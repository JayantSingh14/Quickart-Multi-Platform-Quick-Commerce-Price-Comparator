package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "CameraPositionCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public final class CameraPosition extends AbstractSafeParcelable implements ReflectedParcelable {

    @NonNull
    public static final Parcelable.Creator<CameraPosition> CREATOR = new zza();

    /* renamed from: a, reason: collision with root package name */
    public final LatLng f38435a;

    /* renamed from: b, reason: collision with root package name */
    public final float f38436b;

    /* renamed from: c, reason: collision with root package name */
    public final float f38437c;

    /* renamed from: d, reason: collision with root package name */
    public final float f38438d;

    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public LatLng f38439a;

        /* renamed from: b, reason: collision with root package name */
        public float f38440b;

        /* renamed from: c, reason: collision with root package name */
        public float f38441c;

        /* renamed from: d, reason: collision with root package name */
        public float f38442d;

        public Builder() {
        }

        public final void a(float f2) {
            this.f38442d = f2;
        }

        public final CameraPosition b() {
            return new CameraPosition(this.f38439a, this.f38440b, this.f38441c, this.f38442d);
        }

        public final void c(LatLng latLng) {
            this.f38439a = (LatLng) Preconditions.checkNotNull(latLng, "location must not be null.");
        }

        public final void d(float f2) {
            this.f38441c = f2;
        }

        public final void e(float f2) {
            this.f38440b = f2;
        }

        public Builder(CameraPosition cameraPosition) {
            CameraPosition cameraPosition2 = (CameraPosition) Preconditions.checkNotNull(cameraPosition, "previous must not be null.");
            this.f38439a = cameraPosition2.f38435a;
            this.f38440b = cameraPosition2.f38436b;
            this.f38441c = cameraPosition2.f38437c;
            this.f38442d = cameraPosition2.f38438d;
        }
    }

    public CameraPosition(LatLng latLng, float f2, float f3, float f4) {
        Preconditions.checkNotNull(latLng, "camera target must not be null.");
        boolean z = false;
        if (f3 >= 0.0f && f3 <= 90.0f) {
            z = true;
        }
        Preconditions.checkArgument(z, "Tilt needs to be between 0 and 90 inclusive: %s", Float.valueOf(f3));
        this.f38435a = latLng;
        this.f38436b = f2;
        this.f38437c = f3 + 0.0f;
        this.f38438d = (((double) f4) <= 0.0d ? (f4 % 360.0f) + 360.0f : f4) % 360.0f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CameraPosition)) {
            return false;
        }
        CameraPosition cameraPosition = (CameraPosition) obj;
        return this.f38435a.equals(cameraPosition.f38435a) && Float.floatToIntBits(this.f38436b) == Float.floatToIntBits(cameraPosition.f38436b) && Float.floatToIntBits(this.f38437c) == Float.floatToIntBits(cameraPosition.f38437c) && Float.floatToIntBits(this.f38438d) == Float.floatToIntBits(cameraPosition.f38438d);
    }

    public final int hashCode() {
        return Objects.hashCode(this.f38435a, Float.valueOf(this.f38436b), Float.valueOf(this.f38437c), Float.valueOf(this.f38438d));
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("target", this.f38435a).add("zoom", Float.valueOf(this.f38436b)).add("tilt", Float.valueOf(this.f38437c)).add("bearing", Float.valueOf(this.f38438d)).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.f38435a, i2, false);
        SafeParcelWriter.writeFloat(parcel, 3, this.f38436b);
        SafeParcelWriter.writeFloat(parcel, 4, this.f38437c);
        SafeParcelWriter.writeFloat(parcel, 5, this.f38438d);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
