package org.npci.upi.security.services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import org.npci.upi.security.services.CLRemoteService;
import org.npci.upi.security.services.CLResultReceiver;

/* loaded from: classes5.dex */
public class CLServices {
    private static final String PROVIDER_NAME = "org.npci.upi.security.pinactivitycomponent.clservices";

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f57684a = 0;
    private Context mContext;
    private ServiceConnectionStatusNotifier notifier;
    private static final Uri GET_CHALLENGE_URI = Uri.parse("content://org.npci.upi.security.pinactivitycomponent.clservices/getChallenge");
    private static final Uri REGISTER_APP_URI = Uri.parse("content://org.npci.upi.security.pinactivitycomponent.clservices/registerApp");
    private static final Uri GET_CREDENTIAL_URI = Uri.parse("content://org.npci.upi.security.pinactivitycomponent.clservices/getCredential");
    private static final Uri EXECUTE = Uri.parse("content://org.npci.upi.security.pinactivitycomponent.clservices/execute");
    private static final Uri GET_CREDENTIAL_INTENT_URI = Uri.parse("content://org.npci.upi.security.pinactivitycomponent.clservices/getCredentialIntent");
    private static CLServices clServices = null;
    private CLRemoteService clRemoteService = null;
    private ServiceConnection serviceConnection = new ServiceConnection() { // from class: org.npci.upi.security.services.CLServices.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            CLServices.this.clRemoteService = CLRemoteService.Stub.asInterface(iBinder);
            CLServices.this.notifier.serviceConnected(CLServices.clServices);
            Log.d("Remote Service", "Service Connected");
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            CLServices.this.clRemoteService = null;
            CLServices unused = CLServices.clServices = null;
            CLServices.this.notifier.serviceDisconnected();
            Log.d("Remote Service", "Service Disconnected");
        }
    };

    private CLServices(Context context, ServiceConnectionStatusNotifier serviceConnectionStatusNotifier) {
        this.mContext = context;
        this.notifier = serviceConnectionStatusNotifier;
        Intent intent = new Intent();
        intent.setAction("org.npci.upi.security.services.CLRemoteService");
        intent.setPackage(this.mContext.getPackageName());
        this.mContext.bindService(intent, this.serviceConnection, 1);
    }

    public static CLServices getClServicesInstance() {
        return clServices;
    }

    public static void initService(Context context, ServiceConnectionStatusNotifier serviceConnectionStatusNotifier) {
        if (clServices != null) {
            throw new RuntimeException("Service already initiated");
        }
        clServices = new CLServices(context, serviceConnectionStatusNotifier);
    }

    public void execute(String str) {
        Log.d(CLServices.class.getName(), "Common Library Callback Called");
        try {
            this.clRemoteService.execute(str);
        } catch (RemoteException unused) {
            Log.e("CLServices", "Remote Exception in Common Library Callback");
        }
    }

    public String getChallenge(String str, String str2) {
        Log.d(CLServices.class.getName(), "GetChallenge called");
        if (str == null || str.trim().isEmpty() || str2 == null || str2.trim().isEmpty()) {
            Log.d(CLServices.class.getName(), "In-sufficient arguments provided");
            return null;
        }
        try {
            return this.clRemoteService.getChallenge(str, str2);
        } catch (RemoteException unused) {
            Log.e("CLServerices", "RemoteException in getChallenge");
            return null;
        }
    }

    public void getCredential(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, CLRemoteResultReceiver cLRemoteResultReceiver) {
        Log.d(CLServices.class.getName(), "Get Credential called");
        try {
            this.clRemoteService.getCredential(str, str2, str3, str4, str5, str6, str7, str8, CLResultReceiver.Stub.asInterface(cLRemoteResultReceiver.getBinder()));
        } catch (RemoteException unused) {
            Log.e("CLServices", "Remote Exception in getCredential");
        }
    }

    public Intent getCredentialIntent(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, CLRemoteResultReceiver cLRemoteResultReceiver) {
        Log.d(CLServices.class.getName(), "Get Credential Intent called");
        try {
            return this.clRemoteService.getCredentialIntent(str, str2, str3, str4, str5, str6, str7, str8, CLResultReceiver.Stub.asInterface(cLRemoteResultReceiver.getBinder()));
        } catch (RemoteException unused) {
            Log.e("CLServices", "Remote Exception in getCredential Intent");
            return null;
        }
    }

    public String getUPILiteBalance(String str, String str2, String str3) {
        Log.d(CLServices.class.getName(), "getUPILiteBalance App called");
        try {
            return this.clRemoteService.getUPILiteBalance(str, str2, str3);
        } catch (RemoteException unused) {
            Log.e("CLServices", "Remote Exception in getUPILiteBalance");
            return "";
        }
    }

    public String isUpiLiteBound(String str, String str2, String str3) {
        Log.d(CLServices.class.getName(), "isUpiLiteBound App called");
        try {
            return this.clRemoteService.isUpiLiteBound(str, str2, str3);
        } catch (RemoteException unused) {
            Log.e("CLServices", "Remote Exception in isUpiLiteBound");
            return null;
        }
    }

    public boolean isUpiLiteSupported() {
        Log.d(CLServices.class.getName(), "isUpiLiteSupported App called");
        try {
            return this.clRemoteService.isUpiLiteSupported();
        } catch (RemoteException unused) {
            Log.e("CLServices", "Remote Exception in isUpiLiteSupported");
            return false;
        }
    }

    public boolean registerApp(String str, String str2, String str3, String str4, String str5) {
        Log.d(CLServices.class.getName(), "Register App called");
        if (str == null || str.trim().isEmpty() || str2 == null || str2.trim().isEmpty() || str3 == null || str3.trim().isEmpty() || str4 == null || str4.trim().isEmpty() || str5 == null || str4.trim().isEmpty()) {
            Log.d(CLServices.class.getName(), "In-sufficient arguments provided");
            return false;
        }
        try {
            return this.clRemoteService.registerApp(str, str2, str3, str4, str5);
        } catch (RemoteException unused) {
            Log.e("CLServices", "Remote Exception in registerApp");
            return false;
        }
    }

    public boolean registerUPILiteOnboarding(String str, String str2, String str3, String str4) {
        Log.d(CLServices.class.getName(), "registerUPILiteOnboarding App called");
        try {
            return this.clRemoteService.registerUPILiteOnboarding(str, str2, str3, str4);
        } catch (RemoteException unused) {
            Log.e("CLServices", "Remote Exception in registerUPILiteOnboarding");
            return false;
        }
    }

    public boolean registerUPILiteState(String str, String str2, String str3, String str4) {
        Log.d(CLServices.class.getName(), "registerUPILiteState App called");
        try {
            return this.clRemoteService.registerUPILiteState(str, str2, str3, str4);
        } catch (RemoteException unused) {
            Log.e("CLServices", "Remote Exception in registerUPILiteState");
            return false;
        }
    }

    public boolean unBindDevice(String str, String str2, String str3) {
        Log.d(CLServices.class.getName(), "unBindDevice App called");
        try {
            return this.clRemoteService.unBindDevice(str, str2, str3);
        } catch (RemoteException unused) {
            Log.e("CLServices", "Remote Exception in unBindDevice");
            return false;
        }
    }

    public void unbindService() {
        this.mContext.unbindService(this.serviceConnection);
    }
}
