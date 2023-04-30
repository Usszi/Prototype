package hr.java.production.model;

import org.w3c.dom.ls.LSOutput;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;

public class Factory extends NamedEntity implements Serializable {
    private Address address;
    private Set<Item> items;

    public Factory(Long id,String name, Address address, Set<Item>  items) {
        super(id,name);
        this.address = address;
        this.items = items;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Item>  getItems() {
        return items;
    }

    public void setItems(Set<Item>  items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Factory{" +
                "address=" + address +
                ", items=" + items +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Factory factory = (Factory) o;
        return Objects.equals(address, factory.address) && Objects.equals(items, factory.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), address, items);
    }
}
