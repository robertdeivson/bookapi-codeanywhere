package br.com.springboot.bookapi.utils;

import br.com.springboot.bookapi.dto.request.AuthorDTO;
import br.com.springboot.bookapi.entity.Author;

public class AuthorUtils {

    private static final String NAME = "Eckhart Tolle";


    public static AuthorDTO createFakeDTO(){
        return AuthorDTO.builder()
                .name(NAME)
                .build();
    }

    public static Author createFakeEntity(){
        return Author.builder()
                .name(NAME)
                .build();
    }
}
