package kotlinx.serialization.json.internal;

import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonObject;

@Metadata
/* loaded from: classes3.dex */
class JsonTreeEncoder extends AbstractJsonTreeEncoder {

    /* renamed from: f, reason: collision with root package name */
    public final LinkedHashMap f56061f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsonTreeEncoder(Json json, Function1 nodeConsumer) {
        super(json, nodeConsumer);
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(nodeConsumer, "nodeConsumer");
        this.f56061f = new LinkedHashMap();
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonTreeEncoder
    public JsonElement Y() {
        return new JsonObject(this.f56061f);
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonTreeEncoder
    public void Z(String key, JsonElement element) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(element, "element");
        this.f56061f.put(key, element);
    }
}
