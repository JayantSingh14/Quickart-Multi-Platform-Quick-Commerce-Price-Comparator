package com.truecaller.android.sdk.common;

import android.os.Handler;
import androidx.annotation.RestrictTo;
import com.truecaller.android.sdk.common.callbacks.MissedCallInstallationCallback;

@RestrictTo
/* loaded from: classes4.dex */
public interface VerificationRequestManager {

    public interface Client {
        void a();

        boolean b();

        void c(MissedCallInstallationCallback missedCallInstallationCallback);

        boolean d();

        int e();

        void f(VerificationCallback verificationCallback, long j2);

        void g();

        Handler getHandler();
    }
}
