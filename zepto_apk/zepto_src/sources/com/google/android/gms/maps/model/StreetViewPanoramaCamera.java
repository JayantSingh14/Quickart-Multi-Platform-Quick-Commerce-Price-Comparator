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
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;

@SafeParcelable.Class(creator = "StreetViewPanoramaCameraCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public class StreetViewPanoramaCamera extends AbstractSafeParcelable implements ReflectedParcelable {

    @NonNull
    public static final Parcelable.Creator<StreetViewPanoramaCamera> CREATOR = new zzu();

    /* renamed from: a, reason: collision with root package name */
    public final float f38537a;

    /* renamed from: b, reason: collision with root package name */
    public final float f38538b;

    /* renamed from: c, reason: collision with root package name */
    public final float f38539c;

    public static final class Builder {
    }

    public StreetViewPanoramaCamera(float f2, float f3, float f4) {
        boolean z = false;
        if (f3 >= -90.0f && f3 <= 90.0f) {
            z = true;
        }
        Preconditions.checkArgument(z, "Tilt needs to be between -90 and 90 inclusive: " + f3);
        this.f38537a = ((double) f2) <= 0.0d ? 0.0f : f2;
        this.f38538b = 0.0f + f3;
        this.f38539c = (((double) f4) <= 0.0d ? (f4 % 360.0f) + 360.0f : f4) % 360.0f;
        StreetViewPanoramaOrientation.Builder builder = new StreetViewPanoramaOrientation.Builder();
        builder.f38548b = f3;
        builder.f38547a = f4;
        new StreetViewPanoramaOrientation(builder.f38548b, builder.f38547a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreetViewPanoramaCamera)) {
            return false;
        }
        StreetViewPanoramaCamera streetViewPanoramaCamera = (StreetViewPanoramaCamera) obj;
        return Float.floatToIntBits(this.f38537a) == Float.floatToIntBits(streetViewPanoramaCamera.f38537a) && Float.floatToIntBits(this.f38538b) == Float.floatToIntBits(streetViewPanoramaCamera.f38538b) && Float.floatToIntBits(this.f38539c) == Float.floatToIntBits(streetViewPanoramaCamera.f38539c);
    }

    public final int hashCode() {
        return Objects.hashCode(Float.valueOf(this.f38537a), Float.valueOf(this.f38538b), Float.valueOf(this.f38539c));
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("zoom", Float.valueOf(this.f38537a)).add("tilt", Float.valueOf(this.f38538b)).add("bearing", Float.valueOf(this.f38539c)).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeFloat(parcel, 2, this.f38537a);
        SafeParcelWriter.writeFloat(parcel, 3, this.f38538b);
        SafeParcelWriter.writeFloat(parcel, 4, this.f38539c);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
