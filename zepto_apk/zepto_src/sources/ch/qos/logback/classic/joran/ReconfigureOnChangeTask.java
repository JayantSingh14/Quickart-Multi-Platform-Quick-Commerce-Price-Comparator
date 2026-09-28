package ch.qos.logback.classic.joran;

import android.support.v4.media.b;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.gaffer.GafferUtil;
import ch.qos.logback.classic.util.EnvUtil;
import ch.qos.logback.core.joran.event.SaxEvent;
import ch.qos.logback.core.joran.spi.ConfigurationWatchList;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.joran.util.ConfigurationWatchListUtil;
import ch.qos.logback.core.spi.ContextAwareBase;
import ch.qos.logback.core.status.StatusUtil;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class ReconfigureOnChangeTask extends ContextAwareBase implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    public final long f13281d = System.currentTimeMillis();

    public final void T1(LoggerContext loggerContext, List list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                SaxEvent saxEvent = (SaxEvent) it.next();
                if (!"include".equalsIgnoreCase(saxEvent.f13540a)) {
                    arrayList.add(saxEvent);
                }
            }
        }
        JoranConfigurator joranConfigurator = new JoranConfigurator();
        joranConfigurator.V(this.f13733b);
        ConfigurationWatchList configurationWatchListA = ConfigurationWatchListUtil.a(this.f13733b);
        configurationWatchListA.getClass();
        ConfigurationWatchList configurationWatchList = new ConfigurationWatchList();
        configurationWatchList.f13548d = configurationWatchListA.f13548d;
        configurationWatchList.f13549e = new ArrayList(configurationWatchListA.f13549e);
        configurationWatchList.f13550f = new ArrayList(configurationWatchListA.f13550f);
        if (arrayList.isEmpty()) {
            J1("No previous configuration to fall back on.");
            return;
        }
        J1("Given previous errors, falling back to previously registered safe configuration.");
        try {
            loggerContext.f();
            this.f13733b.O(configurationWatchList, "CONFIGURATION_WATCH_LIST");
            joranConfigurator.Z1(arrayList);
            s1("Re-registering previous fallback configuration once more as a fallback configuration point");
            joranConfigurator.f13733b.O(list, "SAFE_JORAN_CONFIGURATION");
            s1("after registerSafeConfiguration: " + list);
        } catch (JoranException e2) {
            o1("Unexpected exception thrown by a configuration considered safe.", e2);
        }
    }

    @Override // java.lang.Runnable
    public final void run() throws IOException {
        ConfigurationWatchList configurationWatchListA = ConfigurationWatchListUtil.a(this.f13733b);
        if (configurationWatchListA == null) {
            J1("Empty ConfigurationWatchList in context");
            return;
        }
        if (new ArrayList(configurationWatchListA.f13549e).isEmpty()) {
            s1("Empty watch file list. Disabling ");
            return;
        }
        if (configurationWatchListA.U1()) {
            URL url = configurationWatchListA.f13548d;
            s1("Detected change in configuration files.");
            s1("Will reset and reconfigure context named [" + this.f13733b.getName() + "]");
            LoggerContext loggerContext = (LoggerContext) this.f13733b;
            if (!url.toString().endsWith("xml")) {
                if (url.toString().endsWith("groovy")) {
                    if (!EnvUtil.a()) {
                        l1("Groovy classes are not available on the class path. ABORTING INITIALIZATION.");
                        return;
                    } else {
                        loggerContext.f();
                        GafferUtil.b(loggerContext, this, url);
                        return;
                    }
                }
                return;
            }
            JoranConfigurator joranConfigurator = new JoranConfigurator();
            joranConfigurator.V(this.f13733b);
            StatusUtil statusUtil = new StatusUtil(this.f13733b);
            List list = (List) joranConfigurator.f13733b.n0("SAFE_JORAN_CONFIGURATION");
            ConfigurationWatchListUtil.a(this.f13733b);
            loggerContext.f();
            long jCurrentTimeMillis = System.currentTimeMillis();
            try {
                joranConfigurator.Y1(url);
                if (statusUtil.b(jCurrentTimeMillis)) {
                    T1(loggerContext, list);
                }
            } catch (JoranException unused) {
                T1(loggerContext, list);
            }
        }
    }

    public final String toString() {
        return b.p(new StringBuilder("ReconfigureOnChangeTask(born:"), this.f13281d, ")");
    }
}
