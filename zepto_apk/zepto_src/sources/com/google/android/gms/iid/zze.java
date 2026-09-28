package com.google.android.gms.iid;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import java.util.concurrent.ExecutorService;

/* loaded from: classes4.dex */
public abstract class zze extends Service {

    /* renamed from: b, reason: collision with root package name */
    public zzi f22561b;

    /* renamed from: d, reason: collision with root package name */
    public int f22563d;

    /* renamed from: a, reason: collision with root package name */
    public final ExecutorService f22560a = com.google.android.gms.internal.gcm.zzg.f36615a.a(new NamedThreadFactory("EnhancedIntentService"));

    /* renamed from: c, reason: collision with root package name */
    public final Object f22562c = new Object();

    /* renamed from: e, reason: collision with root package name */
    public int f22564e = 0;

    public abstract void a(Intent intent);

    public final void b(Intent intent) {
        if (intent != null) {
            WakefulBroadcastReceiver.a(intent);
        }
        synchronized (this.f22562c) {
            try {
                int i2 = this.f22564e - 1;
                this.f22564e = i2;
                if (i2 == 0) {
                    stopSelfResult(this.f22563d);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.app.Service
    public final synchronized IBinder onBind(Intent intent) {
        try {
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                Log.d("EnhancedIntentService", "Service received bind request");
            }
            if (this.f22561b == null) {
                this.f22561b = new zzi();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f22561b;
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i2, int i3) {
        synchronized (this.f22562c) {
            this.f22563d = i3;
            this.f22564e++;
        }
        if (intent == null) {
            b(intent);
            return 2;
        }
        this.f22560a.execute(new zzf(this, intent, intent));
        return 3;
    }
}
