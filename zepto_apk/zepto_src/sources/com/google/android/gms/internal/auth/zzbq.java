package com.google.android.gms.internal.auth;

import android.os.Parcel;

/* loaded from: classes4.dex */
final class zzbq extends zzbi {
    @Override // com.google.android.gms.internal.auth.zzbi
    public final void a(zzbh zzbhVar) {
        zzbp zzbpVar = new zzbp(this);
        Parcel parcelG = zzbhVar.g();
        zzc.d(parcelG, zzbpVar);
        parcelG.writeInt(0);
        zzbhVar.z0(1, parcelG);
    }
}
