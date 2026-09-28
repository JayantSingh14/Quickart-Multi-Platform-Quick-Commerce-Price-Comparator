package com.chuckerteam.chucker.internal.support;

import com.chuckerteam.chucker.api.BodyDecoder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.ByteString;

@Metadata
/* loaded from: classes3.dex */
public final class PlainTextDecoder implements BodyDecoder {

    /* renamed from: a, reason: collision with root package name */
    public static final PlainTextDecoder f16788a = new PlainTextDecoder();

    /* JADX WARN: Removed duplicated region for block: B:10:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String c(okio.ByteString r9, okhttp3.Headers r10, okhttp3.MediaType r11) {
        /*
            java.util.List r0 = com.chuckerteam.chucker.internal.support.OkHttpUtilsKt.f16784a
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r1 = "Content-Encoding"
            java.lang.String r10 = r10.d(r1)
            r1 = 0
            r2 = 1
            if (r10 == 0) goto L32
            int r3 = r10.length()
            if (r3 <= 0) goto L18
            goto L19
        L18:
            r10 = r1
        L19:
            if (r10 == 0) goto L32
            java.util.Locale r3 = java.util.Locale.ROOT
            java.lang.String r4 = "ROOT"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            java.lang.String r10 = r10.toLowerCase(r3)
            java.lang.String r3 = "toLowerCase(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r3)
            java.util.List r3 = com.chuckerteam.chucker.internal.support.OkHttpUtilsKt.f16784a
            boolean r10 = r3.contains(r10)
            goto L33
        L32:
            r10 = r2
        L33:
            if (r10 == 0) goto Lb5
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            int r10 = r9.d()
            r3 = 64
            int r10 = java.lang.Math.min(r10, r3)
            okio.Buffer r3 = new okio.Buffer
            r3.<init>()
            java.lang.String r4 = "byteString"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r4)
            r9.A(r3, r10)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            okio.Buffer r4 = new okio.Buffer     // Catch: java.io.EOFException -> La2
            r4.<init>()     // Catch: java.io.EOFException -> La2
            long r5 = r3.f56914b     // Catch: java.io.EOFException -> La2
            r7 = 64
            long r7 = java.lang.Math.min(r5, r7)     // Catch: java.io.EOFException -> La2
            r5 = 0
            r3.e(r4, r5, r7)     // Catch: java.io.EOFException -> La2
            com.chuckerteam.chucker.internal.support.OkioUtilsKt$isProbablyPlainText$1 r10 = new com.chuckerteam.chucker.internal.support.OkioUtilsKt$isProbablyPlainText$1     // Catch: java.io.EOFException -> La2
            r10.<init>(r4, r1)     // Catch: java.io.EOFException -> La2
            kotlin.sequences.SequencesKt__SequenceBuilderKt$sequence$$inlined$Sequence$1 r10 = kotlin.sequences.SequencesKt.o(r10)     // Catch: java.io.EOFException -> La2
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)     // Catch: java.io.EOFException -> La2
            boolean r0 = r10 instanceof kotlin.sequences.DropTakeSequence     // Catch: java.io.EOFException -> La2
            if (r0 == 0) goto L7b
            kotlin.sequences.DropTakeSequence r10 = (kotlin.sequences.DropTakeSequence) r10     // Catch: java.io.EOFException -> La2
            kotlin.sequences.Sequence r10 = r10.take()     // Catch: java.io.EOFException -> La2
            goto L81
        L7b:
            kotlin.sequences.TakeSequence r0 = new kotlin.sequences.TakeSequence     // Catch: java.io.EOFException -> La2
            r0.<init>(r10)     // Catch: java.io.EOFException -> La2
            r10 = r0
        L81:
            java.util.Iterator r10 = r10.iterator()     // Catch: java.io.EOFException -> La2
        L85:
            boolean r0 = r10.hasNext()     // Catch: java.io.EOFException -> La2
            if (r0 == 0) goto La3
            java.lang.Object r0 = r10.next()     // Catch: java.io.EOFException -> La2
            java.lang.Number r0 = (java.lang.Number) r0     // Catch: java.io.EOFException -> La2
            int r0 = r0.intValue()     // Catch: java.io.EOFException -> La2
            boolean r3 = java.lang.Character.isWhitespace(r0)     // Catch: java.io.EOFException -> La2
            if (r3 != 0) goto L85
            boolean r0 = java.lang.Character.isISOControl(r0)     // Catch: java.io.EOFException -> La2
            if (r0 != 0) goto La2
            goto L85
        La2:
            r2 = 0
        La3:
            if (r2 == 0) goto Lb5
            if (r11 == 0) goto Laf
            java.util.regex.Pattern r10 = okhttp3.MediaType.f56278d
            java.nio.charset.Charset r10 = r11.a(r1)
            if (r10 != 0) goto Lb1
        Laf:
            java.nio.charset.Charset r10 = kotlin.text.Charsets.UTF_8
        Lb1:
            java.lang.String r1 = r9.s(r10)
        Lb5:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chuckerteam.chucker.internal.support.PlainTextDecoder.c(okio.ByteString, okhttp3.Headers, okhttp3.MediaType):java.lang.String");
    }

    @Override // com.chuckerteam.chucker.api.BodyDecoder
    public final String a(Request request, ByteString body) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(body, "body");
        Headers headers = request.f56333c;
        RequestBody requestBody = request.f56334d;
        return c(body, headers, requestBody != null ? requestBody.contentType() : null);
    }

    @Override // com.chuckerteam.chucker.api.BodyDecoder
    public final String b(Response response, ByteString body) {
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(body, "body");
        Headers headers = response.f56355f;
        ResponseBody responseBody = response.f56356g;
        return c(body, headers, responseBody != null ? responseBody.l() : null);
    }
}
