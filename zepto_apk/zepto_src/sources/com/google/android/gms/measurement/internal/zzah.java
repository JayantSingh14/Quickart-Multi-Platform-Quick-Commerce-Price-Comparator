package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "ConditionalUserPropertyParcelCreator")
/* loaded from: classes4.dex */
public final class zzah extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzah> CREATOR = new zzai();

    /* renamed from: a, reason: collision with root package name */
    public String f38676a;

    /* renamed from: b, reason: collision with root package name */
    public String f38677b;

    /* renamed from: c, reason: collision with root package name */
    public zzpk f38678c;

    /* renamed from: d, reason: collision with root package name */
    public long f38679d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f38680e;

    /* renamed from: f, reason: collision with root package name */
    public String f38681f;

    /* renamed from: g, reason: collision with root package name */
    public final zzbg f38682g;

    /* renamed from: h, reason: collision with root package name */
    public long f38683h;

    /* renamed from: i, reason: collision with root package name */
    public zzbg f38684i;

    /* renamed from: j, reason: collision with root package name */
    public final long f38685j;

    /* renamed from: k, reason: collision with root package name */
    public final zzbg f38686k;

    public zzah(zzah zzahVar) {
        Preconditions.checkNotNull(zzahVar);
        this.f38676a = zzahVar.f38676a;
        this.f38677b = zzahVar.f38677b;
        this.f38678c = zzahVar.f38678c;
        this.f38679d = zzahVar.f38679d;
        this.f38680e = zzahVar.f38680e;
        this.f38681f = zzahVar.f38681f;
        this.f38682g = zzahVar.f38682g;
        this.f38683h = zzahVar.f38683h;
        this.f38684i = zzahVar.f38684i;
        this.f38685j = zzahVar.f38685j;
        this.f38686k = zzahVar.f38686k;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.f38676a, false);
        SafeParcelWriter.writeString(parcel, 3, this.f38677b, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.f38678c, i2, false);
        SafeParcelWriter.writeLong(parcel, 5, this.f38679d);
        SafeParcelWriter.writeBoolean(parcel, 6, this.f38680e);
        SafeParcelWriter.writeString(parcel, 7, this.f38681f, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.f38682g, i2, false);
        SafeParcelWriter.writeLong(parcel, 9, this.f38683h);
        SafeParcelWriter.writeParcelable(parcel, 10, this.f38684i, i2, false);
        SafeParcelWriter.writeLong(parcel, 11, this.f38685j);
        SafeParcelWriter.writeParcelable(parcel, 12, this.f38686k, i2, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public zzah(String str, String str2, zzpk zzpkVar, long j2, boolean z, String str3, zzbg zzbgVar, long j3, zzbg zzbgVar2, long j4, zzbg zzbgVar3) {
        this.f38676a = str;
        this.f38677b = str2;
        this.f38678c = zzpkVar;
        this.f38679d = j2;
        this.f38680e = z;
        this.f38681f = str3;
        this.f38682g = zzbgVar;
        this.f38683h = j3;
        this.f38684i = zzbgVar2;
        this.f38685j = j4;
        this.f38686k = zzbgVar3;
    }
}
