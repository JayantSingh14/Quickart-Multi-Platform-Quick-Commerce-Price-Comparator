package com.google.android.gms.auth.api.identity;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

@SafeParcelable.Class(creator = "BeginSignInRequestCreator")
@Deprecated
/* loaded from: classes4.dex */
public final class BeginSignInRequest extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<BeginSignInRequest> CREATOR = new zbd();

    /* renamed from: a, reason: collision with root package name */
    public final PasswordRequestOptions f22079a;

    /* renamed from: b, reason: collision with root package name */
    public final GoogleIdTokenRequestOptions f22080b;

    /* renamed from: c, reason: collision with root package name */
    public final String f22081c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f22082d;

    /* renamed from: e, reason: collision with root package name */
    public final int f22083e;

    /* renamed from: f, reason: collision with root package name */
    public final PasskeysRequestOptions f22084f;

    /* renamed from: g, reason: collision with root package name */
    public final PasskeyJsonRequestOptions f22085g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f22086h;

    @Deprecated
    public static final class Builder {
        public Builder() {
            Parcelable.Creator<PasswordRequestOptions> creator = PasswordRequestOptions.CREATOR;
            new PasswordRequestOptions.Builder();
            new PasswordRequestOptions(false);
            Parcelable.Creator<GoogleIdTokenRequestOptions> creator2 = GoogleIdTokenRequestOptions.CREATOR;
            new GoogleIdTokenRequestOptions.Builder();
            new GoogleIdTokenRequestOptions(false, null, null, true, null, null, false);
            Parcelable.Creator<PasskeysRequestOptions> creator3 = PasskeysRequestOptions.CREATOR;
            new PasskeysRequestOptions.Builder();
            new PasskeysRequestOptions(null, null, false);
            Parcelable.Creator<PasskeyJsonRequestOptions> creator4 = PasskeyJsonRequestOptions.CREATOR;
            new PasskeyJsonRequestOptions.Builder();
            new PasskeyJsonRequestOptions(null, false);
        }
    }

    @SafeParcelable.Class(creator = "GoogleIdTokenRequestOptionsCreator")
    @Deprecated
    public static final class GoogleIdTokenRequestOptions extends AbstractSafeParcelable {

        @NonNull
        public static final Parcelable.Creator<GoogleIdTokenRequestOptions> CREATOR = new zbj();

        /* renamed from: a, reason: collision with root package name */
        public final boolean f22087a;

        /* renamed from: b, reason: collision with root package name */
        public final String f22088b;

        /* renamed from: c, reason: collision with root package name */
        public final String f22089c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f22090d;

        /* renamed from: e, reason: collision with root package name */
        public final String f22091e;

        /* renamed from: f, reason: collision with root package name */
        public final ArrayList f22092f;

        /* renamed from: g, reason: collision with root package name */
        public final boolean f22093g;

        public static final class Builder {
        }

        public GoogleIdTokenRequestOptions(boolean z, String str, String str2, boolean z2, String str3, ArrayList arrayList, boolean z3) {
            boolean z4 = true;
            if (z2 && z3) {
                z4 = false;
            }
            Preconditions.checkArgument(z4, "filterByAuthorizedAccounts and requestVerifiedPhoneNumber must not both be true; the Verified Phone Number feature only works in sign-ups.");
            this.f22087a = z;
            if (z) {
                Preconditions.checkNotNull(str, "serverClientId must be provided if Google ID tokens are requested");
            }
            this.f22088b = str;
            this.f22089c = str2;
            this.f22090d = z2;
            Parcelable.Creator<BeginSignInRequest> creator = BeginSignInRequest.CREATOR;
            ArrayList arrayList2 = null;
            if (arrayList != null && !arrayList.isEmpty()) {
                arrayList2 = new ArrayList(arrayList);
                Collections.sort(arrayList2);
            }
            this.f22092f = arrayList2;
            this.f22091e = str3;
            this.f22093g = z3;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof GoogleIdTokenRequestOptions)) {
                return false;
            }
            GoogleIdTokenRequestOptions googleIdTokenRequestOptions = (GoogleIdTokenRequestOptions) obj;
            return this.f22087a == googleIdTokenRequestOptions.f22087a && Objects.equal(this.f22088b, googleIdTokenRequestOptions.f22088b) && Objects.equal(this.f22089c, googleIdTokenRequestOptions.f22089c) && this.f22090d == googleIdTokenRequestOptions.f22090d && Objects.equal(this.f22091e, googleIdTokenRequestOptions.f22091e) && Objects.equal(this.f22092f, googleIdTokenRequestOptions.f22092f) && this.f22093g == googleIdTokenRequestOptions.f22093g;
        }

        public final int hashCode() {
            Boolean boolValueOf = Boolean.valueOf(this.f22087a);
            Boolean boolValueOf2 = Boolean.valueOf(this.f22090d);
            Boolean boolValueOf3 = Boolean.valueOf(this.f22093g);
            return Objects.hashCode(boolValueOf, this.f22088b, this.f22089c, boolValueOf2, this.f22091e, this.f22092f, boolValueOf3);
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeBoolean(parcel, 1, this.f22087a);
            SafeParcelWriter.writeString(parcel, 2, this.f22088b, false);
            SafeParcelWriter.writeString(parcel, 3, this.f22089c, false);
            SafeParcelWriter.writeBoolean(parcel, 4, this.f22090d);
            SafeParcelWriter.writeString(parcel, 5, this.f22091e, false);
            SafeParcelWriter.writeStringList(parcel, 6, this.f22092f, false);
            SafeParcelWriter.writeBoolean(parcel, 7, this.f22093g);
            SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
        }
    }

    @SafeParcelable.Class(creator = "PasskeyJsonRequestOptionsCreator")
    @Deprecated
    public static final class PasskeyJsonRequestOptions extends AbstractSafeParcelable {

        @NonNull
        public static final Parcelable.Creator<PasskeyJsonRequestOptions> CREATOR = new zbk();

        /* renamed from: a, reason: collision with root package name */
        public final boolean f22094a;

        /* renamed from: b, reason: collision with root package name */
        public final String f22095b;

        public static final class Builder {
        }

        public PasskeyJsonRequestOptions(String str, boolean z) {
            if (z) {
                Preconditions.checkNotNull(str);
            }
            this.f22094a = z;
            this.f22095b = str;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PasskeyJsonRequestOptions)) {
                return false;
            }
            PasskeyJsonRequestOptions passkeyJsonRequestOptions = (PasskeyJsonRequestOptions) obj;
            return this.f22094a == passkeyJsonRequestOptions.f22094a && Objects.equal(this.f22095b, passkeyJsonRequestOptions.f22095b);
        }

        public final int hashCode() {
            return Objects.hashCode(Boolean.valueOf(this.f22094a), this.f22095b);
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeBoolean(parcel, 1, this.f22094a);
            SafeParcelWriter.writeString(parcel, 2, this.f22095b, false);
            SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
        }
    }

    @SafeParcelable.Class(creator = "PasskeysRequestOptionsCreator")
    @Deprecated
    public static final class PasskeysRequestOptions extends AbstractSafeParcelable {

        @NonNull
        public static final Parcelable.Creator<PasskeysRequestOptions> CREATOR = new zbl();

        /* renamed from: a, reason: collision with root package name */
        public final boolean f22096a;

        /* renamed from: b, reason: collision with root package name */
        public final byte[] f22097b;

        /* renamed from: c, reason: collision with root package name */
        public final String f22098c;

        public static final class Builder {
        }

        public PasskeysRequestOptions(String str, byte[] bArr, boolean z) {
            if (z) {
                Preconditions.checkNotNull(bArr);
                Preconditions.checkNotNull(str);
            }
            this.f22096a = z;
            this.f22097b = bArr;
            this.f22098c = str;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PasskeysRequestOptions)) {
                return false;
            }
            PasskeysRequestOptions passkeysRequestOptions = (PasskeysRequestOptions) obj;
            return this.f22096a == passkeysRequestOptions.f22096a && Arrays.equals(this.f22097b, passkeysRequestOptions.f22097b) && java.util.Objects.equals(this.f22098c, passkeysRequestOptions.f22098c);
        }

        public final int hashCode() {
            return Arrays.hashCode(this.f22097b) + (java.util.Objects.hash(Boolean.valueOf(this.f22096a), this.f22098c) * 31);
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeBoolean(parcel, 1, this.f22096a);
            SafeParcelWriter.writeByteArray(parcel, 2, this.f22097b, false);
            SafeParcelWriter.writeString(parcel, 3, this.f22098c, false);
            SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
        }
    }

    @SafeParcelable.Class(creator = "PasswordRequestOptionsCreator")
    @Deprecated
    public static final class PasswordRequestOptions extends AbstractSafeParcelable {

        @NonNull
        public static final Parcelable.Creator<PasswordRequestOptions> CREATOR = new zbm();

        /* renamed from: a, reason: collision with root package name */
        public final boolean f22099a;

        public static final class Builder {
        }

        public PasswordRequestOptions(boolean z) {
            this.f22099a = z;
        }

        public final boolean equals(Object obj) {
            return (obj instanceof PasswordRequestOptions) && this.f22099a == ((PasswordRequestOptions) obj).f22099a;
        }

        public final int hashCode() {
            return Objects.hashCode(Boolean.valueOf(this.f22099a));
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeBoolean(parcel, 1, this.f22099a);
            SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
        }
    }

    public BeginSignInRequest(PasswordRequestOptions passwordRequestOptions, GoogleIdTokenRequestOptions googleIdTokenRequestOptions, String str, boolean z, int i2, PasskeysRequestOptions passkeysRequestOptions, PasskeyJsonRequestOptions passkeyJsonRequestOptions, boolean z2) {
        this.f22079a = (PasswordRequestOptions) Preconditions.checkNotNull(passwordRequestOptions);
        this.f22080b = (GoogleIdTokenRequestOptions) Preconditions.checkNotNull(googleIdTokenRequestOptions);
        this.f22081c = str;
        this.f22082d = z;
        this.f22083e = i2;
        if (passkeysRequestOptions == null) {
            Parcelable.Creator<PasskeysRequestOptions> creator = PasskeysRequestOptions.CREATOR;
            new PasskeysRequestOptions.Builder();
            passkeysRequestOptions = new PasskeysRequestOptions(null, null, false);
        }
        this.f22084f = passkeysRequestOptions;
        if (passkeyJsonRequestOptions == null) {
            Parcelable.Creator<PasskeyJsonRequestOptions> creator2 = PasskeyJsonRequestOptions.CREATOR;
            new PasskeyJsonRequestOptions.Builder();
            passkeyJsonRequestOptions = new PasskeyJsonRequestOptions(null, false);
        }
        this.f22085g = passkeyJsonRequestOptions;
        this.f22086h = z2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof BeginSignInRequest)) {
            return false;
        }
        BeginSignInRequest beginSignInRequest = (BeginSignInRequest) obj;
        return Objects.equal(this.f22079a, beginSignInRequest.f22079a) && Objects.equal(this.f22080b, beginSignInRequest.f22080b) && Objects.equal(this.f22084f, beginSignInRequest.f22084f) && Objects.equal(this.f22085g, beginSignInRequest.f22085g) && Objects.equal(this.f22081c, beginSignInRequest.f22081c) && this.f22082d == beginSignInRequest.f22082d && this.f22083e == beginSignInRequest.f22083e && this.f22086h == beginSignInRequest.f22086h;
    }

    public final int hashCode() {
        return Objects.hashCode(this.f22079a, this.f22080b, this.f22084f, this.f22085g, this.f22081c, Boolean.valueOf(this.f22082d), Integer.valueOf(this.f22083e), Boolean.valueOf(this.f22086h));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.f22079a, i2, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.f22080b, i2, false);
        SafeParcelWriter.writeString(parcel, 3, this.f22081c, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.f22082d);
        SafeParcelWriter.writeInt(parcel, 5, this.f22083e);
        SafeParcelWriter.writeParcelable(parcel, 6, this.f22084f, i2, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.f22085g, i2, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.f22086h);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
