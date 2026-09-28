package com.google.gson.internal;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class ConstructorConstructor {

    /* renamed from: a, reason: collision with root package name */
    public final Map f45280a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f45281b;

    /* renamed from: c, reason: collision with root package name */
    public final List f45282c;

    /* renamed from: com.google.gson.internal.ConstructorConstructor$13, reason: invalid class name */
    class AnonymousClass13 implements ObjectConstructor<Object> {
        @Override // com.google.gson.internal.ObjectConstructor
        public final Object a() {
            return new ArrayList();
        }
    }

    /* renamed from: com.google.gson.internal.ConstructorConstructor$18, reason: invalid class name */
    class AnonymousClass18 implements ObjectConstructor<Object> {
        @Override // com.google.gson.internal.ObjectConstructor
        public final Object a() {
            return new LinkedTreeMap();
        }
    }

    public ConstructorConstructor(Map map, boolean z, List list) {
        this.f45280a = map;
        this.f45281b = z;
        this.f45282c = list;
    }

    public static String a(Class cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            return "Interfaces can't be instantiated! Register an InstanceCreator or a TypeAdapter for this type. Interface name: ".concat(cls.getName());
        }
        if (!Modifier.isAbstract(modifiers)) {
            return null;
        }
        return "Abstract classes can't be instantiated! Adjust the R8 configuration or register an InstanceCreator or a TypeAdapter for this type. Class name: " + cls.getName() + "\nSee " + TroubleshootingGuide.a("r8-abstract-class");
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.gson.internal.ObjectConstructor b(com.google.gson.reflect.TypeToken r9) throws java.lang.NoSuchMethodException, java.lang.SecurityException {
        /*
            Method dump skipped, instructions count: 439
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.ConstructorConstructor.b(com.google.gson.reflect.TypeToken):com.google.gson.internal.ObjectConstructor");
    }

    public final String toString() {
        return this.f45280a.toString();
    }
}
