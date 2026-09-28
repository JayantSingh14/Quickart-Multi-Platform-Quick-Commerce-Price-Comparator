package androidx.core.content;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.OperationCanceledException;
import androidx.core.os.CancellationSignal;

/* loaded from: classes3.dex */
public final class ContentResolverCompat {
    public static Cursor a(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, CancellationSignal cancellationSignal) throws Exception {
        android.os.CancellationSignal cancellationSignal2;
        if (cancellationSignal != null) {
            synchronized (cancellationSignal) {
                try {
                    if (cancellationSignal.f2875c == null) {
                        android.os.CancellationSignal cancellationSignal3 = new android.os.CancellationSignal();
                        cancellationSignal.f2875c = cancellationSignal3;
                        if (cancellationSignal.f2873a) {
                            cancellationSignal3.cancel();
                        }
                    }
                    cancellationSignal2 = cancellationSignal.f2875c;
                } finally {
                }
            }
        } else {
            cancellationSignal2 = null;
        }
        try {
            return contentResolver.query(uri, strArr, str, strArr2, null, cancellationSignal2);
        } catch (Exception e2) {
            if (e2 instanceof OperationCanceledException) {
                throw new androidx.core.os.OperationCanceledException();
            }
            throw e2;
        }
    }
}
