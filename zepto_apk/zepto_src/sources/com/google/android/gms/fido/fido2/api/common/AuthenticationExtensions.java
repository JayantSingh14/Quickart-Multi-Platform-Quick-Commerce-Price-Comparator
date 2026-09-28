package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "AuthenticationExtensionsCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public class AuthenticationExtensions extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<AuthenticationExtensions> CREATOR = new zzd();

    /* renamed from: a, reason: collision with root package name */
    public final FidoAppIdExtension f22345a;

    /* renamed from: b, reason: collision with root package name */
    public final zzs f22346b;

    /* renamed from: c, reason: collision with root package name */
    public final UserVerificationMethodExtension f22347c;

    /* renamed from: d, reason: collision with root package name */
    public final zzz f22348d;

    /* renamed from: e, reason: collision with root package name */
    public final zzab f22349e;

    /* renamed from: f, reason: collision with root package name */
    public final zzad f22350f;

    /* renamed from: g, reason: collision with root package name */
    public final zzu f22351g;

    /* renamed from: h, reason: collision with root package name */
    public final zzag f22352h;

    /* renamed from: i, reason: collision with root package name */
    public final GoogleThirdPartyPaymentExtension f22353i;

    /* renamed from: j, reason: collision with root package name */
    public final zzai f22354j;

    public static final class Builder {
    }

    public AuthenticationExtensions(FidoAppIdExtension fidoAppIdExtension, zzs zzsVar, UserVerificationMethodExtension userVerificationMethodExtension, zzz zzzVar, zzab zzabVar, zzad zzadVar, zzu zzuVar, zzag zzagVar, GoogleThirdPartyPaymentExtension googleThirdPartyPaymentExtension, zzai zzaiVar) {
        this.f22345a = fidoAppIdExtension;
        this.f22347c = userVerificationMethodExtension;
        this.f22346b = zzsVar;
        this.f22348d = zzzVar;
        this.f22349e = zzabVar;
        this.f22350f = zzadVar;
        this.f22351g = zzuVar;
        this.f22352h = zzagVar;
        this.f22353i = googleThirdPartyPaymentExtension;
        this.f22354j = zzaiVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof AuthenticationExtensions)) {
            return false;
        }
        AuthenticationExtensions authenticationExtensions = (AuthenticationExtensions) obj;
        return Objects.equal(this.f22345a, authenticationExtensions.f22345a) && Objects.equal(this.f22346b, authenticationExtensions.f22346b) && Objects.equal(this.f22347c, authenticationExtensions.f22347c) && Objects.equal(this.f22348d, authenticationExtensions.f22348d) && Objects.equal(this.f22349e, authenticationExtensions.f22349e) && Objects.equal(this.f22350f, authenticationExtensions.f22350f) && Objects.equal(this.f22351g, authenticationExtensions.f22351g) && Objects.equal(this.f22352h, authenticationExtensions.f22352h) && Objects.equal(this.f22353i, authenticationExtensions.f22353i) && Objects.equal(this.f22354j, authenticationExtensions.f22354j);
    }

    public final int hashCode() {
        return Objects.hashCode(this.f22345a, this.f22346b, this.f22347c, this.f22348d, this.f22349e, this.f22350f, this.f22351g, this.f22352h, this.f22353i, this.f22354j);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.f22345a, i2, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.f22346b, i2, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.f22347c, i2, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.f22348d, i2, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.f22349e, i2, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.f22350f, i2, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.f22351g, i2, false);
        SafeParcelWriter.writeParcelable(parcel, 9, this.f22352h, i2, false);
        SafeParcelWriter.writeParcelable(parcel, 10, this.f22353i, i2, false);
        SafeParcelWriter.writeParcelable(parcel, 11, this.f22354j, i2, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
