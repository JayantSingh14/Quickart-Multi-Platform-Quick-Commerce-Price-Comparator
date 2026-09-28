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

@SafeParcelable.Class(creator = "PublicKeyCredentialUserEntityCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public class PublicKeyCredentialUserEntity extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<PublicKeyCredentialUserEntity> CREATOR = new zzar();

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f22432a;

    /* renamed from: b, reason: collision with root package name */
    public final String f22433b;

    /* renamed from: c, reason: collision with root package name */
    public final String f22434c;

    /* renamed from: d, reason: collision with root package name */
    public final String f22435d;

    public PublicKeyCredentialUserEntity(String str, String str2, String str3, byte[] bArr) {
        this.f22432a = (byte[]) Preconditions.checkNotNull(bArr);
        this.f22433b = (String) Preconditions.checkNotNull(str);
        this.f22434c = str2;
        this.f22435d = (String) Preconditions.checkNotNull(str3);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof PublicKeyCredentialUserEntity)) {
            return false;
        }
        PublicKeyCredentialUserEntity publicKeyCredentialUserEntity = (PublicKeyCredentialUserEntity) obj;
        return Arrays.equals(this.f22432a, publicKeyCredentialUserEntity.f22432a) && Objects.equal(this.f22433b, publicKeyCredentialUserEntity.f22433b) && Objects.equal(this.f22434c, publicKeyCredentialUserEntity.f22434c) && Objects.equal(this.f22435d, publicKeyCredentialUserEntity.f22435d);
    }

    public final int hashCode() {
        return Objects.hashCode(this.f22432a, this.f22433b, this.f22434c, this.f22435d);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByteArray(parcel, 2, this.f22432a, false);
        SafeParcelWriter.writeString(parcel, 3, this.f22433b, false);
        SafeParcelWriter.writeString(parcel, 4, this.f22434c, false);
        SafeParcelWriter.writeString(parcel, 5, this.f22435d, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
