package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "StreetViewPanoramaLinkCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public class StreetViewPanoramaLink extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<StreetViewPanoramaLink> CREATOR = new zzv();

    /* renamed from: a, reason: collision with root package name */
    public final String f38540a;

    /* renamed from: b, reason: collision with root package name */
    public final float f38541b;

    public StreetViewPanoramaLink(String str, float f2) {
        this.f38540a = str;
        this.f38541b = (((double) f2) <= 0.0d ? (f2 % 360.0f) + 360.0f : f2) % 360.0f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreetViewPanoramaLink)) {
            return false;
        }
        StreetViewPanoramaLink streetViewPanoramaLink = (StreetViewPanoramaLink) obj;
        return this.f38540a.equals(streetViewPanoramaLink.f38540a) && Float.floatToIntBits(this.f38541b) == Float.floatToIntBits(streetViewPanoramaLink.f38541b);
    }

    public final int hashCode() {
        return Objects.hashCode(this.f38540a, Float.valueOf(this.f38541b));
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("panoId", this.f38540a).add("bearing", Float.valueOf(this.f38541b)).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.f38540a, false);
        SafeParcelWriter.writeFloat(parcel, 3, this.f38541b);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
