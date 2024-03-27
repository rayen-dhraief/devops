package com.esprit.projet.controller;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.esprit.projet.service.IUniversiteService;
import com.esprit.projet.entity.Universite;

import java.util.List;
@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/universite")
public class UniversiteController {

    private IUniversiteService universiteService;

    @GetMapping("/retrieve-all-universites")
    public List<Universite> getUniversites() {
        return universiteService.retrieveAllUniversites();
    }

    @GetMapping("/retrieve-universite/{universite-id}")
    public Universite retrieveUniversite(@PathVariable("universite-id") Long universiteId) {
        return universiteService.retrieveUniversites(universiteId);
    }

    @PostMapping("/add-universite")
    public Universite addUniversite(@RequestBody Universite e) {
        return universiteService.addUniversites(e);
    }

    @DeleteMapping("/remove-universite/{universite-id}")
    public void removeUniversite(@PathVariable("universite-id") Long universiteId) {
        universiteService.removeUniversites(universiteId);
    }

    @PutMapping("/update-universite")
    public Universite updateUniversite(@RequestBody Universite e) {
        return universiteService.updateUniversites(e);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Universite>> searchUniversites(@RequestParam("query") String query){
        return ResponseEntity.ok(universiteService.searchUniversites(query));
    }

}
