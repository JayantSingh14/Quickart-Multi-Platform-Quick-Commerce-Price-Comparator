package com.amazon.android.apay.commonlibrary.interfaces.model;

import android.content.Intent;
import android.os.Bundle;
import com.amazon.android.apay.commonlibrary.interfaces.external.MerchantConstants;
import com.amazon.identity.auth.device.authorization.AuthorizationResponseParser;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
/* loaded from: classes3.dex */
public final class AmazonAuthorizationResponse {

    @NotNull
    public static final Companion Companion = new Companion(null);

    /* renamed from: a, reason: collision with root package name */
    @SerializedName(CLConstants.OTP_STATUS)
    @NotNull
    public final String f14933a;

    /* renamed from: b, reason: collision with root package name */
    @SerializedName("authCode")
    @Nullable
    public final String f14934b;

    /* renamed from: c, reason: collision with root package name */
    @SerializedName("lwaClientId")
    @Nullable
    public final String f14935c;

    /* renamed from: d, reason: collision with root package name */
    @SerializedName("redirectUrl")
    @Nullable
    public final String f14936d;

    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final AmazonAuthorizationResponse fromIntent(@Nullable Intent intent) {
            if (intent != null) {
                try {
                    Bundle extras = intent.getExtras();
                    Intrinsics.c(extras);
                    if (extras.containsKey("AUTH_STATUS")) {
                        Bundle extras2 = intent.getExtras();
                        Intrinsics.c(extras2);
                        String string = extras2.getString("AUTH_STATUS");
                        Intrinsics.c(string);
                        Bundle extras3 = intent.getExtras();
                        Intrinsics.c(extras3);
                        String string2 = extras3.getString("authCode");
                        Bundle extras4 = intent.getExtras();
                        Intrinsics.c(extras4);
                        String string3 = extras4.getString("lwaClientId");
                        Bundle extras5 = intent.getExtras();
                        Intrinsics.c(extras5);
                        return new AmazonAuthorizationResponse(string, string2, string3, extras5.getString(AuthorizationResponseParser.REDIRECT_URI_STATE));
                    }
                } catch (Exception unused) {
                    throw new AmazonPayError(MerchantConstants.AUTH_ERROR, "Error while reading authorization result");
                }
            }
            throw new AmazonPayError(MerchantConstants.AUTH_ERROR, "Intent passed is null or intent does not contain status extra");
        }

        public Companion() {
        }
    }

    public AmazonAuthorizationResponse(@NotNull String status, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(status, "status");
        this.f14933a = status;
        this.f14934b = str;
        this.f14935c = str2;
        this.f14936d = str3;
    }

    @Nullable
    public final String getAuthCode() {
        return this.f14934b;
    }

    @Nullable
    public final String getLwaClientId() {
        return this.f14935c;
    }

    @Nullable
    public final String getRedirectUrl() {
        return this.f14936d;
    }

    @NotNull
    public final String getStatus() {
        return this.f14933a;
    }
}
