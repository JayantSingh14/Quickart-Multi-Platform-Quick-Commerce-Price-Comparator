package com.chuckerteam.chucker.internal.support;

import com.brentvatne.common.react.h;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class FormatUtils {
    public static String a(long j2) {
        if (j2 < 1000) {
            return j2 + " B";
        }
        double d2 = j2;
        double d3 = 1000;
        int iLog = (int) (Math.log(d2) / Math.log(d3));
        String str = String.format(Locale.US, "%.1f %sB", Arrays.copyOf(new Object[]{Double.valueOf(d2 / Math.pow(d3, iLog)), "kMGTPE".charAt(iLog - 1) + ""}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public static String b(List list, boolean z) {
        String strE;
        return (list == null || (strE = CollectionsKt.E(list, "", null, null, new h(z, 5), 30)) == null) ? "" : strE;
    }
}
