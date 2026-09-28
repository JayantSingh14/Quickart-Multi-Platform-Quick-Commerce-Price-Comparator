package kotlinx.serialization.json.internal;

import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonArraySerializer;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectSerializer;
import kotlinx.serialization.json.JsonPrimitive;

@Metadata
/* loaded from: classes3.dex */
final class JsonTreeMapEncoder extends JsonTreeEncoder {

    /* renamed from: g, reason: collision with root package name */
    public String f56069g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f56070h;

    @Override // kotlinx.serialization.json.internal.JsonTreeEncoder, kotlinx.serialization.json.internal.AbstractJsonTreeEncoder
    public final JsonElement Y() {
        return new JsonObject(this.f56061f);
    }

    @Override // kotlinx.serialization.json.internal.JsonTreeEncoder, kotlinx.serialization.json.internal.AbstractJsonTreeEncoder
    public final void Z(String key, JsonElement element) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(element, "element");
        if (!this.f56070h) {
            LinkedHashMap linkedHashMap = this.f56061f;
            String str = this.f56069g;
            if (str == null) {
                Intrinsics.h("tag");
                throw null;
            }
            linkedHashMap.put(str, element);
            this.f56070h = true;
            return;
        }
        if (element instanceof JsonPrimitive) {
            this.f56069g = ((JsonPrimitive) element).b();
            this.f56070h = false;
        } else {
            if (element instanceof JsonObject) {
                throw JsonExceptionsKt.b(JsonObjectSerializer.f56000b);
            }
            if (!(element instanceof JsonArray)) {
                throw new NoWhenBranchMatchedException();
            }
            throw JsonExceptionsKt.b(JsonArraySerializer.f55950b);
        }
    }
}
