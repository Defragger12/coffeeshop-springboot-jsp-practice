package com.scand.coffeeshopboot.repository;

import com.scand.coffeeshopboot.domain.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoffeeRepository extends JpaRepository<Coffee, Long> {

}
