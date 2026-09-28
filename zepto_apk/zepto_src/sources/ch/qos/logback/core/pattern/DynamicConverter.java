package ch.qos.logback.core.pattern;

import ch.qos.logback.core.Context;
import ch.qos.logback.core.spi.ContextAware;
import ch.qos.logback.core.spi.ContextAwareBase;
import ch.qos.logback.core.spi.LifeCycle;
import java.util.List;

/* loaded from: classes.dex */
public abstract class DynamicConverter<E> extends FormattingConverter<E> implements LifeCycle, ContextAware {

    /* renamed from: d, reason: collision with root package name */
    public List f13650d;

    /* renamed from: c, reason: collision with root package name */
    public final ContextAwareBase f13649c = new ContextAwareBase(this);

    /* renamed from: e, reason: collision with root package name */
    public boolean f13651e = false;

    @Override // ch.qos.logback.core.spi.ContextAware
    public final void V(Context context) {
        this.f13649c.V(context);
    }

    public final void d(String str) {
        this.f13649c.l1(str);
    }

    public final void e(String str, Throwable th) {
        this.f13649c.o1(str, th);
    }

    public final String f() {
        List list = this.f13650d;
        if (list == null || list.size() == 0) {
            return null;
        }
        return (String) this.f13650d.get(0);
    }

    @Override // ch.qos.logback.core.spi.LifeCycle
    public final boolean isStarted() {
        return this.f13651e;
    }

    public void start() {
        this.f13651e = true;
    }

    public void stop() {
        this.f13651e = false;
    }
}
