package kotlinx.serialization.json.internal;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.descriptors.SerialDescriptor;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class DescriptorSchemaCache {

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f56038a = new ConcurrentHashMap(16);

    @Metadata
    public static final class Key<T> {
    }

    public final Object a(SerialDescriptor descriptor, Key key) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(key, "key");
        Map map = (Map) this.f56038a.get(descriptor);
        Object obj = map != null ? map.get(key) : null;
        if (obj == null) {
            return null;
        }
        return obj;
    }
}
