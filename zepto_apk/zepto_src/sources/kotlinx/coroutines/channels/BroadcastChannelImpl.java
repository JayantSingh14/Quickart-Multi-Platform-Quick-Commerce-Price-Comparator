package kotlinx.coroutines.channels;

import android.support.v4.media.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.internal.ContextScope;
import kotlinx.coroutines.selects.SelectInstance;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class BroadcastChannelImpl<E> extends BufferedChannel<E> implements BroadcastChannel<E> {

    /* renamed from: k, reason: collision with root package name */
    public final int f54186k;

    /* renamed from: l, reason: collision with root package name */
    public final ReentrantLock f54187l;

    /* renamed from: m, reason: collision with root package name */
    public Object f54188m;
    public Object n;
    public final HashMap o;

    @Metadata
    @SourceDebugExtension
    public final class SubscriberBuffered extends BufferedChannel<E> {
        @Override // kotlinx.coroutines.channels.BufferedChannel
        public final boolean r(CancellationException cancellationException) {
            throw null;
        }
    }

    @Metadata
    public final class SubscriberConflated extends ConflatedBufferedChannel<E> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlinx.coroutines.channels.BufferedChannel
        public final boolean r(CancellationException cancellationException) {
            BroadcastChannelImpl broadcastChannelImpl = null;
            ReentrantLock reentrantLock = broadcastChannelImpl.f54187l;
            reentrantLock.lock();
            try {
                Iterable iterable = (Iterable) broadcastChannelImpl.f54188m;
                ArrayList arrayList = new ArrayList();
                for (Object obj : iterable) {
                    if (((BufferedChannel) obj) != this) {
                        arrayList.add(obj);
                    }
                }
                broadcastChannelImpl.f54188m = arrayList;
                Unit unit = Unit.f53572a;
                reentrantLock.unlock();
                return super.r(cancellationException);
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
    }

    public BroadcastChannelImpl() {
        super(0);
        this.f54186k = -1;
        this.f54187l = new ReentrantLock();
        this.f54188m = EmptyList.f53609a;
        this.n = BroadcastChannelKt.f54199a;
        this.o = new HashMap();
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public final void N(SelectInstance selectInstance, Object obj) {
        ReentrantLock reentrantLock = this.f54187l;
        reentrantLock.lock();
        try {
            Object objRemove = this.o.remove(selectInstance);
            if (objRemove != null) {
                selectInstance.c(objRemove);
                return;
            }
            Unit unit = Unit.f53572a;
            reentrantLock.unlock();
            ContextScope contextScopeA = CoroutineScopeKt.a(selectInstance.getContext());
            CoroutineStart coroutineStart = CoroutineStart.f54078a;
            BuildersKt.c(contextScopeA, null, new BroadcastChannelImpl$registerSelectForSend$2(this, obj, selectInstance, null), 1);
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.SendChannel
    public final boolean d(Throwable th) {
        ReentrantLock reentrantLock = this.f54187l;
        reentrantLock.lock();
        try {
            Iterator it = ((Iterable) this.f54188m).iterator();
            while (it.hasNext()) {
                ((BufferedChannel) it.next()).d(th);
            }
            Iterable iterable = (Iterable) this.f54188m;
            ArrayList arrayList = new ArrayList();
            for (Object obj : iterable) {
                if (((BufferedChannel) obj).B()) {
                    arrayList.add(obj);
                }
            }
            this.f54188m = arrayList;
            boolean zS = s(false, th);
            reentrantLock.unlock();
            return zS;
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.SendChannel
    public final Object i(Object obj) {
        ReentrantLock reentrantLock = this.f54187l;
        reentrantLock.lock();
        try {
            if (p()) {
                return super.i(obj);
            }
            Iterable iterable = (Iterable) this.f54188m;
            if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                Iterator it = iterable.iterator();
                while (it.hasNext()) {
                    if (((BufferedChannel) it.next()).Q()) {
                        return ChannelResult.f54254b;
                    }
                }
            }
            if (this.f54186k == -1) {
                this.n = obj;
            }
            Iterator it2 = ((Iterable) this.f54188m).iterator();
            while (it2.hasNext()) {
                ((BufferedChannel) it2.next()).i(obj);
            }
            ChannelResult.Failed failed = ChannelResult.f54254b;
            return Unit.f53572a;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0077 -> B:30:0x007a). Please report as a decompilation issue!!! */
    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.SendChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object o(java.lang.Object r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof kotlinx.coroutines.channels.BroadcastChannelImpl$send$1
            if (r0 == 0) goto L13
            r0 = r8
            kotlinx.coroutines.channels.BroadcastChannelImpl$send$1 r0 = (kotlinx.coroutines.channels.BroadcastChannelImpl$send$1) r0
            int r1 = r0.f54198f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f54198f = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.BroadcastChannelImpl$send$1 r0 = new kotlinx.coroutines.channels.BroadcastChannelImpl$send$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.f54196d
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f54198f
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.util.Iterator r7 = r0.f54195c
            java.lang.Object r2 = r0.f54194b
            kotlinx.coroutines.channels.BroadcastChannelImpl r4 = r0.f54193a
            kotlin.ResultKt.b(r8)
            goto L7a
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L35:
            kotlin.ResultKt.b(r8)
            java.util.concurrent.locks.ReentrantLock r8 = r6.f54187l
            r8.lock()
            boolean r2 = r6.p()     // Catch: java.lang.Throwable -> L4b
            if (r2 != 0) goto L93
            int r2 = r6.f54186k     // Catch: java.lang.Throwable -> L4b
            r4 = -1
            if (r2 != r4) goto L4d
            r6.n = r7     // Catch: java.lang.Throwable -> L4b
            goto L4d
        L4b:
            r7 = move-exception
            goto L98
        L4d:
            java.lang.Object r2 = r6.f54188m     // Catch: java.lang.Throwable -> L4b
            r8.unlock()
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r8 = r2.iterator()
            r4 = r8
            r8 = r7
            r7 = r4
            r4 = r6
        L5c:
            boolean r2 = r7.hasNext()
            if (r2 == 0) goto L90
            java.lang.Object r2 = r7.next()
            kotlinx.coroutines.channels.BufferedChannel r2 = (kotlinx.coroutines.channels.BufferedChannel) r2
            r0.f54193a = r4
            r0.f54194b = r8
            r0.f54195c = r7
            r0.f54198f = r3
            java.lang.Object r2 = r2.P(r8, r0)
            if (r2 != r1) goto L77
            return r1
        L77:
            r5 = r2
            r2 = r8
            r8 = r5
        L7a:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 != 0) goto L8e
            boolean r8 = r4.p()
            if (r8 != 0) goto L89
            goto L8e
        L89:
            java.lang.Throwable r7 = r4.z()
            throw r7
        L8e:
            r8 = r2
            goto L5c
        L90:
            kotlin.Unit r7 = kotlin.Unit.f53572a
            return r7
        L93:
            java.lang.Throwable r7 = r6.z()     // Catch: java.lang.Throwable -> L4b
            throw r7     // Catch: java.lang.Throwable -> L4b
        L98:
            r8.unlock()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BroadcastChannelImpl.o(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel, kotlinx.coroutines.channels.SendChannel
    public final boolean p() {
        ReentrantLock reentrantLock = this.f54187l;
        reentrantLock.lock();
        try {
            return super.p();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public final boolean r(CancellationException cancellationException) {
        ReentrantLock reentrantLock = this.f54187l;
        reentrantLock.lock();
        try {
            Iterator it = ((Iterable) this.f54188m).iterator();
            while (it.hasNext()) {
                ((BufferedChannel) it.next()).r(cancellationException);
            }
            this.n = BroadcastChannelKt.f54199a;
            boolean zR = super.r(cancellationException);
            reentrantLock.unlock();
            return zR;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // kotlinx.coroutines.channels.BufferedChannel
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.n != BroadcastChannelKt.f54199a ? b.q(new StringBuilder("CONFLATED_ELEMENT="), this.n, "; ") : "");
        sb.append("BROADCAST=<");
        sb.append(super.toString());
        sb.append(">; SUBSCRIBERS=");
        sb.append(CollectionsKt.E((Iterable) this.f54188m, ";", "<", ">", null, 56));
        return sb.toString();
    }
}
