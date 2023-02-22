//package org.example;
//
//import com.thoughtworks.xstream.XStream;
//import com.thoughtworks.xstream.io.xml.DomDriver;
//
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.List;
//
//public class Marshaller {
//
//    public static void marshaller(List<Person> object, String nameXmlFile) throws IOException {
//        XStream xStream = new XStream(new DomDriver());
//        xStream.alias(nameXmlFile, List.class);
//        xStream.processAnnotations(Person.class);
//
//        String xml = xStream.toXML(object);
//        saveToFile(xml, nameXmlFile);
//    }
//
//    private static void saveToFile(String xml, String nameFile) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(nameFile+".xml")));
//        bufferedWriter.write(xml);
//        bufferedWriter.close();
//    }
//}
