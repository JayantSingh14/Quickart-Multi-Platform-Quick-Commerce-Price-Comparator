package androidx.media3.exoplayer.hls;

import androidx.media3.exoplayer.source.l;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements Function, HlsExtractorFactory {
    @Override // com.google.common.base.Function
    public Object apply(Object obj) {
        HlsSampleStreamWrapper hlsSampleStreamWrapper = (HlsSampleStreamWrapper) obj;
        hlsSampleStreamWrapper.t();
        return ImmutableList.o(Lists.d(new l(4), hlsSampleStreamWrapper.I.f7772b));
    }
}
