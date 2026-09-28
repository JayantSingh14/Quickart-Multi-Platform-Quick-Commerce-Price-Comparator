package org.apache.xml.security.encryption;

import com.google.android.gms.internal.pal.a;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/* loaded from: classes5.dex */
public class XMLCipher {

    /* renamed from: a, reason: collision with root package name */
    static Class f57176a;

    /* renamed from: b, reason: collision with root package name */
    private static Log f57177b;

    /* renamed from: org.apache.xml.security.encryption.XMLCipher$1, reason: invalid class name */
    class AnonymousClass1 {
    }

    public class Factory {

        public class AgreementMethodImpl implements AgreementMethod {
        }

        public class CipherDataImpl implements CipherData {
        }

        public class CipherReferenceImpl implements CipherReference {
        }

        public class CipherValueImpl implements CipherValue {
        }

        public class EncryptedDataImpl extends EncryptedTypeImpl implements EncryptedData {
        }

        public class EncryptedKeyImpl extends EncryptedTypeImpl implements EncryptedKey {
        }

        public abstract class EncryptedTypeImpl {
        }

        public class EncryptionMethodImpl implements EncryptionMethod {
        }

        public class EncryptionPropertiesImpl implements EncryptionProperties {
        }

        public class EncryptionPropertyImpl implements EncryptionProperty {
        }

        public class ReferenceListImpl implements ReferenceList {

            public class DataReference extends ReferenceImpl {
            }

            public class KeyReference extends ReferenceImpl {
            }

            public abstract class ReferenceImpl implements Reference {
            }
        }

        public class TransformsImpl extends org.apache.xml.security.transforms.Transforms implements Transforms {
            @Override // org.apache.xml.security.utils.SignatureElementProxy, org.apache.xml.security.utils.ElementProxy
            public String d() {
                return "http://www.w3.org/2001/04/xmlenc#";
            }
        }
    }

    public class Serializer {
    }

    static {
        Class clsA = f57176a;
        if (clsA == null) {
            clsA = a("org.apache.xml.security.encryption.XMLCipher");
            f57176a = clsA;
        }
        f57177b = LogFactory.getLog(clsA.getName());
    }

    public static Class a(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw a.g(e2);
        }
    }
}
