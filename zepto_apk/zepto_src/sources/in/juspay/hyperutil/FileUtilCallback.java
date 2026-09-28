package in.juspay.hyperutil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata
/* loaded from: classes4.dex */
public interface FileUtilCallback {
    boolean copyFile(@NotNull File file, @NotNull File file2);

    boolean deleteFile(@NotNull File file);

    @NotNull
    InputStream getAssetFileAsInputStream(@NotNull String str) throws IOException;

    @NotNull
    byte[] getFileInAssets(@NotNull String str) throws RuntimeException;

    @NotNull
    File getFileInInternalStorage(@NotNull String str);

    @NotNull
    JSONObject getMetadata(@NotNull String str) throws JSONException;

    @NotNull
    byte[] readFileFromInternalStorage(@NotNull String str) throws RuntimeException, FileNotFoundException;

    void resetMetadata(@NotNull String str);
}
