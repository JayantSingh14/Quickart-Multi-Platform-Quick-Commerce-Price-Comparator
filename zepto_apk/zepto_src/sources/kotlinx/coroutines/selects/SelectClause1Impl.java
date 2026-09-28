package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.a;

@Metadata
/* loaded from: classes.dex */
public final class SelectClause1Impl<Q> implements SelectClause1<Q> {

    /* renamed from: a, reason: collision with root package name */
    public final BufferedChannel f55177a;

    /* renamed from: b, reason: collision with root package name */
    public final FunctionReferenceImpl f55178b;

    /* renamed from: c, reason: collision with root package name */
    public final FunctionReferenceImpl f55179c;

    /* JADX WARN: Multi-variable type inference failed */
    public SelectClause1Impl(BufferedChannel bufferedChannel, Function3 function3, Function3 function32, a aVar) {
        this.f55177a = bufferedChannel;
        this.f55178b = (FunctionReferenceImpl) function3;
        this.f55179c = (FunctionReferenceImpl) function32;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.functions.Function3, kotlin.jvm.internal.FunctionReferenceImpl] */
    @Override // kotlinx.coroutines.selects.SelectClause
    public final Function3 a() {
        return this.f55178b;
    }

    @Override // kotlinx.coroutines.selects.SelectClause
    public final Function3 b() {
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.functions.Function3, kotlin.jvm.internal.FunctionReferenceImpl] */
    @Override // kotlinx.coroutines.selects.SelectClause
    public final Function3 c() {
        return this.f55179c;
    }

    @Override // kotlinx.coroutines.selects.SelectClause
    public final Object d() {
        return this.f55177a;
    }
}
