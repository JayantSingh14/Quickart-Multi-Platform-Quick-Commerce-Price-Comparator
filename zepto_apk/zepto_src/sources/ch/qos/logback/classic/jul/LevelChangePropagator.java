package ch.qos.logback.classic.jul;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.spi.LoggerComparator;
import ch.qos.logback.classic.spi.LoggerContextListener;
import ch.qos.logback.core.spi.ContextAwareBase;
import ch.qos.logback.core.spi.LifeCycle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class LevelChangePropagator extends ContextAwareBase implements LoggerContextListener, LifeCycle {

    /* renamed from: d, reason: collision with root package name */
    public final HashSet f13289d = new HashSet();

    /* renamed from: e, reason: collision with root package name */
    public boolean f13290e = false;

    public final void T1(Logger logger, Level level) throws SecurityException {
        java.util.logging.Level level2;
        s1("Propagating " + level + " level on " + logger + " onto the JUL framework");
        String str = logger.f13242a;
        if ("ROOT".equals(str)) {
            str = "";
        }
        java.util.logging.Logger logger2 = java.util.logging.Logger.getLogger(str);
        this.f13289d.add(logger2);
        if (level == null) {
            throw new IllegalArgumentException("Unexpected level [null]");
        }
        int i2 = level.f13240a;
        if (i2 == Integer.MIN_VALUE) {
            level2 = java.util.logging.Level.ALL;
        } else if (i2 == 5000) {
            level2 = java.util.logging.Level.FINEST;
        } else if (i2 == 10000) {
            level2 = java.util.logging.Level.FINE;
        } else if (i2 == 20000) {
            level2 = java.util.logging.Level.INFO;
        } else if (i2 == 30000) {
            level2 = java.util.logging.Level.WARNING;
        } else if (i2 == 40000) {
            level2 = java.util.logging.Level.SEVERE;
        } else {
            if (i2 != Integer.MAX_VALUE) {
                throw new IllegalArgumentException("Unexpected level [" + level + "]");
            }
            level2 = java.util.logging.Level.OFF;
        }
        logger2.setLevel(level2);
    }

    @Override // ch.qos.logback.core.spi.LifeCycle
    public final boolean isStarted() {
        return this.f13290e;
    }

    @Override // ch.qos.logback.classic.spi.LoggerContextListener
    public final boolean l() {
        return false;
    }

    @Override // ch.qos.logback.core.spi.LifeCycle
    public final void start() throws SecurityException {
        ArrayList arrayList = new ArrayList(((LoggerContext) this.f13733b).n.values());
        Collections.sort(arrayList, new LoggerComparator());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Logger logger = (Logger) it.next();
            Level level = logger.f13243b;
            if (level != null) {
                T1(logger, level);
            }
        }
        this.f13290e = true;
    }

    @Override // ch.qos.logback.core.spi.LifeCycle
    public final void stop() {
        this.f13290e = false;
    }

    @Override // ch.qos.logback.classic.spi.LoggerContextListener
    public final void u0(Logger logger, Level level) throws SecurityException {
        T1(logger, level);
    }

    @Override // ch.qos.logback.classic.spi.LoggerContextListener
    public final void T0() {
    }

    @Override // ch.qos.logback.classic.spi.LoggerContextListener
    public final void e() {
    }
}
