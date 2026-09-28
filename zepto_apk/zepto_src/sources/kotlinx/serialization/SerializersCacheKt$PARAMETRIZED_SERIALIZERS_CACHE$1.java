package kotlinx.serialization;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlinx.serialization.modules.SerializersModuleKt;

@Metadata
/* loaded from: classes3.dex */
public final class SerializersCacheKt$PARAMETRIZED_SERIALIZERS_CACHE$1 extends Lambda implements Function2<KClass<Object>, List<? extends KType>, KSerializer<? extends Object>> {

    /* renamed from: c, reason: collision with root package name */
    public static final SerializersCacheKt$PARAMETRIZED_SERIALIZERS_CACHE$1 f55712c = new SerializersCacheKt$PARAMETRIZED_SERIALIZERS_CACHE$1(2);

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        KClass clazz = (KClass) obj;
        final List types = (List) obj2;
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(types, "types");
        ArrayList arrayListD = SerializersKt.d(SerializersModuleKt.f56126a, types, true);
        Intrinsics.c(arrayListD);
        return SerializersKt.a(clazz, arrayListD, new Function0<KClassifier>() { // from class: kotlinx.serialization.SerializersCacheKt$PARAMETRIZED_SERIALIZERS_CACHE$1.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ((KType) types.get(0)).f();
            }
        });
    }
}
