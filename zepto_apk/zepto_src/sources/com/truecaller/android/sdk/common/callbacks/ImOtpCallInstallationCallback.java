package com.truecaller.android.sdk.common.callbacks;

import com.truecaller.android.sdk.common.VerificationCallback;
import com.truecaller.android.sdk.common.VerificationDataBundle;
import com.truecaller.android.sdk.common.VerificationRequestManager;
import java.util.Map;

/* loaded from: classes4.dex */
public class ImOtpCallInstallationCallback extends MissedCallInstallationCallback {
    @Override // com.truecaller.android.sdk.common.callbacks.MissedCallInstallationCallback, com.truecaller.android.sdk.common.callbacks.OtpInstallationCallback, com.truecaller.android.sdk.common.callbacks.CreateInstallationCallback
    public final void e(Map map) {
        if (!"im".equals((String) map.get("method"))) {
            super.e(map);
            return;
        }
        Double dValueOf = (Double) map.get("tokenTtl");
        if (dValueOf == null) {
            dValueOf = Double.valueOf(30.0d);
        }
        long jLongValue = dValueOf.longValue() * 1000;
        String str = (String) map.get("requestNonce");
        VerificationRequestManager.Client client = this.f47216d.f47199e;
        VerificationCallback verificationCallback = this.f47213a;
        client.f(verificationCallback, jLongValue);
        VerificationDataBundle verificationDataBundle = new VerificationDataBundle();
        verificationDataBundle.a(dValueOf.toString(), "ttl");
        verificationDataBundle.a(str, "requestNonce");
        verificationCallback.onRequestSuccess(this.f47214b, verificationDataBundle);
    }
}
