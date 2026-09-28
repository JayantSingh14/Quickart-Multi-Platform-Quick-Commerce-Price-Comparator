package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes4.dex */
public final class zzgnc {

    /* renamed from: a, reason: collision with root package name */
    public final zzgcf f32968a;

    public zzgnc(zzfzm zzfzmVar, zzgcf zzgcfVar) {
        this.f32968a = zzgcfVar;
    }

    public final zzgna a(int i2) {
        return new zzgna(i2, this.f32968a);
    }

    public final void b(int i2) {
        this.f32968a.b(i2 - 1, -1L, null, null);
    }

    public final void c(int i2, String str) {
        this.f32968a.b(i2 - 1, -1L, str, null);
    }

    public final void d(int i2, Throwable th) {
        this.f32968a.b(i2 - 1, -1L, null, th);
    }

    public final void e(int i2, ListenableFuture listenableFuture) {
        zzgna zzgnaVarA = a(i2);
        zzgnaVarA.a();
        zzgnb zzgnbVar = new zzgnb(this, zzgnaVarA);
        listenableFuture.q(new zzgyk(listenableFuture, zzgnbVar), zzgyb.f33369a);
    }

    public final void f(int i2, Runnable runnable) {
        try {
            a(i2).a();
            runnable.run();
        } finally {
        }
    }
}
