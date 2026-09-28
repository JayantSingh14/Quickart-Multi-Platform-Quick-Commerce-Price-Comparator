package com.google.android.gms.internal.common;

import com.google.android.gms.common.api.Api;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class zzaa extends zzab {

    /* renamed from: a, reason: collision with root package name */
    public Object[] f36478a = new Object[4];

    /* renamed from: b, reason: collision with root package name */
    public int f36479b = 0;

    /* renamed from: c, reason: collision with root package name */
    public boolean f36480c;

    public final void a(Object obj) {
        int i2;
        obj.getClass();
        int length = this.f36478a.length;
        int i3 = this.f36479b;
        int i4 = i3 + 1;
        if (i4 < 0) {
            throw new IllegalArgumentException("cannot store more than Integer.MAX_VALUE elements");
        }
        if (i4 <= length) {
            i2 = length;
        } else {
            i2 = (length >> 1) + length + 1;
            if (i2 < i4) {
                int iHighestOneBit = Integer.highestOneBit(i3);
                i2 = iHighestOneBit + iHighestOneBit;
            }
            if (i2 < 0) {
                i2 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            }
        }
        if (i2 > length || this.f36480c) {
            this.f36478a = Arrays.copyOf(this.f36478a, i2);
            this.f36480c = false;
        }
        Object[] objArr = this.f36478a;
        int i5 = this.f36479b;
        this.f36479b = i5 + 1;
        objArr[i5] = obj;
    }

    public void b(Object obj) {
        a(obj);
    }
}
