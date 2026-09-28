package com.google.android.gms.plus.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@KeepName
@SafeParcelable.Class(creator = "PlusCommonExtrasCreator")
/* loaded from: classes4.dex */
public class PlusCommonExtras extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PlusCommonExtras> CREATOR = new zzl();

    /* renamed from: a, reason: collision with root package name */
    public final int f39692a;

    /* renamed from: b, reason: collision with root package name */
    public final String f39693b;

    /* renamed from: c, reason: collision with root package name */
    public final String f39694c;

    public PlusCommonExtras() {
        this.f39692a = 1;
        this.f39693b = "";
        this.f39694c = "";
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof PlusCommonExtras)) {
            return false;
        }
        PlusCommonExtras plusCommonExtras = (PlusCommonExtras) obj;
        return this.f39692a == plusCommonExtras.f39692a && Objects.equal(this.f39693b, plusCommonExtras.f39693b) && Objects.equal(this.f39694c, plusCommonExtras.f39694c);
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f39692a), this.f39693b, this.f39694c);
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("versionCode", Integer.valueOf(this.f39692a)).add("Gpsrc", this.f39693b).add("ClientCallingPackage", this.f39694c).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.f39693b, false);
        SafeParcelWriter.writeString(parcel, 2, this.f39694c, false);
        SafeParcelWriter.writeInt(parcel, 1000, this.f39692a);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public PlusCommonExtras(int i2, String str, String str2) {
        this.f39692a = i2;
        this.f39693b = str;
        this.f39694c = str2;
    }
}
