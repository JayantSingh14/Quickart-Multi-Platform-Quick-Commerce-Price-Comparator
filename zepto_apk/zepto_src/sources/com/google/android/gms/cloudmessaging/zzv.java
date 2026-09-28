package com.google.android.gms.cloudmessaging;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public final class zzv {

    /* renamed from: e, reason: collision with root package name */
    public static zzv f22283e;

    /* renamed from: a, reason: collision with root package name */
    public final Context f22284a;

    /* renamed from: b, reason: collision with root package name */
    public final ScheduledExecutorService f22285b;

    /* renamed from: c, reason: collision with root package name */
    public zzp f22286c = new zzp(this);

    /* renamed from: d, reason: collision with root package name */
    public int f22287d = 1;

    public zzv(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.f22285b = scheduledExecutorService;
        this.f22284a = context.getApplicationContext();
    }

    public static synchronized zzv a(Context context) {
        try {
            if (f22283e == null) {
                f22283e = new zzv(context, Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1, new NamedThreadFactory("MessengerIpcClient"))));
            }
        } catch (Throwable th) {
            throw th;
        }
        return f22283e;
    }

    public final Task b(int i2, Bundle bundle) {
        int i3;
        synchronized (this) {
            i3 = this.f22287d;
            this.f22287d = i3 + 1;
        }
        return d(new zzr(i3, i2, bundle));
    }

    public final Task c(int i2, Bundle bundle) {
        int i3;
        synchronized (this) {
            i3 = this.f22287d;
            this.f22287d = i3 + 1;
        }
        return d(new zzu(i3, i2, bundle));
    }

    public final synchronized Task d(zzs zzsVar) {
        try {
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                Log.d("MessengerIpcClient", "Queueing ".concat(zzsVar.toString()));
            }
            if (!this.f22286c.d(zzsVar)) {
                zzp zzpVar = new zzp(this);
                this.f22286c = zzpVar;
                zzpVar.d(zzsVar);
            }
        } catch (Throwable th) {
            throw th;
        }
        return zzsVar.f22280b.f39750a;
    }
}
