package okhttp3;

import com.google.android.gms.common.api.Api;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.internal.Util;
import okhttp3.internal.a;
import okhttp3.internal.connection.RealCall;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class Dispatcher {

    /* renamed from: a, reason: collision with root package name */
    public ThreadPoolExecutor f56238a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayDeque f56239b = new ArrayDeque();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayDeque f56240c = new ArrayDeque();

    /* renamed from: d, reason: collision with root package name */
    public final ArrayDeque f56241d = new ArrayDeque();

    public final synchronized ExecutorService a() {
        ThreadPoolExecutor threadPoolExecutor;
        try {
            if (this.f56238a == null) {
                TimeUnit timeUnit = TimeUnit.SECONDS;
                SynchronousQueue synchronousQueue = new SynchronousQueue();
                String name = Util.f56400g + " Dispatcher";
                Intrinsics.checkNotNullParameter(name, "name");
                this.f56238a = new ThreadPoolExecutor(0, Api.BaseClientBuilder.API_PRIORITY_OTHER, 60L, timeUnit, synchronousQueue, new a(name, false));
            }
            threadPoolExecutor = this.f56238a;
            Intrinsics.c(threadPoolExecutor);
        } catch (Throwable th) {
            throw th;
        }
        return threadPoolExecutor;
    }

    public final void b(ArrayDeque arrayDeque, Object obj) {
        synchronized (this) {
            if (!arrayDeque.remove(obj)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
            Unit unit = Unit.f53572a;
        }
        d();
    }

    public final void c(RealCall.AsyncCall call) {
        Intrinsics.checkNotNullParameter(call, "call");
        call.f56531b.decrementAndGet();
        b(this.f56240c, call);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d() {
        /*
            r8 = this;
            byte[] r0 = okhttp3.internal.Util.f56394a
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            monitor-enter(r8)
            java.util.ArrayDeque r1 = r8.f56239b     // Catch: java.lang.Throwable -> L48
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L48
            java.lang.String r2 = "readyAsyncCalls.iterator()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)     // Catch: java.lang.Throwable -> L48
        L13:
            boolean r2 = r1.hasNext()     // Catch: java.lang.Throwable -> L48
            if (r2 == 0) goto L4a
            java.lang.Object r2 = r1.next()     // Catch: java.lang.Throwable -> L48
            okhttp3.internal.connection.RealCall$AsyncCall r2 = (okhttp3.internal.connection.RealCall.AsyncCall) r2     // Catch: java.lang.Throwable -> L48
            java.util.ArrayDeque r3 = r8.f56240c     // Catch: java.lang.Throwable -> L48
            int r3 = r3.size()     // Catch: java.lang.Throwable -> L48
            r4 = 64
            if (r3 >= r4) goto L4a
            java.util.concurrent.atomic.AtomicInteger r3 = r2.f56531b     // Catch: java.lang.Throwable -> L48
            int r3 = r3.get()     // Catch: java.lang.Throwable -> L48
            r4 = 5
            if (r3 >= r4) goto L13
            r1.remove()     // Catch: java.lang.Throwable -> L48
            java.util.concurrent.atomic.AtomicInteger r3 = r2.f56531b     // Catch: java.lang.Throwable -> L48
            r3.incrementAndGet()     // Catch: java.lang.Throwable -> L48
            java.lang.String r3 = "asyncCall"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)     // Catch: java.lang.Throwable -> L48
            r0.add(r2)     // Catch: java.lang.Throwable -> L48
            java.util.ArrayDeque r3 = r8.f56240c     // Catch: java.lang.Throwable -> L48
            r3.add(r2)     // Catch: java.lang.Throwable -> L48
            goto L13
        L48:
            r0 = move-exception
            goto Laa
        L4a:
            monitor-enter(r8)     // Catch: java.lang.Throwable -> L48
            java.util.ArrayDeque r1 = r8.f56240c     // Catch: java.lang.Throwable -> La7
            r1.size()     // Catch: java.lang.Throwable -> La7
            java.util.ArrayDeque r1 = r8.f56241d     // Catch: java.lang.Throwable -> La7
            r1.size()     // Catch: java.lang.Throwable -> La7
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L48
            kotlin.Unit r1 = kotlin.Unit.f53572a     // Catch: java.lang.Throwable -> L48
            monitor-exit(r8)
            int r1 = r0.size()
            r2 = 0
        L5e:
            if (r2 >= r1) goto La6
            java.lang.Object r3 = r0.get(r2)
            okhttp3.internal.connection.RealCall$AsyncCall r3 = (okhttp3.internal.connection.RealCall.AsyncCall) r3
            java.util.concurrent.ExecutorService r4 = r8.a()
            r3.getClass()
            java.lang.String r5 = "executorService"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r5)
            okhttp3.internal.connection.RealCall r5 = r3.f56532c
            okhttp3.OkHttpClient r6 = r5.f56517a
            okhttp3.Dispatcher r6 = r6.f56297a
            byte[] r6 = okhttp3.internal.Util.f56394a
            java.util.concurrent.ThreadPoolExecutor r4 = (java.util.concurrent.ThreadPoolExecutor) r4     // Catch: java.util.concurrent.RejectedExecutionException -> L80 java.lang.Throwable -> L9d
            r4.execute(r3)     // Catch: java.util.concurrent.RejectedExecutionException -> L80 java.lang.Throwable -> L9d
            goto L9a
        L80:
            r4 = move-exception
            java.io.InterruptedIOException r6 = new java.io.InterruptedIOException     // Catch: java.lang.Throwable -> L9d
            java.lang.String r7 = "executor rejected"
            r6.<init>(r7)     // Catch: java.lang.Throwable -> L9d
            r6.initCause(r4)     // Catch: java.lang.Throwable -> L9d
            r5.h(r6)     // Catch: java.lang.Throwable -> L9d
            okhttp3.Callback r4 = r3.f56530a     // Catch: java.lang.Throwable -> L9d
            r4.onFailure(r5, r6)     // Catch: java.lang.Throwable -> L9d
            okhttp3.OkHttpClient r4 = r5.f56517a
            okhttp3.Dispatcher r4 = r4.f56297a
            r4.c(r3)
        L9a:
            int r2 = r2 + 1
            goto L5e
        L9d:
            r0 = move-exception
            okhttp3.OkHttpClient r1 = r5.f56517a
            okhttp3.Dispatcher r1 = r1.f56297a
            r1.c(r3)
            throw r0
        La6:
            return
        La7:
            r0 = move-exception
            monitor-exit(r8)     // Catch: java.lang.Throwable -> La7
            throw r0     // Catch: java.lang.Throwable -> L48
        Laa:
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.Dispatcher.d():void");
    }

    public final synchronized List e() {
        List listUnmodifiableList;
        try {
            ArrayDeque arrayDeque = this.f56239b;
            ArrayList arrayList = new ArrayList(CollectionsKt.r(arrayDeque, 10));
            Iterator it = arrayDeque.iterator();
            while (it.hasNext()) {
                arrayList.add(((RealCall.AsyncCall) it.next()).f56532c);
            }
            listUnmodifiableList = Collections.unmodifiableList(arrayList);
            Intrinsics.checkNotNullExpressionValue(listUnmodifiableList, "unmodifiableList(readyAsyncCalls.map { it.call })");
        } catch (Throwable th) {
            throw th;
        }
        return listUnmodifiableList;
    }

    public final synchronized List f() {
        List listUnmodifiableList;
        try {
            ArrayDeque arrayDeque = this.f56241d;
            ArrayDeque arrayDeque2 = this.f56240c;
            ArrayList arrayList = new ArrayList(CollectionsKt.r(arrayDeque2, 10));
            Iterator it = arrayDeque2.iterator();
            while (it.hasNext()) {
                arrayList.add(((RealCall.AsyncCall) it.next()).f56532c);
            }
            listUnmodifiableList = Collections.unmodifiableList(CollectionsKt.L(arrayDeque, arrayList));
            Intrinsics.checkNotNullExpressionValue(listUnmodifiableList, "unmodifiableList(running…yncCalls.map { it.call })");
        } catch (Throwable th) {
            throw th;
        }
        return listUnmodifiableList;
    }
}
