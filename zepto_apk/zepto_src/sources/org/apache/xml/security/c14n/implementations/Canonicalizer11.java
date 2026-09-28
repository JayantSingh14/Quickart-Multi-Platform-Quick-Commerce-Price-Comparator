package org.apache.xml.security.c14n.implementations;

import androidx.fragment.app.e;
import com.google.android.gms.internal.pal.a;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
public abstract class Canonicalizer11 extends CanonicalizerBase {

    /* renamed from: d, reason: collision with root package name */
    static Log f57126d;

    /* renamed from: f, reason: collision with root package name */
    static Class f57127f;

    /* renamed from: b, reason: collision with root package name */
    boolean f57128b;

    /* renamed from: c, reason: collision with root package name */
    final SortedSet f57129c;

    /* renamed from: e, reason: collision with root package name */
    XmlAttrStack f57130e;

    static {
        Class clsA = f57127f;
        if (clsA == null) {
            clsA = a("org.apache.xml.security.c14n.implementations.Canonicalizer11");
            f57127f = clsA;
        }
        f57126d = LogFactory.getLog(clsA.getName());
    }

    public Canonicalizer11(boolean z) {
        super(z);
        this.f57128b = true;
        this.f57129c = new TreeSet(CanonicalizerBase.f57155g);
        this.f57130e = new XmlAttrStack();
    }

    public static Class a(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw a.g(e2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00a9 A[PHI: r13
      0x00a9: PHI (r13v13 java.lang.String) = (r13v12 java.lang.String), (r13v20 java.lang.String) binds: [B:31:0x00a7, B:49:0x00fe] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b7 A[PHI: r13
      0x00b7: PHI (r13v14 java.lang.String) = (r13v12 java.lang.String), (r13v20 java.lang.String) binds: [B:34:0x00b5, B:52:0x0109] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c5 A[PHI: r13
      0x00c5: PHI (r13v15 java.lang.String) = (r13v12 java.lang.String), (r13v20 java.lang.String) binds: [B:37:0x00c3, B:55:0x0114] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00da A[PHI: r0 r13
      0x00da: PHI (r0v6 java.lang.StringBuffer) = (r0v5 java.lang.StringBuffer), (r0v9 java.lang.StringBuffer) binds: [B:42:0x00d8, B:60:0x0126] A[DONT_GENERATE, DONT_INLINE]
      0x00da: PHI (r13v16 java.lang.String) = (r13v12 java.lang.String), (r13v20 java.lang.String) binds: [B:42:0x00d8, B:60:0x0126] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00df A[PHI: r4 r13
      0x00df: PHI (r4v14 int) = (r4v11 int), (r4v18 int) binds: [B:40:0x00cd, B:58:0x011b] A[DONT_GENERATE, DONT_INLINE]
      0x00df: PHI (r13v19 java.lang.String) = (r13v12 java.lang.String), (r13v20 java.lang.String) binds: [B:40:0x00cd, B:58:0x011b] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String b(java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 411
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xml.security.c14n.implementations.Canonicalizer11.b(java.lang.String):java.lang.String");
    }

    @Override // org.apache.xml.security.c14n.implementations.CanonicalizerBase
    public void c(Element element, NameSpaceSymbTable nameSpaceSymbTable) throws DOMException {
        if (element.hasAttributes()) {
            this.f57130e.a(-1);
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
                } else if (!"http://www.w3.org/XML/1998/namespace".equals(attr.getNamespaceURI())) {
                    this.f57130e.a(attr);
                }
            }
        }
    }

    private static String b(String str, String str2) {
        String strB;
        Object scheme;
        String authority;
        String query;
        String strB2;
        String str3;
        String strB3;
        if (str != null) {
            if (str.endsWith("..")) {
                str = str.concat("/");
            }
            URI uri = new URI(str);
            scheme = uri.getScheme();
            authority = uri.getAuthority();
            strB = uri.getPath();
            query = uri.getQuery();
            uri.getFragment();
        } else {
            strB = "";
            scheme = null;
            authority = null;
            query = null;
        }
        URI uri2 = new URI(str2);
        String scheme2 = uri2.getScheme();
        String authority2 = uri2.getAuthority();
        String path = uri2.getPath();
        String query2 = uri2.getQuery();
        String str4 = (scheme2 == null || !scheme2.equals(scheme)) ? scheme2 : null;
        if (str4 != null) {
            strB3 = b(path);
            str3 = str4;
        } else {
            if (authority2 != null) {
                strB2 = b(path);
                authority = authority2;
            } else {
                if (path.length() == 0) {
                    if (query2 != null) {
                    }
                    strB2 = strB;
                    query2 = query;
                } else {
                    if (!path.startsWith("/")) {
                        if (authority == null || strB.length() != 0) {
                            int iLastIndexOf = strB.lastIndexOf(47);
                            if (iLastIndexOf != -1) {
                                StringBuffer stringBuffer = new StringBuffer();
                                stringBuffer.append(strB.substring(0, iLastIndexOf + 1));
                                stringBuffer.append(path);
                                path = stringBuffer.toString();
                            }
                        } else {
                            path = "/".concat(path);
                        }
                    }
                    strB = b(path);
                }
                query = query2;
                strB2 = strB;
                query2 = query;
            }
            str3 = scheme;
            strB3 = strB2;
            authority2 = authority;
        }
        return new URI(str3, authority2, strB3, query2, null).toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x005a  */
    @Override // org.apache.xml.security.c14n.implementations.CanonicalizerBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.Iterator b(org.w3c.dom.Element r13, org.apache.xml.security.c14n.implementations.NameSpaceSymbTable r14) throws org.apache.xml.security.c14n.CanonicalizationException, org.w3c.dom.DOMException {
        /*
            r12 = this;
            org.apache.xml.security.c14n.implementations.Canonicalizer11$XmlAttrStack r0 = r12.f57130e
            int r1 = r14.f()
            r0.a(r1)
            int r0 = r14.f()
            int r0 = r12.a(r13, r0)
            r1 = 0
            r2 = 1
            if (r0 != r2) goto L16
            goto L17
        L16:
            r2 = r1
        L17:
            boolean r0 = r13.hasAttributes()
            r3 = 0
            if (r0 == 0) goto L27
            org.w3c.dom.NamedNodeMap r0 = r13.getAttributes()
            int r4 = r0.getLength()
            goto L29
        L27:
            r4 = r1
            r0 = r3
        L29:
            java.util.SortedSet r5 = r12.f57129c
            r5.clear()
        L2e:
            java.lang.String r6 = "http://www.w3.org/2000/xmlns/"
            java.lang.String r7 = "xmlns"
            if (r1 >= r4) goto Lc4
            org.w3c.dom.Node r8 = r0.item(r1)
            org.w3c.dom.Attr r8 = (org.w3c.dom.Attr) r8
            java.lang.String r9 = r8.getNamespaceURI()
            boolean r6 = r6.equals(r9)
            java.lang.String r10 = "http://www.w3.org/XML/1998/namespace"
            if (r6 != 0) goto L67
            boolean r6 = r10.equals(r9)
            if (r6 == 0) goto L64
            java.lang.String r6 = r8.getLocalName()
            java.lang.String r7 = "id"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L5e
            if (r2 == 0) goto Lc0
        L5a:
            r5.add(r8)
            goto Lc0
        L5e:
            org.apache.xml.security.c14n.implementations.Canonicalizer11$XmlAttrStack r6 = r12.f57130e
            r6.a(r8)
            goto Lc0
        L64:
            if (r2 == 0) goto Lc0
            goto L5a
        L67:
            java.lang.String r6 = r8.getLocalName()
            java.lang.String r9 = r8.getValue()
            java.lang.String r11 = "xml"
            boolean r11 = r11.equals(r6)
            if (r11 == 0) goto L7e
            boolean r10 = r10.equals(r9)
            if (r10 == 0) goto L7e
            goto Lc0
        L7e:
            boolean r10 = r12.c(r8)
            if (r10 == 0) goto Lb1
            if (r2 != 0) goto L8d
            boolean r7 = r14.e(r6)
            if (r7 == 0) goto L8d
            goto Lc0
        L8d:
            org.w3c.dom.Node r7 = r14.b(r6, r9, r8)
            if (r7 == 0) goto Lc0
            r5.add(r7)
            boolean r7 = org.apache.xml.security.c14n.helper.C14nHelper.a(r8)
            if (r7 != 0) goto L9d
            goto Lc0
        L9d:
            java.lang.String r13 = r13.getTagName()
            java.lang.String r14 = r8.getNodeValue()
            java.lang.Object[] r13 = new java.lang.Object[]{r13, r6, r14}
            org.apache.xml.security.c14n.CanonicalizationException r14 = new org.apache.xml.security.c14n.CanonicalizationException
            java.lang.String r0 = "c14n.Canonicalizer.RelativeNamespace"
            r14.<init>(r0, r13)
            throw r14
        Lb1:
            if (r2 == 0) goto Lbd
            boolean r7 = r7.equals(r6)
            if (r7 != 0) goto Lbd
            r14.c(r6)
            goto Lc0
        Lbd:
            r14.a(r6, r9, r8)
        Lc0:
            int r1 = r1 + 1
            goto L2e
        Lc4:
            if (r2 == 0) goto Lec
            org.w3c.dom.Attr r13 = r13.getAttributeNodeNS(r6, r7)
            if (r13 != 0) goto Ld1
            org.w3c.dom.Attr r3 = r14.a(r7)
            goto Ldf
        Ld1:
            boolean r13 = r12.c(r13)
            if (r13 != 0) goto Ldf
            java.lang.String r13 = ""
            org.w3c.dom.Attr r0 = org.apache.xml.security.c14n.implementations.CanonicalizerBase.f57157i
            org.w3c.dom.Node r3 = r14.b(r7, r13, r0)
        Ldf:
            if (r3 == 0) goto Le4
            r5.add(r3)
        Le4:
            org.apache.xml.security.c14n.implementations.Canonicalizer11$XmlAttrStack r13 = r12.f57130e
            r13.a(r5)
            r14.a(r5)
        Lec:
            java.util.Iterator r13 = r5.iterator()
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xml.security.c14n.implementations.Canonicalizer11.b(org.w3c.dom.Element, org.apache.xml.security.c14n.implementations.NameSpaceSymbTable):java.util.Iterator");
    }

    public static class XmlAttrStack {

        /* renamed from: c, reason: collision with root package name */
        XmlsStackElement f57133c;

        /* renamed from: a, reason: collision with root package name */
        int f57131a = 0;

        /* renamed from: b, reason: collision with root package name */
        int f57132b = 0;

        /* renamed from: d, reason: collision with root package name */
        List f57134d = new ArrayList();

        public static class XmlsStackElement {

            /* renamed from: a, reason: collision with root package name */
            int f57135a;

            /* renamed from: b, reason: collision with root package name */
            boolean f57136b = false;

            /* renamed from: c, reason: collision with root package name */
            List f57137c = new ArrayList();
        }

        public void a(int i2) {
            this.f57131a = i2;
            if (i2 == -1) {
                return;
            }
            this.f57133c = null;
            while (this.f57132b >= this.f57131a) {
                List list = this.f57134d;
                list.remove(list.size() - 1);
                if (this.f57134d.size() == 0) {
                    this.f57132b = 0;
                    return;
                }
                this.f57132b = ((XmlsStackElement) e.k(1, this.f57134d)).f57135a;
            }
        }

        public void a(Collection collection) throws DOMException {
            Attr attr;
            String value;
            if (this.f57133c == null) {
                XmlsStackElement xmlsStackElement = new XmlsStackElement();
                this.f57133c = xmlsStackElement;
                int i2 = this.f57131a;
                xmlsStackElement.f57135a = i2;
                this.f57132b = i2;
                this.f57134d.add(xmlsStackElement);
            }
            int size = this.f57134d.size() - 2;
            if (size != -1) {
                XmlsStackElement xmlsStackElement2 = (XmlsStackElement) this.f57134d.get(size);
                if (!xmlsStackElement2.f57136b || xmlsStackElement2.f57135a + 1 != this.f57131a) {
                    HashMap map = new HashMap();
                    ArrayList arrayList = new ArrayList();
                    boolean z = true;
                    while (size >= 0) {
                        XmlsStackElement xmlsStackElement3 = (XmlsStackElement) this.f57134d.get(size);
                        if (xmlsStackElement3.f57136b) {
                            z = false;
                        }
                        Iterator it = xmlsStackElement3.f57137c.iterator();
                        while (it.hasNext() && z) {
                            Attr attr2 = (Attr) it.next();
                            if (attr2.getLocalName().equals("base")) {
                                if (!xmlsStackElement3.f57136b) {
                                    arrayList.add(attr2);
                                }
                            } else if (!map.containsKey(attr2.getName())) {
                                map.put(attr2.getName(), attr2);
                            }
                        }
                        size--;
                    }
                    if (!arrayList.isEmpty()) {
                        Iterator it2 = this.f57133c.f57137c.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                attr = null;
                                value = null;
                                break;
                            } else {
                                attr = (Attr) it2.next();
                                if (attr.getLocalName().equals("base")) {
                                    value = attr.getValue();
                                    break;
                                }
                            }
                        }
                        Iterator it3 = arrayList.iterator();
                        while (it3.hasNext()) {
                            Attr attr3 = (Attr) it3.next();
                            if (value == null) {
                                value = attr3.getValue();
                                attr = attr3;
                            } else {
                                try {
                                    value = Canonicalizer11.a(attr3.getValue(), value);
                                } catch (URISyntaxException e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                        if (value != null && value.length() != 0) {
                            attr.setValue(value);
                            collection.add(attr);
                        }
                    }
                    this.f57133c.f57136b = true;
                    collection.addAll(map.values());
                    return;
                }
            }
            collection.addAll(this.f57133c.f57137c);
            this.f57133c.f57136b = true;
        }

        public void a(Attr attr) {
            if (this.f57133c == null) {
                XmlsStackElement xmlsStackElement = new XmlsStackElement();
                this.f57133c = xmlsStackElement;
                xmlsStackElement.f57135a = this.f57131a;
                this.f57134d.add(xmlsStackElement);
                this.f57132b = this.f57131a;
            }
            this.f57133c.f57137c.add(attr);
        }
    }

    public static String a(String str, String str2) {
        return b(str, str2);
    }

    @Override // org.apache.xml.security.c14n.implementations.CanonicalizerBase
    public Iterator a(Element element, NameSpaceSymbTable nameSpaceSymbTable) throws CanonicalizationException, DOMException {
        Node nodeB;
        if (!element.hasAttributes() && !this.f57128b) {
            return null;
        }
        SortedSet sortedSet = this.f57129c;
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
        if (this.f57128b) {
            nameSpaceSymbTable.a(sortedSet);
            this.f57130e.a(sortedSet);
            this.f57128b = false;
        }
        return sortedSet.iterator();
    }

    private static void a(String str, String str2, String str3) {
        Log log;
        StringBuffer stringBuffer;
        if (f57126d.isDebugEnabled()) {
            Log log2 = f57126d;
            StringBuffer stringBuffer2 = new StringBuffer(StringUtils.SPACE);
            stringBuffer2.append(str);
            stringBuffer2.append(":   ");
            stringBuffer2.append(str2);
            log2.debug(stringBuffer2.toString());
            if (str2.length() == 0) {
                log = f57126d;
                stringBuffer = new StringBuffer("\t\t\t\t");
            } else {
                log = f57126d;
                stringBuffer = new StringBuffer("\t\t\t");
            }
            stringBuffer.append(str3);
            log.debug(stringBuffer.toString());
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
}
