package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fido.fido2.api.common.COSEAlgorithmIdentifier;
import com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialType;

@SafeParcelable.Class(creator = "PublicKeyCredentialParametersCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public class PublicKeyCredentialParameters extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<PublicKeyCredentialParameters> CREATOR = new zzan();

    /* renamed from: a, reason: collision with root package name */
    public final PublicKeyCredentialType f22417a;

    /* renamed from: b, reason: collision with root package name */
    public final COSEAlgorithmIdentifier f22418b;

    public PublicKeyCredentialParameters(String str, int i2) {
        Preconditions.checkNotNull(str);
        try {
            this.f22417a = PublicKeyCredentialType.a(str);
            Preconditions.checkNotNull(Integer.valueOf(i2));
            try {
                this.f22418b = COSEAlgorithmIdentifier.a(i2);
            } catch (COSEAlgorithmIdentifier.UnsupportedAlgorithmIdentifierException e2) {
                throw new IllegalArgumentException(e2);
            }
        } catch (PublicKeyCredentialType.UnsupportedPublicKeyCredTypeException e3) {
            throw new IllegalArgumentException(e3);
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof PublicKeyCredentialParameters)) {
            return false;
        }
        PublicKeyCredentialParameters publicKeyCredentialParameters = (PublicKeyCredentialParameters) obj;
        return this.f22417a.equals(publicKeyCredentialParameters.f22417a) && this.f22418b.equals(publicKeyCredentialParameters.f22418b);
    }

    public final int hashCode() {
        return Objects.hashCode(this.f22417a, this.f22418b);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        this.f22417a.getClass();
        SafeParcelWriter.writeString(parcel, 2, "public-key", false);
        SafeParcelWriter.writeIntegerObject(parcel, 3, Integer.valueOf(this.f22418b.f22382a.a()), false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
