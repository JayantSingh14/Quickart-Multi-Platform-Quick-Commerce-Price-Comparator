package com.google.android.play.core.splitinstall.internal;

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
public final class zzaf {
    public static final HashMap n = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public final Context f41940a;

    /* renamed from: b, reason: collision with root package name */
    public final zzu f41941b;

    /* renamed from: g, reason: collision with root package name */
    public boolean f41946g;

    /* renamed from: h, reason: collision with root package name */
    public final Intent f41947h;

    /* renamed from: l, reason: collision with root package name */
    public ServiceConnection f41951l;

    /* renamed from: m, reason: collision with root package name */
    public zzbo f41952m;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f41943d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public final HashSet f41944e = new HashSet();

    /* renamed from: f, reason: collision with root package name */
    public final Object f41945f = new Object();

    /* renamed from: j, reason: collision with root package name */
    public final zzx f41949j = new IBinder.DeathRecipient() { // from class: com.google.android.play.core.splitinstall.internal.zzx
        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            zzaf zzafVar = this.f42002a;
            zzafVar.f41941b.d("reportBinderDeath", new Object[0]);
            zzaa zzaaVar = (zzaa) zzafVar.f41948i.get();
            if (zzaaVar != null) {
                zzafVar.f41941b.d("calling onBinderDied", new Object[0]);
                zzaaVar.zza();
            } else {
                zzafVar.f41941b.d("%s : Binder has died.", zzafVar.f41942c);
                Iterator it = zzafVar.f41943d.iterator();
                while (it.hasNext()) {
                    zzv zzvVar = (zzv) it.next();
                    RemoteException remoteException = new RemoteException(String.valueOf(zzafVar.f41942c).concat(" : Binder has died."));
                    TaskCompletionSource taskCompletionSource = zzvVar.f41999a;
                    if (taskCompletionSource != null) {
                        taskCompletionSource.c(remoteException);
                    }
                }
                zzafVar.f41943d.clear();
            }
            synchronized (zzafVar.f41945f) {
                zzafVar.e();
            }
        }
    };

    /* renamed from: k, reason: collision with root package name */
    public final AtomicInteger f41950k = new AtomicInteger(0);

    /* renamed from: c, reason: collision with root package name */
    public final String f41942c = "SplitInstallService";

    /* renamed from: i, reason: collision with root package name */
    public final WeakReference f41948i = new WeakReference(null);

    /* JADX WARN: Type inference failed for: r0v3, types: [com.google.android.play.core.splitinstall.internal.zzx] */
    public zzaf(Context context, zzu zzuVar, Intent intent) {
        this.f41940a = context;
        this.f41941b = zzuVar;
        this.f41947h = intent;
    }

    public static void b(zzaf zzafVar, zzv zzvVar) {
        zzbo zzboVar = zzafVar.f41952m;
        ArrayList arrayList = zzafVar.f41943d;
        zzu zzuVar = zzafVar.f41941b;
        if (zzboVar != null || zzafVar.f41946g) {
            if (!zzafVar.f41946g) {
                zzvVar.run();
                return;
            } else {
                zzuVar.d("Waiting to bind to the service.", new Object[0]);
                arrayList.add(zzvVar);
                return;
            }
        }
        zzuVar.d("Initiate binding to the service.", new Object[0]);
        arrayList.add(zzvVar);
        zzae zzaeVar = new zzae(zzafVar);
        zzafVar.f41951l = zzaeVar;
        zzafVar.f41946g = true;
        if (zzafVar.f41940a.bindService(zzafVar.f41947h, zzaeVar, 1)) {
            return;
        }
        zzuVar.d("Failed to bind to the service.", new Object[0]);
        zzafVar.f41946g = false;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            zzv zzvVar2 = (zzv) it.next();
            zzag zzagVar = new zzag();
            TaskCompletionSource taskCompletionSource = zzvVar2.f41999a;
            if (taskCompletionSource != null) {
                taskCompletionSource.c(zzagVar);
            }
        }
        arrayList.clear();
    }

    public final Handler a() {
        Handler handler;
        HashMap map = n;
        synchronized (map) {
            try {
                if (!map.containsKey(this.f41942c)) {
                    HandlerThread handlerThread = new HandlerThread(this.f41942c, 10);
                    handlerThread.start();
                    map.put(this.f41942c, new Handler(handlerThread.getLooper()));
                }
                handler = (Handler) map.get(this.f41942c);
            } catch (Throwable th) {
                throw th;
            }
        }
        return handler;
    }

    public final void c(zzv zzvVar, TaskCompletionSource taskCompletionSource) {
        a().post(new zzy(this, zzvVar.f41999a, taskCompletionSource, zzvVar));
    }

    public final void d(TaskCompletionSource taskCompletionSource) {
        synchronized (this.f41945f) {
            this.f41944e.remove(taskCompletionSource);
        }
        a().post(new zzz(this));
    }

    public final void e() {
        HashSet hashSet = this.f41944e;
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((TaskCompletionSource) it.next()).c(new RemoteException(String.valueOf(this.f41942c).concat(" : Binder has died.")));
        }
        hashSet.clear();
    }
}
