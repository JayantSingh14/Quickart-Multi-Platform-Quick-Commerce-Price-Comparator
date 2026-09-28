package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes4.dex */
public final class zzbtd extends zzbcb implements zzbtf {
    public zzbtd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbtf
    public final void B() {
        j1(15, g());
    }

    @Override // com.google.android.gms.internal.ads.zzbtf
    public final void D4() {
        j1(18, g());
    }

    @Override // com.google.android.gms.internal.ads.zzbtf
    public final void H1(com.google.android.gms.ads.internal.client.zze zzeVar) {
        Parcel parcelG = g();
        zzbcd.c(parcelG, zzeVar);
        j1(23, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzbtf
    public final void K(int i2) {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbtf
    public final void Qb(int i2, String str) {
        Parcel parcelG = g();
        parcelG.writeInt(i2);
        parcelG.writeString(str);
        j1(22, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzbtf
    public final void V5(String str, String str2) {
        Parcel parcelG = g();
        parcelG.writeString(str);
        parcelG.writeString(str2);
        j1(9, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzbtf
    public final void Y0(String str) {
        Parcel parcelG = g();
        parcelG.writeString(str);
        j1(21, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzbtf
    public final void Z0() {
        j1(11, g());
    }

    @Override // com.google.android.gms.internal.ads.zzbtf
    public final void d2(zzbks zzbksVar, String str) {
        Parcel parcelG = g();
        zzbcd.e(parcelG, zzbksVar);
        parcelG.writeString(str);
        j1(10, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzbtf
    public final void hb(zzcac zzcacVar) {
        Parcel parcelG = g();
        zzbcd.e(parcelG, zzcacVar);
        j1(16, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzbtf
    public final void m0() {
        j1(25, g());
    }

    @Override // com.google.android.gms.internal.ads.zzbtf
    public final void o2(com.google.android.gms.ads.internal.client.zze zzeVar) {
        Parcel parcelG = g();
        zzbcd.c(parcelG, zzeVar);
        j1(24, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzbtf
    public final void p0() {
        j1(20, g());
    }

    @Override // com.google.android.gms.internal.ads.zzbtf
    public final void v8(zzbzy zzbzyVar) {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbtf
    public final void zze() {
        j1(1, g());
    }

    @Override // com.google.android.gms.internal.ads.zzbtf
    public final void zzf() {
        j1(2, g());
    }

    @Override // com.google.android.gms.internal.ads.zzbtf
    public final void zzg(int i2) {
        Parcel parcelG = g();
        parcelG.writeInt(i2);
        j1(3, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzbtf
    public final void zzh() {
        j1(4, g());
    }

    @Override // com.google.android.gms.internal.ads.zzbtf
    public final void zzi() {
        j1(5, g());
    }

    @Override // com.google.android.gms.internal.ads.zzbtf
    public final void zzj() {
        j1(6, g());
    }

    @Override // com.google.android.gms.internal.ads.zzbtf
    public final void zzk() {
        j1(8, g());
    }

    @Override // com.google.android.gms.internal.ads.zzbtf
    public final void zzo() {
        j1(13, g());
    }
}
