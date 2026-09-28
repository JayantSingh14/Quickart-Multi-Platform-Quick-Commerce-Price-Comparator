package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.io.File;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* loaded from: classes4.dex */
final class zzglc implements zzgjw {

    /* renamed from: a, reason: collision with root package name */
    public final zzgib f32839a;

    /* renamed from: b, reason: collision with root package name */
    public final ExecutorService f32840b;

    /* renamed from: c, reason: collision with root package name */
    public final zzgnc f32841c;

    public zzglc(zzgib zzgibVar, ExecutorService executorService, zzgnc zzgncVar) {
        this.f32839a = zzgibVar;
        this.f32840b = executorService;
        this.f32841c = zzgncVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgjv
    public final ListenableFuture a(final zzgcs zzgcsVar, final byte[] bArr, final byte[] bArr2) {
        ListenableFuture listenableFutureC = zzgym.c(new Callable() { // from class: com.google.android.gms.internal.ads.zzgla
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() throws IllegalArgumentException {
                this.f32834a.f32839a.a(zzgcsVar, bArr, bArr2);
                return null;
            }
        }, this.f32840b);
        this.f32841c.e(15321, listenableFutureC);
        return listenableFutureC;
    }

    @Override // com.google.android.gms.internal.ads.zzgjv
    public final ListenableFuture b(final zzgcs zzgcsVar, final byte[] bArr) {
        ListenableFuture listenableFutureC = zzgym.c(new Callable() { // from class: com.google.android.gms.internal.ads.zzgkz
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() throws IllegalArgumentException {
                this.f32818a.f32839a.a(zzgcsVar, null, bArr);
                return null;
            }
        }, this.f32840b);
        this.f32841c.e(15305, listenableFutureC);
        return listenableFutureC;
    }

    @Override // com.google.android.gms.internal.ads.zzgjv
    public final ListenableFuture zza() {
        return zzgym.a(Boolean.TRUE);
    }

    @Override // com.google.android.gms.internal.ads.zzgjv
    public final ListenableFuture zzb() {
        ListenableFuture listenableFutureC = zzgym.c(new Callable() { // from class: com.google.android.gms.internal.ads.zzglb
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() throws IllegalArgumentException {
                zzgcs zzgcsVarB = this.f32838a.f32839a.b(1);
                return zzgcsVarB == null ? zzgcs.H() : zzgcsVarB;
            }
        }, this.f32840b);
        this.f32841c.e(15302, listenableFutureC);
        return listenableFutureC;
    }

    @Override // com.google.android.gms.internal.ads.zzgjw
    public final ListenableFuture zze() {
        ListenableFuture listenableFutureC = zzgym.c(new Callable() { // from class: com.google.android.gms.internal.ads.zzgky
            @Override // java.util.concurrent.Callable
            public final Object call() throws IllegalArgumentException {
                zzgib zzgibVar = this.f32817a.f32839a;
                zzgcs zzgcsVarB = zzgibVar.b(1);
                if (zzgcsVarB == null) {
                    zzgibVar.f32637e.b(15315);
                    return null;
                }
                String strC = zzgcsVarB.C().C();
                File fileA = zzfvq.a(zzgibVar.c(), strC, "pcam.jar");
                fileA.getClass();
                if (!fileA.exists()) {
                    fileA = zzfvq.a(zzgibVar.c(), strC, "pcam");
                    fileA.getClass();
                }
                File fileA2 = zzfvq.a(zzgibVar.c(), strC, "pcopt");
                fileA2.getClass();
                File fileA3 = zzfvq.a(zzgibVar.c(), strC, "pcbc");
                fileA3.getClass();
                return new zzfvo(zzgcsVarB.C(), fileA, fileA3, fileA2);
            }
        }, this.f32840b);
        this.f32841c.e(15314, listenableFutureC);
        return listenableFutureC;
    }
}
