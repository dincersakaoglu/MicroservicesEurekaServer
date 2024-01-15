package com.dangercodex.bookservice.dto;

import com.dangercodex.bookservice.model.Book;

public class BookDto {

    private final BookIdDto id;
    private final String title;
    private final int bookYear;
    private final String author;
    private final String pressName;

    public BookDto(BookIdDto id, String title, int bookYear, String author, String pressName) {
        this.id = id;
        this.title = title;
        this.bookYear = bookYear;
        this.author = author;
        this.pressName = pressName;
    }
    public BookDto(String title, int bookYear, String author, String pressName) {
        this.id = null;  // Assuming you want to set id to null when not provided
        this.title = title;
        this.bookYear = bookYear;
        this.author = author;
        this.pressName = pressName;
    }

    public BookIdDto getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getBookYear() {
        return bookYear;
    }

    public String getAuthor() {
        return author;
    }

    public String getPressName() {
        return pressName;
    }

    public static BookDto convert(Book from) {
        return new BookDto(
                from.getId() != null ? BookIdDto.convert(from.getId(), from.getIsbn()) : null,
                from.getTitle(),
                from.getBookYear(),
                from.getAuthor(),
                from.getPressName()
        );
    }
}
