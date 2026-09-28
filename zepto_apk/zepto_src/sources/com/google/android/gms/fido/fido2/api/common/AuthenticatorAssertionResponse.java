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

@SafeParcelable.Class(creator = "AuthenticatorAssertionResponseCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public class AuthenticatorAssertionResponse extends AuthenticatorResponse {

    @NonNull
    public static final Parcelable.Creator<AuthenticatorAssertionResponse> CREATOR = new zzj();

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f22360a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f22361b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f22362c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f22363d;

    /* renamed from: e, reason: collision with root package name */
    public final byte[] f22364e;

    public AuthenticatorAssertionResponse(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        this.f22360a = (byte[]) Preconditions.checkNotNull(bArr);
        this.f22361b = (byte[]) Preconditions.checkNotNull(bArr2);
        this.f22362c = (byte[]) Preconditions.checkNotNull(bArr3);
        this.f22363d = (byte[]) Preconditions.checkNotNull(bArr4);
        this.f22364e = bArr5;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof AuthenticatorAssertionResponse)) {
            return false;
        }
        AuthenticatorAssertionResponse authenticatorAssertionResponse = (AuthenticatorAssertionResponse) obj;
        return Arrays.equals(this.f22360a, authenticatorAssertionResponse.f22360a) && Arrays.equals(this.f22361b, authenticatorAssertionResponse.f22361b) && Arrays.equals(this.f22362c, authenticatorAssertionResponse.f22362c) && Arrays.equals(this.f22363d, authenticatorAssertionResponse.f22363d) && Arrays.equals(this.f22364e, authenticatorAssertionResponse.f22364e);
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(Arrays.hashCode(this.f22360a)), Integer.valueOf(Arrays.hashCode(this.f22361b)), Integer.valueOf(Arrays.hashCode(this.f22362c)), Integer.valueOf(Arrays.hashCode(this.f22363d)), Integer.valueOf(Arrays.hashCode(this.f22364e)));
    }

    public final String toString() {
        com.google.android.gms.internal.fido.zzaj zzajVarA = com.google.android.gms.internal.fido.zzak.a(this);
        zzbf zzbfVar = zzbf.f36609a;
        byte[] bArr = this.f22360a;
        zzajVarA.b(zzbfVar.c(bArr.length, bArr), "keyHandle");
        byte[] bArr2 = this.f22361b;
        zzajVarA.b(zzbfVar.c(bArr2.length, bArr2), "clientDataJSON");
        byte[] bArr3 = this.f22362c;
        zzajVarA.b(zzbfVar.c(bArr3.length, bArr3), "authenticatorData");
        byte[] bArr4 = this.f22363d;
        zzajVarA.b(zzbfVar.c(bArr4.length, bArr4), "signature");
        byte[] bArr5 = this.f22364e;
        if (bArr5 != null) {
            zzajVarA.b(zzbfVar.c(bArr5.length, bArr5), "userHandle");
        }
        return zzajVarA.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByteArray(parcel, 2, this.f22360a, false);
        SafeParcelWriter.writeByteArray(parcel, 3, this.f22361b, false);
        SafeParcelWriter.writeByteArray(parcel, 4, this.f22362c, false);
        SafeParcelWriter.writeByteArray(parcel, 5, this.f22363d, false);
        SafeParcelWriter.writeByteArray(parcel, 6, this.f22364e, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
