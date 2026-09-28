package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* loaded from: classes4.dex */
public final class zzhwz {
    public static String a(zzhwl zzhwlVar) throws GeneralSecurityException {
        int iOrdinal = zzhwlVar.ordinal();
        if (iOrdinal == 0) {
            return MessageDigestAlgorithms.SHA_1;
        }
        if (iOrdinal == 1) {
            return MessageDigestAlgorithms.SHA_224;
        }
        if (iOrdinal == 2) {
            return MessageDigestAlgorithms.SHA_256;
        }
        if (iOrdinal == 3) {
            return MessageDigestAlgorithms.SHA_384;
        }
        if (iOrdinal == 4) {
            return MessageDigestAlgorithms.SHA_512;
        }
        throw new GeneralSecurityException("Unsupported hash ".concat(zzhwlVar.toString()));
    }
}
