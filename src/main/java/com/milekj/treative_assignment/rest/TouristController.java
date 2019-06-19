package com.milekj.treative_assignment.rest;

import com.milekj.treative_assignment.dto.TouristDto;
import com.milekj.treative_assignment.entity.Tourist;
import com.milekj.treative_assignment.exception.ResourceNotFoundException;
import com.milekj.treative_assignment.service.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/tourists")
public class TouristController {
    private TouristService touristService;

    @Autowired
    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }

    @GetMapping("")
    public List<Tourist> getAll() {
        return touristService.getAll();
    }

    @PostMapping("")
    public Tourist create(@RequestBody TouristDto touristDto) {
        return touristService.create(touristDto);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable long id) {
        try {
            touristService.deleteById(id);
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("{id}")
    public void updateById(@PathVariable long id, @RequestBody TouristDto touristDto) {
        try {
            touristService.update(id, touristDto);
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
