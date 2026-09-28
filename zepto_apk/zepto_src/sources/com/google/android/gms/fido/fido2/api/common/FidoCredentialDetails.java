package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

@SafeParcelable.Class(creator = "FidoCredentialDetailsCreator")
/* loaded from: classes4.dex */
public class FidoCredentialDetails extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<FidoCredentialDetails> CREATOR = new zzy();

    /* renamed from: a, reason: collision with root package name */
    public final String f22388a;

    /* renamed from: b, reason: collision with root package name */
    public final String f22389b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f22390c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f22391d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f22392e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f22393f;

    public FidoCredentialDetails(String str, String str2, byte[] bArr, byte[] bArr2, boolean z, boolean z2) {
        this.f22388a = str;
        this.f22389b = str2;
        this.f22390c = bArr;
        this.f22391d = bArr2;
        this.f22392e = z;
        this.f22393f = z2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof FidoCredentialDetails)) {
            return false;
        }
        FidoCredentialDetails fidoCredentialDetails = (FidoCredentialDetails) obj;
        return Objects.equal(this.f22388a, fidoCredentialDetails.f22388a) && Objects.equal(this.f22389b, fidoCredentialDetails.f22389b) && Arrays.equals(this.f22390c, fidoCredentialDetails.f22390c) && Arrays.equals(this.f22391d, fidoCredentialDetails.f22391d) && this.f22392e == fidoCredentialDetails.f22392e && this.f22393f == fidoCredentialDetails.f22393f;
    }

    public final int hashCode() {
        return Objects.hashCode(this.f22388a, this.f22389b, this.f22390c, this.f22391d, Boolean.valueOf(this.f22392e), Boolean.valueOf(this.f22393f));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.f22388a, false);
        SafeParcelWriter.writeString(parcel, 2, this.f22389b, false);
        SafeParcelWriter.writeByteArray(parcel, 3, this.f22390c, false);
        SafeParcelWriter.writeByteArray(parcel, 4, this.f22391d, false);
        SafeParcelWriter.writeBoolean(parcel, 5, this.f22392e);
        SafeParcelWriter.writeBoolean(parcel, 6, this.f22393f);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
