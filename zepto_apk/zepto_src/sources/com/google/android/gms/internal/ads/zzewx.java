package com.google.android.gms.internal.ads;

import android.content.Context;
import android.hardware.display.DisplayManager;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public final class zzewx implements zzezx {

    /* renamed from: a, reason: collision with root package name */
    public final Context f30501a;

    /* renamed from: b, reason: collision with root package name */
    public final zzgyw f30502b;

    public zzewx(Context context, zzgyw zzgywVar) {
        this.f30502b = zzgywVar;
        this.f30501a = context;
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final ListenableFuture zza() {
        return ((zzgxi) this.f30502b).submit(new Callable() { // from class: com.google.android.gms.internal.ads.zzeww
            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzewx zzewxVar = this.f30500a;
                zzewxVar.getClass();
                com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzt.C.f21679c;
                Object systemService = zzewxVar.f30501a.getSystemService("display");
                return new zzewy(systemService instanceof DisplayManager ? Integer.valueOf(((DisplayManager) systemService).getDisplays().length) : null);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final int zzb() {
        return 57;
    }
}
