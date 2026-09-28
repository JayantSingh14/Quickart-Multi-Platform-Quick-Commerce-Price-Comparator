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
public class ResolverFragment extends ResourceResolverSpi {

    /* renamed from: d, reason: collision with root package name */
    static Log f57387d;

    /* renamed from: e, reason: collision with root package name */
    static Class f57388e;

    static {
        Class clsC = f57388e;
        if (clsC == null) {
            clsC = c("org.apache.xml.security.utils.resolver.implementations.ResolverFragment");
            f57388e = clsC;
        }
        f57387d = LogFactory.getLog(clsC.getName());
    }

    public static Class c(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw a.g(e2);
        }
    }

    @Override // org.apache.xml.security.utils.resolver.ResourceResolverSpi
    public XMLSignatureInput a(Attr attr, String str) throws DOMException, ResourceResolverException {
        Node node;
        String nodeValue = attr.getNodeValue();
        Document ownerDocument = attr.getOwnerElement().getOwnerDocument();
        if (nodeValue.equals("")) {
            f57387d.debug("ResolverFragment with empty URI (means complete document)");
            node = ownerDocument;
        } else {
            String strSubstring = nodeValue.substring(1);
            Node nodeA = IdResolver.a(ownerDocument, strSubstring);
            if (nodeA == null) {
                throw new ResourceResolverException("signature.Verification.MissingID", new Object[]{strSubstring}, attr, str);
            }
            node = nodeA;
            if (f57387d.isDebugEnabled()) {
                Log log = f57387d;
                StringBuffer stringBuffer = new StringBuffer("Try to catch an Element with ID ");
                stringBuffer.append(strSubstring);
                stringBuffer.append(" and Element was ");
                stringBuffer.append(nodeA);
                log.debug(stringBuffer.toString());
                node = nodeA;
            }
        }
        XMLSignatureInput xMLSignatureInput = new XMLSignatureInput(node);
        xMLSignatureInput.c(true);
        xMLSignatureInput.a(UtilsKt.MIME_TYPE_XML);
        String nodeValue2 = attr.getNodeValue();
        if (str != null) {
            nodeValue2 = str.concat(nodeValue2);
        }
        xMLSignatureInput.b(nodeValue2);
        return xMLSignatureInput;
    }

    @Override // org.apache.xml.security.utils.resolver.ResourceResolverSpi
    public boolean b(Attr attr, String str) throws DOMException {
        if (attr == null) {
            f57387d.debug("Quick fail for null uri");
            return false;
        }
        String nodeValue = attr.getNodeValue();
        if (nodeValue.equals("") || (nodeValue.charAt(0) == '#' && !(nodeValue.charAt(1) == 'x' && nodeValue.startsWith("#xpointer(")))) {
            if (f57387d.isDebugEnabled()) {
                Log log = f57387d;
                StringBuffer stringBuffer = new StringBuffer("State I can resolve reference: \"");
                stringBuffer.append(nodeValue);
                stringBuffer.append("\"");
                log.debug(stringBuffer.toString());
            }
            return true;
        }
        if (f57387d.isDebugEnabled()) {
            Log log2 = f57387d;
            StringBuffer stringBuffer2 = new StringBuffer("Do not seem to be able to resolve reference: \"");
            stringBuffer2.append(nodeValue);
            stringBuffer2.append("\"");
            log2.debug(stringBuffer2.toString());
        }
        return false;
    }

    @Override // org.apache.xml.security.utils.resolver.ResourceResolverSpi
    public boolean a() {
        return true;
    }
}
