package com.esprit.projet.service;

import com.esprit.projet.entity.Etudiant;
import org.springframework.data.domain.Page;

import java.io.ByteArrayInputStream;
import java.util.*;
public interface IEtudiantService {

    List<Etudiant> retrieveAllEtudiants();

    Etudiant addEtudiant(Etudiant e);

    Etudiant updateEtudiant(Etudiant e);

    Etudiant retrieveEtudiant(Long idEtudiant);

    void removeEtudiant(Long idEtudiant);

    Page<Etudiant> findEtudiantsWithPagination(int offset, int pageSize);


     ByteArrayInputStream etudiantPDFReport(List<Etudiant> etudiants);



}
