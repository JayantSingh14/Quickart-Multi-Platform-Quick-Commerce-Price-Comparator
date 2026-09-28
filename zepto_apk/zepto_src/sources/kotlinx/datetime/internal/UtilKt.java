package kotlinx.datetime.internal;

import android.support.v4.media.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.codec.language.Soundex;

@Metadata
/* loaded from: classes3.dex */
public final class UtilKt {
    public static final boolean a(char c2) {
        return '0' <= c2 && c2 < ':';
    }

    public static final String b(int i2, String str) {
        int iW;
        CharSequence charSequenceSubSequence;
        if (str.length() >= i2 + 12 && StringsKt.o("+-", str.charAt(0)) && (iW = StringsKt.w(str, Soundex.SILENT_MARKER, 1, 4)) >= 12) {
            int i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                if (str.charAt(i4) != '0') {
                    break;
                }
                i3 = i4;
            }
            if (iW - i3 < 12) {
                int i5 = iW - 10;
                Intrinsics.checkNotNullParameter(str, "<this>");
                if (i5 < 1) {
                    throw new IndexOutOfBoundsException(b.g(i5, "End index (", ") is less than start index (1)."));
                }
                if (i5 == 1) {
                    charSequenceSubSequence = str.subSequence(0, str.length());
                } else {
                    StringBuilder sb = new StringBuilder(str.length() - (iW - 11));
                    sb.append((CharSequence) str, 0, 1);
                    Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
                    sb.append((CharSequence) str, i5, str.length());
                    Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
                    charSequenceSubSequence = sb;
                }
                return charSequenceSubSequence.toString();
            }
        }
        return str;
    }
}
