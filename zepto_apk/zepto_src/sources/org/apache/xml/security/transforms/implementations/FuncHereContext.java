package org.apache.xml.security.transforms.implementations;

import org.apache.xml.dtm.DTMManager;
import org.apache.xml.security.utils.I18n;
import org.apache.xpath.XPathContext;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public class FuncHereContext extends XPathContext {
    private FuncHereContext() {
    }

    public FuncHereContext(Node node, DTMManager dTMManager) {
        super(node);
        try {
            ((XPathContext) this).m_dtmManager = dTMManager;
        } catch (IllegalAccessError e2) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(I18n.a("endorsed.jdk1.4.0"));
            stringBuffer.append(" Original message was \"");
            stringBuffer.append(e2.getMessage());
            stringBuffer.append("\"");
            throw new IllegalAccessError(stringBuffer.toString());
        }
    }
}
