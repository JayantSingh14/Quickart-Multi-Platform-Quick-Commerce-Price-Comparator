package com.truecaller.android.sdk.oAuth;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.util.Base64;
import androidx.annotation.RestrictTo;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

@RestrictTo
/* loaded from: classes4.dex */
public class UtilsV2 {
    public static String a(Activity activity) {
        Signature[] signatureArrB = b(activity, activity.getPackageName());
        if (signatureArrB == null || signatureArrB.length == 0) {
            return null;
        }
        return Base64.encodeToString(c(signatureArrB[0].toByteArray()).getBytes(), 2);
    }

    public static Signature[] b(Context context, String str) {
        try {
            return Build.VERSION.SDK_INT < 28 ? context.getPackageManager().getPackageInfo(str, 64).signatures : context.getPackageManager().getPackageInfo(str, 134217728).signingInfo.getApkContentsSigners();
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static String c(byte[] bArr) throws NoSuchAlgorithmException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_1);
            messageDigest.update(bArr);
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b2 : bArrDigest) {
                sb.append(Integer.toHexString((b2 >> 4) & 15));
                sb.append(Integer.toHexString(b2 & 15));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }
}
