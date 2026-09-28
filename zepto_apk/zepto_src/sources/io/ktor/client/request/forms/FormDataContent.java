package io.ktor.client.request.forms;

import io.ktor.http.ContentType;
import io.ktor.http.content.OutgoingContent;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class FormDataContent extends OutgoingContent.ByteArrayContent {
    @Override // io.ktor.http.content.OutgoingContent
    public final Long a() {
        return 0L;
    }

    @Override // io.ktor.http.content.OutgoingContent
    public final ContentType b() {
        return null;
    }

    @Override // io.ktor.http.content.OutgoingContent.ByteArrayContent
    public final byte[] d() {
        return null;
    }
}
