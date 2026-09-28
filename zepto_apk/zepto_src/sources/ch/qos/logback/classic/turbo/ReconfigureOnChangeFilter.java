package ch.qos.logback.classic.turbo;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.gaffer.GafferUtil;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.classic.util.EnvUtil;
import ch.qos.logback.core.joran.GenericConfigurator;
import ch.qos.logback.core.joran.spi.ConfigurationWatchList;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.joran.util.ConfigurationWatchListUtil;
import ch.qos.logback.core.spi.FilterReply;
import ch.qos.logback.core.status.StatusUtil;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.time.DateUtils;

/* loaded from: classes3.dex */
public class ReconfigureOnChangeFilter extends TurboFilter {

    /* renamed from: f, reason: collision with root package name */
    public URL f13401f;

    /* renamed from: g, reason: collision with root package name */
    public volatile long f13402g;

    /* renamed from: h, reason: collision with root package name */
    public ConfigurationWatchList f13403h;

    /* renamed from: e, reason: collision with root package name */
    public final long f13400e = DateUtils.MILLIS_PER_MINUTE;

    /* renamed from: i, reason: collision with root package name */
    public long f13404i = 0;

    /* renamed from: j, reason: collision with root package name */
    public volatile long f13405j = 15;

    /* renamed from: k, reason: collision with root package name */
    public volatile long f13406k = System.currentTimeMillis();

    public class ReconfiguringThread implements Runnable {
        public ReconfiguringThread() {
        }

        public final void a(LoggerContext loggerContext, List list, URL url) {
            JoranConfigurator joranConfigurator = new JoranConfigurator();
            ReconfigureOnChangeFilter reconfigureOnChangeFilter = ReconfigureOnChangeFilter.this;
            joranConfigurator.V(reconfigureOnChangeFilter.f13733b);
            if (list == null) {
                reconfigureOnChangeFilter.J1("No previous configuration to fall back on.");
                return;
            }
            reconfigureOnChangeFilter.J1("Falling back to previously registered safe configuration.");
            try {
                loggerContext.f();
                GenericConfigurator.b2(reconfigureOnChangeFilter.f13733b, url);
                joranConfigurator.Z1(list);
                reconfigureOnChangeFilter.s1("Re-registering previous fallback configuration once more as a fallback configuration point");
                joranConfigurator.f13733b.O(list, "SAFE_JORAN_CONFIGURATION");
            } catch (JoranException e2) {
                reconfigureOnChangeFilter.o1("Unexpected exception thrown by a configuration considered safe.", e2);
            }
        }

        @Override // java.lang.Runnable
        public final void run() throws IOException {
            ReconfigureOnChangeFilter reconfigureOnChangeFilter = ReconfigureOnChangeFilter.this;
            if (reconfigureOnChangeFilter.f13401f == null) {
                reconfigureOnChangeFilter.s1("Due to missing top level configuration file, skipping reconfiguration");
                return;
            }
            LoggerContext loggerContext = (LoggerContext) reconfigureOnChangeFilter.f13733b;
            reconfigureOnChangeFilter.s1("Will reset and reconfigure context named [" + reconfigureOnChangeFilter.f13733b.getName() + "]");
            if (!reconfigureOnChangeFilter.f13401f.toString().endsWith("xml")) {
                if (reconfigureOnChangeFilter.f13401f.toString().endsWith("groovy")) {
                    if (!EnvUtil.a()) {
                        reconfigureOnChangeFilter.l1("Groovy classes are not available on the class path. ABORTING INITIALIZATION.");
                        return;
                    } else {
                        loggerContext.f();
                        GafferUtil.b(loggerContext, this, reconfigureOnChangeFilter.f13401f);
                        return;
                    }
                }
                return;
            }
            JoranConfigurator joranConfigurator = new JoranConfigurator();
            joranConfigurator.V(reconfigureOnChangeFilter.f13733b);
            StatusUtil statusUtil = new StatusUtil(reconfigureOnChangeFilter.f13733b);
            List list = (List) joranConfigurator.f13733b.n0("SAFE_JORAN_CONFIGURATION");
            ConfigurationWatchList configurationWatchListA = ConfigurationWatchListUtil.a(reconfigureOnChangeFilter.f13733b);
            URL url = configurationWatchListA == null ? null : configurationWatchListA.f13548d;
            loggerContext.f();
            long jCurrentTimeMillis = System.currentTimeMillis();
            try {
                joranConfigurator.Y1(reconfigureOnChangeFilter.f13401f);
                if (statusUtil.b(jCurrentTimeMillis)) {
                    a(loggerContext, list, url);
                }
            } catch (JoranException unused) {
                a(loggerContext, list, url);
            }
        }
    }

    @Override // ch.qos.logback.classic.turbo.TurboFilter
    public final FilterReply T1(Level level, String str) {
        boolean zU1;
        if (!this.f13408d) {
            return FilterReply.f13740b;
        }
        long j2 = this.f13404i;
        this.f13404i = j2 + 1;
        if ((j2 & this.f13405j) != this.f13405j) {
            return FilterReply.f13740b;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (this.f13403h) {
            try {
                long j3 = jCurrentTimeMillis - this.f13406k;
                this.f13406k = jCurrentTimeMillis;
                if (j3 < 100 && this.f13405j < 65535) {
                    this.f13405j = 1 | (this.f13405j << 1);
                } else if (j3 > 800) {
                    this.f13405j >>>= 2;
                }
                if (jCurrentTimeMillis >= this.f13402g) {
                    this.f13402g = jCurrentTimeMillis + this.f13400e;
                    zU1 = this.f13403h.U1();
                } else {
                    zU1 = false;
                }
                if (zU1) {
                    this.f13402g = Long.MAX_VALUE;
                    U1();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return FilterReply.f13740b;
    }

    public final void U1() {
        StringBuilder sb = new StringBuilder("Detected change in [");
        ConfigurationWatchList configurationWatchList = this.f13403h;
        configurationWatchList.getClass();
        sb.append(new ArrayList(configurationWatchList.f13549e));
        sb.append("]");
        s1(sb.toString());
        this.f13733b.l0().submit(new ReconfiguringThread());
    }

    @Override // ch.qos.logback.classic.turbo.TurboFilter, ch.qos.logback.core.spi.LifeCycle
    public final void start() {
        ConfigurationWatchList configurationWatchListA = ConfigurationWatchListUtil.a(this.f13733b);
        this.f13403h = configurationWatchListA;
        if (configurationWatchListA == null) {
            J1("Empty ConfigurationWatchList in context");
            return;
        }
        URL url = configurationWatchListA.f13548d;
        this.f13401f = url;
        if (url == null) {
            J1("Due to missing top level configuration file, automatic reconfiguration is impossible.");
            return;
        }
        s1("Will scan for changes in [" + new ArrayList(configurationWatchListA.f13549e) + "] every " + (this.f13400e / 1000) + " seconds. ");
        synchronized (this.f13403h) {
            this.f13402g = System.currentTimeMillis() + this.f13400e;
        }
        this.f13408d = true;
    }

    public final String toString() {
        return "ReconfigureOnChangeFilter{invocationCounter=" + this.f13404i + '}';
    }
}
