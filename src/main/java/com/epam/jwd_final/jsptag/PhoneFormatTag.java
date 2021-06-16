package com.epam.jwd_final.jsptag;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class PhoneFormatTag extends SimpleTagSupport {
    private String phone;

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public void doTag() throws IOException {
        JspWriter out = getJspContext().getOut();
        String newPhone = phone;
        if (phone != null) {
            if (phone.length() == 13) {
                newPhone = phone.substring(0, 4) + " (" + phone.substring(4,6) + ") " + phone.substring(6);
            }
        }
        out.println(newPhone);
    }
}
