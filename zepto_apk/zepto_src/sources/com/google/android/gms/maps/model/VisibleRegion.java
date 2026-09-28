package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "VisibleRegionCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public final class VisibleRegion extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<VisibleRegion> CREATOR = new zzai();

    /* renamed from: a, reason: collision with root package name */
    public final LatLng f38573a;

    /* renamed from: b, reason: collision with root package name */
    public final LatLng f38574b;

    /* renamed from: c, reason: collision with root package name */
    public final LatLng f38575c;

    /* renamed from: d, reason: collision with root package name */
    public final LatLng f38576d;

    /* renamed from: e, reason: collision with root package name */
    public final LatLngBounds f38577e;

    public VisibleRegion(LatLng latLng, LatLng latLng2, LatLng latLng3, LatLng latLng4, LatLngBounds latLngBounds) {
        this.f38573a = latLng;
        this.f38574b = latLng2;
        this.f38575c = latLng3;
        this.f38576d = latLng4;
        this.f38577e = latLngBounds;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VisibleRegion)) {
            return false;
        }
        VisibleRegion visibleRegion = (VisibleRegion) obj;
        return this.f38573a.equals(visibleRegion.f38573a) && this.f38574b.equals(visibleRegion.f38574b) && this.f38575c.equals(visibleRegion.f38575c) && this.f38576d.equals(visibleRegion.f38576d) && this.f38577e.equals(visibleRegion.f38577e);
    }

    public final int hashCode() {
        return Objects.hashCode(this.f38573a, this.f38574b, this.f38575c, this.f38576d, this.f38577e);
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("nearLeft", this.f38573a).add("nearRight", this.f38574b).add("farLeft", this.f38575c).add("farRight", this.f38576d).add("latLngBounds", this.f38577e).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.f38573a, i2, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.f38574b, i2, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.f38575c, i2, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.f38576d, i2, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.f38577e, i2, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
