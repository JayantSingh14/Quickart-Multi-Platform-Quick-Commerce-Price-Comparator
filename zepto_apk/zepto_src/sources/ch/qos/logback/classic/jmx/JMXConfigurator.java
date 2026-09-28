package ch.qos.logback.classic.jmx;

import android.support.v4.media.b;
import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.spi.LoggerContextListener;
import ch.qos.logback.core.spi.ContextAwareBase;
import java.util.ArrayList;
import java.util.Iterator;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.ObjectName;

/* loaded from: classes3.dex */
public class JMXConfigurator extends ContextAwareBase implements JMXConfiguratorMBean, LoggerContextListener {

    /* renamed from: d, reason: collision with root package name */
    public LoggerContext f13276d;

    /* renamed from: e, reason: collision with root package name */
    public MBeanServer f13277e;

    /* renamed from: f, reason: collision with root package name */
    public ObjectName f13278f;

    /* renamed from: g, reason: collision with root package name */
    public final String f13279g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f13280h = true;

    public JMXConfigurator(LoggerContext loggerContext, MBeanServer mBeanServer, ObjectName objectName) {
        this.f13733b = loggerContext;
        this.f13276d = loggerContext;
        this.f13277e = mBeanServer;
        this.f13278f = objectName;
        String string = objectName.toString();
        this.f13279g = string;
        if (!T1()) {
            loggerContext.f13252m.add(this);
            return;
        }
        StringBuilder sbY = b.y("Previously registered JMXConfigurator named [", string, "] in the logger context named [");
        sbY.append(loggerContext.f13433b);
        sbY.append("]");
        l1(sbY.toString());
    }

    @Override // ch.qos.logback.classic.spi.LoggerContextListener
    public final void T0() {
        s1("onReset() method called JMXActivator [" + this.f13279g + "]");
    }

    public final boolean T1() {
        LoggerContext loggerContext = this.f13276d;
        loggerContext.getClass();
        Iterator it = new ArrayList(loggerContext.f13252m).iterator();
        while (it.hasNext()) {
            LoggerContextListener loggerContextListener = (LoggerContextListener) it.next();
            if ((loggerContextListener instanceof JMXConfigurator) && this.f13278f.equals(((JMXConfigurator) loggerContextListener).f13278f)) {
                return true;
            }
        }
        return false;
    }

    @Override // ch.qos.logback.classic.spi.LoggerContextListener
    public final void e() {
        boolean z = this.f13280h;
        String str = this.f13279g;
        if (!z) {
            s1("onStop() method called on a stopped JMXActivator [" + str + "]");
            return;
        }
        if (this.f13277e.isRegistered(this.f13278f)) {
            try {
                s1("Unregistering mbean [" + str + "]");
                this.f13277e.unregisterMBean(this.f13278f);
            } catch (InstanceNotFoundException e2) {
                o1("Unable to find a verifiably registered mbean [" + str + "]", e2);
            } catch (MBeanRegistrationException e3) {
                o1("Failed to unregister [" + str + "]", e3);
            }
        } else {
            s1("mbean [" + str + "] was not in the mbean registry. This is OK.");
        }
        this.f13280h = false;
        this.f13277e = null;
        this.f13278f = null;
        this.f13276d = null;
    }

    @Override // ch.qos.logback.classic.spi.LoggerContextListener
    public final boolean l() {
        return true;
    }

    public final String toString() {
        return getClass().getName() + "(" + this.f13733b.getName() + ")";
    }

    @Override // ch.qos.logback.classic.spi.LoggerContextListener
    public final void u0(Logger logger, Level level) {
    }
}
