package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.IntentFilter;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public final class zzep {

    /* renamed from: f, reason: collision with root package name */
    public static zzep f30015f;

    /* renamed from: a, reason: collision with root package name */
    public final Executor f30016a;

    /* renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList f30017b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f30018c;

    /* renamed from: d, reason: collision with root package name */
    public int f30019d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f30020e;

    public zzep(final Context context) {
        Executor executorA = zzdh.a();
        this.f30016a = executorA;
        this.f30017b = new CopyOnWriteArrayList();
        this.f30018c = new Object();
        this.f30019d = 0;
        executorA.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzem
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                context.registerReceiver(new zzeo(this.f29694a), intentFilter);
            }
        });
    }

    public static synchronized zzep a(Context context) {
        try {
            if (f30015f == null) {
                f30015f = new zzep(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f30015f;
    }

    public final int b() {
        int i2;
        synchronized (this.f30018c) {
            i2 = this.f30019d;
        }
        return i2;
    }

    public final void c(int i2) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f30017b;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            zzel zzelVar = (zzel) it.next();
            if (zzelVar.f29595a.get() == null) {
                copyOnWriteArrayList.remove(zzelVar);
            }
        }
        synchronized (this.f30018c) {
            try {
                if (this.f30020e && this.f30019d == i2) {
                    return;
                }
                this.f30020e = true;
                this.f30019d = i2;
                Iterator it2 = this.f30017b.iterator();
                while (it2.hasNext()) {
                    zzel zzelVar2 = (zzel) it2.next();
                    zzelVar2.getClass();
                    zzelVar2.f29596b.execute(new zzek(zzelVar2));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
