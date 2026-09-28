package com.facebook.react.jstasks;

import com.facebook.react.bridge.WritableMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class HeadlessJsTaskConfig {

    /* renamed from: a, reason: collision with root package name */
    public final String f19004a;

    /* renamed from: b, reason: collision with root package name */
    public final WritableMap f19005b;

    /* renamed from: c, reason: collision with root package name */
    public final long f19006c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f19007d;

    /* renamed from: e, reason: collision with root package name */
    public final HeadlessJsTaskRetryPolicy f19008e;

    public HeadlessJsTaskConfig(String taskKey, WritableMap data, long j2, boolean z, HeadlessJsTaskRetryPolicy headlessJsTaskRetryPolicy) {
        Intrinsics.checkNotNullParameter(taskKey, "taskKey");
        Intrinsics.checkNotNullParameter(data, "data");
        this.f19004a = taskKey;
        this.f19005b = data;
        this.f19006c = j2;
        this.f19007d = z;
        this.f19008e = headlessJsTaskRetryPolicy;
    }

    public final WritableMap a() {
        return this.f19005b;
    }

    public final HeadlessJsTaskRetryPolicy b() {
        return this.f19008e;
    }

    public final String c() {
        return this.f19004a;
    }

    public final long d() {
        return this.f19006c;
    }

    public final boolean e() {
        return this.f19007d;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public HeadlessJsTaskConfig(HeadlessJsTaskConfig source) {
        Intrinsics.checkNotNullParameter(source, "source");
        String str = source.f19004a;
        WritableMap writableMapCopy = source.f19005b.copy();
        long j2 = source.f19006c;
        boolean z = source.f19007d;
        HeadlessJsTaskRetryPolicy headlessJsTaskRetryPolicy = source.f19008e;
        this(str, writableMapCopy, j2, z, headlessJsTaskRetryPolicy != null ? headlessJsTaskRetryPolicy.copy() : null);
    }
}
