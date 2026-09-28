package androidx.media3.extractor.mp4;

import com.google.common.base.Splitter;
import java.util.ArrayList;

/* loaded from: classes3.dex */
final class SefReader {

    /* renamed from: d, reason: collision with root package name */
    public static final Splitter f9057d = Splitter.a(':');

    /* renamed from: e, reason: collision with root package name */
    public static final Splitter f9058e = Splitter.a('*');

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f9059a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public int f9060b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f9061c;

    public static final class DataReference {

        /* renamed from: a, reason: collision with root package name */
        public final long f9062a;

        /* renamed from: b, reason: collision with root package name */
        public final int f9063b;

        public DataReference(long j2, int i2) {
            this.f9062a = j2;
            this.f9063b = i2;
        }
    }
}
