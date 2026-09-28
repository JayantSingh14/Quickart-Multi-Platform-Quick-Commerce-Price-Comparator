package com.cardreader.card_reader_lib.xutils;

/* loaded from: classes3.dex */
public final class ResponseUtils {
    public static boolean a(byte[] bArr, byte[] bArr2) {
        return bArr != null && bArr.length >= 2 && bArr[bArr.length - 2] == bArr2[0] && bArr[bArr.length - 1] == bArr2[1];
    }
}
