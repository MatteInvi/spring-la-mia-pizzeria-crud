package org.lessons.java.spring.spring_la_mia_pizzeria_crud.model;






import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="pizze")
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    

    @NotBlank(message = "Il nome non può essere vuoto")
    private String nome;

    @NotBlank(message = "La descrizione non può essere vuota")
    private String descrizione;
    
    @Lob
    private String urlFoto;
    
    @NotNull
    @Min(value = 1, message = "Il prezzo non può essere inferiore a 1")
    private Float prezzo;


    public String getNome() {
     
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return  this.descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getUrlFoto() {
        return this.urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public Float getPrezzo() {
       return this.prezzo;
    }

    public void setPrezzo(Float prezzo) {
 
        this.prezzo = prezzo;
    }


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
