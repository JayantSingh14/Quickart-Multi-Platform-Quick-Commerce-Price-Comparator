package org.xbill.DNS.dnssec;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import lombok.Generated;
import org.xbill.DNS.NSEC3Record;
import org.xbill.DNS.Name;
import org.xbill.DNS.utils.base32;

/* loaded from: classes5.dex */
class Nsec3ValidationState {
    private static final base32 b32 = new base32(base32.Alphabet.BASE32HEX, false, false);
    private final Map<String, Nsec3CacheEntry> cache = new HashMap();
    int numCalc;
    int numCalcErrors;

    public static class Nsec3CacheEntry {
        private String asBase32;
        private final byte[] hash;

        @Generated
        public Nsec3CacheEntry(byte[] bArr) {
            this.hash = bArr;
        }

        @Generated
        public byte[] getHash() {
            return this.hash;
        }

        public String getHashAsBase32() {
            if (this.asBase32 == null) {
                this.asBase32 = Nsec3ValidationState.b32.toString(this.hash);
            }
            return this.asBase32;
        }
    }

    private String key(NSEC3Record nSEC3Record, Name name) {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append("/");
        sb.append(nSEC3Record.getHashAlgorithm());
        sb.append("/");
        sb.append(nSEC3Record.getIterations());
        sb.append("/");
        sb.append(nSEC3Record.getSalt() == null ? "-" : new BigInteger(nSEC3Record.getSalt()).toString());
        return sb.toString();
    }

    public Nsec3CacheEntry computeIfAbsent(NSEC3Record nSEC3Record, Name name) throws NoSuchAlgorithmException {
        String strKey = key(nSEC3Record, name);
        Nsec3CacheEntry nsec3CacheEntry = this.cache.get(strKey);
        if (nsec3CacheEntry != null) {
            return nsec3CacheEntry;
        }
        Nsec3CacheEntry nsec3CacheEntry2 = new Nsec3CacheEntry(nSEC3Record.hashName(name));
        this.cache.put(strKey, nsec3CacheEntry2);
        this.numCalc++;
        return nsec3CacheEntry2;
    }
}
