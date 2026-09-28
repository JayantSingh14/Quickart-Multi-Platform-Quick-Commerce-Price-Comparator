package kotlin.ranges;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
public class IntProgression implements Iterable<Integer>, KMappedMarker {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final Companion f53837d = new Companion(null);

    /* renamed from: a, reason: collision with root package name */
    public final int f53838a;

    /* renamed from: b, reason: collision with root package name */
    public final int f53839b;

    /* renamed from: c, reason: collision with root package name */
    public final int f53840c;

    @Metadata
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public IntProgression(int i2, int i3, int i4) {
        if (i4 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i4 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f53838a = i2;
        this.f53839b = ProgressionUtilKt.a(i2, i3, i4);
        this.f53840c = i4;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof IntProgression)) {
            return false;
        }
        if (isEmpty() && ((IntProgression) obj).isEmpty()) {
            return true;
        }
        IntProgression intProgression = (IntProgression) obj;
        return this.f53838a == intProgression.f53838a && this.f53839b == intProgression.f53839b && this.f53840c == intProgression.f53840c;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f53838a * 31) + this.f53839b) * 31) + this.f53840c;
    }

    public boolean isEmpty() {
        int i2 = this.f53840c;
        int i3 = this.f53839b;
        int i4 = this.f53838a;
        return i2 > 0 ? i4 > i3 : i4 < i3;
    }

    @Override // java.lang.Iterable
    public final Iterator<Integer> iterator() {
        return new IntProgressionIterator(this.f53838a, this.f53839b, this.f53840c);
    }

    public String toString() {
        StringBuilder sb;
        int i2 = this.f53839b;
        int i3 = this.f53838a;
        int i4 = this.f53840c;
        if (i4 > 0) {
            sb = new StringBuilder();
            sb.append(i3);
            sb.append("..");
            sb.append(i2);
            sb.append(" step ");
            sb.append(i4);
        } else {
            sb = new StringBuilder();
            sb.append(i3);
            sb.append(" downTo ");
            sb.append(i2);
            sb.append(" step ");
            sb.append(-i4);
        }
        return sb.toString();
    }
}
