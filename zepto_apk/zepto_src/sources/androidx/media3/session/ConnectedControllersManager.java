package androidx.media3.session;

import androidx.collection.ArrayMap;
import androidx.media3.common.Player;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.session.MediaSession;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
final class ConnectedControllersManager<T> {

    /* renamed from: d, reason: collision with root package name */
    public final WeakReference f9888d;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayMap f9886b = new ArrayMap();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayMap f9887c = new ArrayMap();

    /* renamed from: a, reason: collision with root package name */
    public final Object f9885a = new Object();

    public interface AsyncCommand {
        ListenableFuture run();
    }

    public static final class ConnectedControllerRecord<T> {

        /* renamed from: a, reason: collision with root package name */
        public final Object f9889a;

        /* renamed from: b, reason: collision with root package name */
        public final SequencedFutureManager f9890b;

        /* renamed from: d, reason: collision with root package name */
        public SessionCommands f9892d;

        /* renamed from: e, reason: collision with root package name */
        public Player.Commands f9893e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f9894f;

        /* renamed from: c, reason: collision with root package name */
        public final ArrayDeque f9891c = new ArrayDeque();

        /* renamed from: g, reason: collision with root package name */
        public Player.Commands f9895g = Player.Commands.f5430b;

        public ConnectedControllerRecord(Object obj, SequencedFutureManager sequencedFutureManager, SessionCommands sessionCommands, Player.Commands commands) {
            this.f9889a = obj;
            this.f9890b = sequencedFutureManager;
            this.f9892d = sessionCommands;
            this.f9893e = commands;
        }
    }

    public ConnectedControllersManager(MediaSessionImpl mediaSessionImpl) {
        this.f9888d = new WeakReference(mediaSessionImpl);
    }

    public final void a(Object obj, MediaSession.ControllerInfo controllerInfo, SessionCommands sessionCommands, Player.Commands commands) {
        synchronized (this.f9885a) {
            try {
                MediaSession.ControllerInfo controllerInfoG = g(obj);
                if (controllerInfoG == null) {
                    this.f9886b.put(obj, controllerInfo);
                    this.f9887c.put(controllerInfo, new ConnectedControllerRecord(obj, new SequencedFutureManager(), sessionCommands, commands));
                } else {
                    ConnectedControllerRecord connectedControllerRecord = (ConnectedControllerRecord) this.f9887c.get(controllerInfoG);
                    Assertions.h(connectedControllerRecord);
                    connectedControllerRecord.f9892d = sessionCommands;
                    connectedControllerRecord.f9893e = commands;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(MediaSession.ControllerInfo controllerInfo, int i2, AsyncCommand asyncCommand) {
        synchronized (this.f9885a) {
            try {
                ConnectedControllerRecord connectedControllerRecord = (ConnectedControllerRecord) this.f9887c.get(controllerInfo);
                if (connectedControllerRecord != null) {
                    Player.Commands commands = connectedControllerRecord.f9895g;
                    commands.getClass();
                    Player.Commands.Builder builder = new Player.Commands.Builder(commands);
                    builder.f5434a.a(i2);
                    connectedControllerRecord.f9895g = builder.d();
                    connectedControllerRecord.f9891c.add(asyncCommand);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void c(ConnectedControllerRecord connectedControllerRecord) {
        MediaSessionImpl mediaSessionImpl = (MediaSessionImpl) this.f9888d.get();
        if (mediaSessionImpl == null) {
            return;
        }
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        while (atomicBoolean.get()) {
            atomicBoolean.set(false);
            AsyncCommand asyncCommand = (AsyncCommand) connectedControllerRecord.f9891c.poll();
            if (asyncCommand == null) {
                connectedControllerRecord.f9894f = false;
                return;
            }
            AtomicBoolean atomicBoolean2 = new AtomicBoolean(true);
            ConnectedControllerRecord connectedControllerRecord2 = connectedControllerRecord;
            Util.X(mediaSessionImpl.f10102l, new l0(mediaSessionImpl, g(connectedControllerRecord.f9889a), new c(this, asyncCommand, atomicBoolean2, connectedControllerRecord2, atomicBoolean)));
            atomicBoolean2.set(false);
            connectedControllerRecord = connectedControllerRecord2;
        }
    }

    public final void d(final MediaSession.ControllerInfo controllerInfo) {
        synchronized (this.f9885a) {
            try {
                ConnectedControllerRecord connectedControllerRecord = (ConnectedControllerRecord) this.f9887c.get(controllerInfo);
                if (connectedControllerRecord == null) {
                    return;
                }
                final Player.Commands commands = connectedControllerRecord.f9895g;
                connectedControllerRecord.f9895g = Player.Commands.f5430b;
                connectedControllerRecord.f9891c.add(new AsyncCommand(controllerInfo, commands) { // from class: androidx.media3.session.b

                    /* renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ MediaSession.ControllerInfo f10309b;

                    @Override // androidx.media3.session.ConnectedControllersManager.AsyncCommand
                    public final ListenableFuture run() {
                        MediaSessionImpl mediaSessionImpl = (MediaSessionImpl) this.f10308a.f9888d.get();
                        if (mediaSessionImpl != null) {
                            mediaSessionImpl.r(this.f10309b);
                        }
                        return Futures.e();
                    }
                });
                if (connectedControllerRecord.f9894f) {
                    return;
                }
                connectedControllerRecord.f9894f = true;
                c(connectedControllerRecord);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Player.Commands e(MediaSession.ControllerInfo controllerInfo) {
        synchronized (this.f9885a) {
            try {
                ConnectedControllerRecord connectedControllerRecord = (ConnectedControllerRecord) this.f9887c.get(controllerInfo);
                if (connectedControllerRecord == null) {
                    return null;
                }
                return connectedControllerRecord.f9893e;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final ImmutableList f() {
        ImmutableList immutableListO;
        synchronized (this.f9885a) {
            immutableListO = ImmutableList.o(this.f9886b.values());
        }
        return immutableListO;
    }

    public final MediaSession.ControllerInfo g(Object obj) {
        MediaSession.ControllerInfo controllerInfo;
        synchronized (this.f9885a) {
            controllerInfo = (MediaSession.ControllerInfo) this.f9886b.get(obj);
        }
        return controllerInfo;
    }

    public final SequencedFutureManager h(MediaSession.ControllerInfo controllerInfo) {
        ConnectedControllerRecord connectedControllerRecord;
        synchronized (this.f9885a) {
            connectedControllerRecord = (ConnectedControllerRecord) this.f9887c.get(controllerInfo);
        }
        if (connectedControllerRecord != null) {
            return connectedControllerRecord.f9890b;
        }
        return null;
    }

    public final boolean i(MediaSession.ControllerInfo controllerInfo) {
        boolean z;
        synchronized (this.f9885a) {
            z = this.f9887c.get(controllerInfo) != null;
        }
        return z;
    }

    public final boolean j(MediaSession.ControllerInfo controllerInfo, int i2) {
        ConnectedControllerRecord connectedControllerRecord;
        synchronized (this.f9885a) {
            connectedControllerRecord = (ConnectedControllerRecord) this.f9887c.get(controllerInfo);
        }
        MediaSessionImpl mediaSessionImpl = (MediaSessionImpl) this.f9888d.get();
        return connectedControllerRecord != null && connectedControllerRecord.f9893e.a(i2) && mediaSessionImpl != null && mediaSessionImpl.s.N0().a(i2);
    }

    public final boolean k(MediaSession.ControllerInfo controllerInfo, int i2) {
        ConnectedControllerRecord connectedControllerRecord;
        synchronized (this.f9885a) {
            connectedControllerRecord = (ConnectedControllerRecord) this.f9887c.get(controllerInfo);
        }
        if (connectedControllerRecord == null) {
            return false;
        }
        SessionCommands sessionCommands = connectedControllerRecord.f9892d;
        sessionCommands.getClass();
        boolean z = false;
        Assertions.b(i2 != 0, "Use contains(Command) for custom command");
        Iterator<E> it = sessionCommands.f10238a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            if (((SessionCommand) it.next()).f10233a == i2) {
                z = true;
                break;
            }
        }
        return z;
    }

    public final boolean l(MediaSession.ControllerInfo controllerInfo, SessionCommand sessionCommand) {
        ConnectedControllerRecord connectedControllerRecord;
        synchronized (this.f9885a) {
            connectedControllerRecord = (ConnectedControllerRecord) this.f9887c.get(controllerInfo);
        }
        if (connectedControllerRecord == null) {
            return false;
        }
        SessionCommands sessionCommands = connectedControllerRecord.f9892d;
        sessionCommands.getClass();
        sessionCommand.getClass();
        return sessionCommands.f10238a.contains(sessionCommand);
    }

    public final void m(MediaSession.ControllerInfo controllerInfo) {
        synchronized (this.f9885a) {
            try {
                ConnectedControllerRecord connectedControllerRecord = (ConnectedControllerRecord) this.f9887c.remove(controllerInfo);
                if (connectedControllerRecord == null) {
                    return;
                }
                this.f9886b.remove(connectedControllerRecord.f9889a);
                connectedControllerRecord.f9890b.b();
                MediaSessionImpl mediaSessionImpl = (MediaSessionImpl) this.f9888d.get();
                if (mediaSessionImpl == null || mediaSessionImpl.j()) {
                    return;
                }
                Util.X(mediaSessionImpl.f10102l, new a(mediaSessionImpl, controllerInfo, 0));
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
