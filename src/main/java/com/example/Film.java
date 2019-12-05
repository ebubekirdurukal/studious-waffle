package com.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String isim;
    private int skor;

    public Film() {
        super();
    }

    public Film(String isim, int skor) {
        this.isim = isim;
        this.skor = skor;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public int getSkor() {
        return skor;
    }

    public void setSkor(int skor) {
        this.skor = skor;
    }
}
