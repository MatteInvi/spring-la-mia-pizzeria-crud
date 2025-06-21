package org.lessons.java.spring.spring_la_mia_pizzeria_crud.model;






import java.math.BigDecimal;
import java.text.DecimalFormat;

import org.springframework.core.convert.converter.ConverterFactory;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NegativeOrZero;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
@Table(name="pizze")
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    

    @NotBlank(message = "Il nome non può essere vuoto")
    private String nome;

    @Lob
    @NotBlank(message = "La descrizione non può essere vuota")
    private String descrizione;
    
    @Lob
    private String urlFoto;
    
    @NotNull (message="Il prezzo non può essere vuoto")
    @Positive(message = "Il prezzo non può essere inferiore a 1")
    private BigDecimal prezzo;


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

    public BigDecimal getPrezzo() {
       return this.prezzo;
    }

    public void setPrezzo(BigDecimal prezzo) {

        this.prezzo =  prezzo;
    }


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
