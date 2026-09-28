package io.ktor.client.request.forms;

import io.ktor.utils.io.charsets.CharsetJVMKt;
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
public final class FormDataContentKt {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f50037a;

    static {
        byte[] bArrC;
        Charset charset = Charsets.UTF_8;
        if (Intrinsics.b(charset, charset)) {
            bArrC = StringsKt.q("\r\n");
        } else {
            CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
            Intrinsics.checkNotNullExpressionValue(charsetEncoderNewEncoder, "charset.newEncoder()");
            bArrC = CharsetJVMKt.c(charsetEncoderNewEncoder, "\r\n", 2);
        }
        f50037a = bArrC;
    }
}
