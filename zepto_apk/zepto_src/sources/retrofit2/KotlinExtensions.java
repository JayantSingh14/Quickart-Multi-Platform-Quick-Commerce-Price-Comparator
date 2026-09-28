package retrofit2;

import kotlin.KotlinNullPointerException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.apache.commons.lang3.ClassUtils;

@Metadata
@JvmName
@SourceDebugExtension
/* loaded from: classes5.dex */
public final class KotlinExtensions {
    public static final Object a(final Call call, Continuation frame) throws Throwable {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, IntrinsicsKt.b(frame));
        cancellableContinuationImpl.s();
        cancellableContinuationImpl.u(new Function1<Throwable, Unit>() { // from class: retrofit2.KotlinExtensions$await$2$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                call.cancel();
                return Unit.f53572a;
            }
        });
        call.N(new Callback<Object>() { // from class: retrofit2.KotlinExtensions$await$2$2
            @Override // retrofit2.Callback
            public final void a(Call call2, Throwable t) {
                Intrinsics.checkNotNullParameter(call2, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                Result.Companion companion = Result.f53538b;
                cancellableContinuationImpl.resumeWith(ResultKt.a(t));
            }

            @Override // retrofit2.Callback
            public final void b(Call call2, Response response) {
                Intrinsics.checkNotNullParameter(call2, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                boolean zC = response.f58224a.c();
                CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
                if (!zC) {
                    Result.Companion companion = Result.f53538b;
                    cancellableContinuationImpl2.resumeWith(ResultKt.a(new HttpException(response)));
                    return;
                }
                Object obj = response.f58225b;
                if (obj != null) {
                    Result.Companion companion2 = Result.f53538b;
                    cancellableContinuationImpl2.resumeWith(obj);
                    return;
                }
                Object objC = call2.r().c(Invocation.class);
                Intrinsics.c(objC);
                Invocation invocation = (Invocation) objC;
                KotlinNullPointerException kotlinNullPointerException = new KotlinNullPointerException("Response from " + invocation.f58102a.getName() + ClassUtils.PACKAGE_SEPARATOR_CHAR + invocation.f58104c.getName() + " was null but response body type was declared as non-null");
                Result.Companion companion3 = Result.f53538b;
                cancellableContinuationImpl2.resumeWith(ResultKt.a(kotlinNullPointerException));
            }
        });
        Object objR = cancellableContinuationImpl.r();
        if (objR == CoroutineSingletons.f53689a) {
            Intrinsics.checkNotNullParameter(frame, "frame");
        }
        return objR;
    }

    public static final Object b(final Call call, Continuation frame) throws Throwable {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, IntrinsicsKt.b(frame));
        cancellableContinuationImpl.s();
        cancellableContinuationImpl.u(new Function1<Throwable, Unit>() { // from class: retrofit2.KotlinExtensions$await$4$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                call.cancel();
                return Unit.f53572a;
            }
        });
        call.N(new Callback<Object>() { // from class: retrofit2.KotlinExtensions$await$4$2
            @Override // retrofit2.Callback
            public final void a(Call call2, Throwable t) {
                Intrinsics.checkNotNullParameter(call2, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                Result.Companion companion = Result.f53538b;
                cancellableContinuationImpl.resumeWith(ResultKt.a(t));
            }

            @Override // retrofit2.Callback
            public final void b(Call call2, Response response) {
                Intrinsics.checkNotNullParameter(call2, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                boolean zC = response.f58224a.c();
                CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
                if (zC) {
                    Result.Companion companion = Result.f53538b;
                    cancellableContinuationImpl2.resumeWith(response.f58225b);
                } else {
                    Result.Companion companion2 = Result.f53538b;
                    cancellableContinuationImpl2.resumeWith(ResultKt.a(new HttpException(response)));
                }
            }
        });
        Object objR = cancellableContinuationImpl.r();
        if (objR == CoroutineSingletons.f53689a) {
            Intrinsics.checkNotNullParameter(frame, "frame");
        }
        return objR;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void c(final java.lang.Throwable r4, kotlin.coroutines.Continuation r5) {
        /*
            boolean r0 = r5 instanceof retrofit2.KotlinExtensions$suspendAndThrow$1
            if (r0 == 0) goto L13
            r0 = r5
            retrofit2.KotlinExtensions$suspendAndThrow$1 r0 = (retrofit2.KotlinExtensions$suspendAndThrow$1) r0
            int r1 = r0.f58113b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f58113b = r1
            goto L18
        L13:
            retrofit2.KotlinExtensions$suspendAndThrow$1 r0 = new retrofit2.KotlinExtensions$suspendAndThrow$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f58112a
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r1 = r0.f58113b
            r2 = 1
            if (r1 == 0) goto L34
            if (r1 == r2) goto L2b
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2b:
            kotlin.ResultKt.b(r5)
            kotlin.KotlinNothingValueException r4 = new kotlin.KotlinNothingValueException
            r4.<init>()
            throw r4
        L34:
            kotlin.ResultKt.b(r5)
            r0.f58113b = r2
            kotlinx.coroutines.scheduling.DefaultScheduler r5 = kotlinx.coroutines.Dispatchers.f54091a
            kotlin.coroutines.CoroutineContext r1 = r0.getContext()
            retrofit2.KotlinExtensions$suspendAndThrow$2$1 r2 = new retrofit2.KotlinExtensions$suspendAndThrow$2$1
            r2.<init>()
            r5.c1(r1, r2)
            java.lang.String r4 = "frame"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: retrofit2.KotlinExtensions.c(java.lang.Throwable, kotlin.coroutines.Continuation):void");
    }
}
