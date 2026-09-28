package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public final class zzamo implements zzaly {

    /* renamed from: g, reason: collision with root package name */
    public static final Pattern f23609g = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)[:.](\\d+)");

    /* renamed from: a, reason: collision with root package name */
    public final boolean f23610a;

    /* renamed from: b, reason: collision with root package name */
    public final zzamn f23611b;

    /* renamed from: c, reason: collision with root package name */
    public final zzer f23612c;

    /* renamed from: d, reason: collision with root package name */
    public LinkedHashMap f23613d;

    /* renamed from: e, reason: collision with root package name */
    public float f23614e;

    /* renamed from: f, reason: collision with root package name */
    public float f23615f;

    public zzamo() {
        this(null);
    }

    public static long c(String str) {
        Matcher matcher = f23609g.matcher(str.trim());
        if (!matcher.matches()) {
            return -9223372036854775807L;
        }
        String strGroup = matcher.group(1);
        String str2 = zzfj.f31254a;
        long j2 = Long.parseLong(strGroup) * 3600000000L;
        long j3 = Long.parseLong(matcher.group(2)) * 60000000;
        return j2 + j3 + (Long.parseLong(matcher.group(3)) * 1000000) + (Long.parseLong(matcher.group(4)) * 10000);
    }

    public static int d(long j2, ArrayList arrayList, ArrayList arrayList2) {
        int i2;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                i2 = 0;
                break;
            }
            if (((Long) arrayList.get(size)).longValue() == j2) {
                return size;
            }
            if (((Long) arrayList.get(size)).longValue() < j2) {
                i2 = size + 1;
                break;
            }
        }
        arrayList.add(i2, Long.valueOf(j2));
        arrayList2.add(i2, i2 == 0 ? new ArrayList() : new ArrayList((Collection) arrayList2.get(i2 - 1)));
        return i2;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:198:0x0193
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:131)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:57)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:49)
        */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.ads.zzaly
    public final void a(byte[] r29, int r30, int r31, com.google.android.gms.internal.ads.zzdr r32) {
        /*
            Method dump skipped, instructions count: 1136
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzamo.a(byte[], int, int, com.google.android.gms.internal.ads.zzdr):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:142:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x02c2 A[Catch: RuntimeException -> 0x0209, TRY_LEAVE, TryCatch #4 {RuntimeException -> 0x0209, blocks: (B:111:0x01d9, B:113:0x01e7, B:114:0x01ed, B:121:0x020e, B:123:0x0212, B:125:0x0221, B:127:0x0225, B:129:0x0234, B:131:0x0238, B:132:0x0240, B:137:0x026a, B:139:0x026e, B:143:0x027f, B:145:0x0283, B:149:0x0294, B:151:0x0298, B:155:0x02a9, B:157:0x02ad, B:161:0x02be, B:163:0x02c2, B:164:0x02ca, B:171:0x02e7, B:169:0x02da, B:135:0x0248, B:116:0x01f8), top: B:195:0x01d9, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0305  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0157  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(com.google.android.gms.internal.ads.zzer r40, java.nio.charset.Charset r41) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 910
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzamo.b(com.google.android.gms.internal.ads.zzer, java.nio.charset.Charset):void");
    }

    public zzamo(List list) throws NumberFormatException {
        this.f23614e = -3.4028235E38f;
        this.f23615f = -3.4028235E38f;
        this.f23612c = new zzer();
        if (list == null || list.isEmpty()) {
            this.f23610a = false;
            this.f23611b = null;
            return;
        }
        this.f23610a = true;
        byte[] bArr = (byte[]) list.get(0);
        String str = zzfj.f31254a;
        Charset charset = StandardCharsets.UTF_8;
        String str2 = new String(bArr, charset);
        zzgqa.a(str2.startsWith("Format:"));
        zzamn zzamnVarA = zzamn.a(str2);
        zzamnVarA.getClass();
        this.f23611b = zzamnVarA;
        b(new zzer((byte[]) list.get(1)), charset);
    }
}
