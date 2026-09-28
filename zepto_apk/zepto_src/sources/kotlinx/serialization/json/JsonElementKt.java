package kotlinx.serialization.json;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.internal.InlineClassDescriptor;
import kotlinx.serialization.internal.InlineClassDescriptorKt;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.internal.JsonDecodingException;
import kotlinx.serialization.json.internal.StringJsonLexer;
import org.xbill.DNS.TTL;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class JsonElementKt {

    /* renamed from: a, reason: collision with root package name */
    public static final InlineClassDescriptor f55977a;

    static {
        BuiltinSerializersKt.d(StringCompanionObject.f53805a);
        f55977a = InlineClassDescriptorKt.a("kotlinx.serialization.json.JsonUnquotedLiteral", StringSerializer.f55902a);
    }

    public static final JsonPrimitive a(Number number) {
        return number == null ? JsonNull.INSTANCE : new JsonLiteral(number, false, null);
    }

    public static final JsonPrimitive b(String str) {
        return str == null ? JsonNull.INSTANCE : new JsonLiteral(str, true, null);
    }

    public static final void c(String str, JsonElement jsonElement) {
        throw new IllegalArgumentException("Element " + Reflection.a(jsonElement.getClass()) + " is not a " + str);
    }

    public static final int d(JsonPrimitive jsonPrimitive) {
        Intrinsics.checkNotNullParameter(jsonPrimitive, "<this>");
        try {
            long jI = new StringJsonLexer(jsonPrimitive.b()).i();
            if (-2147483648L <= jI && jI <= TTL.MAX_VALUE) {
                return (int) jI;
            }
            throw new NumberFormatException(jsonPrimitive.b() + " is not an Int");
        } catch (JsonDecodingException e2) {
            throw new NumberFormatException(e2.getMessage());
        }
    }

    public static final JsonObject e(JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(jsonElement, "<this>");
        JsonObject jsonObject = jsonElement instanceof JsonObject ? (JsonObject) jsonElement : null;
        if (jsonObject != null) {
            return jsonObject;
        }
        c("JsonObject", jsonElement);
        throw null;
    }

    public static final long f(JsonPrimitive jsonPrimitive) {
        Intrinsics.checkNotNullParameter(jsonPrimitive, "<this>");
        try {
            return new StringJsonLexer(jsonPrimitive.b()).i();
        } catch (JsonDecodingException e2) {
            throw new NumberFormatException(e2.getMessage());
        }
    }
}
