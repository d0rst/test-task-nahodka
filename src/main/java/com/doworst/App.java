package com.doworst;

import com.doworst.dao.MyDAOFactory;
import com.doworst.exeption.ConfigException;
import com.doworst.xml.UtilXML;
import com.doworst.dao.model.MathTableRowModel;
import picocli.CommandLine;

import javax.xml.bind.JAXBException;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.Callable;

/**
 * Application launch class
 */
public class App implements Callable<Integer> {
    public static final Properties prop = new Properties();

    @CommandLine.Option(names = "-a", required = false)
    int a;
    @CommandLine.Option(names = "-b", required = false)
    int b;
    @CommandLine.Option(names = "-c", required = false)
    int c;

    @CommandLine.Option(names = "-conf", description="Path and name of config file." +
            "dao.param = <SQLITE or ORACLE_XE> \n" +
            "db.url= <url or path> \n" +
            "db.user= <user> \n" +
            "db.pass= <pass> \n" +
            "xml.outpath = <xml output path> ")

    String conf = "config.properties";

    @CommandLine.Option(names = "-f", description="Path and name of xml file")
    String xmlIn;

    public Integer call() {
        try {
            FileInputStream fis = new FileInputStream(conf);
            prop.load(fis);
            propChek("dao.param");
            propChek("db.url");
        } catch (IOException | ConfigException e) {
            System.out.println(e);
            return 0;
        }

        List<MathTableRowModel> mathTableRowModels = new ArrayList<MathTableRowModel>();

        if (a != 0 && b != 0 && c != 0) {
            mathTableRowModels.add(new MathTableRowModel("a", a));
            mathTableRowModels.add(new MathTableRowModel("b", b));
            mathTableRowModels.add(new MathTableRowModel("c", c));
            try {
                propChek("xml.out_xml_path");}
            catch (NullPointerException | ConfigException e) {
                System.out.println(e);
                return 0;
            }
            try {
                UtilXML.createTableXML(mathTableRowModels, prop.getProperty("xml.out_xml_path"));
            } catch (JAXBException e) {
                System.out.println(e);
            }
        }

        if (xmlIn != null) {
            MyDAOFactory daoFactory = MyDAOFactory.getDAOFactory(prop.getProperty("dao.param"));
            try {
                for (MathTableRowModel m : UtilXML.convertXMLFileToObjects(xmlIn)) {
                    daoFactory.getMathTableDAO().insertTableRow(m);
                }
            } catch (SQLException | JAXBException e) {
                System.out.println(e);
            }
        }
        return 0;
    }

    private void propChek(String parm) throws ConfigException {
        if (prop.contains(parm)) {
            throw new ConfigException("Отсутствует или не корректен " + parm);
        }
    }
}

