package kotlinx.coroutines.test;

import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.SequencesKt;
import kotlin.time.Duration;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.Job;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.test.TestBuildersKt__TestBuildersKt$runTestCoroutineLegacy$3$3", f = "TestBuilders.kt", l = {}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes3.dex */
final class TestBuildersKt__TestBuildersKt$runTestCoroutineLegacy$3$3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbstractCoroutine f55290a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f55291b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function1 f55292c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Function0 f55293d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TestBuildersKt__TestBuildersKt$runTestCoroutineLegacy$3$3(AbstractCoroutine abstractCoroutine, long j2, Function1 function1, Function0 function0, Continuation continuation) {
        super(1, continuation);
        this.f55290a = abstractCoroutine;
        this.f55291b = j2;
        this.f55292c = function1;
        this.f55293d = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new TestBuildersKt__TestBuildersKt$runTestCoroutineLegacy$3$3(this.f55290a, this.f55291b, this.f55292c, this.f55293d, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        ((TestBuildersKt__TestBuildersKt$runTestCoroutineLegacy$3$3) create((Continuation) obj)).invokeSuspend(Unit.f53572a);
        throw null;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Iterable iterable;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        ResultKt.b(obj);
        try {
            iterable = (List) this.f55293d.invoke();
        } catch (UncompletedCoroutinesError unused) {
            iterable = EmptyList.f53609a;
        }
        AbstractCoroutine abstractCoroutine = this.f55290a;
        List listQ = SequencesKt.q(SequencesKt.g(abstractCoroutine.H(), new Function1<Job, Boolean>() { // from class: kotlinx.coroutines.test.TestBuildersKt__TestBuildersKt$handleTimeout$activeChildren$1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return Boolean.valueOf(((Job) obj2).a());
            }
        }));
        Throwable th = abstractCoroutine.isCancelled() ? (Throwable) this.f55292c.invoke(abstractCoroutine) : null;
        String string = "After waiting for " + ((Object) Duration.i(this.f55291b));
        if (th == null) {
            string = android.support.v4.media.b.k(string, ", the test coroutine is not completing");
        }
        if (!listQ.isEmpty()) {
            string = string + ", there were active child jobs: " + listQ;
        }
        if (th != null && listQ.isEmpty()) {
            StringBuilder sbW = android.support.v4.media.b.w(string);
            sbW.append(abstractCoroutine.W() ? ", the test coroutine completed" : ", the test coroutine was not completed");
            string = sbW.toString();
        }
        UncompletedCoroutinesError uncompletedCoroutinesError = new UncompletedCoroutinesError(string);
        if (th != null) {
            ExceptionsKt.a(uncompletedCoroutinesError, th);
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            ExceptionsKt.a(uncompletedCoroutinesError, (Throwable) it.next());
        }
        throw uncompletedCoroutinesError;
    }
}
