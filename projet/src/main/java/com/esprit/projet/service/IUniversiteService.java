package com.esprit.projet.service;

import com.esprit.projet.entity.Universite;

import java.util.List;
public interface IUniversiteService {
    List<Universite> retrieveAllUniversites();

    Universite addUniversites(Universite e);

    Universite updateUniversites(Universite e);

    Universite retrieveUniversites(Long idUniversite);

    void removeUniversites(Long idUniversite);
    List<Universite> searchUniversites(String query);

}
