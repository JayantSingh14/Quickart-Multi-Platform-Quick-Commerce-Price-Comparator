package com.google.android.datatransport.runtime.firebase.transport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public final class LogSourceMetrics {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f20826c = 0;

    /* renamed from: a, reason: collision with root package name */
    public final String f20827a;

    /* renamed from: b, reason: collision with root package name */
    public final List f20828b;

    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public String f20829a = "";

        /* renamed from: b, reason: collision with root package name */
        public List f20830b = new ArrayList();

        public final LogSourceMetrics a() {
            return new LogSourceMetrics(this.f20829a, Collections.unmodifiableList(this.f20830b));
        }
    }

    static {
        new Builder().a();
    }

    public LogSourceMetrics(String str, List list) {
        this.f20827a = str;
        this.f20828b = list;
    }
}
