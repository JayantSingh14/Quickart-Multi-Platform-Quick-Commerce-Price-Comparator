package androidx.media3.ui;

import androidx.media3.common.util.UnstableApi;

@UnstableApi
/* loaded from: classes3.dex */
public interface TimeBar {

    public interface OnScrubListener {
        void B(long j2, boolean z);

        void h(long j2);

        void z(long j2);
    }

    void a(OnScrubListener onScrubListener);

    void b(long[] jArr, boolean[] zArr, int i2);

    long getPreferredUpdateDelay();

    void setBufferedPosition(long j2);

    void setDuration(long j2);

    void setEnabled(boolean z);

    void setPosition(long j2);
}
