package ch.qos.logback.core;

import ch.qos.logback.core.spi.AppenderAttachable;
import ch.qos.logback.core.spi.AppenderAttachableImpl;
import ch.qos.logback.core.util.COWArrayList;
import ch.qos.logback.core.util.InterruptUtil;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;

/* loaded from: classes3.dex */
public class AsyncAppenderBase<E> extends UnsynchronizedAppenderBase<E> implements AppenderAttachable<E> {

    /* renamed from: k, reason: collision with root package name */
    public ArrayBlockingQueue f13422k;

    /* renamed from: j, reason: collision with root package name */
    public final AppenderAttachableImpl f13421j = new AppenderAttachableImpl();

    /* renamed from: l, reason: collision with root package name */
    public final int f13423l = 256;

    /* renamed from: m, reason: collision with root package name */
    public int f13424m = 0;
    public int n = -1;
    public final Worker o = new Worker();
    public final int p = 1000;

    public class Worker extends Thread {
        public Worker() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            AsyncAppenderBase asyncAppenderBase = AsyncAppenderBase.this;
            AppenderAttachableImpl appenderAttachableImpl = asyncAppenderBase.f13421j;
            while (asyncAppenderBase.f13451d) {
                try {
                    appenderAttachableImpl.a(asyncAppenderBase.f13422k.take());
                } catch (InterruptedException unused) {
                }
            }
            asyncAppenderBase.s1("Worker thread will flush remaining events before exiting. ");
            Iterator<E> it = asyncAppenderBase.f13422k.iterator();
            while (it.hasNext()) {
                E next = it.next();
                appenderAttachableImpl.a(next);
                asyncAppenderBase.f13422k.remove(next);
            }
            COWArrayList cOWArrayList = appenderAttachableImpl.f13731a;
            Iterator<E> it2 = cOWArrayList.f13797b.iterator();
            while (it2.hasNext()) {
                ((Appender) it2.next()).stop();
            }
            cOWArrayList.clear();
        }
    }

    @Override // ch.qos.logback.core.UnsynchronizedAppenderBase
    public final void T1(Object obj) {
        if (this.f13422k.remainingCapacity() >= this.n || !U1(obj)) {
            V1(obj);
            boolean z = false;
            while (true) {
                try {
                    this.f13422k.put(obj);
                    break;
                } catch (InterruptedException unused) {
                    z = true;
                } catch (Throwable th) {
                    if (z) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public boolean U1(Object obj) {
        return false;
    }

    public void V1(Object obj) {
    }

    @Override // ch.qos.logback.core.spi.AppenderAttachable
    public final void r0(Appender appender) {
        int i2 = this.f13424m;
        if (i2 != 0) {
            J1("One and only one appender may be attached to AsyncAppender.");
            J1("Ignoring additional appender named [" + appender.getName() + "]");
            return;
        }
        this.f13424m = i2 + 1;
        s1("Attaching appender named [" + appender.getName() + "] to AsyncAppender.");
        this.f13421j.r0(appender);
    }

    @Override // ch.qos.logback.core.UnsynchronizedAppenderBase, ch.qos.logback.core.spi.LifeCycle
    public final void start() {
        if (this.f13451d) {
            return;
        }
        if (this.f13424m == 0) {
            l1("No attached appenders found.");
            return;
        }
        int i2 = this.f13423l;
        if (i2 < 1) {
            l1("Invalid queue size [" + i2 + "]");
            return;
        }
        this.f13422k = new ArrayBlockingQueue(i2);
        if (this.n == -1) {
            this.n = i2 / 5;
        }
        s1("Setting discardingThreshold to " + this.n);
        Worker worker = this.o;
        worker.setDaemon(true);
        worker.setName("AsyncAppender-Worker-" + this.f13453f);
        this.f13451d = true;
        worker.start();
    }

    @Override // ch.qos.logback.core.UnsynchronizedAppenderBase, ch.qos.logback.core.spi.LifeCycle
    public final void stop() {
        int i2 = this.p;
        if (this.f13451d) {
            this.f13451d = false;
            Worker worker = this.o;
            worker.interrupt();
            InterruptUtil interruptUtil = new InterruptUtil(this.f13733b);
            try {
                try {
                    if (interruptUtil.f13811d) {
                        Thread.interrupted();
                    }
                    worker.join(i2);
                    if (worker.isAlive()) {
                        J1("Max queue flush timeout (" + i2 + " ms) exceeded. Approximately " + this.f13422k.size() + " queued events were possibly discarded.");
                    } else {
                        s1("Queue flush finished successfully within timeout.");
                    }
                    interruptUtil.T1();
                } catch (InterruptedException e2) {
                    o1("Failed to join worker thread. " + this.f13422k.size() + " queued events may be discarded.", e2);
                    interruptUtil.T1();
                }
            } catch (Throwable th) {
                interruptUtil.T1();
                throw th;
            }
        }
    }
}
