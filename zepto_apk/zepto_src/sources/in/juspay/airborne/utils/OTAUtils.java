package in.juspay.airborne.utils;

import android.util.Base64;
import android.util.Log;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes4.dex */
public final class OTAUtils {

    @NotNull
    private static final String LOG_TAG = "OTAUtils";

    @NotNull
    public static final OTAUtils INSTANCE = new OTAUtils();

    @NotNull
    private static final ThreadPoolExecutor sharedPool = new ThreadPoolExecutor(6, 10, 5, TimeUnit.SECONDS, new LinkedBlockingQueue());

    private OTAUtils() {
    }

    @JvmStatic
    public static final boolean deleteRecursive(@NotNull File fileOrDirectory) {
        Intrinsics.checkNotNullParameter(fileOrDirectory, "fileOrDirectory");
        if (!fileOrDirectory.exists()) {
            return false;
        }
        if (fileOrDirectory.isDirectory()) {
            File[] fileArrListFiles = fileOrDirectory.listFiles();
            if (fileArrListFiles == null) {
                fileArrListFiles = new File[0];
            }
            for (File child : fileArrListFiles) {
                Intrinsics.checkNotNullExpressionValue(child, "child");
                if (!deleteRecursive(child)) {
                    return false;
                }
            }
        }
        return fileOrDirectory.delete();
    }

    @JvmStatic
    @Nullable
    public static final String md5(@NotNull byte[] bytes) throws NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            messageDigest.update(bytes);
            byte[] messageDigest2 = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            Intrinsics.checkNotNullExpressionValue(messageDigest2, "messageDigest");
            for (byte b2 : messageDigest2) {
                StringBuilder sb2 = new StringBuilder(Integer.toHexString(b2 & 255));
                while (sb2.length() < 2) {
                    sb2.insert(0, "0");
                }
                sb.append((CharSequence) sb2);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    @JvmStatic
    public static final boolean validatePinning(@NotNull X509Certificate[] chain, @NotNull Set<String> validPins) throws NoSuchAlgorithmException, CertificateException {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Intrinsics.checkNotNullParameter(validPins, "validPins");
        StringBuilder sb = new StringBuilder();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
            Intrinsics.checkNotNullExpressionValue(messageDigest, "getInstance(\"SHA-256\")");
            if (chain.length <= 0) {
                Log.d(LOG_TAG, sb.toString());
                return true;
            }
            X509Certificate x509Certificate = chain[0];
            byte[] encoded = x509Certificate.getPublicKey().getEncoded();
            messageDigest.update(encoded, 0, encoded.length);
            String strEncodeToString = Base64.encodeToString(messageDigest.digest(), 2);
            sb.append("    sha256/");
            sb.append(strEncodeToString);
            sb.append(" : ");
            sb.append(x509Certificate.getSubjectDN().toString());
            sb.append(StringUtils.LF);
            return !validPins.contains(strEncodeToString);
        } catch (NoSuchAlgorithmException unused) {
            throw new CertificateException("couldn't create digest");
        }
    }

    @NotNull
    public final <V> Future<V> doAsync(@NotNull Callable<V> callable) {
        Intrinsics.checkNotNullParameter(callable, "callable");
        Future<V> futureSubmit = sharedPool.submit(callable);
        Intrinsics.checkNotNullExpressionValue(futureSubmit, "sharedPool.submit(callable)");
        return futureSubmit;
    }

    public final void runOnBackgroundThread(@Nullable Runnable runnable) {
        sharedPool.execute(runnable);
    }
}
