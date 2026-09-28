package kotlinx.serialization.json.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;

@Metadata
/* loaded from: classes3.dex */
final class JsonTreeMapDecoder extends JsonTreeDecoder {

    /* renamed from: k, reason: collision with root package name */
    public final JsonObject f56066k;

    /* renamed from: l, reason: collision with root package name */
    public final List f56067l;

    /* renamed from: m, reason: collision with root package name */
    public final int f56068m;
    public int n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsonTreeMapDecoder(Json json, JsonObject value) {
        super(json, value, null, null);
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(value, "value");
        this.f56066k = value;
        List listE0 = CollectionsKt.e0(value.f55996a.keySet());
        this.f56067l = listE0;
        this.f56068m = listE0.size() * 2;
        this.n = -1;
    }

    @Override // kotlinx.serialization.json.internal.JsonTreeDecoder, kotlinx.serialization.internal.NamedValueDecoder
    public final String U(SerialDescriptor descriptor, int i2) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return (String) this.f56067l.get(i2 / 2);
    }

    @Override // kotlinx.serialization.json.internal.JsonTreeDecoder, kotlinx.serialization.json.internal.AbstractJsonTreeDecoder
    public final JsonElement W(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        return this.n % 2 == 0 ? JsonElementKt.b(tag) : (JsonElement) MapsKt.d(tag, this.f56066k);
    }

    @Override // kotlinx.serialization.json.internal.JsonTreeDecoder, kotlinx.serialization.json.internal.AbstractJsonTreeDecoder
    public final JsonElement Z() {
        return this.f56066k;
    }

    @Override // kotlinx.serialization.json.internal.JsonTreeDecoder
    /* renamed from: b0 */
    public final JsonObject Z() {
        return this.f56066k;
    }

    @Override // kotlinx.serialization.json.internal.JsonTreeDecoder, kotlinx.serialization.json.internal.AbstractJsonTreeDecoder, kotlinx.serialization.internal.TaggedDecoder, kotlinx.serialization.encoding.CompositeDecoder
    public final void c(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
    }

    @Override // kotlinx.serialization.json.internal.JsonTreeDecoder, kotlinx.serialization.encoding.CompositeDecoder
    public final int o(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        int i2 = this.n;
        if (i2 >= this.f56068m - 1) {
            return -1;
        }
        int i3 = i2 + 1;
        this.n = i3;
        return i3;
    }
}
