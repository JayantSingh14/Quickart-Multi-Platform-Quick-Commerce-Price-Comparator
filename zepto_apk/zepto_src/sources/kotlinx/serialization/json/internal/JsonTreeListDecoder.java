package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;

@Metadata
/* loaded from: classes3.dex */
final class JsonTreeListDecoder extends AbstractJsonTreeDecoder {

    /* renamed from: f, reason: collision with root package name */
    public final JsonArray f56062f;

    /* renamed from: g, reason: collision with root package name */
    public final int f56063g;

    /* renamed from: h, reason: collision with root package name */
    public int f56064h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsonTreeListDecoder(Json json, JsonArray value) {
        super(json, value);
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(value, "value");
        this.f56062f = value;
        this.f56063g = value.f55948a.size();
        this.f56064h = -1;
    }

    @Override // kotlinx.serialization.internal.NamedValueDecoder
    public final String U(SerialDescriptor descriptor, int i2) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return String.valueOf(i2);
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonTreeDecoder
    public final JsonElement W(String tag) throws NumberFormatException {
        Intrinsics.checkNotNullParameter(tag, "tag");
        return (JsonElement) this.f56062f.f55948a.get(Integer.parseInt(tag));
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonTreeDecoder
    public final JsonElement Z() {
        return this.f56062f;
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public final int o(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        int i2 = this.f56064h;
        if (i2 >= this.f56063g - 1) {
            return -1;
        }
        int i3 = i2 + 1;
        this.f56064h = i3;
        return i3;
    }
}
