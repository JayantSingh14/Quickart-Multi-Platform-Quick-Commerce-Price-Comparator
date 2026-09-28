package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

@SafeParcelable.Class(creator = "AuthenticationExtensionsPrfOutputsCreator")
/* loaded from: classes4.dex */
public final class zzh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzh> CREATOR = new zzi();

    /* renamed from: a, reason: collision with root package name */
    public final boolean f22458a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f22459b;

    public zzh(byte[] bArr, boolean z) {
        this.f22458a = z;
        this.f22459b = bArr;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzh)) {
            return false;
        }
        zzh zzhVar = (zzh) obj;
        return this.f22458a == zzhVar.f22458a && Arrays.equals(this.f22459b, zzhVar.f22459b);
    }

    public final int hashCode() {
        return Objects.hashCode(Boolean.valueOf(this.f22458a), this.f22459b);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, this.f22458a);
        SafeParcelWriter.writeByteArray(parcel, 2, this.f22459b, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
