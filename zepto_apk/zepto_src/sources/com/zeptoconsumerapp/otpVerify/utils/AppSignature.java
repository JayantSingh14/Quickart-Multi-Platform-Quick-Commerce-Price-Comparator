package com.zeptoconsumerapp.otpVerify.utils;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.v4.media.b;
import android.util.Base64;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.apache.commons.lang3.StringUtils;

@Metadata
/* loaded from: classes4.dex */
public final class AppSignature extends ContextWrapper {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f47717a = 0;

    @Metadata
    public static final class Companion {
        public static final String a(String str, String str2) throws NoSuchAlgorithmException {
            int i2 = AppSignature.f47717a;
            String strL = b.l(str, StringUtils.SPACE, str2);
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
                Charset UTF_8 = StandardCharsets.UTF_8;
                Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                byte[] bytes = strL.getBytes(UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                messageDigest.update(bytes);
                String strEncodeToString = Base64.encodeToString(Arrays.copyOfRange(messageDigest.digest(), 0, 9), 3);
                Intrinsics.c(strEncodeToString);
                String strSubstring = strEncodeToString.substring(0, 11);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                return strSubstring;
            } catch (NoSuchAlgorithmException unused) {
                return null;
            }
        }
    }

    public AppSignature(Context context) {
        super(context);
    }

    public final ArrayList a() {
        ArrayList arrayList = new ArrayList();
        try {
            String packageName = getPackageName();
            Signature[] signatureArr = getPackageManager().getPackageInfo(packageName, 64).signatures;
            if (signatureArr != null) {
                Iterator itA = ArrayIteratorKt.a(signatureArr);
                while (itA.hasNext()) {
                    Signature signature = (Signature) itA.next();
                    Intrinsics.c(packageName);
                    String charsString = signature.toCharsString();
                    Intrinsics.checkNotNullExpressionValue(charsString, "toCharsString(...)");
                    String strA = Companion.a(packageName, charsString);
                    if (strA != null) {
                        String str = String.format("%s", Arrays.copyOf(new Object[]{strA}, 1));
                        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                        arrayList.add(str);
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return arrayList;
    }
}
