package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "TileCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public final class Tile extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<Tile> CREATOR = new zzae();

    /* renamed from: a, reason: collision with root package name */
    public final int f38560a;

    /* renamed from: b, reason: collision with root package name */
    public final int f38561b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f38562c;

    public Tile(int i2, byte[] bArr, int i3) {
        this.f38560a = i2;
        this.f38561b = i3;
        this.f38562c = bArr;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.f38560a);
        SafeParcelWriter.writeInt(parcel, 3, this.f38561b);
        SafeParcelWriter.writeByteArray(parcel, 4, this.f38562c, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
