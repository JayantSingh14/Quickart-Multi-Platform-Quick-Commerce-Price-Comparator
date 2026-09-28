package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "StreetViewPanoramaOrientationCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public class StreetViewPanoramaOrientation extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<StreetViewPanoramaOrientation> CREATOR = new zzx();

    /* renamed from: a, reason: collision with root package name */
    public final float f38545a;

    /* renamed from: b, reason: collision with root package name */
    public final float f38546b;

    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public float f38547a;

        /* renamed from: b, reason: collision with root package name */
        public float f38548b;
    }

    public StreetViewPanoramaOrientation(float f2, float f3) {
        boolean z = false;
        if (f2 >= -90.0f && f2 <= 90.0f) {
            z = true;
        }
        Preconditions.checkArgument(z, "Tilt needs to be between -90 and 90 inclusive: " + f2);
        this.f38545a = f2 + 0.0f;
        this.f38546b = (((double) f3) <= 0.0d ? (f3 % 360.0f) + 360.0f : f3) % 360.0f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreetViewPanoramaOrientation)) {
            return false;
        }
        StreetViewPanoramaOrientation streetViewPanoramaOrientation = (StreetViewPanoramaOrientation) obj;
        return Float.floatToIntBits(this.f38545a) == Float.floatToIntBits(streetViewPanoramaOrientation.f38545a) && Float.floatToIntBits(this.f38546b) == Float.floatToIntBits(streetViewPanoramaOrientation.f38546b);
    }

    public final int hashCode() {
        return Objects.hashCode(Float.valueOf(this.f38545a), Float.valueOf(this.f38546b));
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("tilt", Float.valueOf(this.f38545a)).add("bearing", Float.valueOf(this.f38546b)).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeFloat(parcel, 2, this.f38545a);
        SafeParcelWriter.writeFloat(parcel, 3, this.f38546b);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
