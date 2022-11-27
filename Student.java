package ro.mta.ip.TemaJava;

public class Student implements Human, Comparable<Human> {
    private String nume;
    private String prenume;
    private String acronimFacultate;
    private Integer varsta;
    private Integer anStudiu;

    public Student(String nume, String prenume, String acronimFacultate,
                   Integer varsta, Integer anStudiu) {
        this.nume = nume;
        this.prenume = prenume;
        this.acronimFacultate = acronimFacultate;
        this.varsta = varsta;
        this.anStudiu = anStudiu;
    }

    public Student(String mesaj){
        String[] caracteristici = mesaj.split(" ");

        nume = caracteristici[1];
        prenume = caracteristici[2];
        acronimFacultate = caracteristici[3];
        varsta = Integer.parseInt(caracteristici[4]);
        anStudiu = Integer.parseInt(caracteristici[5]);
    }

    public Integer getVarsta() {
        return varsta;
    }

    public void setVarsta(Integer varsta) {
        this.varsta = varsta;
    }

    @Override
    public void greeting() {
        System.out.println("Student " + nume +" greeting");
    }

    @Override
    public void doWork() {
        System.out.println("Student " + nume + " working");
    }

    @Override
    public String toString() {
        return "Sd. " + nume + " " + prenume +
                ", Anul " + anStudiu +
                ", Fac. " + acronimFacultate +
                ", Varsta " + varsta;
    }

    @Override
    public int compareTo(Human o) {
        return varsta.compareTo(o.getVarsta());
    }
}
