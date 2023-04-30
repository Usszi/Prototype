package hr.java.production.genericsi;

import hr.java.production.model.Item;
import hr.java.production.model.Store;
import hr.java.production.model.Technical;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public  class TechicalStore <T extends Technical>  extends Store     {

    List<T> technicalStore = new ArrayList<>();

    public TechicalStore(Long id,String name, String webAddress, Set<Item> items) {
        super(id,name, webAddress, items);
    }
}
