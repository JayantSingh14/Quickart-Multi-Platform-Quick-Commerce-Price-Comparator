package com.zeptoconsumerapp.ZeptoImage;

import android.support.v4.media.a;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
public final class ThumbHash {

    @Metadata
    public static final class Channel {

        /* renamed from: a, reason: collision with root package name */
        public final int f47567a;

        /* renamed from: b, reason: collision with root package name */
        public final int f47568b;

        /* renamed from: c, reason: collision with root package name */
        public final float[] f47569c;

        public Channel(int i2, int i3) {
            this.f47567a = i2;
            this.f47568b = i3;
            int i4 = 0;
            int i5 = 0;
            while (i4 < i3) {
                int i6 = i4 > 0 ? 0 : 1;
                while (true) {
                    int i7 = this.f47568b;
                    if (i6 * i7 < (i7 - i4) * this.f47567a) {
                        i5++;
                        i6++;
                    }
                }
                i4++;
            }
            this.f47569c = new float[i5];
        }

        public final int a(byte[] hash, int i2, int i3, float f2) {
            Intrinsics.checkNotNullParameter(hash, "hash");
            float[] fArr = this.f47569c;
            int length = fArr.length;
            for (int i4 = 0; i4 < length; i4++) {
                fArr[i4] = ((((hash[(i3 >> 1) + i2] >> ((i3 & 1) << 2)) & 15) / 7.5f) - 1.0f) * f2;
                i3++;
            }
            return i3;
        }
    }

    @Metadata
    public static final class Image {

        /* renamed from: a, reason: collision with root package name */
        public int f47570a;

        /* renamed from: b, reason: collision with root package name */
        public int f47571b;

        /* renamed from: c, reason: collision with root package name */
        public byte[] f47572c;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Image)) {
                return false;
            }
            Image image = (Image) obj;
            return this.f47570a == image.f47570a && this.f47571b == image.f47571b && Intrinsics.b(this.f47572c, image.f47572c);
        }

        public final int hashCode() {
            return Arrays.hashCode(this.f47572c) + a.b(this.f47571b, Integer.hashCode(this.f47570a) * 31, 31);
        }

        public final String toString() {
            return "Image(width=" + this.f47570a + ", height=" + this.f47571b + ", rgba=" + Arrays.toString(this.f47572c) + ")";
        }
    }

    @Metadata
    public static final class RGBA {
        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RGBA)) {
                return false;
            }
            ((RGBA) obj).getClass();
            return Float.compare(0.0f, 0.0f) == 0 && Float.compare(0.0f, 0.0f) == 0 && Float.compare(0.0f, 0.0f) == 0 && Float.compare(0.0f, 0.0f) == 0;
        }

        public final int hashCode() {
            return Float.hashCode(0.0f) + ((Float.hashCode(0.0f) + ((Float.hashCode(0.0f) + (Float.hashCode(0.0f) * 31)) * 31)) * 31);
        }

        public final String toString() {
            return "RGBA(r=0.0, g=0.0, b=0.0, a=0.0)";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x02f4 A[LOOP:10: B:123:0x02f2->B:124:0x02f4, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0160  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Bitmap a(byte[] r36) {
        /*
            Method dump skipped, instructions count: 812
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zeptoconsumerapp.ZeptoImage.ThumbHash.a(byte[]):android.graphics.Bitmap");
    }
}
