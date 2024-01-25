package it.epicode.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "studente")
@NamedQuery(name = "getStudentiByName", query = "select s from Studente s where s.nome = :nome")
public class Studente extends Persona{

    private String matricola;
    private String universita;



    public Studente() {
    }

    public Studente(int id, String nome, String cognome, String matricola, String universita) {
        super(id, nome, cognome);
        this.matricola = matricola;
        this.universita = universita;
    }

    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    public String getUniversita() {
        return universita;
    }

    public void setUniversita(String universita) {
        this.universita = universita;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", matricola='" + matricola + '\'' +
                ", universita='" + universita + '\'';
    }
}
