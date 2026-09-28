package kotlinx.serialization.json;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.json.internal.StringOpsKt;
import org.jetbrains.annotations.NotNull;

@Metadata
@Serializable(with = JsonObjectSerializer.class)
/* loaded from: classes.dex */
public final class JsonObject extends JsonElement implements Map<String, JsonElement>, KMappedMarker {

    @NotNull
    public static final Companion Companion = new Companion();

    /* renamed from: a, reason: collision with root package name */
    public final Map f55996a;

    @Metadata
    public static final class Companion {
        @NotNull
        public final KSerializer<JsonObject> serializer() {
            return JsonObjectSerializer.f55999a;
        }
    }

    @Metadata
    /* renamed from: kotlinx.serialization.json.JsonObject$toString$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    final class AnonymousClass1 extends Lambda implements Function1<Map.Entry<? extends String, ? extends JsonElement>, CharSequence> {

        /* renamed from: c, reason: collision with root package name */
        public static final AnonymousClass1 f55997c = new AnonymousClass1(1);

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Intrinsics.checkNotNullParameter(entry, "<name for destructuring parameter 0>");
            String str = (String) entry.getKey();
            JsonElement jsonElement = (JsonElement) entry.getValue();
            StringBuilder sb = new StringBuilder();
            StringOpsKt.a(sb, str);
            sb.append(':');
            sb.append(jsonElement);
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }
    }

    public JsonObject(Map content) {
        Intrinsics.checkNotNullParameter(content, "content");
        this.f55996a = content;
    }

    @Override // java.util.Map
    public final void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ JsonElement compute(String str, BiFunction<? super String, ? super JsonElement, ? extends JsonElement> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ JsonElement computeIfAbsent(String str, Function<? super String, ? extends JsonElement> function) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ JsonElement computeIfPresent(String str, BiFunction<? super String, ? super JsonElement, ? extends JsonElement> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        if (!(obj instanceof String)) {
            return false;
        }
        String key = (String) obj;
        Intrinsics.checkNotNullParameter(key, "key");
        return this.f55996a.containsKey(key);
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        if (!(obj instanceof JsonElement)) {
            return false;
        }
        JsonElement value = (JsonElement) obj;
        Intrinsics.checkNotNullParameter(value, "value");
        return this.f55996a.containsValue(value);
    }

    @Override // java.util.Map
    public final Set<Map.Entry<String, JsonElement>> entrySet() {
        return this.f55996a.entrySet();
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        return Intrinsics.b(this.f55996a, obj);
    }

    @Override // java.util.Map
    public final JsonElement get(Object obj) {
        if (!(obj instanceof String)) {
            return null;
        }
        String key = (String) obj;
        Intrinsics.checkNotNullParameter(key, "key");
        return (JsonElement) this.f55996a.get(key);
    }

    @Override // java.util.Map
    public final int hashCode() {
        return this.f55996a.hashCode();
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.f55996a.isEmpty();
    }

    @Override // java.util.Map
    public final Set<String> keySet() {
        return this.f55996a.keySet();
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ JsonElement merge(String str, JsonElement jsonElement, BiFunction<? super JsonElement, ? super JsonElement, ? extends JsonElement> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ JsonElement put(String str, JsonElement jsonElement) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final void putAll(Map<? extends String, ? extends JsonElement> map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ JsonElement putIfAbsent(String str, JsonElement jsonElement) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final JsonElement remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ JsonElement replace(String str, JsonElement jsonElement) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final void replaceAll(BiFunction<? super String, ? super JsonElement, ? extends JsonElement> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final int size() {
        return this.f55996a.size();
    }

    public final String toString() {
        return CollectionsKt.E(this.f55996a.entrySet(), ",", "{", "}", AnonymousClass1.f55997c, 24);
    }

    @Override // java.util.Map
    public final Collection<JsonElement> values() {
        return this.f55996a.values();
    }

    @Override // java.util.Map
    public final boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ boolean replace(String str, JsonElement jsonElement, JsonElement jsonElement2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
