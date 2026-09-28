package io.ktor.http.content;

import io.ktor.http.ContentType;
import io.ktor.http.content.OutgoingContent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class ByteArrayContent extends OutgoingContent.ByteArrayContent {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f50285a;

    /* renamed from: b, reason: collision with root package name */
    public final ContentType f50286b;

    public ByteArrayContent(byte[] bytes, ContentType contentType) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        this.f50285a = bytes;
        this.f50286b = contentType;
    }

    @Override // io.ktor.http.content.OutgoingContent
    public final Long a() {
        return Long.valueOf(this.f50285a.length);
    }

    @Override // io.ktor.http.content.OutgoingContent
    public final ContentType b() {
        return this.f50286b;
    }

    @Override // io.ktor.http.content.OutgoingContent.ByteArrayContent
    public final byte[] d() {
        return this.f50285a;
    }
}
