package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.fido.zzbf;
import java.util.Arrays;

@SafeParcelable.Class(creator = "AuthenticatorAttestationResponseCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public class AuthenticatorAttestationResponse extends AuthenticatorResponse {

    @NonNull
    public static final Parcelable.Creator<AuthenticatorAttestationResponse> CREATOR = new zzk();

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f22365a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f22366b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f22367c;

    /* renamed from: d, reason: collision with root package name */
    public final String[] f22368d;

    public AuthenticatorAttestationResponse(byte[] bArr, byte[] bArr2, byte[] bArr3, String[] strArr) {
        this.f22365a = (byte[]) Preconditions.checkNotNull(bArr);
        this.f22366b = (byte[]) Preconditions.checkNotNull(bArr2);
        this.f22367c = (byte[]) Preconditions.checkNotNull(bArr3);
        this.f22368d = (String[]) Preconditions.checkNotNull(strArr);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof AuthenticatorAttestationResponse)) {
            return false;
        }
        AuthenticatorAttestationResponse authenticatorAttestationResponse = (AuthenticatorAttestationResponse) obj;
        return Arrays.equals(this.f22365a, authenticatorAttestationResponse.f22365a) && Arrays.equals(this.f22366b, authenticatorAttestationResponse.f22366b) && Arrays.equals(this.f22367c, authenticatorAttestationResponse.f22367c);
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(Arrays.hashCode(this.f22365a)), Integer.valueOf(Arrays.hashCode(this.f22366b)), Integer.valueOf(Arrays.hashCode(this.f22367c)));
    }

    public final String toString() {
        com.google.android.gms.internal.fido.zzaj zzajVarA = com.google.android.gms.internal.fido.zzak.a(this);
        zzbf zzbfVar = zzbf.f36609a;
        byte[] bArr = this.f22365a;
        zzajVarA.b(zzbfVar.c(bArr.length, bArr), "keyHandle");
        byte[] bArr2 = this.f22366b;
        zzajVarA.b(zzbfVar.c(bArr2.length, bArr2), "clientDataJSON");
        byte[] bArr3 = this.f22367c;
        zzajVarA.b(zzbfVar.c(bArr3.length, bArr3), "attestationObject");
        zzajVarA.b(Arrays.toString(this.f22368d), "transports");
        return zzajVarA.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByteArray(parcel, 2, this.f22365a, false);
        SafeParcelWriter.writeByteArray(parcel, 3, this.f22366b, false);
        SafeParcelWriter.writeByteArray(parcel, 4, this.f22367c, false);
        SafeParcelWriter.writeStringArray(parcel, 5, this.f22368d, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
