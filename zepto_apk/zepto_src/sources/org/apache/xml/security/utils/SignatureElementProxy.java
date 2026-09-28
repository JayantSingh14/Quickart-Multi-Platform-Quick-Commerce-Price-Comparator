package org.apache.xml.security.utils;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/* loaded from: classes5.dex */
public abstract class SignatureElementProxy extends ElementProxy {
    public SignatureElementProxy() {
    }

    @Override // org.apache.xml.security.utils.ElementProxy
    public String d() {
        return "http://www.w3.org/2000/09/xmldsig#";
    }

    public SignatureElementProxy(Document document) {
        if (document == null) {
            throw new RuntimeException("Document is null");
        }
        this.f57335m = document;
        this.f57333k = XMLUtils.a(document, e());
    }

    public SignatureElementProxy(Element element, String str) {
        super(element, str);
    }
}
