package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes4.dex */
final class zzglh implements zzgle {

    /* renamed from: a, reason: collision with root package name */
    public final zzgbr f32849a;

    /* renamed from: b, reason: collision with root package name */
    public final zzgbr f32850b;

    /* renamed from: c, reason: collision with root package name */
    public final zzija f32851c;

    /* renamed from: d, reason: collision with root package name */
    public final zzgnc f32852d;

    public zzglh(zzgbr zzgbrVar, zzgbr zzgbrVar2, zzija zzijaVar, zzgnc zzgncVar) {
        this.f32849a = zzgbrVar;
        this.f32850b = zzgbrVar2;
        this.f32851c = zzijaVar;
        this.f32852d = zzgncVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgjv
    public final ListenableFuture a(final zzgcs zzgcsVar, byte[] bArr, byte[] bArr2) {
        ListenableFuture listenableFutureB = ((zzgbr) this.f32851c.zzb()).b(bArr);
        zzgnc zzgncVar = this.f32852d;
        zzgncVar.e(20307, listenableFutureB);
        ListenableFuture listenableFutureB2 = this.f32850b.b(bArr2);
        zzgncVar.e(20305, listenableFutureB2);
        return (zzgye) zzgym.h(zzgye.s(new zzgxv(zzgtd.s(new ListenableFuture[]{listenableFutureB, listenableFutureB2}), true)), new zzgxu() { // from class: com.google.android.gms.internal.ads.zzglf
            @Override // com.google.android.gms.internal.ads.zzgxu
            public final ListenableFuture zza(Object obj) {
                zzglh zzglhVar = this.f32845a;
                ListenableFuture listenableFutureB3 = zzglhVar.f32849a.b(zzgcsVar);
                zzglhVar.f32852d.e(20303, listenableFutureB3);
                return listenableFutureB3;
            }
        }, zzgyb.f33369a);
    }

    @Override // com.google.android.gms.internal.ads.zzgjv
    public final ListenableFuture b(final zzgcs zzgcsVar, byte[] bArr) {
        ListenableFuture listenableFutureB = this.f32850b.b(bArr);
        this.f32852d.e(20305, listenableFutureB);
        return (zzgye) zzgym.h(zzgye.s(listenableFutureB), new zzgxu() { // from class: com.google.android.gms.internal.ads.zzglg
            @Override // com.google.android.gms.internal.ads.zzgxu
            public final ListenableFuture zza(Object obj) {
                zzglh zzglhVar = this.f32847a;
                ListenableFuture listenableFutureB2 = zzglhVar.f32849a.b(zzgcsVar);
                zzglhVar.f32852d.e(20303, listenableFutureB2);
                return listenableFutureB2;
            }
        }, zzgyb.f33369a);
    }

    @Override // com.google.android.gms.internal.ads.zzgjv
    public final ListenableFuture zza() {
        return zzgym.a(Boolean.TRUE);
    }

    @Override // com.google.android.gms.internal.ads.zzgjv
    public final ListenableFuture zzb() {
        ListenableFuture listenableFutureA = this.f32849a.a();
        this.f32852d.e(20302, listenableFutureA);
        return listenableFutureA;
    }

    @Override // com.google.android.gms.internal.ads.zzgle
    public final ListenableFuture zze() {
        ListenableFuture listenableFutureA = this.f32850b.a();
        this.f32852d.e(20304, listenableFutureA);
        return listenableFutureA;
    }
}
