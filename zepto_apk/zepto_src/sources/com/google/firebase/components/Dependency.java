package com.google.firebase.components;

/* loaded from: classes.dex */
public final class Dependency {

    /* renamed from: a, reason: collision with root package name */
    public final Qualified f43588a;

    /* renamed from: b, reason: collision with root package name */
    public final int f43589b;

    /* renamed from: c, reason: collision with root package name */
    public final int f43590c;

    public Dependency(int i2, int i3, Class cls) {
        this(Qualified.a(cls), i2, i3);
    }

    public static Dependency a(Qualified qualified) {
        return new Dependency(qualified, 1, 0);
    }

    public static Dependency b(Class cls) {
        return new Dependency(1, 0, cls);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Dependency)) {
            return false;
        }
        Dependency dependency = (Dependency) obj;
        return this.f43588a.equals(dependency.f43588a) && this.f43589b == dependency.f43589b && this.f43590c == dependency.f43590c;
    }

    public final int hashCode() {
        return ((((this.f43588a.hashCode() ^ 1000003) * 1000003) ^ this.f43589b) * 1000003) ^ this.f43590c;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("Dependency{anInterface=");
        sb.append(this.f43588a);
        sb.append(", type=");
        int i2 = this.f43589b;
        sb.append(i2 == 1 ? "required" : i2 == 0 ? "optional" : "set");
        sb.append(", injection=");
        int i3 = this.f43590c;
        if (i3 == 0) {
            str = "direct";
        } else if (i3 == 1) {
            str = "provider";
        } else {
            if (i3 != 2) {
                throw new AssertionError(android.support.v4.media.b.f(i3, "Unsupported injection: "));
            }
            str = "deferred";
        }
        return android.support.v4.media.b.r(sb, str, "}");
    }

    public Dependency(Qualified qualified, int i2, int i3) {
        Preconditions.a(qualified, "Null dependency anInterface.");
        this.f43588a = qualified;
        this.f43589b = i2;
        this.f43590c = i3;
    }
}
