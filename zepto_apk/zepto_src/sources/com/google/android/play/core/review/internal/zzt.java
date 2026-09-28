package com.google.android.play.core.review.internal;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public final class zzt {
    public static final HashMap n = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public final Context f41869a;

    /* renamed from: b, reason: collision with root package name */
    public final zzi f41870b;

    /* renamed from: g, reason: collision with root package name */
    public boolean f41875g;

    /* renamed from: h, reason: collision with root package name */
    public final Intent f41876h;

    /* renamed from: l, reason: collision with root package name */
    public ServiceConnection f41880l;

    /* renamed from: m, reason: collision with root package name */
    public zzf f41881m;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f41872d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public final HashSet f41873e = new HashSet();

    /* renamed from: f, reason: collision with root package name */
    public final Object f41874f = new Object();

    /* renamed from: j, reason: collision with root package name */
    public final zzl f41878j = new IBinder.DeathRecipient() { // from class: com.google.android.play.core.review.internal.zzl
        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            zzt zztVar = this.f41861a;
            zztVar.f41870b.a("reportBinderDeath", new Object[0]);
            zzo zzoVar = (zzo) zztVar.f41877i.get();
            zzi zziVar = zztVar.f41870b;
            if (zzoVar != null) {
                zziVar.a("calling onBinderDied", new Object[0]);
                zzoVar.zza();
            } else {
                String str = zztVar.f41871c;
                zziVar.a("%s : Binder has died.", str);
                ArrayList arrayList = zztVar.f41872d;
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    zzj zzjVar = (zzj) it.next();
                    RemoteException remoteException = new RemoteException(String.valueOf(str).concat(" : Binder has died."));
                    TaskCompletionSource taskCompletionSource = zzjVar.f41858a;
                    if (taskCompletionSource != null) {
                        taskCompletionSource.c(remoteException);
                    }
                }
                arrayList.clear();
            }
            zztVar.d();
        }
    };

    /* renamed from: k, reason: collision with root package name */
    public final AtomicInteger f41879k = new AtomicInteger(0);

    /* renamed from: c, reason: collision with root package name */
    public final String f41871c = "com.google.android.finsky.inappreviewservice.InAppReviewService";

    /* renamed from: i, reason: collision with root package name */
    public final WeakReference f41877i = new WeakReference(null);

    /* JADX WARN: Type inference failed for: r0v3, types: [com.google.android.play.core.review.internal.zzl] */
    public zzt(Context context, zzi zziVar, Intent intent) {
        this.f41869a = context;
        this.f41870b = zziVar;
        this.f41876h = intent;
    }

    public final Handler a() {
        Handler handler;
        HashMap map = n;
        synchronized (map) {
            try {
                if (!map.containsKey(this.f41871c)) {
                    HandlerThread handlerThread = new HandlerThread(this.f41871c, 10);
                    handlerThread.start();
                    map.put(this.f41871c, new Handler(handlerThread.getLooper()));
                }
                handler = (Handler) map.get(this.f41871c);
            } catch (Throwable th) {
                throw th;
            }
        }
        return handler;
    }

    public final void b(zzj zzjVar, final TaskCompletionSource taskCompletionSource) {
        synchronized (this.f41874f) {
            this.f41873e.add(taskCompletionSource);
            taskCompletionSource.f39750a.addOnCompleteListener(new OnCompleteListener() { // from class: com.google.android.play.core.review.internal.zzk
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    zzt zztVar = this.f41859a;
                    TaskCompletionSource taskCompletionSource2 = taskCompletionSource;
                    synchronized (zztVar.f41874f) {
                        zztVar.f41873e.remove(taskCompletionSource2);
                    }
                }
            });
        }
        synchronized (this.f41874f) {
            try {
                if (this.f41879k.getAndIncrement() > 0) {
                    zzi zziVar = this.f41870b;
                    Object[] objArr = new Object[0];
                    zziVar.getClass();
                    if (Log.isLoggable("PlayCore", 3)) {
                        Log.d("PlayCore", zzi.b(zziVar.f41857a, "Already connected to the service.", objArr));
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        a().post(new zzm(this, zzjVar.f41858a, zzjVar));
    }

    public final void c(TaskCompletionSource taskCompletionSource) {
        synchronized (this.f41874f) {
            this.f41873e.remove(taskCompletionSource);
        }
        synchronized (this.f41874f) {
            try {
                if (this.f41879k.get() > 0 && this.f41879k.decrementAndGet() > 0) {
                    this.f41870b.a("Leaving the connection open for other ongoing calls.", new Object[0]);
                } else {
                    a().post(new zzn(this));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d() {
        synchronized (this.f41874f) {
            try {
                Iterator it = this.f41873e.iterator();
                while (it.hasNext()) {
                    ((TaskCompletionSource) it.next()).c(new RemoteException(String.valueOf(this.f41871c).concat(" : Binder has died.")));
                }
                this.f41873e.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
