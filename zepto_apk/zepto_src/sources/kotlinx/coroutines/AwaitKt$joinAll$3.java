package kotlinx.coroutines;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.xbill.DNS.Type;

@Metadata
@DebugMetadata(c = "kotlinx.coroutines.AwaitKt", f = "Await.kt", l = {Type.TALINK}, m = "joinAll")
/* loaded from: classes3.dex */
final class AwaitKt$joinAll$3 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Iterator f54050a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f54051b;

    /* renamed from: c, reason: collision with root package name */
    public int f54052c;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f54051b = obj;
        int i2 = (this.f54052c | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.f54052c = i2;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f53689a;
        if (i2 == 0) {
            ResultKt.b(obj);
            throw null;
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Iterator it = this.f54050a;
        ResultKt.b(obj);
        while (it.hasNext()) {
            Job job = (Job) it.next();
            this.f54050a = it;
            this.f54052c = 1;
            if (job.T0(this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.f53572a;
    }
}
