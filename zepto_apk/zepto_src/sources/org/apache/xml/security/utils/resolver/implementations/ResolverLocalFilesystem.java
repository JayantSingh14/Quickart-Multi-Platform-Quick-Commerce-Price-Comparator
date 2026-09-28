package org.apache.xml.security.utils.resolver.implementations;

import com.google.android.gms.internal.pal.a;
import java.io.FileInputStream;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.signature.XMLSignatureInput;
import org.apache.xml.security.utils.resolver.ResourceResolverException;
import org.apache.xml.security.utils.resolver.ResourceResolverSpi;
import org.apache.xml.utils.URI;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;

/* loaded from: classes5.dex */
public class ResolverLocalFilesystem extends ResourceResolverSpi {

    /* renamed from: d, reason: collision with root package name */
    static Log f57389d;

    /* renamed from: e, reason: collision with root package name */
    static Class f57390e;

    /* renamed from: f, reason: collision with root package name */
    private static int f57391f;

    static {
        Class clsC = f57390e;
        if (clsC == null) {
            clsC = c("org.apache.xml.security.utils.resolver.implementations.ResolverLocalFilesystem");
            f57390e = clsC;
        }
        f57389d = LogFactory.getLog(clsC.getName());
        f57391f = 6;
    }

    public static Class c(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw a.g(e2);
        }
    }

    private static String d(String str) {
        int iIndexOf;
        String strSubstring = str.substring(f57391f);
        if (strSubstring.indexOf("%20") > -1) {
            StringBuffer stringBuffer = new StringBuffer(strSubstring.length());
            int i2 = 0;
            do {
                iIndexOf = strSubstring.indexOf("%20", i2);
                if (iIndexOf == -1) {
                    stringBuffer.append(strSubstring.substring(i2));
                } else {
                    stringBuffer.append(strSubstring.substring(i2, iIndexOf));
                    stringBuffer.append(' ');
                    i2 = iIndexOf + 3;
                }
            } while (iIndexOf != -1);
            strSubstring = stringBuffer.toString();
        }
        return strSubstring.charAt(1) == ':' ? strSubstring : "/".concat(strSubstring);
    }

    @Override // org.apache.xml.security.utils.resolver.ResourceResolverSpi
    public XMLSignatureInput a(Attr attr, String str) throws ResourceResolverException {
        try {
            URI uriA = a(attr.getNodeValue(), str);
            URI uri = new URI(uriA);
            uri.setFragment((String) null);
            XMLSignatureInput xMLSignatureInput = new XMLSignatureInput(new FileInputStream(d(uri.toString())));
            xMLSignatureInput.b(uriA.toString());
            return xMLSignatureInput;
        } catch (Exception e2) {
            throw new ResourceResolverException("generic.EmptyMessage", e2, attr, str);
        }
    }

    @Override // org.apache.xml.security.utils.resolver.ResourceResolverSpi
    public boolean b(Attr attr, String str) throws DOMException {
        if (attr == null) {
            return false;
        }
        String nodeValue = attr.getNodeValue();
        if (!nodeValue.equals("") && nodeValue.charAt(0) != '#' && !nodeValue.startsWith("http:")) {
            try {
                if (f57389d.isDebugEnabled()) {
                    f57389d.debug("I was asked whether I can resolve ".concat(nodeValue));
                }
                if (nodeValue.startsWith("file:") || str.startsWith("file:")) {
                    if (!f57389d.isDebugEnabled()) {
                        return true;
                    }
                    f57389d.debug("I state that I can resolve ".concat(nodeValue));
                    return true;
                }
            } catch (Exception unused) {
            }
            f57389d.debug("But I can't");
        }
        return false;
    }

    private static URI a(String str, String str2) {
        return (str2 == null || "".equals(str2)) ? new URI(str) : new URI(new URI(str2), str);
    }

    @Override // org.apache.xml.security.utils.resolver.ResourceResolverSpi
    public boolean a() {
        return true;
    }
}
