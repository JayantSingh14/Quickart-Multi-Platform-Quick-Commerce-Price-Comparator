package okio.internal;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.C0124SegmentedByteString;

@Metadata
@JvmName
@SourceDebugExtension
/* renamed from: okio.internal.-SegmentedByteString, reason: invalid class name */
/* loaded from: classes3.dex */
public final class SegmentedByteString {
    public static final int a(C0124SegmentedByteString c0124SegmentedByteString, int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(c0124SegmentedByteString, "<this>");
        int[] iArr = c0124SegmentedByteString.f56999f;
        int i4 = i2 + 1;
        int length = c0124SegmentedByteString.f56998e.length;
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        int i5 = length - 1;
        int i6 = 0;
        while (true) {
            if (i6 <= i5) {
                i3 = (i6 + i5) >>> 1;
                int i7 = iArr[i3];
                if (i7 >= i4) {
                    if (i7 <= i4) {
                        break;
                    }
                    i5 = i3 - 1;
                } else {
                    i6 = i3 + 1;
                }
            } else {
                i3 = (-i6) - 1;
                break;
            }
        }
        return i3 >= 0 ? i3 : ~i3;
    }
}
