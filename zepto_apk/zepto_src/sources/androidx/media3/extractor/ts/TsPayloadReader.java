package androidx.media3.extractor.ts;

import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.ExtractorOutput;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@UnstableApi
/* loaded from: classes3.dex */
public interface TsPayloadReader {

    public static final class DvbSubtitleInfo {

        /* renamed from: a, reason: collision with root package name */
        public final String f9804a;

        /* renamed from: b, reason: collision with root package name */
        public final byte[] f9805b;

        public DvbSubtitleInfo(String str, byte[] bArr) {
            this.f9804a = str;
            this.f9805b = bArr;
        }
    }

    public static final class EsInfo {

        /* renamed from: a, reason: collision with root package name */
        public final String f9806a;

        /* renamed from: b, reason: collision with root package name */
        public final int f9807b;

        /* renamed from: c, reason: collision with root package name */
        public final List f9808c;

        /* renamed from: d, reason: collision with root package name */
        public final byte[] f9809d;

        @Target({ElementType.TYPE_USE})
        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface AudioType {
        }

        public EsInfo(int i2, String str, int i3, ArrayList arrayList, byte[] bArr) {
            this.f9806a = str;
            this.f9807b = i3;
            this.f9808c = arrayList == null ? Collections.EMPTY_LIST : Collections.unmodifiableList(arrayList);
            this.f9809d = bArr;
        }

        public final int a() {
            int i2 = this.f9807b;
            if (i2 != 2) {
                return i2 != 3 ? 0 : 512;
            }
            return 2048;
        }
    }

    public interface Factory {
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public static final class TrackIdGenerator {

        /* renamed from: a, reason: collision with root package name */
        public final String f9810a;

        /* renamed from: b, reason: collision with root package name */
        public final int f9811b;

        /* renamed from: c, reason: collision with root package name */
        public final int f9812c;

        /* renamed from: d, reason: collision with root package name */
        public int f9813d;

        /* renamed from: e, reason: collision with root package name */
        public String f9814e;

        public TrackIdGenerator(int i2, int i3) {
            this(Integer.MIN_VALUE, i2, i3);
        }

        public final void a() {
            int i2 = this.f9813d;
            this.f9813d = i2 == Integer.MIN_VALUE ? this.f9811b : i2 + this.f9812c;
            this.f9814e = this.f9810a + this.f9813d;
        }

        public final void b() {
            if (this.f9813d == Integer.MIN_VALUE) {
                throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
            }
        }

        public TrackIdGenerator(int i2, int i3, int i4) {
            String str;
            if (i2 != Integer.MIN_VALUE) {
                str = i2 + "/";
            } else {
                str = "";
            }
            this.f9810a = str;
            this.f9811b = i3;
            this.f9812c = i4;
            this.f9813d = Integer.MIN_VALUE;
            this.f9814e = "";
        }
    }

    void a(int i2, ParsableByteArray parsableByteArray);

    void b(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TrackIdGenerator trackIdGenerator);

    void c();
}
