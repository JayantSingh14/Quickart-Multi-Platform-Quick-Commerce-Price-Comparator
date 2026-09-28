package ch.qos.logback.classic.joran.action;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.ReconfigureOnChangeTask;
import ch.qos.logback.classic.util.EnvUtil;
import ch.qos.logback.core.Context;
import ch.qos.logback.core.joran.action.Action;
import ch.qos.logback.core.joran.spi.ConfigurationWatchList;
import ch.qos.logback.core.joran.spi.InterpretationContext;
import ch.qos.logback.core.joran.util.ConfigurationWatchListUtil;
import ch.qos.logback.core.status.OnConsoleStatusListener;
import ch.qos.logback.core.util.ContextUtil;
import ch.qos.logback.core.util.Duration;
import ch.qos.logback.core.util.OptionHelper;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.xml.sax.helpers.AttributesImpl;

/* loaded from: classes3.dex */
public class ConfigurationAction extends Action {
    @Override // ch.qos.logback.core.joran.action.Action
    public final void T1(InterpretationContext interpretationContext, String str, AttributesImpl attributesImpl) {
        String strX1;
        System.currentTimeMillis();
        Duration durationA = null;
        try {
            strX1 = System.getProperty("logback.debug");
        } catch (SecurityException unused) {
            strX1 = null;
        }
        if (strX1 == null) {
            strX1 = interpretationContext.X1(attributesImpl.getValue("debug"));
        }
        if (OptionHelper.b(strX1) || strX1.equalsIgnoreCase("false") || strX1.equalsIgnoreCase("null")) {
            s1("debug attribute not set");
        } else {
            Context context = this.f13733b;
            OnConsoleStatusListener onConsoleStatusListener = new OnConsoleStatusListener();
            onConsoleStatusListener.V(context);
            if (context.D().c(onConsoleStatusListener)) {
                onConsoleStatusListener.start();
            }
        }
        String strX12 = interpretationContext.X1(attributesImpl.getValue("scan"));
        if (!OptionHelper.b(strX12) && !"false".equalsIgnoreCase(strX12)) {
            ScheduledExecutorService scheduledExecutorServiceT = this.f13733b.T();
            ConfigurationWatchList configurationWatchListA = ConfigurationWatchListUtil.a(this.f13733b);
            URL url = configurationWatchListA == null ? null : configurationWatchListA.f13548d;
            if (url == null) {
                J1("Due to missing top level configuration file, reconfiguration on change (configuration file scanning) cannot be done.");
            } else {
                URL url2 = url;
                ReconfigureOnChangeTask reconfigureOnChangeTask = new ReconfigureOnChangeTask();
                reconfigureOnChangeTask.V(this.f13733b);
                this.f13733b.O(reconfigureOnChangeTask, "RECONFIGURE_ON_CHANGE_TASK");
                String strX13 = interpretationContext.X1(attributesImpl.getValue("scanPeriod"));
                if (!OptionHelper.b(strX13)) {
                    try {
                        durationA = Duration.a(strX13);
                    } catch (NumberFormatException e2) {
                        o1("Error while converting [" + strX12 + "] to long", e2);
                    }
                }
                if (durationA != null) {
                    s1("Will scan for changes in [" + url2 + "] ");
                    StringBuilder sb = new StringBuilder("Setting ReconfigureOnChangeTask scanning period to ");
                    sb.append(durationA);
                    s1(sb.toString());
                    TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                    long j2 = durationA.f13804a;
                    this.f13733b.s(scheduledExecutorServiceT.scheduleAtFixedRate(reconfigureOnChangeTask, j2, j2, timeUnit));
                }
            }
        }
        LoggerContext loggerContext = (LoggerContext) this.f13733b;
        loggerContext.q = OptionHelper.d(interpretationContext.X1(attributesImpl.getValue("packagingData")), false);
        if (EnvUtil.a()) {
            new ContextUtil(this.f13733b);
            ArrayList arrayList = loggerContext.s;
            if (!arrayList.contains("org.codehaus.groovy.runtime")) {
                arrayList.add("org.codehaus.groovy.runtime");
            }
        }
        interpretationContext.W1(this.f13733b);
    }

    @Override // ch.qos.logback.core.joran.action.Action
    public final void V1(InterpretationContext interpretationContext, String str) {
        s1("End of configuration.");
        interpretationContext.V1();
    }
}
