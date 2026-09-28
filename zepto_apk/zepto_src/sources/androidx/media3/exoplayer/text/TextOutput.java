package androidx.media3.exoplayer.text;

import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.UnstableApi;
import java.util.List;

@UnstableApi
/* loaded from: classes3.dex */
public interface TextOutput {
    void e1(CueGroup cueGroup);

    default void k(List list) {
    }
}
