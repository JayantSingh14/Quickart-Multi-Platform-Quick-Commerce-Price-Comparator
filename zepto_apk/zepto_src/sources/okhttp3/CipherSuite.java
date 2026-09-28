package okhttp3;

import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: classes.dex */
public final class CipherSuite {

    /* renamed from: b, reason: collision with root package name */
    public static final Companion f56197b;

    /* renamed from: c, reason: collision with root package name */
    public static final CipherSuite$Companion$ORDER_BY_NAME$1 f56198c;

    /* renamed from: d, reason: collision with root package name */
    public static final LinkedHashMap f56199d;

    /* renamed from: e, reason: collision with root package name */
    public static final CipherSuite f56200e;

    /* renamed from: f, reason: collision with root package name */
    public static final CipherSuite f56201f;

    /* renamed from: g, reason: collision with root package name */
    public static final CipherSuite f56202g;

    /* renamed from: h, reason: collision with root package name */
    public static final CipherSuite f56203h;

    /* renamed from: i, reason: collision with root package name */
    public static final CipherSuite f56204i;

    /* renamed from: j, reason: collision with root package name */
    public static final CipherSuite f56205j;

    /* renamed from: k, reason: collision with root package name */
    public static final CipherSuite f56206k;

    /* renamed from: l, reason: collision with root package name */
    public static final CipherSuite f56207l;

    /* renamed from: m, reason: collision with root package name */
    public static final CipherSuite f56208m;
    public static final CipherSuite n;
    public static final CipherSuite o;
    public static final CipherSuite p;
    public static final CipherSuite q;
    public static final CipherSuite r;
    public static final CipherSuite s;
    public static final CipherSuite t;

    /* renamed from: a, reason: collision with root package name */
    public final String f56209a;

    @Metadata
    public static final class Companion {
        public static final CipherSuite a(Companion companion, String str) {
            CipherSuite cipherSuite = new CipherSuite(str);
            CipherSuite.f56199d.put(str, cipherSuite);
            return cipherSuite;
        }

        public static String c(String str) {
            if (StringsKt.O(str, "TLS_", false)) {
                StringBuilder sb = new StringBuilder("SSL_");
                String strSubstring = str.substring(4);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
                sb.append(strSubstring);
                return sb.toString();
            }
            if (!StringsKt.O(str, "SSL_", false)) {
                return str;
            }
            StringBuilder sb2 = new StringBuilder("TLS_");
            String strSubstring2 = str.substring(4);
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String).substring(startIndex)");
            sb2.append(strSubstring2);
            return sb2.toString();
        }

        public final synchronized CipherSuite b(String javaName) {
            CipherSuite cipherSuite;
            try {
                Intrinsics.checkNotNullParameter(javaName, "javaName");
                LinkedHashMap linkedHashMap = CipherSuite.f56199d;
                cipherSuite = (CipherSuite) linkedHashMap.get(javaName);
                if (cipherSuite == null) {
                    cipherSuite = (CipherSuite) linkedHashMap.get(c(javaName));
                    if (cipherSuite == null) {
                        cipherSuite = new CipherSuite(javaName);
                    }
                    linkedHashMap.put(javaName, cipherSuite);
                }
            } catch (Throwable th) {
                throw th;
            }
            return cipherSuite;
        }
    }

    static {
        Companion companion = new Companion();
        f56197b = companion;
        f56198c = new CipherSuite$Companion$ORDER_BY_NAME$1();
        f56199d = new LinkedHashMap();
        Companion.a(companion, "SSL_RSA_WITH_NULL_MD5");
        Companion.a(companion, "SSL_RSA_WITH_NULL_SHA");
        Companion.a(companion, "SSL_RSA_EXPORT_WITH_RC4_40_MD5");
        Companion.a(companion, "SSL_RSA_WITH_RC4_128_MD5");
        Companion.a(companion, "SSL_RSA_WITH_RC4_128_SHA");
        Companion.a(companion, "SSL_RSA_EXPORT_WITH_DES40_CBC_SHA");
        Companion.a(companion, "SSL_RSA_WITH_DES_CBC_SHA");
        f56200e = Companion.a(companion, "SSL_RSA_WITH_3DES_EDE_CBC_SHA");
        Companion.a(companion, "SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA");
        Companion.a(companion, "SSL_DHE_DSS_WITH_DES_CBC_SHA");
        Companion.a(companion, "SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA");
        Companion.a(companion, "SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA");
        Companion.a(companion, "SSL_DHE_RSA_WITH_DES_CBC_SHA");
        Companion.a(companion, "SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA");
        Companion.a(companion, "SSL_DH_anon_EXPORT_WITH_RC4_40_MD5");
        Companion.a(companion, "SSL_DH_anon_WITH_RC4_128_MD5");
        Companion.a(companion, "SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA");
        Companion.a(companion, "SSL_DH_anon_WITH_DES_CBC_SHA");
        Companion.a(companion, "SSL_DH_anon_WITH_3DES_EDE_CBC_SHA");
        Companion.a(companion, "TLS_KRB5_WITH_DES_CBC_SHA");
        Companion.a(companion, "TLS_KRB5_WITH_3DES_EDE_CBC_SHA");
        Companion.a(companion, "TLS_KRB5_WITH_RC4_128_SHA");
        Companion.a(companion, "TLS_KRB5_WITH_DES_CBC_MD5");
        Companion.a(companion, "TLS_KRB5_WITH_3DES_EDE_CBC_MD5");
        Companion.a(companion, "TLS_KRB5_WITH_RC4_128_MD5");
        Companion.a(companion, "TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA");
        Companion.a(companion, "TLS_KRB5_EXPORT_WITH_RC4_40_SHA");
        Companion.a(companion, "TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5");
        Companion.a(companion, "TLS_KRB5_EXPORT_WITH_RC4_40_MD5");
        f56201f = Companion.a(companion, "TLS_RSA_WITH_AES_128_CBC_SHA");
        Companion.a(companion, "TLS_DHE_DSS_WITH_AES_128_CBC_SHA");
        Companion.a(companion, "TLS_DHE_RSA_WITH_AES_128_CBC_SHA");
        Companion.a(companion, "TLS_DH_anon_WITH_AES_128_CBC_SHA");
        f56202g = Companion.a(companion, "TLS_RSA_WITH_AES_256_CBC_SHA");
        Companion.a(companion, "TLS_DHE_DSS_WITH_AES_256_CBC_SHA");
        Companion.a(companion, "TLS_DHE_RSA_WITH_AES_256_CBC_SHA");
        Companion.a(companion, "TLS_DH_anon_WITH_AES_256_CBC_SHA");
        Companion.a(companion, "TLS_RSA_WITH_NULL_SHA256");
        Companion.a(companion, "TLS_RSA_WITH_AES_128_CBC_SHA256");
        Companion.a(companion, "TLS_RSA_WITH_AES_256_CBC_SHA256");
        Companion.a(companion, "TLS_DHE_DSS_WITH_AES_128_CBC_SHA256");
        Companion.a(companion, "TLS_RSA_WITH_CAMELLIA_128_CBC_SHA");
        Companion.a(companion, "TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA");
        Companion.a(companion, "TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA");
        Companion.a(companion, "TLS_DHE_RSA_WITH_AES_128_CBC_SHA256");
        Companion.a(companion, "TLS_DHE_DSS_WITH_AES_256_CBC_SHA256");
        Companion.a(companion, "TLS_DHE_RSA_WITH_AES_256_CBC_SHA256");
        Companion.a(companion, "TLS_DH_anon_WITH_AES_128_CBC_SHA256");
        Companion.a(companion, "TLS_DH_anon_WITH_AES_256_CBC_SHA256");
        Companion.a(companion, "TLS_RSA_WITH_CAMELLIA_256_CBC_SHA");
        Companion.a(companion, "TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA");
        Companion.a(companion, "TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA");
        Companion.a(companion, "TLS_PSK_WITH_RC4_128_SHA");
        Companion.a(companion, "TLS_PSK_WITH_3DES_EDE_CBC_SHA");
        Companion.a(companion, "TLS_PSK_WITH_AES_128_CBC_SHA");
        Companion.a(companion, "TLS_PSK_WITH_AES_256_CBC_SHA");
        Companion.a(companion, "TLS_RSA_WITH_SEED_CBC_SHA");
        f56203h = Companion.a(companion, "TLS_RSA_WITH_AES_128_GCM_SHA256");
        f56204i = Companion.a(companion, "TLS_RSA_WITH_AES_256_GCM_SHA384");
        Companion.a(companion, "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256");
        Companion.a(companion, "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384");
        Companion.a(companion, "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256");
        Companion.a(companion, "TLS_DHE_DSS_WITH_AES_256_GCM_SHA384");
        Companion.a(companion, "TLS_DH_anon_WITH_AES_128_GCM_SHA256");
        Companion.a(companion, "TLS_DH_anon_WITH_AES_256_GCM_SHA384");
        Companion.a(companion, "TLS_EMPTY_RENEGOTIATION_INFO_SCSV");
        Companion.a(companion, "TLS_FALLBACK_SCSV");
        Companion.a(companion, "TLS_ECDH_ECDSA_WITH_NULL_SHA");
        Companion.a(companion, "TLS_ECDH_ECDSA_WITH_RC4_128_SHA");
        Companion.a(companion, "TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA");
        Companion.a(companion, "TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA");
        Companion.a(companion, "TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA");
        Companion.a(companion, "TLS_ECDHE_ECDSA_WITH_NULL_SHA");
        Companion.a(companion, "TLS_ECDHE_ECDSA_WITH_RC4_128_SHA");
        Companion.a(companion, "TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA");
        Companion.a(companion, "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA");
        Companion.a(companion, "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA");
        Companion.a(companion, "TLS_ECDH_RSA_WITH_NULL_SHA");
        Companion.a(companion, "TLS_ECDH_RSA_WITH_RC4_128_SHA");
        Companion.a(companion, "TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA");
        Companion.a(companion, "TLS_ECDH_RSA_WITH_AES_128_CBC_SHA");
        Companion.a(companion, "TLS_ECDH_RSA_WITH_AES_256_CBC_SHA");
        Companion.a(companion, "TLS_ECDHE_RSA_WITH_NULL_SHA");
        Companion.a(companion, "TLS_ECDHE_RSA_WITH_RC4_128_SHA");
        Companion.a(companion, "TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA");
        f56205j = Companion.a(companion, "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA");
        f56206k = Companion.a(companion, "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA");
        Companion.a(companion, "TLS_ECDH_anon_WITH_NULL_SHA");
        Companion.a(companion, "TLS_ECDH_anon_WITH_RC4_128_SHA");
        Companion.a(companion, "TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA");
        Companion.a(companion, "TLS_ECDH_anon_WITH_AES_128_CBC_SHA");
        Companion.a(companion, "TLS_ECDH_anon_WITH_AES_256_CBC_SHA");
        Companion.a(companion, "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256");
        Companion.a(companion, "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384");
        Companion.a(companion, "TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256");
        Companion.a(companion, "TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384");
        Companion.a(companion, "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256");
        Companion.a(companion, "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384");
        Companion.a(companion, "TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256");
        Companion.a(companion, "TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384");
        f56207l = Companion.a(companion, "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256");
        f56208m = Companion.a(companion, "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384");
        Companion.a(companion, "TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256");
        Companion.a(companion, "TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384");
        n = Companion.a(companion, "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256");
        o = Companion.a(companion, "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384");
        Companion.a(companion, "TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256");
        Companion.a(companion, "TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384");
        Companion.a(companion, "TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA");
        Companion.a(companion, "TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA");
        p = Companion.a(companion, "TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256");
        q = Companion.a(companion, "TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256");
        Companion.a(companion, "TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256");
        Companion.a(companion, "TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256");
        r = Companion.a(companion, "TLS_AES_128_GCM_SHA256");
        s = Companion.a(companion, "TLS_AES_256_GCM_SHA384");
        t = Companion.a(companion, "TLS_CHACHA20_POLY1305_SHA256");
        Companion.a(companion, "TLS_AES_128_CCM_SHA256");
        Companion.a(companion, "TLS_AES_128_CCM_8_SHA256");
    }

    public CipherSuite(String str) {
        this.f56209a = str;
    }

    public final String toString() {
        return this.f56209a;
    }
}
