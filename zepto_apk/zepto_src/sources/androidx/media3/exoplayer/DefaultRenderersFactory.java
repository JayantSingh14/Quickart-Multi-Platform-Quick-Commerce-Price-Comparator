package androidx.media3.exoplayer;

import android.content.Context;
import android.os.Handler;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.audio.AudioRendererEventListener;
import androidx.media3.exoplayer.audio.DefaultAudioSink;
import androidx.media3.exoplayer.audio.MediaCodecAudioRenderer;
import androidx.media3.exoplayer.image.ImageDecoder;
import androidx.media3.exoplayer.image.ImageRenderer;
import androidx.media3.exoplayer.mediacodec.DefaultMediaCodecAdapterFactory;
import androidx.media3.exoplayer.metadata.MetadataOutput;
import androidx.media3.exoplayer.metadata.MetadataRenderer;
import androidx.media3.exoplayer.text.TextOutput;
import androidx.media3.exoplayer.text.TextRenderer;
import androidx.media3.exoplayer.video.MediaCodecVideoRenderer;
import androidx.media3.exoplayer.video.VideoRendererEventListener;
import androidx.media3.exoplayer.video.spherical.CameraMotionRenderer;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;

@UnstableApi
/* loaded from: classes3.dex */
public class DefaultRenderersFactory implements RenderersFactory {

    /* renamed from: a, reason: collision with root package name */
    public final Context f6176a;

    /* renamed from: b, reason: collision with root package name */
    public final DefaultMediaCodecAdapterFactory f6177b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f6178c;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface ExtensionRendererMode {
    }

    public DefaultRenderersFactory(Context context) {
        this.f6176a = context;
        this.f6177b = new DefaultMediaCodecAdapterFactory(context);
    }

    @Override // androidx.media3.exoplayer.RenderersFactory
    public final Renderer[] a(Handler handler, VideoRendererEventListener videoRendererEventListener, AudioRendererEventListener audioRendererEventListener, TextOutput textOutput, MetadataOutput metadataOutput) {
        ArrayList arrayList = new ArrayList();
        boolean z = this.f6178c;
        DefaultMediaCodecAdapterFactory defaultMediaCodecAdapterFactory = this.f6177b;
        arrayList.add(new MediaCodecVideoRenderer(this.f6176a, defaultMediaCodecAdapterFactory, z, handler, videoRendererEventListener));
        DefaultAudioSink defaultAudioSinkA = new DefaultAudioSink.Builder(this.f6176a).a();
        arrayList.add(new MediaCodecAudioRenderer(this.f6176a, defaultMediaCodecAdapterFactory, this.f6178c, handler, audioRendererEventListener, defaultAudioSinkA));
        arrayList.add(new TextRenderer(textOutput, handler.getLooper()));
        arrayList.add(new MetadataRenderer(metadataOutput, handler.getLooper()));
        arrayList.add(new CameraMotionRenderer());
        arrayList.add(new ImageRenderer(ImageDecoder.Factory.f7258a));
        return (Renderer[]) arrayList.toArray(new Renderer[0]);
    }

    public final void b() {
        this.f6177b.f7313b = 1;
    }

    public final void c() {
        this.f6178c = true;
    }
}
