package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public final class zzezh implements zzezx {

    /* renamed from: a, reason: collision with root package name */
    public final zzcbw f30661a;

    /* renamed from: b, reason: collision with root package name */
    public final zzgyw f30662b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f30663c;

    public zzezh(zzcbw zzcbwVar, zzgyw zzgywVar, Context context) {
        this.f30661a = zzcbwVar;
        this.f30662b = zzgywVar;
        this.f30663c = context;
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final ListenableFuture zza() {
        return ((zzgxi) this.f30662b).submit(new Callable() { // from class: com.google.android.gms.internal.ads.zzezg
            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzezh zzezhVar = this.f30660a;
                zzcbw zzcbwVar = zzezhVar.f30661a;
                Context context = zzezhVar.f30663c;
                if (!zzcbwVar.a(context)) {
                    return new zzezi(null, null, null, null, null);
                }
                String strB = zzcbwVar.b(context);
                String str = strB == null ? "" : strB;
                String strC = zzcbwVar.c(context);
                String str2 = strC == null ? "" : strC;
                String strD = zzcbwVar.d(context);
                String str3 = strD == null ? "" : strD;
                String str4 = true != zzcbwVar.a(context) ? null : "fa";
                return new zzezi(str, str2, str3, str4 == null ? "" : str4, "TIME_OUT".equals(str2) ? (Long) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.G0) : null);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final int zzb() {
        return 34;
    }
}
