package androidx.media3.exoplayer;

import android.os.Handler;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.source.BaseMediaSource;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.SequenceableLoader;

@UnstableApi
/* loaded from: classes3.dex */
public final class MetadataRetriever {

    public static final class MetadataRetrieverInternal {

        public final class MediaSourceHandlerCallback implements Handler.Callback {
            /* JADX WARN: Code restructure failed: missing block: B:23:?, code lost:
            
                throw null;
             */
            @Override // android.os.Handler.Callback
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final boolean handleMessage(android.os.Message r4) {
                /*
                    r3 = this;
                    int r0 = r4.what
                    r1 = 1
                    r2 = 0
                    if (r0 == r1) goto L18
                    r4 = 2
                    if (r0 == r4) goto L15
                    r4 = 3
                    if (r0 == r4) goto L13
                    r4 = 4
                    if (r0 == r4) goto L11
                    r4 = 0
                    return r4
                L11:
                    r4 = 0
                    throw r4
                L13:
                    r4 = 0
                    throw r4
                L15:
                    r4 = 0
                    throw r4     // Catch: java.lang.Exception -> L17
                L17:
                    throw r2
                L18:
                    java.lang.Object r4 = r4.obj
                    androidx.media3.common.MediaItem r4 = (androidx.media3.common.MediaItem) r4
                    throw r2
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.MetadataRetriever.MetadataRetrieverInternal.MediaSourceHandlerCallback.handleMessage(android.os.Message):boolean");
            }

            public final class MediaSourceCaller implements MediaSource.MediaSourceCaller {

                public final class MediaPeriodCallback implements MediaPeriod.Callback {
                    @Override // androidx.media3.exoplayer.source.MediaPeriod.Callback
                    public final void j(MediaPeriod mediaPeriod) {
                        throw null;
                    }

                    @Override // androidx.media3.exoplayer.source.SequenceableLoader.Callback
                    public final void k(SequenceableLoader sequenceableLoader) {
                        throw null;
                    }
                }

                @Override // androidx.media3.exoplayer.source.MediaSource.MediaSourceCaller
                public final void b(BaseMediaSource baseMediaSource, Timeline timeline) {
                }
            }
        }
    }
}
