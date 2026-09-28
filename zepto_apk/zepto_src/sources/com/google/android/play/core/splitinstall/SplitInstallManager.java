package com.google.android.play.core.splitinstall;

import com.google.android.gms.tasks.Task;
import java.util.Set;

/* loaded from: classes4.dex */
public interface SplitInstallManager {
    Task a(SplitInstallRequest splitInstallRequest);

    Set b();

    void c(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener);

    void d(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener);
}
