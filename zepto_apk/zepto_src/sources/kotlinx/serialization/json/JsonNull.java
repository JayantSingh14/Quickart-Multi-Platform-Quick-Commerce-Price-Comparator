package kotlinx.serialization.json;

import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import org.jetbrains.annotations.NotNull;

@Metadata
@Serializable(with = JsonNullSerializer.class)
/* loaded from: classes.dex */
public final class JsonNull extends JsonPrimitive {

    @NotNull
    public static final JsonNull INSTANCE = new JsonNull();

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Object f55992a = LazyKt.a(LazyThreadSafetyMode.f53529b, AnonymousClass1.f55993c);

    @Metadata
    /* renamed from: kotlinx.serialization.json.JsonNull$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<KSerializer<Object>> {

        /* renamed from: c, reason: collision with root package name */
        public static final AnonymousClass1 f55993c = new AnonymousClass1(0);

        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return JsonNullSerializer.f55994a;
        }
    }

    @Override // kotlinx.serialization.json.JsonPrimitive
    public final String b() {
        return "null";
    }

    @Override // kotlinx.serialization.json.JsonPrimitive
    public final boolean d() {
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, kotlin.Lazy] */
    @NotNull
    public final KSerializer<JsonNull> serializer() {
        return (KSerializer) f55992a.getValue();
    }
}
