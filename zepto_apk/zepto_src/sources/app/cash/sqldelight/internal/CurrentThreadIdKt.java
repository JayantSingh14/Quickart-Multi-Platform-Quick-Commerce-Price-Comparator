package app.cash.sqldelight.internal;

import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public final class CurrentThreadIdKt {
    public static final long a() {
        return Thread.currentThread().getId();
    }
}
