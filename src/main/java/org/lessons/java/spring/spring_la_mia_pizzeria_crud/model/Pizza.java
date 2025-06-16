package org.lessons.java.spring.spring_la_mia_pizzeria_crud.model;



import java.text.NumberFormat;
import java.util.Locale;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="pizze")
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String nome;
    private String descrizione;
    private String urlFoto;
    private Float prezzo;


    public String getNome() {
     
        return this.nome.substring(0, 1).toUpperCase() + this.nome.substring(1).toLowerCase();
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

    public String getPrezzo() {
        NumberFormat prezzoFormattato = NumberFormat.getCurrencyInstance(Locale.ITALY);
        return prezzoFormattato.format(this.prezzo);
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
