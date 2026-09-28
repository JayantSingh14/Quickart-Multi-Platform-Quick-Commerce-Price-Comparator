package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;

@SafeParcelable.Class(creator = "PublicKeyCredentialRequestOptionsCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public class PublicKeyCredentialRequestOptions extends RequestOptions {

    @NonNull
    public static final Parcelable.Creator<PublicKeyCredentialRequestOptions> CREATOR = new zzao();

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f22419a;

    /* renamed from: b, reason: collision with root package name */
    public final Double f22420b;

    /* renamed from: c, reason: collision with root package name */
    public final String f22421c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f22422d;

    /* renamed from: e, reason: collision with root package name */
    public final Integer f22423e;

    /* renamed from: f, reason: collision with root package name */
    public final TokenBinding f22424f;

    /* renamed from: g, reason: collision with root package name */
    public final zzay f22425g;

    /* renamed from: h, reason: collision with root package name */
    public final AuthenticationExtensions f22426h;

    /* renamed from: i, reason: collision with root package name */
    public final Long f22427i;

    public static final class Builder {
    }

    public PublicKeyCredentialRequestOptions(byte[] bArr, Double d2, String str, ArrayList arrayList, Integer num, TokenBinding tokenBinding, String str2, AuthenticationExtensions authenticationExtensions, Long l2) {
        this.f22419a = (byte[]) Preconditions.checkNotNull(bArr);
        this.f22420b = d2;
        this.f22421c = (String) Preconditions.checkNotNull(str);
        this.f22422d = arrayList;
        this.f22423e = num;
        this.f22424f = tokenBinding;
        this.f22427i = l2;
        if (str2 != null) {
            try {
                this.f22425g = zzay.a(str2);
            } catch (zzax e2) {
                throw new IllegalArgumentException(e2);
            }
        } else {
            this.f22425g = null;
        }
        this.f22426h = authenticationExtensions;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof PublicKeyCredentialRequestOptions)) {
            return false;
        }
        PublicKeyCredentialRequestOptions publicKeyCredentialRequestOptions = (PublicKeyCredentialRequestOptions) obj;
        if (!Arrays.equals(this.f22419a, publicKeyCredentialRequestOptions.f22419a) || !Objects.equal(this.f22420b, publicKeyCredentialRequestOptions.f22420b) || !Objects.equal(this.f22421c, publicKeyCredentialRequestOptions.f22421c)) {
            return false;
        }
        ArrayList arrayList = this.f22422d;
        ArrayList arrayList2 = publicKeyCredentialRequestOptions.f22422d;
        return ((arrayList == null && arrayList2 == null) || (arrayList != null && arrayList2 != null && arrayList.containsAll(arrayList2) && arrayList2.containsAll(arrayList))) && Objects.equal(this.f22423e, publicKeyCredentialRequestOptions.f22423e) && Objects.equal(this.f22424f, publicKeyCredentialRequestOptions.f22424f) && Objects.equal(this.f22425g, publicKeyCredentialRequestOptions.f22425g) && Objects.equal(this.f22426h, publicKeyCredentialRequestOptions.f22426h) && Objects.equal(this.f22427i, publicKeyCredentialRequestOptions.f22427i);
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(Arrays.hashCode(this.f22419a)), this.f22420b, this.f22421c, this.f22422d, this.f22423e, this.f22424f, this.f22425g, this.f22426h, this.f22427i);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByteArray(parcel, 2, this.f22419a, false);
        SafeParcelWriter.writeDoubleObject(parcel, 3, this.f22420b, false);
        SafeParcelWriter.writeString(parcel, 4, this.f22421c, false);
        SafeParcelWriter.writeTypedList(parcel, 5, this.f22422d, false);
        SafeParcelWriter.writeIntegerObject(parcel, 6, this.f22423e, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.f22424f, i2, false);
        zzay zzayVar = this.f22425g;
        SafeParcelWriter.writeString(parcel, 8, zzayVar == null ? null : zzayVar.f22455a, false);
        SafeParcelWriter.writeParcelable(parcel, 9, this.f22426h, i2, false);
        SafeParcelWriter.writeLongObject(parcel, 10, this.f22427i, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
