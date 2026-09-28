package com.truecaller.android.sdk.common.models;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.google.gson.annotations.SerializedName;

@RestrictTo
/* loaded from: classes4.dex */
public class VerifyInstallationModel {

    @SerializedName("countryCodeName")
    private final String mCountryCodeName;

    @SerializedName("phoneNumber")
    private final String mPhoneNumber;

    @SerializedName("secretToken")
    @VisibleForTesting
    public final String mSecretToken;

    @SerializedName("verificationToken")
    private final String mVerificationToken;

    public VerifyInstallationModel(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4) {
        this.mVerificationToken = str;
        this.mPhoneNumber = str2;
        this.mCountryCodeName = str3;
        this.mSecretToken = str4;
    }
}
