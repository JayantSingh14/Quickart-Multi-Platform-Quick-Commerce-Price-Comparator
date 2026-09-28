package ch.qos.logback.classic.pattern;

import ch.qos.logback.classic.spi.ILoggingEvent;

/* loaded from: classes3.dex */
public abstract class NamedConverter extends ClassicConverter {

    /* renamed from: f, reason: collision with root package name */
    public Abbreviator f13318f = null;

    @Override // ch.qos.logback.core.pattern.Converter
    public final String b(Object obj) {
        String strG = g((ILoggingEvent) obj);
        Abbreviator abbreviator = this.f13318f;
        return abbreviator == null ? strG : abbreviator.a(strG);
    }

    public abstract String g(ILoggingEvent iLoggingEvent);

    @Override // ch.qos.logback.core.pattern.DynamicConverter, ch.qos.logback.core.spi.LifeCycle
    public final void start() throws NumberFormatException {
        String strF = f();
        if (strF != null) {
            try {
                int i2 = Integer.parseInt(strF);
                if (i2 == 0) {
                    this.f13318f = new ClassNameOnlyAbbreviator();
                } else if (i2 > 0) {
                    this.f13318f = new TargetLengthBasedClassNameAbbreviator(i2);
                }
            } catch (NumberFormatException unused) {
            }
        }
    }
}
