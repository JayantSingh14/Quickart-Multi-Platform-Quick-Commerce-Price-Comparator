package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

/* loaded from: classes4.dex */
public final class zzp implements Parcelable {
    public static final Parcelable.Creator<zzp> CREATOR = new zzo();

    /* renamed from: a, reason: collision with root package name */
    public int f35277a;

    /* renamed from: b, reason: collision with root package name */
    public final UUID f35278b;

    /* renamed from: c, reason: collision with root package name */
    public final String f35279c;

    /* renamed from: d, reason: collision with root package name */
    public final String f35280d;

    /* renamed from: e, reason: collision with root package name */
    public final byte[] f35281e;

    public zzp(Parcel parcel) {
        this.f35278b = new UUID(parcel.readLong(), parcel.readLong());
        this.f35279c = parcel.readString();
        String string = parcel.readString();
        String str = zzfj.f31254a;
        this.f35280d = string;
        this.f35281e = parcel.createByteArray();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzp)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        zzp zzpVar = (zzp) obj;
        return Objects.equals(this.f35279c, zzpVar.f35279c) && Objects.equals(this.f35280d, zzpVar.f35280d) && Objects.equals(this.f35278b, zzpVar.f35278b) && Arrays.equals(this.f35281e, zzpVar.f35281e);
    }

    public final int hashCode() {
        int i2 = this.f35277a;
        if (i2 != 0) {
            return i2;
        }
        int iHashCode = this.f35278b.hashCode() * 31;
        String str = this.f35279c;
        int iHashCode2 = Arrays.hashCode(this.f35281e) + androidx.fragment.app.e.e((iHashCode + (str == null ? 0 : str.hashCode())) * 31, 31, this.f35280d);
        this.f35277a = iHashCode2;
        return iHashCode2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        UUID uuid = this.f35278b;
        parcel.writeLong(uuid.getMostSignificantBits());
        parcel.writeLong(uuid.getLeastSignificantBits());
        parcel.writeString(this.f35279c);
        parcel.writeString(this.f35280d);
        parcel.writeByteArray(this.f35281e);
    }

    public zzp(UUID uuid, String str, byte[] bArr) {
        uuid.getClass();
        this.f35278b = uuid;
        this.f35279c = null;
        this.f35280d = zzas.h(str);
        this.f35281e = bArr;
    }
}
