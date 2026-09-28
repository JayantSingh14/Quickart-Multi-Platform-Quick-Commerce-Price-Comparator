package org.xbill.DNS;

import java.io.IOException;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedSelectorException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xbill.DNS.utils.hexdump;

/* loaded from: classes5.dex */
public abstract class NioClient {
    private static Thread closeThread;
    private static volatile boolean run;
    private static volatile Selector selector;
    private static Thread selectorThread;

    @Generated
    private static final Logger log = LoggerFactory.b(NioClient.class);
    private static PacketLogger packetLogger = null;
    private static final Runnable[] TIMEOUT_TASKS = new Runnable[2];
    private static final Runnable[] REGISTRATIONS_TASKS = new Runnable[2];
    private static final Runnable[] CLOSE_TASKS = new Runnable[2];

    public interface KeyProcessor {
        void processReadyKey(SelectionKey selectionKey);
    }

    private static void addTask(Runnable[] runnableArr, Runnable runnable, boolean z) {
        if (z) {
            runnableArr[0] = runnable;
        } else {
            runnableArr[1] = runnable;
        }
    }

    public static void close() throws InterruptedException, IOException {
        close(false);
    }

    private static void processReadyKeys() {
        Iterator<SelectionKey> it = selector.selectedKeys().iterator();
        while (it.hasNext()) {
            SelectionKey next = it.next();
            it.remove();
            ((KeyProcessor) next.attachment()).processReadyKey(next);
        }
    }

    public static void runSelector() {
        int iIntValue = Integer.getInteger("dnsjava.nio.selector_timeout", 1000).intValue();
        if (iIntValue <= 0 || iIntValue > 1000) {
            throw new IllegalArgumentException("Invalid selector_timeout, must be between 1 and 1000");
        }
        while (run) {
            try {
                if (selector.select(iIntValue) == 0) {
                    runTasks(TIMEOUT_TASKS);
                }
                if (run) {
                    runTasks(REGISTRATIONS_TASKS);
                    processReadyKeys();
                }
            } catch (IOException e2) {
                log.j("A selection operation failed", e2);
            } catch (ClosedSelectorException unused) {
            }
        }
        log.o("dnsjava NIO selector thread stopped");
    }

    private static synchronized void runTasks(Runnable[] runnableArr) {
        try {
            Runnable runnable = runnableArr[0];
            if (runnable != null) {
                runnable.run();
            }
            Runnable runnable2 = runnableArr[1];
            if (runnable2 != null) {
                runnable2.run();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public static Selector selector() throws IOException {
        if (selector == null) {
            synchronized (NioClient.class) {
                try {
                    if (selector == null) {
                        selector = Selector.open();
                        log.o("Starting dnsjava NIO selector thread");
                        run = true;
                        final int i2 = 0;
                        Thread thread = new Thread(new Runnable() { // from class: org.xbill.DNS.s
                            @Override // java.lang.Runnable
                            public final void run() throws InterruptedException, IOException {
                                switch (i2) {
                                    case 0:
                                        NioClient.runSelector();
                                        break;
                                    default:
                                        NioClient.close(true);
                                        break;
                                }
                            }
                        });
                        selectorThread = thread;
                        thread.setDaemon(true);
                        selectorThread.setName("dnsjava NIO selector");
                        selectorThread.start();
                        final int i3 = 1;
                        Thread thread2 = new Thread(new Runnable() { // from class: org.xbill.DNS.s
                            @Override // java.lang.Runnable
                            public final void run() throws InterruptedException, IOException {
                                switch (i3) {
                                    case 0:
                                        NioClient.runSelector();
                                        break;
                                    default:
                                        NioClient.close(true);
                                        break;
                                }
                            }
                        });
                        closeThread = thread2;
                        thread2.setName("dnsjava NIO shutdown hook");
                        if (Boolean.parseBoolean(System.getProperty("dnsjava.nio.register_shutdown_hook", "true"))) {
                            Runtime.getRuntime().addShutdownHook(closeThread);
                        }
                    }
                } finally {
                }
            }
        }
        return selector;
    }

    public static synchronized void setCloseTask(Runnable runnable, boolean z) {
        addTask(CLOSE_TASKS, runnable, z);
    }

    public static void setPacketLogger(PacketLogger packetLogger2) {
        packetLogger = packetLogger2;
    }

    public static synchronized void setRegistrationsTask(Runnable runnable, boolean z) {
        addTask(REGISTRATIONS_TASKS, runnable, z);
    }

    public static synchronized void setTimeoutTask(Runnable runnable, boolean z) {
        addTask(TIMEOUT_TASKS, runnable, z);
    }

    public static void verboseLog(String str, SocketAddress socketAddress, SocketAddress socketAddress2, ByteBuffer byteBuffer) {
        if (log.f() || packetLogger != null) {
            byte[] bArr = new byte[byteBuffer.remaining()];
            int iPosition = byteBuffer.position();
            byteBuffer.get(bArr, 0, byteBuffer.remaining());
            byteBuffer.position(iPosition);
            verboseLog(str, socketAddress, socketAddress2, bArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void close(boolean z) throws InterruptedException, IOException {
        run = false;
        if (!z) {
            try {
                Runtime.getRuntime().removeShutdownHook(closeThread);
            } catch (Exception unused) {
                log.q("Failed to remove shutdown hook, ignoring and continuing close");
            }
        }
        try {
            runTasks(CLOSE_TASKS);
        } catch (Exception e2) {
            log.t("Failed to execute shutdown task, ignoring and continuing close", e2);
        }
        Selector selector2 = selector;
        Thread thread = selectorThread;
        synchronized (NioClient.class) {
            selector = null;
            selectorThread = null;
            closeThread = null;
        }
        if (selector2 != null) {
            selector2.wakeup();
            try {
                selector2.close();
            } catch (IOException e3) {
                log.t("Failed to properly close selector, ignoring and continuing close", e3);
            }
        }
        if (thread != null) {
            try {
                thread.join();
            } catch (InterruptedException unused2) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void verboseLog(String str, SocketAddress socketAddress, SocketAddress socketAddress2, byte[] bArr) {
        Logger logger = log;
        if (logger.f()) {
            logger.r(hexdump.dump(str, bArr));
        }
        PacketLogger packetLogger2 = packetLogger;
        if (packetLogger2 != null) {
            packetLogger2.log(str, socketAddress, socketAddress2, bArr);
        }
    }
}
