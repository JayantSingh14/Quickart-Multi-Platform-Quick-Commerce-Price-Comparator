package com.truecaller.android.sdk.oAuth.clients;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Locale;

@Keep
/* loaded from: classes4.dex */
public class PartnerInformationV2 implements Parcelable {
    public static final Parcelable.Creator<PartnerInformationV2> CREATOR = new AnonymousClass1();
    private static final String MIN_SDK_VERSION_FOR_ENABLING_VERSIONING = "3.2.0";
    private static final int VERSION = 0;

    @NonNull
    private final String appFingerprint;

    @NonNull
    private final String clientId;

    @NonNull
    private final String codeChallenge;

    @Nullable
    private final Locale locale;

    @NonNull
    private final String packageName;
    private final String[] scopes;

    @Nullable
    private final String sdkVariant;

    @Nullable
    private final String sdkVariantVersion;
    private final String state;
    private final int theme;

    @NonNull
    private final String trueSdkVersion;

    /* renamed from: com.truecaller.android.sdk.oAuth.clients.PartnerInformationV2$1, reason: invalid class name */
    public class AnonymousClass1 implements Parcelable.Creator<PartnerInformationV2> {
        @Override // android.os.Parcelable.Creator
        public final PartnerInformationV2 createFromParcel(Parcel parcel) {
            return new PartnerInformationV2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final PartnerInformationV2[] newArray(int i2) {
            return new PartnerInformationV2[i2];
        }
    }

    public PartnerInformationV2(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4, @Nullable Locale locale, @Nullable String str5, @Nullable String str6, @NonNull String str7, String[] strArr, String str8, int i2) {
        this.clientId = str2;
        this.packageName = str3;
        this.appFingerprint = str4;
        this.trueSdkVersion = str;
        this.codeChallenge = str7;
        this.locale = locale;
        this.sdkVariant = str5;
        this.sdkVariantVersion = str6;
        this.scopes = strArr;
        this.state = str8;
        this.theme = i2;
    }

    private boolean isEqualOrGreater(String str) {
        return str.compareTo(MIN_SDK_VERSION_FOR_ENABLING_VERSIONING) >= 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NonNull
    public String getAppFingerprint() {
        return this.appFingerprint;
    }

    @NonNull
    public String getClientId() {
        return this.clientId;
    }

    @NonNull
    public String getCodeChallenge() {
        return this.codeChallenge;
    }

    @Nullable
    public Locale getLocale() {
        return this.locale;
    }

    @NonNull
    public String getPackageName() {
        return this.packageName;
    }

    public String[] getScopes() {
        return this.scopes;
    }

    @Nullable
    public String getSdkVariant() {
        return this.sdkVariant;
    }

    @Nullable
    public String getSdkVariantVersion() {
        return this.sdkVariantVersion;
    }

    public String getState() {
        return this.state;
    }

    public int getTheme() {
        return this.theme;
    }

    @NonNull
    public String getTrueSdkVersion() {
        return this.trueSdkVersion;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.clientId);
        parcel.writeString(this.packageName);
        parcel.writeString(this.appFingerprint);
        parcel.writeString(this.trueSdkVersion);
        parcel.writeString(this.codeChallenge);
        parcel.writeSerializable(this.locale);
        parcel.writeString(this.sdkVariant);
        parcel.writeString(this.sdkVariantVersion);
        parcel.writeStringArray(this.scopes);
        parcel.writeString(this.state);
        if (isEqualOrGreater(this.trueSdkVersion)) {
            parcel.writeInt(0);
            parcel.writeInt(this.theme);
        }
    }

    public PartnerInformationV2(Parcel parcel) {
        this.clientId = parcel.readString();
        this.packageName = parcel.readString();
        this.appFingerprint = parcel.readString();
        String string = parcel.readString();
        this.trueSdkVersion = string;
        this.codeChallenge = parcel.readString();
        this.locale = (Locale) parcel.readSerializable();
        this.sdkVariant = parcel.readString();
        this.sdkVariantVersion = parcel.readString();
        this.scopes = parcel.createStringArray();
        this.state = parcel.readString();
        if (string != null && isEqualOrGreater(string)) {
            if (parcel.readInt() >= 0) {
                this.theme = parcel.readInt();
                return;
            } else {
                this.theme = 0;
                return;
            }
        }
        this.theme = 0;
    }
}
