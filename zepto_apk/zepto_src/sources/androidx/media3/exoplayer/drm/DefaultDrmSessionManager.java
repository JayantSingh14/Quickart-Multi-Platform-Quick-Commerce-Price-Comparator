package androidx.media3.exoplayer.drm;

import android.annotation.SuppressLint;
import android.media.ResourceBusyException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.media3.common.C;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.drm.DefaultDrmSession;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.drm.DrmSessionManager;
import androidx.media3.exoplayer.drm.ExoMediaDrm;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.upstream.DefaultLoadErrorHandlingPolicy;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.collect.UnmodifiableListIterator;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@UnstableApi
/* loaded from: classes3.dex */
public class DefaultDrmSessionManager implements DrmSessionManager {

    /* renamed from: b, reason: collision with root package name */
    public final UUID f6891b;

    /* renamed from: c, reason: collision with root package name */
    public final ExoMediaDrm.Provider f6892c;

    /* renamed from: d, reason: collision with root package name */
    public final HttpMediaDrmCallback f6893d;

    /* renamed from: e, reason: collision with root package name */
    public final HashMap f6894e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f6895f;

    /* renamed from: g, reason: collision with root package name */
    public final int[] f6896g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f6897h;

    /* renamed from: i, reason: collision with root package name */
    public final ProvisioningManagerImpl f6898i;

    /* renamed from: j, reason: collision with root package name */
    public final DefaultLoadErrorHandlingPolicy f6899j;

    /* renamed from: k, reason: collision with root package name */
    public final ReferenceCountListenerImpl f6900k;

    /* renamed from: l, reason: collision with root package name */
    public final long f6901l;

    /* renamed from: m, reason: collision with root package name */
    public final ArrayList f6902m;
    public final Set n;
    public final Set o;
    public int p;
    public ExoMediaDrm q;
    public DefaultDrmSession r;
    public DefaultDrmSession s;
    public Looper t;
    public Handler u;
    public byte[] v;
    public PlayerId w;
    public volatile MediaDrmHandler x;

    public static final class Builder {

        /* renamed from: d, reason: collision with root package name */
        public boolean f6906d;

        /* renamed from: a, reason: collision with root package name */
        public final HashMap f6903a = new HashMap();

        /* renamed from: b, reason: collision with root package name */
        public UUID f6904b = C.f5167d;

        /* renamed from: c, reason: collision with root package name */
        public ExoMediaDrm.Provider f6905c = FrameworkMediaDrm.f6938d;

        /* renamed from: e, reason: collision with root package name */
        public int[] f6907e = new int[0];

        /* renamed from: f, reason: collision with root package name */
        public boolean f6908f = true;

        /* renamed from: g, reason: collision with root package name */
        public final DefaultLoadErrorHandlingPolicy f6909g = new DefaultLoadErrorHandlingPolicy();

        /* renamed from: h, reason: collision with root package name */
        public final long f6910h = 300000;
    }

    public class MediaDrmEventListener implements ExoMediaDrm.OnEventListener {
        public MediaDrmEventListener() {
        }
    }

    @SuppressLint({"HandlerLeak"})
    public class MediaDrmHandler extends Handler {
        public MediaDrmHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            byte[] bArr = (byte[]) message.obj;
            if (bArr == null) {
                return;
            }
            Iterator it = DefaultDrmSessionManager.this.f6902m.iterator();
            while (it.hasNext()) {
                DefaultDrmSession defaultDrmSession = (DefaultDrmSession) it.next();
                defaultDrmSession.n();
                if (Arrays.equals(defaultDrmSession.u, bArr)) {
                    if (message.what == 2 && defaultDrmSession.o == 4) {
                        int i2 = Util.f5744a;
                        defaultDrmSession.h(false);
                        return;
                    }
                    return;
                }
            }
        }
    }

    public static final class MissingSchemeDataException extends Exception {
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Mode {
    }

    public class PreacquiredSessionReference implements DrmSessionManager.DrmSessionReference {

        /* renamed from: a, reason: collision with root package name */
        public final DrmSessionEventListener.EventDispatcher f6913a;

        /* renamed from: b, reason: collision with root package name */
        public DrmSession f6914b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f6915c;

        public PreacquiredSessionReference(DrmSessionEventListener.EventDispatcher eventDispatcher) {
            this.f6913a = eventDispatcher;
        }

        @Override // androidx.media3.exoplayer.drm.DrmSessionManager.DrmSessionReference
        public final void release() {
            Handler handler = DefaultDrmSessionManager.this.u;
            handler.getClass();
            Util.X(handler, new a(this, 0));
        }
    }

    public class ProvisioningManagerImpl implements DefaultDrmSession.ProvisioningManager {

        /* renamed from: a, reason: collision with root package name */
        public final HashSet f6917a = new HashSet();

        /* renamed from: b, reason: collision with root package name */
        public DefaultDrmSession f6918b;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.media3.exoplayer.drm.DefaultDrmSession.ProvisioningManager
        public final void a(Exception exc, boolean z) {
            this.f6918b = null;
            HashSet hashSet = this.f6917a;
            ImmutableList immutableListO = ImmutableList.o(hashSet);
            hashSet.clear();
            UnmodifiableListIterator unmodifiableListIteratorListIterator = immutableListO.listIterator(0);
            while (unmodifiableListIteratorListIterator.hasNext()) {
                DefaultDrmSession defaultDrmSession = (DefaultDrmSession) unmodifiableListIteratorListIterator.next();
                defaultDrmSession.getClass();
                defaultDrmSession.j(z ? 1 : 3, exc);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.media3.exoplayer.drm.DefaultDrmSession.ProvisioningManager
        public final void b() {
            this.f6918b = null;
            HashSet hashSet = this.f6917a;
            ImmutableList immutableListO = ImmutableList.o(hashSet);
            hashSet.clear();
            UnmodifiableListIterator unmodifiableListIteratorListIterator = immutableListO.listIterator(0);
            while (unmodifiableListIteratorListIterator.hasNext()) {
                DefaultDrmSession defaultDrmSession = (DefaultDrmSession) unmodifiableListIteratorListIterator.next();
                if (defaultDrmSession.l()) {
                    defaultDrmSession.h(true);
                }
            }
        }

        @Override // androidx.media3.exoplayer.drm.DefaultDrmSession.ProvisioningManager
        public final void c(DefaultDrmSession defaultDrmSession) {
            this.f6917a.add(defaultDrmSession);
            if (this.f6918b != null) {
                return;
            }
            this.f6918b = defaultDrmSession;
            ExoMediaDrm.ProvisionRequest provisionRequestB = defaultDrmSession.f6872b.b();
            defaultDrmSession.x = provisionRequestB;
            DefaultDrmSession.RequestHandler requestHandler = defaultDrmSession.r;
            int i2 = Util.f5744a;
            provisionRequestB.getClass();
            requestHandler.getClass();
            requestHandler.obtainMessage(1, new DefaultDrmSession.RequestTask(LoadEventInfo.f7578d.getAndIncrement(), true, SystemClock.elapsedRealtime(), provisionRequestB)).sendToTarget();
        }
    }

    public class ReferenceCountListenerImpl implements DefaultDrmSession.ReferenceCountListener {
        public ReferenceCountListenerImpl() {
        }

        @Override // androidx.media3.exoplayer.drm.DefaultDrmSession.ReferenceCountListener
        public final void a(DefaultDrmSession defaultDrmSession) {
            DefaultDrmSessionManager defaultDrmSessionManager = DefaultDrmSessionManager.this;
            if (defaultDrmSessionManager.f6901l != -9223372036854775807L) {
                defaultDrmSessionManager.o.remove(defaultDrmSession);
                Handler handler = defaultDrmSessionManager.u;
                handler.getClass();
                handler.removeCallbacksAndMessages(defaultDrmSession);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x002c  */
        @Override // androidx.media3.exoplayer.drm.DefaultDrmSession.ReferenceCountListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void b(androidx.media3.exoplayer.drm.DefaultDrmSession r12, int r13) {
            /*
                r11 = this;
                r0 = 1
                r1 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
                androidx.media3.exoplayer.drm.DefaultDrmSessionManager r3 = androidx.media3.exoplayer.drm.DefaultDrmSessionManager.this
                if (r13 != r0) goto L2c
                int r4 = r3.p
                if (r4 <= 0) goto L2c
                long r4 = r3.f6901l
                int r6 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
                if (r6 == 0) goto L2c
                java.util.Set r13 = r3.o
                r13.add(r12)
                android.os.Handler r13 = r3.u
                r13.getClass()
                androidx.media3.exoplayer.drm.a r1 = new androidx.media3.exoplayer.drm.a
                r1.<init>(r12, r0)
                long r6 = android.os.SystemClock.uptimeMillis()
                long r6 = r6 + r4
                r13.postAtTime(r1, r12, r6)
                goto L9b
            L2c:
                if (r13 != 0) goto L9b
                java.util.ArrayList r13 = r3.f6902m
                r13.remove(r12)
                androidx.media3.exoplayer.drm.DefaultDrmSession r13 = r3.r
                r0 = 0
                if (r13 != r12) goto L3a
                r3.r = r0
            L3a:
                androidx.media3.exoplayer.drm.DefaultDrmSession r13 = r3.s
                if (r13 != r12) goto L40
                r3.s = r0
            L40:
                androidx.media3.exoplayer.drm.DefaultDrmSessionManager$ProvisioningManagerImpl r13 = r3.f6898i
                java.util.HashSet r4 = r13.f6917a
                r4.remove(r12)
                androidx.media3.exoplayer.drm.DefaultDrmSession r5 = r13.f6918b
                if (r5 != r12) goto L88
                r13.f6918b = r0
                boolean r0 = r4.isEmpty()
                if (r0 != 0) goto L88
                java.util.Iterator r0 = r4.iterator()
                java.lang.Object r0 = r0.next()
                androidx.media3.exoplayer.drm.DefaultDrmSession r0 = (androidx.media3.exoplayer.drm.DefaultDrmSession) r0
                r13.f6918b = r0
                androidx.media3.exoplayer.drm.ExoMediaDrm r13 = r0.f6872b
                androidx.media3.exoplayer.drm.ExoMediaDrm$ProvisionRequest r10 = r13.b()
                r0.x = r10
                androidx.media3.exoplayer.drm.DefaultDrmSession$RequestHandler r13 = r0.r
                int r0 = androidx.media3.common.util.Util.f5744a
                r10.getClass()
                r13.getClass()
                androidx.media3.exoplayer.drm.DefaultDrmSession$RequestTask r4 = new androidx.media3.exoplayer.drm.DefaultDrmSession$RequestTask
                java.util.concurrent.atomic.AtomicLong r0 = androidx.media3.exoplayer.source.LoadEventInfo.f7578d
                long r5 = r0.getAndIncrement()
                long r8 = android.os.SystemClock.elapsedRealtime()
                r7 = 1
                r4.<init>(r5, r7, r8, r10)
                android.os.Message r13 = r13.obtainMessage(r7, r4)
                r13.sendToTarget()
            L88:
                long r4 = r3.f6901l
                int r13 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
                if (r13 == 0) goto L9b
                android.os.Handler r13 = r3.u
                r13.getClass()
                r13.removeCallbacksAndMessages(r12)
                java.util.Set r13 = r3.o
                r13.remove(r12)
            L9b:
                r3.j()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.drm.DefaultDrmSessionManager.ReferenceCountListenerImpl.b(androidx.media3.exoplayer.drm.DefaultDrmSession, int):void");
        }
    }

    public DefaultDrmSessionManager(UUID uuid, ExoMediaDrm.Provider provider, HttpMediaDrmCallback httpMediaDrmCallback, HashMap map, boolean z, int[] iArr, boolean z2, DefaultLoadErrorHandlingPolicy defaultLoadErrorHandlingPolicy, long j2) {
        uuid.getClass();
        Assertions.b(!C.f5165b.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.f6891b = uuid;
        this.f6892c = provider;
        this.f6893d = httpMediaDrmCallback;
        this.f6894e = map;
        this.f6895f = z;
        this.f6896g = iArr;
        this.f6897h = z2;
        this.f6899j = defaultLoadErrorHandlingPolicy;
        this.f6898i = new ProvisioningManagerImpl();
        this.f6900k = new ReferenceCountListenerImpl();
        this.f6902m = new ArrayList();
        this.n = Collections.newSetFromMap(new IdentityHashMap());
        this.o = Collections.newSetFromMap(new IdentityHashMap());
        this.f6901l = j2;
    }

    public static boolean f(DrmSession drmSession) {
        DefaultDrmSession defaultDrmSession = (DefaultDrmSession) drmSession;
        defaultDrmSession.n();
        if (defaultDrmSession.o != 1) {
            return false;
        }
        DrmSession.DrmSessionException error = defaultDrmSession.getError();
        error.getClass();
        Throwable cause = error.getCause();
        return (cause instanceof ResourceBusyException) || DrmUtil.b(cause);
    }

    public static ArrayList i(DrmInitData drmInitData, UUID uuid, boolean z) {
        ArrayList arrayList = new ArrayList(drmInitData.f5204d);
        for (int i2 = 0; i2 < drmInitData.f5204d; i2++) {
            DrmInitData.SchemeData schemeData = drmInitData.f5201a[i2];
            if ((schemeData.a(uuid) || (C.f5166c.equals(uuid) && schemeData.a(C.f5165b))) && (schemeData.f5209e != null || z)) {
                arrayList.add(schemeData);
            }
        }
        return arrayList;
    }

    @Override // androidx.media3.exoplayer.drm.DrmSessionManager
    public final void a(Looper looper, PlayerId playerId) {
        synchronized (this) {
            try {
                Looper looper2 = this.t;
                if (looper2 == null) {
                    this.t = looper;
                    this.u = new Handler(looper);
                } else {
                    Assertions.g(looper2 == looper);
                    this.u.getClass();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.w = playerId;
    }

    @Override // androidx.media3.exoplayer.drm.DrmSessionManager
    public final DrmSession b(DrmSessionEventListener.EventDispatcher eventDispatcher, Format format) {
        k(false);
        Assertions.g(this.p > 0);
        Assertions.h(this.t);
        return e(this.t, eventDispatcher, format, true);
    }

    @Override // androidx.media3.exoplayer.drm.DrmSessionManager
    public final int c(Format format) {
        k(false);
        ExoMediaDrm exoMediaDrm = this.q;
        exoMediaDrm.getClass();
        int iF = exoMediaDrm.f();
        DrmInitData drmInitData = format.q;
        if (drmInitData == null) {
            int i2 = MimeTypes.i(format.f5225m);
            int i3 = 0;
            while (true) {
                int[] iArr = this.f6896g;
                if (i3 >= iArr.length) {
                    i3 = -1;
                    break;
                }
                if (iArr[i3] == i2) {
                    break;
                }
                i3++;
            }
            if (i3 == -1) {
                return 0;
            }
        } else if (this.v == null) {
            UUID uuid = this.f6891b;
            if (i(drmInitData, uuid, true).isEmpty()) {
                if (drmInitData.f5204d == 1 && drmInitData.f5201a[0].a(C.f5165b)) {
                    Log.h("DefaultDrmSessionMgr", "DrmInitData only contains common PSSH SchemeData. Assuming support for: " + uuid);
                }
                return 1;
            }
            String str = drmInitData.f5203c;
            if (str != null && !"cenc".equals(str) && (!"cbcs".equals(str) ? "cbc1".equals(str) || "cens".equals(str) : Util.f5744a < 25)) {
                return 1;
            }
        }
        return iF;
    }

    @Override // androidx.media3.exoplayer.drm.DrmSessionManager
    public final DrmSessionManager.DrmSessionReference d(DrmSessionEventListener.EventDispatcher eventDispatcher, Format format) {
        Assertions.g(this.p > 0);
        Assertions.h(this.t);
        PreacquiredSessionReference preacquiredSessionReference = new PreacquiredSessionReference(eventDispatcher);
        Handler handler = this.u;
        handler.getClass();
        handler.post(new b(3, preacquiredSessionReference, format));
        return preacquiredSessionReference;
    }

    public final DrmSession e(Looper looper, DrmSessionEventListener.EventDispatcher eventDispatcher, Format format, boolean z) {
        ArrayList arrayListI;
        if (this.x == null) {
            this.x = new MediaDrmHandler(looper);
        }
        DrmInitData drmInitData = format.q;
        int i2 = 0;
        DefaultDrmSession defaultDrmSession = null;
        if (drmInitData == null) {
            int i3 = MimeTypes.i(format.f5225m);
            ExoMediaDrm exoMediaDrm = this.q;
            exoMediaDrm.getClass();
            if (exoMediaDrm.f() != 2 || !FrameworkCryptoConfig.f6935c) {
                int[] iArr = this.f6896g;
                while (true) {
                    if (i2 >= iArr.length) {
                        i2 = -1;
                        break;
                    }
                    if (iArr[i2] == i3) {
                        break;
                    }
                    i2++;
                }
                if (i2 != -1 && exoMediaDrm.f() != 1) {
                    DefaultDrmSession defaultDrmSession2 = this.r;
                    if (defaultDrmSession2 == null) {
                        DefaultDrmSession defaultDrmSessionH = h(ImmutableList.r(), true, null, z);
                        this.f6902m.add(defaultDrmSessionH);
                        this.r = defaultDrmSessionH;
                    } else {
                        defaultDrmSession2.e(null);
                    }
                    return this.r;
                }
            }
            return null;
        }
        if (this.v == null) {
            arrayListI = i(drmInitData, this.f6891b, false);
            if (arrayListI.isEmpty()) {
                MissingSchemeDataException missingSchemeDataException = new MissingSchemeDataException("Media does not support uuid: " + this.f6891b);
                Log.e("DefaultDrmSessionMgr", "DRM error", missingSchemeDataException);
                if (eventDispatcher != null) {
                    eventDispatcher.e(missingSchemeDataException);
                }
                return new ErrorStateDrmSession(new DrmSession.DrmSessionException(6003, missingSchemeDataException));
            }
        } else {
            arrayListI = null;
        }
        if (this.f6895f) {
            Iterator it = this.f6902m.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                DefaultDrmSession defaultDrmSession3 = (DefaultDrmSession) it.next();
                if (Util.a(defaultDrmSession3.f6871a, arrayListI)) {
                    defaultDrmSession = defaultDrmSession3;
                    break;
                }
            }
        } else {
            defaultDrmSession = this.s;
        }
        if (defaultDrmSession != null) {
            defaultDrmSession.e(eventDispatcher);
            return defaultDrmSession;
        }
        DefaultDrmSession defaultDrmSessionH2 = h(arrayListI, false, eventDispatcher, z);
        if (!this.f6895f) {
            this.s = defaultDrmSessionH2;
        }
        this.f6902m.add(defaultDrmSessionH2);
        return defaultDrmSessionH2;
    }

    public final DefaultDrmSession g(List list, boolean z, DrmSessionEventListener.EventDispatcher eventDispatcher) {
        this.q.getClass();
        boolean z2 = this.f6897h | z;
        ExoMediaDrm exoMediaDrm = this.q;
        byte[] bArr = this.v;
        Looper looper = this.t;
        looper.getClass();
        PlayerId playerId = this.w;
        playerId.getClass();
        DefaultDrmSession defaultDrmSession = new DefaultDrmSession(this.f6891b, exoMediaDrm, this.f6898i, this.f6900k, list, z2, z, bArr, this.f6894e, this.f6893d, looper, this.f6899j, playerId);
        defaultDrmSession.e(eventDispatcher);
        if (this.f6901l != -9223372036854775807L) {
            defaultDrmSession.e(null);
        }
        return defaultDrmSession;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final DefaultDrmSession h(List list, boolean z, DrmSessionEventListener.EventDispatcher eventDispatcher, boolean z2) {
        DefaultDrmSession defaultDrmSessionG = g(list, z, eventDispatcher);
        boolean zF = f(defaultDrmSessionG);
        long j2 = this.f6901l;
        Set set = this.o;
        if (zF && !set.isEmpty()) {
            UnmodifiableIterator it = ImmutableSet.o(set).iterator();
            while (it.hasNext()) {
                ((DrmSession) it.next()).f(null);
            }
            defaultDrmSessionG.f(eventDispatcher);
            if (j2 != -9223372036854775807L) {
                defaultDrmSessionG.f(null);
            }
            defaultDrmSessionG = g(list, z, eventDispatcher);
        }
        if (f(defaultDrmSessionG) && z2) {
            Set set2 = this.n;
            if (!set2.isEmpty()) {
                UnmodifiableIterator it2 = ImmutableSet.o(set2).iterator();
                while (it2.hasNext()) {
                    ((PreacquiredSessionReference) it2.next()).release();
                }
                if (!set.isEmpty()) {
                    UnmodifiableIterator it3 = ImmutableSet.o(set).iterator();
                    while (it3.hasNext()) {
                        ((DrmSession) it3.next()).f(null);
                    }
                }
                defaultDrmSessionG.f(eventDispatcher);
                if (j2 != -9223372036854775807L) {
                    defaultDrmSessionG.f(null);
                }
                return g(list, z, eventDispatcher);
            }
        }
        return defaultDrmSessionG;
    }

    public final void j() {
        if (this.q != null && this.p == 0 && this.f6902m.isEmpty() && this.n.isEmpty()) {
            ExoMediaDrm exoMediaDrm = this.q;
            exoMediaDrm.getClass();
            exoMediaDrm.release();
            this.q = null;
        }
    }

    public final void k(boolean z) {
        if (z && this.t == null) {
            Log.i("DefaultDrmSessionMgr", "DefaultDrmSessionManager accessed before setPlayer(), possibly on the wrong thread.", new IllegalStateException());
            return;
        }
        Thread threadCurrentThread = Thread.currentThread();
        Looper looper = this.t;
        looper.getClass();
        if (threadCurrentThread != looper.getThread()) {
            Log.i("DefaultDrmSessionMgr", "DefaultDrmSessionManager accessed on the wrong thread.\nCurrent thread: " + Thread.currentThread().getName() + "\nExpected thread: " + this.t.getThread().getName(), new IllegalStateException());
        }
    }

    @Override // androidx.media3.exoplayer.drm.DrmSessionManager
    public final void p() {
        k(true);
        int i2 = this.p;
        this.p = i2 + 1;
        if (i2 != 0) {
            return;
        }
        if (this.q == null) {
            ExoMediaDrm exoMediaDrmH = this.f6892c.h(this.f6891b);
            this.q = exoMediaDrmH;
            exoMediaDrmH.j(new MediaDrmEventListener());
        } else {
            if (this.f6901l == -9223372036854775807L) {
                return;
            }
            int i3 = 0;
            while (true) {
                ArrayList arrayList = this.f6902m;
                if (i3 >= arrayList.size()) {
                    return;
                }
                ((DefaultDrmSession) arrayList.get(i3)).e(null);
                i3++;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.media3.exoplayer.drm.DrmSessionManager
    public final void release() {
        k(true);
        int i2 = this.p - 1;
        this.p = i2;
        if (i2 != 0) {
            return;
        }
        if (this.f6901l != -9223372036854775807L) {
            ArrayList arrayList = new ArrayList(this.f6902m);
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                ((DefaultDrmSession) arrayList.get(i3)).f(null);
            }
        }
        UnmodifiableIterator it = ImmutableSet.o(this.n).iterator();
        while (it.hasNext()) {
            ((PreacquiredSessionReference) it.next()).release();
        }
        j();
    }
}
