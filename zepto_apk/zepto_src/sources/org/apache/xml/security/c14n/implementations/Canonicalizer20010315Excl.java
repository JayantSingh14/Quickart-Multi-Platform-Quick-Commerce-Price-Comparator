package org.apache.xml.security.c14n.implementations;

import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import org.apache.xml.security.c14n.CanonicalizationException;
import org.apache.xml.security.c14n.helper.C14nHelper;
import org.apache.xml.security.signature.XMLSignatureInput;
import org.apache.xml.security.transforms.params.InclusiveNamespaces;
import org.apache.xml.security.utils.XMLUtils;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

/* loaded from: classes5.dex */
public abstract class Canonicalizer20010315Excl extends CanonicalizerBase {

    /* renamed from: b, reason: collision with root package name */
    TreeSet f57148b;

    /* renamed from: c, reason: collision with root package name */
    final SortedSet f57149c;

    public Canonicalizer20010315Excl(boolean z) {
        super(z);
        this.f57148b = new TreeSet();
        this.f57149c = new TreeSet(CanonicalizerBase.f57155g);
    }

    @Override // org.apache.xml.security.c14n.implementations.CanonicalizerBase
    public Iterator a(Element element, NameSpaceSymbTable nameSpaceSymbTable) throws CanonicalizationException, DOMException {
        NamedNodeMap attributes;
        int length;
        String prefix;
        SortedSet sortedSet = this.f57149c;
        sortedSet.clear();
        int i2 = 0;
        if (element.hasAttributes()) {
            attributes = element.getAttributes();
            length = attributes.getLength();
        } else {
            attributes = null;
            length = 0;
        }
        SortedSet sortedSet2 = (SortedSet) this.f57148b.clone();
        while (true) {
            String str = "xmlns";
            if (i2 >= length) {
                if (element.getNamespaceURI() != null && (prefix = element.getPrefix()) != null && prefix.length() != 0) {
                    str = prefix;
                }
                sortedSet2.add(str);
                Iterator it = sortedSet2.iterator();
                while (it.hasNext()) {
                    Attr attrA = nameSpaceSymbTable.a((String) it.next());
                    if (attrA != null) {
                        sortedSet.add(attrA);
                    }
                }
                return sortedSet.iterator();
            }
            Attr attr = (Attr) attributes.item(i2);
            if ("http://www.w3.org/2000/xmlns/".equals(attr.getNamespaceURI())) {
                String localName = attr.getLocalName();
                String nodeValue = attr.getNodeValue();
                if ((!"xml".equals(localName) || !"http://www.w3.org/XML/1998/namespace".equals(nodeValue)) && nameSpaceSymbTable.a(localName, nodeValue, attr) && C14nHelper.a(nodeValue)) {
                    throw new CanonicalizationException("c14n.Canonicalizer.RelativeNamespace", new Object[]{element.getTagName(), localName, attr.getNodeValue()});
                }
            } else {
                String prefix2 = attr.getPrefix();
                if (prefix2 != null && !prefix2.equals("xml") && !prefix2.equals("xmlns")) {
                    sortedSet2.add(prefix2);
                }
                sortedSet.add(attr);
            }
            i2++;
        }
    }

    @Override // org.apache.xml.security.c14n.implementations.CanonicalizerBase
    public final Iterator b(Element element, NameSpaceSymbTable nameSpaceSymbTable) throws CanonicalizationException, DOMException {
        NamedNodeMap attributes;
        int length;
        String prefix;
        Node nodeB;
        SortedSet sortedSet = this.f57149c;
        sortedSet.clear();
        if (element.hasAttributes()) {
            attributes = element.getAttributes();
            length = attributes.getLength();
        } else {
            attributes = null;
            length = 0;
        }
        boolean z = a(element, nameSpaceSymbTable.f()) == 1;
        Set set = z ? (Set) this.f57148b.clone() : null;
        for (int i2 = 0; i2 < length; i2++) {
            Attr attr = (Attr) attributes.item(i2);
            if ("http://www.w3.org/2000/xmlns/".equals(attr.getNamespaceURI())) {
                String localName = attr.getLocalName();
                if (!z || c(attr) || "xmlns".equals(localName)) {
                    String nodeValue = attr.getNodeValue();
                    if (!z && c(attr) && this.f57148b.contains(localName) && !nameSpaceSymbTable.e(localName) && (nodeB = nameSpaceSymbTable.b(localName, nodeValue, attr)) != null) {
                        sortedSet.add(nodeB);
                        if (C14nHelper.a(attr)) {
                            throw new CanonicalizationException("c14n.Canonicalizer.RelativeNamespace", new Object[]{element.getTagName(), localName, attr.getNodeValue()});
                        }
                    }
                    if (nameSpaceSymbTable.a(localName, nodeValue, attr) && C14nHelper.a(nodeValue)) {
                        throw new CanonicalizationException("c14n.Canonicalizer.RelativeNamespace", new Object[]{element.getTagName(), localName, attr.getNodeValue()});
                    }
                } else {
                    nameSpaceSymbTable.d(localName);
                }
            } else if (c(attr) && z) {
                String prefix2 = attr.getPrefix();
                if (prefix2 != null && !prefix2.equals("xml") && !prefix2.equals("xmlns")) {
                    set.add(prefix2);
                }
                sortedSet.add(attr);
            }
        }
        if (z) {
            Attr attributeNodeNS = element.getAttributeNodeNS("http://www.w3.org/2000/xmlns/", "xmlns");
            if (attributeNodeNS != null && !c(attributeNodeNS)) {
                nameSpaceSymbTable.a("xmlns", "", CanonicalizerBase.f57157i);
            }
            if (element.getNamespaceURI() == null || (prefix = element.getPrefix()) == null || prefix.length() == 0) {
                set.add("xmlns");
            } else {
                set.add(prefix);
            }
            Iterator it = set.iterator();
            while (it.hasNext()) {
                Attr attrA = nameSpaceSymbTable.a((String) it.next());
                if (attrA != null) {
                    sortedSet.add(attrA);
                }
            }
        }
        return sortedSet.iterator();
    }

    @Override // org.apache.xml.security.c14n.implementations.CanonicalizerBase
    public void a(XMLSignatureInput xMLSignatureInput) throws DOMException {
        if (!xMLSignatureInput.a() || this.f57148b.isEmpty()) {
            return;
        }
        XMLUtils.a(xMLSignatureInput.m() != null ? XMLUtils.b(xMLSignatureInput.m()) : XMLUtils.a(xMLSignatureInput.b()));
    }

    public byte[] a(XMLSignatureInput xMLSignatureInput, String str) {
        this.f57148b = (TreeSet) InclusiveNamespaces.a(str);
        return super.b(xMLSignatureInput);
    }

    @Override // org.apache.xml.security.c14n.implementations.CanonicalizerBase, org.apache.xml.security.c14n.CanonicalizerSpi
    public byte[] a(Node node) {
        return a(node, "", (Node) null);
    }

    @Override // org.apache.xml.security.c14n.CanonicalizerSpi
    public byte[] a(Node node, String str) {
        return a(node, str, (Node) null);
    }

    public byte[] a(Node node, String str, Node node2) {
        this.f57148b = (TreeSet) InclusiveNamespaces.a(str);
        return super.a(node, node2);
    }
}
