package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

@SafeParcelable.Class(creator = "ProgramResponseCreator")
/* loaded from: classes4.dex */
public final class zzfvt extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfvt> CREATOR = new zzfvu();

    /* renamed from: a, reason: collision with root package name */
    public final int f31946a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f31947b;

    /* renamed from: c, reason: collision with root package name */
    public final int f31948c;

    public zzfvt(int i2, byte[] bArr, int i3) {
        this.f31946a = i2;
        this.f31947b = bArr == null ? null : Arrays.copyOf(bArr, bArr.length);
        this.f31948c = i3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f31946a);
        SafeParcelWriter.writeByteArray(parcel, 2, this.f31947b, false);
        SafeParcelWriter.writeInt(parcel, 3, this.f31948c);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public zzfvt() {
        this(1, null, 1);
    }
}
