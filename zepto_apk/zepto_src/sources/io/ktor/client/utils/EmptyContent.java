package io.ktor.client.utils;

import io.ktor.http.content.OutgoingContent;
import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public final class EmptyContent extends OutgoingContent.NoContent {

    /* renamed from: a, reason: collision with root package name */
    public static final EmptyContent f50113a = new EmptyContent();

    @Override // io.ktor.http.content.OutgoingContent
    public final Long a() {
        return 0L;
    }

    public final String toString() {
        return "EmptyContent";
    }
}
