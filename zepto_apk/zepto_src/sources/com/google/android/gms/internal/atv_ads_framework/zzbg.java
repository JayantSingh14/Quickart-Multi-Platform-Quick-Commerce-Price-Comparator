package com.google.android.gms.internal.atv_ads_framework;

import android.support.v4.media.b;
import com.google.android.gms.common.api.Api;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class zzbg {

    /* renamed from: a, reason: collision with root package name */
    public Object[] f36049a = new Object[8];

    /* renamed from: b, reason: collision with root package name */
    public int f36050b = 0;

    /* renamed from: c, reason: collision with root package name */
    public zzbf f36051c;

    public final void a(Object obj, Object obj2) {
        c(this.f36050b + 1);
        if (obj == null) {
            throw new NullPointerException("null key in entry: null=".concat(String.valueOf(obj2)));
        }
        if (obj2 == null) {
            throw new NullPointerException(b.D("null value in entry: ", obj.toString(), "=null"));
        }
        Object[] objArr = this.f36049a;
        int i2 = this.f36050b;
        int i3 = i2 + i2;
        objArr[i3] = obj;
        objArr[i3 + 1] = obj2;
        this.f36050b = i2 + 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01a3  */
    /* JADX WARN: Type inference failed for: r17v11 */
    /* JADX WARN: Type inference failed for: r17v12 */
    /* JADX WARN: Type inference failed for: r17v13 */
    /* JADX WARN: Type inference failed for: r17v4 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.lang.Object[]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.atv_ads_framework.zzbh b() {
        /*
            Method dump skipped, instructions count: 466
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.atv_ads_framework.zzbg.b():com.google.android.gms.internal.atv_ads_framework.zzbh");
    }

    public final void c(int i2) {
        Object[] objArr = this.f36049a;
        int length = objArr.length;
        int i3 = i2 + i2;
        if (i3 > length) {
            int i4 = length + (length >> 1) + 1;
            if (i4 < i3) {
                int iHighestOneBit = Integer.highestOneBit(i3 - 1);
                i4 = iHighestOneBit + iHighestOneBit;
            }
            if (i4 < 0) {
                i4 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            }
            this.f36049a = Arrays.copyOf(objArr, i4);
        }
    }
}
