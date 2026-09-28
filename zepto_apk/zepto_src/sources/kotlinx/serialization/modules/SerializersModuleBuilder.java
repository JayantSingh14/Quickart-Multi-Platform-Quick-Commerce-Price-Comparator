package kotlinx.serialization.modules;

import com.zeptonow.horizon.utils.AnyValueSerializer;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import kotlinx.serialization.modules.ContextualProvider;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class SerializersModuleBuilder implements SerializersModuleCollector {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f56121a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f56122b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f56123c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f56124d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    public final HashMap f56125e = new HashMap();

    @PublishedApi
    public SerializersModuleBuilder() {
    }

    public final void a(KClass forClass) {
        AnyValueSerializer serializer = AnyValueSerializer.f48230a;
        Intrinsics.checkNotNullParameter(forClass, "kClass");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        AnyValueSerializer serializer2 = AnyValueSerializer.f48230a;
        Intrinsics.checkNotNullParameter(serializer2, "serializer");
        ContextualProvider.Argless provider = new ContextualProvider.Argless();
        Intrinsics.checkNotNullParameter(forClass, "forClass");
        Intrinsics.checkNotNullParameter(provider, "provider");
        HashMap map = this.f56121a;
        ContextualProvider contextualProvider = (ContextualProvider) map.get(forClass);
        if (contextualProvider == null || contextualProvider.equals(provider)) {
            map.put(forClass, provider);
            return;
        }
        throw new SerializerAlreadyRegisteredException("Contextual serializer or serializer provider for " + forClass + " already registered in this module");
    }
}
