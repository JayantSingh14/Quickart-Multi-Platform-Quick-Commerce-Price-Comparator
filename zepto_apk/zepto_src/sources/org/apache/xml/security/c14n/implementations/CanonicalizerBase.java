package org.apache.xml.security.c14n.implementations;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.xml.security.c14n.CanonicalizationException;
import org.apache.xml.security.c14n.CanonicalizerSpi;
import org.apache.xml.security.c14n.helper.AttrCompare;
import org.apache.xml.security.signature.NodeFilter;
import org.apache.xml.security.signature.XMLSignatureInput;
import org.apache.xml.security.utils.UnsyncByteArrayOutputStream;
import org.apache.xml.security.utils.XMLUtils;
import org.w3c.dom.Attr;
import org.w3c.dom.Comment;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.ProcessingInstruction;
import org.xml.sax.SAXException;

/* loaded from: classes5.dex */
public abstract class CanonicalizerBase extends CanonicalizerSpi {

    /* renamed from: i, reason: collision with root package name */
    protected static final Attr f57157i;

    /* renamed from: j, reason: collision with root package name */
    List f57158j;

    /* renamed from: k, reason: collision with root package name */
    boolean f57159k;

    /* renamed from: l, reason: collision with root package name */
    Set f57160l = null;

    /* renamed from: m, reason: collision with root package name */
    Node f57161m = null;
    OutputStream n = new UnsyncByteArrayOutputStream();

    /* renamed from: b, reason: collision with root package name */
    private static final byte[] f57150b = {63, 62};

    /* renamed from: c, reason: collision with root package name */
    private static final byte[] f57151c = {60, 63};

    /* renamed from: d, reason: collision with root package name */
    private static final byte[] f57152d = {45, 45, 62};

    /* renamed from: e, reason: collision with root package name */
    private static final byte[] f57153e = {60, 33, 45, 45};

    /* renamed from: f, reason: collision with root package name */
    private static final byte[] f57154f = {38, 35, 120, 65, 59};
    private static final byte[] o = {38, 35, 120, 57, 59};
    private static final byte[] p = {38, 113, 117, 111, 116, 59};
    private static final byte[] q = {38, 35, 120, 68, 59};
    private static final byte[] r = {38, 103, 116, 59};
    private static final byte[] s = {38, 108, 116, 59};
    private static final byte[] t = {60, 47};
    private static final byte[] u = {38, 97, 109, 112, 59};

    /* renamed from: g, reason: collision with root package name */
    static final AttrCompare f57155g = new AttrCompare();

    /* renamed from: h, reason: collision with root package name */
    static final byte[] f57156h = {61, 34};

    static {
        try {
            Attr attrCreateAttributeNS = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument().createAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns");
            f57157i = attrCreateAttributeNS;
            attrCreateAttributeNS.setValue("");
        } catch (Exception e2) {
            StringBuffer stringBuffer = new StringBuffer("Unable to create nullNode");
            stringBuffer.append(e2);
            throw new RuntimeException(stringBuffer.toString());
        }
    }

    public CanonicalizerBase(boolean z) {
        this.f57159k = z;
    }

    public int a(Node node, int i2) {
        List list = this.f57158j;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int iA = ((NodeFilter) it.next()).a(node, i2);
                if (iA != 1) {
                    return iA;
                }
            }
        }
        Set set = this.f57160l;
        return (set == null || set.contains(node)) ? 1 : 0;
    }

    public abstract Iterator a(Element element, NameSpaceSymbTable nameSpaceSymbTable);

    public abstract void a(XMLSignatureInput xMLSignatureInput);

    public int b(Node node) {
        List list = this.f57158j;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int iA = ((NodeFilter) it.next()).a(node);
                if (iA != 1) {
                    return iA;
                }
            }
        }
        Set set = this.f57160l;
        return (set == null || set.contains(node)) ? 1 : 0;
    }

    public abstract Iterator b(Element element, NameSpaceSymbTable nameSpaceSymbTable);

    public void c(Element element, NameSpaceSymbTable nameSpaceSymbTable) throws DOMException {
        if (element.hasAttributes()) {
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
                }
            }
        }
    }

    public final void d(Element element, NameSpaceSymbTable nameSpaceSymbTable) throws DOMException {
        ArrayList arrayList = new ArrayList(10);
        Node parentNode = element.getParentNode();
        if (parentNode == null || 1 != parentNode.getNodeType()) {
            return;
        }
        do {
            Element element2 = (Element) parentNode;
            arrayList.add(element2);
            parentNode = element2.getParentNode();
            if (parentNode == null) {
                break;
            }
        } while (1 == parentNode.getNodeType());
        ListIterator listIterator = arrayList.listIterator(arrayList.size());
        while (listIterator.hasPrevious()) {
            c((Element) listIterator.previous(), nameSpaceSymbTable);
        }
        Attr attrB = nameSpaceSymbTable.b("xmlns");
        if (attrB == null || !"".equals(attrB.getValue())) {
            return;
        }
        nameSpaceSymbTable.b("xmlns", "", f57157i);
    }

    private byte[] d(Node node) throws CanonicalizationException, DOMException, IOException {
        try {
            b(node, node);
            this.n.close();
            OutputStream outputStream = this.n;
            if (outputStream instanceof ByteArrayOutputStream) {
                byte[] byteArray = ((ByteArrayOutputStream) outputStream).toByteArray();
                if (!this.f57125a) {
                    return byteArray;
                }
                ((ByteArrayOutputStream) this.n).reset();
                return byteArray;
            }
            if (!(outputStream instanceof UnsyncByteArrayOutputStream)) {
                return null;
            }
            byte[] bArrA = ((UnsyncByteArrayOutputStream) outputStream).a();
            if (this.f57125a) {
                ((UnsyncByteArrayOutputStream) this.n).b();
            }
            return bArrA;
        } catch (UnsupportedEncodingException e2) {
            throw new CanonicalizationException("empty", e2);
        } catch (IOException e3) {
            throw new CanonicalizationException("empty", e3);
        }
    }

    @Override // org.apache.xml.security.c14n.CanonicalizerSpi
    public void a(OutputStream outputStream) {
        this.n = outputStream;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:62:0x0111
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:225)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:195)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:62)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.processFallThroughCases(SwitchRegionMaker.java:105)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:64)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:281)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:64)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:101)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void b(org.w3c.dom.Node r17, org.w3c.dom.Node r18) throws org.apache.xml.security.c14n.CanonicalizationException, org.w3c.dom.DOMException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 374
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xml.security.c14n.implementations.CanonicalizerBase.b(org.w3c.dom.Node, org.w3c.dom.Node):void");
    }

    public boolean c(Node node) {
        List list = this.f57158j;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (((NodeFilter) it.next()).a(node) != 1) {
                    return false;
                }
            }
        }
        Set set = this.f57160l;
        return set == null || set.contains(node);
    }

    public static final void a(String str, OutputStream outputStream) throws IOException {
        byte[] bArr;
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt == '\r') {
                bArr = q;
            } else if (cCharAt == '&') {
                bArr = u;
            } else if (cCharAt == '<') {
                bArr = s;
            } else if (cCharAt != '>') {
                if (cCharAt < 128) {
                    outputStream.write(cCharAt);
                } else {
                    UtfHelpper.a(cCharAt, outputStream);
                }
            } else {
                bArr = r;
            }
            outputStream.write(bArr);
        }
    }

    public byte[] b(XMLSignatureInput xMLSignatureInput) throws CanonicalizationException {
        try {
            if (xMLSignatureInput.n()) {
                this.f57159k = false;
            }
            if (xMLSignatureInput.h()) {
                return a(xMLSignatureInput.e());
            }
            if (xMLSignatureInput.g()) {
                return a(xMLSignatureInput.m(), xMLSignatureInput.l());
            }
            if (!xMLSignatureInput.f()) {
                return null;
            }
            this.f57158j = xMLSignatureInput.p();
            a(xMLSignatureInput);
            return xMLSignatureInput.m() != null ? d(xMLSignatureInput.m()) : a(xMLSignatureInput.b());
        } catch (IOException e2) {
            throw new CanonicalizationException("empty", e2);
        } catch (ParserConfigurationException e3) {
            throw new CanonicalizationException("empty", e3);
        } catch (CanonicalizationException e4) {
            throw new CanonicalizationException("empty", e4);
        } catch (SAXException e5) {
            throw new CanonicalizationException("empty", e5);
        }
    }

    public static final void a(String str, String str2, OutputStream outputStream, Map map) throws IOException {
        byte[] bArr;
        outputStream.write(32);
        UtfHelpper.a(str, outputStream, map);
        outputStream.write(f57156h);
        int length = str2.length();
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 1;
            char cCharAt = str2.charAt(i2);
            if (cCharAt == '\t') {
                bArr = o;
            } else if (cCharAt == '\n') {
                bArr = f57154f;
            } else if (cCharAt == '\r') {
                bArr = q;
            } else if (cCharAt == '\"') {
                bArr = p;
            } else if (cCharAt == '&') {
                bArr = u;
            } else if (cCharAt != '<') {
                if (cCharAt < 128) {
                    outputStream.write(cCharAt);
                } else {
                    UtfHelpper.a(cCharAt, outputStream);
                }
                i2 = i3;
            } else {
                bArr = s;
            }
            outputStream.write(bArr);
            i2 = i3;
        }
        outputStream.write(34);
    }

    public static final void a(Comment comment, OutputStream outputStream, int i2) throws DOMException, IOException {
        if (i2 == 1) {
            outputStream.write(10);
        }
        outputStream.write(f57153e);
        String data = comment.getData();
        int length = data.length();
        for (int i3 = 0; i3 < length; i3++) {
            char cCharAt = data.charAt(i3);
            if (cCharAt == '\r') {
                outputStream.write(q);
            } else if (cCharAt < 128) {
                outputStream.write(cCharAt);
            } else {
                UtfHelpper.a(cCharAt, outputStream);
            }
        }
        outputStream.write(f57152d);
        if (i2 == -1) {
            outputStream.write(10);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:32:0x00ab
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:225)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:195)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:62)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.processFallThroughCases(SwitchRegionMaker.java:105)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:64)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:281)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:64)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:101)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void a(org.w3c.dom.Node r17, org.apache.xml.security.c14n.implementations.NameSpaceSymbTable r18, org.w3c.dom.Node r19, int r20) throws org.apache.xml.security.c14n.CanonicalizationException, org.w3c.dom.DOMException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 262
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xml.security.c14n.implementations.CanonicalizerBase.a(org.w3c.dom.Node, org.apache.xml.security.c14n.implementations.NameSpaceSymbTable, org.w3c.dom.Node, int):void");
    }

    public static final void a(ProcessingInstruction processingInstruction, OutputStream outputStream, int i2) throws IOException {
        if (i2 == 1) {
            outputStream.write(10);
        }
        outputStream.write(f57151c);
        String target = processingInstruction.getTarget();
        int length = target.length();
        for (int i3 = 0; i3 < length; i3++) {
            char cCharAt = target.charAt(i3);
            if (cCharAt == '\r') {
                outputStream.write(q);
            } else if (cCharAt < 128) {
                outputStream.write(cCharAt);
            } else {
                UtfHelpper.a(cCharAt, outputStream);
            }
        }
        String data = processingInstruction.getData();
        int length2 = data.length();
        if (length2 > 0) {
            outputStream.write(32);
            for (int i4 = 0; i4 < length2; i4++) {
                char cCharAt2 = data.charAt(i4);
                if (cCharAt2 == '\r') {
                    outputStream.write(q);
                } else {
                    UtfHelpper.a(cCharAt2, outputStream);
                }
            }
        }
        outputStream.write(f57150b);
        if (i2 == -1) {
            outputStream.write(10);
        }
    }

    public byte[] a(Set set) {
        this.f57160l = set;
        return d(XMLUtils.a(set));
    }

    @Override // org.apache.xml.security.c14n.CanonicalizerSpi
    public byte[] a(Node node) {
        return a(node, (Node) null);
    }

    public byte[] a(Node node, Node node2) throws CanonicalizationException, DOMException, IOException {
        int i2;
        this.f57161m = node2;
        try {
            NameSpaceSymbTable nameSpaceSymbTable = new NameSpaceSymbTable();
            if (node == null || 1 != node.getNodeType()) {
                i2 = -1;
            } else {
                d((Element) node, nameSpaceSymbTable);
                i2 = 0;
            }
            a(node, nameSpaceSymbTable, node, i2);
            this.n.close();
            OutputStream outputStream = this.n;
            if (outputStream instanceof ByteArrayOutputStream) {
                byte[] byteArray = ((ByteArrayOutputStream) outputStream).toByteArray();
                if (this.f57125a) {
                    ((ByteArrayOutputStream) this.n).reset();
                }
                return byteArray;
            }
            if (!(outputStream instanceof UnsyncByteArrayOutputStream)) {
                return null;
            }
            byte[] bArrA = ((UnsyncByteArrayOutputStream) outputStream).a();
            if (this.f57125a) {
                ((UnsyncByteArrayOutputStream) this.n).b();
            }
            return bArrA;
        } catch (UnsupportedEncodingException e2) {
            throw new CanonicalizationException("empty", e2);
        } catch (IOException e3) {
            throw new CanonicalizationException("empty", e3);
        }
    }
}
