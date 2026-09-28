package ch.qos.logback.classic.pattern;

import ch.qos.logback.classic.spi.ILoggingEvent;

/* loaded from: classes3.dex */
public class RelativeTimeConverter extends ClassicConverter {

    /* renamed from: f, reason: collision with root package name */
    public long f13320f = -1;

    /* renamed from: g, reason: collision with root package name */
    public String f13321g = null;

    @Override // ch.qos.logback.core.pattern.Converter
    public final String b(Object obj) {
        String str;
        ILoggingEvent iLoggingEvent = (ILoggingEvent) obj;
        long j2 = iLoggingEvent.j();
        synchronized (this) {
            try {
                if (j2 != this.f13320f) {
                    this.f13320f = j2;
                    this.f13321g = Long.toString(j2 - iLoggingEvent.d().f13346c);
                }
                str = this.f13321g;
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }
}
