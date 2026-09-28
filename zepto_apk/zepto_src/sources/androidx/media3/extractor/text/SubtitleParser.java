package androidx.media3.extractor.text;

import androidx.media3.common.Format;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.UnstableApi;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableListIterator;

@UnstableApi
/* loaded from: classes3.dex */
public interface SubtitleParser {

    public interface Factory {

        /* renamed from: a, reason: collision with root package name */
        public static final Factory f9179a = new AnonymousClass1();

        /* renamed from: androidx.media3.extractor.text.SubtitleParser$Factory$1, reason: invalid class name */
        public class AnonymousClass1 implements Factory {
            @Override // androidx.media3.extractor.text.SubtitleParser.Factory
            public final int a(Format format) {
                return 1;
            }

            @Override // androidx.media3.extractor.text.SubtitleParser.Factory
            public final boolean b(Format format) {
                return false;
            }

            @Override // androidx.media3.extractor.text.SubtitleParser.Factory
            public final SubtitleParser c(Format format) {
                throw new IllegalStateException("This SubtitleParser.Factory doesn't support any formats.");
            }
        }

        int a(Format format);

        boolean b(Format format);

        SubtitleParser c(Format format);
    }

    public static class OutputOptions {

        /* renamed from: c, reason: collision with root package name */
        public static final OutputOptions f9180c = new OutputOptions(-9223372036854775807L, false);

        /* renamed from: a, reason: collision with root package name */
        public final long f9181a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f9182b;

        public OutputOptions(long j2, boolean z) {
            this.f9181a = j2;
            this.f9182b = z;
        }
    }

    default Subtitle a(int i2, byte[] bArr, int i3) {
        UnmodifiableListIterator unmodifiableListIterator = ImmutableList.f42665b;
        ImmutableList.Builder builder = new ImmutableList.Builder();
        b(bArr, 0, i3, OutputOptions.f9180c, new a(builder, 1));
        return new CuesWithTimingSubtitle(builder.j());
    }

    void b(byte[] bArr, int i2, int i3, OutputOptions outputOptions, Consumer consumer);

    int c();

    default void reset() {
    }
}
