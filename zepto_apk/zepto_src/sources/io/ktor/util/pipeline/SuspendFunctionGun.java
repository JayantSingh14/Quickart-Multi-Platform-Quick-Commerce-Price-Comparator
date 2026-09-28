package io.ktor.util.pipeline;

import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class SuspendFunctionGun<TSubject, TContext> extends PipelineContext<TSubject, TContext> {

    /* renamed from: b, reason: collision with root package name */
    public final List f50594b;

    /* renamed from: c, reason: collision with root package name */
    public final SuspendFunctionGun$continuation$1 f50595c;

    /* renamed from: d, reason: collision with root package name */
    public Object f50596d;

    /* renamed from: e, reason: collision with root package name */
    public final Continuation[] f50597e;

    /* renamed from: f, reason: collision with root package name */
    public int f50598f;

    /* renamed from: g, reason: collision with root package name */
    public int f50599g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuspendFunctionGun(Object initial, Object context, List blocks) {
        super(context);
        Intrinsics.checkNotNullParameter(initial, "initial");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(blocks, "blocks");
        this.f50594b = blocks;
        this.f50595c = new SuspendFunctionGun$continuation$1(this);
        this.f50596d = initial;
        this.f50597e = new Continuation[blocks.size()];
        this.f50598f = -1;
    }

    @Override // io.ktor.util.pipeline.PipelineContext
    public final Object a(Object obj, ContinuationImpl continuationImpl) {
        this.f50599g = 0;
        if (this.f50594b.size() == 0) {
            return obj;
        }
        Intrinsics.checkNotNullParameter(obj, "<set-?>");
        this.f50596d = obj;
        if (this.f50598f < 0) {
            return e(continuationImpl);
        }
        throw new IllegalStateException("Already started");
    }

    @Override // io.ktor.util.pipeline.PipelineContext
    public final void c() {
        this.f50599g = this.f50594b.size();
    }

    @Override // io.ktor.util.pipeline.PipelineContext
    public final Object d() {
        return this.f50596d;
    }

    @Override // io.ktor.util.pipeline.PipelineContext
    public final Object e(Continuation frame) {
        Object obj;
        if (this.f50599g == this.f50594b.size()) {
            obj = this.f50596d;
        } else {
            Continuation continuation = IntrinsicsKt.b(frame);
            Intrinsics.checkNotNullParameter(continuation, "continuation");
            int i2 = this.f50598f + 1;
            this.f50598f = i2;
            Continuation[] continuationArr = this.f50597e;
            continuationArr[i2] = continuation;
            if (g(true)) {
                int i3 = this.f50598f;
                if (i3 < 0) {
                    throw new IllegalStateException("No more continuations to resume");
                }
                this.f50598f = i3 - 1;
                continuationArr[i3] = null;
                obj = this.f50596d;
            } else {
                obj = CoroutineSingletons.f53689a;
            }
        }
        if (obj == CoroutineSingletons.f53689a) {
            Intrinsics.checkNotNullParameter(frame, "frame");
        }
        return obj;
    }

    @Override // io.ktor.util.pipeline.PipelineContext
    public final Object f(Object obj, Continuation continuation) {
        Intrinsics.checkNotNullParameter(obj, "<set-?>");
        this.f50596d = obj;
        return e(continuation);
    }

    public final boolean g(boolean z) {
        int i2;
        List list;
        do {
            i2 = this.f50599g;
            list = this.f50594b;
            if (i2 == list.size()) {
                if (z) {
                    return true;
                }
                Result.Companion companion = Result.f53538b;
                h(this.f50596d);
                return false;
            }
            this.f50599g = i2 + 1;
            try {
            } catch (Throwable th) {
                Result.Companion companion2 = Result.f53538b;
                h(ResultKt.a(th));
                return false;
            }
        } while (((Function3) list.get(i2)).invoke(this, this.f50596d, this.f50595c) != CoroutineSingletons.f53689a);
        return false;
    }

    public final void h(Object obj) {
        int i2 = this.f50598f;
        if (i2 < 0) {
            throw new IllegalStateException("No more continuations to resume");
        }
        Continuation[] continuationArr = this.f50597e;
        Continuation continuation = continuationArr[i2];
        Intrinsics.c(continuation);
        int i3 = this.f50598f;
        this.f50598f = i3 - 1;
        continuationArr[i3] = null;
        Result.Companion companion = Result.f53538b;
        if (!(obj instanceof Result.Failure)) {
            continuation.resumeWith(obj);
            return;
        }
        Throwable thA = Result.a(obj);
        Intrinsics.c(thA);
        continuation.resumeWith(ResultKt.a(StackTraceRecoverKt.a(thA, continuation)));
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext r() {
        return this.f50595c.getContext();
    }
}
