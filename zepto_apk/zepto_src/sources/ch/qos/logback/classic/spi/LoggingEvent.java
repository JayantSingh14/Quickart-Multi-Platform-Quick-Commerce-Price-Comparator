package ch.qos.logback.classic.spi;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.util.LogbackMDCAdapter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import org.slf4j.MDC;
import org.slf4j.Marker;
import org.slf4j.helpers.MessageFormatter;
import org.slf4j.spi.MDCAdapter;

/* loaded from: classes3.dex */
public class LoggingEvent implements ILoggingEvent {

    /* renamed from: a, reason: collision with root package name */
    public final transient String f13347a;

    /* renamed from: b, reason: collision with root package name */
    public String f13348b;

    /* renamed from: c, reason: collision with root package name */
    public final String f13349c;

    /* renamed from: d, reason: collision with root package name */
    public final LoggerContext f13350d;

    /* renamed from: e, reason: collision with root package name */
    public final LoggerContextVO f13351e;

    /* renamed from: f, reason: collision with root package name */
    public final transient Level f13352f;

    /* renamed from: g, reason: collision with root package name */
    public final String f13353g;

    /* renamed from: h, reason: collision with root package name */
    public transient String f13354h;

    /* renamed from: i, reason: collision with root package name */
    public final transient Object[] f13355i;

    /* renamed from: j, reason: collision with root package name */
    public final ThrowableProxy f13356j;

    /* renamed from: k, reason: collision with root package name */
    public StackTraceElement[] f13357k;

    /* renamed from: l, reason: collision with root package name */
    public Map f13358l;

    /* renamed from: m, reason: collision with root package name */
    public final long f13359m;

    public LoggingEvent() {
    }

    @Override // ch.qos.logback.classic.spi.ILoggingEvent
    public final Level a() {
        return this.f13352f;
    }

    @Override // ch.qos.logback.classic.spi.ILoggingEvent
    public final String b() {
        String str = this.f13354h;
        if (str != null) {
            return str;
        }
        Object[] objArr = this.f13355i;
        String str2 = this.f13353g;
        if (objArr != null) {
            this.f13354h = MessageFormatter.a(str2, objArr).f57889a;
        } else {
            this.f13354h = str2;
        }
        return this.f13354h;
    }

    @Override // ch.qos.logback.classic.spi.ILoggingEvent
    public final Object[] c() {
        return this.f13355i;
    }

    @Override // ch.qos.logback.classic.spi.ILoggingEvent
    public final LoggerContextVO d() {
        return this.f13351e;
    }

    @Override // ch.qos.logback.classic.spi.ILoggingEvent
    public final Marker e() {
        return null;
    }

    @Override // ch.qos.logback.classic.spi.ILoggingEvent
    public final boolean f() {
        return this.f13357k != null;
    }

    @Override // ch.qos.logback.core.spi.DeferredProcessingAware
    public final void g() {
        b();
        h();
        m();
    }

    @Override // ch.qos.logback.classic.spi.ILoggingEvent
    public final String getMessage() {
        return this.f13353g;
    }

    @Override // ch.qos.logback.classic.spi.ILoggingEvent
    public final String h() {
        if (this.f13348b == null) {
            this.f13348b = Thread.currentThread().getName();
        }
        return this.f13348b;
    }

    @Override // ch.qos.logback.classic.spi.ILoggingEvent
    public final StackTraceElement[] i() {
        StackTraceElement[] stackTraceElementArr;
        if (this.f13357k == null) {
            Throwable th = new Throwable();
            LoggerContext loggerContext = this.f13350d;
            int i2 = loggerContext.r;
            ArrayList arrayList = loggerContext.s;
            String str = CallerData.f13339a;
            StackTraceElement[] stackTrace = th.getStackTrace();
            int i3 = -1;
            for (int i4 = 0; i4 < stackTrace.length; i4++) {
                String className = stackTrace[i4].getClassName();
                if (className.equals(this.f13347a) || className.equals("org.apache.log4j.Category") || className.startsWith("org.slf4j.Logger")) {
                    i3 = i4 + 1;
                    break;
                }
                if (arrayList != null) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (className.startsWith((String) it.next())) {
                            i3 = i4 + 1;
                            break;
                            break;
                        }
                    }
                }
                if (i3 != -1) {
                    break;
                }
            }
            if (i3 == -1) {
                stackTraceElementArr = CallerData.f13340b;
            } else {
                int length = stackTrace.length - i3;
                if (i2 >= length) {
                    i2 = length;
                }
                StackTraceElement[] stackTraceElementArr2 = new StackTraceElement[i2];
                for (int i5 = 0; i5 < i2; i5++) {
                    stackTraceElementArr2[i5] = stackTrace[i3 + i5];
                }
                stackTraceElementArr = stackTraceElementArr2;
            }
            this.f13357k = stackTraceElementArr;
        }
        return this.f13357k;
    }

    @Override // ch.qos.logback.classic.spi.ILoggingEvent
    public final long j() {
        return this.f13359m;
    }

    @Override // ch.qos.logback.classic.spi.ILoggingEvent
    public final String k() {
        return this.f13349c;
    }

    @Override // ch.qos.logback.classic.spi.ILoggingEvent
    public final IThrowableProxy l() {
        return this.f13356j;
    }

    @Override // ch.qos.logback.classic.spi.ILoggingEvent
    public final Map m() {
        if (this.f13358l == null) {
            MDCAdapter mDCAdapter = MDC.f57876a;
            if (mDCAdapter instanceof LogbackMDCAdapter) {
                LogbackMDCAdapter logbackMDCAdapter = (LogbackMDCAdapter) mDCAdapter;
                logbackMDCAdapter.f13414b.set(2);
                this.f13358l = (Map) logbackMDCAdapter.f13413a.get();
            } else {
                this.f13358l = mDCAdapter.a();
            }
        }
        if (this.f13358l == null) {
            this.f13358l = Collections.EMPTY_MAP;
        }
        return this.f13358l;
    }

    public final String toString() {
        return "[" + this.f13352f + "] " + b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13, types: [java.lang.Throwable] */
    public LoggingEvent(Level level, Logger logger, Exception exc, String str, Object[] objArr) throws ClassNotFoundException {
        this.f13347a = "ch.qos.logback.classic.Logger";
        this.f13349c = logger.f13242a;
        LoggerContext loggerContext = logger.f13249h;
        this.f13350d = loggerContext;
        this.f13351e = loggerContext.o;
        this.f13352f = level;
        this.f13353g = str;
        this.f13355i = objArr;
        if (exc == null) {
            exc = null;
            if (objArr != null && objArr.length != 0) {
                Object obj = objArr[objArr.length - 1];
                if (obj instanceof Throwable) {
                    exc = (Throwable) obj;
                }
            }
            if (exc != null) {
                if (objArr == null || objArr.length == 0) {
                    throw new IllegalStateException("non-sensical empty or null argument array");
                }
                int length = objArr.length - 1;
                Object[] objArr2 = new Object[length];
                System.arraycopy(objArr, 0, objArr2, 0, length);
                this.f13355i = objArr2;
            }
        }
        if (exc != null) {
            ThrowableProxy throwableProxy = new ThrowableProxy(exc);
            this.f13356j = throwableProxy;
            if (loggerContext.q && !throwableProxy.f13388i) {
                if (throwableProxy.f13387h == null) {
                    throwableProxy.f13387h = new PackagingDataCalculator();
                }
                PackagingDataCalculator packagingDataCalculator = throwableProxy.f13387h;
                if (packagingDataCalculator != null) {
                    throwableProxy.f13388i = true;
                    for (ThrowableProxy throwableProxyA = throwableProxy; throwableProxyA != null; throwableProxyA = throwableProxyA.a()) {
                        packagingDataCalculator.d(throwableProxyA.e());
                        IThrowableProxy[] iThrowableProxyArrC = throwableProxyA.c();
                        if (iThrowableProxyArrC != null) {
                            for (IThrowableProxy iThrowableProxy : iThrowableProxyArrC) {
                                packagingDataCalculator.d(iThrowableProxy.e());
                            }
                        }
                    }
                }
            }
        }
        this.f13359m = System.currentTimeMillis();
    }
}
