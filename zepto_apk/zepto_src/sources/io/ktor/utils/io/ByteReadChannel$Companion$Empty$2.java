package io.ktor.utils.io;

import io.ktor.utils.io.internal.ObjectPoolKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class ByteReadChannel$Companion$Empty$2 extends Lambda implements Function0<ByteChannel> {

    /* renamed from: c, reason: collision with root package name */
    public static final ByteReadChannel$Companion$Empty$2 f51077c = new ByteReadChannel$Companion$Empty$2(0);

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        ByteBufferChannel byteBufferChannel = new ByteBufferChannel(false, ObjectPoolKt.f51248c, 8);
        ByteWriteChannelKt.a(byteBufferChannel);
        return byteBufferChannel;
    }
}
