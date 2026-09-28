package com.google.thirdparty.publicsuffix;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayDeque;
import java.util.Arrays;

@GwtCompatible
/* loaded from: classes4.dex */
final class TrieParser {

    /* renamed from: a, reason: collision with root package name */
    public static final Joiner f45632a = new Joiner("");

    public static int a(ArrayDeque arrayDeque, String str, int i2, ImmutableMap.Builder builder) {
        int length = str.length();
        int i3 = i2;
        char cCharAt = 0;
        while (i3 < length && (cCharAt = str.charAt(i3)) != '&' && cCharAt != '?' && cCharAt != '!' && cCharAt != ':' && cCharAt != ',') {
            i3++;
        }
        arrayDeque.push(new StringBuilder(str.subSequence(i2, i3)).reverse());
        if (cCharAt == '!' || cCharAt == '?' || cCharAt == ':' || cCharAt == ',') {
            String strC = f45632a.c(arrayDeque);
            if (strC.length() > 0) {
                for (PublicSuffixType publicSuffixType : PublicSuffixType.values()) {
                    if (publicSuffixType.f45630a == cCharAt || publicSuffixType.f45631b == cCharAt) {
                        builder.c(strC, publicSuffixType);
                    }
                }
                throw new IllegalArgumentException("No enum corresponding to given code: " + cCharAt);
            }
        }
        int iA = i3 + 1;
        if (cCharAt != '?' && cCharAt != ',') {
            while (iA < length) {
                iA += a(arrayDeque, str, iA, builder);
                if (str.charAt(iA) == '?' || str.charAt(iA) == ',') {
                    iA++;
                    break;
                }
            }
        }
        arrayDeque.pop();
        return iA - i2;
    }

    public static void b(CharSequence... charSequenceArr) {
        Joiner joiner = f45632a;
        joiner.getClass();
        String strC = joiner.c(Arrays.asList(charSequenceArr));
        ImmutableMap.Builder builder = new ImmutableMap.Builder();
        int length = strC.length();
        for (int iA = 0; iA < length; iA += a(new ArrayDeque(), strC, iA, builder)) {
        }
        builder.a(true);
    }
}
