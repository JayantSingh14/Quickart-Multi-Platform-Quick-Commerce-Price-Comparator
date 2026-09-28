package org.slf4j;

import ch.qos.logback.classic.util.LogbackMDCAdapter;
import java.io.Closeable;
import org.slf4j.helpers.NOPMDCAdapter;
import org.slf4j.helpers.Util;
import org.slf4j.impl.StaticMDCBinder;
import org.slf4j.spi.MDCAdapter;

/* loaded from: classes5.dex */
public class MDC {

    /* renamed from: a, reason: collision with root package name */
    public static final MDCAdapter f57876a;

    public static class MDCCloseable implements Closeable, AutoCloseable {
        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            MDCAdapter mDCAdapter = MDC.f57876a;
            throw new IllegalArgumentException("key parameter cannot be null");
        }
    }

    static {
        try {
            f57876a = a();
        } catch (Exception e2) {
            Util.c("MDC binding unsuccessful.", e2);
        } catch (NoClassDefFoundError e3) {
            f57876a = new NOPMDCAdapter();
            String message = e3.getMessage();
            if (message == null || !message.contains("StaticMDCBinder")) {
                throw e3;
            }
            Util.b("Failed to load class \"org.slf4j.impl.StaticMDCBinder\".");
            Util.b("Defaulting to no-operation MDCAdapter implementation.");
            Util.b("See http://www.slf4j.org/codes.html#no_static_mdc_binder for further details.");
        }
    }

    public static LogbackMDCAdapter a() {
        try {
            StaticMDCBinder.getSingleton().getClass();
            return new LogbackMDCAdapter();
        } catch (NoSuchMethodError unused) {
            return new LogbackMDCAdapter();
        }
    }
}
