package com.doworst.xml;

import com.doworst.dao.model.MathTableRowModel;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;


public class UtilXML {

    public static XMLMathTable buildTableXML(List<MathTableRowModel> list){
        XMLMathTable table = new XMLMathTable();
        table.setMathTableRowModels(list);
        return table;
    }

    public static void createTableXML(List<MathTableRowModel> list, String outNameFile) throws JAXBException {
        XMLMathTable table = buildTableXML(list);
        File file = new File(outNameFile);
        JAXBContext jaxbContext = JAXBContext.newInstance(XMLMathTable.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(table, file);

    }

    public static List<MathTableRowModel> xmlFileToObjects(String fileName) {
        try {
            File xmlFile = new File(fileName);
            JAXBContext jaxbContext;
            jaxbContext = JAXBContext.newInstance(XMLMathTable.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            XMLMathTable table = (XMLMathTable) jaxbUnmarshaller.unmarshal(xmlFile);
            return table.getMathTableRowModels();
        }
        catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
