package io.ktor.client.content;

import io.ktor.http.ContentType;
import io.ktor.http.content.OutgoingContent;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;

@Metadata
/* loaded from: classes3.dex */
public final class LocalFileContent extends OutgoingContent.ReadChannelContent {
    @Override // io.ktor.http.content.OutgoingContent
    public final Long a() {
        throw null;
    }

    @Override // io.ktor.http.content.OutgoingContent
    public final ContentType b() {
        return null;
    }

    @Override // io.ktor.http.content.OutgoingContent.ReadChannelContent
    public final ByteReadChannel d() {
        DefaultScheduler defaultScheduler = Dispatchers.f54091a;
        DefaultIoScheduler coroutineContext = DefaultIoScheduler.f55150b;
        Intrinsics.checkNotNullParameter(null, "<this>");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        throw null;
    }
}
