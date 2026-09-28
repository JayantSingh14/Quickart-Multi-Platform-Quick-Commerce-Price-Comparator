package com.truecaller.android.sdk.common.callbacks;

import android.support.v4.media.b;
import androidx.annotation.RestrictTo;
import com.google.android.gms.common.Scopes;
import com.truecaller.android.sdk.common.VerificationCallback;
import com.truecaller.android.sdk.common.VerificationDataBundle;
import com.truecaller.android.sdk.common.VerificationRequestManagerImpl;
import com.truecaller.android.sdk.common.models.TrueProfile;

@RestrictTo
/* loaded from: classes4.dex */
public class FetchProfileCallback extends BaseApiCallback<TrueProfile> {

    /* renamed from: d, reason: collision with root package name */
    public final String f47221d;

    /* renamed from: e, reason: collision with root package name */
    public final VerificationRequestManagerImpl f47222e;

    /* renamed from: f, reason: collision with root package name */
    public final String f47223f;

    public FetchProfileCallback(String str, String str2, VerificationCallback verificationCallback, VerificationRequestManagerImpl verificationRequestManagerImpl) {
        super(verificationCallback, true, 6);
        this.f47221d = str2;
        this.f47222e = verificationRequestManagerImpl;
        this.f47223f = str;
    }

    @Override // com.truecaller.android.sdk.common.callbacks.BaseApiCallback
    public final void c() {
        VerificationRequestManagerImpl verificationRequestManagerImpl = this.f47222e;
        verificationRequestManagerImpl.f47195a.b(b.C("Bearer ", this.f47221d)).N(this);
    }

    @Override // com.truecaller.android.sdk.common.callbacks.BaseApiCallback
    public final void d(Object obj) {
        TrueProfile trueProfile = (TrueProfile) obj;
        trueProfile.accessToken = this.f47221d;
        trueProfile.requestNonce = this.f47223f;
        VerificationDataBundle verificationDataBundle = new VerificationDataBundle();
        verificationDataBundle.a(trueProfile, Scopes.PROFILE);
        this.f47213a.onRequestSuccess(this.f47214b, verificationDataBundle);
    }
}
