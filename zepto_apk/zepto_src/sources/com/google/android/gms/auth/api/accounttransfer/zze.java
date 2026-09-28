package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import com.google.android.gms.internal.auth.zzau;

/* loaded from: classes4.dex */
final class zze extends zzl {
    @Override // com.google.android.gms.auth.api.accounttransfer.zzl
    public final void a(zzau zzauVar) {
        zzd zzdVar = new zzd(this, this);
        Parcel parcelG = zzauVar.g();
        com.google.android.gms.internal.auth.zzc.d(parcelG, zzdVar);
        parcelG.writeInt(0);
        zzauVar.z0(6, parcelG);
    }
}
