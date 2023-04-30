package hr.java.production.sort;

import hr.java.production.model.Item;

import java.math.BigDecimal;
import java.util.Comparator;

public class VolumenSorter implements Comparator<Item> {

    @Override
    public int compare(Item o1, Item o2) {
        BigDecimal volumen1;
        BigDecimal volumen2;

          volumen1 = o1.getLenght().multiply(o1.getHighth()).multiply(o1.getWidth());
          volumen2 = o2.getLenght().multiply(o2.getHighth()).multiply(o2.getWidth());

          return volumen1.compareTo(volumen2);




    }


}
