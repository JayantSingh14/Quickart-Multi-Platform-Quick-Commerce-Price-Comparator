package ch.qos.logback.core;

import ch.qos.logback.core.spi.LifeCycle;
import ch.qos.logback.core.spi.LogbackLock;
import ch.qos.logback.core.util.ContextUtil;
import ch.qos.logback.core.util.ExecutorServiceUtil;
import in.juspay.hypersdk.analytics.LogConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* loaded from: classes.dex */
public class ContextBase implements Context, LifeCycle {

    /* renamed from: b, reason: collision with root package name */
    public String f13433b;

    /* renamed from: g, reason: collision with root package name */
    public ScheduledThreadPoolExecutor f13438g;

    /* renamed from: i, reason: collision with root package name */
    public LifeCycleManager f13440i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f13441j;

    /* renamed from: a, reason: collision with root package name */
    public final long f13432a = System.currentTimeMillis();

    /* renamed from: c, reason: collision with root package name */
    public final BasicStatusManager f13434c = new BasicStatusManager();

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f13435d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    public final HashMap f13436e = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    public final LogbackLock f13437f = new LogbackLock();

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList f13439h = new ArrayList(1);

    public ContextBase() {
        O(new HashMap(), "FA_FILENAME_COLLISION_MAP");
        O(new HashMap(), "RFA_FILENAME_PATTERN_COLLISION_MAP");
    }

    @Override // ch.qos.logback.core.Context
    public final BasicStatusManager D() {
        return this.f13434c;
    }

    @Override // ch.qos.logback.core.Context
    public final void N(LifeCycle lifeCycle) {
        d().a(lifeCycle);
    }

    @Override // ch.qos.logback.core.Context
    public final void O(Object obj, String str) {
        this.f13436e.put(str, obj);
    }

    @Override // ch.qos.logback.core.Context
    public final synchronized ScheduledExecutorService T() {
        try {
            if (this.f13438g == null) {
                this.f13438g = ExecutorServiceUtil.a();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f13438g;
    }

    @Override // ch.qos.logback.core.Context
    public void a(String str) {
        if (str == null || !str.equals(this.f13433b)) {
            String str2 = this.f13433b;
            if (str2 != null && !LogConstants.DEFAULT_CHANNEL.equals(str2)) {
                throw new IllegalStateException("Context has been already given a name");
            }
            this.f13433b = str;
        }
    }

    @Override // ch.qos.logback.core.spi.PropertyContainer
    public final String b(String str) {
        if ("CONTEXT_NAME".equals(str)) {
            return this.f13433b;
        }
        boolean zEqualsIgnoreCase = "HOSTNAME".equalsIgnoreCase(str);
        HashMap map = this.f13435d;
        if (!zEqualsIgnoreCase) {
            return (String) map.get(str);
        }
        String strU1 = (String) map.get("HOSTNAME");
        if (strU1 == null) {
            strU1 = new ContextUtil(this).U1();
            HashMap map2 = this.f13435d;
            if (((String) map2.get("HOSTNAME")) == null) {
                map2.put("HOSTNAME", strU1);
            }
        }
        return strU1;
    }

    public final synchronized LifeCycleManager d() {
        try {
            if (this.f13440i == null) {
                this.f13440i = new LifeCycleManager();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f13440i;
    }

    @Override // ch.qos.logback.core.Context
    public final String getName() {
        return this.f13433b;
    }

    @Override // ch.qos.logback.core.spi.LifeCycle
    public final boolean isStarted() {
        return this.f13441j;
    }

    @Override // ch.qos.logback.core.Context
    public final synchronized ScheduledExecutorService l0() {
        return T();
    }

    @Override // ch.qos.logback.core.Context
    public final Object n0(String str) {
        return this.f13436e.get(str);
    }

    @Override // ch.qos.logback.core.Context
    public final void s(ScheduledFuture scheduledFuture) {
        this.f13439h.add(scheduledFuture);
    }

    @Override // ch.qos.logback.core.Context
    public void s0(String str, String str2) {
        if (!"HOSTNAME".equalsIgnoreCase(str)) {
            this.f13435d.put(str, str2);
            return;
        }
        HashMap map = this.f13435d;
        if (((String) map.get("HOSTNAME")) == null) {
            map.put("HOSTNAME", str2);
        }
    }

    public void start() {
        this.f13441j = true;
    }

    public void stop() {
        synchronized (this) {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = this.f13438g;
            if (scheduledThreadPoolExecutor != null) {
                ExecutorServiceUtil.b(scheduledThreadPoolExecutor);
                this.f13438g = null;
            }
        }
        this.f13441j = false;
    }

    @Override // ch.qos.logback.core.Context
    public final LogbackLock t0() {
        return this.f13437f;
    }

    public String toString() {
        return this.f13433b;
    }

    @Override // ch.qos.logback.core.Context
    public final long v0() {
        return this.f13432a;
    }
}
