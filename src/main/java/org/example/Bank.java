package org.example;

import javax.xml.bind.annotation.*;
import java.util.List;


@XmlRootElement(name="Bank")
public class Bank {

    @XmlAttribute
    private double wallet;
    @XmlElement(name = "Person")
    private List<Person> personList;

    public Bank(){

    }
    public Bank(double wallet, List<Person> personList) {
        this.wallet = wallet;
        this.personList = personList;
    }

    @XmlTransient
    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    @XmlTransient
    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "wallet=" + wallet +
                ", personList=" + personList +
                '}';
    }
}
