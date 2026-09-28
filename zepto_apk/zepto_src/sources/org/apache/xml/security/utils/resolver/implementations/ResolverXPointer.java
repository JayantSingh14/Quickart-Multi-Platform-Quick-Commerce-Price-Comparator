package org.apache.xml.security.utils.resolver.implementations;

import coil3.util.UtilsKt;
import com.google.android.gms.internal.pal.a;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.signature.XMLSignatureInput;
import org.apache.xml.security.utils.IdResolver;
import org.apache.xml.security.utils.resolver.ResourceResolverException;
import org.apache.xml.security.utils.resolver.ResourceResolverSpi;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public class ResolverXPointer extends ResourceResolverSpi {

    /* renamed from: d, reason: collision with root package name */
    static Log f57392d;

    /* renamed from: e, reason: collision with root package name */
    static Class f57393e;

    /* renamed from: f, reason: collision with root package name */
    private static final int f57394f;

    static {
        Class clsC = f57393e;
        if (clsC == null) {
            clsC = c("org.apache.xml.security.utils.resolver.implementations.ResolverXPointer");
            f57393e = clsC;
        }
        f57392d = LogFactory.getLog(clsC.getName());
        f57394f = 13;
    }

    public static Class c(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw a.g(e2);
        }
    }

    private static boolean d(String str) {
        return str.equals("#xpointer(/)");
    }

    private static boolean e(String str) {
        if (str.startsWith("#xpointer(id(") && str.endsWith("))")) {
            String strK = android.support.v4.media.a.k(2, f57394f, str);
            int length = strK.length() - 1;
            if ((strK.charAt(0) == '\"' && strK.charAt(length) == '\"') || (strK.charAt(0) == '\'' && strK.charAt(length) == '\'')) {
                if (f57392d.isDebugEnabled()) {
                    Log log = f57392d;
                    StringBuffer stringBuffer = new StringBuffer("Id=");
                    stringBuffer.append(strK.substring(1, length));
                    log.debug(stringBuffer.toString());
                }
                return true;
            }
        }
        return false;
    }

    private static String f(String str) {
        if (!str.startsWith("#xpointer(id(") || !str.endsWith("))")) {
            return null;
        }
        String strK = android.support.v4.media.a.k(2, f57394f, str);
        int length = strK.length() - 1;
        if ((strK.charAt(0) == '\"' && strK.charAt(length) == '\"') || (strK.charAt(0) == '\'' && strK.charAt(length) == '\'')) {
            return strK.substring(1, length);
        }
        return null;
    }

    @Override // org.apache.xml.security.utils.resolver.ResourceResolverSpi
    public XMLSignatureInput a(Attr attr, String str) throws DOMException, ResourceResolverException {
        Document ownerDocument = attr.getOwnerElement().getOwnerDocument();
        String nodeValue = attr.getNodeValue();
        Node node = ownerDocument;
        if (!d(nodeValue)) {
            if (e(nodeValue)) {
                String strF = f(nodeValue);
                Node nodeA = IdResolver.a(ownerDocument, strF);
                node = nodeA;
                if (nodeA == null) {
                    throw new ResourceResolverException("signature.Verification.MissingID", new Object[]{strF}, attr, str);
                }
            } else {
                node = null;
            }
        }
        XMLSignatureInput xMLSignatureInput = new XMLSignatureInput(node);
        xMLSignatureInput.a(UtilsKt.MIME_TYPE_XML);
        xMLSignatureInput.b((str == null || str.length() <= 0) ? attr.getNodeValue() : str.concat(attr.getNodeValue()));
        return xMLSignatureInput;
    }

    @Override // org.apache.xml.security.utils.resolver.ResourceResolverSpi
    public boolean b(Attr attr, String str) throws DOMException {
        if (attr == null) {
            return false;
        }
        String nodeValue = attr.getNodeValue();
        return d(nodeValue) || e(nodeValue);
    }

    @Override // org.apache.xml.security.utils.resolver.ResourceResolverSpi
    public boolean a() {
        return true;
    }
}
