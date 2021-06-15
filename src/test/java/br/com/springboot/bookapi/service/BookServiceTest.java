package br.com.springboot.bookapi.service;

import br.com.springboot.bookapi.dto.request.BookDTO;
import br.com.springboot.bookapi.dto.response.MessageResponseDTO;
import br.com.springboot.bookapi.entity.Book;
import br.com.springboot.bookapi.repository.BookRepository;
import br.com.springboot.bookapi.services.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static br.com.springboot.bookapi.utils.BookUtils.createFakeDTO;
import static br.com.springboot.bookapi.utils.BookUtils.createFakeEntity;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    void testGivenBookDTOThenReturnSavedMessage(){
        BookDTO bookDTO = createFakeDTO();
        Book expectedSavedBook = createFakeEntity();

        when(bookRepository.save(any(Book.class))).thenReturn(expectedSavedBook);

        MessageResponseDTO expectedSuccessMessage = createExpectedMessageResponse(expectedSavedBook.getId());
        MessageResponseDTO successMessage = bookService.createBook(bookDTO);

        assertEquals(expectedSuccessMessage, successMessage);
    }

    private MessageResponseDTO createExpectedMessageResponse(Long id) {
        return MessageResponseDTO
                .builder()
                .message("Created book with ID " + id)
                .build();
    }
}
