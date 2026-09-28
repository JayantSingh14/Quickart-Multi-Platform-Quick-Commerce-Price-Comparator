package com.google.android.gms.iid;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.stats.ConnectionTracker;

/* loaded from: classes4.dex */
final class zzt implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public int f22568a;

    public final synchronized void a(String str) {
        try {
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                String strValueOf = String.valueOf(str);
                Log.d("MessengerIpcClient", strValueOf.length() != 0 ? "Disconnected: ".concat(strValueOf) : new String("Disconnected: "));
            }
            int i2 = this.f22568a;
            if (i2 == 0) {
                throw new IllegalStateException();
            }
            if (i2 == 1 || i2 == 2) {
                if (Log.isLoggable("MessengerIpcClient", 2)) {
                    Log.v("MessengerIpcClient", "Unbinding service");
                }
                this.f22568a = 4;
                ConnectionTracker.getInstance();
                throw null;
            }
            if (i2 == 3) {
                this.f22568a = 4;
            } else {
                if (i2 == 4) {
                    return;
                }
                int i3 = this.f22568a;
                StringBuilder sb = new StringBuilder(26);
                sb.append("Unknown state: ");
                sb.append(i3);
                throw new IllegalStateException(sb.toString());
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.content.ServiceConnection
    public final synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Service connected");
            }
            if (iBinder != null) {
                try {
                    new zzy(iBinder);
                    this.f22568a = 2;
                    throw null;
                } catch (RemoteException e2) {
                    a(e2.getMessage());
                    return;
                }
            }
            a("Null service connection");
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.content.ServiceConnection
    public final synchronized void onServiceDisconnected(ComponentName componentName) {
        try {
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Service disconnected");
            }
            a("Service disconnected");
        } catch (Throwable th) {
            throw th;
        }
    }
}
