package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fido.fido2.api.common.AttestationConveyancePreference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SafeParcelable.Class(creator = "PublicKeyCredentialCreationOptionsCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public class PublicKeyCredentialCreationOptions extends RequestOptions {

    @NonNull
    public static final Parcelable.Creator<PublicKeyCredentialCreationOptions> CREATOR = new zzak();

    /* renamed from: a, reason: collision with root package name */
    public final PublicKeyCredentialRpEntity f22403a;

    /* renamed from: b, reason: collision with root package name */
    public final PublicKeyCredentialUserEntity f22404b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f22405c;

    /* renamed from: d, reason: collision with root package name */
    public final List f22406d;

    /* renamed from: e, reason: collision with root package name */
    public final Double f22407e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f22408f;

    /* renamed from: g, reason: collision with root package name */
    public final AuthenticatorSelectionCriteria f22409g;

    /* renamed from: h, reason: collision with root package name */
    public final Integer f22410h;

    /* renamed from: i, reason: collision with root package name */
    public final TokenBinding f22411i;

    /* renamed from: j, reason: collision with root package name */
    public final AttestationConveyancePreference f22412j;

    /* renamed from: k, reason: collision with root package name */
    public final AuthenticationExtensions f22413k;

    public static final class Builder {
    }

    public PublicKeyCredentialCreationOptions(PublicKeyCredentialRpEntity publicKeyCredentialRpEntity, PublicKeyCredentialUserEntity publicKeyCredentialUserEntity, byte[] bArr, ArrayList arrayList, Double d2, ArrayList arrayList2, AuthenticatorSelectionCriteria authenticatorSelectionCriteria, Integer num, TokenBinding tokenBinding, String str, AuthenticationExtensions authenticationExtensions) {
        this.f22403a = (PublicKeyCredentialRpEntity) Preconditions.checkNotNull(publicKeyCredentialRpEntity);
        this.f22404b = (PublicKeyCredentialUserEntity) Preconditions.checkNotNull(publicKeyCredentialUserEntity);
        this.f22405c = (byte[]) Preconditions.checkNotNull(bArr);
        this.f22406d = (List) Preconditions.checkNotNull(arrayList);
        this.f22407e = d2;
        this.f22408f = arrayList2;
        this.f22409g = authenticatorSelectionCriteria;
        this.f22410h = num;
        this.f22411i = tokenBinding;
        if (str != null) {
            try {
                this.f22412j = AttestationConveyancePreference.a(str);
            } catch (AttestationConveyancePreference.UnsupportedAttestationConveyancePreferenceException e2) {
                throw new IllegalArgumentException(e2);
            }
        } else {
            this.f22412j = null;
        }
        this.f22413k = authenticationExtensions;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof PublicKeyCredentialCreationOptions)) {
            return false;
        }
        PublicKeyCredentialCreationOptions publicKeyCredentialCreationOptions = (PublicKeyCredentialCreationOptions) obj;
        if (!Objects.equal(this.f22403a, publicKeyCredentialCreationOptions.f22403a) || !Objects.equal(this.f22404b, publicKeyCredentialCreationOptions.f22404b) || !Arrays.equals(this.f22405c, publicKeyCredentialCreationOptions.f22405c) || !Objects.equal(this.f22407e, publicKeyCredentialCreationOptions.f22407e)) {
            return false;
        }
        List list = this.f22406d;
        List list2 = publicKeyCredentialCreationOptions.f22406d;
        if (!list.containsAll(list2) || !list2.containsAll(list)) {
            return false;
        }
        ArrayList arrayList = this.f22408f;
        ArrayList arrayList2 = publicKeyCredentialCreationOptions.f22408f;
        return ((arrayList == null && arrayList2 == null) || (arrayList != null && arrayList2 != null && arrayList.containsAll(arrayList2) && arrayList2.containsAll(arrayList))) && Objects.equal(this.f22409g, publicKeyCredentialCreationOptions.f22409g) && Objects.equal(this.f22410h, publicKeyCredentialCreationOptions.f22410h) && Objects.equal(this.f22411i, publicKeyCredentialCreationOptions.f22411i) && Objects.equal(this.f22412j, publicKeyCredentialCreationOptions.f22412j) && Objects.equal(this.f22413k, publicKeyCredentialCreationOptions.f22413k);
    }

    public final int hashCode() {
        return Objects.hashCode(this.f22403a, this.f22404b, Integer.valueOf(Arrays.hashCode(this.f22405c)), this.f22406d, this.f22407e, this.f22408f, this.f22409g, this.f22410h, this.f22411i, this.f22412j, this.f22413k);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.f22403a, i2, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.f22404b, i2, false);
        SafeParcelWriter.writeByteArray(parcel, 4, this.f22405c, false);
        SafeParcelWriter.writeTypedList(parcel, 5, this.f22406d, false);
        SafeParcelWriter.writeDoubleObject(parcel, 6, this.f22407e, false);
        SafeParcelWriter.writeTypedList(parcel, 7, this.f22408f, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.f22409g, i2, false);
        SafeParcelWriter.writeIntegerObject(parcel, 9, this.f22410h, false);
        SafeParcelWriter.writeParcelable(parcel, 10, this.f22411i, i2, false);
        AttestationConveyancePreference attestationConveyancePreference = this.f22412j;
        SafeParcelWriter.writeString(parcel, 11, attestationConveyancePreference == null ? null : attestationConveyancePreference.f22344a, false);
        SafeParcelWriter.writeParcelable(parcel, 12, this.f22413k, i2, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
