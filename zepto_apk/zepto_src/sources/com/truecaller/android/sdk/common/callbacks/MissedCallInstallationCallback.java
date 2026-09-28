package com.truecaller.android.sdk.common.callbacks;

import android.os.Handler;
import com.swmansion.gesturehandler.react.b;
import com.truecaller.android.sdk.common.TrueException;
import com.truecaller.android.sdk.common.VerificationDataBundle;
import com.truecaller.android.sdk.common.VerificationRequestManager;
import com.truecaller.android.sdk.common.VerificationRequestManagerImpl;
import java.util.Map;

/* loaded from: classes4.dex */
public class MissedCallInstallationCallback extends OtpInstallationCallback {

    /* renamed from: f, reason: collision with root package name */
    public b f47224f;

    /* renamed from: g, reason: collision with root package name */
    public Handler f47225g;

    /* renamed from: h, reason: collision with root package name */
    public String f47226h;

    /* renamed from: i, reason: collision with root package name */
    public String f47227i;

    @Override // com.truecaller.android.sdk.common.callbacks.OtpInstallationCallback, com.truecaller.android.sdk.common.callbacks.CreateInstallationCallback
    public void e(Map map) {
        if (!"call".equals((String) map.get("method"))) {
            super.e(map);
            return;
        }
        this.f47216d.f47199e.c(this);
        this.f47226h = (String) map.get("pattern");
        Double dValueOf = (Double) map.get("tokenTtl");
        if (dValueOf == null) {
            dValueOf = Double.valueOf(40.0d);
        }
        VerificationDataBundle verificationDataBundle = new VerificationDataBundle();
        verificationDataBundle.a(dValueOf.toString(), "ttl");
        verificationDataBundle.a((String) map.get("requestNonce"), "requestNonce");
        this.f47213a.onRequestSuccess(3, verificationDataBundle);
        b bVar = new b(this, 3);
        this.f47224f = bVar;
        this.f47225g.postDelayed(bVar, dValueOf.longValue() * 1000);
    }

    public final void f(boolean z) {
        if (z || this.f47226h != null) {
            VerificationRequestManagerImpl verificationRequestManagerImpl = this.f47216d;
            VerificationRequestManager.Client client = verificationRequestManagerImpl.f47199e;
            client.a();
            client.g();
            if (this.f47227i != null && this.f47226h != null) {
                StringBuilder sb = new StringBuilder();
                for (String str : this.f47226h.split(",")) {
                    sb.append(this.f47227i.charAt((r6.length() - Integer.parseInt(str)) - 1));
                }
                verificationRequestManagerImpl.f47205k = sb.toString();
                this.f47213a.onRequestSuccess(4, null);
            }
            Handler handler = this.f47225g;
            if (handler != null) {
                handler.removeCallbacks(this.f47224f);
                this.f47225g = null;
            }
        }
    }

    public final void g(String str) {
        if (str != null && str.length() != 0) {
            this.f47227i = str;
            f(false);
            return;
        }
        Handler handler = this.f47225g;
        if (handler != null) {
            handler.removeCallbacks(this.f47224f);
            this.f47225g = null;
        }
        this.f47213a.onRequestFailure(4, new TrueException(4, TrueException.TYPE_MISSING_PERMISSIONS_MESSAGE));
    }
}
