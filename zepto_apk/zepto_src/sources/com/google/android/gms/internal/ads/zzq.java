package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.UUID;

/* loaded from: classes4.dex */
public final class zzq implements Comparator<zzp>, Parcelable {
    public static final Parcelable.Creator<zzq> CREATOR = new zzn();

    /* renamed from: a, reason: collision with root package name */
    public final zzp[] f35361a;

    /* renamed from: b, reason: collision with root package name */
    public int f35362b;

    /* renamed from: c, reason: collision with root package name */
    public final String f35363c;

    /* renamed from: d, reason: collision with root package name */
    public final int f35364d;

    public zzq(Parcel parcel) {
        this.f35363c = parcel.readString();
        zzp[] zzpVarArr = (zzp[]) parcel.createTypedArray(zzp.CREATOR);
        String str = zzfj.f31254a;
        this.f35361a = zzpVarArr;
        this.f35364d = zzpVarArr.length;
    }

    public final zzq a(String str) {
        return Objects.equals(this.f35363c, str) ? this : new zzq(str, false, this.f35361a);
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(zzp zzpVar, zzp zzpVar2) {
        zzp zzpVar3 = zzpVar2;
        UUID uuid = zzg.f32142a;
        UUID uuid2 = zzpVar.f35278b;
        return uuid.equals(uuid2) ? !uuid.equals(zzpVar3.f35278b) ? 1 : 0 : uuid2.compareTo(zzpVar3.f35278b);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzq.class == obj.getClass()) {
            zzq zzqVar = (zzq) obj;
            if (Objects.equals(this.f35363c, zzqVar.f35363c) && Arrays.equals(this.f35361a, zzqVar.f35361a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i2 = this.f35362b;
        if (i2 != 0) {
            return i2;
        }
        String str = this.f35363c;
        int iHashCode = ((str == null ? 0 : str.hashCode()) * 31) + Arrays.hashCode(this.f35361a);
        this.f35362b = iHashCode;
        return iHashCode;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f35363c);
        parcel.writeTypedArray(this.f35361a, 0);
    }

    public zzq(String str, boolean z, zzp... zzpVarArr) {
        this.f35363c = str;
        zzpVarArr = z ? (zzp[]) zzpVarArr.clone() : zzpVarArr;
        this.f35361a = zzpVarArr;
        this.f35364d = zzpVarArr.length;
        Arrays.sort(zzpVarArr, this);
    }
}
