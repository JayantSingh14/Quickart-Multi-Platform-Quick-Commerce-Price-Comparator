package androidx.media3.exoplayer.video.spherical;

import android.opengl.GLES20;
import android.util.Log;
import androidx.media3.common.util.GlProgram;
import androidx.media3.common.util.GlUtil;
import androidx.media3.exoplayer.video.spherical.Projection;
import java.nio.FloatBuffer;

/* loaded from: classes3.dex */
final class ProjectionRenderer {

    /* renamed from: i, reason: collision with root package name */
    public static final float[] f8389i = {1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: j, reason: collision with root package name */
    public static final float[] f8390j = {1.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, 0.0f, 0.5f, 1.0f};

    /* renamed from: k, reason: collision with root package name */
    public static final float[] f8391k = {0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: a, reason: collision with root package name */
    public int f8392a;

    /* renamed from: b, reason: collision with root package name */
    public MeshData f8393b;

    /* renamed from: c, reason: collision with root package name */
    public GlProgram f8394c;

    /* renamed from: d, reason: collision with root package name */
    public int f8395d;

    /* renamed from: e, reason: collision with root package name */
    public int f8396e;

    /* renamed from: f, reason: collision with root package name */
    public int f8397f;

    /* renamed from: g, reason: collision with root package name */
    public int f8398g;

    /* renamed from: h, reason: collision with root package name */
    public int f8399h;

    public static class MeshData {

        /* renamed from: a, reason: collision with root package name */
        public final int f8400a;

        /* renamed from: b, reason: collision with root package name */
        public final FloatBuffer f8401b;

        /* renamed from: c, reason: collision with root package name */
        public final FloatBuffer f8402c;

        /* renamed from: d, reason: collision with root package name */
        public final int f8403d;

        public MeshData(Projection.SubMesh subMesh) {
            float[] fArr = subMesh.f8387c;
            this.f8400a = fArr.length / 3;
            this.f8401b = GlUtil.d(fArr);
            this.f8402c = GlUtil.d(subMesh.f8388d);
            int i2 = subMesh.f8386b;
            if (i2 == 1) {
                this.f8403d = 5;
            } else if (i2 != 2) {
                this.f8403d = 4;
            } else {
                this.f8403d = 6;
            }
        }
    }

    public static boolean b(Projection projection) {
        Projection.SubMesh[] subMeshArr = projection.f8380a.f8384a;
        if (subMeshArr.length == 1 && subMeshArr[0].f8385a == 0) {
            Projection.SubMesh[] subMeshArr2 = projection.f8381b.f8384a;
            if (subMeshArr2.length == 1 && subMeshArr2[0].f8385a == 0) {
                return true;
            }
        }
        return false;
    }

    public final void a() {
        try {
            GlProgram glProgram = new GlProgram("uniform mat4 uMvpMatrix;\nuniform mat3 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec2 aTexCoords;\nvarying vec2 vTexCoords;\n// Standard transformation.\nvoid main() {\n  gl_Position = uMvpMatrix * aPosition;\n  vTexCoords = (uTexMatrix * vec3(aTexCoords, 1)).xy;\n}\n", "// This is required since the texture data is GL_TEXTURE_EXTERNAL_OES.\n#extension GL_OES_EGL_image_external : require\nprecision mediump float;\n// Standard texture rendering shader.\nuniform samplerExternalOES uTexture;\nvarying vec2 vTexCoords;\nvoid main() {\n  gl_FragColor = texture2D(uTexture, vTexCoords);\n}\n");
            this.f8394c = glProgram;
            this.f8395d = GLES20.glGetUniformLocation(glProgram.f5682a, "uMvpMatrix");
            this.f8396e = GLES20.glGetUniformLocation(this.f8394c.f5682a, "uTexMatrix");
            this.f8397f = this.f8394c.b("aPosition");
            this.f8398g = this.f8394c.b("aTexCoords");
            this.f8399h = GLES20.glGetUniformLocation(this.f8394c.f5682a, "uTexture");
        } catch (GlUtil.GlException e2) {
            Log.e("ProjectionRenderer", "Failed to initialize the program", e2);
        }
    }
}
