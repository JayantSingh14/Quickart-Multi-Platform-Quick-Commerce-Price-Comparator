package kotlinx.serialization.json.internal;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;

@Metadata
/* loaded from: classes3.dex */
final class JsonTreeListEncoder extends AbstractJsonTreeEncoder {

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f56065f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsonTreeListEncoder(Json json, Function1 nodeConsumer) {
        super(json, nodeConsumer);
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(nodeConsumer, "nodeConsumer");
        this.f56065f = new ArrayList();
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonTreeEncoder, kotlinx.serialization.internal.NamedValueEncoder
    public final String X(SerialDescriptor descriptor, int i2) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return String.valueOf(i2);
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonTreeEncoder
    public final JsonElement Y() {
        return new JsonArray(this.f56065f);
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonTreeEncoder
    public final void Z(String key, JsonElement element) throws NumberFormatException {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(element, "element");
        this.f56065f.add(Integer.parseInt(key), element);
    }
}
