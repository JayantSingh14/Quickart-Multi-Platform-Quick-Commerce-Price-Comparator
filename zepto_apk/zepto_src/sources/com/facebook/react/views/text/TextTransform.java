package com.facebook.react.views.text;

import com.facebook.react.views.text.TextTransformKt;
import java.text.BreakIterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes.dex */
public final class TextTransform {

    /* renamed from: a, reason: collision with root package name */
    public static final Companion f20137a;

    /* renamed from: b, reason: collision with root package name */
    public static final TextTransform f20138b;

    /* renamed from: c, reason: collision with root package name */
    public static final TextTransform f20139c;

    /* renamed from: d, reason: collision with root package name */
    public static final TextTransform f20140d;

    /* renamed from: e, reason: collision with root package name */
    public static final TextTransform f20141e;

    /* renamed from: f, reason: collision with root package name */
    public static final TextTransform f20142f;

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ TextTransform[] f20143g;

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f20144h;

    @Metadata
    public static final class Companion {
    }

    static {
        TextTransform textTransform = new TextTransform("NONE", 0);
        f20138b = textTransform;
        TextTransform textTransform2 = new TextTransform("UPPERCASE", 1);
        f20139c = textTransform2;
        TextTransform textTransform3 = new TextTransform("LOWERCASE", 2);
        f20140d = textTransform3;
        TextTransform textTransform4 = new TextTransform("CAPITALIZE", 3);
        f20141e = textTransform4;
        TextTransform textTransform5 = new TextTransform("UNSET", 4);
        f20142f = textTransform5;
        TextTransform[] textTransformArr = {textTransform, textTransform2, textTransform3, textTransform4, textTransform5};
        f20143g = textTransformArr;
        f20144h = EnumEntriesKt.a(textTransformArr);
        f20137a = new Companion();
    }

    public static final String a(String str, TextTransform textTransform) {
        f20137a.getClass();
        if (str == null) {
            return null;
        }
        Intrinsics.checkNotNullParameter(str, "<this>");
        int i2 = textTransform == null ? -1 : TextTransformKt.WhenMappings.f20145a[textTransform.ordinal()];
        if (i2 == 1) {
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            String upperCase = str.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            return upperCase;
        }
        if (i2 == 2) {
            Locale locale2 = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale2, "getDefault(...)");
            String lowerCase = str.toLowerCase(locale2);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            return lowerCase;
        }
        if (i2 != 3) {
            return str;
        }
        BreakIterator wordInstance = BreakIterator.getWordInstance();
        wordInstance.setText(str);
        StringBuilder sb = new StringBuilder(str.length());
        int iFirst = wordInstance.first();
        int next = wordInstance.next();
        while (true) {
            int i3 = next;
            int i4 = iFirst;
            iFirst = i3;
            if (iFirst == -1) {
                String string = sb.toString();
                Intrinsics.c(string);
                return string;
            }
            String strSubstring = str.substring(i4, iFirst);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            if (strSubstring.length() > 0) {
                char upperCase2 = Character.toUpperCase(strSubstring.charAt(0));
                String strSubstring2 = strSubstring.substring(1);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                strSubstring = upperCase2 + strSubstring2;
            }
            sb.append(strSubstring);
            next = wordInstance.next();
        }
    }

    public static TextTransform valueOf(String str) {
        return (TextTransform) Enum.valueOf(TextTransform.class, str);
    }

    public static TextTransform[] values() {
        return (TextTransform[]) f20143g.clone();
    }
}
