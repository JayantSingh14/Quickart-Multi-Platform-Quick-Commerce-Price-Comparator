package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "PublicKeyCredentialRpEntityCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public class PublicKeyCredentialRpEntity extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<PublicKeyCredentialRpEntity> CREATOR = new zzap();

    /* renamed from: a, reason: collision with root package name */
    public final String f22428a;

    /* renamed from: b, reason: collision with root package name */
    public final String f22429b;

    /* renamed from: c, reason: collision with root package name */
    public final String f22430c;

    public PublicKeyCredentialRpEntity(String str, String str2, String str3) {
        this.f22428a = (String) Preconditions.checkNotNull(str);
        this.f22429b = (String) Preconditions.checkNotNull(str2);
        this.f22430c = str3;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof PublicKeyCredentialRpEntity)) {
            return false;
        }
        PublicKeyCredentialRpEntity publicKeyCredentialRpEntity = (PublicKeyCredentialRpEntity) obj;
        return Objects.equal(this.f22428a, publicKeyCredentialRpEntity.f22428a) && Objects.equal(this.f22429b, publicKeyCredentialRpEntity.f22429b) && Objects.equal(this.f22430c, publicKeyCredentialRpEntity.f22430c);
    }

    public final int hashCode() {
        return Objects.hashCode(this.f22428a, this.f22429b, this.f22430c);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.f22428a, false);
        SafeParcelWriter.writeString(parcel, 3, this.f22429b, false);
        SafeParcelWriter.writeString(parcel, 4, this.f22430c, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
