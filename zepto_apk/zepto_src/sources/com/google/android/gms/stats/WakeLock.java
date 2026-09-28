package com.google.android.gms.stats;

import android.content.Context;
import android.os.PowerManager;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.common.util.WorkSourceUtil;
import com.google.android.gms.internal.stats.zzi;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.ThreadSafe;

@ShowFirstParty
@ThreadSafe
@KeepForSdk
/* loaded from: classes4.dex */
public class WakeLock {
    public static final long n = TimeUnit.DAYS.toMillis(366);
    public static volatile ScheduledExecutorService o = null;
    public static final Object p = new Object();
    public static volatile zzd q;

    /* renamed from: a, reason: collision with root package name */
    public final Object f39734a;

    /* renamed from: b, reason: collision with root package name */
    public final PowerManager.WakeLock f39735b;

    /* renamed from: c, reason: collision with root package name */
    public int f39736c;

    /* renamed from: d, reason: collision with root package name */
    public ScheduledFuture f39737d;

    /* renamed from: e, reason: collision with root package name */
    public long f39738e;

    /* renamed from: f, reason: collision with root package name */
    public final HashSet f39739f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f39740g;

    /* renamed from: h, reason: collision with root package name */
    public com.google.android.gms.internal.stats.zzb f39741h;

    /* renamed from: i, reason: collision with root package name */
    public final Clock f39742i;

    /* renamed from: j, reason: collision with root package name */
    public final String f39743j;

    /* renamed from: k, reason: collision with root package name */
    public final HashMap f39744k;

    /* renamed from: l, reason: collision with root package name */
    public final AtomicInteger f39745l;

    /* renamed from: m, reason: collision with root package name */
    public final ScheduledExecutorService f39746m;

    public WakeLock(Context context) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String packageName = context.getPackageName();
        this.f39734a = new Object();
        this.f39736c = 0;
        this.f39739f = new HashSet();
        this.f39740g = true;
        this.f39742i = DefaultClock.getInstance();
        this.f39744k = new HashMap();
        this.f39745l = new AtomicInteger(0);
        Preconditions.checkNotNull(context, "WakeLock: context must not be null");
        Preconditions.checkNotEmpty("wake:com.google.firebase.iid.WakeLockHolder", "WakeLock: wakeLockName must not be empty");
        context.getApplicationContext();
        this.f39741h = null;
        if ("com.google.android.gms".equals(context.getPackageName())) {
            this.f39743j = "wake:com.google.firebase.iid.WakeLockHolder";
        } else {
            this.f39743j = "wake:com.google.firebase.iid.WakeLockHolder".length() != 0 ? "*gcore*:".concat("wake:com.google.firebase.iid.WakeLockHolder") : new String("*gcore*:");
        }
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            StringBuilder sb = new StringBuilder(29);
            sb.append((CharSequence) "expected a non-null reference", 0, 29);
            throw new zzi(sb.toString());
        }
        PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(1, "wake:com.google.firebase.iid.WakeLockHolder");
        this.f39735b = wakeLockNewWakeLock;
        if (WorkSourceUtil.hasWorkSourcePermission(context)) {
            WorkSource workSourceFromPackage = WorkSourceUtil.fromPackage(context, Strings.isEmptyOrWhitespace(packageName) ? context.getPackageName() : packageName);
            if (workSourceFromPackage != null) {
                try {
                    wakeLockNewWakeLock.setWorkSource(workSourceFromPackage);
                } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e2) {
                    Log.wtf("WakeLock", e2.toString());
                }
            }
        }
        ScheduledExecutorService scheduledExecutorServiceUnconfigurableScheduledExecutorService = o;
        if (scheduledExecutorServiceUnconfigurableScheduledExecutorService == null) {
            synchronized (p) {
                try {
                    scheduledExecutorServiceUnconfigurableScheduledExecutorService = o;
                    if (scheduledExecutorServiceUnconfigurableScheduledExecutorService == null) {
                        scheduledExecutorServiceUnconfigurableScheduledExecutorService = Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1));
                        o = scheduledExecutorServiceUnconfigurableScheduledExecutorService;
                    }
                } finally {
                }
            }
        }
        this.f39746m = scheduledExecutorServiceUnconfigurableScheduledExecutorService;
    }

    public final void a(long j2) {
        this.f39745l.incrementAndGet();
        long jMax = Math.max(Math.min(Long.MAX_VALUE, n), 1L);
        if (j2 > 0) {
            jMax = Math.min(j2, jMax);
        }
        synchronized (this.f39734a) {
            try {
                if (!b()) {
                    this.f39741h = com.google.android.gms.internal.stats.zzb.f38266a;
                    this.f39735b.acquire();
                    this.f39742i.elapsedRealtime();
                }
                this.f39736c++;
                if (this.f39740g) {
                    TextUtils.isEmpty(null);
                }
                zzc zzcVar = (zzc) this.f39744k.get(null);
                if (zzcVar == null) {
                    zzcVar = new zzc();
                    this.f39744k.put(null, zzcVar);
                }
                zzcVar.f39748a++;
                long jElapsedRealtime = this.f39742i.elapsedRealtime();
                long j3 = Long.MAX_VALUE - jElapsedRealtime > jMax ? jElapsedRealtime + jMax : Long.MAX_VALUE;
                if (j3 > this.f39738e) {
                    this.f39738e = j3;
                    ScheduledFuture scheduledFuture = this.f39737d;
                    if (scheduledFuture != null) {
                        scheduledFuture.cancel(false);
                    }
                    this.f39737d = this.f39746m.schedule(new Runnable() { // from class: com.google.android.gms.stats.zza
                        @Override // java.lang.Runnable
                        public final void run() {
                            WakeLock wakeLock = this.f39747a;
                            synchronized (wakeLock.f39734a) {
                                try {
                                    if (wakeLock.b()) {
                                        Log.e("WakeLock", String.valueOf(wakeLock.f39743j).concat(" ** IS FORCE-RELEASED ON TIMEOUT **"));
                                        wakeLock.d();
                                        if (wakeLock.b()) {
                                            wakeLock.f39736c = 1;
                                            wakeLock.e();
                                        }
                                    }
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                        }
                    }, jMax, TimeUnit.MILLISECONDS);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean b() {
        boolean z;
        synchronized (this.f39734a) {
            z = this.f39736c > 0;
        }
        return z;
    }

    public final void c() {
        if (this.f39745l.decrementAndGet() < 0) {
            Log.e("WakeLock", String.valueOf(this.f39743j).concat(" release without a matched acquire!"));
        }
        synchronized (this.f39734a) {
            try {
                if (this.f39740g) {
                    TextUtils.isEmpty(null);
                }
                if (this.f39744k.containsKey(null)) {
                    zzc zzcVar = (zzc) this.f39744k.get(null);
                    if (zzcVar != null) {
                        int i2 = zzcVar.f39748a - 1;
                        zzcVar.f39748a = i2;
                        if (i2 == 0) {
                            this.f39744k.remove(null);
                        }
                    }
                } else {
                    Log.w("WakeLock", String.valueOf(this.f39743j).concat(" counter does not exist"));
                }
                e();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d() {
        HashSet hashSet = this.f39739f;
        if (hashSet.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList(hashSet);
        hashSet.clear();
        if (arrayList.size() <= 0) {
            return;
        }
        throw null;
    }

    public final void e() {
        synchronized (this.f39734a) {
            try {
                if (b()) {
                    if (this.f39740g) {
                        int i2 = this.f39736c - 1;
                        this.f39736c = i2;
                        if (i2 > 0) {
                            return;
                        }
                    } else {
                        this.f39736c = 0;
                    }
                    d();
                    Iterator it = this.f39744k.values().iterator();
                    while (it.hasNext()) {
                        ((zzc) it.next()).f39748a = 0;
                    }
                    this.f39744k.clear();
                    ScheduledFuture scheduledFuture = this.f39737d;
                    if (scheduledFuture != null) {
                        scheduledFuture.cancel(false);
                        this.f39737d = null;
                        this.f39738e = 0L;
                    }
                    if (this.f39735b.isHeld()) {
                        try {
                            try {
                                this.f39735b.release();
                                if (this.f39741h != null) {
                                    this.f39741h = null;
                                }
                            } catch (RuntimeException e2) {
                                if (!e2.getClass().equals(RuntimeException.class)) {
                                    throw e2;
                                }
                                Log.e("WakeLock", String.valueOf(this.f39743j).concat(" failed to release!"), e2);
                                if (this.f39741h != null) {
                                    this.f39741h = null;
                                }
                            }
                        } catch (Throwable th) {
                            if (this.f39741h != null) {
                                this.f39741h = null;
                            }
                            throw th;
                        }
                    } else {
                        Log.e("WakeLock", String.valueOf(this.f39743j).concat(" should be held!"));
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
