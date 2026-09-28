package org.xbill.DNS;

import java.io.IOException;
import org.apache.commons.lang3.StringUtils;
import org.xbill.DNS.DNSSEC;
import org.xbill.DNS.utils.base64;

/* loaded from: classes5.dex */
public class CERTRecord extends Record {
    public static final int OID = 254;
    public static final int PGP = 3;
    public static final int PKIX = 1;
    public static final int SPKI = 2;
    public static final int URI = 253;
    private int alg;
    private byte[] cert;
    private int certType;
    private int keyTag;

    public static class CertificateType {
        public static final int ACPKIX = 7;
        public static final int IACPKIX = 8;
        public static final int IPGP = 6;
        public static final int IPKIX = 4;
        public static final int ISPKI = 5;
        public static final int OID = 254;
        public static final int PGP = 3;
        public static final int PKIX = 1;
        public static final int SPKI = 2;
        public static final int URI = 253;
        private static final Mnemonic types;

        static {
            Mnemonic mnemonic = new Mnemonic("Certificate type", 2);
            types = mnemonic;
            mnemonic.setMaximum(Message.MAXLENGTH);
            mnemonic.setNumericAllowed(true);
            mnemonic.add(1, "PKIX");
            mnemonic.add(2, "SPKI");
            mnemonic.add(3, "PGP");
            mnemonic.add(1, "IPKIX");
            mnemonic.add(2, "ISPKI");
            mnemonic.add(3, "IPGP");
            mnemonic.add(3, "ACPKIX");
            mnemonic.add(3, "IACPKIX");
            mnemonic.add(253, "URI");
            mnemonic.add(254, "OID");
        }

        private CertificateType() {
        }

        public static String string(int i2) {
            return types.getText(i2);
        }

        public static int value(String str) {
            return types.getValue(str);
        }
    }

    public CERTRecord() {
    }

    public int getAlgorithm() {
        return this.alg;
    }

    public byte[] getCert() {
        return this.cert;
    }

    public int getCertType() {
        return this.certType;
    }

    public int getKeyTag() {
        return this.keyTag;
    }

    @Override // org.xbill.DNS.Record
    public void rdataFromString(Tokenizer tokenizer, Name name) throws IOException {
        String string = tokenizer.getString();
        int iValue = CertificateType.value(string);
        this.certType = iValue;
        if (iValue < 0) {
            throw tokenizer.exception("Invalid certificate type: " + string);
        }
        this.keyTag = tokenizer.getUInt16();
        String string2 = tokenizer.getString();
        int iValue2 = DNSSEC.Algorithm.value(string2);
        this.alg = iValue2;
        if (iValue2 >= 0) {
            this.cert = tokenizer.getBase64();
        } else {
            throw tokenizer.exception("Invalid algorithm: " + string2);
        }
    }

    @Override // org.xbill.DNS.Record
    public void rrFromWire(DNSInput dNSInput) throws IOException {
        this.certType = dNSInput.readU16();
        this.keyTag = dNSInput.readU16();
        this.alg = dNSInput.readU8();
        this.cert = dNSInput.readByteArray();
    }

    @Override // org.xbill.DNS.Record
    public String rrToString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.certType);
        sb.append(StringUtils.SPACE);
        sb.append(this.keyTag);
        sb.append(StringUtils.SPACE);
        sb.append(this.alg);
        if (this.cert != null) {
            if (Options.multiline()) {
                sb.append(" (\n");
                sb.append(base64.formatString(this.cert, 64, "\t", true));
            } else {
                sb.append(StringUtils.SPACE);
                sb.append(base64.toString(this.cert));
            }
        }
        return sb.toString();
    }

    @Override // org.xbill.DNS.Record
    public void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        dNSOutput.writeU16(this.certType);
        dNSOutput.writeU16(this.keyTag);
        dNSOutput.writeU8(this.alg);
        dNSOutput.writeByteArray(this.cert);
    }

    public CERTRecord(Name name, int i2, long j2, int i3, int i4, int i5, byte[] bArr) {
        super(name, 37, i2, j2);
        this.certType = Record.checkU16("certType", i3);
        this.keyTag = Record.checkU16("keyTag", i4);
        this.alg = Record.checkU8("alg", i5);
        this.cert = bArr;
    }
}
