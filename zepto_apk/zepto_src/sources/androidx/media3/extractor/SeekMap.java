package androidx.media3.extractor;

import android.support.v4.media.b;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
/* loaded from: classes3.dex */
public interface SeekMap {

    public static final class SeekPoints {

        /* renamed from: a, reason: collision with root package name */
        public final SeekPoint f8600a;

        /* renamed from: b, reason: collision with root package name */
        public final SeekPoint f8601b;

        public SeekPoints(SeekPoint seekPoint, SeekPoint seekPoint2) {
            this.f8600a = seekPoint;
            this.f8601b = seekPoint2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && SeekPoints.class == obj.getClass()) {
                SeekPoints seekPoints = (SeekPoints) obj;
                if (this.f8600a.equals(seekPoints.f8600a) && this.f8601b.equals(seekPoints.f8601b)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return this.f8601b.hashCode() + (this.f8600a.hashCode() * 31);
        }

        public final String toString() {
            String str;
            StringBuilder sb = new StringBuilder("[");
            SeekPoint seekPoint = this.f8600a;
            sb.append(seekPoint);
            SeekPoint seekPoint2 = this.f8601b;
            if (seekPoint.equals(seekPoint2)) {
                str = "";
            } else {
                str = ", " + seekPoint2;
            }
            return b.r(sb, str, "]");
        }
    }

    public static class Unseekable implements SeekMap {

        /* renamed from: a, reason: collision with root package name */
        public final long f8602a;

        /* renamed from: b, reason: collision with root package name */
        public final SeekPoints f8603b;

        public Unseekable(long j2) {
            this(j2, 0L);
        }

        @Override // androidx.media3.extractor.SeekMap
        public final SeekPoints d(long j2) {
            return this.f8603b;
        }

        @Override // androidx.media3.extractor.SeekMap
        public final boolean g() {
            return false;
        }

        @Override // androidx.media3.extractor.SeekMap
        public final long l() {
            return this.f8602a;
        }

        public Unseekable(long j2, long j3) {
            this.f8602a = j2;
            SeekPoint seekPoint = j3 == 0 ? SeekPoint.f8604c : new SeekPoint(0L, j3);
            this.f8603b = new SeekPoints(seekPoint, seekPoint);
        }
    }

    SeekPoints d(long j2);

    boolean g();

    long l();
}
