package kotlinx.datetime;

import android.support.v4.media.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.datetime.serializers.DateTimePeriodIso8601Serializer;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import org.apache.commons.codec.language.Soundex;
import org.apache.commons.lang3.ClassUtils;
import org.jetbrains.annotations.NotNull;
import org.xbill.DNS.TTL;

@Metadata
@Serializable(with = DateTimePeriodIso8601Serializer.class)
@SourceDebugExtension
/* loaded from: classes3.dex */
public abstract class DateTimePeriod {

    @NotNull
    public static final Companion Companion = new Companion();

    @Metadata
    public static final class Companion {
        /* JADX WARN: Removed duplicated region for block: B:202:0x0300 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:227:0x017f A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:86:0x0153  */
        /* JADX WARN: Removed duplicated region for block: B:98:0x018b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static kotlinx.datetime.DateTimePeriod a(java.lang.String r23) {
            /*
                Method dump skipped, instructions count: 772
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.datetime.DateTimePeriod.Companion.a(java.lang.String):kotlinx.datetime.DateTimePeriod");
        }

        public static final void b(int i2, String str) {
            throw new DateTimeFormatException(b.h(i2, "Parse error at char ", ": ", str));
        }

        public static final int c(long j2, int i2, char c2) {
            if (j2 >= -2147483648L && j2 <= TTL.MAX_VALUE) {
                return (int) j2;
            }
            b(i2, "Value " + j2 + " does not fit into an Int, which is required for component '" + c2 + '\'');
            throw null;
        }

        @NotNull
        public final KSerializer<DateTimePeriod> serializer() {
            return DateTimePeriodIso8601Serializer.f55649a;
        }
    }

    public abstract int a();

    public int b() {
        return (int) (h() / 3600000000000L);
    }

    public int c() {
        return (int) ((h() % 3600000000000L) / 60000000000L);
    }

    public final int d() {
        return g() % 12;
    }

    public int e() {
        return (int) (h() % 1000000000);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DateTimePeriod)) {
            return false;
        }
        DateTimePeriod dateTimePeriod = (DateTimePeriod) obj;
        return g() == dateTimePeriod.g() && a() == dateTimePeriod.a() && h() == dateTimePeriod.h();
    }

    public int f() {
        return (int) ((h() % 60000000000L) / 1000000000);
    }

    public abstract int g();

    public abstract long h();

    public final int hashCode() {
        return Long.hashCode(h()) + ((a() + (g() * 31)) * 31);
    }

    public final int i() {
        return g() / 12;
    }

    public final String toString() {
        int i2;
        StringBuilder sb = new StringBuilder();
        if (g() > 0 || a() > 0 || h() > 0 || ((g() | a()) == 0 && h() == 0)) {
            i2 = 1;
        } else {
            sb.append(Soundex.SILENT_MARKER);
            i2 = -1;
        }
        sb.append('P');
        if (i() != 0) {
            sb.append(i() * i2);
            sb.append('Y');
        }
        if (d() != 0) {
            sb.append(d() * i2);
            sb.append('M');
        }
        if (a() != 0) {
            sb.append(a() * i2);
            sb.append('D');
        }
        String str = "";
        String str2 = "T";
        if (b() != 0) {
            sb.append("T");
            sb.append(b() * i2);
            sb.append('H');
            str2 = "";
        }
        if (c() != 0) {
            sb.append(str2);
            sb.append(c() * i2);
            sb.append('M');
        } else {
            str = str2;
        }
        if ((f() | e()) != 0) {
            sb.append(str);
            sb.append(f() != 0 ? Integer.valueOf(f() * i2) : e() * i2 < 0 ? "-0" : "0");
            if (e() != 0) {
                sb.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
                sb.append(StringsKt.D(9, String.valueOf(Math.abs(e()))));
            }
            sb.append('S');
        }
        if (sb.length() == 1) {
            sb.append("0D");
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
