package com.truecaller.android.sdk.legacy;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.ColorInt;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.truecaller.android.sdk.common.TrueException;
import com.truecaller.android.sdk.common.annotations.SinceTruecaller;
import com.truecaller.android.sdk.legacy.clients.CustomDataBundle;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Keep
/* loaded from: classes4.dex */
public class TruecallerSdkScope {
    public static final int BUTTON_SHAPE_RECTANGLE = 2048;
    public static final int BUTTON_SHAPE_ROUNDED = 1024;

    @SinceTruecaller
    public static final int CONSENT_MODE_BOTTOMSHEET = 128;
    public static final int CONSENT_MODE_FULLSCREEN = 8;
    public static final int CONSENT_MODE_POPUP = 4;
    public static final int CTA_TEXT_PREFIX_CONTINUE_WITH = 1;
    public static final int CTA_TEXT_PREFIX_PROCEED_WITH = 2;
    public static final int CTA_TEXT_PREFIX_USE = 0;
    public static final int FOOTER_TYPE_ANOTHER_METHOD = 256;
    public static final int FOOTER_TYPE_CONTINUE = 2;
    public static final int FOOTER_TYPE_LATER = 4096;
    public static final int FOOTER_TYPE_MANUALLY = 512;

    @SinceTruecaller
    public static final int FOOTER_TYPE_NONE = 64;
    public static final int FOOTER_TYPE_SKIP = 1;
    public static final int LOGIN_TEXT_PREFIX_FOR_NEW_UPDATES = 12;
    public static final int LOGIN_TEXT_PREFIX_TO_CHECKOUT = 4;
    public static final int LOGIN_TEXT_PREFIX_TO_COMPLETE_YOUR_BOOKING = 5;
    public static final int LOGIN_TEXT_PREFIX_TO_COMPLETE_YOUR_PURCHASE = 3;
    public static final int LOGIN_TEXT_PREFIX_TO_CONTINUE = 1;
    public static final int LOGIN_TEXT_PREFIX_TO_CONTINUE_READING = 10;
    public static final int LOGIN_TEXT_PREFIX_TO_CONTINUE_WITH_YOUR_BOOKING = 7;
    public static final int LOGIN_TEXT_PREFIX_TO_GET_BEST_PRICE = 16;
    public static final int LOGIN_TEXT_PREFIX_TO_GET_DETAILS = 8;
    public static final int LOGIN_TEXT_PREFIX_TO_GET_STARTED = 0;
    public static final int LOGIN_TEXT_PREFIX_TO_GET_UPDATES = 13;
    public static final int LOGIN_TEXT_PREFIX_TO_PLACE_ORDER = 2;
    public static final int LOGIN_TEXT_PREFIX_TO_PROCEED = 11;
    public static final int LOGIN_TEXT_PREFIX_TO_PROCEED_WITH_YOUR_BOOKING = 6;
    public static final int LOGIN_TEXT_PREFIX_TO_SUBSCRIBE = 14;
    public static final int LOGIN_TEXT_PREFIX_TO_SUBSCRIBE_AND_GET_UPDATES = 15;
    public static final int LOGIN_TEXT_PREFIX_TO_VIEW_MORE = 9;
    public static final int LOGIN_TEXT_SUFFIX_PLEASE_LOGIN = 1;
    public static final int LOGIN_TEXT_SUFFIX_PLEASE_LOGIN_SIGNUP = 3;
    public static final int LOGIN_TEXT_SUFFIX_PLEASE_REGISTER = 4;
    public static final int LOGIN_TEXT_SUFFIX_PLEASE_SIGNUP = 2;
    public static final int LOGIN_TEXT_SUFFIX_PLEASE_SIGN_IN = 5;
    public static final int LOGIN_TEXT_SUFFIX_PLEASE_VERIFY_MOBILE_NO = 0;
    public static final int SDK_CONSENT_TITLE_GET_STARTED = 5;
    public static final int SDK_CONSENT_TITLE_LOG_IN = 0;
    public static final int SDK_CONSENT_TITLE_REGISTER = 4;
    public static final int SDK_CONSENT_TITLE_SIGN_IN = 2;
    public static final int SDK_CONSENT_TITLE_SIGN_UP = 1;
    public static final int SDK_CONSENT_TITLE_VERIFY = 3;
    public static final int SDK_OPTION_WITHOUT_OTP = 16;
    public static final int SDK_OPTION_WITH_OTP = 32;

    @NonNull
    final ITrueCallback callback;

    @ConsentTitleOptions
    final int consentTitleOption;

    @NonNull
    final Context context;
    final CustomDataBundle customDataBundle;

    @NonNull
    final String partnerKey;
    final int sdkFlag;

    @Keep
    public static class Builder {

        @ColorInt
        private int buttonColor;

        @ColorInt
        private int buttonTextColor;

        @NonNull
        private final ITrueCallback callback;

        @NonNull
        private final Context context;

        @CTATextPrefixOptions
        private int ctaTextPrefixOption;

        @LoginTextPrefixOptions
        private int loginTextPrefixOption;

        @LoginTextSuffixOptions
        private int loginTextSuffixOption;

        @Nullable
        private final String partnerKey;
        private String privacyPolicyUrl;
        private int sdkFlag;
        private String termsOfServiceUrl;

        @ConsentTitleOptions
        private int titleOption;

        public Builder(@NonNull Context context, @NonNull ITrueCallback iTrueCallback) throws PackageManager.NameNotFoundException {
            ApplicationInfo applicationInfo;
            Bundle bundle;
            this.context = context.getApplicationContext();
            this.callback = iTrueCallback;
            String str = null;
            try {
                applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            } catch (PackageManager.NameNotFoundException unused) {
                applicationInfo = null;
            }
            if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
                Object obj = bundle.get("com.truecaller.android.sdk.PartnerKey");
                if (obj instanceof String) {
                    str = (String) obj;
                }
            }
            this.partnerKey = str;
        }

        public TruecallerSdkScope build() throws RuntimeException {
            if (TextUtils.isEmpty(this.partnerKey)) {
                throw new RuntimeException(TrueException.TYPE_PARTNER_KEY);
            }
            return new TruecallerSdkScope(this);
        }

        public Builder buttonColor(@ColorInt int i2) {
            this.buttonColor = i2;
            return this;
        }

        public Builder buttonShapeOptions(@ButtonShape int i2) {
            this.sdkFlag = i2 | (this.sdkFlag & (-3073));
            return this;
        }

        public Builder buttonTextColor(@ColorInt int i2) {
            this.buttonTextColor = i2;
            return this;
        }

        public Builder consentMode(@ConsentMode int i2) {
            this.sdkFlag = i2 | (this.sdkFlag & (-141));
            return this;
        }

        public Builder consentTitleOption(@ConsentTitleOptions int i2) {
            this.titleOption = i2;
            return this;
        }

        public Builder ctaTextPrefix(@CTATextPrefixOptions int i2) {
            this.ctaTextPrefixOption = i2;
            return this;
        }

        public Builder footerType(@FooterType int i2) {
            this.sdkFlag = i2 | (this.sdkFlag & (-4932));
            return this;
        }

        public Builder loginTextPrefix(@LoginTextPrefixOptions int i2) {
            this.loginTextPrefixOption = i2;
            return this;
        }

        public Builder loginTextSuffix(@LoginTextSuffixOptions int i2) {
            this.loginTextSuffixOption = i2;
            return this;
        }

        public Builder privacyPolicyUrl(String str) {
            this.privacyPolicyUrl = str;
            return this;
        }

        public Builder sdkOptions(@SdkOptions int i2) {
            this.sdkFlag = i2 | (this.sdkFlag & (-49));
            return this;
        }

        public Builder termsOfServiceUrl(String str) {
            this.termsOfServiceUrl = str;
            return this;
        }
    }

    @Retention(RetentionPolicy.CLASS)
    public @interface CTATextPrefixOptions {
    }

    @Retention(RetentionPolicy.CLASS)
    public @interface ConsentTitleOptions {
    }

    @Retention(RetentionPolicy.CLASS)
    public @interface LoginTextPrefixOptions {
    }

    @Retention(RetentionPolicy.CLASS)
    public @interface LoginTextSuffixOptions {
    }

    public TruecallerSdkScope(@NonNull Builder builder) {
        this.context = builder.context;
        this.partnerKey = builder.partnerKey;
        this.sdkFlag = builder.sdkFlag;
        this.callback = builder.callback;
        this.consentTitleOption = builder.titleOption;
        this.customDataBundle = new CustomDataBundle(builder.buttonColor, builder.buttonTextColor, builder.privacyPolicyUrl, builder.termsOfServiceUrl, builder.ctaTextPrefixOption, builder.loginTextPrefixOption, builder.loginTextSuffixOption);
    }
}
