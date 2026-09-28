package kotlinx.serialization.modules;

import java.util.List;
import kotlin.Metadata;
import kotlin.reflect.KClass;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;

@Metadata
/* loaded from: classes.dex */
public abstract class SerializersModule {
    public abstract KSerializer a(KClass kClass, List list);

    public abstract DeserializationStrategy b(String str, KClass kClass);

    public abstract SerializationStrategy c(KClass kClass, Object obj);
}
