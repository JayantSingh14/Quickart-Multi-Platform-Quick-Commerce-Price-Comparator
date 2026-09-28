package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "StyleSpanCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public final class StyleSpan extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<StyleSpan> CREATOR = new zzab();

    /* renamed from: a, reason: collision with root package name */
    public final StrokeStyle f38558a;

    /* renamed from: b, reason: collision with root package name */
    public final double f38559b;

    public StyleSpan(StrokeStyle strokeStyle, double d2) {
        if (d2 <= 0.0d) {
            throw new IllegalArgumentException("A style must be applied to some segments on a polyline.");
        }
        this.f38558a = strokeStyle;
        this.f38559b = d2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.f38558a, i2, false);
        SafeParcelWriter.writeDouble(parcel, 3, this.f38559b);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
