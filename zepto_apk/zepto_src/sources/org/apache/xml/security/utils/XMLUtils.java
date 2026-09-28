package org.apache.xml.security.utils;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

/* loaded from: classes5.dex */
public class XMLUtils {

    /* renamed from: c, reason: collision with root package name */
    private static boolean f57370c = ((Boolean) AccessController.doPrivileged(new PrivilegedAction() { // from class: org.apache.xml.security.utils.XMLUtils.1
        @Override // java.security.PrivilegedAction
        public Object run() {
            return Boolean.valueOf(Boolean.getBoolean("org.apache.xml.security.ignoreLineBreaks"));
        }
    })).booleanValue();

    /* renamed from: a, reason: collision with root package name */
    static String f57368a = null;

    /* renamed from: d, reason: collision with root package name */
    private static Map f57371d = Collections.synchronizedMap(new HashMap());

    /* renamed from: b, reason: collision with root package name */
    static String f57369b = null;

    private XMLUtils() {
    }

    public static String a(Element element) {
        StringBuffer stringBuffer = new StringBuffer();
        NodeList childNodes = element.getChildNodes();
        int length = childNodes.getLength();
        for (int i2 = 0; i2 < length; i2++) {
            Node nodeItem = childNodes.item(i2);
            if (nodeItem.getNodeType() == 3) {
                stringBuffer.append(((Text) nodeItem).getData());
            }
        }
        return stringBuffer.toString();
    }

    public static Document b(Node node) {
        if (node.getNodeType() == 9) {
            return (Document) node;
        }
        try {
            return node.getOwnerDocument();
        } catch (NullPointerException e2) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(I18n.a("endorsed.jdk1.4.0"));
            stringBuffer.append(" Original message was \"");
            stringBuffer.append(e2.getMessage());
            stringBuffer.append("\"");
            throw new NullPointerException(stringBuffer.toString());
        }
    }

    private static void c(Node node) throws DOMException {
        Node parentNode = null;
        Node nextSibling = null;
        while (true) {
            short nodeType = node.getNodeType();
            if (nodeType == 1) {
                Element element = (Element) node;
                if (element.hasChildNodes()) {
                    if (element.hasAttributes()) {
                        NamedNodeMap attributes = element.getAttributes();
                        int length = attributes.getLength();
                        for (Node firstChild = element.getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
                            if (firstChild.getNodeType() == 1) {
                                Element element2 = (Element) firstChild;
                                for (int i2 = 0; i2 < length; i2++) {
                                    Attr attr = (Attr) attributes.item(i2);
                                    if ("http://www.w3.org/2000/xmlns/".equals(attr.getNamespaceURI()) && !element2.hasAttributeNS("http://www.w3.org/2000/xmlns/", attr.getLocalName())) {
                                        element2.setAttributeNS("http://www.w3.org/2000/xmlns/", attr.getName(), attr.getNodeValue());
                                    }
                                }
                            }
                        }
                    }
                    parentNode = node;
                    node = node.getFirstChild();
                }
                node = nextSibling;
            } else if (nodeType == 5 || nodeType == 9) {
                parentNode = node;
                node = node.getFirstChild();
            } else {
                node = nextSibling;
            }
            while (node == null && parentNode != null) {
                node = parentNode.getNextSibling();
                parentNode = parentNode.getParentNode();
            }
            if (node == null) {
                return;
            } else {
                nextSibling = node.getNextSibling();
            }
        }
    }

    public static Document a(Set set) {
        Iterator it = set.iterator();
        NullPointerException e2 = null;
        while (it.hasNext()) {
            Node node = (Node) it.next();
            short nodeType = node.getNodeType();
            if (nodeType == 9) {
                return (Document) node;
            }
            try {
                return nodeType == 2 ? ((Attr) node).getOwnerElement().getOwnerDocument() : node.getOwnerDocument();
            } catch (NullPointerException e3) {
                e2 = e3;
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(I18n.a("endorsed.jdk1.4.0"));
        stringBuffer.append(" Original message was \"");
        stringBuffer.append(e2 == null ? "" : e2.getMessage());
        stringBuffer.append("\"");
        throw new NullPointerException(stringBuffer.toString());
    }

    public static Text b(Node node, String str, int i2) {
        Element elementA = a(node, str, i2);
        if (elementA == null) {
            return null;
        }
        Node firstChild = elementA.getFirstChild();
        while (firstChild != null && firstChild.getNodeType() != 3) {
            firstChild = firstChild.getNextSibling();
        }
        return (Text) firstChild;
    }

    public static Element a(Document document, String str) {
        if (document == null) {
            throw new RuntimeException("Document is null");
        }
        String str2 = f57368a;
        if (str2 == null || str2.length() == 0) {
            return document.createElementNS("http://www.w3.org/2000/09/xmldsig#", str);
        }
        String string = (String) f57371d.get(str);
        if (string == null) {
            StringBuffer stringBuffer = new StringBuffer(f57368a);
            stringBuffer.append(':');
            stringBuffer.append(str);
            string = stringBuffer.toString();
            f57371d.put(str, string);
        }
        return document.createElementNS("http://www.w3.org/2000/09/xmldsig#", string);
    }

    public static void b(Element element) throws DOMException {
        if (f57370c) {
            return;
        }
        element.appendChild(element.getOwnerDocument().createTextNode(StringUtils.LF));
    }

    public static Element a(Node node) {
        while (node != null && node.getNodeType() != 1) {
            node = node.getNextSibling();
        }
        return (Element) node;
    }

    public static final void b(Node node, Set set, Node node2, boolean z) {
        if (node == node2) {
            return;
        }
        short nodeType = node.getNodeType();
        if (nodeType != 1) {
            switch (nodeType) {
                case 8:
                    if (z) {
                        set.add(node);
                        break;
                    }
                    break;
                case 9:
                    break;
                case 10:
                    break;
                default:
                    set.add(node);
                    break;
            }
            return;
        }
        set.add(node);
        Element element = (Element) node;
        if (element.hasAttributes()) {
            NamedNodeMap attributes = element.getAttributes();
            for (int i2 = 0; i2 < attributes.getLength(); i2++) {
                set.add(attributes.item(i2));
            }
        }
        Node firstChild = node.getFirstChild();
        while (firstChild != null) {
            if (firstChild.getNodeType() == 3) {
                set.add(firstChild);
                while (firstChild != null && firstChild.getNodeType() == 3) {
                    firstChild = firstChild.getNextSibling();
                }
                if (firstChild == null) {
                    return;
                }
            }
            b(firstChild, set, node2, z);
            firstChild = firstChild.getNextSibling();
        }
    }

    public static Element a(Node node, String str, int i2) {
        while (node != null) {
            if ("http://www.w3.org/2000/09/xmldsig#".equals(node.getNamespaceURI()) && node.getLocalName().equals(str)) {
                if (i2 == 0) {
                    return (Element) node;
                }
                i2--;
            }
            node = node.getNextSibling();
        }
        return null;
    }

    public static Element a(Node node, String str, String str2, int i2) {
        while (node != null) {
            if (node.getNamespaceURI() != null && node.getNamespaceURI().equals(str) && node.getLocalName().equals(str2)) {
                if (i2 == 0) {
                    return (Element) node;
                }
                i2--;
            }
            node = node.getNextSibling();
        }
        return null;
    }

    public static void a(Document document) throws DOMException {
        Element documentElement = document.getDocumentElement();
        if (documentElement.getAttributeNodeNS("http://www.w3.org/2000/xmlns/", "xmlns") == null) {
            documentElement.setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns", "");
        }
        c(document);
    }

    public static void a(Node node, Set set, Node node2, boolean z) {
        if (node2 == null || !a(node2, node)) {
            b(node, set, node2, z);
        }
    }

    public static boolean a() {
        return f57370c;
    }

    public static boolean a(Node node, Node node2) {
        if (node == node2) {
            return true;
        }
        while (node2 != null) {
            if (node2 == node) {
                return true;
            }
            node2 = node2.getNodeType() == 2 ? ((Attr) node2).getOwnerElement() : node2.getParentNode();
        }
        return false;
    }

    public static Element[] a(Node node, String str) {
        return a(node, "http://www.w3.org/2000/09/xmldsig#", str);
    }

    public static Element[] a(Node node, String str, String str2) {
        int i2 = 20;
        Element[] elementArr = new Element[20];
        int i3 = 0;
        while (node != null) {
            if (node.getNamespaceURI() != null && node.getNamespaceURI().equals(str) && node.getLocalName().equals(str2)) {
                int i4 = i3 + 1;
                elementArr[i3] = (Element) node;
                if (i2 <= i4) {
                    int i5 = i2 << 2;
                    Element[] elementArr2 = new Element[i5];
                    System.arraycopy(elementArr, 0, elementArr2, 0, i2);
                    i2 = i5;
                    i3 = i4;
                    elementArr = elementArr2;
                } else {
                    i3 = i4;
                }
            }
            node = node.getNextSibling();
        }
        Element[] elementArr3 = new Element[i3];
        System.arraycopy(elementArr, 0, elementArr3, 0, i3);
        return elementArr3;
    }
}
