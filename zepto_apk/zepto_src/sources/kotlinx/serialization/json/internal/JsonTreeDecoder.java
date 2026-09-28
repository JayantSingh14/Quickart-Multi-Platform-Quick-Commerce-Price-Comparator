package kotlinx.serialization.json.internal;

import android.support.v4.media.b;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.EmptySet;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.internal.InlineClassDescriptor;
import kotlinx.serialization.internal.Platform_commonKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;
import kotlinx.serialization.json.JsonSchemaCacheKt;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
class JsonTreeDecoder extends AbstractJsonTreeDecoder {

    /* renamed from: f, reason: collision with root package name */
    public final JsonObject f56056f;

    /* renamed from: g, reason: collision with root package name */
    public final String f56057g;

    /* renamed from: h, reason: collision with root package name */
    public final SerialDescriptor f56058h;

    /* renamed from: i, reason: collision with root package name */
    public int f56059i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f56060j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsonTreeDecoder(Json json, JsonObject value, String str, SerialDescriptor serialDescriptor) {
        super(json, value);
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(value, "value");
        this.f56056f = value;
        this.f56057g = str;
        this.f56058h = serialDescriptor;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonTreeDecoder, kotlinx.serialization.internal.TaggedDecoder, kotlinx.serialization.encoding.Decoder
    public final boolean A() {
        return !this.f56060j && super.A();
    }

    @Override // kotlinx.serialization.internal.NamedValueDecoder
    public String U(SerialDescriptor descriptor, int i2) {
        Object next;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Json json = this.f56010c;
        JsonNamesMapKt.e(descriptor, json);
        String strF = descriptor.f(i2);
        if (this.f56012e.f55975j && !Z().f55996a.keySet().contains(strF)) {
            Map mapA = JsonNamesMapKt.a(descriptor, json);
            Iterator it = Z().f55996a.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                Integer num = (Integer) mapA.get((String) next);
                if (num != null && num.intValue() == i2) {
                    break;
                }
            }
            String str = (String) next;
            if (str != null) {
                return str;
            }
        }
        return strF;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonTreeDecoder
    public JsonElement W(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        return (JsonElement) MapsKt.d(tag, Z());
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonTreeDecoder, kotlinx.serialization.internal.TaggedDecoder, kotlinx.serialization.encoding.Decoder
    public final CompositeDecoder b(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        SerialDescriptor serialDescriptor = this.f56058h;
        if (descriptor != serialDescriptor) {
            return super.b(descriptor);
        }
        JsonElement jsonElementX = X();
        if (jsonElementX instanceof JsonObject) {
            return new JsonTreeDecoder(this.f56010c, (JsonObject) jsonElementX, this.f56057g, serialDescriptor);
        }
        throw JsonExceptionsKt.c(-1, "Expected " + Reflection.a(JsonObject.class) + " as the serialized body of " + serialDescriptor.i() + ", but had " + Reflection.a(jsonElementX.getClass()));
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonTreeDecoder
    /* renamed from: b0, reason: merged with bridge method [inline-methods] */
    public JsonObject Z() {
        return this.f56056f;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonTreeDecoder, kotlinx.serialization.internal.TaggedDecoder, kotlinx.serialization.encoding.CompositeDecoder
    public void c(SerialDescriptor descriptor) {
        Set setD;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        JsonConfiguration jsonConfiguration = this.f56012e;
        if (jsonConfiguration.f55967b || (descriptor.d() instanceof PolymorphicKind)) {
            return;
        }
        Json json = this.f56010c;
        JsonNamesMapKt.e(descriptor, json);
        if (jsonConfiguration.f55975j) {
            Intrinsics.checkNotNullParameter(descriptor, "<this>");
            Set setA = Platform_commonKt.a(descriptor);
            Map map = (Map) JsonSchemaCacheKt.a(json).a(descriptor, JsonNamesMapKt.f56045a);
            Set setKeySet = map != null ? map.keySet() : null;
            if (setKeySet == null) {
                setKeySet = EmptySet.f53611a;
            }
            setD = SetsKt.d(setA, setKeySet);
        } else {
            Intrinsics.checkNotNullParameter(descriptor, "<this>");
            setD = Platform_commonKt.a(descriptor);
        }
        for (String key : Z().f55996a.keySet()) {
            if (!setD.contains(key) && !Intrinsics.b(key, this.f56057g)) {
                String input = Z().toString();
                Intrinsics.checkNotNullParameter(key, "key");
                Intrinsics.checkNotNullParameter(input, "input");
                StringBuilder sbY = b.y("Encountered an unknown key '", key, "'.\nUse 'ignoreUnknownKeys = true' in 'Json {}' builder to ignore unknown keys.\nCurrent input: ");
                sbY.append((Object) JsonExceptionsKt.g(input, -1));
                throw JsonExceptionsKt.c(-1, sbY.toString());
            }
        }
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public int o(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        while (this.f56059i < descriptor.e()) {
            int i2 = this.f56059i;
            this.f56059i = i2 + 1;
            String strR = R(descriptor, i2);
            int i3 = this.f56059i - 1;
            boolean z = false;
            this.f56060j = false;
            boolean zContainsKey = Z().containsKey(strR);
            Json json = this.f56010c;
            if (!zContainsKey) {
                if (!json.f55945a.f55970e && !descriptor.j(i3) && descriptor.h(i3).b()) {
                    z = true;
                }
                this.f56060j = z;
                if (!z) {
                    continue;
                }
            }
            if (this.f56012e.f55972g && descriptor.j(i3)) {
                SerialDescriptor serialDescriptorH = descriptor.h(i3);
                if (serialDescriptorH.b() || !(W(strR) instanceof JsonNull)) {
                    if (Intrinsics.b(serialDescriptorH.d(), SerialKind.ENUM.f55764a) && (!serialDescriptorH.b() || !(W(strR) instanceof JsonNull))) {
                        JsonElement jsonElementW = W(strR);
                        String strB = null;
                        JsonPrimitive jsonPrimitive = jsonElementW instanceof JsonPrimitive ? (JsonPrimitive) jsonElementW : null;
                        if (jsonPrimitive != null) {
                            InlineClassDescriptor inlineClassDescriptor = JsonElementKt.f55977a;
                            Intrinsics.checkNotNullParameter(jsonPrimitive, "<this>");
                            if (!(jsonPrimitive instanceof JsonNull)) {
                                strB = jsonPrimitive.b();
                            }
                        }
                        if (strB != null && JsonNamesMapKt.c(serialDescriptorH, json, strB) == -3) {
                        }
                    }
                }
            }
            return i3;
        }
        return -1;
    }
}
