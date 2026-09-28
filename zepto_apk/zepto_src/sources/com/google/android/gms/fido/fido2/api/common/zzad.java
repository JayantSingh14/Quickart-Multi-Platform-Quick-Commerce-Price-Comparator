package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "GoogleSilentVerificationExtensionCreator")
/* loaded from: classes4.dex */
public final class zzad extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzad> CREATOR = new zzae();

    /* renamed from: a, reason: collision with root package name */
    public final boolean f22451a;

    public zzad(boolean z) {
        this.f22451a = ((Boolean) Preconditions.checkNotNull(Boolean.valueOf(z))).booleanValue();
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzad) && this.f22451a == ((zzad) obj).f22451a;
    }

    public final int hashCode() {
        return Objects.hashCode(Boolean.valueOf(this.f22451a));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, this.f22451a);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
