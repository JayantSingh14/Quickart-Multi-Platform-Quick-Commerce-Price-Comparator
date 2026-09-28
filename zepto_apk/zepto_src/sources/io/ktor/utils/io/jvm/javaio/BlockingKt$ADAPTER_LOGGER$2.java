package io.ktor.utils.io.jvm.javaio;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Metadata
/* loaded from: classes3.dex */
public final class BlockingKt$ADAPTER_LOGGER$2 extends Lambda implements Function0<Logger> {

    /* renamed from: c, reason: collision with root package name */
    public static final BlockingKt$ADAPTER_LOGGER$2 f51310c = new BlockingKt$ADAPTER_LOGGER$2(0);

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return LoggerFactory.b(BlockingAdapter.class);
    }
}
