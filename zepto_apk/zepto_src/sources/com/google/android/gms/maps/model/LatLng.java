package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "LatLngCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public final class LatLng extends AbstractSafeParcelable implements ReflectedParcelable {

    @NonNull
    @KeepForSdk
    public static final Parcelable.Creator<LatLng> CREATOR = new zzj();

    /* renamed from: a, reason: collision with root package name */
    public final double f38475a;

    /* renamed from: b, reason: collision with root package name */
    public final double f38476b;

    public LatLng(double d2, double d3) {
        if (d3 < -180.0d || d3 >= 180.0d) {
            this.f38476b = ((((d3 - 180.0d) % 360.0d) + 360.0d) % 360.0d) - 180.0d;
        } else {
            this.f38476b = d3;
        }
        this.f38475a = Math.max(-90.0d, Math.min(90.0d, d2));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLng)) {
            return false;
        }
        LatLng latLng = (LatLng) obj;
        return Double.doubleToLongBits(this.f38475a) == Double.doubleToLongBits(latLng.f38475a) && Double.doubleToLongBits(this.f38476b) == Double.doubleToLongBits(latLng.f38476b);
    }

    public final int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.f38475a);
        long j2 = jDoubleToLongBits ^ (jDoubleToLongBits >>> 32);
        long jDoubleToLongBits2 = Double.doubleToLongBits(this.f38476b);
        return ((((int) j2) + 31) * 31) + ((int) (jDoubleToLongBits2 ^ (jDoubleToLongBits2 >>> 32)));
    }

    public final String toString() {
        return "lat/lng: (" + this.f38475a + "," + this.f38476b + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeDouble(parcel, 2, this.f38475a);
        SafeParcelWriter.writeDouble(parcel, 3, this.f38476b);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
