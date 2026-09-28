package ch.qos.logback.classic.spi;

import ch.qos.logback.classic.LoggerContext;
import java.io.Serializable;
import java.util.HashMap;

/* loaded from: classes.dex */
public class LoggerContextVO implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final String f13344a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f13345b;

    /* renamed from: c, reason: collision with root package name */
    public final long f13346c;

    public LoggerContextVO(LoggerContext loggerContext) {
        this.f13344a = loggerContext.f13433b;
        this.f13345b = new HashMap(loggerContext.f13435d);
        this.f13346c = loggerContext.f13432a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LoggerContextVO)) {
            return false;
        }
        LoggerContextVO loggerContextVO = (LoggerContextVO) obj;
        if (this.f13346c != loggerContextVO.f13346c) {
            return false;
        }
        String str = loggerContextVO.f13344a;
        String str2 = this.f13344a;
        if (str2 != null) {
            if (!str2.equals(str)) {
                return false;
            }
        } else if (str != null) {
            return false;
        }
        HashMap map = this.f13345b;
        HashMap map2 = loggerContextVO.f13345b;
        return map != null ? map.equals(map2) : map2 == null;
    }

    public final int hashCode() {
        String str = this.f13344a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        HashMap map = this.f13345b;
        int iHashCode2 = map != null ? map.hashCode() : 0;
        long j2 = this.f13346c;
        return ((iHashCode + iHashCode2) * 31) + ((int) (j2 ^ (j2 >>> 32)));
    }

    public final String toString() {
        return "LoggerContextVO{name='" + this.f13344a + "', propertyMap=" + this.f13345b + ", birthTime=" + this.f13346c + '}';
    }
}
