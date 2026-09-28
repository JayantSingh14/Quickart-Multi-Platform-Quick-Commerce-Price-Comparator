package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes4.dex */
public final class zzanp {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f23784a = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)((?:.|\\f)*)?$");

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f23785b = Pattern.compile("(\\S+?):(\\S+)");

    /* renamed from: c, reason: collision with root package name */
    public static final Map f23786c;

    /* renamed from: d, reason: collision with root package name */
    public static final Map f23787d;

    static {
        HashMap map = new HashMap();
        android.support.v4.media.a.p(255, 255, 255, map, "white");
        android.support.v4.media.a.p(0, 255, 0, map, "lime");
        android.support.v4.media.a.p(0, 255, 255, map, "cyan");
        android.support.v4.media.a.p(255, 0, 0, map, "red");
        android.support.v4.media.a.p(255, 255, 0, map, "yellow");
        android.support.v4.media.a.p(255, 0, 255, map, "magenta");
        android.support.v4.media.a.p(0, 0, 255, map, "blue");
        android.support.v4.media.a.p(0, 0, 0, map, "black");
        f23786c = Collections.unmodifiableMap(map);
        HashMap map2 = new HashMap();
        android.support.v4.media.a.p(255, 255, 255, map2, "bg_white");
        android.support.v4.media.a.p(0, 255, 0, map2, "bg_lime");
        android.support.v4.media.a.p(0, 255, 255, map2, "bg_cyan");
        android.support.v4.media.a.p(255, 0, 0, map2, "bg_red");
        android.support.v4.media.a.p(255, 255, 0, map2, "bg_yellow");
        android.support.v4.media.a.p(255, 0, 255, map2, "bg_magenta");
        android.support.v4.media.a.p(0, 0, 255, map2, "bg_blue");
        android.support.v4.media.a.p(0, 0, 0, map2, "bg_black");
        f23787d = Collections.unmodifiableMap(map2);
    }

    /* JADX WARN: Removed duplicated region for block: B:129:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a2 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x013c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.text.SpannedString a(java.lang.String r19, java.lang.String r20, java.util.List r21) {
        /*
            Method dump skipped, instructions count: 648
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzanp.a(java.lang.String, java.lang.String, java.util.List):android.text.SpannedString");
    }

    public static zzanj b(String str, Matcher matcher, zzer zzerVar, ArrayList arrayList) {
        zzano zzanoVar = new zzano();
        try {
            String strGroup = matcher.group(1);
            if (strGroup == null) {
                throw null;
            }
            zzanoVar.f23773a = zzanr.a(strGroup);
            String strGroup2 = matcher.group(2);
            if (strGroup2 == null) {
                throw null;
            }
            zzanoVar.f23774b = zzanr.a(strGroup2);
            String strGroup3 = matcher.group(3);
            strGroup3.getClass();
            c(strGroup3, zzanoVar);
            StringBuilder sb = new StringBuilder();
            String strN = zzerVar.n(StandardCharsets.UTF_8);
            while (!TextUtils.isEmpty(strN)) {
                if (sb.length() > 0) {
                    sb.append(StringUtils.LF);
                }
                sb.append(strN.trim());
                strN = zzerVar.n(StandardCharsets.UTF_8);
            }
            zzanoVar.f23775c = a(str, sb.toString(), arrayList);
            return new zzanj(zzanoVar.a().b(), zzanoVar.f23773a, zzanoVar.f23774b);
        } catch (IllegalArgumentException unused) {
            zzee.c("WebvttCueParser", "Skipping cue with bad header: ".concat(String.valueOf(matcher.group())));
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0167  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void c(java.lang.String r17, com.google.android.gms.internal.ads.zzano r18) {
        /*
            Method dump skipped, instructions count: 606
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzanp.c(java.lang.String, com.google.android.gms.internal.ads.zzano):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void d(java.lang.String r18, com.google.android.gms.internal.ads.zzanm r19, java.util.List r20, android.text.SpannableStringBuilder r21, java.util.List r22) {
        /*
            Method dump skipped, instructions count: 630
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzanp.d(java.lang.String, com.google.android.gms.internal.ads.zzanm, java.util.List, android.text.SpannableStringBuilder, java.util.List):void");
    }

    public static int e(List list, String str, zzanm zzanmVar) {
        ArrayList arrayListF = f(list, str, zzanmVar);
        for (int i2 = 0; i2 < arrayListF.size(); i2++) {
            int i3 = ((zzann) arrayListF.get(i2)).f23772b.o;
            if (i3 != -1) {
                return i3;
            }
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.ArrayList f(java.util.List r8, java.lang.String r9, com.google.android.gms.internal.ads.zzanm r10) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            r2 = r1
        L7:
            int r3 = r8.size()
            if (r2 >= r3) goto L7a
            java.lang.Object r3 = r8.get(r2)
            com.google.android.gms.internal.ads.zzani r3 = (com.google.android.gms.internal.ads.zzani) r3
            java.lang.String r4 = r10.f23767a
            java.lang.String r5 = r3.f23747a
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L3f
            java.lang.String r5 = r3.f23748b
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L3f
            java.util.Set r5 = r3.f23749c
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L3f
            java.lang.String r5 = r3.f23750d
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L3f
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 == 0) goto L3d
            r4 = 1
            goto L6d
        L3d:
            r4 = r1
            goto L6d
        L3f:
            java.lang.String r5 = r3.f23747a
            r6 = 1073741824(0x40000000, float:2.0)
            int r5 = com.google.android.gms.internal.ads.zzani.a(r1, r6, r5, r9)
            java.lang.String r6 = r3.f23748b
            r7 = 2
            int r4 = com.google.android.gms.internal.ads.zzani.a(r5, r7, r6, r4)
            java.lang.String r5 = r3.f23750d
            java.lang.String r6 = r10.f23769c
            r7 = 4
            int r4 = com.google.android.gms.internal.ads.zzani.a(r4, r7, r5, r6)
            r5 = -1
            if (r4 == r5) goto L3d
            java.util.Set r5 = r3.f23749c
            java.util.Set r6 = r10.f23770d
            boolean r5 = r6.containsAll(r5)
            if (r5 != 0) goto L65
            goto L3d
        L65:
            java.util.Set r5 = r3.f23749c
            int r5 = r5.size()
            int r5 = r5 * r7
            int r4 = r4 + r5
        L6d:
            if (r4 <= 0) goto L77
            com.google.android.gms.internal.ads.zzann r5 = new com.google.android.gms.internal.ads.zzann
            r5.<init>(r4, r3)
            r0.add(r5)
        L77:
            int r2 = r2 + 1
            goto L7
        L7a:
            java.util.Collections.sort(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzanp.f(java.util.List, java.lang.String, com.google.android.gms.internal.ads.zzanm):java.util.ArrayList");
    }
}
