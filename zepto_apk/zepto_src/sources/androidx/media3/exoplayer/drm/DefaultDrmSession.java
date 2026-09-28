package androidx.media3.exoplayer.drm;

import android.annotation.SuppressLint;
import android.media.NotProvisionedException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import androidx.media3.common.C;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.CopyOnWriteMultiset;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.CryptoConfig;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.drm.ExoMediaDrm;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.upstream.DefaultLoadErrorHandlingPolicy;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* loaded from: classes3.dex */
class DefaultDrmSession implements DrmSession {

    /* renamed from: a, reason: collision with root package name */
    public final List f6871a;

    /* renamed from: b, reason: collision with root package name */
    public final ExoMediaDrm f6872b;

    /* renamed from: c, reason: collision with root package name */
    public final ProvisioningManager f6873c;

    /* renamed from: d, reason: collision with root package name */
    public final ReferenceCountListener f6874d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f6875e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f6876f;

    /* renamed from: g, reason: collision with root package name */
    public final HashMap f6877g;

    /* renamed from: h, reason: collision with root package name */
    public final CopyOnWriteMultiset f6878h;

    /* renamed from: i, reason: collision with root package name */
    public final DefaultLoadErrorHandlingPolicy f6879i;

    /* renamed from: j, reason: collision with root package name */
    public final PlayerId f6880j;

    /* renamed from: k, reason: collision with root package name */
    public final HttpMediaDrmCallback f6881k;

    /* renamed from: l, reason: collision with root package name */
    public final UUID f6882l;

    /* renamed from: m, reason: collision with root package name */
    public final Looper f6883m;
    public final ResponseHandler n;
    public int o;
    public int p;
    public HandlerThread q;
    public RequestHandler r;
    public CryptoConfig s;
    public DrmSession.DrmSessionException t;
    public byte[] u;
    public byte[] v;
    public ExoMediaDrm.KeyRequest w;
    public ExoMediaDrm.ProvisionRequest x;

    public interface ProvisioningManager {
        void a(Exception exc, boolean z);

        void b();

        void c(DefaultDrmSession defaultDrmSession);
    }

    public interface ReferenceCountListener {
        void a(DefaultDrmSession defaultDrmSession);

        void b(DefaultDrmSession defaultDrmSession, int i2);
    }

    @SuppressLint({"HandlerLeak"})
    public class RequestHandler extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public boolean f6884a;

        public RequestHandler(Looper looper) {
            super(looper);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Exception excC;
            RequestTask requestTask = (RequestTask) message.obj;
            try {
                int i2 = message.what;
                if (i2 == 1) {
                    excC = DefaultDrmSession.this.f6881k.c((ExoMediaDrm.ProvisionRequest) requestTask.f6888c);
                } else {
                    if (i2 != 2) {
                        throw new RuntimeException();
                    }
                    DefaultDrmSession defaultDrmSession = DefaultDrmSession.this;
                    excC = defaultDrmSession.f6881k.a(defaultDrmSession.f6882l, (ExoMediaDrm.KeyRequest) requestTask.f6888c);
                }
            } catch (MediaDrmCallbackException e2) {
                RequestTask requestTask2 = (RequestTask) message.obj;
                if (requestTask2.f6887b) {
                    int i3 = requestTask2.f6889d + 1;
                    requestTask2.f6889d = i3;
                    if (i3 <= DefaultDrmSession.this.f6879i.b(3)) {
                        SystemClock.elapsedRealtime();
                        SystemClock.elapsedRealtime();
                        long jA = DefaultDrmSession.this.f6879i.a(new LoadErrorHandlingPolicy.LoadErrorInfo(e2.getCause() instanceof IOException ? (IOException) e2.getCause() : new UnexpectedDrmSessionException(e2.getCause()), requestTask2.f6889d));
                        if (jA != -9223372036854775807L) {
                            synchronized (this) {
                                try {
                                    if (!this.f6884a) {
                                        sendMessageDelayed(Message.obtain(message), jA);
                                        return;
                                    }
                                } finally {
                                }
                            }
                        }
                    }
                }
                excC = e2;
            } catch (Exception e3) {
                Log.i("DefaultDrmSession", "Key/provisioning request produced an unexpected exception. Not retrying.", e3);
                excC = e3;
            }
            DefaultLoadErrorHandlingPolicy defaultLoadErrorHandlingPolicy = DefaultDrmSession.this.f6879i;
            long j2 = requestTask.f6886a;
            defaultLoadErrorHandlingPolicy.getClass();
            synchronized (this) {
                try {
                    if (!this.f6884a) {
                        DefaultDrmSession.this.n.obtainMessage(message.what, Pair.create(requestTask.f6888c, excC)).sendToTarget();
                    }
                } finally {
                }
            }
        }
    }

    public static final class RequestTask {

        /* renamed from: a, reason: collision with root package name */
        public final long f6886a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f6887b;

        /* renamed from: c, reason: collision with root package name */
        public final Object f6888c;

        /* renamed from: d, reason: collision with root package name */
        public int f6889d;

        public RequestTask(long j2, boolean z, long j3, Object obj) {
            this.f6886a = j2;
            this.f6887b = z;
            this.f6888c = obj;
        }
    }

    @SuppressLint({"HandlerLeak"})
    public class ResponseHandler extends Handler {
        public ResponseHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Set set;
            Pair pair = (Pair) message.obj;
            Object obj = pair.first;
            Object obj2 = pair.second;
            int i2 = message.what;
            if (i2 == 1) {
                DefaultDrmSession defaultDrmSession = DefaultDrmSession.this;
                if (obj == defaultDrmSession.x) {
                    if (defaultDrmSession.o == 2 || defaultDrmSession.i()) {
                        defaultDrmSession.x = null;
                        boolean z = obj2 instanceof Exception;
                        ProvisioningManager provisioningManager = defaultDrmSession.f6873c;
                        if (z) {
                            provisioningManager.a((Exception) obj2, false);
                            return;
                        }
                        try {
                            defaultDrmSession.f6872b.e((byte[]) obj2);
                            provisioningManager.b();
                            return;
                        } catch (Exception e2) {
                            provisioningManager.a(e2, true);
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            if (i2 != 2) {
                return;
            }
            DefaultDrmSession defaultDrmSession2 = DefaultDrmSession.this;
            if (obj == defaultDrmSession2.w && defaultDrmSession2.i()) {
                defaultDrmSession2.w = null;
                if ((obj2 instanceof Exception) || (obj2 instanceof NoSuchMethodError)) {
                    defaultDrmSession2.k(false, (Throwable) obj2);
                    return;
                }
                try {
                    byte[] bArrI = defaultDrmSession2.f6872b.i(defaultDrmSession2.u, (byte[]) obj2);
                    if (defaultDrmSession2.v != null && bArrI != null && bArrI.length != 0) {
                        defaultDrmSession2.v = bArrI;
                    }
                    defaultDrmSession2.o = 4;
                    CopyOnWriteMultiset copyOnWriteMultiset = defaultDrmSession2.f6878h;
                    synchronized (copyOnWriteMultiset.f5671a) {
                        set = copyOnWriteMultiset.f5673c;
                    }
                    Iterator it = set.iterator();
                    while (it.hasNext()) {
                        ((DrmSessionEventListener.EventDispatcher) it.next()).b();
                    }
                } catch (Exception e3) {
                    e = e3;
                    defaultDrmSession2.k(true, e);
                } catch (NoSuchMethodError e4) {
                    e = e4;
                    defaultDrmSession2.k(true, e);
                }
            }
        }
    }

    public static final class UnexpectedDrmSessionException extends IOException {
    }

    public DefaultDrmSession(UUID uuid, ExoMediaDrm exoMediaDrm, ProvisioningManager provisioningManager, ReferenceCountListener referenceCountListener, List list, boolean z, boolean z2, byte[] bArr, HashMap map, HttpMediaDrmCallback httpMediaDrmCallback, Looper looper, DefaultLoadErrorHandlingPolicy defaultLoadErrorHandlingPolicy, PlayerId playerId) {
        this.f6882l = uuid;
        this.f6873c = provisioningManager;
        this.f6874d = referenceCountListener;
        this.f6872b = exoMediaDrm;
        this.f6875e = z;
        this.f6876f = z2;
        if (bArr != null) {
            this.v = bArr;
            this.f6871a = null;
        } else {
            list.getClass();
            this.f6871a = Collections.unmodifiableList(list);
        }
        this.f6877g = map;
        this.f6881k = httpMediaDrmCallback;
        this.f6878h = new CopyOnWriteMultiset();
        this.f6879i = defaultLoadErrorHandlingPolicy;
        this.f6880j = playerId;
        this.o = 2;
        this.f6883m = looper;
        this.n = new ResponseHandler(looper);
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public final UUID a() {
        n();
        return this.f6882l;
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public final boolean b() {
        n();
        return this.f6875e;
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public final CryptoConfig d() {
        n();
        return this.s;
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public final void e(DrmSessionEventListener.EventDispatcher eventDispatcher) {
        n();
        if (this.p < 0) {
            Log.d("DefaultDrmSession", "Session reference count less than zero: " + this.p);
            this.p = 0;
        }
        if (eventDispatcher != null) {
            CopyOnWriteMultiset copyOnWriteMultiset = this.f6878h;
            synchronized (copyOnWriteMultiset.f5671a) {
                try {
                    ArrayList arrayList = new ArrayList(copyOnWriteMultiset.f5674d);
                    arrayList.add(eventDispatcher);
                    copyOnWriteMultiset.f5674d = Collections.unmodifiableList(arrayList);
                    Integer num = (Integer) copyOnWriteMultiset.f5672b.get(eventDispatcher);
                    if (num == null) {
                        HashSet hashSet = new HashSet(copyOnWriteMultiset.f5673c);
                        hashSet.add(eventDispatcher);
                        copyOnWriteMultiset.f5673c = Collections.unmodifiableSet(hashSet);
                    }
                    copyOnWriteMultiset.f5672b.put(eventDispatcher, Integer.valueOf(num != null ? num.intValue() + 1 : 1));
                } finally {
                }
            }
        }
        int i2 = this.p + 1;
        this.p = i2;
        if (i2 == 1) {
            Assertions.g(this.o == 2);
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:DrmRequestHandler");
            this.q = handlerThread;
            handlerThread.start();
            this.r = new RequestHandler(this.q.getLooper());
            if (l()) {
                h(true);
            }
        } else if (eventDispatcher != null && i() && this.f6878h.b(eventDispatcher) == 1) {
            eventDispatcher.d(this.o);
        }
        this.f6874d.a(this);
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public final void f(DrmSessionEventListener.EventDispatcher eventDispatcher) {
        n();
        int i2 = this.p;
        if (i2 <= 0) {
            Log.d("DefaultDrmSession", "release() called on a session that's already fully released.");
            return;
        }
        int i3 = i2 - 1;
        this.p = i3;
        if (i3 == 0) {
            this.o = 0;
            ResponseHandler responseHandler = this.n;
            int i4 = Util.f5744a;
            responseHandler.removeCallbacksAndMessages(null);
            RequestHandler requestHandler = this.r;
            synchronized (requestHandler) {
                requestHandler.removeCallbacksAndMessages(null);
                requestHandler.f6884a = true;
            }
            this.r = null;
            this.q.quit();
            this.q = null;
            this.s = null;
            this.t = null;
            this.w = null;
            this.x = null;
            byte[] bArr = this.u;
            if (bArr != null) {
                this.f6872b.h(bArr);
                this.u = null;
            }
        }
        if (eventDispatcher != null) {
            CopyOnWriteMultiset copyOnWriteMultiset = this.f6878h;
            synchronized (copyOnWriteMultiset.f5671a) {
                try {
                    Integer num = (Integer) copyOnWriteMultiset.f5672b.get(eventDispatcher);
                    if (num != null) {
                        ArrayList arrayList = new ArrayList(copyOnWriteMultiset.f5674d);
                        arrayList.remove(eventDispatcher);
                        copyOnWriteMultiset.f5674d = Collections.unmodifiableList(arrayList);
                        if (num.intValue() == 1) {
                            copyOnWriteMultiset.f5672b.remove(eventDispatcher);
                            HashSet hashSet = new HashSet(copyOnWriteMultiset.f5673c);
                            hashSet.remove(eventDispatcher);
                            copyOnWriteMultiset.f5673c = Collections.unmodifiableSet(hashSet);
                        } else {
                            copyOnWriteMultiset.f5672b.put(eventDispatcher, Integer.valueOf(num.intValue() - 1));
                        }
                    }
                } finally {
                }
            }
            if (this.f6878h.b(eventDispatcher) == 0) {
                eventDispatcher.f();
            }
        }
        this.f6874d.b(this, this.p);
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public final boolean g(String str) {
        n();
        byte[] bArr = this.u;
        Assertions.h(bArr);
        return this.f6872b.m(str, bArr);
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public final DrmSession.DrmSessionException getError() {
        n();
        if (this.o == 1) {
            return this.t;
        }
        return null;
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public final int getState() {
        n();
        return this.o;
    }

    public final void h(boolean z) {
        long jMin;
        String str;
        Set set;
        boolean z2 = true;
        if (this.f6876f) {
            return;
        }
        byte[] bArr = this.u;
        int i2 = Util.f5744a;
        if (this.v == null) {
            m(bArr, 1, z);
            return;
        }
        if (this.o != 4) {
            try {
                this.f6872b.d(this.u, this.v);
            } catch (Exception | NoSuchMethodError e2) {
                j(1, e2);
                z2 = false;
            }
            if (!z2) {
                return;
            }
        }
        if (C.f5167d.equals(this.f6882l)) {
            n();
            byte[] bArr2 = this.u;
            Pair pair = null;
            Map mapA = bArr2 == null ? null : this.f6872b.a(bArr2);
            if (mapA != null) {
                long j2 = -9223372036854775807L;
                try {
                    str = (String) mapA.get("LicenseDurationRemaining");
                } catch (NumberFormatException unused) {
                }
                long j3 = str != null ? Long.parseLong(str) : -9223372036854775807L;
                Long lValueOf = Long.valueOf(j3);
                try {
                    String str2 = (String) mapA.get("PlaybackDurationRemaining");
                    if (str2 != null) {
                        j2 = Long.parseLong(str2);
                    }
                } catch (NumberFormatException unused2) {
                }
                pair = new Pair(lValueOf, Long.valueOf(j2));
            }
            pair.getClass();
            jMin = Math.min(((Long) pair.first).longValue(), ((Long) pair.second).longValue());
        } else {
            jMin = Long.MAX_VALUE;
        }
        if (jMin <= 60) {
            Log.b("DefaultDrmSession", "Offline license has expired or will expire soon. Remaining seconds: " + jMin);
            m(bArr, 2, z);
            return;
        }
        if (jMin <= 0) {
            j(2, new KeysExpiredException());
            return;
        }
        this.o = 4;
        CopyOnWriteMultiset copyOnWriteMultiset = this.f6878h;
        synchronized (copyOnWriteMultiset.f5671a) {
            set = copyOnWriteMultiset.f5673c;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            ((DrmSessionEventListener.EventDispatcher) it.next()).c();
        }
    }

    public final boolean i() {
        int i2 = this.o;
        return i2 == 3 || i2 == 4;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j(int r6, java.lang.Throwable r7) {
        /*
            r5 = this;
            androidx.media3.exoplayer.drm.DrmSession$DrmSessionException r0 = new androidx.media3.exoplayer.drm.DrmSession$DrmSessionException
            int r1 = androidx.media3.common.util.Util.f5744a
            r2 = 21
            r3 = 1
            if (r1 < r2) goto L14
            boolean r2 = androidx.media3.exoplayer.drm.DrmUtil.Api21.a(r7)
            if (r2 == 0) goto L14
            int r6 = androidx.media3.exoplayer.drm.DrmUtil.Api21.b(r7)
            goto L5f
        L14:
            r2 = 23
            r4 = 6006(0x1776, float:8.416E-42)
            if (r1 < r2) goto L22
            boolean r1 = androidx.media3.exoplayer.drm.DrmUtil.Api23.a(r7)
            if (r1 == 0) goto L22
        L20:
            r6 = r4
            goto L5f
        L22:
            boolean r1 = r7 instanceof android.media.NotProvisionedException
            r2 = 6002(0x1772, float:8.41E-42)
            if (r1 != 0) goto L57
            boolean r1 = androidx.media3.exoplayer.drm.DrmUtil.a(r7)
            if (r1 == 0) goto L2f
            goto L57
        L2f:
            boolean r1 = r7 instanceof android.media.DeniedByServerException
            if (r1 == 0) goto L36
            r6 = 6007(0x1777, float:8.418E-42)
            goto L5f
        L36:
            boolean r1 = r7 instanceof androidx.media3.exoplayer.drm.UnsupportedDrmException
            if (r1 == 0) goto L3d
            r6 = 6001(0x1771, float:8.409E-42)
            goto L5f
        L3d:
            boolean r1 = r7 instanceof androidx.media3.exoplayer.drm.DefaultDrmSessionManager.MissingSchemeDataException
            if (r1 == 0) goto L44
            r6 = 6003(0x1773, float:8.412E-42)
            goto L5f
        L44:
            boolean r1 = r7 instanceof androidx.media3.exoplayer.drm.KeysExpiredException
            if (r1 == 0) goto L4b
            r6 = 6008(0x1778, float:8.419E-42)
            goto L5f
        L4b:
            if (r6 != r3) goto L4e
            goto L20
        L4e:
            r1 = 2
            if (r6 != r1) goto L54
            r6 = 6004(0x1774, float:8.413E-42)
            goto L5f
        L54:
            r1 = 3
            if (r6 != r1) goto L59
        L57:
            r6 = r2
            goto L5f
        L59:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            r6.<init>()
            throw r6
        L5f:
            r0.<init>(r6, r7)
            r5.t = r0
            java.lang.String r6 = "DefaultDrmSession"
            java.lang.String r0 = "DRM session error"
            androidx.media3.common.util.Log.e(r6, r0, r7)
            boolean r6 = r7 instanceof java.lang.Exception
            if (r6 == 0) goto L91
            androidx.media3.common.util.CopyOnWriteMultiset r6 = r5.f6878h
            java.lang.Object r0 = r6.f5671a
            monitor-enter(r0)
            java.util.Set r6 = r6.f5673c     // Catch: java.lang.Throwable -> L8e
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L8e
            java.util.Iterator r6 = r6.iterator()
        L7b:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto La5
            java.lang.Object r0 = r6.next()
            androidx.media3.exoplayer.drm.DrmSessionEventListener$EventDispatcher r0 = (androidx.media3.exoplayer.drm.DrmSessionEventListener.EventDispatcher) r0
            r1 = r7
            java.lang.Exception r1 = (java.lang.Exception) r1
            r0.e(r1)
            goto L7b
        L8e:
            r6 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L8e
            throw r6
        L91:
            boolean r6 = r7 instanceof java.lang.Error
            if (r6 == 0) goto Lad
            boolean r6 = androidx.media3.exoplayer.drm.DrmUtil.b(r7)
            if (r6 != 0) goto La5
            boolean r6 = androidx.media3.exoplayer.drm.DrmUtil.a(r7)
            if (r6 == 0) goto La2
            goto La5
        La2:
            java.lang.Error r7 = (java.lang.Error) r7
            throw r7
        La5:
            int r6 = r5.o
            r7 = 4
            if (r6 == r7) goto Lac
            r5.o = r3
        Lac:
            return
        Lad:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "Unexpected Throwable subclass"
            r6.<init>(r0, r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.drm.DefaultDrmSession.j(int, java.lang.Throwable):void");
    }

    public final void k(boolean z, Throwable th) {
        if ((th instanceof NotProvisionedException) || DrmUtil.a(th)) {
            this.f6873c.c(this);
        } else {
            j(z ? 1 : 2, th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean l() {
        /*
            r4 = this;
            boolean r0 = r4.i()
            r1 = 1
            if (r0 == 0) goto L8
            return r1
        L8:
            androidx.media3.exoplayer.drm.ExoMediaDrm r0 = r4.f6872b     // Catch: java.lang.NoSuchMethodError -> L46 java.lang.Exception -> L48 android.media.NotProvisionedException -> L5d
            byte[] r0 = r0.c()     // Catch: java.lang.NoSuchMethodError -> L46 java.lang.Exception -> L48 android.media.NotProvisionedException -> L5d
            r4.u = r0     // Catch: java.lang.NoSuchMethodError -> L46 java.lang.Exception -> L48 android.media.NotProvisionedException -> L5d
            androidx.media3.exoplayer.drm.ExoMediaDrm r2 = r4.f6872b     // Catch: java.lang.NoSuchMethodError -> L46 java.lang.Exception -> L48 android.media.NotProvisionedException -> L5d
            androidx.media3.exoplayer.analytics.PlayerId r3 = r4.f6880j     // Catch: java.lang.NoSuchMethodError -> L46 java.lang.Exception -> L48 android.media.NotProvisionedException -> L5d
            r2.l(r0, r3)     // Catch: java.lang.NoSuchMethodError -> L46 java.lang.Exception -> L48 android.media.NotProvisionedException -> L5d
            androidx.media3.exoplayer.drm.ExoMediaDrm r0 = r4.f6872b     // Catch: java.lang.NoSuchMethodError -> L46 java.lang.Exception -> L48 android.media.NotProvisionedException -> L5d
            byte[] r2 = r4.u     // Catch: java.lang.NoSuchMethodError -> L46 java.lang.Exception -> L48 android.media.NotProvisionedException -> L5d
            androidx.media3.decoder.CryptoConfig r0 = r0.g(r2)     // Catch: java.lang.NoSuchMethodError -> L46 java.lang.Exception -> L48 android.media.NotProvisionedException -> L5d
            r4.s = r0     // Catch: java.lang.NoSuchMethodError -> L46 java.lang.Exception -> L48 android.media.NotProvisionedException -> L5d
            r0 = 3
            r4.o = r0     // Catch: java.lang.NoSuchMethodError -> L46 java.lang.Exception -> L48 android.media.NotProvisionedException -> L5d
            androidx.media3.common.util.CopyOnWriteMultiset r2 = r4.f6878h     // Catch: java.lang.NoSuchMethodError -> L46 java.lang.Exception -> L48 android.media.NotProvisionedException -> L5d
            java.lang.Object r3 = r2.f5671a     // Catch: java.lang.NoSuchMethodError -> L46 java.lang.Exception -> L48 android.media.NotProvisionedException -> L5d
            monitor-enter(r3)     // Catch: java.lang.NoSuchMethodError -> L46 java.lang.Exception -> L48 android.media.NotProvisionedException -> L5d
            java.util.Set r2 = r2.f5673c     // Catch: java.lang.Throwable -> L4a
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L4a
            java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.NoSuchMethodError -> L46 java.lang.Exception -> L48 android.media.NotProvisionedException -> L5d
        L30:
            boolean r3 = r2.hasNext()     // Catch: java.lang.NoSuchMethodError -> L46 java.lang.Exception -> L48 android.media.NotProvisionedException -> L5d
            if (r3 == 0) goto L40
            java.lang.Object r3 = r2.next()     // Catch: java.lang.NoSuchMethodError -> L46 java.lang.Exception -> L48 android.media.NotProvisionedException -> L5d
            androidx.media3.exoplayer.drm.DrmSessionEventListener$EventDispatcher r3 = (androidx.media3.exoplayer.drm.DrmSessionEventListener.EventDispatcher) r3     // Catch: java.lang.NoSuchMethodError -> L46 java.lang.Exception -> L48 android.media.NotProvisionedException -> L5d
            r3.d(r0)     // Catch: java.lang.NoSuchMethodError -> L46 java.lang.Exception -> L48 android.media.NotProvisionedException -> L5d
            goto L30
        L40:
            byte[] r0 = r4.u     // Catch: java.lang.NoSuchMethodError -> L46 java.lang.Exception -> L48 android.media.NotProvisionedException -> L5d
            r0.getClass()     // Catch: java.lang.NoSuchMethodError -> L46 java.lang.Exception -> L48 android.media.NotProvisionedException -> L5d
            return r1
        L46:
            r0 = move-exception
            goto L4d
        L48:
            r0 = move-exception
            goto L4d
        L4a:
            r0 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L4a
            throw r0     // Catch: java.lang.NoSuchMethodError -> L46 java.lang.Exception -> L48 android.media.NotProvisionedException -> L5d
        L4d:
            boolean r2 = androidx.media3.exoplayer.drm.DrmUtil.a(r0)
            if (r2 == 0) goto L59
            androidx.media3.exoplayer.drm.DefaultDrmSession$ProvisioningManager r0 = r4.f6873c
            r0.c(r4)
            goto L62
        L59:
            r4.j(r1, r0)
            goto L62
        L5d:
            androidx.media3.exoplayer.drm.DefaultDrmSession$ProvisioningManager r0 = r4.f6873c
            r0.c(r4)
        L62:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.drm.DefaultDrmSession.l():boolean");
    }

    public final void m(byte[] bArr, int i2, boolean z) {
        try {
            ExoMediaDrm.KeyRequest keyRequestK = this.f6872b.k(bArr, this.f6871a, i2, this.f6877g);
            this.w = keyRequestK;
            RequestHandler requestHandler = this.r;
            int i3 = Util.f5744a;
            keyRequestK.getClass();
            requestHandler.getClass();
            requestHandler.obtainMessage(2, new RequestTask(LoadEventInfo.f7578d.getAndIncrement(), z, SystemClock.elapsedRealtime(), keyRequestK)).sendToTarget();
        } catch (Exception | NoSuchMethodError e2) {
            k(true, e2);
        }
    }

    public final void n() {
        Thread threadCurrentThread = Thread.currentThread();
        Looper looper = this.f6883m;
        if (threadCurrentThread != looper.getThread()) {
            Log.i("DefaultDrmSession", "DefaultDrmSession accessed on the wrong thread.\nCurrent thread: " + Thread.currentThread().getName() + "\nExpected thread: " + looper.getThread().getName(), new IllegalStateException());
        }
    }
}
