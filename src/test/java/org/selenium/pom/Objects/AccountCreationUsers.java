package org.selenium.pom.Objects;

public class AccountCreationUsers {
    private String  username ;
    private  String Password;
    private String Email ;


    public AccountCreationUsers()
    {

    }

    public AccountCreationUsers(String username,String password, String email)

    {
      this.username=username;
      this.Password=password;
      this.Email=email;
    }






    public String getUsername() {
        return username;
    }

    public AccountCreationUsers setUsername(String username) {
        this.username = username;
        return  this;
    }

    public String getPassword() {
        return Password;
    }

    public AccountCreationUsers setPassword(String password) {
        Password = password;
        return this;
    }

    public String getEmail() {
        return Email;
    }

    public AccountCreationUsers setEmail(String email) {
        Email = email;
        return this;
    }




}
