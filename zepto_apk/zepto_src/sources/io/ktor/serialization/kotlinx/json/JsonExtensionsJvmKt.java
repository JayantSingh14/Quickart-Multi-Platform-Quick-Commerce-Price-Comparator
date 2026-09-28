package io.ktor.serialization.kotlinx.json;

import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import kotlinx.serialization.json.Json;

@Metadata
/* loaded from: classes3.dex */
public final class JsonExtensionsJvmKt {
    public static final Object a(TypeInfo typeInfo, ByteReadChannel byteReadChannel, Continuation continuation, Json json) {
        DefaultScheduler defaultScheduler = Dispatchers.f54091a;
        return BuildersKt.e(DefaultIoScheduler.f55150b, new JsonExtensionsJvmKt$deserializeSequence$2(typeInfo, byteReadChannel, null, json), continuation);
    }
}
