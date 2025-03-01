package com.example.payx.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    private String name;

    private String email;

    private String password;

    private Integer Balance; 

    

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id=id;
    }

    public String getpassword(String email){
        return password;
    }

    public void setpassword(String password){
        this.password=password;
    }

    
    public  String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email=email;
    }

    public Integer getBalance() {
        return Balance;
    }

    public void setBalance(Integer Balance) {
        this.Balance = Balance;
    }

 
    
}
