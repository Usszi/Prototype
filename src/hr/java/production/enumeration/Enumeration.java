package hr.java.production.enumeration;

public enum Enumeration {

    prvi("ZAGREB","10000"),
    drugi("ZADAR","23000"),
    treci("KNIN","70000");
    private String nazivGrada;
    private String postanskiBroj;

    Enumeration(String nazivGrada, String postanskiBroj) {
        this.nazivGrada = nazivGrada;
        this.postanskiBroj = postanskiBroj;
    }

    public String getNazivGrada() {
        return nazivGrada;
    }

    public String getPostanskiBroj() {
        return postanskiBroj;
    }


}
