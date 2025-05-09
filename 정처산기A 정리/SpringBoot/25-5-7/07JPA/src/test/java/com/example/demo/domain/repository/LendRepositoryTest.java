package com.example.demo.domain.repository;

import com.example.demo.domain.entity.Lend;
import com.example.demo.domain.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class LendRepositoryTest {

    @Autowired
    private LendRepository lendRepository;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;

//    @Test
//    public void t1() throws Exception{
//
//        //저장되어 있는 도서코드를 가지는 Book
//        Book book = bookRepository.findById(1111L).get();
//
//        //저장되어 있는 유저정보를 가지는 User
//        User user = userRepository.findById("user").get();
//
//        Lend lend = new Lend();
//        lend.setBook(book);
//        lend.setUser(user);
//        lendRepository.save(lend);
//    }

//    @Test
//    public void t4() throws Exception{
//        List<Lend> list = lendRepository.findLendsByUser("user2");
//        list.stream().forEach(System.out::println);
//    }

    @Test
//    @Transactional(rollbackFor = Exception.class)
    public void t5() throws Exception{
        System.out.println("--------------FETCH 방식 테스트 시작-----------------");
        Optional<Lend> lendOptional = lendRepository.findById(2222L);
        System.out.println("--------------findById(2L)----------------");
        Lend lend = lendOptional.get();
        System.out.println("--------------getUser()----------------");
        User user = lend.getUser(); //LAZY Option 사용 시 해당 시점에서 쿼리 실행

        System.out.println("--------------FETCH 방식 테스트 종료------------------");

    }

}