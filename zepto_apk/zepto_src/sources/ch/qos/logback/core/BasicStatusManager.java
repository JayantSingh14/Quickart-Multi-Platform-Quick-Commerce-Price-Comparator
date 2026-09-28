package ch.qos.logback.core;

import ch.qos.logback.core.helpers.CyclicBuffer;
import ch.qos.logback.core.spi.LogbackLock;
import ch.qos.logback.core.status.OnConsoleStatusListener;
import ch.qos.logback.core.status.StatusBase;
import ch.qos.logback.core.status.StatusListener;
import ch.qos.logback.core.status.StatusManager;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class BasicStatusManager implements StatusManager {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f13426a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public final CyclicBuffer f13427b = new CyclicBuffer(150);

    /* renamed from: c, reason: collision with root package name */
    public final LogbackLock f13428c = new LogbackLock();

    /* renamed from: d, reason: collision with root package name */
    public int f13429d = 0;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f13430e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    public final LogbackLock f13431f = new LogbackLock();

    @Override // ch.qos.logback.core.status.StatusManager
    public final void a(StatusBase statusBase) {
        synchronized (this.f13431f) {
            try {
                Iterator it = this.f13430e.iterator();
                while (it.hasNext()) {
                    ((StatusListener) it.next()).z0(statusBase);
                }
            } finally {
            }
        }
        int i2 = statusBase.f13747a;
        if (i2 > this.f13429d) {
            this.f13429d = i2;
        }
        synchronized (this.f13428c) {
            try {
                if (this.f13426a.size() < 150) {
                    this.f13426a.add(statusBase);
                } else {
                    this.f13427b.a(statusBase);
                }
            } finally {
            }
        }
    }

    @Override // ch.qos.logback.core.status.StatusManager
    public final ArrayList b() {
        ArrayList arrayList;
        synchronized (this.f13428c) {
            arrayList = new ArrayList(this.f13426a);
            CyclicBuffer cyclicBuffer = this.f13427b;
            cyclicBuffer.getClass();
            ArrayList arrayList2 = new ArrayList();
            int i2 = 0;
            while (true) {
                int i3 = cyclicBuffer.f13483d;
                if (i2 < i3) {
                    arrayList2.add((i2 < 0 || i2 >= i3) ? null : cyclicBuffer.f13480a[(cyclicBuffer.f13481b + i2) % cyclicBuffer.f13484e]);
                    i2++;
                } else {
                    arrayList.addAll(arrayList2);
                }
            }
        }
        return arrayList;
    }

    public final boolean c(StatusListener statusListener) {
        synchronized (this.f13431f) {
            try {
                if (statusListener instanceof OnConsoleStatusListener) {
                    ArrayList arrayList = this.f13430e;
                    Class<?> cls = statusListener.getClass();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (((StatusListener) it.next()).getClass() == cls) {
                            return false;
                        }
                    }
                }
                this.f13430e.add(statusListener);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final ArrayList d() {
        ArrayList arrayList;
        synchronized (this.f13431f) {
            arrayList = new ArrayList(this.f13430e);
        }
        return arrayList;
    }
}
