package io.ktor.utils.io.jvm.javaio;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.CoroutinesKt;
import io.ktor.utils.io.pool.ByteArrayPoolKt;
import io.ktor.utils.io.pool.ByteArrayPoolKt$ByteArrayPool$1;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class ReadingKt {
    public static ByteReadChannel a(InputStream inputStream) {
        DefaultScheduler defaultScheduler = Dispatchers.f54091a;
        DefaultIoScheduler context = DefaultIoScheduler.f55150b;
        ByteArrayPoolKt$ByteArrayPool$1 pool = ByteArrayPoolKt.f51367a;
        Intrinsics.checkNotNullParameter(inputStream, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pool, "pool");
        return CoroutinesKt.a(GlobalScope.f54113a, context, true, new ReadingKt$toByteReadChannel$2(pool, inputStream, null)).t0();
    }
}
