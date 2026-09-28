package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableStringBuilder;
import android.util.Base64;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/* loaded from: classes4.dex */
final class zzanc implements zzalt {

    /* renamed from: a, reason: collision with root package name */
    public final zzamv f23717a;

    /* renamed from: b, reason: collision with root package name */
    public final long[] f23718b;

    /* renamed from: c, reason: collision with root package name */
    public final Map f23719c;

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f23720d;

    /* renamed from: e, reason: collision with root package name */
    public final HashMap f23721e;

    public zzanc(zzamv zzamvVar, HashMap map, HashMap map2, HashMap map3) {
        this.f23717a = zzamvVar;
        this.f23720d = map2;
        this.f23721e = map3;
        this.f23719c = Collections.unmodifiableMap(map);
        TreeSet treeSet = new TreeSet();
        int i2 = 0;
        zzamvVar.f(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            jArr[i2] = ((Long) it.next()).longValue();
            i2++;
        }
        this.f23718b = jArr;
    }

    @Override // com.google.android.gms.internal.ads.zzalt
    public final ArrayList b(long j2) {
        zzamv zzamvVar = this.f23717a;
        ArrayList arrayList = new ArrayList();
        String str = zzamvVar.f23661h;
        zzamvVar.g(j2, str, arrayList);
        TreeMap treeMap = new TreeMap();
        zzamvVar.h(j2, false, str, treeMap);
        HashMap map = this.f23720d;
        zzamvVar.j(j2, this.f23719c, map, str, treeMap);
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            Pair pair = (Pair) arrayList.get(i2);
            String str2 = (String) this.f23721e.get(pair.second);
            if (str2 != null) {
                byte[] bArrDecode = Base64.decode(str2, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                zzamz zzamzVar = (zzamz) map.get(pair.first);
                zzamzVar.getClass();
                zzcw zzcwVar = new zzcw();
                zzcwVar.f27257b = bitmapDecodeByteArray;
                zzcwVar.f27256a = null;
                zzcwVar.f27263h = zzamzVar.f23682b;
                zzcwVar.f27264i = 0;
                zzcwVar.f27260e = zzamzVar.f23683c;
                zzcwVar.f27261f = 0;
                zzcwVar.f27262g = zzamzVar.f23685e;
                zzcwVar.f27267l = zzamzVar.f23686f;
                zzcwVar.f27268m = zzamzVar.f23687g;
                zzcwVar.n = zzamzVar.f23690j;
                arrayList2.add(zzcwVar.b());
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            zzamz zzamzVar2 = (zzamz) map.get(entry.getKey());
            zzamzVar2.getClass();
            zzcw zzcwVar2 = (zzcw) entry.getValue();
            CharSequence charSequence = zzcwVar2.f27256a;
            charSequence.getClass();
            SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) charSequence;
            for (zzamt zzamtVar : (zzamt[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), zzamt.class)) {
                spannableStringBuilder.replace(spannableStringBuilder.getSpanStart(zzamtVar), spannableStringBuilder.getSpanEnd(zzamtVar), (CharSequence) "");
            }
            int i3 = 0;
            while (i3 < spannableStringBuilder.length()) {
                int i4 = i3 + 1;
                if (spannableStringBuilder.charAt(i3) == ' ') {
                    int i5 = i4;
                    while (i5 < spannableStringBuilder.length() && spannableStringBuilder.charAt(i5) == ' ') {
                        i5++;
                    }
                    int i6 = i5 - i4;
                    if (i6 > 0) {
                        spannableStringBuilder.delete(i3, i6 + i3);
                    }
                }
                i3 = i4;
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(0) == ' ') {
                spannableStringBuilder.delete(0, 1);
            }
            int i7 = 0;
            while (i7 < spannableStringBuilder.length() - 1) {
                int i8 = i7 + 1;
                if (spannableStringBuilder.charAt(i7) == '\n' && spannableStringBuilder.charAt(i8) == ' ') {
                    spannableStringBuilder.delete(i8, i7 + 2);
                }
                i7 = i8;
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == ' ') {
                spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
            }
            int i9 = 0;
            while (i9 < spannableStringBuilder.length() - 1) {
                int i10 = i9 + 1;
                if (spannableStringBuilder.charAt(i9) == ' ' && spannableStringBuilder.charAt(i10) == '\n') {
                    spannableStringBuilder.delete(i9, i10);
                }
                i9 = i10;
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == '\n') {
                spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
            }
            zzcwVar2.f27260e = zzamzVar2.f23683c;
            zzcwVar2.f27261f = zzamzVar2.f23684d;
            zzcwVar2.f27262g = zzamzVar2.f23685e;
            zzcwVar2.f27263h = zzamzVar2.f23682b;
            zzcwVar2.f27267l = zzamzVar2.f23686f;
            zzcwVar2.f27266k = zzamzVar2.f23689i;
            zzcwVar2.f27265j = zzamzVar2.f23688h;
            zzcwVar2.n = zzamzVar2.f23690j;
            arrayList2.add(zzcwVar2.b());
        }
        return arrayList2;
    }

    @Override // com.google.android.gms.internal.ads.zzalt
    public final int zza() {
        return this.f23718b.length;
    }

    @Override // com.google.android.gms.internal.ads.zzalt
    public final long zzb(int i2) {
        return this.f23718b[i2];
    }
}
