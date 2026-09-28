package in.juspay.hypersdk.security;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import in.juspay.hyper.core.JuspayLogger;
import in.juspay.hypersdk.core.SdkTracker;
import in.juspay.hypersdk.utils.Utils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.DigestInputStream;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

@Keep
/* loaded from: classes4.dex */
public class EncryptionHelper {
    public static final String ENCRYPTED_VERSION = "v1";
    private static final String LOG_TAG = "EncryptionHelper";
    private static final String algorithm = "AES";
    private static final byte[] logsEntryRequirement = {-52, 51, -68, -121, -44, -114, -59, -20, -79, 22, 34, -77, -48, -75, 45, 93};

    @NonNull
    public static String bytesToHexString(@NonNull byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static byte[] decryptThenGunzip(byte[] bArr, String str) {
        try {
            return gunzipContent(v1Decrypt(bArr));
        } catch (Exception e2) {
            SdkTracker.trackAndLogBootException(LOG_TAG, "action", "system", "helper", "Exception in decrypting", e2);
            throw new RuntimeException(e2);
        }
    }

    private static Key generateKey() throws IOException {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(logsEntryRequirement);
            try {
                int iAvailable = byteArrayInputStream.available();
                byte[] bArr = new byte[iAvailable];
                int i2 = 0;
                do {
                    i2 += byteArrayInputStream.read(bArr);
                } while (i2 < iAvailable);
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
                byteArrayInputStream.close();
                return secretKeySpec;
            } finally {
            }
        } catch (IOException e2) {
            SdkTracker.trackAndLogBootException(LOG_TAG, "sdk", "system", "generate_key", null, e2);
            return null;
        }
    }

    @NonNull
    private static KeyStore getAndroidKeyStore() throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
        keyStore.load(null);
        return keyStore;
    }

    @NonNull
    public static KeyPair getKeyPair(String str) {
        KeyStore androidKeyStore = getAndroidKeyStore();
        return new KeyPair(androidKeyStore.getCertificate(str).getPublicKey(), (PrivateKey) androidKeyStore.getKey(str, null));
    }

    @Keep
    public static String getSHA256Hash(@Nullable String str) throws NoSuchAlgorithmException {
        if (str == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
            messageDigest.update(str.getBytes());
            String strBytesToHexString = bytesToHexString(messageDigest.digest());
            JuspayLogger.d(LOG_TAG, "result is " + strBytesToHexString);
            return strBytesToHexString;
        } catch (NoSuchAlgorithmException e2) {
            SdkTracker.trackAndLogBootException(LOG_TAG, "action", "system", "helper", "Exception caught trying to SHA-256 hash", e2);
            return null;
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
            SdkTracker.trackAndLogBootException(LOG_TAG, "action", "system", "helper", "Error while gunzipping", e2);
            throw new RuntimeException(e2);
        }
    }

    public static byte[] gzipThenEncrypt(byte[] bArr, RSAPublicKey rSAPublicKey) {
        try {
            String strConstructPayload = JOSEUtils.constructPayload(JOSEUtils.jweEncrypt(Utils.gzipContent(bArr), "{\"alg\":\"RSA-OAEP-256\",\"enc\":\"A256GCM\"}", rSAPublicKey));
            if (strConstructPayload != null) {
                return strConstructPayload.getBytes(StandardCharsets.UTF_8);
            }
            return null;
        } catch (Exception e2) {
            SdkTracker.trackAndLogBootException(LOG_TAG, "action", "system", "helper", "Exception while GZipping and encrypting", e2);
            return null;
        }
    }

    public static byte[] gzipThenEncryptExp(byte[] bArr, RSAPublicKey rSAPublicKey, Map<String, String> map) {
        try {
            HashMap<String, Object> mapJweEncrypt = JOSEUtils.jweEncrypt(Utils.gzipContent(bArr), "{\"alg\":\"RSA-OAEP-256\",\"enc\":\"A256GCM\"}", rSAPublicKey);
            if (mapJweEncrypt.containsKey("headers") && mapJweEncrypt.containsKey("encryptedKey") && mapJweEncrypt.containsKey("iv") && mapJweEncrypt.containsKey("cipherText") && mapJweEncrypt.containsKey("authTag")) {
                String str = (String) mapJweEncrypt.get("headers");
                String str2 = (String) mapJweEncrypt.get("encryptedKey");
                String str3 = (String) mapJweEncrypt.get("iv");
                byte[] bArr2 = (byte[]) mapJweEncrypt.get("cipherText");
                String str4 = (String) mapJweEncrypt.get("authTag");
                if (str != null && str2 != null && str3 != null && bArr2 != null && str4 != null) {
                    map.put("protectedHeaders", str);
                    map.put("encryptedKey", str2);
                    map.put("iv", str3);
                    map.put("authTag", str4);
                    return bArr2;
                }
            }
            return null;
        } catch (Exception e2) {
            SdkTracker.trackAndLogBootException(LOG_TAG, "action", "system", "helper", "Exception while GZipping and encrypting", e2);
            return null;
        }
    }

    public static String md5(String str) {
        return md5(str.getBytes());
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

    public static byte[] v1Encrypt(byte[] bArr) {
        byte[] bArrGzipContent = Utils.gzipContent(bArr);
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

    public static String md5(byte[] bArr) throws NoSuchAlgorithmException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            messageDigest.update(bArr);
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b2 : bArrDigest) {
                StringBuilder sb2 = new StringBuilder(Integer.toHexString(b2 & 255));
                while (sb2.length() < 2) {
                    sb2.insert(0, "0");
                }
                sb.append((CharSequence) sb2);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e2) {
            SdkTracker.trackAndLogBootException(LOG_TAG, "action", "system", "helper", "Exception trying to calculate md5sum from given string", e2);
            return null;
        }
    }

    public static String md5(InputStream inputStream) throws IOException {
        try {
            DigestInputStream digestInputStream = new DigestInputStream(inputStream, MessageDigest.getInstance(MessageDigestAlgorithms.MD5));
            do {
                try {
                } finally {
                }
            } while (digestInputStream.read() != -1);
            byte[] bArrDigest = digestInputStream.getMessageDigest().digest();
            digestInputStream.close();
            StringBuilder sb = new StringBuilder();
            for (byte b2 : bArrDigest) {
                StringBuilder sb2 = new StringBuilder(Integer.toHexString(b2 & 255));
                while (sb2.length() < 2) {
                    sb2.insert(0, "0");
                }
                sb.append((CharSequence) sb2);
            }
            return sb.toString();
        } catch (IOException | NoSuchAlgorithmException e2) {
            SdkTracker.trackAndLogBootException(LOG_TAG, "action", "system", "helper", "Exception trying to get md5sum from input stream", e2);
            return null;
        }
    }
}
