package com.google.android.gms.fido.u2f.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.fido.zzaj;
import com.google.android.gms.internal.fido.zzak;
import com.google.android.gms.internal.fido.zzbf;
import java.util.Arrays;

@SafeParcelable.Class(creator = "SignResponseDataCreator")
@SafeParcelable.Reserved({1})
@Deprecated
/* loaded from: classes4.dex */
public class SignResponseData extends ResponseData {

    @NonNull
    public static final Parcelable.Creator<SignResponseData> CREATOR = new zzl();

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f22521a;

    /* renamed from: b, reason: collision with root package name */
    public final String f22522b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f22523c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f22524d;

    public SignResponseData(byte[] bArr, String str, byte[] bArr2, byte[] bArr3) {
        this.f22521a = (byte[]) Preconditions.checkNotNull(bArr);
        this.f22522b = (String) Preconditions.checkNotNull(str);
        this.f22523c = (byte[]) Preconditions.checkNotNull(bArr2);
        this.f22524d = (byte[]) Preconditions.checkNotNull(bArr3);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof SignResponseData)) {
            return false;
        }
        SignResponseData signResponseData = (SignResponseData) obj;
        return Arrays.equals(this.f22521a, signResponseData.f22521a) && Objects.equal(this.f22522b, signResponseData.f22522b) && Arrays.equals(this.f22523c, signResponseData.f22523c) && Arrays.equals(this.f22524d, signResponseData.f22524d);
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(Arrays.hashCode(this.f22521a)), this.f22522b, Integer.valueOf(Arrays.hashCode(this.f22523c)), Integer.valueOf(Arrays.hashCode(this.f22524d)));
    }

    public final String toString() {
        zzaj zzajVarA = zzak.a(this);
        zzbf zzbfVar = zzbf.f36609a;
        byte[] bArr = this.f22521a;
        zzajVarA.b(zzbfVar.c(bArr.length, bArr), "keyHandle");
        zzajVarA.b(this.f22522b, "clientDataString");
        byte[] bArr2 = this.f22523c;
        zzajVarA.b(zzbfVar.c(bArr2.length, bArr2), "signatureData");
        byte[] bArr3 = this.f22524d;
        zzajVarA.b(zzbfVar.c(bArr3.length, bArr3), "application");
        return zzajVarA.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByteArray(parcel, 2, this.f22521a, false);
        SafeParcelWriter.writeString(parcel, 3, this.f22522b, false);
        SafeParcelWriter.writeByteArray(parcel, 4, this.f22523c, false);
        SafeParcelWriter.writeByteArray(parcel, 5, this.f22524d, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
