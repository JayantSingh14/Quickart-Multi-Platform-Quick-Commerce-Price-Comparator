package com.google.android.gms.cloudmessaging;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
final class zzp implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public int f22271a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final Messenger f22272b;

    /* renamed from: c, reason: collision with root package name */
    public zzq f22273c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayDeque f22274d;

    /* renamed from: e, reason: collision with root package name */
    public final SparseArray f22275e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ zzv f22276f;

    public zzp(zzv zzvVar) {
        this.f22276f = zzvVar;
        com.google.android.gms.internal.cloudmessaging.zzf zzfVar = new com.google.android.gms.internal.cloudmessaging.zzf(Looper.getMainLooper(), new Handler.Callback() { // from class: com.google.android.gms.cloudmessaging.zzm
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                int i2 = message.arg1;
                if (Log.isLoggable("MessengerIpcClient", 3)) {
                    Log.d("MessengerIpcClient", "Received response to request: " + i2);
                }
                zzp zzpVar = this.f22268a;
                synchronized (zzpVar) {
                    try {
                        zzs zzsVar = (zzs) zzpVar.f22275e.get(i2);
                        if (zzsVar == null) {
                            Log.w("MessengerIpcClient", "Received response for unknown request: " + i2);
                            return true;
                        }
                        zzpVar.f22275e.remove(i2);
                        zzpVar.c();
                        Bundle data = message.getData();
                        if (data.getBoolean("unsupported", false)) {
                            zzsVar.c(new zzt("Not supported by GmsCore", null));
                            return true;
                        }
                        zzsVar.a(data);
                        return true;
                    } finally {
                    }
                }
            }
        });
        Looper.getMainLooper();
        this.f22272b = new Messenger(zzfVar);
        this.f22274d = new ArrayDeque();
        this.f22275e = new SparseArray();
    }

    public final synchronized void a(String str) {
        b(str, null);
    }

    public final synchronized void b(String str, SecurityException securityException) {
        try {
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                Log.d("MessengerIpcClient", "Disconnected: ".concat(String.valueOf(str)));
            }
            int i2 = this.f22271a;
            if (i2 == 0) {
                throw new IllegalStateException();
            }
            if (i2 != 1 && i2 != 2) {
                if (i2 != 3) {
                    return;
                }
                this.f22271a = 4;
                return;
            }
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Unbinding service");
            }
            this.f22271a = 4;
            ConnectionTracker.getInstance().unbindService(this.f22276f.f22284a, this);
            zzt zztVar = new zzt(str, securityException);
            Iterator it = this.f22274d.iterator();
            while (it.hasNext()) {
                ((zzs) it.next()).c(zztVar);
            }
            this.f22274d.clear();
            for (int i3 = 0; i3 < this.f22275e.size(); i3++) {
                ((zzs) this.f22275e.valueAt(i3)).c(zztVar);
            }
            this.f22275e.clear();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void c() {
        try {
            if (this.f22271a == 2 && this.f22274d.isEmpty() && this.f22275e.size() == 0) {
                if (Log.isLoggable("MessengerIpcClient", 2)) {
                    Log.v("MessengerIpcClient", "Finished handling requests, unbinding");
                }
                this.f22271a = 3;
                ConnectionTracker.getInstance().unbindService(this.f22276f.f22284a, this);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized boolean d(zzs zzsVar) {
        int i2 = this.f22271a;
        if (i2 != 0) {
            if (i2 == 1) {
                this.f22274d.add(zzsVar);
                return true;
            }
            if (i2 != 2) {
                return false;
            }
            this.f22274d.add(zzsVar);
            this.f22276f.f22285b.execute(new zzj(this));
            return true;
        }
        this.f22274d.add(zzsVar);
        Preconditions.checkState(this.f22271a == 0);
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Starting bind to GmsCore");
        }
        this.f22271a = 1;
        Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
        intent.setPackage("com.google.android.gms");
        try {
            if (ConnectionTracker.getInstance().bindService(this.f22276f.f22284a, intent, this, 1)) {
                this.f22276f.f22285b.schedule(new Runnable() { // from class: com.google.android.gms.cloudmessaging.zzk
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzp zzpVar = this.f22266a;
                        synchronized (zzpVar) {
                            if (zzpVar.f22271a == 1) {
                                zzpVar.a("Timed out while binding");
                            }
                        }
                    }
                }, 30L, TimeUnit.SECONDS);
            } else {
                a("Unable to bind to service");
            }
        } catch (SecurityException e2) {
            b("Unable to bind to service", e2);
        }
        return true;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service connected");
        }
        this.f22276f.f22285b.execute(new Runnable() { // from class: com.google.android.gms.cloudmessaging.zzi
            @Override // java.lang.Runnable
            public final void run() {
                zzp zzpVar = this.f22263a;
                IBinder iBinder2 = iBinder;
                synchronized (zzpVar) {
                    if (iBinder2 == null) {
                        zzpVar.a("Null service connection");
                        return;
                    }
                    try {
                        zzpVar.f22273c = new zzq(iBinder2);
                        zzpVar.f22271a = 2;
                        zzpVar.f22276f.f22285b.execute(new zzj(zzpVar));
                    } catch (RemoteException e2) {
                        zzpVar.a(e2.getMessage());
                    }
                }
            }
        });
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service disconnected");
        }
        this.f22276f.f22285b.execute(new Runnable() { // from class: com.google.android.gms.cloudmessaging.zzl
            @Override // java.lang.Runnable
            public final void run() {
                this.f22267a.a("Service disconnected");
            }
        });
    }
}
