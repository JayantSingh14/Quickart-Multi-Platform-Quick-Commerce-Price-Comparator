package com.google.android.gms.fido.u2f.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fido.u2f.api.common.ProtocolVersion;
import com.google.android.gms.internal.fido.zzaj;
import com.google.android.gms.internal.fido.zzak;
import com.google.android.gms.internal.fido.zzbf;
import java.util.Arrays;

@SafeParcelable.Class(creator = "RegisterResponseDataCreator")
@SafeParcelable.Reserved({1})
@Deprecated
/* loaded from: classes4.dex */
public class RegisterResponseData extends ResponseData {

    @NonNull
    public static final Parcelable.Creator<RegisterResponseData> CREATOR = new zzi();

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f22508a;

    /* renamed from: b, reason: collision with root package name */
    public final ProtocolVersion f22509b;

    /* renamed from: c, reason: collision with root package name */
    public final String f22510c;

    public RegisterResponseData(String str, String str2, byte[] bArr) {
        this.f22508a = bArr;
        try {
            this.f22509b = ProtocolVersion.a(str);
            this.f22510c = str2;
        } catch (ProtocolVersion.UnsupportedProtocolException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof RegisterResponseData)) {
            return false;
        }
        RegisterResponseData registerResponseData = (RegisterResponseData) obj;
        return Objects.equal(this.f22509b, registerResponseData.f22509b) && Arrays.equals(this.f22508a, registerResponseData.f22508a) && Objects.equal(this.f22510c, registerResponseData.f22510c);
    }

    public final int hashCode() {
        return Objects.hashCode(this.f22509b, Integer.valueOf(Arrays.hashCode(this.f22508a)), this.f22510c);
    }

    public final String toString() {
        zzaj zzajVarA = zzak.a(this);
        zzajVarA.b(this.f22509b, "protocolVersion");
        zzbf zzbfVar = zzbf.f36609a;
        byte[] bArr = this.f22508a;
        zzajVarA.b(zzbfVar.c(bArr.length, bArr), "registerData");
        String str = this.f22510c;
        if (str != null) {
            zzajVarA.b(str, "clientDataString");
        }
        return zzajVarA.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByteArray(parcel, 2, this.f22508a, false);
        SafeParcelWriter.writeString(parcel, 3, this.f22509b.f22496a, false);
        SafeParcelWriter.writeString(parcel, 4, this.f22510c, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
