package com.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user2")
public class User {

    @Id
    @Column(name="accountNo")
    private String accountNo;

    @Column(name="name")
    private String name;

    @Column(name="AadharCardNo")
    private String AadharCardNo;

    @Column(name="Balance")
    private int balance;

    @Column(name="UBranchCode")
    private int UBranchCode;

    public User() {
    }

    public User(String accountNo, String name,  String aadharCardNo, int balance, int UBranchCode) {

        this.accountNo = accountNo;
        this.name = name;
        AadharCardNo = aadharCardNo;
        this.balance = balance;
        this.UBranchCode = UBranchCode;
    }

    @Override
    public String toString() {
        return "User{" +
                "accountNo='" + accountNo + '\'' +
                ", name='" + name + '\'' +
                ", AadharCardNo='" + AadharCardNo + '\'' +
                ", balance=" + balance +
                ", UBranchCode=" + UBranchCode +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAadharCardNo() {
        return AadharCardNo;
    }

    public void setAadharCardNo(String aadharCardNo) {
        AadharCardNo = aadharCardNo;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getUBranchCode() {
        return UBranchCode;
    }

    public void setUBranchCode(int UBranchCode) {
        this.UBranchCode = UBranchCode;
    }
}





