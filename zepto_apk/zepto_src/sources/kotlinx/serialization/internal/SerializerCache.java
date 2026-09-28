package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;

@Metadata
/* loaded from: classes3.dex */
public interface SerializerCache<T> {
    KSerializer a(KClass kClass);
}
