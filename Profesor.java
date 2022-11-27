package ro.mta.ip.TemaJava;

import java.util.ArrayList;
import java.util.Collections;

public class Profesor implements Human, Comparable<Human>{
    private String nume;
    private String prenume;
    private String acronimFacultate;
    private Integer varsta;
    private String materie;

    public Profesor(String nume, String prenume, String acronimFacultate, Integer varsta, String materie) {
        this.nume = nume;
        this.prenume = prenume;
        this.acronimFacultate = acronimFacultate;
        this.varsta = varsta;
        this.materie = materie;
    }

    public Profesor(String mesaj) {
        String[] caracteristici = mesaj.split(" ");

        nume = caracteristici[1];
        prenume = caracteristici[2];
        acronimFacultate = caracteristici[3];
        varsta = Integer.parseInt(caracteristici[4]);
        materie = caracteristici[5];
    }

    public Integer getVarsta() {
        return varsta;
    }

    public void setVarsta(Integer varsta) {
        this.varsta = varsta;
    }

    @Override
    public void greeting() {
        System.out.println("Profesor " + nume +" greeting");
    }

    @Override
    public void doWork() {
        System.out.println("Profesor " + nume + " working");
    }

    @Override
    public String toString() {
        return "Prof. " + nume + " " + prenume +
                ", Fac. " + acronimFacultate +
                ", Varsta " + varsta +
                ", Materie predata - " + materie;
    }

    @Override
    public int compareTo(Human o) {
        return varsta.compareTo(o.getVarsta());
    }

    public static void main(String[] args) {
        Student student1 = new Student("Student Alin Ioan FEAA 19 1");
        Student student2 = new Student("Student Oprea Denisa ATM 22 4");
        Student student3 = new Student("Student Stan Denis ASE 20 2");
        Student student4 = new Student("Student Iulian Mihai ASE 21 3");

        Profesor profesor1 = new Profesor("Profesor Gheorghe Razvan ASE 55 Economie");
        Profesor profesor2 = new Profesor("Profesor Tol Adelin FEAA 35 Analiza");

        student1.greeting();
        profesor2.greeting();
        student1.doWork();
        profesor1.doWork();

        ArrayList<Human> humanList = new ArrayList<>();

        humanList.add(student1);
        humanList.add(student2);
        humanList.add(student3);
        humanList.add(student4);
        humanList.add(profesor1);
        humanList.add(profesor2);

        Collections.sort(humanList);

        System.out.println("\nLista ordonata dupa varsta:");
        for(int i=0;i<humanList.size(); i++)
        {
            System.out.println(humanList.get(i).toString());
        }
    }
}
