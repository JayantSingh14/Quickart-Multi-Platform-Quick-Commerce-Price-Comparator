package kotlinx.serialization.modules;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class SerializersModuleBuildersKt$polymorphic$1 extends Lambda implements Function1 {
    static {
        new SerializersModuleBuildersKt$polymorphic$1();
    }

    public SerializersModuleBuildersKt$polymorphic$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Intrinsics.checkNotNullParameter((PolymorphicModuleBuilder) obj, "$this$null");
        return Unit.f53572a;
    }
}
