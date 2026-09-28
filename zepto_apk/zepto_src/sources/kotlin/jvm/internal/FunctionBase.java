package kotlin.jvm.internal;

import kotlin.Function;
import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public interface FunctionBase<R> extends Function<R> {
    int getArity();
}
