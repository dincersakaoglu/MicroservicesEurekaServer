package com.dangercodex.libraryservice.dto;

import java.util.List;

public class LibraryDto {

    private final String id;
    private final List<BookDto> userBookList;

    public LibraryDto(String id, List<BookDto> userBookList) {
        this.id = id;
        this.userBookList = userBookList;
    }

    public String getId() {
        return id;
    }

    public List<BookDto> getUserBookList() {
        return userBookList;
    }

    @Override
    public String toString() {
        return "LibraryDto{" +
                "id='" + id + '\'' +
                ", userBookList=" + userBookList +
                '}';
    }
}