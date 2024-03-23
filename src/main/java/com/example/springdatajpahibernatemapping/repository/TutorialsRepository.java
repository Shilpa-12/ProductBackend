package com.example.springdatajpahibernatemapping.repository;

import com.example.springdatajpahibernatemapping.Model.Tutorials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface TutorialsRepository extends JpaRepository<Tutorials, Long> {

    List<Tutorials> findByPrice(Long price);

    List<Tutorials> findByName(String name);

}
