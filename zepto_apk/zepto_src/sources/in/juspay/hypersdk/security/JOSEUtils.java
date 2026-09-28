package in.juspay.hypersdk.security;

import android.support.v4.media.b;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import androidx.fragment.app.e;
import in.juspay.hypersdk.core.Constants;
import in.juspay.hypersdk.core.PaymentConstants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public class JOSEUtils {
    @Nullable
    public static RSAPublicKey JWKtoRSAPublicKey(JSONObject jSONObject) {
        return (RSAPublicKey) KeyFactory.getInstance(Constants.ALG_RSA).generatePublic(new RSAPublicKeySpec(new BigInteger(1, Base64Codec.decode(jSONObject.getString("n"))), new BigInteger(1, Base64Codec.decode(jSONObject.getString("e")))));
    }

    public static void assertIfMatches(String str, String str2) throws Exception {
        if (!str.equals(str2)) {
            throw new Exception(e.p("Assert failed, org=", str, ", expected=", str2));
        }
    }

    public static void assertIfSupportedEncAlg(String str) throws Exception {
        str.getClass();
        switch (str) {
            case "RSA1_5":
            case "RSA-OAEP-256-MGF1-SHA1":
            case "RSA-OAEP-256":
            case "RSA-OAEP":
                return;
            default:
                throw new Exception("Not supported signing alg ".concat(str));
        }
    }

    public static void assertIfSupportedSigningAlg(String str) throws Exception {
        str.getClass();
        if (!str.equals("RS256") && !str.equals("RS512")) {
            throw new Exception("Not supported signing alg ".concat(str));
        }
    }

    public static byte[] concat(byte[]... bArr) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                for (byte[] bArr2 : bArr) {
                    if (bArr2 != null) {
                        byteArrayOutputStream.write(bArr2);
                    }
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            } finally {
            }
        } catch (IOException e2) {
            throw new IllegalStateException(e2.getMessage(), e2);
        }
    }

    public static String constructPayload(HashMap<String, Object> map) {
        if (!map.containsKey("headers") || !map.containsKey("encryptedKey") || !map.containsKey("iv") || !map.containsKey("cipherText") || !map.containsKey("authTag")) {
            return null;
        }
        String str = (String) map.get("headers");
        String str2 = (String) map.get("encryptedKey");
        String str3 = (String) map.get("iv");
        byte[] bArr = (byte[]) map.get("cipherText");
        String str4 = (String) map.get("authTag");
        if (str == null || str2 == null || str3 == null || bArr == null || str4 == null) {
            return null;
        }
        return str + CLConstants.DOT_SALT_DELIMETER + str2 + CLConstants.DOT_SALT_DELIMETER + str3 + CLConstants.DOT_SALT_DELIMETER + Base64Codec.encodeToString(bArr, true) + CLConstants.DOT_SALT_DELIMETER + str4;
    }

    @Keep
    public static JSONObject decodeJwsPayload(String str) throws Exception {
        String[] strArrSplit = str.split("\\.");
        if (strArrSplit.length != 3) {
            throw new Exception("JWS Decode - mandatory params missing " + strArrSplit.length);
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("headers", new String(Base64Codec.decode(strArrSplit[0])));
        jSONObject.put(PaymentConstants.PAYLOAD, new String(Base64Codec.decode(strArrSplit[1])));
        return jSONObject;
    }

    public static String extractKey(String str, String str2) throws Exception {
        JSONObject jSONObject = new JSONObject(str2);
        if (jSONObject.has(str)) {
            return jSONObject.getString(str);
        }
        throw new Exception(b.C("JWS Sign - header missing ", str));
    }

    public static String getJavaAlg(String str) throws Exception {
        str.getClass();
        switch (str) {
            case "RSA1_5":
                return "RSA/ECB/PKCS1Padding";
            case "RSA-OAEP-256-MGF1-SHA1":
            case "RSA-OAEP-256":
                return "RSA/ECB/OAEPWithSHA-256AndMGF1Padding";
            case "RSA-OAEP":
                return "RSA/ECB/OAEPWithSHA-1AndMGF1Padding";
            case "RS256":
                return "SHA256withRSA";
            case "RS512":
                return "SHA512withRSA";
            default:
                throw new Exception("Not supported signing alg ".concat(str));
        }
    }

    public static JSONObject jweDecrypt(String str, PrivateKey privateKey) throws Exception {
        GCMParameterSpec gCMParameterSpec;
        String[] strArrSplit = str.split("\\.");
        String str2 = new String(Base64Codec.decode(strArrSplit[0]));
        String strExtractKey = extractKey("alg", str2);
        assertIfSupportedEncAlg(strExtractKey);
        assertIfMatches(extractKey("enc", str2), "A256GCM");
        new SecureRandom().nextBytes(new byte[2048]);
        String str3 = strArrSplit[1];
        Cipher cipher = Cipher.getInstance(getJavaAlg(strExtractKey));
        cipher.init(2, privateKey);
        SecretKeySpec secretKeySpec = new SecretKeySpec(cipher.doFinal(Base64Codec.decode(str3)), CLConstants.AES_KEY_VAULT_KEY);
        byte[] bytes = Base64Codec.encodeToString(str2.getBytes(StandardCharsets.UTF_8), true).getBytes(StandardCharsets.US_ASCII);
        SecretKeySpec secretKeySpec2 = new SecretKeySpec(secretKeySpec.getEncoded(), CLConstants.AES_KEY_VAULT_KEY);
        Cipher cipher2 = Cipher.getInstance("AES/GCM/NoPadding");
        try {
            gCMParameterSpec = new GCMParameterSpec(128, Base64Codec.decode(strArrSplit[2]));
        } catch (Exception unused) {
            gCMParameterSpec = new GCMParameterSpec(128, Base64Codec.decode(strArrSplit[2]));
        }
        cipher2.init(2, secretKeySpec2, gCMParameterSpec);
        cipher2.updateAAD(bytes);
        byte[] bArrDoFinal = cipher2.doFinal(concat(Base64Codec.decode(strArrSplit[3]), Base64Codec.decode(strArrSplit[4])));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("headers", str2);
        jSONObject.put(PaymentConstants.PAYLOAD, new String(bArrDoFinal));
        return jSONObject;
    }

    public static String jweEncrypt(String str, String str2, byte[] bArr) {
        return constructPayload(jweEncrypt(str.getBytes(StandardCharsets.UTF_8), str2, (RSAPublicKey) KeyFactory.getInstance(Constants.ALG_RSA).generatePublic(new X509EncodedKeySpec(bArr))));
    }

    public static String jwsSign(String str, String str2, PrivateKey privateKey) {
        StringBuilder sb = new StringBuilder();
        Charset charset = StandardCharsets.UTF_8;
        sb.append(Base64Codec.encodeToString(str2.getBytes(charset), true));
        sb.append(CLConstants.DOT_SALT_DELIMETER);
        sb.append(Base64Codec.encodeToString(str.getBytes(charset), true));
        String string = sb.toString();
        String strExtractKey = extractKey("alg", str2);
        assertIfSupportedSigningAlg(strExtractKey);
        Signature signature = Signature.getInstance(getJavaAlg(strExtractKey));
        signature.initSign(privateKey);
        signature.update(string.getBytes(charset));
        byte[] bArrSign = signature.sign();
        StringBuilder sbX = b.x(string, CLConstants.DOT_SALT_DELIMETER);
        sbX.append(Base64Codec.encodeToString(bArrSign, true));
        return sbX.toString();
    }

    public static boolean jwsVerify(String str, byte[] bArr) {
        return jwsVerify(str, (RSAPublicKey) KeyFactory.getInstance(Constants.ALG_RSA).generatePublic(new X509EncodedKeySpec(bArr)));
    }

    public static byte[] subArray(byte[] bArr, int i2, int i3) {
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i2, bArr2, 0, i3);
        return bArr2;
    }

    public static boolean jwsVerify(String str, RSAPublicKey rSAPublicKey) throws Exception {
        String[] strArrSplit = str.split("\\.");
        if (strArrSplit.length == 3) {
            String str2 = strArrSplit[0] + CLConstants.DOT_SALT_DELIMETER + strArrSplit[1];
            String strExtractKey = extractKey("alg", new String(Base64Codec.decode(strArrSplit[0])));
            assertIfSupportedSigningAlg(strExtractKey);
            Signature signature = Signature.getInstance(getJavaAlg(strExtractKey));
            signature.initVerify(rSAPublicKey);
            signature.update(str2.getBytes(StandardCharsets.UTF_8));
            return signature.verify(Base64Codec.decode(strArrSplit[2]));
        }
        throw new Exception("JWS Verify - mandatory params missing " + strArrSplit.length);
    }

    public static HashMap<String, Object> jweEncrypt(byte[] bArr, String str, RSAPublicKey rSAPublicKey) throws Exception {
        GCMParameterSpec gCMParameterSpec;
        byte[] iv;
        String strExtractKey = extractKey("alg", str);
        assertIfSupportedEncAlg(strExtractKey);
        assertIfMatches(extractKey("enc", str), "A256GCM");
        byte[] bArr2 = new byte[32];
        new SecureRandom().nextBytes(bArr2);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, CLConstants.AES_KEY_VAULT_KEY);
        Cipher cipher = Cipher.getInstance(getJavaAlg(strExtractKey));
        cipher.init(1, rSAPublicKey);
        String strEncodeToString = Base64Codec.encodeToString(cipher.doFinal(secretKeySpec.getEncoded()), true);
        byte[] bytes = Base64Codec.encodeToString(str.getBytes(StandardCharsets.UTF_8), true).getBytes(StandardCharsets.US_ASCII);
        byte[] bArr3 = new byte[12];
        new SecureRandom().nextBytes(bArr3);
        Cipher cipher2 = Cipher.getInstance("AES/GCM/NoPadding");
        try {
            gCMParameterSpec = new GCMParameterSpec(128, bArr3);
        } catch (Exception unused) {
            gCMParameterSpec = new GCMParameterSpec(128, bArr3);
        }
        cipher2.init(1, secretKeySpec, gCMParameterSpec);
        cipher2.updateAAD(bytes);
        byte[] bArrDoFinal = cipher2.doFinal(bArr);
        int length = bArrDoFinal.length - 16;
        byte[] bArrSubArray = subArray(bArrDoFinal, 0, length);
        byte[] bArrSubArray2 = subArray(bArrDoFinal, length, 16);
        try {
            iv = ((GCMParameterSpec) cipher2.getParameters().getParameterSpec(GCMParameterSpec.class)).getIV();
        } catch (Exception unused2) {
            iv = ((GCMParameterSpec) cipher2.getParameters().getParameterSpec(GCMParameterSpec.class)).getIV();
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("encryptedKey", strEncodeToString);
        map.put("iv", Base64Codec.encodeToString(iv, true));
        map.put("cipherText", bArrSubArray);
        map.put("authTag", Base64Codec.encodeToString(bArrSubArray2, true));
        map.put("headers", Base64Codec.encodeToString(str.getBytes(StandardCharsets.UTF_8), true));
        return map;
    }
}
