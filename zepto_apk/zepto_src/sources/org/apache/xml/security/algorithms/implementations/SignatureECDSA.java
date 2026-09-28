package org.apache.xml.security.algorithms.implementations;

import com.google.android.gms.internal.pal.a;
import java.io.IOException;
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
import org.apache.xml.security.utils.Base64;

/* loaded from: classes5.dex */
public abstract class SignatureECDSA extends SignatureAlgorithmSpi {

    /* renamed from: a, reason: collision with root package name */
    static Log f57118a;

    /* renamed from: b, reason: collision with root package name */
    static Class f57119b;

    /* renamed from: c, reason: collision with root package name */
    static Class f57120c;

    /* renamed from: d, reason: collision with root package name */
    private Signature f57121d;

    public static class SignatureECDSASHA1 extends SignatureECDSA {
        @Override // org.apache.xml.security.algorithms.implementations.SignatureECDSA
        public String d() {
            return "http://www.w3.org/2001/04/xmldsig-more#ecdsa-sha1";
        }
    }

    static {
        Class clsA = f57119b;
        if (clsA == null) {
            clsA = a("org.apache.xml.security.algorithms.implementations.SignatureECDSA");
            f57119b = clsA;
        }
        f57118a = LogFactory.getLog(clsA.getName());
    }

    public SignatureECDSA() throws XMLSignatureException {
        this.f57121d = null;
        String strA = JCEMapper.a(d());
        if (f57118a.isDebugEnabled()) {
            Log log = f57118a;
            StringBuffer stringBuffer = new StringBuffer("Created SignatureECDSA using ");
            stringBuffer.append(strA);
            log.debug(stringBuffer.toString());
        }
        String strA2 = JCEMapper.a();
        try {
            this.f57121d = strA2 == null ? Signature.getInstance(strA) : Signature.getInstance(strA, strA2);
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

    private static byte[] c(byte[] bArr) throws IOException {
        if (bArr.length < 48) {
            throw new IOException("Invalid XMLDSIG format of ECDSA signature");
        }
        int length = bArr.length / 2;
        int i2 = length;
        while (i2 > 0 && bArr[length - i2] == 0) {
            i2--;
        }
        int i3 = length - i2;
        int i4 = bArr[i3] < 0 ? i2 + 1 : i2;
        int i5 = length;
        while (i5 > 0 && bArr[(length * 2) - i5] == 0) {
            i5--;
        }
        int i6 = (length * 2) - i5;
        int i7 = bArr[i6] < 0 ? i5 + 1 : i5;
        int i8 = i4 + 6 + i7;
        byte[] bArr2 = new byte[i8];
        bArr2[0] = 48;
        int i9 = i4 + 4;
        bArr2[1] = (byte) (i9 + i7);
        bArr2[2] = 2;
        bArr2[3] = (byte) i4;
        System.arraycopy(bArr, i3, bArr2, i9 - i2, i2);
        bArr2[i9] = 2;
        bArr2[i4 + 5] = (byte) i7;
        System.arraycopy(bArr, i6, bArr2, i8 - i5, i5);
        return bArr2;
    }

    @Override // org.apache.xml.security.algorithms.SignatureAlgorithmSpi
    public String b() {
        return this.f57121d.getProvider().getName();
    }

    public abstract String d();

    @Override // org.apache.xml.security.algorithms.SignatureAlgorithmSpi
    public boolean b(byte[] bArr) throws XMLSignatureException {
        try {
            byte[] bArrC = c(bArr);
            if (f57118a.isDebugEnabled()) {
                Log log = f57118a;
                StringBuffer stringBuffer = new StringBuffer("Called ECDSA.verify() on ");
                stringBuffer.append(Base64.b(bArr));
                log.debug(stringBuffer.toString());
            }
            return this.f57121d.verify(bArrC);
        } catch (IOException e2) {
            throw new XMLSignatureException("empty", e2);
        } catch (SignatureException e3) {
            throw new XMLSignatureException("empty", e3);
        }
    }

    @Override // org.apache.xml.security.algorithms.SignatureAlgorithmSpi
    public String a() {
        return this.f57121d.getAlgorithm();
    }

    @Override // org.apache.xml.security.algorithms.SignatureAlgorithmSpi
    public void a(byte b2) throws SignatureException, XMLSignatureException {
        try {
            this.f57121d.update(b2);
        } catch (SignatureException e2) {
            throw new XMLSignatureException("empty", e2);
        }
    }

    @Override // org.apache.xml.security.algorithms.SignatureAlgorithmSpi
    public void a(Key key) throws Throwable {
        if (!(key instanceof PublicKey)) {
            String name = key.getClass().getName();
            Class clsA = f57120c;
            if (clsA == null) {
                clsA = a("java.security.PublicKey");
                f57120c = clsA;
            }
            throw new XMLSignatureException("algorithms.WrongKeyForThisOperation", new Object[]{name, clsA.getName()});
        }
        try {
            this.f57121d.initVerify((PublicKey) key);
        } catch (InvalidKeyException e2) {
            Signature signature = this.f57121d;
            try {
                this.f57121d = Signature.getInstance(signature.getAlgorithm());
            } catch (Exception e3) {
                if (f57118a.isDebugEnabled()) {
                    Log log = f57118a;
                    StringBuffer stringBuffer = new StringBuffer("Exception when reinstantiating Signature:");
                    stringBuffer.append(e3);
                    log.debug(stringBuffer.toString());
                }
                this.f57121d = signature;
            }
            throw new XMLSignatureException("empty", e2);
        }
    }

    @Override // org.apache.xml.security.algorithms.SignatureAlgorithmSpi
    public void a(byte[] bArr) throws SignatureException, XMLSignatureException {
        try {
            this.f57121d.update(bArr);
        } catch (SignatureException e2) {
            throw new XMLSignatureException("empty", e2);
        }
    }

    @Override // org.apache.xml.security.algorithms.SignatureAlgorithmSpi
    public void a(byte[] bArr, int i2, int i3) throws SignatureException, XMLSignatureException {
        try {
            this.f57121d.update(bArr, i2, i3);
        } catch (SignatureException e2) {
            throw new XMLSignatureException("empty", e2);
        }
    }
}
