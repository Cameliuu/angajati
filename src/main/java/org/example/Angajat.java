package org.example;

import java.time.LocalDate;

public class Angajat {
    private String nume;
    private String post;
    private LocalDate dataAngajare;
    private double salariu;

    public Angajat(){}
    public Angajat(String n, String p, LocalDate d, double s)
    {
        this.nume = n;
        this.post = p;
        this.dataAngajare = d;
        this.salariu = s;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public LocalDate getDataAngajare() {
        return dataAngajare;
    }

    public void setDataAngajare(LocalDate dataAngajare) {
        this.dataAngajare = dataAngajare;
    }

    public double getSalariu() {
        return salariu;
    }

    public void setSalariu(double salariu) {
        this.salariu = salariu;
    }

    @java.lang.Override
    public java.lang.String toString() {
       return "Angajat{" +
                "nume='" + nume + '\'' +
                ", post=" + post +
                ", dataAngajare=" + dataAngajare +
                ", salariu=" + salariu +
                '}';

    }
}
