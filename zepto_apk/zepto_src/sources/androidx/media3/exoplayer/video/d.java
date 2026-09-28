package androidx.media3.exoplayer.video;

import androidx.media3.common.VideoFrameProcessor;
import androidx.media3.exoplayer.video.CompositingVideoSinkProvider;
import com.google.common.base.Supplier;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes3.dex */
public final /* synthetic */ class d implements Supplier {
    @Override // com.google.common.base.Supplier
    public final Object get() throws IllegalAccessException, InstantiationException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        Supplier supplier = CompositingVideoSinkProvider.ReflectiveDefaultVideoFrameProcessorFactory.f8242a;
        try {
            Class<?> cls = Class.forName("androidx.media3.effect.DefaultVideoFrameProcessor$Factory$Builder");
            Object objInvoke = cls.getMethod("build", null).invoke(cls.getConstructor(null).newInstance(null), null);
            objInvoke.getClass();
            return (VideoFrameProcessor.Factory) objInvoke;
        } catch (Exception e2) {
            throw new IllegalStateException(e2);
        }
    }
}
