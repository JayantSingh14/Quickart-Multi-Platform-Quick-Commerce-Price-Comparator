package com.google.android.gms.iid;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;

/* loaded from: classes4.dex */
public final class zzk implements ServiceConnection {
    public final synchronized void a() {
        try {
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                Log.d("EnhancedIntentService", "flush queue called");
            }
            throw null;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this) {
            try {
                if (Log.isLoggable("EnhancedIntentService", 3)) {
                    String strValueOf = String.valueOf(componentName);
                    StringBuilder sb = new StringBuilder(strValueOf.length() + 20);
                    sb.append("onServiceConnected: ");
                    sb.append(strValueOf);
                    Log.d("EnhancedIntentService", sb.toString());
                }
                if (iBinder == null) {
                    Log.e("EnhancedIntentService", "Null service connection");
                    throw null;
                }
                a();
                throw null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            String strValueOf = String.valueOf(componentName);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 23);
            sb.append("onServiceDisconnected: ");
            sb.append(strValueOf);
            Log.d("EnhancedIntentService", sb.toString());
        }
        a();
        throw null;
    }
}
