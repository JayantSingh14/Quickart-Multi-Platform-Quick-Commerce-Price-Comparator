package io.ktor.util.pipeline;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class SuspendFunctionGun$continuation$1 implements Continuation<Unit>, CoroutineStackFrame {

    /* renamed from: a, reason: collision with root package name */
    public int f50600a = Integer.MIN_VALUE;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SuspendFunctionGun f50601b;

    public SuspendFunctionGun$continuation$1(SuspendFunctionGun suspendFunctionGun) {
        this.f50601b = suspendFunctionGun;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.coroutines.Continuation[]] */
    /* JADX WARN: Type inference failed for: r2v2 */
    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final CoroutineStackFrame getCallerFrame() {
        StackWalkingFailedFrame stackWalkingFailedFrame = StackWalkingFailedFrame.f50593a;
        int i2 = this.f50600a;
        SuspendFunctionGun suspendFunctionGun = this.f50601b;
        if (i2 == Integer.MIN_VALUE) {
            this.f50600a = suspendFunctionGun.f50598f;
        }
        int i3 = this.f50600a;
        if (i3 < 0) {
            this.f50600a = Integer.MIN_VALUE;
            stackWalkingFailedFrame = null;
        } else {
            try {
                ?? r2 = suspendFunctionGun.f50597e[i3];
                if (r2 != 0) {
                    this.f50600a = i3 - 1;
                    stackWalkingFailedFrame = r2;
                }
            } catch (Throwable unused) {
            }
        }
        if (stackWalkingFailedFrame instanceof CoroutineStackFrame) {
            return stackWalkingFailedFrame;
        }
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        SuspendFunctionGun suspendFunctionGun = this.f50601b;
        Continuation[] continuationArr = suspendFunctionGun.f50597e;
        int i2 = suspendFunctionGun.f50598f;
        Continuation continuation = continuationArr[i2];
        if (continuation != this && continuation != null) {
            return continuation.getContext();
        }
        int i3 = i2 - 1;
        while (i3 >= 0) {
            int i4 = i3 - 1;
            Continuation continuation2 = suspendFunctionGun.f50597e[i3];
            if (continuation2 != this && continuation2 != null) {
                return continuation2.getContext();
            }
            i3 = i4;
        }
        throw new IllegalStateException("Not started");
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        Result.Companion companion = Result.f53538b;
        boolean z = obj instanceof Result.Failure;
        SuspendFunctionGun suspendFunctionGun = this.f50601b;
        if (!z) {
            suspendFunctionGun.g(false);
            return;
        }
        Throwable thA = Result.a(obj);
        Intrinsics.c(thA);
        suspendFunctionGun.h(ResultKt.a(thA));
    }
}
