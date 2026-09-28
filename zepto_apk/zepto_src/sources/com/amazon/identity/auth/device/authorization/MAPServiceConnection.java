package com.amazon.identity.auth.device.authorization;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.amazon.android.apay.commonlibrary.commonlib.utils.InstrumentUtil;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.authorization.ThirdPartyServiceHelper;
import d.a;
import org.json.JSONException;

/* loaded from: classes3.dex */
public abstract class MAPServiceConnection<T> implements ServiceConnection {
    protected a mListener;
    protected IInterface mService = null;

    public abstract IInterface getServiceInterface(IBinder iBinder);

    public abstract Class<T> getServiceInterfaceClass();

    public boolean isValidService(IBinder iBinder) throws RemoteException {
        try {
            iBinder.getInterfaceDescriptor();
            getServiceInterfaceClass().getName();
            return iBinder.getInterfaceDescriptor().equals(getServiceInterfaceClass().getName());
        } catch (Exception e2) {
            e2.getMessage();
            return false;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) throws JSONException {
        if (isValidService(iBinder)) {
            IInterface serviceInterface = getServiceInterface(iBinder);
            this.mService = serviceInterface;
            ThirdPartyServiceHelper.a aVar = (ThirdPartyServiceHelper.a) this.mListener;
            InstrumentUtil.addMetricEvent("BoundServiceEstablished", "LWA_LITE_SDK.AUTHORIZE_WITH_SERVICE", aVar.f15185a, (String) null, (String) null);
            ThirdPartyServiceHelper.c cVar = aVar.f15186b;
            cVar.f15193b = serviceInterface;
            cVar.f15194c = aVar.f15187c;
            cVar.f15195d = aVar.f15188d;
            aVar.f15189e.countDown();
            return;
        }
        a aVar2 = this.mListener;
        AuthError authError = new AuthError("Returned service's interface doesn't match authorization service", AuthError.ERROR_TYPE.ERROR_UNKNOWN);
        ThirdPartyServiceHelper.a aVar3 = (ThirdPartyServiceHelper.a) aVar2;
        ThirdPartyServiceHelper.c cVar2 = aVar3.f15186b;
        cVar2.f15193b = null;
        cVar2.f15194c = null;
        cVar2.f15195d = null;
        authError.toString();
        aVar3.f15189e.countDown();
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.mService = null;
    }

    public void setServiceListener(a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("listener cannot be null!");
        }
        this.mListener = aVar;
    }
}
