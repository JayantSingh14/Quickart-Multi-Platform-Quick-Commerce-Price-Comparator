package com.google.android.gms.ads.nonagon.signalgeneration;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.internal.ads.zzbgk;
import com.google.android.gms.internal.ads.zzcdo;
import com.google.android.gms.internal.ads.zzdxj;
import com.google.android.gms.internal.ads.zzfik;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public final class zzaa {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a(java.lang.String r1) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r1)
            if (r0 == 0) goto L9
            java.lang.String r1 = "unspecified"
            return r1
        L9:
            int r0 = r1.hashCode()
            switch(r0) {
                case 1743582862: goto L62;
                case 1743582863: goto L58;
                case 1743582864: goto L4e;
                case 1743582865: goto L44;
                case 1743582866: goto L3a;
                case 1743582867: goto L30;
                case 1743582868: goto L26;
                case 1743582869: goto L1c;
                case 1743582870: goto L11;
                default: goto L10;
            }
        L10:
            goto L6c
        L11:
            java.lang.String r0 = "requester_type_8"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L6c
            r0 = 8
            goto L6d
        L1c:
            java.lang.String r0 = "requester_type_7"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L6c
            r0 = 7
            goto L6d
        L26:
            java.lang.String r0 = "requester_type_6"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L6c
            r0 = 6
            goto L6d
        L30:
            java.lang.String r0 = "requester_type_5"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L6c
            r0 = 5
            goto L6d
        L3a:
            java.lang.String r0 = "requester_type_4"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L6c
            r0 = 4
            goto L6d
        L44:
            java.lang.String r0 = "requester_type_3"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L6c
            r0 = 3
            goto L6d
        L4e:
            java.lang.String r0 = "requester_type_2"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L6c
            r0 = 2
            goto L6d
        L58:
            java.lang.String r0 = "requester_type_1"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L6c
            r0 = 1
            goto L6d
        L62:
            java.lang.String r0 = "requester_type_0"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L6c
            r0 = 0
            goto L6d
        L6c:
            r0 = -1
        L6d:
            switch(r0) {
                case 0: goto L89;
                case 1: goto L86;
                case 2: goto L83;
                case 3: goto L80;
                case 4: goto L7d;
                case 5: goto L7a;
                case 6: goto L77;
                case 7: goto L74;
                case 8: goto L71;
                default: goto L70;
            }
        L70:
            return r1
        L71:
            java.lang.String r1 = "8"
            return r1
        L74:
            java.lang.String r1 = "7"
            return r1
        L77:
            java.lang.String r1 = "6"
            return r1
        L7a:
            java.lang.String r1 = "5"
            return r1
        L7d:
            java.lang.String r1 = "4"
            return r1
        L80:
            java.lang.String r1 = "3"
            return r1
        L83:
            java.lang.String r1 = "2"
            return r1
        L86:
            java.lang.String r1 = "1"
            return r1
        L89:
            java.lang.String r1 = "0"
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.nonagon.signalgeneration.zzaa.a(java.lang.String):java.lang.String");
    }

    public static String b(com.google.android.gms.ads.internal.client.zzm zzmVar) {
        Bundle bundle;
        return (zzmVar == null || (bundle = zzmVar.f21256c) == null) ? "unspecified" : bundle.getString("query_info_type");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.ads.zzfnt c(android.os.Bundle r2) {
        /*
            java.lang.String r0 = "com.google.ads.mediation.admob.AdMobAdapter"
            android.os.Bundle r0 = r2.getBundle(r0)
            if (r0 == 0) goto L9
            r2 = r0
        L9:
            java.lang.String r0 = "query_info_type"
            java.lang.String r2 = r2.getString(r0)
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            com.google.android.gms.internal.ads.zzfnt r1 = com.google.android.gms.internal.ads.zzfnt.SCAR_REQUEST_TYPE_UNSPECIFIED
            if (r0 == 0) goto L18
            return r1
        L18:
            int r0 = r2.hashCode()
            switch(r0) {
                case 1743582862: goto L71;
                case 1743582863: goto L67;
                case 1743582864: goto L5d;
                case 1743582865: goto L53;
                case 1743582866: goto L49;
                case 1743582867: goto L3f;
                case 1743582868: goto L35;
                case 1743582869: goto L2b;
                case 1743582870: goto L20;
                default: goto L1f;
            }
        L1f:
            goto L7b
        L20:
            java.lang.String r0 = "requester_type_8"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L7b
            r2 = 8
            goto L7c
        L2b:
            java.lang.String r0 = "requester_type_7"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L7b
            r2 = 7
            goto L7c
        L35:
            java.lang.String r0 = "requester_type_6"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L7b
            r2 = 6
            goto L7c
        L3f:
            java.lang.String r0 = "requester_type_5"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L7b
            r2 = 5
            goto L7c
        L49:
            java.lang.String r0 = "requester_type_4"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L7b
            r2 = 4
            goto L7c
        L53:
            java.lang.String r0 = "requester_type_3"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L7b
            r2 = 3
            goto L7c
        L5d:
            java.lang.String r0 = "requester_type_2"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L7b
            r2 = 2
            goto L7c
        L67:
            java.lang.String r0 = "requester_type_1"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L7b
            r2 = 1
            goto L7c
        L71:
            java.lang.String r0 = "requester_type_0"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L7b
            r2 = 0
            goto L7c
        L7b:
            r2 = -1
        L7c:
            switch(r2) {
                case 0: goto L98;
                case 1: goto L95;
                case 2: goto L92;
                case 3: goto L8f;
                case 4: goto L8c;
                case 5: goto L89;
                case 6: goto L86;
                case 7: goto L83;
                case 8: goto L80;
                default: goto L7f;
            }
        L7f:
            return r1
        L80:
            com.google.android.gms.internal.ads.zzfnt r2 = com.google.android.gms.internal.ads.zzfnt.SCAR_REQUEST_TYPE_GAM_S2S
            return r2
        L83:
            com.google.android.gms.internal.ads.zzfnt r2 = com.google.android.gms.internal.ads.zzfnt.SCAR_REQUEST_TYPE_GUILDER
            return r2
        L86:
            com.google.android.gms.internal.ads.zzfnt r2 = com.google.android.gms.internal.ads.zzfnt.SCAR_REQUEST_TYPE_PAW
            return r2
        L89:
            com.google.android.gms.internal.ads.zzfnt r2 = com.google.android.gms.internal.ads.zzfnt.SCAR_REQUEST_TYPE_UNITY
            return r2
        L8c:
            com.google.android.gms.internal.ads.zzfnt r2 = com.google.android.gms.internal.ads.zzfnt.SCAR_REQUEST_TYPE_YAVIN
            return r2
        L8f:
            com.google.android.gms.internal.ads.zzfnt r2 = com.google.android.gms.internal.ads.zzfnt.SCAR_REQUEST_TYPE_GOLDENEYE
            return r2
        L92:
            com.google.android.gms.internal.ads.zzfnt r2 = com.google.android.gms.internal.ads.zzfnt.SCAR_REQUEST_TYPE_GBID
            return r2
        L95:
            com.google.android.gms.internal.ads.zzfnt r2 = com.google.android.gms.internal.ads.zzfnt.SCAR_REQUEST_TYPE_INBOUND_MEDIATION
            return r2
        L98:
            com.google.android.gms.internal.ads.zzfnt r2 = com.google.android.gms.internal.ads.zzfnt.SCAR_REQUEST_TYPE_ADMOB
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.nonagon.signalgeneration.zzaa.c(android.os.Bundle):com.google.android.gms.internal.ads.zzfnt");
    }

    public static void d(final zzdxj zzdxjVar, final String str, final Pair... pairArr) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.D7)).booleanValue()) {
            zzcdo.f25982a.execute(new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzz
                @Override // java.lang.Runnable
                public final void run() {
                    zzdxj zzdxjVar2 = zzdxjVar;
                    zzdxjVar2.getClass();
                    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(zzdxjVar2.f28748a);
                    String str2 = str;
                    if (!TextUtils.isEmpty("action") && !TextUtils.isEmpty(str2)) {
                        concurrentHashMap.put("action", str2);
                    }
                    int i2 = 0;
                    while (true) {
                        Pair[] pairArr2 = pairArr;
                        if (i2 >= pairArr2.length) {
                            zzdxjVar2.a(concurrentHashMap, false);
                            return;
                        }
                        Pair pair = pairArr2[i2];
                        String str3 = (String) pair.first;
                        String str4 = (String) pair.second;
                        if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                            concurrentHashMap.put(str3, str4);
                        }
                        i2++;
                    }
                }
            });
        }
    }

    public static int e(zzfik zzfikVar) {
        if (zzfikVar.s) {
            return 2;
        }
        com.google.android.gms.ads.internal.client.zzm zzmVar = zzfikVar.f31216d;
        com.google.android.gms.ads.internal.client.zzc zzcVar = zzmVar.s;
        String str = zzmVar.x;
        if (zzcVar == null && str == null) {
            return 1;
        }
        if (zzcVar == null || str == null) {
            return zzcVar != null ? 3 : 4;
        }
        return 5;
    }
}
