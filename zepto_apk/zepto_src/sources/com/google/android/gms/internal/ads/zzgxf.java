package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgxg;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes4.dex */
public abstract class zzgxf<V> extends zzgxg<V> {

    final class zza {

        /* renamed from: c, reason: collision with root package name */
        public static final zza f33308c;

        /* renamed from: d, reason: collision with root package name */
        public static final zza f33309d;

        /* renamed from: a, reason: collision with root package name */
        public final boolean f33310a;

        /* renamed from: b, reason: collision with root package name */
        public final RuntimeException f33311b;

        static {
            if (zzgxg.f33322f) {
                f33309d = null;
                f33308c = null;
            } else {
                f33309d = new zza(false, null);
                f33308c = new zza(true, null);
            }
        }

        public zza(boolean z, RuntimeException runtimeException) {
            this.f33310a = z;
            this.f33311b = runtimeException;
        }
    }

    final class zzb<V> implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final zzgxf f33312a;

        /* renamed from: b, reason: collision with root package name */
        public final ListenableFuture f33313b;

        public zzb(zzgxf zzgxfVar, ListenableFuture listenableFuture) {
            this.f33312a = zzgxfVar;
            this.f33313b = listenableFuture;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.f33312a.f33324a != this) {
                return;
            }
            ListenableFuture listenableFuture = this.f33313b;
            if (zzgxg.f33323g.g(this.f33312a, this, zzgxf.g(listenableFuture))) {
                zzgxf.o(this.f33312a, false);
            }
        }
    }

    final class zzc {

        /* renamed from: b, reason: collision with root package name */
        public static final zzc f33314b = new zzc(new AnonymousClass1("Failure occurred while trying to finish a future."));

        /* renamed from: a, reason: collision with root package name */
        public final Throwable f33315a;

        /* renamed from: com.google.android.gms.internal.ads.zzgxf$zzc$1, reason: invalid class name */
        public class AnonymousClass1 extends Throwable {
            @Override // java.lang.Throwable
            public final Throwable fillInStackTrace() {
                return this;
            }
        }

        public zzc(Throwable th) {
            th.getClass();
            this.f33315a = th;
        }
    }

    final class zzd {

        /* renamed from: d, reason: collision with root package name */
        public static final zzd f33316d = new zzd();

        /* renamed from: a, reason: collision with root package name */
        public final Runnable f33317a;

        /* renamed from: b, reason: collision with root package name */
        public final Executor f33318b;

        /* renamed from: c, reason: collision with root package name */
        public zzd f33319c;

        public zzd() {
            this.f33317a = null;
            this.f33318b = null;
        }

        public zzd(Runnable runnable, Executor executor) {
            this.f33317a = runnable;
            this.f33318b = executor;
        }
    }

    interface zze<V> extends ListenableFuture<V> {
    }

    abstract class zzf<V> extends zzgxf<V> implements zze<V> {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Object g(ListenableFuture listenableFuture) {
        Throwable thA;
        if (listenableFuture instanceof zze) {
            Object zzaVar = ((zzgxf) listenableFuture).f33324a;
            if (zzaVar instanceof zza) {
                zza zzaVar2 = (zza) zzaVar;
                if (zzaVar2.f33310a) {
                    RuntimeException runtimeException = zzaVar2.f33311b;
                    zzaVar = runtimeException != null ? new zza(false, runtimeException) : zza.f33309d;
                }
            }
            Objects.requireNonNull(zzaVar);
            return zzaVar;
        }
        if ((listenableFuture instanceof zzgzo) && (thA = ((zzgzo) listenableFuture).a()) != null) {
            return new zzc(thA);
        }
        boolean zIsCancelled = listenableFuture.isCancelled();
        if ((!zzgxg.f33322f) && zIsCancelled) {
            zza zzaVar3 = zza.f33309d;
            Objects.requireNonNull(zzaVar3);
            return zzaVar3;
        }
        try {
            try {
                try {
                    Object objH = h(listenableFuture);
                    if (!zIsCancelled) {
                        return objH == null ? zzgxg.f33320d : objH;
                    }
                    String strValueOf = String.valueOf(listenableFuture);
                    StringBuilder sb = new StringBuilder(strValueOf.length() + 84);
                    sb.append("get() did not throw CancellationException, despite reporting isCancelled() == true: ");
                    sb.append(strValueOf);
                    return new zza(false, new IllegalArgumentException(sb.toString()));
                } catch (Error | Exception e2) {
                    e = e2;
                    return new zzc(e);
                }
            } catch (Error e3) {
                e = e3;
                return new zzc(e);
            }
        } catch (CancellationException e4) {
            return !zIsCancelled ? new zzc(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: ".concat(String.valueOf(listenableFuture)), e4)) : new zza(false, e4);
        } catch (ExecutionException e5) {
            return zIsCancelled ? new zza(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: ".concat(String.valueOf(listenableFuture)), e5)) : new zzc(e5.getCause());
        }
    }

    public static Object h(ListenableFuture listenableFuture) {
        V v;
        boolean z = false;
        while (true) {
            try {
                v = listenableFuture.get();
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

    public static Object i(Object obj) throws ExecutionException {
        if (obj instanceof zza) {
            RuntimeException runtimeException = ((zza) obj).f33311b;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(runtimeException);
            throw cancellationException;
        }
        if (obj instanceof zzc) {
            throw new ExecutionException(((zzc) obj).f33315a);
        }
        if (obj == zzgxg.f33320d) {
            return null;
        }
        return obj;
    }

    public static boolean j(Object obj) {
        return !(obj instanceof zzb);
    }

    public static void o(zzgxf zzgxfVar, boolean z) {
        zzd zzdVar = null;
        while (true) {
            zzgxfVar.getClass();
            for (zzgxg.zze zzeVarE = zzgxg.f33323g.e(zzgxfVar); zzeVarE != null; zzeVarE = zzeVarE.f33340b) {
                Thread thread = zzeVarE.f33339a;
                if (thread != null) {
                    zzeVarE.f33339a = null;
                    LockSupport.unpark(thread);
                }
            }
            if (z) {
                zzgxfVar.k();
            }
            zzgxfVar.e();
            zzd zzdVar2 = zzdVar;
            zzd zzdVarF = zzgxg.f33323g.f(zzgxfVar);
            zzd zzdVar3 = zzdVar2;
            while (zzdVarF != null) {
                zzd zzdVar4 = zzdVarF.f33319c;
                zzdVarF.f33319c = zzdVar3;
                zzdVar3 = zzdVarF;
                zzdVarF = zzdVar4;
            }
            while (zzdVar3 != null) {
                Runnable runnable = zzdVar3.f33317a;
                zzdVar = zzdVar3.f33319c;
                Objects.requireNonNull(runnable);
                if (runnable instanceof zzb) {
                    zzb zzbVar = (zzb) runnable;
                    zzgxfVar = zzbVar.f33312a;
                    if (zzgxfVar.f33324a == zzbVar) {
                        if (zzgxg.f33323g.g(zzgxfVar, zzbVar, g(zzbVar.f33313b))) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    Executor executor = zzdVar3.f33318b;
                    Objects.requireNonNull(executor);
                    r(runnable, executor);
                }
                zzdVar3 = zzdVar;
            }
            return;
            z = false;
        }
    }

    public static void r(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (Exception e2) {
            Logger loggerA = zzgxg.f33321e.a();
            Level level = Level.SEVERE;
            String strValueOf = String.valueOf(runnable);
            String strValueOf2 = String.valueOf(executor);
            loggerA.logp(level, "com.google.common.util.concurrent.AbstractFuture", "executeListener", android.support.v4.media.a.n(new StringBuilder(strValueOf.length() + 57 + strValueOf2.length()), "RuntimeException while executing runnable ", strValueOf, " with executor ", strValueOf2), (Throwable) e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgzo
    public final Throwable a() {
        if (!(this instanceof zze)) {
            return null;
        }
        Object obj = this.f33324a;
        if (obj instanceof zzc) {
            return ((zzc) obj).f33315a;
        }
        return null;
    }

    public boolean c(Object obj) {
        if (obj == null) {
            obj = zzgxg.f33320d;
        }
        if (!zzgxg.f33323g.g(this, null, obj)) {
            return false;
        }
        o(this, false);
        return true;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        zza zzaVar;
        Object obj = this.f33324a;
        if (!(obj instanceof zzb) && !(obj == null)) {
            return false;
        }
        if (zzgxg.f33322f) {
            zzaVar = new zza(z, new CancellationException("Future.cancel() was called."));
        } else {
            zzaVar = z ? zza.f33308c : zza.f33309d;
            Objects.requireNonNull(zzaVar);
        }
        zzgxf<V> zzgxfVar = this;
        boolean z2 = false;
        while (true) {
            if (zzgxg.f33323g.g(zzgxfVar, obj, zzaVar)) {
                o(zzgxfVar, z);
                if (!(obj instanceof zzb)) {
                    break;
                }
                ListenableFuture listenableFuture = ((zzb) obj).f33313b;
                if (!(listenableFuture instanceof zze)) {
                    listenableFuture.cancel(z);
                    break;
                }
                zzgxfVar = (zzgxf) listenableFuture;
                obj = zzgxfVar.f33324a;
                if (!(obj == null) && !(obj instanceof zzb)) {
                    break;
                }
                z2 = true;
            } else {
                obj = zzgxfVar.f33324a;
                if (j(obj)) {
                    return z2;
                }
            }
        }
        return true;
    }

    public boolean d(Throwable th) {
        th.getClass();
        if (!zzgxg.f33323g.g(this, null, new zzc(th))) {
            return false;
        }
        o(this, false);
        return true;
    }

    public void e() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String f() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        long delay = ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS);
        StringBuilder sb = new StringBuilder(String.valueOf(delay).length() + 21);
        sb.append("remaining delay=[");
        sb.append(delay);
        sb.append(" ms]");
        return sb.toString();
    }

    @Override // java.util.concurrent.Future
    public Object get() throws InterruptedException {
        Object obj;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj2 = this.f33324a;
        if ((obj2 != null) && j(obj2)) {
            return i(obj2);
        }
        zzgxg.zze zzeVar = this.f33326c;
        zzgxg.zze zzeVar2 = zzgxg.zze.f33338c;
        if (zzeVar != zzeVar2) {
            zzgxg.zze zzeVar3 = new zzgxg.zze();
            do {
                zzgxg.zza zzaVar = zzgxg.f33323g;
                zzaVar.b(zzeVar3, zzeVar);
                if (zzaVar.c(this, zzeVar, zzeVar3)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            b(zzeVar3);
                            throw new InterruptedException();
                        }
                        obj = this.f33324a;
                    } while (!((obj != null) & j(obj)));
                    return i(obj);
                }
                zzeVar = this.f33326c;
            } while (zzeVar != zzeVar2);
        }
        Object obj3 = this.f33324a;
        Objects.requireNonNull(obj3);
        return i(obj3);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.f33324a instanceof zza;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        Object obj = this.f33324a;
        return (obj != null) & j(obj);
    }

    public void k() {
    }

    public final boolean l() {
        Object obj = this.f33324a;
        return (obj instanceof zza) && ((zza) obj).f33310a;
    }

    public final void m(ListenableFuture listenableFuture) {
        zzc zzcVar;
        listenableFuture.getClass();
        Object obj = this.f33324a;
        if (obj == null) {
            if (listenableFuture.isDone()) {
                if (zzgxg.f33323g.g(this, null, g(listenableFuture))) {
                    o(this, false);
                    return;
                }
                return;
            }
            zzb zzbVar = new zzb(this, listenableFuture);
            if (zzgxg.f33323g.g(this, null, zzbVar)) {
                try {
                    listenableFuture.q(zzbVar, zzgyb.f33369a);
                    return;
                } catch (Throwable th) {
                    try {
                        zzcVar = new zzc(th);
                    } catch (Error | Exception unused) {
                        zzcVar = zzc.f33314b;
                    }
                    zzgxg.f33323g.g(this, zzbVar, zzcVar);
                    return;
                }
            }
            obj = this.f33324a;
        }
        if (obj instanceof zza) {
            listenableFuture.cancel(((zza) obj).f33310a);
        }
    }

    public final void n(Future future) {
        if ((future != null) && isCancelled()) {
            future.cancel(l());
        }
    }

    public final void p(StringBuilder sb) {
        try {
            Object objH = h(this);
            sb.append("SUCCESS, result=[");
            if (objH == null) {
                sb.append("null");
            } else if (objH == this) {
                sb.append("this future");
            } else {
                sb.append(objH.getClass().getName());
                sb.append("@");
                sb.append(Integer.toHexString(System.identityHashCode(objH)));
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

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void q(Runnable runnable, Executor executor) {
        zzd zzdVar;
        zzd zzdVar2;
        zzgqa.h(runnable, "Runnable was null.");
        zzgqa.h(executor, "Executor was null.");
        if (!isDone() && (zzdVar = this.f33325b) != (zzdVar2 = zzd.f33316d)) {
            zzd zzdVar3 = new zzd(runnable, executor);
            do {
                zzdVar3.f33319c = zzdVar;
                if (zzgxg.f33323g.d(this, zzdVar, zzdVar3)) {
                    return;
                } else {
                    zzdVar = this.f33325b;
                }
            } while (zzdVar != zzdVar2);
        }
        r(runnable, executor);
    }

    public String toString() {
        String strConcat;
        StringBuilder sb = new StringBuilder();
        if (getClass().getName().startsWith("com.google.common.util.concurrent.")) {
            sb.append(getClass().getSimpleName());
        } else {
            sb.append(getClass().getName());
        }
        sb.append('@');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            p(sb);
        } else {
            int length = sb.length();
            sb.append("PENDING");
            Object obj = this.f33324a;
            if (obj instanceof zzb) {
                sb.append(", setFuture=[");
                ListenableFuture listenableFuture = ((zzb) obj).f33313b;
                try {
                    if (listenableFuture == this) {
                        sb.append("this future");
                    } else {
                        sb.append(listenableFuture);
                    }
                } catch (Throwable th) {
                    if ((th instanceof Error) && !(th instanceof StackOverflowError)) {
                        throw th;
                    }
                    sb.append("Exception thrown from implementation: ");
                    sb.append(th.getClass());
                }
                sb.append("]");
            } else {
                try {
                    strConcat = f();
                    if (zzgpz.a(strConcat)) {
                        strConcat = null;
                    }
                } catch (Throwable th2) {
                    if ((th2 instanceof Error) && !(th2 instanceof StackOverflowError)) {
                        throw th2;
                    }
                    strConcat = "Exception thrown from implementation: ".concat(String.valueOf(th2.getClass()));
                }
                if (strConcat != null) {
                    android.support.v4.media.a.u(sb, ", info=[", strConcat, "]");
                }
            }
            if (isDone()) {
                sb.delete(length, sb.length());
                p(sb);
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // java.util.concurrent.Future
    public Object get(long j2, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        long j3;
        boolean z;
        long nanos = timeUnit.toNanos(j2);
        if (!Thread.interrupted()) {
            Object obj = this.f33324a;
            if ((obj != null) & j(obj)) {
                return i(obj);
            }
            long j4 = 0;
            long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
            if (nanos >= 1000) {
                zzgxg.zze zzeVar = this.f33326c;
                zzgxg.zze zzeVar2 = zzgxg.zze.f33338c;
                if (zzeVar != zzeVar2) {
                    zzgxg.zze zzeVar3 = new zzgxg.zze();
                    z = true;
                    while (true) {
                        zzgxg.zza zzaVar = zzgxg.f33323g;
                        zzaVar.b(zzeVar3, zzeVar);
                        if (zzaVar.c(this, zzeVar, zzeVar3)) {
                            j3 = j4;
                            do {
                                LockSupport.parkNanos(this, Math.min(nanos, 2147483647999999999L));
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.f33324a;
                                    if ((obj2 != null) & j(obj2)) {
                                        return i(obj2);
                                    }
                                    nanos = jNanoTime - System.nanoTime();
                                } else {
                                    b(zzeVar3);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= 1000);
                            b(zzeVar3);
                        } else {
                            long j5 = j4;
                            zzeVar = this.f33326c;
                            if (zzeVar == zzeVar2) {
                                break;
                            }
                            j4 = j5;
                        }
                    }
                }
                Object obj3 = this.f33324a;
                Objects.requireNonNull(obj3);
                return i(obj3);
            }
            j3 = 0;
            z = true;
            while (nanos > j3) {
                Object obj4 = this.f33324a;
                if ((obj4 != null ? z : false) & j(obj4)) {
                    return i(obj4);
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
            String lowerCase2 = timeUnit.toString().toLowerCase(locale);
            StringBuilder sb = new StringBuilder(String.valueOf(j2).length() + 8 + String.valueOf(lowerCase2).length());
            androidx.fragment.app.e.A(sb, "Waited ", j2, StringUtils.SPACE);
            sb.append(lowerCase2);
            String string3 = sb.toString();
            if (nanos + 1000 < j3) {
                String strConcat = string3.concat(" (plus ");
                long j6 = -nanos;
                long jConvert = timeUnit.convert(j6, TimeUnit.NANOSECONDS);
                long nanos2 = j6 - timeUnit.toNanos(jConvert);
                boolean z2 = (jConvert == j3 || nanos2 > 1000) ? z : false;
                if (jConvert > j3) {
                    StringBuilder sb2 = new StringBuilder(String.valueOf(jConvert).length() + strConcat.length() + 1 + String.valueOf(lowerCase).length());
                    androidx.fragment.app.e.A(sb2, strConcat, jConvert, StringUtils.SPACE);
                    sb2.append(lowerCase);
                    String string4 = sb2.toString();
                    if (z2) {
                        string4 = string4.concat(",");
                    }
                    strConcat = string4.concat(StringUtils.SPACE);
                }
                if (z2) {
                    StringBuilder sb3 = new StringBuilder(String.valueOf(nanos2).length() + strConcat.length() + 13);
                    sb3.append(strConcat);
                    sb3.append(nanos2);
                    sb3.append(" nanoseconds ");
                    strConcat = sb3.toString();
                }
                string3 = strConcat.concat("delay)");
            }
            if (isDone()) {
                throw new TimeoutException(string3.concat(" but future completed as timeout expired"));
            }
            throw new TimeoutException(android.support.v4.media.b.s(new StringBuilder(string3.length() + 5 + String.valueOf(string).length()), string3, " for ", string));
        }
        throw new InterruptedException();
    }
}
