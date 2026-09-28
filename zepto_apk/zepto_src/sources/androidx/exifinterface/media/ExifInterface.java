package androidx.exifinterface.media;

import android.content.res.AssetManager;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.support.v4.media.b;
import android.system.OsConstants;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.RestrictTo;
import androidx.exifinterface.media.ExifInterfaceUtils;
import com.google.android.gms.common.api.Api;
import j$.util.DesugarTimeZone;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.zip.CRC32;
import org.xbill.DNS.KEYRecord;
import org.xbill.DNS.TTL;
import org.xbill.DNS.Type;

/* loaded from: classes3.dex */
public class ExifInterface {
    public static final ExifTag U;
    public static final ExifTag[][] V;
    public static final ExifTag[] W;
    public static final HashMap[] X;
    public static final HashMap[] Y;
    public static final HashSet Z;
    public static final HashMap a0;
    public static final Charset b0;
    public static final byte[] c0;
    public static final byte[] d0;
    public static final Pattern e0;

    /* renamed from: a, reason: collision with root package name */
    public final String f4416a;

    /* renamed from: b, reason: collision with root package name */
    public final FileDescriptor f4417b;

    /* renamed from: c, reason: collision with root package name */
    public final AssetManager.AssetInputStream f4418c;

    /* renamed from: d, reason: collision with root package name */
    public int f4419d;

    /* renamed from: e, reason: collision with root package name */
    public final HashMap[] f4420e;

    /* renamed from: f, reason: collision with root package name */
    public final HashSet f4421f;

    /* renamed from: g, reason: collision with root package name */
    public ByteOrder f4422g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f4423h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f4424i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f4425j;

    /* renamed from: k, reason: collision with root package name */
    public int f4426k;

    /* renamed from: l, reason: collision with root package name */
    public int f4427l;

    /* renamed from: m, reason: collision with root package name */
    public byte[] f4428m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public boolean s;
    public static final boolean t = Log.isLoggable("ExifInterface", 3);
    public static final List u = Arrays.asList(1, 6, 3, 8);
    public static final List v = Arrays.asList(2, 7, 4, 5);
    public static final int[] w = {8, 8, 8};
    public static final int[] x = {8};
    public static final byte[] y = {-1, -40, -1};
    public static final byte[] z = {102, 116, 121, 112};
    public static final byte[] A = {109, 105, 102, 49};
    public static final byte[] B = {104, 101, 105, 99};
    public static final byte[] C = {79, 76, 89, 77, 80, 0};
    public static final byte[] D = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
    public static final byte[] E = {-119, 80, 78, 71, 13, 10, 26, 10};
    public static final byte[] F = {101, 88, 73, 102};
    public static final byte[] G = {73, 72, 68, 82};
    public static final byte[] H = {73, 69, 78, 68};
    public static final byte[] I = {82, 73, 70, 70};
    public static final byte[] J = {87, 69, 66, 80};
    public static final byte[] K = {69, 88, 73, 70};
    public static final byte[] L = {-99, 1, 42};
    public static final byte[] M = "VP8X".getBytes(Charset.defaultCharset());
    public static final byte[] N = "VP8L".getBytes(Charset.defaultCharset());
    public static final byte[] O = "VP8 ".getBytes(Charset.defaultCharset());
    public static final byte[] P = "ANIM".getBytes(Charset.defaultCharset());
    public static final byte[] Q = "ANMF".getBytes(Charset.defaultCharset());
    public static final String[] R = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
    public static final int[] S = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
    public static final byte[] T = {65, 83, 67, 73, 73, 0, 0, 0};

    public static class ByteOrderedDataOutputStream extends FilterOutputStream {

        /* renamed from: a, reason: collision with root package name */
        public final OutputStream f4436a;

        /* renamed from: b, reason: collision with root package name */
        public ByteOrder f4437b;

        public ByteOrderedDataOutputStream(OutputStream outputStream, ByteOrder byteOrder) {
            super(outputStream);
            this.f4436a = outputStream;
            this.f4437b = byteOrder;
        }

        public final void a(int i2) throws IOException {
            this.f4436a.write(i2);
        }

        public final void b(int i2) throws IOException {
            ByteOrder byteOrder = this.f4437b;
            ByteOrder byteOrder2 = ByteOrder.LITTLE_ENDIAN;
            OutputStream outputStream = this.f4436a;
            if (byteOrder == byteOrder2) {
                outputStream.write(i2 & 255);
                outputStream.write((i2 >>> 8) & 255);
                outputStream.write((i2 >>> 16) & 255);
                outputStream.write((i2 >>> 24) & 255);
                return;
            }
            if (byteOrder == ByteOrder.BIG_ENDIAN) {
                outputStream.write((i2 >>> 24) & 255);
                outputStream.write((i2 >>> 16) & 255);
                outputStream.write((i2 >>> 8) & 255);
                outputStream.write(i2 & 255);
            }
        }

        public final void c(short s) throws IOException {
            ByteOrder byteOrder = this.f4437b;
            ByteOrder byteOrder2 = ByteOrder.LITTLE_ENDIAN;
            OutputStream outputStream = this.f4436a;
            if (byteOrder == byteOrder2) {
                outputStream.write(s & 255);
                outputStream.write((s >>> 8) & 255);
            } else if (byteOrder == ByteOrder.BIG_ENDIAN) {
                outputStream.write((s >>> 8) & 255);
                outputStream.write(s & 255);
            }
        }

        public final void e(long j2) throws IOException {
            if (j2 > 4294967295L) {
                throw new IllegalArgumentException("val is larger than the maximum value of a 32-bit unsigned integer");
            }
            b((int) j2);
        }

        public final void l(int i2) throws IOException {
            if (i2 > 65535) {
                throw new IllegalArgumentException("val is larger than the maximum value of a 16-bit unsigned integer");
            }
            c((short) i2);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public final void write(byte[] bArr) throws IOException {
            this.f4436a.write(bArr);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public final void write(byte[] bArr, int i2, int i3) throws IOException {
            this.f4436a.write(bArr, i2, i3);
        }
    }

    public static class ExifAttribute {

        /* renamed from: a, reason: collision with root package name */
        public final int f4438a;

        /* renamed from: b, reason: collision with root package name */
        public final int f4439b;

        /* renamed from: c, reason: collision with root package name */
        public final long f4440c;

        /* renamed from: d, reason: collision with root package name */
        public final byte[] f4441d;

        public ExifAttribute(int i2, byte[] bArr, int i3) {
            this(-1L, bArr, i2, i3);
        }

        public static ExifAttribute a(String str) {
            byte[] bytes = str.concat("\u0000").getBytes(ExifInterface.b0);
            return new ExifAttribute(2, bytes, bytes.length);
        }

        public static ExifAttribute b(long j2, ByteOrder byteOrder) {
            return c(new long[]{j2}, byteOrder);
        }

        public static ExifAttribute c(long[] jArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[ExifInterface.S[4] * jArr.length]);
            byteBufferWrap.order(byteOrder);
            for (long j2 : jArr) {
                byteBufferWrap.putInt((int) j2);
            }
            return new ExifAttribute(4, byteBufferWrap.array(), jArr.length);
        }

        public static ExifAttribute d(Rational[] rationalArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[ExifInterface.S[5] * rationalArr.length]);
            byteBufferWrap.order(byteOrder);
            for (Rational rational : rationalArr) {
                byteBufferWrap.putInt((int) rational.f4446a);
                byteBufferWrap.putInt((int) rational.f4447b);
            }
            return new ExifAttribute(5, byteBufferWrap.array(), rationalArr.length);
        }

        public static ExifAttribute e(int i2, ByteOrder byteOrder) {
            return f(new int[]{i2}, byteOrder);
        }

        public static ExifAttribute f(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[ExifInterface.S[3] * iArr.length]);
            byteBufferWrap.order(byteOrder);
            for (int i2 : iArr) {
                byteBufferWrap.putShort((short) i2);
            }
            return new ExifAttribute(3, byteBufferWrap.array(), iArr.length);
        }

        public final double g(ByteOrder byteOrder) throws Throwable {
            Object objJ = j(byteOrder);
            if (objJ == null) {
                throw new NumberFormatException("NULL can't be converted to a double value");
            }
            if (objJ instanceof String) {
                return Double.parseDouble((String) objJ);
            }
            if (objJ instanceof long[]) {
                if (((long[]) objJ).length == 1) {
                    return r5[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (objJ instanceof int[]) {
                if (((int[]) objJ).length == 1) {
                    return r5[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (objJ instanceof double[]) {
                double[] dArr = (double[]) objJ;
                if (dArr.length == 1) {
                    return dArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (!(objJ instanceof Rational[])) {
                throw new NumberFormatException("Couldn't find a double value");
            }
            Rational[] rationalArr = (Rational[]) objJ;
            if (rationalArr.length != 1) {
                throw new NumberFormatException("There are more than one component");
            }
            Rational rational = rationalArr[0];
            return rational.f4446a / rational.f4447b;
        }

        public final int h(ByteOrder byteOrder) throws Throwable {
            Object objJ = j(byteOrder);
            if (objJ == null) {
                throw new NumberFormatException("NULL can't be converted to a integer value");
            }
            if (objJ instanceof String) {
                return Integer.parseInt((String) objJ);
            }
            if (objJ instanceof long[]) {
                long[] jArr = (long[]) objJ;
                if (jArr.length == 1) {
                    return (int) jArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (!(objJ instanceof int[])) {
                throw new NumberFormatException("Couldn't find a integer value");
            }
            int[] iArr = (int[]) objJ;
            if (iArr.length == 1) {
                return iArr[0];
            }
            throw new NumberFormatException("There are more than one component");
        }

        public final String i(ByteOrder byteOrder) throws Throwable {
            Object objJ = j(byteOrder);
            if (objJ == null) {
                return null;
            }
            if (objJ instanceof String) {
                return (String) objJ;
            }
            StringBuilder sb = new StringBuilder();
            int i2 = 0;
            if (objJ instanceof long[]) {
                long[] jArr = (long[]) objJ;
                while (i2 < jArr.length) {
                    sb.append(jArr[i2]);
                    i2++;
                    if (i2 != jArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (objJ instanceof int[]) {
                int[] iArr = (int[]) objJ;
                while (i2 < iArr.length) {
                    sb.append(iArr[i2]);
                    i2++;
                    if (i2 != iArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (objJ instanceof double[]) {
                double[] dArr = (double[]) objJ;
                while (i2 < dArr.length) {
                    sb.append(dArr[i2]);
                    i2++;
                    if (i2 != dArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (!(objJ instanceof Rational[])) {
                return null;
            }
            Rational[] rationalArr = (Rational[]) objJ;
            while (i2 < rationalArr.length) {
                sb.append(rationalArr[i2].f4446a);
                sb.append('/');
                sb.append(rationalArr[i2].f4447b);
                i2++;
                if (i2 != rationalArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }

        /* JADX WARN: Not initialized variable reg: 6, insn: 0x0033: MOVE (r5 I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY]) (LINE:52), block:B:16:0x0033 */
        /* JADX WARN: Removed duplicated region for block: B:153:0x016d A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r15v22, types: [int[], java.io.Serializable] */
        /* JADX WARN: Type inference failed for: r15v23, types: [java.io.Serializable, long[]] */
        /* JADX WARN: Type inference failed for: r15v24, types: [androidx.exifinterface.media.ExifInterface$Rational[], java.io.Serializable] */
        /* JADX WARN: Type inference failed for: r15v25, types: [int[], java.io.Serializable] */
        /* JADX WARN: Type inference failed for: r15v26, types: [int[], java.io.Serializable] */
        /* JADX WARN: Type inference failed for: r15v27, types: [androidx.exifinterface.media.ExifInterface$Rational[], java.io.Serializable] */
        /* JADX WARN: Type inference failed for: r15v28, types: [double[], java.io.Serializable] */
        /* JADX WARN: Type inference failed for: r15v29, types: [double[], java.io.Serializable] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.io.Serializable j(java.nio.ByteOrder r15) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 402
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.ExifAttribute.j(java.nio.ByteOrder):java.io.Serializable");
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("(");
            sb.append(ExifInterface.R[this.f4438a]);
            sb.append(", data length:");
            return b.o(sb, this.f4441d.length, ")");
        }

        public ExifAttribute(long j2, byte[] bArr, int i2, int i3) {
            this.f4438a = i2;
            this.f4439b = i3;
            this.f4440c = j2;
            this.f4441d = bArr;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface ExifStreamType {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface IfdType {
    }

    public static class Rational {

        /* renamed from: a, reason: collision with root package name */
        public final long f4446a;

        /* renamed from: b, reason: collision with root package name */
        public final long f4447b;

        public Rational(long j2, long j3) {
            if (j3 == 0) {
                this.f4446a = 0L;
                this.f4447b = 1L;
            } else {
                this.f4446a = j2;
                this.f4447b = j3;
            }
        }

        public final String toString() {
            return this.f4446a + "/" + this.f4447b;
        }
    }

    static {
        ExifTag[] exifTagArr = {new ExifTag("NewSubfileType", 254, 4), new ExifTag("SubfileType", 255, 4), new ExifTag("ImageWidth", 256, 3, 4), new ExifTag("ImageLength", Type.CAA, 3, 4), new ExifTag("BitsPerSample", Type.AVC, 3), new ExifTag("Compression", Type.DOA, 3), new ExifTag("PhotometricInterpretation", 262, 3), new ExifTag("ImageDescription", 270, 2), new ExifTag("Make", 271, 2), new ExifTag("Model", 272, 2), new ExifTag("StripOffsets", 273, 3, 4), new ExifTag("Orientation", 274, 3), new ExifTag("SamplesPerPixel", 277, 3), new ExifTag("RowsPerStrip", 278, 3, 4), new ExifTag("StripByteCounts", 279, 3, 4), new ExifTag("XResolution", 282, 5), new ExifTag("YResolution", 283, 5), new ExifTag("PlanarConfiguration", 284, 3), new ExifTag("ResolutionUnit", 296, 3), new ExifTag("TransferFunction", 301, 3), new ExifTag("Software", 305, 2), new ExifTag("DateTime", 306, 2), new ExifTag("Artist", 315, 2), new ExifTag("WhitePoint", 318, 5), new ExifTag("PrimaryChromaticities", 319, 5), new ExifTag("SubIFDPointer", 330, 4), new ExifTag("JPEGInterchangeFormat", 513, 4), new ExifTag("JPEGInterchangeFormatLength", 514, 4), new ExifTag("YCbCrCoefficients", 529, 5), new ExifTag("YCbCrSubSampling", 530, 3), new ExifTag("YCbCrPositioning", 531, 3), new ExifTag("ReferenceBlackWhite", 532, 5), new ExifTag("Copyright", 33432, 2), new ExifTag("ExifIFDPointer", 34665, 4), new ExifTag("GPSInfoIFDPointer", 34853, 4), new ExifTag("SensorTopBorder", 4, 4), new ExifTag("SensorLeftBorder", 5, 4), new ExifTag("SensorBottomBorder", 6, 4), new ExifTag("SensorRightBorder", 7, 4), new ExifTag("ISO", 23, 3), new ExifTag("JpgFromRaw", 46, 7), new ExifTag("Xmp", 700, 1)};
        ExifTag[] exifTagArr2 = {new ExifTag("ExposureTime", 33434, 5), new ExifTag("FNumber", 33437, 5), new ExifTag("ExposureProgram", 34850, 3), new ExifTag("SpectralSensitivity", 34852, 2), new ExifTag("PhotographicSensitivity", 34855, 3), new ExifTag("OECF", 34856, 7), new ExifTag("SensitivityType", 34864, 3), new ExifTag("StandardOutputSensitivity", 34865, 4), new ExifTag("RecommendedExposureIndex", 34866, 4), new ExifTag("ISOSpeed", 34867, 4), new ExifTag("ISOSpeedLatitudeyyy", 34868, 4), new ExifTag("ISOSpeedLatitudezzz", 34869, 4), new ExifTag("ExifVersion", 36864, 2), new ExifTag("DateTimeOriginal", 36867, 2), new ExifTag("DateTimeDigitized", 36868, 2), new ExifTag("OffsetTime", 36880, 2), new ExifTag("OffsetTimeOriginal", 36881, 2), new ExifTag("OffsetTimeDigitized", 36882, 2), new ExifTag("ComponentsConfiguration", 37121, 7), new ExifTag("CompressedBitsPerPixel", 37122, 5), new ExifTag("ShutterSpeedValue", 37377, 10), new ExifTag("ApertureValue", 37378, 5), new ExifTag("BrightnessValue", 37379, 10), new ExifTag("ExposureBiasValue", 37380, 10), new ExifTag("MaxApertureValue", 37381, 5), new ExifTag("SubjectDistance", 37382, 5), new ExifTag("MeteringMode", 37383, 3), new ExifTag("LightSource", 37384, 3), new ExifTag("Flash", 37385, 3), new ExifTag("FocalLength", 37386, 5), new ExifTag("SubjectArea", 37396, 3), new ExifTag("MakerNote", 37500, 7), new ExifTag("UserComment", 37510, 7), new ExifTag("SubSecTime", 37520, 2), new ExifTag("SubSecTimeOriginal", 37521, 2), new ExifTag("SubSecTimeDigitized", 37522, 2), new ExifTag("FlashpixVersion", 40960, 7), new ExifTag("ColorSpace", 40961, 3), new ExifTag("PixelXDimension", 40962, 3, 4), new ExifTag("PixelYDimension", 40963, 3, 4), new ExifTag("RelatedSoundFile", 40964, 2), new ExifTag("InteroperabilityIFDPointer", 40965, 4), new ExifTag("FlashEnergy", 41483, 5), new ExifTag("SpatialFrequencyResponse", 41484, 7), new ExifTag("FocalPlaneXResolution", 41486, 5), new ExifTag("FocalPlaneYResolution", 41487, 5), new ExifTag("FocalPlaneResolutionUnit", 41488, 3), new ExifTag("SubjectLocation", 41492, 3), new ExifTag("ExposureIndex", 41493, 5), new ExifTag("SensingMethod", 41495, 3), new ExifTag("FileSource", 41728, 7), new ExifTag("SceneType", 41729, 7), new ExifTag("CFAPattern", 41730, 7), new ExifTag("CustomRendered", 41985, 3), new ExifTag("ExposureMode", 41986, 3), new ExifTag("WhiteBalance", 41987, 3), new ExifTag("DigitalZoomRatio", 41988, 5), new ExifTag("FocalLengthIn35mmFilm", 41989, 3), new ExifTag("SceneCaptureType", 41990, 3), new ExifTag("GainControl", 41991, 3), new ExifTag("Contrast", 41992, 3), new ExifTag("Saturation", 41993, 3), new ExifTag("Sharpness", 41994, 3), new ExifTag("DeviceSettingDescription", 41995, 7), new ExifTag("SubjectDistanceRange", 41996, 3), new ExifTag("ImageUniqueID", 42016, 2), new ExifTag("CameraOwnerName", 42032, 2), new ExifTag("BodySerialNumber", 42033, 2), new ExifTag("LensSpecification", 42034, 5), new ExifTag("LensMake", 42035, 2), new ExifTag("LensModel", 42036, 2), new ExifTag("Gamma", 42240, 5), new ExifTag("DNGVersion", 50706, 1), new ExifTag("DefaultCropSize", 50720, 3, 4)};
        ExifTag[] exifTagArr3 = {new ExifTag("GPSVersionID", 0, 1), new ExifTag("GPSLatitudeRef", 1, 2), new ExifTag("GPSLatitude", 2, 5, 10), new ExifTag("GPSLongitudeRef", 3, 2), new ExifTag("GPSLongitude", 4, 5, 10), new ExifTag("GPSAltitudeRef", 5, 1), new ExifTag("GPSAltitude", 6, 5), new ExifTag("GPSTimeStamp", 7, 5), new ExifTag("GPSSatellites", 8, 2), new ExifTag("GPSStatus", 9, 2), new ExifTag("GPSMeasureMode", 10, 2), new ExifTag("GPSDOP", 11, 5), new ExifTag("GPSSpeedRef", 12, 2), new ExifTag("GPSSpeed", 13, 5), new ExifTag("GPSTrackRef", 14, 2), new ExifTag("GPSTrack", 15, 5), new ExifTag("GPSImgDirectionRef", 16, 2), new ExifTag("GPSImgDirection", 17, 5), new ExifTag("GPSMapDatum", 18, 2), new ExifTag("GPSDestLatitudeRef", 19, 2), new ExifTag("GPSDestLatitude", 20, 5), new ExifTag("GPSDestLongitudeRef", 21, 2), new ExifTag("GPSDestLongitude", 22, 5), new ExifTag("GPSDestBearingRef", 23, 2), new ExifTag("GPSDestBearing", 24, 5), new ExifTag("GPSDestDistanceRef", 25, 2), new ExifTag("GPSDestDistance", 26, 5), new ExifTag("GPSProcessingMethod", 27, 7), new ExifTag("GPSAreaInformation", 28, 7), new ExifTag("GPSDateStamp", 29, 2), new ExifTag("GPSDifferential", 30, 3), new ExifTag("GPSHPositioningError", 31, 5)};
        ExifTag[] exifTagArr4 = {new ExifTag("InteroperabilityIndex", 1, 2)};
        ExifTag[] exifTagArr5 = {new ExifTag("NewSubfileType", 254, 4), new ExifTag("SubfileType", 255, 4), new ExifTag("ThumbnailImageWidth", 256, 3, 4), new ExifTag("ThumbnailImageLength", Type.CAA, 3, 4), new ExifTag("BitsPerSample", Type.AVC, 3), new ExifTag("Compression", Type.DOA, 3), new ExifTag("PhotometricInterpretation", 262, 3), new ExifTag("ImageDescription", 270, 2), new ExifTag("Make", 271, 2), new ExifTag("Model", 272, 2), new ExifTag("StripOffsets", 273, 3, 4), new ExifTag("ThumbnailOrientation", 274, 3), new ExifTag("SamplesPerPixel", 277, 3), new ExifTag("RowsPerStrip", 278, 3, 4), new ExifTag("StripByteCounts", 279, 3, 4), new ExifTag("XResolution", 282, 5), new ExifTag("YResolution", 283, 5), new ExifTag("PlanarConfiguration", 284, 3), new ExifTag("ResolutionUnit", 296, 3), new ExifTag("TransferFunction", 301, 3), new ExifTag("Software", 305, 2), new ExifTag("DateTime", 306, 2), new ExifTag("Artist", 315, 2), new ExifTag("WhitePoint", 318, 5), new ExifTag("PrimaryChromaticities", 319, 5), new ExifTag("SubIFDPointer", 330, 4), new ExifTag("JPEGInterchangeFormat", 513, 4), new ExifTag("JPEGInterchangeFormatLength", 514, 4), new ExifTag("YCbCrCoefficients", 529, 5), new ExifTag("YCbCrSubSampling", 530, 3), new ExifTag("YCbCrPositioning", 531, 3), new ExifTag("ReferenceBlackWhite", 532, 5), new ExifTag("Copyright", 33432, 2), new ExifTag("ExifIFDPointer", 34665, 4), new ExifTag("GPSInfoIFDPointer", 34853, 4), new ExifTag("DNGVersion", 50706, 1), new ExifTag("DefaultCropSize", 50720, 3, 4)};
        U = new ExifTag("StripOffsets", 273, 3);
        V = new ExifTag[][]{exifTagArr, exifTagArr2, exifTagArr3, exifTagArr4, exifTagArr5, exifTagArr, new ExifTag[]{new ExifTag("ThumbnailImage", 256, 7), new ExifTag("CameraSettingsIFDPointer", 8224, 4), new ExifTag("ImageProcessingIFDPointer", 8256, 4)}, new ExifTag[]{new ExifTag("PreviewImageStart", Type.CAA, 4), new ExifTag("PreviewImageLength", Type.AVC, 4)}, new ExifTag[]{new ExifTag("AspectFrame", 4371, 3)}, new ExifTag[]{new ExifTag("ColorSpace", 55, 3)}};
        W = new ExifTag[]{new ExifTag("SubIFDPointer", 330, 4), new ExifTag("ExifIFDPointer", 34665, 4), new ExifTag("GPSInfoIFDPointer", 34853, 4), new ExifTag("InteroperabilityIFDPointer", 40965, 4), new ExifTag("CameraSettingsIFDPointer", 8224, 1), new ExifTag("ImageProcessingIFDPointer", 8256, 1)};
        X = new HashMap[10];
        Y = new HashMap[10];
        Z = new HashSet(Arrays.asList("FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"));
        a0 = new HashMap();
        Charset charsetForName = Charset.forName("US-ASCII");
        b0 = charsetForName;
        c0 = "Exif\u0000\u0000".getBytes(charsetForName);
        d0 = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(charsetForName);
        Locale locale = Locale.US;
        new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", locale).setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale).setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        int i2 = 0;
        while (true) {
            ExifTag[][] exifTagArr6 = V;
            if (i2 >= exifTagArr6.length) {
                HashMap map = a0;
                ExifTag[] exifTagArr7 = W;
                map.put(Integer.valueOf(exifTagArr7[0].f4442a), 5);
                map.put(Integer.valueOf(exifTagArr7[1].f4442a), 1);
                map.put(Integer.valueOf(exifTagArr7[2].f4442a), 2);
                map.put(Integer.valueOf(exifTagArr7[3].f4442a), 3);
                map.put(Integer.valueOf(exifTagArr7[4].f4442a), 7);
                map.put(Integer.valueOf(exifTagArr7[5].f4442a), 8);
                Pattern.compile(".*[1-9].*");
                e0 = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
                Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                return;
            }
            X[i2] = new HashMap();
            Y[i2] = new HashMap();
            for (ExifTag exifTag : exifTagArr6[i2]) {
                X[i2].put(Integer.valueOf(exifTag.f4442a), exifTag);
                Y[i2].put(exifTag.f4443b, exifTag);
            }
            i2++;
        }
    }

    public ExifInterface(File file) throws Throwable {
        FileInputStream fileInputStream;
        boolean z2;
        ExifTag[][] exifTagArr = V;
        this.f4420e = new HashMap[exifTagArr.length];
        this.f4421f = new HashSet(exifTagArr.length);
        this.f4422g = ByteOrder.BIG_ENDIAN;
        if (file == null) {
            throw new NullPointerException("file cannot be null");
        }
        String absolutePath = file.getAbsolutePath();
        if (absolutePath == null) {
            throw new NullPointerException("filename cannot be null");
        }
        FileInputStream fileInputStream2 = null;
        this.f4418c = null;
        this.f4416a = absolutePath;
        try {
            fileInputStream = new FileInputStream(absolutePath);
        } catch (Throwable th) {
            th = th;
        }
        try {
            try {
                ExifInterfaceUtils.Api21Impl.c(fileInputStream.getFD(), 0L, OsConstants.SEEK_CUR);
                z2 = true;
            } catch (Exception unused) {
                if (t) {
                    Log.d("ExifInterface", "The file descriptor for the given input is not seekable");
                }
                z2 = false;
            }
            if (z2) {
                this.f4417b = fileInputStream.getFD();
            } else {
                this.f4417b = null;
            }
            r(fileInputStream);
            ExifInterfaceUtils.a(fileInputStream);
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            ExifInterfaceUtils.a(fileInputStream2);
            throw th;
        }
    }

    public static Pair o(String str) throws NumberFormatException {
        if (str.contains(",")) {
            String[] strArrSplit = str.split(",", -1);
            Pair pairO = o(strArrSplit[0]);
            if (((Integer) pairO.first).intValue() == 2) {
                return pairO;
            }
            for (int i2 = 1; i2 < strArrSplit.length; i2++) {
                Pair pairO2 = o(strArrSplit[i2]);
                int iIntValue = (((Integer) pairO2.first).equals(pairO.first) || ((Integer) pairO2.second).equals(pairO.first)) ? ((Integer) pairO.first).intValue() : -1;
                int iIntValue2 = (((Integer) pairO.second).intValue() == -1 || !(((Integer) pairO2.first).equals(pairO.second) || ((Integer) pairO2.second).equals(pairO.second))) ? -1 : ((Integer) pairO.second).intValue();
                if (iIntValue == -1 && iIntValue2 == -1) {
                    return new Pair(2, -1);
                }
                if (iIntValue == -1) {
                    pairO = new Pair(Integer.valueOf(iIntValue2), -1);
                } else if (iIntValue2 == -1) {
                    pairO = new Pair(Integer.valueOf(iIntValue), -1);
                }
            }
            return pairO;
        }
        if (!str.contains("/")) {
            try {
                try {
                    long j2 = Long.parseLong(str);
                    return (j2 < 0 || j2 > 65535) ? j2 < 0 ? new Pair(9, -1) : new Pair(4, -1) : new Pair(3, 4);
                } catch (NumberFormatException unused) {
                    return new Pair(2, -1);
                }
            } catch (NumberFormatException unused2) {
                Double.parseDouble(str);
                return new Pair(12, -1);
            }
        }
        String[] strArrSplit2 = str.split("/", -1);
        if (strArrSplit2.length == 2) {
            try {
                long j3 = (long) Double.parseDouble(strArrSplit2[0]);
                long j4 = (long) Double.parseDouble(strArrSplit2[1]);
                if (j3 >= 0 && j4 >= 0) {
                    if (j3 <= TTL.MAX_VALUE && j4 <= TTL.MAX_VALUE) {
                        return new Pair(10, 5);
                    }
                    return new Pair(5, -1);
                }
                return new Pair(10, -1);
            } catch (NumberFormatException unused3) {
            }
        }
        return new Pair(2, -1);
    }

    public static ByteOrder u(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        short s = byteOrderedDataInputStream.readShort();
        boolean z2 = t;
        if (s == 18761) {
            if (z2) {
                Log.d("ExifInterface", "readExifSegment: Byte Align II");
            }
            return ByteOrder.LITTLE_ENDIAN;
        }
        if (s == 19789) {
            if (z2) {
                Log.d("ExifInterface", "readExifSegment: Byte Align MM");
            }
            return ByteOrder.BIG_ENDIAN;
        }
        throw new IOException("Invalid byte order: " + Integer.toHexString(s));
    }

    public final void A(BufferedInputStream bufferedInputStream, BufferedOutputStream bufferedOutputStream) throws IOException {
        if (t) {
            Log.d("ExifInterface", "saveJpegAttributes starting with (inputStream: " + bufferedInputStream + ", outputStream: " + bufferedOutputStream + ")");
        }
        ByteOrderedDataInputStream byteOrderedDataInputStream = new ByteOrderedDataInputStream(bufferedInputStream);
        ByteOrderedDataOutputStream byteOrderedDataOutputStream = new ByteOrderedDataOutputStream(bufferedOutputStream, ByteOrder.BIG_ENDIAN);
        if (byteOrderedDataInputStream.readByte() != -1) {
            throw new IOException("Invalid marker");
        }
        byteOrderedDataOutputStream.a(-1);
        if (byteOrderedDataInputStream.readByte() != -40) {
            throw new IOException("Invalid marker");
        }
        byteOrderedDataOutputStream.a(-40);
        String strB = b("Xmp");
        HashMap[] mapArr = this.f4420e;
        ExifAttribute exifAttribute = (strB == null || !this.s) ? null : (ExifAttribute) mapArr[0].remove("Xmp");
        byteOrderedDataOutputStream.a(-1);
        byteOrderedDataOutputStream.a(-31);
        I(byteOrderedDataOutputStream);
        if (exifAttribute != null) {
            mapArr[0].put("Xmp", exifAttribute);
        }
        byte[] bArr = new byte[4096];
        while (byteOrderedDataInputStream.readByte() == -1) {
            byte b2 = byteOrderedDataInputStream.readByte();
            if (b2 == -39 || b2 == -38) {
                byteOrderedDataOutputStream.a(-1);
                byteOrderedDataOutputStream.a(b2);
                ExifInterfaceUtils.c(byteOrderedDataInputStream, byteOrderedDataOutputStream);
                return;
            }
            if (b2 != -31) {
                byteOrderedDataOutputStream.a(-1);
                byteOrderedDataOutputStream.a(b2);
                int unsignedShort = byteOrderedDataInputStream.readUnsignedShort();
                byteOrderedDataOutputStream.l(unsignedShort);
                int i2 = unsignedShort - 2;
                if (i2 < 0) {
                    throw new IOException("Invalid length");
                }
                while (i2 > 0) {
                    int i3 = byteOrderedDataInputStream.read(bArr, 0, Math.min(i2, 4096));
                    if (i3 >= 0) {
                        byteOrderedDataOutputStream.write(bArr, 0, i3);
                        i2 -= i3;
                    }
                }
            } else {
                int unsignedShort2 = byteOrderedDataInputStream.readUnsignedShort();
                int i4 = unsignedShort2 - 2;
                if (i4 < 0) {
                    throw new IOException("Invalid length");
                }
                byte[] bArr2 = new byte[6];
                if (i4 >= 6) {
                    byteOrderedDataInputStream.readFully(bArr2);
                    if (Arrays.equals(bArr2, c0)) {
                        byteOrderedDataInputStream.a(unsignedShort2 - 8);
                    }
                }
                byteOrderedDataOutputStream.a(-1);
                byteOrderedDataOutputStream.a(b2);
                byteOrderedDataOutputStream.l(unsignedShort2);
                if (i4 >= 6) {
                    i4 = unsignedShort2 - 8;
                    byteOrderedDataOutputStream.write(bArr2);
                }
                while (i4 > 0) {
                    int i5 = byteOrderedDataInputStream.read(bArr, 0, Math.min(i4, 4096));
                    if (i5 >= 0) {
                        byteOrderedDataOutputStream.write(bArr, 0, i5);
                        i4 -= i5;
                    }
                }
            }
        }
        throw new IOException("Invalid marker");
    }

    public final void B(BufferedInputStream bufferedInputStream, BufferedOutputStream bufferedOutputStream) throws Throwable {
        if (t) {
            Log.d("ExifInterface", "savePngAttributes starting with (inputStream: " + bufferedInputStream + ", outputStream: " + bufferedOutputStream + ")");
        }
        ByteOrderedDataInputStream byteOrderedDataInputStream = new ByteOrderedDataInputStream(bufferedInputStream);
        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
        ByteOrderedDataOutputStream byteOrderedDataOutputStream = new ByteOrderedDataOutputStream(bufferedOutputStream, byteOrder);
        ExifInterfaceUtils.d(byteOrderedDataInputStream, byteOrderedDataOutputStream, E.length);
        if (this.o == 0) {
            int i2 = byteOrderedDataInputStream.readInt();
            byteOrderedDataOutputStream.b(i2);
            ExifInterfaceUtils.d(byteOrderedDataInputStream, byteOrderedDataOutputStream, i2 + 8);
        } else {
            ExifInterfaceUtils.d(byteOrderedDataInputStream, byteOrderedDataOutputStream, (r2 - r7.length) - 8);
            byteOrderedDataInputStream.a(byteOrderedDataInputStream.readInt() + 8);
        }
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                ByteOrderedDataOutputStream byteOrderedDataOutputStream2 = new ByteOrderedDataOutputStream(byteArrayOutputStream2, byteOrder);
                I(byteOrderedDataOutputStream2);
                byte[] byteArray = ((ByteArrayOutputStream) byteOrderedDataOutputStream2.f4436a).toByteArray();
                byteOrderedDataOutputStream.write(byteArray);
                CRC32 crc32 = new CRC32();
                crc32.update(byteArray, 4, byteArray.length - 4);
                byteOrderedDataOutputStream.b((int) crc32.getValue());
                ExifInterfaceUtils.a(byteArrayOutputStream2);
                ExifInterfaceUtils.c(byteOrderedDataInputStream, byteOrderedDataOutputStream);
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = byteArrayOutputStream2;
                ExifInterfaceUtils.a(byteArrayOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final void C(BufferedInputStream bufferedInputStream, BufferedOutputStream bufferedOutputStream) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        int i2;
        int i3;
        int i4;
        int i5;
        ByteArrayOutputStream byteArrayOutputStream2;
        ByteOrderedDataOutputStream byteOrderedDataOutputStream;
        byte[] bArr;
        boolean z2;
        if (t) {
            Log.d("ExifInterface", "saveWebpAttributes starting with (inputStream: " + bufferedInputStream + ", outputStream: " + bufferedOutputStream + ")");
        }
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        ByteOrderedDataInputStream byteOrderedDataInputStream = new ByteOrderedDataInputStream(bufferedInputStream, byteOrder);
        ByteOrderedDataOutputStream byteOrderedDataOutputStream2 = new ByteOrderedDataOutputStream(bufferedOutputStream, byteOrder);
        byte[] bArr2 = I;
        ExifInterfaceUtils.d(byteOrderedDataInputStream, byteOrderedDataOutputStream2, bArr2.length);
        byte[] bArr3 = J;
        byteOrderedDataInputStream.a(bArr3.length + 4);
        ByteArrayOutputStream byteArrayOutputStream3 = null;
        try {
            try {
                ByteArrayOutputStream byteArrayOutputStream4 = new ByteArrayOutputStream();
                try {
                    ByteOrderedDataOutputStream byteOrderedDataOutputStream3 = new ByteOrderedDataOutputStream(byteArrayOutputStream4, byteOrder);
                    int i6 = this.o;
                    try {
                        try {
                            if (i6 != 0) {
                                ExifInterfaceUtils.d(byteOrderedDataInputStream, byteOrderedDataOutputStream3, (i6 - ((bArr2.length + 4) + bArr3.length)) - 8);
                                byteOrderedDataInputStream.a(4);
                                int i7 = byteOrderedDataInputStream.readInt();
                                if (i7 % 2 != 0) {
                                    i7++;
                                }
                                byteOrderedDataInputStream.a(i7);
                                I(byteOrderedDataOutputStream3);
                            } else {
                                byte[] bArr4 = new byte[4];
                                byteOrderedDataInputStream.readFully(bArr4);
                                byte[] bArr5 = M;
                                boolean zEquals = Arrays.equals(bArr4, bArr5);
                                byte[] bArr6 = O;
                                byte[] bArr7 = N;
                                if (!zEquals) {
                                    if (Arrays.equals(bArr4, bArr6) || Arrays.equals(bArr4, bArr7)) {
                                        int i8 = byteOrderedDataInputStream.readInt();
                                        int i9 = i8 % 2 == 1 ? i8 + 1 : i8;
                                        byte[] bArr8 = new byte[3];
                                        boolean zEquals2 = Arrays.equals(bArr4, bArr6);
                                        boolean z3 = true;
                                        byte[] bArr9 = L;
                                        if (zEquals2) {
                                            byteOrderedDataInputStream.readFully(bArr8);
                                            byte[] bArr10 = new byte[3];
                                            byteOrderedDataInputStream.readFully(bArr10);
                                            if (!Arrays.equals(bArr9, bArr10)) {
                                                throw new IOException("Error checking VP8 signature");
                                            }
                                            i2 = byteOrderedDataInputStream.readInt();
                                            i9 -= 10;
                                            i3 = (i2 << 18) >> 18;
                                            i4 = (i2 << 2) >> 18;
                                            z3 = false;
                                        } else if (!Arrays.equals(bArr4, bArr7)) {
                                            i2 = 0;
                                            i3 = 0;
                                            z3 = false;
                                            i4 = 0;
                                        } else {
                                            if (byteOrderedDataInputStream.readByte() != 47) {
                                                throw new IOException("Error checking VP8L signature");
                                            }
                                            i2 = byteOrderedDataInputStream.readInt();
                                            i3 = (i2 & 16383) + 1;
                                            i4 = ((i2 & 268419072) >>> 14) + 1;
                                            if ((i2 & 268435456) == 0) {
                                                z3 = false;
                                            }
                                            i9 -= 5;
                                        }
                                        byteOrderedDataOutputStream3.write(bArr5);
                                        byteOrderedDataOutputStream3.b(10);
                                        byte[] bArr11 = new byte[10];
                                        if (z3) {
                                            i5 = i3;
                                            bArr11[0] = (byte) (bArr11[0] | 16);
                                        } else {
                                            i5 = i3;
                                        }
                                        bArr11[0] = (byte) (bArr11[0] | 8);
                                        int i10 = i5 - 1;
                                        byteArrayOutputStream2 = byteArrayOutputStream4;
                                        int i11 = i4 - 1;
                                        byteOrderedDataOutputStream = byteOrderedDataOutputStream2;
                                        try {
                                            bArr11[4] = (byte) i10;
                                            bArr11[5] = (byte) (i10 >> 8);
                                            bArr11[6] = (byte) (i10 >> 16);
                                            bArr11[7] = (byte) i11;
                                            bArr11[8] = (byte) (i11 >> 8);
                                            bArr11[9] = (byte) (i11 >> 16);
                                            byteOrderedDataOutputStream3.write(bArr11);
                                            byteOrderedDataOutputStream3.write(bArr4);
                                            byteOrderedDataOutputStream3.b(i8);
                                        } catch (Exception e2) {
                                            e = e2;
                                            byteArrayOutputStream = byteArrayOutputStream2;
                                            byteArrayOutputStream3 = byteArrayOutputStream;
                                            throw new IOException("Failed to save WebP file", e);
                                        } catch (Throwable th) {
                                            th = th;
                                            byteArrayOutputStream = byteArrayOutputStream2;
                                            byteArrayOutputStream3 = byteArrayOutputStream;
                                            ExifInterfaceUtils.a(byteArrayOutputStream3);
                                            throw th;
                                        }
                                        try {
                                            if (Arrays.equals(bArr4, bArr6)) {
                                                byteOrderedDataOutputStream3.write(bArr8);
                                                byteOrderedDataOutputStream3.write(bArr9);
                                                byteOrderedDataOutputStream3.b(i2);
                                            } else {
                                                if (Arrays.equals(bArr4, bArr7)) {
                                                    byteOrderedDataOutputStream3.write(47);
                                                    byteOrderedDataOutputStream3.b(i2);
                                                }
                                                ExifInterfaceUtils.d(byteOrderedDataInputStream, byteOrderedDataOutputStream3, i9);
                                                I(byteOrderedDataOutputStream3);
                                            }
                                            ExifInterfaceUtils.d(byteOrderedDataInputStream, byteOrderedDataOutputStream3, i9);
                                            I(byteOrderedDataOutputStream3);
                                        } catch (Exception e3) {
                                            e = e3;
                                            byteArrayOutputStream3 = byteArrayOutputStream2;
                                            throw new IOException("Failed to save WebP file", e);
                                        } catch (Throwable th2) {
                                            th = th2;
                                            byteArrayOutputStream3 = byteArrayOutputStream2;
                                            ExifInterfaceUtils.a(byteArrayOutputStream3);
                                            throw th;
                                        }
                                    }
                                    ExifInterfaceUtils.c(byteOrderedDataInputStream, byteOrderedDataOutputStream3);
                                    ByteOrderedDataOutputStream byteOrderedDataOutputStream4 = byteOrderedDataOutputStream;
                                    byteOrderedDataOutputStream4.b(byteArrayOutputStream2.size() + bArr3.length);
                                    byteOrderedDataOutputStream4.write(bArr3);
                                    byteArrayOutputStream = byteArrayOutputStream2;
                                    byteArrayOutputStream.writeTo(byteOrderedDataOutputStream4);
                                    ExifInterfaceUtils.a(byteArrayOutputStream);
                                    return;
                                }
                                int i12 = byteOrderedDataInputStream.readInt();
                                byte[] bArr12 = new byte[i12 % 2 == 1 ? i12 + 1 : i12];
                                byteOrderedDataInputStream.readFully(bArr12);
                                byte b2 = (byte) (8 | bArr12[0]);
                                bArr12[0] = b2;
                                boolean z4 = ((b2 >> 1) & 1) == 1;
                                byteOrderedDataOutputStream3.write(bArr5);
                                byteOrderedDataOutputStream3.b(i12);
                                byteOrderedDataOutputStream3.write(bArr12);
                                if (z4) {
                                    byte[] bArr13 = P;
                                    do {
                                        bArr = new byte[4];
                                        byteOrderedDataInputStream.readFully(bArr);
                                        int i13 = byteOrderedDataInputStream.readInt();
                                        byteOrderedDataOutputStream3.write(bArr);
                                        byteOrderedDataOutputStream3.b(i13);
                                        if (i13 % 2 == 1) {
                                            i13++;
                                        }
                                        ExifInterfaceUtils.d(byteOrderedDataInputStream, byteOrderedDataOutputStream3, i13);
                                    } while (!Arrays.equals(bArr, bArr13));
                                    while (true) {
                                        byte[] bArr14 = new byte[4];
                                        try {
                                            byteOrderedDataInputStream.readFully(bArr14);
                                            z2 = !Arrays.equals(bArr14, Q);
                                        } catch (EOFException unused) {
                                            z2 = true;
                                        }
                                        if (z2) {
                                            break;
                                        }
                                        int i14 = byteOrderedDataInputStream.readInt();
                                        byteOrderedDataOutputStream3.write(bArr14);
                                        byteOrderedDataOutputStream3.b(i14);
                                        if (i14 % 2 == 1) {
                                            i14++;
                                        }
                                        ExifInterfaceUtils.d(byteOrderedDataInputStream, byteOrderedDataOutputStream3, i14);
                                    }
                                    I(byteOrderedDataOutputStream3);
                                } else {
                                    while (true) {
                                        byte[] bArr15 = new byte[4];
                                        byteOrderedDataInputStream.readFully(bArr15);
                                        int i15 = byteOrderedDataInputStream.readInt();
                                        byteOrderedDataOutputStream3.write(bArr15);
                                        byteOrderedDataOutputStream3.b(i15);
                                        if (i15 % 2 == 1) {
                                            i15++;
                                        }
                                        ExifInterfaceUtils.d(byteOrderedDataInputStream, byteOrderedDataOutputStream3, i15);
                                        if (Arrays.equals(bArr15, bArr6) || (bArr7 != null && Arrays.equals(bArr15, bArr7))) {
                                            break;
                                        }
                                    }
                                    I(byteOrderedDataOutputStream3);
                                }
                            }
                            byteArrayOutputStream.writeTo(byteOrderedDataOutputStream4);
                            ExifInterfaceUtils.a(byteArrayOutputStream);
                            return;
                        } catch (Exception e4) {
                            e = e4;
                            byteArrayOutputStream3 = byteArrayOutputStream;
                            throw new IOException("Failed to save WebP file", e);
                        } catch (Throwable th3) {
                            th = th3;
                            byteArrayOutputStream3 = byteArrayOutputStream;
                            ExifInterfaceUtils.a(byteArrayOutputStream3);
                            throw th;
                        }
                        byteOrderedDataOutputStream = byteOrderedDataOutputStream2;
                        byteArrayOutputStream2 = byteArrayOutputStream4;
                        ExifInterfaceUtils.c(byteOrderedDataInputStream, byteOrderedDataOutputStream3);
                        ByteOrderedDataOutputStream byteOrderedDataOutputStream42 = byteOrderedDataOutputStream;
                        byteOrderedDataOutputStream42.b(byteArrayOutputStream2.size() + bArr3.length);
                        byteOrderedDataOutputStream42.write(bArr3);
                        byteArrayOutputStream = byteArrayOutputStream2;
                    } catch (Exception e5) {
                        e = e5;
                        byteArrayOutputStream3 = byteArrayOutputStream4;
                    } catch (Throwable th4) {
                        th = th4;
                        byteArrayOutputStream3 = byteArrayOutputStream4;
                    }
                } catch (Exception e6) {
                    e = e6;
                    byteArrayOutputStream = byteArrayOutputStream4;
                } catch (Throwable th5) {
                    th = th5;
                    byteArrayOutputStream = byteArrayOutputStream4;
                }
            } catch (Exception e7) {
                e = e7;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0344  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0333  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void D(java.lang.String r21) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 940
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.D(java.lang.String):void");
    }

    public final void E(ByteOrderedDataInputStream byteOrderedDataInputStream) throws Throwable {
        String str;
        ExifAttribute exifAttribute;
        int iH;
        HashMap map = this.f4420e[4];
        ExifAttribute exifAttribute2 = (ExifAttribute) map.get("Compression");
        if (exifAttribute2 == null) {
            this.n = 6;
            p(byteOrderedDataInputStream, map);
            return;
        }
        int iH2 = exifAttribute2.h(this.f4422g);
        this.n = iH2;
        int i2 = 1;
        if (iH2 != 1) {
            if (iH2 == 6) {
                p(byteOrderedDataInputStream, map);
                return;
            } else if (iH2 != 7) {
                return;
            }
        }
        ExifAttribute exifAttribute3 = (ExifAttribute) map.get("BitsPerSample");
        String str2 = "ExifInterface";
        if (exifAttribute3 != null) {
            int[] iArr = (int[]) exifAttribute3.j(this.f4422g);
            int[] iArr2 = w;
            if (Arrays.equals(iArr2, iArr) || (this.f4419d == 3 && (exifAttribute = (ExifAttribute) map.get("PhotometricInterpretation")) != null && (((iH = exifAttribute.h(this.f4422g)) == 1 && Arrays.equals(iArr, x)) || (iH == 6 && Arrays.equals(iArr, iArr2))))) {
                ExifAttribute exifAttribute4 = (ExifAttribute) map.get("StripOffsets");
                ExifAttribute exifAttribute5 = (ExifAttribute) map.get("StripByteCounts");
                if (exifAttribute4 == null || exifAttribute5 == null) {
                    return;
                }
                long[] jArrB = ExifInterfaceUtils.b(exifAttribute4.j(this.f4422g));
                long[] jArrB2 = ExifInterfaceUtils.b(exifAttribute5.j(this.f4422g));
                if (jArrB == null || jArrB.length == 0) {
                    Log.w("ExifInterface", "stripOffsets should not be null or have zero length.");
                    return;
                }
                if (jArrB2 == null || jArrB2.length == 0) {
                    Log.w("ExifInterface", "stripByteCounts should not be null or have zero length.");
                    return;
                }
                if (jArrB.length != jArrB2.length) {
                    Log.w("ExifInterface", "stripOffsets and stripByteCounts should have same length.");
                    return;
                }
                long j2 = 0;
                for (long j3 : jArrB2) {
                    j2 += j3;
                }
                int i3 = (int) j2;
                byte[] bArr = new byte[i3];
                this.f4425j = true;
                this.f4424i = true;
                this.f4423h = true;
                int i4 = 0;
                int i5 = 0;
                int i6 = 0;
                while (i4 < jArrB.length) {
                    int i7 = (int) jArrB[i4];
                    int i8 = (int) jArrB2[i4];
                    if (i4 < jArrB.length - i2) {
                        str = str2;
                        if (i7 + i8 != jArrB[i4 + 1]) {
                            this.f4425j = false;
                        }
                    } else {
                        str = str2;
                    }
                    int i9 = i7 - i5;
                    if (i9 < 0) {
                        Log.d(str, "Invalid strip offset value");
                        return;
                    }
                    String str3 = str;
                    try {
                        byteOrderedDataInputStream.a(i9);
                        int i10 = i5 + i9;
                        byte[] bArr2 = new byte[i8];
                        try {
                            byteOrderedDataInputStream.readFully(bArr2);
                            i5 = i10 + i8;
                            System.arraycopy(bArr2, 0, bArr, i6, i8);
                            i6 += i8;
                            i4++;
                            str2 = str3;
                            i2 = 1;
                        } catch (EOFException unused) {
                            Log.d(str3, "Failed to read " + i8 + " bytes.");
                            return;
                        }
                    } catch (EOFException unused2) {
                        Log.d(str3, "Failed to skip " + i9 + " bytes.");
                        return;
                    }
                }
                this.f4428m = bArr;
                if (this.f4425j) {
                    this.f4426k = (int) jArrB[0];
                    this.f4427l = i3;
                    return;
                }
                return;
            }
        }
        if (t) {
            Log.d("ExifInterface", "Unsupported data type value");
        }
    }

    public final void F(int i2, int i3) throws Throwable {
        HashMap[] mapArr = this.f4420e;
        boolean zIsEmpty = mapArr[i2].isEmpty();
        boolean z2 = t;
        if (zIsEmpty || mapArr[i3].isEmpty()) {
            if (z2) {
                Log.d("ExifInterface", "Cannot perform swap since only one image data exists");
                return;
            }
            return;
        }
        ExifAttribute exifAttribute = (ExifAttribute) mapArr[i2].get("ImageLength");
        ExifAttribute exifAttribute2 = (ExifAttribute) mapArr[i2].get("ImageWidth");
        ExifAttribute exifAttribute3 = (ExifAttribute) mapArr[i3].get("ImageLength");
        ExifAttribute exifAttribute4 = (ExifAttribute) mapArr[i3].get("ImageWidth");
        if (exifAttribute == null || exifAttribute2 == null) {
            if (z2) {
                Log.d("ExifInterface", "First image does not contain valid size information");
                return;
            }
            return;
        }
        if (exifAttribute3 == null || exifAttribute4 == null) {
            if (z2) {
                Log.d("ExifInterface", "Second image does not contain valid size information");
                return;
            }
            return;
        }
        int iH = exifAttribute.h(this.f4422g);
        int iH2 = exifAttribute2.h(this.f4422g);
        int iH3 = exifAttribute3.h(this.f4422g);
        int iH4 = exifAttribute4.h(this.f4422g);
        if (iH >= iH3 || iH2 >= iH4) {
            return;
        }
        HashMap map = mapArr[i2];
        mapArr[i2] = mapArr[i3];
        mapArr[i3] = map;
    }

    public final void G(SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream, int i2) throws Throwable {
        ExifAttribute exifAttributeE;
        ExifAttribute exifAttributeE2;
        HashMap[] mapArr = this.f4420e;
        ExifAttribute exifAttribute = (ExifAttribute) mapArr[i2].get("DefaultCropSize");
        ExifAttribute exifAttribute2 = (ExifAttribute) mapArr[i2].get("SensorTopBorder");
        ExifAttribute exifAttribute3 = (ExifAttribute) mapArr[i2].get("SensorLeftBorder");
        ExifAttribute exifAttribute4 = (ExifAttribute) mapArr[i2].get("SensorBottomBorder");
        ExifAttribute exifAttribute5 = (ExifAttribute) mapArr[i2].get("SensorRightBorder");
        if (exifAttribute != null) {
            if (exifAttribute.f4438a == 5) {
                Rational[] rationalArr = (Rational[]) exifAttribute.j(this.f4422g);
                if (rationalArr == null || rationalArr.length != 2) {
                    Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(rationalArr));
                    return;
                } else {
                    exifAttributeE = ExifAttribute.d(new Rational[]{rationalArr[0]}, this.f4422g);
                    exifAttributeE2 = ExifAttribute.d(new Rational[]{rationalArr[1]}, this.f4422g);
                }
            } else {
                int[] iArr = (int[]) exifAttribute.j(this.f4422g);
                if (iArr == null || iArr.length != 2) {
                    Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(iArr));
                    return;
                }
                exifAttributeE = ExifAttribute.e(iArr[0], this.f4422g);
                exifAttributeE2 = ExifAttribute.e(iArr[1], this.f4422g);
            }
            mapArr[i2].put("ImageWidth", exifAttributeE);
            mapArr[i2].put("ImageLength", exifAttributeE2);
            return;
        }
        if (exifAttribute2 != null && exifAttribute3 != null && exifAttribute4 != null && exifAttribute5 != null) {
            int iH = exifAttribute2.h(this.f4422g);
            int iH2 = exifAttribute4.h(this.f4422g);
            int iH3 = exifAttribute5.h(this.f4422g);
            int iH4 = exifAttribute3.h(this.f4422g);
            if (iH2 <= iH || iH3 <= iH4) {
                return;
            }
            ExifAttribute exifAttributeE3 = ExifAttribute.e(iH2 - iH, this.f4422g);
            ExifAttribute exifAttributeE4 = ExifAttribute.e(iH3 - iH4, this.f4422g);
            mapArr[i2].put("ImageLength", exifAttributeE3);
            mapArr[i2].put("ImageWidth", exifAttributeE4);
            return;
        }
        ExifAttribute exifAttribute6 = (ExifAttribute) mapArr[i2].get("ImageLength");
        ExifAttribute exifAttribute7 = (ExifAttribute) mapArr[i2].get("ImageWidth");
        if (exifAttribute6 == null || exifAttribute7 == null) {
            ExifAttribute exifAttribute8 = (ExifAttribute) mapArr[i2].get("JPEGInterchangeFormat");
            ExifAttribute exifAttribute9 = (ExifAttribute) mapArr[i2].get("JPEGInterchangeFormatLength");
            if (exifAttribute8 == null || exifAttribute9 == null) {
                return;
            }
            int iH5 = exifAttribute8.h(this.f4422g);
            int iH6 = exifAttribute8.h(this.f4422g);
            seekableByteOrderedDataInputStream.b(iH5);
            byte[] bArr = new byte[iH6];
            seekableByteOrderedDataInputStream.readFully(bArr);
            f(new ByteOrderedDataInputStream(bArr), iH5, i2);
        }
    }

    public final void H() throws Throwable {
        F(0, 5);
        F(0, 4);
        F(5, 4);
        HashMap[] mapArr = this.f4420e;
        ExifAttribute exifAttribute = (ExifAttribute) mapArr[1].get("PixelXDimension");
        ExifAttribute exifAttribute2 = (ExifAttribute) mapArr[1].get("PixelYDimension");
        if (exifAttribute != null && exifAttribute2 != null) {
            mapArr[0].put("ImageWidth", exifAttribute);
            mapArr[0].put("ImageLength", exifAttribute2);
        }
        if (mapArr[4].isEmpty() && q(mapArr[5])) {
            mapArr[4] = mapArr[5];
            mapArr[5] = new HashMap();
        }
        if (!q(mapArr[4])) {
            Log.d("ExifInterface", "No image meets the size requirements of a thumbnail image.");
        }
        y(0, "ThumbnailOrientation", "Orientation");
        y(0, "ThumbnailImageLength", "ImageLength");
        y(0, "ThumbnailImageWidth", "ImageWidth");
        y(5, "ThumbnailOrientation", "Orientation");
        y(5, "ThumbnailImageLength", "ImageLength");
        y(5, "ThumbnailImageWidth", "ImageWidth");
        y(4, "Orientation", "ThumbnailOrientation");
        y(4, "ImageLength", "ThumbnailImageLength");
        y(4, "ImageWidth", "ThumbnailImageWidth");
    }

    public final void I(ByteOrderedDataOutputStream byteOrderedDataOutputStream) throws IOException {
        HashMap[] mapArr;
        char c2;
        char c3;
        int i2;
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        ExifTag[][] exifTagArr = V;
        int[] iArr4 = new int[exifTagArr.length];
        int[] iArr5 = new int[exifTagArr.length];
        ExifTag[] exifTagArr2 = W;
        for (ExifTag exifTag : exifTagArr2) {
            x(exifTag.f4443b);
        }
        if (this.f4423h) {
            if (this.f4424i) {
                x("StripOffsets");
                x("StripByteCounts");
            } else {
                x("JPEGInterchangeFormat");
                x("JPEGInterchangeFormatLength");
            }
        }
        int i3 = 0;
        while (true) {
            int length = exifTagArr.length;
            mapArr = this.f4420e;
            if (i3 >= length) {
                break;
            }
            Object[] array = mapArr[i3].entrySet().toArray();
            int length2 = array.length;
            int i4 = 0;
            while (i4 < length2) {
                Map.Entry entry = (Map.Entry) array[i4];
                if (entry.getValue() == null) {
                    iArr3 = iArr4;
                    mapArr[i3].remove(entry.getKey());
                } else {
                    iArr3 = iArr4;
                }
                i4++;
                iArr4 = iArr3;
            }
            i3++;
        }
        int[] iArr6 = iArr4;
        if (!mapArr[1].isEmpty()) {
            mapArr[0].put(exifTagArr2[1].f4443b, ExifAttribute.b(0L, this.f4422g));
        }
        if (mapArr[2].isEmpty()) {
            c2 = 2;
        } else {
            c2 = 2;
            mapArr[0].put(exifTagArr2[2].f4443b, ExifAttribute.b(0L, this.f4422g));
        }
        if (mapArr[3].isEmpty()) {
            c3 = 3;
        } else {
            c3 = 3;
            mapArr[1].put(exifTagArr2[3].f4443b, ExifAttribute.b(0L, this.f4422g));
        }
        if (!this.f4423h) {
            i2 = 1;
            iArr = iArr5;
        } else if (this.f4424i) {
            mapArr[4].put("StripOffsets", ExifAttribute.e(0, this.f4422g));
            mapArr[4].put("StripByteCounts", ExifAttribute.e(this.f4427l, this.f4422g));
            i2 = 1;
            iArr = iArr5;
        } else {
            mapArr[4].put("JPEGInterchangeFormat", ExifAttribute.b(0L, this.f4422g));
            i2 = 1;
            iArr = iArr5;
            mapArr[4].put("JPEGInterchangeFormatLength", ExifAttribute.b(this.f4427l, this.f4422g));
        }
        int i5 = 0;
        while (true) {
            int length3 = exifTagArr.length;
            iArr2 = S;
            if (i5 >= length3) {
                break;
            }
            Iterator it = mapArr[i5].entrySet().iterator();
            int i6 = 0;
            while (it.hasNext()) {
                ExifAttribute exifAttribute = (ExifAttribute) ((Map.Entry) it.next()).getValue();
                exifAttribute.getClass();
                int i7 = iArr2[exifAttribute.f4438a] * exifAttribute.f4439b;
                if (i7 > 4) {
                    i6 += i7;
                }
            }
            iArr[i5] = iArr[i5] + i6;
            i5++;
        }
        int size = 8;
        for (int i8 = 0; i8 < exifTagArr.length; i8++) {
            if (!mapArr[i8].isEmpty()) {
                iArr6[i8] = size;
                size = (mapArr[i8].size() * 12) + 6 + iArr[i8] + size;
            }
        }
        if (this.f4423h) {
            if (this.f4424i) {
                mapArr[4].put("StripOffsets", ExifAttribute.e(size, this.f4422g));
            } else {
                mapArr[4].put("JPEGInterchangeFormat", ExifAttribute.b(size, this.f4422g));
            }
            this.f4426k = size;
            size += this.f4427l;
        }
        if (this.f4419d == 4) {
            size += 8;
        }
        if (t) {
            for (int i9 = 0; i9 < exifTagArr.length; i9++) {
                Log.d("ExifInterface", String.format("index: %d, offsets: %d, tag count: %d, data sizes: %d, total size: %d", Integer.valueOf(i9), Integer.valueOf(iArr6[i9]), Integer.valueOf(mapArr[i9].size()), Integer.valueOf(iArr[i9]), Integer.valueOf(size)));
            }
        }
        if (!mapArr[i2].isEmpty()) {
            mapArr[0].put(exifTagArr2[i2].f4443b, ExifAttribute.b(iArr6[i2], this.f4422g));
        }
        if (!mapArr[c2].isEmpty()) {
            mapArr[0].put(exifTagArr2[c2].f4443b, ExifAttribute.b(iArr6[c2], this.f4422g));
        }
        if (!mapArr[c3].isEmpty()) {
            mapArr[i2].put(exifTagArr2[c3].f4443b, ExifAttribute.b(iArr6[c3], this.f4422g));
        }
        int i10 = this.f4419d;
        if (i10 == 4) {
            if (size > 65535) {
                throw new IllegalStateException(b.g(size, "Size of exif data (", " bytes) exceeds the max size of a JPEG APP1 segment (65536 bytes)"));
            }
            byteOrderedDataOutputStream.l(size);
            byteOrderedDataOutputStream.write(c0);
        } else if (i10 == 13) {
            byteOrderedDataOutputStream.b(size);
            byteOrderedDataOutputStream.write(F);
        } else if (i10 == 14) {
            byteOrderedDataOutputStream.write(K);
            byteOrderedDataOutputStream.b(size);
        }
        byteOrderedDataOutputStream.c(this.f4422g == ByteOrder.BIG_ENDIAN ? (short) 19789 : (short) 18761);
        byteOrderedDataOutputStream.f4437b = this.f4422g;
        byteOrderedDataOutputStream.l(42);
        byteOrderedDataOutputStream.e(8L);
        for (int i11 = 0; i11 < exifTagArr.length; i11++) {
            if (!mapArr[i11].isEmpty()) {
                byteOrderedDataOutputStream.l(mapArr[i11].size());
                int size2 = (mapArr[i11].size() * 12) + iArr6[i11] + 2 + 4;
                for (Map.Entry entry2 : mapArr[i11].entrySet()) {
                    int i12 = ((ExifTag) Y[i11].get(entry2.getKey())).f4442a;
                    ExifAttribute exifAttribute2 = (ExifAttribute) entry2.getValue();
                    exifAttribute2.getClass();
                    int i13 = exifAttribute2.f4438a;
                    int i14 = iArr2[i13];
                    int i15 = exifAttribute2.f4439b;
                    int i16 = i14 * i15;
                    byteOrderedDataOutputStream.l(i12);
                    byteOrderedDataOutputStream.l(i13);
                    byteOrderedDataOutputStream.b(i15);
                    if (i16 > 4) {
                        byteOrderedDataOutputStream.e(size2);
                        size2 += i16;
                    } else {
                        byteOrderedDataOutputStream.write(exifAttribute2.f4441d);
                        if (i16 < 4) {
                            while (i16 < 4) {
                                byteOrderedDataOutputStream.a(0);
                                i16++;
                            }
                        }
                    }
                }
                if (i11 != 0 || mapArr[4].isEmpty()) {
                    byteOrderedDataOutputStream.e(0L);
                } else {
                    byteOrderedDataOutputStream.e(iArr6[4]);
                }
                Iterator it2 = mapArr[i11].entrySet().iterator();
                while (it2.hasNext()) {
                    byte[] bArr = ((ExifAttribute) ((Map.Entry) it2.next()).getValue()).f4441d;
                    if (bArr.length > 4) {
                        byteOrderedDataOutputStream.write(bArr, 0, bArr.length);
                    }
                }
            }
        }
        if (this.f4423h) {
            byteOrderedDataOutputStream.write(m());
        }
        if (this.f4419d == 14 && size % 2 == i2) {
            byteOrderedDataOutputStream.a(0);
        }
        byteOrderedDataOutputStream.f4437b = ByteOrder.BIG_ENDIAN;
    }

    public final void a() {
        String strB = b("DateTimeOriginal");
        HashMap[] mapArr = this.f4420e;
        if (strB != null && b("DateTime") == null) {
            mapArr[0].put("DateTime", ExifAttribute.a(strB));
        }
        if (b("ImageWidth") == null) {
            mapArr[0].put("ImageWidth", ExifAttribute.b(0L, this.f4422g));
        }
        if (b("ImageLength") == null) {
            mapArr[0].put("ImageLength", ExifAttribute.b(0L, this.f4422g));
        }
        if (b("Orientation") == null) {
            mapArr[0].put("Orientation", ExifAttribute.b(0L, this.f4422g));
        }
        if (b("LightSource") == null) {
            mapArr[1].put("LightSource", ExifAttribute.b(0L, this.f4422g));
        }
    }

    public final String b(String str) {
        ExifAttribute exifAttributeD = d(str);
        if (exifAttributeD != null) {
            if (!Z.contains(str)) {
                return exifAttributeD.i(this.f4422g);
            }
            if (str.equals("GPSTimeStamp")) {
                int i2 = exifAttributeD.f4438a;
                if (i2 != 5 && i2 != 10) {
                    Log.w("ExifInterface", "GPS Timestamp format is not rational. format=" + i2);
                    return null;
                }
                Rational[] rationalArr = (Rational[]) exifAttributeD.j(this.f4422g);
                if (rationalArr == null || rationalArr.length != 3) {
                    Log.w("ExifInterface", "Invalid GPS Timestamp array. array=" + Arrays.toString(rationalArr));
                    return null;
                }
                Rational rational = rationalArr[0];
                Integer numValueOf = Integer.valueOf((int) (rational.f4446a / rational.f4447b));
                Rational rational2 = rationalArr[1];
                Integer numValueOf2 = Integer.valueOf((int) (rational2.f4446a / rational2.f4447b));
                Rational rational3 = rationalArr[2];
                return String.format("%02d:%02d:%02d", numValueOf, numValueOf2, Integer.valueOf((int) (rational3.f4446a / rational3.f4447b)));
            }
            try {
                return Double.toString(exifAttributeD.g(this.f4422g));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public final int c() {
        ExifAttribute exifAttributeD = d("Orientation");
        if (exifAttributeD == null) {
            return 1;
        }
        try {
            return exifAttributeD.h(this.f4422g);
        } catch (NumberFormatException unused) {
            return 1;
        }
    }

    public final ExifAttribute d(String str) {
        if ("ISOSpeedRatings".equals(str)) {
            if (t) {
                Log.d("ExifInterface", "getExifAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
            }
            str = "PhotographicSensitivity";
        }
        for (int i2 = 0; i2 < V.length; i2++) {
            ExifAttribute exifAttribute = (ExifAttribute) this.f4420e[i2].get(str);
            if (exifAttribute != null) {
                return exifAttribute;
            }
        }
        return null;
    }

    public final void e(final SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream) throws IOException {
        String strExtractMetadata;
        String strExtractMetadata2;
        String strExtractMetadata3;
        if (Build.VERSION.SDK_INT < 28) {
            throw new UnsupportedOperationException("Reading EXIF from HEIF files is supported from SDK 28 and above");
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                ExifInterfaceUtils.Api23Impl.a(mediaMetadataRetriever, new MediaDataSource() { // from class: androidx.exifinterface.media.ExifInterface.1

                    /* renamed from: a, reason: collision with root package name */
                    public long f4429a;

                    @Override // java.io.Closeable, java.lang.AutoCloseable
                    public final void close() {
                    }

                    @Override // android.media.MediaDataSource
                    public final long getSize() {
                        return -1L;
                    }

                    @Override // android.media.MediaDataSource
                    public final int readAt(long j2, byte[] bArr, int i2, int i3) throws IOException {
                        if (i3 == 0) {
                            return 0;
                        }
                        if (j2 < 0) {
                            return -1;
                        }
                        try {
                            long j3 = this.f4429a;
                            SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream2 = seekableByteOrderedDataInputStream;
                            if (j3 != j2) {
                                if (j3 >= 0 && j2 >= j3 + seekableByteOrderedDataInputStream2.f4431a.available()) {
                                    return -1;
                                }
                                seekableByteOrderedDataInputStream2.b(j2);
                                this.f4429a = j2;
                            }
                            if (i3 > seekableByteOrderedDataInputStream2.f4431a.available()) {
                                i3 = seekableByteOrderedDataInputStream2.f4431a.available();
                            }
                            int i4 = seekableByteOrderedDataInputStream2.read(bArr, i2, i3);
                            if (i4 >= 0) {
                                this.f4429a += i4;
                                return i4;
                            }
                        } catch (IOException unused) {
                        }
                        this.f4429a = -1L;
                        return -1;
                    }
                });
                String strExtractMetadata4 = mediaMetadataRetriever.extractMetadata(33);
                String strExtractMetadata5 = mediaMetadataRetriever.extractMetadata(34);
                String strExtractMetadata6 = mediaMetadataRetriever.extractMetadata(26);
                String strExtractMetadata7 = mediaMetadataRetriever.extractMetadata(17);
                if ("yes".equals(strExtractMetadata6)) {
                    strExtractMetadata = mediaMetadataRetriever.extractMetadata(29);
                    strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(30);
                    strExtractMetadata3 = mediaMetadataRetriever.extractMetadata(31);
                } else if ("yes".equals(strExtractMetadata7)) {
                    strExtractMetadata = mediaMetadataRetriever.extractMetadata(18);
                    strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                    strExtractMetadata3 = mediaMetadataRetriever.extractMetadata(24);
                } else {
                    strExtractMetadata = null;
                    strExtractMetadata2 = null;
                    strExtractMetadata3 = null;
                }
                HashMap[] mapArr = this.f4420e;
                if (strExtractMetadata != null) {
                    mapArr[0].put("ImageWidth", ExifAttribute.e(Integer.parseInt(strExtractMetadata), this.f4422g));
                }
                if (strExtractMetadata2 != null) {
                    mapArr[0].put("ImageLength", ExifAttribute.e(Integer.parseInt(strExtractMetadata2), this.f4422g));
                }
                if (strExtractMetadata3 != null) {
                    int i2 = Integer.parseInt(strExtractMetadata3);
                    mapArr[0].put("Orientation", ExifAttribute.e(i2 != 90 ? i2 != 180 ? i2 != 270 ? 1 : 8 : 3 : 6, this.f4422g));
                }
                if (strExtractMetadata4 != null && strExtractMetadata5 != null) {
                    int i3 = Integer.parseInt(strExtractMetadata4);
                    int i4 = Integer.parseInt(strExtractMetadata5);
                    if (i4 <= 6) {
                        throw new IOException("Invalid exif length");
                    }
                    seekableByteOrderedDataInputStream.b(i3);
                    byte[] bArr = new byte[6];
                    seekableByteOrderedDataInputStream.readFully(bArr);
                    int i5 = i3 + 6;
                    int i6 = i4 - 6;
                    if (!Arrays.equals(bArr, c0)) {
                        throw new IOException("Invalid identifier");
                    }
                    byte[] bArr2 = new byte[i6];
                    seekableByteOrderedDataInputStream.readFully(bArr2);
                    this.o = i5;
                    v(0, bArr2);
                }
                if (t) {
                    Log.d("ExifInterface", "Heif meta: " + strExtractMetadata + "x" + strExtractMetadata2 + ", rotation " + strExtractMetadata3);
                }
                mediaMetadataRetriever.release();
            } catch (RuntimeException unused) {
                throw new UnsupportedOperationException("Failed to read EXIF from HEIF file. Given stream is either malformed or unsupported.");
            }
        } catch (Throwable th) {
            mediaMetadataRetriever.release();
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:83:0x0190, code lost:
    
        r24.f4433c = r23.f4422g;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0194, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream r24, int r25, int r26) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 522
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.f(androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream, int, int):void");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:169|12|(4:164|13|150|14)|(16:17|(2:19|20)(1:28)|23|29|(1:31)|32|(4:152|35|(7:154|39|40|(3:43|(1:45)(2:46|(1:48))|(1:179)(3:177|51|52))(1:180)|53|36|37)|176)|34|160|65|162|66|67|(1:73)(1:72)|74|(1:87)(8:156|89|158|90|91|(1:93)(1:94)|95|(1:107)(3:109|(2:110|(2:112|(2:170|114)(1:115))(2:171|116))|(1:118)(4:120|(2:121|(2:123|(1:173)(1:126))(3:172|127|(2:128|(2:130|(1:175)(1:133))(2:174|134))))|125|(1:136)(1:138)))))|16|160|65|162|66|67|(3:69|73|74)(0)|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0061, code lost:
    
        if (r9 < 16) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00ef, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00f0, code lost:
    
        r6 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00f2, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00f4, code lost:
    
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x00f6, code lost:
    
        if (r6 != null) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x00f8, code lost:
    
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x00fb, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x00fc, code lost:
    
        if (r2 != null) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x00fe, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0101, code lost:
    
        r0 = r18;
     */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0139 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0107 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0105 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int g(java.io.BufferedInputStream r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 409
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.g(java.io.BufferedInputStream):int");
    }

    public final void h(SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream) throws Throwable {
        int i2;
        int i3;
        k(seekableByteOrderedDataInputStream);
        HashMap[] mapArr = this.f4420e;
        ExifAttribute exifAttribute = (ExifAttribute) mapArr[1].get("MakerNote");
        if (exifAttribute != null) {
            SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream2 = new SeekableByteOrderedDataInputStream(exifAttribute.f4441d);
            seekableByteOrderedDataInputStream2.f4433c = this.f4422g;
            byte[] bArr = C;
            byte[] bArr2 = new byte[bArr.length];
            seekableByteOrderedDataInputStream2.readFully(bArr2);
            seekableByteOrderedDataInputStream2.b(0L);
            byte[] bArr3 = D;
            byte[] bArr4 = new byte[bArr3.length];
            seekableByteOrderedDataInputStream2.readFully(bArr4);
            if (Arrays.equals(bArr2, bArr)) {
                seekableByteOrderedDataInputStream2.b(8L);
            } else if (Arrays.equals(bArr4, bArr3)) {
                seekableByteOrderedDataInputStream2.b(12L);
            }
            w(seekableByteOrderedDataInputStream2, 6);
            ExifAttribute exifAttribute2 = (ExifAttribute) mapArr[7].get("PreviewImageStart");
            ExifAttribute exifAttribute3 = (ExifAttribute) mapArr[7].get("PreviewImageLength");
            if (exifAttribute2 != null && exifAttribute3 != null) {
                mapArr[5].put("JPEGInterchangeFormat", exifAttribute2);
                mapArr[5].put("JPEGInterchangeFormatLength", exifAttribute3);
            }
            ExifAttribute exifAttribute4 = (ExifAttribute) mapArr[8].get("AspectFrame");
            if (exifAttribute4 != null) {
                int[] iArr = (int[]) exifAttribute4.j(this.f4422g);
                if (iArr == null || iArr.length != 4) {
                    Log.w("ExifInterface", "Invalid aspect frame values. frame=" + Arrays.toString(iArr));
                    return;
                }
                int i4 = iArr[2];
                int i5 = iArr[0];
                if (i4 <= i5 || (i2 = iArr[3]) <= (i3 = iArr[1])) {
                    return;
                }
                int i6 = (i4 - i5) + 1;
                int i7 = (i2 - i3) + 1;
                if (i6 < i7) {
                    int i8 = i6 + i7;
                    i7 = i8 - i7;
                    i6 = i8 - i7;
                }
                ExifAttribute exifAttributeE = ExifAttribute.e(i6, this.f4422g);
                ExifAttribute exifAttributeE2 = ExifAttribute.e(i7, this.f4422g);
                mapArr[0].put("ImageWidth", exifAttributeE);
                mapArr[0].put("ImageLength", exifAttributeE2);
            }
        }
    }

    public final void i(ByteOrderedDataInputStream byteOrderedDataInputStream) throws Throwable {
        if (t) {
            Log.d("ExifInterface", "getPngAttributes starting with: " + byteOrderedDataInputStream);
        }
        byteOrderedDataInputStream.f4433c = ByteOrder.BIG_ENDIAN;
        byte[] bArr = E;
        byteOrderedDataInputStream.a(bArr.length);
        int length = bArr.length;
        while (true) {
            try {
                int i2 = byteOrderedDataInputStream.readInt();
                byte[] bArr2 = new byte[4];
                byteOrderedDataInputStream.readFully(bArr2);
                int i3 = length + 8;
                if (i3 == 16 && !Arrays.equals(bArr2, G)) {
                    throw new IOException("Encountered invalid PNG file--IHDR chunk should appearas the first chunk");
                }
                if (Arrays.equals(bArr2, H)) {
                    return;
                }
                if (Arrays.equals(bArr2, F)) {
                    byte[] bArr3 = new byte[i2];
                    byteOrderedDataInputStream.readFully(bArr3);
                    int i4 = byteOrderedDataInputStream.readInt();
                    CRC32 crc32 = new CRC32();
                    crc32.update(bArr2);
                    crc32.update(bArr3);
                    if (((int) crc32.getValue()) == i4) {
                        this.o = i3;
                        v(0, bArr3);
                        H();
                        E(new ByteOrderedDataInputStream(bArr3));
                        return;
                    }
                    throw new IOException("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: " + i4 + ", calculated CRC value: " + crc32.getValue());
                }
                int i5 = i2 + 4;
                byteOrderedDataInputStream.a(i5);
                length = i3 + i5;
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt PNG file.");
            }
        }
    }

    public final void j(ByteOrderedDataInputStream byteOrderedDataInputStream) throws Throwable {
        boolean z2 = t;
        if (z2) {
            Log.d("ExifInterface", "getRafAttributes starting with: " + byteOrderedDataInputStream);
        }
        byteOrderedDataInputStream.a(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        byte[] bArr3 = new byte[4];
        byteOrderedDataInputStream.readFully(bArr);
        byteOrderedDataInputStream.readFully(bArr2);
        byteOrderedDataInputStream.readFully(bArr3);
        int i2 = ByteBuffer.wrap(bArr).getInt();
        int i3 = ByteBuffer.wrap(bArr2).getInt();
        int i4 = ByteBuffer.wrap(bArr3).getInt();
        byte[] bArr4 = new byte[i3];
        byteOrderedDataInputStream.a(i2 - byteOrderedDataInputStream.f4432b);
        byteOrderedDataInputStream.readFully(bArr4);
        f(new ByteOrderedDataInputStream(bArr4), i2, 5);
        byteOrderedDataInputStream.a(i4 - byteOrderedDataInputStream.f4432b);
        byteOrderedDataInputStream.f4433c = ByteOrder.BIG_ENDIAN;
        int i5 = byteOrderedDataInputStream.readInt();
        if (z2) {
            Log.d("ExifInterface", "numberOfDirectoryEntry: " + i5);
        }
        for (int i6 = 0; i6 < i5; i6++) {
            int unsignedShort = byteOrderedDataInputStream.readUnsignedShort();
            int unsignedShort2 = byteOrderedDataInputStream.readUnsignedShort();
            if (unsignedShort == U.f4442a) {
                short s = byteOrderedDataInputStream.readShort();
                short s2 = byteOrderedDataInputStream.readShort();
                ExifAttribute exifAttributeE = ExifAttribute.e(s, this.f4422g);
                ExifAttribute exifAttributeE2 = ExifAttribute.e(s2, this.f4422g);
                HashMap[] mapArr = this.f4420e;
                mapArr[0].put("ImageLength", exifAttributeE);
                mapArr[0].put("ImageWidth", exifAttributeE2);
                if (z2) {
                    Log.d("ExifInterface", "Updated to length: " + ((int) s) + ", width: " + ((int) s2));
                    return;
                }
                return;
            }
            byteOrderedDataInputStream.a(unsignedShort2);
        }
    }

    public final void k(SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream) throws Throwable {
        s(seekableByteOrderedDataInputStream);
        w(seekableByteOrderedDataInputStream, 0);
        G(seekableByteOrderedDataInputStream, 0);
        G(seekableByteOrderedDataInputStream, 5);
        G(seekableByteOrderedDataInputStream, 4);
        H();
        if (this.f4419d == 8) {
            HashMap[] mapArr = this.f4420e;
            ExifAttribute exifAttribute = (ExifAttribute) mapArr[1].get("MakerNote");
            if (exifAttribute != null) {
                SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream2 = new SeekableByteOrderedDataInputStream(exifAttribute.f4441d);
                seekableByteOrderedDataInputStream2.f4433c = this.f4422g;
                seekableByteOrderedDataInputStream2.a(6);
                w(seekableByteOrderedDataInputStream2, 9);
                ExifAttribute exifAttribute2 = (ExifAttribute) mapArr[9].get("ColorSpace");
                if (exifAttribute2 != null) {
                    mapArr[1].put("ColorSpace", exifAttribute2);
                }
            }
        }
    }

    public final void l(SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream) throws Throwable {
        if (t) {
            Log.d("ExifInterface", "getRw2Attributes starting with: " + seekableByteOrderedDataInputStream);
        }
        k(seekableByteOrderedDataInputStream);
        HashMap[] mapArr = this.f4420e;
        ExifAttribute exifAttribute = (ExifAttribute) mapArr[0].get("JpgFromRaw");
        if (exifAttribute != null) {
            f(new ByteOrderedDataInputStream(exifAttribute.f4441d), (int) exifAttribute.f4440c, 5);
        }
        ExifAttribute exifAttribute2 = (ExifAttribute) mapArr[0].get("ISO");
        ExifAttribute exifAttribute3 = (ExifAttribute) mapArr[1].get("PhotographicSensitivity");
        if (exifAttribute2 == null || exifAttribute3 != null) {
            return;
        }
        mapArr[1].put("PhotographicSensitivity", exifAttribute2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0078 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v1, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v6, types: [android.content.res.AssetManager$AssetInputStream, java.io.Closeable, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.io.Closeable, java.io.InputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final byte[] m() throws java.lang.Throwable {
        /*
            r10 = this;
            java.lang.String r0 = "Error closing fd."
            java.lang.String r1 = "ExifInterfaceUtils"
            java.lang.String r2 = "ExifInterface"
            boolean r3 = r10.f4423h
            r4 = 0
            if (r3 != 0) goto Ld
            goto L9c
        Ld:
            byte[] r3 = r10.f4428m
            if (r3 == 0) goto L12
            return r3
        L12:
            android.content.res.AssetManager$AssetInputStream r3 = r10.f4418c     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L43
            if (r3 == 0) goto L34
            boolean r5 = r3.markSupported()     // Catch: java.lang.Throwable -> L21 java.lang.Exception -> L26
            if (r5 == 0) goto L2b
            r3.reset()     // Catch: java.lang.Throwable -> L21 java.lang.Exception -> L26
        L1f:
            r5 = r4
            goto L5d
        L21:
            r2 = move-exception
            r5 = r4
        L23:
            r4 = r3
            goto L9d
        L26:
            r5 = move-exception
            r6 = r5
            r5 = r4
            goto L8b
        L2b:
            java.lang.String r5 = "Cannot read thumbnail from inputstream without mark/reset support"
            android.util.Log.d(r2, r5)     // Catch: java.lang.Throwable -> L21 java.lang.Exception -> L26
            androidx.exifinterface.media.ExifInterfaceUtils.a(r3)
            return r4
        L34:
            java.lang.String r3 = r10.f4416a     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L43
            if (r3 == 0) goto L48
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L43
            java.lang.String r5 = r10.f4416a     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L43
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L43
            goto L1f
        L40:
            r2 = move-exception
            r5 = r4
            goto L9d
        L43:
            r5 = move-exception
            r3 = r4
            r6 = r5
            r5 = r3
            goto L8b
        L48:
            java.io.FileDescriptor r3 = r10.f4417b     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L43
            java.io.FileDescriptor r3 = androidx.exifinterface.media.ExifInterfaceUtils.Api21Impl.b(r3)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L43
            int r5 = android.system.OsConstants.SEEK_SET     // Catch: java.lang.Throwable -> L84 java.lang.Exception -> L87
            r6 = 0
            androidx.exifinterface.media.ExifInterfaceUtils.Api21Impl.c(r3, r6, r5)     // Catch: java.lang.Throwable -> L84 java.lang.Exception -> L87
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L84 java.lang.Exception -> L87
            r5.<init>(r3)     // Catch: java.lang.Throwable -> L84 java.lang.Exception -> L87
            r9 = r5
            r5 = r3
            r3 = r9
        L5d:
            androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream r6 = new androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L82
            r6.<init>(r3)     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L82
            int r7 = r10.f4426k     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L82
            int r8 = r10.o     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L82
            int r7 = r7 + r8
            r6.a(r7)     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L82
            int r7 = r10.f4427l     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L82
            byte[] r7 = new byte[r7]     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L82
            r6.readFully(r7)     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L82
            r10.f4428m = r7     // Catch: java.lang.Throwable -> L80 java.lang.Exception -> L82
            androidx.exifinterface.media.ExifInterfaceUtils.a(r3)
            if (r5 == 0) goto L7f
            androidx.exifinterface.media.ExifInterfaceUtils.Api21Impl.a(r5)     // Catch: java.lang.Exception -> L7c
            return r7
        L7c:
            android.util.Log.e(r1, r0)
        L7f:
            return r7
        L80:
            r2 = move-exception
            goto L23
        L82:
            r6 = move-exception
            goto L8b
        L84:
            r2 = move-exception
            r5 = r3
            goto L9d
        L87:
            r5 = move-exception
            r6 = r5
            r5 = r3
            r3 = r4
        L8b:
            java.lang.String r7 = "Encountered exception while getting thumbnail"
            android.util.Log.d(r2, r7, r6)     // Catch: java.lang.Throwable -> L80
            androidx.exifinterface.media.ExifInterfaceUtils.a(r3)
            if (r5 == 0) goto L9c
            androidx.exifinterface.media.ExifInterfaceUtils.Api21Impl.a(r5)     // Catch: java.lang.Exception -> L99
            goto L9c
        L99:
            android.util.Log.e(r1, r0)
        L9c:
            return r4
        L9d:
            androidx.exifinterface.media.ExifInterfaceUtils.a(r4)
            if (r5 == 0) goto La9
            androidx.exifinterface.media.ExifInterfaceUtils.Api21Impl.a(r5)     // Catch: java.lang.Exception -> La6
            goto La9
        La6:
            android.util.Log.e(r1, r0)
        La9:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.m():byte[]");
    }

    public final void n(ByteOrderedDataInputStream byteOrderedDataInputStream) throws Throwable {
        if (t) {
            Log.d("ExifInterface", "getWebpAttributes starting with: " + byteOrderedDataInputStream);
        }
        byteOrderedDataInputStream.f4433c = ByteOrder.LITTLE_ENDIAN;
        byteOrderedDataInputStream.a(I.length);
        int i2 = byteOrderedDataInputStream.readInt() + 8;
        byte[] bArr = J;
        byteOrderedDataInputStream.a(bArr.length);
        int length = bArr.length + 8;
        while (true) {
            try {
                byte[] bArr2 = new byte[4];
                byteOrderedDataInputStream.readFully(bArr2);
                int i3 = byteOrderedDataInputStream.readInt();
                int i4 = length + 8;
                if (Arrays.equals(K, bArr2)) {
                    byte[] bArr3 = new byte[i3];
                    byteOrderedDataInputStream.readFully(bArr3);
                    this.o = i4;
                    v(0, bArr3);
                    E(new ByteOrderedDataInputStream(bArr3));
                    return;
                }
                if (i3 % 2 == 1) {
                    i3++;
                }
                length = i4 + i3;
                if (length == i2) {
                    return;
                }
                if (length > i2) {
                    throw new IOException("Encountered WebP file with invalid chunk size");
                }
                byteOrderedDataInputStream.a(i3);
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt WebP file.");
            }
        }
    }

    public final void p(ByteOrderedDataInputStream byteOrderedDataInputStream, HashMap map) throws Throwable {
        ExifAttribute exifAttribute = (ExifAttribute) map.get("JPEGInterchangeFormat");
        ExifAttribute exifAttribute2 = (ExifAttribute) map.get("JPEGInterchangeFormatLength");
        if (exifAttribute == null || exifAttribute2 == null) {
            return;
        }
        int iH = exifAttribute.h(this.f4422g);
        int iH2 = exifAttribute2.h(this.f4422g);
        if (this.f4419d == 7) {
            iH += this.p;
        }
        if (iH > 0 && iH2 > 0) {
            this.f4423h = true;
            if (this.f4416a == null && this.f4418c == null && this.f4417b == null) {
                byte[] bArr = new byte[iH2];
                byteOrderedDataInputStream.a(iH);
                byteOrderedDataInputStream.readFully(bArr);
                this.f4428m = bArr;
            }
            this.f4426k = iH;
            this.f4427l = iH2;
        }
        if (t) {
            Log.d("ExifInterface", "Setting thumbnail attributes with offset: " + iH + ", length: " + iH2);
        }
    }

    public final boolean q(HashMap map) {
        ExifAttribute exifAttribute = (ExifAttribute) map.get("ImageLength");
        ExifAttribute exifAttribute2 = (ExifAttribute) map.get("ImageWidth");
        if (exifAttribute == null || exifAttribute2 == null) {
            return false;
        }
        return exifAttribute.h(this.f4422g) <= 512 && exifAttribute2.h(this.f4422g) <= 512;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0091 A[Catch: all -> 0x0017, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0017, blocks: (B:5:0x0006, B:7:0x000b, B:14:0x0020, B:20:0x003d, B:22:0x0048, B:30:0x005e, B:25:0x004f, B:28:0x0057, B:29:0x005b, B:31:0x0068, B:33:0x0071, B:35:0x0077, B:37:0x007d, B:39:0x0083, B:45:0x0091), top: B:57:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void r(java.io.InputStream r8) {
        /*
            r7 = this;
            boolean r0 = androidx.exifinterface.media.ExifInterface.t
            if (r8 == 0) goto Lab
            r1 = 0
            r2 = r1
        L6:
            androidx.exifinterface.media.ExifInterface$ExifTag[][] r3 = androidx.exifinterface.media.ExifInterface.V     // Catch: java.lang.Throwable -> L17 java.lang.UnsupportedOperationException -> L1a java.io.IOException -> L1d
            int r3 = r3.length     // Catch: java.lang.Throwable -> L17 java.lang.UnsupportedOperationException -> L1a java.io.IOException -> L1d
            if (r2 >= r3) goto L20
            java.util.HashMap[] r3 = r7.f4420e     // Catch: java.lang.Throwable -> L17 java.lang.UnsupportedOperationException -> L1a java.io.IOException -> L1d
            java.util.HashMap r4 = new java.util.HashMap     // Catch: java.lang.Throwable -> L17 java.lang.UnsupportedOperationException -> L1a java.io.IOException -> L1d
            r4.<init>()     // Catch: java.lang.Throwable -> L17 java.lang.UnsupportedOperationException -> L1a java.io.IOException -> L1d
            r3[r2] = r4     // Catch: java.lang.Throwable -> L17 java.lang.UnsupportedOperationException -> L1a java.io.IOException -> L1d
            int r2 = r2 + 1
            goto L6
        L17:
            r8 = move-exception
            goto L99
        L1a:
            r8 = move-exception
            goto L8f
        L1d:
            r8 = move-exception
            goto L8f
        L20:
            java.io.BufferedInputStream r2 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L17 java.lang.UnsupportedOperationException -> L1a java.io.IOException -> L1d
            r3 = 5000(0x1388, float:7.006E-42)
            r2.<init>(r8, r3)     // Catch: java.lang.Throwable -> L17 java.lang.UnsupportedOperationException -> L1a java.io.IOException -> L1d
            int r8 = r7.g(r2)     // Catch: java.lang.Throwable -> L17 java.lang.UnsupportedOperationException -> L1a java.io.IOException -> L1d
            r7.f4419d = r8     // Catch: java.lang.Throwable -> L17 java.lang.UnsupportedOperationException -> L1a java.io.IOException -> L1d
            r3 = 14
            r4 = 13
            r5 = 9
            r6 = 4
            if (r8 == r6) goto L68
            if (r8 == r5) goto L68
            if (r8 == r4) goto L68
            if (r8 != r3) goto L3d
            goto L68
        L3d:
            androidx.exifinterface.media.ExifInterface$SeekableByteOrderedDataInputStream r8 = new androidx.exifinterface.media.ExifInterface$SeekableByteOrderedDataInputStream     // Catch: java.lang.Throwable -> L17 java.lang.UnsupportedOperationException -> L1a java.io.IOException -> L1d
            r8.<init>(r2)     // Catch: java.lang.Throwable -> L17 java.lang.UnsupportedOperationException -> L1a java.io.IOException -> L1d
            int r1 = r7.f4419d     // Catch: java.lang.Throwable -> L17 java.lang.UnsupportedOperationException -> L1a java.io.IOException -> L1d
            r2 = 12
            if (r1 != r2) goto L4c
            r7.e(r8)     // Catch: java.lang.Throwable -> L17 java.lang.UnsupportedOperationException -> L1a java.io.IOException -> L1d
            goto L5e
        L4c:
            r2 = 7
            if (r1 != r2) goto L53
            r7.h(r8)     // Catch: java.lang.Throwable -> L17 java.lang.UnsupportedOperationException -> L1a java.io.IOException -> L1d
            goto L5e
        L53:
            r2 = 10
            if (r1 != r2) goto L5b
            r7.l(r8)     // Catch: java.lang.Throwable -> L17 java.lang.UnsupportedOperationException -> L1a java.io.IOException -> L1d
            goto L5e
        L5b:
            r7.k(r8)     // Catch: java.lang.Throwable -> L17 java.lang.UnsupportedOperationException -> L1a java.io.IOException -> L1d
        L5e:
            int r1 = r7.o     // Catch: java.lang.Throwable -> L17 java.lang.UnsupportedOperationException -> L1a java.io.IOException -> L1d
            long r1 = (long) r1     // Catch: java.lang.Throwable -> L17 java.lang.UnsupportedOperationException -> L1a java.io.IOException -> L1d
            r8.b(r1)     // Catch: java.lang.Throwable -> L17 java.lang.UnsupportedOperationException -> L1a java.io.IOException -> L1d
            r7.E(r8)     // Catch: java.lang.Throwable -> L17 java.lang.UnsupportedOperationException -> L1a java.io.IOException -> L1d
            goto L86
        L68:
            androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream r8 = new androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream     // Catch: java.lang.Throwable -> L17 java.lang.UnsupportedOperationException -> L1a java.io.IOException -> L1d
            r8.<init>(r2)     // Catch: java.lang.Throwable -> L17 java.lang.UnsupportedOperationException -> L1a java.io.IOException -> L1d
            int r2 = r7.f4419d     // Catch: java.lang.Throwable -> L17 java.lang.UnsupportedOperationException -> L1a java.io.IOException -> L1d
            if (r2 != r6) goto L75
            r7.f(r8, r1, r1)     // Catch: java.lang.Throwable -> L17 java.lang.UnsupportedOperationException -> L1a java.io.IOException -> L1d
            goto L86
        L75:
            if (r2 != r4) goto L7b
            r7.i(r8)     // Catch: java.lang.Throwable -> L17 java.lang.UnsupportedOperationException -> L1a java.io.IOException -> L1d
            goto L86
        L7b:
            if (r2 != r5) goto L81
            r7.j(r8)     // Catch: java.lang.Throwable -> L17 java.lang.UnsupportedOperationException -> L1a java.io.IOException -> L1d
            goto L86
        L81:
            if (r2 != r3) goto L86
            r7.n(r8)     // Catch: java.lang.Throwable -> L17 java.lang.UnsupportedOperationException -> L1a java.io.IOException -> L1d
        L86:
            r7.a()
            if (r0 == 0) goto Laa
            r7.t()
            return
        L8f:
            if (r0 == 0) goto La2
            java.lang.String r1 = "ExifInterface"
            java.lang.String r2 = "Invalid image: ExifInterface got an unsupported image format file(ExifInterface supports JPEG and some RAW image formats only) or a corrupted JPEG file to ExifInterface."
            android.util.Log.w(r1, r2, r8)     // Catch: java.lang.Throwable -> L17
            goto La2
        L99:
            r7.a()
            if (r0 == 0) goto La1
            r7.t()
        La1:
            throw r8
        La2:
            r7.a()
            if (r0 == 0) goto Laa
            r7.t()
        Laa:
            return
        Lab:
            java.lang.NullPointerException r8 = new java.lang.NullPointerException
            java.lang.String r0 = "inputstream shouldn't be null"
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.r(java.io.InputStream):void");
    }

    public final void s(SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream) throws IOException {
        ByteOrder byteOrderU = u(seekableByteOrderedDataInputStream);
        this.f4422g = byteOrderU;
        seekableByteOrderedDataInputStream.f4433c = byteOrderU;
        int unsignedShort = seekableByteOrderedDataInputStream.readUnsignedShort();
        int i2 = this.f4419d;
        if (i2 != 7 && i2 != 10 && unsignedShort != 42) {
            throw new IOException("Invalid start code: " + Integer.toHexString(unsignedShort));
        }
        int i3 = seekableByteOrderedDataInputStream.readInt();
        if (i3 < 8) {
            throw new IOException(b.f(i3, "Invalid first Ifd offset: "));
        }
        int i4 = i3 - 8;
        if (i4 > 0) {
            seekableByteOrderedDataInputStream.a(i4);
        }
    }

    public final void t() {
        int i2 = 0;
        while (true) {
            HashMap[] mapArr = this.f4420e;
            if (i2 >= mapArr.length) {
                return;
            }
            StringBuilder sbU = b.u(i2, "The size of tag group[", "]: ");
            sbU.append(mapArr[i2].size());
            Log.d("ExifInterface", sbU.toString());
            for (Map.Entry entry : mapArr[i2].entrySet()) {
                ExifAttribute exifAttribute = (ExifAttribute) entry.getValue();
                Log.d("ExifInterface", "tagName: " + ((String) entry.getKey()) + ", tagType: " + exifAttribute.toString() + ", tagValue: '" + exifAttribute.i(this.f4422g) + "'");
            }
            i2++;
        }
    }

    public final void v(int i2, byte[] bArr) throws IOException {
        SeekableByteOrderedDataInputStream seekableByteOrderedDataInputStream = new SeekableByteOrderedDataInputStream(bArr);
        s(seekableByteOrderedDataInputStream);
        w(seekableByteOrderedDataInputStream, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x014d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void w(androidx.exifinterface.media.ExifInterface.SeekableByteOrderedDataInputStream r27, int r28) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 927
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.w(androidx.exifinterface.media.ExifInterface$SeekableByteOrderedDataInputStream, int):void");
    }

    public final void x(String str) {
        for (int i2 = 0; i2 < V.length; i2++) {
            this.f4420e[i2].remove(str);
        }
    }

    public final void y(int i2, String str, String str2) {
        HashMap[] mapArr = this.f4420e;
        if (mapArr[i2].isEmpty() || mapArr[i2].get(str) == null) {
            return;
        }
        HashMap map = mapArr[i2];
        map.put(str2, map.get(str));
        mapArr[i2].remove(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00fa A[Catch: all -> 0x010a, Exception -> 0x010d, TryCatch #19 {Exception -> 0x010d, all -> 0x010a, blocks: (B:80:0x00f6, B:82:0x00fa, B:89:0x0118, B:88:0x0110), top: B:128:0x00f6 }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0110 A[Catch: all -> 0x010a, Exception -> 0x010d, TryCatch #19 {Exception -> 0x010d, all -> 0x010a, blocks: (B:80:0x00f6, B:82:0x00fa, B:89:0x0118, B:88:0x0110), top: B:128:0x00f6 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void z() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 370
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.z():void");
    }

    public static class ByteOrderedDataInputStream extends InputStream implements DataInput {

        /* renamed from: a, reason: collision with root package name */
        public final DataInputStream f4431a;

        /* renamed from: b, reason: collision with root package name */
        public int f4432b;

        /* renamed from: c, reason: collision with root package name */
        public ByteOrder f4433c;

        /* renamed from: d, reason: collision with root package name */
        public byte[] f4434d;

        /* renamed from: e, reason: collision with root package name */
        public final int f4435e;

        public ByteOrderedDataInputStream(byte[] bArr) {
            this(new ByteArrayInputStream(bArr), ByteOrder.BIG_ENDIAN);
            this.f4435e = bArr.length;
        }

        public final void a(int i2) throws IOException {
            int i3 = 0;
            while (i3 < i2) {
                DataInputStream dataInputStream = this.f4431a;
                int i4 = i2 - i3;
                int iSkip = (int) dataInputStream.skip(i4);
                if (iSkip <= 0) {
                    if (this.f4434d == null) {
                        this.f4434d = new byte[KEYRecord.Flags.FLAG2];
                    }
                    iSkip = dataInputStream.read(this.f4434d, 0, Math.min(KEYRecord.Flags.FLAG2, i4));
                    if (iSkip == -1) {
                        throw new EOFException(b.g(i2, "Reached EOF while skipping ", " bytes."));
                    }
                }
                i3 += iSkip;
            }
            this.f4432b += i3;
        }

        @Override // java.io.InputStream
        public final int available() {
            return this.f4431a.available();
        }

        @Override // java.io.InputStream
        public final void mark(int i2) {
            throw new UnsupportedOperationException("Mark is currently unsupported");
        }

        @Override // java.io.InputStream
        public final int read() {
            this.f4432b++;
            return this.f4431a.read();
        }

        @Override // java.io.DataInput
        public final boolean readBoolean() {
            this.f4432b++;
            return this.f4431a.readBoolean();
        }

        @Override // java.io.DataInput
        public final byte readByte() throws IOException {
            this.f4432b++;
            int i2 = this.f4431a.read();
            if (i2 >= 0) {
                return (byte) i2;
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public final char readChar() {
            this.f4432b += 2;
            return this.f4431a.readChar();
        }

        @Override // java.io.DataInput
        public final double readDouble() {
            return Double.longBitsToDouble(readLong());
        }

        @Override // java.io.DataInput
        public final float readFloat() {
            return Float.intBitsToFloat(readInt());
        }

        @Override // java.io.DataInput
        public final void readFully(byte[] bArr, int i2, int i3) throws IOException {
            this.f4432b += i3;
            this.f4431a.readFully(bArr, i2, i3);
        }

        @Override // java.io.DataInput
        public final int readInt() throws IOException {
            this.f4432b += 4;
            DataInputStream dataInputStream = this.f4431a;
            int i2 = dataInputStream.read();
            int i3 = dataInputStream.read();
            int i4 = dataInputStream.read();
            int i5 = dataInputStream.read();
            if ((i2 | i3 | i4 | i5) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f4433c;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                return (i5 << 24) + (i4 << 16) + (i3 << 8) + i2;
            }
            if (byteOrder == ByteOrder.BIG_ENDIAN) {
                return (i2 << 24) + (i3 << 16) + (i4 << 8) + i5;
            }
            throw new IOException("Invalid byte order: " + this.f4433c);
        }

        @Override // java.io.DataInput
        public final String readLine() {
            Log.d("ExifInterface", "Currently unsupported");
            return null;
        }

        @Override // java.io.DataInput
        public final long readLong() throws IOException {
            long j2;
            long j3;
            this.f4432b += 8;
            DataInputStream dataInputStream = this.f4431a;
            int i2 = dataInputStream.read();
            int i3 = dataInputStream.read();
            int i4 = dataInputStream.read();
            int i5 = dataInputStream.read();
            int i6 = dataInputStream.read();
            int i7 = dataInputStream.read();
            int i8 = dataInputStream.read();
            int i9 = dataInputStream.read();
            if ((i2 | i3 | i4 | i5 | i6 | i7 | i8 | i9) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f4433c;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                j2 = (i9 << 56) + (i8 << 48) + (i7 << 40) + (i6 << 32) + (i5 << 24) + (i4 << 16) + (i3 << 8);
                j3 = i2;
            } else {
                if (byteOrder != ByteOrder.BIG_ENDIAN) {
                    throw new IOException("Invalid byte order: " + this.f4433c);
                }
                j2 = (i2 << 56) + (i3 << 48) + (i4 << 40) + (i5 << 32) + (i6 << 24) + (i7 << 16) + (i8 << 8);
                j3 = i9;
            }
            return j2 + j3;
        }

        @Override // java.io.DataInput
        public final short readShort() throws IOException {
            this.f4432b += 2;
            DataInputStream dataInputStream = this.f4431a;
            int i2 = dataInputStream.read();
            int i3 = dataInputStream.read();
            if ((i2 | i3) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f4433c;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                return (short) ((i3 << 8) + i2);
            }
            if (byteOrder == ByteOrder.BIG_ENDIAN) {
                return (short) ((i2 << 8) + i3);
            }
            throw new IOException("Invalid byte order: " + this.f4433c);
        }

        @Override // java.io.DataInput
        public final String readUTF() {
            this.f4432b += 2;
            return this.f4431a.readUTF();
        }

        @Override // java.io.DataInput
        public final int readUnsignedByte() {
            this.f4432b++;
            return this.f4431a.readUnsignedByte();
        }

        @Override // java.io.DataInput
        public final int readUnsignedShort() throws IOException {
            this.f4432b += 2;
            DataInputStream dataInputStream = this.f4431a;
            int i2 = dataInputStream.read();
            int i3 = dataInputStream.read();
            if ((i2 | i3) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f4433c;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                return (i3 << 8) + i2;
            }
            if (byteOrder == ByteOrder.BIG_ENDIAN) {
                return (i2 << 8) + i3;
            }
            throw new IOException("Invalid byte order: " + this.f4433c);
        }

        @Override // java.io.InputStream
        public final void reset() {
            throw new UnsupportedOperationException("Reset is currently unsupported");
        }

        @Override // java.io.DataInput
        public final int skipBytes(int i2) {
            throw new UnsupportedOperationException("skipBytes is currently unsupported");
        }

        public ByteOrderedDataInputStream(InputStream inputStream) {
            this(inputStream, ByteOrder.BIG_ENDIAN);
        }

        @Override // java.io.InputStream
        public final int read(byte[] bArr, int i2, int i3) throws IOException {
            int i4 = this.f4431a.read(bArr, i2, i3);
            this.f4432b += i4;
            return i4;
        }

        @Override // java.io.DataInput
        public final void readFully(byte[] bArr) throws IOException {
            this.f4432b += bArr.length;
            this.f4431a.readFully(bArr);
        }

        public ByteOrderedDataInputStream(InputStream inputStream, ByteOrder byteOrder) {
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            this.f4431a = dataInputStream;
            dataInputStream.mark(0);
            this.f4432b = 0;
            this.f4433c = byteOrder;
            this.f4435e = inputStream instanceof ByteOrderedDataInputStream ? ((ByteOrderedDataInputStream) inputStream).f4435e : -1;
        }
    }

    public static class SeekableByteOrderedDataInputStream extends ByteOrderedDataInputStream {
        public SeekableByteOrderedDataInputStream(byte[] bArr) {
            super(bArr);
            this.f4431a.mark(Api.BaseClientBuilder.API_PRIORITY_OTHER);
        }

        public final void b(long j2) throws IOException {
            int i2 = this.f4432b;
            if (i2 > j2) {
                this.f4432b = 0;
                this.f4431a.reset();
            } else {
                j2 -= i2;
            }
            a((int) j2);
        }

        public SeekableByteOrderedDataInputStream(InputStream inputStream) {
            super(inputStream);
            if (inputStream.markSupported()) {
                this.f4431a.mark(Api.BaseClientBuilder.API_PRIORITY_OTHER);
                return;
            }
            throw new IllegalArgumentException("Cannot create SeekableByteOrderedDataInputStream with stream that does not support mark/reset");
        }
    }

    public static class ExifTag {

        /* renamed from: a, reason: collision with root package name */
        public final int f4442a;

        /* renamed from: b, reason: collision with root package name */
        public final String f4443b;

        /* renamed from: c, reason: collision with root package name */
        public final int f4444c;

        /* renamed from: d, reason: collision with root package name */
        public final int f4445d;

        public ExifTag(String str, int i2, int i3) {
            this.f4443b = str;
            this.f4442a = i2;
            this.f4444c = i3;
            this.f4445d = -1;
        }

        public ExifTag(String str, int i2, int i3, int i4) {
            this.f4443b = str;
            this.f4442a = i2;
            this.f4444c = i3;
            this.f4445d = i4;
        }
    }

    public ExifInterface(InputStream inputStream) throws IOException {
        ExifTag[][] exifTagArr = V;
        this.f4420e = new HashMap[exifTagArr.length];
        this.f4421f = new HashSet(exifTagArr.length);
        this.f4422g = ByteOrder.BIG_ENDIAN;
        if (inputStream != null) {
            this.f4416a = null;
            if (inputStream instanceof AssetManager.AssetInputStream) {
                this.f4418c = (AssetManager.AssetInputStream) inputStream;
                this.f4417b = null;
            } else if (inputStream instanceof FileInputStream) {
                FileInputStream fileInputStream = (FileInputStream) inputStream;
                try {
                    ExifInterfaceUtils.Api21Impl.c(fileInputStream.getFD(), 0L, OsConstants.SEEK_CUR);
                    this.f4418c = null;
                    this.f4417b = fileInputStream.getFD();
                } catch (Exception unused) {
                    if (t) {
                        Log.d("ExifInterface", "The file descriptor for the given input is not seekable");
                    }
                }
            } else {
                this.f4418c = null;
                this.f4417b = null;
            }
            r(inputStream);
            return;
        }
        throw new NullPointerException("inputStream cannot be null");
    }
}
