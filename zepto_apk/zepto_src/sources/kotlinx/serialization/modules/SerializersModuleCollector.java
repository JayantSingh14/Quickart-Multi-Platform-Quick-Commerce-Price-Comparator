package kotlinx.serialization.modules;

import com.zeptonow.horizon.utils.AnyValueSerializer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.json.internal.PolymorphismValidator;

@Metadata
@ExperimentalSerializationApi
/* loaded from: classes.dex */
public interface SerializersModuleCollector {

    @Metadata
    public static final class DefaultImpls {
        public static void a(PolymorphismValidator polymorphismValidator, KClass kClass) {
            AnyValueSerializer serializer = AnyValueSerializer.f48230a;
            Intrinsics.checkNotNullParameter(kClass, "kClass");
            Intrinsics.checkNotNullParameter(serializer, "serializer");
            polymorphismValidator.a(kClass, new SerializersModuleCollector$contextual$1(1));
        }
    }
}
