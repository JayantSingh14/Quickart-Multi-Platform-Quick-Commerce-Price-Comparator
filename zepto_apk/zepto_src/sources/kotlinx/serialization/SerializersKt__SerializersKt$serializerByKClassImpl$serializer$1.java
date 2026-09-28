package kotlinx.serialization;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClassifier;

@Metadata
/* loaded from: classes3.dex */
final class SerializersKt__SerializersKt$serializerByKClassImpl$serializer$1 extends Lambda implements Function0<KClassifier> {
    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        throw new SerializationException("It is not possible to retrieve an array serializer using KClass alone, use KType instead or ArraySerializer factory");
    }
}
