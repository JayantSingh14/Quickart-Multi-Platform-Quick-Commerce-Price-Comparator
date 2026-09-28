package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "LocationSettingsResultCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class LocationSettingsResult extends AbstractSafeParcelable implements Result {

    @NonNull
    public static final Parcelable.Creator<LocationSettingsResult> CREATOR = new zzaa();

    /* renamed from: a, reason: collision with root package name */
    public final Status f38344a;

    /* renamed from: b, reason: collision with root package name */
    public final LocationSettingsStates f38345b;

    public LocationSettingsResult(Status status, LocationSettingsStates locationSettingsStates) {
        this.f38344a = status;
        this.f38345b = locationSettingsStates;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f38344a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.f38344a, i2, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.f38345b, i2, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
