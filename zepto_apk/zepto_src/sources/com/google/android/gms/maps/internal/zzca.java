package com.google.android.gms.maps.internal;

import android.os.Parcel;

/* loaded from: classes4.dex */
public final class zzca extends com.google.android.gms.internal.maps.zza implements IUiSettingsDelegate {
    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final void J8(boolean z) {
        Parcel parcelZ0 = z0();
        int i2 = com.google.android.gms.internal.maps.zzc.f36737a;
        parcelZ0.writeInt(z ? 1 : 0);
        j1(6, parcelZ0);
    }

    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final void K4(boolean z) {
        Parcel parcelZ0 = z0();
        int i2 = com.google.android.gms.internal.maps.zzc.f36737a;
        parcelZ0.writeInt(z ? 1 : 0);
        j1(18, parcelZ0);
    }

    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final void L6(boolean z) {
        Parcel parcelZ0 = z0();
        int i2 = com.google.android.gms.internal.maps.zzc.f36737a;
        parcelZ0.writeInt(z ? 1 : 0);
        j1(16, parcelZ0);
    }

    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final void L8(boolean z) {
        Parcel parcelZ0 = z0();
        int i2 = com.google.android.gms.internal.maps.zzc.f36737a;
        parcelZ0.writeInt(z ? 1 : 0);
        j1(5, parcelZ0);
    }

    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final void W1(boolean z) {
        Parcel parcelZ0 = z0();
        int i2 = com.google.android.gms.internal.maps.zzc.f36737a;
        parcelZ0.writeInt(z ? 1 : 0);
        j1(3, parcelZ0);
    }

    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final boolean Ya() {
        Parcel parcelG = g(12, z0());
        int i2 = com.google.android.gms.internal.maps.zzc.f36737a;
        boolean z = parcelG.readInt() != 0;
        parcelG.recycle();
        return z;
    }

    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final void f9(boolean z) {
        Parcel parcelZ0 = z0();
        int i2 = com.google.android.gms.internal.maps.zzc.f36737a;
        parcelZ0.writeInt(z ? 1 : 0);
        j1(1, parcelZ0);
    }

    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final void n9(boolean z) {
        Parcel parcelZ0 = z0();
        int i2 = com.google.android.gms.internal.maps.zzc.f36737a;
        parcelZ0.writeInt(z ? 1 : 0);
        j1(7, parcelZ0);
    }

    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final void ta(boolean z) {
        Parcel parcelZ0 = z0();
        int i2 = com.google.android.gms.internal.maps.zzc.f36737a;
        parcelZ0.writeInt(z ? 1 : 0);
        j1(4, parcelZ0);
    }

    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final void u7(boolean z) {
        Parcel parcelZ0 = z0();
        int i2 = com.google.android.gms.internal.maps.zzc.f36737a;
        parcelZ0.writeInt(z ? 1 : 0);
        j1(2, parcelZ0);
    }

    @Override // com.google.android.gms.maps.internal.IUiSettingsDelegate
    public final void v7(boolean z) {
        Parcel parcelZ0 = z0();
        int i2 = com.google.android.gms.internal.maps.zzc.f36737a;
        parcelZ0.writeInt(z ? 1 : 0);
        j1(20, parcelZ0);
    }
}
