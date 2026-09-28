package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgxf;
import com.google.common.util.concurrent.ListenableFuture;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* loaded from: classes4.dex */
abstract class zzgxg<V> extends zzgzo implements ListenableFuture<V> {

    /* renamed from: d, reason: collision with root package name */
    public static final Object f33320d = new Object();

    /* renamed from: e, reason: collision with root package name */
    public static final zzgyu f33321e = new zzgyu(zzgxf.class);

    /* renamed from: f, reason: collision with root package name */
    public static final boolean f33322f;

    /* renamed from: g, reason: collision with root package name */
    public static final zza f33323g;

    /* renamed from: a, reason: collision with root package name */
    public volatile Object f33324a;

    /* renamed from: b, reason: collision with root package name */
    public volatile zzgxf.zzd f33325b;

    /* renamed from: c, reason: collision with root package name */
    public volatile zze f33326c;

    abstract class zza {
        public abstract void a(zze zzeVar, Thread thread);

        public abstract void b(zze zzeVar, zze zzeVar2);

        public abstract boolean c(zzgxg zzgxgVar, zze zzeVar, zze zzeVar2);

        public abstract boolean d(zzgxf zzgxfVar, zzgxf.zzd zzdVar, zzgxf.zzd zzdVar2);

        public abstract zze e(zzgxf zzgxfVar);

        public abstract zzgxf.zzd f(zzgxf zzgxfVar);

        public abstract boolean g(zzgxg zzgxgVar, Object obj, Object obj2);
    }

    final class zzb extends zza {

        /* renamed from: a, reason: collision with root package name */
        public static final AtomicReferenceFieldUpdater f33327a = AtomicReferenceFieldUpdater.newUpdater(zze.class, Thread.class, "a");

        /* renamed from: b, reason: collision with root package name */
        public static final AtomicReferenceFieldUpdater f33328b = AtomicReferenceFieldUpdater.newUpdater(zze.class, zze.class, "b");

        /* renamed from: c, reason: collision with root package name */
        public static final AtomicReferenceFieldUpdater f33329c = AtomicReferenceFieldUpdater.newUpdater(zzgxg.class, zze.class, "c");

        /* renamed from: d, reason: collision with root package name */
        public static final AtomicReferenceFieldUpdater f33330d = AtomicReferenceFieldUpdater.newUpdater(zzgxg.class, zzgxf.zzd.class, "b");

        /* renamed from: e, reason: collision with root package name */
        public static final AtomicReferenceFieldUpdater f33331e = AtomicReferenceFieldUpdater.newUpdater(zzgxg.class, Object.class, "a");

        @Override // com.google.android.gms.internal.ads.zzgxg.zza
        public final void a(zze zzeVar, Thread thread) {
            f33327a.lazySet(zzeVar, thread);
        }

        @Override // com.google.android.gms.internal.ads.zzgxg.zza
        public final void b(zze zzeVar, zze zzeVar2) {
            f33328b.lazySet(zzeVar, zzeVar2);
        }

        @Override // com.google.android.gms.internal.ads.zzgxg.zza
        public final boolean c(zzgxg zzgxgVar, zze zzeVar, zze zzeVar2) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
            do {
                atomicReferenceFieldUpdater = f33329c;
                if (atomicReferenceFieldUpdater.compareAndSet(zzgxgVar, zzeVar, zzeVar2)) {
                    return true;
                }
            } while (atomicReferenceFieldUpdater.get(zzgxgVar) == zzeVar);
            return false;
        }

        @Override // com.google.android.gms.internal.ads.zzgxg.zza
        public final boolean d(zzgxf zzgxfVar, zzgxf.zzd zzdVar, zzgxf.zzd zzdVar2) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
            do {
                atomicReferenceFieldUpdater = f33330d;
                if (atomicReferenceFieldUpdater.compareAndSet(zzgxfVar, zzdVar, zzdVar2)) {
                    return true;
                }
            } while (atomicReferenceFieldUpdater.get(zzgxfVar) == zzdVar);
            return false;
        }

        @Override // com.google.android.gms.internal.ads.zzgxg.zza
        public final zze e(zzgxf zzgxfVar) {
            return (zze) f33329c.getAndSet(zzgxfVar, zze.f33338c);
        }

        @Override // com.google.android.gms.internal.ads.zzgxg.zza
        public final zzgxf.zzd f(zzgxf zzgxfVar) {
            return (zzgxf.zzd) f33330d.getAndSet(zzgxfVar, zzgxf.zzd.f33316d);
        }

        @Override // com.google.android.gms.internal.ads.zzgxg.zza
        public final boolean g(zzgxg zzgxgVar, Object obj, Object obj2) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
            do {
                atomicReferenceFieldUpdater = f33331e;
                if (atomicReferenceFieldUpdater.compareAndSet(zzgxgVar, obj, obj2)) {
                    return true;
                }
            } while (atomicReferenceFieldUpdater.get(zzgxgVar) == obj);
            return false;
        }
    }

    final class zzc extends zza {
        @Override // com.google.android.gms.internal.ads.zzgxg.zza
        public final void a(zze zzeVar, Thread thread) {
            zzeVar.f33339a = thread;
        }

        @Override // com.google.android.gms.internal.ads.zzgxg.zza
        public final void b(zze zzeVar, zze zzeVar2) {
            zzeVar.f33340b = zzeVar2;
        }

        @Override // com.google.android.gms.internal.ads.zzgxg.zza
        public final boolean c(zzgxg zzgxgVar, zze zzeVar, zze zzeVar2) {
            synchronized (zzgxgVar) {
                try {
                    if (zzgxgVar.f33326c != zzeVar) {
                        return false;
                    }
                    zzgxgVar.f33326c = zzeVar2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // com.google.android.gms.internal.ads.zzgxg.zza
        public final boolean d(zzgxf zzgxfVar, zzgxf.zzd zzdVar, zzgxf.zzd zzdVar2) {
            synchronized (zzgxfVar) {
                try {
                    if (zzgxfVar.f33325b != zzdVar) {
                        return false;
                    }
                    zzgxfVar.f33325b = zzdVar2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // com.google.android.gms.internal.ads.zzgxg.zza
        public final zze e(zzgxf zzgxfVar) {
            zze zzeVar;
            zze zzeVar2 = zze.f33338c;
            synchronized (zzgxfVar) {
                try {
                    zzeVar = zzgxfVar.f33326c;
                    if (zzeVar != zzeVar2) {
                        zzgxfVar.f33326c = zzeVar2;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return zzeVar;
        }

        @Override // com.google.android.gms.internal.ads.zzgxg.zza
        public final zzgxf.zzd f(zzgxf zzgxfVar) {
            zzgxf.zzd zzdVar;
            zzgxf.zzd zzdVar2 = zzgxf.zzd.f33316d;
            synchronized (zzgxfVar) {
                try {
                    zzdVar = zzgxfVar.f33325b;
                    if (zzdVar != zzdVar2) {
                        zzgxfVar.f33325b = zzdVar2;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return zzdVar;
        }

        @Override // com.google.android.gms.internal.ads.zzgxg.zza
        public final boolean g(zzgxg zzgxgVar, Object obj, Object obj2) {
            synchronized (zzgxgVar) {
                try {
                    if (zzgxgVar.f33324a != obj) {
                        return false;
                    }
                    zzgxgVar.f33324a = obj2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    final class zzd extends zza {

        /* renamed from: a, reason: collision with root package name */
        public static final Unsafe f33332a;

        /* renamed from: b, reason: collision with root package name */
        public static final long f33333b;

        /* renamed from: c, reason: collision with root package name */
        public static final long f33334c;

        /* renamed from: d, reason: collision with root package name */
        public static final long f33335d;

        /* renamed from: e, reason: collision with root package name */
        public static final long f33336e;

        /* renamed from: f, reason: collision with root package name */
        public static final long f33337f;

        static {
            Unsafe unsafe;
            try {
                try {
                    unsafe = Unsafe.getUnsafe();
                } catch (SecurityException unused) {
                    unsafe = (Unsafe) AccessController.doPrivileged(zzgxh.f33341a);
                }
                try {
                    f33334c = unsafe.objectFieldOffset(zzgxg.class.getDeclaredField("c"));
                    f33333b = unsafe.objectFieldOffset(zzgxg.class.getDeclaredField("b"));
                    f33335d = unsafe.objectFieldOffset(zzgxg.class.getDeclaredField("a"));
                    f33336e = unsafe.objectFieldOffset(zze.class.getDeclaredField("a"));
                    f33337f = unsafe.objectFieldOffset(zze.class.getDeclaredField("b"));
                    f33332a = unsafe;
                } catch (NoSuchFieldException e2) {
                    throw new RuntimeException(e2);
                }
            } catch (PrivilegedActionException e3) {
                throw new RuntimeException("Could not initialize intrinsics", e3.getCause());
            }
        }

        @Override // com.google.android.gms.internal.ads.zzgxg.zza
        public final void a(zze zzeVar, Thread thread) {
            f33332a.putObject(zzeVar, f33336e, thread);
        }

        @Override // com.google.android.gms.internal.ads.zzgxg.zza
        public final void b(zze zzeVar, zze zzeVar2) {
            f33332a.putObject(zzeVar, f33337f, zzeVar2);
        }

        @Override // com.google.android.gms.internal.ads.zzgxg.zza
        public final boolean c(zzgxg zzgxgVar, zze zzeVar, zze zzeVar2) {
            return com.google.ads.interactivemedia.v3.internal.a.a(f33332a, zzgxgVar, f33334c, zzeVar, zzeVar2);
        }

        @Override // com.google.android.gms.internal.ads.zzgxg.zza
        public final boolean d(zzgxf zzgxfVar, zzgxf.zzd zzdVar, zzgxf.zzd zzdVar2) {
            return com.google.ads.interactivemedia.v3.internal.a.a(f33332a, zzgxfVar, f33333b, zzdVar, zzdVar2);
        }

        @Override // com.google.android.gms.internal.ads.zzgxg.zza
        public final zze e(zzgxf zzgxfVar) {
            zze zzeVar;
            zze zzeVar2 = zze.f33338c;
            do {
                zzeVar = zzgxfVar.f33326c;
                if (zzeVar2 == zzeVar) {
                    break;
                }
            } while (!c(zzgxfVar, zzeVar, zzeVar2));
            return zzeVar;
        }

        @Override // com.google.android.gms.internal.ads.zzgxg.zza
        public final zzgxf.zzd f(zzgxf zzgxfVar) {
            zzgxf.zzd zzdVar;
            zzgxf.zzd zzdVar2 = zzgxf.zzd.f33316d;
            do {
                zzdVar = zzgxfVar.f33325b;
                if (zzdVar2 == zzdVar) {
                    break;
                }
            } while (!d(zzgxfVar, zzdVar, zzdVar2));
            return zzdVar;
        }

        @Override // com.google.android.gms.internal.ads.zzgxg.zza
        public final boolean g(zzgxg zzgxgVar, Object obj, Object obj2) {
            return com.google.ads.interactivemedia.v3.internal.a.a(f33332a, zzgxgVar, f33335d, obj, obj2);
        }
    }

    final class zze {

        /* renamed from: c, reason: collision with root package name */
        public static final zze f33338c = new zze();

        /* renamed from: a, reason: collision with root package name */
        public volatile Thread f33339a;

        /* renamed from: b, reason: collision with root package name */
        public volatile zze f33340b;

        public zze() {
            zzgxg.f33323g.a(this, Thread.currentThread());
        }
    }

    static {
        boolean z;
        zza zzcVar;
        Throwable th;
        Throwable th2;
        try {
            z = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        } catch (SecurityException unused) {
            z = false;
        }
        f33322f = z;
        String property = System.getProperty("java.runtime.name", "");
        Throwable th3 = null;
        if (property == null || property.contains("Android")) {
            try {
                zzcVar = new zzd();
            } catch (Error | Exception e2) {
                try {
                    zzcVar = new zzb();
                } catch (Error | Exception e3) {
                    th3 = e3;
                    zzcVar = new zzc();
                }
                th = th3;
                th2 = e2;
            }
        } else {
            try {
                zzcVar = new zzb();
            } catch (NoClassDefFoundError unused2) {
                zzcVar = new zzc();
            }
        }
        th = null;
        th2 = null;
        f33323g = zzcVar;
        if (th != null) {
            zzgyu zzgyuVar = f33321e;
            Logger loggerA = zzgyuVar.a();
            Level level = Level.SEVERE;
            loggerA.logp(level, "com.google.common.util.concurrent.AbstractFutureState", "<clinit>", "UnsafeAtomicHelper is broken!", th2);
            zzgyuVar.a().logp(level, "com.google.common.util.concurrent.AbstractFutureState", "<clinit>", "AtomicReferenceFieldUpdaterAtomicHelper is broken!", th);
        }
    }

    public final void b(zze zzeVar) {
        zzeVar.f33339a = null;
        while (true) {
            zze zzeVar2 = this.f33326c;
            if (zzeVar2 != zze.f33338c) {
                zze zzeVar3 = null;
                while (zzeVar2 != null) {
                    zze zzeVar4 = zzeVar2.f33340b;
                    if (zzeVar2.f33339a != null) {
                        zzeVar3 = zzeVar2;
                    } else if (zzeVar3 != null) {
                        zzeVar3.f33340b = zzeVar4;
                        if (zzeVar3.f33339a == null) {
                            break;
                        }
                    } else if (!f33323g.c(this, zzeVar2, zzeVar4)) {
                        break;
                    }
                    zzeVar2 = zzeVar4;
                }
                return;
            }
            return;
        }
    }
}
