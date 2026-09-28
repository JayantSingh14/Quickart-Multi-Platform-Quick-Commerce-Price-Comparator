package ch.qos.logback.classic.turbo;

import ch.qos.logback.classic.Level;
import ch.qos.logback.core.spi.FilterReply;

/* loaded from: classes3.dex */
public class MarkerFilter extends MatchingFilter {
    @Override // ch.qos.logback.classic.turbo.TurboFilter
    public final FilterReply T1(Level level, String str) {
        return !this.f13408d ? FilterReply.f13740b : this.f13399e;
    }

    @Override // ch.qos.logback.classic.turbo.TurboFilter, ch.qos.logback.core.spi.LifeCycle
    public final void start() {
        l1("The marker property must be set for [null]");
    }
}
