package coil3.decode;

import android.content.res.AssetFileDescriptor;
import android.graphics.ImageDecoder;
import android.os.Build;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import androidx.annotation.RequiresApi;
import coil3.annotation.InternalCoilApi;
import coil3.decode.ImageSource;
import coil3.request.Options;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.FileSystem;
import okio.Path;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public final class StaticImageDecoderKt {
    @RequiresApi
    @InternalCoilApi
    @Nullable
    public static final ImageDecoder.Source toImageDecoderSourceOrNull(@NotNull ImageSource imageSource, @NotNull Options options, boolean z) throws ErrnoException {
        Path pathFileOrNull;
        if (imageSource.getFileSystem() == FileSystem.SYSTEM && (pathFileOrNull = imageSource.fileOrNull()) != null) {
            return ImageDecoder.createSource(pathFileOrNull.g());
        }
        ImageSource.Metadata metadata = imageSource.getMetadata();
        if (metadata instanceof AssetMetadata) {
            return ImageDecoder.createSource(options.getContext().getAssets(), ((AssetMetadata) metadata).getFilePath());
        }
        if ((metadata instanceof ContentMetadata) && Build.VERSION.SDK_INT >= 29) {
            try {
                AssetFileDescriptor assetFileDescriptor = ((ContentMetadata) metadata).getAssetFileDescriptor();
                Os.lseek(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), OsConstants.SEEK_SET);
                return ImageDecoder.createSource(new d(assetFileDescriptor, 0));
            } catch (ErrnoException unused) {
                return null;
            }
        }
        if (metadata instanceof ResourceMetadata) {
            ResourceMetadata resourceMetadata = (ResourceMetadata) metadata;
            if (Intrinsics.b(resourceMetadata.getPackageName(), options.getContext().getPackageName())) {
                return ImageDecoder.createSource(options.getContext().getResources(), resourceMetadata.getResId());
            }
        }
        if (!(metadata instanceof ByteBufferMetadata)) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 30 || !z || ((ByteBufferMetadata) metadata).getByteBuffer().isDirect()) {
            return ImageDecoder.createSource(((ByteBufferMetadata) metadata).getByteBuffer());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AssetFileDescriptor toImageDecoderSourceOrNull$lambda$0(AssetFileDescriptor assetFileDescriptor) {
        return assetFileDescriptor;
    }
}
