package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private  static ObjectMapper mapper=new ObjectMapper();
    public static void main(String[] args){

        mapper.registerModule(new JavaTimeModule());
        var angajati = CitesteAngajati();
        //AfisareCuReferinte(angajati);
        //AfisareSalariu(angajati);
      //List<Angajat> sefi = AfisareSef(angajati);
      //sefi.stream().forEach(System.out::println);
        //AfisareNeSef(angajati).forEach(System.out::println);
        //Majuscule(angajati).forEach(System.out::println);
        //Salarii(angajati).forEach(System.out::println);
       // PrimulAngajat(angajati);
            //Statistics(angajati);
        //Ion(angajati);
        //System.out.println(PersoaneAngajateAnulTrecut(angajati));
    }
    public static void Statistics(List<Angajat> angajati)
    {
        var s = angajati.stream().collect(Collectors.summarizingDouble(Angajat::getSalariu));
        System.out.println("MINIM: " + s.getMin());
        System.out.println("MAXIM: " + s.getMax());
        System.out.println("MEDIU: " + s.getAverage());
    }
    public static int PersoaneAngajateAnulTrecut(List<Angajat> angajati)
    {
        return (int) angajati.stream().filter((a) -> a.getDataAngajare().getYear() == LocalDate.now().getYear()-1).count();
    }
    public static void Ion(List<Angajat> angajati)
    {
        angajati.stream().filter((a) -> a.getNume().equalsIgnoreCase("Ion")).findAny().ifPresentOrElse(x -> System.out.println(x), () -> System.out.println("Nu exista niciun Ion"));
    }
    public static void PrimulAngajat(List<Angajat> angajati)
    {

        angajati.stream().sorted(Comparator.comparing(Angajat::getDataAngajare)).findFirst().ifPresentOrElse(x -> System.out.println(x), () -> System.out.println("Nema"));
    }
    public static List<Double> Salarii(List<Angajat> angajati) {


        return angajati.stream().map(Angajat::getSalariu).filter((a) -> a < 3000).collect(Collectors.toList());
    }
    public static List<String> Majuscule(List<Angajat> angajati) {


        return angajati.stream().map(Angajat::getNume).map(String::toUpperCase).collect(Collectors.toList());
    }
    public static List<Angajat> AfisareNeSef(List<Angajat> angajati) {


        return angajati.stream().filter((a) -> !a.getPost().equalsIgnoreCase("sef") || !a.getPost().equalsIgnoreCase("director")).sorted(Comparator.comparing(Angajat::getSalariu).reversed()).collect(Collectors.toList());
    }
    public static List<Angajat> AfisareSef(List<Angajat> angajati)
    {


        return angajati.stream().filter((a) -> (a.getPost().equalsIgnoreCase("sef") || a.getPost().equalsIgnoreCase("director") && a.getDataAngajare().getMonthValue() == 4) && a.getDataAngajare().getYear() == LocalDate.now().getYear() - 1).collect(Collectors.toList());
    }
    public static void AfisareSalariu(List<Angajat> angajati)
    {
        angajati.stream().filter((a) -> a.getSalariu() > 2500).forEach(System.out::println);
    }
    public static void AfisareCuReferinte(List<Angajat> angajati)
    {
        angajati.stream().map(Angajat::toString).forEach(System.out::println);
    }
    public static List<Angajat> CitesteAngajati()
    {
        List<Angajat> angajati = new ArrayList<>();
        try {
         angajati = Arrays.asList(mapper.readValue(new File("D:\\lucru_java_intellij\\angajati\\src\\main\\resources\\angajati.json"),Angajat[].class));
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return angajati;
    }
}