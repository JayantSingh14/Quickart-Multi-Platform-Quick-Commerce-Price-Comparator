package kotlinx.coroutines.internal;

import androidx.fragment.app.e;
import com.google.android.gms.common.api.Api;
import kotlin.Metadata;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: classes.dex */
public final class SystemPropsKt {
    public static final int a() {
        return SystemPropsKt__SystemPropsKt.f55108a;
    }

    public static final long b(long j2, long j3, long j4, String str) {
        String strC = c(str);
        if (strC == null) {
            return j2;
        }
        Long lA0 = StringsKt.a0(strC);
        if (lA0 == null) {
            throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + strC + '\'').toString());
        }
        long jLongValue = lA0.longValue();
        if (j3 <= jLongValue && jLongValue <= j4) {
            return jLongValue;
        }
        StringBuilder sb = new StringBuilder("System property '");
        sb.append(str);
        sb.append("' should be in range ");
        sb.append(j3);
        e.A(sb, "..", j4, ", but is '");
        sb.append(jLongValue);
        sb.append('\'');
        throw new IllegalStateException(sb.toString().toString());
    }

    public static final String c(String str) {
        int i2 = SystemPropsKt__SystemPropsKt.f55108a;
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }

    public static int d(int i2, int i3, String str) {
        return (int) b(i2, 1, (i3 & 8) != 0 ? Api.BaseClientBuilder.API_PRIORITY_OTHER : 2097150, str);
    }
}
