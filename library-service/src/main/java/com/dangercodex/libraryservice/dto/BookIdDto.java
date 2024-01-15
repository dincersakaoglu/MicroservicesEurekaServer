package com.dangercodex.libraryservice.dto;

public class BookIdDto {

    private final String bookId;
    private final String isbn;

    public BookIdDto(String bookId, String isbn) {
        this.bookId = bookId;
        this.isbn = isbn;
    }

    public String getBookId() {
        return bookId;
    }

    public String getIsbn() {
        return isbn;
    }

    public static BookIdDto convert(String id, String isbn) {
        return new BookIdDto(id, isbn);
    }

    @Override
    public String toString() {
        return "BookIdDto{" +
                "bookId='" + bookId + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}
