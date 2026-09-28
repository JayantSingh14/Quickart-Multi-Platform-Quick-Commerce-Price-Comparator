package kotlinx.serialization.json;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.internal.StringOpsKt;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class JsonLiteral extends JsonPrimitive {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f55987a;

    /* renamed from: b, reason: collision with root package name */
    public final SerialDescriptor f55988b;

    /* renamed from: c, reason: collision with root package name */
    public final String f55989c;

    public JsonLiteral(Serializable body, boolean z, SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(body, "body");
        this.f55987a = z;
        this.f55988b = serialDescriptor;
        this.f55989c = body.toString();
        if (serialDescriptor != null && !serialDescriptor.isInline()) {
            throw new IllegalArgumentException("Failed requirement.");
        }
    }

    @Override // kotlinx.serialization.json.JsonPrimitive
    public final String b() {
        return this.f55989c;
    }

    @Override // kotlinx.serialization.json.JsonPrimitive
    public final boolean d() {
        return this.f55987a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || JsonLiteral.class != obj.getClass()) {
            return false;
        }
        JsonLiteral jsonLiteral = (JsonLiteral) obj;
        return this.f55987a == jsonLiteral.f55987a && Intrinsics.b(this.f55989c, jsonLiteral.f55989c);
    }

    public final int hashCode() {
        return this.f55989c.hashCode() + (Boolean.hashCode(this.f55987a) * 31);
    }

    @Override // kotlinx.serialization.json.JsonPrimitive
    public final String toString() {
        boolean z = this.f55987a;
        String str = this.f55989c;
        if (!z) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        StringOpsKt.a(sb, str);
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
