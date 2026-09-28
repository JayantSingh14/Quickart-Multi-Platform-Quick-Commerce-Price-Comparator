package androidx.room;

import androidx.room.AmbiguousColumnResolver;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
final class AmbiguousColumnResolver$resolve$1$1 extends Lambda implements Function3<Integer, Integer, List<? extends AmbiguousColumnResolver.ResultColumn>, Unit> {
    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        ((Number) obj).intValue();
        ((Number) obj2).intValue();
        List resultColumnsSublist = (List) obj3;
        Intrinsics.checkNotNullParameter(resultColumnsSublist, "resultColumnsSublist");
        throw null;
    }
}
