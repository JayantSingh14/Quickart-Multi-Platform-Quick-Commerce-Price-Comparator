package ch.qos.logback.classic.turbo;

import ch.qos.logback.classic.Level;
import ch.qos.logback.core.spi.FilterReply;

/* loaded from: classes3.dex */
public class DuplicateMessageFilter extends TurboFilter {

    /* renamed from: e, reason: collision with root package name */
    public final int f13395e = 5;

    /* renamed from: f, reason: collision with root package name */
    public final int f13396f = 100;

    /* renamed from: g, reason: collision with root package name */
    public LRUMessageCache f13397g;

    @Override // ch.qos.logback.classic.turbo.TurboFilter
    public final FilterReply T1(Level level, String str) {
        return this.f13397g.a(str) <= this.f13395e ? FilterReply.f13740b : FilterReply.f13739a;
    }

    @Override // ch.qos.logback.classic.turbo.TurboFilter, ch.qos.logback.core.spi.LifeCycle
    public final void start() {
        this.f13397g = new LRUMessageCache(this.f13396f);
        this.f13408d = true;
    }

    @Override // ch.qos.logback.classic.turbo.TurboFilter, ch.qos.logback.core.spi.LifeCycle
    public final void stop() {
        this.f13397g.clear();
        this.f13397g = null;
        this.f13408d = false;
    }
}
