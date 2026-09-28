package org.xbill.DNS;

import j$.time.Duration;
import j$.time.Instant;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.SignatureException;
import java.util.Iterator;
import org.xbill.DNS.DNSSEC;

/* loaded from: classes5.dex */
public class SIG0 {
    private static final Duration VALIDITY = Duration.ofSeconds(300);

    private SIG0() {
    }

    public static void signMessage(Message message, KEYRecord kEYRecord, PrivateKey privateKey, SIGRecord sIGRecord) throws NumberFormatException, DNSSEC.DNSSECException {
        signMessage(message, kEYRecord, privateKey, sIGRecord, Instant.now());
    }

    public static void verifyMessage(Message message, byte[] bArr, KEYRecord kEYRecord, SIGRecord sIGRecord) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, DNSSEC.DNSSECException {
        verifyMessage(message, bArr, kEYRecord, sIGRecord, Instant.now());
    }

    public static void signMessage(Message message, KEYRecord kEYRecord, PrivateKey privateKey, SIGRecord sIGRecord, Instant instant) throws NumberFormatException, DNSSEC.DNSSECException {
        int iIntValue = Options.intValue("sig0validity");
        message.addRecord(DNSSEC.signMessage(message, sIGRecord, kEYRecord, privateKey, instant, instant.plus(iIntValue < 0 ? VALIDITY : Duration.ofSeconds(iIntValue))), 3);
    }

    public static void verifyMessage(Message message, byte[] bArr, KEYRecord kEYRecord, SIGRecord sIGRecord, Instant instant) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, DNSSEC.DNSSECException {
        SIGRecord sIGRecord2;
        Iterator<Record> it = message.getSection(3).iterator();
        while (true) {
            if (!it.hasNext()) {
                sIGRecord2 = null;
                break;
            }
            Record next = it.next();
            if (next.getType() == 24) {
                sIGRecord2 = (SIGRecord) next;
                if (sIGRecord2.getTypeCovered() == 0) {
                    break;
                }
            }
        }
        DNSSEC.verifyMessage(message, bArr, sIGRecord2, sIGRecord, kEYRecord, instant);
    }
}
