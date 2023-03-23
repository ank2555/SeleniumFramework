package org.selenium.pom.Objects;

public class Billinginformation {

    private String firstname;
    private String Lastname;
    private String addressLineone;
    private String city;
    private String postcode;
    private String email;
    private String company;
    private String CountryName;
    private String StateName;





   public Billinginformation()
    {

    }

   public Billinginformation(String firstname,String lastname,String addressLineone , String city, String postcode, String email,String company)
    {

        this.firstname=firstname;
        this.Lastname=lastname;
        this.addressLineone=addressLineone;
        this.city=city;
        this.company=company;
        this.postcode=postcode;
        this.email=email;


    }




    public String getFirstname() {
        return firstname;
    }

    public Billinginformation setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String getLastname() {
        return Lastname;

    }

    public Billinginformation setLastname(String lastname) {
        Lastname = lastname;
        return this;
    }

    public String getAddressLineone() {
        return addressLineone;
    }

    public Billinginformation setAddressLineone(String addressLineone) {
        this.addressLineone = addressLineone;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Billinginformation setCity(String city) {
        this.city = city;
   return  this;
    }

    public String getPostcode() {
        return postcode;
    }

    public Billinginformation setPostcode(String postcode) {
        this.postcode = postcode;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Billinginformation setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getCompany() {
        return company;
    }

    public Billinginformation setCompany(String company) {
        this.company = company;
        return this;
    }

    public String getCountryName() {
        return CountryName;
    }

    public Billinginformation setCountryName(String CountryName) {
      this.CountryName=CountryName;
        return this ;
    }

    public String getStateName() {
        return StateName;
    }

    public Billinginformation setStateName(String stateName) {
        this.StateName = stateName;
        return this ;
    }




}
