package kotlinx.serialization;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;

@Metadata
/* loaded from: classes3.dex */
public final class SerializersCacheKt$SERIALIZERS_CACHE$1 extends Lambda implements Function1<KClass<?>, KSerializer<? extends Object>> {

    /* renamed from: c, reason: collision with root package name */
    public static final SerializersCacheKt$SERIALIZERS_CACHE$1 f55716c = new SerializersCacheKt$SERIALIZERS_CACHE$1(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        KClass it = (KClass) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        return SerializersKt.b(it);
    }
}
