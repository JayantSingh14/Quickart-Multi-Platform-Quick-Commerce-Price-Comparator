package androidx.media3.exoplayer.upstream;

import android.content.Context;
import android.os.Handler;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.NetworkTypeObserver;
import androidx.media3.common.util.SystemClock;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.upstream.BandwidthMeter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

@UnstableApi
/* loaded from: classes.dex */
public final class DefaultBandwidthMeter implements BandwidthMeter, TransferListener {
    public static final ImmutableList n = ImmutableList.s(4300000L, 3200000L, 2400000L, 1700000L, 860000L);
    public static final ImmutableList o = ImmutableList.s(1500000L, 980000L, 750000L, 520000L, 290000L);
    public static final ImmutableList p = ImmutableList.s(2000000L, 1300000L, 1000000L, 860000L, 610000L);
    public static final ImmutableList q = ImmutableList.s(2500000L, 1700000L, 1200000L, 970000L, 680000L);
    public static final ImmutableList r = ImmutableList.s(4700000L, 2800000L, 2100000L, 1700000L, 980000L);
    public static final ImmutableList s = ImmutableList.s(2700000L, 2000000L, 1600000L, 1300000L, 1000000L);
    public static DefaultBandwidthMeter t;

    /* renamed from: a, reason: collision with root package name */
    public final ImmutableMap f8137a;

    /* renamed from: b, reason: collision with root package name */
    public final BandwidthMeter.EventListener.EventDispatcher f8138b = new BandwidthMeter.EventListener.EventDispatcher();

    /* renamed from: c, reason: collision with root package name */
    public final SystemClock f8139c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f8140d;

    /* renamed from: e, reason: collision with root package name */
    public final SlidingPercentile f8141e;

    /* renamed from: f, reason: collision with root package name */
    public int f8142f;

    /* renamed from: g, reason: collision with root package name */
    public long f8143g;

    /* renamed from: h, reason: collision with root package name */
    public long f8144h;

    /* renamed from: i, reason: collision with root package name */
    public long f8145i;

    /* renamed from: j, reason: collision with root package name */
    public long f8146j;

    /* renamed from: k, reason: collision with root package name */
    public long f8147k;

    /* renamed from: l, reason: collision with root package name */
    public long f8148l;

    /* renamed from: m, reason: collision with root package name */
    public int f8149m;

    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public final Context f8150a;

        /* renamed from: b, reason: collision with root package name */
        public final HashMap f8151b;

        /* renamed from: c, reason: collision with root package name */
        public final int f8152c;

        /* renamed from: d, reason: collision with root package name */
        public final SystemClock f8153d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f8154e;

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:13:0x0038  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public Builder(android.content.Context r15) {
            /*
                Method dump skipped, instructions count: 8796
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.upstream.DefaultBandwidthMeter.Builder.<init>(android.content.Context):void");
        }
    }

    public DefaultBandwidthMeter(Context context, HashMap map, int i2, SystemClock systemClock, boolean z) {
        this.f8137a = ImmutableMap.a(map);
        this.f8141e = new SlidingPercentile(i2);
        this.f8139c = systemClock;
        this.f8140d = z;
        if (context == null) {
            this.f8149m = 0;
            this.f8147k = j(0);
            return;
        }
        NetworkTypeObserver networkTypeObserverB = NetworkTypeObserver.b(context);
        int iC = networkTypeObserverB.c();
        this.f8149m = iC;
        this.f8147k = j(iC);
        b bVar = new b(this);
        CopyOnWriteArrayList copyOnWriteArrayList = networkTypeObserverB.f5711b;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference.get() == null) {
                copyOnWriteArrayList.remove(weakReference);
            }
        }
        copyOnWriteArrayList.add(new WeakReference(bVar));
        networkTypeObserverB.f5710a.post(new androidx.media3.common.util.c(0, networkTypeObserverB, bVar));
    }

    @Override // androidx.media3.exoplayer.upstream.BandwidthMeter
    public final void a(BandwidthMeter.EventListener eventListener) {
        this.f8138b.a(eventListener);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x000d  */
    @Override // androidx.media3.datasource.TransferListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void c(androidx.media3.datasource.DataSpec r3, boolean r4, int r5) {
        /*
            r2 = this;
            monitor-enter(r2)
            if (r4 == 0) goto Ld
            r4 = 8
            boolean r3 = r3.c(r4)     // Catch: java.lang.Throwable -> L1a
            if (r3 != 0) goto Ld
            r3 = 1
            goto Le
        Ld:
            r3 = 0
        Le:
            if (r3 != 0) goto L12
            monitor-exit(r2)
            return
        L12:
            long r3 = r2.f8144h     // Catch: java.lang.Throwable -> L1a
            long r0 = (long) r5     // Catch: java.lang.Throwable -> L1a
            long r3 = r3 + r0
            r2.f8144h = r3     // Catch: java.lang.Throwable -> L1a
            monitor-exit(r2)
            return
        L1a:
            r3 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L1a
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.upstream.DefaultBandwidthMeter.c(androidx.media3.datasource.DataSpec, boolean, int):void");
    }

    @Override // androidx.media3.exoplayer.upstream.BandwidthMeter
    public final void d(Handler handler, BandwidthMeter.EventListener eventListener) {
        Assertions.d(eventListener);
        BandwidthMeter.EventListener.EventDispatcher eventDispatcher = this.f8138b;
        eventDispatcher.getClass();
        eventDispatcher.a(eventListener);
        eventDispatcher.f8061a.add(new BandwidthMeter.EventListener.EventDispatcher.HandlerAndListener(handler, eventListener));
    }

    @Override // androidx.media3.exoplayer.upstream.BandwidthMeter
    public final TransferListener e() {
        return this;
    }

    @Override // androidx.media3.exoplayer.upstream.BandwidthMeter
    public final synchronized long f() {
        return this.f8147k;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x000f  */
    @Override // androidx.media3.datasource.TransferListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void h(androidx.media3.datasource.DataSpec r13, boolean r14) {
        /*
            r12 = this;
            monitor-enter(r12)
            r0 = 0
            r1 = 1
            if (r14 == 0) goto Lf
            r14 = 8
            boolean r13 = r13.c(r14)     // Catch: java.lang.Throwable -> L5c
            if (r13 != 0) goto Lf
            r13 = r1
            goto L10
        Lf:
            r13 = r0
        L10:
            if (r13 != 0) goto L14
            monitor-exit(r12)
            return
        L14:
            int r13 = r12.f8142f     // Catch: java.lang.Throwable -> L5c
            if (r13 <= 0) goto L19
            r0 = r1
        L19:
            androidx.media3.common.util.Assertions.g(r0)     // Catch: java.lang.Throwable -> L5c
            androidx.media3.common.util.SystemClock r13 = r12.f8139c     // Catch: java.lang.Throwable -> L5c
            r13.getClass()     // Catch: java.lang.Throwable -> L5c
            long r13 = android.os.SystemClock.elapsedRealtime()     // Catch: java.lang.Throwable -> L5c
            long r2 = r12.f8143g     // Catch: java.lang.Throwable -> L5c
            long r2 = r13 - r2
            int r6 = (int) r2     // Catch: java.lang.Throwable -> L5c
            long r2 = r12.f8145i     // Catch: java.lang.Throwable -> L5c
            long r4 = (long) r6     // Catch: java.lang.Throwable -> L5c
            long r2 = r2 + r4
            r12.f8145i = r2     // Catch: java.lang.Throwable -> L5c
            long r2 = r12.f8146j     // Catch: java.lang.Throwable -> L5c
            long r4 = r12.f8144h     // Catch: java.lang.Throwable -> L5c
            long r2 = r2 + r4
            r12.f8146j = r2     // Catch: java.lang.Throwable -> L5c
            if (r6 <= 0) goto La9
            float r0 = (float) r4     // Catch: java.lang.Throwable -> L5c
            r2 = 1174011904(0x45fa0000, float:8000.0)
            float r0 = r0 * r2
            float r2 = (float) r6     // Catch: java.lang.Throwable -> L5c
            float r0 = r0 / r2
            androidx.media3.exoplayer.upstream.SlidingPercentile r2 = r12.f8141e     // Catch: java.lang.Throwable -> L5c
            double r3 = (double) r4     // Catch: java.lang.Throwable -> L5c
            double r3 = java.lang.Math.sqrt(r3)     // Catch: java.lang.Throwable -> L5c
            int r3 = (int) r3     // Catch: java.lang.Throwable -> L5c
            r2.a(r0, r3)     // Catch: java.lang.Throwable -> L5c
            long r2 = r12.f8145i     // Catch: java.lang.Throwable -> L5c
            r4 = 2000(0x7d0, double:9.88E-321)
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 >= 0) goto L5f
            long r2 = r12.f8146j     // Catch: java.lang.Throwable -> L5c
            r4 = 524288(0x80000, double:2.590327E-318)
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 < 0) goto L68
            goto L5f
        L5c:
            r0 = move-exception
            r13 = r0
            goto Lb0
        L5f:
            androidx.media3.exoplayer.upstream.SlidingPercentile r0 = r12.f8141e     // Catch: java.lang.Throwable -> L5c
            float r0 = r0.b()     // Catch: java.lang.Throwable -> L5c
            long r2 = (long) r0     // Catch: java.lang.Throwable -> L5c
            r12.f8147k = r2     // Catch: java.lang.Throwable -> L5c
        L68:
            long r7 = r12.f8144h     // Catch: java.lang.Throwable -> L5c
            long r9 = r12.f8147k     // Catch: java.lang.Throwable -> L5c
            r2 = 0
            if (r6 != 0) goto L7b
            int r0 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r0 != 0) goto L7b
            long r4 = r12.f8148l     // Catch: java.lang.Throwable -> L5c
            int r0 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r0 != 0) goto L7b
            goto La5
        L7b:
            r12.f8148l = r9     // Catch: java.lang.Throwable -> L5c
            androidx.media3.exoplayer.upstream.BandwidthMeter$EventListener$EventDispatcher r0 = r12.f8138b     // Catch: java.lang.Throwable -> L5c
            java.util.concurrent.CopyOnWriteArrayList r0 = r0.f8061a     // Catch: java.lang.Throwable -> L5c
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L5c
        L85:
            boolean r4 = r0.hasNext()     // Catch: java.lang.Throwable -> L5c
            if (r4 == 0) goto La5
            java.lang.Object r4 = r0.next()     // Catch: java.lang.Throwable -> L5c
            r5 = r4
            androidx.media3.exoplayer.upstream.BandwidthMeter$EventListener$EventDispatcher$HandlerAndListener r5 = (androidx.media3.exoplayer.upstream.BandwidthMeter.EventListener.EventDispatcher.HandlerAndListener) r5     // Catch: java.lang.Throwable -> L5c
            boolean r4 = androidx.media3.exoplayer.upstream.BandwidthMeter.EventListener.EventDispatcher.HandlerAndListener.b(r5)     // Catch: java.lang.Throwable -> L5c
            if (r4 != 0) goto L85
            android.os.Handler r11 = androidx.media3.exoplayer.upstream.BandwidthMeter.EventListener.EventDispatcher.HandlerAndListener.c(r5)     // Catch: java.lang.Throwable -> L5c
            androidx.media3.exoplayer.upstream.a r4 = new androidx.media3.exoplayer.upstream.a     // Catch: java.lang.Throwable -> L5c
            r4.<init>(r5, r6, r7, r9)     // Catch: java.lang.Throwable -> L5c
            r11.post(r4)     // Catch: java.lang.Throwable -> L5c
            goto L85
        La5:
            r12.f8143g = r13     // Catch: java.lang.Throwable -> L5c
            r12.f8144h = r2     // Catch: java.lang.Throwable -> L5c
        La9:
            int r13 = r12.f8142f     // Catch: java.lang.Throwable -> L5c
            int r13 = r13 - r1
            r12.f8142f = r13     // Catch: java.lang.Throwable -> L5c
            monitor-exit(r12)
            return
        Lb0:
            monitor-exit(r12)     // Catch: java.lang.Throwable -> L5c
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.upstream.DefaultBandwidthMeter.h(androidx.media3.datasource.DataSpec, boolean):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x000e  */
    @Override // androidx.media3.datasource.TransferListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void i(androidx.media3.datasource.DataSpec r2, boolean r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            r0 = 1
            if (r3 == 0) goto Le
            r3 = 8
            boolean r2 = r2.c(r3)     // Catch: java.lang.Throwable -> L23
            if (r2 != 0) goto Le
            r2 = r0
            goto Lf
        Le:
            r2 = 0
        Lf:
            if (r2 != 0) goto L13
            monitor-exit(r1)
            return
        L13:
            int r2 = r1.f8142f     // Catch: java.lang.Throwable -> L23
            if (r2 != 0) goto L25
            androidx.media3.common.util.SystemClock r2 = r1.f8139c     // Catch: java.lang.Throwable -> L23
            r2.getClass()     // Catch: java.lang.Throwable -> L23
            long r2 = android.os.SystemClock.elapsedRealtime()     // Catch: java.lang.Throwable -> L23
            r1.f8143g = r2     // Catch: java.lang.Throwable -> L23
            goto L25
        L23:
            r2 = move-exception
            goto L2c
        L25:
            int r2 = r1.f8142f     // Catch: java.lang.Throwable -> L23
            int r2 = r2 + r0
            r1.f8142f = r2     // Catch: java.lang.Throwable -> L23
            monitor-exit(r1)
            return
        L2c:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L23
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.upstream.DefaultBandwidthMeter.i(androidx.media3.datasource.DataSpec, boolean):void");
    }

    public final long j(int i2) {
        Integer numValueOf = Integer.valueOf(i2);
        ImmutableMap immutableMap = this.f8137a;
        Long l2 = (Long) immutableMap.get(numValueOf);
        if (l2 == null) {
            l2 = (Long) immutableMap.get(0);
        }
        if (l2 == null) {
            l2 = 1000000L;
        }
        return l2.longValue();
    }

    @Override // androidx.media3.datasource.TransferListener
    public final void g(DataSpec dataSpec, boolean z) {
    }
}
