package com.dangercodex.libraryservice.service;

import com.dangercodex.libraryservice.client.BookServiceClient;
import com.dangercodex.libraryservice.dto.AddBookRequest;
import com.dangercodex.libraryservice.dto.LibraryDto;
import com.dangercodex.libraryservice.exception.LibraryNotFoundException;
import com.dangercodex.libraryservice.model.Library;
import com.dangercodex.libraryservice.repository.LibraryRepository;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class LibraryService {
    private final LibraryRepository libraryRepository;
    private final BookServiceClient bookServiceClient;

    public LibraryService(LibraryRepository libraryRepository,
                          BookServiceClient bookServiceClient) {
        this.libraryRepository = libraryRepository;
        this.bookServiceClient = bookServiceClient;
    }

    public LibraryDto getAllBooksInLibraryById(String id) {
        Library library = libraryRepository.findById(id)
                .orElseThrow(() -> new LibraryNotFoundException("Library could not found by id: " + id));

        LibraryDto libraryDto = new LibraryDto(library.getId(),
                library.getUserBook()
                        .stream()
                        .map(book -> bookServiceClient.getBookById(book).getBody())
                        .collect(Collectors.toList()));
        return libraryDto;
    }

    public LibraryDto createLibrary() {
        Library newLibrary = libraryRepository.save(new Library());
        return new LibraryDto(newLibrary.getId(),null);
    }

    public void addBookToLibrary(AddBookRequest request) {
        String BookId = bookServiceClient.getBookByIsbn(request.getIsbn()).getBody().getBookId();
        Library library = libraryRepository.findById(request.getId())
                .orElseThrow(() -> new LibraryNotFoundException("Library could not found by id: " + request.getId()));
        library.getUserBook().add(BookId);
        libraryRepository.save(library);
    }
}
