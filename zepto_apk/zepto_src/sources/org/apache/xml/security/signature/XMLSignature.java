package org.apache.xml.security.signature;

import com.google.android.gms.internal.pal.a;
import java.io.IOException;
import java.security.Key;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.algorithms.SignatureAlgorithm;
import org.apache.xml.security.exceptions.Base64DecodingException;
import org.apache.xml.security.exceptions.XMLSecurityException;
import org.apache.xml.security.keys.KeyInfo;
import org.apache.xml.security.utils.Base64;
import org.apache.xml.security.utils.SignatureElementProxy;
import org.apache.xml.security.utils.SignerOutputStream;
import org.apache.xml.security.utils.UnsyncBufferedOutputStream;
import org.apache.xml.security.utils.XMLUtils;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;

/* loaded from: classes5.dex */
public final class XMLSignature extends SignatureElementProxy {

    /* renamed from: a, reason: collision with root package name */
    static Log f57260a;

    /* renamed from: b, reason: collision with root package name */
    static Class f57261b;

    /* renamed from: c, reason: collision with root package name */
    private SignedInfo f57262c;

    /* renamed from: d, reason: collision with root package name */
    private KeyInfo f57263d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f57264e;

    /* renamed from: f, reason: collision with root package name */
    private Element f57265f;

    /* renamed from: g, reason: collision with root package name */
    private int f57266g;

    static {
        Class clsA = f57261b;
        if (clsA == null) {
            clsA = a("org.apache.xml.security.signature.XMLSignature");
            f57261b = clsA;
        }
        f57260a = LogFactory.getLog(clsA.getName());
    }

    public XMLSignature(Element element, String str) throws XMLSignatureException {
        super(element, str);
        this.f57262c = null;
        this.f57263d = null;
        this.f57264e = false;
        this.f57266g = 0;
        Element elementA = XMLUtils.a(element.getFirstChild());
        if (elementA == null) {
            throw new XMLSignatureException("xml.WrongContent", new Object[]{"SignedInfo", "Signature"});
        }
        this.f57262c = new SignedInfo(elementA, str);
        Element elementA2 = XMLUtils.a(XMLUtils.a(element.getFirstChild()).getNextSibling());
        this.f57265f = elementA2;
        if (elementA2 == null) {
            throw new XMLSignatureException("xml.WrongContent", new Object[]{"SignatureValue", "Signature"});
        }
        Element elementA3 = XMLUtils.a(elementA2.getNextSibling());
        if (elementA3 != null && elementA3.getNamespaceURI().equals("http://www.w3.org/2000/09/xmldsig#") && elementA3.getLocalName().equals("KeyInfo")) {
            this.f57263d = new KeyInfo(elementA3, str);
        }
        this.f57266g = 1;
    }

    public static Class a(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw a.g(e2);
        }
    }

    public byte[] b() throws XMLSignatureException {
        try {
            return Base64.a(this.f57265f);
        } catch (Base64DecodingException e2) {
            throw new XMLSignatureException("empty", e2);
        }
    }

    @Override // org.apache.xml.security.utils.ElementProxy
    public String e() {
        return "Signature";
    }

    public SignedInfo a() {
        return this.f57262c;
    }

    public boolean a(Key key) throws XMLSecurityException, DOMException {
        byte[] bArrB;
        if (key == null) {
            throw new XMLSignatureException("empty", new Object[]{"Didn't get a key"});
        }
        try {
            SignedInfo signedInfoA = a();
            SignatureAlgorithm signatureAlgorithmC = signedInfoA.c();
            if (f57260a.isDebugEnabled()) {
                Log log = f57260a;
                StringBuffer stringBuffer = new StringBuffer("SignatureMethodURI = ");
                stringBuffer.append(signatureAlgorithmC.a());
                log.debug(stringBuffer.toString());
                Log log2 = f57260a;
                StringBuffer stringBuffer2 = new StringBuffer("jceSigAlgorithm    = ");
                stringBuffer2.append(signatureAlgorithmC.b());
                log2.debug(stringBuffer2.toString());
                Log log3 = f57260a;
                StringBuffer stringBuffer3 = new StringBuffer("jceSigProvider     = ");
                stringBuffer3.append(signatureAlgorithmC.c());
                log3.debug(stringBuffer3.toString());
                Log log4 = f57260a;
                StringBuffer stringBuffer4 = new StringBuffer("PublicKey = ");
                stringBuffer4.append(key);
                log4.debug(stringBuffer4.toString());
            }
            try {
                signatureAlgorithmC.a(key);
                UnsyncBufferedOutputStream unsyncBufferedOutputStream = new UnsyncBufferedOutputStream(new SignerOutputStream(signatureAlgorithmC));
                signedInfoA.a(unsyncBufferedOutputStream);
                unsyncBufferedOutputStream.close();
                bArrB = b();
            } catch (IOException unused) {
                signatureAlgorithmC.f();
                bArrB = null;
            } catch (XMLSecurityException e2) {
                signatureAlgorithmC.f();
                throw e2;
            }
            if (signatureAlgorithmC.b(bArrB)) {
                return signedInfoA.b(this.f57264e);
            }
            f57260a.warn("Signature verification failed.");
            return false;
        } catch (XMLSignatureException e3) {
            throw e3;
        } catch (XMLSecurityException e4) {
            throw new XMLSignatureException("empty", e4);
        }
    }
}
