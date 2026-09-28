package kotlinx.serialization.internal;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.reflect.KClass;

@Metadata
/* loaded from: classes3.dex */
public interface ParametrizedSerializerCache<T> {

    @Metadata
    public static final class DefaultImpls {
    }

    Object a(KClass kClass, ArrayList arrayList);
}
