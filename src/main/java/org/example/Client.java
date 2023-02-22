package org.example;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name="Person")
public class Client {

    @XmlAttribute
    private String name;
    @XmlAttribute
    private double wallet;
    @XmlAttribute
    private double appendFromBank = 0.0;

    public Client() {
    }

    public Client(String name, double wallet, double appendFromBank) {
        this.name = name;
        this.wallet = wallet;
        this.appendFromBank = appendFromBank;
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

    @XmlTransient
    public double getAppendFromBank() {
        return appendFromBank;
    }

    public void setAppendFromBank(double appendFromBank) {
        this.appendFromBank = appendFromBank;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", wallet=" + wallet +
                ", appendFromBank=" + appendFromBank +
                "}\n";
    }
}
