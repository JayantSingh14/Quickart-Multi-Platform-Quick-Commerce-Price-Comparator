package com.google.ads.interactivemedia.pal;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/* loaded from: classes3.dex */
public interface PlatformSignalCollector {
    @NonNull
    Task<Map<String, String>> collectSignals(@NonNull Context context, @NonNull ExecutorService executorService);
}
