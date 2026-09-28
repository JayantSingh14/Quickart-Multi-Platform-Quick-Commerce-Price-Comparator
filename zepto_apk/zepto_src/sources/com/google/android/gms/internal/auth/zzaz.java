package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "SendDataRequestCreator")
/* loaded from: classes4.dex */
public final class zzaz extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaz> CREATOR = new zzba();

    /* renamed from: a, reason: collision with root package name */
    public final int f36296a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final String f36297b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f36298c;

    public zzaz(String str, byte[] bArr) {
        this.f36297b = (String) Preconditions.checkNotNull(str);
        this.f36298c = (byte[]) Preconditions.checkNotNull(bArr);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f36296a);
        SafeParcelWriter.writeString(parcel, 2, this.f36297b, false);
        SafeParcelWriter.writeByteArray(parcel, 3, this.f36298c, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
