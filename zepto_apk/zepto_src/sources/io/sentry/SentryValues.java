package io.sentry;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
final class SentryValues<T> {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f51893a;

    public static final class JsonKeys {
    }

    public SentryValues(List list) {
        this.f51893a = new ArrayList(list == null ? new ArrayList(0) : list);
    }

    public final ArrayList a() {
        return this.f51893a;
    }
}
