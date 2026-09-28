package com.google.android.gms.internal.ads;

import com.google.android.gms.tasks.Task;

/* loaded from: classes4.dex */
public final class zzfjp {

    /* renamed from: a, reason: collision with root package name */
    public static Task f31276a;

    /* renamed from: b, reason: collision with root package name */
    public static com.google.android.gms.internal.appset.zzr f31277b;

    /* renamed from: c, reason: collision with root package name */
    public static final Object f31278c = new Object();

    /* JADX WARN: Removed duplicated region for block: B:27:0x002f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(android.content.Context r4, boolean r5) {
        /*
            java.lang.Object r0 = com.google.android.gms.internal.ads.zzfjp.f31278c
            java.lang.String r1 = "Failed to get app set ID info: "
            monitor-enter(r0)
            com.google.android.gms.internal.appset.zzr r2 = com.google.android.gms.internal.ads.zzfjp.f31277b     // Catch: java.lang.Throwable -> L23
            if (r2 != 0) goto L10
            com.google.android.gms.internal.appset.zzr r2 = new com.google.android.gms.internal.appset.zzr     // Catch: java.lang.Throwable -> L23
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L23
            com.google.android.gms.internal.ads.zzfjp.f31277b = r2     // Catch: java.lang.Throwable -> L23
        L10:
            com.google.android.gms.tasks.Task r4 = com.google.android.gms.internal.ads.zzfjp.f31276a     // Catch: java.lang.Throwable -> L23
            if (r4 == 0) goto L2f
            boolean r4 = r4.o()     // Catch: java.lang.Throwable -> L23
            if (r4 == 0) goto L25
            com.google.android.gms.tasks.Task r4 = com.google.android.gms.internal.ads.zzfjp.f31276a     // Catch: java.lang.Throwable -> L23
            boolean r4 = r4.p()     // Catch: java.lang.Throwable -> L23
            if (r4 == 0) goto L2f
            goto L25
        L23:
            r4 = move-exception
            goto L69
        L25:
            if (r5 == 0) goto L67
            com.google.android.gms.tasks.Task r4 = com.google.android.gms.internal.ads.zzfjp.f31276a     // Catch: java.lang.Throwable -> L23
            boolean r4 = r4.o()     // Catch: java.lang.Throwable -> L23
            if (r4 == 0) goto L67
        L2f:
            com.google.android.gms.internal.appset.zzr r4 = com.google.android.gms.internal.ads.zzfjp.f31277b     // Catch: java.lang.Throwable -> L23 java.lang.ArrayIndexOutOfBoundsException -> L40
            java.lang.String r5 = "the appSetIdClient shouldn't be null"
            java.lang.Object r4 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r4, r5)     // Catch: java.lang.Throwable -> L23 java.lang.ArrayIndexOutOfBoundsException -> L40
            com.google.android.gms.appset.AppSetIdClient r4 = (com.google.android.gms.appset.AppSetIdClient) r4     // Catch: java.lang.Throwable -> L23 java.lang.ArrayIndexOutOfBoundsException -> L40
            com.google.android.gms.tasks.Task r4 = r4.a()     // Catch: java.lang.Throwable -> L23 java.lang.ArrayIndexOutOfBoundsException -> L40
            com.google.android.gms.internal.ads.zzfjp.f31276a = r4     // Catch: java.lang.Throwable -> L23 java.lang.ArrayIndexOutOfBoundsException -> L40
            goto L67
        L40:
            r4 = move-exception
            java.lang.String r5 = r4.getMessage()     // Catch: java.lang.Throwable -> L23
            java.lang.String r2 = java.lang.String.valueOf(r5)     // Catch: java.lang.Throwable -> L23
            int r2 = r2.length()     // Catch: java.lang.Throwable -> L23
            int r2 = r2 + 31
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L23
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L23
            r3.append(r1)     // Catch: java.lang.Throwable -> L23
            r3.append(r5)     // Catch: java.lang.Throwable -> L23
            java.lang.String r5 = r3.toString()     // Catch: java.lang.Throwable -> L23
            com.google.android.gms.ads.internal.util.zze.k(r5)     // Catch: java.lang.Throwable -> L23
            com.google.android.gms.tasks.Task r4 = com.google.android.gms.tasks.Tasks.d(r4)     // Catch: java.lang.Throwable -> L23
            com.google.android.gms.internal.ads.zzfjp.f31276a = r4     // Catch: java.lang.Throwable -> L23
        L67:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L23
            return
        L69:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L23
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfjp.a(android.content.Context, boolean):void");
    }
}
