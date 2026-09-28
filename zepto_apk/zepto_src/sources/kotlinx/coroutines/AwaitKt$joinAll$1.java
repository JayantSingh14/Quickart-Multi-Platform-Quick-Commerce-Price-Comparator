package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.AwaitKt", f = "Await.kt", l = {47}, m = "joinAll")
/* loaded from: classes3.dex */
final class AwaitKt$joinAll$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object[] f54045a;

    /* renamed from: b, reason: collision with root package name */
    public int f54046b;

    /* renamed from: c, reason: collision with root package name */
    public int f54047c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f54048d;

    /* renamed from: e, reason: collision with root package name */
    public int f54049e;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Job job;
        this.f54048d = obj;
        int i2 = (this.f54049e | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.f54049e = i2;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        if (i2 == 0) {
            ResultKt.b(obj);
            throw null;
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        int i3 = this.f54047c;
        int i4 = this.f54046b;
        Job[] jobArr = (Job[]) this.f54045a;
        ResultKt.b(obj);
        do {
            i4++;
            if (i4 >= i3) {
                return Unit.f53572a;
            }
            job = jobArr[i4];
            this.f54045a = jobArr;
            this.f54046b = i4;
            this.f54047c = i3;
            this.f54049e = 1;
        } while (job.T0(this) != coroutineSingletons);
        return coroutineSingletons;
    }
}
