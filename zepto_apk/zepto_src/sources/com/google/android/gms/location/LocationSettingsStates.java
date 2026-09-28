package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "LocationSettingsStatesCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class LocationSettingsStates extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<LocationSettingsStates> CREATOR = new zzab();

    /* renamed from: a, reason: collision with root package name */
    public final boolean f38346a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f38347b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f38348c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f38349d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f38350e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f38351f;

    public LocationSettingsStates(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.f38346a = z;
        this.f38347b = z2;
        this.f38348c = z3;
        this.f38349d = z4;
        this.f38350e = z5;
        this.f38351f = z6;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, this.f38346a);
        SafeParcelWriter.writeBoolean(parcel, 2, this.f38347b);
        SafeParcelWriter.writeBoolean(parcel, 3, this.f38348c);
        SafeParcelWriter.writeBoolean(parcel, 4, this.f38349d);
        SafeParcelWriter.writeBoolean(parcel, 5, this.f38350e);
        SafeParcelWriter.writeBoolean(parcel, 6, this.f38351f);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
