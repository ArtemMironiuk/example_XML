package org.example;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.List;

@XmlRootElement(name="total")
public class Total {
    @XmlElementWrapper(name="result")
    @XmlElement(name = "Person")
    private List<Client> result;
    @XmlElementWrapper(name="minimum")
    @XmlElement(name = "Person")
    private List<Client> minimum;

    public Total() {
    }

    public Total(List<Client> result, List<Client> minimum) {
        this.result = result;
        this.minimum = minimum;
    }

    @XmlTransient
    public List<Client> getResult() {
        return result;
    }

    public void setResult(List<Client> result) {
        this.result = result;
    }

    @XmlTransient
    public List<Client> getMinimum() {
        return minimum;
    }

    public void setMinimum(List<Client> minimum) {
        this.minimum = minimum;
    }
}
