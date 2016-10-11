/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankdetailsexample;

/**
 *
 * @author user2
 */
public class AccountDetails implements Runnable {

    /**
     * @param args the command line arguments
     */
    //Defining an object of the account class
    private Account account = new Account();
    
  public static void main(String[] args) {  
      //Creating new object of the AccountDetails class
        AccountDetails r = new AccountDetails(); 
        //Defining two Threads for Assinging the names of the two bank customers
        Thread one = new Thread(r);  
        Thread two = new Thread(r); 
        Thread three = new Thread(r);
        //Assigning names
        one.setName("Chris");  
        two.setName("Natalie");  
        three.setName("Nancy");
        //Starting the threads one and two to see who is trying to 
        //withdraw and deposit
        one.start();  
        two.start();  
        three.start();
    }  
  
    //Using the run() method of the Thread Class
    @Override  
    public void run() {  
        for (int x = 0; x < 5; x++) {  
            makeWithdrawal(10);  
            //if account balance is less than 0
            if (account.getBalance() < 0) { 
                //Programme will print "account is overdrawn" 
                System.out.println("account is overdrawn!");  
            }  
            deposit(1000);
        }  
    }  
    //Synchronized is used to provide access to shared resources.
    private synchronized void makeWithdrawal(int amt) {  
        //When Account balance is equal to the amount available int the account
        if (account.getBalance() >= amt) {  
            //Customer can Withdraw money
            //Thread.currentThread().getName() == this will give you the name of the Customer
            //Who is Withdrawing money from account
            System.out.println(Thread.currentThread().getName() + " is going to withdraw");  
            //Assigning a delay of 100 for the thread 
            try {  
                Thread.sleep(100);  
            } catch (InterruptedException ex) {  
            } 
            //Once the Customer Withdrew the mouney from account program will print 
            //Customer completes Withdrawal
            account.Withdraw(amt);  
            System.out.println(Thread.currentThread().getName() + " completes the withdrawal");  
        } else {  
            //if there are not enough funds available in the account 
            //Programme will print not enough money in the account
            System.out.println("Not enough in account for " + Thread.currentThread().getName() + " to withdraw " + account.getBalance());  
        }  
    }  
    private synchronized void deposit(int bal){
        //When Account balance is greater than to the amount available int the account
        if (bal>0) {
            //Customer is trying to deposit money
            System.out.println(Thread.currentThread().getName()+" "+ " is try to deposit");
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //Depositing money into the acccount
            account.Deposit(bal);
            System.out.println(Thread.currentThread().getName()+" "+ "is complete the deposit");
            //If there is no sufficient funds programme will print no money to deposit
        }else{        
            System.out.println(Thread.currentThread().getName()+ " "+"doesn't have enough money for deposit");
        }
    }
}  
    

//Declaring a class Account and assigning account balance
class Account{
    //Account balance is 500
    private int balance = 500;

    //returning the balance using getBalance method
    public int getBalance() {
        return balance;
    }
    //Method Withdraw to find out the balance amount in the account
    public void Withdraw(int amount){
        balance = balance-amount;
    }
    //Method Deposit to find out the balance amount in the account
    public void Deposit(int bal){
        balance= balance+bal;
    }
}


    
    


   
    
