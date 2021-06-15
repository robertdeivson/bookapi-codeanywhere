package br.com.springboot.bookapi.mapper;

import br.com.springboot.bookapi.dto.request.BookDTO;
import br.com.springboot.bookapi.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);


    @Mapping(target = "date_published", source= "date_published", dateFormat= "dd-MM-yyyy")
    Book toModel(BookDTO bookDTO);

    BookDTO toDTO(Book book);
}
