package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "LatLngBoundsCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public final class LatLngBounds extends AbstractSafeParcelable implements ReflectedParcelable {

    @NonNull
    @KeepForSdk
    public static final Parcelable.Creator<LatLngBounds> CREATOR = new zzi();

    /* renamed from: a, reason: collision with root package name */
    public final LatLng f38477a;

    /* renamed from: b, reason: collision with root package name */
    public final LatLng f38478b;

    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public double f38479a = Double.POSITIVE_INFINITY;

        /* renamed from: b, reason: collision with root package name */
        public double f38480b = Double.NEGATIVE_INFINITY;

        /* renamed from: c, reason: collision with root package name */
        public double f38481c = Double.NaN;

        /* renamed from: d, reason: collision with root package name */
        public double f38482d = Double.NaN;

        public final LatLngBounds a() {
            Preconditions.checkState(!Double.isNaN(this.f38481c), "no included points");
            return new LatLngBounds(new LatLng(this.f38479a, this.f38481c), new LatLng(this.f38480b, this.f38482d));
        }

        public final void b(LatLng latLng) {
            Preconditions.checkNotNull(latLng, "point must not be null");
            this.f38479a = Math.min(this.f38479a, latLng.f38475a);
            this.f38480b = Math.max(this.f38480b, latLng.f38475a);
            boolean zIsNaN = Double.isNaN(this.f38481c);
            double d2 = latLng.f38476b;
            if (zIsNaN) {
                this.f38481c = d2;
                this.f38482d = d2;
                return;
            }
            double d3 = this.f38481c;
            double d4 = this.f38482d;
            if (d3 <= d4) {
                if (d3 <= d2 && d2 <= d4) {
                    return;
                }
            } else if (d3 <= d2 || d2 <= d4) {
                return;
            }
            Parcelable.Creator<LatLngBounds> creator = LatLngBounds.CREATOR;
            if (((d3 - d2) + 360.0d) % 360.0d < ((d2 - d4) + 360.0d) % 360.0d) {
                this.f38481c = d2;
            } else {
                this.f38482d = d2;
            }
        }
    }

    public LatLngBounds(LatLng latLng, LatLng latLng2) {
        Preconditions.checkNotNull(latLng, "southwest must not be null.");
        Preconditions.checkNotNull(latLng2, "northeast must not be null.");
        double d2 = latLng2.f38475a;
        double d3 = latLng.f38475a;
        Preconditions.checkArgument(d2 >= d3, "southern latitude exceeds northern latitude (%s > %s)", Double.valueOf(d3), Double.valueOf(latLng2.f38475a));
        this.f38477a = latLng;
        this.f38478b = latLng2;
    }

    public final LatLng b() {
        LatLng latLng = this.f38477a;
        double d2 = latLng.f38475a;
        LatLng latLng2 = this.f38478b;
        double d3 = d2 + latLng2.f38475a;
        double d4 = latLng.f38476b;
        double d5 = latLng2.f38476b;
        if (d4 > d5) {
            d5 += 360.0d;
        }
        return new LatLng(d3 / 2.0d, (d5 + d4) / 2.0d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLngBounds)) {
            return false;
        }
        LatLngBounds latLngBounds = (LatLngBounds) obj;
        return this.f38477a.equals(latLngBounds.f38477a) && this.f38478b.equals(latLngBounds.f38478b);
    }

    public final int hashCode() {
        return Objects.hashCode(this.f38477a, this.f38478b);
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("southwest", this.f38477a).add("northeast", this.f38478b).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.f38477a, i2, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.f38478b, i2, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
