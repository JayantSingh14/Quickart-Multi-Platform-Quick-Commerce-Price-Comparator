package org.apache.xml.security.transforms.params;

import org.apache.xml.security.exceptions.XMLSecurityException;
import org.apache.xml.security.transforms.TransformParam;
import org.apache.xml.security.utils.ElementProxy;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* loaded from: classes5.dex */
public class XPath2FilterContainer extends ElementProxy implements TransformParam {
    private XPath2FilterContainer() {
    }

    public static XPath2FilterContainer a(Element element, String str) {
        return new XPath2FilterContainer(element, str);
    }

    public boolean b() {
        return this.f57333k.getAttributeNS(null, "Filter").equals("subtract");
    }

    public boolean c() {
        return this.f57333k.getAttributeNS(null, "Filter").equals("union");
    }

    @Override // org.apache.xml.security.utils.ElementProxy
    public final String d() {
        return "http://www.w3.org/2002/06/xmldsig-filter2";
    }

    @Override // org.apache.xml.security.utils.ElementProxy
    public final String e() {
        return "XPath";
    }

    public Node f() {
        NodeList childNodes = this.f57333k.getChildNodes();
        int length = childNodes.getLength();
        for (int i2 = 0; i2 < length; i2++) {
            if (childNodes.item(i2).getNodeType() == 3) {
                return childNodes.item(i2);
            }
        }
        return null;
    }

    private XPath2FilterContainer(Element element, String str) throws XMLSecurityException, DOMException {
        super(element, str);
        String attributeNS = this.f57333k.getAttributeNS(null, "Filter");
        if (!attributeNS.equals("intersect") && !attributeNS.equals("subtract") && !attributeNS.equals("union")) {
            throw new XMLSecurityException("attributeValueIllegal", new Object[]{"Filter", attributeNS, "intersect, subtract or union"});
        }
    }

    public boolean a() {
        return this.f57333k.getAttributeNS(null, "Filter").equals("intersect");
    }
}
