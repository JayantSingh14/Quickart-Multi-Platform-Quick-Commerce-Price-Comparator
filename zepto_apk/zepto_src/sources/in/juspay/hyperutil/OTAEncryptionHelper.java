package in.juspay.hyperutil;

import androidx.annotation.Keep;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

@Keep
/* loaded from: classes4.dex */
public class OTAEncryptionHelper {
    public static final String ENCRYPTED_VERSION = "v1";
    public static TrackerCallback trackerCallback;

    public static byte[] decryptThenGunzip(byte[] bArr, String str) {
        try {
            return gunzipContent(v1Decrypt(bArr));
        } catch (Exception e2) {
            trackException("action", "system", "helper", "Exception in decrypting", e2);
            throw new RuntimeException(e2);
        }
    }

    public static byte[] gunzipContent(byte[] bArr) throws IOException {
        byte[] bArr2 = new byte[1024];
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream, 1024);
                    while (true) {
                        try {
                            int i2 = gZIPInputStream.read(bArr2);
                            if (i2 == -1) {
                                gZIPInputStream.close();
                                byte[] byteArray = byteArrayOutputStream.toByteArray();
                                byteArrayOutputStream.close();
                                byteArrayInputStream.close();
                                return byteArray;
                            }
                            byteArrayOutputStream.write(bArr2, 0, i2);
                        } finally {
                        }
                    }
                } finally {
                }
            } finally {
            }
        } catch (IOException e2) {
            trackException("action", "system", "helper", "Error while gunzipping", e2);
            throw new RuntimeException(e2);
        }
    }

    private static byte[] gzipContent(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            try {
                gZIPOutputStream.write(bArr);
                gZIPOutputStream.finish();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                gZIPOutputStream.close();
                byteArrayOutputStream.close();
                return byteArray;
            } finally {
            }
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static void trackException(String str, String str2, String str3, String str4, Throwable th) {
        TrackerCallback trackerCallback2 = trackerCallback;
        if (trackerCallback2 != null) {
            trackerCallback2.trackException(str, str2, str3, str4, th);
        }
    }

    public static byte[] v1Decrypt(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length - 8];
        int length = bArr.length;
        byte[] bArr3 = {bArr[9], bArr[19], bArr[29], bArr[39], bArr[49], bArr[59], bArr[69], bArr[79]};
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            if (i4 % 10 != 9 || i2 >= 8) {
                bArr2[i3] = (byte) (bArr[i4] ^ bArr3[i3 % 8]);
                i3++;
            } else {
                i2++;
            }
        }
        return bArr2;
    }

    public static byte[] v1Encrypt(byte[] bArr) throws Exception {
        byte[] bArrGzipContent = gzipContent(bArr);
        byte[] bArr2 = new byte[8];
        new SecureRandom().nextBytes(bArr2);
        int length = bArrGzipContent.length;
        int i2 = length + 8;
        byte[] bArr3 = new byte[i2];
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i3 < length && i5 < i2; i5++) {
            if (i5 % 10 != 9 || i4 >= 8) {
                bArr3[i5] = (byte) (bArrGzipContent[i3] ^ bArr2[i3 % 8]);
                i3++;
            } else {
                bArr3[i5] = bArr2[i4];
                i4++;
            }
        }
        return bArr3;
    }
}
