package ch.qos.logback.core.rolling;

import ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP;

/* loaded from: classes3.dex */
public class SizeAndTimeBasedRollingPolicy<E> extends TimeBasedRollingPolicy<E> {
    @Override // ch.qos.logback.core.rolling.TimeBasedRollingPolicy, ch.qos.logback.core.rolling.RollingPolicyBase, ch.qos.logback.core.spi.LifeCycle
    public final void start() {
        new SizeAndTimeBasedFNATP(SizeAndTimeBasedFNATP.Usage.f13717a);
        l1("maxFileSize property is mandatory.");
    }

    @Override // ch.qos.logback.core.rolling.TimeBasedRollingPolicy
    public final String toString() {
        return "c.q.l.core.rolling.SizeAndTimeBasedRollingPolicy@" + hashCode();
    }
}
