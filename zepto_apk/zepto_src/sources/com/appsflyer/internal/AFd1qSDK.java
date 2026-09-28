package com.appsflyer.internal;

import java.util.ArrayList;
import kotlin.ExceptionsKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension
/* loaded from: classes3.dex */
public final class AFd1qSDK {
    @NotNull
    public static final AFc1cSDK getCurrencyIso4217Code(@NotNull Throwable th, @NotNull String str) {
        Intrinsics.checkNotNullParameter(th, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(th, "");
        String name = th.getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "");
        return new AFc1cSDK(android.support.v4.media.b.l(name, ": ", str), getMediationNetwork(th), ExceptionsKt.b(th), 0, 8, null);
    }

    @NotNull
    private static String getMediationNetwork(@NotNull Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        Intrinsics.checkNotNullParameter(th, "");
        Intrinsics.checkNotNullParameter(th, "");
        StackTraceElement[] stackTrace = th.getStackTrace();
        Intrinsics.checkNotNullExpressionValue(stackTrace, "");
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : stackTrace) {
            String className = stackTraceElement.getClassName();
            Intrinsics.checkNotNullExpressionValue(className, "");
            if (!StringsKt.O(className, "com.appsflyer", false)) {
                stackTraceElement = null;
            }
            if (stackTraceElement != null) {
                arrayList.add(stackTraceElement);
            }
        }
        String str = th + StringUtils.LF + CollectionsKt.E(arrayList, StringUtils.LF, null, null, new Function1<StackTraceElement, CharSequence>() { // from class: com.appsflyer.internal.AFd1qSDK.5
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            /* renamed from: AFAdRevenueData, reason: merged with bridge method [inline-methods] */
            public final CharSequence invoke(@NotNull StackTraceElement stackTraceElement2) {
                Intrinsics.checkNotNullParameter(stackTraceElement2, "");
                return "at " + stackTraceElement2;
            }
        }, 30);
        Intrinsics.checkNotNullParameter(str, "");
        return AFd1rSDK.getCurrencyIso4217Code(str, MessageDigestAlgorithms.SHA_256);
    }
}
