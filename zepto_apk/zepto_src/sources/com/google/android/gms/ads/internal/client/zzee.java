package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.ads.zzbcb;
import com.google.android.gms.internal.ads.zzbcd;

/* loaded from: classes4.dex */
public final class zzee extends zzbcb implements zzeg {
    public zzee(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
    }

    @Override // com.google.android.gms.ads.internal.client.zzeg
    public final void P4(boolean z) {
        Parcel parcelG = g();
        ClassLoader classLoader = zzbcd.f24690a;
        parcelG.writeInt(z ? 1 : 0);
        j1(5, parcelG);
    }

    @Override // com.google.android.gms.ads.internal.client.zzeg
    public final void zze() {
        j1(1, g());
    }

    @Override // com.google.android.gms.ads.internal.client.zzeg
    public final void zzf() {
        j1(2, g());
    }

    @Override // com.google.android.gms.ads.internal.client.zzeg
    public final void zzg() {
        j1(3, g());
    }

    @Override // com.google.android.gms.ads.internal.client.zzeg
    public final void zzh() {
        j1(4, g());
    }
}
