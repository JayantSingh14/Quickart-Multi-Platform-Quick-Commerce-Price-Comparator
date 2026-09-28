package kotlinx.datetime.internal.format.parser;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class UnconditionalModification<Output> implements ParserOperation<Output> {

    /* renamed from: a, reason: collision with root package name */
    public final Function1 f55635a;

    public UnconditionalModification(Function1 operation) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        this.f55635a = operation;
    }

    @Override // kotlinx.datetime.internal.format.parser.ParserOperation
    public final Object a(Copyable copyable, String input, int i2) {
        Intrinsics.checkNotNullParameter(input, "input");
        this.f55635a.invoke(copyable);
        return Integer.valueOf(i2);
    }
}
