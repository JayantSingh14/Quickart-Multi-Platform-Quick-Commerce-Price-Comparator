package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.internal.ElementMarker;

@Metadata
/* loaded from: classes.dex */
public final class JsonElementMarker {

    /* renamed from: a, reason: collision with root package name */
    public final ElementMarker f56041a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f56042b;

    public JsonElementMarker(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        this.f56041a = new ElementMarker(descriptor, new JsonElementMarker$origin$1(2, this, JsonElementMarker.class, "readIfAbsent", "readIfAbsent(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Z", 0));
    }
}
