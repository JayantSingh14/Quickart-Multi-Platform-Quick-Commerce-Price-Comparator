package com.truecaller.android.sdk.legacy;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import androidx.annotation.RestrictTo;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

@RestrictTo
/* loaded from: classes4.dex */
public class Utils {
    public static String a(Activity activity) throws PackageManager.NameNotFoundException {
        PackageInfo packageInfo;
        Signature[] signatureArr;
        try {
            packageInfo = activity.getPackageManager().getPackageInfo(activity.getPackageName(), 64);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        if (packageInfo == null || (signatureArr = packageInfo.signatures) == null || signatureArr.length == 0) {
            return null;
        }
        return Base64.encodeToString(b(signatureArr[0].toByteArray()).getBytes(), 2);
    }

    public static String b(byte[] bArr) throws NoSuchAlgorithmException {
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
