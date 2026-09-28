package com.truecaller.android.sdk;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Locale;
import java.util.UUID;

@Keep
/* loaded from: classes4.dex */
public class PartnerInformation implements Parcelable {
    private static final String APP_FINGERPRINT = "PARTNERINFO_APP_FINGERPRINT";
    public static final Parcelable.Creator<PartnerInformation> CREATOR = new AnonymousClass1();
    public static final String PACKAGE_NAME = "PARTNERINFO_PACKAGE_NAME";
    public static final String PARTNER_INFO_EXTRA = "PARTNER_INFO_EXTRA";
    private static final String PARTNER_KEY = "PARTNERINFO_PARTNER_KEY";
    private static final String REQ_NONCE = "PARTNERINFO_REQ_NONCE";
    private static final String SDK_LOCALE = "PARTNERINFO_LOCALE";
    private static final String SDK_THEME = "PARTNERINFO_THEME";
    private static final String SDK_VARIANT = "PARTNERINFO_SDK_VARIANT";
    private static final String SDK_VARIANT_VERSION = "PARTNERINFO_SDK_VARIANT_VERSION";
    public static final String TRUESDK_VERSION = "PARTNERINFO_TRUESDK_VERSION";

    @NonNull
    public final String appFingerprint;

    @Nullable
    public final Locale locale;

    @NonNull
    public final String packageName;

    @NonNull
    public final String partnerKey;

    @NonNull
    public final String reqNonce;

    @Nullable
    public String sdkVariant;

    @Nullable
    public String sdkVariantVersion;
    public final int theme;

    @NonNull
    public final String truesdkVersion;

    /* renamed from: com.truecaller.android.sdk.PartnerInformation$1, reason: invalid class name */
    public class AnonymousClass1 implements Parcelable.Creator<PartnerInformation> {
        @Override // android.os.Parcelable.Creator
        public final PartnerInformation createFromParcel(Parcel parcel) {
            return new PartnerInformation(0, parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final PartnerInformation[] newArray(int i2) {
            return new PartnerInformation[i2];
        }
    }

    public /* synthetic */ PartnerInformation(int i2, Parcel parcel) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void writeToBundle(@NonNull Bundle bundle) {
        bundle.putString(TRUESDK_VERSION, this.truesdkVersion);
        bundle.putString(PARTNER_KEY, this.partnerKey);
        bundle.putString(PACKAGE_NAME, this.packageName);
        bundle.putString(APP_FINGERPRINT, this.appFingerprint);
        bundle.putString(REQ_NONCE, this.reqNonce);
        Locale locale = this.locale;
        if (locale != null) {
            bundle.putString(SDK_LOCALE, locale.toString());
        }
        bundle.putInt(SDK_THEME, this.theme);
        bundle.putString(SDK_VARIANT, this.sdkVariant);
        bundle.putString(SDK_VARIANT_VERSION, this.sdkVariantVersion);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.partnerKey);
        parcel.writeString(this.packageName);
        parcel.writeString(this.appFingerprint);
    }

    public PartnerInformation(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4, @NonNull String str5, @Nullable Locale locale, int i2, @Nullable String str6, @Nullable String str7) {
        this.truesdkVersion = str;
        this.partnerKey = str2;
        this.packageName = str3;
        this.appFingerprint = str4;
        this.reqNonce = str5;
        this.locale = locale;
        this.theme = i2;
        this.sdkVariant = str6;
        this.sdkVariantVersion = str7;
    }

    public PartnerInformation(@NonNull Bundle bundle) {
        this.truesdkVersion = bundle.getString(TRUESDK_VERSION, "");
        this.partnerKey = bundle.getString(PARTNER_KEY, "");
        this.packageName = bundle.getString(PACKAGE_NAME, "");
        this.appFingerprint = bundle.getString(APP_FINGERPRINT, "");
        this.reqNonce = bundle.getString(REQ_NONCE, "");
        this.locale = new Locale(bundle.getString(SDK_LOCALE, ""));
        this.theme = bundle.getInt(SDK_THEME, 0);
        this.sdkVariant = bundle.getString(SDK_VARIANT, "");
        this.sdkVariantVersion = bundle.getString(SDK_VARIANT_VERSION, "");
    }

    private PartnerInformation(Parcel parcel) {
        this.partnerKey = parcel.readString();
        this.packageName = parcel.readString();
        this.appFingerprint = parcel.readString();
        this.truesdkVersion = "0.4.2";
        this.reqNonce = UUID.randomUUID().toString();
        this.locale = Locale.ENGLISH;
        this.theme = 0;
    }
}
