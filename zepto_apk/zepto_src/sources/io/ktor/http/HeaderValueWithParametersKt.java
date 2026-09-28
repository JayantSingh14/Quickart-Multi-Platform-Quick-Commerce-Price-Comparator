package io.ktor.http;

import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.apache.commons.lang3.CharUtils;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class HeaderValueWithParametersKt {

    /* renamed from: a, reason: collision with root package name */
    public static final Set f50199a;

    static {
        Character[] elements = {'(', ')', '<', '>', '@', ',', ';', ':', '\\', '\"', '/', '[', ']', '?', '=', '{', '}', ' ', '\t', '\n', Character.valueOf(CharUtils.CR)};
        Intrinsics.checkNotNullParameter(elements, "elements");
        f50199a = ArraysKt.H(elements);
    }

    public static final boolean a(String str) {
        if (str.length() != 0) {
            if (str.length() >= 2) {
                Intrinsics.checkNotNullParameter(str, "<this>");
                if (str.length() == 0) {
                    throw new NoSuchElementException("Char sequence is empty.");
                }
                if (str.charAt(0) == '\"' && StringsKt.A(str) == '\"') {
                    int i2 = 1;
                    do {
                        int iW = StringsKt.w(str, '\"', i2, 4);
                        if (iW == StringsKt.v(str)) {
                            break;
                        }
                        int i3 = 0;
                        for (int i4 = iW - 1; str.charAt(i4) == '\\'; i4--) {
                            i3++;
                        }
                        if (i3 % 2 != 0) {
                            i2 = iW + 1;
                        }
                    } while (i2 < str.length());
                    return false;
                }
            }
            int length = str.length();
            for (int i5 = 0; i5 < length; i5++) {
                if (!f50199a.contains(Character.valueOf(str.charAt(i5)))) {
                }
            }
            return false;
        }
        return true;
    }

    public static final String b(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        StringBuilder sb = new StringBuilder("\"");
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt == '\\') {
                sb.append("\\\\");
            } else if (cCharAt == '\n') {
                sb.append("\\n");
            } else if (cCharAt == '\r') {
                sb.append("\\r");
            } else if (cCharAt == '\t') {
                sb.append("\\t");
            } else if (cCharAt == '\"') {
                sb.append("\\\"");
            } else {
                sb.append(cCharAt);
            }
        }
        sb.append("\"");
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
