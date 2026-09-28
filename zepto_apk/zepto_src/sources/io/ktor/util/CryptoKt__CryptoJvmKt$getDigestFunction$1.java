package io.ktor.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes3.dex */
final class CryptoKt__CryptoJvmKt$getDigestFunction$1 extends Lambda implements Function1<String, byte[]> {
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) throws NoSuchAlgorithmException {
        String e2 = (String) obj;
        Intrinsics.checkNotNullParameter(e2, "e");
        MessageDigest.getInstance(null);
        throw null;
    }
}
