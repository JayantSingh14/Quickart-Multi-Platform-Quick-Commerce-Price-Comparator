package com.google.firebase.components;

import org.apache.commons.lang3.StringUtils;

/* loaded from: classes.dex */
public final class Qualified<T> {

    /* renamed from: a, reason: collision with root package name */
    public final Class f43603a;

    /* renamed from: b, reason: collision with root package name */
    public final Class f43604b;

    public @interface Unqualified {
    }

    public Qualified(Class cls, Class cls2) {
        this.f43603a = cls;
        this.f43604b = cls2;
    }

    public static Qualified a(Class cls) {
        return new Qualified(Unqualified.class, cls);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Qualified.class != obj.getClass()) {
            return false;
        }
        Qualified qualified = (Qualified) obj;
        if (this.f43604b.equals(qualified.f43604b)) {
            return this.f43603a.equals(qualified.f43603a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f43603a.hashCode() + (this.f43604b.hashCode() * 31);
    }

    public final String toString() {
        Class cls = this.f43604b;
        Class cls2 = this.f43603a;
        if (cls2 == Unqualified.class) {
            return cls.getName();
        }
        return "@" + cls2.getName() + StringUtils.SPACE + cls.getName();
    }
}
