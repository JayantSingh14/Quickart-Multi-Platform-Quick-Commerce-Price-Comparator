package com.google.ads.interactivemedia.v3.internal;

import android.support.v4.media.b;
import androidx.fragment.app.e;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;
import org.apache.commons.lang3.StringUtils;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import sun.misc.Unsafe;

/* loaded from: classes3.dex */
public abstract class zzrq<V> extends zztm implements zzta<V> {
    private static final zza zza;
    static final boolean zzb;
    private static final Object zzba;
    static final zzsz zzc;

    @CheckForNull
    private volatile zzd listeners;

    @CheckForNull
    private volatile Object value;

    @CheckForNull
    private volatile zzk waiters;

    abstract class zza {
        public /* synthetic */ zza(zzrp zzrpVar) {
        }

        public abstract zzd zza(zzrq zzrqVar, zzd zzdVar);

        public abstract zzk zzb(zzrq zzrqVar, zzk zzkVar);

        public abstract void zzc(zzk zzkVar, @CheckForNull zzk zzkVar2);

        public abstract void zzd(zzk zzkVar, Thread thread);

        public abstract boolean zze(zzrq zzrqVar, @CheckForNull zzd zzdVar, zzd zzdVar2);

        public abstract boolean zzf(zzrq zzrqVar, @CheckForNull Object obj, Object obj2);

        public abstract boolean zzg(zzrq zzrqVar, @CheckForNull zzk zzkVar, @CheckForNull zzk zzkVar2);
    }

    final class zzb {

        @CheckForNull
        static final zzb zza;

        @CheckForNull
        static final zzb zzb;
        final boolean zzc;

        @CheckForNull
        final Throwable zzd;

        static {
            if (zzrq.zzb) {
                zzb = null;
                zza = null;
            } else {
                zzb = new zzb(false, null);
                zza = new zzb(true, null);
            }
        }

        public zzb(boolean z, @CheckForNull Throwable th) {
            this.zzc = z;
            this.zzd = th;
        }
    }

    final class zzc {
        static final zzc zza = new zzc(new Throwable("Failure occurred while trying to finish a future.") { // from class: com.google.ads.interactivemedia.v3.internal.zzrq.zzc.1
            {
                super("Failure occurred while trying to finish a future.");
            }

            @Override // java.lang.Throwable
            public final synchronized Throwable fillInStackTrace() {
                return this;
            }
        });
        final Throwable zzb;

        public zzc(Throwable th) {
            th.getClass();
            this.zzb = th;
        }
    }

    final class zzd {
        static final zzd zza = new zzd();

        @CheckForNull
        zzd next;

        @CheckForNull
        final Runnable zzb;

        @CheckForNull
        final Executor zzc;

        public zzd() {
            this.zzb = null;
            this.zzc = null;
        }

        public zzd(Runnable runnable, Executor executor) {
            this.zzb = runnable;
            this.zzc = executor;
        }
    }

    final class zze extends zza {
        final AtomicReferenceFieldUpdater<zzk, Thread> zza;
        final AtomicReferenceFieldUpdater<zzk, zzk> zzb;
        final AtomicReferenceFieldUpdater<zzrq, zzk> zzc;
        final AtomicReferenceFieldUpdater<zzrq, zzd> zzd;
        final AtomicReferenceFieldUpdater<zzrq, Object> zze;

        public zze(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
            super(null);
            this.zza = atomicReferenceFieldUpdater;
            this.zzb = atomicReferenceFieldUpdater2;
            this.zzc = atomicReferenceFieldUpdater3;
            this.zzd = atomicReferenceFieldUpdater4;
            this.zze = atomicReferenceFieldUpdater5;
        }

        @Override // com.google.ads.interactivemedia.v3.internal.zzrq.zza
        public final zzd zza(zzrq zzrqVar, zzd zzdVar) {
            return this.zzd.getAndSet(zzrqVar, zzdVar);
        }

        @Override // com.google.ads.interactivemedia.v3.internal.zzrq.zza
        public final zzk zzb(zzrq zzrqVar, zzk zzkVar) {
            return this.zzc.getAndSet(zzrqVar, zzkVar);
        }

        @Override // com.google.ads.interactivemedia.v3.internal.zzrq.zza
        public final void zzc(zzk zzkVar, @CheckForNull zzk zzkVar2) {
            this.zzb.lazySet(zzkVar, zzkVar2);
        }

        @Override // com.google.ads.interactivemedia.v3.internal.zzrq.zza
        public final void zzd(zzk zzkVar, Thread thread) {
            this.zza.lazySet(zzkVar, thread);
        }

        @Override // com.google.ads.interactivemedia.v3.internal.zzrq.zza
        public final boolean zze(zzrq zzrqVar, @CheckForNull zzd zzdVar, zzd zzdVar2) {
            return zzrr.zza(this.zzd, zzrqVar, zzdVar, zzdVar2);
        }

        @Override // com.google.ads.interactivemedia.v3.internal.zzrq.zza
        public final boolean zzf(zzrq zzrqVar, @CheckForNull Object obj, Object obj2) {
            return zzrr.zza(this.zze, zzrqVar, obj, obj2);
        }

        @Override // com.google.ads.interactivemedia.v3.internal.zzrq.zza
        public final boolean zzg(zzrq zzrqVar, @CheckForNull zzk zzkVar, @CheckForNull zzk zzkVar2) {
            return zzrr.zza(this.zzc, zzrqVar, zzkVar, zzkVar2);
        }
    }

    final class zzf<V> implements Runnable {
        final zzrq<V> zza;
        final zzta<? extends V> zzb;

        @Override // java.lang.Runnable
        public final void run() {
            throw null;
        }
    }

    final class zzg extends zza {
        private zzg() {
            super(null);
        }

        @Override // com.google.ads.interactivemedia.v3.internal.zzrq.zza
        public final zzd zza(zzrq zzrqVar, zzd zzdVar) {
            zzd zzdVar2;
            synchronized (zzrqVar) {
                try {
                    zzdVar2 = zzrqVar.listeners;
                    if (zzdVar2 != zzdVar) {
                        zzrqVar.listeners = zzdVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return zzdVar2;
        }

        @Override // com.google.ads.interactivemedia.v3.internal.zzrq.zza
        public final zzk zzb(zzrq zzrqVar, zzk zzkVar) {
            zzk zzkVar2;
            synchronized (zzrqVar) {
                try {
                    zzkVar2 = zzrqVar.waiters;
                    if (zzkVar2 != zzkVar) {
                        zzrqVar.waiters = zzkVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return zzkVar2;
        }

        @Override // com.google.ads.interactivemedia.v3.internal.zzrq.zza
        public final void zzc(zzk zzkVar, @CheckForNull zzk zzkVar2) {
            zzkVar.next = zzkVar2;
        }

        @Override // com.google.ads.interactivemedia.v3.internal.zzrq.zza
        public final void zzd(zzk zzkVar, Thread thread) {
            zzkVar.thread = thread;
        }

        @Override // com.google.ads.interactivemedia.v3.internal.zzrq.zza
        public final boolean zze(zzrq zzrqVar, @CheckForNull zzd zzdVar, zzd zzdVar2) {
            synchronized (zzrqVar) {
                try {
                    if (zzrqVar.listeners != zzdVar) {
                        return false;
                    }
                    zzrqVar.listeners = zzdVar2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // com.google.ads.interactivemedia.v3.internal.zzrq.zza
        public final boolean zzf(zzrq zzrqVar, @CheckForNull Object obj, Object obj2) {
            synchronized (zzrqVar) {
                try {
                    if (zzrqVar.value != obj) {
                        return false;
                    }
                    zzrqVar.value = obj2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // com.google.ads.interactivemedia.v3.internal.zzrq.zza
        public final boolean zzg(zzrq zzrqVar, @CheckForNull zzk zzkVar, @CheckForNull zzk zzkVar2) {
            synchronized (zzrqVar) {
                try {
                    if (zzrqVar.waiters != zzkVar) {
                        return false;
                    }
                    zzrqVar.waiters = zzkVar2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public /* synthetic */ zzg(zzrs zzrsVar) {
            super(null);
        }
    }

    interface zzh<V> extends zzta<V> {
    }

    abstract class zzi<V> extends zzrq<V> implements zzh<V> {
    }

    final class zzj extends zza {
        static final Unsafe zza;
        static final long zzb;
        static final long zzc;
        static final long zzd;
        static final long zze;
        static final long zzf;

        static {
            Unsafe unsafe;
            try {
                try {
                    unsafe = Unsafe.getUnsafe();
                } catch (PrivilegedActionException e2) {
                    throw new RuntimeException("Could not initialize intrinsics", e2.getCause());
                }
            } catch (SecurityException unused) {
                unsafe = (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() { // from class: com.google.ads.interactivemedia.v3.internal.zzrq.zzj.1
                    @Override // java.security.PrivilegedExceptionAction
                    public final /* bridge */ /* synthetic */ Unsafe run() throws Exception {
                        for (Field field : Unsafe.class.getDeclaredFields()) {
                            field.setAccessible(true);
                            Object obj = field.get(null);
                            if (Unsafe.class.isInstance(obj)) {
                                return (Unsafe) Unsafe.class.cast(obj);
                            }
                        }
                        throw new NoSuchFieldError("the Unsafe");
                    }
                });
            }
            try {
                zzc = unsafe.objectFieldOffset(zzrq.class.getDeclaredField("waiters"));
                zzb = unsafe.objectFieldOffset(zzrq.class.getDeclaredField("listeners"));
                zzd = unsafe.objectFieldOffset(zzrq.class.getDeclaredField(CLConstants.FIELD_PAY_INFO_VALUE));
                zze = unsafe.objectFieldOffset(zzk.class.getDeclaredField("thread"));
                zzf = unsafe.objectFieldOffset(zzk.class.getDeclaredField("next"));
                zza = unsafe;
            } catch (NoSuchFieldException e3) {
                throw new RuntimeException(e3);
            }
        }

        private zzj() {
            super(null);
        }

        @Override // com.google.ads.interactivemedia.v3.internal.zzrq.zza
        public final zzd zza(zzrq zzrqVar, zzd zzdVar) {
            zzd zzdVar2;
            do {
                zzdVar2 = zzrqVar.listeners;
                if (zzdVar == zzdVar2) {
                    break;
                }
            } while (!zze(zzrqVar, zzdVar2, zzdVar));
            return zzdVar2;
        }

        @Override // com.google.ads.interactivemedia.v3.internal.zzrq.zza
        public final zzk zzb(zzrq zzrqVar, zzk zzkVar) {
            zzk zzkVar2;
            do {
                zzkVar2 = zzrqVar.waiters;
                if (zzkVar == zzkVar2) {
                    break;
                }
            } while (!zzg(zzrqVar, zzkVar2, zzkVar));
            return zzkVar2;
        }

        @Override // com.google.ads.interactivemedia.v3.internal.zzrq.zza
        public final void zzc(zzk zzkVar, @CheckForNull zzk zzkVar2) {
            zza.putObject(zzkVar, zzf, zzkVar2);
        }

        @Override // com.google.ads.interactivemedia.v3.internal.zzrq.zza
        public final void zzd(zzk zzkVar, Thread thread) {
            zza.putObject(zzkVar, zze, thread);
        }

        @Override // com.google.ads.interactivemedia.v3.internal.zzrq.zza
        public final boolean zze(zzrq zzrqVar, @CheckForNull zzd zzdVar, zzd zzdVar2) {
            return zzrt.zza(zza, zzrqVar, zzb, zzdVar, zzdVar2);
        }

        @Override // com.google.ads.interactivemedia.v3.internal.zzrq.zza
        public final boolean zzf(zzrq zzrqVar, @CheckForNull Object obj, Object obj2) {
            return zzrt.zza(zza, zzrqVar, zzd, obj, obj2);
        }

        @Override // com.google.ads.interactivemedia.v3.internal.zzrq.zza
        public final boolean zzg(zzrq zzrqVar, @CheckForNull zzk zzkVar, @CheckForNull zzk zzkVar2) {
            return zzrt.zza(zza, zzrqVar, zzc, zzkVar, zzkVar2);
        }

        public /* synthetic */ zzj(zzru zzruVar) {
            super(null);
        }
    }

    final class zzk {
        static final zzk zza = new zzk(false);

        @CheckForNull
        volatile zzk next;

        @CheckForNull
        volatile Thread thread;

        public zzk(boolean z) {
        }

        public zzk() {
            zzrq.zza.zzd(this, Thread.currentThread());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        boolean z;
        Throwable th;
        zza zzgVar;
        Throwable th2;
        try {
            z = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        } catch (SecurityException unused) {
            z = false;
        }
        zzb = z;
        zzc = new zzsz(zzrq.class);
        Object[] objArr = 0;
        try {
            zzgVar = new zzj(null);
            th = null;
            th2 = null;
        } catch (Error | Exception e2) {
            try {
                th = null;
                th2 = e2;
                zzgVar = new zze(AtomicReferenceFieldUpdater.newUpdater(zzk.class, Thread.class, "thread"), AtomicReferenceFieldUpdater.newUpdater(zzk.class, zzk.class, "next"), AtomicReferenceFieldUpdater.newUpdater(zzrq.class, zzk.class, "waiters"), AtomicReferenceFieldUpdater.newUpdater(zzrq.class, zzd.class, "listeners"), AtomicReferenceFieldUpdater.newUpdater(zzrq.class, Object.class, CLConstants.FIELD_PAY_INFO_VALUE));
            } catch (Error | Exception e3) {
                th = e3;
                zzgVar = new zzg(objArr == true ? 1 : 0);
                th2 = e2;
            }
        }
        zza = zzgVar;
        if (th != null) {
            zzsz zzszVar = zzc;
            Logger loggerZza = zzszVar.zza();
            Level level = Level.SEVERE;
            loggerZza.logp(level, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "UnsafeAtomicHelper is broken!", th2);
            zzszVar.zza().logp(level, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "SafeAtomicHelper is broken!", th);
        }
        zzba = new Object();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static Object zzp(zzta zztaVar) {
        Throwable thZzi;
        if (zztaVar instanceof zzh) {
            Object zzbVar = ((zzrq) zztaVar).value;
            if (zzbVar instanceof zzb) {
                zzb zzbVar2 = (zzb) zzbVar;
                if (zzbVar2.zzc) {
                    Throwable th = zzbVar2.zzd;
                    zzbVar = th != null ? new zzb(false, th) : zzb.zzb;
                }
            }
            Objects.requireNonNull(zzbVar);
            return zzbVar;
        }
        if ((zztaVar instanceof zztm) && (thZzi = ((zztm) zztaVar).zzi()) != null) {
            return new zzc(thZzi);
        }
        boolean zIsCancelled = zztaVar.isCancelled();
        if ((!zzb) && zIsCancelled) {
            zzb zzbVar3 = zzb.zzb;
            Objects.requireNonNull(zzbVar3);
            return zzbVar3;
        }
        try {
            Object objZzq = zzq(zztaVar);
            return zIsCancelled ? new zzb(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: ".concat(String.valueOf(zztaVar)))) : objZzq == null ? zzba : objZzq;
        } catch (Error | Exception e2) {
            return new zzc(e2);
        } catch (CancellationException e3) {
            return !zIsCancelled ? new zzc(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: ".concat(String.valueOf(zztaVar)), e3)) : new zzb(false, e3);
        } catch (ExecutionException e4) {
            return zIsCancelled ? new zzb(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: ".concat(String.valueOf(zztaVar)), e4)) : new zzc(e4.getCause());
        }
    }

    private static Object zzq(Future future) throws ExecutionException {
        Object obj;
        boolean z = false;
        while (true) {
            try {
                obj = future.get();
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
        return obj;
    }

    private final void zzr(StringBuilder sb) {
        try {
            Object objZzq = zzq(this);
            sb.append("SUCCESS, result=[");
            if (objZzq == null) {
                sb.append("null");
            } else if (objZzq == this) {
                sb.append("this future");
            } else {
                sb.append(objZzq.getClass().getName());
                sb.append("@");
                sb.append(Integer.toHexString(System.identityHashCode(objZzq)));
            }
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (ExecutionException e2) {
            sb.append("FAILURE, cause=[");
            sb.append(e2.getCause());
            sb.append("]");
        } catch (Exception e3) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e3.getClass());
            sb.append(" thrown from get()]");
        }
    }

    private final void zzs(StringBuilder sb) {
        String strConcat;
        int length = sb.length();
        sb.append("PENDING");
        Object obj = this.value;
        if (obj instanceof zzf) {
            sb.append(", setFuture=[");
            zzt(sb, ((zzf) obj).zzb);
            sb.append("]");
        } else {
            try {
                strConcat = zzpg.zza(zza());
            } catch (Exception | StackOverflowError e2) {
                strConcat = "Exception thrown from implementation: ".concat(String.valueOf(e2.getClass()));
            }
            if (strConcat != null) {
                android.support.v4.media.a.u(sb, ", info=[", strConcat, "]");
            }
        }
        if (isDone()) {
            sb.delete(length, sb.length());
            zzr(sb);
        }
    }

    private final void zzt(StringBuilder sb, @CheckForNull Object obj) {
        try {
            if (obj == this) {
                sb.append("this future");
            } else {
                sb.append(obj);
            }
        } catch (Exception e2) {
            e = e2;
            sb.append("Exception thrown from implementation: ");
            sb.append(e.getClass());
        } catch (StackOverflowError e3) {
            e = e3;
            sb.append("Exception thrown from implementation: ");
            sb.append(e.getClass());
        }
    }

    private static void zzu(zzrq zzrqVar, boolean z) {
        zzd zzdVar = null;
        while (true) {
            for (zzk zzkVarZzb = zza.zzb(zzrqVar, zzk.zza); zzkVarZzb != null; zzkVarZzb = zzkVarZzb.next) {
                Thread thread = zzkVarZzb.thread;
                if (thread != null) {
                    zzkVarZzb.thread = null;
                    LockSupport.unpark(thread);
                }
            }
            if (z) {
                zzrqVar.zzn();
            }
            zzrqVar.zzb();
            zzd zzdVar2 = zzdVar;
            zzd zzdVarZza = zza.zza(zzrqVar, zzd.zza);
            zzd zzdVar3 = zzdVar2;
            while (zzdVarZza != null) {
                zzd zzdVar4 = zzdVarZza.next;
                zzdVarZza.next = zzdVar3;
                zzdVar3 = zzdVarZza;
                zzdVarZza = zzdVar4;
            }
            while (zzdVar3 != null) {
                zzdVar = zzdVar3.next;
                Runnable runnable = zzdVar3.zzb;
                Objects.requireNonNull(runnable);
                Runnable runnable2 = runnable;
                if (runnable2 instanceof zzf) {
                    zzf zzfVar = (zzf) runnable2;
                    zzrqVar = zzfVar.zza;
                    if (zzrqVar.value == zzfVar) {
                        if (zza.zzf(zzrqVar, zzfVar, zzp(zzfVar.zzb))) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    Executor executor = zzdVar3.zzc;
                    Objects.requireNonNull(executor);
                    zzv(runnable2, executor);
                }
                zzdVar3 = zzdVar;
            }
            return;
            z = false;
        }
    }

    private static void zzv(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (Exception e2) {
            zzc.zza().logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFuture", "executeListener", e.p("RuntimeException while executing runnable ", String.valueOf(runnable), " with executor ", String.valueOf(executor)), (Throwable) e2);
        }
    }

    private final void zzw(zzk zzkVar) {
        zzkVar.thread = null;
        while (true) {
            zzk zzkVar2 = this.waiters;
            if (zzkVar2 != zzk.zza) {
                zzk zzkVar3 = null;
                while (zzkVar2 != null) {
                    zzk zzkVar4 = zzkVar2.next;
                    if (zzkVar2.thread != null) {
                        zzkVar3 = zzkVar2;
                    } else if (zzkVar3 != null) {
                        zzkVar3.next = zzkVar4;
                        if (zzkVar3.thread == null) {
                            break;
                        }
                    } else if (!zza.zzg(this, zzkVar2, zzkVar4)) {
                        break;
                    }
                    zzkVar2 = zzkVar4;
                }
                return;
            }
            return;
        }
    }

    private static final Object zzx(Object obj) throws ExecutionException {
        if (obj instanceof zzb) {
            Throwable th = ((zzb) obj).zzd;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        }
        if (obj instanceof zzc) {
            throw new ExecutionException(((zzc) obj).zzb);
        }
        if (obj == zzba) {
            return null;
        }
        return obj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0057, code lost:
    
        return true;
     */
    @Override // java.util.concurrent.Future
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean cancel(boolean r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.value
            boolean r1 = r0 instanceof com.google.ads.interactivemedia.v3.internal.zzrq.zzf
            r2 = 0
            r3 = 1
            if (r0 != 0) goto La
            r4 = r3
            goto Lb
        La:
            r4 = r2
        Lb:
            r1 = r1 | r4
            if (r1 == 0) goto L5f
            boolean r1 = com.google.ads.interactivemedia.v3.internal.zzrq.zzb
            if (r1 == 0) goto L1f
            com.google.ads.interactivemedia.v3.internal.zzrq$zzb r1 = new com.google.ads.interactivemedia.v3.internal.zzrq$zzb
            java.util.concurrent.CancellationException r4 = new java.util.concurrent.CancellationException
            java.lang.String r5 = "Future.cancel() was called."
            r4.<init>(r5)
            r1.<init>(r8, r4)
            goto L29
        L1f:
            if (r8 == 0) goto L24
            com.google.ads.interactivemedia.v3.internal.zzrq$zzb r1 = com.google.ads.interactivemedia.v3.internal.zzrq.zzb.zza
            goto L26
        L24:
            com.google.ads.interactivemedia.v3.internal.zzrq$zzb r1 = com.google.ads.interactivemedia.v3.internal.zzrq.zzb.zzb
        L26:
            java.util.Objects.requireNonNull(r1)
        L29:
            r4 = r7
            r5 = r2
        L2b:
            com.google.ads.interactivemedia.v3.internal.zzrq$zza r6 = com.google.ads.interactivemedia.v3.internal.zzrq.zza
            boolean r6 = r6.zzf(r4, r0, r1)
            if (r6 == 0) goto L58
            zzu(r4, r8)
            boolean r4 = r0 instanceof com.google.ads.interactivemedia.v3.internal.zzrq.zzf
            if (r4 == 0) goto L57
            com.google.ads.interactivemedia.v3.internal.zzrq$zzf r0 = (com.google.ads.interactivemedia.v3.internal.zzrq.zzf) r0
            com.google.ads.interactivemedia.v3.internal.zzta<? extends V> r0 = r0.zzb
            boolean r4 = r0 instanceof com.google.ads.interactivemedia.v3.internal.zzrq.zzh
            if (r4 == 0) goto L54
            r4 = r0
            com.google.ads.interactivemedia.v3.internal.zzrq r4 = (com.google.ads.interactivemedia.v3.internal.zzrq) r4
            java.lang.Object r0 = r4.value
            if (r0 != 0) goto L4b
            r5 = r3
            goto L4c
        L4b:
            r5 = r2
        L4c:
            boolean r6 = r0 instanceof com.google.ads.interactivemedia.v3.internal.zzrq.zzf
            r5 = r5 | r6
            if (r5 == 0) goto L53
            r5 = r3
            goto L2b
        L53:
            return r3
        L54:
            r0.cancel(r8)
        L57:
            return r3
        L58:
            java.lang.Object r0 = r4.value
            boolean r6 = r0 instanceof com.google.ads.interactivemedia.v3.internal.zzrq.zzf
            if (r6 != 0) goto L2b
            return r5
        L5f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.zzrq.cancel(boolean):boolean");
    }

    @Override // java.util.concurrent.Future
    public final Object get() throws ExecutionException, InterruptedException {
        Object obj;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj2 = this.value;
        if ((obj2 != null) && (!(obj2 instanceof zzf))) {
            return zzx(obj2);
        }
        zzk zzkVar = this.waiters;
        if (zzkVar != zzk.zza) {
            zzk zzkVar2 = new zzk();
            do {
                zza zzaVar = zza;
                zzaVar.zzc(zzkVar2, zzkVar);
                if (zzaVar.zzg(this, zzkVar, zzkVar2)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            zzw(zzkVar2);
                            throw new InterruptedException();
                        }
                        obj = this.value;
                    } while (!((obj != null) & (!(obj instanceof zzf))));
                    return zzx(obj);
                }
                zzkVar = this.waiters;
            } while (zzkVar != zzk.zza);
        }
        Object obj3 = this.value;
        Objects.requireNonNull(obj3);
        return zzx(obj3);
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.value instanceof zzb;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return (this.value != null) & (!(r0 instanceof zzf));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (getClass().getName().startsWith("com.google.common.util.concurrent.")) {
            sb.append(getClass().getSimpleName());
        } else {
            sb.append(getClass().getName());
        }
        sb.append('@');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("[status=");
        if (this.value instanceof zzb) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            zzr(sb);
        } else {
            zzs(sb);
        }
        sb.append("]");
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @CheckForNull
    public String zza() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    public void zzb() {
    }

    public boolean zzc(Object obj) {
        if (obj == null) {
            obj = zzba;
        }
        if (!zza.zzf(this, null, obj)) {
            return false;
        }
        zzu(this, false);
        return true;
    }

    public boolean zzd(Throwable th) {
        th.getClass();
        if (!zza.zzf(this, null, new zzc(th))) {
            return false;
        }
        zzu(this, false);
        return true;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zztm
    @CheckForNull
    public final Throwable zzi() {
        if (!(this instanceof zzh)) {
            return null;
        }
        Object obj = this.value;
        if (obj instanceof zzc) {
            return ((zzc) obj).zzb;
        }
        return null;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzta
    public final void zzm(Runnable runnable, Executor executor) {
        zzd zzdVar;
        if (executor == null) {
            throw new NullPointerException("Executor was null.");
        }
        if (!isDone() && (zzdVar = this.listeners) != zzd.zza) {
            zzd zzdVar2 = new zzd(runnable, executor);
            do {
                zzdVar2.next = zzdVar;
                if (zza.zze(this, zzdVar, zzdVar2)) {
                    return;
                } else {
                    zzdVar = this.listeners;
                }
            } while (zzdVar != zzd.zza);
        }
        zzv(runnable, executor);
    }

    public void zzn() {
    }

    public final boolean zzo() {
        Object obj = this.value;
        return (obj instanceof zzb) && ((zzb) obj).zzc;
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j2, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j2);
        if (!Thread.interrupted()) {
            Object obj = this.value;
            boolean z = true;
            if ((obj != null) & (!(obj instanceof zzf))) {
                return zzx(obj);
            }
            long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
            if (nanos >= 1000) {
                zzk zzkVar = this.waiters;
                if (zzkVar != zzk.zza) {
                    zzk zzkVar2 = new zzk();
                    do {
                        zza zzaVar = zza;
                        zzaVar.zzc(zzkVar2, zzkVar);
                        if (zzaVar.zzg(this, zzkVar, zzkVar2)) {
                            do {
                                LockSupport.parkNanos(this, Math.min(nanos, 2147483647999999999L));
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.value;
                                    if ((obj2 != null) & (!(obj2 instanceof zzf))) {
                                        return zzx(obj2);
                                    }
                                    nanos = jNanoTime - System.nanoTime();
                                } else {
                                    zzw(zzkVar2);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= 1000);
                            zzw(zzkVar2);
                        } else {
                            zzkVar = this.waiters;
                        }
                    } while (zzkVar != zzk.zza);
                }
                Object obj3 = this.value;
                Objects.requireNonNull(obj3);
                return zzx(obj3);
            }
            while (nanos > 0) {
                Object obj4 = this.value;
                if ((obj4 != null) & (!(obj4 instanceof zzf))) {
                    return zzx(obj4);
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
            String strConcat = "Waited " + j2 + StringUtils.SPACE + timeUnit.toString().toLowerCase(locale);
            if (nanos + 1000 < 0) {
                String strConcat2 = strConcat.concat(" (plus ");
                long j3 = -nanos;
                long jConvert = timeUnit.convert(j3, TimeUnit.NANOSECONDS);
                long nanos2 = j3 - timeUnit.toNanos(jConvert);
                if (jConvert != 0 && nanos2 <= 1000) {
                    z = false;
                }
                if (jConvert > 0) {
                    String strConcat3 = strConcat2 + jConvert + StringUtils.SPACE + lowerCase;
                    if (z) {
                        strConcat3 = strConcat3.concat(",");
                    }
                    strConcat2 = strConcat3.concat(StringUtils.SPACE);
                }
                if (z) {
                    strConcat2 = strConcat2 + nanos2 + " nanoseconds ";
                }
                strConcat = strConcat2.concat("delay)");
            }
            if (isDone()) {
                throw new TimeoutException(strConcat.concat(" but future completed as timeout expired"));
            }
            throw new TimeoutException(b.l(strConcat, " for ", string));
        }
        throw new InterruptedException();
    }
}
