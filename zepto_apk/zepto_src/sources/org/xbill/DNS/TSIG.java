package org.xbill.DNS;

import j$.time.Clock;
import j$.time.Duration;
import j$.time.Instant;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import lombok.Generated;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xbill.DNS.utils.base64;
import org.xbill.DNS.utils.hexdump;

/* loaded from: classes5.dex */
public class TSIG {
    public static final Duration FUDGE;

    @Deprecated
    public static final Name HMAC;
    public static final Name HMAC_MD5;
    public static final Name HMAC_SHA1;
    public static final Name HMAC_SHA224;
    public static final Name HMAC_SHA256;
    public static final Name HMAC_SHA256_128;
    public static final Name HMAC_SHA384;
    public static final Name HMAC_SHA384_192;
    public static final Name HMAC_SHA512;
    public static final Name HMAC_SHA512_256;
    private static final Map<Name, Integer> algLengthMap;
    private static final Map<Name, String> algMap;
    private static final Pattern javaAlgNamePattern;
    private final Name alg;
    private final Clock clock;
    private final String macAlgorithm;
    private final SecretKey macKey;
    private final Name name;
    private final Mac sharedHmac;

    @Generated
    private static final Logger log = LoggerFactory.b(TSIG.class);
    public static final Name GSS_TSIG = Name.fromConstantString("gss-tsig.");

    public static class StreamGenerator {
        private final TSIG key;
        private TSIGRecord lastTsigRecord;
        private int numGenerated;
        private final Mac sharedHmac;
        private final int signEveryNthMessage;

        public StreamGenerator(TSIG tsig, TSIGRecord tSIGRecord) {
            this(tsig, tSIGRecord, 1);
        }

        public void generate(Message message) throws IllegalStateException, NumberFormatException {
            generate(message, true);
        }

        public StreamGenerator(TSIG tsig, TSIGRecord tSIGRecord, int i2) {
            if (i2 < 1 || i2 > 100) {
                throw new IllegalArgumentException("signEveryNthMessage must be between 1 and 100");
            }
            this.key = tsig;
            this.lastTsigRecord = tSIGRecord;
            this.signEveryNthMessage = i2;
            this.sharedHmac = tsig.initHmac();
        }

        public void generate(Message message, boolean z) throws IllegalStateException, NumberFormatException {
            int i2 = this.numGenerated;
            boolean z2 = i2 % this.signEveryNthMessage == 0;
            boolean z3 = i2 == 0;
            if (z3 || z2 || z) {
                TSIGRecord tSIGRecordGenerate = this.key.generate(message, message.toWire(), 0, z3 ? this.lastTsigRecord : null, z3, this.sharedHmac);
                message.addRecord(tSIGRecordGenerate, 3);
                message.tsigState = 3;
                this.lastTsigRecord = tSIGRecordGenerate;
                TSIG.hmacAddSignature(this.sharedHmac, tSIGRecordGenerate);
            } else {
                this.sharedHmac.update(message.toWire(Message.MAXLENGTH));
            }
            this.numGenerated++;
        }
    }

    public static class StreamVerifier {
        private String errorMessage;
        private final TSIG key;
        private int lastsigned;
        private int nresponses = 0;
        private final TSIGRecord queryTsig;
        private final Mac sharedHmac;

        public StreamVerifier(TSIG tsig, TSIGRecord tSIGRecord) {
            this.key = tsig;
            this.sharedHmac = tsig.initHmac();
            this.queryTsig = tSIGRecord;
        }

        private void addUnsignedMessageToMac(Message message, byte[] bArr, Mac mac) throws IllegalStateException {
            byte[] wire = message.getHeader().toWire();
            if (TSIG.log.f()) {
                TSIG.log.r(hexdump.dump("TSIG-HMAC header", wire));
            }
            mac.update(wire);
            int length = bArr.length - wire.length;
            if (TSIG.log.f()) {
                TSIG.log.r(hexdump.dump("TSIG-HMAC message after header", bArr, wire.length, length));
            }
            mac.update(bArr, wire.length, length);
            message.tsigState = 2;
        }

        @Generated
        public String getErrorMessage() {
            return this.errorMessage;
        }

        public int verify(Message message, byte[] bArr) {
            return verify(message, bArr, false);
        }

        public int verify(Message message, byte[] bArr, boolean z) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException {
            TSIGRecord tsig = message.getTSIG();
            int i2 = this.nresponses + 1;
            this.nresponses = i2;
            if (i2 == 1) {
                if (tsig != null) {
                    int iVerify = this.key.verify(message, bArr, this.queryTsig, true, this.sharedHmac);
                    TSIG.hmacAddSignature(this.sharedHmac, tsig);
                    this.lastsigned = this.nresponses;
                    return iVerify;
                }
                this.errorMessage = "missing required signature on first message";
                TSIG.log.s(this.errorMessage, "FORMERR: {}");
                message.tsigState = 4;
                return 1;
            }
            if (tsig != null) {
                int iVerify2 = this.key.verify(message, bArr, null, false, this.sharedHmac);
                this.lastsigned = this.nresponses;
                TSIG.hmacAddSignature(this.sharedHmac, tsig);
                return iVerify2;
            }
            if (i2 - this.lastsigned >= 100) {
                this.errorMessage = "Missing required signature on message #" + this.nresponses;
                TSIG.log.s(this.errorMessage, "FORMERR: {}");
                message.tsigState = 4;
                return 1;
            }
            if (z) {
                this.errorMessage = "Missing required signature on last message";
                TSIG.log.s(this.errorMessage, "FORMERR: {}");
                message.tsigState = 4;
                return 1;
            }
            this.errorMessage = android.support.v4.media.b.o(new StringBuilder("Intermediate message #"), this.nresponses, " without signature");
            TSIG.log.s(this.errorMessage, "FORMERR: {}");
            addUnsignedMessageToMac(message, bArr, this.sharedHmac);
            return 0;
        }
    }

    static {
        Name nameFromConstantString = Name.fromConstantString("HMAC-MD5.SIG-ALG.REG.INT.");
        HMAC_MD5 = nameFromConstantString;
        HMAC = nameFromConstantString;
        Name nameFromConstantString2 = Name.fromConstantString("hmac-sha1.");
        HMAC_SHA1 = nameFromConstantString2;
        Name nameFromConstantString3 = Name.fromConstantString("hmac-sha224.");
        HMAC_SHA224 = nameFromConstantString3;
        Name nameFromConstantString4 = Name.fromConstantString("hmac-sha256.");
        HMAC_SHA256 = nameFromConstantString4;
        Name nameFromConstantString5 = Name.fromConstantString("hmac-sha384.");
        HMAC_SHA384 = nameFromConstantString5;
        Name nameFromConstantString6 = Name.fromConstantString("hmac-sha512.");
        HMAC_SHA512 = nameFromConstantString6;
        Name nameFromConstantString7 = Name.fromConstantString("hmac-sha256-128.");
        HMAC_SHA256_128 = nameFromConstantString7;
        Name nameFromConstantString8 = Name.fromConstantString("hmac-sha384-192.");
        HMAC_SHA384_192 = nameFromConstantString8;
        Name nameFromConstantString9 = Name.fromConstantString("hmac-sha512-256.");
        HMAC_SHA512_256 = nameFromConstantString9;
        javaAlgNamePattern = Pattern.compile("^Hmac(?<alg>(SHA(1|\\d{3})|MD5))(/(?<length>\\d{3}))?$", 2);
        TreeMap treeMap = new TreeMap();
        treeMap.put(nameFromConstantString, "HmacMD5");
        treeMap.put(nameFromConstantString2, "HmacSHA1");
        treeMap.put(nameFromConstantString3, "HmacSHA224");
        treeMap.put(nameFromConstantString4, "HmacSHA256");
        treeMap.put(nameFromConstantString5, "HmacSHA384");
        treeMap.put(nameFromConstantString6, "HmacSHA512");
        treeMap.put(nameFromConstantString7, "HmacSHA256");
        treeMap.put(nameFromConstantString8, "HmacSHA384");
        treeMap.put(nameFromConstantString9, "HmacSHA512");
        algMap = Collections.unmodifiableMap(treeMap);
        HashMap map = new HashMap();
        map.put(nameFromConstantString, 16);
        map.put(nameFromConstantString2, 20);
        map.put(nameFromConstantString3, 28);
        map.put(nameFromConstantString4, 32);
        map.put(nameFromConstantString5, 48);
        map.put(nameFromConstantString6, 64);
        map.put(nameFromConstantString7, 16);
        map.put(nameFromConstantString8, 24);
        map.put(nameFromConstantString9, 32);
        algLengthMap = Collections.unmodifiableMap(map);
        FUDGE = Duration.ofSeconds(300L);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public TSIG(Name name, Name name2, String str) throws IOException {
        byte[] bArrFromString = base64.fromString(str);
        Objects.requireNonNull(bArrFromString);
        this(name, name2, bArrFromString);
    }

    public static Name algorithmToName(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Null algorithm");
        }
        if (!str.contains("-")) {
            Matcher matcher = javaAlgNamePattern.matcher(str);
            if (matcher.matches()) {
                str = "hmac-" + matcher.group("alg");
                String strGroup = matcher.group("length");
                if (strGroup != null) {
                    str = android.support.v4.media.b.l(str, "-", strGroup);
                }
            }
        }
        if (!str.endsWith(CLConstants.DOT_SALT_DELIMETER)) {
            str = str.concat(CLConstants.DOT_SALT_DELIMETER);
        }
        try {
            Name nameFromString = Name.fromString(str);
            if (nameFromString.equals(Name.fromConstantString("hmac-md5."))) {
                return HMAC_MD5;
            }
            if (algMap.get(nameFromString) != null) {
                return nameFromString;
            }
            throw new IllegalArgumentException("Unknown algorithm: " + nameFromString);
        } catch (TextParseException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    @Deprecated
    public static TSIG fromString(String str) {
        String[] strArrSplit = str.split("[:/]", 3);
        int length = strArrSplit.length;
        if (length == 2) {
            return new TSIG(HMAC_MD5, strArrSplit[0], strArrSplit[1]);
        }
        if (length == 3) {
            return new TSIG(strArrSplit[0], strArrSplit[1], strArrSplit[2]);
        }
        throw new IllegalArgumentException("Invalid TSIG key specification");
    }

    private Instant getTimeSigned(int i2, TSIGRecord tSIGRecord) {
        return i2 == 18 ? tSIGRecord.getTimeSigned() : this.clock.instant();
    }

    private static Duration getTsigFudge() throws NumberFormatException {
        int iIntValue = Options.intValue("tsigfudge");
        return (iIntValue < 0 || iIntValue > 32767) ? FUDGE : Duration.ofSeconds(iIntValue);
    }

    private static byte[] getTsigVariables(boolean z, TSIGRecord tSIGRecord) {
        DNSOutput dNSOutput = new DNSOutput();
        if (z) {
            tSIGRecord.getName().toWireCanonical(dNSOutput);
            dNSOutput.writeU16(tSIGRecord.dclass);
            dNSOutput.writeU32(tSIGRecord.ttl);
            tSIGRecord.getAlgorithm().toWireCanonical(dNSOutput);
        }
        writeTsigTimerVariables(tSIGRecord.getTimeSigned(), tSIGRecord.getFudge(), dNSOutput);
        if (z) {
            dNSOutput.writeU16(tSIGRecord.getError());
            if (tSIGRecord.getOther() != null) {
                dNSOutput.writeU16(tSIGRecord.getOther().length);
                dNSOutput.writeByteArray(tSIGRecord.getOther());
            } else {
                dNSOutput.writeU16(0);
            }
        }
        byte[] byteArray = dNSOutput.toByteArray();
        Logger logger = log;
        if (logger.f()) {
            logger.r(hexdump.dump("TSIG-HMAC variables", byteArray));
        }
        return byteArray;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hmacAddSignature(Mac mac, TSIGRecord tSIGRecord) throws IllegalStateException {
        byte[] u16 = DNSOutput.toU16(tSIGRecord.getSignature().length);
        Logger logger = log;
        if (logger.f()) {
            logger.r(hexdump.dump("TSIG-HMAC signature size", u16));
            logger.r(hexdump.dump("TSIG-HMAC signature", tSIGRecord.getSignature()));
        }
        mac.update(u16);
        mac.update(tSIGRecord.getSignature());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Mac initHmac() throws NoSuchAlgorithmException, InvalidKeyException {
        Mac mac = this.sharedHmac;
        if (mac != null) {
            try {
                return (Mac) mac.clone();
            } catch (CloneNotSupportedException unused) {
                this.sharedHmac.reset();
                return this.sharedHmac;
            }
        }
        try {
            Mac mac2 = Mac.getInstance(this.macAlgorithm);
            mac2.init(this.macKey);
            return mac2;
        } catch (GeneralSecurityException e2) {
            throw new IllegalArgumentException("Caught security exception setting up HMAC.", e2);
        }
    }

    @Deprecated
    public static String nameToAlgorithm(Name name) {
        String str = algMap.get(name);
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException("Unknown algorithm: " + name);
    }

    private static boolean verify(byte[] bArr, byte[] bArr2) {
        if (bArr2.length < bArr.length) {
            int length = bArr2.length;
            byte[] bArr3 = new byte[length];
            System.arraycopy(bArr, 0, bArr3, 0, length);
            bArr = bArr3;
        }
        return Arrays.equals(bArr2, bArr);
    }

    private int verifySignature(Mac mac, byte[] bArr) throws IllegalStateException {
        int macLength = mac.getMacLength();
        int iMax = Math.max(10, macLength / 2);
        if (bArr.length > macLength) {
            log.u("BADSIG: signature too long, expected: {}, actual: {}", Integer.valueOf(macLength), Integer.valueOf(bArr.length));
            return 16;
        }
        if (bArr.length < iMax) {
            log.g("BADSIG: signature too short, expected: {} of {}, actual: {}", Integer.valueOf(iMax), Integer.valueOf(macLength), Integer.valueOf(bArr.length));
            return 16;
        }
        byte[] bArrDoFinal = mac.doFinal();
        int length = bArrDoFinal.length;
        Map<Name, Integer> map = algLengthMap;
        if (length > map.get(this.alg).intValue()) {
            bArrDoFinal = Arrays.copyOfRange(bArrDoFinal, 0, map.get(this.alg).intValue());
        }
        if (verify(bArrDoFinal, bArr)) {
            return 0;
        }
        Logger logger = log;
        if (logger.b()) {
            logger.u("BADSIG: signature verification failed, expected: {}, actual: {}", base64.toString(bArrDoFinal), base64.toString(bArr));
        }
        return 16;
    }

    private int verifyTime(TSIGRecord tSIGRecord) {
        Instant instant = this.clock.instant();
        if (Duration.between(instant, tSIGRecord.getTimeSigned()).abs().compareTo(tSIGRecord.getFudge()) <= 0) {
            return 0;
        }
        log.g("BADTIME failure, now {} +/- tsig {} > fudge {}", instant, tSIGRecord.getTimeSigned(), tSIGRecord.getFudge());
        return 18;
    }

    private static void writeTsigTime(Instant instant, DNSOutput dNSOutput) {
        long epochSecond = instant.getEpochSecond();
        dNSOutput.writeU16((int) (epochSecond >> 32));
        dNSOutput.writeU32(epochSecond & 4294967295L);
    }

    private static void writeTsigTimerVariables(Instant instant, Duration duration, DNSOutput dNSOutput) {
        writeTsigTime(instant, dNSOutput);
        dNSOutput.writeU16((int) duration.getSeconds());
    }

    public void apply(Message message, TSIGRecord tSIGRecord) {
        apply(message, 0, tSIGRecord, true);
    }

    @Deprecated
    public void applyStream(Message message, TSIGRecord tSIGRecord, boolean z) {
        apply(message, 0, tSIGRecord, z);
    }

    public TSIGRecord generate(Message message, byte[] bArr, int i2, TSIGRecord tSIGRecord) {
        return generate(message, bArr, i2, tSIGRecord, true);
    }

    public int recordLength() {
        return algLengthMap.get(this.alg).intValue() + this.alg.length() + this.name.length() + 10 + 10 + 12;
    }

    public TSIG(Name name, Name name2, byte[] bArr) {
        this(name, name2, new SecretKeySpec(bArr, nameToAlgorithm(name)));
    }

    public void apply(Message message, int i2, TSIGRecord tSIGRecord) {
        apply(message, i2, tSIGRecord, true);
    }

    public TSIGRecord generate(Message message, byte[] bArr, int i2, TSIGRecord tSIGRecord, boolean z) {
        return generate(message, bArr, i2, tSIGRecord, z, (i2 == 0 || i2 == 18 || i2 == 22) ? initHmac() : null);
    }

    public TSIG(Name name, Name name2, SecretKey secretKey) {
        this(name, name2, secretKey, Clock.systemUTC());
    }

    public void apply(Message message, TSIGRecord tSIGRecord, boolean z) {
        apply(message, 0, tSIGRecord, z);
    }

    public TSIG(Name name, Name name2, SecretKey secretKey, Clock clock) {
        this.name = name2;
        this.alg = name;
        this.clock = clock;
        this.macAlgorithm = nameToAlgorithm(name);
        this.macKey = secretKey;
        this.sharedHmac = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TSIGRecord generate(Message message, byte[] bArr, int i2, TSIGRecord tSIGRecord, boolean z, Mac mac) throws IllegalStateException, NumberFormatException {
        byte[] bArrDoFinal;
        byte[] byteArray;
        Instant timeSigned = getTimeSigned(i2, tSIGRecord);
        Duration tsigFudge = getTsigFudge();
        boolean z2 = mac != null;
        if (tSIGRecord != null && z2) {
            hmacAddSignature(mac, tSIGRecord);
        }
        if (z2) {
            Logger logger = log;
            if (logger.f()) {
                logger.r(hexdump.dump("TSIG-HMAC rendered message", bArr));
            }
            mac.update(bArr);
        }
        DNSOutput dNSOutput = new DNSOutput();
        if (z) {
            this.name.toWireCanonical(dNSOutput);
            dNSOutput.writeU16(255);
            dNSOutput.writeU32(0L);
            this.alg.toWireCanonical(dNSOutput);
        }
        writeTsigTimerVariables(timeSigned, tsigFudge, dNSOutput);
        if (z) {
            dNSOutput.writeU16(i2);
            dNSOutput.writeU16(0);
        }
        if (z2) {
            byte[] byteArray2 = dNSOutput.toByteArray();
            Logger logger2 = log;
            if (logger2.f()) {
                logger2.r(hexdump.dump("TSIG-HMAC variables", byteArray2));
            }
            bArrDoFinal = mac.doFinal(byteArray2);
            int length = bArrDoFinal.length;
            Map<Name, Integer> map = algLengthMap;
            if (length > map.get(this.alg).intValue()) {
                bArrDoFinal = Arrays.copyOfRange(bArrDoFinal, 0, map.get(this.alg).intValue());
            }
        } else {
            bArrDoFinal = new byte[0];
        }
        byte[] bArr2 = bArrDoFinal;
        if (i2 == 18) {
            DNSOutput dNSOutput2 = new DNSOutput(6);
            writeTsigTime(this.clock.instant(), dNSOutput2);
            byteArray = dNSOutput2.toByteArray();
        } else {
            byteArray = null;
        }
        return new TSIGRecord(this.name, 255, 0L, this.alg, timeSigned, tsigFudge, bArr2, message.getHeader().getID(), i2, byteArray);
    }

    public void apply(Message message, int i2, TSIGRecord tSIGRecord, boolean z) {
        message.addRecord(generate(message, message.toWire(), i2, tSIGRecord, z), 3);
        message.tsigState = 3;
    }

    @Deprecated
    public byte verify(Message message, byte[] bArr, int i2, TSIGRecord tSIGRecord) {
        return (byte) verify(message, bArr, tSIGRecord);
    }

    public int verify(Message message, byte[] bArr, TSIGRecord tSIGRecord) {
        return verify(message, bArr, tSIGRecord, true);
    }

    public int verify(Message message, byte[] bArr, TSIGRecord tSIGRecord, boolean z) {
        return verify(message, bArr, tSIGRecord, z, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int verify(Message message, byte[] bArr, TSIGRecord tSIGRecord, boolean z, Mac mac) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException {
        message.tsigState = 4;
        TSIGRecord tsig = message.getTSIG();
        if (tsig == null) {
            return 1;
        }
        if (tsig.getName().equals(this.name) && tsig.getAlgorithm().equals(this.alg)) {
            if (mac == null) {
                mac = initHmac();
            }
            if (tSIGRecord != null && tsig.getError() != 17 && tsig.getError() != 16) {
                hmacAddSignature(mac, tSIGRecord);
            }
            message.getHeader().decCount(3);
            byte[] wire = message.getHeader().toWire();
            message.getHeader().incCount(3);
            Logger logger = log;
            if (logger.f()) {
                logger.r(hexdump.dump("TSIG-HMAC header", wire));
            }
            mac.update(wire);
            int length = message.tsigstart - wire.length;
            if (logger.f()) {
                logger.r(hexdump.dump("TSIG-HMAC message after header", bArr, wire.length, length));
            }
            mac.update(bArr, wire.length, length);
            mac.update(getTsigVariables(z, tsig));
            int iVerifySignature = verifySignature(mac, tsig.getSignature());
            if (iVerifySignature != 0) {
                return iVerifySignature;
            }
            int iVerifyTime = verifyTime(tsig);
            if (iVerifyTime != 0) {
                return iVerifyTime;
            }
            message.tsigState = 1;
            return 0;
        }
        log.g("BADKEY failure on message id {}, expected: {}/{}, actual: {}/{}", Integer.valueOf(message.getHeader().getID()), this.name, this.alg, tsig.getName(), tsig.getAlgorithm());
        return 17;
    }

    @Deprecated
    public TSIG(Mac mac, Name name) {
        this.name = name;
        this.sharedHmac = mac;
        this.macAlgorithm = null;
        this.macKey = null;
        this.clock = Clock.systemUTC();
        this.alg = algorithmToName(mac.getAlgorithm());
    }

    @Deprecated
    public TSIG(Name name, byte[] bArr) {
        this(HMAC_MD5, name, bArr);
    }

    public TSIG(Name name, String str, String str2) throws IOException {
        byte[] bArrFromString = base64.fromString(str2);
        if (bArrFromString != null) {
            try {
                this.name = Name.fromString(str, Name.root);
                this.alg = name;
                this.clock = Clock.systemUTC();
                String strNameToAlgorithm = nameToAlgorithm(name);
                this.macAlgorithm = strNameToAlgorithm;
                this.sharedHmac = null;
                this.macKey = new SecretKeySpec(bArrFromString, strNameToAlgorithm);
                return;
            } catch (TextParseException unused) {
                throw new IllegalArgumentException("Invalid TSIG key name");
            }
        }
        throw new IllegalArgumentException("Invalid TSIG key string");
    }

    public TSIG(String str, String str2, String str3) {
        this(algorithmToName(str), str2, str3);
    }

    @Deprecated
    public TSIG(String str, String str2) {
        this(HMAC_MD5, str, str2);
    }
}
