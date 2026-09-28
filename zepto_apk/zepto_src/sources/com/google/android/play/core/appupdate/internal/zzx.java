package com.google.android.play.core.appupdate.internal;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public final class zzx {
    public static final HashMap n = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public final Context f41700a;

    /* renamed from: b, reason: collision with root package name */
    public final zzm f41701b;

    /* renamed from: g, reason: collision with root package name */
    public boolean f41706g;

    /* renamed from: h, reason: collision with root package name */
    public final Intent f41707h;

    /* renamed from: l, reason: collision with root package name */
    public ServiceConnection f41711l;

    /* renamed from: m, reason: collision with root package name */
    public zzf f41712m;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f41703d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public final HashSet f41704e = new HashSet();

    /* renamed from: f, reason: collision with root package name */
    public final Object f41705f = new Object();

    /* renamed from: j, reason: collision with root package name */
    public final zzp f41709j = new IBinder.DeathRecipient() { // from class: com.google.android.play.core.appupdate.internal.zzp
        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            zzx zzxVar = this.f41691a;
            zzxVar.f41701b.c("reportBinderDeath", new Object[0]);
            zzs zzsVar = (zzs) zzxVar.f41708i.get();
            if (zzsVar != null) {
                zzxVar.f41701b.c("calling onBinderDied", new Object[0]);
                zzsVar.zza();
            } else {
                zzxVar.f41701b.c("%s : Binder has died.", zzxVar.f41702c);
                Iterator it = zzxVar.f41703d.iterator();
                while (it.hasNext()) {
                    zzn zznVar = (zzn) it.next();
                    RemoteException remoteException = new RemoteException(String.valueOf(zzxVar.f41702c).concat(" : Binder has died."));
                    TaskCompletionSource taskCompletionSource = zznVar.f41688a;
                    if (taskCompletionSource != null) {
                        taskCompletionSource.c(remoteException);
                    }
                }
                zzxVar.f41703d.clear();
            }
            synchronized (zzxVar.f41705f) {
                zzxVar.e();
            }
        }
    };

    /* renamed from: k, reason: collision with root package name */
    public final AtomicInteger f41710k = new AtomicInteger(0);

    /* renamed from: c, reason: collision with root package name */
    public final String f41702c = "AppUpdateService";

    /* renamed from: i, reason: collision with root package name */
    public final WeakReference f41708i = new WeakReference(null);

    /* JADX WARN: Type inference failed for: r0v3, types: [com.google.android.play.core.appupdate.internal.zzp] */
    public zzx(Context context, zzm zzmVar, Intent intent) {
        this.f41700a = context;
        this.f41701b = zzmVar;
        this.f41707h = intent;
    }

    public static void b(zzx zzxVar, zzn zznVar) {
        zzf zzfVar = zzxVar.f41712m;
        ArrayList arrayList = zzxVar.f41703d;
        zzm zzmVar = zzxVar.f41701b;
        if (zzfVar != null || zzxVar.f41706g) {
            if (!zzxVar.f41706g) {
                zznVar.run();
                return;
            } else {
                zzmVar.c("Waiting to bind to the service.", new Object[0]);
                arrayList.add(zznVar);
                return;
            }
        }
        zzmVar.c("Initiate binding to the service.", new Object[0]);
        arrayList.add(zznVar);
        zzw zzwVar = new zzw(zzxVar);
        zzxVar.f41711l = zzwVar;
        zzxVar.f41706g = true;
        if (zzxVar.f41700a.bindService(zzxVar.f41707h, zzwVar, 1)) {
            return;
        }
        zzmVar.c("Failed to bind to the service.", new Object[0]);
        zzxVar.f41706g = false;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            zzn zznVar2 = (zzn) it.next();
            zzy zzyVar = new zzy();
            TaskCompletionSource taskCompletionSource = zznVar2.f41688a;
            if (taskCompletionSource != null) {
                taskCompletionSource.c(zzyVar);
            }
        }
        arrayList.clear();
    }

    public final Handler a() {
        Handler handler;
        HashMap map = n;
        synchronized (map) {
            try {
                if (!map.containsKey(this.f41702c)) {
                    HandlerThread handlerThread = new HandlerThread(this.f41702c, 10);
                    handlerThread.start();
                    map.put(this.f41702c, new Handler(handlerThread.getLooper()));
                }
                handler = (Handler) map.get(this.f41702c);
            } catch (Throwable th) {
                throw th;
            }
        }
        return handler;
    }

    public final void c(zzn zznVar, TaskCompletionSource taskCompletionSource) {
        a().post(new zzq(this, zznVar.f41688a, taskCompletionSource, zznVar));
    }

    public final void d(TaskCompletionSource taskCompletionSource) {
        synchronized (this.f41705f) {
            this.f41704e.remove(taskCompletionSource);
        }
        a().post(new zzr(this));
    }

    public final void e() {
        HashSet hashSet = this.f41704e;
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((TaskCompletionSource) it.next()).c(new RemoteException(String.valueOf(this.f41702c).concat(" : Binder has died.")));
        }
        hashSet.clear();
    }
}
