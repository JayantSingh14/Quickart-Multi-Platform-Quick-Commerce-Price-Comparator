package com.google.android.gms.internal.ads;

import android.os.Parcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzbph implements zzgxu {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzboz f25404a;

    public zzbph(zzbpl zzbplVar, zzboz zzbozVar) {
        this.f25404a = zzbozVar;
        Objects.requireNonNull(zzbplVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgxu
    public final ListenableFuture zza(Object obj) {
        zzbpf zzbpfVar = (zzbpf) obj;
        zzcdt zzcdtVar = new zzcdt();
        zzbpg zzbpgVar = new zzbpg(this, zzcdtVar);
        Parcel parcelG = zzbpfVar.g();
        zzbcd.c(parcelG, this.f25404a);
        zzbcd.e(parcelG, zzbpgVar);
        zzbpfVar.w1(2, parcelG);
        return zzcdtVar;
    }
}
