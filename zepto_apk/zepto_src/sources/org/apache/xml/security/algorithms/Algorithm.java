package org.apache.xml.security.algorithms;

import org.apache.xml.security.utils.SignatureElementProxy;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/* loaded from: classes5.dex */
public abstract class Algorithm extends SignatureElementProxy {
    public Algorithm(Document document, String str) throws DOMException {
        super(document);
        a(str);
    }

    public String a() {
        return this.f57333k.getAttributeNS(null, "Algorithm");
    }

    public Algorithm(Element element, String str) {
        super(element, str);
    }

    public void a(String str) throws DOMException {
        if (str != null) {
            this.f57333k.setAttributeNS(null, "Algorithm", str);
        }
    }
}
