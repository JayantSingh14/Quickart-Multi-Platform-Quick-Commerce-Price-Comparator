package ch.qos.logback.core.rolling;

import ch.qos.logback.core.Context;
import ch.qos.logback.core.FileAppender;
import java.util.Map;

/* loaded from: classes3.dex */
public class RollingFileAppender<E> extends FileAppender<E> {
    @Override // ch.qos.logback.core.OutputStreamAppender
    public final void Y1(Object obj) {
        throw null;
    }

    @Override // ch.qos.logback.core.FileAppender
    public final String a2() {
        throw null;
    }

    @Override // ch.qos.logback.core.FileAppender, ch.qos.logback.core.OutputStreamAppender, ch.qos.logback.core.UnsynchronizedAppenderBase, ch.qos.logback.core.spi.LifeCycle
    public final void start() {
        J1("No TriggeringPolicy was set for the RollingFileAppender named " + this.f13453f);
        J1("For more information, please visit http://logback.qos.ch/codes.html#rfa_no_tp");
    }

    @Override // ch.qos.logback.core.FileAppender, ch.qos.logback.core.OutputStreamAppender, ch.qos.logback.core.UnsynchronizedAppenderBase, ch.qos.logback.core.spi.LifeCycle
    public final void stop() {
        String str;
        super.stop();
        Context context = this.f13733b;
        Map map = context == null ? null : (Map) context.n0("RFA_FILENAME_PATTERN_COLLISION_MAP");
        if (map == null || (str = this.f13453f) == null) {
            return;
        }
        map.remove(str);
    }
}
