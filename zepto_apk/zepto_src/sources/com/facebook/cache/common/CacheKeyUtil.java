package com.facebook.cache.common;

import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

@Metadata
/* loaded from: classes3.dex */
public final class CacheKeyUtil {
    public static final String a(CacheKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            if (!(key instanceof MultiCacheKey)) {
                return c(key);
            }
            ArrayList arrayList = ((MultiCacheKey) key).f16990a;
            Intrinsics.checkNotNullExpressionValue(arrayList, "getCacheKeys(...)");
            Object obj = arrayList.get(0);
            Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
            return c((CacheKey) obj);
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static final ArrayList b(CacheKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            if (!(key instanceof MultiCacheKey)) {
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(key.c() ? key.a() : c(key));
                return arrayList;
            }
            ArrayList arrayList2 = ((MultiCacheKey) key).f16990a;
            Intrinsics.checkNotNullExpressionValue(arrayList2, "getCacheKeys(...)");
            ArrayList arrayList3 = new ArrayList(arrayList2.size());
            int size = arrayList2.size();
            for (int i2 = 0; i2 < size; i2++) {
                Object obj = arrayList2.get(i2);
                Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
                arrayList3.add(c((CacheKey) obj));
            }
            return arrayList3;
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static String c(CacheKey cacheKey) throws NoSuchAlgorithmException {
        String strA = cacheKey.a();
        Intrinsics.checkNotNullExpressionValue(strA, "getUriString(...)");
        Charset charsetForName = Charset.forName("UTF-8");
        Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(...)");
        byte[] bytes = strA.getBytes(charsetForName);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_1);
            messageDigest.update(bytes, 0, bytes.length);
            String strEncodeToString = Base64.encodeToString(messageDigest.digest(), 11);
            Intrinsics.checkNotNullExpressionValue(strEncodeToString, "makeSHA1HashBase64(...)");
            return strEncodeToString;
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        }
    }
}
