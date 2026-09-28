package ch.qos.logback.classic.servlet;

import ch.qos.logback.core.spi.ContextAwareBase;
import javax.servlet.ServletContextListener;

/* loaded from: classes3.dex */
public class LogbackServletContextListener implements ServletContextListener {
    public LogbackServletContextListener() {
        new ContextAwareBase();
    }
}
