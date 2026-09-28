package kotlinx.serialization.modules;

import com.zeptonow.horizon.utils.AnyValueSerializer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.KSerializer;

@Metadata
/* loaded from: classes.dex */
final class SerializersModuleCollector$contextual$1 extends Lambda implements Function1<List<? extends KSerializer<?>>, KSerializer<?>> {
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        List it = (List) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        return AnyValueSerializer.f48230a;
    }
}
