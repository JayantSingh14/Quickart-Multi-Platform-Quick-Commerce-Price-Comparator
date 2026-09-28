package org.xbill.DNS.dnssec;

/* loaded from: classes5.dex */
final class JustifiedSecStatus {
    int edeReason;
    String reason;
    SecurityStatus status;

    public JustifiedSecStatus(SecurityStatus securityStatus, int i2, String str) {
        this.status = securityStatus;
        this.edeReason = i2;
        this.reason = str;
    }

    public void applyToResponse(SMessage sMessage) {
        sMessage.setStatus(this.status, this.edeReason, this.reason);
    }
}
