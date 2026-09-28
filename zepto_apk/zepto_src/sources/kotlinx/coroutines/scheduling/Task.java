package kotlinx.coroutines.scheduling;

import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public abstract class Task implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public long f55155a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f55156b;

    public Task(long j2, boolean z) {
        this.f55155a = j2;
        this.f55156b = z;
    }

    public Task() {
        this(0L, false);
    }
}
