package com.amazonaws.mobileconnectors.remoteconfiguration.internal.gear;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* loaded from: classes3.dex */
public final class LocalConfigInstanceIdGenerationHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f15282a = "0123456789ABCDEF".toCharArray();

    public static String generateLocalConfigInstanceId(String str) {
        Checks.checkArgument((str == null || str.isEmpty()) ? false : true, "Invalid string for hashing");
        try {
            byte[] bArrDigest = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256).digest(str.getBytes());
            char[] cArr = new char[bArrDigest.length * 2];
            for (int i2 = 0; i2 < bArrDigest.length; i2++) {
                byte b2 = bArrDigest[i2];
                int i3 = i2 * 2;
                char[] cArr2 = f15282a;
                cArr[i3] = cArr2[(b2 & 255) >>> 4];
                cArr[i3 + 1] = cArr2[b2 & 15];
            }
            return new String(cArr);
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }
}
