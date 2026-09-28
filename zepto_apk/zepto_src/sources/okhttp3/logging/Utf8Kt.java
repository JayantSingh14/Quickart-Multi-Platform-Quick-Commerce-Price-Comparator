package okhttp3.logging;

import java.io.EOFException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;

@Metadata
/* loaded from: classes3.dex */
public final class Utf8Kt {
    public static final boolean a(Buffer buffer) {
        Buffer buffer2;
        int i2;
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        try {
            buffer2 = new Buffer();
            long j2 = buffer.f56914b;
            long j3 = 64;
            if (j2 <= 64) {
                j3 = j2;
            }
            buffer.e(buffer2, 0L, j3);
        } catch (EOFException unused) {
        }
        for (i2 = 0; i2 < 16; i2++) {
            if (buffer2.l()) {
                return true;
            }
            int iC1 = buffer2.c1();
            if (Character.isISOControl(iC1) && !Character.isWhitespace(iC1)) {
                return false;
            }
        }
        return true;
    }
}
