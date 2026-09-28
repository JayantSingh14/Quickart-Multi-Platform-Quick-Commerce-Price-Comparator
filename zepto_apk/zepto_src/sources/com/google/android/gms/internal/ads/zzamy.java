package com.google.android.gms.internal.ads;

import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: classes4.dex */
public final class zzamy implements zzaly {

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f23672b = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f23673c = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");

    /* renamed from: d, reason: collision with root package name */
    public static final Pattern f23674d = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");

    /* renamed from: e, reason: collision with root package name */
    public static final Pattern f23675e = Pattern.compile("^([-+]?\\d+\\.?\\d*?)%$");

    /* renamed from: f, reason: collision with root package name */
    public static final Pattern f23676f = Pattern.compile("^([-+]?\\d+\\.?\\d*?)% ([-+]?\\d+\\.?\\d*?)%$");

    /* renamed from: g, reason: collision with root package name */
    public static final Pattern f23677g = Pattern.compile("^([-+]?\\d+\\.?\\d*?)px ([-+]?\\d+\\.?\\d*?)px$");

    /* renamed from: h, reason: collision with root package name */
    public static final Pattern f23678h = Pattern.compile("^(\\d+) (\\d+)$");

    /* renamed from: i, reason: collision with root package name */
    public static final zzamw f23679i = new zzamw(30.0f, 1, 1);

    /* renamed from: a, reason: collision with root package name */
    public final XmlPullParserFactory f23680a;

    public zzamy() throws XmlPullParserException {
        try {
            XmlPullParserFactory xmlPullParserFactoryNewInstance = XmlPullParserFactory.newInstance();
            this.f23680a = xmlPullParserFactoryNewInstance;
            xmlPullParserFactoryNewInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e2) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e2);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x037b  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x042e  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x0431  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x045a A[Catch: zzalu -> 0x04ac, TryCatch #3 {zzalu -> 0x04ac, blocks: (B:233:0x03c4, B:236:0x03e0, B:239:0x03f2, B:241:0x03f8, B:243:0x03ff, B:265:0x0436, B:270:0x045c, B:272:0x0462, B:273:0x046a, B:266:0x0439, B:267:0x0456, B:268:0x0457, B:269:0x045a, B:274:0x046b, B:275:0x046c, B:276:0x0489, B:238:0x03e7, B:277:0x048a, B:278:0x04ab), top: B:300:0x03c4 }] */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0462 A[Catch: zzalu -> 0x04ac, TryCatch #3 {zzalu -> 0x04ac, blocks: (B:233:0x03c4, B:236:0x03e0, B:239:0x03f2, B:241:0x03f8, B:243:0x03ff, B:265:0x0436, B:270:0x045c, B:272:0x0462, B:273:0x046a, B:266:0x0439, B:267:0x0456, B:268:0x0457, B:269:0x045a, B:274:0x046b, B:275:0x046c, B:276:0x0489, B:238:0x03e7, B:277:0x048a, B:278:0x04ab), top: B:300:0x03c4 }] */
    /* JADX WARN: Removed duplicated region for block: B:307:0x046a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.ads.zzanb c(org.xmlpull.v1.XmlPullParser r17, com.google.android.gms.internal.ads.zzanb r18) throws com.google.android.gms.internal.ads.zzalu {
        /*
            Method dump skipped, instructions count: 1428
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzamy.c(org.xmlpull.v1.XmlPullParser, com.google.android.gms.internal.ads.zzanb):com.google.android.gms.internal.ads.zzanb");
    }

    public static zzanb d(zzanb zzanbVar) {
        return zzanbVar == null ? new zzanb() : zzanbVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.text.Layout.Alignment e(java.lang.String r5) {
        /*
            java.lang.String r5 = com.google.android.gms.internal.ads.zzgpj.a(r5)
            int r0 = r5.hashCode()
            r1 = 4
            r2 = 3
            r3 = 2
            r4 = 1
            switch(r0) {
                case -1364013995: goto L38;
                case 100571: goto L2e;
                case 3317767: goto L24;
                case 108511772: goto L1a;
                case 109757538: goto L10;
                default: goto Lf;
            }
        Lf:
            goto L42
        L10:
            java.lang.String r0 = "start"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L42
            r5 = r4
            goto L43
        L1a:
            java.lang.String r0 = "right"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L42
            r5 = r3
            goto L43
        L24:
            java.lang.String r0 = "left"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L42
            r5 = 0
            goto L43
        L2e:
            java.lang.String r0 = "end"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L42
            r5 = r2
            goto L43
        L38:
            java.lang.String r0 = "center"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L42
            r5 = r1
            goto L43
        L42:
            r5 = -1
        L43:
            if (r5 == 0) goto L55
            if (r5 == r4) goto L55
            if (r5 == r3) goto L52
            if (r5 == r2) goto L52
            if (r5 == r1) goto L4f
            r5 = 0
            return r5
        L4f:
            android.text.Layout$Alignment r5 = android.text.Layout.Alignment.ALIGN_CENTER
            return r5
        L52:
            android.text.Layout$Alignment r5 = android.text.Layout.Alignment.ALIGN_OPPOSITE
            return r5
        L55:
            android.text.Layout$Alignment r5 = android.text.Layout.Alignment.ALIGN_NORMAL
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzamy.e(java.lang.String):android.text.Layout$Alignment");
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00f2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static long f(java.lang.String r13, com.google.android.gms.internal.ads.zzamw r14) throws com.google.android.gms.internal.ads.zzalu, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 298
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzamy.f(java.lang.String, com.google.android.gms.internal.ads.zzamw):long");
    }

    @Override // com.google.android.gms.internal.ads.zzaly
    public final void a(byte[] bArr, int i2, int i3, zzdr zzdrVar) {
        zzals.a(b(i2, bArr, i3), zzdrVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Can't wrap try/catch for region: R(13:298|(3:460|299|300)|(9:443|302|303|304|(2:326|(2:328|(3:330|(3:332|(2:(2:338|339)|335)(3:343|(2:345|339)|335)|430)(6:454|346|347|(2:446|349)(1:350)|351|(1:353))|354)(2:360|361))(1:364))(1:365)|340|441|366|487)|486|369|(3:371|(1:380)(4:373|(1:375)(1:376)|377|(2:379|380)(1:381))|430)(1:382)|383|(3:385|(1:387)(1:(2:390|(1:392)))|388)(1:393)|394|395|456|396|(3:398|(1:400)|401)) */
    /* JADX WARN: Code restructure failed: missing block: B:403:0x074c, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0358  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x03de  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0402 A[Catch: IOException -> 0x0096, XmlPullParserException -> 0x0099, TRY_LEAVE, TryCatch #16 {IOException -> 0x0096, XmlPullParserException -> 0x0099, blocks: (B:3:0x0009, B:5:0x0060, B:7:0x006d, B:10:0x0079, B:13:0x0089, B:15:0x0091, B:21:0x009e, B:23:0x00a6, B:27:0x00bc, B:29:0x00d7, B:31:0x00e1, B:32:0x00e5, B:34:0x00f1, B:35:0x00f5, B:69:0x018c, B:88:0x01e3, B:91:0x01f7, B:93:0x01fd, B:95:0x0205, B:97:0x020d, B:99:0x0215, B:101:0x021d, B:103:0x0225, B:105:0x022b, B:107:0x0233, B:109:0x023b, B:111:0x0241, B:113:0x0247, B:115:0x024d, B:117:0x0255, B:120:0x025e, B:430:0x07cb, B:124:0x0293, B:127:0x029b, B:129:0x02a4, B:131:0x02b5, B:133:0x02bf, B:135:0x02cf, B:137:0x02d5, B:139:0x02ed, B:141:0x02f3, B:294:0x059b, B:134:0x02c6, B:143:0x0303, B:146:0x0311, B:278:0x054b, B:149:0x032e, B:151:0x0336, B:153:0x033e, B:155:0x0346, B:162:0x035a, B:165:0x036d, B:167:0x0373, B:169:0x0380, B:191:0x03e8, B:193:0x03ee, B:195:0x03f4, B:197:0x03fc, B:199:0x0402, B:202:0x0411, B:204:0x0417, B:206:0x0424, B:226:0x049b, B:228:0x04a3, B:248:0x04ee, B:250:0x04f8, B:276:0x053e, B:207:0x042f, B:208:0x0430, B:209:0x0431, B:210:0x043e, B:213:0x0446, B:216:0x0454, B:218:0x045a, B:220:0x0465, B:221:0x0479, B:222:0x047a, B:223:0x047b, B:224:0x0488, B:171:0x0389, B:172:0x038a, B:173:0x038b, B:175:0x0398, B:178:0x03a2, B:181:0x03ab, B:183:0x03b1, B:185:0x03bc, B:186:0x03cc, B:187:0x03cd, B:188:0x03ce, B:189:0x03d6, B:281:0x055e, B:283:0x056b, B:285:0x0576, B:287:0x057c, B:289:0x0588, B:299:0x05c3, B:302:0x05e5, B:366:0x06ce, B:336:0x0656, B:338:0x065e, B:343:0x0675, B:346:0x067e, B:349:0x0689, B:351:0x0697, B:350:0x068e, B:404:0x074d, B:361:0x06ae, B:364:0x06b5, B:365:0x06bf, B:371:0x06e7, B:375:0x06f3, B:379:0x06fc, B:387:0x070f, B:394:0x071f, B:396:0x072f, B:398:0x0734, B:400:0x0738, B:401:0x073f, B:390:0x0716, B:72:0x0199, B:74:0x01a3, B:77:0x01ac, B:79:0x01b2, B:81:0x01bd, B:82:0x01c7, B:83:0x01c8, B:84:0x01c9, B:39:0x0111, B:41:0x011d, B:44:0x0129, B:46:0x012f, B:48:0x013c, B:58:0x015d, B:60:0x0161, B:61:0x0174, B:68:0x0184, B:65:0x017e, B:67:0x0183, B:408:0x076d, B:410:0x0779, B:411:0x0780, B:413:0x0788, B:416:0x078c, B:418:0x0796, B:420:0x07a0, B:422:0x07a7, B:423:0x07a8, B:426:0x07bc, B:429:0x07c9, B:434:0x07e8), top: B:463:0x0009, inners: #5, #9, #12, #13, #15 }] */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0497  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x04a3 A[Catch: IOException -> 0x0096, XmlPullParserException -> 0x0099, TRY_LEAVE, TryCatch #16 {IOException -> 0x0096, XmlPullParserException -> 0x0099, blocks: (B:3:0x0009, B:5:0x0060, B:7:0x006d, B:10:0x0079, B:13:0x0089, B:15:0x0091, B:21:0x009e, B:23:0x00a6, B:27:0x00bc, B:29:0x00d7, B:31:0x00e1, B:32:0x00e5, B:34:0x00f1, B:35:0x00f5, B:69:0x018c, B:88:0x01e3, B:91:0x01f7, B:93:0x01fd, B:95:0x0205, B:97:0x020d, B:99:0x0215, B:101:0x021d, B:103:0x0225, B:105:0x022b, B:107:0x0233, B:109:0x023b, B:111:0x0241, B:113:0x0247, B:115:0x024d, B:117:0x0255, B:120:0x025e, B:430:0x07cb, B:124:0x0293, B:127:0x029b, B:129:0x02a4, B:131:0x02b5, B:133:0x02bf, B:135:0x02cf, B:137:0x02d5, B:139:0x02ed, B:141:0x02f3, B:294:0x059b, B:134:0x02c6, B:143:0x0303, B:146:0x0311, B:278:0x054b, B:149:0x032e, B:151:0x0336, B:153:0x033e, B:155:0x0346, B:162:0x035a, B:165:0x036d, B:167:0x0373, B:169:0x0380, B:191:0x03e8, B:193:0x03ee, B:195:0x03f4, B:197:0x03fc, B:199:0x0402, B:202:0x0411, B:204:0x0417, B:206:0x0424, B:226:0x049b, B:228:0x04a3, B:248:0x04ee, B:250:0x04f8, B:276:0x053e, B:207:0x042f, B:208:0x0430, B:209:0x0431, B:210:0x043e, B:213:0x0446, B:216:0x0454, B:218:0x045a, B:220:0x0465, B:221:0x0479, B:222:0x047a, B:223:0x047b, B:224:0x0488, B:171:0x0389, B:172:0x038a, B:173:0x038b, B:175:0x0398, B:178:0x03a2, B:181:0x03ab, B:183:0x03b1, B:185:0x03bc, B:186:0x03cc, B:187:0x03cd, B:188:0x03ce, B:189:0x03d6, B:281:0x055e, B:283:0x056b, B:285:0x0576, B:287:0x057c, B:289:0x0588, B:299:0x05c3, B:302:0x05e5, B:366:0x06ce, B:336:0x0656, B:338:0x065e, B:343:0x0675, B:346:0x067e, B:349:0x0689, B:351:0x0697, B:350:0x068e, B:404:0x074d, B:361:0x06ae, B:364:0x06b5, B:365:0x06bf, B:371:0x06e7, B:375:0x06f3, B:379:0x06fc, B:387:0x070f, B:394:0x071f, B:396:0x072f, B:398:0x0734, B:400:0x0738, B:401:0x073f, B:390:0x0716, B:72:0x0199, B:74:0x01a3, B:77:0x01ac, B:79:0x01b2, B:81:0x01bd, B:82:0x01c7, B:83:0x01c8, B:84:0x01c9, B:39:0x0111, B:41:0x011d, B:44:0x0129, B:46:0x012f, B:48:0x013c, B:58:0x015d, B:60:0x0161, B:61:0x0174, B:68:0x0184, B:65:0x017e, B:67:0x0183, B:408:0x076d, B:410:0x0779, B:411:0x0780, B:413:0x0788, B:416:0x078c, B:418:0x0796, B:420:0x07a0, B:422:0x07a7, B:423:0x07a8, B:426:0x07bc, B:429:0x07c9, B:434:0x07e8), top: B:463:0x0009, inners: #5, #9, #12, #13, #15 }] */
    /* JADX WARN: Removed duplicated region for block: B:240:0x04ca  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x04cd  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x04d0  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x04e0  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x04f8 A[Catch: IOException -> 0x0096, XmlPullParserException -> 0x0099, TRY_LEAVE, TryCatch #16 {IOException -> 0x0096, XmlPullParserException -> 0x0099, blocks: (B:3:0x0009, B:5:0x0060, B:7:0x006d, B:10:0x0079, B:13:0x0089, B:15:0x0091, B:21:0x009e, B:23:0x00a6, B:27:0x00bc, B:29:0x00d7, B:31:0x00e1, B:32:0x00e5, B:34:0x00f1, B:35:0x00f5, B:69:0x018c, B:88:0x01e3, B:91:0x01f7, B:93:0x01fd, B:95:0x0205, B:97:0x020d, B:99:0x0215, B:101:0x021d, B:103:0x0225, B:105:0x022b, B:107:0x0233, B:109:0x023b, B:111:0x0241, B:113:0x0247, B:115:0x024d, B:117:0x0255, B:120:0x025e, B:430:0x07cb, B:124:0x0293, B:127:0x029b, B:129:0x02a4, B:131:0x02b5, B:133:0x02bf, B:135:0x02cf, B:137:0x02d5, B:139:0x02ed, B:141:0x02f3, B:294:0x059b, B:134:0x02c6, B:143:0x0303, B:146:0x0311, B:278:0x054b, B:149:0x032e, B:151:0x0336, B:153:0x033e, B:155:0x0346, B:162:0x035a, B:165:0x036d, B:167:0x0373, B:169:0x0380, B:191:0x03e8, B:193:0x03ee, B:195:0x03f4, B:197:0x03fc, B:199:0x0402, B:202:0x0411, B:204:0x0417, B:206:0x0424, B:226:0x049b, B:228:0x04a3, B:248:0x04ee, B:250:0x04f8, B:276:0x053e, B:207:0x042f, B:208:0x0430, B:209:0x0431, B:210:0x043e, B:213:0x0446, B:216:0x0454, B:218:0x045a, B:220:0x0465, B:221:0x0479, B:222:0x047a, B:223:0x047b, B:224:0x0488, B:171:0x0389, B:172:0x038a, B:173:0x038b, B:175:0x0398, B:178:0x03a2, B:181:0x03ab, B:183:0x03b1, B:185:0x03bc, B:186:0x03cc, B:187:0x03cd, B:188:0x03ce, B:189:0x03d6, B:281:0x055e, B:283:0x056b, B:285:0x0576, B:287:0x057c, B:289:0x0588, B:299:0x05c3, B:302:0x05e5, B:366:0x06ce, B:336:0x0656, B:338:0x065e, B:343:0x0675, B:346:0x067e, B:349:0x0689, B:351:0x0697, B:350:0x068e, B:404:0x074d, B:361:0x06ae, B:364:0x06b5, B:365:0x06bf, B:371:0x06e7, B:375:0x06f3, B:379:0x06fc, B:387:0x070f, B:394:0x071f, B:396:0x072f, B:398:0x0734, B:400:0x0738, B:401:0x073f, B:390:0x0716, B:72:0x0199, B:74:0x01a3, B:77:0x01ac, B:79:0x01b2, B:81:0x01bd, B:82:0x01c7, B:83:0x01c8, B:84:0x01c9, B:39:0x0111, B:41:0x011d, B:44:0x0129, B:46:0x012f, B:48:0x013c, B:58:0x015d, B:60:0x0161, B:61:0x0174, B:68:0x0184, B:65:0x017e, B:67:0x0183, B:408:0x076d, B:410:0x0779, B:411:0x0780, B:413:0x0788, B:416:0x078c, B:418:0x0796, B:420:0x07a0, B:422:0x07a7, B:423:0x07a8, B:426:0x07bc, B:429:0x07c9, B:434:0x07e8), top: B:463:0x0009, inners: #5, #9, #12, #13, #15 }] */
    /* JADX WARN: Removed duplicated region for block: B:267:0x052d  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0530  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0536  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x053c  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0199 A[Catch: IOException -> 0x0096, XmlPullParserException -> 0x0099, TryCatch #16 {IOException -> 0x0096, XmlPullParserException -> 0x0099, blocks: (B:3:0x0009, B:5:0x0060, B:7:0x006d, B:10:0x0079, B:13:0x0089, B:15:0x0091, B:21:0x009e, B:23:0x00a6, B:27:0x00bc, B:29:0x00d7, B:31:0x00e1, B:32:0x00e5, B:34:0x00f1, B:35:0x00f5, B:69:0x018c, B:88:0x01e3, B:91:0x01f7, B:93:0x01fd, B:95:0x0205, B:97:0x020d, B:99:0x0215, B:101:0x021d, B:103:0x0225, B:105:0x022b, B:107:0x0233, B:109:0x023b, B:111:0x0241, B:113:0x0247, B:115:0x024d, B:117:0x0255, B:120:0x025e, B:430:0x07cb, B:124:0x0293, B:127:0x029b, B:129:0x02a4, B:131:0x02b5, B:133:0x02bf, B:135:0x02cf, B:137:0x02d5, B:139:0x02ed, B:141:0x02f3, B:294:0x059b, B:134:0x02c6, B:143:0x0303, B:146:0x0311, B:278:0x054b, B:149:0x032e, B:151:0x0336, B:153:0x033e, B:155:0x0346, B:162:0x035a, B:165:0x036d, B:167:0x0373, B:169:0x0380, B:191:0x03e8, B:193:0x03ee, B:195:0x03f4, B:197:0x03fc, B:199:0x0402, B:202:0x0411, B:204:0x0417, B:206:0x0424, B:226:0x049b, B:228:0x04a3, B:248:0x04ee, B:250:0x04f8, B:276:0x053e, B:207:0x042f, B:208:0x0430, B:209:0x0431, B:210:0x043e, B:213:0x0446, B:216:0x0454, B:218:0x045a, B:220:0x0465, B:221:0x0479, B:222:0x047a, B:223:0x047b, B:224:0x0488, B:171:0x0389, B:172:0x038a, B:173:0x038b, B:175:0x0398, B:178:0x03a2, B:181:0x03ab, B:183:0x03b1, B:185:0x03bc, B:186:0x03cc, B:187:0x03cd, B:188:0x03ce, B:189:0x03d6, B:281:0x055e, B:283:0x056b, B:285:0x0576, B:287:0x057c, B:289:0x0588, B:299:0x05c3, B:302:0x05e5, B:366:0x06ce, B:336:0x0656, B:338:0x065e, B:343:0x0675, B:346:0x067e, B:349:0x0689, B:351:0x0697, B:350:0x068e, B:404:0x074d, B:361:0x06ae, B:364:0x06b5, B:365:0x06bf, B:371:0x06e7, B:375:0x06f3, B:379:0x06fc, B:387:0x070f, B:394:0x071f, B:396:0x072f, B:398:0x0734, B:400:0x0738, B:401:0x073f, B:390:0x0716, B:72:0x0199, B:74:0x01a3, B:77:0x01ac, B:79:0x01b2, B:81:0x01bd, B:82:0x01c7, B:83:0x01c8, B:84:0x01c9, B:39:0x0111, B:41:0x011d, B:44:0x0129, B:46:0x012f, B:48:0x013c, B:58:0x015d, B:60:0x0161, B:61:0x0174, B:68:0x0184, B:65:0x017e, B:67:0x0183, B:408:0x076d, B:410:0x0779, B:411:0x0780, B:413:0x0788, B:416:0x078c, B:418:0x0796, B:420:0x07a0, B:422:0x07a7, B:423:0x07a8, B:426:0x07bc, B:429:0x07c9, B:434:0x07e8), top: B:463:0x0009, inners: #5, #9, #12, #13, #15 }] */
    /* JADX WARN: Type inference failed for: r51v1, types: [com.google.android.gms.internal.ads.zzanb, java.lang.Throwable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.ads.zzalt b(int r50, byte[] r51, int r52) throws org.xmlpull.v1.XmlPullParserException, com.google.android.gms.internal.ads.zzalu, java.lang.NumberFormatException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 2068
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzamy.b(int, byte[], int):com.google.android.gms.internal.ads.zzalt");
    }
}
