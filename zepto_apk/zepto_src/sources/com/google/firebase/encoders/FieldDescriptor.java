package com.google.firebase.encoders;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class FieldDescriptor {

    /* renamed from: a, reason: collision with root package name */
    public final String f44494a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f44495b;

    /* loaded from: classes4.dex */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public final String f44496a;

        /* renamed from: b, reason: collision with root package name */
        public HashMap f44497b = null;

        public Builder(String str) {
            this.f44496a = str;
        }
    }

    public FieldDescriptor(String str, Map map) {
        this.f44494a = str;
        this.f44495b = map;
    }

    public static FieldDescriptor a(String str) {
        return new FieldDescriptor(str, Collections.EMPTY_MAP);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FieldDescriptor)) {
            return false;
        }
        FieldDescriptor fieldDescriptor = (FieldDescriptor) obj;
        return this.f44494a.equals(fieldDescriptor.f44494a) && this.f44495b.equals(fieldDescriptor.f44495b);
    }

    public final int hashCode() {
        return this.f44495b.hashCode() + (this.f44494a.hashCode() * 31);
    }

    public final String toString() {
        return "FieldDescriptor{name=" + this.f44494a + ", properties=" + this.f44495b.values() + "}";
    }
}
