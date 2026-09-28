package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "PointOfInterestCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public final class PointOfInterest extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<PointOfInterest> CREATOR = new zzp();

    /* renamed from: a, reason: collision with root package name */
    public final LatLng f38508a;

    /* renamed from: b, reason: collision with root package name */
    public final String f38509b;

    /* renamed from: c, reason: collision with root package name */
    public final String f38510c;

    public PointOfInterest(LatLng latLng, String str, String str2) {
        this.f38508a = latLng;
        this.f38509b = str;
        this.f38510c = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.f38508a, i2, false);
        SafeParcelWriter.writeString(parcel, 3, this.f38509b, false);
        SafeParcelWriter.writeString(parcel, 4, this.f38510c, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
