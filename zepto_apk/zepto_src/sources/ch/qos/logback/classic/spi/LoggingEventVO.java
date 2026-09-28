package ch.qos.logback.classic.spi;

import ch.qos.logback.classic.Level;
import java.io.Serializable;
import java.util.Map;
import org.slf4j.Marker;
import org.slf4j.helpers.MessageFormatter;

/* loaded from: classes3.dex */
public class LoggingEventVO implements ILoggingEvent, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public String f13360a;

    /* renamed from: b, reason: collision with root package name */
    public String f13361b;

    /* renamed from: c, reason: collision with root package name */
    public LoggerContextVO f13362c;

    /* renamed from: d, reason: collision with root package name */
    public transient Level f13363d;

    /* renamed from: e, reason: collision with root package name */
    public String f13364e;

    /* renamed from: f, reason: collision with root package name */
    public transient String f13365f;

    /* renamed from: g, reason: collision with root package name */
    public transient Object[] f13366g;

    /* renamed from: h, reason: collision with root package name */
    public ThrowableProxyVO f13367h;

    /* renamed from: i, reason: collision with root package name */
    public StackTraceElement[] f13368i;

    /* renamed from: j, reason: collision with root package name */
    public Marker f13369j;

    /* renamed from: k, reason: collision with root package name */
    public Map f13370k;

    /* renamed from: l, reason: collision with root package name */
    public long f13371l;

    @Override // ch.qos.logback.classic.spi.ILoggingEvent
    public final Level a() {
        return this.f13363d;
    }

    @Override // ch.qos.logback.classic.spi.ILoggingEvent
    public final String b() {
        String str = this.f13365f;
        if (str != null) {
            return str;
        }
        Object[] objArr = this.f13366g;
        if (objArr != null) {
            this.f13365f = MessageFormatter.a(this.f13364e, objArr).f57889a;
        } else {
            this.f13365f = this.f13364e;
        }
        return this.f13365f;
    }

    @Override // ch.qos.logback.classic.spi.ILoggingEvent
    public final Object[] c() {
        return this.f13366g;
    }

    @Override // ch.qos.logback.classic.spi.ILoggingEvent
    public final LoggerContextVO d() {
        return this.f13362c;
    }

    @Override // ch.qos.logback.classic.spi.ILoggingEvent
    public final Marker e() {
        return this.f13369j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LoggingEventVO loggingEventVO = (LoggingEventVO) obj;
        String str = this.f13364e;
        if (str == null) {
            if (loggingEventVO.f13364e != null) {
                return false;
            }
        } else if (!str.equals(loggingEventVO.f13364e)) {
            return false;
        }
        String str2 = this.f13361b;
        if (str2 == null) {
            if (loggingEventVO.f13361b != null) {
                return false;
            }
        } else if (!str2.equals(loggingEventVO.f13361b)) {
            return false;
        }
        String str3 = this.f13360a;
        if (str3 == null) {
            if (loggingEventVO.f13360a != null) {
                return false;
            }
        } else if (!str3.equals(loggingEventVO.f13360a)) {
            return false;
        }
        if (this.f13371l != loggingEventVO.f13371l) {
            return false;
        }
        Marker marker = this.f13369j;
        if (marker == null) {
            if (loggingEventVO.f13369j != null) {
                return false;
            }
        } else if (!marker.equals(loggingEventVO.f13369j)) {
            return false;
        }
        Map map = this.f13370k;
        if (map == null) {
            if (loggingEventVO.f13370k != null) {
                return false;
            }
        } else if (!map.equals(loggingEventVO.f13370k)) {
            return false;
        }
        return true;
    }

    @Override // ch.qos.logback.classic.spi.ILoggingEvent
    public final boolean f() {
        return this.f13368i != null;
    }

    @Override // ch.qos.logback.core.spi.DeferredProcessingAware
    public final void g() {
    }

    @Override // ch.qos.logback.classic.spi.ILoggingEvent
    public final String getMessage() {
        return this.f13364e;
    }

    @Override // ch.qos.logback.classic.spi.ILoggingEvent
    public final String h() {
        return this.f13360a;
    }

    public final int hashCode() {
        String str = this.f13364e;
        int iHashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.f13360a;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        long j2 = this.f13371l;
        return iHashCode2 + ((int) (j2 ^ (j2 >>> 32)));
    }

    @Override // ch.qos.logback.classic.spi.ILoggingEvent
    public final StackTraceElement[] i() {
        return this.f13368i;
    }

    @Override // ch.qos.logback.classic.spi.ILoggingEvent
    public final long j() {
        return this.f13371l;
    }

    @Override // ch.qos.logback.classic.spi.ILoggingEvent
    public final String k() {
        return this.f13361b;
    }

    @Override // ch.qos.logback.classic.spi.ILoggingEvent
    public final IThrowableProxy l() {
        return this.f13367h;
    }

    @Override // ch.qos.logback.classic.spi.ILoggingEvent
    public final Map m() {
        return this.f13370k;
    }
}
