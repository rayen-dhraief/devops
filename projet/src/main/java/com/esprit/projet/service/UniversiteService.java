package com.esprit.projet.service;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.esprit.projet.entity.Universite;
import com.esprit.projet.repository.UniversiteRepository;

import java.util.List;
@AllArgsConstructor
@Service
public class UniversiteService implements IUniversiteService{

    UniversiteRepository universiteRepository;
    @Override
    public List<Universite> retrieveAllUniversites() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite addUniversites(Universite e) {
        return universiteRepository.save(e);
    }

    @Override
    public Universite updateUniversites(Universite e) {
        return universiteRepository.save(e);
    }

    @Override
    public Universite retrieveUniversites(Long idUniversite) {
        return universiteRepository.findById(idUniversite).orElse(null);
    }


    @Override
    public void removeUniversites(Long idUniversite) {
        universiteRepository.deleteById(idUniversite);

    }

    @Override
    public List<Universite> searchUniversites(String query) {
        return universiteRepository.searchUniversites(query);
    }

}
