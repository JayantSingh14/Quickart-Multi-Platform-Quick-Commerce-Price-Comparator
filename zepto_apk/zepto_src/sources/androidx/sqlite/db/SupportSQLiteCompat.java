package androidx.sqlite.db;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
@RestrictTo
/* loaded from: classes3.dex */
public final class SupportSQLiteCompat {

    @Metadata
    @RequiresApi
    @RestrictTo
    /* loaded from: classes.dex */
    public static final class Api16Impl {
    }

    @Metadata
    @RequiresApi
    @RestrictTo
    /* loaded from: classes.dex */
    public static final class Api19Impl {
    }

    @Metadata
    @RequiresApi
    @RestrictTo
    /* loaded from: classes.dex */
    public static final class Api21Impl {
    }

    @Metadata
    @RequiresApi
    @RestrictTo
    public static final class Api23Impl {
    }

    @Metadata
    @RequiresApi
    @RestrictTo
    public static final class Api29Impl {
        public static final List a(Cursor cursor) {
            Intrinsics.checkNotNullParameter(cursor, "cursor");
            List<Uri> notificationUris = cursor.getNotificationUris();
            Intrinsics.c(notificationUris);
            return notificationUris;
        }

        public static final void b(Cursor cursor, ContentResolver cr, List uris) {
            Intrinsics.checkNotNullParameter(cursor, "cursor");
            Intrinsics.checkNotNullParameter(cr, "cr");
            Intrinsics.checkNotNullParameter(uris, "uris");
            cursor.setNotificationUris(cr, uris);
        }
    }
}
