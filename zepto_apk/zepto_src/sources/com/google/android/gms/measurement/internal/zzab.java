package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* loaded from: classes4.dex */
abstract class zzab {

    /* renamed from: a, reason: collision with root package name */
    public final String f38660a;

    /* renamed from: b, reason: collision with root package name */
    public final int f38661b;

    /* renamed from: c, reason: collision with root package name */
    public Boolean f38662c;

    /* renamed from: d, reason: collision with root package name */
    public Boolean f38663d;

    /* renamed from: e, reason: collision with root package name */
    public Long f38664e;

    /* renamed from: f, reason: collision with root package name */
    public Long f38665f;

    public zzab(String str, int i2) {
        this.f38660a = str;
        this.f38661b = i2;
    }

    public static Boolean d(Boolean bool, boolean z) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() != z);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static Boolean e(String str, com.google.android.gms.internal.measurement.zzfr zzfrVar, zzgt zzgtVar) {
        List listX;
        Preconditions.checkNotNull(zzfrVar);
        if (str != null && zzfrVar.s() && zzfrVar.A() != 1 && (zzfrVar.A() != 7 ? zzfrVar.t() : zzfrVar.y() != 0)) {
            int iA = zzfrVar.A();
            boolean zW = zzfrVar.w();
            String strU = (zW || iA == 2 || iA == 7) ? zzfrVar.u() : zzfrVar.u().toUpperCase(Locale.ENGLISH);
            if (zzfrVar.y() == 0) {
                listX = null;
            } else {
                listX = zzfrVar.x();
                if (!zW) {
                    ArrayList arrayList = new ArrayList(listX.size());
                    Iterator it = listX.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((String) it.next()).toUpperCase(Locale.ENGLISH));
                    }
                    listX = Collections.unmodifiableList(arrayList);
                }
            }
            String str2 = iA == 2 ? strU : null;
            if (iA != 7 ? strU != null : listX != null && !listX.isEmpty()) {
                if (!zW && iA != 2) {
                    str = str.toUpperCase(Locale.ENGLISH);
                }
                switch (iA - 1) {
                    case 1:
                        if (str2 != null) {
                            try {
                                return Boolean.valueOf(Pattern.compile(str2, true != zW ? 66 : 0).matcher(str).matches());
                            } catch (PatternSyntaxException unused) {
                                if (zzgtVar != null) {
                                    zzgtVar.f38961i.b(str2, "Invalid regular expression in REGEXP audience filter. expression");
                                    break;
                                }
                            }
                        }
                        break;
                    case 2:
                        return Boolean.valueOf(str.startsWith(strU));
                    case 3:
                        return Boolean.valueOf(str.endsWith(strU));
                    case 4:
                        return Boolean.valueOf(str.contains(strU));
                    case 5:
                        return Boolean.valueOf(str.equals(strU));
                    case 6:
                        if (listX != null) {
                            return Boolean.valueOf(listX.contains(str));
                        }
                        break;
                }
            }
        }
        return null;
    }

    public static Boolean f(long j2, com.google.android.gms.internal.measurement.zzfl zzflVar) {
        try {
            return g(new BigDecimal(j2), zzflVar, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0107  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Boolean g(java.math.BigDecimal r8, com.google.android.gms.internal.measurement.zzfl r9, double r10) {
        /*
            Method dump skipped, instructions count: 280
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzab.g(java.math.BigDecimal, com.google.android.gms.internal.measurement.zzfl, double):java.lang.Boolean");
    }

    public abstract int a();

    public abstract boolean b();

    public abstract boolean c();
}
