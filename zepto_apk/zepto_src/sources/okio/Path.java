package okio;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class Path implements Comparable<Path> {

    /* renamed from: b, reason: collision with root package name */
    public static final String f56972b;

    /* renamed from: a, reason: collision with root package name */
    public final ByteString f56973a;

    @Metadata
    public static final class Companion {
        public static Path a(String str, boolean z) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            ByteString byteString = okio.internal.Path.f57031a;
            Intrinsics.checkNotNullParameter(str, "<this>");
            Buffer buffer = new Buffer();
            buffer.X1(str);
            return okio.internal.Path.d(buffer, z);
        }

        public static Path b(File file) {
            String str = Path.f56972b;
            Intrinsics.checkNotNullParameter(file, "<this>");
            String string = file.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return a(string, false);
        }

        public static Path c(java.nio.file.Path path) {
            String str = Path.f56972b;
            Intrinsics.checkNotNullParameter(path, "<this>");
            return a(path.toString(), false);
        }
    }

    static {
        String separator = File.separator;
        Intrinsics.checkNotNullExpressionValue(separator, "separator");
        f56972b = separator;
    }

    public Path(ByteString bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        this.f56973a = bytes;
    }

    public final ArrayList a() {
        ArrayList arrayList = new ArrayList();
        int iA = okio.internal.Path.a(this);
        ByteString byteString = this.f56973a;
        if (iA == -1) {
            iA = 0;
        } else if (iA < byteString.d() && byteString.l(iA) == 92) {
            iA++;
        }
        int iD = byteString.d();
        int i2 = iA;
        while (iA < iD) {
            if (byteString.l(iA) == 47 || byteString.l(iA) == 92) {
                arrayList.add(byteString.t(i2, iA));
                i2 = iA + 1;
            }
            iA++;
        }
        if (i2 < byteString.d()) {
            arrayList.add(byteString.t(i2, byteString.d()));
        }
        return arrayList;
    }

    public final String b() {
        ByteString byteString = okio.internal.Path.f57031a;
        ByteString byteString2 = okio.internal.Path.f57031a;
        ByteString byteStringU = this.f56973a;
        int iP = ByteString.p(byteStringU, byteString2);
        if (iP == -1) {
            iP = ByteString.p(byteStringU, okio.internal.Path.f57032b);
        }
        if (iP != -1) {
            byteStringU = ByteString.u(byteStringU, iP + 1, 0, 2);
        } else if (i() != null && byteStringU.d() == 2) {
            byteStringU = ByteString.f56924d;
        }
        return byteStringU.z();
    }

    public final Path c() {
        ByteString byteString = okio.internal.Path.f57034d;
        ByteString byteString2 = this.f56973a;
        if (Intrinsics.b(byteString2, byteString)) {
            return null;
        }
        ByteString byteString3 = okio.internal.Path.f57031a;
        if (Intrinsics.b(byteString2, byteString3)) {
            return null;
        }
        ByteString prefix = okio.internal.Path.f57032b;
        if (Intrinsics.b(byteString2, prefix)) {
            return null;
        }
        ByteString suffix = okio.internal.Path.f57035e;
        byteString2.getClass();
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        int iD = byteString2.d();
        byte[] bArr = suffix.f56925a;
        if (byteString2.r(iD - bArr.length, suffix, bArr.length) && (byteString2.d() == 2 || byteString2.r(byteString2.d() - 3, byteString3, 1) || byteString2.r(byteString2.d() - 3, prefix, 1))) {
            return null;
        }
        int iP = ByteString.p(byteString2, byteString3);
        if (iP == -1) {
            iP = ByteString.p(byteString2, prefix);
        }
        if (iP == 2 && i() != null) {
            if (byteString2.d() == 3) {
                return null;
            }
            return new Path(ByteString.u(byteString2, 0, 3, 1));
        }
        if (iP == 1) {
            Intrinsics.checkNotNullParameter(prefix, "prefix");
            if (byteString2.r(0, prefix, prefix.d())) {
                return null;
            }
        }
        if (iP != -1 || i() == null) {
            return iP == -1 ? new Path(byteString) : iP == 0 ? new Path(ByteString.u(byteString2, 0, 1, 1)) : new Path(ByteString.u(byteString2, 0, iP, 1));
        }
        if (byteString2.d() == 2) {
            return null;
        }
        return new Path(ByteString.u(byteString2, 0, 2, 1));
    }

    @Override // java.lang.Comparable
    public final int compareTo(Path path) {
        Path other = path;
        Intrinsics.checkNotNullParameter(other, "other");
        return this.f56973a.compareTo(other.f56973a);
    }

    public final Path d(Path other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int iA = okio.internal.Path.a(this);
        ByteString byteString = this.f56973a;
        Path path = iA == -1 ? null : new Path(byteString.t(0, iA));
        other.getClass();
        int iA2 = okio.internal.Path.a(other);
        ByteString byteString2 = other.f56973a;
        if (!Intrinsics.b(path, iA2 != -1 ? new Path(byteString2.t(0, iA2)) : null)) {
            throw new IllegalArgumentException(("Paths of different roots cannot be relative to each other: " + this + " and " + other).toString());
        }
        ArrayList arrayListA = a();
        ArrayList arrayListA2 = other.a();
        int iMin = Math.min(arrayListA.size(), arrayListA2.size());
        int i2 = 0;
        while (i2 < iMin && Intrinsics.b(arrayListA.get(i2), arrayListA2.get(i2))) {
            i2++;
        }
        if (i2 == iMin && byteString.d() == byteString2.d()) {
            return Companion.a(CLConstants.DOT_SALT_DELIMETER, false);
        }
        if (arrayListA2.subList(i2, arrayListA2.size()).indexOf(okio.internal.Path.f57035e) != -1) {
            throw new IllegalArgumentException(("Impossible relative path to resolve: " + this + " and " + other).toString());
        }
        if (Intrinsics.b(byteString2, okio.internal.Path.f57034d)) {
            return this;
        }
        Buffer buffer = new Buffer();
        ByteString byteStringC = okio.internal.Path.c(other);
        if (byteStringC == null && (byteStringC = okio.internal.Path.c(this)) == null) {
            byteStringC = okio.internal.Path.f(f56972b);
        }
        int size = arrayListA2.size();
        for (int i3 = i2; i3 < size; i3++) {
            buffer.s1(okio.internal.Path.f57035e);
            buffer.s1(byteStringC);
        }
        int size2 = arrayListA.size();
        while (i2 < size2) {
            buffer.s1((ByteString) arrayListA.get(i2));
            buffer.s1(byteStringC);
            i2++;
        }
        return okio.internal.Path.d(buffer, false);
    }

    public final Path e(String child) {
        Intrinsics.checkNotNullParameter(child, "child");
        Buffer buffer = new Buffer();
        buffer.X1(child);
        return okio.internal.Path.b(this, okio.internal.Path.d(buffer, false), false);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof Path) && Intrinsics.b(((Path) obj).f56973a, this.f56973a);
    }

    public final File g() {
        return new File(this.f56973a.z());
    }

    public final java.nio.file.Path h() {
        java.nio.file.Path path = Paths.get(this.f56973a.z(), new String[0]);
        Intrinsics.checkNotNullExpressionValue(path, "get(...)");
        return path;
    }

    public final int hashCode() {
        return this.f56973a.hashCode();
    }

    public final Character i() {
        ByteString byteString = okio.internal.Path.f57031a;
        ByteString byteString2 = this.f56973a;
        if (ByteString.h(byteString2, byteString) != -1 || byteString2.d() < 2 || byteString2.l(1) != 58) {
            return null;
        }
        char cL = (char) byteString2.l(0);
        if (('a' > cL || cL >= '{') && ('A' > cL || cL >= '[')) {
            return null;
        }
        return Character.valueOf(cL);
    }

    public final String toString() {
        return this.f56973a.z();
    }
}
