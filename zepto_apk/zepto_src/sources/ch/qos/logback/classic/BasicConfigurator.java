package ch.qos.logback.classic;

import ch.qos.logback.classic.layout.TTLLLayout;
import ch.qos.logback.classic.spi.Configurator;
import ch.qos.logback.core.ConsoleAppender;
import ch.qos.logback.core.encoder.LayoutWrappingEncoder;
import ch.qos.logback.core.spi.ContextAwareBase;

/* loaded from: classes.dex */
public class BasicConfigurator extends ContextAwareBase implements Configurator {
    @Override // ch.qos.logback.classic.spi.Configurator
    public final void r(LoggerContext loggerContext) {
        s1("Setting up default configuration.");
        ConsoleAppender consoleAppender = new ConsoleAppender();
        consoleAppender.V(loggerContext);
        consoleAppender.f13453f = "console";
        LayoutWrappingEncoder layoutWrappingEncoder = new LayoutWrappingEncoder();
        layoutWrappingEncoder.V(loggerContext);
        TTLLLayout tTLLLayout = new TTLLLayout();
        tTLLLayout.f13733b = loggerContext;
        tTLLLayout.start();
        layoutWrappingEncoder.f13476e = tTLLLayout;
        consoleAppender.f13447j = layoutWrappingEncoder;
        consoleAppender.start();
        loggerContext.c("ROOT").r0(consoleAppender);
    }
}
