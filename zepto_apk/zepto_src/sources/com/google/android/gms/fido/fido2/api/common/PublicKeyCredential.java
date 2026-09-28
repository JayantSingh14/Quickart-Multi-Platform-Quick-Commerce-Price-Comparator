package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

@SafeParcelable.Class(creator = "PublicKeyCredentialCreator")
/* loaded from: classes4.dex */
public class PublicKeyCredential extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<PublicKeyCredential> CREATOR = new zzal();

    /* renamed from: a, reason: collision with root package name */
    public final String f22395a;

    /* renamed from: b, reason: collision with root package name */
    public final String f22396b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f22397c;

    /* renamed from: d, reason: collision with root package name */
    public final AuthenticatorAttestationResponse f22398d;

    /* renamed from: e, reason: collision with root package name */
    public final AuthenticatorAssertionResponse f22399e;

    /* renamed from: f, reason: collision with root package name */
    public final AuthenticatorErrorResponse f22400f;

    /* renamed from: g, reason: collision with root package name */
    public final AuthenticationExtensionsClientOutputs f22401g;

    /* renamed from: h, reason: collision with root package name */
    public final String f22402h;

    public static class Builder {
    }

    public PublicKeyCredential(String str, String str2, byte[] bArr, AuthenticatorAttestationResponse authenticatorAttestationResponse, AuthenticatorAssertionResponse authenticatorAssertionResponse, AuthenticatorErrorResponse authenticatorErrorResponse, AuthenticationExtensionsClientOutputs authenticationExtensionsClientOutputs, String str3) {
        boolean z = true;
        if ((authenticatorAttestationResponse == null || authenticatorAssertionResponse != null || authenticatorErrorResponse != null) && ((authenticatorAttestationResponse != null || authenticatorAssertionResponse == null || authenticatorErrorResponse != null) && (authenticatorAttestationResponse != null || authenticatorAssertionResponse != null || authenticatorErrorResponse == null))) {
            z = false;
        }
        Preconditions.checkArgument(z);
        this.f22395a = str;
        this.f22396b = str2;
        this.f22397c = bArr;
        this.f22398d = authenticatorAttestationResponse;
        this.f22399e = authenticatorAssertionResponse;
        this.f22400f = authenticatorErrorResponse;
        this.f22401g = authenticationExtensionsClientOutputs;
        this.f22402h = str3;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof PublicKeyCredential)) {
            return false;
        }
        PublicKeyCredential publicKeyCredential = (PublicKeyCredential) obj;
        return Objects.equal(this.f22395a, publicKeyCredential.f22395a) && Objects.equal(this.f22396b, publicKeyCredential.f22396b) && Arrays.equals(this.f22397c, publicKeyCredential.f22397c) && Objects.equal(this.f22398d, publicKeyCredential.f22398d) && Objects.equal(this.f22399e, publicKeyCredential.f22399e) && Objects.equal(this.f22400f, publicKeyCredential.f22400f) && Objects.equal(this.f22401g, publicKeyCredential.f22401g) && Objects.equal(this.f22402h, publicKeyCredential.f22402h);
    }

    public final int hashCode() {
        return Objects.hashCode(this.f22395a, this.f22396b, this.f22397c, this.f22399e, this.f22398d, this.f22400f, this.f22401g, this.f22402h);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.f22395a, false);
        SafeParcelWriter.writeString(parcel, 2, this.f22396b, false);
        SafeParcelWriter.writeByteArray(parcel, 3, this.f22397c, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.f22398d, i2, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.f22399e, i2, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.f22400f, i2, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.f22401g, i2, false);
        SafeParcelWriter.writeString(parcel, 8, this.f22402h, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
