package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

@SafeParcelable.Class(creator = "AuthenticationExtensionsDevicePublicKeyOutputsCreator")
/* loaded from: classes4.dex */
public final class zzf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzf> CREATOR = new zzg();

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f22456a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f22457b;

    public zzf(byte[] bArr, byte[] bArr2) {
        this.f22456a = bArr;
        this.f22457b = bArr2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzf)) {
            return false;
        }
        zzf zzfVar = (zzf) obj;
        return Arrays.equals(this.f22456a, zzfVar.f22456a) && Arrays.equals(this.f22457b, zzfVar.f22457b);
    }

    public final int hashCode() {
        return Objects.hashCode(this.f22456a, this.f22457b);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByteArray(parcel, 1, this.f22456a, false);
        SafeParcelWriter.writeByteArray(parcel, 2, this.f22457b, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
