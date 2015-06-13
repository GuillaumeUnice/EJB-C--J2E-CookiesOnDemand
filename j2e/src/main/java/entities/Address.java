package entities;

import javax.persistence.Embeddable;

/**
 * Created by Maxime Dito on 10/03/2015.
 */
@Embeddable
public class Address {

    private String country;
    private String city;
    private int zipCode;
    private String adress;


    public Address() {
        country = "";
        city = "";
        zipCode = 0;
        adress = "";
    }

    public Address(String country, String city, int zipCode, String adress) {
        this.city = city;
        this.country = country;
        this.zipCode = zipCode;
        this.adress = adress;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;

        Address address = (Address) o;

        if (getZipCode() != address.getZipCode()) return false;
        if (getAdress() != null ? !getAdress().equals(address.getAdress()) : address.getAdress() != null) return false;
        if (getCity() != null ? !getCity().equals(address.getCity()) : address.getCity() != null) return false;
        if (getCountry() != null ? !getCountry().equals(address.getCountry()) : address.getCountry() != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Adresse : "+getCountry()+"-"+getCity()+"-"+getZipCode()+"-"+getAdress() ;
    }

}
