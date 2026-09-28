package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public final class zzegn {

    /* renamed from: a, reason: collision with root package name */
    public final zzegj f29286a;

    /* renamed from: b, reason: collision with root package name */
    public final zzgyw f29287b;

    public zzegn(zzegj zzegjVar, zzgyw zzgywVar) {
        this.f29286a = zzegjVar;
        this.f29287b = zzgywVar;
    }

    public final void a(zzflu zzfluVar) {
        final zzegj zzegjVar = this.f29286a;
        Callable callable = new Callable() { // from class: com.google.android.gms.internal.ads.zzegm
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return zzegjVar.getWritableDatabase();
            }
        };
        zzgyw zzgywVar = this.f29287b;
        ListenableFuture listenableFutureSubmit = zzgywVar.submit(callable);
        listenableFutureSubmit.q(new zzgyk(listenableFutureSubmit, new zzegl(this, zzfluVar)), zzgywVar);
    }
}
