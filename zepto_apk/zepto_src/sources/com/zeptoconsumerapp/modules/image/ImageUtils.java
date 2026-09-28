package com.zeptoconsumerapp.modules.image;

import android.support.v4.media.b;
import androidx.fragment.app.e;
import com.zeptoconsumerapp.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class ImageUtils {
    public static String a(String input) {
        Intrinsics.checkNotNullParameter(input, "inputUrl");
        if (!StringsKt.O(input, BuildConfig.IMAGEKIT_BASE_URL, false)) {
            return input;
        }
        Intrinsics.checkNotNullParameter(input, "inputUrl");
        if (!StringsKt.z(input)) {
            Regex regex = new Regex("[?&]q=(?:100|[1-9][0-9]?)(?=&|$)");
            Intrinsics.checkNotNullParameter(input, "input");
            if (regex.f53992a.matcher(input).find()) {
                String strReplace = regex.replace(input, "");
                if (new Regex(".*\\?q=(?:100|[1-9][0-9]?)(?=&|$).*").c(input) && !StringsKt.n(strReplace, "?", false)) {
                    Intrinsics.checkNotNullParameter(strReplace, "<this>");
                    Intrinsics.checkNotNullParameter("&", "oldValue");
                    Intrinsics.checkNotNullParameter("?", "newValue");
                    int iX = StringsKt.x(strReplace, "&", 0, false, 2);
                    if (iX >= 0) {
                        int i2 = 1 + iX;
                        Intrinsics.checkNotNullParameter(strReplace, "<this>");
                        Intrinsics.checkNotNullParameter("?", "replacement");
                        if (i2 < iX) {
                            throw new IndexOutOfBoundsException(b.e(i2, iX, "End index (", ") is less than start index (", ")."));
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append((CharSequence) strReplace, 0, iX);
                        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
                        sb.append((CharSequence) "?");
                        sb.append((CharSequence) strReplace, i2, strReplace.length());
                        Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
                        strReplace = sb.toString();
                    }
                }
                input = new Regex("[?&]$").replace(new Regex("&{2,}").replace(strReplace, "&"), "");
            }
        }
        int iX2 = StringsKt.x(input, "tr:", 0, false, 6);
        if (iX2 == -1 || iX2 < 46) {
            return input;
        }
        int i3 = iX2 + 3;
        int iW = StringsKt.w(input, '/', i3, 4);
        if (iW == -1) {
            iW = input.length();
        }
        String strSubstring = input.substring(0, iX2);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        String strSubstring2 = input.substring(i3, iW);
        Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
        String strSubstring3 = input.substring(iW);
        Intrinsics.checkNotNullExpressionValue(strSubstring3, "substring(...)");
        if (!StringsKt.n(strSubstring2, "q-", false)) {
            return input;
        }
        ArrayList arrayListF0 = CollectionsKt.f0(StringsKt.M(strSubstring2, new char[]{','}));
        Iterator it = arrayListF0.iterator();
        int i4 = 0;
        while (true) {
            if (!it.hasNext()) {
                i4 = -1;
                break;
            }
            if (StringsKt.O((String) it.next(), "q-", false)) {
                break;
            }
            i4++;
        }
        if (i4 == -1) {
            return input;
        }
        return arrayListF0.isEmpty() ? b.k(StringsKt.d0(strSubstring, '/'), strSubstring3) : e.D(strSubstring, "tr:", CollectionsKt.E(arrayListF0, ",", null, null, null, 62), strSubstring3);
    }
}
