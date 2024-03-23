package com.example.springdatajpahibernatemapping.Controller;

import com.example.springdatajpahibernatemapping.Exception.ResourceNotFoundException;
import com.example.springdatajpahibernatemapping.Model.Tutorials;
import com.example.springdatajpahibernatemapping.repository.TutorialDetailsRepository;
import com.example.springdatajpahibernatemapping.repository.TutorialsRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@CrossOrigin(origins="http://localhost:8097")
@RestController
@RequestMapping("/api")
public class TutorialsController {

    @Autowired
    private TutorialsRepository tutorialsRepository;

    @Autowired
    private TutorialDetailsRepository tutorialDetailsRepository;

    @PostMapping("/tutorials")
    public ResponseEntity<Tutorials> createTutorial(@RequestBody Tutorials tutorials)
    {
        Tutorials t=tutorialsRepository.save(new Tutorials(tutorials.getName(),tutorials.getDescription(),tutorials.getImagepath(), tutorials.getPrice(),tutorials.getQuantity()));
        return new ResponseEntity<>(t, HttpStatus.CREATED);
    }
    @GetMapping("/tutorials")
    public ResponseEntity<?> getAllTutorials(@RequestParam(required=false) String name)
    {
        List<Tutorials> tutorialsList=new ArrayList<>();
        if(name==null)
        {
            tutorialsRepository.findAll().forEach(tutorialsList::add);
        }
        else
        {
            tutorialsRepository.findByName(name).forEach(tutorialsList::add);
        }
        if(tutorialsList.isEmpty())
        {
            return new ResponseEntity<>("Data not found",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(tutorialsList,HttpStatus.OK);
    }

    /*@GetMapping("/tutorials/{id}")
    public ResponseEntity<?> getTutorialsById(@PathVariable("id") long id)
    {

    }*/

    @PutMapping("/tutorials/{id}")
    public ResponseEntity<Tutorials> updateTutorial(@PathVariable("id") long id, @RequestBody Tutorials tutorial) throws ResourceNotFoundException
    {
        Tutorials t1=tutorialsRepository.findById(id).
                orElseThrow(()-> new ResourceNotFoundException("Tutorial Id "+id+"NotFound!"));

        t1.setDescription((tutorial.getDescription()));
        t1.setName(tutorial.getName());

        return new ResponseEntity<>(tutorialsRepository.save(t1),HttpStatus.OK);
    }

    @DeleteMapping("/tutorials/{id}")
    public  ResponseEntity<?> deleteTutorial(@PathVariable("id") long id)
    {
        if(tutorialDetailsRepository.existsById(id))
        {
            tutorialDetailsRepository.deleteById(id);
        }
        tutorialsRepository.deleteById(id);
        return new ResponseEntity<>("Deleted successfully",HttpStatus.OK);
    }

    @DeleteMapping("tutorials")
    public ResponseEntity<Tutorials> deleteAllTutorial()
    {
        tutorialsRepository.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

   /* @GetMapping("/tutorials/published")
    public ResponseEntity<?> findByPublishedTutorials()
    {
        List<Tutorials> tutorials=tutorialsRepository.findByPublished(true);
        if(tutorials.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(tutorials,HttpStatus.OK);
    }

    @GetMapping("/tutorials/published/{flag}")
    public ResponseEntity<List<Tutorials>> findByPublished(@PathVariable("flag")boolean flag)
    {
        List<Tutorials> tutorials=tutorialsRepository.findByPublished(flag);
        if(tutorials.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tutorials,HttpStatus.OK);
    }*/

}
