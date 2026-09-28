package com.amazon.apay.hardened.signer;

import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;

/* loaded from: classes3.dex */
public class AWS4Signer {
    static {
        try {
            Mac.getInstance("HmacSHA384");
        } catch (NoSuchAlgorithmException e2) {
            throw new IllegalArgumentException(e2);
        }
    }
}
