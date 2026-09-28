package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.ObjectWrapper;

@SafeParcelable.Class(creator = "MarkerOptionsCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public class MarkerOptions extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<MarkerOptions> CREATOR = new zzl();

    /* renamed from: a, reason: collision with root package name */
    public LatLng f38486a;

    /* renamed from: b, reason: collision with root package name */
    public String f38487b;

    /* renamed from: c, reason: collision with root package name */
    public String f38488c;

    /* renamed from: d, reason: collision with root package name */
    public BitmapDescriptor f38489d;

    /* renamed from: g, reason: collision with root package name */
    public boolean f38492g;
    public float n;
    public View p;
    public int q;
    public String r;
    public float s;

    /* renamed from: e, reason: collision with root package name */
    public float f38490e = 0.5f;

    /* renamed from: f, reason: collision with root package name */
    public float f38491f = 1.0f;

    /* renamed from: h, reason: collision with root package name */
    public boolean f38493h = true;

    /* renamed from: i, reason: collision with root package name */
    public boolean f38494i = false;

    /* renamed from: j, reason: collision with root package name */
    public float f38495j = 0.0f;

    /* renamed from: k, reason: collision with root package name */
    public float f38496k = 0.5f;

    /* renamed from: l, reason: collision with root package name */
    public float f38497l = 0.0f;

    /* renamed from: m, reason: collision with root package name */
    public float f38498m = 1.0f;
    public int o = 0;

    public void A(boolean z) {
        this.f38494i = z;
    }

    public final LatLng D0() {
        return this.f38486a;
    }

    public final float N() {
        return this.f38498m;
    }

    public final float S1() {
        return this.f38495j;
    }

    public final String T1() {
        return this.f38488c;
    }

    public final String U1() {
        return this.f38487b;
    }

    public final float V1() {
        return this.n;
    }

    public void W1(BitmapDescriptor bitmapDescriptor) {
        this.f38489d = bitmapDescriptor;
    }

    public void X1(float f2, float f3) {
        this.f38496k = f2;
        this.f38497l = f3;
    }

    public final boolean Y1() {
        return this.f38492g;
    }

    public final float Z() {
        return this.f38490e;
    }

    public final boolean Z1() {
        return this.f38494i;
    }

    public void a2(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("latlng cannot be null - a position is required.");
        }
        this.f38486a = latLng;
    }

    public void b(float f2) {
        this.f38498m = f2;
    }

    public void b2(float f2) {
        this.f38495j = f2;
    }

    public void c2(String str) {
        this.f38488c = str;
    }

    public void d2(String str) {
        this.f38487b = str;
    }

    public void e2(float f2) {
        this.n = f2;
    }

    public final float l0() {
        return this.f38491f;
    }

    public final BitmapDescriptor n0() {
        return this.f38489d;
    }

    public void r(float f2, float f3) {
        this.f38490e = f2;
        this.f38491f = f3;
    }

    public void s(boolean z) {
        this.f38492g = z;
    }

    public final float s0() {
        return this.f38496k;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.f38486a, i2, false);
        SafeParcelWriter.writeString(parcel, 3, this.f38487b, false);
        SafeParcelWriter.writeString(parcel, 4, this.f38488c, false);
        BitmapDescriptor bitmapDescriptor = this.f38489d;
        SafeParcelWriter.writeIBinder(parcel, 5, bitmapDescriptor == null ? null : bitmapDescriptor.f38433a.asBinder(), false);
        SafeParcelWriter.writeFloat(parcel, 6, this.f38490e);
        SafeParcelWriter.writeFloat(parcel, 7, this.f38491f);
        SafeParcelWriter.writeBoolean(parcel, 8, this.f38492g);
        SafeParcelWriter.writeBoolean(parcel, 9, this.f38493h);
        SafeParcelWriter.writeBoolean(parcel, 10, this.f38494i);
        SafeParcelWriter.writeFloat(parcel, 11, this.f38495j);
        SafeParcelWriter.writeFloat(parcel, 12, this.f38496k);
        SafeParcelWriter.writeFloat(parcel, 13, this.f38497l);
        SafeParcelWriter.writeFloat(parcel, 14, this.f38498m);
        SafeParcelWriter.writeFloat(parcel, 15, this.n);
        SafeParcelWriter.writeInt(parcel, 17, this.o);
        SafeParcelWriter.writeIBinder(parcel, 18, new ObjectWrapper(this.p).asBinder(), false);
        SafeParcelWriter.writeInt(parcel, 19, this.q);
        SafeParcelWriter.writeString(parcel, 20, this.r, false);
        SafeParcelWriter.writeFloat(parcel, 21, this.s);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final float y0() {
        return this.f38497l;
    }
}
