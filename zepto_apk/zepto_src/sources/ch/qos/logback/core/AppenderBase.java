package ch.qos.logback.core;

import android.support.v4.media.b;
import ch.qos.logback.core.spi.ContextAwareBase;
import ch.qos.logback.core.spi.FilterAttachableImpl;
import ch.qos.logback.core.spi.FilterReply;
import ch.qos.logback.core.status.WarnStatus;

/* loaded from: classes3.dex */
public abstract class AppenderBase<E> extends ContextAwareBase implements Appender<E> {

    /* renamed from: f, reason: collision with root package name */
    public String f13417f;

    /* renamed from: d, reason: collision with root package name */
    public volatile boolean f13415d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f13416e = false;

    /* renamed from: g, reason: collision with root package name */
    public final FilterAttachableImpl f13418g = new FilterAttachableImpl();

    /* renamed from: h, reason: collision with root package name */
    public int f13419h = 0;

    /* renamed from: i, reason: collision with root package name */
    public int f13420i = 0;

    @Override // ch.qos.logback.core.Appender
    public final synchronized void A(Object obj) {
        if (this.f13416e) {
            return;
        }
        try {
            try {
                this.f13416e = true;
            } catch (Exception e2) {
                int i2 = this.f13420i;
                this.f13420i = i2 + 1;
                if (i2 < 5) {
                    o1("Appender [" + this.f13417f + "] failed to append.", e2);
                }
            }
            if (this.f13415d) {
                if (this.f13418g.b(obj) == FilterReply.f13739a) {
                    return;
                }
                T1(obj);
                return;
            }
            int i3 = this.f13419h;
            this.f13419h = i3 + 1;
            if (i3 < 5) {
                w1(new WarnStatus("Attempted to append to non started appender [" + this.f13417f + "].", this));
            }
        } finally {
            this.f13416e = false;
        }
    }

    public abstract void T1(Object obj);

    @Override // ch.qos.logback.core.Appender
    public final void a(String str) {
        this.f13417f = str;
    }

    @Override // ch.qos.logback.core.Appender
    public final String getName() {
        return this.f13417f;
    }

    @Override // ch.qos.logback.core.spi.LifeCycle
    public final boolean isStarted() {
        return this.f13415d;
    }

    public void start() {
        this.f13415d = true;
    }

    @Override // ch.qos.logback.core.spi.LifeCycle
    public void stop() {
        this.f13415d = false;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getName());
        sb.append("[");
        return b.r(sb, this.f13417f, "]");
    }
}
