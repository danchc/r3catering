package it.uniroma3.siw.spring.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Questa entità modella le informazioni di una persona reale, quindi specifica tutte le informazioni
 * necessarie per indicare una persona.
 */
@Entity
@Table(name = "utente")
@Getter @Setter @NoArgsConstructor
public class User {

    /* ----------------------------------------------------------------*/
    /* --------------------- variabili --------------------------------*/
    /* ----------------------------------------------------------------*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nome;

    @NotNull
    private String cognome;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String telefono;

    @NotNull
    private String indirizzo;

    @NotNull
    private String citta;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataNascita;

    @OneToMany(mappedBy = "utente", cascade = {CascadeType.ALL})
    private List<Buffet> preferiti;


    public void addPreferito(Buffet buffet) {
        if(this.getPreferiti().size() == 0){
            this.preferiti = new ArrayList<>();
            preferiti.add(buffet);
        }
        this.preferiti.add(buffet);
    }
}
