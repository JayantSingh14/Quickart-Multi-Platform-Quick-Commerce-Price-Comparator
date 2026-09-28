package androidx.media3.common.util;

import android.net.Uri;
import androidx.media3.common.MediaMetadata;
import com.google.common.util.concurrent.ListenableFuture;

@UnstableApi
/* loaded from: classes3.dex */
public interface BitmapLoader {
    default ListenableFuture a(MediaMetadata mediaMetadata) {
        byte[] bArr = mediaMetadata.f5389k;
        if (bArr != null) {
            return c(bArr);
        }
        Uri uri = mediaMetadata.f5391m;
        if (uri != null) {
            return b(uri);
        }
        return null;
    }

    ListenableFuture b(Uri uri);

    ListenableFuture c(byte[] bArr);
}
