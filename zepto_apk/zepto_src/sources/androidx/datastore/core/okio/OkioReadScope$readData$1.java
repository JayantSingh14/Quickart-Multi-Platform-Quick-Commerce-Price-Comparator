package androidx.datastore.core.okio;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import okio.RealBufferedSource;

@Metadata
@DebugMetadata(c = "androidx.datastore.core.okio.OkioReadScope", f = "OkioStorage.kt", l = {180, 187}, m = "readData$suspendImpl")
/* loaded from: classes.dex */
final class OkioReadScope$readData$1<T> extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f3651a;

    /* renamed from: b, reason: collision with root package name */
    public RealBufferedSource f3652b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f3653c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ OkioReadScope f3654d;

    /* renamed from: e, reason: collision with root package name */
    public int f3655e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OkioReadScope$readData$1(OkioReadScope okioReadScope, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f3654d = okioReadScope;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f3653c = obj;
        this.f3655e |= Integer.MIN_VALUE;
        return OkioReadScope.f(this.f3654d, this);
    }
}
