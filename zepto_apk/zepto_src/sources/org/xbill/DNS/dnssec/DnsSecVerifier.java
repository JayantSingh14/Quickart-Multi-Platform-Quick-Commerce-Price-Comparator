package org.xbill.DNS.dnssec;

import j$.time.Instant;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xbill.DNS.DClass;
import org.xbill.DNS.DNSKEYRecord;
import org.xbill.DNS.DNSSEC;
import org.xbill.DNS.RRSIGRecord;
import org.xbill.DNS.RRset;
import org.xbill.DNS.Record;
import org.xbill.DNS.Type;

/* loaded from: classes5.dex */
final class DnsSecVerifier {
    public static final String MAX_VALIDATE_RRSIGS_PROPERTY = "dnsjava.dnssec.max_validate_rrsigs";

    @Generated
    private static final Logger log = LoggerFactory.b(DnsSecVerifier.class);
    private int maxValidateRRsigs;
    private final ValUtils valUtils;

    public DnsSecVerifier(ValUtils valUtils) {
        this.valUtils = valUtils;
    }

    private List<DNSKEYRecord> findKey(RRset rRset, RRSIGRecord rRSIGRecord) {
        if (!rRSIGRecord.getSigner().equals(rRset.getName())) {
            log.d("Could not find appropriate key because incorrect keyset was supplied. Wanted: {}, got: {}", rRSIGRecord.getSigner(), rRset.getName());
            return Collections.EMPTY_LIST;
        }
        int footprint = rRSIGRecord.getFootprint();
        int algorithm = rRSIGRecord.getAlgorithm();
        ArrayList arrayList = new ArrayList(rRset.size());
        Iterator<Record> it = rRset.rrs(false).iterator();
        while (it.hasNext()) {
            DNSKEYRecord dNSKEYRecord = (DNSKEYRecord) it.next();
            if (dNSKEYRecord.getAlgorithm() == algorithm && dNSKEYRecord.getFootprint() == footprint) {
                arrayList.add(dNSKEYRecord);
            }
        }
        return arrayList;
    }

    private JustifiedSecStatus verifySignature(SRRset sRRset, RRSIGRecord rRSIGRecord, KeyEntry keyEntry, Instant instant) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        if (!sRRset.getName().subdomain(rRSIGRecord.getSigner())) {
            log.u("Signer name {} is off-tree for {}", rRSIGRecord.getSigner(), sRRset.getName());
            return new JustifiedSecStatus(SecurityStatus.BOGUS, 6, R.get("dnskey.key_offtree", rRSIGRecord.getSigner(), sRRset.getName()));
        }
        Iterator<DNSKEYRecord> it = findKey(keyEntry, rRSIGRecord).iterator();
        if (!it.hasNext()) {
            log.m(rRSIGRecord, "Could not find appropriate key for {}");
            return new JustifiedSecStatus(SecurityStatus.UNCHECKED, 9, R.get("dnskey.no_key", rRSIGRecord.getSigner()));
        }
        try {
            DNSSEC.verify(sRRset, rRSIGRecord, it.next(), instant);
            ValUtils.setCanonicalNsecOwner(sRRset, rRSIGRecord);
            return new JustifiedSecStatus(SecurityStatus.SECURE, -1, null);
        } catch (DNSSEC.InvalidDnskeyException e2) {
            return new JustifiedSecStatus(SecurityStatus.BOGUS, e2.getEdeCode(), R.get("dnskey.invalid", new Object[0]));
        } catch (DNSSEC.KeyMismatchException unused) {
            return new JustifiedSecStatus(SecurityStatus.BOGUS, 6, R.get("dnskey.no_match", new Object[0]));
        } catch (DNSSEC.SignatureExpiredException unused2) {
            return new JustifiedSecStatus(SecurityStatus.BOGUS, 7, R.get("dnskey.expired", new Object[0]));
        } catch (DNSSEC.SignatureNotYetValidException unused3) {
            return new JustifiedSecStatus(SecurityStatus.BOGUS, 8, R.get("dnskey.not_yet_valid", new Object[0]));
        } catch (DNSSEC.DNSSECException e3) {
            log.p(sRRset.getName(), DClass.string(sRRset.getDClass()), Type.string(sRRset.getType()), e3);
            return new JustifiedSecStatus(SecurityStatus.BOGUS, 6, R.get("dnskey.invalid", new Object[0]));
        }
    }

    public void init(Properties properties) {
        this.maxValidateRRsigs = Integer.parseInt(properties.getProperty(MAX_VALIDATE_RRSIGS_PROPERTY, "8"));
    }

    public JustifiedSecStatus verify(SRRset sRRset, KeyEntry keyEntry, Instant instant) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        AlgorithmRequirements algorithmRequirements;
        List<RRSIGRecord> listSigs = sRRset.sigs();
        if (listSigs.isEmpty()) {
            log.k(sRRset.getName(), DClass.string(sRRset.getDClass()), Type.string(sRRset.getType()));
            return new JustifiedSecStatus(SecurityStatus.BOGUS, 10, R.get("validate.bogus.missingsig_named", sRRset.getName(), Type.string(sRRset.getType())));
        }
        JustifiedSecStatus justifiedSecStatus = null;
        if (keyEntry.getAlgo() != null) {
            algorithmRequirements = new AlgorithmRequirements(this.valUtils);
            algorithmRequirements.initList(keyEntry.getAlgo());
            if (algorithmRequirements.getNum() == 0) {
                log.s(sRRset.getName(), "{} has no known algorithms");
                return new JustifiedSecStatus(SecurityStatus.INSECURE, 1, R.get("validate.insecure.noalg", sRRset.getName()));
            }
        } else {
            algorithmRequirements = null;
        }
        int i2 = 0;
        for (RRSIGRecord rRSIGRecord : listSigs) {
            JustifiedSecStatus justifiedSecStatusVerifySignature = verifySignature(sRRset, rRSIGRecord, keyEntry, instant);
            SecurityStatus securityStatus = justifiedSecStatusVerifySignature.status;
            if (securityStatus == SecurityStatus.SECURE) {
                if (algorithmRequirements == null || algorithmRequirements.setSecure(rRSIGRecord.getAlgorithm())) {
                    return justifiedSecStatusVerifySignature;
                }
            } else if (algorithmRequirements != null && securityStatus == SecurityStatus.BOGUS) {
                algorithmRequirements.setBogus(rRSIGRecord.getAlgorithm());
            }
            i2++;
            if (i2 > this.maxValidateRRsigs) {
                log.e("RRset <{}/{}/{}> failed to verify: too many signatures", sRRset.getName(), DClass.string(sRRset.getDClass()), Type.string(sRRset.getType()));
                return new JustifiedSecStatus(SecurityStatus.BOGUS, 6, R.get("validate.bogus.rrsigtoomany", sRRset.getName(), Type.string(sRRset.getType())));
            }
            justifiedSecStatus = justifiedSecStatusVerifySignature;
        }
        log.e("RRset <{}/{}/{}> failed to verify: all signatures are BOGUS", sRRset.getName(), DClass.string(sRRset.getDClass()), Type.string(sRRset.getType()));
        return justifiedSecStatus;
    }

    public JustifiedSecStatus verify(RRset rRset, DNSKEYRecord dNSKEYRecord, Instant instant) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        String str;
        List<RRSIGRecord> listSigs = rRset.sigs();
        if (listSigs.isEmpty()) {
            log.e("RRset <{}/{}/{}> failed to verify due to lack of signatures", rRset.getName(), DClass.string(rRset.getDClass()), Type.string(rRset.getType()));
            return new JustifiedSecStatus(SecurityStatus.BOGUS, 10, R.get("validate.bogus.missingsig_named", rRset.getName(), Type.string(rRset.getType())));
        }
        Iterator<RRSIGRecord> it = listSigs.iterator();
        int i2 = 0;
        DNSSEC.DNSSECException e2 = null;
        while (true) {
            int i3 = 6;
            if (it.hasNext()) {
                RRSIGRecord next = it.next();
                if (next.getFootprint() == dNSKEYRecord.getFootprint()) {
                    i2++;
                    try {
                        DNSSEC.verify(rRset, next, dNSKEYRecord, instant);
                        return new JustifiedSecStatus(SecurityStatus.SECURE, -1, null);
                    } catch (DNSSEC.DNSSECException e3) {
                        e2 = e3;
                        Logger logger = log;
                        logger.e("Failed to validate RRset <{}/{}/{}> with signature {}", rRset.getName(), DClass.string(rRset.getDClass()), Type.string(rRset.getType()), Integer.valueOf(next.getFootprint()), e2);
                        if (i2 > this.maxValidateRRsigs) {
                            logger.e("RRset <{}/{}/{}> failed to verify: too many signatures", rRset.getName(), DClass.string(rRset.getDClass()), Type.string(rRset.getType()));
                            return new JustifiedSecStatus(SecurityStatus.BOGUS, 6, R.get("validate.bogus.rrsigtoomany", rRset.getName(), Type.string(rRset.getType())));
                        }
                    }
                }
            } else {
                log.e("RRset <{}/{}/{}> failed to verify: all signatures were BOGUS", rRset.getName(), DClass.string(rRset.getDClass()), Type.string(rRset.getType()));
                if (i2 == 0) {
                    i3 = 9;
                    str = "dnskey.no_ds_match";
                } else if (e2 instanceof DNSSEC.SignatureExpiredException) {
                    i3 = 7;
                    str = "dnskey.expired";
                } else if (e2 instanceof DNSSEC.SignatureNotYetValidException) {
                    i3 = 8;
                    str = "dnskey.not_yet_valid";
                } else {
                    str = "dnskey.invalid";
                }
                return new JustifiedSecStatus(SecurityStatus.BOGUS, i3, R.get(str, new Object[0]));
            }
        }
    }
}
