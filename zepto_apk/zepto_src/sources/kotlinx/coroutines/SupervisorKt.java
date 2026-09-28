package kotlinx.coroutines;

import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public final class SupervisorKt {
    public static final CompletableJob a(Job job) {
        return new SupervisorJobImpl(job);
    }

    public static CompletableJob b() {
        return new SupervisorJobImpl(null);
    }
}
