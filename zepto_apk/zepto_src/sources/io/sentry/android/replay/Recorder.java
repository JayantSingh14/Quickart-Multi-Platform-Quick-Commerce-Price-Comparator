package io.sentry.android.replay;

import java.io.Closeable;
import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public interface Recorder extends Closeable {
    void i0(ScreenshotRecorderConfig screenshotRecorderConfig);

    void pause();

    void resume();

    void stop();
}
