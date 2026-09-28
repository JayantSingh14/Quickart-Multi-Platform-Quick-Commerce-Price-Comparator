package com.facebook.imageformat;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntProgressionIterator;
import kotlin.ranges.IntRange;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class ImageFormatCheckerUtils {
    public static final byte[] a(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        try {
            Charset charsetForName = Charset.forName("ASCII");
            Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(...)");
            byte[] bytes = value.getBytes(charsetForName);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            return bytes;
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("ASCII not found!", e2);
        }
    }

    public static final boolean b(int i2, byte[] byteArray, byte[] pattern) {
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        if (pattern.length + i2 <= byteArray.length) {
            Intrinsics.checkNotNullParameter(pattern, "<this>");
            Intrinsics.checkNotNullParameter(pattern, "<this>");
            Iterable intRange = new IntRange(0, pattern.length - 1, 1);
            if (!(intRange instanceof Collection) || !((Collection) intRange).isEmpty()) {
                Iterator<Integer> it = intRange.iterator();
                while (((IntProgressionIterator) it).f53843c) {
                    int iA = ((IntIterator) it).a();
                    if (byteArray[i2 + iA] != pattern[iA]) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    public static final boolean c(byte[] byteArray, byte[] pattern) {
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        return b(0, byteArray, pattern);
    }
}
