package com.facebook.react.modules.debug;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class DidJSUpdateUiDuringFrameDetectorKt {
    public static final void a(ArrayList arrayList, long j2) {
        int size = arrayList.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            if (((Number) arrayList.get(i3)).longValue() < j2) {
                i2++;
            }
        }
        if (i2 > 0) {
            int i4 = size - i2;
            for (int i5 = 0; i5 < i4; i5++) {
                arrayList.set(i5, arrayList.get(i5 + i2));
            }
            CollectionsKt.w(i2, arrayList);
        }
    }

    public static final long b(ArrayList arrayList, long j2, long j3) {
        Iterator it = arrayList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        long j4 = -1;
        while (it.hasNext()) {
            Object next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            long jLongValue = ((Number) next).longValue();
            if (j2 <= jLongValue && jLongValue < j3) {
                j4 = jLongValue;
            } else if (jLongValue >= j3) {
                break;
            }
        }
        return j4;
    }

    public static final boolean c(ArrayList arrayList, long j2, long j3) {
        if (arrayList != null && arrayList.isEmpty()) {
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            long jLongValue = ((Number) it.next()).longValue();
            if (j2 <= jLongValue && jLongValue < j3) {
                return true;
            }
        }
        return false;
    }
}
