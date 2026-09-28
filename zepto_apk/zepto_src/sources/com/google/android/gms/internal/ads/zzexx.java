package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public final class zzexx implements zzezx {

    /* renamed from: a, reason: collision with root package name */
    public final zzgyw f30548a;

    /* renamed from: b, reason: collision with root package name */
    public final zzfik f30549b;

    /* renamed from: c, reason: collision with root package name */
    public final PackageInfo f30550c;

    /* renamed from: d, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.util.zzj f30551d;

    public zzexx(zzgyw zzgywVar, zzfik zzfikVar, PackageInfo packageInfo, com.google.android.gms.ads.internal.util.zzj zzjVar) {
        this.f30548a = zzgywVar;
        this.f30549b = zzfikVar;
        this.f30550c = packageInfo;
        this.f30551d = zzjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final ListenableFuture zza() {
        return ((zzgxi) this.f30548a).submit(new Callable() { // from class: com.google.android.gms.internal.ads.zzexw
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                zzexx zzexxVar = this.f30547a;
                return new zzexy(zzexxVar.f30549b, zzexxVar.f30550c, zzexxVar.f30551d);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final int zzb() {
        return 26;
    }
}
