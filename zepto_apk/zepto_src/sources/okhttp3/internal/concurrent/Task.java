package okhttp3.internal.concurrent;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public abstract class Task {

    /* renamed from: a, reason: collision with root package name */
    public final String f56461a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f56462b;

    /* renamed from: c, reason: collision with root package name */
    public TaskQueue f56463c;

    /* renamed from: d, reason: collision with root package name */
    public long f56464d;

    public Task(String name, boolean z) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.f56461a = name;
        this.f56462b = z;
        this.f56464d = -1L;
    }

    public abstract long a();

    public final String toString() {
        return this.f56461a;
    }
}
