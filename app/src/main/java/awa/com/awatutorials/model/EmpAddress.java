package awa.com.awatutorials.model;

public class EmpAddress {
    private String street, city;


    private int zipCode;

  /*  public EmpAddress(String street, String city, int zipCode) {
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
    }*/

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }
    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public int getZipCode() {
        return zipCode;
    }
    @Override
    public String toString(){
        return getStreet() + ", "+getCity()+", "+getZipCode();
    }


}
