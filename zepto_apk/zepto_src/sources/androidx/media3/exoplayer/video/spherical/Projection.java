package androidx.media3.exoplayer.video.spherical;

import androidx.media3.common.util.Assertions;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* loaded from: classes3.dex */
final class Projection {

    /* renamed from: a, reason: collision with root package name */
    public final Mesh f8380a;

    /* renamed from: b, reason: collision with root package name */
    public final Mesh f8381b;

    /* renamed from: c, reason: collision with root package name */
    public final int f8382c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f8383d;

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface DrawMode {
    }

    public static final class Mesh {

        /* renamed from: a, reason: collision with root package name */
        public final SubMesh[] f8384a;

        public Mesh(SubMesh... subMeshArr) {
            this.f8384a = subMeshArr;
        }
    }

    public static final class SubMesh {

        /* renamed from: a, reason: collision with root package name */
        public final int f8385a;

        /* renamed from: b, reason: collision with root package name */
        public final int f8386b;

        /* renamed from: c, reason: collision with root package name */
        public final float[] f8387c;

        /* renamed from: d, reason: collision with root package name */
        public final float[] f8388d;

        public SubMesh(int i2, float[] fArr, float[] fArr2, int i3) {
            this.f8385a = i2;
            Assertions.a(((long) fArr.length) * 2 == ((long) fArr2.length) * 3);
            this.f8387c = fArr;
            this.f8388d = fArr2;
            this.f8386b = i3;
        }
    }

    public Projection(Mesh mesh, Mesh mesh2, int i2) {
        this.f8380a = mesh;
        this.f8381b = mesh2;
        this.f8382c = i2;
        this.f8383d = mesh == mesh2;
    }
}
