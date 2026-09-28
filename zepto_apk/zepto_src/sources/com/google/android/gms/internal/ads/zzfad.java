package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public final class zzfad implements zzezx {

    /* renamed from: a, reason: collision with root package name */
    public final Context f30726a;

    /* renamed from: b, reason: collision with root package name */
    public final zzgyw f30727b;

    public zzfad(Context context, zzgyw zzgywVar) {
        this.f30726a = context;
        this.f30727b = zzgywVar;
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final ListenableFuture zza() {
        if (!((Boolean) zzbic.f25122b.c()).booleanValue()) {
            return zzgym.a(new zzfae(-1, -1));
        }
        return ((zzgxi) this.f30727b).submit(new Callable() { // from class: com.google.android.gms.internal.ads.zzfac
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Context context = this.f30725a.f30726a;
                return new zzfae(zzbfv.b(context, "init_without_write"), zzbfv.b(context, "crash_without_write"));
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final int zzb() {
        return 59;
    }
}
