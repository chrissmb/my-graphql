package com.example.mygraphql.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.mygraphql.entity.Author;
import com.example.mygraphql.entity.Book;
import com.example.mygraphql.entity.BookInput;
import com.example.mygraphql.exception.BusinessException;
import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.GraphQLException;
import graphql.language.SourceLocation;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;
import java.util.List;

@Component
public class BookResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

    public Book getBook(Long id) {
        return instanceBook(id);
    }

    public List<Book> getBooks() {
        return Arrays.asList(instanceBook(1L), instanceBook(2L), instanceBook(3L));
    }

    private Book instanceBook(Long id) {
        return Book.builder()
                .id(id)
                .title("Código da Vinci")
                .year(2000)
                .author(Author.builder()
                        .id(1L)
                        .name("Dan Brown")
                        .build())
                .build();
    }

    public Book saveBook(BookInput bookInput) {
        if (bookInput.getTitle().isBlank()) {
            //throw new MyGraphQLError("Title must be filled.", ErrorType.ValidationError);
            throw new BusinessException("Title must be filled.");
        }
        return Book.builder()
                .id(99L)
                .title(bookInput.getTitle())
                .year(bookInput.getYear())
                .build();
    }
}
