package com.truecaller.android.sdk.common.models;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.google.gson.annotations.SerializedName;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@RestrictTo
/* loaded from: classes4.dex */
public class CreateInstallationModel {
    private static final int CLIENT_ID = 15;
    private static final String CLIENT_OS = "android";

    @SerializedName("airplaneModeDisabled")
    private boolean airplaneModeDisabled;

    @SerializedName("countryCodeName")
    @VisibleForTesting
    public final String countryCodeName;

    @SerializedName(CLConstants.SALT_FIELD_DEVICE_ID)
    @VisibleForTesting
    public final String deviceId;

    @SerializedName("hasTruecaller")
    @VisibleForTesting
    public final boolean hasTruecaller;

    @SerializedName("phoneNumber")
    @VisibleForTesting
    public final String phoneNumber;

    @SerializedName("phonePermission")
    private boolean phonePermission;

    @SerializedName("requestNonce")
    public final String requestNonce;

    @SerializedName("simState")
    private int simState;

    @SerializedName("clientId")
    private final int clientId = 15;

    @SerializedName("osId")
    private final int osId = 15;

    @SerializedName("os")
    private final String os = "android";

    @SerializedName("version")
    private final String version = Build.VERSION.RELEASE;

    public CreateInstallationModel(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4, boolean z) {
        this.phoneNumber = str3;
        this.countryCodeName = str2;
        this.deviceId = str4;
        this.hasTruecaller = z;
        this.requestNonce = str;
    }

    public void setAirplaneModeDisabled(boolean z) {
        this.airplaneModeDisabled = z;
    }

    public void setPhonePermission(boolean z) {
        this.phonePermission = z;
    }

    public void setSimState(int i2) {
        this.simState = i2;
    }
}
