package coil3.fetch;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import coil3.ImageLoader;
import coil3.Image_androidKt;
import coil3.Uri;
import coil3.UriKt;
import coil3.decode.DataSource;
import coil3.decode.ImageSourceKt;
import coil3.decode.ResourceMetadata;
import coil3.fetch.Fetcher;
import coil3.request.ImageRequests_androidKt;
import coil3.request.Options;
import coil3.size.Precision;
import coil3.util.ContextsKt;
import coil3.util.DrawableUtils;
import coil3.util.MimeTypeMap;
import coil3.util.UtilsKt;
import coil3.util.Utils_androidKt;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import okio.Okio;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class ResourceUriFetcher implements Fetcher {

    @NotNull
    private final Uri data;

    @NotNull
    private final Options options;

    @Metadata
    /* loaded from: classes.dex */
    public static final class Factory implements Fetcher.Factory<Uri> {
        private final boolean isApplicable(Uri uri) {
            return Intrinsics.b(uri.getScheme(), "android.resource");
        }

        @Override // coil3.fetch.Fetcher.Factory
        @Nullable
        public Fetcher create(@NotNull Uri uri, @NotNull Options options, @NotNull ImageLoader imageLoader) {
            if (isApplicable(uri)) {
                return new ResourceUriFetcher(uri, options);
            }
            return null;
        }
    }

    public ResourceUriFetcher(@NotNull Uri uri, @NotNull Options options) {
        this.data = uri;
        this.options = options;
    }

    private final Void throwInvalidUriException(Uri uri) {
        throw new IllegalStateException("Invalid android.resource URI: " + uri);
    }

    @Override // coil3.fetch.Fetcher
    @Nullable
    public Object fetch(@NotNull Continuation<? super FetchResult> continuation) throws Resources.NotFoundException {
        Integer intOrNull;
        String authority = this.data.getAuthority();
        if (authority != null) {
            if (StringsKt.z(authority)) {
                authority = null;
            }
            if (authority != null) {
                String str = (String) CollectionsKt.G(UriKt.getPathSegments(this.data));
                if (str == null || (intOrNull = StringsKt.toIntOrNull(str)) == null) {
                    throwInvalidUriException(this.data);
                    throw new KotlinNothingValueException();
                }
                int iIntValue = intOrNull.intValue();
                Context context = this.options.getContext();
                Resources resources = authority.equals(context.getPackageName()) ? context.getResources() : context.getPackageManager().getResourcesForApplication(authority);
                TypedValue typedValue = new TypedValue();
                resources.getValue(iIntValue, typedValue, true);
                CharSequence charSequence = typedValue.string;
                String mimeTypeFromUrl = MimeTypeMap.INSTANCE.getMimeTypeFromUrl(charSequence.subSequence(StringsKt.B(charSequence, '/', 0, 6), charSequence.length()).toString());
                if (!Intrinsics.b(mimeTypeFromUrl, UtilsKt.MIME_TYPE_XML)) {
                    TypedValue typedValue2 = new TypedValue();
                    return new SourceFetchResult(ImageSourceKt.ImageSource(Okio.d(Okio.m(resources.openRawResource(iIntValue, typedValue2))), this.options.getFileSystem(), new ResourceMetadata(authority, iIntValue, typedValue2.density)), mimeTypeFromUrl, DataSource.DISK);
                }
                Drawable drawableCompat = authority.equals(context.getPackageName()) ? ContextsKt.getDrawableCompat(context, iIntValue) : ContextsKt.getXmlDrawableCompat(context, resources, iIntValue);
                boolean zIsVector = Utils_androidKt.isVector(drawableCompat);
                if (zIsVector) {
                    drawableCompat = new BitmapDrawable(context.getResources(), DrawableUtils.INSTANCE.convertToBitmap(drawableCompat, ImageRequests_androidKt.getBitmapConfig(this.options), this.options.getSize(), this.options.getScale(), this.options.getPrecision() == Precision.INEXACT));
                }
                return new ImageFetchResult(Image_androidKt.asImage(drawableCompat), zIsVector, DataSource.DISK);
            }
        }
        throwInvalidUriException(this.data);
        throw new KotlinNothingValueException();
    }
}
