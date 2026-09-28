package com.google.android.gms.internal.pal;

import com.google.android.gms.common.api.Api;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/* loaded from: classes4.dex */
public final class zzjb {

    /* renamed from: a, reason: collision with root package name */
    public Object[] f37825a = new Object[8];

    /* renamed from: b, reason: collision with root package name */
    public int f37826b = 0;

    /* renamed from: c, reason: collision with root package name */
    public zzja f37827c;

    public final void a(Object obj, Object obj2) {
        d(this.f37826b + 1);
        zziu.a(obj, obj2);
        Object[] objArr = this.f37825a;
        int i2 = this.f37826b;
        int i3 = i2 + i2;
        objArr[i3] = obj;
        objArr[i3 + 1] = obj2;
        this.f37826b = i2 + 1;
    }

    public final void b(Map map) {
        Set<Map.Entry> setEntrySet = map.entrySet();
        if (setEntrySet != null) {
            d(setEntrySet.size() + this.f37826b);
        }
        for (Map.Entry entry : setEntrySet) {
            a(entry.getKey(), entry.getValue());
        }
    }

    public final zzjc c() {
        zzja zzjaVar = this.f37827c;
        if (zzjaVar != null) {
            throw zzjaVar.a();
        }
        zzjj zzjjVarH = zzjj.h(this.f37826b, this.f37825a, this);
        zzja zzjaVar2 = this.f37827c;
        if (zzjaVar2 == null) {
            return zzjjVarH;
        }
        throw zzjaVar2.a();
    }

    public final void d(int i2) {
        int i3 = i2 + i2;
        Object[] objArr = this.f37825a;
        int length = objArr.length;
        if (i3 > length) {
            int i4 = length + (length >> 1) + 1;
            if (i4 < i3) {
                int iHighestOneBit = Integer.highestOneBit(i3 - 1);
                i4 = iHighestOneBit + iHighestOneBit;
            }
            if (i4 < 0) {
                i4 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            }
            this.f37825a = Arrays.copyOf(objArr, i4);
        }
    }
}
