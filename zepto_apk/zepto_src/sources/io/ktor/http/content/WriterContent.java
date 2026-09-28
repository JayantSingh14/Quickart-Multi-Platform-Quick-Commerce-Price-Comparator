package io.ktor.http.content;

import io.ktor.http.ContentType;
import io.ktor.http.ContentTypesKt;
import io.ktor.http.content.OutgoingContent;
import io.ktor.utils.io.ByteWriteChannel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata
/* loaded from: classes3.dex */
public final class WriterContent extends OutgoingContent.WriteChannelContent {
    @Override // io.ktor.http.content.OutgoingContent
    public final Long a() {
        return null;
    }

    @Override // io.ktor.http.content.OutgoingContent
    public final ContentType b() {
        return null;
    }

    @Override // io.ktor.http.content.OutgoingContent.WriteChannelContent
    public final Object d(ByteWriteChannel byteWriteChannel, Continuation continuation) {
        ContentTypesKt.a(null);
        throw null;
    }
}
