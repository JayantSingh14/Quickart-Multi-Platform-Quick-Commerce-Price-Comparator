package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "StrokeStyleCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public final class StrokeStyle extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<StrokeStyle> CREATOR = new zzaa();

    /* renamed from: a, reason: collision with root package name */
    public final float f38551a;

    /* renamed from: b, reason: collision with root package name */
    public final int f38552b;

    /* renamed from: c, reason: collision with root package name */
    public final int f38553c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f38554d;

    /* renamed from: e, reason: collision with root package name */
    public final StampStyle f38555e;

    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public float f38556a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f38557b;
    }

    public StrokeStyle(float f2, int i2, int i3, boolean z, StampStyle stampStyle) {
        this.f38551a = f2;
        this.f38552b = i2;
        this.f38553c = i3;
        this.f38554d = z;
        this.f38555e = stampStyle;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeFloat(parcel, 2, this.f38551a);
        SafeParcelWriter.writeInt(parcel, 3, this.f38552b);
        SafeParcelWriter.writeInt(parcel, 4, this.f38553c);
        SafeParcelWriter.writeBoolean(parcel, 5, this.f38554d);
        SafeParcelWriter.writeParcelable(parcel, 6, this.f38555e, i2, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
