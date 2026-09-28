package ch.qos.logback.core;

import ch.qos.logback.core.joran.spi.ConsoleTarget;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class ConsoleAppender<E> extends OutputStreamAppender<E> {
    public final ConsoleTarget n = ConsoleTarget.SystemOut;

    @Override // ch.qos.logback.core.OutputStreamAppender, ch.qos.logback.core.UnsynchronizedAppenderBase, ch.qos.logback.core.spi.LifeCycle
    public final void start() {
        OutputStream outputStream = this.n.f13554b;
        System.getProperty("os.name").startsWith("Windows");
        X1(outputStream);
        super.start();
    }
}
