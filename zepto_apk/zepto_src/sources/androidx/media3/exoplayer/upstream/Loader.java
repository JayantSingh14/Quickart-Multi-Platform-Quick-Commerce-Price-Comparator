package androidx.media3.exoplayer.upstream;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.os.Trace;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.common.util.d;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@UnstableApi
/* loaded from: classes3.dex */
public final class Loader implements LoaderErrorThrower {

    /* renamed from: d, reason: collision with root package name */
    public static final LoadErrorAction f8164d = new LoadErrorAction(0, -9223372036854775807L);

    /* renamed from: e, reason: collision with root package name */
    public static final LoadErrorAction f8165e = new LoadErrorAction(2, -9223372036854775807L);

    /* renamed from: f, reason: collision with root package name */
    public static final LoadErrorAction f8166f = new LoadErrorAction(3, -9223372036854775807L);

    /* renamed from: a, reason: collision with root package name */
    public final ExecutorService f8167a;

    /* renamed from: b, reason: collision with root package name */
    public LoadTask f8168b;

    /* renamed from: c, reason: collision with root package name */
    public IOException f8169c;

    public interface Callback<T extends Loadable> {
        void a0(Loadable loadable, long j2, long j3);

        void d0(Loadable loadable, long j2, long j3, boolean z);

        LoadErrorAction k(Loadable loadable, long j2, long j3, IOException iOException, int i2);
    }

    public static final class LoadErrorAction {

        /* renamed from: a, reason: collision with root package name */
        public final int f8170a;

        /* renamed from: b, reason: collision with root package name */
        public final long f8171b;

        public LoadErrorAction(int i2, long j2) {
            this.f8170a = i2;
            this.f8171b = j2;
        }

        public final boolean a() {
            int i2 = this.f8170a;
            return i2 == 0 || i2 == 1;
        }
    }

    @SuppressLint({"HandlerLeak"})
    public final class LoadTask<T extends Loadable> extends Handler implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final int f8172a;

        /* renamed from: b, reason: collision with root package name */
        public final Loadable f8173b;

        /* renamed from: c, reason: collision with root package name */
        public final long f8174c;

        /* renamed from: d, reason: collision with root package name */
        public Callback f8175d;

        /* renamed from: e, reason: collision with root package name */
        public IOException f8176e;

        /* renamed from: f, reason: collision with root package name */
        public int f8177f;

        /* renamed from: g, reason: collision with root package name */
        public Thread f8178g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f8179h;

        /* renamed from: i, reason: collision with root package name */
        public volatile boolean f8180i;

        public LoadTask(Looper looper, Loadable loadable, Callback callback, int i2, long j2) {
            super(looper);
            this.f8173b = loadable;
            this.f8175d = callback;
            this.f8172a = i2;
            this.f8174c = j2;
        }

        public final void a(boolean z) {
            this.f8180i = z;
            this.f8176e = null;
            if (hasMessages(1)) {
                this.f8179h = true;
                removeMessages(1);
                if (!z) {
                    sendEmptyMessage(2);
                }
            } else {
                synchronized (this) {
                    try {
                        this.f8179h = true;
                        this.f8173b.b();
                        Thread thread = this.f8178g;
                        if (thread != null) {
                            thread.interrupt();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            if (z) {
                Loader.this.f8168b = null;
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                Callback callback = this.f8175d;
                callback.getClass();
                callback.d0(this.f8173b, jElapsedRealtime, jElapsedRealtime - this.f8174c, true);
                this.f8175d = null;
            }
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (this.f8180i) {
                return;
            }
            int i2 = message.what;
            if (i2 == 1) {
                this.f8176e = null;
                Loader loader = Loader.this;
                ExecutorService executorService = loader.f8167a;
                LoadTask loadTask = loader.f8168b;
                loadTask.getClass();
                executorService.execute(loadTask);
                return;
            }
            if (i2 == 4) {
                throw ((Error) message.obj);
            }
            Loader.this.f8168b = null;
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j2 = jElapsedRealtime - this.f8174c;
            Callback callback = this.f8175d;
            callback.getClass();
            if (this.f8179h) {
                callback.d0(this.f8173b, jElapsedRealtime, j2, false);
                return;
            }
            int i3 = message.what;
            if (i3 == 2) {
                try {
                    callback.a0(this.f8173b, jElapsedRealtime, j2);
                    return;
                } catch (RuntimeException e2) {
                    Log.e("LoadTask", "Unexpected exception handling load completed", e2);
                    Loader.this.f8169c = new UnexpectedLoaderException(e2);
                    return;
                }
            }
            if (i3 != 3) {
                return;
            }
            IOException iOException = (IOException) message.obj;
            this.f8176e = iOException;
            int i4 = this.f8177f + 1;
            this.f8177f = i4;
            LoadErrorAction loadErrorActionK = callback.k(this.f8173b, jElapsedRealtime, j2, iOException, i4);
            int i5 = loadErrorActionK.f8170a;
            if (i5 == 3) {
                Loader.this.f8169c = this.f8176e;
                return;
            }
            if (i5 != 2) {
                if (i5 == 1) {
                    this.f8177f = 1;
                }
                long jMin = loadErrorActionK.f8171b;
                if (jMin == -9223372036854775807L) {
                    jMin = Math.min((this.f8177f - 1) * 1000, 5000);
                }
                Loader loader2 = Loader.this;
                Assertions.g(loader2.f8168b == null);
                loader2.f8168b = this;
                if (jMin > 0) {
                    sendEmptyMessageDelayed(1, jMin);
                } else {
                    this.f8176e = null;
                    loader2.f8167a.execute(this);
                }
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean z;
            try {
                synchronized (this) {
                    z = this.f8179h;
                    this.f8178g = Thread.currentThread();
                }
                if (!z) {
                    Trace.beginSection("load:".concat(this.f8173b.getClass().getSimpleName()));
                    try {
                        this.f8173b.a();
                        Trace.endSection();
                    } catch (Throwable th) {
                        Trace.endSection();
                        throw th;
                    }
                }
                synchronized (this) {
                    this.f8178g = null;
                    Thread.interrupted();
                }
                if (this.f8180i) {
                    return;
                }
                sendEmptyMessage(2);
            } catch (IOException e2) {
                if (this.f8180i) {
                    return;
                }
                obtainMessage(3, e2).sendToTarget();
            } catch (Exception e3) {
                if (this.f8180i) {
                    return;
                }
                Log.e("LoadTask", "Unexpected exception loading stream", e3);
                obtainMessage(3, new UnexpectedLoaderException(e3)).sendToTarget();
            } catch (OutOfMemoryError e4) {
                if (this.f8180i) {
                    return;
                }
                Log.e("LoadTask", "OutOfMemory error loading stream", e4);
                obtainMessage(3, new UnexpectedLoaderException(e4)).sendToTarget();
            } catch (Error e5) {
                if (!this.f8180i) {
                    Log.e("LoadTask", "Unexpected error loading stream", e5);
                    obtainMessage(4, e5).sendToTarget();
                }
                throw e5;
            }
        }
    }

    public interface Loadable {
        void a();

        void b();
    }

    public interface ReleaseCallback {
        void j();
    }

    public static final class ReleaseTask implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final Object f8182a;

        public ReleaseTask(ReleaseCallback releaseCallback) {
            this.f8182a = releaseCallback;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [androidx.media3.exoplayer.upstream.Loader$ReleaseCallback, java.lang.Object] */
        @Override // java.lang.Runnable
        public final void run() {
            this.f8182a.j();
        }
    }

    public static final class UnexpectedLoaderException extends IOException {
        public UnexpectedLoaderException(Throwable th) {
            String str;
            StringBuilder sb = new StringBuilder("Unexpected ");
            sb.append(th.getClass().getSimpleName());
            if (th.getMessage() != null) {
                str = ": " + th.getMessage();
            } else {
                str = "";
            }
            sb.append(str);
            super(sb.toString(), th);
        }
    }

    public Loader(String str) {
        String strConcat = "ExoPlayer:Loader:".concat(str);
        int i2 = Util.f5744a;
        this.f8167a = Executors.newSingleThreadExecutor(new d(strConcat));
    }

    public final void a() {
        LoadTask loadTask = this.f8168b;
        Assertions.h(loadTask);
        loadTask.a(false);
    }

    public final boolean b() {
        return this.f8169c != null;
    }

    @Override // androidx.media3.exoplayer.upstream.LoaderErrorThrower
    public final void c() throws IOException {
        e(Integer.MIN_VALUE);
    }

    public final boolean d() {
        return this.f8168b != null;
    }

    public final void e(int i2) throws IOException {
        IOException iOException = this.f8169c;
        if (iOException != null) {
            throw iOException;
        }
        LoadTask loadTask = this.f8168b;
        if (loadTask != null) {
            if (i2 == Integer.MIN_VALUE) {
                i2 = loadTask.f8172a;
            }
            IOException iOException2 = loadTask.f8176e;
            if (iOException2 != null && loadTask.f8177f > i2) {
                throw iOException2;
            }
        }
    }

    public final void f(ReleaseCallback releaseCallback) {
        LoadTask loadTask = this.f8168b;
        if (loadTask != null) {
            loadTask.a(true);
        }
        ExecutorService executorService = this.f8167a;
        if (releaseCallback != null) {
            executorService.execute(new ReleaseTask(releaseCallback));
        }
        executorService.shutdown();
    }

    public final long g(Loadable loadable, Callback callback, int i2) {
        Looper looperMyLooper = Looper.myLooper();
        Assertions.h(looperMyLooper);
        this.f8169c = null;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        LoadTask loadTask = new LoadTask(looperMyLooper, loadable, callback, i2, jElapsedRealtime);
        Assertions.g(this.f8168b == null);
        this.f8168b = loadTask;
        loadTask.f8176e = null;
        this.f8167a.execute(loadTask);
        return jElapsedRealtime;
    }
}
