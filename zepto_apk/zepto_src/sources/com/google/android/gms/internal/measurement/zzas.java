package com.google.android.gms.internal.measurement;

import android.support.v4.media.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.CharUtils;
import org.xbill.DNS.TTL;

/* loaded from: classes4.dex */
public final class zzas implements Iterable, zzao {

    /* renamed from: a, reason: collision with root package name */
    public final String f36775a;

    public zzas(String str) {
        if (str == null) {
            throw new IllegalArgumentException("StringValue cannot be null.");
        }
        this.f36775a = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzas) {
            return this.f36775a.equals(((zzas) obj).f36775a);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final zzao f() {
        return new zzas(this.f36775a);
    }

    public final int hashCode() {
        return this.f36775a.hashCode();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.zzao
    public final zzao i(String str, zzg zzgVar, ArrayList arrayList) {
        String str2;
        String str3;
        String str4;
        String str5;
        char c2;
        int i2;
        String strZzc;
        int i3;
        int i4;
        int i5;
        zzg zzgVar2;
        int iH;
        if ("charAt".equals(str) || "concat".equals(str) || "hasOwnProperty".equals(str) || "indexOf".equals(str) || "lastIndexOf".equals(str) || "match".equals(str) || "replace".equals(str) || "search".equals(str) || "slice".equals(str) || "split".equals(str) || "substring".equals(str) || "toLowerCase".equals(str) || "toLocaleLowerCase".equals(str) || "toString".equals(str) || "toUpperCase".equals(str) || "toLocaleUpperCase".equals(str)) {
            str2 = "hasOwnProperty";
            str3 = "trim";
        } else {
            str2 = "hasOwnProperty";
            str3 = "trim";
            if (!str3.equals(str)) {
                throw new IllegalArgumentException(str.concat(" is not a String function"));
            }
        }
        switch (str.hashCode()) {
            case -1789698943:
                str4 = str2;
                str5 = "charAt";
                if (str.equals(str4)) {
                    c2 = 2;
                    break;
                } else {
                    c2 = 65535;
                    break;
                }
            case -1776922004:
                str5 = "charAt";
                if (str.equals("toString")) {
                    c2 = 14;
                    str4 = str2;
                    break;
                }
                str4 = str2;
                c2 = 65535;
                break;
            case -1464939364:
                str5 = "charAt";
                if (str.equals("toLocaleLowerCase")) {
                    c2 = '\f';
                    str4 = str2;
                    break;
                }
                str4 = str2;
                c2 = 65535;
                break;
            case -1361633751:
                str5 = "charAt";
                if (str.equals(str5)) {
                    str4 = str2;
                    c2 = 0;
                    break;
                }
                str4 = str2;
                c2 = 65535;
                break;
            case -1354795244:
                if (str.equals("concat")) {
                    str4 = str2;
                    str5 = "charAt";
                    c2 = 1;
                    break;
                }
                str4 = str2;
                str5 = "charAt";
                c2 = 65535;
                break;
            case -1137582698:
                if (str.equals("toLowerCase")) {
                    c2 = CharUtils.CR;
                    str4 = str2;
                    str5 = "charAt";
                    break;
                }
                str4 = str2;
                str5 = "charAt";
                c2 = 65535;
                break;
            case -906336856:
                if (str.equals("search")) {
                    c2 = 7;
                    str4 = str2;
                    str5 = "charAt";
                    break;
                }
                str4 = str2;
                str5 = "charAt";
                c2 = 65535;
                break;
            case -726908483:
                if (str.equals("toLocaleUpperCase")) {
                    c2 = 11;
                    str4 = str2;
                    str5 = "charAt";
                    break;
                }
                str4 = str2;
                str5 = "charAt";
                c2 = 65535;
                break;
            case -467511597:
                if (str.equals("lastIndexOf")) {
                    c2 = 4;
                    str4 = str2;
                    str5 = "charAt";
                    break;
                }
                str4 = str2;
                str5 = "charAt";
                c2 = 65535;
                break;
            case -399551817:
                if (str.equals("toUpperCase")) {
                    c2 = 15;
                    str4 = str2;
                    str5 = "charAt";
                    break;
                }
                str4 = str2;
                str5 = "charAt";
                c2 = 65535;
                break;
            case 3568674:
                if (str.equals(str3)) {
                    c2 = 16;
                    str4 = str2;
                    str5 = "charAt";
                    break;
                }
                str4 = str2;
                str5 = "charAt";
                c2 = 65535;
                break;
            case 103668165:
                if (str.equals("match")) {
                    c2 = 5;
                    str4 = str2;
                    str5 = "charAt";
                    break;
                }
                str4 = str2;
                str5 = "charAt";
                c2 = 65535;
                break;
            case 109526418:
                if (str.equals("slice")) {
                    c2 = '\b';
                    str4 = str2;
                    str5 = "charAt";
                    break;
                }
                str4 = str2;
                str5 = "charAt";
                c2 = 65535;
                break;
            case 109648666:
                if (str.equals("split")) {
                    c2 = '\t';
                    str4 = str2;
                    str5 = "charAt";
                    break;
                }
                str4 = str2;
                str5 = "charAt";
                c2 = 65535;
                break;
            case 530542161:
                if (str.equals("substring")) {
                    c2 = '\n';
                    str4 = str2;
                    str5 = "charAt";
                    break;
                }
                str4 = str2;
                str5 = "charAt";
                c2 = 65535;
                break;
            case 1094496948:
                if (str.equals("replace")) {
                    c2 = 6;
                    str4 = str2;
                    str5 = "charAt";
                    break;
                }
                str4 = str2;
                str5 = "charAt";
                c2 = 65535;
                break;
            case 1943291465:
                if (str.equals("indexOf")) {
                    str4 = str2;
                    str5 = "charAt";
                    c2 = 3;
                    break;
                }
                str4 = str2;
                str5 = "charAt";
                c2 = 65535;
                break;
            default:
                str4 = str2;
                str5 = "charAt";
                c2 = 65535;
                break;
        }
        char c3 = c2;
        String str6 = this.f36775a;
        switch (c3) {
            case 0:
                zzh.c(1, str5, arrayList);
                int iH2 = !arrayList.isEmpty() ? (int) zzh.h(zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(0)).zzd().doubleValue()) : 0;
                return (iH2 < 0 || iH2 >= str6.length()) ? zzao.v0 : new zzas(String.valueOf(str6.charAt(iH2)));
            case 1:
                if (!arrayList.isEmpty()) {
                    StringBuilder sb = new StringBuilder(str6);
                    for (int i6 = 0; i6 < arrayList.size(); i6++) {
                        sb.append(zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(i6)).zzc());
                    }
                    return new zzas(sb.toString());
                }
                return this;
            case 2:
                zzh.a(str4, arrayList, 1);
                zzao zzaoVarB = zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(0));
                boolean zEquals = "length".equals(zzaoVarB.zzc());
                zzaf zzafVar = zzao.t0;
                if (zEquals) {
                    return zzafVar;
                }
                double dDoubleValue = zzaoVarB.zzd().doubleValue();
                return (dDoubleValue != Math.floor(dDoubleValue) || (i2 = (int) dDoubleValue) < 0 || i2 >= str6.length()) ? zzao.u0 : zzafVar;
            case 3:
                zzh.c(2, "indexOf", arrayList);
                return new zzah(Double.valueOf(str6.indexOf(arrayList.size() > 0 ? zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(0)).zzc() : "undefined", (int) zzh.h(arrayList.size() < 2 ? 0.0d : zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(1)).zzd().doubleValue()))));
            case 4:
                zzh.c(2, "lastIndexOf", arrayList);
                String strZzc2 = arrayList.size() > 0 ? zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(0)).zzc() : "undefined";
                return new zzah(Double.valueOf(str6.lastIndexOf(strZzc2, (int) (Double.isNaN(arrayList.size() < 2 ? Double.NaN : zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(1)).zzd().doubleValue()) ? Double.POSITIVE_INFINITY : zzh.h(r3)))));
            case 5:
                zzh.c(1, "match", arrayList);
                Matcher matcher = Pattern.compile(arrayList.size() <= 0 ? "" : zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(0)).zzc()).matcher(str6);
                return matcher.find() ? new zzae(Arrays.asList(new zzas(matcher.group()))) : zzao.p0;
            case 6:
                zzh.c(2, "replace", arrayList);
                boolean zIsEmpty = arrayList.isEmpty();
                zzao zzaoVarA = zzao.o0;
                if (!zIsEmpty) {
                    strZzc = zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(0)).zzc();
                    if (arrayList.size() > 1) {
                        zzaoVarA = zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(1));
                    }
                }
                String str7 = strZzc;
                int iIndexOf = str6.indexOf(str7);
                if (iIndexOf >= 0) {
                    if (zzaoVarA instanceof zzai) {
                        i3 = 0;
                        zzaoVarA = ((zzai) zzaoVarA).a(zzgVar, Arrays.asList(new zzas(str7), new zzah(Double.valueOf(iIndexOf)), this));
                    } else {
                        i3 = 0;
                    }
                    String strSubstring = str6.substring(i3, iIndexOf);
                    String strZzc3 = zzaoVarA.zzc();
                    String strSubstring2 = str6.substring(str7.length() + iIndexOf);
                    return new zzas(b.s(new StringBuilder(String.valueOf(strSubstring).length() + String.valueOf(strZzc3).length() + String.valueOf(strSubstring2).length()), strSubstring, strZzc3, strSubstring2));
                }
                return this;
            case 7:
                zzh.c(1, "search", arrayList);
                return Pattern.compile(arrayList.isEmpty() ? "undefined" : zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(0)).zzc()).matcher(str6).find() ? new zzah(Double.valueOf(r1.start())) : new zzah(Double.valueOf(-1.0d));
            case '\b':
                zzh.c(2, "slice", arrayList);
                double dH = zzh.h(!arrayList.isEmpty() ? zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(0)).zzd().doubleValue() : 0.0d);
                double dMax = dH < 0.0d ? Math.max(str6.length() + dH, 0.0d) : Math.min(dH, str6.length());
                double dH2 = zzh.h(arrayList.size() > 1 ? zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(1)).zzd().doubleValue() : str6.length());
                int i7 = (int) dMax;
                return new zzas(str6.substring(i7, Math.max(0, ((int) (dH2 < 0.0d ? Math.max(str6.length() + dH2, 0.0d) : Math.min(dH2, str6.length()))) - i7) + i7));
            case '\t':
                zzh.c(2, "split", arrayList);
                if (str6.length() == 0) {
                    return new zzae(Arrays.asList(this));
                }
                ArrayList arrayList2 = new ArrayList();
                if (arrayList.isEmpty()) {
                    arrayList2.add(this);
                } else {
                    String strZzc4 = zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(0)).zzc();
                    long jG = arrayList.size() > 1 ? zzh.g(zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(1)).zzd().doubleValue()) & 4294967295L : TTL.MAX_VALUE;
                    if (jG == 0) {
                        return new zzae();
                    }
                    String[] strArrSplit = str6.split(Pattern.quote(strZzc4), ((int) jG) + 1);
                    int length = strArrSplit.length;
                    if (!strZzc4.isEmpty() || length <= 0) {
                        i4 = length;
                        i5 = 0;
                    } else {
                        boolean zIsEmpty2 = strArrSplit[0].isEmpty();
                        i4 = length - 1;
                        i5 = zIsEmpty2;
                        if (!strArrSplit[i4].isEmpty()) {
                            i4 = length;
                            i5 = zIsEmpty2;
                        }
                    }
                    if (length > jG) {
                        i4--;
                    }
                    while (i5 < i4) {
                        arrayList2.add(new zzas(strArrSplit[i5]));
                        i5++;
                    }
                }
                return new zzae(arrayList2);
            case '\n':
                zzh.c(2, "substring", arrayList);
                if (arrayList.isEmpty()) {
                    zzgVar2 = zzgVar;
                    iH = 0;
                } else {
                    zzgVar2 = zzgVar;
                    iH = (int) zzh.h(zzgVar2.f36956b.b(zzgVar2, (zzao) arrayList.get(0)).zzd().doubleValue());
                }
                int iH3 = arrayList.size() > 1 ? (int) zzh.h(zzgVar2.f36956b.b(zzgVar2, (zzao) arrayList.get(1)).zzd().doubleValue()) : str6.length();
                int iMin = Math.min(Math.max(iH, 0), str6.length());
                int iMin2 = Math.min(Math.max(iH3, 0), str6.length());
                return new zzas(str6.substring(Math.min(iMin, iMin2), Math.max(iMin, iMin2)));
            case 11:
                zzh.a("toLocaleUpperCase", arrayList, 0);
                return new zzas(str6.toUpperCase());
            case '\f':
                zzh.a("toLocaleLowerCase", arrayList, 0);
                return new zzas(str6.toLowerCase());
            case '\r':
                zzh.a("toLowerCase", arrayList, 0);
                return new zzas(str6.toLowerCase(Locale.ENGLISH));
            case 14:
                zzh.a("toString", arrayList, 0);
                return this;
            case 15:
                zzh.a("toUpperCase", arrayList, 0);
                return new zzas(str6.toUpperCase(Locale.ENGLISH));
            case 16:
                zzh.a("toUpperCase", arrayList, 0);
                return new zzas(str6.trim());
            default:
                throw new IllegalArgumentException("Command not supported");
        }
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new zzar(this);
    }

    public final String toString() {
        String str = this.f36775a;
        return b.s(new StringBuilder(str.length() + 2), "\"", str, "\"");
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final String zzc() {
        return this.f36775a;
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final Double zzd() {
        String str = this.f36775a;
        if (str.isEmpty()) {
            return Double.valueOf(0.0d);
        }
        try {
            return Double.valueOf(str);
        } catch (NumberFormatException unused) {
            return Double.valueOf(Double.NaN);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final Boolean zze() {
        return Boolean.valueOf(!this.f36775a.isEmpty());
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final Iterator zzf() {
        return new zzaq(this);
    }
}
