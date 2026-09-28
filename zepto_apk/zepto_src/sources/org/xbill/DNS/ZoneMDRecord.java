package org.xbill.DNS;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import lombok.Generated;
import org.apache.commons.lang3.StringUtils;
import org.xbill.DNS.utils.base16;

/* loaded from: classes5.dex */
public class ZoneMDRecord extends Record {
    private byte[] digest;
    private int hashAlgorithm;
    private int scheme;
    private long serial;

    public static final class Hash {
        public static final int RESERVED = 0;
        public static final int SHA384 = 1;
        public static final int SHA512 = 2;
        private static final Map<Integer, Integer> hashLengths;
        private static final Mnemonic schemes;

        static {
            Mnemonic mnemonic = new Mnemonic("ZONEMD Hash Algorithms", 2);
            schemes = mnemonic;
            HashMap map = new HashMap(2);
            hashLengths = map;
            mnemonic.setMaximum(255);
            mnemonic.setNumericAllowed(true);
            mnemonic.add(0, "RESERVED");
            mnemonic.add(1, "SHA384");
            map.put(1, 48);
            mnemonic.add(2, "SHA512");
            map.put(2, 64);
        }

        @Generated
        private Hash() {
            throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
        }

        public static int hashLength(int i2) {
            Integer num = hashLengths.get(Integer.valueOf(i2));
            if (num == null) {
                return -1;
            }
            return num.intValue();
        }

        public static String string(int i2) {
            return schemes.getText(i2);
        }

        public static int value(String str) {
            return schemes.getValue(str);
        }
    }

    public static final class Scheme {
        public static final int RESERVED = 0;
        public static final int SIMPLE = 1;
        private static final Mnemonic schemes;

        static {
            Mnemonic mnemonic = new Mnemonic("ZONEMD Schemes", 2);
            schemes = mnemonic;
            mnemonic.setMaximum(255);
            mnemonic.setNumericAllowed(true);
            mnemonic.add(0, "RESERVED");
            mnemonic.add(1, "SIMPLE");
        }

        @Generated
        private Scheme() {
            throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
        }

        public static String string(int i2) {
            return schemes.getText(i2);
        }

        public static int value(String str) {
            return schemes.getValue(str);
        }
    }

    public ZoneMDRecord() {
    }

    private String getDigestSizeExceptionMessage(int i2, byte[] bArr) {
        int iHashLength = Hash.hashLength(i2);
        if (iHashLength == -1 || iHashLength == bArr.length) {
            if (bArr.length >= 12) {
                return null;
            }
            return "Digest size must be at least 12 bytes, got " + bArr.length;
        }
        return "Digest size for " + Hash.string(i2) + " be exactly " + Hash.hashLength(i2) + " bytes, got " + bArr.length;
    }

    @Generated
    public byte[] getDigest() {
        return this.digest;
    }

    @Generated
    public int getHashAlgorithm() {
        return this.hashAlgorithm;
    }

    @Generated
    public int getScheme() {
        return this.scheme;
    }

    @Generated
    public long getSerial() {
        return this.serial;
    }

    @Override // org.xbill.DNS.Record
    public void rdataFromString(Tokenizer tokenizer, Name name) throws IOException {
        this.serial = tokenizer.getUInt32();
        this.scheme = tokenizer.getUInt8();
        this.hashAlgorithm = tokenizer.getUInt8();
        byte[] hex = tokenizer.getHex(true);
        this.digest = hex;
        String digestSizeExceptionMessage = getDigestSizeExceptionMessage(this.hashAlgorithm, hex);
        if (digestSizeExceptionMessage != null) {
            throw tokenizer.exception(digestSizeExceptionMessage);
        }
    }

    @Override // org.xbill.DNS.Record
    public void rrFromWire(DNSInput dNSInput) throws IOException {
        this.serial = dNSInput.readU32();
        this.scheme = dNSInput.readU8();
        this.hashAlgorithm = dNSInput.readU8();
        byte[] byteArray = dNSInput.readByteArray();
        this.digest = byteArray;
        String digestSizeExceptionMessage = getDigestSizeExceptionMessage(this.hashAlgorithm, byteArray);
        if (digestSizeExceptionMessage != null) {
            throw new WireParseException(digestSizeExceptionMessage);
        }
    }

    @Override // org.xbill.DNS.Record
    public String rrToString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.serial);
        sb.append(StringUtils.SPACE);
        sb.append(this.scheme);
        sb.append(StringUtils.SPACE);
        String strO = android.support.v4.media.b.o(sb, this.hashAlgorithm, StringUtils.SPACE);
        if (Options.multiline()) {
            StringBuilder sbX = android.support.v4.media.b.x(strO, "(");
            sbX.append(base16.toString(this.digest, 48, "\t", true));
            return sbX.toString();
        }
        StringBuilder sbW = android.support.v4.media.b.w(strO);
        sbW.append(base16.toString(this.digest));
        return sbW.toString();
    }

    @Override // org.xbill.DNS.Record
    public void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        dNSOutput.writeU32(this.serial);
        dNSOutput.writeU8(this.scheme);
        dNSOutput.writeU8(this.hashAlgorithm);
        dNSOutput.writeByteArray(this.digest);
    }

    public ZoneMDRecord(Name name, int i2, long j2, long j3, int i3, int i4, byte[] bArr) {
        super(name, 63, i2, j2);
        this.serial = Record.checkU32("serial", j3);
        this.scheme = Record.checkU8("scheme", i3);
        this.hashAlgorithm = Record.checkU8("hashAlgorithm", i4);
        String digestSizeExceptionMessage = getDigestSizeExceptionMessage(i4, bArr);
        if (digestSizeExceptionMessage != null) {
            throw new IllegalArgumentException(digestSizeExceptionMessage);
        }
        this.digest = bArr;
    }
}
