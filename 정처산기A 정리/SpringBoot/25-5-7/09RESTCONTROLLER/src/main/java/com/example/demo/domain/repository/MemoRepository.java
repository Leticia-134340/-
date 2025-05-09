package com.example.demo.domain.repository;

import com.example.demo.domain.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemoRepository<integer> extends JpaRepository<Memo,integer> {

}
