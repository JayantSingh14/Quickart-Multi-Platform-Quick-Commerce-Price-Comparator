package io.ktor.utils.io.jvm.javaio;

import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

@Metadata
/* loaded from: classes3.dex */
public final class BlockingKt {

    /* renamed from: a, reason: collision with root package name */
    public static final Lazy f51307a = LazyKt.b(BlockingKt$ADAPTER_LOGGER$2.f51310c);

    /* renamed from: b, reason: collision with root package name */
    public static final Object f51308b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public static final Object f51309c = new Object();

    public static final InputStream a(ByteReadChannel byteReadChannel, Job job) {
        Intrinsics.checkNotNullParameter(byteReadChannel, "<this>");
        return new InputAdapter(byteReadChannel, job);
    }

    public static OutputStream b(ByteWriteChannel byteWriteChannel) {
        Intrinsics.checkNotNullParameter(byteWriteChannel, "<this>");
        return new OutputAdapter(byteWriteChannel);
    }
}
