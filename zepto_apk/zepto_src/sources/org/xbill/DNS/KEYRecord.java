package org.xbill.DNS;

import java.io.IOException;
import java.security.PublicKey;
import java.util.StringTokenizer;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.xbill.DNS.DNSSEC;

/* loaded from: classes5.dex */
public class KEYRecord extends KEYBase {
    public static final int FLAG_NOAUTH = 32768;
    public static final int FLAG_NOCONF = 16384;
    public static final int FLAG_NOKEY = 49152;
    public static final int OWNER_HOST = 512;
    public static final int OWNER_USER = 0;
    public static final int OWNER_ZONE = 256;
    public static final int PROTOCOL_ANY = 255;
    public static final int PROTOCOL_DNSSEC = 3;
    public static final int PROTOCOL_EMAIL = 2;
    public static final int PROTOCOL_IPSEC = 4;
    public static final int PROTOCOL_TLS = 1;

    public static class Flags {
        public static final int EXTEND = 4096;
        public static final int FLAG10 = 32;
        public static final int FLAG11 = 16;
        public static final int FLAG2 = 8192;
        public static final int FLAG4 = 2048;
        public static final int FLAG5 = 1024;
        public static final int FLAG8 = 128;
        public static final int FLAG9 = 64;
        public static final int HOST = 512;
        private static final Mnemonic KEY_FLAGS;
        public static final int NOAUTH = 32768;
        public static final int NOCONF = 16384;
        public static final int NOKEY = 49152;
        public static final int NTYP3 = 768;
        public static final int OWNER_MASK = 768;
        public static final int SIG0 = 0;
        public static final int SIG1 = 1;
        public static final int SIG10 = 10;
        public static final int SIG11 = 11;
        public static final int SIG12 = 12;
        public static final int SIG13 = 13;
        public static final int SIG14 = 14;
        public static final int SIG15 = 15;
        public static final int SIG2 = 2;
        public static final int SIG3 = 3;
        public static final int SIG4 = 4;
        public static final int SIG5 = 5;
        public static final int SIG6 = 6;
        public static final int SIG7 = 7;
        public static final int SIG8 = 8;
        public static final int SIG9 = 9;
        public static final int USER = 0;
        public static final int USE_MASK = 49152;
        public static final int ZONE = 256;

        static {
            Mnemonic mnemonic = new Mnemonic("KEY flags", 2);
            KEY_FLAGS = mnemonic;
            mnemonic.setMaximum(Message.MAXLENGTH);
            mnemonic.setNumericAllowed(false);
            mnemonic.add(16384, "NOCONF");
            mnemonic.add(32768, "NOAUTH");
            mnemonic.add(49152, "NOKEY");
            mnemonic.add(FLAG2, "FLAG2");
            mnemonic.add(4096, "EXTEND");
            mnemonic.add(2048, "FLAG4");
            mnemonic.add(1024, "FLAG5");
            mnemonic.add(0, "USER");
            mnemonic.add(256, "ZONE");
            mnemonic.add(512, "HOST");
            mnemonic.add(768, "NTYP3");
            mnemonic.add(128, "FLAG8");
            mnemonic.add(64, "FLAG9");
            mnemonic.add(32, "FLAG10");
            mnemonic.add(16, "FLAG11");
            mnemonic.add(0, "SIG0");
            mnemonic.add(1, "SIG1");
            mnemonic.add(2, "SIG2");
            mnemonic.add(3, "SIG3");
            mnemonic.add(4, "SIG4");
            mnemonic.add(5, "SIG5");
            mnemonic.add(6, "SIG6");
            mnemonic.add(7, "SIG7");
            mnemonic.add(8, "SIG8");
            mnemonic.add(9, "SIG9");
            mnemonic.add(10, "SIG10");
            mnemonic.add(11, "SIG11");
            mnemonic.add(12, "SIG12");
            mnemonic.add(13, "SIG13");
            mnemonic.add(14, "SIG14");
            mnemonic.add(15, "SIG15");
        }

        private Flags() {
        }

        public static int value(String str) throws NumberFormatException {
            try {
                int i2 = Integer.parseInt(str);
                if (Utils.isUInt16(i2)) {
                    return i2;
                }
                return -1;
            } catch (NumberFormatException unused) {
                StringTokenizer stringTokenizer = new StringTokenizer(str, CLConstants.SALT_DELIMETER);
                int i3 = 0;
                while (stringTokenizer.hasMoreTokens()) {
                    int value = KEY_FLAGS.getValue(stringTokenizer.nextToken());
                    if (value < 0) {
                        return -1;
                    }
                    i3 |= value;
                }
                return i3;
            }
        }
    }

    public static class Protocol {
        public static final int ANY = 255;
        public static final int DNSSEC = 3;
        public static final int EMAIL = 2;
        public static final int IPSEC = 4;
        public static final int NONE = 0;
        public static final int TLS = 1;
        private static final Mnemonic protocols;

        static {
            Mnemonic mnemonic = new Mnemonic("KEY protocol", 2);
            protocols = mnemonic;
            mnemonic.setMaximum(255);
            mnemonic.setNumericAllowed(true);
            mnemonic.add(0, "NONE");
            mnemonic.add(1, "TLS");
            mnemonic.add(2, CLConstants.CREDTYPE_EMAIL);
            mnemonic.add(3, "DNSSEC");
            mnemonic.add(4, "IPSEC");
            mnemonic.add(255, "ANY");
        }

        private Protocol() {
        }

        public static String string(int i2) {
            return protocols.getText(i2);
        }

        public static int value(String str) {
            return protocols.getValue(str);
        }
    }

    public KEYRecord() {
    }

    @Override // org.xbill.DNS.KEYBase
    public /* bridge */ /* synthetic */ int getAlgorithm() {
        return super.getAlgorithm();
    }

    @Override // org.xbill.DNS.KEYBase
    public /* bridge */ /* synthetic */ int getFlags() {
        return super.getFlags();
    }

    @Override // org.xbill.DNS.KEYBase
    public /* bridge */ /* synthetic */ int getFootprint() {
        return super.getFootprint();
    }

    @Override // org.xbill.DNS.KEYBase
    public /* bridge */ /* synthetic */ byte[] getKey() {
        return super.getKey();
    }

    @Override // org.xbill.DNS.KEYBase
    public /* bridge */ /* synthetic */ int getProtocol() {
        return super.getProtocol();
    }

    @Override // org.xbill.DNS.KEYBase
    public /* bridge */ /* synthetic */ PublicKey getPublicKey() throws DNSSEC.DNSSECException {
        return super.getPublicKey();
    }

    @Override // org.xbill.DNS.Record
    public void rdataFromString(Tokenizer tokenizer, Name name) throws IOException, NumberFormatException {
        String identifier = tokenizer.getIdentifier();
        int iValue = Flags.value(identifier);
        this.flags = iValue;
        if (iValue < 0) {
            throw tokenizer.exception("Invalid flags: " + identifier);
        }
        String identifier2 = tokenizer.getIdentifier();
        int iValue2 = Protocol.value(identifier2);
        this.proto = iValue2;
        if (iValue2 < 0) {
            throw tokenizer.exception("Invalid protocol: " + identifier2);
        }
        String identifier3 = tokenizer.getIdentifier();
        int iValue3 = DNSSEC.Algorithm.value(identifier3);
        this.alg = iValue3;
        if (iValue3 < 0) {
            throw tokenizer.exception("Invalid algorithm: " + identifier3);
        }
        if ((this.flags & 49152) == 49152) {
            this.key = null;
        } else {
            this.key = tokenizer.getBase64();
        }
    }

    public KEYRecord(Name name, int i2, long j2, int i3, int i4, int i5, byte[] bArr) {
        super(name, 25, i2, j2, i3, i4, i5, bArr);
    }

    public KEYRecord(Name name, int i2, long j2, int i3, int i4, int i5, PublicKey publicKey) throws DNSSEC.DNSSECException {
        super(name, 25, i2, j2, i3, i4, i5, DNSSEC.fromPublicKey(publicKey, i5));
        this.publicKey = publicKey;
    }
}
