package in.juspay.hypersdk.core;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import in.juspay.hyper.constants.Labels;

/* loaded from: classes4.dex */
class GodelServiceConnection implements ServiceConnection {
    private static final String TAG = "GodelServiceConnection";
    private final JuspayServices juspayServices;
    boolean isBound = false;
    private Messenger messenger = null;
    private Message pendingMsg = null;

    public GodelServiceConnection(JuspayServices juspayServices) {
        this.juspayServices = juspayServices;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        SdkTracker sdkTracker = this.juspayServices.getSdkTracker();
        try {
            sdkTracker.trackAction("system", "info", Labels.System.GODEL_SERVICE_CONNECTION, "gsc_on_service_connected", "Successfully connected to " + componentName.getPackageName() + "/" + componentName.getClassName());
            this.messenger = new Messenger(iBinder);
            this.isBound = true;
            request(this.pendingMsg);
        } catch (Exception e2) {
            sdkTracker.trackAndLogException(TAG, "action", "system", Labels.System.MPIN_UTIL, "Exception while trying to send message", e2);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.messenger = null;
        this.isBound = false;
    }

    public void request(int i2, Bundle bundle, Handler handler) throws RemoteException {
        this.juspayServices.getSdkTracker().trackAction("system", "info", Labels.System.GODEL_SERVICE_CONNECTION, "gsc_request", "Sending request to MPIN SDK");
        Message messageObtain = Message.obtain((Handler) null, i2);
        messageObtain.setData(bundle);
        messageObtain.replyTo = new Messenger(handler);
        request(messageObtain);
    }

    public void request(Message message) throws RemoteException {
        if (this.isBound) {
            this.messenger.send(message);
        } else {
            this.pendingMsg = message;
        }
    }
}
