package com.truecaller.android.sdk.oAuth;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.ColorInt;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Keep
/* loaded from: classes4.dex */
public class TcSdkOptions {
    public static final int BUTTON_SHAPE_RECTANGLE = 256;
    public static final int BUTTON_SHAPE_ROUNDED = 128;
    public static final int CONSENT_MODE_BOTTOMSHEET = 4096;
    public static final int CONSENT_MODE_POPUP = 2048;
    public static final int CTA_TEXT_ACCEPT = 2;
    public static final int CTA_TEXT_CONFIRM = 3;
    public static final int CTA_TEXT_CONTINUE = 1;
    public static final int CTA_TEXT_CONTINUE_WITH = 5;
    public static final int CTA_TEXT_PROCEED = 0;
    public static final int CTA_TEXT_PROCEED_WITH = 6;
    public static final int CTA_TEXT_USE = 4;
    public static final int DISMISS_OPTION_CROSS_BUTTON = 1024;
    public static final int DISMISS_OPTION_SECONDARY_CTA_BORDER = 512;
    public static final int FOOTER_TYPE_ANOTHER_METHOD = 4;
    public static final int FOOTER_TYPE_ANOTHER_MOBILE_NO = 2;
    public static final int FOOTER_TYPE_LATER = 16;
    public static final int FOOTER_TYPE_MANUALLY = 8;
    public static final int FOOTER_TYPE_SKIP = 1;
    public static final int LOGIN_TEXT_PREFIX_FOR_NEW_UPDATES = 12;
    public static final int LOGIN_TEXT_PREFIX_TO_CHECKOUT = 4;
    public static final int LOGIN_TEXT_PREFIX_TO_COMPLETE_YOUR_BOOKING = 5;
    public static final int LOGIN_TEXT_PREFIX_TO_COMPLETE_YOUR_PURCHASE = 3;
    public static final int LOGIN_TEXT_PREFIX_TO_CONTINUE = 1;
    public static final int LOGIN_TEXT_PREFIX_TO_CONTINUE_READING = 10;
    public static final int LOGIN_TEXT_PREFIX_TO_CONTINUE_WITH_YOUR_BOOKING = 7;
    public static final int LOGIN_TEXT_PREFIX_TO_GET_DETAILS = 8;
    public static final int LOGIN_TEXT_PREFIX_TO_GET_STARTED = 0;
    public static final int LOGIN_TEXT_PREFIX_TO_GET_UPDATES = 13;
    public static final int LOGIN_TEXT_PREFIX_TO_PLACE_ORDER = 2;
    public static final int LOGIN_TEXT_PREFIX_TO_PROCEED = 11;
    public static final int LOGIN_TEXT_PREFIX_TO_PROCEED_WITH_YOUR_BOOKING = 6;
    public static final int LOGIN_TEXT_PREFIX_TO_SUBSCRIBE = 14;
    public static final int LOGIN_TEXT_PREFIX_TO_SUBSCRIBE_AND_GET_UPDATES = 15;
    public static final int LOGIN_TEXT_PREFIX_TO_VIEW_MORE = 9;
    public static final int OPTION_VERIFY_ALL_USERS = 64;
    public static final int OPTION_VERIFY_ONLY_TC_USERS = 32;
    public static final int SDK_CONSENT_HEADING_CHECKOUT_WITH = 16;
    public static final int SDK_CONSENT_HEADING_COMPLETE_BOOKING_WITH = 15;
    public static final int SDK_CONSENT_HEADING_COMPLETE_ORDER_WITH = 13;
    public static final int SDK_CONSENT_HEADING_CONTINUE_READING_ON = 22;
    public static final int SDK_CONSENT_HEADING_CONTINUE_WITH = 12;
    public static final int SDK_CONSENT_HEADING_GET_NEW_UPDATES_FROM = 23;
    public static final int SDK_CONSENT_HEADING_GET_STARTED_WITH = 5;
    public static final int SDK_CONSENT_HEADING_GET_UPDATES_FROM = 21;
    public static final int SDK_CONSENT_HEADING_LOGIN_SIGNUP_WITH = 24;
    public static final int SDK_CONSENT_HEADING_LOGIN_TO_WITH_ONE_TAP = 19;
    public static final int SDK_CONSENT_HEADING_LOG_IN_TO = 0;
    public static final int SDK_CONSENT_HEADING_MANAGE_DETAILS_WITH = 17;
    public static final int SDK_CONSENT_HEADING_MANAGE_YOUR_DETAILS_WITH = 18;
    public static final int SDK_CONSENT_HEADING_PLACE_ORDER_WITH = 14;
    public static final int SDK_CONSENT_HEADING_PROCEED_WITH = 6;
    public static final int SDK_CONSENT_HEADING_REGISTER_WITH = 4;
    public static final int SDK_CONSENT_HEADING_SIGN_IN_TO = 2;
    public static final int SDK_CONSENT_HEADING_SIGN_UP_WITH = 1;
    public static final int SDK_CONSENT_HEADING_SUBSCRIBE_TO = 20;
    public static final int SDK_CONSENT_HEADING_VERIFY_NUMBER_WITH = 3;
    public static final int SDK_CONSENT_HEADING_VERIFY_PHONE_NO_WITH = 10;
    public static final int SDK_CONSENT_HEADING_VERIFY_PROFILE_WITH = 8;
    public static final int SDK_CONSENT_HEADING_VERIFY_WITH = 7;
    public static final int SDK_CONSENT_HEADING_VERIFY_YOUR_NO_WITH = 11;
    public static final int SDK_CONSENT_HEADING_VERIFY_YOUR_PROFILE_WITH = 9;

    @NonNull
    protected final TcOAuthCallback callback;

    @NonNull
    protected final String clientId;

    @NonNull
    protected final Context context;
    protected final int sdkFlag;
    final SdkOptionsDataBundle sdkOptionsDataBundle;

    @Keep
    public static class Builder {

        @ColorInt
        private int buttonColor;

        @ColorInt
        private int buttonTextColor;

        @NonNull
        private final TcOAuthCallback callback;

        @Nullable
        private final String clientId;

        @NonNull
        private final Context context;

        @CTATextOptions
        private int ctaTextOption;

        @ConsentHeadingOptions
        private int headingOption;

        @LoginTextPrefixOptions
        private int loginTextPrefixOption;
        private int sdkFlag;

        @ConsentTitleOptions
        private int titleOption;

        public Builder(@NonNull Context context, @NonNull TcOAuthCallback tcOAuthCallback) throws PackageManager.NameNotFoundException {
            ApplicationInfo applicationInfo;
            Bundle bundle;
            this.context = context.getApplicationContext();
            this.callback = tcOAuthCallback;
            String str = null;
            try {
                applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            } catch (PackageManager.NameNotFoundException unused) {
                applicationInfo = null;
            }
            if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
                Object obj = bundle.get("com.truecaller.android.sdk.ClientId");
                if (obj instanceof String) {
                    str = (String) obj;
                }
            }
            this.clientId = str;
        }

        public TcSdkOptions build() throws RuntimeException {
            if (TextUtils.isEmpty(this.clientId)) {
                throw new RuntimeException("Add client id in your manifest");
            }
            return new TcSdkOptions(this);
        }

        public Builder buttonColor(@ColorInt int i2) {
            this.buttonColor = i2;
            return this;
        }

        public Builder buttonShapeOptions(@ButtonShape int i2) {
            this.sdkFlag = i2 | (this.sdkFlag & (-385));
            return this;
        }

        public Builder buttonTextColor(@ColorInt int i2) {
            this.buttonTextColor = i2;
            return this;
        }

        public Builder consentHeadingOption(@ConsentHeadingOptions int i2) {
            this.headingOption = i2;
            return this;
        }

        public Builder consentMode(@ConsentMode int i2) {
            this.sdkFlag = i2 | (this.sdkFlag & (-6145));
            return this;
        }

        public Builder consentTitleOption(@ConsentTitleOptions int i2) {
            this.titleOption = i2;
            return this;
        }

        public Builder ctaText(@CTATextOptions int i2) {
            this.ctaTextOption = i2;
            return this;
        }

        public Builder dismissOptions(@DismissOptions int i2) {
            this.sdkFlag = i2 | (this.sdkFlag & (-1537));
            return this;
        }

        public Builder footerType(@FooterType int i2) {
            this.sdkFlag = i2 | (this.sdkFlag & (-32));
            return this;
        }

        public Builder loginTextPrefix(@LoginTextPrefixOptions int i2) {
            this.loginTextPrefixOption = i2;
            return this;
        }

        public Builder sdkOptions(@SdkOptions int i2) {
            this.sdkFlag = i2 | (this.sdkFlag & (-97));
            return this;
        }
    }

    @Retention(RetentionPolicy.CLASS)
    public @interface CTATextOptions {
    }

    @Retention(RetentionPolicy.CLASS)
    public @interface ConsentHeadingOptions {
    }

    @Retention(RetentionPolicy.CLASS)
    public @interface ConsentTitleOptions {
    }

    @Retention(RetentionPolicy.CLASS)
    public @interface DismissOptions {
    }

    @Retention(RetentionPolicy.CLASS)
    public @interface FooterType {
    }

    @Retention(RetentionPolicy.CLASS)
    public @interface LoginTextPrefixOptions {
    }

    @Retention(RetentionPolicy.CLASS)
    public @interface SdkOptions {
    }

    public TcSdkOptions(@NonNull Builder builder) {
        this.context = builder.context;
        this.clientId = builder.clientId;
        this.sdkFlag = builder.sdkFlag;
        this.callback = builder.callback;
        this.sdkOptionsDataBundle = new SdkOptionsDataBundle(builder.buttonColor, builder.buttonTextColor, builder.titleOption, builder.headingOption, builder.ctaTextOption, builder.loginTextPrefixOption);
    }
}
