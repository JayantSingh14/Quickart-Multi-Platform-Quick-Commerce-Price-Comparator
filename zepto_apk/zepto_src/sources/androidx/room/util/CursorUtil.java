package androidx.room.util;

import android.database.Cursor;
import android.os.Build;
import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.fragment.app.e;
import com.google.ads.interactivemedia.v3.impl.data.zzck;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
@JvmName
@RestrictTo
@SourceDebugExtension
/* loaded from: classes.dex */
public final class CursorUtil {
    public static final int a(Cursor c2, String name) {
        Intrinsics.checkNotNullParameter(c2, "c");
        Intrinsics.checkNotNullParameter(name, "name");
        int columnIndex = c2.getColumnIndex(name);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        int columnIndex2 = c2.getColumnIndex("`" + name + '`');
        if (columnIndex2 >= 0) {
            return columnIndex2;
        }
        if (Build.VERSION.SDK_INT > 25 || name.length() == 0) {
            return -1;
        }
        String[] columnNames = c2.getColumnNames();
        Intrinsics.checkNotNullExpressionValue(columnNames, "columnNames");
        Intrinsics.checkNotNullParameter(columnNames, "columnNames");
        Intrinsics.checkNotNullParameter(name, "name");
        String strConcat = CLConstants.DOT_SALT_DELIMETER.concat(name);
        String strL = e.l('`', CLConstants.DOT_SALT_DELIMETER, name);
        int length = columnNames.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            String str = columnNames[i2];
            int i4 = i3 + 1;
            if (str.length() >= name.length() + 2 && (StringsKt.r(str, strConcat, false) || (str.charAt(0) == '`' && StringsKt.r(str, strL, false)))) {
                return i3;
            }
            i2++;
            i3 = i4;
        }
        return -1;
    }

    public static final int b(Cursor c2, String name) {
        String strA;
        Intrinsics.checkNotNullParameter(c2, "c");
        Intrinsics.checkNotNullParameter(name, "name");
        int iA = a(c2, name);
        if (iA >= 0) {
            return iA;
        }
        try {
            String[] columnNames = c2.getColumnNames();
            Intrinsics.checkNotNullExpressionValue(columnNames, "c.columnNames");
            strA = ArraysKt.A(63, null, columnNames);
        } catch (Exception e2) {
            Log.d("RoomCursorUtil", "Cannot collect column names for debug purposes", e2);
            strA = zzck.UNKNOWN_CONTENT_TYPE;
        }
        throw new IllegalArgumentException(e.p("column '", name, "' does not exist. Available columns: ", strA));
    }
}
