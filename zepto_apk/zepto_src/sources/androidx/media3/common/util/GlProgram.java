package androidx.media3.common.util;

import android.opengl.GLES20;
import androidx.media3.common.util.GlUtil;
import java.util.HashMap;

@UnstableApi
/* loaded from: classes3.dex */
public final class GlProgram {

    /* renamed from: a, reason: collision with root package name */
    public final int f5682a;

    /* renamed from: b, reason: collision with root package name */
    public final Attribute[] f5683b;

    /* renamed from: c, reason: collision with root package name */
    public final Uniform[] f5684c;

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f5685d;

    /* renamed from: e, reason: collision with root package name */
    public final HashMap f5686e;

    public static final class Attribute {
    }

    public static final class Uniform {
    }

    public GlProgram(String str, String str2) throws GlUtil.GlException {
        int iGlCreateProgram = GLES20.glCreateProgram();
        this.f5682a = iGlCreateProgram;
        GlUtil.b();
        a(iGlCreateProgram, 35633, str);
        a(iGlCreateProgram, 35632, str2);
        GLES20.glLinkProgram(iGlCreateProgram);
        int[] iArr = {0};
        GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
        GlUtil.c("Unable to link shader program: \n" + GLES20.glGetProgramInfoLog(iGlCreateProgram), iArr[0] == 1);
        GLES20.glUseProgram(iGlCreateProgram);
        this.f5685d = new HashMap();
        int[] iArr2 = new int[1];
        GLES20.glGetProgramiv(iGlCreateProgram, 35721, iArr2, 0);
        this.f5683b = new Attribute[iArr2[0]];
        for (int i2 = 0; i2 < iArr2[0]; i2++) {
            int i3 = this.f5682a;
            int[] iArr3 = new int[1];
            GLES20.glGetProgramiv(i3, 35722, iArr3, 0);
            int i4 = iArr3[0];
            byte[] bArr = new byte[i4];
            GLES20.glGetActiveAttrib(i3, i2, i4, new int[1], 0, new int[1], 0, new int[1], 0, bArr, 0);
            int i5 = 0;
            while (true) {
                if (i5 >= i4) {
                    break;
                }
                if (bArr[i5] == 0) {
                    i4 = i5;
                    break;
                }
                i5++;
            }
            String str3 = new String(bArr, 0, i4);
            GLES20.glGetAttribLocation(i3, str3);
            Attribute attribute = new Attribute();
            this.f5683b[i2] = attribute;
            this.f5685d.put(str3, attribute);
        }
        this.f5686e = new HashMap();
        int[] iArr4 = new int[1];
        GLES20.glGetProgramiv(this.f5682a, 35718, iArr4, 0);
        this.f5684c = new Uniform[iArr4[0]];
        for (int i6 = 0; i6 < iArr4[0]; i6++) {
            int i7 = this.f5682a;
            int[] iArr5 = new int[1];
            GLES20.glGetProgramiv(i7, 35719, iArr5, 0);
            int i8 = iArr5[0];
            byte[] bArr2 = new byte[i8];
            GLES20.glGetActiveUniform(i7, i6, i8, new int[1], 0, new int[1], 0, new int[1], 0, bArr2, 0);
            int i9 = 0;
            while (true) {
                if (i9 >= i8) {
                    break;
                }
                if (bArr2[i9] == 0) {
                    i8 = i9;
                    break;
                }
                i9++;
            }
            String str4 = new String(bArr2, 0, i8);
            GLES20.glGetUniformLocation(i7, str4);
            Uniform uniform = new Uniform();
            this.f5684c[i6] = uniform;
            this.f5686e.put(str4, uniform);
        }
        GlUtil.b();
    }

    public static void a(int i2, int i3, String str) throws GlUtil.GlException {
        int iGlCreateShader = GLES20.glCreateShader(i3);
        GLES20.glShaderSource(iGlCreateShader, str);
        GLES20.glCompileShader(iGlCreateShader);
        int[] iArr = {0};
        GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        GlUtil.c(GLES20.glGetShaderInfoLog(iGlCreateShader) + ", source: \n" + str, iArr[0] == 1);
        GLES20.glAttachShader(i2, iGlCreateShader);
        GLES20.glDeleteShader(iGlCreateShader);
        GlUtil.b();
    }

    public final int b(String str) throws GlUtil.GlException {
        int iGlGetAttribLocation = GLES20.glGetAttribLocation(this.f5682a, str);
        GLES20.glEnableVertexAttribArray(iGlGetAttribLocation);
        GlUtil.b();
        return iGlGetAttribLocation;
    }
}
