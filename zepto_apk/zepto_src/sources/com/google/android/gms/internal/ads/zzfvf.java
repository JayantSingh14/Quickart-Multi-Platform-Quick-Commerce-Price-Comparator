package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "GassEventParcelCreator")
/* loaded from: classes4.dex */
public final class zzfvf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfvf> CREATOR = new zzfvg();

    /* renamed from: a, reason: collision with root package name */
    public final int f31918a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f31919b;

    public zzfvf(int i2, byte[] bArr) {
        this.f31918a = i2;
        this.f31919b = bArr;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f31918a);
        SafeParcelWriter.writeByteArray(parcel, 2, this.f31919b, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
