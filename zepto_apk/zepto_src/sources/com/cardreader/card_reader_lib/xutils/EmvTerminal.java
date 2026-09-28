package com.cardreader.card_reader_lib.xutils;

import android.util.Log;
import java.security.SecureRandom;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final class EmvTerminal {
    static {
        new SecureRandom();
    }

    public static byte[] a(TagAndLength tagAndLength) {
        byte[] bArrCopyOf;
        int i2 = tagAndLength.f16588b;
        byte[] bArr = new byte[i2];
        if (tagAndLength.f16587a == EmvTags.f16577i) {
            TerminalTransactionQualifiers terminalTransactionQualifiers = new TerminalTransactionQualifiers();
            byte[] bArr2 = terminalTransactionQualifiers.f16594a;
            bArr2[0] = BytesUtils.d(5, bArr2[0]);
            byte[] bArr3 = terminalTransactionQualifiers.f16594a;
            bArr3[0] = BytesUtils.d(3, bArr3[0]);
            byte[] bArr4 = terminalTransactionQualifiers.f16594a;
            bArrCopyOf = Arrays.copyOf(bArr4, bArr4.length);
        } else {
            bArrCopyOf = null;
        }
        Log.d("Deepak Sharma ", BytesUtils.a(bArrCopyOf));
        if (bArrCopyOf != null) {
            System.arraycopy(bArrCopyOf, 0, bArr, 0, Math.min(bArrCopyOf.length, i2));
        }
        return bArr;
    }
}
