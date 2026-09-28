package com.google.gson;

import java.lang.reflect.Field;
import java.util.Objects;

/* loaded from: classes4.dex */
public final class FieldAttributes {

    /* renamed from: a, reason: collision with root package name */
    public final Field f45217a;

    public FieldAttributes(Field field) {
        Objects.requireNonNull(field);
        this.f45217a = field;
    }

    public final String toString() {
        return this.f45217a.toString();
    }
}
