package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.maps.zzap;

@SafeParcelable.Class(creator = "TileOverlayOptionsCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public final class TileOverlayOptions extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<TileOverlayOptions> CREATOR = new zzah();

    /* renamed from: a, reason: collision with root package name */
    public zzap f38564a;

    /* renamed from: b, reason: collision with root package name */
    public TileProvider f38565b;

    /* renamed from: d, reason: collision with root package name */
    public float f38567d;

    /* renamed from: c, reason: collision with root package name */
    public boolean f38566c = true;

    /* renamed from: e, reason: collision with root package name */
    public boolean f38568e = true;

    /* renamed from: f, reason: collision with root package name */
    public float f38569f = 0.0f;

    public final void b(TileProvider tileProvider) {
        this.f38565b = (TileProvider) Preconditions.checkNotNull(tileProvider, "tileProvider must not be null.");
        this.f38564a = new zzag(tileProvider);
    }

    public final void r(float f2) {
        boolean z = false;
        if (f2 >= 0.0f && f2 <= 1.0f) {
            z = true;
        }
        Preconditions.checkArgument(z, "Transparency must be in the range [0..1]");
        this.f38569f = f2;
    }

    public final void s(float f2) {
        this.f38567d = f2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        zzap zzapVar = this.f38564a;
        SafeParcelWriter.writeIBinder(parcel, 2, zzapVar == null ? null : zzapVar.asBinder(), false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.f38566c);
        SafeParcelWriter.writeFloat(parcel, 4, this.f38567d);
        SafeParcelWriter.writeBoolean(parcel, 5, this.f38568e);
        SafeParcelWriter.writeFloat(parcel, 6, this.f38569f);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
