package kotlinx.serialization;

import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import kotlinx.serialization.builtins.BuiltinSerializersKt;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class SerializersCacheKt$SERIALIZERS_CACHE_NULLABLE$1 extends Lambda implements Function1<KClass<?>, KSerializer<Object>> {

    /* renamed from: c, reason: collision with root package name */
    public static final SerializersCacheKt$SERIALIZERS_CACHE_NULLABLE$1 f55717c = new SerializersCacheKt$SERIALIZERS_CACHE_NULLABLE$1(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException, InvocationTargetException {
        KClass it = (KClass) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        KSerializer kSerializerB = SerializersKt.b(it);
        if (kSerializerB != null) {
            return BuiltinSerializersKt.c(kSerializerB);
        }
        return null;
    }
}
