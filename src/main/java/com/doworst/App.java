package com.doworst;

import com.doworst.dao.MyDAOFactory;
import com.doworst.xml.UtilXML;
import com.doworst.dao.model.MathTableRowModel;
import picocli.CommandLine;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.Callable;

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
    String xmlin;

    public Integer call() throws Exception {
        try {
            FileInputStream fis = new FileInputStream(conf);
            prop.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<MathTableRowModel> mathTableRowModels = new ArrayList<MathTableRowModel>();

        MyDAOFactory daoFactory = MyDAOFactory.getDAOFactory(prop.getProperty("dao.param"));
        if (a != 0 && b != 0 && c != 0) {
            mathTableRowModels.add(new MathTableRowModel("a", a));
            mathTableRowModels.add(new MathTableRowModel("b", b));
            mathTableRowModels.add(new MathTableRowModel("c", c));
            UtilXML.createTableXML(mathTableRowModels, prop.getProperty("xml.outpath"));
        }

        if (xmlin != null) {
            List<MathTableRowModel> table = UtilXML.xmlFileToObjects(xmlin);
            for (MathTableRowModel m : table) {
                daoFactory.getMathTableDAO().insertTableRow(m);
            }
        }
        return 0;
    }
}

