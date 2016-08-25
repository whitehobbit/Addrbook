package com.whitehobbit.Addrbook.repository;

import com.whitehobbit.Addrbook.domain.Addrbook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by whitehobbit on 2016. 8. 25..
 */
@Repository
public interface AddrbookRepository extends JpaRepository<Addrbook, Integer> {
    @Query("SELECT x FROM Addrbook x ORDER BY x.ab_id")
    Page<Addrbook> findAllOrderByName(Pageable pageable);
}
