package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.time.DateUtils;

/* loaded from: classes4.dex */
public final class zzams implements zzaly {

    /* renamed from: d, reason: collision with root package name */
    public static final Pattern f23641d = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d{3}))?)\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d{3}))?)\\s*");

    /* renamed from: e, reason: collision with root package name */
    public static final Pattern f23642e = Pattern.compile("\\{\\\\.*?\\}");

    /* renamed from: a, reason: collision with root package name */
    public final StringBuilder f23643a = new StringBuilder();

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f23644b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final zzer f23645c = new zzer();

    public static long b(Matcher matcher, int i2) {
        String strGroup = matcher.group(i2 + 1);
        long j2 = strGroup != null ? Long.parseLong(strGroup) * DateUtils.MILLIS_PER_HOUR : 0L;
        String strGroup2 = matcher.group(i2 + 2);
        strGroup2.getClass();
        long j3 = (Long.parseLong(strGroup2) * DateUtils.MILLIS_PER_MINUTE) + j2;
        String strGroup3 = matcher.group(i2 + 3);
        strGroup3.getClass();
        long j4 = (Long.parseLong(strGroup3) * 1000) + j3;
        String strGroup4 = matcher.group(i2 + 4);
        if (strGroup4 != null) {
            j4 += Long.parseLong(strGroup4);
        }
        return j4 * 1000;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0182  */
    @Override // com.google.android.gms.internal.ads.zzaly
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(byte[] r18, int r19, int r20, com.google.android.gms.internal.ads.zzdr r21) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 568
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzams.a(byte[], int, int, com.google.android.gms.internal.ads.zzdr):void");
    }
}
