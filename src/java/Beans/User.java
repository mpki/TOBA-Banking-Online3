/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
/**
 *
 * @author Matt
 */
@Entity
public class User implements Serializable {
    
    @Id
    public String Username; 
    public String Password; 
    public String Firstname; 
    public String Lastname; 
    public String Email; 
    public String Phone; 
    public String Address; 
    public String State; 
    public String City; 
    public String Zipcode;
    @OneToMany(mappedBy = "User")
    private List<Account> accounts;
    public User()
    {
        this.Username = "";
        this.Password = "";
        this.Firstname = "";
        this.Lastname = "";
        this.Email = "";
        this.Phone = "";
        this.Address = "";
        this.State = "";
        this.City = "";
        this.Zipcode = "";
    }
    
    public User(String Firstname, String Lastname, String Email, String Phone, String Address, String State, String City, String Zipcode,
            String Username, String Password)
    {
        this.Firstname = Firstname;
        this.Lastname = Lastname;
        this.Email = Email;
        this.Phone = Phone;
        this.Address = Address;
        this.State = State;
        this.City = City;
        this.Zipcode = Zipcode;
        this.Username = Username;
        this.Password = Password;
    }
    
    public String getFirstname(){return Firstname;}
    public void setFirstname(String var){this.Firstname = var;}
    public String getLastname(){return Lastname;}
    public void setLastname(String var){this.Lastname = var;}
    public String getEmail(){return Email;}
    public void setEmail(String var){this.Email = var;}
    public String getPhone(){return Phone;}
    public void setPhone(String var){this.Phone = var;}
    public String getAddress(){return Address;}
    public void setAddress(String var){this.Address = var;}
    public String getState(){return State;}
    public void setState(String var){this.State = var;}
    public String getCity(){return City;}
    public void setCity(String var){this.City = var;}
    public String getZipcode(){return Zipcode;}
    public void setZipcode(String var){this.Zipcode = var;}
    public String getUsername(){return Username;}
    public void setUsername(String var){this.Username = var;}
    public String getPassword(){return Password;}
    public void setPassword(String var){this.Password = var;}
    
    
}
