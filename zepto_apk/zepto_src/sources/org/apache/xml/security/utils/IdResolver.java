package org.apache.xml.security.utils;

import com.google.android.gms.internal.pal.a;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;
import java.util.WeakHashMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public class IdResolver {

    /* renamed from: a, reason: collision with root package name */
    static Class f57344a;

    /* renamed from: b, reason: collision with root package name */
    private static Log f57345b;

    /* renamed from: c, reason: collision with root package name */
    private static WeakHashMap f57346c;

    /* renamed from: d, reason: collision with root package name */
    private static List f57347d;

    /* renamed from: e, reason: collision with root package name */
    private static int f57348e;

    static {
        Class clsA = f57344a;
        if (clsA == null) {
            clsA = a("org.apache.xml.security.utils.IdResolver");
            f57344a = clsA;
        }
        f57345b = LogFactory.getLog(clsA.getName());
        f57346c = new WeakHashMap();
        List listAsList = Arrays.asList("http://www.w3.org/2000/09/xmldsig#", "http://www.w3.org/2001/04/xmlenc#", "http://schemas.xmlsoap.org/soap/security/2000-12", "http://www.w3.org/2002/03/xkms#", "urn:oasis:names:tc:SAML:1.0:assertion", "urn:oasis:names:tc:SAML:1.0:protocol");
        f57347d = listAsList;
        f57348e = listAsList.size();
    }

    private IdResolver() {
    }

    public static int a(Element element, String str, Element[] elementArr) throws DOMException {
        if (!element.hasAttributes()) {
            return 0;
        }
        NamedNodeMap attributes = element.getAttributes();
        int iIndexOf = f57347d.indexOf(element.getNamespaceURI());
        if (iIndexOf < 0) {
            iIndexOf = f57348e;
        }
        int length = attributes.getLength();
        for (int i2 = 0; i2 < length; i2++) {
            Attr attr = (Attr) attributes.item(i2);
            int iIndexOf2 = attr.getNamespaceURI() == null ? iIndexOf : f57347d.indexOf(attr.getNamespaceURI());
            if (iIndexOf2 < 0) {
                iIndexOf2 = f57348e;
            }
            String localName = attr.getLocalName();
            if (localName == null) {
                localName = attr.getName();
            }
            if (localName.length() <= 2) {
                String nodeValue = attr.getNodeValue();
                if (localName.charAt(0) == 'I') {
                    char cCharAt = localName.charAt(1);
                    if (cCharAt == 'd' && nodeValue.equals(str)) {
                        elementArr[iIndexOf2] = element;
                        if (iIndexOf2 == 0) {
                            return 1;
                        }
                    } else if (cCharAt == 'D' && nodeValue.endsWith(str)) {
                        if (iIndexOf2 != 3) {
                            iIndexOf2 = f57348e;
                        }
                        elementArr[iIndexOf2] = element;
                    }
                } else if (CLConstants.SHARED_PREFERENCE_ITEM_ID.equals(localName) && nodeValue.equals(str)) {
                    if (iIndexOf2 != 2) {
                        iIndexOf2 = f57348e;
                    }
                    elementArr[iIndexOf2] = element;
                }
            }
        }
        if (iIndexOf == 3 && (element.getAttribute("OriginalRequestID").equals(str) || element.getAttribute("RequestID").equals(str) || element.getAttribute("ResponseID").equals(str))) {
            elementArr[3] = element;
        } else if (iIndexOf == 4 && element.getAttribute("AssertionID").equals(str)) {
            elementArr[4] = element;
        } else if (iIndexOf == 5 && (element.getAttribute("RequestID").equals(str) || element.getAttribute("ResponseID").equals(str))) {
            elementArr[5] = element;
        }
        return 0;
    }

    private static Element b(Document document, String str) {
        if (f57345b.isDebugEnabled()) {
            Log log = f57345b;
            StringBuffer stringBuffer = new StringBuffer("getElementByIdUsingDOM() Search for ID ");
            stringBuffer.append(str);
            log.debug(stringBuffer.toString());
        }
        return document.getElementById(str);
    }

    private static Element c(Document document, String str) {
        WeakHashMap weakHashMap;
        WeakReference weakReference;
        if (f57345b.isDebugEnabled()) {
            Log log = f57345b;
            StringBuffer stringBuffer = new StringBuffer("getElementByIdType() Search for ID ");
            stringBuffer.append(str);
            log.debug(stringBuffer.toString());
        }
        synchronized (f57346c) {
            weakHashMap = (WeakHashMap) f57346c.get(document);
        }
        if (weakHashMap == null || (weakReference = (WeakReference) weakHashMap.get(str)) == null) {
            return null;
        }
        return (Element) weakReference.get();
    }

    private static int a(Node node, String str, Element[] elementArr) {
        Node parentNode = null;
        Node nextSibling = null;
        while (true) {
            short nodeType = node.getNodeType();
            if (nodeType != 1) {
                node = (nodeType == 9 || nodeType == 11) ? node.getFirstChild() : nextSibling;
            } else {
                Element element = (Element) node;
                if (a(element, str, elementArr) == 1) {
                    return 1;
                }
                Node firstChild = node.getFirstChild();
                if (firstChild != null) {
                    parentNode = element;
                } else if (parentNode != null) {
                    node = node.getNextSibling();
                }
                node = firstChild;
            }
            while (node == null && parentNode != null) {
                node = parentNode.getNextSibling();
                parentNode = parentNode.getParentNode();
                if (parentNode != null && 1 != parentNode.getNodeType()) {
                    parentNode = null;
                }
            }
            if (node == null) {
                return 1;
            }
            nextSibling = node.getNextSibling();
        }
    }

    public static Class a(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw a.g(e2);
        }
    }

    public static Element a(Document document, String str) {
        Log log;
        StringBuffer stringBuffer;
        Element elementC = c(document, str);
        if (elementC != null) {
            log = f57345b;
            stringBuffer = new StringBuffer("I could find an Element using the simple getElementByIdType method: ");
        } else {
            elementC = b(document, str);
            if (elementC == null) {
                Element elementA = a((Node) document, str);
                if (elementA == null) {
                    return null;
                }
                a(elementA, str);
                return elementA;
            }
            log = f57345b;
            stringBuffer = new StringBuffer("I could find an Element using the simple getElementByIdUsingDOM method: ");
        }
        stringBuffer.append(elementC.getTagName());
        log.debug(stringBuffer.toString());
        return elementC;
    }

    private static Element a(Node node, String str) {
        int i2 = f57348e + 1;
        Element[] elementArr = new Element[i2];
        a(node, str, elementArr);
        for (int i3 = 0; i3 < i2; i3++) {
            Element element = elementArr[i3];
            if (element != null) {
                return element;
            }
        }
        return null;
    }

    public static void a(Element element, String str) {
        WeakHashMap weakHashMap;
        Document ownerDocument = element.getOwnerDocument();
        synchronized (f57346c) {
            try {
                weakHashMap = (WeakHashMap) f57346c.get(ownerDocument);
                if (weakHashMap == null) {
                    weakHashMap = new WeakHashMap();
                    f57346c.put(ownerDocument, weakHashMap);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        weakHashMap.put(str, new WeakReference(element));
    }
}
