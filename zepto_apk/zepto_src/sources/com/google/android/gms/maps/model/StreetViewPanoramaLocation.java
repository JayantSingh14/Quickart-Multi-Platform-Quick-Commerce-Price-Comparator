package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "StreetViewPanoramaLocationCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public class StreetViewPanoramaLocation extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<StreetViewPanoramaLocation> CREATOR = new zzw();

    /* renamed from: a, reason: collision with root package name */
    public final StreetViewPanoramaLink[] f38542a;

    /* renamed from: b, reason: collision with root package name */
    public final LatLng f38543b;

    /* renamed from: c, reason: collision with root package name */
    public final String f38544c;

    public StreetViewPanoramaLocation(StreetViewPanoramaLink[] streetViewPanoramaLinkArr, LatLng latLng, String str) {
        this.f38542a = streetViewPanoramaLinkArr;
        this.f38543b = latLng;
        this.f38544c = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreetViewPanoramaLocation)) {
            return false;
        }
        StreetViewPanoramaLocation streetViewPanoramaLocation = (StreetViewPanoramaLocation) obj;
        return this.f38544c.equals(streetViewPanoramaLocation.f38544c) && this.f38543b.equals(streetViewPanoramaLocation.f38543b);
    }

    public final int hashCode() {
        return Objects.hashCode(this.f38543b, this.f38544c);
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("panoId", this.f38544c).add("position", this.f38543b.toString()).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedArray(parcel, 2, this.f38542a, i2, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.f38543b, i2, false);
        SafeParcelWriter.writeString(parcel, 4, this.f38544c, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
