package org.xbill.DNS.dnssec;

import org.xbill.DNS.Name;

/* loaded from: classes5.dex */
final class FindKeyState {
    Name currentDSKeyName;
    SRRset dsRRset;
    Name emptyDSName;
    KeyEntry keyEntry;
    int qclass;
    Name signerName;
}
