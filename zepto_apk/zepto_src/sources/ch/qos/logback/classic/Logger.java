package ch.qos.logback.classic;

import android.support.v4.media.b;
import androidx.fragment.app.e;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.LoggerContextListener;
import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.Appender;
import ch.qos.logback.core.BasicStatusManager;
import ch.qos.logback.core.spi.AppenderAttachable;
import ch.qos.logback.core.spi.AppenderAttachableImpl;
import ch.qos.logback.core.spi.FilterReply;
import ch.qos.logback.core.status.WarnStatus;
import ch.qos.logback.core.util.COWArrayList;
import j$.time.Instant;
import java.io.Serializable;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.slf4j.spi.LocationAwareLogger;

/* loaded from: classes.dex */
public final class Logger implements org.slf4j.Logger, LocationAwareLogger, AppenderAttachable<ILoggingEvent>, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final String f13242a;

    /* renamed from: b, reason: collision with root package name */
    public transient Level f13243b;

    /* renamed from: c, reason: collision with root package name */
    public transient int f13244c;

    /* renamed from: d, reason: collision with root package name */
    public final transient Logger f13245d;

    /* renamed from: e, reason: collision with root package name */
    public transient CopyOnWriteArrayList f13246e;

    /* renamed from: f, reason: collision with root package name */
    public transient AppenderAttachableImpl f13247f;

    /* renamed from: g, reason: collision with root package name */
    public transient boolean f13248g = true;

    /* renamed from: h, reason: collision with root package name */
    public final transient LoggerContext f13249h;

    public Logger(String str, Logger logger, LoggerContext loggerContext) {
        this.f13242a = str;
        this.f13245d = logger;
        this.f13249h = loggerContext;
    }

    public final synchronized void A(int i2) {
        if (this.f13243b == null) {
            this.f13244c = i2;
            CopyOnWriteArrayList copyOnWriteArrayList = this.f13246e;
            if (copyOnWriteArrayList != null) {
                int size = copyOnWriteArrayList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((Logger) this.f13246e.get(i3)).A(i2);
                }
            }
        }
    }

    public final void B(String str) {
        x(Level.f13236f, str, null, null);
    }

    public final boolean C(Level level) {
        Logger logger;
        Level level2;
        FilterReply filterReplyB;
        LoggerContext loggerContext = this.f13249h;
        int size = loggerContext.p.size();
        FilterReply filterReply = FilterReply.f13740b;
        if (size == 0) {
            logger = this;
            level2 = level;
            filterReplyB = filterReply;
        } else {
            logger = this;
            level2 = level;
            filterReplyB = loggerContext.p.b(level2, logger, null, null, null);
        }
        if (filterReplyB == filterReply) {
            return logger.f13244c <= level2.f13240a;
        }
        if (filterReplyB == FilterReply.f13739a) {
            return false;
        }
        if (filterReplyB == FilterReply.f13741c) {
            return true;
        }
        throw new IllegalStateException("Unknown FilterReply value: " + filterReplyB);
    }

    public final void D() {
        AppenderAttachableImpl appenderAttachableImpl = this.f13247f;
        if (appenderAttachableImpl != null) {
            COWArrayList cOWArrayList = appenderAttachableImpl.f13731a;
            Iterator it = cOWArrayList.f13797b.iterator();
            while (it.hasNext()) {
                ((Appender) it.next()).stop();
            }
            cOWArrayList.clear();
        }
        this.f13244c = 10000;
        if (this.f13245d == null) {
            this.f13243b = Level.f13237g;
        } else {
            this.f13243b = null;
        }
        this.f13248g = true;
        CopyOnWriteArrayList copyOnWriteArrayList = this.f13246e;
        if (copyOnWriteArrayList == null) {
            return;
        }
        Iterator it2 = copyOnWriteArrayList.iterator();
        while (it2.hasNext()) {
            ((Logger) it2.next()).D();
        }
    }

    public final synchronized void E(Level level) {
        try {
            if (this.f13243b == level) {
                return;
            }
            if (level == null) {
                if (this.f13245d == null) {
                    throw new IllegalArgumentException("The level of the root logger cannot be set to null");
                }
            }
            this.f13243b = level;
            if (level == null) {
                Logger logger = this.f13245d;
                this.f13244c = logger.f13244c;
                int i2 = logger.f13244c;
                Level level2 = Level.f13237g;
                if (i2 == Integer.MIN_VALUE) {
                    level = Level.f13239i;
                } else if (i2 == 5000) {
                    level = Level.f13238h;
                } else if (i2 != 10000) {
                    level = i2 != 20000 ? i2 != 30000 ? i2 != 40000 ? i2 != Integer.MAX_VALUE ? level2 : Level.f13233c : Level.f13234d : Level.f13235e : Level.f13236f;
                }
            } else {
                this.f13244c = level.f13240a;
            }
            CopyOnWriteArrayList copyOnWriteArrayList = this.f13246e;
            if (copyOnWriteArrayList != null) {
                int size = copyOnWriteArrayList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((Logger) this.f13246e.get(i3)).A(this.f13244c);
                }
            }
            Iterator it = this.f13249h.f13252m.iterator();
            while (it.hasNext()) {
                ((LoggerContextListener) it.next()).u0(this, level);
            }
        } finally {
        }
    }

    @Override // org.slf4j.Logger
    public final void a(String str, Exception exc) {
        x(Level.f13237g, str, null, exc);
    }

    @Override // org.slf4j.Logger
    public final boolean b() {
        Logger logger;
        FilterReply filterReplyB;
        Level level = Level.f13237g;
        LoggerContext loggerContext = this.f13249h;
        int size = loggerContext.p.size();
        FilterReply filterReply = FilterReply.f13740b;
        if (size == 0) {
            logger = this;
            filterReplyB = filterReply;
        } else {
            logger = this;
            filterReplyB = loggerContext.p.b(level, logger, null, null, null);
        }
        if (filterReplyB == filterReply) {
            return logger.f13244c <= 10000;
        }
        if (filterReplyB == FilterReply.f13739a) {
            return false;
        }
        if (filterReplyB == FilterReply.f13741c) {
            return true;
        }
        throw new IllegalStateException("Unknown FilterReply value: " + filterReplyB);
    }

    @Override // org.slf4j.Logger
    public final void c(String str) {
        y(Level.f13234d, "DNSJavaNameService: invalid {}", str);
    }

    @Override // org.slf4j.Logger
    public final void d(String str, Object obj, Object obj2) {
        z(Level.f13238h, str, obj, obj2);
    }

    @Override // org.slf4j.Logger
    public final void e(String str, Object... objArr) {
        x(Level.f13235e, str, objArr, null);
    }

    @Override // org.slf4j.Logger
    public final boolean f() {
        Logger logger;
        FilterReply filterReplyB;
        Level level = Level.f13238h;
        LoggerContext loggerContext = this.f13249h;
        int size = loggerContext.p.size();
        FilterReply filterReply = FilterReply.f13740b;
        if (size == 0) {
            logger = this;
            filterReplyB = filterReply;
        } else {
            logger = this;
            filterReplyB = loggerContext.p.b(level, logger, null, null, null);
        }
        if (filterReplyB == filterReply) {
            return logger.f13244c <= 5000;
        }
        if (filterReplyB == FilterReply.f13739a) {
            return false;
        }
        if (filterReplyB == FilterReply.f13741c) {
            return true;
        }
        throw new IllegalStateException("Unknown FilterReply value: " + filterReplyB);
    }

    @Override // org.slf4j.Logger
    public final void g(String str, Object... objArr) {
        x(Level.f13237g, str, objArr, null);
    }

    @Override // org.slf4j.Logger
    public final String getName() {
        return this.f13242a;
    }

    @Override // org.slf4j.Logger
    public final void h(String str, Object obj, Exception exc) {
        z(Level.f13235e, str, obj, exc);
    }

    @Override // org.slf4j.Logger
    public final void i(String str, Object... objArr) {
        x(Level.f13238h, str, objArr, null);
    }

    @Override // org.slf4j.Logger
    public final void j(String str, Exception exc) {
        x(Level.f13234d, str, null, exc);
    }

    @Override // org.slf4j.Logger
    public final void k(Object... objArr) {
        x(Level.f13236f, "RRset <{}/{}/{}> failed to verify due to a lack of signatures", objArr, null);
    }

    @Override // org.slf4j.Logger
    public final void l(Instant instant) {
        y(Level.f13236f, "Local hosts database has changed at {}, clearing cache", instant);
    }

    @Override // org.slf4j.Logger
    public final void m(Object obj, String str) {
        y(Level.f13238h, str, obj);
    }

    @Override // org.slf4j.Logger
    public final void n(Object obj, String str) {
        y(Level.f13235e, str, obj);
    }

    @Override // org.slf4j.Logger
    public final void o(String str) {
        x(Level.f13237g, str, null, null);
    }

    @Override // org.slf4j.Logger
    public final void p(Object... objArr) {
        x(Level.f13234d, "Failed to validate RRset <{}/{}/{}>", objArr, null);
    }

    @Override // org.slf4j.Logger
    public final void q(String str) {
        x(Level.f13235e, str, null, null);
    }

    @Override // org.slf4j.Logger
    public final void r(String str) {
        x(Level.f13238h, str, null, null);
    }

    @Override // ch.qos.logback.core.spi.AppenderAttachable
    public final synchronized void r0(Appender appender) {
        try {
            if (this.f13247f == null) {
                this.f13247f = new AppenderAttachableImpl();
            }
            this.f13247f.r0(appender);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // org.slf4j.Logger
    public final void s(Object obj, String str) {
        y(Level.f13237g, str, obj);
    }

    @Override // org.slf4j.Logger
    public final void t(String str, Exception exc) {
        x(Level.f13235e, str, null, exc);
    }

    public final String toString() {
        return b.r(new StringBuilder("Logger["), this.f13242a, "]");
    }

    @Override // org.slf4j.Logger
    public final void u(String str, Object obj, Serializable serializable) {
        z(Level.f13237g, str, obj, serializable);
    }

    public final void v(ILoggingEvent iLoggingEvent) {
        int iA = 0;
        for (Logger logger = this; logger != null; logger = logger.f13245d) {
            AppenderAttachableImpl appenderAttachableImpl = logger.f13247f;
            iA += appenderAttachableImpl != null ? appenderAttachableImpl.a(iLoggingEvent) : 0;
            if (!logger.f13248g) {
                break;
            }
        }
        if (iA == 0) {
            LoggerContext loggerContext = this.f13249h;
            int i2 = loggerContext.f13251l;
            loggerContext.f13251l = i2 + 1;
            if (i2 == 0) {
                BasicStatusManager basicStatusManager = loggerContext.f13434c;
                StringBuilder sb = new StringBuilder("No appenders present in context [");
                sb.append(loggerContext.f13433b);
                sb.append("] for logger [");
                basicStatusManager.a(new WarnStatus(b.r(sb, this.f13242a, "]."), this));
            }
        }
    }

    public final Logger w(String str) {
        String str2 = this.f13242a;
        int length = str2.length() + 1;
        int iIndexOf = str.indexOf(46, length);
        int iIndexOf2 = str.indexOf(36, length);
        if (iIndexOf == -1 && iIndexOf2 == -1) {
            iIndexOf = -1;
        } else if (iIndexOf == -1 || (iIndexOf2 != -1 && iIndexOf >= iIndexOf2)) {
            iIndexOf = iIndexOf2;
        }
        if (iIndexOf != -1) {
            StringBuilder sbV = e.v("For logger [", str2, "] child name [", str, " passed as parameter, may not include '.' after index");
            sbV.append(str2.length() + 1);
            throw new IllegalArgumentException(sbV.toString());
        }
        if (this.f13246e == null) {
            this.f13246e = new CopyOnWriteArrayList();
        }
        Logger logger = new Logger(str, this, this.f13249h);
        this.f13246e.add(logger);
        logger.f13244c = this.f13244c;
        return logger;
    }

    public final void x(Level level, String str, Object[] objArr, Exception exc) {
        Logger logger;
        Level level2;
        String str2;
        Object[] objArr2;
        Exception exc2;
        FilterReply filterReplyB;
        LoggerContext loggerContext = this.f13249h;
        int size = loggerContext.p.size();
        FilterReply filterReply = FilterReply.f13740b;
        if (size == 0) {
            logger = this;
            level2 = level;
            str2 = str;
            objArr2 = objArr;
            exc2 = exc;
            filterReplyB = filterReply;
        } else {
            logger = this;
            level2 = level;
            str2 = str;
            objArr2 = objArr;
            exc2 = exc;
            filterReplyB = loggerContext.p.b(level2, logger, exc2, str2, objArr2);
        }
        if (filterReplyB == filterReply) {
            if (logger.f13244c > level2.f13240a) {
                return;
            }
        } else if (filterReplyB == FilterReply.f13739a) {
            return;
        }
        v(new LoggingEvent(level2, logger, exc2, str2, objArr2));
    }

    public final void y(Level level, String str, Object obj) {
        Logger logger;
        Level level2;
        String str2;
        FilterReply filterReplyB;
        LoggerContext loggerContext = this.f13249h;
        int size = loggerContext.p.size();
        FilterReply filterReply = FilterReply.f13740b;
        if (size == 0) {
            logger = this;
            level2 = level;
            str2 = str;
            filterReplyB = filterReply;
        } else {
            logger = this;
            level2 = level;
            str2 = str;
            filterReplyB = loggerContext.p.b(level2, logger, null, str2, new Object[]{obj});
        }
        if (filterReplyB == filterReply) {
            if (logger.f13244c > level2.f13240a) {
                return;
            }
        } else if (filterReplyB == FilterReply.f13739a) {
            return;
        }
        v(new LoggingEvent(level2, logger, null, str2, new Object[]{obj}));
    }

    public final void z(Level level, String str, Object obj, Object obj2) {
        Logger logger;
        Level level2;
        String str2;
        FilterReply filterReplyB;
        LoggerContext loggerContext = this.f13249h;
        int size = loggerContext.p.size();
        FilterReply filterReply = FilterReply.f13740b;
        if (size == 0) {
            logger = this;
            level2 = level;
            str2 = str;
            filterReplyB = filterReply;
        } else {
            logger = this;
            level2 = level;
            str2 = str;
            filterReplyB = loggerContext.p.b(level2, logger, null, str2, new Object[]{obj, obj2});
        }
        if (filterReplyB == filterReply) {
            if (logger.f13244c > level2.f13240a) {
                return;
            }
        } else if (filterReplyB == FilterReply.f13739a) {
            return;
        }
        v(new LoggingEvent(level2, logger, null, str2, new Object[]{obj, obj2}));
    }
}
