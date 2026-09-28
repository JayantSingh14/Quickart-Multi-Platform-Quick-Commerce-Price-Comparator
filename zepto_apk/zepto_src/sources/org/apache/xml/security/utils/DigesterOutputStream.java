package org.apache.xml.security.utils;

import com.google.android.gms.internal.pal.a;
import java.io.ByteArrayOutputStream;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.algorithms.MessageDigestAlgorithm;

/* loaded from: classes5.dex */
public class DigesterOutputStream extends ByteArrayOutputStream {

    /* renamed from: b, reason: collision with root package name */
    static Log f57329b;

    /* renamed from: c, reason: collision with root package name */
    static Class f57330c;

    /* renamed from: a, reason: collision with root package name */
    final MessageDigestAlgorithm f57331a;

    static {
        Class clsA = f57330c;
        if (clsA == null) {
            clsA = a("org.apache.xml.security.utils.DigesterOutputStream");
            f57330c = clsA;
        }
        f57329b = LogFactory.getLog(clsA.getName());
    }

    public DigesterOutputStream(MessageDigestAlgorithm messageDigestAlgorithm) {
        this.f57331a = messageDigestAlgorithm;
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
        this.f57331a.a((byte) i2);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) {
        if (f57329b.isDebugEnabled()) {
            f57329b.debug("Pre-digested input:");
            StringBuffer stringBuffer = new StringBuffer(i3);
            for (int i4 = i2; i4 < i2 + i3; i4++) {
                stringBuffer.append((char) bArr[i4]);
            }
            f57329b.debug(stringBuffer.toString());
        }
        this.f57331a.a(bArr, i2, i3);
    }

    public byte[] a() {
        return this.f57331a.b();
    }
}
