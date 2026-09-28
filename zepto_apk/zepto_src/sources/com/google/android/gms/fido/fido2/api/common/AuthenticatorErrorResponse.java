package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fido.fido2.api.common.ErrorCode;

@SafeParcelable.Class(creator = "AuthenticatorErrorResponseCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public class AuthenticatorErrorResponse extends AuthenticatorResponse {

    @NonNull
    public static final Parcelable.Creator<AuthenticatorErrorResponse> CREATOR = new zzl();

    /* renamed from: a, reason: collision with root package name */
    public final ErrorCode f22369a;

    /* renamed from: b, reason: collision with root package name */
    public final String f22370b;

    /* renamed from: c, reason: collision with root package name */
    public final int f22371c;

    public AuthenticatorErrorResponse(int i2, String str, int i3) {
        try {
            this.f22369a = ErrorCode.a(i2);
            this.f22370b = str;
            this.f22371c = i3;
        } catch (ErrorCode.UnsupportedErrorCodeException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof AuthenticatorErrorResponse)) {
            return false;
        }
        AuthenticatorErrorResponse authenticatorErrorResponse = (AuthenticatorErrorResponse) obj;
        return Objects.equal(this.f22369a, authenticatorErrorResponse.f22369a) && Objects.equal(this.f22370b, authenticatorErrorResponse.f22370b) && Objects.equal(Integer.valueOf(this.f22371c), Integer.valueOf(authenticatorErrorResponse.f22371c));
    }

    public final int hashCode() {
        return Objects.hashCode(this.f22369a, this.f22370b, Integer.valueOf(this.f22371c));
    }

    public final String toString() {
        com.google.android.gms.internal.fido.zzaj zzajVarA = com.google.android.gms.internal.fido.zzak.a(this);
        zzajVarA.a(this.f22369a.f22386a);
        String str = this.f22370b;
        if (str != null) {
            zzajVarA.b(str, "errorMessage");
        }
        return zzajVarA.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.f22369a.f22386a);
        SafeParcelWriter.writeString(parcel, 3, this.f22370b, false);
        SafeParcelWriter.writeInt(parcel, 4, this.f22371c);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
