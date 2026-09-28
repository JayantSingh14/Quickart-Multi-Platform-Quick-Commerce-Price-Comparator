package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata
/* loaded from: classes.dex */
public final class SelectClause0Impl implements SelectClause0 {

    /* renamed from: a, reason: collision with root package name */
    public final Object f55174a;

    /* renamed from: b, reason: collision with root package name */
    public final FunctionReferenceImpl f55175b;

    /* renamed from: c, reason: collision with root package name */
    public final Function3 f55176c;

    /* JADX WARN: Multi-variable type inference failed */
    public SelectClause0Impl(Object obj, Function3 function3) {
        this.f55174a = obj;
        this.f55175b = (FunctionReferenceImpl) function3;
        Function3 function32 = SelectKt.f55205a;
        this.f55176c = SelectKt$DUMMY_PROCESS_RESULT_FUNCTION$1.f55211a;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.functions.Function3, kotlin.jvm.internal.FunctionReferenceImpl] */
    @Override // kotlinx.coroutines.selects.SelectClause
    public final Function3 a() {
        return this.f55175b;
    }

    @Override // kotlinx.coroutines.selects.SelectClause
    public final Function3 b() {
        return null;
    }

    @Override // kotlinx.coroutines.selects.SelectClause
    public final Function3 c() {
        return this.f55176c;
    }

    @Override // kotlinx.coroutines.selects.SelectClause
    public final Object d() {
        return this.f55174a;
    }
}
