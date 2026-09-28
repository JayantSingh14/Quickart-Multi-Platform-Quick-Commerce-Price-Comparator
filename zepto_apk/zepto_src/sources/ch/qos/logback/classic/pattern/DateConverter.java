package ch.qos.logback.classic.pattern;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.util.CachingDateFormatter;
import j$.util.DesugarTimeZone;
import java.util.List;

/* loaded from: classes3.dex */
public class DateConverter extends ClassicConverter {

    /* renamed from: f, reason: collision with root package name */
    public CachingDateFormatter f13314f = null;

    @Override // ch.qos.logback.core.pattern.Converter
    public final String b(Object obj) {
        return this.f13314f.a(((ILoggingEvent) obj).j());
    }

    @Override // ch.qos.logback.core.pattern.DynamicConverter, ch.qos.logback.core.spi.LifeCycle
    public final void start() {
        String strF = f();
        if (strF == null) {
            strF = "yyyy-MM-dd HH:mm:ss,SSS";
        }
        if (strF.equals("ISO8601")) {
            strF = "yyyy-MM-dd HH:mm:ss,SSS";
        }
        try {
            this.f13314f = new CachingDateFormatter(strF);
        } catch (IllegalArgumentException e2) {
            this.f13649c.O1("Could not instantiate SimpleDateFormat with pattern ".concat(strF), e2);
            this.f13314f = new CachingDateFormatter("yyyy-MM-dd HH:mm:ss,SSS");
        }
        List list = this.f13650d;
        if (list == null || list.size() <= 1) {
            return;
        }
        this.f13314f.f13802c.setTimeZone(DesugarTimeZone.getTimeZone((String) list.get(1)));
    }
}
