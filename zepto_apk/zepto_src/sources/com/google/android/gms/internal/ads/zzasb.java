package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* loaded from: classes4.dex */
public final class zzasb {

    /* renamed from: d, reason: collision with root package name */
    public static final Comparator f24256d = new zzasa();

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f24257a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f24258b = new ArrayList(64);

    /* renamed from: c, reason: collision with root package name */
    public int f24259c = 0;

    public final synchronized byte[] a(int i2) {
        int i3 = 0;
        while (true) {
            ArrayList arrayList = this.f24258b;
            if (i3 >= arrayList.size()) {
                return new byte[i2];
            }
            byte[] bArr = (byte[]) arrayList.get(i3);
            int length = bArr.length;
            if (length >= i2) {
                this.f24259c -= length;
                arrayList.remove(i3);
                this.f24257a.remove(bArr);
                return bArr;
            }
            i3++;
        }
    }

    public final synchronized void b(byte[] bArr) {
        if (bArr != null) {
            int length = bArr.length;
            if (length <= 4096) {
                this.f24257a.add(bArr);
                ArrayList arrayList = this.f24258b;
                int iBinarySearch = Collections.binarySearch(arrayList, bArr, f24256d);
                if (iBinarySearch < 0) {
                    iBinarySearch = (-iBinarySearch) - 1;
                }
                arrayList.add(iBinarySearch, bArr);
                this.f24259c += length;
                synchronized (this) {
                    while (this.f24259c > 4096) {
                        byte[] bArr2 = (byte[]) this.f24257a.remove(0);
                        this.f24258b.remove(bArr2);
                        this.f24259c -= bArr2.length;
                    }
                }
            }
        }
    }
}
