package ch.qos.logback.core.rolling;

import ch.qos.logback.core.rolling.helper.RenameUtil;

/* loaded from: classes3.dex */
public class TimeBasedRollingPolicy<E> extends RollingPolicyBase implements TriggeringPolicy<E> {

    /* renamed from: e, reason: collision with root package name */
    public final RenameUtil f13720e = new RenameUtil();

    @Override // ch.qos.logback.core.rolling.RollingPolicyBase, ch.qos.logback.core.spi.LifeCycle
    public void start() {
        this.f13720e.V(this.f13733b);
        J1("The FileNamePattern option must be set before using TimeBasedRollingPolicy. ");
        J1("See also http://logback.qos.ch/codes.html#tbr_fnp_not_set");
        throw new IllegalStateException("The FileNamePattern option must be set before using TimeBasedRollingPolicy. See also http://logback.qos.ch/codes.html#tbr_fnp_not_set");
    }

    @Override // ch.qos.logback.core.rolling.RollingPolicyBase, ch.qos.logback.core.spi.LifeCycle
    public final void stop() {
        if (this.f13716d) {
            this.f13716d = false;
        }
    }

    public String toString() {
        return "c.q.l.core.rolling.TimeBasedRollingPolicy@" + hashCode();
    }
}
