package org.npci.upi.security.pinactivitycomponent;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import org.npci.upi.security.services.CLRemoteService;
import org.npci.upi.security.services.CLResultReceiver;

/* loaded from: classes5.dex */
public class CLRemoteServiceImpl extends Service {

    /* renamed from: a, reason: collision with root package name */
    private CLRemoteService.Stub f57463a = null;

    /* renamed from: b, reason: collision with root package name */
    private d f57464b = null;

    public class a extends CLRemoteService.Stub {

        /* renamed from: b, reason: collision with root package name */
        private Context f57466b;

        private a(Context context) {
            this.f57466b = context;
        }

        @Override // org.npci.upi.security.services.CLRemoteService
        public void execute(String str) {
            if (GetCredential._getInstance() != null) {
                GetCredential._getInstance().triggredOTPResponse(str);
            }
        }

        @Override // org.npci.upi.security.services.CLRemoteService
        public String getChallenge(String str, String str2) {
            return CLRemoteServiceImpl.this.f57464b.a(str, str2);
        }

        @Override // org.npci.upi.security.services.CLRemoteService
        public void getCredential(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, CLResultReceiver cLResultReceiver) {
            new n(this.f57466b).a(CLConstants.SHARED_PREFERENCE_ITEM_LANG_PREF, str8);
            Bundle bundleA = CLRemoteServiceImpl.this.a(str, str2, str3, str4, str5, str6, str7, str8, cLResultReceiver);
            Intent intent = new Intent(this.f57466b, (Class<?>) GetCredential.class);
            intent.setFlags(268435456);
            intent.putExtras(bundleA);
            this.f57466b.startActivity(intent);
        }

        @Override // org.npci.upi.security.services.CLRemoteService
        public Intent getCredentialIntent(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, CLResultReceiver cLResultReceiver) {
            Bundle bundleA = CLRemoteServiceImpl.this.a(str, str2, str3, str4, str5, str6, str7, str8, cLResultReceiver);
            Intent intent = new Intent(this.f57466b, (Class<?>) GetCredential.class);
            intent.putExtras(bundleA);
            return intent;
        }

        @Override // org.npci.upi.security.services.CLRemoteService
        public String getUPILiteBalance(String str, String str2, String str3) {
            return CLRemoteServiceImpl.this.f57464b.c(str, str2, str3);
        }

        @Override // org.npci.upi.security.services.CLRemoteService
        public String isUpiLiteBound(String str, String str2, String str3) {
            return CLRemoteServiceImpl.this.f57464b.a(str, str2, str3);
        }

        @Override // org.npci.upi.security.services.CLRemoteService
        public boolean isUpiLiteSupported() {
            return CLRemoteServiceImpl.this.f57464b.c();
        }

        @Override // org.npci.upi.security.services.CLRemoteService
        public boolean registerApp(String str, String str2, String str3, String str4, String str5) {
            return CLRemoteServiceImpl.this.f57464b.a(str, str2, str3, str4, str5);
        }

        @Override // org.npci.upi.security.services.CLRemoteService
        public boolean registerUPILiteOnboarding(String str, String str2, String str3, String str4) {
            return CLRemoteServiceImpl.this.f57464b.a(str, str2, str3, str4);
        }

        @Override // org.npci.upi.security.services.CLRemoteService
        public boolean registerUPILiteState(String str, String str2, String str3, String str4) {
            return CLRemoteServiceImpl.this.f57464b.b(str, str2, str3, str4);
        }

        @Override // org.npci.upi.security.services.CLRemoteService
        public boolean unBindDevice(String str, String str2, String str3) {
            return CLRemoteServiceImpl.this.f57464b.b(str, str2, str3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, CLResultReceiver cLResultReceiver) {
        Bundle bundle = new Bundle();
        bundle.putString(CLConstants.INPUT_CODE, str);
        bundle.putString(CLConstants.INPUT_XML_PAYLOAD, str2);
        bundle.putString(CLConstants.INPUT_CONTROLS, str3);
        bundle.putString(CLConstants.INPUT_CONFIGURATION, str4);
        bundle.putString(CLConstants.INPUT_SALT, str5);
        bundle.putString(CLConstants.INPUT_PAY_INFO, str6);
        bundle.putString(CLConstants.INPUT_TRUST, str7);
        bundle.putString(CLConstants.INPUT_LANGUAGE_PREFERENCE, str8);
        l.a(new CLServerResultReceiver(cLResultReceiver));
        return bundle;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (this.f57463a == null) {
            this.f57463a = new a(getBaseContext());
        }
        try {
            this.f57464b = new d(getBaseContext());
            return this.f57463a;
        } catch (Exception unused) {
            throw new RuntimeException("Could not initialize service provider");
        }
    }
}
