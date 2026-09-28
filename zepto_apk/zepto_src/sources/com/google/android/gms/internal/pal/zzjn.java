package com.google.android.gms.internal.pal;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.StringUtils;
import sun.misc.Unsafe;

/* loaded from: classes4.dex */
public abstract class zzjn<V> extends zzjs implements zzjq<V> {

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f37848d;

    /* renamed from: e, reason: collision with root package name */
    public static final Logger f37849e;

    /* renamed from: f, reason: collision with root package name */
    public static final zza f37850f;

    /* renamed from: g, reason: collision with root package name */
    public static final Object f37851g;

    /* renamed from: a, reason: collision with root package name */
    public volatile Object f37852a;

    /* renamed from: b, reason: collision with root package name */
    public volatile zzd f37853b;

    /* renamed from: c, reason: collision with root package name */
    public volatile zzk f37854c;

    abstract class zza {
        public abstract zzd a(zzjn zzjnVar);

        public abstract zzk b(zzjn zzjnVar);

        public abstract void c(zzk zzkVar, zzk zzkVar2);

        public abstract void d(zzk zzkVar, Thread thread);

        public abstract boolean e(zzjn zzjnVar, Object obj, Object obj2);

        public abstract boolean f(zzjn zzjnVar, zzk zzkVar, zzk zzkVar2);
    }

    final class zzb {

        /* renamed from: b, reason: collision with root package name */
        public static final zzb f37855b;

        /* renamed from: c, reason: collision with root package name */
        public static final zzb f37856c;

        /* renamed from: a, reason: collision with root package name */
        public final RuntimeException f37857a;

        static {
            if (zzjn.f37848d) {
                f37856c = null;
                f37855b = null;
            } else {
                f37856c = new zzb(false, null);
                f37855b = new zzb(true, null);
            }
        }

        public zzb(boolean z, RuntimeException runtimeException) {
            this.f37857a = runtimeException;
        }
    }

    final class zzc {

        /* renamed from: a, reason: collision with root package name */
        public final Throwable f37858a;

        /* renamed from: com.google.android.gms.internal.pal.zzjn$zzc$1, reason: invalid class name */
        public class AnonymousClass1 extends Throwable {
            @Override // java.lang.Throwable
            public final synchronized Throwable fillInStackTrace() {
                return this;
            }
        }

        static {
            new zzc(new AnonymousClass1("Failure occurred while trying to finish a future."));
        }

        public zzc(Throwable th) {
            th.getClass();
            this.f37858a = th;
        }
    }

    final class zzd {

        /* renamed from: b, reason: collision with root package name */
        public static final zzd f37859b = new zzd();

        /* renamed from: a, reason: collision with root package name */
        public zzd f37860a;
    }

    final class zze extends zza {

        /* renamed from: a, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f37861a;

        /* renamed from: b, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f37862b;

        /* renamed from: c, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f37863c;

        /* renamed from: d, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f37864d;

        /* renamed from: e, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f37865e;

        public zze(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
            this.f37861a = atomicReferenceFieldUpdater;
            this.f37862b = atomicReferenceFieldUpdater2;
            this.f37863c = atomicReferenceFieldUpdater3;
            this.f37864d = atomicReferenceFieldUpdater4;
            this.f37865e = atomicReferenceFieldUpdater5;
        }

        @Override // com.google.android.gms.internal.pal.zzjn.zza
        public final zzd a(zzjn zzjnVar) {
            return (zzd) this.f37864d.getAndSet(zzjnVar, zzd.f37859b);
        }

        @Override // com.google.android.gms.internal.pal.zzjn.zza
        public final zzk b(zzjn zzjnVar) {
            return (zzk) this.f37863c.getAndSet(zzjnVar, zzk.f37872c);
        }

        @Override // com.google.android.gms.internal.pal.zzjn.zza
        public final void c(zzk zzkVar, zzk zzkVar2) {
            this.f37862b.lazySet(zzkVar, zzkVar2);
        }

        @Override // com.google.android.gms.internal.pal.zzjn.zza
        public final void d(zzk zzkVar, Thread thread) {
            this.f37861a.lazySet(zzkVar, thread);
        }

        @Override // com.google.android.gms.internal.pal.zzjn.zza
        public final boolean e(zzjn zzjnVar, Object obj, Object obj2) {
            while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = this.f37865e;
                if (atomicReferenceFieldUpdater.compareAndSet(zzjnVar, obj, obj2)) {
                    return true;
                }
                if (atomicReferenceFieldUpdater.get(zzjnVar) != obj && atomicReferenceFieldUpdater.get(zzjnVar) != obj) {
                    return false;
                }
            }
        }

        @Override // com.google.android.gms.internal.pal.zzjn.zza
        public final boolean f(zzjn zzjnVar, zzk zzkVar, zzk zzkVar2) {
            while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = this.f37863c;
                if (atomicReferenceFieldUpdater.compareAndSet(zzjnVar, zzkVar, zzkVar2)) {
                    return true;
                }
                if (atomicReferenceFieldUpdater.get(zzjnVar) != zzkVar && atomicReferenceFieldUpdater.get(zzjnVar) != zzkVar) {
                    return false;
                }
            }
        }
    }

    final class zzf<V> implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            throw null;
        }
    }

    final class zzg extends zza {
        @Override // com.google.android.gms.internal.pal.zzjn.zza
        public final zzd a(zzjn zzjnVar) {
            zzd zzdVar;
            zzd zzdVar2 = zzd.f37859b;
            synchronized (zzjnVar) {
                zzdVar = zzjnVar.f37853b;
                if (zzdVar != zzdVar2) {
                    zzjnVar.f37853b = zzdVar2;
                }
            }
            return zzdVar;
        }

        @Override // com.google.android.gms.internal.pal.zzjn.zza
        public final zzk b(zzjn zzjnVar) {
            zzk zzkVar;
            zzk zzkVar2 = zzk.f37872c;
            synchronized (zzjnVar) {
                zzkVar = zzjnVar.f37854c;
                if (zzkVar != zzkVar2) {
                    zzjnVar.f37854c = zzkVar2;
                }
            }
            return zzkVar;
        }

        @Override // com.google.android.gms.internal.pal.zzjn.zza
        public final void c(zzk zzkVar, zzk zzkVar2) {
            zzkVar.f37874b = zzkVar2;
        }

        @Override // com.google.android.gms.internal.pal.zzjn.zza
        public final void d(zzk zzkVar, Thread thread) {
            zzkVar.f37873a = thread;
        }

        @Override // com.google.android.gms.internal.pal.zzjn.zza
        public final boolean e(zzjn zzjnVar, Object obj, Object obj2) {
            synchronized (zzjnVar) {
                try {
                    if (zzjnVar.f37852a != obj) {
                        return false;
                    }
                    zzjnVar.f37852a = obj2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // com.google.android.gms.internal.pal.zzjn.zza
        public final boolean f(zzjn zzjnVar, zzk zzkVar, zzk zzkVar2) {
            synchronized (zzjnVar) {
                try {
                    if (zzjnVar.f37854c != zzkVar) {
                        return false;
                    }
                    zzjnVar.f37854c = zzkVar2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    interface zzh<V> extends zzjq<V> {
    }

    abstract class zzi<V> extends zzjn<V> implements zzh<V> {
    }

    final class zzj extends zza {

        /* renamed from: a, reason: collision with root package name */
        public static final Unsafe f37866a;

        /* renamed from: b, reason: collision with root package name */
        public static final long f37867b;

        /* renamed from: c, reason: collision with root package name */
        public static final long f37868c;

        /* renamed from: d, reason: collision with root package name */
        public static final long f37869d;

        /* renamed from: e, reason: collision with root package name */
        public static final long f37870e;

        /* renamed from: f, reason: collision with root package name */
        public static final long f37871f;

        /* renamed from: com.google.android.gms.internal.pal.zzjn$zzj$1, reason: invalid class name */
        public class AnonymousClass1 implements PrivilegedExceptionAction<Unsafe> {
            public static final Unsafe a() throws IllegalAccessException, SecurityException, IllegalArgumentException {
                for (Field field : Unsafe.class.getDeclaredFields()) {
                    field.setAccessible(true);
                    Object obj = field.get(null);
                    if (Unsafe.class.isInstance(obj)) {
                        return (Unsafe) Unsafe.class.cast(obj);
                    }
                }
                throw new NoSuchFieldError("the Unsafe");
            }

            @Override // java.security.PrivilegedExceptionAction
            public final /* bridge */ /* synthetic */ Unsafe run() {
                return a();
            }
        }

        static {
            Unsafe unsafe;
            try {
                try {
                    unsafe = Unsafe.getUnsafe();
                } catch (PrivilegedActionException e2) {
                    throw new RuntimeException("Could not initialize intrinsics", e2.getCause());
                }
            } catch (SecurityException unused) {
                unsafe = (Unsafe) AccessController.doPrivileged(new AnonymousClass1());
            }
            try {
                f37868c = unsafe.objectFieldOffset(zzjn.class.getDeclaredField("c"));
                f37867b = unsafe.objectFieldOffset(zzjn.class.getDeclaredField("b"));
                f37869d = unsafe.objectFieldOffset(zzjn.class.getDeclaredField("a"));
                f37870e = unsafe.objectFieldOffset(zzk.class.getDeclaredField("a"));
                f37871f = unsafe.objectFieldOffset(zzk.class.getDeclaredField("b"));
                f37866a = unsafe;
            } catch (NoSuchFieldException e3) {
                throw new RuntimeException(e3);
            } catch (RuntimeException e4) {
                throw e4;
            }
        }

        @Override // com.google.android.gms.internal.pal.zzjn.zza
        public final zzd a(zzjn zzjnVar) {
            zzd zzdVar;
            zzd zzdVar2 = zzd.f37859b;
            while (true) {
                zzdVar = zzjnVar.f37853b;
                if (zzdVar2 == zzdVar) {
                    break;
                }
                zzjn zzjnVar2 = zzjnVar;
                if (zzjp.a(f37866a, zzjnVar2, f37867b, zzdVar, zzdVar2)) {
                    break;
                }
                zzjnVar = zzjnVar2;
            }
            return zzdVar;
        }

        @Override // com.google.android.gms.internal.pal.zzjn.zza
        public final zzk b(zzjn zzjnVar) {
            zzk zzkVar;
            zzk zzkVar2 = zzk.f37872c;
            do {
                zzkVar = zzjnVar.f37854c;
                if (zzkVar2 == zzkVar) {
                    break;
                }
            } while (!f(zzjnVar, zzkVar, zzkVar2));
            return zzkVar;
        }

        @Override // com.google.android.gms.internal.pal.zzjn.zza
        public final void c(zzk zzkVar, zzk zzkVar2) {
            f37866a.putObject(zzkVar, f37871f, zzkVar2);
        }

        @Override // com.google.android.gms.internal.pal.zzjn.zza
        public final void d(zzk zzkVar, Thread thread) {
            f37866a.putObject(zzkVar, f37870e, thread);
        }

        @Override // com.google.android.gms.internal.pal.zzjn.zza
        public final boolean e(zzjn zzjnVar, Object obj, Object obj2) {
            return zzjp.a(f37866a, zzjnVar, f37869d, obj, obj2);
        }

        @Override // com.google.android.gms.internal.pal.zzjn.zza
        public final boolean f(zzjn zzjnVar, zzk zzkVar, zzk zzkVar2) {
            return zzjp.a(f37866a, zzjnVar, f37868c, zzkVar, zzkVar2);
        }
    }

    final class zzk {

        /* renamed from: c, reason: collision with root package name */
        public static final zzk f37872c = new zzk();

        /* renamed from: a, reason: collision with root package name */
        public volatile Thread f37873a;

        /* renamed from: b, reason: collision with root package name */
        public volatile zzk f37874b;

        public zzk() {
            zzjn.f37850f.d(this, Thread.currentThread());
        }
    }

    static {
        boolean z;
        zza zzgVar;
        Throwable th;
        Throwable th2;
        try {
            z = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        } catch (SecurityException unused) {
            z = false;
        }
        f37848d = z;
        f37849e = Logger.getLogger(zzjn.class.getName());
        Throwable th3 = null;
        try {
            zzgVar = new zzj();
            th2 = null;
            th = null;
        } catch (Error | RuntimeException e2) {
            try {
                th = e2;
                zzgVar = new zze(AtomicReferenceFieldUpdater.newUpdater(zzk.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(zzk.class, zzk.class, "b"), AtomicReferenceFieldUpdater.newUpdater(zzjn.class, zzk.class, "c"), AtomicReferenceFieldUpdater.newUpdater(zzjn.class, zzd.class, "b"), AtomicReferenceFieldUpdater.newUpdater(zzjn.class, Object.class, "a"));
            } catch (Error | RuntimeException e3) {
                th3 = e3;
                zzgVar = new zzg();
                th = e2;
            }
            th2 = th3;
        }
        f37850f = zzgVar;
        if (th2 != null) {
            Logger logger = f37849e;
            Level level = Level.SEVERE;
            logger.logp(level, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "UnsafeAtomicHelper is broken!", th);
            logger.logp(level, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "SafeAtomicHelper is broken!", th2);
        }
        f37851g = new Object();
    }

    public static Object a(zzjn zzjnVar) {
        V v;
        boolean z = false;
        while (true) {
            try {
                v = zzjnVar.get();
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
        return v;
    }

    public static void c(zzjn zzjnVar) {
        for (zzk zzkVarB = f37850f.b(zzjnVar); zzkVarB != null; zzkVarB = zzkVarB.f37874b) {
            Thread thread = zzkVarB.f37873a;
            if (thread != null) {
                zzkVarB.f37873a = null;
                LockSupport.unpark(thread);
            }
        }
        zzd zzdVarA = f37850f.a(zzjnVar);
        zzd zzdVar = null;
        while (zzdVarA != null) {
            zzd zzdVar2 = zzdVarA.f37860a;
            zzdVarA.f37860a = zzdVar;
            zzdVar = zzdVarA;
            zzdVarA = zzdVar2;
        }
        if (zzdVar != null) {
            throw null;
        }
    }

    public static final Object e(Object obj) throws ExecutionException {
        if (obj instanceof zzb) {
            RuntimeException runtimeException = ((zzb) obj).f37857a;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(runtimeException);
            throw cancellationException;
        }
        if (obj instanceof zzc) {
            throw new ExecutionException(((zzc) obj).f37858a);
        }
        if (obj == f37851g) {
            return null;
        }
        return obj;
    }

    public final void b(StringBuilder sb) {
        try {
            Object objA = a(this);
            sb.append("SUCCESS, result=[");
            if (objA == null) {
                sb.append("null");
            } else if (objA == this) {
                sb.append("this future");
            } else {
                sb.append(objA.getClass().getName());
                sb.append("@");
                sb.append(Integer.toHexString(System.identityHashCode(objA)));
            }
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e2) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e2.getClass());
            sb.append(" thrown from get()]");
        } catch (ExecutionException e3) {
            sb.append("FAILURE, cause=[");
            sb.append(e3.getCause());
            sb.append("]");
        }
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        zzb zzbVar;
        Object obj = this.f37852a;
        if ((obj == null) | (obj instanceof zzf)) {
            if (f37848d) {
                zzbVar = new zzb(z, new CancellationException("Future.cancel() was called."));
            } else {
                zzbVar = z ? zzb.f37855b : zzb.f37856c;
                zzbVar.getClass();
            }
            while (!f37850f.e(this, obj, zzbVar)) {
                obj = this.f37852a;
                if (!(obj instanceof zzf)) {
                }
            }
            c(this);
            if (!(obj instanceof zzf)) {
                return true;
            }
            ((zzf) obj).getClass();
            throw null;
        }
        return false;
    }

    public final void d(zzk zzkVar) {
        zzkVar.f37873a = null;
        while (true) {
            zzk zzkVar2 = this.f37854c;
            if (zzkVar2 != zzk.f37872c) {
                zzk zzkVar3 = null;
                while (zzkVar2 != null) {
                    zzk zzkVar4 = zzkVar2.f37874b;
                    if (zzkVar2.f37873a != null) {
                        zzkVar3 = zzkVar2;
                    } else if (zzkVar3 != null) {
                        zzkVar3.f37874b = zzkVar4;
                        if (zzkVar3.f37873a == null) {
                            break;
                        }
                    } else if (!f37850f.f(this, zzkVar2, zzkVar4)) {
                        break;
                    }
                    zzkVar2 = zzkVar4;
                }
                return;
            }
            return;
        }
    }

    @Override // java.util.concurrent.Future
    public final Object get() throws InterruptedException {
        Object obj;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj2 = this.f37852a;
        if ((obj2 != null) && (!(obj2 instanceof zzf))) {
            return e(obj2);
        }
        zzk zzkVar = this.f37854c;
        zzk zzkVar2 = zzk.f37872c;
        if (zzkVar != zzkVar2) {
            zzk zzkVar3 = new zzk();
            do {
                zza zzaVar = f37850f;
                zzaVar.c(zzkVar3, zzkVar);
                if (zzaVar.f(this, zzkVar, zzkVar3)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            d(zzkVar3);
                            throw new InterruptedException();
                        }
                        obj = this.f37852a;
                    } while (!((obj != null) & (!(obj instanceof zzf))));
                    return e(obj);
                }
                zzkVar = this.f37854c;
            } while (zzkVar != zzkVar2);
        }
        Object obj3 = this.f37852a;
        obj3.getClass();
        return e(obj3);
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f37852a instanceof zzb;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return (!(r0 instanceof zzf)) & (this.f37852a != null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String toString() {
        /*
            r10 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.Class r1 = r10.getClass()
            java.lang.String r1 = r1.getName()
            java.lang.String r2 = "com.google.common.util.concurrent."
            boolean r1 = r1.startsWith(r2)
            if (r1 == 0) goto L21
            java.lang.Class r1 = r10.getClass()
            java.lang.String r1 = r1.getSimpleName()
            r0.append(r1)
            goto L2c
        L21:
            java.lang.Class r1 = r10.getClass()
            java.lang.String r1 = r1.getName()
            r0.append(r1)
        L2c:
            r1 = 64
            r0.append(r1)
            int r1 = java.lang.System.identityHashCode(r10)
            java.lang.String r1 = java.lang.Integer.toHexString(r1)
            r0.append(r1)
            java.lang.String r1 = "[status="
            r0.append(r1)
            java.lang.Object r1 = r10.f37852a
            boolean r1 = r1 instanceof com.google.android.gms.internal.pal.zzjn.zzb
            java.lang.String r2 = "]"
            if (r1 == 0) goto L50
            java.lang.String r1 = "CANCELLED"
            r0.append(r1)
            goto Le5
        L50:
            boolean r1 = r10.isDone()
            if (r1 == 0) goto L5b
            r10.b(r0)
            goto Le5
        L5b:
            java.lang.String r1 = "remaining delay=["
            int r3 = r0.length()
            java.lang.String r4 = "PENDING"
            r0.append(r4)
            java.lang.Object r4 = r10.f37852a
            boolean r5 = r4 instanceof com.google.android.gms.internal.pal.zzjn.zzf
            java.lang.String r6 = "Exception thrown from implementation: "
            r7 = 0
            if (r5 == 0) goto L8e
            java.lang.String r1 = ", setFuture=["
            r0.append(r1)
            com.google.android.gms.internal.pal.zzjn$zzf r4 = (com.google.android.gms.internal.pal.zzjn.zzf) r4
            r4.getClass()
            r0.append(r7)     // Catch: java.lang.StackOverflowError -> L7d java.lang.RuntimeException -> L7f
            goto L8a
        L7d:
            r1 = move-exception
            goto L80
        L7f:
            r1 = move-exception
        L80:
            r0.append(r6)
            java.lang.Class r1 = r1.getClass()
            r0.append(r1)
        L8a:
            r0.append(r2)
            goto Ld5
        L8e:
            boolean r4 = r10 instanceof java.util.concurrent.ScheduledFuture     // Catch: java.lang.StackOverflowError -> Lad java.lang.RuntimeException -> Laf
            if (r4 == 0) goto Lb1
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.StackOverflowError -> Lad java.lang.RuntimeException -> Laf
            r4.<init>(r1)     // Catch: java.lang.StackOverflowError -> Lad java.lang.RuntimeException -> Laf
            r1 = r10
            java.util.concurrent.ScheduledFuture r1 = (java.util.concurrent.ScheduledFuture) r1     // Catch: java.lang.StackOverflowError -> Lad java.lang.RuntimeException -> Laf
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.StackOverflowError -> Lad java.lang.RuntimeException -> Laf
            long r8 = r1.getDelay(r5)     // Catch: java.lang.StackOverflowError -> Lad java.lang.RuntimeException -> Laf
            r4.append(r8)     // Catch: java.lang.StackOverflowError -> Lad java.lang.RuntimeException -> Laf
            java.lang.String r1 = " ms]"
            r4.append(r1)     // Catch: java.lang.StackOverflowError -> Lad java.lang.RuntimeException -> Laf
            java.lang.String r1 = r4.toString()     // Catch: java.lang.StackOverflowError -> Lad java.lang.RuntimeException -> Laf
            goto Lb2
        Lad:
            r1 = move-exception
            goto Lbf
        Laf:
            r1 = move-exception
            goto Lbf
        Lb1:
            r1 = r7
        Lb2:
            int r4 = com.google.android.gms.internal.pal.zzio.f37812a     // Catch: java.lang.StackOverflowError -> Lad java.lang.RuntimeException -> Laf
            if (r1 == 0) goto Lce
            boolean r4 = r1.isEmpty()     // Catch: java.lang.StackOverflowError -> Lad java.lang.RuntimeException -> Laf
            if (r4 == 0) goto Lbd
            goto Lce
        Lbd:
            r7 = r1
            goto Lce
        Lbf:
            java.lang.Class r1 = r1.getClass()
            r1.toString()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r7 = r6.concat(r1)
        Lce:
            if (r7 == 0) goto Ld5
            java.lang.String r1 = ", info=["
            android.support.v4.media.a.u(r0, r1, r7, r2)
        Ld5:
            boolean r1 = r10.isDone()
            if (r1 == 0) goto Le5
            int r1 = r0.length()
            r0.delete(r3, r1)
            r10.b(r0)
        Le5:
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.pal.zzjn.toString():java.lang.String");
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j2, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        boolean z;
        long j3;
        long nanos = timeUnit.toNanos(j2);
        if (!Thread.interrupted()) {
            Object obj = this.f37852a;
            if ((obj != null) & (!(obj instanceof zzf))) {
                return e(obj);
            }
            long j4 = 0;
            long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
            if (nanos >= 1000) {
                zzk zzkVar = this.f37854c;
                zzk zzkVar2 = zzk.f37872c;
                if (zzkVar != zzkVar2) {
                    zzk zzkVar3 = new zzk();
                    z = true;
                    while (true) {
                        zza zzaVar = f37850f;
                        zzaVar.c(zzkVar3, zzkVar);
                        if (zzaVar.f(this, zzkVar, zzkVar3)) {
                            j3 = j4;
                            do {
                                LockSupport.parkNanos(this, Math.min(nanos, 2147483647999999999L));
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.f37852a;
                                    if ((obj2 != null) & (!(obj2 instanceof zzf))) {
                                        return e(obj2);
                                    }
                                    nanos = jNanoTime - System.nanoTime();
                                } else {
                                    d(zzkVar3);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= 1000);
                            d(zzkVar3);
                        } else {
                            long j5 = j4;
                            zzkVar = this.f37854c;
                            if (zzkVar == zzkVar2) {
                                break;
                            }
                            j4 = j5;
                        }
                    }
                }
                Object obj3 = this.f37852a;
                obj3.getClass();
                return e(obj3);
            }
            z = true;
            j3 = 0;
            while (nanos > j3) {
                Object obj4 = this.f37852a;
                if ((obj4 != null ? z : false) & (!(obj4 instanceof zzf))) {
                    return e(obj4);
                }
                if (!Thread.interrupted()) {
                    nanos = jNanoTime - System.nanoTime();
                } else {
                    throw new InterruptedException();
                }
            }
            String string = toString();
            String string2 = timeUnit.toString();
            Locale locale = Locale.ROOT;
            String lowerCase = string2.toLowerCase(locale);
            StringBuilder sbV = android.support.v4.media.b.v(j2, "Waited ", StringUtils.SPACE);
            sbV.append(timeUnit.toString().toLowerCase(locale));
            String string3 = sbV.toString();
            if (nanos + 1000 < j3) {
                String strConcat = string3.concat(" (plus ");
                long j6 = -nanos;
                long jConvert = timeUnit.convert(j6, TimeUnit.NANOSECONDS);
                long nanos2 = j6 - timeUnit.toNanos(jConvert);
                if (jConvert != j3 && nanos2 <= 1000) {
                    z = false;
                }
                if (jConvert > j3) {
                    String strConcat2 = strConcat + jConvert + StringUtils.SPACE + lowerCase;
                    if (z) {
                        strConcat2 = strConcat2.concat(",");
                    }
                    strConcat = strConcat2.concat(StringUtils.SPACE);
                }
                if (z) {
                    strConcat = strConcat + nanos2 + " nanoseconds ";
                }
                string3 = strConcat.concat("delay)");
            }
            if (isDone()) {
                throw new TimeoutException(string3.concat(" but future completed as timeout expired"));
            }
            throw new TimeoutException(android.support.v4.media.b.l(string3, " for ", string));
        }
        throw new InterruptedException();
    }
}
