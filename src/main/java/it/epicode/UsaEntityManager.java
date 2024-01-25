package it.epicode;

import it.epicode.entities.Impiegato;
import it.epicode.entities.Persona;
import it.epicode.entities.Studente;
import jakarta.persistence.*;

import java.util.List;

public class UsaEntityManager {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ereditarieta_jpa");
        EntityManager em = emf.createEntityManager();

//        Persona p = new Persona();
//        p.setNome("Roberto");
//        p.setCognome("Galdi");

//        Studente s = new Studente();
//        s.setNome("Francesco");
//        s.setCognome("Roma");
//        s.setMatricola("4524232");

        Studente s1 = new Studente();
        s1.setNome("Francesco");
        s1.setCognome("Salerno");
        s1.setMatricola("6546546");

        Studente s2 = new Studente();
        s2.setNome("Mario");
        s2.setCognome("Roma");
        s2.setMatricola("3452342");

//        Impiegato i = new Impiegato();
//        i.setNome("Francesco");
//        i.setCognome("Sada");
//        i.setUfficio("12");
  //codice per inserire una persona, uno studente e un impiegato nel database
 /*       try {
            EntityTransaction et = em.getTransaction();
            et.begin();

           // em.persist(p);
           // em.persist(s);
           // em.persist(i);

            em.persist(s1);
            em.persist(s2);
            et.commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            //em.close();
            //emf.close();
        }
*/
// codice per recuperare uno studente dal db e stamparne le caratteristiche
       // Studente s2 = em.find(Studente.class, 2);

        //System.out.println(s2);

        //Dynamic query per estrarre uno studente con uno specifico id da passare come parametro
        //Query query = em.createQuery("select s from Studente s where s.id=:id");
        //query.setParameter("id", 2);

        //estrazione di un solo studente. Viene estratto come Object per cui va castato
        //Studente s2 =(Studente)query.getSingleResult();




        //utilizzo dell'update e delete con una query dinamica
        EntityTransaction et = em.getTransaction();
        et.begin();

            //update
//        Query update = em.createQuery("update Studente s set s.universita=:universita where s.id=:id");
//        update.setParameter("universita", "Bicocca");
//        update.setParameter("id", 52);
//        update.executeUpdate();

        //delete
        Query delete = em.createQuery("delete from Studente s where s.id=:id");
        delete.setParameter("id", 2);
        delete.executeUpdate();

        et.commit();

        //richiamo di una NamedQuery parametrizzata
        Query query = em.createNamedQuery("getStudentiByName");
        query.setParameter("nome", "Francesco");


        List<Studente> studenti  =query.getResultList();
        studenti.stream().forEach(studente -> System.out.println(studente));

        //System.out.println(s2);

        //query di esempio nel caso in cui bisogna lavorare su collezioni all'interno di entità
        //questa query verifica se una collezione ha più di 2 elementi all'interno
       // Query query2 = em.createQuery("select s from Studente s where size(s.indirizzi)>=2");

        //questa query verifica se una determinata stringa si trova all'interno di una collezione
        //Query query3 = em.createQuery("select s from Studente s where 'via Roma' member of s.indirizzi");

        //questa query è come la precedente ma ha il parametro per la stringa da cercare
        //Query query4 = em.createQuery("select s from Studente s where :via member of s.indirizzi");

    }
}
