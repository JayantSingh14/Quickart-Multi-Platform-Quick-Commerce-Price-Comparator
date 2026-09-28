package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "InterstitialAdParameterParcelCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public final class zzl extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzl> CREATOR = new zzm();

    /* renamed from: a, reason: collision with root package name */
    public final boolean f21653a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f21654b;

    /* renamed from: c, reason: collision with root package name */
    public final String f21655c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f21656d;

    /* renamed from: e, reason: collision with root package name */
    public final float f21657e;

    /* renamed from: f, reason: collision with root package name */
    public final int f21658f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f21659g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f21660h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f21661i;

    public zzl(boolean z, boolean z2, String str, boolean z3, float f2, int i2, boolean z4, boolean z5, boolean z6) {
        this.f21653a = z;
        this.f21654b = z2;
        this.f21655c = str;
        this.f21656d = z3;
        this.f21657e = f2;
        this.f21658f = i2;
        this.f21659g = z4;
        this.f21660h = z5;
        this.f21661i = z6;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 2, this.f21653a);
        SafeParcelWriter.writeBoolean(parcel, 3, this.f21654b);
        SafeParcelWriter.writeString(parcel, 4, this.f21655c, false);
        SafeParcelWriter.writeBoolean(parcel, 5, this.f21656d);
        SafeParcelWriter.writeFloat(parcel, 6, this.f21657e);
        SafeParcelWriter.writeInt(parcel, 7, this.f21658f);
        SafeParcelWriter.writeBoolean(parcel, 8, this.f21659g);
        SafeParcelWriter.writeBoolean(parcel, 9, this.f21660h);
        SafeParcelWriter.writeBoolean(parcel, 10, this.f21661i);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public zzl(boolean z, boolean z2, boolean z3, float f2, boolean z4, boolean z5, boolean z6) {
        this(z, z2, null, z3, f2, -1, z4, z5, z6);
    }
}
