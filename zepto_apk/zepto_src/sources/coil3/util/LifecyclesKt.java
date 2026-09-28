package coil3.util;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class LifecyclesKt {

    @Metadata
    @DebugMetadata(c = "coil3.util.LifecyclesKt", f = "lifecycles.kt", l = {42}, m = "awaitStarted")
    /* renamed from: coil3.util.LifecyclesKt$awaitStarted$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LifecyclesKt.awaitStarted(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object awaitStarted(@org.jetbrains.annotations.NotNull androidx.lifecycle.Lifecycle r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            boolean r0 = r7 instanceof coil3.util.LifecyclesKt.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r7
            coil3.util.LifecyclesKt$awaitStarted$1 r0 = (coil3.util.LifecyclesKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            coil3.util.LifecyclesKt$awaitStarted$1 r0 = new coil3.util.LifecyclesKt$awaitStarted$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r6 = r0.L$1
            kotlin.jvm.internal.Ref$ObjectRef r6 = (kotlin.jvm.internal.Ref.ObjectRef) r6
            java.lang.Object r0 = r0.L$0
            androidx.lifecycle.Lifecycle r0 = (androidx.lifecycle.Lifecycle) r0
            kotlin.ResultKt.b(r7)     // Catch: java.lang.Throwable -> L2f
            goto L82
        L2f:
            r7 = move-exception
            goto L90
        L31:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L39:
            kotlin.ResultKt.b(r7)
            androidx.lifecycle.Lifecycle$State r7 = r6.b()
            androidx.lifecycle.Lifecycle$State r2 = androidx.lifecycle.Lifecycle.State.f4808d
            boolean r7 = r7.a(r2)
            if (r7 == 0) goto L4b
            kotlin.Unit r6 = kotlin.Unit.f53572a
            return r6
        L4b:
            kotlin.jvm.internal.Ref$ObjectRef r7 = new kotlin.jvm.internal.Ref$ObjectRef
            r7.<init>()
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L8e
            r0.L$1 = r7     // Catch: java.lang.Throwable -> L8e
            r0.label = r3     // Catch: java.lang.Throwable -> L8e
            kotlinx.coroutines.CancellableContinuationImpl r2 = new kotlinx.coroutines.CancellableContinuationImpl     // Catch: java.lang.Throwable -> L8e
            kotlin.coroutines.Continuation r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.b(r0)     // Catch: java.lang.Throwable -> L8e
            r2.<init>(r3, r4)     // Catch: java.lang.Throwable -> L8e
            r2.s()     // Catch: java.lang.Throwable -> L8e
            coil3.util.LifecyclesKt$awaitStarted$2$1 r3 = new coil3.util.LifecyclesKt$awaitStarted$2$1     // Catch: java.lang.Throwable -> L8e
            r3.<init>()     // Catch: java.lang.Throwable -> L8e
            r7.f53801a = r3     // Catch: java.lang.Throwable -> L8e
            r6.a(r3)     // Catch: java.lang.Throwable -> L8e
            java.lang.Object r2 = r2.r()     // Catch: java.lang.Throwable -> L8e
            if (r2 != r1) goto L7d
            java.lang.String r3 = "frame"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)     // Catch: java.lang.Throwable -> L8e
            goto L7d
        L78:
            r5 = r0
            r0 = r6
            r6 = r7
            r7 = r5
            goto L90
        L7d:
            if (r2 != r1) goto L80
            return r1
        L80:
            r0 = r6
            r6 = r7
        L82:
            java.lang.Object r6 = r6.f53801a
            androidx.lifecycle.LifecycleObserver r6 = (androidx.lifecycle.LifecycleObserver) r6
            if (r6 == 0) goto L8b
            r0.c(r6)
        L8b:
            kotlin.Unit r6 = kotlin.Unit.f53572a
            return r6
        L8e:
            r0 = move-exception
            goto L78
        L90:
            java.lang.Object r6 = r6.f53801a
            androidx.lifecycle.LifecycleObserver r6 = (androidx.lifecycle.LifecycleObserver) r6
            if (r6 == 0) goto L99
            r0.c(r6)
        L99:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: coil3.util.LifecyclesKt.awaitStarted(androidx.lifecycle.Lifecycle, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final void removeAndAddObserver(@NotNull Lifecycle lifecycle, @NotNull LifecycleObserver lifecycleObserver) {
        lifecycle.c(lifecycleObserver);
        lifecycle.a(lifecycleObserver);
    }
}
