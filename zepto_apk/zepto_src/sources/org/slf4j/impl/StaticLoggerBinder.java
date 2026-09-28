package org.slf4j.impl;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.util.ContextInitializer;
import ch.qos.logback.classic.util.ContextSelectorStaticBinder;
import ch.qos.logback.core.BasicStatusManager;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;
import in.juspay.hypersdk.analytics.LogConstants;
import org.slf4j.helpers.Util;
import org.slf4j.spi.LoggerFactoryBinder;

/* loaded from: classes.dex */
public class StaticLoggerBinder implements LoggerFactoryBinder {

    /* renamed from: d, reason: collision with root package name */
    public static final StaticLoggerBinder f57904d;

    /* renamed from: e, reason: collision with root package name */
    public static final Object f57905e;

    /* renamed from: a, reason: collision with root package name */
    public boolean f57906a = false;

    /* renamed from: b, reason: collision with root package name */
    public final LoggerContext f57907b;

    /* renamed from: c, reason: collision with root package name */
    public final ContextSelectorStaticBinder f57908c;

    static {
        StaticLoggerBinder staticLoggerBinder = new StaticLoggerBinder();
        f57904d = staticLoggerBinder;
        f57905e = new Object();
        LoggerContext loggerContext = staticLoggerBinder.f57907b;
        try {
            try {
                new ContextInitializer(loggerContext).a();
            } catch (JoranException e2) {
                Util.c("Failed to auto configure default logger context", e2);
            }
            BasicStatusManager basicStatusManager = loggerContext.f13434c;
            if (!((basicStatusManager == null || basicStatusManager.d().size() == 0) ? false : true)) {
                StatusPrinter.b(loggerContext);
            }
            staticLoggerBinder.f57908c.a(loggerContext, f57905e);
            staticLoggerBinder.f57906a = true;
        } catch (Exception e3) {
            Util.c("Failed to instantiate [" + LoggerContext.class.getName() + "]", e3);
        }
    }

    public StaticLoggerBinder() {
        LoggerContext loggerContext = new LoggerContext();
        this.f57907b = loggerContext;
        this.f57908c = ContextSelectorStaticBinder.f13410c;
        loggerContext.a(LogConstants.DEFAULT_CHANNEL);
    }
}
