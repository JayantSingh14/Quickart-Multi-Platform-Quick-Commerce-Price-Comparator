package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.CollectionUtils;
import java.util.Map;

/* loaded from: classes4.dex */
public final class zzbnu implements zzbnn {

    /* renamed from: d, reason: collision with root package name */
    public static final Map f25359d = CollectionUtils.mapOfKeyValueArrays(new String[]{"resize", "playVideo", "storePicture", "createCalendarEvent", "setOrientationProperties", "closeResizedAd", "unload"}, new Integer[]{1, 2, 3, 4, 5, 6, 7});

    /* renamed from: a, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.zzb f25360a;

    /* renamed from: b, reason: collision with root package name */
    public final zzbvx f25361b;

    /* renamed from: c, reason: collision with root package name */
    public final zzbwe f25362c;

    public zzbnu(com.google.android.gms.ads.internal.zzb zzbVar, zzbvx zzbvxVar, zzbwe zzbweVar) {
        this.f25360a = zzbVar;
        this.f25361b = zzbvxVar;
        this.f25362c = zzbweVar;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0353 A[PHI: r16
      0x0353: PHI (r16v13 int) = (r16v6 int), (r16v7 int), (r16v8 int), (r16v9 int), (r16v10 int), (r16v11 int), (r16v14 int) binds: [B:170:0x034f, B:167:0x0342, B:164:0x0336, B:161:0x032a, B:158:0x031e, B:155:0x0312, B:153:0x0307] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0450 A[Catch: all -> 0x01aa, TryCatch #1 {all -> 0x01aa, blocks: (B:88:0x019f, B:90:0x01a3, B:91:0x01a8, B:95:0x01ad, B:97:0x01b9, B:98:0x01be, B:100:0x01c0, B:102:0x01ce, B:103:0x01d3, B:105:0x01d5, B:107:0x01db, B:108:0x01e0, B:110:0x01e2, B:112:0x01f0, B:113:0x0202, B:115:0x0210, B:116:0x0222, B:118:0x0230, B:119:0x0242, B:121:0x0250, B:122:0x0262, B:124:0x0270, B:125:0x027e, B:127:0x028c, B:128:0x028e, B:130:0x0292, B:132:0x0296, B:134:0x029c, B:137:0x02a4, B:141:0x02dc, B:147:0x02ec, B:229:0x0450, B:230:0x0455, B:232:0x0457, B:234:0x047d, B:236:0x0486, B:238:0x04b9, B:271:0x0573, B:278:0x05a6, B:279:0x05be, B:280:0x05e7, B:282:0x05f1, B:283:0x05fc, B:284:0x0621, B:287:0x0624, B:289:0x064f, B:290:0x065e, B:272:0x057a, B:273:0x0581, B:274:0x058a, B:275:0x0591, B:276:0x0597, B:277:0x05a0, B:237:0x04b6, B:292:0x0660, B:293:0x0665, B:149:0x02fa, B:151:0x02fe, B:183:0x0369, B:185:0x0371, B:186:0x0373, B:204:0x03ce, B:206:0x03d2, B:208:0x03d6, B:211:0x03de, B:187:0x0377, B:189:0x037f, B:190:0x0381, B:192:0x0388, B:194:0x0392, B:195:0x0395, B:196:0x039d, B:198:0x03a9, B:199:0x03b3, B:201:0x03bf, B:202:0x03c2, B:212:0x03ed, B:219:0x0427, B:225:0x0437, B:222:0x042d, B:224:0x0435, B:215:0x041e, B:217:0x0424, B:226:0x043c, B:227:0x0445, B:295:0x0667, B:296:0x066c, B:298:0x066e, B:299:0x0673), top: B:327:0x019f, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0457 A[Catch: all -> 0x01aa, TryCatch #1 {all -> 0x01aa, blocks: (B:88:0x019f, B:90:0x01a3, B:91:0x01a8, B:95:0x01ad, B:97:0x01b9, B:98:0x01be, B:100:0x01c0, B:102:0x01ce, B:103:0x01d3, B:105:0x01d5, B:107:0x01db, B:108:0x01e0, B:110:0x01e2, B:112:0x01f0, B:113:0x0202, B:115:0x0210, B:116:0x0222, B:118:0x0230, B:119:0x0242, B:121:0x0250, B:122:0x0262, B:124:0x0270, B:125:0x027e, B:127:0x028c, B:128:0x028e, B:130:0x0292, B:132:0x0296, B:134:0x029c, B:137:0x02a4, B:141:0x02dc, B:147:0x02ec, B:229:0x0450, B:230:0x0455, B:232:0x0457, B:234:0x047d, B:236:0x0486, B:238:0x04b9, B:271:0x0573, B:278:0x05a6, B:279:0x05be, B:280:0x05e7, B:282:0x05f1, B:283:0x05fc, B:284:0x0621, B:287:0x0624, B:289:0x064f, B:290:0x065e, B:272:0x057a, B:273:0x0581, B:274:0x058a, B:275:0x0591, B:276:0x0597, B:277:0x05a0, B:237:0x04b6, B:292:0x0660, B:293:0x0665, B:149:0x02fa, B:151:0x02fe, B:183:0x0369, B:185:0x0371, B:186:0x0373, B:204:0x03ce, B:206:0x03d2, B:208:0x03d6, B:211:0x03de, B:187:0x0377, B:189:0x037f, B:190:0x0381, B:192:0x0388, B:194:0x0392, B:195:0x0395, B:196:0x039d, B:198:0x03a9, B:199:0x03b3, B:201:0x03bf, B:202:0x03c2, B:212:0x03ed, B:219:0x0427, B:225:0x0437, B:222:0x042d, B:224:0x0435, B:215:0x041e, B:217:0x0424, B:226:0x043c, B:227:0x0445, B:295:0x0667, B:296:0x066c, B:298:0x066e, B:299:0x0673), top: B:327:0x019f, inners: #0 }] */
    @Override // com.google.android.gms.internal.ads.zzbnn
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(java.lang.Object r19, java.util.Map r20) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 1794
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbnu.a(java.lang.Object, java.util.Map):void");
    }
}
