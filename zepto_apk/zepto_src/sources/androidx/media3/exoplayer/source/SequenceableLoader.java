package androidx.media3.exoplayer.source;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.LoadingInfo;

@UnstableApi
/* loaded from: classes3.dex */
public interface SequenceableLoader {

    public interface Callback<T extends SequenceableLoader> {
        void k(SequenceableLoader sequenceableLoader);
    }

    boolean b();

    boolean e(LoadingInfo loadingInfo);

    long f();

    long q();

    void s(long j2);
}
