package com.doworst.xml;

import com.doworst.dao.model.MathTableRowModel;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;
/**
 * Utility for processing XML format files
 */
public class UtilXML {
    /** method to create xml table from class MathTableRowModel
     * @param list - MathTableRowModel list
     * */
    public static XMLMathTable buildTableXML(List<MathTableRowModel> list){
        XMLMathTable table = new XMLMathTable();
        table.setMathTableRowModels(list);
        return table;
    }

    /** method to create xml file from class MathTableRowModel
     * @param list - MathTableRowModel list
     * @param outNameFile - path to output xml file
     * */
    public static void createTableXML(List<MathTableRowModel> list, String outNameFile)
            throws JAXBException, NullPointerException {
        XMLMathTable table = buildTableXML(list);
        File file = new File(outNameFile);
        JAXBContext jaxbContext = JAXBContext.newInstance(XMLMathTable.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(table, file);

    }

    /** method to create xml file from class MathTableRowModel
     * @param fileName - path to input xml file
     * */
    public static List<MathTableRowModel> convertXMLFileToObjects(String fileName) throws JAXBException {
        File xmlFile = new File(fileName);
        JAXBContext jaxbContext;
        jaxbContext = JAXBContext.newInstance(XMLMathTable.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        XMLMathTable table = (XMLMathTable) jaxbUnmarshaller.unmarshal(xmlFile);
        return table.getMathTableRowModels();
    }
}
