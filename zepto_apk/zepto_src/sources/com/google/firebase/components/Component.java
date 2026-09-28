package com.google.firebase.components;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class Component<T> {

    /* renamed from: a, reason: collision with root package name */
    public final String f43556a;

    /* renamed from: b, reason: collision with root package name */
    public final Set f43557b;

    /* renamed from: c, reason: collision with root package name */
    public final Set f43558c;

    /* renamed from: d, reason: collision with root package name */
    public final int f43559d;

    /* renamed from: e, reason: collision with root package name */
    public final int f43560e;

    /* renamed from: f, reason: collision with root package name */
    public final ComponentFactory f43561f;

    /* renamed from: g, reason: collision with root package name */
    public final Set f43562g;

    public Component(String str, Set set, Set set2, int i2, int i3, ComponentFactory componentFactory, Set set3) {
        this.f43556a = str;
        this.f43557b = Collections.unmodifiableSet(set);
        this.f43558c = Collections.unmodifiableSet(set2);
        this.f43559d = i2;
        this.f43560e = i3;
        this.f43561f = componentFactory;
        this.f43562g = Collections.unmodifiableSet(set3);
    }

    public static Builder a(Qualified qualified) {
        return new Builder(qualified, new Qualified[0]);
    }

    public static Builder b(Class cls) {
        return new Builder(cls, new Class[0]);
    }

    public static Component c(Object obj, Class cls, Class... clsArr) {
        Builder builder = new Builder(cls, clsArr);
        builder.f43568f = new androidx.work.impl.c(obj, 1);
        return builder.b();
    }

    public final String toString() {
        return "Component<" + Arrays.toString(this.f43557b.toArray()) + ">{" + this.f43559d + ", type=" + this.f43560e + ", deps=" + Arrays.toString(this.f43558c.toArray()) + "}";
    }

    public static class Builder<T> {

        /* renamed from: a, reason: collision with root package name */
        public String f43563a = null;

        /* renamed from: b, reason: collision with root package name */
        public final HashSet f43564b;

        /* renamed from: c, reason: collision with root package name */
        public final HashSet f43565c;

        /* renamed from: d, reason: collision with root package name */
        public int f43566d;

        /* renamed from: e, reason: collision with root package name */
        public int f43567e;

        /* renamed from: f, reason: collision with root package name */
        public ComponentFactory f43568f;

        /* renamed from: g, reason: collision with root package name */
        public final HashSet f43569g;

        public Builder(Class cls, Class[] clsArr) {
            HashSet hashSet = new HashSet();
            this.f43564b = hashSet;
            this.f43565c = new HashSet();
            this.f43566d = 0;
            this.f43567e = 0;
            this.f43569g = new HashSet();
            hashSet.add(Qualified.a(cls));
            for (Class cls2 : clsArr) {
                Preconditions.a(cls2, "Null interface");
                this.f43564b.add(Qualified.a(cls2));
            }
        }

        public final void a(Dependency dependency) {
            if (this.f43564b.contains(dependency.f43588a)) {
                throw new IllegalArgumentException("Components are not allowed to depend on interfaces they themselves provide.");
            }
            this.f43565c.add(dependency);
        }

        public final Component b() {
            if (this.f43568f != null) {
                return new Component(this.f43563a, new HashSet(this.f43564b), new HashSet(this.f43565c), this.f43566d, this.f43567e, this.f43568f, this.f43569g);
            }
            throw new IllegalStateException("Missing required property: factory.");
        }

        public final void c(ComponentFactory componentFactory) {
            Preconditions.a(componentFactory, "Null factory");
            this.f43568f = componentFactory;
        }

        public final void d(int i2) {
            if (!(this.f43566d == 0)) {
                throw new IllegalStateException("Instantiation type has already been set.");
            }
            this.f43566d = i2;
        }

        public Builder(Qualified qualified, Qualified[] qualifiedArr) {
            HashSet hashSet = new HashSet();
            this.f43564b = hashSet;
            this.f43565c = new HashSet();
            this.f43566d = 0;
            this.f43567e = 0;
            this.f43569g = new HashSet();
            hashSet.add(qualified);
            for (Qualified qualified2 : qualifiedArr) {
                Preconditions.a(qualified2, "Null interface");
            }
            Collections.addAll(this.f43564b, qualifiedArr);
        }
    }
}
