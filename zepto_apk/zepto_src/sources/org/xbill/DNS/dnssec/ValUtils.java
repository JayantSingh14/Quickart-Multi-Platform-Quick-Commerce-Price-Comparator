package org.xbill.DNS.dnssec;

import j$.time.Instant;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Security;
import java.security.SignatureException;
import java.security.interfaces.RSAPublicKey;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xbill.DNS.DClass;
import org.xbill.DNS.DNSKEYRecord;
import org.xbill.DNS.DNSSEC;
import org.xbill.DNS.DSRecord;
import org.xbill.DNS.Message;
import org.xbill.DNS.NSECRecord;
import org.xbill.DNS.Name;
import org.xbill.DNS.NameTooLongException;
import org.xbill.DNS.RRSIGRecord;
import org.xbill.DNS.RRset;
import org.xbill.DNS.Record;
import org.xbill.DNS.Type;

/* loaded from: classes5.dex */
final class ValUtils {
    public static final String ALGORITHM_ENABLED = "dnsjava.dnssec.algorithm";
    public static final String ALGORITHM_RSA_MIN_KEY_SIZE = "dnsjava.dnssec.algorithm_rsa_min_key_size";
    public static final String DIGEST_ENABLED = "dnsjava.dnssec.digest";
    public static final String DIGEST_HARDEN_DOWNGRADE = "dnsjava.dnssec.harden_algo_downgrade";
    public static final String DIGEST_PREFERENCE = "dnsjava.dnssec.digest_preference";
    public static final String MAX_DS_MATCH_FAILURES_PROPERTY = "dnsjava.dnssec.max_ds_match_failures";
    private boolean hasEd25519;
    private boolean hasEd448;
    private boolean hasGost;
    private final DnsSecVerifier verifier;

    @Generated
    private static final Logger log = LoggerFactory.b(ValUtils.class);
    private static final Name WILDCARD = Name.fromConstantString("*");
    private int[] digestPreference = null;
    private Properties config = null;
    private boolean digestHardenDowngrade = true;
    private int minRsaKeySize = 1024;
    private int maxDsMatchFailures = 4;

    /* renamed from: org.xbill.DNS.dnssec.ValUtils$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$xbill$DNS$dnssec$SecurityStatus;

        static {
            int[] iArr = new int[SecurityStatus.values().length];
            $SwitchMap$org$xbill$DNS$dnssec$SecurityStatus = iArr;
            try {
                iArr[SecurityStatus.INSECURE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$xbill$DNS$dnssec$SecurityStatus[SecurityStatus.SECURE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static class NsecProvesNodataResponse {
        boolean result;
        Name wc;
    }

    public ValUtils() {
        this.hasGost = Security.getProviders("MessageDigest.GOST3411") != null;
        this.hasEd25519 = Security.getProviders("KeyFactory.Ed25519") != null;
        this.hasEd448 = Security.getProviders("KeyFactory.Ed448") != null;
        this.verifier = new DnsSecVerifier(this);
    }

    public static ResponseClassification classifyResponse(Message message, SMessage sMessage) {
        if (sMessage.getRcode() == 3 && sMessage.getCount(1) == 0) {
            return ResponseClassification.NAMEERROR;
        }
        boolean z = false;
        if (!message.getHeader().getFlag(7) && sMessage.getCount(1) == 0 && sMessage.getRcode() != 0) {
            for (SRRset sRRset : sMessage.getSectionRRsets(2)) {
                if (sRRset.getType() == 6) {
                    return ResponseClassification.NODATA;
                }
                if (sRRset.getType() == 43) {
                    return ResponseClassification.REFERRAL;
                }
                if (sRRset.getType() == 2) {
                    z = true;
                }
            }
            return z ? ResponseClassification.REFERRAL : ResponseClassification.NODATA;
        }
        if (sMessage.getSectionRRsets(2).isEmpty() && sMessage.getSectionRRsets(1).size() == 1 && sMessage.getRcode() == 0 && sMessage.getSectionRRsets(1).get(0).getType() == 2 && !sMessage.getSectionRRsets(1).get(0).getName().equals(message.getQuestion().getName())) {
            return ResponseClassification.REFERRAL;
        }
        if (sMessage.getRcode() != 0 && sMessage.getRcode() != 3) {
            return ResponseClassification.UNKNOWN;
        }
        if (sMessage.getRcode() == 0 && sMessage.getCount(1) == 0) {
            return ResponseClassification.NODATA;
        }
        int type = sMessage.getQuestion().getType();
        if (type == 255) {
            return ResponseClassification.ANY;
        }
        for (SRRset sRRset2 : sMessage.getSectionRRsets(1)) {
            if (sRRset2.getType() == type) {
                return ResponseClassification.POSITIVE;
            }
            if (sRRset2.getType() == 5 || sRRset2.getType() == 39) {
                if (type == 43) {
                    return ResponseClassification.CNAME;
                }
                z = true;
            }
        }
        if (z) {
            return sMessage.getRcode() == 3 ? ResponseClassification.CNAME_NAMEERROR : ResponseClassification.CNAME_NODATA;
        }
        log.n(sMessage, "Failed to classify response message:\n{}");
        return ResponseClassification.UNKNOWN;
    }

    public static Name closestEncloser(Name name, Name name2, Name name3) {
        Name nameLongestCommonName = longestCommonName(name, name2);
        Name nameLongestCommonName2 = longestCommonName(name, name3);
        return nameLongestCommonName.labels() > nameLongestCommonName2.labels() ? nameLongestCommonName : nameLongestCommonName2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [byte[], java.io.Serializable] */
    private boolean dsDigestMatchesDnskey(DSRecord dSRecord, DNSKEYRecord dNSKEYRecord) {
        ?? digest = dSRecord.getDigest();
        try {
            byte[] digest2 = new DSRecord(Name.root, dSRecord.getDClass(), 0L, dSRecord.getDigestID(), dNSKEYRecord).getDigest();
            if (Arrays.equals(digest2, (byte[]) digest)) {
                return true;
            }
            log.u("Hash mismatch: key {} != ds {}", digest2, digest);
            return false;
        } catch (IllegalArgumentException e2) {
            log.a("Digest generation failed", e2);
            return false;
        }
    }

    private boolean isKeySizeSupported(RRset rRset) {
        Iterator<Record> it = rRset.rrs(false).iterator();
        while (it.hasNext()) {
            if (!isKeySizeSupported((DNSKEYRecord) it.next())) {
                return false;
            }
        }
        return true;
    }

    public static Name longestCommonName(Name name, Name name2) {
        int iMin = Math.min(name.labels(), name2.labels());
        Name name3 = new Name(name, name.labels() - iMin);
        Name name4 = new Name(name2, name2.labels() - iMin);
        for (int i2 = 0; i2 < iMin - 1; i2++) {
            Name name5 = new Name(name3, i2);
            if (name5.equals(new Name(name4, i2))) {
                return name5;
            }
        }
        return Name.root;
    }

    public static boolean nsecProvesNameError(SRRset sRRset, NSECRecord nSECRecord, Name name) {
        Name name2 = sRRset.getName();
        Name next = nSECRecord.getNext();
        if (name.equals(name2) || !next.subdomain(sRRset.getSignerName())) {
            return false;
        }
        if (name.subdomain(name2)) {
            if (nSECRecord.hasType(39)) {
                return false;
            }
            if (nSECRecord.hasType(2) && !nSECRecord.hasType(6)) {
                return false;
            }
        }
        return name2.equals(next) ? strictSubdomain(name, next) : name2.compareTo(next) > 0 ? name2.compareTo(name) < 0 && strictSubdomain(name, next) : name2.compareTo(name) < 0 && name.compareTo(next) < 0;
    }

    public static SecurityStatus nsecProvesNoDS(NSECRecord nSECRecord, Name name) {
        return ((!nSECRecord.hasType(6) || Name.root.equals(name)) && !nSECRecord.hasType(43)) ? !nSECRecord.hasType(2) ? SecurityStatus.INSECURE : SecurityStatus.SECURE : SecurityStatus.BOGUS;
    }

    public static boolean nsecProvesNoWC(SRRset sRRset, NSECRecord nSECRecord, Name name) {
        int iLabels = name.labels() - closestEncloser(name, sRRset.getName(), nSECRecord.getNext()).labels();
        if (iLabels > 0) {
            return nsecProvesNameError(sRRset, nSECRecord, name.wild(iLabels));
        }
        return false;
    }

    public static NsecProvesNodataResponse nsecProvesNodata(SRRset sRRset, NSECRecord nSECRecord, Name name, int i2) {
        NsecProvesNodataResponse nsecProvesNodataResponse = new NsecProvesNodataResponse();
        if (sRRset.getName().equals(name)) {
            if (nSECRecord.hasType(i2)) {
                log.s(Type.string(i2), "NSEC proofed that {} exists");
                nsecProvesNodataResponse.result = false;
                return nsecProvesNodataResponse;
            }
            if (nSECRecord.hasType(5)) {
                log.o("NSEC proofed CNAME");
                nsecProvesNodataResponse.result = false;
                return nsecProvesNodataResponse;
            }
            if (i2 != 43 && nSECRecord.hasType(2) && !nSECRecord.hasType(6)) {
                log.o("NSEC proofed missing referral");
                nsecProvesNodataResponse.result = false;
                return nsecProvesNodataResponse;
            }
            if (i2 != 43 || !nSECRecord.hasType(6) || Name.root.equals(name)) {
                nsecProvesNodataResponse.result = true;
                return nsecProvesNodataResponse;
            }
            log.o("NSEC from wrong zone");
            nsecProvesNodataResponse.result = false;
            return nsecProvesNodataResponse;
        }
        if (strictSubdomain(nSECRecord.getNext(), name) && sRRset.getName().compareTo(name) < 0) {
            nsecProvesNodataResponse.result = true;
            return nsecProvesNodataResponse;
        }
        if (!sRRset.getName().isWild()) {
            nsecProvesNodataResponse.result = false;
            return nsecProvesNodataResponse;
        }
        Name name2 = new Name(sRRset.getName(), 1);
        if (strictSubdomain(name, name2)) {
            if (nSECRecord.hasType(5)) {
                log.o("NSEC proofed wildcard CNAME");
                nsecProvesNodataResponse.result = false;
                return nsecProvesNodataResponse;
            }
            if (nSECRecord.hasType(2) && !nSECRecord.hasType(6)) {
                log.o("Wrong parent (wildcard) NSEC used");
                nsecProvesNodataResponse.result = false;
                return nsecProvesNodataResponse;
            }
            if (nSECRecord.hasType(i2)) {
                log.s(Type.string(i2), "NSEC proofed that {} exists");
                nsecProvesNodataResponse.result = false;
                return nsecProvesNodataResponse;
            }
        }
        nsecProvesNodataResponse.wc = name2;
        nsecProvesNodataResponse.result = true;
        return nsecProvesNodataResponse;
    }

    public static Name nsecWildcard(Name name, SRRset sRRset, NSECRecord nSECRecord) throws NameTooLongException {
        return Name.concatenate(WILDCARD, closestEncloser(name, sRRset.getName(), nSECRecord.getNext()));
    }

    private boolean propertyOrTrueWithPrecondition(String str, boolean z) {
        if (!z) {
            return false;
        }
        Properties properties = this.config;
        if (properties == null) {
            return true;
        }
        return Boolean.parseBoolean(properties.getProperty(str, Boolean.TRUE.toString()));
    }

    public static Name rrsetWildcard(RRset rRset) {
        List<RRSIGRecord> listSigs = rRset.sigs();
        RRSIGRecord rRSIGRecord = listSigs.get(0);
        for (int i2 = 1; i2 < listSigs.size(); i2++) {
            if (listSigs.get(i2).getLabels() != rRSIGRecord.getLabels()) {
                throw new IllegalArgumentException("failed.wildcard.label_count_mismatch");
            }
        }
        Name name = rRset.getName();
        if (rRset.getName().isWild()) {
            name = new Name(name, 1);
        }
        int iLabels = (name.labels() - 1) - rRSIGRecord.getLabels();
        if (iLabels > 0) {
            return name.wild(iLabels);
        }
        return null;
    }

    public static void setCanonicalNsecOwner(SRRset sRRset, RRSIGRecord rRSIGRecord) {
        if (sRRset.getType() != 47) {
            return;
        }
        Record recordFirst = sRRset.first();
        int iLabels = recordFirst.getName().labels();
        int i2 = iLabels - 1;
        if (recordFirst.getName().isWild()) {
            i2 = iLabels - 2;
        }
        if (rRSIGRecord.getLabels() == i2) {
            sRRset.setName(recordFirst.getName());
        } else {
            if (rRSIGRecord.getLabels() >= i2) {
                throw new IllegalArgumentException("invalid nsec record");
            }
            sRRset.setName(recordFirst.getName().wild(rRSIGRecord.getSigner().labels() - rRSIGRecord.getLabels()));
        }
    }

    public static boolean strictSubdomain(Name name, Name name2) {
        if (name.labels() <= name2.labels()) {
            return false;
        }
        return new Name(name, name.labels() - name2.labels()).equals(name2);
    }

    private JustifiedSecStatus verifyDnskeysWithDs(SRRset sRRset, DSRecord dSRecord, Instant instant, AtomicInteger atomicInteger) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        Iterator<Record> it = sRRset.rrs(false).iterator();
        int i2 = 0;
        int i3 = 0;
        while (it.hasNext()) {
            DNSKEYRecord dNSKEYRecord = (DNSKEYRecord) it.next();
            Logger logger = log;
            logger.i("Validating DNSKEY {} (footprint={}, alg={}) against DS {} (footprint={}, digest={}, alg={})", dNSKEYRecord.getName(), Integer.valueOf(dNSKEYRecord.getFootprint()), Integer.valueOf(dNSKEYRecord.getAlgorithm()), dSRecord.getName(), Integer.valueOf(dSRecord.getFootprint()), Integer.valueOf(dSRecord.getDigestID()), Integer.valueOf(dSRecord.getAlgorithm()));
            if (dSRecord.getFootprint() == dNSKEYRecord.getFootprint() && dSRecord.getAlgorithm() == dNSKEYRecord.getAlgorithm()) {
                atomicInteger.getAndIncrement();
                if (dsDigestMatchesDnskey(dSRecord, dNSKEYRecord)) {
                    i3++;
                    if (isKeySizeSupported(dNSKEYRecord)) {
                        JustifiedSecStatus justifiedSecStatusVerify = this.verifier.verify(sRRset, dNSKEYRecord, instant);
                        if (justifiedSecStatusVerify.status == SecurityStatus.SECURE) {
                            return justifiedSecStatusVerify;
                        }
                    } else {
                        logger.o("DS okay but that DNSKEY size is not supported");
                        i2++;
                    }
                } else {
                    logger.o("DS did not match DNSKEY, ignoring");
                    if (atomicInteger.get() > this.maxDsMatchFailures + i3) {
                        return new JustifiedSecStatus(SecurityStatus.BOGUS, 6, R.get("dnskey.ds_max_match", new Object[0]));
                    }
                }
            } else {
                logger.r("Footprint or algorithm mismatch, ignoring");
            }
        }
        return i2 > 0 ? new JustifiedSecStatus(SecurityStatus.INSECURE, -1, null) : atomicInteger.get() == 0 ? new JustifiedSecStatus(SecurityStatus.BOGUS, 9, R.get("dnskey.no_ds_alg_match", sRRset.getName(), DNSSEC.Algorithm.string(dSRecord.getAlgorithm()))) : i3 == 0 ? new JustifiedSecStatus(SecurityStatus.BOGUS, 6, R.get("dnskey.no_ds_match", new Object[0])) : new JustifiedSecStatus(SecurityStatus.BOGUS, 6, R.get("dnskey.ds_match_mismatch", new Object[0]));
    }

    public boolean atLeastOneSupportedAlgorithm(RRset rRset) {
        Iterator<Record> it = rRset.rrs(false).iterator();
        while (it.hasNext()) {
            if (isAlgorithmSupported(((DSRecord) it.next()).getAlgorithm())) {
                return true;
            }
        }
        return false;
    }

    public boolean atLeastOneSupportedDigest(RRset rRset) {
        Iterator<Record> it = rRset.rrs(false).iterator();
        while (it.hasNext()) {
            if (isDigestSupported(((DSRecord) it.next()).getDigestID())) {
                return true;
            }
        }
        return false;
    }

    public int favoriteDSDigestID(SRRset sRRset) {
        int[] iArr = this.digestPreference;
        int digestID = 0;
        if (iArr == null) {
            Iterator<Record> it = sRRset.rrs(false).iterator();
            while (it.hasNext()) {
                DSRecord dSRecord = (DSRecord) it.next();
                if (dSRecord.getDigestID() > digestID && isDigestSupported(dSRecord.getDigestID()) && isAlgorithmSupported(dSRecord.getAlgorithm())) {
                    digestID = dSRecord.getDigestID();
                }
            }
            return digestID;
        }
        for (int i2 : iArr) {
            Iterator<Record> it2 = sRRset.rrs(false).iterator();
            while (it2.hasNext()) {
                DSRecord dSRecord2 = (DSRecord) it2.next();
                if (dSRecord2.getDigestID() == i2) {
                    return dSRecord2.getDigestID();
                }
            }
        }
        return 0;
    }

    public boolean hasSignedNsecs(SMessage sMessage) {
        for (SRRset sRRset : sMessage.getSectionRRsets(2)) {
            if (sRRset.getType() == 47 || sRRset.getType() == 50) {
                if (!sRRset.sigs().isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void init(Properties properties) {
        this.hasGost = Security.getProviders("MessageDigest.GOST3411") != null;
        this.hasEd25519 = Security.getProviders("KeyFactory.Ed25519") != null;
        this.hasEd448 = Security.getProviders("KeyFactory.Ed448") != null;
        this.config = properties;
        String property = properties.getProperty(DIGEST_PREFERENCE);
        if (property != null) {
            String[] strArrSplit = property.split(",");
            this.digestPreference = new int[strArrSplit.length];
            for (int i2 = 0; i2 < strArrSplit.length; i2++) {
                this.digestPreference[i2] = Integer.parseInt(strArrSplit[i2]);
                if (!isDigestSupported(this.digestPreference[i2])) {
                    throw new IllegalArgumentException("Unsupported or disabled digest ID in digest preferences");
                }
            }
        }
        this.digestHardenDowngrade = Boolean.parseBoolean(properties.getProperty(DIGEST_HARDEN_DOWNGRADE, Boolean.TRUE.toString()));
        this.minRsaKeySize = Integer.parseInt(properties.getProperty(ALGORITHM_RSA_MIN_KEY_SIZE, Integer.toString(this.minRsaKeySize)));
        this.maxDsMatchFailures = Integer.parseInt(properties.getProperty(MAX_DS_MATCH_FAILURES_PROPERTY, Integer.toString(this.maxDsMatchFailures)));
        this.verifier.init(properties);
    }

    public boolean isAlgorithmSupported(int i2) {
        String strF = android.support.v4.media.b.f(i2, "dnsjava.dnssec.algorithm.");
        switch (i2) {
            case 3:
            case 6:
                Properties properties = this.config;
                if (properties == null) {
                    return false;
                }
                return Boolean.parseBoolean(properties.getProperty(strF, Boolean.FALSE.toString()));
            case 4:
            case 9:
            case 11:
            default:
                return false;
            case 5:
            case 7:
            case 8:
            case 10:
            case 13:
            case 14:
                return propertyOrTrueWithPrecondition(strF, true);
            case 12:
                return propertyOrTrueWithPrecondition(strF, this.hasGost);
            case 15:
                return propertyOrTrueWithPrecondition(strF, this.hasEd25519);
            case 16:
                return propertyOrTrueWithPrecondition(strF, this.hasEd448);
        }
    }

    public boolean isDigestSupported(int i2) {
        String strF = android.support.v4.media.b.f(i2, "dnsjava.dnssec.digest.");
        if (i2 != 1 && i2 != 2) {
            if (i2 == 3) {
                return propertyOrTrueWithPrecondition(strF, this.hasGost);
            }
            if (i2 != 4) {
                return false;
            }
        }
        Properties properties = this.config;
        if (properties == null) {
            return true;
        }
        return Boolean.parseBoolean(properties.getProperty(strF, Boolean.TRUE.toString()));
    }

    public JustifiedSecStatus nsecProvesNodataDsReply(Message message, SMessage sMessage, KeyEntry keyEntry, Instant instant) {
        Name name = message.getQuestion().getName();
        SRRset sRRsetFindRRset = sMessage.findRRset(name, 47, message.getQuestion().getDClass(), 2);
        if (sRRsetFindRRset != null) {
            JustifiedSecStatus justifiedSecStatusVerifySRRset = verifySRRset(sRRsetFindRRset, keyEntry, instant);
            if (justifiedSecStatusVerifySRRset.status != SecurityStatus.SECURE) {
                return new JustifiedSecStatus(SecurityStatus.BOGUS, 6, R.get("failed.ds.nsec", justifiedSecStatusVerifySRRset.reason));
            }
            SecurityStatus securityStatusNsecProvesNoDS = nsecProvesNoDS((NSECRecord) sRRsetFindRRset.first(), name);
            int i2 = AnonymousClass1.$SwitchMap$org$xbill$DNS$dnssec$SecurityStatus[securityStatusNsecProvesNoDS.ordinal()];
            return i2 != 1 ? i2 != 2 ? new JustifiedSecStatus(securityStatusNsecProvesNoDS, 6, R.get("failed.ds.nsec.hasdata", new Object[0])) : new JustifiedSecStatus(securityStatusNsecProvesNoDS, -1, R.get("insecure.ds.nsec", new Object[0])) : new JustifiedSecStatus(securityStatusNsecProvesNoDS, -1, R.get("failed.ds.nodelegation", new Object[0]));
        }
        NsecProvesNodataResponse nsecProvesNodataResponse = new NsecProvesNodataResponse();
        Name nameClosestEncloser = null;
        NSECRecord nSECRecord = null;
        boolean z = false;
        for (SRRset sRRset : sMessage.getSectionRRsets(2, 47)) {
            JustifiedSecStatus justifiedSecStatusVerifySRRset2 = verifySRRset(sRRset, keyEntry, instant);
            SecurityStatus securityStatus = justifiedSecStatusVerifySRRset2.status;
            if (securityStatus != SecurityStatus.SECURE) {
                return new JustifiedSecStatus(securityStatus, justifiedSecStatusVerifySRRset2.edeReason, R.get("failed.ds.nsec.ent", new Object[0]));
            }
            NSECRecord nSECRecord2 = (NSECRecord) sRRset.rrs(false).get(0);
            NsecProvesNodataResponse nsecProvesNodataResponseNsecProvesNodata = nsecProvesNodata(sRRset, nSECRecord2, name, 43);
            if (nsecProvesNodataResponseNsecProvesNodata.result) {
                if (nsecProvesNodataResponseNsecProvesNodata.wc == null || !nSECRecord2.getName().isWild()) {
                    z = true;
                } else {
                    z = true;
                    nSECRecord = nSECRecord2;
                }
            }
            if (nsecProvesNameError(sRRset, nSECRecord2, name)) {
                nameClosestEncloser = closestEncloser(name, sRRset.getName(), nSECRecord2.getNext());
            }
            nsecProvesNodataResponse = nsecProvesNodataResponseNsecProvesNodata;
        }
        Name name2 = nsecProvesNodataResponse.wc;
        if (name2 != null && (nameClosestEncloser == null || !nameClosestEncloser.equals(name2))) {
            z = false;
        }
        return z ? nsecProvesNodataResponse.wc != null ? new JustifiedSecStatus(nsecProvesNoDS(nSECRecord, name), 12, R.get("failed.ds.nowildcardproof", new Object[0])) : new JustifiedSecStatus(SecurityStatus.INSECURE, -1, R.get("insecure.ds.nsec.ent", new Object[0])) : new JustifiedSecStatus(SecurityStatus.UNCHECKED, 5, R.get("failed.ds.nonconclusive", new Object[0]));
    }

    public KeyEntry verifyNewDNSKEYs(SRRset sRRset, SRRset sRRset2, long j2, Instant instant) {
        int iFavoriteDSDigestID;
        AlgorithmRequirements algorithmRequirements;
        List<Integer> listInitDs;
        int iMissing;
        boolean z;
        ValUtils valUtils = this;
        boolean z2 = false;
        if (!sRRset.getName().equals(sRRset2.getName())) {
            KeyEntry keyEntryNewBadKeyEntry = KeyEntry.newBadKeyEntry(sRRset2.getName(), sRRset2.getDClass(), j2);
            keyEntryNewBadKeyEntry.setBadReason(6, R.get("dnskey.no_name_match", new Object[0]));
            return keyEntryNewBadKeyEntry;
        }
        if (valUtils.digestHardenDowngrade) {
            iFavoriteDSDigestID = valUtils.favoriteDSDigestID(sRRset2);
            algorithmRequirements = new AlgorithmRequirements(valUtils);
            listInitDs = algorithmRequirements.initDs(sRRset2, iFavoriteDSDigestID);
            log.i("Favorite DigestID for rrset {}/DNSKEY is {} ({})", sRRset.getName(), Integer.valueOf(iFavoriteDSDigestID), DNSSEC.Digest.string(iFavoriteDSDigestID));
        } else {
            iFavoriteDSDigestID = -1;
            algorithmRequirements = null;
            listInitDs = null;
        }
        AtomicInteger atomicInteger = new AtomicInteger(0);
        Iterator<Record> it = sRRset2.rrs(false).iterator();
        boolean z3 = false;
        JustifiedSecStatus justifiedSecStatusVerifyDnskeysWithDs = null;
        boolean z4 = false;
        while (it.hasNext()) {
            DSRecord dSRecord = (DSRecord) it.next();
            if (valUtils.isDigestSupported(dSRecord.getDigestID())) {
                z = z2;
                if (!valUtils.isAlgorithmSupported(dSRecord.getAlgorithm())) {
                    log.u("Algorithm {} ({}) is not supported", Integer.valueOf(dSRecord.getAlgorithm()), DNSSEC.Algorithm.string(dSRecord.getAlgorithm()));
                } else if (algorithmRequirements == null || dSRecord.getDigestID() == iFavoriteDSDigestID) {
                    justifiedSecStatusVerifyDnskeysWithDs = valUtils.verifyDnskeysWithDs(sRRset, dSRecord, instant, atomicInteger);
                    if (justifiedSecStatusVerifyDnskeysWithDs.status == SecurityStatus.INSECURE) {
                        log.u("Algorithm {} ({}) refused", Integer.valueOf(dSRecord.getAlgorithm()), DNSSEC.Algorithm.string(dSRecord.getAlgorithm()));
                        valUtils = this;
                        z2 = true;
                    } else {
                        if (atomicInteger.get() > 0) {
                            log.s(Integer.valueOf(atomicInteger.get()), "Checked #{} DS");
                            z4 = true;
                        }
                        SecurityStatus securityStatus = justifiedSecStatusVerifyDnskeysWithDs.status;
                        SecurityStatus securityStatus2 = SecurityStatus.SECURE;
                        if (securityStatus == securityStatus2) {
                            if (algorithmRequirements == null || algorithmRequirements.setSecure(dSRecord.getAlgorithm())) {
                                if (isKeySizeSupported(sRRset)) {
                                    sRRset.setSecurityStatus(securityStatus2);
                                    return KeyEntry.newKeyEntry(sRRset, listInitDs);
                                }
                                log.g("DS {} (footprint={}, id={}, alg={}) works, but DNSKEY set contains keys that are unsupported, treat as insecure", dSRecord.getName(), Integer.valueOf(dSRecord.getFootprint()), Integer.valueOf(dSRecord.getDigestID()), Integer.valueOf(dSRecord.getAlgorithm()));
                                return KeyEntry.newNullKeyEntry(sRRset2.getName(), sRRset2.getDClass(), j2);
                            }
                        } else if (algorithmRequirements != null && securityStatus == SecurityStatus.BOGUS) {
                            algorithmRequirements.setBogus(dSRecord.getAlgorithm());
                        }
                        valUtils = this;
                        z2 = z;
                        z3 = true;
                    }
                } else {
                    log.u("Downgrade protection prevents using digest ID {} ({})", Integer.valueOf(dSRecord.getDigestID()), DNSSEC.Digest.string(dSRecord.getDigestID()));
                }
            } else {
                z = z2;
                log.u("Digest ID {} ({}) is not supported", Integer.valueOf(dSRecord.getDigestID()), DNSSEC.Digest.string(dSRecord.getDigestID()));
            }
            z2 = z;
        }
        if (z2 && !z4) {
            log.o("No supported DS records were found -- treating as insecure");
            KeyEntry keyEntryNewNullKeyEntry = KeyEntry.newNullKeyEntry(sRRset2.getName(), sRRset2.getDClass(), j2);
            keyEntryNewNullKeyEntry.setBadReason(2, R.get("failed.ds.nodigest", sRRset2.getName()));
            return keyEntryNewNullKeyEntry;
        }
        if (!z3) {
            log.o("No usable DS records were found -- treating as insecure");
            KeyEntry keyEntryNewNullKeyEntry2 = KeyEntry.newNullKeyEntry(sRRset2.getName(), sRRset2.getDClass(), j2);
            keyEntryNewNullKeyEntry2.setBadReason(2, R.get("failed.ds.no_usable_digest", sRRset2.getName()));
            return keyEntryNewNullKeyEntry2;
        }
        Logger logger = log;
        logger.o("Failed to match any usable DS to a DNSKEY");
        if (algorithmRequirements != null && (iMissing = algorithmRequirements.missing()) != 0) {
            logger.u("Missing verification of DNSKEY signature with algorithm {} ({})", Integer.valueOf(iMissing), DNSSEC.Algorithm.string(iMissing));
        }
        KeyEntry keyEntryNewBadKeyEntry2 = KeyEntry.newBadKeyEntry(sRRset2.getName(), sRRset2.getDClass(), j2);
        keyEntryNewBadKeyEntry2.setBadReason(justifiedSecStatusVerifyDnskeysWithDs.edeReason, justifiedSecStatusVerifyDnskeysWithDs.reason);
        return keyEntryNewBadKeyEntry2;
    }

    public JustifiedSecStatus verifySRRset(SRRset sRRset, KeyEntry keyEntry, Instant instant) {
        SecurityStatus securityStatus = sRRset.getSecurityStatus();
        SecurityStatus securityStatus2 = SecurityStatus.SECURE;
        if (securityStatus == securityStatus2) {
            log.i("RRset <{}/{}/{}> previously found to be SECURE", sRRset.getName(), Type.string(sRRset.getType()), DClass.string(sRRset.getDClass()));
            return new JustifiedSecStatus(securityStatus2, -1, null);
        }
        JustifiedSecStatus justifiedSecStatusVerify = this.verifier.verify(sRRset, keyEntry, instant);
        sRRset.setSecurityStatus(justifiedSecStatusVerify.status);
        return justifiedSecStatusVerify;
    }

    private boolean isKeySizeSupported(DNSKEYRecord dNSKEYRecord) {
        try {
            PublicKey publicKey = dNSKEYRecord.getPublicKey();
            int algorithm = dNSKEYRecord.getAlgorithm();
            boolean z = true;
            if (algorithm != 1 && algorithm != 5 && algorithm != 10 && algorithm != 7 && algorithm != 8) {
                return true;
            }
            int iBitLength = ((RSAPublicKey) publicKey).getModulus().bitLength();
            if (iBitLength < this.minRsaKeySize) {
                z = false;
            }
            if (!z) {
                log.g("Key size {} for DNSKEY <{}/{}>, alg={}, id={} is less than minimum of {}", Integer.valueOf(iBitLength), dNSKEYRecord.getName(), DClass.string(dNSKEYRecord.getDClass()), DNSSEC.Algorithm.string(dNSKEYRecord.getAlgorithm()), Integer.valueOf(dNSKEYRecord.getFootprint()), Integer.valueOf(this.minRsaKeySize));
            }
            return z;
        } catch (DNSSEC.DNSSECException unused) {
            return false;
        }
    }
}
