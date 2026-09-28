package com.zeptonow.horizon.utils;

import com.zeptonow.horizon.network.KtorNetworkClient$sendEvents$2$invokeSuspend$$inlined$makeRequest0E7RQCE$1;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import net.jpountz.lz4.LZ4FrameOutputStream;

@Metadata
/* loaded from: classes.dex */
public final class Compressor {
    /* JADX WARN: Type inference failed for: r4v7, types: [byte[], java.io.Serializable] */
    public static Serializable a(KtorNetworkClient$sendEvents$2$invokeSuspend$$inlined$makeRequest0E7RQCE$1 data) throws IOException {
        CompressionType type = CompressionType.f48232a;
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(data, "data");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        LZ4FrameOutputStream lZ4FrameOutputStream = new LZ4FrameOutputStream(byteArrayOutputStream);
        try {
            String str = (String) data.invoke();
            Charset charsetForName = Charset.forName("UTF-8");
            Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(...)");
            byte[] bytes = str.getBytes(charsetForName);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            lZ4FrameOutputStream.write(bytes);
            Unit unit = Unit.f53572a;
            lZ4FrameOutputStream.close();
            Result.Companion companion = Result.f53538b;
            return byteArrayOutputStream.toByteArray();
        } finally {
        }
    }
}
