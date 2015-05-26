package com.ibcs.primax.javaee.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.text.DecimalFormat;

/**
 * @author Abdullah Al Mamun Oronno
 *         Email: mr.oronno@gmail.com
 */

/*
Custom tag "calculateTax" demonstration
 */
public class CalculationTagHandler extends SimpleTagSupport {

    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter jspWriter = getJspContext().getOut();

        double priceWithTaxRate = getPrice() * 1.15;

        DecimalFormat formatter = new DecimalFormat("$##,###.##");

        getJspBody().invoke(jspWriter);
        jspWriter.write(formatter.format(priceWithTaxRate));
    }
}
