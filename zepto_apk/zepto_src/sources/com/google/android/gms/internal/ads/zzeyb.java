package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public final class zzeyb implements zzezx {

    /* renamed from: b, reason: collision with root package name */
    public static String f30566b;

    /* renamed from: a, reason: collision with root package name */
    public final zzgyw f30567a;

    public zzeyb(Context context, zzgyw zzgywVar) {
        this.f30567a = zzgywVar;
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final ListenableFuture zza() {
        return ((zzgxi) this.f30567a).submit(new Callable() { // from class: com.google.android.gms.internal.ads.zzeya
            @Override // java.util.concurrent.Callable
            public final Object call() {
                this.f30565a.getClass();
                zzbgb zzbgbVar = zzbgk.V5;
                com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
                if (!((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
                    return new zzeyc(null);
                }
                boolean zBooleanValue = ((Boolean) zzbdVar.f21153c.a(zzbgk.e6)).booleanValue();
                zzeik zzeikVar = zzeik.f29405a;
                if (!zBooleanValue) {
                    com.google.android.gms.ads.internal.zzt.C.x.getClass();
                    return new zzeyc(((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue() ? (String) zzeiv.i(zzeikVar) : null);
                }
                if (zzeyb.f30566b == null) {
                    com.google.android.gms.ads.internal.zzt.C.x.getClass();
                    zzeyb.f30566b = ((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue() ? (String) zzeiv.i(zzeikVar) : null;
                }
                return new zzeyc(zzeyb.f30566b);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final int zzb() {
        return 27;
    }
}
