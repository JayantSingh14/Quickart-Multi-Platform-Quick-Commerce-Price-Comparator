package com.zeptonow.horizon.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorImpl;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.SerialDescriptorsKt$buildClassSerialDescriptor$1;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.InlineClassDescriptor;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonEncoder;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;
import kotlinx.serialization.json.internal.JsonDecodingException;
import kotlinx.serialization.json.internal.StringJsonLexer;
import kotlinx.serialization.json.internal.StringOpsKt;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class AnyValueSerializer implements KSerializer<Object> {

    /* renamed from: a, reason: collision with root package name */
    public static final AnyValueSerializer f48230a = new AnyValueSerializer();

    /* renamed from: b, reason: collision with root package name */
    public static final SerialDescriptorImpl f48231b = SerialDescriptorsKt.b("Any", new SerialDescriptor[0], SerialDescriptorsKt$buildClassSerialDescriptor$1.f55761c);

    /* JADX WARN: Multi-variable type inference failed */
    public static Serializable e(JsonElement jsonElement) {
        if (jsonElement instanceof JsonNull) {
            return "";
        }
        if (!(jsonElement instanceof JsonPrimitive)) {
            if (jsonElement instanceof JsonObject) {
                Map map = (Map) jsonElement;
                LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.f(map.size()));
                for (Map.Entry entry : map.entrySet()) {
                    linkedHashMap.put(entry.getKey(), e((JsonElement) entry.getValue()));
                }
                return linkedHashMap;
            }
            if (!(jsonElement instanceof JsonArray)) {
                throw new NoWhenBranchMatchedException();
            }
            Iterable iterable = (Iterable) jsonElement;
            ArrayList arrayList = new ArrayList(CollectionsKt.r(iterable, 10));
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                arrayList.add(e((JsonElement) it.next()));
            }
            return arrayList;
        }
        JsonPrimitive jsonPrimitive = (JsonPrimitive) jsonElement;
        if (jsonPrimitive.d()) {
            return jsonPrimitive.b();
        }
        InlineClassDescriptor inlineClassDescriptor = JsonElementKt.f55977a;
        Intrinsics.checkNotNullParameter(jsonPrimitive, "<this>");
        String strB = jsonPrimitive.b();
        String[] strArr = StringOpsKt.f56105a;
        Intrinsics.checkNotNullParameter(strB, "<this>");
        Serializable serializableValueOf = null;
        if ((StringsKt.t(strB, "true", true) ? Boolean.TRUE : StringsKt.t(strB, "false", true) ? Boolean.FALSE : null) == null) {
            Intrinsics.checkNotNullParameter(jsonPrimitive, "<this>");
            try {
                serializableValueOf = Long.valueOf(new StringJsonLexer(jsonPrimitive.b()).i());
            } catch (JsonDecodingException unused) {
            }
            if (serializableValueOf != null) {
                return Long.valueOf(JsonElementKt.f(jsonPrimitive));
            }
            Intrinsics.checkNotNullParameter(jsonPrimitive, "<this>");
            if (StringsKt.Y(jsonPrimitive.b()) == null) {
                return jsonPrimitive.b();
            }
            Intrinsics.checkNotNullParameter(jsonPrimitive, "<this>");
            return Double.valueOf(Double.parseDouble(jsonPrimitive.b()));
        }
        Intrinsics.checkNotNullParameter(jsonPrimitive, "<this>");
        String strB2 = jsonPrimitive.b();
        Intrinsics.checkNotNullParameter(strB2, "<this>");
        if (StringsKt.t(strB2, "true", true)) {
            serializableValueOf = Boolean.TRUE;
        } else if (StringsKt.t(strB2, "false", true)) {
            serializableValueOf = Boolean.FALSE;
        }
        if (serializableValueOf != null) {
            return serializableValueOf;
        }
        throw new IllegalStateException(jsonPrimitive + " does not represent a Boolean");
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor a() {
        return f48231b;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object b(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        if (decoder instanceof JsonDecoder) {
            return e(((JsonDecoder) decoder).j());
        }
        throw new SerializationException("This serializer only works with Json");
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void c(Encoder encoder, Object value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        if (!(encoder instanceof JsonEncoder)) {
            throw new SerializationException("This serializer only works with Json");
        }
        ((JsonEncoder) encoder).z(SerializationUtilsKt.a(value));
    }
}
