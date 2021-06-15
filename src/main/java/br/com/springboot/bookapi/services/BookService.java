package br.com.springboot.bookapi.services;

import br.com.springboot.bookapi.dto.request.BookDTO;
import br.com.springboot.bookapi.dto.response.MessageResponseDTO;
import br.com.springboot.bookapi.entity.Book;
import br.com.springboot.bookapi.exception.BookNotFoundException;
import br.com.springboot.bookapi.mapper.BookMapper;
import br.com.springboot.bookapi.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




import java.util.List;

import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BookService {

    private BookRepository bookRepository;

    private final BookMapper bookMapper = BookMapper.INSTANCE;


    public MessageResponseDTO createBook(BookDTO bookDTO) {
        Book bookToSave = bookMapper.toModel(bookDTO);

        Book savedBook = bookRepository.save(bookToSave);
        return getMessageResponseDTO(savedBook.getId(), "Created book with ID ");

    }

    public List<BookDTO> listAll() {
        List<Book> allBooks = bookRepository.findAll();
        return allBooks.stream().map(bookMapper::toDTO).collect(Collectors.toList());
    }


    public BookDTO findById(Long id) throws BookNotFoundException {
        Book book = verifyIfExists(id);
        return bookMapper.toDTO(book);
    }


    public MessageResponseDTO updateById(Long id, BookDTO bookDTO) throws BookNotFoundException {
        verifyIfExists(id);

        Book bookToUpdate = bookMapper.toModel(bookDTO);

        Book updateBook = bookRepository.save(bookToUpdate);

        return getMessageResponseDTO(updateBook.getId(), "Updated book with ID ");
    }

    public void deleteId(Long id) throws BookNotFoundException {
        Book book = verifyIfExists(id);

        bookRepository.deleteById(id);
    }


    public Book verifyIfExists(Long id) throws BookNotFoundException {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
    }


    private MessageResponseDTO getMessageResponseDTO(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }



}





