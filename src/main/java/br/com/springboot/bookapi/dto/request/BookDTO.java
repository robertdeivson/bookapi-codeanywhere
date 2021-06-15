package br.com.springboot.bookapi.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {

    private Long id;



    private String title;

    @NotEmpty
    private String isbn;

    @NotEmpty
    private String publisher;

    @NotEmpty
    private String language;

    @NotEmpty
    private String date_published;

    private AuthorDTO author;
}
