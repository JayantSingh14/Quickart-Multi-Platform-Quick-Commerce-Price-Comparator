package org.apache.xml.security.utils;

import com.google.android.gms.internal.pal.a;
import java.util.HashMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.exceptions.XMLSecurityException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

/* loaded from: classes5.dex */
public abstract class ElementProxy {

    /* renamed from: j, reason: collision with root package name */
    static Log f57332j;
    static HashMap n;
    static HashMap o;
    static Class p;

    /* renamed from: k, reason: collision with root package name */
    protected Element f57333k;

    /* renamed from: l, reason: collision with root package name */
    protected String f57334l;

    /* renamed from: m, reason: collision with root package name */
    protected Document f57335m;

    static {
        Class clsC = p;
        if (clsC == null) {
            clsC = c("org.apache.xml.security.utils.ElementProxy");
            p = clsC;
        }
        f57332j = LogFactory.getLog(clsC.getName());
        n = new HashMap();
        o = new HashMap();
    }

    public ElementProxy() {
        this.f57333k = null;
        this.f57334l = null;
        this.f57335m = null;
    }

    public static void d(String str, String str2) throws XMLSecurityException {
        if (n.containsValue(str2)) {
            Object obj = n.get(str);
            if (!obj.equals(str2)) {
                throw new XMLSecurityException("prefix.AlreadyAssigned", new Object[]{str2, str, obj});
            }
        }
        if ("http://www.w3.org/2000/09/xmldsig#".equals(str)) {
            XMLUtils.f57368a = str2;
        }
        if ("http://www.w3.org/2001/04/xmlenc#".equals(str)) {
            XMLUtils.f57369b = str2;
        }
        n.put(str, str2.intern());
        if (str2.length() == 0) {
            o.put(str, "xmlns");
        } else {
            o.put(str, "xmlns:".concat(str2).intern());
        }
    }

    public String b(String str, String str2) {
        return ((Text) XMLUtils.a(this.f57333k.getFirstChild(), str2, str, 0).getFirstChild()).getData();
    }

    public int c(String str, String str2) {
        int i2 = 0;
        for (Node firstChild = this.f57333k.getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
            if (str2.equals(firstChild.getLocalName()) && str.equals(firstChild.getNamespaceURI())) {
                i2++;
            }
        }
        return i2;
    }

    public abstract String d();

    public abstract String e();

    public final Element k() {
        return this.f57333k;
    }

    public String l() {
        return this.f57334l;
    }

    public void m() throws XMLSecurityException {
        String strE = e();
        String strD = d();
        String localName = this.f57333k.getLocalName();
        String namespaceURI = this.f57333k.getNamespaceURI();
        if (strD.equals(namespaceURI) || strE.equals(localName)) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(namespaceURI);
        stringBuffer.append(":");
        stringBuffer.append(localName);
        String string = stringBuffer.toString();
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append(strD);
        stringBuffer2.append(":");
        stringBuffer2.append(strE);
        throw new XMLSecurityException("xml.WrongElement", new Object[]{string, stringBuffer2.toString()});
    }

    public byte[] n() {
        return Base64.a(XMLUtils.a(this.f57333k));
    }

    public String o() {
        return XMLUtils.a(this.f57333k);
    }

    public ElementProxy(Element element, String str) throws XMLSecurityException {
        this.f57333k = null;
        this.f57334l = null;
        this.f57335m = null;
        if (element == null) {
            throw new XMLSecurityException("ElementProxy.nullElement");
        }
        if (f57332j.isDebugEnabled()) {
            Log log = f57332j;
            StringBuffer stringBuffer = new StringBuffer("setElement(\"");
            stringBuffer.append(element.getTagName());
            stringBuffer.append("\", \"");
            stringBuffer.append(str);
            stringBuffer.append("\")");
            log.debug(stringBuffer.toString());
        }
        this.f57335m = element.getOwnerDocument();
        this.f57333k = element;
        this.f57334l = str;
        m();
    }

    public static Class c(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw a.g(e2);
        }
    }
}
