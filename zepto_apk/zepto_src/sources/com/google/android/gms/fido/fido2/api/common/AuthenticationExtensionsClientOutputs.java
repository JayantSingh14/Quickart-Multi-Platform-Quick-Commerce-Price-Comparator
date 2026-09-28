package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "AuthenticationExtensionsClientOutputsCreator")
/* loaded from: classes4.dex */
public class AuthenticationExtensionsClientOutputs extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<AuthenticationExtensionsClientOutputs> CREATOR = new zzc();

    /* renamed from: a, reason: collision with root package name */
    public final UvmEntries f22355a;

    /* renamed from: b, reason: collision with root package name */
    public final zzf f22356b;

    /* renamed from: c, reason: collision with root package name */
    public final AuthenticationExtensionsCredPropsOutputs f22357c;

    /* renamed from: d, reason: collision with root package name */
    public final zzh f22358d;

    public static final class Builder {
    }

    public AuthenticationExtensionsClientOutputs(UvmEntries uvmEntries, zzf zzfVar, AuthenticationExtensionsCredPropsOutputs authenticationExtensionsCredPropsOutputs, zzh zzhVar) {
        this.f22355a = uvmEntries;
        this.f22356b = zzfVar;
        this.f22357c = authenticationExtensionsCredPropsOutputs;
        this.f22358d = zzhVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof AuthenticationExtensionsClientOutputs)) {
            return false;
        }
        AuthenticationExtensionsClientOutputs authenticationExtensionsClientOutputs = (AuthenticationExtensionsClientOutputs) obj;
        return Objects.equal(this.f22355a, authenticationExtensionsClientOutputs.f22355a) && Objects.equal(this.f22356b, authenticationExtensionsClientOutputs.f22356b) && Objects.equal(this.f22357c, authenticationExtensionsClientOutputs.f22357c) && Objects.equal(this.f22358d, authenticationExtensionsClientOutputs.f22358d);
    }

    public final int hashCode() {
        return Objects.hashCode(this.f22355a, this.f22356b, this.f22357c, this.f22358d);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.f22355a, i2, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.f22356b, i2, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.f22357c, i2, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.f22358d, i2, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
