package com.vs.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.vs.dto.BookDto;
import com.vs.entity.Book;

@Mapper(componentModel = "spring")
public interface BookMapper {

	
	Book toEntity(BookDto bookDto);

   
    BookDto toDto(Book book);

  
    @Mapping(target = "bookId", ignore = true)
    void updateBookFromEntity(Book source, @MappingTarget Book target);
}
