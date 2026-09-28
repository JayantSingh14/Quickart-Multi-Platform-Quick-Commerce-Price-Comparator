package okhttp3.internal.publicsuffix;

import android.support.v4.media.b;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.DropSequence;
import kotlin.sequences.DropTakeSequence;
import kotlin.sequences.Sequence;
import kotlin.text.StringsKt;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import okio.GzipSource;
import okio.Okio;
import okio.RealBufferedSource;
import org.apache.commons.lang3.ClassUtils;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
/* loaded from: classes3.dex */
public final class PublicSuffixDatabase {

    /* renamed from: e, reason: collision with root package name */
    public static final byte[] f56813e = {42};

    /* renamed from: f, reason: collision with root package name */
    public static final List f56814f = CollectionsKt.H("*");

    /* renamed from: g, reason: collision with root package name */
    public static final PublicSuffixDatabase f56815g = new PublicSuffixDatabase();

    /* renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f56816a = new AtomicBoolean(false);

    /* renamed from: b, reason: collision with root package name */
    public final CountDownLatch f56817b = new CountDownLatch(1);

    /* renamed from: c, reason: collision with root package name */
    public byte[] f56818c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f56819d;

    @Metadata
    public static final class Companion {
        public static final String a(byte[] bArr, byte[][] bArr2, int i2) {
            int i3;
            boolean z;
            int i4;
            int i5;
            int i6 = -1;
            byte[] bArr3 = PublicSuffixDatabase.f56813e;
            int length = bArr.length;
            int i7 = 0;
            while (i7 < length) {
                int i8 = (i7 + length) / 2;
                while (i8 > i6 && bArr[i8] != 10) {
                    i8 += i6;
                }
                int i9 = i8 + 1;
                int i10 = 1;
                while (true) {
                    i3 = i9 + i10;
                    if (bArr[i3] == 10) {
                        break;
                    }
                    i10++;
                }
                int i11 = i3 - i9;
                int i12 = i2;
                boolean z2 = false;
                int i13 = 0;
                int i14 = 0;
                while (true) {
                    if (z2) {
                        i4 = 46;
                        z = false;
                    } else {
                        byte b2 = bArr2[i12][i13];
                        byte[] bArr4 = Util.f56394a;
                        int i15 = b2 & 255;
                        z = z2;
                        i4 = i15;
                    }
                    byte b3 = bArr[i9 + i14];
                    byte[] bArr5 = Util.f56394a;
                    i5 = i4 - (b3 & 255);
                    if (i5 != 0) {
                        break;
                    }
                    i14++;
                    i13++;
                    if (i14 == i11) {
                        break;
                    }
                    if (bArr2[i12].length != i13) {
                        z2 = z;
                    } else {
                        if (i12 == bArr2.length - 1) {
                            break;
                        }
                        i12++;
                        z2 = true;
                        i13 = -1;
                    }
                }
                if (i5 >= 0) {
                    if (i5 <= 0) {
                        int i16 = i11 - i14;
                        int length2 = bArr2[i12].length - i13;
                        int length3 = bArr2.length;
                        for (int i17 = i12 + 1; i17 < length3; i17++) {
                            length2 += bArr2[i17].length;
                        }
                        if (length2 >= i16) {
                            if (length2 <= i16) {
                                Charset UTF_8 = StandardCharsets.UTF_8;
                                Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                                return new String(bArr, i9, i11, UTF_8);
                            }
                        }
                        length = i8;
                    }
                    i7 = i3 + 1;
                } else {
                    length = i8;
                }
                i6 = -1;
            }
            return null;
        }

        public static PublicSuffixDatabase b() {
            return PublicSuffixDatabase.f56815g;
        }
    }

    public static List c(String str) {
        List listM = StringsKt.M(str, new char[]{ClassUtils.PACKAGE_SEPARATOR_CHAR});
        return Intrinsics.b(CollectionsKt.F(listM), "") ? CollectionsKt.w(1, listM) : listM;
    }

    public final String a(String domain) throws InterruptedException {
        String strA;
        String strA2;
        String strA3;
        List listM;
        List listM2;
        int size;
        int size2;
        int i2 = 0;
        Intrinsics.checkNotNullParameter(domain, "domain");
        String unicodeDomain = IDN.toUnicode(domain);
        Intrinsics.checkNotNullExpressionValue(unicodeDomain, "unicodeDomain");
        List listC = c(unicodeDomain);
        if (this.f56816a.get() || !this.f56816a.compareAndSet(false, true)) {
            try {
                this.f56817b.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } else {
            boolean z = false;
            while (true) {
                try {
                    try {
                        b();
                        break;
                    } finally {
                        if (z) {
                            Thread.currentThread().interrupt();
                        }
                    }
                } catch (InterruptedIOException unused2) {
                    Thread.interrupted();
                    z = true;
                } catch (IOException e2) {
                    Platform platform = Platform.f56791a;
                    Platform.f56791a.getClass();
                    Platform.i(5, "Failed to read public suffix list", e2);
                    if (z) {
                    }
                }
            }
        }
        if (this.f56818c == null) {
            throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
        }
        int size3 = listC.size();
        byte[][] bArr = new byte[size3][];
        for (int i3 = 0; i3 < size3; i3++) {
            String str = (String) listC.get(i3);
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            byte[] bytes = str.getBytes(UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            bArr[i3] = bytes;
        }
        int i4 = 0;
        while (true) {
            if (i4 >= size3) {
                strA = null;
                break;
            }
            byte[] bArr2 = this.f56818c;
            if (bArr2 == null) {
                Intrinsics.h("publicSuffixListBytes");
                throw null;
            }
            strA = Companion.a(bArr2, bArr, i4);
            if (strA != null) {
                break;
            }
            i4++;
        }
        if (size3 > 1) {
            byte[][] bArr3 = (byte[][]) bArr.clone();
            int length = bArr3.length - 1;
            for (int i5 = 0; i5 < length; i5++) {
                bArr3[i5] = f56813e;
                byte[] bArr4 = this.f56818c;
                if (bArr4 == null) {
                    Intrinsics.h("publicSuffixListBytes");
                    throw null;
                }
                strA2 = Companion.a(bArr4, bArr3, i5);
                if (strA2 != null) {
                    break;
                }
            }
            strA2 = null;
        } else {
            strA2 = null;
        }
        if (strA2 != null) {
            int i6 = size3 - 1;
            for (int i7 = 0; i7 < i6; i7++) {
                byte[] bArr5 = this.f56819d;
                if (bArr5 == null) {
                    Intrinsics.h("publicSuffixExceptionListBytes");
                    throw null;
                }
                strA3 = Companion.a(bArr5, bArr, i7);
                if (strA3 != null) {
                    break;
                }
            }
            strA3 = null;
        } else {
            strA3 = null;
        }
        if (strA3 != null) {
            listM2 = StringsKt.M("!".concat(strA3), new char[]{ClassUtils.PACKAGE_SEPARATOR_CHAR});
        } else if (strA == null && strA2 == null) {
            listM2 = f56814f;
        } else {
            if (strA == null || (listM = StringsKt.M(strA, new char[]{ClassUtils.PACKAGE_SEPARATOR_CHAR})) == null) {
                listM = EmptyList.f53609a;
            }
            if (strA2 == null || (listM2 = StringsKt.M(strA2, new char[]{ClassUtils.PACKAGE_SEPARATOR_CHAR})) == null) {
                listM2 = EmptyList.f53609a;
            }
            if (listM.size() > listM2.size()) {
                listM2 = listM;
            }
        }
        if (listC.size() == listM2.size() && ((String) listM2.get(0)).charAt(0) != '!') {
            return null;
        }
        if (((String) listM2.get(0)).charAt(0) == '!') {
            size = listC.size();
            size2 = listM2.size();
        } else {
            size = listC.size();
            size2 = listM2.size() + 1;
        }
        int i8 = size - size2;
        Sequence sequenceN = CollectionsKt.n(c(domain));
        Intrinsics.checkNotNullParameter(sequenceN, "<this>");
        if (i8 < 0) {
            throw new IllegalArgumentException(b.g(i8, "Requested element count ", " is less than zero.").toString());
        }
        if (i8 != 0) {
            sequenceN = sequenceN instanceof DropTakeSequence ? ((DropTakeSequence) sequenceN).a(i8) : new DropSequence(sequenceN, i8);
        }
        Intrinsics.checkNotNullParameter(sequenceN, "<this>");
        Intrinsics.checkNotNullParameter(CLConstants.DOT_SALT_DELIMETER, "separator");
        Intrinsics.checkNotNullParameter("", "prefix");
        Intrinsics.checkNotNullParameter("", "postfix");
        Intrinsics.checkNotNullParameter("...", "truncated");
        StringBuilder buffer = new StringBuilder();
        Intrinsics.checkNotNullParameter(sequenceN, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        Intrinsics.checkNotNullParameter(CLConstants.DOT_SALT_DELIMETER, "separator");
        Intrinsics.checkNotNullParameter("", "prefix");
        Intrinsics.checkNotNullParameter("", "postfix");
        Intrinsics.checkNotNullParameter("...", "truncated");
        buffer.append((CharSequence) "");
        for (Object obj : sequenceN) {
            i2++;
            if (i2 > 1) {
                buffer.append((CharSequence) CLConstants.DOT_SALT_DELIMETER);
            }
            StringsKt.k(buffer, obj, null);
        }
        buffer.append((CharSequence) "");
        return buffer.toString();
    }

    public final void b() {
        try {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream("publicsuffixes.gz");
            if (resourceAsStream != null) {
                RealBufferedSource realBufferedSourceD = Okio.d(new GzipSource(Okio.m(resourceAsStream)));
                try {
                    long jA = realBufferedSourceD.A();
                    realBufferedSourceD.j0(jA);
                    objectRef.f53801a = realBufferedSourceD.f56985b.r0(jA);
                    long jA2 = realBufferedSourceD.A();
                    realBufferedSourceD.j0(jA2);
                    objectRef2.f53801a = realBufferedSourceD.f56985b.r0(jA2);
                    Unit unit = Unit.f53572a;
                    realBufferedSourceD.close();
                    synchronized (this) {
                        Object obj = objectRef.f53801a;
                        Intrinsics.c(obj);
                        this.f56818c = (byte[]) obj;
                        Object obj2 = objectRef2.f53801a;
                        Intrinsics.c(obj2);
                        this.f56819d = (byte[]) obj2;
                    }
                } finally {
                }
            }
        } finally {
            this.f56817b.countDown();
        }
    }
}
