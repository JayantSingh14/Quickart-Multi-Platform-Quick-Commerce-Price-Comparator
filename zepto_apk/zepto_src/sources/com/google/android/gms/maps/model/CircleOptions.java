package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;

@SafeParcelable.Class(creator = "CircleOptionsCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public final class CircleOptions extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<CircleOptions> CREATOR = new zzc();

    /* renamed from: a, reason: collision with root package name */
    public LatLng f38447a = null;

    /* renamed from: b, reason: collision with root package name */
    public double f38448b = 0.0d;

    /* renamed from: c, reason: collision with root package name */
    public float f38449c = 10.0f;

    /* renamed from: d, reason: collision with root package name */
    public int f38450d = -16777216;

    /* renamed from: e, reason: collision with root package name */
    public int f38451e = 0;

    /* renamed from: f, reason: collision with root package name */
    public float f38452f = 0.0f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f38453g = true;

    /* renamed from: h, reason: collision with root package name */
    public boolean f38454h = false;

    /* renamed from: i, reason: collision with root package name */
    public ArrayList f38455i = null;

    public final void A(int i2) {
        this.f38450d = i2;
    }

    public final void N(float f2) {
        this.f38449c = f2;
    }

    public final void Z(float f2) {
        this.f38452f = f2;
    }

    public final void b(LatLng latLng) {
        Preconditions.checkNotNull(latLng, "center must not be null.");
        this.f38447a = latLng;
    }

    public final void r(int i2) {
        this.f38451e = i2;
    }

    public final void s(double d2) {
        this.f38448b = d2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.f38447a, i2, false);
        SafeParcelWriter.writeDouble(parcel, 3, this.f38448b);
        SafeParcelWriter.writeFloat(parcel, 4, this.f38449c);
        SafeParcelWriter.writeInt(parcel, 5, this.f38450d);
        SafeParcelWriter.writeInt(parcel, 6, this.f38451e);
        SafeParcelWriter.writeFloat(parcel, 7, this.f38452f);
        SafeParcelWriter.writeBoolean(parcel, 8, this.f38453g);
        SafeParcelWriter.writeBoolean(parcel, 9, this.f38454h);
        SafeParcelWriter.writeTypedList(parcel, 10, this.f38455i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
