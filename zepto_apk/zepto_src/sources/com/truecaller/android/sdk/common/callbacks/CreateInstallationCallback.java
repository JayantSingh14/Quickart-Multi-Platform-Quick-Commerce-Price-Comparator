package com.truecaller.android.sdk.common.callbacks;

import android.support.v4.media.b;
import androidx.annotation.RestrictTo;
import com.truecaller.android.sdk.common.TrueException;
import com.truecaller.android.sdk.common.VerificationCallback;
import com.truecaller.android.sdk.common.VerificationRequestManagerImpl;
import java.util.Map;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@RestrictTo
/* loaded from: classes4.dex */
public abstract class CreateInstallationCallback extends BaseApiCallback<Map<String, Object>> {

    /* renamed from: d, reason: collision with root package name */
    public final VerificationRequestManagerImpl f47216d;

    public CreateInstallationCallback(VerificationCallback verificationCallback, VerificationRequestManagerImpl verificationRequestManagerImpl) {
        super(verificationCallback, false, 9);
        this.f47216d = verificationRequestManagerImpl;
    }

    @Override // com.truecaller.android.sdk.common.callbacks.BaseApiCallback
    public final void c() {
    }

    @Override // com.truecaller.android.sdk.common.callbacks.BaseApiCallback
    public final void d(Object obj) {
        Map map = (Map) obj;
        Double d2 = (Double) map.get(CLConstants.OTP_STATUS);
        double dDoubleValue = d2.doubleValue();
        VerificationRequestManagerImpl verificationRequestManagerImpl = this.f47216d;
        if (dDoubleValue == 0.0d) {
            String str = (String) map.get("verificationToken");
            System.currentTimeMillis();
            verificationRequestManagerImpl.f47204j = str;
            e(map);
            return;
        }
        double dDoubleValue2 = d2.doubleValue();
        VerificationCallback verificationCallback = this.f47213a;
        if (dDoubleValue2 != 1.0d) {
            verificationCallback.onRequestFailure(this.f47214b, new TrueException(1, TrueException.TYPE_UNKNOWN_MESSAGE));
        } else {
            String str2 = (String) map.get("accessToken");
            verificationRequestManagerImpl.f47195a.b(b.C("Bearer ", str2)).N(new FetchProfileCallback((String) map.get("requestNonce"), str2, verificationCallback, verificationRequestManagerImpl));
        }
    }

    public abstract void e(Map map);
}
