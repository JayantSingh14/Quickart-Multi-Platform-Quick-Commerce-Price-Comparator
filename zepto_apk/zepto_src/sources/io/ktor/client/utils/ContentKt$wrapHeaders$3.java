package io.ktor.client.utils;

import io.ktor.http.ContentType;
import io.ktor.http.Headers;
import io.ktor.http.content.OutgoingContent;
import io.ktor.utils.io.ByteWriteChannel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata
/* loaded from: classes3.dex */
public final class ContentKt$wrapHeaders$3 extends OutgoingContent.WriteChannelContent {
    @Override // io.ktor.http.content.OutgoingContent
    public final Long a() {
        throw null;
    }

    @Override // io.ktor.http.content.OutgoingContent
    public final ContentType b() {
        throw null;
    }

    @Override // io.ktor.http.content.OutgoingContent
    public final Headers c() {
        return null;
    }

    @Override // io.ktor.http.content.OutgoingContent.WriteChannelContent
    public final Object d(ByteWriteChannel byteWriteChannel, Continuation continuation) {
        throw null;
    }
}
