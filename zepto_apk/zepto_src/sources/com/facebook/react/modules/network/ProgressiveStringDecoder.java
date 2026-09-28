package com.facebook.react.modules.network;

import com.facebook.common.logging.FLog;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/* loaded from: classes.dex */
class ProgressiveStringDecoder {

    /* renamed from: a, reason: collision with root package name */
    public final CharsetDecoder f19154a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f19155b = null;

    public ProgressiveStringDecoder(Charset charset) {
        this.f19154a = charset.newDecoder();
    }

    public final String a(int i2, byte[] bArr) throws CharacterCodingException {
        byte[] bArr2 = this.f19155b;
        if (bArr2 != null) {
            byte[] bArr3 = new byte[bArr2.length + i2];
            System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
            System.arraycopy(bArr, 0, bArr3, this.f19155b.length, i2);
            i2 += this.f19155b.length;
            bArr = bArr3;
        }
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr, 0, i2);
        boolean z = false;
        int i3 = 0;
        CharBuffer charBufferDecode = null;
        while (!z && i3 < 4) {
            try {
                charBufferDecode = this.f19154a.decode(byteBufferWrap);
                z = true;
            } catch (CharacterCodingException unused) {
                i3++;
                byteBufferWrap = ByteBuffer.wrap(bArr, 0, i2 - i3);
            }
        }
        if (!z || i3 <= 0) {
            this.f19155b = null;
        } else {
            byte[] bArr4 = new byte[i3];
            this.f19155b = bArr4;
            System.arraycopy(bArr, i2 - i3, bArr4, 0, i3);
        }
        if (z) {
            return new String(charBufferDecode.array(), 0, charBufferDecode.length());
        }
        FLog.q("ReactNative", "failed to decode string from byte array");
        return "";
    }
}
