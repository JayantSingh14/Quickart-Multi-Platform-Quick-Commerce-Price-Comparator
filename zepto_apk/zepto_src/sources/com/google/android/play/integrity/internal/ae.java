package com.google.android.play.integrity.internal;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public final class ae {
    public static final HashMap o = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public final Context f42156a;

    /* renamed from: b, reason: collision with root package name */
    public final s f42157b;

    /* renamed from: c, reason: collision with root package name */
    public final String f42158c;

    /* renamed from: g, reason: collision with root package name */
    public boolean f42162g;

    /* renamed from: h, reason: collision with root package name */
    public final Intent f42163h;

    /* renamed from: i, reason: collision with root package name */
    public final z f42164i;

    /* renamed from: m, reason: collision with root package name */
    public ServiceConnection f42168m;
    public IInterface n;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f42159d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public final HashSet f42160e = new HashSet();

    /* renamed from: f, reason: collision with root package name */
    public final Object f42161f = new Object();

    /* renamed from: k, reason: collision with root package name */
    public final u f42166k = new IBinder.DeathRecipient() { // from class: com.google.android.play.integrity.internal.u
        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            ae aeVar = this.f42196a;
            aeVar.f42157b.b("reportBinderDeath", new Object[0]);
            y yVar = (y) aeVar.f42165j.get();
            if (yVar != null) {
                aeVar.f42157b.b("calling onBinderDied", new Object[0]);
                yVar.a();
            } else {
                aeVar.f42157b.b("%s : Binder has died.", aeVar.f42158c);
                Iterator it = aeVar.f42159d.iterator();
                while (it.hasNext()) {
                    ((t) it.next()).a(new RemoteException(String.valueOf(aeVar.f42158c).concat(" : Binder has died.")));
                }
                aeVar.f42159d.clear();
            }
            synchronized (aeVar.f42161f) {
                aeVar.e();
            }
        }
    };

    /* renamed from: l, reason: collision with root package name */
    public final AtomicInteger f42167l = new AtomicInteger(0);

    /* renamed from: j, reason: collision with root package name */
    public final WeakReference f42165j = new WeakReference(null);

    /* JADX WARN: Type inference failed for: r0v3, types: [com.google.android.play.integrity.internal.u] */
    public ae(Context context, s sVar, String str, Intent intent, z zVar) {
        this.f42156a = context;
        this.f42157b = sVar;
        this.f42158c = str;
        this.f42163h = intent;
        this.f42164i = zVar;
    }

    public static /* bridge */ /* synthetic */ void b(ae aeVar, t tVar) {
        IInterface iInterface = aeVar.n;
        ArrayList arrayList = aeVar.f42159d;
        s sVar = aeVar.f42157b;
        if (iInterface != null || aeVar.f42162g) {
            if (!aeVar.f42162g) {
                tVar.run();
                return;
            } else {
                sVar.b("Waiting to bind to the service.", new Object[0]);
                arrayList.add(tVar);
                return;
            }
        }
        sVar.b("Initiate binding to the service.", new Object[0]);
        arrayList.add(tVar);
        ad adVar = new ad(aeVar);
        aeVar.f42168m = adVar;
        aeVar.f42162g = true;
        if (aeVar.f42156a.bindService(aeVar.f42163h, adVar, 1)) {
            return;
        }
        sVar.b("Failed to bind to the service.", new Object[0]);
        aeVar.f42162g = false;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((t) it.next()).a(new af());
        }
        arrayList.clear();
    }

    public final Handler a() {
        Handler handler;
        HashMap map = o;
        synchronized (map) {
            try {
                if (!map.containsKey(this.f42158c)) {
                    HandlerThread handlerThread = new HandlerThread(this.f42158c, 10);
                    handlerThread.start();
                    map.put(this.f42158c, new Handler(handlerThread.getLooper()));
                }
                handler = (Handler) map.get(this.f42158c);
            } catch (Throwable th) {
                throw th;
            }
        }
        return handler;
    }

    public final void c(t tVar, TaskCompletionSource taskCompletionSource) {
        a().post(new w(this, tVar.f42195a, taskCompletionSource, tVar));
    }

    public final void d(TaskCompletionSource taskCompletionSource) {
        synchronized (this.f42161f) {
            this.f42160e.remove(taskCompletionSource);
        }
        a().post(new x(this));
    }

    public final void e() {
        HashSet hashSet = this.f42160e;
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((TaskCompletionSource) it.next()).c(new RemoteException(String.valueOf(this.f42158c).concat(" : Binder has died.")));
        }
        hashSet.clear();
    }
}
