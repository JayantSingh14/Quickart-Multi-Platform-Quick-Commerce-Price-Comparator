package org.apache.xml.security.utils;

import com.google.android.gms.internal.pal.a;
import java.io.ByteArrayOutputStream;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.algorithms.SignatureAlgorithm;
import org.apache.xml.security.signature.XMLSignatureException;

/* loaded from: classes5.dex */
public class SignerOutputStream extends ByteArrayOutputStream {

    /* renamed from: b, reason: collision with root package name */
    static Log f57357b;

    /* renamed from: c, reason: collision with root package name */
    static Class f57358c;

    /* renamed from: a, reason: collision with root package name */
    final SignatureAlgorithm f57359a;

    static {
        Class clsA = f57358c;
        if (clsA == null) {
            clsA = a("org.apache.xml.security.utils.SignerOutputStream");
            f57358c = clsA;
        }
        f57357b = LogFactory.getLog(clsA.getName());
    }

    public SignerOutputStream(SignatureAlgorithm signatureAlgorithm) {
        this.f57359a = signatureAlgorithm;
    }

    public static Class a(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw a.g(e2);
        }
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public void write(int i2) {
        try {
            this.f57359a.a((byte) i2);
        } catch (XMLSignatureException e2) {
            StringBuffer stringBuffer = new StringBuffer("");
            stringBuffer.append(e2);
            throw new RuntimeException(stringBuffer.toString());
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        try {
            this.f57359a.a(bArr);
        } catch (XMLSignatureException e2) {
            StringBuffer stringBuffer = new StringBuffer("");
            stringBuffer.append(e2);
            throw new RuntimeException(stringBuffer.toString());
        }
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) {
        if (f57357b.isDebugEnabled()) {
            f57357b.debug("Canonicalized SignedInfo:");
            StringBuffer stringBuffer = new StringBuffer(i3);
            for (int i4 = i2; i4 < i2 + i3; i4++) {
                stringBuffer.append((char) bArr[i4]);
            }
            f57357b.debug(stringBuffer.toString());
        }
        try {
            this.f57359a.a(bArr, i2, i3);
        } catch (XMLSignatureException e2) {
            StringBuffer stringBuffer2 = new StringBuffer("");
            stringBuffer2.append(e2);
            throw new RuntimeException(stringBuffer2.toString());
        }
    }
}
