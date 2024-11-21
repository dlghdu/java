package org.example.tobi.catalogservice.demo;

import lombok.RequiredArgsConstructor;
import org.example.tobi.catalogservice.domain.Book;
import org.example.tobi.catalogservice.domain.BookRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("testdata")
@RequiredArgsConstructor
public class BookDataLoader {

//    private final BookRepository bookRepository;
//
//    @EventListener(ApplicationReadyEvent.class)
//    public void loadBookTestData() {
//        var book = new Book("1234567891", "Northern Lights", "Lyra SilverStar", 9.90);
//
//        var book2 = new Book("1234567892", "Polar Journey", "Iorek Polarson", 12.90);
//    }

    private final BookRepository bookRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void loadBookTestData() {
        bookRepository.deleteAll();
        Book build = Book.builder()
                .isbn("1234567891")
                .title("test")
                .author("test")
                .price(9.9)
                .build();

        Book build2 = Book.builder()
                .isbn("1234567892")
                .title("test2")
                .author("test2")
                .price(9.2)
                .build();

        bookRepository.saveAll(List.of(build, build2));
    }

}