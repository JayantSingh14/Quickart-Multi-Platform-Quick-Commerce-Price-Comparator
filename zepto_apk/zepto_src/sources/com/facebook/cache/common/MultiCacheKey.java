package com.facebook.cache.common;

import android.net.Uri;
import com.facebook.infer.annotation.Nullsafe;
import java.util.ArrayList;

@Nullsafe
/* loaded from: classes3.dex */
public class MultiCacheKey implements CacheKey {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f16990a;

    public MultiCacheKey(ArrayList arrayList) {
        this.f16990a = arrayList;
    }

    @Override // com.facebook.cache.common.CacheKey
    public final String a() {
        return ((CacheKey) this.f16990a.get(0)).a();
    }

    @Override // com.facebook.cache.common.CacheKey
    public final boolean b(Uri uri) {
        int i2 = 0;
        while (true) {
            ArrayList arrayList = this.f16990a;
            if (i2 >= arrayList.size()) {
                return false;
            }
            if (((CacheKey) arrayList.get(i2)).b(uri)) {
                return true;
            }
            i2++;
        }
    }

    @Override // com.facebook.cache.common.CacheKey
    public final boolean c() {
        return false;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof MultiCacheKey) {
            return this.f16990a.equals(((MultiCacheKey) obj).f16990a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f16990a.hashCode();
    }

    public final String toString() {
        return "MultiCacheKey:" + this.f16990a.toString();
    }
}
