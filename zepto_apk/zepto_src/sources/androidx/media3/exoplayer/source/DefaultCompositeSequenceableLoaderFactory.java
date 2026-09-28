package androidx.media3.exoplayer.source;

import androidx.media3.common.util.UnstableApi;
import com.google.common.collect.ImmutableList;

@UnstableApi
/* loaded from: classes3.dex */
public final class DefaultCompositeSequenceableLoaderFactory implements CompositeSequenceableLoaderFactory {
    public final CompositeSequenceableLoader a() {
        return new CompositeSequenceableLoader(ImmutableList.r(), ImmutableList.r());
    }
}
