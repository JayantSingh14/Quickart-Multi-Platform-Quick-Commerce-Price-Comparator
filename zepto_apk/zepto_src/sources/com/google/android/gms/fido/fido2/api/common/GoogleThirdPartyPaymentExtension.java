package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "GoogleThirdPartyPaymentExtensionCreator")
/* loaded from: classes4.dex */
public class GoogleThirdPartyPaymentExtension extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<GoogleThirdPartyPaymentExtension> CREATOR = new zzaf();

    /* renamed from: a, reason: collision with root package name */
    public final boolean f22394a;

    public GoogleThirdPartyPaymentExtension(boolean z) {
        this.f22394a = z;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof GoogleThirdPartyPaymentExtension) {
            return this.f22394a == ((GoogleThirdPartyPaymentExtension) obj).f22394a;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Boolean.valueOf(this.f22394a));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, this.f22394a);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
