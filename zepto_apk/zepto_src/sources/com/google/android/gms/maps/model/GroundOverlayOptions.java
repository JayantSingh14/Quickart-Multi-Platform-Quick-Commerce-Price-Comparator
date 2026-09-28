package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "GroundOverlayOptionsCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public final class GroundOverlayOptions extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<GroundOverlayOptions> CREATOR = new zzg();

    /* renamed from: a, reason: collision with root package name */
    public BitmapDescriptor f38461a;

    /* renamed from: b, reason: collision with root package name */
    public LatLng f38462b;

    /* renamed from: c, reason: collision with root package name */
    public float f38463c;

    /* renamed from: d, reason: collision with root package name */
    public float f38464d;

    /* renamed from: e, reason: collision with root package name */
    public LatLngBounds f38465e;

    /* renamed from: f, reason: collision with root package name */
    public float f38466f;

    /* renamed from: g, reason: collision with root package name */
    public float f38467g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f38468h = true;

    /* renamed from: i, reason: collision with root package name */
    public float f38469i = 0.0f;

    /* renamed from: j, reason: collision with root package name */
    public float f38470j = 0.5f;

    /* renamed from: k, reason: collision with root package name */
    public float f38471k = 0.5f;

    /* renamed from: l, reason: collision with root package name */
    public boolean f38472l = false;

    public final void A(float f2) {
        boolean z = false;
        if (f2 >= 0.0f && f2 <= 1.0f) {
            z = true;
        }
        Preconditions.checkArgument(z, "Transparency must be in the range [0..1]");
        this.f38469i = f2;
    }

    public final void N() {
        this.f38468h = false;
    }

    public final void Z(float f2) {
        this.f38467g = f2;
    }

    public final void b(float f2) {
        this.f38466f = ((f2 % 360.0f) + 360.0f) % 360.0f;
    }

    public final void r(BitmapDescriptor bitmapDescriptor) {
        Preconditions.checkNotNull(bitmapDescriptor, "imageDescriptor must not be null");
        this.f38461a = bitmapDescriptor;
    }

    public final void s(LatLngBounds latLngBounds) {
        LatLng latLng = this.f38462b;
        Preconditions.checkState(latLng == null, "Position has already been set using position: ".concat(String.valueOf(latLng)));
        this.f38465e = latLngBounds;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeIBinder(parcel, 2, this.f38461a.f38433a.asBinder(), false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.f38462b, i2, false);
        SafeParcelWriter.writeFloat(parcel, 4, this.f38463c);
        SafeParcelWriter.writeFloat(parcel, 5, this.f38464d);
        SafeParcelWriter.writeParcelable(parcel, 6, this.f38465e, i2, false);
        SafeParcelWriter.writeFloat(parcel, 7, this.f38466f);
        SafeParcelWriter.writeFloat(parcel, 8, this.f38467g);
        SafeParcelWriter.writeBoolean(parcel, 9, this.f38468h);
        SafeParcelWriter.writeFloat(parcel, 10, this.f38469i);
        SafeParcelWriter.writeFloat(parcel, 11, this.f38470j);
        SafeParcelWriter.writeFloat(parcel, 12, this.f38471k);
        SafeParcelWriter.writeBoolean(parcel, 13, this.f38472l);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
