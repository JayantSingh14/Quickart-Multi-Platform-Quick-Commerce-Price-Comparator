package org.apache.xml.security.utils;

import com.google.android.gms.internal.pal.a;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/* loaded from: classes5.dex */
public class JavaUtils {

    /* renamed from: a, reason: collision with root package name */
    static Log f57353a;

    /* renamed from: b, reason: collision with root package name */
    static Class f57354b;

    static {
        Class clsA = f57354b;
        if (clsA == null) {
            clsA = a("org.apache.xml.security.utils.JavaUtils");
            f57354b = clsA;
        }
        f57353a = LogFactory.getLog(clsA.getName());
    }

    private JavaUtils() {
    }

    public static Class a(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw a.g(e2);
        }
    }

    public static byte[] a(InputStream inputStream) throws IOException {
        UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int i2 = inputStream.read(bArr);
            if (i2 <= 0) {
                return unsyncByteArrayOutputStream.a();
            }
            unsyncByteArrayOutputStream.write(bArr, 0, i2);
        }
    }
}
