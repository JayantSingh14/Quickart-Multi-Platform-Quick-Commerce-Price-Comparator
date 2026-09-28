package com.facebook.imageutils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.UShort;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntProgressionIterator;
import kotlin.ranges.IntRange;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class WebpUtil {
    public static boolean a(String str, byte[] bArr) {
        if (bArr.length == str.length()) {
            Intrinsics.checkNotNullParameter(bArr, "<this>");
            Intrinsics.checkNotNullParameter(bArr, "<this>");
            Iterable intRange = new IntRange(0, bArr.length - 1, 1);
            if (!(intRange instanceof Collection) || !((Collection) intRange).isEmpty()) {
                Iterator<Integer> it = intRange.iterator();
                while (((IntProgressionIterator) it).f53843c) {
                    int iA = ((IntIterator) it).a();
                    if (((byte) str.charAt(iA)) != bArr[iA]) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    public static String b(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (short s : bArr) {
            UShort.Companion companion = UShort.f53567b;
            sb.append((char) (s & 65535));
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public static void c(InputStream inputStream) throws IOException {
        inputStream.read();
        inputStream.read();
        inputStream.read();
        inputStream.read();
    }

    public static Pair d(InputStream stream) throws IOException {
        stream.skip(7L);
        int i2 = stream.read() & 255;
        int i3 = stream.read() & 255;
        int i4 = stream.read() & 255;
        if (i2 != 157 || i3 != 1 || i4 != 42) {
            return null;
        }
        Intrinsics.checkNotNullParameter(stream, "stream");
        Integer numValueOf = Integer.valueOf((stream.read() & 255) | ((stream.read() & 255) << 8));
        Intrinsics.checkNotNullParameter(stream, "stream");
        return new Pair(numValueOf, Integer.valueOf(((stream.read() & 255) << 8) | (stream.read() & 255)));
    }

    public static Pair e(InputStream inputStream) throws IOException {
        c(inputStream);
        if ((inputStream.read() & 255) != 47) {
            return null;
        }
        int i2 = inputStream.read() & 255;
        int i3 = inputStream.read();
        return new Pair(Integer.valueOf((i2 | ((i3 & 63) << 8)) + 1), Integer.valueOf((((inputStream.read() & 15) << 10) | ((inputStream.read() & 255) << 2) | ((i3 & 192) >> 6)) + 1));
    }
}
