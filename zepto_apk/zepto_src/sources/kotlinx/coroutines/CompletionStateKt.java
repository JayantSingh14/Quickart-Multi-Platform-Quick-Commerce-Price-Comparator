package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class CompletionStateKt {
    public static final Object a(Object obj) {
        if (obj instanceof CompletedExceptionally) {
            Result.Companion companion = Result.f53538b;
            return ResultKt.a(((CompletedExceptionally) obj).f54073a);
        }
        Result.Companion companion2 = Result.f53538b;
        return obj;
    }
}
