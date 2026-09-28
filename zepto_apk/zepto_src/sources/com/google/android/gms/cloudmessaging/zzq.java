package com.google.android.gms.cloudmessaging;

import android.os.IBinder;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzq {

    /* renamed from: a, reason: collision with root package name */
    public final Messenger f22277a;

    /* renamed from: b, reason: collision with root package name */
    public final zzd f22278b;

    public zzq(IBinder iBinder) throws RemoteException {
        String interfaceDescriptor = iBinder.getInterfaceDescriptor();
        if (Objects.equals(interfaceDescriptor, "android.os.IMessenger")) {
            this.f22277a = new Messenger(iBinder);
            this.f22278b = null;
        } else {
            if (!Objects.equals(interfaceDescriptor, "com.google.android.gms.iid.IMessengerCompat")) {
                Log.w("MessengerIpcClient", "Invalid interface descriptor: ".concat(String.valueOf(interfaceDescriptor)));
                throw new RemoteException();
            }
            this.f22278b = new zzd(iBinder);
            this.f22277a = null;
        }
    }
}
