package com.google.android.gms.auth.api.identity;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fido.fido2.api.common.PublicKeyCredential;

@SafeParcelable.Class(creator = "SignInCredentialCreator")
@Deprecated
/* loaded from: classes4.dex */
public final class SignInCredential extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<SignInCredential> CREATOR = new zbr();

    /* renamed from: a, reason: collision with root package name */
    public final String f22119a;

    /* renamed from: b, reason: collision with root package name */
    public final String f22120b;

    /* renamed from: c, reason: collision with root package name */
    public final String f22121c;

    /* renamed from: d, reason: collision with root package name */
    public final String f22122d;

    /* renamed from: e, reason: collision with root package name */
    public final Uri f22123e;

    /* renamed from: f, reason: collision with root package name */
    public final String f22124f;

    /* renamed from: g, reason: collision with root package name */
    public final String f22125g;

    /* renamed from: h, reason: collision with root package name */
    public final String f22126h;

    /* renamed from: i, reason: collision with root package name */
    public final PublicKeyCredential f22127i;

    public SignInCredential(String str, String str2, String str3, String str4, Uri uri, String str5, String str6, String str7, PublicKeyCredential publicKeyCredential) {
        this.f22119a = (String) Preconditions.checkNotNull(str);
        this.f22120b = str2;
        this.f22121c = str3;
        this.f22122d = str4;
        this.f22123e = uri;
        this.f22124f = str5;
        this.f22125g = str6;
        this.f22126h = str7;
        this.f22127i = publicKeyCredential;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof SignInCredential)) {
            return false;
        }
        SignInCredential signInCredential = (SignInCredential) obj;
        return Objects.equal(this.f22119a, signInCredential.f22119a) && Objects.equal(this.f22120b, signInCredential.f22120b) && Objects.equal(this.f22121c, signInCredential.f22121c) && Objects.equal(this.f22122d, signInCredential.f22122d) && Objects.equal(this.f22123e, signInCredential.f22123e) && Objects.equal(this.f22124f, signInCredential.f22124f) && Objects.equal(this.f22125g, signInCredential.f22125g) && Objects.equal(this.f22126h, signInCredential.f22126h) && Objects.equal(this.f22127i, signInCredential.f22127i);
    }

    public final int hashCode() {
        return Objects.hashCode(this.f22119a, this.f22120b, this.f22121c, this.f22122d, this.f22123e, this.f22124f, this.f22125g, this.f22126h, this.f22127i);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.f22119a, false);
        SafeParcelWriter.writeString(parcel, 2, this.f22120b, false);
        SafeParcelWriter.writeString(parcel, 3, this.f22121c, false);
        SafeParcelWriter.writeString(parcel, 4, this.f22122d, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.f22123e, i2, false);
        SafeParcelWriter.writeString(parcel, 6, this.f22124f, false);
        SafeParcelWriter.writeString(parcel, 7, this.f22125g, false);
        SafeParcelWriter.writeString(parcel, 8, this.f22126h, false);
        SafeParcelWriter.writeParcelable(parcel, 9, this.f22127i, i2, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
