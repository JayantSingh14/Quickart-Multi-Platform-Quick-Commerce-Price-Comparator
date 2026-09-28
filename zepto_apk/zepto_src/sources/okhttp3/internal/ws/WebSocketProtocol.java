package okhttp3.internal.ws;

import android.support.v4.media.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.Buffer;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class WebSocketProtocol {
    public static String a(int i2) {
        if (i2 < 1000 || i2 >= 5000) {
            return b.f(i2, "Code must be in range [1000,5000): ");
        }
        if ((1004 > i2 || i2 >= 1007) && (1015 > i2 || i2 >= 3000)) {
            return null;
        }
        return b.g(i2, "Code ", " is reserved and may not be used.");
    }

    public static void b(Buffer.UnsafeCursor cursor, byte[] key) {
        long j2;
        Intrinsics.checkNotNullParameter(cursor, "cursor");
        Intrinsics.checkNotNullParameter(key, "key");
        int length = key.length;
        int i2 = 0;
        do {
            byte[] bArr = cursor.f56919e;
            int i3 = cursor.f56920f;
            int i4 = cursor.f56921g;
            if (bArr != null) {
                while (i3 < i4) {
                    int i5 = i2 % length;
                    bArr[i3] = (byte) (bArr[i3] ^ key[i5]);
                    i3++;
                    i2 = i5 + 1;
                }
            }
            long j3 = cursor.f56918d;
            Buffer buffer = cursor.f56915a;
            Intrinsics.c(buffer);
            if (j3 == buffer.f56914b) {
                throw new IllegalStateException("no more bytes");
            }
            j2 = cursor.f56918d;
        } while (cursor.b(j2 == -1 ? 0L : j2 + (cursor.f56921g - cursor.f56920f)) != -1);
    }
}
