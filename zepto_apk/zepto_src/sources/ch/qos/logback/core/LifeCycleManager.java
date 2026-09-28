package ch.qos.logback.core;

import ch.qos.logback.core.spi.LifeCycle;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class LifeCycleManager {

    /* renamed from: a, reason: collision with root package name */
    public final HashSet f13446a = new HashSet();

    public final void a(LifeCycle lifeCycle) {
        this.f13446a.add(lifeCycle);
    }

    public final void b() {
        HashSet hashSet = this.f13446a;
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            LifeCycle lifeCycle = (LifeCycle) it.next();
            if (lifeCycle.isStarted()) {
                lifeCycle.stop();
            }
        }
        hashSet.clear();
    }
}
