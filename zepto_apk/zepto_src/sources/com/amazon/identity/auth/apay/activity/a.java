package com.amazon.identity.auth.apay.activity;

import android.os.Handler;
import android.widget.TextView;
import androidx.browser.customtabs.CustomTabsIntent;
import com.amazon.android.apay.commonlibrary.commonlib.utils.InstrumentUtil;
import com.amazon.identity.auth.device.authorization.R;
import com.amazon.identity.auth.device.authorization.ServiceConnectionState;
import com.amazon.identity.auth.device.authorization.ThirdPartyAuthorizationHelper;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15073a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AuthActivity f15074b;

    public /* synthetic */ a(AuthActivity authActivity, int i2) {
        this.f15073a = i2;
        this.f15074b = authActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AuthActivity authActivity = this.f15074b;
        switch (this.f15073a) {
            case 0:
                CustomTabsIntent customTabsIntent = AuthActivity.p;
                authActivity.findViewById(R.id.cancelBtn).setVisibility(0);
                break;
            case 1:
                CustomTabsIntent customTabsIntent2 = AuthActivity.p;
                authActivity.findViewById(R.id.cancelBtn).setVisibility(0);
                InstrumentUtil.addMetricEvent("DelayedCancel", "LWA_LITE_SDK.BUSINESS_METRICS", authActivity.f15071m);
                break;
            case 2:
                CustomTabsIntent customTabsIntent3 = AuthActivity.p;
                if (!authActivity.isFinishing() && ThirdPartyAuthorizationHelper.serviceStatus == ServiceConnectionState.UNINITIATED) {
                    authActivity.f15067i.f9e = true;
                    authActivity.runOnUiThread(new a(authActivity, 3));
                    break;
                }
                break;
            case 3:
                CustomTabsIntent customTabsIntent4 = AuthActivity.p;
                ((TextView) authActivity.findViewById(R.id.loading_text)).setText("Canceling your Amazon Pay authorization");
                new Handler().postDelayed(new a(authActivity, 4), 1000L);
                break;
            default:
                InstrumentUtil.addMetricEvent("LoginDroppedOff", "LWA_LITE_SDK.BUSINESS_METRICS", authActivity.f15071m);
                authActivity.q("AuthCancelled", "Auth cancelled");
                break;
        }
    }
}
