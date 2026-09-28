package ch.qos.logback.core.net.server;

import ch.qos.logback.core.spi.ContextAware;
import java.io.Serializable;
import java.util.concurrent.ArrayBlockingQueue;

/* loaded from: classes3.dex */
interface RemoteReceiverClient extends Client, ContextAware {
    void L1(ArrayBlockingQueue arrayBlockingQueue);

    boolean b1(Serializable serializable);
}
