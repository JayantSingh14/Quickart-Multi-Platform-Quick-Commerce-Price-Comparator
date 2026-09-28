package androidx.media3.exoplayer.video;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.media3.common.util.GlProgram;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.decoder.VideoDecoderOutputBuffer;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.util.concurrent.atomic.AtomicReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

@UnstableApi
/* loaded from: classes3.dex */
public final class VideoDecoderGLSurfaceView extends GLSurfaceView implements VideoDecoderOutputBufferRenderer {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f8289b = 0;

    /* renamed from: a, reason: collision with root package name */
    public final Renderer f8290a;

    public static final class Renderer implements GLSurfaceView.Renderer {

        /* renamed from: j, reason: collision with root package name */
        public static final float[] f8291j = {1.164f, 1.164f, 1.164f, 0.0f, -0.213f, 2.112f, 1.793f, -0.533f, 0.0f};

        /* renamed from: k, reason: collision with root package name */
        public static final String[] f8292k = {"y_tex", "u_tex", "v_tex"};

        /* renamed from: l, reason: collision with root package name */
        public static final FloatBuffer f8293l = GlUtil.d(new float[]{-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f});

        /* renamed from: a, reason: collision with root package name */
        public final VideoDecoderGLSurfaceView f8294a;

        /* renamed from: b, reason: collision with root package name */
        public final int[] f8295b = new int[3];

        /* renamed from: c, reason: collision with root package name */
        public final int[] f8296c = new int[3];

        /* renamed from: d, reason: collision with root package name */
        public final int[] f8297d = new int[3];

        /* renamed from: e, reason: collision with root package name */
        public final int[] f8298e = new int[3];

        /* renamed from: f, reason: collision with root package name */
        public final AtomicReference f8299f = new AtomicReference();

        /* renamed from: g, reason: collision with root package name */
        public GlProgram f8300g;

        /* renamed from: h, reason: collision with root package name */
        public int f8301h;

        /* renamed from: i, reason: collision with root package name */
        public VideoDecoderOutputBuffer f8302i;

        public Renderer(VideoDecoderGLSurfaceView videoDecoderGLSurfaceView) {
            this.f8294a = videoDecoderGLSurfaceView;
            for (int i2 = 0; i2 < 3; i2++) {
                int[] iArr = this.f8297d;
                this.f8298e[i2] = -1;
                iArr[i2] = -1;
            }
        }

        public final void a() {
            int[] iArr = this.f8295b;
            try {
                GLES20.glGenTextures(3, iArr, 0);
                for (int i2 = 0; i2 < 3; i2++) {
                    GlProgram glProgram = this.f8300g;
                    GLES20.glUniform1i(GLES20.glGetUniformLocation(glProgram.f5682a, f8292k[i2]), i2);
                    GLES20.glActiveTexture(33984 + i2);
                    GlUtil.a(3553, iArr[i2]);
                }
                GlUtil.b();
            } catch (GlUtil.GlException e2) {
                Log.e("VideoDecoderGLSV", "Failed to set up the textures", e2);
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public final void onDrawFrame(GL10 gl10) {
            VideoDecoderOutputBuffer videoDecoderOutputBuffer = (VideoDecoderOutputBuffer) this.f8299f.getAndSet(null);
            if (videoDecoderOutputBuffer == null && this.f8302i == null) {
                return;
            }
            if (videoDecoderOutputBuffer != null) {
                VideoDecoderOutputBuffer videoDecoderOutputBuffer2 = this.f8302i;
                if (videoDecoderOutputBuffer2 != null) {
                    videoDecoderOutputBuffer2.getClass();
                    throw null;
                }
                this.f8302i = videoDecoderOutputBuffer;
            }
            this.f8302i.getClass();
            GLES20.glUniformMatrix3fv(this.f8301h, 1, false, f8291j, 0);
            throw null;
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public final void onSurfaceChanged(GL10 gl10, int i2, int i3) {
            GLES20.glViewport(0, 0, i2, i3);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public final void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            int[] iArr = this.f8296c;
            try {
                GlProgram glProgram = new GlProgram("varying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nattribute vec4 in_pos;\nattribute vec2 in_tc_y;\nattribute vec2 in_tc_u;\nattribute vec2 in_tc_v;\nvoid main() {\n  gl_Position = in_pos;\n  interp_tc_y = in_tc_y;\n  interp_tc_u = in_tc_u;\n  interp_tc_v = in_tc_v;\n}\n", "precision mediump float;\nvarying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nuniform sampler2D y_tex;\nuniform sampler2D u_tex;\nuniform sampler2D v_tex;\nuniform mat3 mColorConversion;\nvoid main() {\n  vec3 yuv;\n  yuv.x = texture2D(y_tex, interp_tc_y).r - 0.0625;\n  yuv.y = texture2D(u_tex, interp_tc_u).r - 0.5;\n  yuv.z = texture2D(v_tex, interp_tc_v).r - 0.5;\n  gl_FragColor = vec4(mColorConversion * yuv, 1.0);\n}\n");
                this.f8300g = glProgram;
                GLES20.glVertexAttribPointer(glProgram.b("in_pos"), 2, 5126, false, 0, (Buffer) f8293l);
                iArr[0] = this.f8300g.b("in_tc_y");
                iArr[1] = this.f8300g.b("in_tc_u");
                iArr[2] = this.f8300g.b("in_tc_v");
                this.f8301h = GLES20.glGetUniformLocation(this.f8300g.f5682a, "mColorConversion");
                GlUtil.b();
                a();
                GlUtil.b();
            } catch (GlUtil.GlException e2) {
                Log.e("VideoDecoderGLSV", "Failed to set up the textures and program", e2);
            }
        }
    }

    public VideoDecoderGLSurfaceView(Context context) {
        this(context, null);
    }

    @Deprecated
    public VideoDecoderOutputBufferRenderer getVideoDecoderOutputBufferRenderer() {
        return this;
    }

    public void setOutputBuffer(VideoDecoderOutputBuffer videoDecoderOutputBuffer) {
        Renderer renderer = this.f8290a;
        if (((VideoDecoderOutputBuffer) renderer.f8299f.getAndSet(videoDecoderOutputBuffer)) != null) {
            throw null;
        }
        renderer.f8294a.requestRender();
    }

    public VideoDecoderGLSurfaceView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Renderer renderer = new Renderer(this);
        this.f8290a = renderer;
        setPreserveEGLContextOnPause(true);
        setEGLContextClientVersion(2);
        setRenderer(renderer);
        setRenderMode(0);
    }
}
