package org.npci.upi.security.pinactivitycomponent;

import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.os.ResultReceiver;
import org.npci.upi.security.services.CLResultReceiver;

/* loaded from: classes5.dex */
public class CLServerResultReceiver extends ResultReceiver {

    /* renamed from: a, reason: collision with root package name */
    private CLResultReceiver f57467a;

    public CLServerResultReceiver(CLResultReceiver cLResultReceiver) {
        super(new Handler());
        this.f57467a = cLResultReceiver;
    }

    @Override // android.os.ResultReceiver
    public void onReceiveResult(int i2, Bundle bundle) {
        super.onReceiveResult(i2, bundle);
        try {
            if (i2 == 2) {
                this.f57467a.triggerOtp(bundle);
                return;
            }
            if (i2 == 3) {
                this.f57467a.forgotUpiPIN(bundle);
            } else if (i2 == 4) {
                this.f57467a.triggerAadhaarOtp(bundle);
            } else {
                this.f57467a.sendCredential(bundle);
            }
        } catch (RemoteException e2) {
            q.a("onReceiveResult", "" + e2.getLocalizedMessage());
        }
    }
}
