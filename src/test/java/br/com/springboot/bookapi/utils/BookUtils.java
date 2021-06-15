package br.com.springboot.bookapi.utils;

import br.com.springboot.bookapi.dto.request.BookDTO;
import br.com.springboot.bookapi.entity.Book;

import java.time.LocalDate;
import java.util.Collections;

public class BookUtils {

    private static final String TITLE = "O Poder do Agora";
    private static final String ISBN = "9788575426319";
    private static final String PUBLISHER = "Sextante";
    private static final String LANGUAGE = "Português";
    private static final long BOOK_ID = 1L;
    private static final LocalDate DATE_PUBLISHED = LocalDate.of(2010, 12, 28);

    public static BookDTO createFakeDTO(){
        return BookDTO.builder()
                .title(TITLE)
                .isbn(ISBN)
                .publisher(PUBLISHER)
                .language(LANGUAGE)
                .date_published("28-10-2010")
                .author(AuthorUtils.createFakeDTO())
                .build();
    }

    public static Book createFakeEntity(){
        return Book.builder()
                .id(BOOK_ID)
                .title(TITLE)
                .isbn(ISBN)
                .publisher(PUBLISHER)
                .language(LANGUAGE)
                .date_published(DATE_PUBLISHED)
                .author(AuthorUtils.createFakeEntity())
                .build();
    }

}
