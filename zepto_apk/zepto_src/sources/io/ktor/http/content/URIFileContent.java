package io.ktor.http.content;

import io.ktor.http.ContentType;
import io.ktor.http.content.OutgoingContent;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public final class URIFileContent extends OutgoingContent.ReadChannelContent {
    @Override // io.ktor.http.content.OutgoingContent
    public final Long a() {
        return null;
    }

    @Override // io.ktor.http.content.OutgoingContent
    public final ContentType b() {
        return null;
    }

    @Override // io.ktor.http.content.OutgoingContent.ReadChannelContent
    public final ByteReadChannel d() {
        throw null;
    }
}
