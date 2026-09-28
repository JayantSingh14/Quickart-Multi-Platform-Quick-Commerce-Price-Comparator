package androidx.media3.exoplayer.video;

import android.content.Context;
import android.os.Looper;
import android.util.Pair;
import android.view.Surface;
import androidx.annotation.RestrictTo;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.Effect;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.PreviewingVideoGraph;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.VideoFrameProcessor;
import androidx.media3.common.VideoGraph;
import androidx.media3.common.VideoSize;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.HandlerWrapper;
import androidx.media3.common.util.LongArrayQueue;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.SystemClock;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.video.VideoFrameRenderControl;
import androidx.media3.exoplayer.video.VideoSink;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableList;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;

@RestrictTo
@UnstableApi
/* loaded from: classes3.dex */
public final class CompositingVideoSinkProvider implements VideoSinkProvider, VideoGraph.Listener {
    public static final b o = new b();

    /* renamed from: a, reason: collision with root package name */
    public final Context f8222a;

    /* renamed from: b, reason: collision with root package name */
    public final VideoSinkImpl f8223b;

    /* renamed from: c, reason: collision with root package name */
    public final VideoFrameReleaseControl f8224c;

    /* renamed from: d, reason: collision with root package name */
    public final VideoFrameRenderControl f8225d;

    /* renamed from: e, reason: collision with root package name */
    public final PreviewingVideoGraph.Factory f8226e;

    /* renamed from: f, reason: collision with root package name */
    public final SystemClock f8227f;

    /* renamed from: g, reason: collision with root package name */
    public final CopyOnWriteArraySet f8228g;

    /* renamed from: h, reason: collision with root package name */
    public Format f8229h;

    /* renamed from: i, reason: collision with root package name */
    public VideoFrameMetadataListener f8230i;

    /* renamed from: j, reason: collision with root package name */
    public HandlerWrapper f8231j;

    /* renamed from: k, reason: collision with root package name */
    public PreviewingVideoGraph f8232k;

    /* renamed from: l, reason: collision with root package name */
    public Pair f8233l;

    /* renamed from: m, reason: collision with root package name */
    public int f8234m;
    public int n;

    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public final Context f8235a;

        /* renamed from: b, reason: collision with root package name */
        public final VideoFrameReleaseControl f8236b;

        /* renamed from: c, reason: collision with root package name */
        public VideoFrameProcessor.Factory f8237c;

        /* renamed from: d, reason: collision with root package name */
        public PreviewingVideoGraph.Factory f8238d;

        /* renamed from: e, reason: collision with root package name */
        public SystemClock f8239e = Clock.f5662a;

        /* renamed from: f, reason: collision with root package name */
        public boolean f8240f;

        public Builder(Context context, VideoFrameReleaseControl videoFrameReleaseControl) {
            this.f8235a = context.getApplicationContext();
            this.f8236b = videoFrameReleaseControl;
        }
    }

    public final class FrameRendererImpl implements VideoFrameRenderControl.FrameRenderer {
        public FrameRendererImpl() {
        }
    }

    public interface Listener {
        void b(VideoSize videoSize);

        void e();

        void h();
    }

    public static final class ReflectiveDefaultVideoFrameProcessorFactory implements VideoFrameProcessor.Factory {

        /* renamed from: a, reason: collision with root package name */
        public static final Supplier f8242a = Suppliers.a(new d());
    }

    public static final class ReflectivePreviewingSingleInputVideoGraphFactory implements PreviewingVideoGraph.Factory {

        /* renamed from: a, reason: collision with root package name */
        public final VideoFrameProcessor.Factory f8243a;

        public ReflectivePreviewingSingleInputVideoGraphFactory(VideoFrameProcessor.Factory factory) {
            this.f8243a = factory;
        }

        @Override // androidx.media3.common.PreviewingVideoGraph.Factory
        public final PreviewingVideoGraph a(Context context, ColorInfo colorInfo, VideoGraph.Listener listener, a aVar, List list) throws VideoFrameProcessingException {
            try {
                return ((PreviewingVideoGraph.Factory) Class.forName("androidx.media3.effect.PreviewingSingleInputVideoGraph$Factory").getConstructor(VideoFrameProcessor.Factory.class).newInstance(this.f8243a)).a(context, colorInfo, listener, aVar, list);
            } catch (Exception e2) {
                int i2 = VideoFrameProcessingException.f5558a;
                if (e2 instanceof VideoFrameProcessingException) {
                    throw ((VideoFrameProcessingException) e2);
                }
                throw new VideoFrameProcessingException(e2);
            }
        }
    }

    public static final class ScaleAndRotateAccessor {

        /* renamed from: a, reason: collision with root package name */
        public static Constructor f8244a;

        /* renamed from: b, reason: collision with root package name */
        public static Method f8245b;

        /* renamed from: c, reason: collision with root package name */
        public static Method f8246c;

        public static void a() throws ClassNotFoundException {
            if (f8244a == null || f8245b == null || f8246c == null) {
                Class<?> cls = Class.forName("androidx.media3.effect.ScaleAndRotateTransformation$Builder");
                f8244a = cls.getConstructor(null);
                f8245b = cls.getMethod("setRotationDegrees", Float.TYPE);
                f8246c = cls.getMethod("build", null);
            }
        }
    }

    public final class VideoSinkImpl implements VideoSink, Listener {

        /* renamed from: a, reason: collision with root package name */
        public final Context f8247a;

        /* renamed from: b, reason: collision with root package name */
        public final int f8248b;

        /* renamed from: c, reason: collision with root package name */
        public final ArrayList f8249c;

        /* renamed from: d, reason: collision with root package name */
        public Effect f8250d;

        /* renamed from: e, reason: collision with root package name */
        public VideoFrameProcessor f8251e;

        /* renamed from: f, reason: collision with root package name */
        public Format f8252f;

        /* renamed from: g, reason: collision with root package name */
        public long f8253g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f8254h;

        /* renamed from: i, reason: collision with root package name */
        public long f8255i;

        /* renamed from: j, reason: collision with root package name */
        public long f8256j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f8257k;

        /* renamed from: l, reason: collision with root package name */
        public long f8258l;

        /* renamed from: m, reason: collision with root package name */
        public VideoSink.Listener f8259m;
        public Executor n;

        public VideoSinkImpl(Context context) {
            this.f8247a = context;
            this.f8248b = Util.P(context) ? 1 : 5;
            this.f8249c = new ArrayList();
            this.f8255i = -9223372036854775807L;
            this.f8256j = -9223372036854775807L;
            this.f8259m = VideoSink.Listener.f8348a;
            this.n = CompositingVideoSinkProvider.o;
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public final void C(float f2) {
            VideoFrameRenderControl videoFrameRenderControl = CompositingVideoSinkProvider.this.f8225d;
            videoFrameRenderControl.getClass();
            Assertions.a(f2 > 0.0f);
            VideoFrameReleaseControl videoFrameReleaseControl = videoFrameRenderControl.f8337b;
            if (f2 == videoFrameReleaseControl.f8312j) {
                return;
            }
            videoFrameReleaseControl.f8312j = f2;
            VideoFrameReleaseHelper videoFrameReleaseHelper = videoFrameReleaseControl.f8304b;
            videoFrameReleaseHelper.f8324i = f2;
            videoFrameReleaseHelper.f8328m = 0L;
            videoFrameReleaseHelper.p = -1L;
            videoFrameReleaseHelper.n = -1L;
            videoFrameReleaseHelper.d(false);
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public final boolean a() {
            if (!d()) {
                return false;
            }
            CompositingVideoSinkProvider compositingVideoSinkProvider = CompositingVideoSinkProvider.this;
            return compositingVideoSinkProvider.f8234m == 0 && compositingVideoSinkProvider.f8225d.f8337b.b(true);
        }

        @Override // androidx.media3.exoplayer.video.CompositingVideoSinkProvider.Listener
        public final void b(VideoSize videoSize) {
            this.n.execute(new e(this, this.f8259m, videoSize));
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public final boolean c() {
            if (!d()) {
                return false;
            }
            long j2 = this.f8255i;
            if (j2 == -9223372036854775807L) {
                return false;
            }
            CompositingVideoSinkProvider compositingVideoSinkProvider = CompositingVideoSinkProvider.this;
            if (compositingVideoSinkProvider.f8234m != 0) {
                return false;
            }
            long j3 = compositingVideoSinkProvider.f8225d.f8345j;
            return j3 != -9223372036854775807L && j3 >= j2;
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public final boolean d() {
            return this.f8251e != null;
        }

        @Override // androidx.media3.exoplayer.video.CompositingVideoSinkProvider.Listener
        public final void e() {
            this.n.execute(new e(this, this.f8259m, 2));
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public final void f() {
            VideoFrameReleaseControl videoFrameReleaseControl = CompositingVideoSinkProvider.this.f8224c;
            if (videoFrameReleaseControl.f8306d == 0) {
                videoFrameReleaseControl.f8306d = 1;
            }
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public final Surface g() {
            Assertions.g(d());
            VideoFrameProcessor videoFrameProcessor = this.f8251e;
            Assertions.h(videoFrameProcessor);
            return videoFrameProcessor.g();
        }

        @Override // androidx.media3.exoplayer.video.CompositingVideoSinkProvider.Listener
        public final void h() {
            this.n.execute(new e(this, this.f8259m, 1));
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public final void i(long j2, long j3) throws VideoSink.VideoSinkException {
            try {
                CompositingVideoSinkProvider.this.b(j2, j3);
            } catch (ExoPlaybackException e2) {
                Format format = this.f8252f;
                if (format == null) {
                    format = new Format(new Format.Builder());
                }
                throw new VideoSink.VideoSinkException(e2, format);
            }
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public final void j(VideoFrameMetadataListener videoFrameMetadataListener) {
            CompositingVideoSinkProvider.this.f8230i = videoFrameMetadataListener;
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public final long k(long j2, boolean z) {
            Assertions.g(d());
            int i2 = this.f8248b;
            Assertions.g(i2 != -1);
            long j3 = this.f8258l;
            CompositingVideoSinkProvider compositingVideoSinkProvider = CompositingVideoSinkProvider.this;
            if (j3 != -9223372036854775807L) {
                if (compositingVideoSinkProvider.f8234m == 0) {
                    long j4 = compositingVideoSinkProvider.f8225d.f8345j;
                    if (j4 != -9223372036854775807L && j4 >= j3) {
                        y();
                        this.f8258l = -9223372036854775807L;
                    }
                }
                return -9223372036854775807L;
            }
            VideoFrameProcessor videoFrameProcessor = this.f8251e;
            Assertions.h(videoFrameProcessor);
            if (videoFrameProcessor.i() < i2) {
                VideoFrameProcessor videoFrameProcessor2 = this.f8251e;
                Assertions.h(videoFrameProcessor2);
                if (videoFrameProcessor2.h()) {
                    if (this.f8254h) {
                        compositingVideoSinkProvider.f8225d.f8340e.a(j2, Long.valueOf(this.f8253g));
                        this.f8254h = false;
                    }
                    this.f8256j = j2;
                    if (z) {
                        this.f8255i = j2;
                    }
                    return j2 * 1000;
                }
            }
            return -9223372036854775807L;
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public final void l() {
            CompositingVideoSinkProvider.this.f8224c.e();
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public final void m(List list) {
            ArrayList arrayList = this.f8249c;
            if (arrayList.equals(list)) {
                return;
            }
            arrayList.clear();
            arrayList.addAll(list);
            y();
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public final boolean n() {
            return Util.P(this.f8247a);
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public final void o(Format format) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
            int i2;
            Format format2;
            Assertions.g(d());
            CompositingVideoSinkProvider.this.f8224c.f(format.u);
            if (Util.f5744a >= 21 || (i2 = format.v) == -1 || i2 == 0) {
                this.f8250d = null;
            } else if (this.f8250d == null || (format2 = this.f8252f) == null || format2.v != i2) {
                float f2 = i2;
                try {
                    ScaleAndRotateAccessor.a();
                    Object objNewInstance = ScaleAndRotateAccessor.f8244a.newInstance(null);
                    ScaleAndRotateAccessor.f8245b.invoke(objNewInstance, Float.valueOf(f2));
                    Object objInvoke = ScaleAndRotateAccessor.f8246c.invoke(objNewInstance, null);
                    objInvoke.getClass();
                    this.f8250d = (Effect) objInvoke;
                } catch (Exception e2) {
                    throw new IllegalStateException(e2);
                }
            }
            this.f8252f = format;
            if (this.f8257k) {
                Assertions.g(this.f8256j != -9223372036854775807L);
                this.f8258l = this.f8256j;
            } else {
                y();
                this.f8257k = true;
                this.f8258l = -9223372036854775807L;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v0, types: [androidx.media3.exoplayer.video.a] */
        @Override // androidx.media3.exoplayer.video.VideoSink
        public final void p(Format format) throws VideoSink.VideoSinkException {
            Assertions.g(!d());
            CompositingVideoSinkProvider compositingVideoSinkProvider = CompositingVideoSinkProvider.this;
            Assertions.g(compositingVideoSinkProvider.n == 0);
            ColorInfo colorInfoA = format.z;
            if (colorInfoA == null || !colorInfoA.d()) {
                colorInfoA = ColorInfo.f5169h;
            }
            if (colorInfoA.f5177c == 7 && Util.f5744a < 34) {
                ColorInfo.Builder builder = new ColorInfo.Builder();
                builder.f5182a = colorInfoA.f5175a;
                builder.f5183b = colorInfoA.f5176b;
                builder.f5185d = colorInfoA.f5178d;
                builder.f5186e = colorInfoA.f5179e;
                builder.f5187f = colorInfoA.f5180f;
                builder.f5184c = 6;
                colorInfoA = builder.a();
            }
            ColorInfo colorInfo = colorInfoA;
            Looper looperMyLooper = Looper.myLooper();
            Assertions.h(looperMyLooper);
            final HandlerWrapper handlerWrapperA = compositingVideoSinkProvider.f8227f.a(looperMyLooper, null);
            compositingVideoSinkProvider.f8231j = handlerWrapperA;
            try {
                compositingVideoSinkProvider.f8232k = ((ReflectivePreviewingSingleInputVideoGraphFactory) compositingVideoSinkProvider.f8226e).a(compositingVideoSinkProvider.f8222a, colorInfo, compositingVideoSinkProvider, new Executor() { // from class: androidx.media3.exoplayer.video.a
                    @Override // java.util.concurrent.Executor
                    public final void execute(Runnable runnable) {
                        handlerWrapperA.i(runnable);
                    }
                }, ImmutableList.r());
                Pair pair = compositingVideoSinkProvider.f8233l;
                if (pair != null) {
                    Surface surface = (Surface) pair.first;
                    Size size = (Size) pair.second;
                    compositingVideoSinkProvider.a(surface, size.f5731a, size.f5732b);
                }
                compositingVideoSinkProvider.f8232k.d();
                compositingVideoSinkProvider.n = 1;
                this.f8251e = compositingVideoSinkProvider.f8232k.c();
            } catch (VideoFrameProcessingException e2) {
                throw new VideoSink.VideoSinkException(e2, format);
            }
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public final void q(boolean z) {
            CompositingVideoSinkProvider.this.f8224c.f8306d = z ? 1 : 0;
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public final void r() {
            CompositingVideoSinkProvider.this.f8224c.d();
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public final void release() {
            CompositingVideoSinkProvider compositingVideoSinkProvider = CompositingVideoSinkProvider.this;
            if (compositingVideoSinkProvider.n == 2) {
                return;
            }
            HandlerWrapper handlerWrapper = compositingVideoSinkProvider.f8231j;
            if (handlerWrapper != null) {
                handlerWrapper.d();
            }
            PreviewingVideoGraph previewingVideoGraph = compositingVideoSinkProvider.f8232k;
            if (previewingVideoGraph != null) {
                previewingVideoGraph.release();
            }
            compositingVideoSinkProvider.f8233l = null;
            compositingVideoSinkProvider.n = 2;
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public final void s(Surface surface, Size size) {
            CompositingVideoSinkProvider compositingVideoSinkProvider = CompositingVideoSinkProvider.this;
            Pair pair = compositingVideoSinkProvider.f8233l;
            if (pair != null && ((Surface) pair.first).equals(surface) && ((Size) compositingVideoSinkProvider.f8233l.second).equals(size)) {
                return;
            }
            compositingVideoSinkProvider.f8233l = Pair.create(surface, size);
            compositingVideoSinkProvider.a(surface, size.f5731a, size.f5732b);
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public final void t(long j2) {
            this.f8254h |= this.f8253g != j2;
            this.f8253g = j2;
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public final void u() {
            CompositingVideoSinkProvider.this.f8224c.c(0);
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public final void v() {
            CompositingVideoSinkProvider compositingVideoSinkProvider = CompositingVideoSinkProvider.this;
            compositingVideoSinkProvider.getClass();
            Size size = Size.f5730c;
            compositingVideoSinkProvider.a(null, size.f5731a, size.f5732b);
            compositingVideoSinkProvider.f8233l = null;
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public final void w(boolean z) {
            if (d()) {
                this.f8251e.flush();
            }
            this.f8257k = false;
            this.f8255i = -9223372036854775807L;
            this.f8256j = -9223372036854775807L;
            final CompositingVideoSinkProvider compositingVideoSinkProvider = CompositingVideoSinkProvider.this;
            if (compositingVideoSinkProvider.n == 1) {
                compositingVideoSinkProvider.f8234m++;
                compositingVideoSinkProvider.f8225d.a();
                HandlerWrapper handlerWrapper = compositingVideoSinkProvider.f8231j;
                Assertions.h(handlerWrapper);
                handlerWrapper.i(new Runnable() { // from class: androidx.media3.exoplayer.video.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        CompositingVideoSinkProvider compositingVideoSinkProvider2 = compositingVideoSinkProvider;
                        int i2 = compositingVideoSinkProvider2.f8234m - 1;
                        compositingVideoSinkProvider2.f8234m = i2;
                        if (i2 > 0) {
                            return;
                        }
                        if (i2 < 0) {
                            throw new IllegalStateException(String.valueOf(compositingVideoSinkProvider2.f8234m));
                        }
                        compositingVideoSinkProvider2.f8225d.a();
                    }
                });
            }
            if (z) {
                VideoFrameReleaseControl videoFrameReleaseControl = compositingVideoSinkProvider.f8224c;
                VideoFrameReleaseHelper videoFrameReleaseHelper = videoFrameReleaseControl.f8304b;
                videoFrameReleaseHelper.f8328m = 0L;
                videoFrameReleaseHelper.p = -1L;
                videoFrameReleaseHelper.n = -1L;
                videoFrameReleaseControl.f8309g = -9223372036854775807L;
                videoFrameReleaseControl.f8307e = -9223372036854775807L;
                videoFrameReleaseControl.c(1);
                videoFrameReleaseControl.f8310h = -9223372036854775807L;
            }
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public final void x(VideoSink.Listener listener, Executor executor) {
            this.f8259m = listener;
            this.n = executor;
        }

        public final void y() {
            if (this.f8252f == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            Effect effect = this.f8250d;
            if (effect != null) {
                arrayList.add(effect);
            }
            arrayList.addAll(this.f8249c);
            Format format = this.f8252f;
            format.getClass();
            VideoFrameProcessor videoFrameProcessor = this.f8251e;
            Assertions.h(videoFrameProcessor);
            ColorInfo colorInfo = format.z;
            if (colorInfo == null || !colorInfo.d()) {
                ColorInfo colorInfo2 = ColorInfo.f5169h;
            }
            int i2 = format.s;
            Assertions.b(i2 > 0, "width must be positive, but is: " + i2);
            int i3 = format.t;
            Assertions.b(i3 > 0, "height must be positive, but is: " + i3);
            videoFrameProcessor.j();
            this.f8255i = -9223372036854775807L;
        }
    }

    public CompositingVideoSinkProvider(Builder builder) {
        Context context = builder.f8235a;
        this.f8222a = context;
        VideoSinkImpl videoSinkImpl = new VideoSinkImpl(context);
        this.f8223b = videoSinkImpl;
        SystemClock systemClock = builder.f8239e;
        this.f8227f = systemClock;
        VideoFrameReleaseControl videoFrameReleaseControl = builder.f8236b;
        this.f8224c = videoFrameReleaseControl;
        videoFrameReleaseControl.f8313k = systemClock;
        this.f8225d = new VideoFrameRenderControl(new FrameRendererImpl(), videoFrameReleaseControl);
        PreviewingVideoGraph.Factory factory = builder.f8238d;
        Assertions.h(factory);
        this.f8226e = factory;
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        this.f8228g = copyOnWriteArraySet;
        this.n = 0;
        copyOnWriteArraySet.add(videoSinkImpl);
    }

    public final void a(Surface surface, int i2, int i3) {
        PreviewingVideoGraph previewingVideoGraph = this.f8232k;
        if (previewingVideoGraph != null) {
            previewingVideoGraph.b();
            this.f8224c.g(surface);
        }
    }

    public final void b(long j2, long j3) {
        if (this.f8234m != 0) {
            return;
        }
        while (true) {
            VideoFrameRenderControl videoFrameRenderControl = this.f8225d;
            LongArrayQueue longArrayQueue = videoFrameRenderControl.f8341f;
            int i2 = longArrayQueue.f5706b;
            if (i2 == 0) {
                return;
            }
            if (i2 == 0) {
                throw new NoSuchElementException();
            }
            long j4 = longArrayQueue.f5707c[longArrayQueue.f5705a];
            Long l2 = (Long) videoFrameRenderControl.f8340e.f(j4);
            VideoFrameReleaseControl videoFrameReleaseControl = videoFrameRenderControl.f8337b;
            if (l2 != null && l2.longValue() != videoFrameRenderControl.f8344i) {
                videoFrameRenderControl.f8344i = l2.longValue();
                videoFrameReleaseControl.c(2);
            }
            int iA = videoFrameRenderControl.f8337b.a(j4, j2, j3, videoFrameRenderControl.f8344i, false, videoFrameRenderControl.f8338c);
            FrameRendererImpl frameRendererImpl = videoFrameRenderControl.f8336a;
            CompositingVideoSinkProvider compositingVideoSinkProvider = CompositingVideoSinkProvider.this;
            if (iA == 0 || iA == 1) {
                videoFrameRenderControl.f8345j = j4;
                boolean z = iA == 0;
                long jA = longArrayQueue.a();
                VideoSize videoSize = (VideoSize) videoFrameRenderControl.f8339d.f(jA);
                if (videoSize != null && !videoSize.equals(VideoSize.f5559e) && !videoSize.equals(videoFrameRenderControl.f8343h)) {
                    videoFrameRenderControl.f8343h = videoSize;
                    Format.Builder builder = new Format.Builder();
                    builder.r = videoSize.f5564a;
                    builder.s = videoSize.f5565b;
                    builder.f5237l = MimeTypes.p("video/raw");
                    compositingVideoSinkProvider.f8229h = new Format(builder);
                    Iterator it = compositingVideoSinkProvider.f8228g.iterator();
                    while (it.hasNext()) {
                        ((Listener) it.next()).b(videoSize);
                    }
                }
                if (!z) {
                    long j5 = videoFrameRenderControl.f8338c.f8315b;
                }
                boolean z2 = videoFrameReleaseControl.f8306d != 3;
                videoFrameReleaseControl.f8306d = 3;
                videoFrameReleaseControl.f8313k.getClass();
                videoFrameReleaseControl.f8308f = Util.T(android.os.SystemClock.elapsedRealtime());
                CompositingVideoSinkProvider compositingVideoSinkProvider2 = CompositingVideoSinkProvider.this;
                if (z2 && compositingVideoSinkProvider2.f8233l != null) {
                    Iterator it2 = compositingVideoSinkProvider2.f8228g.iterator();
                    while (it2.hasNext()) {
                        ((Listener) it2.next()).e();
                    }
                }
                if (compositingVideoSinkProvider2.f8230i != null) {
                    Format format = compositingVideoSinkProvider2.f8229h;
                    Format format2 = format == null ? new Format(new Format.Builder()) : format;
                    VideoFrameMetadataListener videoFrameMetadataListener = compositingVideoSinkProvider2.f8230i;
                    compositingVideoSinkProvider2.f8227f.getClass();
                    videoFrameMetadataListener.e(jA, System.nanoTime(), format2, null);
                }
                PreviewingVideoGraph previewingVideoGraph = compositingVideoSinkProvider2.f8232k;
                Assertions.h(previewingVideoGraph);
                previewingVideoGraph.a();
            } else {
                if (iA != 2 && iA != 3 && iA != 4) {
                    if (iA != 5) {
                        throw new IllegalStateException(String.valueOf(iA));
                    }
                    return;
                }
                videoFrameRenderControl.f8345j = j4;
                longArrayQueue.a();
                Iterator it3 = compositingVideoSinkProvider.f8228g.iterator();
                while (it3.hasNext()) {
                    ((Listener) it3.next()).h();
                }
                PreviewingVideoGraph previewingVideoGraph2 = compositingVideoSinkProvider.f8232k;
                Assertions.h(previewingVideoGraph2);
                previewingVideoGraph2.a();
            }
        }
    }
}
