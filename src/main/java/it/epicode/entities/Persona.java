package it.epicode.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "persona")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //strategia per avere una unica tabella da tutte le entità padre e figli
//@Inheritance(strategy = InheritanceType.JOINED)  // strategia per avere tabelle distinte per ogni entità padre e figlio. L'entità figlio avrà solo i suoi attributi specifici
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nome;
    private String cognome;

    public Persona() {
    }

    public Persona(int id, String nome, String cognome) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'';
    }
}
