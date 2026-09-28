package io.ktor.util;

import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.StringsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.channels.ChannelResult;

@Metadata
/* loaded from: classes3.dex */
public final class CryptoKt {
    public static final String a() {
        String str = (String) ChannelResult.b(NonceKt.f50489b.m());
        if (str != null) {
            return str;
        }
        ((JobSupport) NonceKt.f50490c).start();
        return (String) BuildersKt.d(new CryptoKt__CryptoJvmKt$generateNonceBlocking$1(2, null));
    }

    public static final byte[] b() {
        char[] cArr = CryptoKt__CryptoKt.f50448a;
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder(0);
        while (bytePacketBuilder.A() < 16) {
            try {
                String strA = a();
                StringsKt.e(bytePacketBuilder, strA, 0, strA.length(), Charsets.UTF_8);
            } catch (Throwable th) {
                bytePacketBuilder.close();
                throw th;
            }
        }
        return StringsKt.b(bytePacketBuilder.V(), 16);
    }

    public static final String c(byte[] bytes) {
        char[] cArr = CryptoKt__CryptoKt.f50448a;
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        char[] cArr2 = new char[bytes.length * 2];
        int i2 = 0;
        for (byte b2 : bytes) {
            int i3 = i2 + 1;
            char[] cArr3 = CryptoKt__CryptoKt.f50448a;
            cArr2[i2] = cArr3[(b2 & 255) >> 4];
            i2 += 2;
            cArr2[i3] = cArr3[b2 & 15];
        }
        Intrinsics.checkNotNullParameter(cArr2, "<this>");
        return new String(cArr2);
    }
}
