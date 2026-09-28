package androidx.work.impl;

import androidx.work.impl.model.WorkGenerationalId;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class StartStopToken {

    /* renamed from: a, reason: collision with root package name */
    public final WorkGenerationalId f12629a;

    public StartStopToken(WorkGenerationalId id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.f12629a = id;
    }

    public final WorkGenerationalId a() {
        return this.f12629a;
    }
}
