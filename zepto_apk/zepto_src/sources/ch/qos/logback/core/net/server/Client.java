package ch.qos.logback.core.net.server;

import java.io.Closeable;

/* loaded from: classes3.dex */
public interface Client extends Runnable, Closeable, AutoCloseable {
    void close();
}
