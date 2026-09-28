package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public final class zzbtm extends zzbcb implements zzbto {
    public zzbtm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper");
    }

    @Override // com.google.android.gms.internal.ads.zzbto
    public final float H() {
        Parcel parcelZ0 = z0(24, g());
        float f2 = parcelZ0.readFloat();
        parcelZ0.recycle();
        return f2;
    }

    @Override // com.google.android.gms.internal.ads.zzbto
    public final float I() {
        Parcel parcelZ0 = z0(23, g());
        float f2 = parcelZ0.readFloat();
        parcelZ0.recycle();
        return f2;
    }

    @Override // com.google.android.gms.internal.ads.zzbto
    public final void R0(IObjectWrapper iObjectWrapper) {
        Parcel parcelG = g();
        zzbcd.e(parcelG, iObjectWrapper);
        j1(20, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzbto
    public final Bundle bb() {
        Parcel parcelZ0 = z0(16, g());
        Bundle bundle = (Bundle) zzbcd.b(parcelZ0, Bundle.CREATOR);
        parcelZ0.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzbto
    public final boolean f() {
        Parcel parcelZ0 = z0(17, g());
        ClassLoader classLoader = zzbcd.f24690a;
        boolean z = parcelZ0.readInt() != 0;
        parcelZ0.recycle();
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzbto
    public final void h() {
        j1(19, g());
    }

    @Override // com.google.android.gms.internal.ads.zzbto
    public final void i2(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        Parcel parcelG = g();
        zzbcd.e(parcelG, iObjectWrapper);
        zzbcd.e(parcelG, iObjectWrapper2);
        zzbcd.e(parcelG, iObjectWrapper3);
        j1(21, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzbto
    public final boolean p0() {
        Parcel parcelZ0 = z0(18, g());
        ClassLoader classLoader = zzbcd.f24690a;
        boolean z = parcelZ0.readInt() != 0;
        parcelZ0.recycle();
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzbto
    public final void s8(IObjectWrapper iObjectWrapper) {
        Parcel parcelG = g();
        zzbcd.e(parcelG, iObjectWrapper);
        j1(22, parcelG);
    }

    @Override // com.google.android.gms.internal.ads.zzbto
    public final float t() {
        Parcel parcelZ0 = z0(25, g());
        float f2 = parcelZ0.readFloat();
        parcelZ0.recycle();
        return f2;
    }

    @Override // com.google.android.gms.internal.ads.zzbto
    public final void v() {
        j1(26, g());
    }

    @Override // com.google.android.gms.internal.ads.zzbto
    public final String zze() {
        Parcel parcelZ0 = z0(2, g());
        String string = parcelZ0.readString();
        parcelZ0.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbto
    public final List zzf() {
        Parcel parcelZ0 = z0(3, g());
        ArrayList arrayList = parcelZ0.readArrayList(zzbcd.f24690a);
        parcelZ0.recycle();
        return arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzbto
    public final String zzg() {
        Parcel parcelZ0 = z0(4, g());
        String string = parcelZ0.readString();
        parcelZ0.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbto
    public final zzbjy zzh() {
        Parcel parcelZ0 = z0(5, g());
        zzbjy zzbjyVarXb = zzbjx.Xb(parcelZ0.readStrongBinder());
        parcelZ0.recycle();
        return zzbjyVarXb;
    }

    @Override // com.google.android.gms.internal.ads.zzbto
    public final String zzi() {
        Parcel parcelZ0 = z0(6, g());
        String string = parcelZ0.readString();
        parcelZ0.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbto
    public final String zzj() {
        Parcel parcelZ0 = z0(7, g());
        String string = parcelZ0.readString();
        parcelZ0.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbto
    public final double zzk() {
        Parcel parcelZ0 = z0(8, g());
        double d2 = parcelZ0.readDouble();
        parcelZ0.recycle();
        return d2;
    }

    @Override // com.google.android.gms.internal.ads.zzbto
    public final String zzl() {
        Parcel parcelZ0 = z0(9, g());
        String string = parcelZ0.readString();
        parcelZ0.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbto
    public final String zzm() {
        Parcel parcelZ0 = z0(10, g());
        String string = parcelZ0.readString();
        parcelZ0.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbto
    public final com.google.android.gms.ads.internal.client.zzed zzn() {
        Parcel parcelZ0 = z0(11, g());
        com.google.android.gms.ads.internal.client.zzed zzedVarXb = com.google.android.gms.ads.internal.client.zzec.Xb(parcelZ0.readStrongBinder());
        parcelZ0.recycle();
        return zzedVarXb;
    }

    @Override // com.google.android.gms.internal.ads.zzbto
    public final zzbjr zzo() {
        Parcel parcelZ0 = z0(12, g());
        zzbjr zzbjrVarXb = zzbjq.Xb(parcelZ0.readStrongBinder());
        parcelZ0.recycle();
        return zzbjrVarXb;
    }

    @Override // com.google.android.gms.internal.ads.zzbto
    public final IObjectWrapper zzp() {
        return android.support.v4.media.a.f(z0(13, g()));
    }

    @Override // com.google.android.gms.internal.ads.zzbto
    public final IObjectWrapper zzq() {
        return android.support.v4.media.a.f(z0(14, g()));
    }

    @Override // com.google.android.gms.internal.ads.zzbto
    public final IObjectWrapper zzr() {
        return android.support.v4.media.a.f(z0(15, g()));
    }
}
