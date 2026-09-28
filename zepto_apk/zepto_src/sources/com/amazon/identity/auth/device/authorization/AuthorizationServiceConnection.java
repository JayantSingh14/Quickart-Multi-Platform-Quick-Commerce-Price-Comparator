package com.amazon.identity.auth.device.authorization;

import android.os.IBinder;
import android.os.IInterface;
import com.amazon.identity.auth.device.authorization.AmazonAuthorizationServiceInterface;

/* loaded from: classes3.dex */
public class AuthorizationServiceConnection extends MAPServiceConnection<AmazonAuthorizationServiceInterface> {
    @Override // com.amazon.identity.auth.device.authorization.MAPServiceConnection
    public IInterface getServiceInterface(IBinder iBinder) {
        int i2 = AmazonAuthorizationServiceInterface.Stub.f15131a;
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(AmazonAuthorizationServiceInterface.DESCRIPTOR);
        return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof AmazonAuthorizationServiceInterface)) ? new AmazonAuthorizationServiceInterface.Stub.a(iBinder) : (AmazonAuthorizationServiceInterface) iInterfaceQueryLocalInterface;
    }

    @Override // com.amazon.identity.auth.device.authorization.MAPServiceConnection
    public Class<AmazonAuthorizationServiceInterface> getServiceInterfaceClass() {
        return AmazonAuthorizationServiceInterface.class;
    }
}
