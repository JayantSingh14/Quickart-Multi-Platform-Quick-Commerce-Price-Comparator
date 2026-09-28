package okio.internal;

import android.support.v4.media.b;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.Buffer;
import okio.ByteString;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
@JvmName
@SourceDebugExtension
/* renamed from: okio.internal.-Path, reason: invalid class name */
/* loaded from: classes.dex */
public final class Path {

    /* renamed from: a, reason: collision with root package name */
    public static final ByteString f57031a;

    /* renamed from: b, reason: collision with root package name */
    public static final ByteString f57032b;

    /* renamed from: c, reason: collision with root package name */
    public static final ByteString f57033c;

    /* renamed from: d, reason: collision with root package name */
    public static final ByteString f57034d;

    /* renamed from: e, reason: collision with root package name */
    public static final ByteString f57035e;

    static {
        ByteString byteString = ByteString.f56924d;
        f57031a = ByteString.Companion.c("/");
        f57032b = ByteString.Companion.c("\\");
        f57033c = ByteString.Companion.c("/\\");
        f57034d = ByteString.Companion.c(CLConstants.DOT_SALT_DELIMETER);
        f57035e = ByteString.Companion.c("..");
    }

    public static final int a(okio.Path path) {
        if (path.f56973a.d() != 0) {
            ByteString byteString = path.f56973a;
            if (byteString.l(0) != 47) {
                if (byteString.l(0) == 92) {
                    if (byteString.d() > 2 && byteString.l(1) == 92) {
                        ByteString other = f57032b;
                        Intrinsics.checkNotNullParameter(other, "other");
                        int iG = byteString.g(2, other.f56925a);
                        return iG == -1 ? byteString.d() : iG;
                    }
                } else if (byteString.d() > 2 && byteString.l(1) == 58 && byteString.l(2) == 92) {
                    char cL = (char) byteString.l(0);
                    if ('a' <= cL && cL < '{') {
                        return 3;
                    }
                    if ('A' <= cL && cL < '[') {
                        return 3;
                    }
                }
            }
            return 1;
        }
        return -1;
    }

    public static final okio.Path b(okio.Path path, okio.Path child, boolean z) {
        Intrinsics.checkNotNullParameter(path, "<this>");
        Intrinsics.checkNotNullParameter(child, "child");
        child.getClass();
        if (a(child) != -1 || child.i() != null) {
            return child;
        }
        ByteString byteStringC = c(path);
        if (byteStringC == null && (byteStringC = c(child)) == null) {
            byteStringC = f(okio.Path.f56972b);
        }
        Buffer buffer = new Buffer();
        buffer.s1(path.f56973a);
        if (buffer.f56914b > 0) {
            buffer.s1(byteStringC);
        }
        buffer.s1(child.f56973a);
        return d(buffer, z);
    }

    public static final ByteString c(okio.Path path) {
        ByteString byteString = path.f56973a;
        ByteString byteString2 = f57031a;
        if (ByteString.h(byteString, byteString2) != -1) {
            return byteString2;
        }
        ByteString byteString3 = f57032b;
        if (ByteString.h(path.f56973a, byteString3) != -1) {
            return byteString3;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0126 A[EDGE_INSN: B:101:0x0126->B:84:0x0126 BREAK  A[LOOP:1: B:53:0x00b3->B:116:0x00b3], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0144  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final okio.Path d(okio.Buffer r18, boolean r19) throws java.io.EOFException {
        /*
            Method dump skipped, instructions count: 353
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.Path.d(okio.Buffer, boolean):okio.Path");
    }

    public static final ByteString e(byte b2) {
        if (b2 == 47) {
            return f57031a;
        }
        if (b2 == 92) {
            return f57032b;
        }
        throw new IllegalArgumentException(b.f(b2, "not a directory separator: "));
    }

    public static final ByteString f(String str) {
        if (Intrinsics.b(str, "/")) {
            return f57031a;
        }
        if (Intrinsics.b(str, "\\")) {
            return f57032b;
        }
        throw new IllegalArgumentException(b.C("not a directory separator: ", str));
    }
}
