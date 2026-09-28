package com.truecaller.android.sdk.common.callbacks;

import android.support.v4.media.b;
import androidx.annotation.RestrictTo;
import com.truecaller.android.sdk.common.TrueException;
import com.truecaller.android.sdk.common.VerificationCallback;
import com.truecaller.android.sdk.common.VerificationDataBundle;
import com.truecaller.android.sdk.common.VerificationRequestManagerImpl;
import com.truecaller.android.sdk.common.models.TrueProfile;
import com.truecaller.android.sdk.common.models.VerifyInstallationModel;
import com.truecaller.android.sdk.common.network.VerificationService;
import java.util.Map;

@RestrictTo
/* loaded from: classes4.dex */
public class VerifyInstallationCallback extends BaseApiCallback<Map<String, Object>> {

    /* renamed from: d, reason: collision with root package name */
    public final TrueProfile f47229d;

    /* renamed from: e, reason: collision with root package name */
    public final VerificationRequestManagerImpl f47230e;

    /* renamed from: f, reason: collision with root package name */
    public final String f47231f;

    /* renamed from: g, reason: collision with root package name */
    public final VerifyInstallationModel f47232g;

    public VerifyInstallationCallback(String str, VerifyInstallationModel verifyInstallationModel, VerificationCallback verificationCallback, TrueProfile trueProfile, VerificationRequestManagerImpl verificationRequestManagerImpl) {
        super(verificationCallback, true, 5);
        this.f47229d = trueProfile;
        this.f47230e = verificationRequestManagerImpl;
        this.f47231f = str;
        this.f47232g = verifyInstallationModel;
    }

    @Override // com.truecaller.android.sdk.common.callbacks.BaseApiCallback
    public final void c() {
        String str = this.f47231f;
        VerifyInstallationModel verifyInstallationModel = this.f47232g;
        VerificationRequestManagerImpl verificationRequestManagerImpl = this.f47230e;
        boolean z = verificationRequestManagerImpl.f47207m;
        VerificationService verificationService = verificationRequestManagerImpl.f47196b;
        if (z) {
            verificationService.d(str, verificationRequestManagerImpl.f47203i, verifyInstallationModel).N(this);
        } else {
            verificationService.a(str, verificationRequestManagerImpl.f47203i, verifyInstallationModel).N(this);
        }
    }

    @Override // com.truecaller.android.sdk.common.callbacks.BaseApiCallback
    public final void d(Object obj) {
        Map map = (Map) obj;
        boolean zContainsKey = map.containsKey("accessToken");
        int i2 = this.f47214b;
        VerificationCallback verificationCallback = this.f47213a;
        if (!zContainsKey) {
            verificationCallback.onRequestFailure(i2, new TrueException(1, TrueException.TYPE_UNKNOWN_MESSAGE));
            return;
        }
        String str = (String) map.get("accessToken");
        VerificationDataBundle verificationDataBundle = new VerificationDataBundle();
        verificationDataBundle.a(str, "accessToken");
        verificationDataBundle.a((String) map.get("requestNonce"), "requestNonce");
        verificationCallback.onRequestSuccess(i2, verificationDataBundle);
        VerificationRequestManagerImpl verificationRequestManagerImpl = this.f47230e;
        TrueProfile trueProfile = this.f47229d;
        verificationRequestManagerImpl.f47195a.a(b.C("Bearer ", str), trueProfile).N(new CreateProfileCallback(str, trueProfile, verificationRequestManagerImpl));
    }
}
