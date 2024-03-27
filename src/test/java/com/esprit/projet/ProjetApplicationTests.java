package com.esprit.projet;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.esprit.projet.entity.Universite;
import com.esprit.projet.repository.UniversiteRepository;
import com.esprit.projet.service.UniversiteService;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class ProjetApplicationTests {

    @Autowired
    private UniversiteService universiteService;

    @MockBean
    private UniversiteRepository universiteRepository;

    @Test
    public void testSearchUniversites() {
        // Données simulées
        List<Universite> universites = new ArrayList<>();
        universites.add(new Universite(1L, "Universite1", "Adresse1"));
        universites.add(new Universite(2L, "Universite2", "Adresse2"));

        // Simuler le comportement du repository
        when(universiteRepository.searchUniversites("test")).thenReturn(universites);

        // Appeler le service
        List<Universite> result = universiteService.searchUniversites("test");

        // Vérifier le résultat
        assertEquals(2, result.size());
        assertEquals("Universite1", result.get(0).getNomUniversite());
        assertEquals("Adresse1", result.get(0).getAdresse());
        assertEquals("Universite2", result.get(1).getNomUniversite());
        assertEquals("Adresse2", result.get(1).getAdresse());
    }

}
