package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.b;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "DetectedActivityCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public class DetectedActivity extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<DetectedActivity> CREATOR = new zzl();

    /* renamed from: a, reason: collision with root package name */
    public int f38295a;

    /* renamed from: b, reason: collision with root package name */
    public int f38296b;

    public final boolean equals(Object obj) {
        if (obj instanceof DetectedActivity) {
            DetectedActivity detectedActivity = (DetectedActivity) obj;
            if (this.f38295a == detectedActivity.f38295a && this.f38296b == detectedActivity.f38296b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f38295a), Integer.valueOf(this.f38296b));
    }

    public final String toString() {
        int i2 = this.f38295a;
        if (i2 > 22 || i2 < 0) {
            i2 = 4;
        }
        return b.o(b.y("DetectedActivity [type=", i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? i2 != 7 ? i2 != 8 ? i2 != 16 ? i2 != 17 ? Integer.toString(i2) : "IN_RAIL_VEHICLE" : "IN_ROAD_VEHICLE" : "RUNNING" : "WALKING" : "TILTING" : "UNKNOWN" : "STILL" : "ON_FOOT" : "ON_BICYCLE" : "IN_VEHICLE", ", confidence="), this.f38296b, "]");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        Preconditions.checkNotNull(parcel);
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f38295a);
        SafeParcelWriter.writeInt(parcel, 2, this.f38296b);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
