package org.npci.upi.security.services;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.ResultReceiver;
import org.npci.upi.security.services.CLResultReceiver;

/* loaded from: classes5.dex */
public class CLRemoteResultReceiver extends Service {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f57683a = 0;
    private IBinder mBinder = new CLResultReceiver.Stub() { // from class: org.npci.upi.security.services.CLRemoteResultReceiver.1
        @Override // org.npci.upi.security.services.CLResultReceiver
        public void forgotUpiPIN(Bundle bundle) {
            CLRemoteResultReceiver.this.mResultReceiver.send(3, bundle);
        }

        @Override // org.npci.upi.security.services.CLResultReceiver
        public void sendCredential(Bundle bundle) {
            CLRemoteResultReceiver.this.mResultReceiver.send(1, bundle);
        }

        @Override // org.npci.upi.security.services.CLResultReceiver
        public void triggerAadhaarOtp(Bundle bundle) {
            CLRemoteResultReceiver.this.mResultReceiver.send(4, bundle);
        }

        @Override // org.npci.upi.security.services.CLResultReceiver
        public void triggerOtp(Bundle bundle) {
            CLRemoteResultReceiver.this.mResultReceiver.send(2, bundle);
        }
    };
    private ResultReceiver mResultReceiver;

    public CLRemoteResultReceiver(ResultReceiver resultReceiver) {
        this.mResultReceiver = resultReceiver;
    }

    public IBinder getBinder() {
        return this.mBinder;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.mBinder;
    }
}
