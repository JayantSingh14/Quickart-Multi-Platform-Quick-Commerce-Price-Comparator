package io.ktor.utils.io.jvm.javaio;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.EventLoop;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.ThreadLocalEventLoop;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
abstract class BlockingAdapter {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f51296f = AtomicReferenceFieldUpdater.newUpdater(BlockingAdapter.class, Object.class, "state");

    /* renamed from: a, reason: collision with root package name */
    public final Job f51297a;

    /* renamed from: b, reason: collision with root package name */
    public final BlockingAdapter$end$1 f51298b;

    /* renamed from: c, reason: collision with root package name */
    public final DisposableHandle f51299c;

    /* renamed from: d, reason: collision with root package name */
    public int f51300d;

    /* renamed from: e, reason: collision with root package name */
    public int f51301e;

    @NotNull
    volatile /* synthetic */ int result;

    @NotNull
    volatile /* synthetic */ Object state;

    public BlockingAdapter() {
        this(null);
    }

    public static final void a(BlockingAdapter blockingAdapter, ContinuationImpl continuationImpl) {
        Object obj;
        Continuation continuationB;
        Object obj2 = null;
        while (true) {
            Object obj3 = blockingAdapter.state;
            if (obj3 instanceof Thread) {
                continuationB = IntrinsicsKt.b(continuationImpl);
                obj = obj3;
            } else {
                if (!Intrinsics.b(obj3, blockingAdapter)) {
                    throw new IllegalStateException("Already suspended or in finished state");
                }
                obj = obj2;
                continuationB = IntrinsicsKt.b(continuationImpl);
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f51296f;
            while (!atomicReferenceFieldUpdater.compareAndSet(blockingAdapter, obj3, continuationB)) {
                if (atomicReferenceFieldUpdater.get(blockingAdapter) != obj3) {
                    break;
                }
            }
            if (obj != null) {
                Parking parking = (Parking) PollersKt.f51329a.get();
                if (parking == null) {
                    parking = DefaultParking.f51311a;
                }
                parking.b(obj);
            }
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
            return;
            obj2 = obj;
        }
    }

    public abstract Object b(ContinuationImpl continuationImpl);

    public final int c(int i2, byte[] buffer, int i3) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        this.f51300d = i2;
        this.f51301e = i3;
        return d(buffer);
    }

    public final int d(Object jobToken) throws Throwable {
        Object noWhenBranchMatchedException;
        Intrinsics.checkNotNullParameter(jobToken, "jobToken");
        Thread thread = Thread.currentThread();
        Continuation continuation = null;
        while (true) {
            Object obj = this.state;
            if (obj instanceof Continuation) {
                Intrinsics.d(obj, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any>");
                continuation = (Continuation) obj;
                noWhenBranchMatchedException = thread;
            } else {
                if (obj instanceof Unit) {
                    return this.result;
                }
                if (obj instanceof Throwable) {
                    throw ((Throwable) obj);
                }
                if (obj instanceof Thread) {
                    throw new IllegalStateException("There is already thread owning adapter");
                }
                if (Intrinsics.b(obj, this)) {
                    throw new IllegalStateException("Not yet started");
                }
                noWhenBranchMatchedException = new NoWhenBranchMatchedException();
            }
            Intrinsics.checkNotNullExpressionValue(noWhenBranchMatchedException, "when (value) {\n         …Exception()\n            }");
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f51296f;
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, noWhenBranchMatchedException)) {
                if (atomicReferenceFieldUpdater.get(this) != obj) {
                    break;
                }
            }
            Intrinsics.c(continuation);
            Result.Companion companion = Result.f53538b;
            continuation.resumeWith(jobToken);
            Intrinsics.checkNotNullExpressionValue(thread, "thread");
            if (this.state == thread) {
                Parking parking = (Parking) PollersKt.f51329a.get();
                DefaultParking defaultParking = DefaultParking.f51311a;
                if (parking == null) {
                    parking = defaultParking;
                }
                if (parking == ProhibitParking.f51330a) {
                    ((Logger) BlockingKt.f51307a.getValue()).q("Blocking network thread detected. \nIt can possible lead to a performance decline or even a deadlock.\nPlease make sure you're using blocking IO primitives like InputStream and OutputStream only in \nthe context of Dispatchers.IO:\n```\nwithContext(Dispatchers.IO) {\n    myInputStream.read()\n}\n```");
                }
                while (true) {
                    EventLoop eventLoop = (EventLoop) ThreadLocalEventLoop.f54160a.get();
                    long jU1 = eventLoop != null ? eventLoop.U1() : Long.MAX_VALUE;
                    if (this.state != thread) {
                        break;
                    }
                    if (jU1 > 0) {
                        Parking parking2 = (Parking) PollersKt.f51329a.get();
                        if (parking2 == null) {
                            parking2 = defaultParking;
                        }
                        parking2.a(jU1);
                    }
                }
            }
            Object obj2 = this.state;
            if (obj2 instanceof Throwable) {
                throw ((Throwable) obj2);
            }
            return this.result;
        }
    }

    public BlockingAdapter(Job job) {
        this.f51297a = job;
        BlockingAdapter$end$1 blockingAdapter$end$1 = new BlockingAdapter$end$1(this);
        this.f51298b = blockingAdapter$end$1;
        this.state = this;
        this.result = 0;
        this.f51299c = job != null ? job.j0(new Function1<Throwable, Unit>() { // from class: io.ktor.utils.io.jvm.javaio.BlockingAdapter$disposable$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Throwable th = (Throwable) obj;
                if (th != null) {
                    BlockingAdapter$end$1 blockingAdapter$end$12 = this.f51304c.f51298b;
                    Result.Companion companion = Result.f53538b;
                    blockingAdapter$end$12.resumeWith(ResultKt.a(th));
                }
                return Unit.f53572a;
            }
        }) : null;
        BlockingAdapter$block$1 blockingAdapter$block$1 = new BlockingAdapter$block$1(this, null);
        TypeIntrinsics.b(1, blockingAdapter$block$1);
        blockingAdapter$block$1.invoke(blockingAdapter$end$1);
        if (this.state == this) {
            throw new IllegalArgumentException("Failed requirement.");
        }
    }
}
