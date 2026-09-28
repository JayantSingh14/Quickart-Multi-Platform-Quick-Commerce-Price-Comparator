package com.bumptech.glide.util;

/* loaded from: classes3.dex */
public class MultiClassKey {

    /* renamed from: a, reason: collision with root package name */
    public Class f16525a;

    /* renamed from: b, reason: collision with root package name */
    public Class f16526b;

    /* renamed from: c, reason: collision with root package name */
    public Class f16527c;

    public MultiClassKey() {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MultiClassKey multiClassKey = (MultiClassKey) obj;
        return this.f16525a.equals(multiClassKey.f16525a) && this.f16526b.equals(multiClassKey.f16526b) && Util.a(this.f16527c, multiClassKey.f16527c);
    }

    public final int hashCode() {
        int iHashCode = (this.f16526b.hashCode() + (this.f16525a.hashCode() * 31)) * 31;
        Class cls = this.f16527c;
        return iHashCode + (cls != null ? cls.hashCode() : 0);
    }

    public final String toString() {
        return "MultiClassKey{first=" + this.f16525a + ", second=" + this.f16526b + '}';
    }

    public MultiClassKey(Class cls, Class cls2, Class cls3) {
        this.f16525a = cls;
        this.f16526b = cls2;
        this.f16527c = cls3;
    }
}
