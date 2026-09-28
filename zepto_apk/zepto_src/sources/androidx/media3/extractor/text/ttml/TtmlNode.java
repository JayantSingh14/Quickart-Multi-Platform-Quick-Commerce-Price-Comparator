package androidx.media3.extractor.text.ttml;

import android.text.SpannableStringBuilder;
import android.util.Pair;
import androidx.media3.common.text.Cue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes3.dex */
final class TtmlNode {

    /* renamed from: a, reason: collision with root package name */
    public final String f9370a;

    /* renamed from: b, reason: collision with root package name */
    public final String f9371b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f9372c;

    /* renamed from: d, reason: collision with root package name */
    public final long f9373d;

    /* renamed from: e, reason: collision with root package name */
    public final long f9374e;

    /* renamed from: f, reason: collision with root package name */
    public final TtmlStyle f9375f;

    /* renamed from: g, reason: collision with root package name */
    public final String[] f9376g;

    /* renamed from: h, reason: collision with root package name */
    public final String f9377h;

    /* renamed from: i, reason: collision with root package name */
    public final String f9378i;

    /* renamed from: j, reason: collision with root package name */
    public final TtmlNode f9379j;

    /* renamed from: k, reason: collision with root package name */
    public final HashMap f9380k;

    /* renamed from: l, reason: collision with root package name */
    public final HashMap f9381l;

    /* renamed from: m, reason: collision with root package name */
    public ArrayList f9382m;

    public TtmlNode(String str, String str2, long j2, long j3, TtmlStyle ttmlStyle, String[] strArr, String str3, String str4, TtmlNode ttmlNode) {
        this.f9370a = str;
        this.f9371b = str2;
        this.f9378i = str4;
        this.f9375f = ttmlStyle;
        this.f9376g = strArr;
        this.f9372c = str2 != null;
        this.f9373d = j2;
        this.f9374e = j3;
        str3.getClass();
        this.f9377h = str3;
        this.f9379j = ttmlNode;
        this.f9380k = new HashMap();
        this.f9381l = new HashMap();
    }

    public static TtmlNode a(String str) {
        return new TtmlNode(null, str.replaceAll("\r\n", StringUtils.LF).replaceAll(" *\n *", StringUtils.LF).replaceAll(StringUtils.LF, StringUtils.SPACE).replaceAll("[ \t\\x0B\f\r]+", StringUtils.SPACE), -9223372036854775807L, -9223372036854775807L, null, null, "", null, null);
    }

    public static SpannableStringBuilder e(String str, TreeMap treeMap) {
        if (!treeMap.containsKey(str)) {
            Cue.Builder builder = new Cue.Builder();
            builder.f5625a = new SpannableStringBuilder();
            treeMap.put(str, builder);
        }
        CharSequence charSequence = ((Cue.Builder) treeMap.get(str)).f5625a;
        charSequence.getClass();
        return (SpannableStringBuilder) charSequence;
    }

    public final TtmlNode b(int i2) {
        ArrayList arrayList = this.f9382m;
        if (arrayList != null) {
            return (TtmlNode) arrayList.get(i2);
        }
        throw new IndexOutOfBoundsException();
    }

    public final int c() {
        ArrayList arrayList = this.f9382m;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public final void d(TreeSet treeSet, boolean z) {
        String str = this.f9370a;
        boolean zEquals = "p".equals(str);
        boolean zEquals2 = "div".equals(str);
        if (z || zEquals || (zEquals2 && this.f9378i != null)) {
            long j2 = this.f9373d;
            if (j2 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j2));
            }
            long j3 = this.f9374e;
            if (j3 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j3));
            }
        }
        if (this.f9382m == null) {
            return;
        }
        for (int i2 = 0; i2 < this.f9382m.size(); i2++) {
            ((TtmlNode) this.f9382m.get(i2)).d(treeSet, z || zEquals);
        }
    }

    public final boolean f(long j2) {
        long j3 = this.f9373d;
        long j4 = this.f9374e;
        if (j3 == -9223372036854775807L && j4 == -9223372036854775807L) {
            return true;
        }
        if (j3 <= j2 && j4 == -9223372036854775807L) {
            return true;
        }
        if (j3 != -9223372036854775807L || j2 >= j4) {
            return j3 <= j2 && j2 < j4;
        }
        return true;
    }

    public final void g(long j2, String str, ArrayList arrayList) {
        String str2;
        String str3 = this.f9377h;
        if (!"".equals(str3)) {
            str = str3;
        }
        if (f(j2) && "div".equals(this.f9370a) && (str2 = this.f9378i) != null) {
            arrayList.add(new Pair(str, str2));
            return;
        }
        for (int i2 = 0; i2 < c(); i2++) {
            b(i2).g(j2, str, arrayList);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:143:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x02d4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h(long r21, java.util.Map r23, java.util.HashMap r24, java.lang.String r25, java.util.TreeMap r26) {
        /*
            Method dump skipped, instructions count: 762
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.ttml.TtmlNode.h(long, java.util.Map, java.util.HashMap, java.lang.String, java.util.TreeMap):void");
    }

    public final void i(long j2, boolean z, String str, TreeMap treeMap) {
        boolean z2;
        TreeMap treeMap2;
        long j3;
        HashMap map = this.f9380k;
        map.clear();
        HashMap map2 = this.f9381l;
        map2.clear();
        String str2 = this.f9370a;
        if ("metadata".equals(str2)) {
            return;
        }
        String str3 = this.f9377h;
        String str4 = "".equals(str3) ? str : str3;
        if (this.f9372c && z) {
            SpannableStringBuilder spannableStringBuilderE = e(str4, treeMap);
            String str5 = this.f9371b;
            str5.getClass();
            spannableStringBuilderE.append((CharSequence) str5);
            return;
        }
        if ("br".equals(str2) && z) {
            e(str4, treeMap).append('\n');
            return;
        }
        if (f(j2)) {
            for (Map.Entry entry : treeMap.entrySet()) {
                String str6 = (String) entry.getKey();
                CharSequence charSequence = ((Cue.Builder) entry.getValue()).f5625a;
                charSequence.getClass();
                map.put(str6, Integer.valueOf(charSequence.length()));
            }
            boolean zEquals = "p".equals(str2);
            for (int i2 = 0; i2 < c(); i2++) {
                TtmlNode ttmlNodeB = b(i2);
                if (z || zEquals) {
                    z2 = true;
                    treeMap2 = treeMap;
                    j3 = j2;
                } else {
                    z2 = false;
                    j3 = j2;
                    treeMap2 = treeMap;
                }
                ttmlNodeB.i(j3, z2, str4, treeMap2);
            }
            if (zEquals) {
                SpannableStringBuilder spannableStringBuilderE2 = e(str4, treeMap);
                int length = spannableStringBuilderE2.length() - 1;
                while (length >= 0 && spannableStringBuilderE2.charAt(length) == ' ') {
                    length--;
                }
                if (length >= 0 && spannableStringBuilderE2.charAt(length) != '\n') {
                    spannableStringBuilderE2.append('\n');
                }
            }
            for (Map.Entry entry2 : treeMap.entrySet()) {
                String str7 = (String) entry2.getKey();
                CharSequence charSequence2 = ((Cue.Builder) entry2.getValue()).f5625a;
                charSequence2.getClass();
                map2.put(str7, Integer.valueOf(charSequence2.length()));
            }
        }
    }
}
