package ch.qos.logback.classic.layout;

import ch.qos.logback.classic.pattern.ThrowableProxyConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.LayoutBase;
import ch.qos.logback.core.util.CachingDateFormatter;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes.dex */
public class TTLLLayout extends LayoutBase<ILoggingEvent> {

    /* renamed from: e, reason: collision with root package name */
    public final CachingDateFormatter f13291e = new CachingDateFormatter("HH:mm:ss.SSS");

    /* renamed from: f, reason: collision with root package name */
    public final ThrowableProxyConverter f13292f = new ThrowableProxyConverter();

    @Override // ch.qos.logback.core.Layout
    public final String c1(Object obj) {
        ILoggingEvent iLoggingEvent = (ILoggingEvent) obj;
        if (!this.f13445d) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f13291e.a(iLoggingEvent.j()));
        sb.append(" [");
        sb.append(iLoggingEvent.h());
        sb.append("] ");
        sb.append(iLoggingEvent.a().f13241b);
        sb.append(StringUtils.SPACE);
        sb.append(iLoggingEvent.k());
        sb.append(" - ");
        sb.append(iLoggingEvent.b());
        sb.append(CoreConstants.f13442a);
        if (iLoggingEvent.l() != null) {
            sb.append(this.f13292f.b(iLoggingEvent));
        }
        return sb.toString();
    }

    @Override // ch.qos.logback.core.LayoutBase, ch.qos.logback.core.spi.LifeCycle
    public final void start() {
        this.f13292f.start();
        this.f13445d = true;
    }
}
