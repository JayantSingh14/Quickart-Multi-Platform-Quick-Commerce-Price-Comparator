package ch.qos.logback.core;

import android.support.v4.media.b;
import ch.qos.logback.core.spi.ContextAwareBase;
import ch.qos.logback.core.spi.FilterAttachableImpl;
import ch.qos.logback.core.spi.FilterReply;
import ch.qos.logback.core.status.WarnStatus;

/* loaded from: classes.dex */
public abstract class UnsynchronizedAppenderBase<E> extends ContextAwareBase implements Appender<E> {

    /* renamed from: f, reason: collision with root package name */
    public String f13453f;

    /* renamed from: d, reason: collision with root package name */
    public boolean f13451d = false;

    /* renamed from: e, reason: collision with root package name */
    public final ThreadLocal f13452e = new ThreadLocal();

    /* renamed from: g, reason: collision with root package name */
    public final FilterAttachableImpl f13454g = new FilterAttachableImpl();

    /* renamed from: h, reason: collision with root package name */
    public int f13455h = 0;

    /* renamed from: i, reason: collision with root package name */
    public int f13456i = 0;

    @Override // ch.qos.logback.core.Appender
    public final void A(Object obj) {
        Boolean bool = Boolean.TRUE;
        ThreadLocal threadLocal = this.f13452e;
        if (bool.equals(threadLocal.get())) {
            return;
        }
        try {
            threadLocal.set(bool);
            if (!this.f13451d) {
                int i2 = this.f13455h;
                this.f13455h = i2 + 1;
                if (i2 < 3) {
                    w1(new WarnStatus("Attempted to append to non started appender [" + this.f13453f + "].", this));
                }
            } else if (this.f13454g.b(obj) != FilterReply.f13739a) {
                T1(obj);
            }
        } catch (Exception e2) {
            int i3 = this.f13456i;
            this.f13456i = i3 + 1;
            if (i3 < 3) {
                o1("Appender [" + this.f13453f + "] failed to append.", e2);
            }
        } finally {
            threadLocal.set(Boolean.FALSE);
        }
    }

    public abstract void T1(Object obj);

    @Override // ch.qos.logback.core.Appender
    public final void a(String str) {
        this.f13453f = str;
    }

    @Override // ch.qos.logback.core.Appender
    public final String getName() {
        return this.f13453f;
    }

    @Override // ch.qos.logback.core.spi.LifeCycle
    public final boolean isStarted() {
        return this.f13451d;
    }

    public void start() {
        this.f13451d = true;
    }

    public void stop() {
        this.f13451d = false;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getName());
        sb.append("[");
        return b.r(sb, this.f13453f, "]");
    }
}
