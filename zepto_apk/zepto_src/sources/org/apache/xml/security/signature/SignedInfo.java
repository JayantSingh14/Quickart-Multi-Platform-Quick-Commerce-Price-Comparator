package org.apache.xml.security.signature;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.xml.security.algorithms.SignatureAlgorithm;
import org.apache.xml.security.c14n.Canonicalizer;
import org.apache.xml.security.exceptions.XMLSecurityException;
import org.apache.xml.security.transforms.params.InclusiveNamespaces;
import org.apache.xml.security.utils.XMLUtils;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/* loaded from: classes5.dex */
public class SignedInfo extends Manifest {

    /* renamed from: g, reason: collision with root package name */
    private SignatureAlgorithm f57257g;

    /* renamed from: h, reason: collision with root package name */
    private byte[] f57258h;

    /* renamed from: i, reason: collision with root package name */
    private Element f57259i;
    private Element q;

    public SignedInfo(Element element, String str) {
        super(a(element), str);
        this.f57257g = null;
        this.f57258h = null;
        Element elementA = XMLUtils.a(element.getFirstChild());
        this.f57259i = elementA;
        this.q = XMLUtils.a(elementA.getNextSibling());
        this.f57257g = new SignatureAlgorithm(this.q, l());
    }

    private static Element a(Element element) throws XMLSecurityException, DOMException, SAXException, IOException {
        String attributeNS = XMLUtils.a(element.getFirstChild()).getAttributeNS(null, "Algorithm");
        if (attributeNS.equals("http://www.w3.org/TR/2001/REC-xml-c14n-20010315") || attributeNS.equals("http://www.w3.org/TR/2001/REC-xml-c14n-20010315#WithComments") || attributeNS.equals("http://www.w3.org/2001/10/xml-exc-c14n#") || attributeNS.equals("http://www.w3.org/2001/10/xml-exc-c14n#WithComments") || attributeNS.equals("http://www.w3.org/2006/12/xml-c14n11") || attributeNS.equals("http://www.w3.org/2006/12/xml-c14n11#WithComments")) {
            return element;
        }
        try {
            byte[] bArrA = Canonicalizer.a(attributeNS).a(element);
            DocumentBuilderFactory documentBuilderFactoryNewInstance = DocumentBuilderFactory.newInstance();
            documentBuilderFactoryNewInstance.setNamespaceAware(true);
            Node nodeImportNode = element.getOwnerDocument().importNode(documentBuilderFactoryNewInstance.newDocumentBuilder().parse(new ByteArrayInputStream(bArrA)).getDocumentElement(), true);
            element.getParentNode().replaceChild(nodeImportNode, element);
            return (Element) nodeImportNode;
        } catch (IOException e2) {
            throw new XMLSecurityException("empty", e2);
        } catch (ParserConfigurationException e3) {
            throw new XMLSecurityException("empty", e3);
        } catch (SAXException e4) {
            throw new XMLSecurityException("empty", e4);
        }
    }

    public String b() {
        return this.f57259i.getAttributeNS(null, "Algorithm");
    }

    public SignatureAlgorithm c() {
        return this.f57257g;
    }

    @Override // org.apache.xml.security.signature.Manifest, org.apache.xml.security.utils.ElementProxy
    public String e() {
        return "SignedInfo";
    }

    public String f() throws DOMException {
        Element elementA;
        String attributeNS = this.f57259i.getAttributeNS(null, "Algorithm");
        if ((attributeNS.equals("http://www.w3.org/2001/10/xml-exc-c14n#") || attributeNS.equals("http://www.w3.org/2001/10/xml-exc-c14n#WithComments")) && (elementA = XMLUtils.a(this.f57259i.getFirstChild())) != null) {
            try {
                return new InclusiveNamespaces(elementA, "http://www.w3.org/2001/10/xml-exc-c14n#").a();
            } catch (XMLSecurityException unused) {
            }
        }
        return null;
    }

    public void a(OutputStream outputStream) throws DOMException, IOException {
        byte[] bArr = this.f57258h;
        if (bArr != null) {
            try {
                outputStream.write(bArr);
                return;
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }
        Canonicalizer canonicalizerA = Canonicalizer.a(b());
        canonicalizerA.a(outputStream);
        String strF = f();
        if (strF == null) {
            canonicalizerA.a(this.f57333k);
        } else {
            canonicalizerA.a(this.f57333k, strF);
        }
    }

    public boolean b(boolean z) {
        return super.a(z);
    }
}
