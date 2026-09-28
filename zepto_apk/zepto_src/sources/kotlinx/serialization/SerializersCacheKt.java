package kotlinx.serialization;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.internal.CachingKt;
import kotlinx.serialization.internal.ParametrizedSerializerCache;
import kotlinx.serialization.internal.SerializerCache;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class SerializersCacheKt {

    /* renamed from: a, reason: collision with root package name */
    public static final SerializerCache f55708a = CachingKt.a(SerializersCacheKt$SERIALIZERS_CACHE$1.f55716c);

    /* renamed from: b, reason: collision with root package name */
    public static final SerializerCache f55709b = CachingKt.a(SerializersCacheKt$SERIALIZERS_CACHE_NULLABLE$1.f55717c);

    /* renamed from: c, reason: collision with root package name */
    public static final ParametrizedSerializerCache f55710c = CachingKt.b(SerializersCacheKt$PARAMETRIZED_SERIALIZERS_CACHE$1.f55712c);

    /* renamed from: d, reason: collision with root package name */
    public static final ParametrizedSerializerCache f55711d = CachingKt.b(SerializersCacheKt$PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE$1.f55714c);
}
