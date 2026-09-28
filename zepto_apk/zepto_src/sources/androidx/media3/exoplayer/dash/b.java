package androidx.media3.exoplayer.dash;

import androidx.media3.exoplayer.source.chunk.ChunkSampleStream;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public final /* synthetic */ class b implements Function {
    @Override // com.google.common.base.Function
    public final Object apply(Object obj) {
        Pattern pattern = DashMediaPeriod.z;
        return ImmutableList.t(Integer.valueOf(((ChunkSampleStream) obj).f7866a));
    }
}
