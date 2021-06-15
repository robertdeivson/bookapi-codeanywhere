package br.com.springboot.bookapi.controller;

import br.com.springboot.bookapi.dto.request.BookDTO;
import br.com.springboot.bookapi.dto.response.MessageResponseDTO;
import br.com.springboot.bookapi.exception.BookNotFoundException;
import br.com.springboot.bookapi.services.BookService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BookController {

    private BookService bookService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createBook(@RequestBody @Valid BookDTO bookDTO){
        return bookService.createBook(bookDTO);
    }

    @GetMapping
    public List<BookDTO> listAll(){
        return bookService.listAll();
    }

    @GetMapping("/{id}")
    public BookDTO bookById(@PathVariable Long id) throws BookNotFoundException {
        return bookService.findById(id);
    }


    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody BookDTO bookDTO) throws BookNotFoundException {
        return bookService.updateById(id, bookDTO);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteId(@PathVariable Long id) throws BookNotFoundException {
        bookService.deleteId(id);
    }

}
