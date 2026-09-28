package androidx.media3.common.util;

import android.media.MediaFormat;
import java.nio.ByteBuffer;
import java.util.List;

@UnstableApi
/* loaded from: classes3.dex */
public final class MediaFormatUtil {
    public static void a(MediaFormat mediaFormat, String str, int i2) {
        if (i2 != -1) {
            mediaFormat.setInteger(str, i2);
        }
    }

    public static void b(MediaFormat mediaFormat, List list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            mediaFormat.setByteBuffer(android.support.v4.media.b.f(i2, "csd-"), ByteBuffer.wrap((byte[]) list.get(i2)));
        }
    }
}
