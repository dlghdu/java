package org.example.tobi.orderservice.book;

public record Book(
        String isbn,
        String title,
        String author,
        Double price
) {
}