package org.apache.xml.security.algorithms;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.HashMap;
import java.util.Map;
import org.apache.xml.security.signature.XMLSignatureException;
import org.w3c.dom.Document;

/* loaded from: classes5.dex */
public class MessageDigestAlgorithm extends Algorithm {

    /* renamed from: b, reason: collision with root package name */
    static ThreadLocal f57093b = new ThreadLocal() { // from class: org.apache.xml.security.algorithms.MessageDigestAlgorithm.1
        @Override // java.lang.ThreadLocal
        public Object initialValue() {
            return new HashMap();
        }
    };

    /* renamed from: a, reason: collision with root package name */
    MessageDigest f57094a;

    private MessageDigestAlgorithm(Document document, MessageDigest messageDigest, String str) {
        super(document, str);
        this.f57094a = messageDigest;
    }

    public static MessageDigestAlgorithm a(Document document, String str) {
        return new MessageDigestAlgorithm(document, b(str), str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [java.lang.Object, java.security.MessageDigest] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.String] */
    private static MessageDigest b(String str) throws XMLSignatureException {
        MessageDigest messageDigest = (MessageDigest) ((Map) f57093b.get()).get(str);
        if (messageDigest != null) {
            return messageDigest;
        }
        Object objA = JCEMapper.a(str);
        if (objA == 0) {
            throw new XMLSignatureException("algorithms.NoSuchMap", new Object[]{str});
        }
        String strA = JCEMapper.a();
        try {
            objA = strA == null ? MessageDigest.getInstance(objA) : MessageDigest.getInstance((String) objA, strA);
            ((Map) f57093b.get()).put(str, objA);
            return objA;
        } catch (NoSuchAlgorithmException e2) {
            throw new XMLSignatureException("algorithms.NoSuchAlgorithm", new Object[]{objA, e2.getLocalizedMessage()});
        } catch (NoSuchProviderException e3) {
            throw new XMLSignatureException("algorithms.NoSuchAlgorithm", new Object[]{objA, e3.getLocalizedMessage()});
        }
    }

    public void c() {
        this.f57094a.reset();
    }

    @Override // org.apache.xml.security.utils.SignatureElementProxy, org.apache.xml.security.utils.ElementProxy
    public String d() {
        return "http://www.w3.org/2000/09/xmldsig#";
    }

    @Override // org.apache.xml.security.utils.ElementProxy
    public String e() {
        return "DigestMethod";
    }

    public void a(byte b2) {
        this.f57094a.update(b2);
    }

    public byte[] b() {
        return this.f57094a.digest();
    }

    public void a(byte[] bArr, int i2, int i3) {
        this.f57094a.update(bArr, i2, i3);
    }

    public static boolean a(byte[] bArr, byte[] bArr2) {
        return MessageDigest.isEqual(bArr, bArr2);
    }
}
