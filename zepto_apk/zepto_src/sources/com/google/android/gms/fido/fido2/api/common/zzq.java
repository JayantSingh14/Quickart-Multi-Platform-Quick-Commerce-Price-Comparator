package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

@SafeParcelable.Class(creator = "CableAuthenticationDataCreator")
/* loaded from: classes4.dex */
public final class zzq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzq> CREATOR = new zzr();

    /* renamed from: a, reason: collision with root package name */
    public final long f22460a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f22461b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f22462c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f22463d;

    public zzq(long j2, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        this.f22460a = j2;
        this.f22461b = (byte[]) Preconditions.checkNotNull(bArr);
        this.f22462c = (byte[]) Preconditions.checkNotNull(bArr2);
        this.f22463d = (byte[]) Preconditions.checkNotNull(bArr3);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzq)) {
            return false;
        }
        zzq zzqVar = (zzq) obj;
        return this.f22460a == zzqVar.f22460a && Arrays.equals(this.f22461b, zzqVar.f22461b) && Arrays.equals(this.f22462c, zzqVar.f22462c) && Arrays.equals(this.f22463d, zzqVar.f22463d);
    }

    public final int hashCode() {
        return Objects.hashCode(Long.valueOf(this.f22460a), this.f22461b, this.f22462c, this.f22463d);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, this.f22460a);
        SafeParcelWriter.writeByteArray(parcel, 2, this.f22461b, false);
        SafeParcelWriter.writeByteArray(parcel, 3, this.f22462c, false);
        SafeParcelWriter.writeByteArray(parcel, 4, this.f22463d, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
