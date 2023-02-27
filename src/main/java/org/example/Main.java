package org.example;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static Bank bank;
    private static double sumWallet;
    private static double moneyOfOne;
    public static void marshalBank() throws JAXBException, IOException {
        List<Person> myPerson = new ArrayList<Person>();
        myPerson.add(new Person("Михаил", 1.34));
        myPerson.add(new Person("Татьяна", 2.12));
        myPerson.add(new Person("Игорь", 3.44));
        myPerson.add(new Person("Александр", 5.15));
        myPerson.add(new Person("Георгий", 5.15));
        myPerson.add(new Person("Оля", 1.43));
        myPerson.add(new Person("Светлана", 4.25));
        Bank bank = new Bank(10.10, myPerson);

        JAXBContext context = JAXBContext.newInstance(Bank.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(bank, new File("./bank.xml"));
    }

    public static void marshalTotal(Total total) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Total.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(total, new File("./total.xml"));
    }

    public static Bank unmarshall() throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Bank.class);
        Bank bank = (Bank) context.createUnmarshaller().unmarshal(new FileReader("./bank.xml"));
        return bank;
    }


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try {
            marshalBank();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

        try {
            List<Client> result = new ArrayList<>();
            bank = unmarshall();    //получил объект из XML файла
            sumWallet = bank.getWallet();
            Collections.sort(bank.getPersonList());
            for (Person person : bank.getPersonList()) {
                sumWallet = sumWallet + person.getWallet();      // подсчет суммы кошелька банка и клиентов
            }
            moneyOfOne = sumWallet/bank.getPersonList().size();  // количество денег у одного клиента

            Iterator<Person> iterator = bank.getPersonList().iterator();
            while (iterator.hasNext()){
                Person person = iterator.next();
                if (person.getWallet() > moneyOfOne) {
                    Client client = new Client();
                    client.setName(person.getName());
                    client.setWallet(person.getWallet());
                    result.add(client);
                    sumWallet = sumWallet - person.getWallet();
                    moneyOfOne = sumWallet/bank.getPersonList().size();
                    iterator.remove();
                }
            }
            int sum = (int) (sumWallet * 100);                   //перевод суммы в int
            int moneyOneNew =  sum/ bank.getPersonList().size();
            int b = sum % bank.getPersonList().size();
            for (Person person : bank.getPersonList()) {
                Client client = new Client();
                client.setName(person.getName());
                int a = moneyOneNew - (int) (person.getWallet() * 100);
                client.setAppendFromBank((double) a /100);
                if (b > 0) {
                    client.setWallet((double) (moneyOneNew + 1) /100);
                    b--;
                } else {
                    client.setWallet((double) moneyOneNew / 100);
                }
                result.add(client);
            }
            List<Client> minimum = result
                    .stream()
                    .filter((Client client1) ->
                            client1.getAppendFromBank() == result
                                    .stream()
                                    .min(Comparator.comparingDouble(Client::getAppendFromBank))
                                    .get()
                                    .getAppendFromBank())
                    .collect(Collectors.toList());

            marshalTotal(new Total(result, minimum));

            System.out.println(result);
            System.out.println(minimum);
            System.out.println(sumWallet);
            System.out.println(sum);
            System.out.println(moneyOfOne);
            System.out.println(moneyOneNew);

            System.out.println(sum%7);

        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}