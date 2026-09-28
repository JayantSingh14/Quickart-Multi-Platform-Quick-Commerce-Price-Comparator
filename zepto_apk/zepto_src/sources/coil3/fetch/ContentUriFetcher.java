package coil3.fetch;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import coil3.ImageLoader;
import coil3.Uri;
import coil3.UriKt;
import coil3.Uri_androidKt;
import coil3.decode.ContentMetadata;
import coil3.decode.DataSource;
import coil3.decode.ImageSourceKt;
import coil3.fetch.Fetcher;
import coil3.request.Options;
import coil3.size.Dimension;
import java.io.FileNotFoundException;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.Okio;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class ContentUriFetcher implements Fetcher {

    @NotNull
    private final Uri data;

    @NotNull
    private final Options options;

    @Metadata
    /* loaded from: classes.dex */
    public static final class Factory implements Fetcher.Factory<Uri> {
        private final boolean isApplicable(Uri uri) {
            return Intrinsics.b(uri.getScheme(), "content");
        }

        @Override // coil3.fetch.Fetcher.Factory
        @Nullable
        public Fetcher create(@NotNull Uri uri, @NotNull Options options, @NotNull ImageLoader imageLoader) {
            if (isApplicable(uri)) {
                return new ContentUriFetcher(uri, options);
            }
            return null;
        }
    }

    public ContentUriFetcher(@NotNull Uri uri, @NotNull Options options) {
        this.data = uri;
        this.options = options;
    }

    private final Bundle newMusicThumbnailSizeOptions() {
        Dimension width = this.options.getSize().getWidth();
        Dimension.Pixels pixels = width instanceof Dimension.Pixels ? (Dimension.Pixels) width : null;
        if (pixels == null) {
            return null;
        }
        int iM42unboximpl = pixels.m42unboximpl();
        Dimension height = this.options.getSize().getHeight();
        Dimension.Pixels pixels2 = height instanceof Dimension.Pixels ? (Dimension.Pixels) height : null;
        if (pixels2 == null) {
            return null;
        }
        int iM42unboximpl2 = pixels2.m42unboximpl();
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("android.content.extra.SIZE", new Point(iM42unboximpl, iM42unboximpl2));
        return bundle;
    }

    @Override // coil3.fetch.Fetcher
    @Nullable
    public Object fetch(@NotNull Continuation<? super FetchResult> continuation) throws FileNotFoundException {
        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor;
        android.net.Uri androidUri = Uri_androidKt.toAndroidUri(this.data);
        ContentResolver contentResolver = this.options.getContext().getContentResolver();
        if (isContactPhotoUri$coil_core_release(this.data)) {
            assetFileDescriptorOpenAssetFileDescriptor = contentResolver.openAssetFileDescriptor(androidUri, "r");
            if (assetFileDescriptorOpenAssetFileDescriptor == null) {
                throw new IllegalStateException(("Unable to find a contact photo associated with '" + androidUri + "'.").toString());
            }
        } else if (Build.VERSION.SDK_INT < 29 || !isMusicThumbnailUri$coil_core_release(this.data)) {
            assetFileDescriptorOpenAssetFileDescriptor = contentResolver.openAssetFileDescriptor(androidUri, "r");
            if (assetFileDescriptorOpenAssetFileDescriptor == null) {
                throw new IllegalStateException(("Unable to open '" + androidUri + "'.").toString());
            }
        } else {
            assetFileDescriptorOpenAssetFileDescriptor = contentResolver.openTypedAssetFile(androidUri, "image/*", newMusicThumbnailSizeOptions(), null);
            if (assetFileDescriptorOpenAssetFileDescriptor == null) {
                throw new IllegalStateException(("Unable to find a music thumbnail associated with '" + androidUri + "'.").toString());
            }
        }
        return new SourceFetchResult(ImageSourceKt.ImageSource(Okio.d(Okio.m(assetFileDescriptorOpenAssetFileDescriptor.createInputStream())), this.options.getFileSystem(), new ContentMetadata(this.data, assetFileDescriptorOpenAssetFileDescriptor)), contentResolver.getType(androidUri), DataSource.DISK);
    }

    @VisibleForTesting
    public final boolean isContactPhotoUri$coil_core_release(@NotNull Uri uri) {
        return Intrinsics.b(uri.getAuthority(), "com.android.contacts") && Intrinsics.b(CollectionsKt.G(UriKt.getPathSegments(uri)), "display_photo");
    }

    @VisibleForTesting
    public final boolean isMusicThumbnailUri$coil_core_release(@NotNull Uri uri) {
        List<String> pathSegments;
        int size;
        return Intrinsics.b(uri.getAuthority(), "media") && (size = (pathSegments = UriKt.getPathSegments(uri)).size()) >= 3 && Intrinsics.b(pathSegments.get(size + (-3)), "audio") && Intrinsics.b(pathSegments.get(size + (-2)), "albums");
    }
}
