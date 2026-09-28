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
public class SignatureDSA extends SignatureAlgorithmSpi {

    /* renamed from: a, reason: collision with root package name */
    static Log f57114a;

    /* renamed from: b, reason: collision with root package name */
    static Class f57115b;

    /* renamed from: c, reason: collision with root package name */
    static Class f57116c;

    /* renamed from: d, reason: collision with root package name */
    private Signature f57117d;

    static {
        Class clsA = f57115b;
        if (clsA == null) {
            clsA = a("org.apache.xml.security.algorithms.implementations.SignatureDSA");
            f57115b = clsA;
        }
        f57114a = LogFactory.getLog(clsA.getName());
    }

    public SignatureDSA() throws XMLSignatureException {
        this.f57117d = null;
        String strA = JCEMapper.a("http://www.w3.org/2000/09/xmldsig#dsa-sha1");
        if (f57114a.isDebugEnabled()) {
            Log log = f57114a;
            StringBuffer stringBuffer = new StringBuffer("Created SignatureDSA using ");
            stringBuffer.append(strA);
            log.debug(stringBuffer.toString());
        }
        String strA2 = JCEMapper.a();
        try {
            this.f57117d = strA2 == null ? Signature.getInstance(strA) : Signature.getInstance(strA, strA2);
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
        if (bArr.length != 40) {
            throw new IOException("Invalid XMLDSIG format of DSA signature");
        }
        int i2 = 20;
        int i3 = 20;
        while (i3 > 0 && bArr[20 - i3] == 0) {
            i3--;
        }
        int i4 = 20 - i3;
        int i5 = bArr[i4] < 0 ? i3 + 1 : i3;
        while (i2 > 0 && bArr[40 - i2] == 0) {
            i2--;
        }
        int i6 = 40 - i2;
        int i7 = bArr[i6] < 0 ? i2 + 1 : i2;
        int i8 = i5 + 6 + i7;
        byte[] bArr2 = new byte[i8];
        bArr2[0] = 48;
        int i9 = i5 + 4;
        bArr2[1] = (byte) (i9 + i7);
        bArr2[2] = 2;
        bArr2[3] = (byte) i5;
        System.arraycopy(bArr, i4, bArr2, i9 - i3, i3);
        bArr2[i9] = 2;
        bArr2[i5 + 5] = (byte) i7;
        System.arraycopy(bArr, i6, bArr2, i8 - i2, i2);
        return bArr2;
    }

    @Override // org.apache.xml.security.algorithms.SignatureAlgorithmSpi
    public String b() {
        return this.f57117d.getProvider().getName();
    }

    @Override // org.apache.xml.security.algorithms.SignatureAlgorithmSpi
    public boolean b(byte[] bArr) throws XMLSignatureException {
        try {
            if (f57114a.isDebugEnabled()) {
                Log log = f57114a;
                StringBuffer stringBuffer = new StringBuffer("Called DSA.verify() on ");
                stringBuffer.append(Base64.b(bArr));
                log.debug(stringBuffer.toString());
            }
            return this.f57117d.verify(c(bArr));
        } catch (IOException e2) {
            throw new XMLSignatureException("empty", e2);
        } catch (SignatureException e3) {
            throw new XMLSignatureException("empty", e3);
        }
    }

    @Override // org.apache.xml.security.algorithms.SignatureAlgorithmSpi
    public String a() {
        return this.f57117d.getAlgorithm();
    }

    @Override // org.apache.xml.security.algorithms.SignatureAlgorithmSpi
    public void a(byte b2) throws SignatureException, XMLSignatureException {
        try {
            this.f57117d.update(b2);
        } catch (SignatureException e2) {
            throw new XMLSignatureException("empty", e2);
        }
    }

    @Override // org.apache.xml.security.algorithms.SignatureAlgorithmSpi
    public void a(Key key) throws Throwable {
        if (!(key instanceof PublicKey)) {
            String name = key.getClass().getName();
            Class clsA = f57116c;
            if (clsA == null) {
                clsA = a("java.security.PublicKey");
                f57116c = clsA;
            }
            throw new XMLSignatureException("algorithms.WrongKeyForThisOperation", new Object[]{name, clsA.getName()});
        }
        try {
            this.f57117d.initVerify((PublicKey) key);
        } catch (InvalidKeyException e2) {
            Signature signature = this.f57117d;
            try {
                this.f57117d = Signature.getInstance(signature.getAlgorithm());
            } catch (Exception e3) {
                if (f57114a.isDebugEnabled()) {
                    Log log = f57114a;
                    StringBuffer stringBuffer = new StringBuffer("Exception when reinstantiating Signature:");
                    stringBuffer.append(e3);
                    log.debug(stringBuffer.toString());
                }
                this.f57117d = signature;
            }
            throw new XMLSignatureException("empty", e2);
        }
    }

    @Override // org.apache.xml.security.algorithms.SignatureAlgorithmSpi
    public void a(byte[] bArr) throws SignatureException, XMLSignatureException {
        try {
            this.f57117d.update(bArr);
        } catch (SignatureException e2) {
            throw new XMLSignatureException("empty", e2);
        }
    }

    @Override // org.apache.xml.security.algorithms.SignatureAlgorithmSpi
    public void a(byte[] bArr, int i2, int i3) throws SignatureException, XMLSignatureException {
        try {
            this.f57117d.update(bArr, i2, i3);
        } catch (SignatureException e2) {
            throw new XMLSignatureException("empty", e2);
        }
    }
}
