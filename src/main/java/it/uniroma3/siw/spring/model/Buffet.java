package it.uniroma3.siw.spring.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor
public class Buffet {

    /* ----------------------------------------------------------------*/
    /* --------------------- variabili --------------------------------*/
    /* ----------------------------------------------------------------*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String descrizione;

    //foto del buffet
    @Column(nullable = true, length = 64)
    private String photo;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Chef chef;

    @OneToMany(mappedBy = "buffet", cascade = {CascadeType.ALL})
    private List<Piatto> piatti;

    @Transient
    public String getImagePath(){
        if(this.getPhoto() == null || this.getId() == null){
            return null;
        }
        return "/"+"buffet-photo"+"/"+this.id+"/"+this.photo;
    }

}
