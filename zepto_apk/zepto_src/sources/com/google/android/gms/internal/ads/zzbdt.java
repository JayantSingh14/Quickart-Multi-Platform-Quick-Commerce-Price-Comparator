package com.google.android.gms.internal.ads;

import java.util.PriorityQueue;
import javax.annotation.ParametersAreNonnullByDefault;
import org.xbill.DNS.TTL;

@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public final class zzbdt {
    public static void a(int i2, long j2, String str, int i3, PriorityQueue priorityQueue) {
        zzbds zzbdsVar = new zzbds(i3, j2, str);
        if ((priorityQueue.size() != i2 || (((zzbds) priorityQueue.peek()).f24811c <= i3 && ((zzbds) priorityQueue.peek()).f24809a <= j2)) && !priorityQueue.contains(zzbdsVar)) {
            priorityQueue.add(zzbdsVar);
            if (priorityQueue.size() > i2) {
                priorityQueue.poll();
            }
        }
    }

    public static String b(String[] strArr, int i2, int i3) {
        int i4 = i3 + i2;
        if (strArr.length < i4) {
            int i5 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.c("Unable to construct shingle");
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i6 = i4 - 1;
            if (i2 >= i6) {
                sb.append(strArr[i6]);
                return sb.toString();
            }
            sb.append(strArr[i2]);
            sb.append(' ');
            i2++;
        }
    }

    public static long c(int i2, long j2) {
        if (i2 == 1) {
            return j2;
        }
        int i3 = i2 >> 1;
        long j3 = (j2 * j2) % 1073807359;
        return (i2 & 1) == 0 ? c(i3, j3) % 1073807359 : ((c(i3, j3) % 1073807359) * j2) % 1073807359;
    }

    public static long d(int i2, String[] strArr) {
        long jA = (zzbdq.a(strArr[0]) + TTL.MAX_VALUE) % 1073807359;
        for (int i3 = 1; i3 < i2; i3++) {
            jA = (((zzbdq.a(strArr[i3]) + TTL.MAX_VALUE) % 1073807359) + ((jA * 16785407) % 1073807359)) % 1073807359;
        }
        return jA;
    }
}
