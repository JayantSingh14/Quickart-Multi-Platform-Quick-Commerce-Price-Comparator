package io.ktor.http;

import androidx.fragment.app.e;
import io.ktor.utils.io.charsets.EncodingKt;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.CharRange;
import kotlin.text.Charsets;
import org.apache.commons.codec.language.Soundex;
import org.apache.commons.lang3.ClassUtils;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class CodecsKt {

    /* renamed from: a, reason: collision with root package name */
    public static final Set f50116a;

    /* renamed from: b, reason: collision with root package name */
    public static final Set f50117b;

    /* renamed from: c, reason: collision with root package name */
    public static final Set f50118c;

    /* renamed from: d, reason: collision with root package name */
    public static final ArrayList f50119d;

    /* renamed from: e, reason: collision with root package name */
    public static final Set f50120e;

    /* renamed from: f, reason: collision with root package name */
    public static final ArrayList f50121f;

    static {
        ArrayList arrayListL = CollectionsKt.L(CollectionsKt.M(new CharRange('a', 'z'), new CharRange('A', 'Z')), new CharRange('0', '9'));
        ArrayList arrayList = new ArrayList(CollectionsKt.r(arrayListL, 10));
        Iterator it = arrayListL.iterator();
        while (it.hasNext()) {
            arrayList.add(Byte.valueOf((byte) ((Character) it.next()).charValue()));
        }
        f50116a = CollectionsKt.h0(arrayList);
        f50117b = CollectionsKt.h0(CollectionsKt.L(CollectionsKt.M(new CharRange('a', 'z'), new CharRange('A', 'Z')), new CharRange('0', '9')));
        f50118c = CollectionsKt.h0(CollectionsKt.L(CollectionsKt.M(new CharRange('a', 'f'), new CharRange('A', 'F')), new CharRange('0', '9')));
        Character[] elements = {':', '/', '?', '#', '[', ']', '@', '!', '$', '&', '\'', '(', ')', '*', ',', ';', '=', Character.valueOf(Soundex.SILENT_MARKER), Character.valueOf(ClassUtils.PACKAGE_SEPARATOR_CHAR), '_', '~', '+'};
        Intrinsics.checkNotNullParameter(elements, "elements");
        Set setH = ArraysKt.H(elements);
        ArrayList arrayList2 = new ArrayList(CollectionsKt.r(setH, 10));
        Iterator it2 = setH.iterator();
        while (it2.hasNext()) {
            arrayList2.add(Byte.valueOf((byte) ((Character) it2.next()).charValue()));
        }
        f50119d = arrayList2;
        Character[] elements2 = {':', '@', '!', '$', '&', '\'', '(', ')', '*', '+', ',', ';', '=', Character.valueOf(Soundex.SILENT_MARKER), Character.valueOf(ClassUtils.PACKAGE_SEPARATOR_CHAR), '_', '~'};
        Intrinsics.checkNotNullParameter(elements2, "elements");
        f50120e = ArraysKt.H(elements2);
        Set set = f50117b;
        Character[] elements3 = {'!', '#', '$', '&', '+', Character.valueOf(Soundex.SILENT_MARKER), Character.valueOf(ClassUtils.PACKAGE_SEPARATOR_CHAR), '^', '_', '`', '|', '~'};
        Intrinsics.checkNotNullParameter(elements3, "elements");
        SetsKt.d(set, ArraysKt.H(elements3));
        List listI = CollectionsKt.I(Character.valueOf(Soundex.SILENT_MARKER), Character.valueOf(ClassUtils.PACKAGE_SEPARATOR_CHAR), '_', '~');
        ArrayList arrayList3 = new ArrayList(CollectionsKt.r(listI, 10));
        Iterator it3 = listI.iterator();
        while (it3.hasNext()) {
            arrayList3.add(Byte.valueOf((byte) ((Character) it3.next()).charValue()));
        }
        f50121f = arrayList3;
    }

    public static final String a(byte b2) {
        int i2 = (b2 & 255) >> 4;
        int i3 = b2 & 15;
        char[] cArr = {'%', (char) ((i2 < 0 || i2 >= 10) ? ((char) (i2 + 65)) - '\n' : i2 + 48), (char) ((i3 < 0 || i3 >= 10) ? ((char) (i3 + 65)) - '\n' : i3 + 48)};
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return new String(cArr);
    }

    public static final int b(char c2) {
        if ('0' <= c2 && c2 < ':') {
            return c2 - '0';
        }
        if ('A' <= c2 && c2 < 'G') {
            return c2 - '7';
        }
        if ('a' > c2 || c2 >= 'g') {
            return -1;
        }
        return c2 - 'W';
    }

    public static final String c(String str, int i2, int i3, boolean z, Charset charset) throws URLDecodeException {
        int i4 = i2;
        while (i4 < i3) {
            char cCharAt = str.charAt(i4);
            if (cCharAt == '%' || (z && cCharAt == '+')) {
                int i5 = i3 - i2;
                if (i5 > 255) {
                    i5 /= 3;
                }
                StringBuilder sb = new StringBuilder(i5);
                if (i4 > i2) {
                    sb.append((CharSequence) str, i2, i4);
                }
                byte[] bArr = null;
                while (i4 < i3) {
                    char cCharAt2 = str.charAt(i4);
                    if (z && cCharAt2 == '+') {
                        sb.append(' ');
                    } else if (cCharAt2 == '%') {
                        if (bArr == null) {
                            bArr = new byte[(i3 - i4) / 3];
                        }
                        int i6 = 0;
                        while (i4 < i3 && str.charAt(i4) == '%') {
                            int i7 = i4 + 2;
                            if (i7 >= i3) {
                                StringBuilder sb2 = new StringBuilder("Incomplete trailing HEX escape: ");
                                sb2.append(str.subSequence(i4, str.length()).toString());
                                sb2.append(", in ");
                                sb2.append((Object) str);
                                throw new URLDecodeException(e.r(sb2, i4, " at "));
                            }
                            int i8 = i4 + 1;
                            int iB = b(str.charAt(i8));
                            int iB2 = b(str.charAt(i7));
                            if (iB == -1 || iB2 == -1) {
                                throw new URLDecodeException("Wrong HEX escape: %" + str.charAt(i8) + str.charAt(i7) + ", in " + ((Object) str) + ", at " + i4);
                            }
                            bArr[i6] = (byte) ((iB * 16) + iB2);
                            i4 += 3;
                            i6++;
                        }
                        sb.append(new String(bArr, 0, i6, charset));
                    } else {
                        sb.append(cCharAt2);
                    }
                    i4++;
                }
                String string = sb.toString();
                Intrinsics.checkNotNullExpressionValue(string, "sb.toString()");
                return string;
            }
            i4++;
        }
        if (i2 == 0 && i3 == str.length()) {
            return str.toString();
        }
        String strSubstring = str.substring(i2, i3);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static String d(String str) {
        int length = str.length();
        Charset charset = Charsets.UTF_8;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return c(str, 0, length, false, charset);
    }

    public static String e(int i2, int i3, int i4, String str) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = str.length();
        }
        boolean z = (i4 & 4) == 0;
        Charset charset = Charsets.UTF_8;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return c(str, i2, i3, z, charset);
    }

    public static final String f(String str, final boolean z) throws Throwable {
        Intrinsics.checkNotNullParameter(str, "<this>");
        final StringBuilder sb = new StringBuilder();
        CharsetEncoder charsetEncoderNewEncoder = Charsets.UTF_8.newEncoder();
        Intrinsics.checkNotNullExpressionValue(charsetEncoderNewEncoder, "UTF_8.newEncoder()");
        g(EncodingKt.b(charsetEncoderNewEncoder, str, 0, str.length()), new Function1<Byte, Unit>() { // from class: io.ktor.http.CodecsKt$encodeURLParameter$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                byte bByteValue = ((Number) obj).byteValue();
                boolean zContains = CodecsKt.f50116a.contains(Byte.valueOf(bByteValue));
                StringBuilder sb2 = sb;
                if (zContains || CodecsKt.f50121f.contains(Byte.valueOf(bByteValue))) {
                    sb2.append((char) bByteValue);
                } else if (z && bByteValue == 32) {
                    sb2.append('+');
                } else {
                    sb2.append(CodecsKt.a(bByteValue));
                }
                return Unit.f53572a;
            }
        });
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002b, code lost:
    
        throw new java.io.EOFException("No readable bytes available.");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void g(io.ktor.utils.io.core.ByteReadPacket r4, kotlin.jvm.functions.Function1 r5) throws java.lang.Throwable {
        /*
            r0 = 1
            io.ktor.utils.io.core.internal.ChunkBuffer r1 = io.ktor.utils.io.core.internal.UnsafeKt.b(r4, r0)
            if (r1 != 0) goto L8
            goto L32
        L8:
            int r2 = r1.f51182c     // Catch: java.lang.Throwable -> L22
            int r3 = r1.f51181b     // Catch: java.lang.Throwable -> L22
            if (r2 <= r3) goto L2c
            if (r3 == r2) goto L24
            int r2 = r3 + 1
            r1.f51181b = r2     // Catch: java.lang.Throwable -> L22
            java.nio.ByteBuffer r2 = r1.f51180a     // Catch: java.lang.Throwable -> L22
            byte r2 = r2.get(r3)     // Catch: java.lang.Throwable -> L22
            java.lang.Byte r2 = java.lang.Byte.valueOf(r2)     // Catch: java.lang.Throwable -> L22
            r5.invoke(r2)     // Catch: java.lang.Throwable -> L22
            goto L8
        L22:
            r5 = move-exception
            goto L35
        L24:
            java.io.EOFException r5 = new java.io.EOFException     // Catch: java.lang.Throwable -> L22
            java.lang.String r2 = "No readable bytes available."
            r5.<init>(r2)     // Catch: java.lang.Throwable -> L22
            throw r5     // Catch: java.lang.Throwable -> L22
        L2c:
            io.ktor.utils.io.core.internal.ChunkBuffer r1 = io.ktor.utils.io.core.internal.UnsafeKt.c(r4, r1)     // Catch: java.lang.Throwable -> L33
            if (r1 != 0) goto L8
        L32:
            return
        L33:
            r5 = move-exception
            r0 = 0
        L35:
            if (r0 == 0) goto L3a
            io.ktor.utils.io.core.internal.UnsafeKt.a(r4, r1)
        L3a:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.http.CodecsKt.g(io.ktor.utils.io.core.ByteReadPacket, kotlin.jvm.functions.Function1):void");
    }
}
