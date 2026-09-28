package kotlinx.serialization.json;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.DescriptorSchemaCache;

@Metadata
/* loaded from: classes3.dex */
public final class JsonSchemaCacheKt {
    public static final DescriptorSchemaCache a(Json json) {
        Intrinsics.checkNotNullParameter(json, "<this>");
        return json.f55947c;
    }
}
