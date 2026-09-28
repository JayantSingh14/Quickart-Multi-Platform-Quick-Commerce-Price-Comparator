package androidx.media3.exoplayer.video.spherical;

import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.opengl.GLES20;
import androidx.media3.common.Format;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimedValueQueue;
import androidx.media3.exoplayer.video.VideoFrameMetadataListener;
import androidx.media3.exoplayer.video.spherical.Projection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
final class SceneRenderer implements VideoFrameMetadataListener, CameraMotionListener {

    /* renamed from: i, reason: collision with root package name */
    public int f8412i;

    /* renamed from: j, reason: collision with root package name */
    public SurfaceTexture f8413j;

    /* renamed from: m, reason: collision with root package name */
    public byte[] f8416m;

    /* renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f8404a = new AtomicBoolean();

    /* renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f8405b = new AtomicBoolean(true);

    /* renamed from: c, reason: collision with root package name */
    public final ProjectionRenderer f8406c = new ProjectionRenderer();

    /* renamed from: d, reason: collision with root package name */
    public final FrameRotationQueue f8407d = new FrameRotationQueue();

    /* renamed from: e, reason: collision with root package name */
    public final TimedValueQueue f8408e = new TimedValueQueue();

    /* renamed from: f, reason: collision with root package name */
    public final TimedValueQueue f8409f = new TimedValueQueue();

    /* renamed from: g, reason: collision with root package name */
    public final float[] f8410g = new float[16];

    /* renamed from: h, reason: collision with root package name */
    public final float[] f8411h = new float[16];

    /* renamed from: k, reason: collision with root package name */
    public volatile int f8414k = 0;

    /* renamed from: l, reason: collision with root package name */
    public int f8415l = -1;

    public final SurfaceTexture a() {
        try {
            GLES20.glClearColor(0.5f, 0.5f, 0.5f, 1.0f);
            GlUtil.b();
            this.f8406c.a();
            GlUtil.b();
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            GlUtil.b();
            int i2 = iArr[0];
            GlUtil.a(36197, i2);
            this.f8412i = i2;
        } catch (GlUtil.GlException e2) {
            Log.e("SceneRenderer", "Failed to initialize the renderer", e2);
        }
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f8412i);
        this.f8413j = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: androidx.media3.exoplayer.video.spherical.a
            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public final void onFrameAvailable(SurfaceTexture surfaceTexture2) {
                this.f8446a.f8404a.set(true);
            }
        });
        return this.f8413j;
    }

    @Override // androidx.media3.exoplayer.video.spherical.CameraMotionListener
    public final void b(long j2, float[] fArr) {
        this.f8407d.f8371c.a(j2, fArr);
    }

    @Override // androidx.media3.exoplayer.video.spherical.CameraMotionListener
    public final void d() {
        this.f8408e.b();
        FrameRotationQueue frameRotationQueue = this.f8407d;
        frameRotationQueue.f8371c.b();
        frameRotationQueue.f8372d = false;
        this.f8405b.set(true);
    }

    @Override // androidx.media3.exoplayer.video.VideoFrameMetadataListener
    public final void e(long j2, long j3, Format format, MediaFormat mediaFormat) {
        int i2;
        ArrayList arrayListA;
        int iJ;
        this.f8408e.a(j3, Long.valueOf(j2));
        byte[] bArr = format.x;
        int i3 = format.y;
        byte[] bArr2 = this.f8416m;
        int i4 = this.f8415l;
        this.f8416m = bArr;
        if (i3 == -1) {
            i3 = this.f8414k;
        }
        this.f8415l = i3;
        if (i4 == i3 && Arrays.equals(bArr2, this.f8416m)) {
            return;
        }
        byte[] bArr3 = this.f8416m;
        Projection projection = null;
        if (bArr3 != null) {
            int i5 = this.f8415l;
            ParsableByteArray parsableByteArray = new ParsableByteArray(bArr3);
            try {
                parsableByteArray.K(4);
                iJ = parsableByteArray.j();
                parsableByteArray.J(0);
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
            if (iJ == 1886547818) {
                parsableByteArray.K(8);
                int i6 = parsableByteArray.f5724b;
                int i7 = parsableByteArray.f5725c;
                while (i6 < i7) {
                    int iJ2 = parsableByteArray.j() + i6;
                    if (iJ2 > i6 && iJ2 <= i7) {
                        int iJ3 = parsableByteArray.j();
                        if (iJ3 != 2037673328 && iJ3 != 1836279920) {
                            parsableByteArray.J(iJ2);
                            i6 = iJ2;
                        }
                        parsableByteArray.I(iJ2);
                        arrayListA = ProjectionDecoder.a(parsableByteArray);
                        break;
                    }
                    break;
                }
                arrayListA = null;
            } else {
                arrayListA = ProjectionDecoder.a(parsableByteArray);
            }
            if (arrayListA != null) {
                int size = arrayListA.size();
                if (size == 1) {
                    Projection.Mesh mesh = (Projection.Mesh) arrayListA.get(0);
                    projection = new Projection(mesh, mesh, i5);
                } else if (size == 2) {
                    projection = new Projection((Projection.Mesh) arrayListA.get(0), (Projection.Mesh) arrayListA.get(1), i5);
                }
            }
        }
        if (projection == null || !ProjectionRenderer.b(projection)) {
            int i8 = this.f8415l;
            float radians = (float) Math.toRadians(180.0f);
            float radians2 = (float) Math.toRadians(360.0f);
            float f2 = radians / 36;
            float f3 = radians2 / 72;
            float[] fArr = new float[15984];
            float[] fArr2 = new float[10656];
            int i9 = 0;
            int i10 = 0;
            int i11 = 0;
            for (int i12 = 36; i9 < i12; i12 = 36) {
                float f4 = radians / 2.0f;
                float f5 = (i9 * f2) - f4;
                int i13 = i9 + 1;
                float f6 = (i13 * f2) - f4;
                int i14 = 0;
                while (i14 < 73) {
                    float f7 = f6;
                    int i15 = i13;
                    float f8 = radians;
                    int i16 = i10;
                    int i17 = i11;
                    int i18 = 2;
                    int i19 = 0;
                    while (i19 < i18) {
                        float f9 = i19 == 0 ? f5 : f7;
                        float f10 = radians2;
                        float f11 = i14 * f3;
                        float f12 = f5;
                        float f13 = f2;
                        double d2 = 50.0f;
                        double d3 = (f11 + 3.1415927f) - (f10 / 2.0f);
                        double dSin = Math.sin(d3) * d2;
                        double d4 = f9;
                        fArr[i16] = -((float) (Math.cos(d4) * dSin));
                        fArr[i16 + 1] = (float) (Math.sin(d4) * d2);
                        int i20 = i16 + 3;
                        fArr[i16 + 2] = (float) (Math.cos(d3) * d2 * Math.cos(d4));
                        fArr2[i17] = f11 / f10;
                        int i21 = i17 + 2;
                        fArr2[i17 + 1] = ((i9 + i19) * f13) / f8;
                        if ((i14 == 0 && i19 == 0) || (i14 == 72 && i19 == 1)) {
                            System.arraycopy(fArr, i16, fArr, i20, 3);
                            i16 += 6;
                            i2 = 2;
                            System.arraycopy(fArr2, i17, fArr2, i21, 2);
                            i17 += 4;
                        } else {
                            i2 = 2;
                            i16 = i20;
                            i17 = i21;
                        }
                        i19++;
                        i18 = i2;
                        radians2 = f10;
                        f5 = f12;
                        f2 = f13;
                    }
                    i14++;
                    i10 = i16;
                    i11 = i17;
                    f6 = f7;
                    i13 = i15;
                    radians = f8;
                    f2 = f2;
                }
                i9 = i13;
            }
            Projection.Mesh mesh2 = new Projection.Mesh(new Projection.SubMesh(0, fArr, fArr2, 1));
            projection = new Projection(mesh2, mesh2, i8);
        }
        this.f8409f.a(j3, projection);
    }
}
