package it.epicode.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "impiegato")
public class Impiegato extends Persona{
    private String azienda;
    private String ufficio;

    public Impiegato() {
    }

    public Impiegato(int id, String nome, String cognome, String azienda, String ufficio) {
        super(id, nome, cognome);
        this.azienda = azienda;
        this.ufficio = ufficio;
    }

    public String getAzienda() {
        return azienda;
    }

    public void setAzienda(String azienda) {
        this.azienda = azienda;
    }

    public String getUfficio() {
        return ufficio;
    }

    public void setUfficio(String ufficio) {
        this.ufficio = ufficio;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", azienda='" + azienda + '\'' +
                ", ufficio='" + ufficio + '\'';
    }
}
