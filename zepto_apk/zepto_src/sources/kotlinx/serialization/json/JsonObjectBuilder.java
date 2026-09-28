package kotlinx.serialization.json;

import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.internal.Intrinsics;

@Metadata
@JsonDslMarker
/* loaded from: classes.dex */
public final class JsonObjectBuilder {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f55998a = new LinkedHashMap();

    @PublishedApi
    public JsonObjectBuilder() {
    }

    public final void a(String key, JsonPrimitive element) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(element, "element");
    }
}
