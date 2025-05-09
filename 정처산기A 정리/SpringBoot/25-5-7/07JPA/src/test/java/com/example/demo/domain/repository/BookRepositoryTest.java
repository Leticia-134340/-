package com.example.demo.domain.repository;

import com.example.demo.domain.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;
    //기본 CRUD TEST
    @Test
    public void t1() throws Exception{
        //INSERT
        Book book =
                Book.builder()
                        .bookCode(1111L)
                        .bookName("DareDemon")
                        .publisher("Seventeen")
                        .isbn("2025-0526")
                        .build();
        bookRepository.save(book);

//        //UPDATE
//        book.setBookName("Burstday");
//        book.setPublisher("세븐틴");
//        bookRepository.save(book);

//        //DELETE
//        bookRepository.deleteById(1111L);


    }

    @Test
    public void t2() throws Exception{

//        Optional<Book> bookOptional = bookRepository.findById(1244L);
//        if(bookOptional.isPresent())
//            System.out.printon(bookOptional.get());

//        List<Book> list = bookRepository.findbyBookName("java");
//        list.stream().forEach(System.out::println);

//        List<Book> list = bookRepository.findByPublisher("한빛");
//        list.stream().forEach(System.out::println);

//        Book book = bookRepository.findByBookNameAndIsbn("java","1113");
//        System.out.println(book);

//        List<Book> list = bookRepository.findByBookNameContains("");
//        list.stream().forEach(System.out::println);



    }

}