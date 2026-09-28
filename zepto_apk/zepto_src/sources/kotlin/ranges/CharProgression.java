package kotlin.ranges;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
public class CharProgression implements Iterable<Character>, KMappedMarker {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final Companion f53828d = new Companion(null);

    /* renamed from: a, reason: collision with root package name */
    public final char f53829a;

    /* renamed from: b, reason: collision with root package name */
    public final char f53830b;

    /* renamed from: c, reason: collision with root package name */
    public final int f53831c = 1;

    @Metadata
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public CharProgression(char c2, char c3) {
        this.f53829a = c2;
        this.f53830b = (char) ProgressionUtilKt.a(c2, c3, 1);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CharProgression)) {
            return false;
        }
        if (isEmpty() && ((CharProgression) obj).isEmpty()) {
            return true;
        }
        CharProgression charProgression = (CharProgression) obj;
        return this.f53829a == charProgression.f53829a && this.f53830b == charProgression.f53830b && this.f53831c == charProgression.f53831c;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f53829a * 31) + this.f53830b) * 31) + this.f53831c;
    }

    public boolean isEmpty() {
        int i2 = this.f53831c;
        char c2 = this.f53830b;
        char c3 = this.f53829a;
        return i2 > 0 ? Intrinsics.e(c3, c2) > 0 : Intrinsics.e(c3, c2) < 0;
    }

    @Override // java.lang.Iterable
    public final Iterator<Character> iterator() {
        return new CharProgressionIterator(this.f53829a, this.f53830b, this.f53831c);
    }

    public String toString() {
        StringBuilder sb;
        char c2 = this.f53830b;
        char c3 = this.f53829a;
        int i2 = this.f53831c;
        if (i2 > 0) {
            sb = new StringBuilder();
            sb.append(c3);
            sb.append("..");
            sb.append(c2);
            sb.append(" step ");
            sb.append(i2);
        } else {
            sb = new StringBuilder();
            sb.append(c3);
            sb.append(" downTo ");
            sb.append(c2);
            sb.append(" step ");
            sb.append(-i2);
        }
        return sb.toString();
    }
}
