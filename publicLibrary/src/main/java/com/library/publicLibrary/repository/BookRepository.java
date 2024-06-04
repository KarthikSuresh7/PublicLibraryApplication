package com.library.publicLibrary.repository;

import com.library.publicLibrary.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

    @Query("from Book where id=:bookId")
    Book getBookId(Long bookId);
}
