package com.google.android.gms.internal.ads;

import android.text.SpannableStringBuilder;
import android.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes4.dex */
final class zzamv {

    /* renamed from: a, reason: collision with root package name */
    public final String f23654a;

    /* renamed from: b, reason: collision with root package name */
    public final String f23655b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f23656c;

    /* renamed from: d, reason: collision with root package name */
    public final long f23657d;

    /* renamed from: e, reason: collision with root package name */
    public final long f23658e;

    /* renamed from: f, reason: collision with root package name */
    public final zzanb f23659f;

    /* renamed from: g, reason: collision with root package name */
    public final String[] f23660g;

    /* renamed from: h, reason: collision with root package name */
    public final String f23661h;

    /* renamed from: i, reason: collision with root package name */
    public final String f23662i;

    /* renamed from: j, reason: collision with root package name */
    public final zzamv f23663j;

    /* renamed from: k, reason: collision with root package name */
    public final HashMap f23664k;

    /* renamed from: l, reason: collision with root package name */
    public final HashMap f23665l;

    /* renamed from: m, reason: collision with root package name */
    public ArrayList f23666m;

    public zzamv(String str, String str2, long j2, long j3, zzanb zzanbVar, String[] strArr, String str3, String str4, zzamv zzamvVar) {
        this.f23654a = str;
        this.f23655b = str2;
        this.f23662i = str4;
        this.f23659f = zzanbVar;
        this.f23660g = strArr;
        this.f23656c = str2 != null;
        this.f23657d = j2;
        this.f23658e = j3;
        str3.getClass();
        this.f23661h = str3;
        this.f23663j = zzamvVar;
        this.f23664k = new HashMap();
        this.f23665l = new HashMap();
    }

    public static zzamv a(String str) {
        return new zzamv(null, str.replaceAll("\r\n", StringUtils.LF).replaceAll(" *\n *", StringUtils.LF).replaceAll(StringUtils.LF, StringUtils.SPACE).replaceAll("[ \t\\x0B\f\r]+", StringUtils.SPACE), -9223372036854775807L, -9223372036854775807L, null, null, "", null, null);
    }

    public static zzamv b(String str, long j2, long j3, zzanb zzanbVar, String[] strArr, String str2, String str3, zzamv zzamvVar) {
        return new zzamv(str, null, j2, j3, zzanbVar, strArr, str2, str3, zzamvVar);
    }

    public static SpannableStringBuilder i(String str, TreeMap treeMap) {
        if (!treeMap.containsKey(str)) {
            zzcw zzcwVar = new zzcw();
            zzcwVar.a(new SpannableStringBuilder());
            treeMap.put(str, zzcwVar);
        }
        CharSequence charSequence = ((zzcw) treeMap.get(str)).f27256a;
        charSequence.getClass();
        return (SpannableStringBuilder) charSequence;
    }

    public final boolean c(long j2) {
        long j3 = this.f23657d;
        long j4 = this.f23658e;
        if (j3 == -9223372036854775807L) {
            if (j4 == -9223372036854775807L) {
                return true;
            }
            j3 = -9223372036854775807L;
        }
        if (j3 <= j2 && j4 == -9223372036854775807L) {
            return true;
        }
        if (j3 != -9223372036854775807L || j2 >= j4) {
            return j3 <= j2 && j2 < j4;
        }
        return true;
    }

    public final zzamv d(int i2) {
        ArrayList arrayList = this.f23666m;
        if (arrayList != null) {
            return (zzamv) arrayList.get(i2);
        }
        throw new IndexOutOfBoundsException();
    }

    public final int e() {
        ArrayList arrayList = this.f23666m;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public final void f(TreeSet treeSet, boolean z) {
        String str = this.f23654a;
        boolean zEquals = "p".equals(str);
        if (z || zEquals || ("div".equals(str) && this.f23662i != null)) {
            long j2 = this.f23657d;
            if (j2 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j2));
            }
            long j3 = this.f23658e;
            if (j3 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j3));
            }
        }
        if (this.f23666m != null) {
            for (int i2 = 0; i2 < this.f23666m.size(); i2++) {
                zzamv zzamvVar = (zzamv) this.f23666m.get(i2);
                boolean z2 = true;
                if (!z && !zEquals) {
                    z2 = false;
                }
                zzamvVar.f(treeSet, z2);
            }
        }
    }

    public final void g(long j2, String str, ArrayList arrayList) {
        String str2;
        String str3 = this.f23661h;
        boolean zEquals = "".equals(str3);
        boolean zC = c(j2);
        if (true != zEquals) {
            str = str3;
        }
        if (zC && "div".equals(this.f23654a) && (str2 = this.f23662i) != null) {
            arrayList.add(new Pair(str, str2));
            return;
        }
        for (int i2 = 0; i2 < e(); i2++) {
            d(i2).g(j2, str, arrayList);
        }
    }

    public final void h(long j2, boolean z, String str, TreeMap treeMap) {
        long j3;
        boolean z2;
        HashMap map = this.f23664k;
        map.clear();
        HashMap map2 = this.f23665l;
        map2.clear();
        String str2 = this.f23654a;
        if ("metadata".equals(str2)) {
            return;
        }
        String str3 = this.f23661h;
        String str4 = true != "".equals(str3) ? str3 : str;
        if (this.f23656c && z) {
            SpannableStringBuilder spannableStringBuilderI = i(str4, treeMap);
            String str5 = this.f23655b;
            str5.getClass();
            spannableStringBuilderI.append((CharSequence) str5);
            return;
        }
        if ("br".equals(str2) && z) {
            i(str4, treeMap).append('\n');
            return;
        }
        if (c(j2)) {
            for (Map.Entry entry : treeMap.entrySet()) {
                String str6 = (String) entry.getKey();
                CharSequence charSequence = ((zzcw) entry.getValue()).f27256a;
                charSequence.getClass();
                map.put(str6, Integer.valueOf(charSequence.length()));
            }
            boolean zEquals = "p".equals(str2);
            for (int i2 = 0; i2 < e(); i2++) {
                zzamv zzamvVarD = d(i2);
                if (z || zEquals) {
                    j3 = j2;
                    z2 = true;
                } else {
                    j3 = j2;
                    z2 = false;
                }
                zzamvVarD.h(j3, z2, str4, treeMap);
            }
            if (zEquals) {
                SpannableStringBuilder spannableStringBuilderI2 = i(str4, treeMap);
                int length = spannableStringBuilderI2.length();
                do {
                    length--;
                    if (length < 0) {
                        break;
                    }
                } while (spannableStringBuilderI2.charAt(length) == ' ');
                if (length >= 0 && spannableStringBuilderI2.charAt(length) != '\n') {
                    spannableStringBuilderI2.append('\n');
                }
            }
            for (Map.Entry entry2 : treeMap.entrySet()) {
                String str7 = (String) entry2.getKey();
                CharSequence charSequence2 = ((zzcw) entry2.getValue()).f27256a;
                charSequence2.getClass();
                map2.put(str7, Integer.valueOf(charSequence2.length()));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:141:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00bc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j(long r21, java.util.Map r23, java.util.HashMap r24, java.lang.String r25, java.util.TreeMap r26) {
        /*
            Method dump skipped, instructions count: 759
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzamv.j(long, java.util.Map, java.util.HashMap, java.lang.String, java.util.TreeMap):void");
    }
}
