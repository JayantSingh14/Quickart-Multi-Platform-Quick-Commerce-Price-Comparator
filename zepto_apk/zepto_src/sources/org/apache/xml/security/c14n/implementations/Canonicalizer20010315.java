package org.apache.xml.security.c14n.implementations;

import androidx.fragment.app.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import org.apache.xml.security.c14n.CanonicalizationException;
import org.apache.xml.security.c14n.helper.C14nHelper;
import org.apache.xml.security.signature.XMLSignatureInput;
import org.apache.xml.security.utils.XMLUtils;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public abstract class Canonicalizer20010315 extends CanonicalizerBase {

    /* renamed from: b, reason: collision with root package name */
    boolean f57138b;

    /* renamed from: c, reason: collision with root package name */
    final SortedSet f57139c;

    /* renamed from: d, reason: collision with root package name */
    XmlAttrStack f57140d;

    public Canonicalizer20010315(boolean z) {
        super(z);
        this.f57138b = true;
        this.f57139c = new TreeSet(CanonicalizerBase.f57155g);
        this.f57140d = new XmlAttrStack();
    }

    @Override // org.apache.xml.security.c14n.implementations.CanonicalizerBase
    public Iterator a(Element element, NameSpaceSymbTable nameSpaceSymbTable) throws CanonicalizationException {
        Node nodeB;
        if (!element.hasAttributes() && !this.f57138b) {
            return null;
        }
        SortedSet sortedSet = this.f57139c;
        sortedSet.clear();
        NamedNodeMap attributes = element.getAttributes();
        int length = attributes.getLength();
        for (int i2 = 0; i2 < length; i2++) {
            Attr attr = (Attr) attributes.item(i2);
            if ("http://www.w3.org/2000/xmlns/".equals(attr.getNamespaceURI())) {
                String localName = attr.getLocalName();
                String value = attr.getValue();
                if ((!"xml".equals(localName) || !"http://www.w3.org/XML/1998/namespace".equals(value)) && (nodeB = nameSpaceSymbTable.b(localName, value, attr)) != null) {
                    sortedSet.add(nodeB);
                    if (C14nHelper.a(attr)) {
                        throw new CanonicalizationException("c14n.Canonicalizer.RelativeNamespace", new Object[]{element.getTagName(), localName, attr.getNodeValue()});
                    }
                }
            } else {
                sortedSet.add(attr);
            }
        }
        if (this.f57138b) {
            nameSpaceSymbTable.a(sortedSet);
            this.f57140d.a(sortedSet);
            this.f57138b = false;
        }
        return sortedSet.iterator();
    }

    @Override // org.apache.xml.security.c14n.implementations.CanonicalizerBase
    public Iterator b(Element element, NameSpaceSymbTable nameSpaceSymbTable) throws CanonicalizationException, DOMException {
        int length;
        NamedNodeMap attributes;
        Node nodeB;
        this.f57140d.a(nameSpaceSymbTable.f());
        boolean z = a(element, nameSpaceSymbTable.f()) == 1;
        Node nodeB2 = null;
        if (element.hasAttributes()) {
            attributes = element.getAttributes();
            length = attributes.getLength();
        } else {
            length = 0;
            attributes = null;
        }
        SortedSet sortedSet = this.f57139c;
        sortedSet.clear();
        for (int i2 = 0; i2 < length; i2++) {
            Attr attr = (Attr) attributes.item(i2);
            String namespaceURI = attr.getNamespaceURI();
            if ("http://www.w3.org/2000/xmlns/".equals(namespaceURI)) {
                String localName = attr.getLocalName();
                String value = attr.getValue();
                if (!"xml".equals(localName) || !"http://www.w3.org/XML/1998/namespace".equals(value)) {
                    if (c(attr)) {
                        if ((z || !nameSpaceSymbTable.e(localName)) && (nodeB = nameSpaceSymbTable.b(localName, value, attr)) != null) {
                            sortedSet.add(nodeB);
                            if (C14nHelper.a(attr)) {
                                throw new CanonicalizationException("c14n.Canonicalizer.RelativeNamespace", new Object[]{element.getTagName(), localName, attr.getNodeValue()});
                            }
                        }
                    } else if (!z || "xmlns".equals(localName)) {
                        nameSpaceSymbTable.a(localName, value, attr);
                    } else {
                        nameSpaceSymbTable.c(localName);
                    }
                }
            } else if ("http://www.w3.org/XML/1998/namespace".equals(namespaceURI)) {
                this.f57140d.a(attr);
            } else if (z) {
                sortedSet.add(attr);
            }
        }
        if (z) {
            Node attributeNodeNS = element.getAttributeNodeNS("http://www.w3.org/2000/xmlns/", "xmlns");
            if (attributeNodeNS == null) {
                nodeB2 = nameSpaceSymbTable.a("xmlns");
            } else if (!c(attributeNodeNS)) {
                nodeB2 = nameSpaceSymbTable.b("xmlns", "", CanonicalizerBase.f57157i);
            }
            if (nodeB2 != null) {
                sortedSet.add(nodeB2);
            }
            this.f57140d.a(sortedSet);
            nameSpaceSymbTable.a(sortedSet);
        }
        return sortedSet.iterator();
    }

    @Override // org.apache.xml.security.c14n.implementations.CanonicalizerBase
    public void c(Element element, NameSpaceSymbTable nameSpaceSymbTable) throws DOMException {
        if (element.hasAttributes()) {
            this.f57140d.a(-1);
            NamedNodeMap attributes = element.getAttributes();
            int length = attributes.getLength();
            for (int i2 = 0; i2 < length; i2++) {
                Attr attr = (Attr) attributes.item(i2);
                if ("http://www.w3.org/2000/xmlns/".equals(attr.getNamespaceURI())) {
                    String localName = attr.getLocalName();
                    String nodeValue = attr.getNodeValue();
                    if (!"xml".equals(localName) || !"http://www.w3.org/XML/1998/namespace".equals(nodeValue)) {
                        nameSpaceSymbTable.a(localName, nodeValue, attr);
                    }
                } else if ("http://www.w3.org/XML/1998/namespace".equals(attr.getNamespaceURI())) {
                    this.f57140d.a(attr);
                }
            }
        }
    }

    @Override // org.apache.xml.security.c14n.implementations.CanonicalizerBase
    public void a(XMLSignatureInput xMLSignatureInput) throws DOMException {
        if (xMLSignatureInput.a()) {
            XMLUtils.a(xMLSignatureInput.m() != null ? XMLUtils.b(xMLSignatureInput.m()) : XMLUtils.a(xMLSignatureInput.b()));
        }
    }

    @Override // org.apache.xml.security.c14n.CanonicalizerSpi
    public byte[] a(Node node, String str) throws CanonicalizationException {
        throw new CanonicalizationException("c14n.Canonicalizer.UnsupportedOperation");
    }

    public static class XmlAttrStack {

        /* renamed from: c, reason: collision with root package name */
        XmlsStackElement f57143c;

        /* renamed from: a, reason: collision with root package name */
        int f57141a = 0;

        /* renamed from: b, reason: collision with root package name */
        int f57142b = 0;

        /* renamed from: d, reason: collision with root package name */
        List f57144d = new ArrayList();

        public static class XmlsStackElement {

            /* renamed from: a, reason: collision with root package name */
            int f57145a;

            /* renamed from: b, reason: collision with root package name */
            boolean f57146b = false;

            /* renamed from: c, reason: collision with root package name */
            List f57147c = new ArrayList();
        }

        public void a(int i2) {
            this.f57141a = i2;
            if (i2 == -1) {
                return;
            }
            this.f57143c = null;
            while (this.f57142b >= this.f57141a) {
                List list = this.f57144d;
                list.remove(list.size() - 1);
                if (this.f57144d.size() == 0) {
                    this.f57142b = 0;
                    return;
                }
                this.f57142b = ((XmlsStackElement) e.k(1, this.f57144d)).f57145a;
            }
        }

        public void a(Collection collection) {
            int size = this.f57144d.size() - 1;
            if (this.f57143c == null) {
                XmlsStackElement xmlsStackElement = new XmlsStackElement();
                this.f57143c = xmlsStackElement;
                int i2 = this.f57141a;
                xmlsStackElement.f57145a = i2;
                this.f57142b = i2;
                this.f57144d.add(xmlsStackElement);
            }
            if (size != -1) {
                XmlsStackElement xmlsStackElement2 = (XmlsStackElement) this.f57144d.get(size);
                if (!xmlsStackElement2.f57146b || xmlsStackElement2.f57145a + 1 != this.f57141a) {
                    HashMap map = new HashMap();
                    while (size >= 0) {
                        for (Attr attr : ((XmlsStackElement) this.f57144d.get(size)).f57147c) {
                            if (!map.containsKey(attr.getName())) {
                                map.put(attr.getName(), attr);
                            }
                        }
                        size--;
                    }
                    this.f57143c.f57146b = true;
                    collection.addAll(map.values());
                    return;
                }
            }
            collection.addAll(this.f57143c.f57147c);
            this.f57143c.f57146b = true;
        }

        public void a(Attr attr) {
            if (this.f57143c == null) {
                XmlsStackElement xmlsStackElement = new XmlsStackElement();
                this.f57143c = xmlsStackElement;
                xmlsStackElement.f57145a = this.f57141a;
                this.f57144d.add(xmlsStackElement);
                this.f57142b = this.f57141a;
            }
            this.f57143c.f57147c.add(attr);
        }
    }
}
