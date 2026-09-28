package ch.qos.logback.core.joran.spi;

import java.util.HashMap;

/* loaded from: classes3.dex */
public class DefaultNestedComponentRegistry {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f13555a = new HashMap();

    public final void a(Class cls, String str, Class cls2) {
        this.f13555a.put(new HostClassAndPropertyDouble(cls, str.toLowerCase()), cls2);
    }
}
