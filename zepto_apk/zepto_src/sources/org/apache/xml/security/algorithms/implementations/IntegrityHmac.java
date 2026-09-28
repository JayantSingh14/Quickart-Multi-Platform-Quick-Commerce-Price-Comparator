package org.apache.xml.security.algorithms.implementations;

import com.google.android.gms.internal.pal.a;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.algorithms.JCEMapper;
import org.apache.xml.security.algorithms.MessageDigestAlgorithm;
import org.apache.xml.security.algorithms.SignatureAlgorithmSpi;
import org.apache.xml.security.signature.XMLSignatureException;
import org.apache.xml.security.utils.XMLUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/* loaded from: classes5.dex */
public abstract class IntegrityHmac extends SignatureAlgorithmSpi {

    /* renamed from: a, reason: collision with root package name */
    static Log f57104a;

    /* renamed from: c, reason: collision with root package name */
    static Class f57105c;

    /* renamed from: d, reason: collision with root package name */
    static Class f57106d;

    /* renamed from: e, reason: collision with root package name */
    private Mac f57108e;

    /* renamed from: b, reason: collision with root package name */
    int f57107b = 0;

    /* renamed from: f, reason: collision with root package name */
    private boolean f57109f = false;

    public static class IntegrityHmacMD5 extends IntegrityHmac {
        @Override // org.apache.xml.security.algorithms.implementations.IntegrityHmac
        public String d() {
            return "http://www.w3.org/2001/04/xmldsig-more#hmac-md5";
        }

        @Override // org.apache.xml.security.algorithms.implementations.IntegrityHmac
        public int e() {
            return 128;
        }
    }

    public static class IntegrityHmacRIPEMD160 extends IntegrityHmac {
        @Override // org.apache.xml.security.algorithms.implementations.IntegrityHmac
        public String d() {
            return "http://www.w3.org/2001/04/xmldsig-more#hmac-ripemd160";
        }

        @Override // org.apache.xml.security.algorithms.implementations.IntegrityHmac
        public int e() {
            return 160;
        }
    }

    public static class IntegrityHmacSHA1 extends IntegrityHmac {
        @Override // org.apache.xml.security.algorithms.implementations.IntegrityHmac
        public String d() {
            return "http://www.w3.org/2000/09/xmldsig#hmac-sha1";
        }

        @Override // org.apache.xml.security.algorithms.implementations.IntegrityHmac
        public int e() {
            return 160;
        }
    }

    public static class IntegrityHmacSHA256 extends IntegrityHmac {
        @Override // org.apache.xml.security.algorithms.implementations.IntegrityHmac
        public String d() {
            return "http://www.w3.org/2001/04/xmldsig-more#hmac-sha256";
        }

        @Override // org.apache.xml.security.algorithms.implementations.IntegrityHmac
        public int e() {
            return 256;
        }
    }

    public static class IntegrityHmacSHA384 extends IntegrityHmac {
        @Override // org.apache.xml.security.algorithms.implementations.IntegrityHmac
        public String d() {
            return "http://www.w3.org/2001/04/xmldsig-more#hmac-sha384";
        }

        @Override // org.apache.xml.security.algorithms.implementations.IntegrityHmac
        public int e() {
            return 384;
        }
    }

    public static class IntegrityHmacSHA512 extends IntegrityHmac {
        @Override // org.apache.xml.security.algorithms.implementations.IntegrityHmac
        public String d() {
            return "http://www.w3.org/2001/04/xmldsig-more#hmac-sha512";
        }

        @Override // org.apache.xml.security.algorithms.implementations.IntegrityHmac
        public int e() {
            return 512;
        }
    }

    static {
        Class clsA = f57105c;
        if (clsA == null) {
            clsA = a("org.apache.xml.security.algorithms.implementations.IntegrityHmac$IntegrityHmacSHA1");
            f57105c = clsA;
        }
        f57104a = LogFactory.getLog(clsA.getName());
    }

    public IntegrityHmac() throws XMLSignatureException {
        this.f57108e = null;
        String strA = JCEMapper.a(d());
        if (f57104a.isDebugEnabled()) {
            Log log = f57104a;
            StringBuffer stringBuffer = new StringBuffer("Created IntegrityHmacSHA1 using ");
            stringBuffer.append(strA);
            log.debug(stringBuffer.toString());
        }
        try {
            this.f57108e = Mac.getInstance(strA);
        } catch (NoSuchAlgorithmException e2) {
            throw new XMLSignatureException("algorithms.NoSuchAlgorithm", new Object[]{strA, e2.getLocalizedMessage()});
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
        return this.f57108e.getProvider().getName();
    }

    @Override // org.apache.xml.security.algorithms.SignatureAlgorithmSpi
    public void c() {
        this.f57107b = 0;
        this.f57109f = false;
        this.f57108e.reset();
    }

    public abstract String d();

    public abstract int e();

    @Override // org.apache.xml.security.algorithms.SignatureAlgorithmSpi
    public boolean b(byte[] bArr) throws XMLSignatureException {
        try {
            if (!this.f57109f || this.f57107b >= e()) {
                return MessageDigestAlgorithm.a(this.f57108e.doFinal(), bArr);
            }
            if (f57104a.isDebugEnabled()) {
                Log log = f57104a;
                StringBuffer stringBuffer = new StringBuffer("HMACOutputLength must not be less than ");
                stringBuffer.append(e());
                log.debug(stringBuffer.toString());
            }
            throw new XMLSignatureException("algorithms.HMACOutputLengthMin", new Object[]{String.valueOf(e())});
        } catch (IllegalStateException e2) {
            throw new XMLSignatureException("empty", e2);
        }
    }

    @Override // org.apache.xml.security.algorithms.SignatureAlgorithmSpi
    public String a() {
        f57104a.debug("engineGetJCEAlgorithmString()");
        return this.f57108e.getAlgorithm();
    }

    @Override // org.apache.xml.security.algorithms.SignatureAlgorithmSpi
    public void a(byte b2) throws IllegalStateException, XMLSignatureException {
        try {
            this.f57108e.update(b2);
        } catch (IllegalStateException e2) {
            throw new XMLSignatureException("empty", e2);
        }
    }

    @Override // org.apache.xml.security.algorithms.SignatureAlgorithmSpi
    public void a(Key key) throws Throwable {
        if (!(key instanceof SecretKey)) {
            String name = key.getClass().getName();
            Class clsA = f57106d;
            if (clsA == null) {
                clsA = a("javax.crypto.SecretKey");
                f57106d = clsA;
            }
            throw new XMLSignatureException("algorithms.WrongKeyForThisOperation", new Object[]{name, clsA.getName()});
        }
        try {
            this.f57108e.init(key);
        } catch (InvalidKeyException e2) {
            Mac mac = this.f57108e;
            try {
                this.f57108e = Mac.getInstance(mac.getAlgorithm());
            } catch (Exception e3) {
                if (f57104a.isDebugEnabled()) {
                    Log log = f57104a;
                    StringBuffer stringBuffer = new StringBuffer("Exception when reinstantiating Mac:");
                    stringBuffer.append(e3);
                    log.debug(stringBuffer.toString());
                }
                this.f57108e = mac;
            }
            throw new XMLSignatureException("empty", e2);
        }
    }

    @Override // org.apache.xml.security.algorithms.SignatureAlgorithmSpi
    public void a(Element element) {
        super.a(element);
        if (element == null) {
            throw new IllegalArgumentException("element null");
        }
        Text textB = XMLUtils.b(element.getFirstChild(), "HMACOutputLength", 0);
        if (textB != null) {
            this.f57107b = Integer.parseInt(textB.getData());
            this.f57109f = true;
        }
    }

    @Override // org.apache.xml.security.algorithms.SignatureAlgorithmSpi
    public void a(byte[] bArr) throws IllegalStateException, XMLSignatureException {
        try {
            this.f57108e.update(bArr);
        } catch (IllegalStateException e2) {
            throw new XMLSignatureException("empty", e2);
        }
    }

    @Override // org.apache.xml.security.algorithms.SignatureAlgorithmSpi
    public void a(byte[] bArr, int i2, int i3) throws IllegalStateException, XMLSignatureException {
        try {
            this.f57108e.update(bArr, i2, i3);
        } catch (IllegalStateException e2) {
            throw new XMLSignatureException("empty", e2);
        }
    }
}
