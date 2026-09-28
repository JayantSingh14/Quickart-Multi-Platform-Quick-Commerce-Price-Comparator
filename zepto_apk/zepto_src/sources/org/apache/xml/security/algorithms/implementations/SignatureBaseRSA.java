package org.apache.xml.security.algorithms.implementations;

import com.google.android.gms.internal.pal.a;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.algorithms.JCEMapper;
import org.apache.xml.security.algorithms.SignatureAlgorithmSpi;
import org.apache.xml.security.signature.XMLSignatureException;

/* loaded from: classes5.dex */
public abstract class SignatureBaseRSA extends SignatureAlgorithmSpi {

    /* renamed from: a, reason: collision with root package name */
    static Log f57110a;

    /* renamed from: b, reason: collision with root package name */
    static Class f57111b;

    /* renamed from: c, reason: collision with root package name */
    static Class f57112c;

    /* renamed from: d, reason: collision with root package name */
    private Signature f57113d;

    public static class SignatureRSAMD5 extends SignatureBaseRSA {
        @Override // org.apache.xml.security.algorithms.implementations.SignatureBaseRSA
        public String d() {
            return "http://www.w3.org/2001/04/xmldsig-more#rsa-md5";
        }
    }

    public static class SignatureRSARIPEMD160 extends SignatureBaseRSA {
        @Override // org.apache.xml.security.algorithms.implementations.SignatureBaseRSA
        public String d() {
            return "http://www.w3.org/2001/04/xmldsig-more#rsa-ripemd160";
        }
    }

    public static class SignatureRSASHA1 extends SignatureBaseRSA {
        @Override // org.apache.xml.security.algorithms.implementations.SignatureBaseRSA
        public String d() {
            return "http://www.w3.org/2000/09/xmldsig#rsa-sha1";
        }
    }

    public static class SignatureRSASHA256 extends SignatureBaseRSA {
        @Override // org.apache.xml.security.algorithms.implementations.SignatureBaseRSA
        public String d() {
            return "http://www.w3.org/2001/04/xmldsig-more#rsa-sha256";
        }
    }

    public static class SignatureRSASHA384 extends SignatureBaseRSA {
        @Override // org.apache.xml.security.algorithms.implementations.SignatureBaseRSA
        public String d() {
            return "http://www.w3.org/2001/04/xmldsig-more#rsa-sha384";
        }
    }

    public static class SignatureRSASHA512 extends SignatureBaseRSA {
        @Override // org.apache.xml.security.algorithms.implementations.SignatureBaseRSA
        public String d() {
            return "http://www.w3.org/2001/04/xmldsig-more#rsa-sha512";
        }
    }

    static {
        Class clsA = f57111b;
        if (clsA == null) {
            clsA = a("org.apache.xml.security.algorithms.implementations.SignatureBaseRSA");
            f57111b = clsA;
        }
        f57110a = LogFactory.getLog(clsA.getName());
    }

    public SignatureBaseRSA() throws XMLSignatureException {
        this.f57113d = null;
        String strA = JCEMapper.a(d());
        if (f57110a.isDebugEnabled()) {
            Log log = f57110a;
            StringBuffer stringBuffer = new StringBuffer("Created SignatureRSA using ");
            stringBuffer.append(strA);
            log.debug(stringBuffer.toString());
        }
        String strA2 = JCEMapper.a();
        try {
            this.f57113d = strA2 == null ? Signature.getInstance(strA) : Signature.getInstance(strA, strA2);
        } catch (NoSuchAlgorithmException e2) {
            throw new XMLSignatureException("algorithms.NoSuchAlgorithm", new Object[]{strA, e2.getLocalizedMessage()});
        } catch (NoSuchProviderException e3) {
            throw new XMLSignatureException("algorithms.NoSuchAlgorithm", new Object[]{strA, e3.getLocalizedMessage()});
        }
    }

    public static Class a(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw a.g(e2);
        }
    }

    @Override // org.apache.xml.security.algorithms.SignatureAlgorithmSpi
    public String b() {
        return this.f57113d.getProvider().getName();
    }

    public abstract String d();

    @Override // org.apache.xml.security.algorithms.SignatureAlgorithmSpi
    public boolean b(byte[] bArr) throws XMLSignatureException {
        try {
            return this.f57113d.verify(bArr);
        } catch (SignatureException e2) {
            throw new XMLSignatureException("empty", e2);
        }
    }

    @Override // org.apache.xml.security.algorithms.SignatureAlgorithmSpi
    public String a() {
        return this.f57113d.getAlgorithm();
    }

    @Override // org.apache.xml.security.algorithms.SignatureAlgorithmSpi
    public void a(byte b2) throws SignatureException, XMLSignatureException {
        try {
            this.f57113d.update(b2);
        } catch (SignatureException e2) {
            throw new XMLSignatureException("empty", e2);
        }
    }

    @Override // org.apache.xml.security.algorithms.SignatureAlgorithmSpi
    public void a(Key key) throws Throwable {
        if (!(key instanceof PublicKey)) {
            String name = key.getClass().getName();
            Class clsA = f57112c;
            if (clsA == null) {
                clsA = a("java.security.PublicKey");
                f57112c = clsA;
            }
            throw new XMLSignatureException("algorithms.WrongKeyForThisOperation", new Object[]{name, clsA.getName()});
        }
        try {
            this.f57113d.initVerify((PublicKey) key);
        } catch (InvalidKeyException e2) {
            Signature signature = this.f57113d;
            try {
                this.f57113d = Signature.getInstance(signature.getAlgorithm());
            } catch (Exception e3) {
                if (f57110a.isDebugEnabled()) {
                    Log log = f57110a;
                    StringBuffer stringBuffer = new StringBuffer("Exception when reinstantiating Signature:");
                    stringBuffer.append(e3);
                    log.debug(stringBuffer.toString());
                }
                this.f57113d = signature;
            }
            throw new XMLSignatureException("empty", e2);
        }
    }

    @Override // org.apache.xml.security.algorithms.SignatureAlgorithmSpi
    public void a(byte[] bArr) throws SignatureException, XMLSignatureException {
        try {
            this.f57113d.update(bArr);
        } catch (SignatureException e2) {
            throw new XMLSignatureException("empty", e2);
        }
    }

    @Override // org.apache.xml.security.algorithms.SignatureAlgorithmSpi
    public void a(byte[] bArr, int i2, int i3) throws SignatureException, XMLSignatureException {
        try {
            this.f57113d.update(bArr, i2, i3);
        } catch (SignatureException e2) {
            throw new XMLSignatureException("empty", e2);
        }
    }
}
