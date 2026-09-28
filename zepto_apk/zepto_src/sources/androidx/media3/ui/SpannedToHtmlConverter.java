package androidx.media3.ui;

import android.text.Html;
import androidx.media3.ui.SpannedToHtmlConverter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
final class SpannedToHtmlConverter {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f10935a = Pattern.compile("(&#13;)?&#10;");

    public static class HtmlAndCss {

        /* renamed from: a, reason: collision with root package name */
        public final String f10936a;

        /* renamed from: b, reason: collision with root package name */
        public final Object f10937b;

        public HtmlAndCss(String str, Map map) {
            this.f10936a = str;
            this.f10937b = map;
        }
    }

    public static final class SpanInfo {

        /* renamed from: e, reason: collision with root package name */
        public static final l f10938e;

        /* renamed from: f, reason: collision with root package name */
        public static final l f10939f;

        /* renamed from: a, reason: collision with root package name */
        public final int f10940a;

        /* renamed from: b, reason: collision with root package name */
        public final int f10941b;

        /* renamed from: c, reason: collision with root package name */
        public final String f10942c;

        /* renamed from: d, reason: collision with root package name */
        public final String f10943d;

        /* JADX WARN: Type inference failed for: r0v0, types: [androidx.media3.ui.l] */
        /* JADX WARN: Type inference failed for: r0v1, types: [androidx.media3.ui.l] */
        static {
            final int i2 = 0;
            f10938e = new Comparator() { // from class: androidx.media3.ui.l
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    SpannedToHtmlConverter.SpanInfo spanInfo = (SpannedToHtmlConverter.SpanInfo) obj;
                    SpannedToHtmlConverter.SpanInfo spanInfo2 = (SpannedToHtmlConverter.SpanInfo) obj2;
                    switch (i2) {
                        case 0:
                            int iCompare = Integer.compare(spanInfo2.f10941b, spanInfo.f10941b);
                            if (iCompare != 0) {
                                return iCompare;
                            }
                            int iCompareTo = spanInfo.f10942c.compareTo(spanInfo2.f10942c);
                            return iCompareTo != 0 ? iCompareTo : spanInfo.f10943d.compareTo(spanInfo2.f10943d);
                        default:
                            int iCompare2 = Integer.compare(spanInfo2.f10940a, spanInfo.f10940a);
                            if (iCompare2 != 0) {
                                return iCompare2;
                            }
                            int iCompareTo2 = spanInfo2.f10942c.compareTo(spanInfo.f10942c);
                            return iCompareTo2 != 0 ? iCompareTo2 : spanInfo2.f10943d.compareTo(spanInfo.f10943d);
                    }
                }
            };
            final int i3 = 1;
            f10939f = new Comparator() { // from class: androidx.media3.ui.l
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    SpannedToHtmlConverter.SpanInfo spanInfo = (SpannedToHtmlConverter.SpanInfo) obj;
                    SpannedToHtmlConverter.SpanInfo spanInfo2 = (SpannedToHtmlConverter.SpanInfo) obj2;
                    switch (i3) {
                        case 0:
                            int iCompare = Integer.compare(spanInfo2.f10941b, spanInfo.f10941b);
                            if (iCompare != 0) {
                                return iCompare;
                            }
                            int iCompareTo = spanInfo.f10942c.compareTo(spanInfo2.f10942c);
                            return iCompareTo != 0 ? iCompareTo : spanInfo.f10943d.compareTo(spanInfo2.f10943d);
                        default:
                            int iCompare2 = Integer.compare(spanInfo2.f10940a, spanInfo.f10940a);
                            if (iCompare2 != 0) {
                                return iCompare2;
                            }
                            int iCompareTo2 = spanInfo2.f10942c.compareTo(spanInfo.f10942c);
                            return iCompareTo2 != 0 ? iCompareTo2 : spanInfo2.f10943d.compareTo(spanInfo.f10943d);
                    }
                }
            };
        }

        public SpanInfo(int i2, int i3, String str, String str2) {
            this.f10940a = i2;
            this.f10941b = i3;
            this.f10942c = str;
            this.f10943d = str2;
        }
    }

    public static final class Transition {

        /* renamed from: a, reason: collision with root package name */
        public final ArrayList f10944a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList f10945b = new ArrayList();
    }

    public static String a(CharSequence charSequence) {
        return f10935a.matcher(Html.escapeHtml(charSequence)).replaceAll("<br>");
    }
}
