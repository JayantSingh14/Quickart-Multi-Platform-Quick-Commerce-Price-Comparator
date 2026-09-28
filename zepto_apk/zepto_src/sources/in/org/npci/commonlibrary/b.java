package in.org.npci.commonlibrary;

import in.juspay.hypersdk.core.Constants;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.npci.upi.security.pinactivitycomponent.q;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static List<g> f49184a;

    /* renamed from: b, reason: collision with root package name */
    private f f49185b;

    /* renamed from: c, reason: collision with root package name */
    private h f49186c;

    /* renamed from: d, reason: collision with root package name */
    private in.org.npci.commonlibrary.a.b f49187d;

    /* renamed from: e, reason: collision with root package name */
    private String f49188e = "";

    public b(String str) throws c {
        try {
            in.org.npci.commonlibrary.a.b bVar = new in.org.npci.commonlibrary.a.b();
            this.f49187d = bVar;
            if (!bVar.a(str)) {
                throw new c(d.KEYS_NOT_VALID);
            }
            h hVar = new h(str);
            this.f49186c = hVar;
            f49184a = hVar.a();
            try {
                this.f49185b = new f();
            } catch (NoSuchAlgorithmException | NoSuchPaddingException e2) {
                q.a("commonLibrary", e2);
                throw new c(d.UNKNOWN_ERROR);
            }
        } catch (c e3) {
            q.a("commonLibrary", e3);
            throw e3;
        } catch (Exception e4) {
            q.a("commonLibrary", e4);
            throw new c(d.UNKNOWN_ERROR);
        }
    }

    private String b(String str, String str2, String str3, String str4) throws c {
        StringBuilder sb = new StringBuilder(500);
        try {
            byte[] bArrB = this.f49185b.b();
            String strB = a.b(bArrB, 2);
            f fVar = this.f49185b;
            String strB2 = a.b(fVar.a(fVar.a(str3, strB), this.f49185b.a(str4), bArrB), 2);
            sb.append(str2);
            sb.append(CLConstants.SALT_DELIMETER);
            sb.append(str);
            sb.append(CLConstants.SALT_DELIMETER);
            sb.append(strB2);
            sb.append(CLConstants.SALT_DELIMETER);
            sb.append(strB);
            return sb.toString();
        } catch (Exception e2) {
            q.a("commonLibrary", e2);
            throw new c(d.UNKNOWN_ERROR);
        }
    }

    public Message a(String str, String str2, String str3, String str4, String str5, Boolean bool) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, c, InvalidAlgorithmParameterException {
        String strB;
        if (str != null && str.isEmpty()) {
            throw new c(d.KEY_CODE_EMPTY);
        }
        ArrayList arrayList = new ArrayList();
        for (g gVar : f49184a) {
            if (gVar.b().equals(str)) {
                arrayList.add(gVar);
            }
        }
        if (arrayList.size() == 0) {
            throw new c(d.KEY_CODE_INVALID);
        }
        g gVar2 = (g) arrayList.get(new SecureRandom().nextInt(arrayList.size()));
        this.f49188e = gVar2.c();
        String strB2 = b(str2, str3, str4, str5);
        if (bool.booleanValue()) {
            byte[] encoded = this.f49185b.a().getEncoded();
            byte[] bArrB = this.f49185b.b();
            String strB3 = a.b(bArrB, 2);
            byte[] bArrA = this.f49185b.a(strB2.getBytes(), encoded, bArrB);
            strB = a.a("eyJhbGciOiJSU0EtT0FFUCIsImVuYyI6IkEyNTZHQ00ifQ." + a.b(a(a.b(encoded, 0)), 2) + CLConstants.DOT_SALT_DELIMETER + strB3 + CLConstants.DOT_SALT_DELIMETER + a.b(bArrA, 2));
        } else {
            strB = a.b(a(strB2), 2);
        }
        return new Message("", "", new Data(gVar2.a(), gVar2.b(), strB));
    }

    private PublicKey b(String str) {
        return KeyFactory.getInstance(Constants.ALG_RSA).generatePublic(new X509EncodedKeySpec(a.a(str.getBytes("utf-8"), 2)));
    }

    public String a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        try {
            byte[] bArrB = this.f49185b.b();
            String strB = a.b(bArrB, 2);
            byte[] bArrA = this.f49185b.a(str, strB);
            f fVar = this.f49185b;
            String strB2 = a.b(fVar.a(bArrA, fVar.a(str2), bArrB), 2);
            SecretKey secretKeyA = this.f49185b.a();
            String strB3 = a.b(this.f49185b.a(str.getBytes(), secretKeyA.getEncoded(), bArrB), 2);
            String strA = this.f49185b.a(a.b(secretKeyA.getEncoded(), 2), i.a());
            sb.append(strB2);
            sb.append(CLConstants.SALT_DELIMETER);
            sb.append(strB3);
            sb.append(CLConstants.SALT_DELIMETER);
            sb.append(strA);
            sb.append(CLConstants.SALT_DELIMETER);
            sb.append(strB);
        } catch (Exception e2) {
            q.a("commonLibrary", e2);
        }
        return sb.toString();
    }

    public void a(String str, String str2, String str3, String str4) throws c {
        try {
            f fVar = new f();
            byte[] bArrA = a.a(str4, 2);
            String strB = a.b(fVar.a(str2, str4), 2);
            String strB2 = a.b(fVar.b(a.a(str, 2), fVar.a(str3), bArrA), 2);
            if (strB2 != null && !strB2.equalsIgnoreCase(strB)) {
                throw new c(d.TRUST_NOT_VALID);
            }
        } catch (UnsupportedEncodingException e2) {
            e = e2;
            q.a("commonLibrary", e);
            throw new c(d.UNKNOWN_ERROR);
        } catch (InvalidAlgorithmParameterException e3) {
            e = e3;
            q.a("commonLibrary", e);
            throw new c(d.UNKNOWN_ERROR);
        } catch (InvalidKeyException e4) {
            e = e4;
            q.a("commonLibrary", e);
            throw new c(d.UNKNOWN_ERROR);
        } catch (NoSuchAlgorithmException e5) {
            e = e5;
            q.a("commonLibrary", e);
            throw new c(d.UNKNOWN_ERROR);
        } catch (BadPaddingException e6) {
            e = e6;
            q.a("commonLibrary", e);
            throw new c(d.UNKNOWN_ERROR);
        } catch (IllegalBlockSizeException e7) {
            e = e7;
            q.a("commonLibrary", e);
            throw new c(d.UNKNOWN_ERROR);
        } catch (NoSuchPaddingException e8) {
            e = e8;
            q.a("commonLibrary", e);
            throw new c(d.UNKNOWN_ERROR);
        } catch (Exception e9) {
            q.a("commonLibrary", e9);
            throw new c(d.UNKNOWN_ERROR);
        }
    }

    public byte[] a(String str) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        byte[] bytes = str.getBytes();
        try {
            PublicKey publicKeyB = b(this.f49188e);
            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPwithSHA-256andMGF1Padding");
            cipher.init(1, publicKeyB, new OAEPParameterSpec(MessageDigestAlgorithms.SHA_256, "MGF1", MGF1ParameterSpec.SHA256, PSource.PSpecified.DEFAULT));
            return cipher.doFinal(bytes);
        } catch (Exception e2) {
            q.a("commonLibrary", e2);
            return null;
        }
    }
}
