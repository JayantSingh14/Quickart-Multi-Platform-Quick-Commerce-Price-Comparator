package com.google.android.gms.internal.ads;

import androidx.datastore.core.DataStore;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorCoroutineDispatcherImpl;
import kotlinx.coroutines.sync.MutexImpl;
import kotlinx.coroutines.sync.MutexKt;

/* loaded from: classes4.dex */
public final class zzfza implements zzfxt {

    /* renamed from: a, reason: collision with root package name */
    public final CoroutineScope f32075a;

    /* renamed from: b, reason: collision with root package name */
    public final MutexImpl f32076b;

    /* renamed from: c, reason: collision with root package name */
    public final MutexImpl f32077c;

    /* renamed from: d, reason: collision with root package name */
    public final MutexImpl f32078d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f32079e;

    /* renamed from: f, reason: collision with root package name */
    public zzfxr f32080f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f32081g;

    /* renamed from: h, reason: collision with root package name */
    public final DataStore f32082h;

    /* renamed from: i, reason: collision with root package name */
    public final zzduo f32083i;

    public zzfza(DataStore adQualityDataStore, zzfzc coroutineScopeProvider, zzduo dataPinger, zzfyc clock) {
        Intrinsics.checkNotNullParameter(adQualityDataStore, "adQualityDataStore");
        Intrinsics.checkNotNullParameter(coroutineScopeProvider, "coroutineScopeProvider");
        Intrinsics.checkNotNullParameter(dataPinger, "dataPinger");
        Intrinsics.checkNotNullParameter(clock, "clock");
        this.f32083i = dataPinger;
        this.f32075a = CoroutineScopeKt.a(new ExecutorCoroutineDispatcherImpl(((zzfzd) coroutineScopeProvider).f32086a));
        this.f32076b = MutexKt.a();
        this.f32077c = MutexKt.a();
        this.f32078d = MutexKt.a();
        this.f32082h = adQualityDataStore;
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0108, code lost:
    
        if (i(r2) == r3) goto L63;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Type inference failed for: r17v0, types: [com.google.android.gms.internal.ads.zzfza] */
    /* JADX WARN: Type inference failed for: r4v0, types: [int] */
    /* JADX WARN: Type inference failed for: r4v1, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r4v17, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v5, types: [kotlinx.coroutines.sync.Mutex] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(kotlin.coroutines.jvm.internal.ContinuationImpl r18) {
        /*
            Method dump skipped, instructions count: 278
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfza.a(kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(java.lang.String r7, kotlin.coroutines.jvm.internal.ContinuationImpl r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.google.android.gms.internal.ads.zzfyo
            if (r0 == 0) goto L13
            r0 = r8
            com.google.android.gms.internal.ads.zzfyo r0 = (com.google.android.gms.internal.ads.zzfyo) r0
            int r1 = r0.f32034e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f32034e = r1
            goto L18
        L13:
            com.google.android.gms.internal.ads.zzfyo r0 = new com.google.android.gms.internal.ads.zzfyo
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.f32032c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f32034e
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            long r1 = r0.f32031b
            kotlinx.coroutines.sync.MutexImpl r7 = r0.f32030a
            java.lang.String r0 = r0.f32035f
            kotlin.ResultKt.b(r8)
            goto L4f
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L35:
            kotlin.ResultKt.b(r8)
            kotlinx.coroutines.sync.MutexImpl r8 = r6.f32076b
            long r4 = java.lang.System.currentTimeMillis()
            r0.f32035f = r7
            r0.f32030a = r8
            r0.f32031b = r4
            r0.f32034e = r3
            java.lang.Object r0 = r8.c(r0)
            if (r0 == r1) goto L8d
            r0 = r7
            r7 = r8
            r1 = r4
        L4f:
            r8 = 0
            boolean r4 = r6.f32079e     // Catch: java.lang.Throwable -> L5a
            if (r4 == 0) goto L5c
            kotlin.Unit r0 = kotlin.Unit.f53572a     // Catch: java.lang.Throwable -> L5a
            r7.b(r8)
            return r0
        L5a:
            r0 = move-exception
            goto L89
        L5c:
            r6.f32079e = r3     // Catch: java.lang.Throwable -> L5a
            com.google.android.gms.internal.ads.zzfxs r3 = com.google.android.gms.internal.ads.zzfxs.T()     // Catch: java.lang.Throwable -> L5a
            com.google.android.gms.internal.ads.zzial r3 = r3.v()     // Catch: java.lang.Throwable -> L5a
            java.lang.String r4 = "toBuilder(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)     // Catch: java.lang.Throwable -> L5a
            com.google.android.gms.internal.ads.zzfxr r3 = (com.google.android.gms.internal.ads.zzfxr) r3     // Catch: java.lang.Throwable -> L5a
            r6.f32080f = r3     // Catch: java.lang.Throwable -> L5a
            r3.j()     // Catch: java.lang.Throwable -> L5a
            com.google.android.gms.internal.ads.zziar r4 = r3.f34638b     // Catch: java.lang.Throwable -> L5a
            com.google.android.gms.internal.ads.zzfxs r4 = (com.google.android.gms.internal.ads.zzfxs) r4     // Catch: java.lang.Throwable -> L5a
            r4.U(r0)     // Catch: java.lang.Throwable -> L5a
            r3.j()     // Catch: java.lang.Throwable -> L5a
            com.google.android.gms.internal.ads.zziar r0 = r3.f34638b     // Catch: java.lang.Throwable -> L5a
            com.google.android.gms.internal.ads.zzfxs r0 = (com.google.android.gms.internal.ads.zzfxs) r0     // Catch: java.lang.Throwable -> L5a
            r0.a0(r1)     // Catch: java.lang.Throwable -> L5a
            r7.b(r8)
            kotlin.Unit r7 = kotlin.Unit.f53572a
            return r7
        L89:
            r7.b(r8)
            throw r0
        L8d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfza.b(java.lang.String, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00a2, code lost:
    
        if (k(r0) != r1) goto L41;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0085 A[Catch: all -> 0x00ae, TRY_LEAVE, TryCatch #1 {all -> 0x00ae, blocks: (B:33:0x0081, B:35:0x0085, B:43:0x00a8, B:44:0x00ad), top: B:52:0x0081 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a8 A[Catch: all -> 0x00ae, TRY_ENTER, TryCatch #1 {all -> 0x00ae, blocks: (B:33:0x0081, B:35:0x0085, B:43:0x00a8, B:44:0x00ad), top: B:52:0x0081 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(kotlin.coroutines.jvm.internal.ContinuationImpl r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof com.google.android.gms.internal.ads.zzfyk
            if (r0 == 0) goto L13
            r0 = r10
            com.google.android.gms.internal.ads.zzfyk r0 = (com.google.android.gms.internal.ads.zzfyk) r0
            int r1 = r0.f32020e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f32020e = r1
            goto L18
        L13:
            com.google.android.gms.internal.ads.zzfyk r0 = new com.google.android.gms.internal.ads.zzfyk
            r0.<init>(r9, r10)
        L18:
            java.lang.Object r10 = r0.f32018c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f32020e
            r3 = 0
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            if (r2 == 0) goto L4c
            if (r2 == r7) goto L46
            if (r2 == r6) goto L3e
            if (r2 == r5) goto L3a
            if (r2 != r4) goto L32
            kotlin.ResultKt.b(r10)
            goto La5
        L32:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L3a:
            kotlin.ResultKt.b(r10)
            goto L9c
        L3e:
            long r6 = r0.f32017b
            kotlinx.coroutines.sync.MutexImpl r2 = r0.f32016a
            kotlin.ResultKt.b(r10)
            goto L81
        L46:
            kotlinx.coroutines.sync.MutexImpl r2 = r0.f32016a
            kotlin.ResultKt.b(r10)
            goto L5b
        L4c:
            kotlin.ResultKt.b(r10)
            kotlinx.coroutines.sync.MutexImpl r2 = r9.f32077c
            r0.f32016a = r2
            r0.f32020e = r7
            java.lang.Object r10 = r2.c(r0)
            if (r10 == r1) goto Lb7
        L5b:
            boolean r10 = r9.f32081g     // Catch: java.lang.Throwable -> L65
            if (r10 == 0) goto L67
            kotlin.Unit r10 = kotlin.Unit.f53572a     // Catch: java.lang.Throwable -> L65
            r2.b(r3)
            return r10
        L65:
            r10 = move-exception
            goto Lb3
        L67:
            r9.f32081g = r7     // Catch: java.lang.Throwable -> L65
            kotlin.Unit r10 = kotlin.Unit.f53572a     // Catch: java.lang.Throwable -> L65
            r2.b(r3)
            kotlinx.coroutines.sync.MutexImpl r2 = r9.f32076b
            long r7 = java.lang.System.currentTimeMillis()
            r0.f32016a = r2
            r0.f32017b = r7
            r0.f32020e = r6
            java.lang.Object r10 = r2.c(r0)
            if (r10 == r1) goto Lb7
            r6 = r7
        L81:
            com.google.android.gms.internal.ads.zzfxr r10 = r9.f32080f     // Catch: java.lang.Throwable -> Lae
            if (r10 == 0) goto La8
            r10.j()     // Catch: java.lang.Throwable -> Lae
            com.google.android.gms.internal.ads.zziar r10 = r10.f34638b     // Catch: java.lang.Throwable -> Lae
            com.google.android.gms.internal.ads.zzfxs r10 = (com.google.android.gms.internal.ads.zzfxs) r10     // Catch: java.lang.Throwable -> Lae
            r10.d0(r6)     // Catch: java.lang.Throwable -> Lae
            r2.b(r3)
            r0.f32016a = r3
            r0.f32020e = r5
            java.lang.Object r10 = r9.j(r6, r0)
            if (r10 == r1) goto Lb7
        L9c:
            r0.f32020e = r4
            java.lang.Object r10 = r9.k(r0)
            if (r10 != r1) goto La5
            goto Lb7
        La5:
            kotlin.Unit r10 = kotlin.Unit.f53572a
            return r10
        La8:
            java.lang.String r10 = "adQualityDataBuilder"
            kotlin.jvm.internal.Intrinsics.h(r10)     // Catch: java.lang.Throwable -> Lae
            throw r3     // Catch: java.lang.Throwable -> Lae
        Lae:
            r10 = move-exception
            r2.b(r3)
            throw r10
        Lb3:
            r2.b(r3)
            throw r10
        Lb7:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfza.c(kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x007b A[Catch: all -> 0x00db, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x00db, blocks: (B:30:0x0075, B:33:0x007b, B:36:0x0087, B:38:0x008b, B:40:0x00af, B:42:0x00bf, B:44:0x00c3, B:45:0x00d7, B:46:0x00da, B:49:0x00de, B:50:0x00e1, B:51:0x00e2, B:52:0x00e5, B:53:0x00e6, B:55:0x00ea, B:57:0x00f4, B:59:0x00f8, B:61:0x011c, B:62:0x0130, B:63:0x0133, B:64:0x0134, B:65:0x0137, B:66:0x0138, B:68:0x013c, B:71:0x014c, B:72:0x014f, B:73:0x0150, B:74:0x0153, B:75:0x0154, B:76:0x0157), top: B:83:0x0075 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0154 A[Catch: all -> 0x00db, TryCatch #1 {all -> 0x00db, blocks: (B:30:0x0075, B:33:0x007b, B:36:0x0087, B:38:0x008b, B:40:0x00af, B:42:0x00bf, B:44:0x00c3, B:45:0x00d7, B:46:0x00da, B:49:0x00de, B:50:0x00e1, B:51:0x00e2, B:52:0x00e5, B:53:0x00e6, B:55:0x00ea, B:57:0x00f4, B:59:0x00f8, B:61:0x011c, B:62:0x0130, B:63:0x0133, B:64:0x0134, B:65:0x0137, B:66:0x0138, B:68:0x013c, B:71:0x014c, B:72:0x014f, B:73:0x0150, B:74:0x0153, B:75:0x0154, B:76:0x0157), top: B:83:0x0075 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(kotlin.coroutines.jvm.internal.ContinuationImpl r12) {
        /*
            Method dump skipped, instructions count: 353
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfza.d(kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00f2, code lost:
    
        if (h(r14, r0) == r1) goto L68;
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0092 A[Catch: all -> 0x00f8, TRY_ENTER, TryCatch #0 {all -> 0x00f8, blocks: (B:35:0x008c, B:38:0x0092, B:40:0x00a0, B:42:0x00b7, B:44:0x00c5, B:56:0x00fa, B:57:0x00fd, B:58:0x00fe, B:59:0x0101, B:60:0x0102, B:61:0x0105, B:62:0x0106, B:63:0x0109), top: B:69:0x008c }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0106 A[Catch: all -> 0x00f8, TryCatch #0 {all -> 0x00f8, blocks: (B:35:0x008c, B:38:0x0092, B:40:0x00a0, B:42:0x00b7, B:44:0x00c5, B:56:0x00fa, B:57:0x00fd, B:58:0x00fe, B:59:0x0101, B:60:0x0102, B:61:0x0105, B:62:0x0106, B:63:0x0109), top: B:69:0x008c }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(kotlin.coroutines.jvm.internal.ContinuationImpl r14) {
        /*
            Method dump skipped, instructions count: 275
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfza.e(kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x0100, code lost:
    
        if (h(r14, r0) == r1) goto L72;
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0092 A[Catch: all -> 0x0106, TRY_ENTER, TryCatch #0 {all -> 0x0106, blocks: (B:35:0x008c, B:38:0x0092, B:40:0x00a0, B:42:0x00b7, B:44:0x00c5, B:46:0x00d3, B:58:0x0108, B:59:0x010b, B:60:0x010c, B:61:0x010f, B:62:0x0110, B:63:0x0113, B:64:0x0114, B:65:0x0117, B:66:0x0118, B:67:0x011b), top: B:73:0x008c }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0118 A[Catch: all -> 0x0106, TryCatch #0 {all -> 0x0106, blocks: (B:35:0x008c, B:38:0x0092, B:40:0x00a0, B:42:0x00b7, B:44:0x00c5, B:46:0x00d3, B:58:0x0108, B:59:0x010b, B:60:0x010c, B:61:0x010f, B:62:0x0110, B:63:0x0113, B:64:0x0114, B:65:0x0117, B:66:0x0118, B:67:0x011b), top: B:73:0x008c }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(kotlin.coroutines.jvm.internal.ContinuationImpl r14) {
        /*
            Method dump skipped, instructions count: 293
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfza.f(kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(kotlin.coroutines.jvm.internal.ContinuationImpl r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.google.android.gms.internal.ads.zzfyq
            if (r0 == 0) goto L13
            r0 = r7
            com.google.android.gms.internal.ads.zzfyq r0 = (com.google.android.gms.internal.ads.zzfyq) r0
            int r1 = r0.f32043e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f32043e = r1
            goto L18
        L13:
            com.google.android.gms.internal.ads.zzfyq r0 = new com.google.android.gms.internal.ads.zzfyq
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f32041c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f32043e
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            long r1 = r0.f32039a
            kotlinx.coroutines.sync.MutexImpl r0 = r0.f32040b
            kotlin.ResultKt.b(r7)
            goto L4a
        L2b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L33:
            kotlin.ResultKt.b(r7)
            kotlinx.coroutines.sync.MutexImpl r7 = r6.f32076b
            long r4 = java.lang.System.currentTimeMillis()
            r0.f32040b = r7
            r0.f32039a = r4
            r0.f32043e = r3
            java.lang.Object r0 = r7.c(r0)
            if (r0 == r1) goto L6a
            r0 = r7
            r1 = r4
        L4a:
            r7 = 0
            com.google.android.gms.internal.ads.zzfxr r3 = r6.f32080f     // Catch: java.lang.Throwable -> L65
            if (r3 == 0) goto L5f
            r3.j()     // Catch: java.lang.Throwable -> L65
            com.google.android.gms.internal.ads.zziar r3 = r3.f34638b     // Catch: java.lang.Throwable -> L65
            com.google.android.gms.internal.ads.zzfxs r3 = (com.google.android.gms.internal.ads.zzfxs) r3     // Catch: java.lang.Throwable -> L65
            r3.D(r1)     // Catch: java.lang.Throwable -> L65
            r0.b(r7)
            kotlin.Unit r7 = kotlin.Unit.f53572a
            return r7
        L5f:
            java.lang.String r1 = "adQualityDataBuilder"
            kotlin.jvm.internal.Intrinsics.h(r1)     // Catch: java.lang.Throwable -> L65
            throw r7     // Catch: java.lang.Throwable -> L65
        L65:
            r1 = move-exception
            r0.b(r7)
            throw r1
        L6a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfza.g(kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object h(java.lang.String r8, kotlin.coroutines.jvm.internal.ContinuationImpl r9) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.google.android.gms.internal.ads.zzfyf
            if (r0 == 0) goto L13
            r0 = r9
            com.google.android.gms.internal.ads.zzfyf r0 = (com.google.android.gms.internal.ads.zzfyf) r0
            int r1 = r0.f32004e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f32004e = r1
            goto L18
        L13:
            com.google.android.gms.internal.ads.zzfyf r0 = new com.google.android.gms.internal.ads.zzfyf
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.f32002c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f32004e
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L45
            if (r2 == r4) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r8 = r0.f32000a
            kotlinx.coroutines.sync.Mutex r8 = (kotlinx.coroutines.sync.Mutex) r8
            kotlin.ResultKt.b(r9)     // Catch: java.lang.Throwable -> L2f
            goto L6c
        L2f:
            r9 = move-exception
            goto L78
        L31:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L39:
            kotlinx.coroutines.sync.MutexImpl r8 = r0.f32001b
            java.lang.Object r2 = r0.f32000a
            java.lang.String r2 = (java.lang.String) r2
            kotlin.ResultKt.b(r9)
            r9 = r8
            r8 = r2
            goto L56
        L45:
            kotlin.ResultKt.b(r9)
            kotlinx.coroutines.sync.MutexImpl r9 = r7.f32078d
            r0.f32000a = r8
            r0.f32001b = r9
            r0.f32004e = r4
            java.lang.Object r2 = r9.c(r0)
            if (r2 == r1) goto L7c
        L56:
            androidx.datastore.core.DataStore r2 = r7.f32082h     // Catch: java.lang.Throwable -> L74
            com.google.android.gms.internal.ads.zzfyg r4 = new com.google.android.gms.internal.ads.zzfyg     // Catch: java.lang.Throwable -> L74
            r4.<init>(r8, r5)     // Catch: java.lang.Throwable -> L74
            r0.f32000a = r9     // Catch: java.lang.Throwable -> L74
            r0.f32001b = r5     // Catch: java.lang.Throwable -> L74
            r0.f32004e = r3     // Catch: java.lang.Throwable -> L74
            java.lang.Object r8 = r2.a(r4, r0)     // Catch: java.lang.Throwable -> L74
            if (r8 == r1) goto L7c
            r6 = r9
            r9 = r8
            r8 = r6
        L6c:
            com.google.android.gms.internal.ads.zzfxw r9 = (com.google.android.gms.internal.ads.zzfxw) r9     // Catch: java.lang.Throwable -> L2f
            r8.b(r5)
            kotlin.Unit r8 = kotlin.Unit.f53572a
            return r8
        L74:
            r8 = move-exception
            r6 = r9
            r9 = r8
            r8 = r6
        L78:
            r8.b(r5)
            throw r9
        L7c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfza.h(java.lang.String, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v3, types: [kotlinx.coroutines.sync.Mutex] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(kotlin.coroutines.jvm.internal.ContinuationImpl r8) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.google.android.gms.internal.ads.zzfyi
            if (r0 == 0) goto L13
            r0 = r8
            com.google.android.gms.internal.ads.zzfyi r0 = (com.google.android.gms.internal.ads.zzfyi) r0
            int r1 = r0.f32015d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f32015d = r1
            goto L18
        L13:
            com.google.android.gms.internal.ads.zzfyi r0 = new com.google.android.gms.internal.ads.zzfyi
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.f32013b
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f32015d
            r3 = 1
            r4 = 2
            r5 = 0
            if (r2 == 0) goto L3e
            if (r2 == r3) goto L37
            if (r2 != r4) goto L2f
            kotlinx.coroutines.sync.Mutex r0 = r0.f32012a
            kotlin.ResultKt.b(r8)     // Catch: java.lang.Throwable -> L2d
            goto L61
        L2d:
            r8 = move-exception
            goto L6d
        L2f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L37:
            kotlinx.coroutines.sync.Mutex r2 = r0.f32012a
            kotlin.ResultKt.b(r8)
            r8 = r2
            goto L4d
        L3e:
            kotlin.ResultKt.b(r8)
            kotlinx.coroutines.sync.MutexImpl r8 = r7.f32078d
            r0.f32012a = r8
            r0.f32015d = r3
            java.lang.Object r2 = r8.c(r0)
            if (r2 == r1) goto L71
        L4d:
            androidx.datastore.core.DataStore r2 = r7.f32082h     // Catch: java.lang.Throwable -> L69
            com.google.android.gms.internal.ads.zzfyj r3 = new com.google.android.gms.internal.ads.zzfyj     // Catch: java.lang.Throwable -> L69
            r3.<init>(r4, r5)     // Catch: java.lang.Throwable -> L69
            r0.f32012a = r8     // Catch: java.lang.Throwable -> L69
            r0.f32015d = r4     // Catch: java.lang.Throwable -> L69
            java.lang.Object r0 = r2.a(r3, r0)     // Catch: java.lang.Throwable -> L69
            if (r0 == r1) goto L71
            r6 = r0
            r0 = r8
            r8 = r6
        L61:
            com.google.android.gms.internal.ads.zzfxw r8 = (com.google.android.gms.internal.ads.zzfxw) r8     // Catch: java.lang.Throwable -> L2d
            r0.b(r5)
            kotlin.Unit r8 = kotlin.Unit.f53572a
            return r8
        L69:
            r0 = move-exception
            r6 = r0
            r0 = r8
            r8 = r6
        L6d:
            r0.b(r5)
            throw r8
        L71:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfza.i(kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j(long r6, kotlin.coroutines.jvm.internal.ContinuationImpl r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.google.android.gms.internal.ads.zzfyh
            if (r0 == 0) goto L13
            r0 = r8
            com.google.android.gms.internal.ads.zzfyh r0 = (com.google.android.gms.internal.ads.zzfyh) r0
            int r1 = r0.f32011e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f32011e = r1
            goto L18
        L13:
            com.google.android.gms.internal.ads.zzfyh r0 = new com.google.android.gms.internal.ads.zzfyh
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.f32009c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f32011e
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            long r6 = r0.f32007a
            kotlinx.coroutines.sync.MutexImpl r0 = r0.f32008b
            kotlin.ResultKt.b(r8)
            goto L45
        L2b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L33:
            kotlin.ResultKt.b(r8)
            kotlinx.coroutines.sync.MutexImpl r8 = r5.f32076b
            r0.f32008b = r8
            r0.f32007a = r6
            r0.f32011e = r3
            java.lang.Object r0 = r8.c(r0)
            if (r0 == r1) goto L80
            r0 = r8
        L45:
            r8 = 0
            com.google.android.gms.internal.ads.zzfxr r1 = r5.f32080f     // Catch: java.lang.Throwable -> L76
            java.lang.String r2 = "adQualityDataBuilder"
            if (r1 == 0) goto L78
            com.google.android.gms.internal.ads.zziar r3 = r1.f34638b     // Catch: java.lang.Throwable -> L76
            com.google.android.gms.internal.ads.zzfxs r3 = (com.google.android.gms.internal.ads.zzfxs) r3     // Catch: java.lang.Throwable -> L76
            long r3 = r3.L()     // Catch: java.lang.Throwable -> L76
            long r6 = r6 - r3
            com.google.android.gms.internal.ads.zzfxr r3 = r5.f32080f     // Catch: java.lang.Throwable -> L76
            if (r3 == 0) goto L72
            com.google.android.gms.internal.ads.zziar r2 = r3.f34638b     // Catch: java.lang.Throwable -> L76
            com.google.android.gms.internal.ads.zzfxs r2 = (com.google.android.gms.internal.ads.zzfxs) r2     // Catch: java.lang.Throwable -> L76
            long r2 = r2.K()     // Catch: java.lang.Throwable -> L76
            long r6 = r6 - r2
            r1.j()     // Catch: java.lang.Throwable -> L76
            com.google.android.gms.internal.ads.zziar r1 = r1.f34638b     // Catch: java.lang.Throwable -> L76
            com.google.android.gms.internal.ads.zzfxs r1 = (com.google.android.gms.internal.ads.zzfxs) r1     // Catch: java.lang.Throwable -> L76
            r1.V(r6)     // Catch: java.lang.Throwable -> L76
            r0.b(r8)
            kotlin.Unit r6 = kotlin.Unit.f53572a
            return r6
        L72:
            kotlin.jvm.internal.Intrinsics.h(r2)     // Catch: java.lang.Throwable -> L76
            throw r8     // Catch: java.lang.Throwable -> L76
        L76:
            r6 = move-exception
            goto L7c
        L78:
            kotlin.jvm.internal.Intrinsics.h(r2)     // Catch: java.lang.Throwable -> L76
            throw r8     // Catch: java.lang.Throwable -> L76
        L7c:
            r0.b(r8)
            throw r6
        L80:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfza.j(long, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object k(kotlin.coroutines.jvm.internal.ContinuationImpl r8) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.google.android.gms.internal.ads.zzfym
            if (r0 == 0) goto L13
            r0 = r8
            com.google.android.gms.internal.ads.zzfym r0 = (com.google.android.gms.internal.ads.zzfym) r0
            int r1 = r0.f32027e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f32027e = r1
            goto L18
        L13:
            com.google.android.gms.internal.ads.zzfym r0 = new com.google.android.gms.internal.ads.zzfym
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.f32025c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f32027e
            r3 = 0
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L4e
            if (r2 == r6) goto L46
            if (r2 == r5) goto L3c
            if (r2 != r4) goto L34
            java.lang.Object r0 = r0.f32023a
            kotlinx.coroutines.sync.Mutex r0 = (kotlinx.coroutines.sync.Mutex) r0
            kotlin.ResultKt.b(r8)     // Catch: java.lang.Throwable -> L32
            goto L8d
        L32:
            r8 = move-exception
            goto L97
        L34:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L3c:
            kotlinx.coroutines.sync.MutexImpl r2 = r0.f32024b
            java.lang.Object r5 = r0.f32023a
            com.google.android.gms.internal.ads.zzfxs r5 = (com.google.android.gms.internal.ads.zzfxs) r5
            kotlin.ResultKt.b(r8)
            goto L79
        L46:
            java.lang.Object r2 = r0.f32023a
            kotlinx.coroutines.sync.Mutex r2 = (kotlinx.coroutines.sync.Mutex) r2
            kotlin.ResultKt.b(r8)
            goto L5d
        L4e:
            kotlin.ResultKt.b(r8)
            kotlinx.coroutines.sync.MutexImpl r2 = r7.f32076b
            r0.f32023a = r2
            r0.f32027e = r6
            java.lang.Object r8 = r2.c(r0)
            if (r8 == r1) goto La7
        L5d:
            com.google.android.gms.internal.ads.zzfxr r8 = r7.f32080f     // Catch: java.lang.Throwable -> L9b
            if (r8 == 0) goto L9d
            com.google.android.gms.internal.ads.zziar r8 = r8.l()     // Catch: java.lang.Throwable -> L9b
            com.google.android.gms.internal.ads.zzfxs r8 = (com.google.android.gms.internal.ads.zzfxs) r8     // Catch: java.lang.Throwable -> L9b
            r2.b(r3)
            kotlinx.coroutines.sync.MutexImpl r2 = r7.f32078d
            r0.f32023a = r8
            r0.f32024b = r2
            r0.f32027e = r5
            java.lang.Object r5 = r2.c(r0)
            if (r5 == r1) goto La7
            r5 = r8
        L79:
            androidx.datastore.core.DataStore r8 = r7.f32082h     // Catch: java.lang.Throwable -> L95
            com.google.android.gms.internal.ads.zzfyn r6 = new com.google.android.gms.internal.ads.zzfyn     // Catch: java.lang.Throwable -> L95
            r6.<init>(r5, r3)     // Catch: java.lang.Throwable -> L95
            r0.f32023a = r2     // Catch: java.lang.Throwable -> L95
            r0.f32024b = r3     // Catch: java.lang.Throwable -> L95
            r0.f32027e = r4     // Catch: java.lang.Throwable -> L95
            java.lang.Object r8 = r8.a(r6, r0)     // Catch: java.lang.Throwable -> L95
            if (r8 == r1) goto La7
            r0 = r2
        L8d:
            com.google.android.gms.internal.ads.zzfxw r8 = (com.google.android.gms.internal.ads.zzfxw) r8     // Catch: java.lang.Throwable -> L32
            r0.b(r3)
            kotlin.Unit r8 = kotlin.Unit.f53572a
            return r8
        L95:
            r8 = move-exception
            r0 = r2
        L97:
            r0.b(r3)
            throw r8
        L9b:
            r8 = move-exception
            goto La3
        L9d:
            java.lang.String r8 = "adQualityDataBuilder"
            kotlin.jvm.internal.Intrinsics.h(r8)     // Catch: java.lang.Throwable -> L9b
            throw r3     // Catch: java.lang.Throwable -> L9b
        La3:
            r2.b(r3)
            throw r8
        La7:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfza.k(kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}
