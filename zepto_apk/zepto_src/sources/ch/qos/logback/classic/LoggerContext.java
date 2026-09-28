package ch.qos.logback.classic;

import android.support.v4.media.b;
import ch.qos.logback.classic.spi.LoggerContextListener;
import ch.qos.logback.classic.spi.LoggerContextVO;
import ch.qos.logback.classic.spi.TurboFilterList;
import ch.qos.logback.classic.turbo.TurboFilter;
import ch.qos.logback.core.BasicStatusManager;
import ch.qos.logback.core.ContextBase;
import ch.qos.logback.core.spi.LifeCycle;
import ch.qos.logback.core.status.StatusListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledFuture;
import org.slf4j.ILoggerFactory;

/* loaded from: classes.dex */
public class LoggerContext extends ContextBase implements ILoggerFactory, LifeCycle {

    /* renamed from: k, reason: collision with root package name */
    public final Logger f13250k;
    public final ConcurrentHashMap n;
    public LoggerContextVO o;
    public final ArrayList s;

    /* renamed from: l, reason: collision with root package name */
    public int f13251l = 0;

    /* renamed from: m, reason: collision with root package name */
    public final ArrayList f13252m = new ArrayList();
    public final TurboFilterList p = new TurboFilterList();
    public boolean q = false;
    public final int r = 8;

    public LoggerContext() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.n = concurrentHashMap;
        this.o = new LoggerContextVO(this);
        Logger logger = new Logger("ROOT", null, this);
        this.f13250k = logger;
        logger.E(Level.f13237g);
        concurrentHashMap.put("ROOT", logger);
        O(new HashMap(), "EVALUATOR_MAP");
        this.s = new ArrayList();
    }

    @Override // ch.qos.logback.core.ContextBase, ch.qos.logback.core.Context
    public final void a(String str) {
        super.a(str);
        this.o = new LoggerContextVO(this);
    }

    @Override // org.slf4j.ILoggerFactory
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public final Logger c(String str) {
        Logger loggerW;
        if (str == null) {
            throw new IllegalArgumentException("name argument cannot be null");
        }
        if ("ROOT".equalsIgnoreCase(str)) {
            return this.f13250k;
        }
        Logger logger = this.f13250k;
        Logger logger2 = (Logger) this.n.get(str);
        if (logger2 != null) {
            return logger2;
        }
        int i2 = 0;
        while (true) {
            int iIndexOf = str.indexOf(46, i2);
            int iIndexOf2 = str.indexOf(36, i2);
            if (iIndexOf == -1 && iIndexOf2 == -1) {
                iIndexOf = -1;
            } else if (iIndexOf == -1 || (iIndexOf2 != -1 && iIndexOf >= iIndexOf2)) {
                iIndexOf = iIndexOf2;
            }
            String strSubstring = iIndexOf == -1 ? str : str.substring(0, iIndexOf);
            int i3 = iIndexOf + 1;
            synchronized (logger) {
                try {
                    CopyOnWriteArrayList copyOnWriteArrayList = logger.f13246e;
                    Logger logger3 = null;
                    if (copyOnWriteArrayList != null) {
                        int size = copyOnWriteArrayList.size();
                        int i4 = 0;
                        while (true) {
                            if (i4 >= size) {
                                break;
                            }
                            Logger logger4 = (Logger) logger.f13246e.get(i4);
                            if (strSubstring.equals(logger4.f13242a)) {
                                logger3 = logger4;
                                break;
                            }
                            i4++;
                        }
                    }
                    if (logger3 == null) {
                        loggerW = logger.w(strSubstring);
                        this.n.put(strSubstring, loggerW);
                    } else {
                        loggerW = logger3;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (iIndexOf == -1) {
                return loggerW;
            }
            i2 = i3;
            logger = loggerW;
        }
    }

    public final void f() {
        Thread thread = (Thread) this.f13436e.get("SHUTDOWN_HOOK");
        HashMap map = this.f13436e;
        if (thread != null) {
            map.remove("SHUTDOWN_HOOK");
            try {
                Runtime.getRuntime().removeShutdownHook(thread);
            } catch (IllegalStateException unused) {
            }
        }
        d().b();
        this.f13435d.clear();
        map.clear();
        O(new HashMap(), "EVALUATOR_MAP");
        O(new HashMap(), "FA_FILENAME_COLLISION_MAP");
        O(new HashMap(), "RFA_FILENAME_PATTERN_COLLISION_MAP");
        this.f13250k.D();
        TurboFilterList turboFilterList = this.p;
        Iterator<TurboFilter> it = turboFilterList.iterator();
        while (it.hasNext()) {
            it.next().stop();
        }
        turboFilterList.clear();
        ArrayList arrayList = this.f13439h;
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((ScheduledFuture) it2.next()).cancel(false);
        }
        arrayList.clear();
        Iterator it3 = this.f13252m.iterator();
        while (it3.hasNext()) {
            ((LoggerContextListener) it3.next()).T0();
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = this.f13252m;
        Iterator it4 = arrayList3.iterator();
        while (it4.hasNext()) {
            LoggerContextListener loggerContextListener = (LoggerContextListener) it4.next();
            if (loggerContextListener.l()) {
                arrayList2.add(loggerContextListener);
            }
        }
        arrayList3.retainAll(arrayList2);
        BasicStatusManager basicStatusManager = this.f13434c;
        Iterator it5 = basicStatusManager.d().iterator();
        while (it5.hasNext()) {
            StatusListener statusListener = (StatusListener) it5.next();
            synchronized (basicStatusManager.f13431f) {
                basicStatusManager.f13430e.remove(statusListener);
            }
        }
    }

    @Override // ch.qos.logback.core.ContextBase, ch.qos.logback.core.Context
    public final void s0(String str, String str2) {
        super.s0(str, str2);
        this.o = new LoggerContextVO(this);
    }

    @Override // ch.qos.logback.core.ContextBase, ch.qos.logback.core.spi.LifeCycle
    public final void start() {
        this.f13441j = true;
        Iterator it = this.f13252m.iterator();
        while (it.hasNext()) {
            ((LoggerContextListener) it.next()).getClass();
        }
    }

    @Override // ch.qos.logback.core.ContextBase, ch.qos.logback.core.spi.LifeCycle
    public final void stop() {
        f();
        ArrayList arrayList = this.f13252m;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((LoggerContextListener) it.next()).e();
        }
        arrayList.clear();
        super.stop();
    }

    @Override // ch.qos.logback.core.ContextBase
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getName());
        sb.append("[");
        return b.r(sb, this.f13433b, "]");
    }
}
