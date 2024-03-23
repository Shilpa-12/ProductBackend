package com.example.springdatajpahibernatemapping.repository;

import com.example.springdatajpahibernatemapping.Model.TutorialDetails;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorialDetailsRepository extends JpaRepository<TutorialDetails, Long> {

    // if the entire transaction is successful, then all the changes will be
    //committed in the database
    @Transactional
    void deleteById(long id);

    @Transactional
    void deleteByTutorialsId(long tutorialId);
}
