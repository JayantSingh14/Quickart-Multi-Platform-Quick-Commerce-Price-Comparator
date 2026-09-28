package ch.qos.logback.classic.pattern;

import ch.qos.logback.classic.spi.ILoggingEvent;

/* loaded from: classes3.dex */
public final class PropertyConverter extends ClassicConverter {

    /* renamed from: f, reason: collision with root package name */
    public String f13319f;

    @Override // ch.qos.logback.core.pattern.Converter
    public final String b(Object obj) {
        ILoggingEvent iLoggingEvent = (ILoggingEvent) obj;
        if (this.f13319f == null) {
            return "Property_HAS_NO_KEY";
        }
        String str = (String) iLoggingEvent.d().f13345b.get(this.f13319f);
        return str != null ? str : System.getProperty(this.f13319f);
    }

    @Override // ch.qos.logback.core.pattern.DynamicConverter, ch.qos.logback.core.spi.LifeCycle
    public final void start() {
        String strF = f();
        if (strF != null) {
            this.f13319f = strF;
            this.f13651e = true;
        }
    }
}
