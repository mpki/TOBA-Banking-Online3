/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Matt
 */
@Entity
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private float Balance;
    private BankAccount AccountType;
   @OneToMany(targetEntity = Transactions.class, fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    private List<Transactions> Transaction;
    @ManyToOne
    private User user;
    
    public void credit(float credit){this.Balance += credit;}
    public void debit(float debit){this.Balance -= debit;}
    
    public enum BankAccount
    {
        Checking, Savings
    }
    
    public Account()
    {
        
    }
    
    public Account(User user, float Balance)
    {
        this.user = user;
        this.Balance = Balance;
    }
    
    public Long getId() {
        return id;
    }
    
    public float getBalance()
    {
        return this.Balance;
    }

    public BankAccount getAccountType()
    {
        return this.AccountType;
    }
    
    public List getTransactions()
    {
        return this.Transaction;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public void setBalance(float Balance)
    {
        this.Balance = Balance;
    }
    
    public void setAccountType(BankAccount AccountType)
    {
        this.AccountType = AccountType;
    }
    
    public void AddTransaction(Transactions transfer)
    {
        this.Transaction.add(transfer);
    }
    
    public void DeleteTransactions()
    {
        this.Transaction = null;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Beans.Account[ id=" + id + " ]";
    }
    
}
