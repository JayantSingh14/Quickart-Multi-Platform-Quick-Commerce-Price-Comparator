package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlinx.coroutines.channels.Channel;

@Metadata
/* loaded from: classes3.dex */
public final class SelectClause2Impl<P, Q> implements SelectClause2<P, Q> {

    /* renamed from: a, reason: collision with root package name */
    public final Channel f55180a;

    /* renamed from: b, reason: collision with root package name */
    public final FunctionReferenceImpl f55181b;

    /* renamed from: c, reason: collision with root package name */
    public final Function3 f55182c;

    /* JADX WARN: Multi-variable type inference failed */
    public SelectClause2Impl(Channel channel, Function3 function3, Function3 function32) {
        this.f55180a = channel;
        this.f55181b = (FunctionReferenceImpl) function3;
        this.f55182c = function32;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.functions.Function3, kotlin.jvm.internal.FunctionReferenceImpl] */
    @Override // kotlinx.coroutines.selects.SelectClause
    public final Function3 a() {
        return this.f55181b;
    }

    @Override // kotlinx.coroutines.selects.SelectClause
    public final Function3 c() {
        return this.f55182c;
    }
}
