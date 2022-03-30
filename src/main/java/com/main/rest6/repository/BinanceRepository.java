package com.main.rest6.repository;

import com.main.rest6.model.BinanceAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BinanceRepository extends JpaRepository<BinanceAccount, Integer> {

    List<BinanceAccount> findByUsersId(long user_id);
}
