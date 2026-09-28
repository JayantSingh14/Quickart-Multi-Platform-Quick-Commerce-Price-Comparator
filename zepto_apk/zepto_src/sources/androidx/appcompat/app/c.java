package androidx.appcompat.app;

import android.app.NotificationChannel;
import android.app.job.JobWorkItem;
import android.content.Intent;
import android.media.AudioFocusRequest;

/* loaded from: classes3.dex */
public abstract /* synthetic */ class c {
    public static /* synthetic */ NotificationChannel e(String str, String str2) {
        return new NotificationChannel(str, str2, 3);
    }

    public static /* synthetic */ JobWorkItem g(Intent intent) {
        return new JobWorkItem(intent);
    }

    public static /* synthetic */ AudioFocusRequest.Builder k(int i2) {
        return new AudioFocusRequest.Builder(i2);
    }

    public static /* synthetic */ AudioFocusRequest.Builder o(AudioFocusRequest audioFocusRequest) {
        return new AudioFocusRequest.Builder(audioFocusRequest);
    }

    public static /* synthetic */ void t() {
    }
}
