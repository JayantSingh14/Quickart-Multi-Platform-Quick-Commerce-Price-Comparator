package okio.internal;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import okio.Segment;

@Metadata
@JvmName
@SourceDebugExtension
/* renamed from: okio.internal.-Buffer, reason: invalid class name */
/* loaded from: classes.dex */
public final class Buffer {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f57009a;

    static {
        Intrinsics.checkNotNullParameter("0123456789abcdef", "<this>");
        byte[] bytes = "0123456789abcdef".getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        f57009a = bytes;
    }

    public static final boolean a(Segment segment, int i2, byte[] bytes, int i3) {
        Intrinsics.checkNotNullParameter(segment, "segment");
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        int i4 = segment.f56990c;
        byte[] bArr = segment.f56988a;
        for (int i5 = 1; i5 < i3; i5++) {
            if (i2 == i4) {
                segment = segment.f56993f;
                Intrinsics.c(segment);
                i2 = segment.f56989b;
                i4 = segment.f56990c;
                bArr = segment.f56988a;
            }
            if (bArr[i2] != bytes[i5]) {
                return false;
            }
            i2++;
        }
        return true;
    }

    public static final String b(okio.Buffer buffer, long j2) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        if (j2 > 0) {
            long j3 = j2 - 1;
            if (buffer.x(j3) == 13) {
                String strT0 = buffer.T0(j3, Charsets.UTF_8);
                buffer.j1(2L);
                return strT0;
            }
        }
        buffer.getClass();
        String strT02 = buffer.T0(j2, Charsets.UTF_8);
        buffer.j1(1L);
        return strT02;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0061, code lost:
    
        if (r18 == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0063, code lost:
    
        return -2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0086, code lost:
    
        return r9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final int c(okio.Buffer r16, okio.Options r17, boolean r18) {
        /*
            Method dump skipped, instructions count: 176
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.Buffer.c(okio.Buffer, okio.Options, boolean):int");
    }
}
