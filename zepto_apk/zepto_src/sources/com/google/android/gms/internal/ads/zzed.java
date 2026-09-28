package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes4.dex */
public final class zzed {

    /* renamed from: a, reason: collision with root package name */
    public final zzdn f29097a;

    /* renamed from: b, reason: collision with root package name */
    public final zzdx f29098b;

    /* renamed from: c, reason: collision with root package name */
    public final zzdz f29099c;

    /* renamed from: d, reason: collision with root package name */
    public final CopyOnWriteArraySet f29100d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayDeque f29101e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayDeque f29102f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f29103g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f29104h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f29105i;

    public zzed(Looper looper, zzdn zzdnVar) {
        this(new CopyOnWriteArraySet(), looper, zzdnVar, null, true);
    }

    public final void a(Object obj) {
        obj.getClass();
        synchronized (this.f29103g) {
            try {
                if (this.f29104h) {
                    return;
                }
                this.f29100d.add(new zzea(obj));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(Object obj) {
        f();
        CopyOnWriteArraySet copyOnWriteArraySet = this.f29100d;
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            zzea zzeaVar = (zzea) it.next();
            if (zzeaVar.f28903a.equals(obj)) {
                zzeaVar.f28906d = true;
                zzdz zzdzVar = this.f29099c;
                if (zzdzVar != null && zzeaVar.f28905c) {
                    zzeaVar.f28905c = false;
                    zzdzVar.a(zzeaVar.f28903a, zzeaVar.f28904b.b());
                }
                copyOnWriteArraySet.remove(zzeaVar);
            }
        }
    }

    public final void c(final int i2, final zzdy zzdyVar) {
        f();
        final CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet(this.f29100d);
        this.f29102f.add(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeb
            @Override // java.lang.Runnable
            public final void run() {
                Iterator it = copyOnWriteArraySet.iterator();
                while (it.hasNext()) {
                    zzea zzeaVar = (zzea) it.next();
                    if (!zzeaVar.f28906d) {
                        int i3 = i2;
                        if (i3 != -1) {
                            zzeaVar.f28904b.a(i3);
                        }
                        zzeaVar.f28905c = true;
                        zzdyVar.zza(zzeaVar.f28903a);
                    }
                }
            }
        });
    }

    public final void d() {
        f();
        ArrayDeque arrayDeque = this.f29102f;
        if (arrayDeque.isEmpty()) {
            return;
        }
        if (this.f29099c != null) {
            zzdx zzdxVar = this.f29098b;
            if (!zzdxVar.zzb()) {
                zzdxVar.c(zzdxVar.l(1));
            }
        }
        ArrayDeque arrayDeque2 = this.f29101e;
        boolean zIsEmpty = arrayDeque2.isEmpty();
        arrayDeque2.addAll(arrayDeque);
        arrayDeque.clear();
        if (zIsEmpty) {
            while (!arrayDeque2.isEmpty()) {
                ((Runnable) arrayDeque2.peekFirst()).run();
                arrayDeque2.removeFirst();
            }
        }
    }

    public final void e() {
        f();
        synchronized (this.f29103g) {
            this.f29104h = true;
        }
        CopyOnWriteArraySet copyOnWriteArraySet = this.f29100d;
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            zzea zzeaVar = (zzea) it.next();
            zzdz zzdzVar = this.f29099c;
            zzeaVar.f28906d = true;
            if (zzdzVar != null && zzeaVar.f28905c) {
                zzeaVar.f28905c = false;
                zzdzVar.a(zzeaVar.f28903a, zzeaVar.f28904b.b());
            }
        }
        copyOnWriteArraySet.clear();
    }

    public final void f() {
        if (this.f29105i) {
            zzgqa.f(Thread.currentThread() == this.f29098b.zza().getThread());
        }
    }

    public zzed(CopyOnWriteArraySet copyOnWriteArraySet, Looper looper, zzdn zzdnVar, zzdz zzdzVar, boolean z) {
        this.f29097a = zzdnVar;
        this.f29100d = copyOnWriteArraySet;
        this.f29099c = zzdzVar;
        this.f29103g = new Object();
        this.f29101e = new ArrayDeque();
        this.f29102f = new ArrayDeque();
        this.f29098b = zzdnVar.a(looper, new Handler.Callback() { // from class: com.google.android.gms.internal.ads.zzec
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                zzed zzedVar = this.f29044a;
                zzdz zzdzVar2 = zzedVar.f29099c;
                zzdzVar2.getClass();
                Iterator it = zzedVar.f29100d.iterator();
                while (it.hasNext()) {
                    zzea zzeaVar = (zzea) it.next();
                    if (!zzeaVar.f28906d && zzeaVar.f28905c) {
                        zzs zzsVarB = zzeaVar.f28904b.b();
                        zzeaVar.f28904b = new zzr();
                        zzeaVar.f28905c = false;
                        zzdzVar2.a(zzeaVar.f28903a, zzsVarB);
                    }
                    if (zzedVar.f29098b.zzb()) {
                        return true;
                    }
                }
                return true;
            }
        });
        this.f29105i = z;
    }
}
