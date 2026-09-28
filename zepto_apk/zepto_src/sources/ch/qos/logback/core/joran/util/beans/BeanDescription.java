package ch.qos.logback.core.joran.util.beans;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class BeanDescription {

    /* renamed from: a, reason: collision with root package name */
    public final Map f13585a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f13586b;

    /* renamed from: c, reason: collision with root package name */
    public final Map f13587c;

    public BeanDescription(HashMap map, HashMap map2, HashMap map3) {
        this.f13585a = Collections.unmodifiableMap(map);
        this.f13586b = Collections.unmodifiableMap(map2);
        this.f13587c = Collections.unmodifiableMap(map3);
    }
}
