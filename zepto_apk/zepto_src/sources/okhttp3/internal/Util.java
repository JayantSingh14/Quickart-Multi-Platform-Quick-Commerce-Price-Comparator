package okhttp3.internal;

import androidx.fragment.app.e;
import com.google.android.gms.common.api.Api;
import j$.util.DesugarTimeZone;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody$Companion$asResponseBody$1;
import okhttp3.internal.http2.Header;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Options;
import okio.RealBufferedSource;
import okio.Source;
import org.apache.commons.lang3.time.TimeZones;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.xbill.DNS.TTL;
import org.xbill.DNS.WKSRecord;

@Metadata
@JvmName
@SourceDebugExtension
/* loaded from: classes.dex */
public final class Util {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f56394a;

    /* renamed from: b, reason: collision with root package name */
    public static final Headers f56395b = Headers.Companion.c(new String[0]);

    /* renamed from: c, reason: collision with root package name */
    public static final ResponseBody$Companion$asResponseBody$1 f56396c;

    /* renamed from: d, reason: collision with root package name */
    public static final Options f56397d;

    /* renamed from: e, reason: collision with root package name */
    public static final TimeZone f56398e;

    /* renamed from: f, reason: collision with root package name */
    public static final Regex f56399f;

    /* renamed from: g, reason: collision with root package name */
    public static final String f56400g;

    static {
        byte[] bArr = new byte[0];
        f56394a = bArr;
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Buffer buffer = new Buffer();
        buffer.w1(bArr);
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        f56396c = new ResponseBody$Companion$asResponseBody$1(null, 0, buffer);
        RequestBody.Companion.c(RequestBody.Companion, bArr, null, 0, 7);
        int i2 = Options.f56967d;
        ByteString byteString = ByteString.f56924d;
        f56397d = Options.Companion.b(ByteString.Companion.b("efbbbf"), ByteString.Companion.b("feff"), ByteString.Companion.b("fffe"), ByteString.Companion.b("0000ffff"), ByteString.Companion.b("ffff0000"));
        TimeZone timeZone = DesugarTimeZone.getTimeZone(TimeZones.GMT_ID);
        Intrinsics.c(timeZone);
        f56398e = timeZone;
        f56399f = new Regex("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
        String name = OkHttpClient.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "OkHttpClient::class.java.name");
        f56400g = StringsKt.G(StringsKt.F(name, "okhttp3."), "Client");
    }

    public static final String A(int i2, int i3, String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        int iN = n(i2, i3, str);
        String strSubstring = str.substring(iN, o(iN, i3, str));
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static final boolean a(HttpUrl httpUrl, HttpUrl other) {
        Intrinsics.checkNotNullParameter(httpUrl, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return Intrinsics.b(httpUrl.f56262d, other.f56262d) && httpUrl.f56263e == other.f56263e && Intrinsics.b(httpUrl.f56259a, other.f56259a);
    }

    public static final int b(long j2, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter("timeout", CLConstants.FIELD_PAY_INFO_NAME);
        if (j2 < 0) {
            throw new IllegalStateException("timeout < 0".toString());
        }
        if (timeUnit == null) {
            throw new IllegalStateException("unit == null");
        }
        long millis = timeUnit.toMillis(j2);
        if (millis > TTL.MAX_VALUE) {
            throw new IllegalArgumentException("timeout too large.".toString());
        }
        if (millis != 0 || j2 <= 0) {
            return (int) millis;
        }
        throw new IllegalArgumentException("timeout too small.".toString());
    }

    public static final void c(Closeable closeable) {
        Intrinsics.checkNotNullParameter(closeable, "<this>");
        try {
            closeable.close();
        } catch (RuntimeException e2) {
            throw e2;
        } catch (Exception unused) {
        }
    }

    public static final void d(Socket socket) {
        Intrinsics.checkNotNullParameter(socket, "<this>");
        try {
            socket.close();
        } catch (AssertionError e2) {
            throw e2;
        } catch (RuntimeException e3) {
            if (!Intrinsics.b(e3.getMessage(), "bio == null")) {
                throw e3;
            }
        } catch (Exception unused) {
        }
    }

    public static final int e(int i2, int i3, String str, String delimiters) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(delimiters, "delimiters");
        while (i2 < i3) {
            if (StringsKt.o(delimiters, str.charAt(i2))) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static final int f(String str, char c2, int i2, int i3) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        while (i2 < i3) {
            if (str.charAt(i2) == c2) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static /* synthetic */ int g(String str, char c2, int i2, int i3, int i4) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = str.length();
        }
        return f(str, c2, i2, i3);
    }

    public static final boolean h(Source source) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        Intrinsics.checkNotNullParameter(source, "<this>");
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        try {
            return v(source, 100);
        } catch (IOException unused) {
            return false;
        }
    }

    public static final String i(String format, Object... args) {
        Intrinsics.checkNotNullParameter(format, "format");
        Intrinsics.checkNotNullParameter(args, "args");
        Locale locale = Locale.US;
        Object[] objArrCopyOf = Arrays.copyOf(args, args.length);
        String str = String.format(locale, format, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
        Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
        return str;
    }

    public static final boolean j(String[] strArr, String[] strArr2, Comparator comparator) {
        Intrinsics.checkNotNullParameter(strArr, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (strArr.length != 0 && strArr2 != null && strArr2.length != 0) {
            for (String str : strArr) {
                Iterator itA = ArrayIteratorKt.a(strArr2);
                while (itA.hasNext()) {
                    if (comparator.compare(str, (String) itA.next()) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static final long k(Response response) {
        Intrinsics.checkNotNullParameter(response, "<this>");
        String strD = response.f56355f.d("Content-Length");
        if (strD != null) {
            Intrinsics.checkNotNullParameter(strD, "<this>");
            try {
                return Long.parseLong(strD);
            } catch (NumberFormatException unused) {
            }
        }
        return -1L;
    }

    public static final List l(Object... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Object[] objArr = (Object[]) elements.clone();
        List listUnmodifiableList = Collections.unmodifiableList(CollectionsKt.I(Arrays.copyOf(objArr, objArr.length)));
        Intrinsics.checkNotNullExpressionValue(listUnmodifiableList, "unmodifiableList(listOf(*elements.clone()))");
        return listUnmodifiableList;
    }

    public static final int m(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (Intrinsics.e(cCharAt, 31) <= 0 || Intrinsics.e(cCharAt, WKSRecord.Service.LOCUS_CON) >= 0) {
                return i2;
            }
        }
        return -1;
    }

    public static final int n(int i2, int i3, String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        while (i2 < i3) {
            char cCharAt = str.charAt(i2);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static final int o(int i2, int i3, String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        int i4 = i3 - 1;
        if (i2 <= i4) {
            while (true) {
                char cCharAt = str.charAt(i4);
                if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                    return i4 + 1;
                }
                if (i4 == i2) {
                    break;
                }
                i4--;
            }
        }
        return i2;
    }

    public static final String[] p(String[] strArr, String[] other, Comparator comparator) {
        Intrinsics.checkNotNullParameter(strArr, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = other.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                if (comparator.compare(str, other[i2]) == 0) {
                    arrayList.add(str);
                    break;
                }
                i2++;
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public static final boolean q(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return StringsKt.t(name, "Authorization", true) || StringsKt.t(name, "Cookie", true) || StringsKt.t(name, "Proxy-Authorization", true) || StringsKt.t(name, "Set-Cookie", true);
    }

    public static final int r(char c2) {
        if ('0' <= c2 && c2 < ':') {
            return c2 - '0';
        }
        if ('a' <= c2 && c2 < 'g') {
            return c2 - 'W';
        }
        if ('A' > c2 || c2 >= 'G') {
            return -1;
        }
        return c2 - '7';
    }

    public static final Charset s(BufferedSource bufferedSource, Charset charset) {
        Intrinsics.checkNotNullParameter(bufferedSource, "<this>");
        Intrinsics.checkNotNullParameter(charset, "default");
        int iR1 = bufferedSource.R1(f56397d);
        if (iR1 == -1) {
            return charset;
        }
        if (iR1 == 0) {
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            return UTF_8;
        }
        if (iR1 == 1) {
            Charset UTF_16BE = StandardCharsets.UTF_16BE;
            Intrinsics.checkNotNullExpressionValue(UTF_16BE, "UTF_16BE");
            return UTF_16BE;
        }
        if (iR1 == 2) {
            Charset UTF_16LE = StandardCharsets.UTF_16LE;
            Intrinsics.checkNotNullExpressionValue(UTF_16LE, "UTF_16LE");
            return UTF_16LE;
        }
        if (iR1 == 3) {
            Charsets.f53956a.getClass();
            Charset charset2 = Charsets.f53959d;
            if (charset2 != null) {
                return charset2;
            }
            Charset charsetForName = Charset.forName("UTF-32BE");
            Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(...)");
            Charsets.f53959d = charsetForName;
            return charsetForName;
        }
        if (iR1 != 4) {
            throw new AssertionError();
        }
        Charsets.f53956a.getClass();
        Charset charset3 = Charsets.f53958c;
        if (charset3 != null) {
            return charset3;
        }
        Charset charsetForName2 = Charset.forName("UTF-32LE");
        Intrinsics.checkNotNullExpressionValue(charsetForName2, "forName(...)");
        Charsets.f53958c = charsetForName2;
        return charsetForName2;
    }

    public static final int t(RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "<this>");
        return (realBufferedSource.e() & 255) | ((realBufferedSource.e() & 255) << 16) | ((realBufferedSource.e() & 255) << 8);
    }

    public static final int u(Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "<this>");
        int i2 = 0;
        while (!buffer.l() && buffer.x(0L) == 61) {
            i2++;
            buffer.k0();
        }
        return i2;
    }

    public static final boolean v(Source source, int i2) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        Intrinsics.checkNotNullParameter(source, "<this>");
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        long jNanoTime = System.nanoTime();
        long jC = source.timeout().e() ? source.timeout().c() - jNanoTime : Long.MAX_VALUE;
        source.timeout().d(Math.min(jC, timeUnit.toNanos(i2)) + jNanoTime);
        try {
            Buffer buffer = new Buffer();
            while (source.read(buffer, 8192L) != -1) {
                buffer.a();
            }
            if (jC == Long.MAX_VALUE) {
                source.timeout().a();
                return true;
            }
            source.timeout().d(jNanoTime + jC);
            return true;
        } catch (InterruptedIOException unused) {
            if (jC == Long.MAX_VALUE) {
                source.timeout().a();
                return false;
            }
            source.timeout().d(jNanoTime + jC);
            return false;
        } catch (Throwable th) {
            if (jC == Long.MAX_VALUE) {
                source.timeout().a();
            } else {
                source.timeout().d(jNanoTime + jC);
            }
            throw th;
        }
    }

    public static final Headers w(List list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Headers.Builder builder = new Headers.Builder();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Header header = (Header) it.next();
            builder.c(header.f56633a.z(), header.f56634b.z());
        }
        return builder.e();
    }

    public static final String x(HttpUrl httpUrl, boolean z) {
        Intrinsics.checkNotNullParameter(httpUrl, "<this>");
        boolean zN = StringsKt.n(httpUrl.f56262d, ":", false);
        String strL = httpUrl.f56262d;
        if (zN) {
            strL = e.l(']', "[", strL);
        }
        int i2 = httpUrl.f56263e;
        if (!z && i2 == HttpUrl.Companion.b(httpUrl.f56259a)) {
            return strL;
        }
        return strL + ':' + i2;
    }

    public static final List y(List list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        List listUnmodifiableList = Collections.unmodifiableList(CollectionsKt.f0(list));
        Intrinsics.checkNotNullExpressionValue(listUnmodifiableList, "unmodifiableList(toMutableList())");
        return listUnmodifiableList;
    }

    public static final int z(int i2, String str) throws NumberFormatException {
        if (str == null) {
            return i2;
        }
        try {
            long j2 = Long.parseLong(str);
            if (j2 > TTL.MAX_VALUE) {
                return Api.BaseClientBuilder.API_PRIORITY_OTHER;
            }
            if (j2 < 0) {
                return 0;
            }
            return (int) j2;
        } catch (NumberFormatException unused) {
            return i2;
        }
    }
}
