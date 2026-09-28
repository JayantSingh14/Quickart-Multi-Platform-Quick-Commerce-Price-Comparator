package com.facebook.imageutils;

import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class StreamProcessor {
    public static final int a(InputStream stream, int i2, boolean z) throws IOException {
        int i3;
        Intrinsics.checkNotNullParameter(stream, "stream");
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = stream.read();
            if (i6 == -1) {
                throw new IOException("no more bytes");
            }
            if (z) {
                i3 = (i6 & 255) << (i5 * 8);
            } else {
                i4 <<= 8;
                i3 = i6 & 255;
            }
            i4 |= i3;
        }
        return i4;
    }
}
