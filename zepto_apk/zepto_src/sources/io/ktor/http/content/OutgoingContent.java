package io.ktor.http.content;

import io.ktor.http.ContentType;
import io.ktor.http.EmptyHeaders;
import io.ktor.http.Headers;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public abstract class OutgoingContent {

    @Metadata
    public static abstract class ByteArrayContent extends OutgoingContent {
        public abstract byte[] d();
    }

    @Metadata
    public static abstract class NoContent extends OutgoingContent {
    }

    @Metadata
    /* loaded from: classes3.dex */
    public static abstract class ProtocolUpgrade extends OutgoingContent {
    }

    @Metadata
    /* loaded from: classes3.dex */
    public static abstract class ReadChannelContent extends OutgoingContent {
        public abstract ByteReadChannel d();
    }

    @Metadata
    /* loaded from: classes3.dex */
    public static abstract class WriteChannelContent extends OutgoingContent {
        public abstract Object d(ByteWriteChannel byteWriteChannel, Continuation continuation);
    }

    public Long a() {
        return null;
    }

    public ContentType b() {
        return null;
    }

    public Headers c() {
        Headers.f50200a.getClass();
        return EmptyHeaders.f50185d;
    }
}
