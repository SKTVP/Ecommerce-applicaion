package com.atempt2.ecommerce.repository;

import com.atempt2.ecommerce.model.User;

import com.atempt2.ecommerce.model.watchList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface watchListRepository extends JpaRepository <watchList,Long>{

    List<watchList> findAllByUserOrderByDateDesc(User user);

}
