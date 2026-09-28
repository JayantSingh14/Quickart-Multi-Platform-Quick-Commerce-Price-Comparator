package com.appsflyer.lvl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.android.vending.licensing.ILicenseResultListener;
import com.android.vending.licensing.ILicensingService;
import com.appsflyer.lvl.AppsFlyerLVL;

/* loaded from: classes.dex */
public class AppsFlyerLVLImpl implements ServiceConnection {
    private final long afNounce;
    private Context ctx;
    private ILicensingService lvlService;
    private final String packageName;
    private AppsFlyerLVL.resultListener resultListener;

    public class ResultListener extends ILicenseResultListener.Stub {
        public /* synthetic */ ResultListener(AppsFlyerLVLImpl appsFlyerLVLImpl, int i2) {
            this();
        }

        @Override // com.android.vending.licensing.ILicenseResultListener
        public void verifyLicense(int i2, String str, String str2) {
            AppsFlyerLVLImpl.this.resultListener.onLvlResult(str, str2);
        }

        private ResultListener() {
        }
    }

    public AppsFlyerLVLImpl(long j2, Context context, AppsFlyerLVL.resultListener resultlistener) {
        this.ctx = context;
        this.packageName = context.getPackageName();
        this.afNounce = j2;
        this.resultListener = resultlistener;
    }

    public void getLVLResult() {
        ILicensingService iLicensingService = this.lvlService;
        if (iLicensingService != null) {
            try {
                iLicensingService.E5(this.afNounce, this.packageName, new ResultListener(this, 0));
                return;
            } catch (RemoteException e2) {
                this.resultListener.onLvlFailure(e2);
                return;
            }
        }
        try {
            if (this.ctx.bindService(new Intent("com.android.vending.licensing.ILicensingService").setPackage("com.android.vending"), this, 1)) {
                return;
            }
            this.resultListener.onLvlFailure(new Exception("LVLException: could not bind service"));
        } catch (SecurityException e3) {
            this.resultListener.onLvlFailure(e3);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ILicensingService iLicensingServiceG = ILicensingService.Stub.g(iBinder);
        this.lvlService = iLicensingServiceG;
        try {
            iLicensingServiceG.E5(this.afNounce, this.packageName, new ResultListener(this, 0));
        } catch (RemoteException e2) {
            this.resultListener.onLvlFailure(e2);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.lvlService = null;
    }
}
