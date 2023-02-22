package org.example;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name="Person")
public class Person implements Comparable<Person>{

    @XmlAttribute
    private String name;
    @XmlAttribute
    private double wallet;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, double wallet) {
        this.name = name;
        this.wallet = wallet;
    }

    public Person(String name, double wallet, double appendFromBank) {
        this.name = name;
        this.wallet = wallet;
    }

    @XmlTransient
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public double getWallet() {
        return wallet;
    }

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    @Override
    public int compareTo(Person o) {
        if(this.wallet > o.getWallet())
            return 1;
        if(this.wallet < o.getWallet())
            return -1;
        return 0;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", wallet=" + wallet +
                '}';
    }
}
