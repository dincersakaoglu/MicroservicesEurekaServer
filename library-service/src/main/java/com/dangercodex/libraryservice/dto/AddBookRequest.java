package com.dangercodex.libraryservice.dto;

public class AddBookRequest {

    private final String id;
    private final String isbn;

    public AddBookRequest(String id, String isbn) {
        this.id = id;
        this.isbn = isbn;
    }

    public String getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return "AddBookRequest{" +
                "id='" + id + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}