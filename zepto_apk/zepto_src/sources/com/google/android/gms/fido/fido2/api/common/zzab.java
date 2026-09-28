package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "GoogleSessionIdExtensionCreator")
/* loaded from: classes4.dex */
public final class zzab extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzab> CREATOR = new zzac();

    /* renamed from: a, reason: collision with root package name */
    public final long f22450a;

    public zzab(long j2) {
        this.f22450a = ((Long) Preconditions.checkNotNull(Long.valueOf(j2))).longValue();
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzab) && this.f22450a == ((zzab) obj).f22450a;
    }

    public final int hashCode() {
        return Objects.hashCode(Long.valueOf(this.f22450a));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, this.f22450a);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
