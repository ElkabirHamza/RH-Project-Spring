package com.rh.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Stagiaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idStagiaire;
    private String nom;
    private String prenom;
    private String departement;
    private String sujet;
    private String etatStage;

    public int getIdS() {
        return idStagiaire;
    }
    public void setIdS(int idS) {
        this.idStagiaire = idS;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getDepartement() {
        return departement;
    }
    public void setDepartement(String dep) {
        this.departement = dep;
    }


    public String getSujet() {
        return sujet;
    }
    public void setSujet(String s) {
        this.sujet = s;
    }
    public String getEtatStage() {
        return etatStage;
    }
    public void setEtatStage(String ets) {
        this.etatStage = ets;
    }
}
