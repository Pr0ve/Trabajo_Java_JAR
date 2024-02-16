/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankjar;

import java.util.logging.Logger;

/**
 *
 * @author DAW TARDE
 */
public class BankImpl implements Bank{
    
    private String owner;
    private String iban;
    private double balance;
    private AccountType accountType;
    private String bank;
    private double[] latestTransactions;

    
    public String getOwner() {
        return owner;
    }

    public String getIban() {
        return iban;
    }

    public double getBalance() {
        return balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public String getBank() {
        return bank;
    }

    public double[] getLatestTransactions() {
        return latestTransactions;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public void setLatestTransactions(double[] latestTransactions) {
        this.latestTransactions = latestTransactions;
    }

    public String toString() {
        return "owner= " + owner + ", iban= " + iban + ", balance= " + balance + ", acountType= " + accountType + ", bank= " + bank + ", latestTransactions= " + latestTransactions;
    }

    public BankImpl(String owner, String iban, double balance, String accountType, String bank) {
        this.owner = owner;
        this.iban = iban;
        this.balance = balance;
        this.accountType = AccountType.valueOf(accountType.toUpperCase());
        this.bank = bank;
        this.latestTransactions = new double[20];
    }

    public BankImpl() {
        this.owner = "";
        this.iban = "";
        this.balance = 0.0;
        this.accountType = null;
        this.bank = "";
        this.latestTransactions = new double[20];
    }
    
    
    public String getNameSurnameMaxBalance(Bank account){
        String s = "";
        
        if(this.balance<account.getBalance()){
            s = account.getOwner();
        }
        else if(this.balance>account.getBalance()){
            s = this.owner;
        } 
        else{
            s = "Tienen el mismo saldo";
        }
        return s;
    }
    
    public int getRisk(){
        int n = -1;
        
        switch(this.accountType){
            case AHORRO:
                n=0;
                break;
            case CORRIENTE:
                n=1;
                break;
            case INVERSION:
                n=2;
                break;       
        }
        return n;
    }
    
    public String getBalance(String iban, String owner){
        String s = "";
        
        if(this.iban.equals(iban) && this.owner.equals(owner)){
            s = "The balance of your account is: " + this.balance;
        }
        else{
            s = "The person does not have an account in the provided bank: " + this.bank;
        }
        return s;
    } 
    
    public String getAccountNumberMaxRisk(Bank account){
        String s = "";
        
        if(this.bank.equals(account)){
            if(this.getRisk()<account.getRisk()){
                s = account.getIban();
            }
            else if(this.getRisk()>account.getRisk()){
                s = this.getIban();
            }
            else{
                s = "Tienen el mismo riesgo";
            }
        }
        else{
            s = "Error el banco no es el mismo.";
        }
        return s;
    } 
    
    public double getBalanceIncomesExpenses(){
        double t = 0;
        
        for(double n:latestTransactions){
            t = t + n;
        }
        return t;  
    }
    
    public boolean isBalancePositive(){
        double t = 0;
        boolean b;
        
        for(int i=0;i<10;i++){
            t = t + latestTransactions[i];
        }
        
        if(t > 0){
            b = true;
        }
        else{
            b = false;
        }
        return b;
    }
    
    public String getCCC(){
        String[] s = this.iban.split(" ");
        String t = "";
        
        for(int i=1;i<s.length;i++){
            t = t + s[i];
        }
        return t;
    }
    
    public double sumWhilePositive(double[] transacciones){
        int i = 0;
        double o = 0.0;
        
        while(transacciones[i]>0.0){
            o = transacciones[1] + o;
            i++;
        }
        return o;
    }
    
    
    
    
    
    
    
    
}
