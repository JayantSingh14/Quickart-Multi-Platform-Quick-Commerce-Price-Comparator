package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "AdErrorParcelCreator")
/* loaded from: classes4.dex */
public final class zze extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zze> CREATOR = new zzf();

    /* renamed from: a, reason: collision with root package name */
    public final int f21161a;

    /* renamed from: b, reason: collision with root package name */
    public final String f21162b;

    /* renamed from: c, reason: collision with root package name */
    public final String f21163c;

    /* renamed from: d, reason: collision with root package name */
    public zze f21164d;

    /* renamed from: e, reason: collision with root package name */
    public IBinder f21165e;

    public zze(int i2, String str, String str2, zze zzeVar, IBinder iBinder) {
        this.f21161a = i2;
        this.f21162b = str;
        this.f21163c = str2;
        this.f21164d = zzeVar;
        this.f21165e = iBinder;
    }

    public final AdError b() {
        zze zzeVar = this.f21164d;
        return new AdError(this.f21161a, this.f21162b, this.f21163c, zzeVar != null ? new AdError(zzeVar.f21161a, zzeVar.f21162b, zzeVar.f21163c, null) : null);
    }

    public final LoadAdError r() {
        zzea zzdyVar;
        zze zzeVar = this.f21164d;
        AdError adError = zzeVar == null ? null : new AdError(zzeVar.f21161a, zzeVar.f21162b, zzeVar.f21163c, null);
        IBinder iBinder = this.f21165e;
        if (iBinder == null) {
            zzdyVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IResponseInfo");
            zzdyVar = iInterfaceQueryLocalInterface instanceof zzea ? (zzea) iInterfaceQueryLocalInterface : new zzdy(iBinder);
        }
        return new LoadAdError(this.f21161a, this.f21162b, this.f21163c, adError, zzdyVar != null ? new ResponseInfo(zzdyVar) : null);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f21161a);
        SafeParcelWriter.writeString(parcel, 2, this.f21162b, false);
        SafeParcelWriter.writeString(parcel, 3, this.f21163c, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.f21164d, i2, false);
        SafeParcelWriter.writeIBinder(parcel, 5, this.f21165e, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
