package com.esprit.projet.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.esprit.projet.entity.Etudiant;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant,Long>{

}
