package ch.qos.logback.core.net.server;

import ch.qos.logback.core.net.server.Client;
import ch.qos.logback.core.spi.ContextAwareBase;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes3.dex */
public abstract class ConcurrentServerRunner<T extends Client> extends ContextAwareBase implements Runnable, ServerRunner<T> {

    /* renamed from: d, reason: collision with root package name */
    public final ReentrantLock f13621d = new ReentrantLock();

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f13622e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    public final ServerSocketListener f13623f;

    /* renamed from: g, reason: collision with root package name */
    public final ExecutorService f13624g;

    /* renamed from: ch.qos.logback.core.net.server.ConcurrentServerRunner$1, reason: invalid class name */
    class AnonymousClass1 implements ClientVisitor<Client> {
        @Override // ch.qos.logback.core.net.server.ClientVisitor
        public final void a(Client client) {
            client.close();
        }
    }

    public class ClientWrapper implements Client {

        /* renamed from: a, reason: collision with root package name */
        public final Client f13625a;

        public ClientWrapper(Client client) {
            this.f13625a = client;
        }

        @Override // ch.qos.logback.core.net.server.Client, java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            this.f13625a.close();
        }

        @Override // java.lang.Runnable
        public final void run() {
            Client client = this.f13625a;
            ConcurrentServerRunner concurrentServerRunner = ConcurrentServerRunner.this;
            ReentrantLock reentrantLock = concurrentServerRunner.f13621d;
            reentrantLock.lock();
            try {
                concurrentServerRunner.f13622e.add(client);
                try {
                    client.run();
                } finally {
                    ConcurrentServerRunner.U1(concurrentServerRunner, client);
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public ConcurrentServerRunner(ServerSocketListener serverSocketListener, ExecutorService executorService) {
        this.f13623f = serverSocketListener;
        this.f13624g = executorService;
    }

    public static void U1(ConcurrentServerRunner concurrentServerRunner, Client client) {
        ReentrantLock reentrantLock = concurrentServerRunner.f13621d;
        reentrantLock.lock();
        try {
            concurrentServerRunner.f13622e.remove(client);
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void T1(ClientVisitor clientVisitor) {
        ReentrantLock reentrantLock = this.f13621d;
        reentrantLock.lock();
        try {
            ArrayList arrayList = new ArrayList(this.f13622e);
            reentrantLock.unlock();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Client client = (Client) it.next();
                try {
                    clientVisitor.a(client);
                } catch (RuntimeException e2) {
                    l1(client + ": " + e2);
                }
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public abstract void V1(Client client);

    @Override // java.lang.Runnable
    public final void run() throws IOException {
        ServerSocketListener serverSocketListener = this.f13623f;
        try {
            s1("listening on " + serverSocketListener);
            while (!Thread.currentThread().isInterrupted()) {
                Client clientA = serverSocketListener.a();
                V1(clientA);
                try {
                    this.f13624g.execute(new ClientWrapper(clientA));
                } catch (RejectedExecutionException unused) {
                    l1(clientA + ": connection dropped");
                    clientA.close();
                }
            }
        } catch (InterruptedException unused2) {
        } catch (Exception e2) {
            l1("listener: " + e2);
        }
        s1("shutting down");
        serverSocketListener.close();
    }

    public final void stop() throws IOException {
        this.f13623f.close();
        T1(new AnonymousClass1());
    }
}
