package com.facebook.imageutils;

import com.facebook.common.logging.FLog;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class TiffUtil {

    @Metadata
    public static final class TiffHeader {

        /* renamed from: a, reason: collision with root package name */
        public boolean f18396a;

        /* renamed from: b, reason: collision with root package name */
        public int f18397b;
    }

    public static final int a(InputStream stream, int i2) throws IOException {
        int i3;
        int i4;
        boolean z;
        Intrinsics.checkNotNullParameter(stream, "stream");
        TiffHeader tiffHeader = new TiffHeader();
        if (i2 > 8) {
            int iA = StreamProcessor.a(stream, 4, false);
            if (iA == 1229531648 || iA == 1296891946) {
                boolean z2 = iA == 1229531648;
                tiffHeader.f18396a = z2;
                int iA2 = StreamProcessor.a(stream, 4, z2);
                tiffHeader.f18397b = iA2;
                i3 = i2 - 8;
                if (iA2 < 8 || iA2 - 8 > i3) {
                    FLog.e(TiffUtil.class, "Invalid offset");
                }
            } else {
                FLog.e(TiffUtil.class, "Invalid TIFF header");
            }
            i3 = 0;
        } else {
            i3 = 0;
        }
        int i5 = tiffHeader.f18397b - 8;
        if (i3 != 0 && i5 <= i3) {
            stream.skip(i5);
            int i6 = i3 - i5;
            boolean z3 = tiffHeader.f18396a;
            if (i6 < 14) {
                i4 = 0;
                z = tiffHeader.f18396a;
                if (i4 >= 10 && StreamProcessor.a(stream, 2, z) == 3 && StreamProcessor.a(stream, 4, z) == 1) {
                    return StreamProcessor.a(stream, 2, z);
                }
            } else {
                int iA3 = StreamProcessor.a(stream, 2, z3);
                int i7 = i6 - 2;
                while (true) {
                    int i8 = iA3 - 1;
                    if (iA3 <= 0 || i7 < 12) {
                        break;
                    }
                    i4 = i7 - 2;
                    if (StreamProcessor.a(stream, 2, z3) == 274) {
                        break;
                    }
                    stream.skip(10L);
                    i7 -= 12;
                    iA3 = i8;
                }
                z = tiffHeader.f18396a;
                if (i4 >= 10) {
                    return StreamProcessor.a(stream, 2, z);
                }
            }
        }
        return 0;
    }
}
