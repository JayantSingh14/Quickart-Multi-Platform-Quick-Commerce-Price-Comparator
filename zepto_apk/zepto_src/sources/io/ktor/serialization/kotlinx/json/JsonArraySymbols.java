package io.ktor.serialization.kotlinx.json;

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
final class JsonArraySymbols {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f50379a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f50380b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f50381c;

    public JsonArraySymbols(Charset charset) throws CharacterCodingException {
        byte[] bArrC;
        byte[] bArrC2;
        byte[] bArrC3;
        Intrinsics.checkNotNullParameter(charset, "charset");
        Charset charset2 = Charsets.UTF_8;
        if (Intrinsics.b(charset, charset2)) {
            bArrC = StringsKt.q("[");
        } else {
            CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
            Intrinsics.checkNotNullExpressionValue(charsetEncoderNewEncoder, "charset.newEncoder()");
            bArrC = CharsetJVMKt.c(charsetEncoderNewEncoder, "[", 1);
        }
        this.f50379a = bArrC;
        if (Intrinsics.b(charset, charset2)) {
            bArrC2 = StringsKt.q("]");
        } else {
            CharsetEncoder charsetEncoderNewEncoder2 = charset.newEncoder();
            Intrinsics.checkNotNullExpressionValue(charsetEncoderNewEncoder2, "charset.newEncoder()");
            bArrC2 = CharsetJVMKt.c(charsetEncoderNewEncoder2, "]", 1);
        }
        this.f50380b = bArrC2;
        if (Intrinsics.b(charset, charset2)) {
            bArrC3 = StringsKt.q(",");
        } else {
            CharsetEncoder charsetEncoderNewEncoder3 = charset.newEncoder();
            Intrinsics.checkNotNullExpressionValue(charsetEncoderNewEncoder3, "charset.newEncoder()");
            bArrC3 = CharsetJVMKt.c(charsetEncoderNewEncoder3, ",", 1);
        }
        this.f50381c = bArrC3;
    }

    public final byte[] a() {
        return this.f50379a;
    }

    public final byte[] b() {
        return this.f50380b;
    }
}
