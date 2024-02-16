/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bankjar;

/**
 *
 * @author DAW TARDE
 */
interface Bank {
    public String getOwner();
    public String getIban();
    public double getBalance();
    public AccountType getAccountType();
    public String getBank();
    public double[] getLatestTransactions();
    public void setOwner(String owner);
    public void setIban(String iban);
    public void setBalance(double balance);
    public void setAccountType(AccountType accountType);
    public void setBank(String bank);
    public void setLatestTransactions(double[] latestTransactions);
    public String getNameSurnameMaxBalance(Bank account);
    public int getRisk();
    public String getBalance(String iban, String owner);
    public String getAccountNumberMaxRisk(Bank account);
}
