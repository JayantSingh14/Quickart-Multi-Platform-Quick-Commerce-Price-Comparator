package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "AuthenticationExtensionsCredPropsOutputsCreator")
/* loaded from: classes4.dex */
public class AuthenticationExtensionsCredPropsOutputs extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<AuthenticationExtensionsCredPropsOutputs> CREATOR = new zze();

    /* renamed from: a, reason: collision with root package name */
    public final boolean f22359a;

    public AuthenticationExtensionsCredPropsOutputs(boolean z) {
        this.f22359a = z;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof AuthenticationExtensionsCredPropsOutputs) && this.f22359a == ((AuthenticationExtensionsCredPropsOutputs) obj).f22359a;
    }

    public final int hashCode() {
        return Objects.hashCode(Boolean.valueOf(this.f22359a));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, this.f22359a);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
