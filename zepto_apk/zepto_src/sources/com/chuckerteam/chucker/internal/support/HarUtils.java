package com.chuckerteam.chucker.internal.support;

import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public final class HarUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final HarUtils f16765a = new HarUtils();

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(java.util.List r6, java.lang.String r7, java.lang.String r8, kotlin.coroutines.jvm.internal.ContinuationImpl r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof com.chuckerteam.chucker.internal.support.HarUtils$harStringFromTransactions$1
            if (r0 == 0) goto L13
            r0 = r9
            com.chuckerteam.chucker.internal.support.HarUtils$harStringFromTransactions$1 r0 = (com.chuckerteam.chucker.internal.support.HarUtils$harStringFromTransactions$1) r0
            int r1 = r0.f16768c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f16768c = r1
            goto L18
        L13:
            com.chuckerteam.chucker.internal.support.HarUtils$harStringFromTransactions$1 r0 = new com.chuckerteam.chucker.internal.support.HarUtils$harStringFromTransactions$1
            r0.<init>(r5, r9)
        L18:
            java.lang.Object r9 = r0.f16766a
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f16768c
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.ResultKt.b(r9)
            goto L43
        L27:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L2f:
            kotlin.ResultKt.b(r9)
            kotlinx.coroutines.scheduling.DefaultScheduler r9 = kotlinx.coroutines.Dispatchers.f54091a
            com.chuckerteam.chucker.internal.support.HarUtils$harStringFromTransactions$2 r2 = new com.chuckerteam.chucker.internal.support.HarUtils$harStringFromTransactions$2
            r4 = 0
            r2.<init>(r6, r7, r8, r4)
            r0.f16768c = r3
            java.lang.Object r9 = kotlinx.coroutines.BuildersKt.e(r9, r2, r0)
            if (r9 != r1) goto L43
            return r1
        L43:
            java.lang.String r6 = "withContext(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r6)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chuckerteam.chucker.internal.support.HarUtils.a(java.util.List, java.lang.String, java.lang.String, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}
