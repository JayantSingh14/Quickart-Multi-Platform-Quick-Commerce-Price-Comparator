package androidx.media3.common;

import androidx.media3.common.util.UnstableApi;
import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;

@UnstableApi
/* loaded from: classes3.dex */
public final class PriorityTaskManager {

    /* renamed from: a, reason: collision with root package name */
    public final Object f5449a = new Object();

    public static class PriorityTooLowException extends IOException {
    }

    public PriorityTaskManager() {
        new PriorityQueue(10, Collections.reverseOrder());
    }
}
