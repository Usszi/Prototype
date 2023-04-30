package hr.java.production.model;


import hr.java.production.enumeration.Enumeration;

import java.io.Serializable;
import java.util.Objects;

public class Address implements Serializable {

    private String street;
    private String houseNumber;
    private Enumeration city_postalCode;


    public Address(String street, String houseNumber, Enumeration city_postalCode) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.city_postalCode = city_postalCode;
    }

    public Address() {

    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public Enumeration getCity() {
        return city_postalCode;
    }

    public void setCity(Enumeration city) {
        this.city_postalCode = city;
    }


    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", city_postalCode=" + city_postalCode +
                '}';
    }

    public static class  Builder {
        private String street;
        private String houseNumber;
        private Enumeration city_postalCode;


        public Builder(Enumeration city_postalCode) {
            this.city_postalCode = city_postalCode;
        }

        public Builder setStreet(String street) {
            this.street = street;
            return this;
        }

        public Builder setHouseNumber(String houseNumber) {
            this.houseNumber = houseNumber;
            return this;
        }

        public Address build() {
            Address address = new Address();
            address.street = this.street;
            address.houseNumber = this.houseNumber;
            address.city_postalCode = this.city_postalCode;
            return address;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(street, address.street) && Objects.equals(houseNumber, address.houseNumber) && Objects.equals(city_postalCode, address.city_postalCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, houseNumber, city_postalCode);
    }
}
