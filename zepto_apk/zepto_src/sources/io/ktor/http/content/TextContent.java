package io.ktor.http.content;

import io.ktor.http.ContentType;
import io.ktor.http.ContentTypesKt;
import io.ktor.http.content.OutgoingContent;
import io.ktor.utils.io.charsets.CharsetJVMKt;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class TextContent extends OutgoingContent.ByteArrayContent {

    /* renamed from: a, reason: collision with root package name */
    public final String f50300a;

    /* renamed from: b, reason: collision with root package name */
    public final ContentType f50301b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f50302c;

    public TextContent(String text, ContentType contentType) throws CharacterCodingException {
        byte[] bArrC;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        this.f50300a = text;
        this.f50301b = contentType;
        Charset charsetA = ContentTypesKt.a(contentType);
        charsetA = charsetA == null ? Charsets.UTF_8 : charsetA;
        if (Intrinsics.b(charsetA, Charsets.UTF_8)) {
            bArrC = StringsKt.q(text);
        } else {
            CharsetEncoder charsetEncoderNewEncoder = charsetA.newEncoder();
            Intrinsics.checkNotNullExpressionValue(charsetEncoderNewEncoder, "charset.newEncoder()");
            bArrC = CharsetJVMKt.c(charsetEncoderNewEncoder, text, text.length());
        }
        this.f50302c = bArrC;
    }

    @Override // io.ktor.http.content.OutgoingContent
    public final Long a() {
        return Long.valueOf(this.f50302c.length);
    }

    @Override // io.ktor.http.content.OutgoingContent
    public final ContentType b() {
        return this.f50301b;
    }

    @Override // io.ktor.http.content.OutgoingContent.ByteArrayContent
    public final byte[] d() {
        return this.f50302c;
    }

    public final String toString() {
        return "TextContent[" + this.f50301b + "] \"" + StringsKt.W(30, this.f50300a) + '\"';
    }
}
