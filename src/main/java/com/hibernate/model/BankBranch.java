package com.hibernate.model;
import javax.persistence.*;

@Entity
@Table(name="bankbranch2")
public class BankBranch {

    @Id
    @Column(name="id")
    private int id;

    @Column(name="address")
    private String address;

    @Column(name="phone")
    private String phone;

    public BankBranch() {
    }

    public BankBranch(int id, String address, String phone) {
        this.id = id;
        this.address = address;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "BankBranch{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                '}';
    }
}
