package androidx.work.impl.model;

import androidx.annotation.RestrictTo;
import androidx.room.Entity;
import androidx.work.Data;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Entity
@Metadata
@RestrictTo
/* loaded from: classes3.dex */
public final class WorkProgress {

    /* renamed from: a, reason: collision with root package name */
    public final String f12899a;

    /* renamed from: b, reason: collision with root package name */
    public final Data f12900b;

    public WorkProgress(String workSpecId, Data progress) {
        Intrinsics.checkNotNullParameter(workSpecId, "workSpecId");
        Intrinsics.checkNotNullParameter(progress, "progress");
        this.f12899a = workSpecId;
        this.f12900b = progress;
    }

    public final Data a() {
        return this.f12900b;
    }

    public final String b() {
        return this.f12899a;
    }
}
