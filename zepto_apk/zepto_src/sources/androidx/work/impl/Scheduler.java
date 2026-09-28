package androidx.work.impl;

import androidx.annotation.RestrictTo;
import androidx.work.impl.model.WorkSpec;

@RestrictTo
/* loaded from: classes.dex */
public interface Scheduler {
    void a(String str);

    void b(WorkSpec... workSpecArr);

    boolean d();
}
