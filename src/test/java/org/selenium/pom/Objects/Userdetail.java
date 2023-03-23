package org.selenium.pom.Objects;

public class Userdetail {

    private String Username;

    private String Password;



    public Userdetail()
    {

    }


    public Userdetail(String username, String password)
    {
        this.Password=password;
        this.Username=username;
    }


    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }







}
