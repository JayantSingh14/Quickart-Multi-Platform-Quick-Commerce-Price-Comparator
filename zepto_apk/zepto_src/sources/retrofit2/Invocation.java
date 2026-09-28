package retrofit2;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class Invocation {

    /* renamed from: a, reason: collision with root package name */
    public final Class f58102a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f58103b;

    /* renamed from: c, reason: collision with root package name */
    public final Method f58104c;

    /* renamed from: d, reason: collision with root package name */
    public final List f58105d;

    public Invocation(Class cls, Object obj, Method method, ArrayList arrayList) {
        this.f58102a = cls;
        this.f58103b = obj;
        this.f58104c = method;
        this.f58105d = Collections.unmodifiableList(arrayList);
    }

    public final String toString() {
        return String.format("%s.%s() %s", this.f58102a.getName(), this.f58104c.getName(), this.f58105d);
    }
}
