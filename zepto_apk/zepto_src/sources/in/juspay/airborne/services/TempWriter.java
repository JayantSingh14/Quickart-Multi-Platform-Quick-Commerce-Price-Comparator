package in.juspay.airborne.services;

import android.support.v4.media.b;
import in.juspay.airborne.services.FileProviderService;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes4.dex */
public final class TempWriter {

    @NotNull
    private final String LOG_TAG;

    @NotNull
    private final FileProviderService fileProviderService;

    @NotNull
    private final OTAServices otaServices;

    @NotNull
    private final File tempDir;

    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FileProviderService.Mode.values().length];
            try {
                iArr[FileProviderService.Mode.NEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FileProviderService.Mode.RE_OPEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public TempWriter(@NotNull String s, @NotNull FileProviderService.Mode m2, @NotNull OTAServices otaServices) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(s, "s");
        Intrinsics.checkNotNullParameter(m2, "m");
        Intrinsics.checkNotNullParameter(otaServices, "otaServices");
        this.otaServices = otaServices;
        this.fileProviderService = otaServices.getFileProviderService();
        this.LOG_TAG = "TEMP_WRITER";
        int i2 = WhenMappings.$EnumSwitchMapping$0[m2.ordinal()];
        if (i2 == 1) {
            String str = String.format("temp-%s-%s", Arrays.copyOf(new Object[]{s, Long.valueOf(System.currentTimeMillis())}, 2));
            Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
            File fileOpenInCache = otaServices.getWorkspace().openInCache(str);
            this.tempDir = fileOpenInCache;
            fileOpenInCache.mkdir();
            return;
        }
        if (i2 != 2) {
            throw new NoWhenBranchMatchedException();
        }
        File fileOpenInCache2 = otaServices.getWorkspace().openInCache(s);
        this.tempDir = fileOpenInCache2;
        if (!fileOpenInCache2.exists()) {
            throw new FileNotFoundException(b.k(s, " does not exist in cache!"));
        }
    }

    public final boolean copyToMain(@NotNull String fileName, @NotNull String dest) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(dest, "dest");
        if (!this.otaServices.getFromAirborne()) {
            return this.otaServices.getFileProviderService().hyperFileUtil.copyFile(this.tempDir, dest, fileName);
        }
        return this.fileProviderService.copyFile(new File(this.tempDir, fileName), this.fileProviderService.getFileFromInternalStorage(dest + '/' + fileName));
    }

    @NotNull
    public final String getDirName() {
        String name = this.tempDir.getName();
        Intrinsics.checkNotNullExpressionValue(name, "tempDir.name");
        return name;
    }

    @Nullable
    public final String[] list() {
        return this.fileProviderService.listFilesRecursive(this.tempDir);
    }

    public final boolean write(@NotNull String fileName, @NotNull byte[] content) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(content, "content");
        File file = new File(this.tempDir, fileName);
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        return this.fileProviderService.writeToFile(file, content, false);
    }
}
