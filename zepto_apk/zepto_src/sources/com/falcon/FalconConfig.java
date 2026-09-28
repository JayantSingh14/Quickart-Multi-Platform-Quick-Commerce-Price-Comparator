package com.falcon;

import bridges.CommsModule;
import in.juspay.hypersdk.core.PaymentConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class FalconConfig {

    /* renamed from: a, reason: collision with root package name */
    public static final Companion f20433a = new Companion();

    /* renamed from: b, reason: collision with root package name */
    public static volatile FalconConfig f20434b;

    @Metadata
    public static final class Companion {
    }

    public FalconConfig() {
        Intrinsics.checkNotNullParameter(com.zeptoconsumerapp.BuildConfig.EVENT_SERVICE_BASE_URL, "eventServiceBaseUrl");
        Intrinsics.checkNotNullParameter(CommsModule.SHARED_PREFERENCE_NAME, "clientSharedPrefsName");
        Intrinsics.checkNotNullParameter("PROD", PaymentConstants.ENV);
        Intrinsics.checkNotNullParameter(com.zeptoconsumerapp.BuildConfig.MIXPANEL_KEY, "mixpanelKey");
        Intrinsics.checkNotNullParameter(com.zeptoconsumerapp.BuildConfig.DEFAULT_DEEPLINK_URL, "defaultDeeplinkUrl");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FalconConfig)) {
            return false;
        }
        ((FalconConfig) obj).getClass();
        return true;
    }

    public final int hashCode() {
        return ((Boolean.hashCode(false) + 807060716) * 31) + 255579490;
    }

    public final String toString() {
        return "FalconConfig(eventServiceBaseUrl=https://events.zepto.co.in/api/, clientSharedPrefsName=Zepto, environment=PROD, mixpanelKey=dcc8757645c1c32f4481b555710c7039, isDebug=false, defaultDeeplinkUrl=https://www.zepto.com/)";
    }
}
