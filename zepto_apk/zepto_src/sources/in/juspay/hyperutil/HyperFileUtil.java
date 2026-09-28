package in.juspay.hyperutil;

import android.os.Build;
import android.support.v4.media.b;
import android.util.Base64;
import com.amazonaws.mobileconnectors.remoteconfiguration.Attributes;
import dalvik.system.ZipPathValidator;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.apache.commons.lang3.ClassUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata
@SourceDebugExtension
/* loaded from: classes4.dex */
public final class HyperFileUtil {

    @NotNull
    private final String LOG_TAG;

    @NotNull
    private final FileUtilCallback fileUtilCallback;

    @NotNull
    private final String sdkNameAndVersion;

    @NotNull
    private final TrackerCallback trackerCallback;

    @Metadata
    public static final class DecodeFileResponse {

        @NotNull
        private final byte[] content;

        @NotNull
        private final String fileName;

        public DecodeFileResponse(@NotNull String fileName, @NotNull byte[] content) {
            Intrinsics.checkNotNullParameter(fileName, "fileName");
            Intrinsics.checkNotNullParameter(content, "content");
            this.fileName = fileName;
            this.content = content;
        }

        @NotNull
        public final byte[] getContent() {
            return this.content;
        }

        @NotNull
        public final String getFileName() {
            return this.fileName;
        }
    }

    public HyperFileUtil(@NotNull String sdkNameAndVersion, @NotNull FileUtilCallback fileUtilCallback, @NotNull TrackerCallback trackerCallback) {
        Intrinsics.checkNotNullParameter(sdkNameAndVersion, "sdkNameAndVersion");
        Intrinsics.checkNotNullParameter(fileUtilCallback, "fileUtilCallback");
        Intrinsics.checkNotNullParameter(trackerCallback, "trackerCallback");
        this.sdkNameAndVersion = sdkNameAndVersion;
        this.fileUtilCallback = fileUtilCallback;
        this.trackerCallback = trackerCallback;
        this.LOG_TAG = "HyperFileUtil";
    }

    private final String asDecryptedJSA(String str) {
        return replaceExtension(str, ".jsa", ".jsajs");
    }

    private final String asEncryptedJSA(String str) {
        return replaceExtension(str, ".jsajs", ".jsa");
    }

    private final String decodeFileName(String str) {
        return appendSdkNameAndVersion(getUnzippedFileName(str));
    }

    private final byte[] decryptContent(String str, byte[] bArr) {
        if (!StringsKt.r(str, ".jsa", false)) {
            return bArr;
        }
        byte[] bArrDecryptThenGunzip = OTAEncryptionHelper.decryptThenGunzip(bArr, "v1");
        Intrinsics.checkNotNullExpressionValue(bArrDecryptThenGunzip, "{\n            OTAEncrypt…RYPTED_VERSION)\n        }");
        return bArrDecryptThenGunzip;
    }

    private final String getUnzippedFileName(String str) {
        return StringsKt.r(str, ".zip", false) ? StringsKt.K(str, ".zip", ".jsa") : str;
    }

    private final String getZippedFileName(String str) {
        return StringsKt.r(str, ".jsa", false) ? StringsKt.K(str, ".jsa", ".zip") : str;
    }

    private final String readFileFromAssets(String str) {
        try {
            return new String(decryptContent(str, this.fileUtilCallback.getFileInAssets(str)), Charsets.UTF_8);
        } catch (Exception e2) {
            this.trackerCallback.trackException("action", "system", "file_provider_service", b.C("Exception trying to read file from assets: ", str), e2);
            return null;
        }
    }

    private final String replaceExtension(String str, String str2, String str3) {
        return StringsKt.r(str, str2, false) ? StringsKt.K(str, str2, str3) : str;
    }

    private final String stripSdkNameAndVersion(String str) {
        try {
            return StringsKt.K(str, Attributes.PREDEFINED_ATTRIBUTE_PREFIX + this.sdkNameAndVersion, "");
        } catch (Exception unused) {
            return str;
        }
    }

    private final byte[] unzipAndVerify(byte[] bArr, String str, byte[] bArr2) throws IOException {
        if (bArr == null || !StringsKt.n(str, ".zip", false)) {
            return bArr;
        }
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                ZipInputStream zipInputStream = new ZipInputStream(byteArrayInputStream);
                try {
                    Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    if (Build.VERSION.SDK_INT >= 34) {
                        ZipPathValidator.clearCallback();
                    }
                    try {
                        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                        Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
                        while (true) {
                            ZipEntry nextEntry = zipInputStream.getNextEntry();
                            objectRef.f53801a = nextEntry;
                            if (nextEntry == null) {
                                try {
                                    break;
                                } catch (ClassNotFoundException e2) {
                                    this.trackerCallback.trackAndLogException(this.LOG_TAG, "action", "system", "remote_asset_service", "Exception while Reading Public Key", e2);
                                    Unit unit = Unit.f53572a;
                                    zipInputStream.close();
                                    byteArrayInputStream.close();
                                    return null;
                                } catch (InvalidKeyException e3) {
                                    this.trackerCallback.trackAndLogException(this.LOG_TAG, "action", "system", "remote_asset_service", "Key Used was Invalid", e3);
                                    Unit unit2 = Unit.f53572a;
                                    zipInputStream.close();
                                    byteArrayInputStream.close();
                                    return null;
                                } catch (NoSuchAlgorithmException e4) {
                                    this.trackerCallback.trackAndLogException(this.LOG_TAG, "action", "system", "remote_asset_service", "DSA Algorithm not found", e4);
                                    Unit unit22 = Unit.f53572a;
                                    zipInputStream.close();
                                    byteArrayInputStream.close();
                                    return null;
                                } catch (SignatureException e5) {
                                    this.trackerCallback.trackAndLogException(this.LOG_TAG, "action", "system", "remote_asset_service", "Exception while matching Signature for file", e5);
                                    Unit unit222 = Unit.f53572a;
                                    zipInputStream.close();
                                    byteArrayInputStream.close();
                                    return null;
                                }
                            }
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            try {
                                byte[] bArr3 = new byte[1024];
                                while (true) {
                                    int i2 = zipInputStream.read(bArr3);
                                    if (i2 == -1) {
                                        break;
                                    }
                                    byteArrayOutputStream.write(bArr3, 0, i2);
                                }
                                zipInputStream.closeEntry();
                                ZipEntry zipEntry = (ZipEntry) objectRef.f53801a;
                                String name = zipEntry != null ? zipEntry.getName() : null;
                                if (name == null) {
                                    name = "";
                                } else {
                                    Intrinsics.checkNotNullExpressionValue(name, "distinctFiles?.name ?: \"\"");
                                }
                                if (StringsKt.n(name, "signature", false)) {
                                    objectRef3.f53801a = Base64.decode(byteArrayOutputStream.toByteArray(), 2);
                                } else if (StringsKt.n(name, ".jsa", false) || (StringsKt.n(str, "certificate", false) && StringsKt.n(name, ".zip", false))) {
                                    objectRef2.f53801a = byteArrayOutputStream.toByteArray();
                                }
                                Unit unit3 = Unit.f53572a;
                                byteArrayOutputStream.close();
                            } finally {
                            }
                        }
                        ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(bArr2));
                        try {
                            Object object = objectInputStream.readObject();
                            Intrinsics.d(object, "null cannot be cast to non-null type java.security.PublicKey");
                            Signature signature = Signature.getInstance("DSA");
                            signature.initVerify((PublicKey) object);
                            signature.update((byte[]) objectRef2.f53801a);
                            if (!signature.verify((byte[]) objectRef3.f53801a)) {
                                TrackerCallback trackerCallback = this.trackerCallback;
                                JSONObject jSONObjectPut = new JSONObject().put("signature verification failed for", str);
                                Intrinsics.checkNotNullExpressionValue(jSONObjectPut, "JSONObject().put(\"signat…on failed for\", fileName)");
                                trackerCallback.track("action", "system", "info", "remote_asset_service", "signature_not_verified", jSONObjectPut);
                                CloseableKt.a(objectInputStream, null);
                                zipInputStream.close();
                                byteArrayInputStream.close();
                                return null;
                            }
                            TrackerCallback trackerCallback2 = this.trackerCallback;
                            JSONObject jSONObjectPut2 = new JSONObject().put("signature verified for", str);
                            Intrinsics.checkNotNullExpressionValue(jSONObjectPut2, "JSONObject().put(\"signat… verified for\", fileName)");
                            trackerCallback2.track("action", "system", "info", "remote_asset_service", "signature_verified", jSONObjectPut2);
                            byte[] bArr4 = (byte[]) objectRef2.f53801a;
                            CloseableKt.a(objectInputStream, null);
                            zipInputStream.close();
                            byteArrayInputStream.close();
                            return bArr4;
                        } finally {
                        }
                    } catch (Exception e6) {
                        this.trackerCallback.trackAndLogException(this.LOG_TAG, "action", "system", "remote_asset_service", "Exception while verifying Signature", e6);
                    }
                } finally {
                }
            } finally {
            }
        } catch (IOException e7) {
            this.trackerCallback.trackAndLogException(this.LOG_TAG, "action", "system", "remote_asset_service", "IOException while verifying Signature", e7);
            return null;
        }
    }

    @NotNull
    public final String appendSdkNameAndVersion(@NotNull String file) {
        Intrinsics.checkNotNullParameter(file, "file");
        int iB = StringsKt.B(file, ClassUtils.PACKAGE_SEPARATOR_CHAR, 0, 6);
        if (iB <= 0 || iB >= file.length() - 1) {
            return file + '_' + this.sdkNameAndVersion;
        }
        String strSubstring = file.substring(0, iB);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        String strSubstring2 = file.substring(iB);
        Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String).substring(startIndex)");
        StringBuilder sb = new StringBuilder();
        sb.append(strSubstring);
        sb.append('_');
        return b.r(sb, this.sdkNameAndVersion, strSubstring2);
    }

    public final boolean copyFile(@NotNull File sourceDir, @NotNull String destDir, @NotNull String fileName) {
        Intrinsics.checkNotNullParameter(sourceDir, "sourceDir");
        Intrinsics.checkNotNullParameter(destDir, "destDir");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        String strAsDecryptedJSA = asDecryptedJSA(decodeFileName(fileName));
        return this.fileUtilCallback.copyFile(new File(sourceDir, strAsDecryptedJSA), this.fileUtilCallback.getFileInInternalStorage(destDir + '/' + strAsDecryptedJSA));
    }

    @NotNull
    public final DecodeFileResponse decodeFileContent(@NotNull String fileName, @NotNull byte[] content) throws Exception {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(content, "content");
        String strDecodeFileName = decodeFileName(fileName);
        if (StringsKt.n(strDecodeFileName, ".jsa", false)) {
            strDecodeFileName = asDecryptedJSA(strDecodeFileName);
            content = OTAEncryptionHelper.decryptThenGunzip(content, "v1");
            Intrinsics.checkNotNullExpressionValue(content, "decryptThenGunzip(\n     …TED_VERSION\n            )");
        }
        return new DecodeFileResponse(strDecodeFileName, content);
    }

    public final boolean deleteFileFromInternalStorage(@NotNull String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        String strAsDecryptedJSA = asDecryptedJSA(decodeFileName(filePath));
        if (!this.fileUtilCallback.getFileInInternalStorage(strAsDecryptedJSA).exists()) {
            return false;
        }
        this.fileUtilCallback.resetMetadata(getUnzippedFileName(filePath));
        FileUtilCallback fileUtilCallback = this.fileUtilCallback;
        return fileUtilCallback.deleteFile(fileUtilCallback.getFileInInternalStorage(strAsDecryptedJSA));
    }

    @NotNull
    public final String encodeFileName(@NotNull String fileName) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        return getZippedFileName(stripSdkNameAndVersion(asEncryptedJSA(fileName)));
    }

    @NotNull
    public final File getFileFromInternalStorage(@NotNull String fileName) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        return this.fileUtilCallback.getFileInInternalStorage(asDecryptedJSA(decodeFileName(fileName)));
    }

    @NotNull
    public final String getFileNameForMetadata(@NotNull String fileName) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        return getUnzippedFileName(fileName);
    }

    @NotNull
    public final FileUtilCallback getFileUtilCallback() {
        return this.fileUtilCallback;
    }

    @NotNull
    public final JSONObject getMetadata(@NotNull String fileName) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        return this.fileUtilCallback.getMetadata(getUnzippedFileName(fileName));
    }

    @NotNull
    public final String getSdkNameAndVersion() {
        return this.sdkNameAndVersion;
    }

    @NotNull
    public final TrackerCallback getTrackerCallback() {
        return this.trackerCallback;
    }

    public final boolean isFilePresent(@NotNull String fileName) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        String strDecodeFileName = decodeFileName(fileName);
        if (this.fileUtilCallback.getFileInInternalStorage(asDecryptedJSA(strDecodeFileName)).exists() || this.fileUtilCallback.getFileInInternalStorage(strDecodeFileName).exists()) {
            return true;
        }
        try {
            this.fileUtilCallback.getAssetFileAsInputStream(getUnzippedFileName(fileName));
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @Nullable
    public final String readFileForHyperSDK(@NotNull String fileName) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        String unzippedFileName = getUnzippedFileName(fileName);
        String fileFromInternalStorage = readFileFromInternalStorage(unzippedFileName);
        if (fileFromInternalStorage == null) {
            fileFromInternalStorage = readFileFromAssets(unzippedFileName);
        }
        return fileFromInternalStorage == null ? "" : fileFromInternalStorage;
    }

    @Nullable
    public final String readFileFromInternalStorage(@NotNull String fileName) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        try {
            return new String(this.fileUtilCallback.readFileFromInternalStorage(asDecryptedJSA(decodeFileName(fileName))), Charsets.UTF_8);
        } catch (FileNotFoundException unused) {
            this.fileUtilCallback.resetMetadata(fileName);
            return null;
        } catch (Exception unused2) {
            return null;
        }
    }

    @Nullable
    public final byte[] verifyFileForHyperSDK(@Nullable byte[] bArr, @NotNull String fileName) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        return !StringsKt.r(fileName, ".zip", false) ? bArr : unzipAndVerify(bArr, fileName, this.fileUtilCallback.getFileInAssets("remoteAssetPublicKey"));
    }
}
