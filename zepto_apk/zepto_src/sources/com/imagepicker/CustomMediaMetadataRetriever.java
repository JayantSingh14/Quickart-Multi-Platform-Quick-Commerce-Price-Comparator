package com.imagepicker;

import android.media.MediaMetadataRetriever;
import java.io.IOException;

/* loaded from: classes4.dex */
class CustomMediaMetadataRetriever extends MediaMetadataRetriever implements AutoCloseable {
    @Override // android.media.MediaMetadataRetriever, java.lang.AutoCloseable
    public final void close() throws IOException {
        release();
    }
}
