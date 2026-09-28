package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "LocationRequestUpdateDataCreator")
@SafeParcelable.Reserved({1000})
@Deprecated
/* loaded from: classes4.dex */
public final class zzdf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdf> CREATOR = new zzdg();

    /* renamed from: a, reason: collision with root package name */
    public final int f36677a;

    /* renamed from: b, reason: collision with root package name */
    public final zzdd f36678b;

    /* renamed from: c, reason: collision with root package name */
    public final com.google.android.gms.location.zzu f36679c;

    /* renamed from: d, reason: collision with root package name */
    public final com.google.android.gms.location.zzr f36680d;

    /* renamed from: e, reason: collision with root package name */
    public final PendingIntent f36681e;

    /* renamed from: f, reason: collision with root package name */
    public final zzk f36682f;

    /* renamed from: g, reason: collision with root package name */
    public final String f36683g;

    public zzdf(int i2, zzdd zzddVar, IBinder iBinder, IBinder iBinder2, PendingIntent pendingIntent, IBinder iBinder3, String str) {
        com.google.android.gms.location.zzu zzsVar;
        com.google.android.gms.location.zzr zzpVar;
        this.f36677a = i2;
        this.f36678b = zzddVar;
        zzk zziVar = null;
        if (iBinder != null) {
            int i3 = com.google.android.gms.location.zzt.f38392a;
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationListener");
            zzsVar = iInterfaceQueryLocalInterface instanceof com.google.android.gms.location.zzu ? (com.google.android.gms.location.zzu) iInterfaceQueryLocalInterface : new com.google.android.gms.location.zzs(iBinder, "com.google.android.gms.location.ILocationListener");
        } else {
            zzsVar = null;
        }
        this.f36679c = zzsVar;
        this.f36681e = pendingIntent;
        if (iBinder2 != null) {
            int i4 = com.google.android.gms.location.zzq.f38391a;
            IInterface iInterfaceQueryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.location.ILocationCallback");
            zzpVar = iInterfaceQueryLocalInterface2 instanceof com.google.android.gms.location.zzr ? (com.google.android.gms.location.zzr) iInterfaceQueryLocalInterface2 : new com.google.android.gms.location.zzp(iBinder2, "com.google.android.gms.location.ILocationCallback");
        } else {
            zzpVar = null;
        }
        this.f36680d = zzpVar;
        if (iBinder3 != null) {
            IInterface iInterfaceQueryLocalInterface3 = iBinder3.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            zziVar = iInterfaceQueryLocalInterface3 instanceof zzk ? (zzk) iInterfaceQueryLocalInterface3 : new zzi(iBinder3, "com.google.android.gms.location.internal.IFusedLocationProviderCallback");
        }
        this.f36682f = zziVar;
        this.f36683g = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f36677a);
        SafeParcelWriter.writeParcelable(parcel, 2, this.f36678b, i2, false);
        com.google.android.gms.location.zzu zzuVar = this.f36679c;
        SafeParcelWriter.writeIBinder(parcel, 3, zzuVar == null ? null : zzuVar.asBinder(), false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.f36681e, i2, false);
        com.google.android.gms.location.zzr zzrVar = this.f36680d;
        SafeParcelWriter.writeIBinder(parcel, 5, zzrVar == null ? null : zzrVar.asBinder(), false);
        zzk zzkVar = this.f36682f;
        SafeParcelWriter.writeIBinder(parcel, 6, zzkVar != null ? zzkVar.asBinder() : null, false);
        SafeParcelWriter.writeString(parcel, 8, this.f36683g, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
