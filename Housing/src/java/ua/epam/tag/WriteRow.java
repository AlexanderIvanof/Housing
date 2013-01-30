/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.epam.tag;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.BodyTagSupport;

/**
 * Tag handler for custom tag.
 *
 * @author Alexandr Ivanov
 */
public class WriteRow extends BodyTagSupport {

    private String onumber;
    private String foreman;
    private String worker;
    private String date;
    private String address;

    /**
     * Creates new instance of tag handler
     */
    public WriteRow() {
        super();
    }

    /**
     * This method is called when the JSP engine encounters the start tag, after
     * the attributes are processed. Scripting variables (if any) have their
     * values set here.
     *
     * @return EVAL_BODY_BUFFERED if the JSP engine should evaluate the tag
     * body, otherwise return SKIP_BODY. This method is automatically generated.
     * Do not modify this method. Instead, modify the methods that this method
     * calls.
     */
    @Override
    public int doStartTag() throws JspTagException {
        try {
            pageContext.getOut().write("<tr><td width=\"5%\" align=\"center\">" + onumber + "</td>");
            pageContext.getOut().write("<td width=\"30%\">" + foreman + "</td>");
            pageContext.getOut().write("<td width=\"30%\">" + worker + "</td>");
            pageContext.getOut().write("<td width=\"10%\">" + date + "</td>");
            pageContext.getOut().write("<td width=\"25%\">" + address);
        } catch (IOException ex) {
            throw new JspTagException(ex.getMessage());
        }
        return SKIP_BODY;
    }

    /**
     * This method is called after the JSP engine finished processing the tag.
     *
     * @return EVAL_PAGE if the JSP engine should continue evaluating the JSP
     * page, otherwise return SKIP_PAGE. This method is automatically generated.
     * Do not modify this method. Instead, modify the methods that this method
     * calls.
     */
    @Override
    public int doEndTag() throws JspException {
        try {
            pageContext.getOut().write("</td></tr>");
        } catch (IOException ex) {
            throw new JspTagException(ex.getMessage());
        }

        return EVAL_PAGE;
    }

    /**
     * This method is called after the JSP engine processes the body content of
     * the tag.
     *
     * @return EVAL_BODY_AGAIN if the JSP engine should evaluate the tag body
     * again, otherwise return SKIP_BODY. This method is automatically
     * generated. Do not modify this method. Instead, modify the methods that
     * this method calls.
     */
    public void setOnumber(String onumber) {
        this.onumber = onumber;
    }

    public void setForeman(String foreman) {
        this.foreman = foreman;
    }

    public void setWorker(String worker) {
        this.worker = worker;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
