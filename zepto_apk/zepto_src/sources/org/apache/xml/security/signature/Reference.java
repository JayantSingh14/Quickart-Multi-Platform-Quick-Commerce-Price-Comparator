package org.apache.xml.security.signature;

import com.google.android.gms.internal.pal.a;
import java.io.IOException;
import java.io.OutputStream;
import java.security.AccessController;
import java.security.PrivilegedAction;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.algorithms.MessageDigestAlgorithm;
import org.apache.xml.security.c14n.CanonicalizationException;
import org.apache.xml.security.c14n.InvalidCanonicalizerException;
import org.apache.xml.security.exceptions.XMLSecurityException;
import org.apache.xml.security.transforms.TransformationException;
import org.apache.xml.security.transforms.Transforms;
import org.apache.xml.security.utils.Base64;
import org.apache.xml.security.utils.DigesterOutputStream;
import org.apache.xml.security.utils.SignatureElementProxy;
import org.apache.xml.security.utils.UnsyncBufferedOutputStream;
import org.apache.xml.security.utils.XMLUtils;
import org.apache.xml.security.utils.resolver.ResourceResolver;
import org.apache.xml.security.utils.resolver.ResourceResolverException;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;

/* loaded from: classes5.dex */
public class Reference extends SignatureElementProxy {

    /* renamed from: a, reason: collision with root package name */
    static Log f57249a;

    /* renamed from: d, reason: collision with root package name */
    static Class f57250d;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f57251e = ((Boolean) AccessController.doPrivileged(new PrivilegedAction() { // from class: org.apache.xml.security.signature.Reference.1
        @Override // java.security.PrivilegedAction
        public Object run() {
            return Boolean.valueOf(Boolean.getBoolean("org.apache.xml.security.useC14N11"));
        }
    })).booleanValue();

    /* renamed from: b, reason: collision with root package name */
    Manifest f57252b;

    /* renamed from: c, reason: collision with root package name */
    XMLSignatureInput f57253c;

    /* renamed from: f, reason: collision with root package name */
    private Transforms f57254f;

    /* renamed from: g, reason: collision with root package name */
    private Element f57255g;

    /* renamed from: h, reason: collision with root package name */
    private Element f57256h;

    static {
        Class clsA = f57250d;
        if (clsA == null) {
            clsA = a("org.apache.xml.security.signature.Reference");
            f57250d = clsA;
        }
        f57249a = LogFactory.getLog(clsA.getName());
    }

    public Reference(Element element, String str, Manifest manifest) {
        super(element, str);
        this.f57252b = null;
        this.f57334l = str;
        Element elementA = XMLUtils.a(element.getFirstChild());
        if ("Transforms".equals(elementA.getLocalName()) && "http://www.w3.org/2000/09/xmldsig#".equals(elementA.getNamespaceURI())) {
            this.f57254f = new Transforms(elementA, this.f57334l);
            elementA = XMLUtils.a(elementA.getNextSibling());
        }
        this.f57255g = elementA;
        this.f57256h = XMLUtils.a(elementA.getNextSibling());
        this.f57252b = manifest;
    }

    public static Class a(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw a.g(e2);
        }
    }

    public String b() {
        return this.f57333k.getAttributeNS(null, "URI");
    }

    public String c() {
        return this.f57333k.getAttributeNS(null, "Type");
    }

    @Override // org.apache.xml.security.utils.ElementProxy
    public String e() {
        return "Reference";
    }

    public boolean f() {
        return "http://www.w3.org/2000/09/xmldsig#Manifest".equals(c());
    }

    public XMLSignatureInput g() throws DOMException, ReferenceNotInitializedException {
        try {
            String nodeValue = null;
            Attr attributeNodeNS = this.f57333k.getAttributeNodeNS(null, "URI");
            if (attributeNodeNS != null) {
                nodeValue = attributeNodeNS.getNodeValue();
            }
            ResourceResolver resourceResolverA = ResourceResolver.a(attributeNodeNS, this.f57334l, this.f57252b.f57246e);
            if (resourceResolverA == null) {
                throw new ReferenceNotInitializedException("signature.Verification.Reference.NoInput", new Object[]{nodeValue});
            }
            resourceResolverA.a(this.f57252b.f57245d);
            return resourceResolverA.b(attributeNodeNS, this.f57334l);
        } catch (ResourceResolverException e2) {
            throw new ReferenceNotInitializedException("empty", e2);
        } catch (XMLSecurityException e3) {
            throw new ReferenceNotInitializedException("empty", e3);
        }
    }

    public Transforms h() {
        return this.f57254f;
    }

    public byte[] i() throws XMLSecurityException {
        Element element = this.f57256h;
        if (element != null) {
            return Base64.a(element);
        }
        throw new XMLSecurityException("signature.Verification.NoSignatureElement", new Object[]{"DigestValue", "http://www.w3.org/2000/09/xmldsig#"});
    }

    public boolean j() {
        byte[] bArrI = i();
        byte[] bArrA = a(true);
        boolean zA = MessageDigestAlgorithm.a(bArrI, bArrA);
        if (zA) {
            Log log = f57249a;
            StringBuffer stringBuffer = new StringBuffer("Verification successful for URI \"");
            stringBuffer.append(b());
            stringBuffer.append("\"");
            log.debug(stringBuffer.toString());
            return zA;
        }
        Log log2 = f57249a;
        StringBuffer stringBuffer2 = new StringBuffer("Verification failed for URI \"");
        stringBuffer2.append(b());
        stringBuffer2.append("\"");
        log2.warn(stringBuffer2.toString());
        Log log3 = f57249a;
        StringBuffer stringBuffer3 = new StringBuffer("Expected Digest: ");
        stringBuffer3.append(Base64.b(bArrI));
        log3.warn(stringBuffer3.toString());
        Log log4 = f57249a;
        StringBuffer stringBuffer4 = new StringBuffer("Actual Digest: ");
        stringBuffer4.append(Base64.b(bArrA));
        log4.warn(stringBuffer4.toString());
        return zA;
    }

    public MessageDigestAlgorithm a() {
        String attributeNS;
        Element element = this.f57255g;
        if (element == null || (attributeNS = element.getAttributeNS(null, "Algorithm")) == null) {
            return null;
        }
        return MessageDigestAlgorithm.a(this.f57335m, attributeNS);
    }

    public XMLSignatureInput a(OutputStream outputStream) {
        try {
            XMLSignatureInput xMLSignatureInputA = a(g(), outputStream);
            this.f57253c = xMLSignatureInputA;
            return xMLSignatureInputA;
        } catch (XMLSecurityException e2) {
            throw new ReferenceNotInitializedException("empty", e2);
        }
    }

    private XMLSignatureInput a(XMLSignatureInput xMLSignatureInput, OutputStream outputStream) throws XMLSignatureException {
        try {
            Transforms transformsH = h();
            if (transformsH == null) {
                return xMLSignatureInput;
            }
            XMLSignatureInput xMLSignatureInputA = transformsH.a(xMLSignatureInput, outputStream);
            this.f57253c = xMLSignatureInputA;
            return xMLSignatureInputA;
        } catch (CanonicalizationException e2) {
            throw new XMLSignatureException("empty", e2);
        } catch (InvalidCanonicalizerException e3) {
            throw new XMLSignatureException("empty", e3);
        } catch (TransformationException e4) {
            throw new XMLSignatureException("empty", e4);
        } catch (ResourceResolverException e5) {
            throw new XMLSignatureException("empty", e5);
        } catch (XMLSecurityException e6) {
            throw new XMLSignatureException("empty", e6);
        }
    }

    private byte[] a(boolean z) throws DOMException, ReferenceNotInitializedException {
        try {
            MessageDigestAlgorithm messageDigestAlgorithmA = a();
            messageDigestAlgorithmA.c();
            DigesterOutputStream digesterOutputStream = new DigesterOutputStream(messageDigestAlgorithmA);
            UnsyncBufferedOutputStream unsyncBufferedOutputStream = new UnsyncBufferedOutputStream(digesterOutputStream);
            XMLSignatureInput xMLSignatureInputA = a(unsyncBufferedOutputStream);
            if (!f57251e || z || xMLSignatureInputA.i() || xMLSignatureInputA.h()) {
                xMLSignatureInputA.a(unsyncBufferedOutputStream);
            } else {
                if (this.f57254f == null) {
                    Transforms transforms = new Transforms(this.f57335m);
                    this.f57254f = transforms;
                    this.f57333k.insertBefore(transforms.k(), this.f57255g);
                }
                this.f57254f.a("http://www.w3.org/2006/12/xml-c14n11");
                xMLSignatureInputA.a(unsyncBufferedOutputStream, true);
            }
            unsyncBufferedOutputStream.flush();
            return digesterOutputStream.a();
        } catch (IOException e2) {
            throw new ReferenceNotInitializedException("empty", e2);
        } catch (XMLSecurityException e3) {
            throw new ReferenceNotInitializedException("empty", e3);
        }
    }
}
