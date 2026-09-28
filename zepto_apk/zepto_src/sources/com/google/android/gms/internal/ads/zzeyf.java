package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public final class zzeyf implements zzezx {

    /* renamed from: a, reason: collision with root package name */
    public final zzgyw f30571a;

    /* renamed from: b, reason: collision with root package name */
    public final zzdyh f30572b;

    public zzeyf(zzgyw zzgywVar, zzdyh zzdyhVar) {
        this.f30571a = zzgywVar;
        this.f30572b = zzdyhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final ListenableFuture zza() {
        return ((zzgxi) this.f30571a).submit(new Callable() { // from class: com.google.android.gms.internal.ads.zzeye
            @Override // java.util.concurrent.Callable
            public final Object call() {
                HashMap map;
                zzdyh zzdyhVar = this.f30570a.f30572b;
                synchronized (zzdyhVar) {
                    map = new HashMap();
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.B8)).booleanValue()) {
                        zzdyhVar.b();
                        for (Map.Entry entry : zzdyhVar.f28791a.entrySet()) {
                            map.put((zzdyk) entry.getKey(), new ArrayDeque((Collection) entry.getValue()));
                        }
                    }
                }
                return new zzeyg(map);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final int zzb() {
        return 62;
    }
}
