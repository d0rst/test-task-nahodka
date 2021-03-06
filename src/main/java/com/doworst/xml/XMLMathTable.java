package com.doworst.xml;

import com.doworst.dao.model.MathTableRowModel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
/**
 * Schema class for working with xml files
 */
@XmlRootElement(name = "table")
@XmlAccessorType(XmlAccessType.FIELD)
public class XMLMathTable {
    private List<MathTableRowModel> mathTableRowModels;

    public void setMathTableRowModels(List<MathTableRowModel> mathTableRowModels) {
        this.mathTableRowModels = mathTableRowModels;
    }

    public List<MathTableRowModel> getMathTableRowModels() {
        return mathTableRowModels;
    }
}