package com.esprit.projet.controller;
import com.esprit.projet.repository.EtudiantRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.esprit.projet.service.IEtudiantService;
import com.esprit.projet.entity.Etudiant;
import com.esprit.projet.dto.APIResponse;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import java.io.ByteArrayInputStream;
@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/etudiant")
public class EtudiantController {

    private IEtudiantService etudiantsevice;
    EtudiantRepository etudiantRepository;

    @GetMapping("/retrieve-all-etudiants")
    public List<Etudiant> getEtudiants() {
        return etudiantsevice.retrieveAllEtudiants();
    }
    @GetMapping("/retrieve-etudiant/{etudiant-id}")
    public Etudiant retrieveEtudiant(@PathVariable("etudiant-id") Long etudiantId) { return etudiantsevice.retrieveEtudiant(etudiantId);
    }
    @GetMapping("/pagination/{offset}/{pageSize}")
    public APIResponse<Page<Etudiant>> findEtudiantsWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
        Page<Etudiant> productsWithPagination = etudiantsevice.findEtudiantsWithPagination(offset, pageSize);
        return new APIResponse<>(productsWithPagination.getSize(), productsWithPagination);
    }
    @PostMapping("/add-etudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant e) {
        return etudiantsevice.addEtudiant(e);
    }
    @DeleteMapping("/remove-etudiant/{etudiant-id}")
    public void removeEtudiant(@PathVariable("etudiant-id") Long etudiantId) { etudiantsevice.removeEtudiant(etudiantId);
    }
    @PutMapping("/update-etudiant")
    public Etudiant updateEtudiant(@RequestBody Etudiant e) {

        return etudiantsevice.updateEtudiant(e);
    }

    @GetMapping(value = "/openpdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> etudiantReport()  {
        List<Etudiant> etudiants =  etudiantRepository.findAll();

        ByteArrayInputStream bis = etudiantsevice.etudiantPDFReport(etudiants);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=etudiants.pdf");

        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }



}
