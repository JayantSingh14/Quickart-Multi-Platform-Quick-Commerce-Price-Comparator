package com.truecaller.android.sdk.common.callVerification;

import android.telephony.PhoneStateListener;
import androidx.annotation.RestrictTo;
import com.truecaller.android.sdk.common.callbacks.MissedCallInstallationCallback;

@RestrictTo
/* loaded from: classes4.dex */
public class IncomingCallListener extends PhoneStateListener {

    /* renamed from: a, reason: collision with root package name */
    public final MissedCallInstallationCallback f47210a;

    public IncomingCallListener(MissedCallInstallationCallback missedCallInstallationCallback) {
        this.f47210a = missedCallInstallationCallback;
    }

    @Override // android.telephony.PhoneStateListener
    public final void onCallStateChanged(int i2, String str) {
        super.onCallStateChanged(i2, str);
        if (i2 == 1) {
            this.f47210a.g(str);
        }
    }
}
