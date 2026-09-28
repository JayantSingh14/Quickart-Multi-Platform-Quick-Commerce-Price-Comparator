package okio;

import android.support.v4.media.b;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okio.Buffer;

@Metadata
@JvmName
@SourceDebugExtension
/* renamed from: okio.-SegmentedByteString, reason: invalid class name */
/* loaded from: classes.dex */
public final class SegmentedByteString {

    /* renamed from: a, reason: collision with root package name */
    public static final Buffer.UnsafeCursor f56899a = new Buffer.UnsafeCursor();

    /* renamed from: b, reason: collision with root package name */
    public static final int f56900b = -1234567890;

    public static final boolean a(byte[] a2, int i2, int i3, byte[] b2, int i4) {
        Intrinsics.checkNotNullParameter(a2, "a");
        Intrinsics.checkNotNullParameter(b2, "b");
        for (int i5 = 0; i5 < i4; i5++) {
            if (a2[i5 + i2] != b2[i5 + i3]) {
                return false;
            }
        }
        return true;
    }

    public static final void b(long j2, long j3, long j4) {
        if ((j3 | j4) < 0 || j3 > j2 || j2 - j3 < j4) {
            StringBuilder sbV = b.v(j2, "size=", " offset=");
            sbV.append(j3);
            sbV.append(" byteCount=");
            sbV.append(j4);
            throw new ArrayIndexOutOfBoundsException(sbV.toString());
        }
    }

    public static final int c(ByteString byteString, int i2) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        return i2 == f56900b ? byteString.d() : i2;
    }

    public static final String d(byte b2) {
        char[] cArr = okio.internal.ByteString.f57010a;
        char[] cArr2 = {cArr[(b2 >> 4) & 15], cArr[b2 & 15]};
        Intrinsics.checkNotNullParameter(cArr2, "<this>");
        return new String(cArr2);
    }

    public static final String e(int i2) {
        int i3 = 0;
        if (i2 == 0) {
            return "0";
        }
        char[] cArr = okio.internal.ByteString.f57010a;
        char[] cArr2 = {cArr[(i2 >> 28) & 15], cArr[(i2 >> 24) & 15], cArr[(i2 >> 20) & 15], cArr[(i2 >> 16) & 15], cArr[(i2 >> 12) & 15], cArr[(i2 >> 8) & 15], cArr[(i2 >> 4) & 15], cArr[i2 & 15]};
        while (i3 < 8 && cArr2[i3] == '0') {
            i3++;
        }
        return StringsKt.m(cArr2, i3, 8);
    }
}
