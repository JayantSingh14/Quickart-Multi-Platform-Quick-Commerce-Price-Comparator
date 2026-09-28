package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;
import org.apache.commons.lang3.StringUtils;
import org.xbill.DNS.TTL;

/* loaded from: classes4.dex */
public final class zzbdp {

    /* renamed from: a, reason: collision with root package name */
    public final int f24806a;

    /* renamed from: b, reason: collision with root package name */
    public final zzbdr f24807b = new zzbdr();

    public zzbdp(int i2) {
        this.f24806a = i2;
    }

    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v2 */
    public final String a(ArrayList arrayList) throws IOException {
        int i2;
        int i3;
        char c2 = 5;
        int i4 = 1;
        StringBuilder sb = new StringBuilder();
        int size = arrayList.size();
        ?? r5 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            sb.append(((String) arrayList.get(i5)).toLowerCase(Locale.US));
            sb.append('\n');
        }
        String[] strArrSplit = sb.toString().split(StringUtils.LF);
        if (strArrSplit.length == 0) {
            return "";
        }
        zzbdo zzbdoVar = new zzbdo();
        zzbdn zzbdnVar = new zzbdn();
        int i6 = this.f24806a;
        PriorityQueue priorityQueue = new PriorityQueue(i6, zzbdnVar);
        int i7 = 0;
        while (i7 < strArrSplit.length) {
            String[] strArrB = zzbdq.b(strArrSplit[i7], r5);
            if (strArrB.length != 0) {
                int length = strArrB.length;
                int i8 = 6;
                if (length >= 6) {
                    i3 = i6;
                    long jD = zzbdt.d(6, strArrB);
                    zzbdt.a(i3, jD, zzbdt.b(strArrB, r5, 6), 6, priorityQueue);
                    int i9 = i4;
                    while (true) {
                        int length2 = strArrB.length;
                        if (i9 >= length2 - 5) {
                            break;
                        }
                        long jA = zzbdq.a(strArrB[i9 - 1]);
                        long jA2 = zzbdq.a(strArrB[i9 + 5]);
                        String strB = zzbdt.b(strArrB, i9, i8);
                        jD = (((jA2 + TTL.MAX_VALUE) % 1073807359) + (((((jD + 1073807359) - ((((jA + TTL.MAX_VALUE) % 1073807359) * zzbdt.c(5, 16785407L)) % 1073807359)) % 1073807359) * 16785407) % 1073807359)) % 1073807359;
                        i3 = i3;
                        zzbdt.a(i3, jD, strB, length2, priorityQueue);
                        i9++;
                        c2 = 5;
                        i4 = i4;
                        i8 = 6;
                    }
                } else {
                    i3 = i6;
                    zzbdt.a(i3, zzbdt.d(length, strArrB), zzbdt.b(strArrB, r5, length), length, priorityQueue);
                }
                i2 = i4;
            } else {
                i2 = i4;
                i3 = i6;
            }
            i7++;
            c2 = c2;
            i6 = i3;
            i4 = i2;
            r5 = 0;
        }
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()) {
            try {
                zzbdoVar.f24805b.write(this.f24807b.b(((zzbds) it.next()).f24810b));
            } catch (IOException e2) {
                int i10 = com.google.android.gms.ads.internal.util.zze.f21576b;
                com.google.android.gms.ads.internal.util.client.zzo.d("Error while writing hash to byteStream", e2);
            }
        }
        return zzbdoVar.toString();
    }
}
