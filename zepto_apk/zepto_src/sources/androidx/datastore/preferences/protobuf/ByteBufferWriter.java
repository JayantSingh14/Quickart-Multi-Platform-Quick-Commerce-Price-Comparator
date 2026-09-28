package androidx.datastore.preferences.protobuf;

import com.appsflyer.AppsFlyerProperties;

/* loaded from: classes3.dex */
final class ByteBufferWriter {
    static {
        Class<?> cls;
        new ThreadLocal();
        try {
            cls = Class.forName("java.io.FileOutputStream");
        } catch (ClassNotFoundException unused) {
            cls = null;
        }
        if (cls != null) {
            try {
                if (UnsafeUtil.f4185e) {
                    UnsafeUtil.f4183c.n(cls.getDeclaredField(AppsFlyerProperties.CHANNEL));
                }
            } catch (Throwable unused2) {
            }
        }
    }
}
