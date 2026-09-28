package com.google.firebase.messaging;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayDeque;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
class WithinAppServiceConnection implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final Context f44805a;

    /* renamed from: b, reason: collision with root package name */
    public final Intent f44806b;

    /* renamed from: c, reason: collision with root package name */
    public final ScheduledThreadPoolExecutor f44807c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayDeque f44808d;

    /* renamed from: e, reason: collision with root package name */
    public WithinAppServiceBinder f44809e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f44810f;

    public static class BindRequest {

        /* renamed from: a, reason: collision with root package name */
        public final Intent f44811a;

        /* renamed from: b, reason: collision with root package name */
        public final TaskCompletionSource f44812b = new TaskCompletionSource();

        public BindRequest(Intent intent) {
            this.f44811a = intent;
        }
    }

    public WithinAppServiceConnection(Context context) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("Firebase-FirebaseInstanceIdServiceConnection"));
        scheduledThreadPoolExecutor.setKeepAliveTime(40L, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f44808d = new ArrayDeque();
        this.f44810f = false;
        Context applicationContext = context.getApplicationContext();
        this.f44805a = applicationContext;
        this.f44806b = new Intent("com.google.firebase.MESSAGING_EVENT").setPackage(applicationContext.getPackageName());
        this.f44807c = scheduledThreadPoolExecutor;
    }

    public final synchronized void a() {
        try {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "flush queue called");
            }
            while (!this.f44808d.isEmpty()) {
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    Log.d("FirebaseMessaging", "found intent to be delivered");
                }
                WithinAppServiceBinder withinAppServiceBinder = this.f44809e;
                if (withinAppServiceBinder == null || !withinAppServiceBinder.isBinderAlive()) {
                    c();
                    return;
                }
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    Log.d("FirebaseMessaging", "binder is alive, sending the intent.");
                }
                this.f44809e.a((BindRequest) this.f44808d.poll());
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized Task b(Intent intent) {
        BindRequest bindRequest;
        try {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "new intent queued in the bind-strategy delivery");
            }
            bindRequest = new BindRequest(intent);
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.f44807c;
            bindRequest.f44812b.f39750a.b(scheduledThreadPoolExecutor, new u(scheduledThreadPoolExecutor.schedule(new s(bindRequest, 1), 20L, TimeUnit.SECONDS), 2));
            this.f44808d.add(bindRequest);
            a();
        } catch (Throwable th) {
            throw th;
        }
        return bindRequest.f44812b.f39750a;
    }

    public final void c() {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            StringBuilder sb = new StringBuilder("binder is dead. start connection? ");
            sb.append(!this.f44810f);
            Log.d("FirebaseMessaging", sb.toString());
        }
        if (this.f44810f) {
            return;
        }
        this.f44810f = true;
        try {
        } catch (SecurityException e2) {
            Log.e("FirebaseMessaging", "Exception while binding the service", e2);
        }
        if (ConnectionTracker.getInstance().bindService(this.f44805a, this.f44806b, this, 65)) {
            return;
        }
        Log.e("FirebaseMessaging", "binding to the service failed");
        this.f44810f = false;
        while (true) {
            ArrayDeque arrayDeque = this.f44808d;
            if (arrayDeque.isEmpty()) {
                return;
            } else {
                ((BindRequest) arrayDeque.poll()).f44812b.d(null);
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "onServiceConnected: " + componentName);
            }
            this.f44810f = false;
            if (iBinder instanceof WithinAppServiceBinder) {
                this.f44809e = (WithinAppServiceBinder) iBinder;
                a();
                return;
            }
            Log.e("FirebaseMessaging", "Invalid service connection: " + iBinder);
            while (true) {
                ArrayDeque arrayDeque = this.f44808d;
                if (arrayDeque.isEmpty()) {
                    return;
                } else {
                    ((BindRequest) arrayDeque.poll()).f44812b.d(null);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "onServiceDisconnected: " + componentName);
        }
        a();
    }
}
