package org.xbill.DNS;

import java.util.HashMap;
import java.util.function.Supplier;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes5.dex */
public final class Type {
    public static final int A = 1;
    public static final int A6 = 38;
    public static final int AAAA = 28;
    public static final int AFSDB = 18;
    public static final int AMTRELAY = 260;
    public static final int ANY = 255;
    public static final int APL = 42;
    public static final int ATMA = 34;
    public static final int AVC = 258;
    public static final int AXFR = 252;
    public static final int CAA = 257;
    public static final int CDNSKEY = 60;
    public static final int CDS = 59;
    public static final int CERT = 37;
    public static final int CNAME = 5;
    public static final int CSYNC = 62;
    public static final int DHCID = 49;
    public static final int DLV = 32769;
    public static final int DNAME = 39;
    public static final int DNSKEY = 48;
    public static final int DOA = 259;
    public static final int DS = 43;
    public static final int EID = 31;
    public static final int EUI48 = 108;
    public static final int EUI64 = 109;
    public static final int GID = 102;
    public static final int GPOS = 27;
    public static final int HINFO = 13;
    public static final int HIP = 55;
    public static final int HTTPS = 65;
    public static final int IPSECKEY = 45;
    public static final int ISDN = 20;
    public static final int IXFR = 251;
    public static final int KEY = 25;
    public static final int KX = 36;
    public static final int L32 = 105;
    public static final int L64 = 106;
    public static final int LOC = 29;
    public static final int LP = 107;
    public static final int MAILA = 254;
    public static final int MAILB = 253;
    public static final int MB = 7;
    public static final int MD = 3;
    public static final int MF = 4;
    public static final int MG = 8;
    public static final int MINFO = 14;
    public static final int MR = 9;
    public static final int MX = 15;
    public static final int NAPTR = 35;
    public static final int NID = 104;
    public static final int NIMLOC = 32;
    public static final int NINFO = 56;
    public static final int NS = 2;
    public static final int NSAP = 22;
    public static final int NSAP_PTR = 23;
    public static final int NSEC = 47;
    public static final int NSEC3 = 50;
    public static final int NSEC3PARAM = 51;
    public static final int NULL = 10;
    public static final int NXT = 30;
    public static final int OPENPGPKEY = 61;
    public static final int OPT = 41;
    public static final int PTR = 12;
    public static final int PX = 26;
    public static final int RKEY = 57;
    public static final int RP = 17;
    public static final int RRSIG = 46;
    public static final int RT = 21;
    public static final int SIG = 24;
    public static final int SINK = 40;
    public static final int SMIMEA = 53;
    public static final int SOA = 6;
    public static final int SPF = 99;
    public static final int SRV = 33;
    public static final int SSHFP = 44;
    public static final int SVCB = 64;
    public static final int TA = 32768;
    public static final int TALINK = 58;
    public static final int TKEY = 249;
    public static final int TLSA = 52;
    public static final int TSIG = 250;
    public static final int TXT = 16;
    public static final int UID = 101;
    public static final int UINFO = 100;
    public static final int UNSPEC = 103;
    public static final int URI = 256;
    public static final int WKS = 11;
    public static final int X25 = 19;
    public static final int ZONEMD = 63;
    private static final TypeMnemonic types;

    public static class TypeMnemonic extends Mnemonic {
        private final HashMap<Integer, Supplier<Record>> factories;

        public TypeMnemonic() {
            super("Type", 2);
            setPrefix("TYPE");
            setMaximum(Message.MAXLENGTH);
            this.factories = new HashMap<>();
        }

        public void add(int i2, String str, Supplier<Record> supplier) {
            super.add(i2, str);
            this.factories.put(Integer.valueOf(i2), supplier);
        }

        @Override // org.xbill.DNS.Mnemonic
        public void check(int i2) {
            Type.check(i2);
        }

        public Supplier<Record> getFactory(int i2) {
            check(i2);
            return this.factories.get(Integer.valueOf(i2));
        }

        public void replace(int i2, String str, Supplier<Record> supplier) {
            int value = getValue(str);
            if (value != -1) {
                if (value != i2) {
                    throw new IllegalArgumentException("mnemnonic \"" + str + "\" already used by type " + value);
                }
                remove(i2);
                this.factories.remove(Integer.valueOf(i2));
            }
            add(i2, str, supplier);
        }
    }

    static {
        TypeMnemonic typeMnemonic = new TypeMnemonic();
        types = typeMnemonic;
        typeMnemonic.add(1, "A", new y(7));
        typeMnemonic.add(2, "NS", new y(9));
        typeMnemonic.add(3, "MD", new y(21));
        final int i2 = 3;
        typeMnemonic.add(4, "MF", new Supplier() { // from class: org.xbill.DNS.c0
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i2) {
                    case 0:
                        return new APLRecord();
                    case 1:
                        return new DSRecord();
                    case 2:
                        return new SSHFPRecord();
                    case 3:
                        return new MFRecord();
                    case 4:
                        return new IPSECKEYRecord();
                    case 5:
                        return new RRSIGRecord();
                    case 6:
                        return new NSECRecord();
                    case 7:
                        return new DNSKEYRecord();
                    case 8:
                        return new DHCIDRecord();
                    case 9:
                        return new NSEC3Record();
                    case 10:
                        return new HINFORecord();
                    case 11:
                        return new NSEC3PARAMRecord();
                    case 12:
                        return new TLSARecord();
                    case 13:
                        return new SMIMEARecord();
                    case 14:
                        return new HIPRecord();
                    case 15:
                        return new CNAMERecord();
                    case 16:
                        return new CDSRecord();
                    case 17:
                        return new CDNSKEYRecord();
                    case 18:
                        return new OPENPGPKEYRecord();
                    case 19:
                        return new ZoneMDRecord();
                    case 20:
                        return new SVCBRecord();
                    case 21:
                        return new MINFORecord();
                    case 22:
                        return new HTTPSRecord();
                    case 23:
                        return new SPFRecord();
                    case 24:
                        return new TKEYRecord();
                    case 25:
                        return new TSIGRecord();
                    case 26:
                        return new URIRecord();
                    case 27:
                        return new SOARecord();
                    case 28:
                        return new CAARecord();
                    default:
                        return new DLVRecord();
                }
            }
        });
        final int i3 = 15;
        typeMnemonic.add(5, "CNAME", new Supplier() { // from class: org.xbill.DNS.c0
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i3) {
                    case 0:
                        return new APLRecord();
                    case 1:
                        return new DSRecord();
                    case 2:
                        return new SSHFPRecord();
                    case 3:
                        return new MFRecord();
                    case 4:
                        return new IPSECKEYRecord();
                    case 5:
                        return new RRSIGRecord();
                    case 6:
                        return new NSECRecord();
                    case 7:
                        return new DNSKEYRecord();
                    case 8:
                        return new DHCIDRecord();
                    case 9:
                        return new NSEC3Record();
                    case 10:
                        return new HINFORecord();
                    case 11:
                        return new NSEC3PARAMRecord();
                    case 12:
                        return new TLSARecord();
                    case 13:
                        return new SMIMEARecord();
                    case 14:
                        return new HIPRecord();
                    case 15:
                        return new CNAMERecord();
                    case 16:
                        return new CDSRecord();
                    case 17:
                        return new CDNSKEYRecord();
                    case 18:
                        return new OPENPGPKEYRecord();
                    case 19:
                        return new ZoneMDRecord();
                    case 20:
                        return new SVCBRecord();
                    case 21:
                        return new MINFORecord();
                    case 22:
                        return new HTTPSRecord();
                    case 23:
                        return new SPFRecord();
                    case 24:
                        return new TKEYRecord();
                    case 25:
                        return new TSIGRecord();
                    case 26:
                        return new URIRecord();
                    case 27:
                        return new SOARecord();
                    case 28:
                        return new CAARecord();
                    default:
                        return new DLVRecord();
                }
            }
        });
        final int i4 = 27;
        typeMnemonic.add(6, "SOA", new Supplier() { // from class: org.xbill.DNS.c0
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i4) {
                    case 0:
                        return new APLRecord();
                    case 1:
                        return new DSRecord();
                    case 2:
                        return new SSHFPRecord();
                    case 3:
                        return new MFRecord();
                    case 4:
                        return new IPSECKEYRecord();
                    case 5:
                        return new RRSIGRecord();
                    case 6:
                        return new NSECRecord();
                    case 7:
                        return new DNSKEYRecord();
                    case 8:
                        return new DHCIDRecord();
                    case 9:
                        return new NSEC3Record();
                    case 10:
                        return new HINFORecord();
                    case 11:
                        return new NSEC3PARAMRecord();
                    case 12:
                        return new TLSARecord();
                    case 13:
                        return new SMIMEARecord();
                    case 14:
                        return new HIPRecord();
                    case 15:
                        return new CNAMERecord();
                    case 16:
                        return new CDSRecord();
                    case 17:
                        return new CDNSKEYRecord();
                    case 18:
                        return new OPENPGPKEYRecord();
                    case 19:
                        return new ZoneMDRecord();
                    case 20:
                        return new SVCBRecord();
                    case 21:
                        return new MINFORecord();
                    case 22:
                        return new HTTPSRecord();
                    case 23:
                        return new SPFRecord();
                    case 24:
                        return new TKEYRecord();
                    case 25:
                        return new TSIGRecord();
                    case 26:
                        return new URIRecord();
                    case 27:
                        return new SOARecord();
                    case 28:
                        return new CAARecord();
                    default:
                        return new DLVRecord();
                }
            }
        });
        final int i5 = 0;
        typeMnemonic.add(7, "MB", new Supplier() { // from class: org.xbill.DNS.d0
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i5) {
                    case 0:
                        return new MBRecord();
                    case 1:
                        return new MGRecord();
                    case 2:
                        return new MXRecord();
                    case 3:
                        return new MRRecord();
                    case 4:
                        return new NULLRecord();
                    case 5:
                        return new TXTRecord();
                    case 6:
                        return new RPRecord();
                    case 7:
                        return new AFSDBRecord();
                    default:
                        return new X25Record();
                }
            }
        });
        final int i6 = 1;
        typeMnemonic.add(8, "MG", new Supplier() { // from class: org.xbill.DNS.d0
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i6) {
                    case 0:
                        return new MBRecord();
                    case 1:
                        return new MGRecord();
                    case 2:
                        return new MXRecord();
                    case 3:
                        return new MRRecord();
                    case 4:
                        return new NULLRecord();
                    case 5:
                        return new TXTRecord();
                    case 6:
                        return new RPRecord();
                    case 7:
                        return new AFSDBRecord();
                    default:
                        return new X25Record();
                }
            }
        });
        final int i7 = 3;
        typeMnemonic.add(9, "MR", new Supplier() { // from class: org.xbill.DNS.d0
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i7) {
                    case 0:
                        return new MBRecord();
                    case 1:
                        return new MGRecord();
                    case 2:
                        return new MXRecord();
                    case 3:
                        return new MRRecord();
                    case 4:
                        return new NULLRecord();
                    case 5:
                        return new TXTRecord();
                    case 6:
                        return new RPRecord();
                    case 7:
                        return new AFSDBRecord();
                    default:
                        return new X25Record();
                }
            }
        });
        final int i8 = 4;
        typeMnemonic.add(10, "NULL", new Supplier() { // from class: org.xbill.DNS.d0
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i8) {
                    case 0:
                        return new MBRecord();
                    case 1:
                        return new MGRecord();
                    case 2:
                        return new MXRecord();
                    case 3:
                        return new MRRecord();
                    case 4:
                        return new NULLRecord();
                    case 5:
                        return new TXTRecord();
                    case 6:
                        return new RPRecord();
                    case 7:
                        return new AFSDBRecord();
                    default:
                        return new X25Record();
                }
            }
        });
        typeMnemonic.add(11, "WKS", new y(18));
        typeMnemonic.add(12, "PTR", new y(29));
        final int i9 = 10;
        typeMnemonic.add(13, "HINFO", new Supplier() { // from class: org.xbill.DNS.c0
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i9) {
                    case 0:
                        return new APLRecord();
                    case 1:
                        return new DSRecord();
                    case 2:
                        return new SSHFPRecord();
                    case 3:
                        return new MFRecord();
                    case 4:
                        return new IPSECKEYRecord();
                    case 5:
                        return new RRSIGRecord();
                    case 6:
                        return new NSECRecord();
                    case 7:
                        return new DNSKEYRecord();
                    case 8:
                        return new DHCIDRecord();
                    case 9:
                        return new NSEC3Record();
                    case 10:
                        return new HINFORecord();
                    case 11:
                        return new NSEC3PARAMRecord();
                    case 12:
                        return new TLSARecord();
                    case 13:
                        return new SMIMEARecord();
                    case 14:
                        return new HIPRecord();
                    case 15:
                        return new CNAMERecord();
                    case 16:
                        return new CDSRecord();
                    case 17:
                        return new CDNSKEYRecord();
                    case 18:
                        return new OPENPGPKEYRecord();
                    case 19:
                        return new ZoneMDRecord();
                    case 20:
                        return new SVCBRecord();
                    case 21:
                        return new MINFORecord();
                    case 22:
                        return new HTTPSRecord();
                    case 23:
                        return new SPFRecord();
                    case 24:
                        return new TKEYRecord();
                    case 25:
                        return new TSIGRecord();
                    case 26:
                        return new URIRecord();
                    case 27:
                        return new SOARecord();
                    case 28:
                        return new CAARecord();
                    default:
                        return new DLVRecord();
                }
            }
        });
        final int i10 = 21;
        typeMnemonic.add(14, "MINFO", new Supplier() { // from class: org.xbill.DNS.c0
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i10) {
                    case 0:
                        return new APLRecord();
                    case 1:
                        return new DSRecord();
                    case 2:
                        return new SSHFPRecord();
                    case 3:
                        return new MFRecord();
                    case 4:
                        return new IPSECKEYRecord();
                    case 5:
                        return new RRSIGRecord();
                    case 6:
                        return new NSECRecord();
                    case 7:
                        return new DNSKEYRecord();
                    case 8:
                        return new DHCIDRecord();
                    case 9:
                        return new NSEC3Record();
                    case 10:
                        return new HINFORecord();
                    case 11:
                        return new NSEC3PARAMRecord();
                    case 12:
                        return new TLSARecord();
                    case 13:
                        return new SMIMEARecord();
                    case 14:
                        return new HIPRecord();
                    case 15:
                        return new CNAMERecord();
                    case 16:
                        return new CDSRecord();
                    case 17:
                        return new CDNSKEYRecord();
                    case 18:
                        return new OPENPGPKEYRecord();
                    case 19:
                        return new ZoneMDRecord();
                    case 20:
                        return new SVCBRecord();
                    case 21:
                        return new MINFORecord();
                    case 22:
                        return new HTTPSRecord();
                    case 23:
                        return new SPFRecord();
                    case 24:
                        return new TKEYRecord();
                    case 25:
                        return new TSIGRecord();
                    case 26:
                        return new URIRecord();
                    case 27:
                        return new SOARecord();
                    case 28:
                        return new CAARecord();
                    default:
                        return new DLVRecord();
                }
            }
        });
        final int i11 = 2;
        typeMnemonic.add(15, "MX", new Supplier() { // from class: org.xbill.DNS.d0
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i11) {
                    case 0:
                        return new MBRecord();
                    case 1:
                        return new MGRecord();
                    case 2:
                        return new MXRecord();
                    case 3:
                        return new MRRecord();
                    case 4:
                        return new NULLRecord();
                    case 5:
                        return new TXTRecord();
                    case 6:
                        return new RPRecord();
                    case 7:
                        return new AFSDBRecord();
                    default:
                        return new X25Record();
                }
            }
        });
        final int i12 = 5;
        typeMnemonic.add(16, "TXT", new Supplier() { // from class: org.xbill.DNS.d0
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i12) {
                    case 0:
                        return new MBRecord();
                    case 1:
                        return new MGRecord();
                    case 2:
                        return new MXRecord();
                    case 3:
                        return new MRRecord();
                    case 4:
                        return new NULLRecord();
                    case 5:
                        return new TXTRecord();
                    case 6:
                        return new RPRecord();
                    case 7:
                        return new AFSDBRecord();
                    default:
                        return new X25Record();
                }
            }
        });
        final int i13 = 6;
        typeMnemonic.add(17, "RP", new Supplier() { // from class: org.xbill.DNS.d0
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i13) {
                    case 0:
                        return new MBRecord();
                    case 1:
                        return new MGRecord();
                    case 2:
                        return new MXRecord();
                    case 3:
                        return new MRRecord();
                    case 4:
                        return new NULLRecord();
                    case 5:
                        return new TXTRecord();
                    case 6:
                        return new RPRecord();
                    case 7:
                        return new AFSDBRecord();
                    default:
                        return new X25Record();
                }
            }
        });
        final int i14 = 7;
        typeMnemonic.add(18, "AFSDB", new Supplier() { // from class: org.xbill.DNS.d0
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i14) {
                    case 0:
                        return new MBRecord();
                    case 1:
                        return new MGRecord();
                    case 2:
                        return new MXRecord();
                    case 3:
                        return new MRRecord();
                    case 4:
                        return new NULLRecord();
                    case 5:
                        return new TXTRecord();
                    case 6:
                        return new RPRecord();
                    case 7:
                        return new AFSDBRecord();
                    default:
                        return new X25Record();
                }
            }
        });
        final int i15 = 8;
        typeMnemonic.add(19, "X25", new Supplier() { // from class: org.xbill.DNS.d0
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i15) {
                    case 0:
                        return new MBRecord();
                    case 1:
                        return new MGRecord();
                    case 2:
                        return new MXRecord();
                    case 3:
                        return new MRRecord();
                    case 4:
                        return new NULLRecord();
                    case 5:
                        return new TXTRecord();
                    case 6:
                        return new RPRecord();
                    case 7:
                        return new AFSDBRecord();
                    default:
                        return new X25Record();
                }
            }
        });
        typeMnemonic.add(20, "ISDN", new y(8));
        typeMnemonic.add(21, "RT", new y(10));
        typeMnemonic.add(22, "NSAP", new y(11));
        typeMnemonic.add(23, "NSAP-PTR", new y(12));
        typeMnemonic.add(24, "SIG", new y(13));
        typeMnemonic.add(25, "KEY", new y(14));
        typeMnemonic.add(26, "PX", new y(15));
        typeMnemonic.add(27, "GPOS", new y(16));
        typeMnemonic.add(28, "AAAA", new y(17));
        typeMnemonic.add(29, "LOC", new y(19));
        typeMnemonic.add(30, "NXT", new y(20));
        typeMnemonic.add(31, "EID");
        typeMnemonic.add(32, "NIMLOC");
        typeMnemonic.add(33, "SRV", new y(22));
        typeMnemonic.add(34, "ATMA");
        typeMnemonic.add(35, "NAPTR", new y(23));
        typeMnemonic.add(36, "KX", new y(24));
        typeMnemonic.add(37, "CERT", new y(25));
        typeMnemonic.add(38, "A6", new y(26));
        typeMnemonic.add(39, "DNAME", new y(27));
        typeMnemonic.add(40, "SINK");
        typeMnemonic.add(41, "OPT", new y(28));
        final int i16 = 0;
        typeMnemonic.add(42, "APL", new Supplier() { // from class: org.xbill.DNS.c0
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i16) {
                    case 0:
                        return new APLRecord();
                    case 1:
                        return new DSRecord();
                    case 2:
                        return new SSHFPRecord();
                    case 3:
                        return new MFRecord();
                    case 4:
                        return new IPSECKEYRecord();
                    case 5:
                        return new RRSIGRecord();
                    case 6:
                        return new NSECRecord();
                    case 7:
                        return new DNSKEYRecord();
                    case 8:
                        return new DHCIDRecord();
                    case 9:
                        return new NSEC3Record();
                    case 10:
                        return new HINFORecord();
                    case 11:
                        return new NSEC3PARAMRecord();
                    case 12:
                        return new TLSARecord();
                    case 13:
                        return new SMIMEARecord();
                    case 14:
                        return new HIPRecord();
                    case 15:
                        return new CNAMERecord();
                    case 16:
                        return new CDSRecord();
                    case 17:
                        return new CDNSKEYRecord();
                    case 18:
                        return new OPENPGPKEYRecord();
                    case 19:
                        return new ZoneMDRecord();
                    case 20:
                        return new SVCBRecord();
                    case 21:
                        return new MINFORecord();
                    case 22:
                        return new HTTPSRecord();
                    case 23:
                        return new SPFRecord();
                    case 24:
                        return new TKEYRecord();
                    case 25:
                        return new TSIGRecord();
                    case 26:
                        return new URIRecord();
                    case 27:
                        return new SOARecord();
                    case 28:
                        return new CAARecord();
                    default:
                        return new DLVRecord();
                }
            }
        });
        final int i17 = 1;
        typeMnemonic.add(43, "DS", new Supplier() { // from class: org.xbill.DNS.c0
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i17) {
                    case 0:
                        return new APLRecord();
                    case 1:
                        return new DSRecord();
                    case 2:
                        return new SSHFPRecord();
                    case 3:
                        return new MFRecord();
                    case 4:
                        return new IPSECKEYRecord();
                    case 5:
                        return new RRSIGRecord();
                    case 6:
                        return new NSECRecord();
                    case 7:
                        return new DNSKEYRecord();
                    case 8:
                        return new DHCIDRecord();
                    case 9:
                        return new NSEC3Record();
                    case 10:
                        return new HINFORecord();
                    case 11:
                        return new NSEC3PARAMRecord();
                    case 12:
                        return new TLSARecord();
                    case 13:
                        return new SMIMEARecord();
                    case 14:
                        return new HIPRecord();
                    case 15:
                        return new CNAMERecord();
                    case 16:
                        return new CDSRecord();
                    case 17:
                        return new CDNSKEYRecord();
                    case 18:
                        return new OPENPGPKEYRecord();
                    case 19:
                        return new ZoneMDRecord();
                    case 20:
                        return new SVCBRecord();
                    case 21:
                        return new MINFORecord();
                    case 22:
                        return new HTTPSRecord();
                    case 23:
                        return new SPFRecord();
                    case 24:
                        return new TKEYRecord();
                    case 25:
                        return new TSIGRecord();
                    case 26:
                        return new URIRecord();
                    case 27:
                        return new SOARecord();
                    case 28:
                        return new CAARecord();
                    default:
                        return new DLVRecord();
                }
            }
        });
        final int i18 = 2;
        typeMnemonic.add(44, "SSHFP", new Supplier() { // from class: org.xbill.DNS.c0
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i18) {
                    case 0:
                        return new APLRecord();
                    case 1:
                        return new DSRecord();
                    case 2:
                        return new SSHFPRecord();
                    case 3:
                        return new MFRecord();
                    case 4:
                        return new IPSECKEYRecord();
                    case 5:
                        return new RRSIGRecord();
                    case 6:
                        return new NSECRecord();
                    case 7:
                        return new DNSKEYRecord();
                    case 8:
                        return new DHCIDRecord();
                    case 9:
                        return new NSEC3Record();
                    case 10:
                        return new HINFORecord();
                    case 11:
                        return new NSEC3PARAMRecord();
                    case 12:
                        return new TLSARecord();
                    case 13:
                        return new SMIMEARecord();
                    case 14:
                        return new HIPRecord();
                    case 15:
                        return new CNAMERecord();
                    case 16:
                        return new CDSRecord();
                    case 17:
                        return new CDNSKEYRecord();
                    case 18:
                        return new OPENPGPKEYRecord();
                    case 19:
                        return new ZoneMDRecord();
                    case 20:
                        return new SVCBRecord();
                    case 21:
                        return new MINFORecord();
                    case 22:
                        return new HTTPSRecord();
                    case 23:
                        return new SPFRecord();
                    case 24:
                        return new TKEYRecord();
                    case 25:
                        return new TSIGRecord();
                    case 26:
                        return new URIRecord();
                    case 27:
                        return new SOARecord();
                    case 28:
                        return new CAARecord();
                    default:
                        return new DLVRecord();
                }
            }
        });
        final int i19 = 4;
        typeMnemonic.add(45, "IPSECKEY", new Supplier() { // from class: org.xbill.DNS.c0
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i19) {
                    case 0:
                        return new APLRecord();
                    case 1:
                        return new DSRecord();
                    case 2:
                        return new SSHFPRecord();
                    case 3:
                        return new MFRecord();
                    case 4:
                        return new IPSECKEYRecord();
                    case 5:
                        return new RRSIGRecord();
                    case 6:
                        return new NSECRecord();
                    case 7:
                        return new DNSKEYRecord();
                    case 8:
                        return new DHCIDRecord();
                    case 9:
                        return new NSEC3Record();
                    case 10:
                        return new HINFORecord();
                    case 11:
                        return new NSEC3PARAMRecord();
                    case 12:
                        return new TLSARecord();
                    case 13:
                        return new SMIMEARecord();
                    case 14:
                        return new HIPRecord();
                    case 15:
                        return new CNAMERecord();
                    case 16:
                        return new CDSRecord();
                    case 17:
                        return new CDNSKEYRecord();
                    case 18:
                        return new OPENPGPKEYRecord();
                    case 19:
                        return new ZoneMDRecord();
                    case 20:
                        return new SVCBRecord();
                    case 21:
                        return new MINFORecord();
                    case 22:
                        return new HTTPSRecord();
                    case 23:
                        return new SPFRecord();
                    case 24:
                        return new TKEYRecord();
                    case 25:
                        return new TSIGRecord();
                    case 26:
                        return new URIRecord();
                    case 27:
                        return new SOARecord();
                    case 28:
                        return new CAARecord();
                    default:
                        return new DLVRecord();
                }
            }
        });
        final int i20 = 5;
        typeMnemonic.add(46, "RRSIG", new Supplier() { // from class: org.xbill.DNS.c0
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i20) {
                    case 0:
                        return new APLRecord();
                    case 1:
                        return new DSRecord();
                    case 2:
                        return new SSHFPRecord();
                    case 3:
                        return new MFRecord();
                    case 4:
                        return new IPSECKEYRecord();
                    case 5:
                        return new RRSIGRecord();
                    case 6:
                        return new NSECRecord();
                    case 7:
                        return new DNSKEYRecord();
                    case 8:
                        return new DHCIDRecord();
                    case 9:
                        return new NSEC3Record();
                    case 10:
                        return new HINFORecord();
                    case 11:
                        return new NSEC3PARAMRecord();
                    case 12:
                        return new TLSARecord();
                    case 13:
                        return new SMIMEARecord();
                    case 14:
                        return new HIPRecord();
                    case 15:
                        return new CNAMERecord();
                    case 16:
                        return new CDSRecord();
                    case 17:
                        return new CDNSKEYRecord();
                    case 18:
                        return new OPENPGPKEYRecord();
                    case 19:
                        return new ZoneMDRecord();
                    case 20:
                        return new SVCBRecord();
                    case 21:
                        return new MINFORecord();
                    case 22:
                        return new HTTPSRecord();
                    case 23:
                        return new SPFRecord();
                    case 24:
                        return new TKEYRecord();
                    case 25:
                        return new TSIGRecord();
                    case 26:
                        return new URIRecord();
                    case 27:
                        return new SOARecord();
                    case 28:
                        return new CAARecord();
                    default:
                        return new DLVRecord();
                }
            }
        });
        final int i21 = 6;
        typeMnemonic.add(47, "NSEC", new Supplier() { // from class: org.xbill.DNS.c0
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i21) {
                    case 0:
                        return new APLRecord();
                    case 1:
                        return new DSRecord();
                    case 2:
                        return new SSHFPRecord();
                    case 3:
                        return new MFRecord();
                    case 4:
                        return new IPSECKEYRecord();
                    case 5:
                        return new RRSIGRecord();
                    case 6:
                        return new NSECRecord();
                    case 7:
                        return new DNSKEYRecord();
                    case 8:
                        return new DHCIDRecord();
                    case 9:
                        return new NSEC3Record();
                    case 10:
                        return new HINFORecord();
                    case 11:
                        return new NSEC3PARAMRecord();
                    case 12:
                        return new TLSARecord();
                    case 13:
                        return new SMIMEARecord();
                    case 14:
                        return new HIPRecord();
                    case 15:
                        return new CNAMERecord();
                    case 16:
                        return new CDSRecord();
                    case 17:
                        return new CDNSKEYRecord();
                    case 18:
                        return new OPENPGPKEYRecord();
                    case 19:
                        return new ZoneMDRecord();
                    case 20:
                        return new SVCBRecord();
                    case 21:
                        return new MINFORecord();
                    case 22:
                        return new HTTPSRecord();
                    case 23:
                        return new SPFRecord();
                    case 24:
                        return new TKEYRecord();
                    case 25:
                        return new TSIGRecord();
                    case 26:
                        return new URIRecord();
                    case 27:
                        return new SOARecord();
                    case 28:
                        return new CAARecord();
                    default:
                        return new DLVRecord();
                }
            }
        });
        final int i22 = 7;
        typeMnemonic.add(48, "DNSKEY", new Supplier() { // from class: org.xbill.DNS.c0
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i22) {
                    case 0:
                        return new APLRecord();
                    case 1:
                        return new DSRecord();
                    case 2:
                        return new SSHFPRecord();
                    case 3:
                        return new MFRecord();
                    case 4:
                        return new IPSECKEYRecord();
                    case 5:
                        return new RRSIGRecord();
                    case 6:
                        return new NSECRecord();
                    case 7:
                        return new DNSKEYRecord();
                    case 8:
                        return new DHCIDRecord();
                    case 9:
                        return new NSEC3Record();
                    case 10:
                        return new HINFORecord();
                    case 11:
                        return new NSEC3PARAMRecord();
                    case 12:
                        return new TLSARecord();
                    case 13:
                        return new SMIMEARecord();
                    case 14:
                        return new HIPRecord();
                    case 15:
                        return new CNAMERecord();
                    case 16:
                        return new CDSRecord();
                    case 17:
                        return new CDNSKEYRecord();
                    case 18:
                        return new OPENPGPKEYRecord();
                    case 19:
                        return new ZoneMDRecord();
                    case 20:
                        return new SVCBRecord();
                    case 21:
                        return new MINFORecord();
                    case 22:
                        return new HTTPSRecord();
                    case 23:
                        return new SPFRecord();
                    case 24:
                        return new TKEYRecord();
                    case 25:
                        return new TSIGRecord();
                    case 26:
                        return new URIRecord();
                    case 27:
                        return new SOARecord();
                    case 28:
                        return new CAARecord();
                    default:
                        return new DLVRecord();
                }
            }
        });
        final int i23 = 8;
        typeMnemonic.add(49, "DHCID", new Supplier() { // from class: org.xbill.DNS.c0
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i23) {
                    case 0:
                        return new APLRecord();
                    case 1:
                        return new DSRecord();
                    case 2:
                        return new SSHFPRecord();
                    case 3:
                        return new MFRecord();
                    case 4:
                        return new IPSECKEYRecord();
                    case 5:
                        return new RRSIGRecord();
                    case 6:
                        return new NSECRecord();
                    case 7:
                        return new DNSKEYRecord();
                    case 8:
                        return new DHCIDRecord();
                    case 9:
                        return new NSEC3Record();
                    case 10:
                        return new HINFORecord();
                    case 11:
                        return new NSEC3PARAMRecord();
                    case 12:
                        return new TLSARecord();
                    case 13:
                        return new SMIMEARecord();
                    case 14:
                        return new HIPRecord();
                    case 15:
                        return new CNAMERecord();
                    case 16:
                        return new CDSRecord();
                    case 17:
                        return new CDNSKEYRecord();
                    case 18:
                        return new OPENPGPKEYRecord();
                    case 19:
                        return new ZoneMDRecord();
                    case 20:
                        return new SVCBRecord();
                    case 21:
                        return new MINFORecord();
                    case 22:
                        return new HTTPSRecord();
                    case 23:
                        return new SPFRecord();
                    case 24:
                        return new TKEYRecord();
                    case 25:
                        return new TSIGRecord();
                    case 26:
                        return new URIRecord();
                    case 27:
                        return new SOARecord();
                    case 28:
                        return new CAARecord();
                    default:
                        return new DLVRecord();
                }
            }
        });
        final int i24 = 9;
        typeMnemonic.add(50, "NSEC3", new Supplier() { // from class: org.xbill.DNS.c0
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i24) {
                    case 0:
                        return new APLRecord();
                    case 1:
                        return new DSRecord();
                    case 2:
                        return new SSHFPRecord();
                    case 3:
                        return new MFRecord();
                    case 4:
                        return new IPSECKEYRecord();
                    case 5:
                        return new RRSIGRecord();
                    case 6:
                        return new NSECRecord();
                    case 7:
                        return new DNSKEYRecord();
                    case 8:
                        return new DHCIDRecord();
                    case 9:
                        return new NSEC3Record();
                    case 10:
                        return new HINFORecord();
                    case 11:
                        return new NSEC3PARAMRecord();
                    case 12:
                        return new TLSARecord();
                    case 13:
                        return new SMIMEARecord();
                    case 14:
                        return new HIPRecord();
                    case 15:
                        return new CNAMERecord();
                    case 16:
                        return new CDSRecord();
                    case 17:
                        return new CDNSKEYRecord();
                    case 18:
                        return new OPENPGPKEYRecord();
                    case 19:
                        return new ZoneMDRecord();
                    case 20:
                        return new SVCBRecord();
                    case 21:
                        return new MINFORecord();
                    case 22:
                        return new HTTPSRecord();
                    case 23:
                        return new SPFRecord();
                    case 24:
                        return new TKEYRecord();
                    case 25:
                        return new TSIGRecord();
                    case 26:
                        return new URIRecord();
                    case 27:
                        return new SOARecord();
                    case 28:
                        return new CAARecord();
                    default:
                        return new DLVRecord();
                }
            }
        });
        final int i25 = 11;
        typeMnemonic.add(51, "NSEC3PARAM", new Supplier() { // from class: org.xbill.DNS.c0
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i25) {
                    case 0:
                        return new APLRecord();
                    case 1:
                        return new DSRecord();
                    case 2:
                        return new SSHFPRecord();
                    case 3:
                        return new MFRecord();
                    case 4:
                        return new IPSECKEYRecord();
                    case 5:
                        return new RRSIGRecord();
                    case 6:
                        return new NSECRecord();
                    case 7:
                        return new DNSKEYRecord();
                    case 8:
                        return new DHCIDRecord();
                    case 9:
                        return new NSEC3Record();
                    case 10:
                        return new HINFORecord();
                    case 11:
                        return new NSEC3PARAMRecord();
                    case 12:
                        return new TLSARecord();
                    case 13:
                        return new SMIMEARecord();
                    case 14:
                        return new HIPRecord();
                    case 15:
                        return new CNAMERecord();
                    case 16:
                        return new CDSRecord();
                    case 17:
                        return new CDNSKEYRecord();
                    case 18:
                        return new OPENPGPKEYRecord();
                    case 19:
                        return new ZoneMDRecord();
                    case 20:
                        return new SVCBRecord();
                    case 21:
                        return new MINFORecord();
                    case 22:
                        return new HTTPSRecord();
                    case 23:
                        return new SPFRecord();
                    case 24:
                        return new TKEYRecord();
                    case 25:
                        return new TSIGRecord();
                    case 26:
                        return new URIRecord();
                    case 27:
                        return new SOARecord();
                    case 28:
                        return new CAARecord();
                    default:
                        return new DLVRecord();
                }
            }
        });
        final int i26 = 12;
        typeMnemonic.add(52, "TLSA", new Supplier() { // from class: org.xbill.DNS.c0
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i26) {
                    case 0:
                        return new APLRecord();
                    case 1:
                        return new DSRecord();
                    case 2:
                        return new SSHFPRecord();
                    case 3:
                        return new MFRecord();
                    case 4:
                        return new IPSECKEYRecord();
                    case 5:
                        return new RRSIGRecord();
                    case 6:
                        return new NSECRecord();
                    case 7:
                        return new DNSKEYRecord();
                    case 8:
                        return new DHCIDRecord();
                    case 9:
                        return new NSEC3Record();
                    case 10:
                        return new HINFORecord();
                    case 11:
                        return new NSEC3PARAMRecord();
                    case 12:
                        return new TLSARecord();
                    case 13:
                        return new SMIMEARecord();
                    case 14:
                        return new HIPRecord();
                    case 15:
                        return new CNAMERecord();
                    case 16:
                        return new CDSRecord();
                    case 17:
                        return new CDNSKEYRecord();
                    case 18:
                        return new OPENPGPKEYRecord();
                    case 19:
                        return new ZoneMDRecord();
                    case 20:
                        return new SVCBRecord();
                    case 21:
                        return new MINFORecord();
                    case 22:
                        return new HTTPSRecord();
                    case 23:
                        return new SPFRecord();
                    case 24:
                        return new TKEYRecord();
                    case 25:
                        return new TSIGRecord();
                    case 26:
                        return new URIRecord();
                    case 27:
                        return new SOARecord();
                    case 28:
                        return new CAARecord();
                    default:
                        return new DLVRecord();
                }
            }
        });
        final int i27 = 13;
        typeMnemonic.add(53, "SMIMEA", new Supplier() { // from class: org.xbill.DNS.c0
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i27) {
                    case 0:
                        return new APLRecord();
                    case 1:
                        return new DSRecord();
                    case 2:
                        return new SSHFPRecord();
                    case 3:
                        return new MFRecord();
                    case 4:
                        return new IPSECKEYRecord();
                    case 5:
                        return new RRSIGRecord();
                    case 6:
                        return new NSECRecord();
                    case 7:
                        return new DNSKEYRecord();
                    case 8:
                        return new DHCIDRecord();
                    case 9:
                        return new NSEC3Record();
                    case 10:
                        return new HINFORecord();
                    case 11:
                        return new NSEC3PARAMRecord();
                    case 12:
                        return new TLSARecord();
                    case 13:
                        return new SMIMEARecord();
                    case 14:
                        return new HIPRecord();
                    case 15:
                        return new CNAMERecord();
                    case 16:
                        return new CDSRecord();
                    case 17:
                        return new CDNSKEYRecord();
                    case 18:
                        return new OPENPGPKEYRecord();
                    case 19:
                        return new ZoneMDRecord();
                    case 20:
                        return new SVCBRecord();
                    case 21:
                        return new MINFORecord();
                    case 22:
                        return new HTTPSRecord();
                    case 23:
                        return new SPFRecord();
                    case 24:
                        return new TKEYRecord();
                    case 25:
                        return new TSIGRecord();
                    case 26:
                        return new URIRecord();
                    case 27:
                        return new SOARecord();
                    case 28:
                        return new CAARecord();
                    default:
                        return new DLVRecord();
                }
            }
        });
        final int i28 = 14;
        typeMnemonic.add(55, "HIP", new Supplier() { // from class: org.xbill.DNS.c0
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i28) {
                    case 0:
                        return new APLRecord();
                    case 1:
                        return new DSRecord();
                    case 2:
                        return new SSHFPRecord();
                    case 3:
                        return new MFRecord();
                    case 4:
                        return new IPSECKEYRecord();
                    case 5:
                        return new RRSIGRecord();
                    case 6:
                        return new NSECRecord();
                    case 7:
                        return new DNSKEYRecord();
                    case 8:
                        return new DHCIDRecord();
                    case 9:
                        return new NSEC3Record();
                    case 10:
                        return new HINFORecord();
                    case 11:
                        return new NSEC3PARAMRecord();
                    case 12:
                        return new TLSARecord();
                    case 13:
                        return new SMIMEARecord();
                    case 14:
                        return new HIPRecord();
                    case 15:
                        return new CNAMERecord();
                    case 16:
                        return new CDSRecord();
                    case 17:
                        return new CDNSKEYRecord();
                    case 18:
                        return new OPENPGPKEYRecord();
                    case 19:
                        return new ZoneMDRecord();
                    case 20:
                        return new SVCBRecord();
                    case 21:
                        return new MINFORecord();
                    case 22:
                        return new HTTPSRecord();
                    case 23:
                        return new SPFRecord();
                    case 24:
                        return new TKEYRecord();
                    case 25:
                        return new TSIGRecord();
                    case 26:
                        return new URIRecord();
                    case 27:
                        return new SOARecord();
                    case 28:
                        return new CAARecord();
                    default:
                        return new DLVRecord();
                }
            }
        });
        typeMnemonic.add(56, "NINFO");
        typeMnemonic.add(57, "RKEY");
        typeMnemonic.add(58, "TALINK");
        final int i29 = 16;
        typeMnemonic.add(59, "CDS", new Supplier() { // from class: org.xbill.DNS.c0
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i29) {
                    case 0:
                        return new APLRecord();
                    case 1:
                        return new DSRecord();
                    case 2:
                        return new SSHFPRecord();
                    case 3:
                        return new MFRecord();
                    case 4:
                        return new IPSECKEYRecord();
                    case 5:
                        return new RRSIGRecord();
                    case 6:
                        return new NSECRecord();
                    case 7:
                        return new DNSKEYRecord();
                    case 8:
                        return new DHCIDRecord();
                    case 9:
                        return new NSEC3Record();
                    case 10:
                        return new HINFORecord();
                    case 11:
                        return new NSEC3PARAMRecord();
                    case 12:
                        return new TLSARecord();
                    case 13:
                        return new SMIMEARecord();
                    case 14:
                        return new HIPRecord();
                    case 15:
                        return new CNAMERecord();
                    case 16:
                        return new CDSRecord();
                    case 17:
                        return new CDNSKEYRecord();
                    case 18:
                        return new OPENPGPKEYRecord();
                    case 19:
                        return new ZoneMDRecord();
                    case 20:
                        return new SVCBRecord();
                    case 21:
                        return new MINFORecord();
                    case 22:
                        return new HTTPSRecord();
                    case 23:
                        return new SPFRecord();
                    case 24:
                        return new TKEYRecord();
                    case 25:
                        return new TSIGRecord();
                    case 26:
                        return new URIRecord();
                    case 27:
                        return new SOARecord();
                    case 28:
                        return new CAARecord();
                    default:
                        return new DLVRecord();
                }
            }
        });
        final int i30 = 17;
        typeMnemonic.add(60, "CDNSKEY", new Supplier() { // from class: org.xbill.DNS.c0
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i30) {
                    case 0:
                        return new APLRecord();
                    case 1:
                        return new DSRecord();
                    case 2:
                        return new SSHFPRecord();
                    case 3:
                        return new MFRecord();
                    case 4:
                        return new IPSECKEYRecord();
                    case 5:
                        return new RRSIGRecord();
                    case 6:
                        return new NSECRecord();
                    case 7:
                        return new DNSKEYRecord();
                    case 8:
                        return new DHCIDRecord();
                    case 9:
                        return new NSEC3Record();
                    case 10:
                        return new HINFORecord();
                    case 11:
                        return new NSEC3PARAMRecord();
                    case 12:
                        return new TLSARecord();
                    case 13:
                        return new SMIMEARecord();
                    case 14:
                        return new HIPRecord();
                    case 15:
                        return new CNAMERecord();
                    case 16:
                        return new CDSRecord();
                    case 17:
                        return new CDNSKEYRecord();
                    case 18:
                        return new OPENPGPKEYRecord();
                    case 19:
                        return new ZoneMDRecord();
                    case 20:
                        return new SVCBRecord();
                    case 21:
                        return new MINFORecord();
                    case 22:
                        return new HTTPSRecord();
                    case 23:
                        return new SPFRecord();
                    case 24:
                        return new TKEYRecord();
                    case 25:
                        return new TSIGRecord();
                    case 26:
                        return new URIRecord();
                    case 27:
                        return new SOARecord();
                    case 28:
                        return new CAARecord();
                    default:
                        return new DLVRecord();
                }
            }
        });
        final int i31 = 18;
        typeMnemonic.add(61, "OPENPGPKEY", new Supplier() { // from class: org.xbill.DNS.c0
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i31) {
                    case 0:
                        return new APLRecord();
                    case 1:
                        return new DSRecord();
                    case 2:
                        return new SSHFPRecord();
                    case 3:
                        return new MFRecord();
                    case 4:
                        return new IPSECKEYRecord();
                    case 5:
                        return new RRSIGRecord();
                    case 6:
                        return new NSECRecord();
                    case 7:
                        return new DNSKEYRecord();
                    case 8:
                        return new DHCIDRecord();
                    case 9:
                        return new NSEC3Record();
                    case 10:
                        return new HINFORecord();
                    case 11:
                        return new NSEC3PARAMRecord();
                    case 12:
                        return new TLSARecord();
                    case 13:
                        return new SMIMEARecord();
                    case 14:
                        return new HIPRecord();
                    case 15:
                        return new CNAMERecord();
                    case 16:
                        return new CDSRecord();
                    case 17:
                        return new CDNSKEYRecord();
                    case 18:
                        return new OPENPGPKEYRecord();
                    case 19:
                        return new ZoneMDRecord();
                    case 20:
                        return new SVCBRecord();
                    case 21:
                        return new MINFORecord();
                    case 22:
                        return new HTTPSRecord();
                    case 23:
                        return new SPFRecord();
                    case 24:
                        return new TKEYRecord();
                    case 25:
                        return new TSIGRecord();
                    case 26:
                        return new URIRecord();
                    case 27:
                        return new SOARecord();
                    case 28:
                        return new CAARecord();
                    default:
                        return new DLVRecord();
                }
            }
        });
        typeMnemonic.add(62, "CSYNC");
        final int i32 = 19;
        typeMnemonic.add(63, "ZONEMD", new Supplier() { // from class: org.xbill.DNS.c0
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i32) {
                    case 0:
                        return new APLRecord();
                    case 1:
                        return new DSRecord();
                    case 2:
                        return new SSHFPRecord();
                    case 3:
                        return new MFRecord();
                    case 4:
                        return new IPSECKEYRecord();
                    case 5:
                        return new RRSIGRecord();
                    case 6:
                        return new NSECRecord();
                    case 7:
                        return new DNSKEYRecord();
                    case 8:
                        return new DHCIDRecord();
                    case 9:
                        return new NSEC3Record();
                    case 10:
                        return new HINFORecord();
                    case 11:
                        return new NSEC3PARAMRecord();
                    case 12:
                        return new TLSARecord();
                    case 13:
                        return new SMIMEARecord();
                    case 14:
                        return new HIPRecord();
                    case 15:
                        return new CNAMERecord();
                    case 16:
                        return new CDSRecord();
                    case 17:
                        return new CDNSKEYRecord();
                    case 18:
                        return new OPENPGPKEYRecord();
                    case 19:
                        return new ZoneMDRecord();
                    case 20:
                        return new SVCBRecord();
                    case 21:
                        return new MINFORecord();
                    case 22:
                        return new HTTPSRecord();
                    case 23:
                        return new SPFRecord();
                    case 24:
                        return new TKEYRecord();
                    case 25:
                        return new TSIGRecord();
                    case 26:
                        return new URIRecord();
                    case 27:
                        return new SOARecord();
                    case 28:
                        return new CAARecord();
                    default:
                        return new DLVRecord();
                }
            }
        });
        final int i33 = 20;
        typeMnemonic.add(64, "SVCB", new Supplier() { // from class: org.xbill.DNS.c0
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i33) {
                    case 0:
                        return new APLRecord();
                    case 1:
                        return new DSRecord();
                    case 2:
                        return new SSHFPRecord();
                    case 3:
                        return new MFRecord();
                    case 4:
                        return new IPSECKEYRecord();
                    case 5:
                        return new RRSIGRecord();
                    case 6:
                        return new NSECRecord();
                    case 7:
                        return new DNSKEYRecord();
                    case 8:
                        return new DHCIDRecord();
                    case 9:
                        return new NSEC3Record();
                    case 10:
                        return new HINFORecord();
                    case 11:
                        return new NSEC3PARAMRecord();
                    case 12:
                        return new TLSARecord();
                    case 13:
                        return new SMIMEARecord();
                    case 14:
                        return new HIPRecord();
                    case 15:
                        return new CNAMERecord();
                    case 16:
                        return new CDSRecord();
                    case 17:
                        return new CDNSKEYRecord();
                    case 18:
                        return new OPENPGPKEYRecord();
                    case 19:
                        return new ZoneMDRecord();
                    case 20:
                        return new SVCBRecord();
                    case 21:
                        return new MINFORecord();
                    case 22:
                        return new HTTPSRecord();
                    case 23:
                        return new SPFRecord();
                    case 24:
                        return new TKEYRecord();
                    case 25:
                        return new TSIGRecord();
                    case 26:
                        return new URIRecord();
                    case 27:
                        return new SOARecord();
                    case 28:
                        return new CAARecord();
                    default:
                        return new DLVRecord();
                }
            }
        });
        final int i34 = 22;
        typeMnemonic.add(65, "HTTPS", new Supplier() { // from class: org.xbill.DNS.c0
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i34) {
                    case 0:
                        return new APLRecord();
                    case 1:
                        return new DSRecord();
                    case 2:
                        return new SSHFPRecord();
                    case 3:
                        return new MFRecord();
                    case 4:
                        return new IPSECKEYRecord();
                    case 5:
                        return new RRSIGRecord();
                    case 6:
                        return new NSECRecord();
                    case 7:
                        return new DNSKEYRecord();
                    case 8:
                        return new DHCIDRecord();
                    case 9:
                        return new NSEC3Record();
                    case 10:
                        return new HINFORecord();
                    case 11:
                        return new NSEC3PARAMRecord();
                    case 12:
                        return new TLSARecord();
                    case 13:
                        return new SMIMEARecord();
                    case 14:
                        return new HIPRecord();
                    case 15:
                        return new CNAMERecord();
                    case 16:
                        return new CDSRecord();
                    case 17:
                        return new CDNSKEYRecord();
                    case 18:
                        return new OPENPGPKEYRecord();
                    case 19:
                        return new ZoneMDRecord();
                    case 20:
                        return new SVCBRecord();
                    case 21:
                        return new MINFORecord();
                    case 22:
                        return new HTTPSRecord();
                    case 23:
                        return new SPFRecord();
                    case 24:
                        return new TKEYRecord();
                    case 25:
                        return new TSIGRecord();
                    case 26:
                        return new URIRecord();
                    case 27:
                        return new SOARecord();
                    case 28:
                        return new CAARecord();
                    default:
                        return new DLVRecord();
                }
            }
        });
        final int i35 = 23;
        typeMnemonic.add(99, "SPF", new Supplier() { // from class: org.xbill.DNS.c0
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i35) {
                    case 0:
                        return new APLRecord();
                    case 1:
                        return new DSRecord();
                    case 2:
                        return new SSHFPRecord();
                    case 3:
                        return new MFRecord();
                    case 4:
                        return new IPSECKEYRecord();
                    case 5:
                        return new RRSIGRecord();
                    case 6:
                        return new NSECRecord();
                    case 7:
                        return new DNSKEYRecord();
                    case 8:
                        return new DHCIDRecord();
                    case 9:
                        return new NSEC3Record();
                    case 10:
                        return new HINFORecord();
                    case 11:
                        return new NSEC3PARAMRecord();
                    case 12:
                        return new TLSARecord();
                    case 13:
                        return new SMIMEARecord();
                    case 14:
                        return new HIPRecord();
                    case 15:
                        return new CNAMERecord();
                    case 16:
                        return new CDSRecord();
                    case 17:
                        return new CDNSKEYRecord();
                    case 18:
                        return new OPENPGPKEYRecord();
                    case 19:
                        return new ZoneMDRecord();
                    case 20:
                        return new SVCBRecord();
                    case 21:
                        return new MINFORecord();
                    case 22:
                        return new HTTPSRecord();
                    case 23:
                        return new SPFRecord();
                    case 24:
                        return new TKEYRecord();
                    case 25:
                        return new TSIGRecord();
                    case 26:
                        return new URIRecord();
                    case 27:
                        return new SOARecord();
                    case 28:
                        return new CAARecord();
                    default:
                        return new DLVRecord();
                }
            }
        });
        typeMnemonic.add(100, "UINFO");
        typeMnemonic.add(101, "UID");
        typeMnemonic.add(102, "GID");
        typeMnemonic.add(103, "UNSPEC");
        typeMnemonic.add(104, "NID");
        typeMnemonic.add(105, CLConstants.ERROR_INVALID_CONTROLS_COMBO);
        typeMnemonic.add(L64, "L64");
        typeMnemonic.add(107, "LP");
        typeMnemonic.add(EUI48, "EUI48");
        typeMnemonic.add(109, "EUI64");
        final int i36 = 24;
        typeMnemonic.add(TKEY, "TKEY", new Supplier() { // from class: org.xbill.DNS.c0
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i36) {
                    case 0:
                        return new APLRecord();
                    case 1:
                        return new DSRecord();
                    case 2:
                        return new SSHFPRecord();
                    case 3:
                        return new MFRecord();
                    case 4:
                        return new IPSECKEYRecord();
                    case 5:
                        return new RRSIGRecord();
                    case 6:
                        return new NSECRecord();
                    case 7:
                        return new DNSKEYRecord();
                    case 8:
                        return new DHCIDRecord();
                    case 9:
                        return new NSEC3Record();
                    case 10:
                        return new HINFORecord();
                    case 11:
                        return new NSEC3PARAMRecord();
                    case 12:
                        return new TLSARecord();
                    case 13:
                        return new SMIMEARecord();
                    case 14:
                        return new HIPRecord();
                    case 15:
                        return new CNAMERecord();
                    case 16:
                        return new CDSRecord();
                    case 17:
                        return new CDNSKEYRecord();
                    case 18:
                        return new OPENPGPKEYRecord();
                    case 19:
                        return new ZoneMDRecord();
                    case 20:
                        return new SVCBRecord();
                    case 21:
                        return new MINFORecord();
                    case 22:
                        return new HTTPSRecord();
                    case 23:
                        return new SPFRecord();
                    case 24:
                        return new TKEYRecord();
                    case 25:
                        return new TSIGRecord();
                    case 26:
                        return new URIRecord();
                    case 27:
                        return new SOARecord();
                    case 28:
                        return new CAARecord();
                    default:
                        return new DLVRecord();
                }
            }
        });
        final int i37 = 25;
        typeMnemonic.add(TSIG, "TSIG", new Supplier() { // from class: org.xbill.DNS.c0
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i37) {
                    case 0:
                        return new APLRecord();
                    case 1:
                        return new DSRecord();
                    case 2:
                        return new SSHFPRecord();
                    case 3:
                        return new MFRecord();
                    case 4:
                        return new IPSECKEYRecord();
                    case 5:
                        return new RRSIGRecord();
                    case 6:
                        return new NSECRecord();
                    case 7:
                        return new DNSKEYRecord();
                    case 8:
                        return new DHCIDRecord();
                    case 9:
                        return new NSEC3Record();
                    case 10:
                        return new HINFORecord();
                    case 11:
                        return new NSEC3PARAMRecord();
                    case 12:
                        return new TLSARecord();
                    case 13:
                        return new SMIMEARecord();
                    case 14:
                        return new HIPRecord();
                    case 15:
                        return new CNAMERecord();
                    case 16:
                        return new CDSRecord();
                    case 17:
                        return new CDNSKEYRecord();
                    case 18:
                        return new OPENPGPKEYRecord();
                    case 19:
                        return new ZoneMDRecord();
                    case 20:
                        return new SVCBRecord();
                    case 21:
                        return new MINFORecord();
                    case 22:
                        return new HTTPSRecord();
                    case 23:
                        return new SPFRecord();
                    case 24:
                        return new TKEYRecord();
                    case 25:
                        return new TSIGRecord();
                    case 26:
                        return new URIRecord();
                    case 27:
                        return new SOARecord();
                    case 28:
                        return new CAARecord();
                    default:
                        return new DLVRecord();
                }
            }
        });
        typeMnemonic.add(IXFR, "IXFR");
        typeMnemonic.add(252, "AXFR");
        typeMnemonic.add(253, "MAILB");
        typeMnemonic.add(254, "MAILA");
        typeMnemonic.add(255, "ANY");
        final int i38 = 26;
        typeMnemonic.add(256, "URI", new Supplier() { // from class: org.xbill.DNS.c0
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i38) {
                    case 0:
                        return new APLRecord();
                    case 1:
                        return new DSRecord();
                    case 2:
                        return new SSHFPRecord();
                    case 3:
                        return new MFRecord();
                    case 4:
                        return new IPSECKEYRecord();
                    case 5:
                        return new RRSIGRecord();
                    case 6:
                        return new NSECRecord();
                    case 7:
                        return new DNSKEYRecord();
                    case 8:
                        return new DHCIDRecord();
                    case 9:
                        return new NSEC3Record();
                    case 10:
                        return new HINFORecord();
                    case 11:
                        return new NSEC3PARAMRecord();
                    case 12:
                        return new TLSARecord();
                    case 13:
                        return new SMIMEARecord();
                    case 14:
                        return new HIPRecord();
                    case 15:
                        return new CNAMERecord();
                    case 16:
                        return new CDSRecord();
                    case 17:
                        return new CDNSKEYRecord();
                    case 18:
                        return new OPENPGPKEYRecord();
                    case 19:
                        return new ZoneMDRecord();
                    case 20:
                        return new SVCBRecord();
                    case 21:
                        return new MINFORecord();
                    case 22:
                        return new HTTPSRecord();
                    case 23:
                        return new SPFRecord();
                    case 24:
                        return new TKEYRecord();
                    case 25:
                        return new TSIGRecord();
                    case 26:
                        return new URIRecord();
                    case 27:
                        return new SOARecord();
                    case 28:
                        return new CAARecord();
                    default:
                        return new DLVRecord();
                }
            }
        });
        final int i39 = 28;
        typeMnemonic.add(CAA, "CAA", new Supplier() { // from class: org.xbill.DNS.c0
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i39) {
                    case 0:
                        return new APLRecord();
                    case 1:
                        return new DSRecord();
                    case 2:
                        return new SSHFPRecord();
                    case 3:
                        return new MFRecord();
                    case 4:
                        return new IPSECKEYRecord();
                    case 5:
                        return new RRSIGRecord();
                    case 6:
                        return new NSECRecord();
                    case 7:
                        return new DNSKEYRecord();
                    case 8:
                        return new DHCIDRecord();
                    case 9:
                        return new NSEC3Record();
                    case 10:
                        return new HINFORecord();
                    case 11:
                        return new NSEC3PARAMRecord();
                    case 12:
                        return new TLSARecord();
                    case 13:
                        return new SMIMEARecord();
                    case 14:
                        return new HIPRecord();
                    case 15:
                        return new CNAMERecord();
                    case 16:
                        return new CDSRecord();
                    case 17:
                        return new CDNSKEYRecord();
                    case 18:
                        return new OPENPGPKEYRecord();
                    case 19:
                        return new ZoneMDRecord();
                    case 20:
                        return new SVCBRecord();
                    case 21:
                        return new MINFORecord();
                    case 22:
                        return new HTTPSRecord();
                    case 23:
                        return new SPFRecord();
                    case 24:
                        return new TKEYRecord();
                    case 25:
                        return new TSIGRecord();
                    case 26:
                        return new URIRecord();
                    case 27:
                        return new SOARecord();
                    case 28:
                        return new CAARecord();
                    default:
                        return new DLVRecord();
                }
            }
        });
        typeMnemonic.add(AVC, "AVC");
        typeMnemonic.add(DOA, "DOA");
        typeMnemonic.add(AMTRELAY, "AMTRELAY");
        typeMnemonic.add(32768, "TA");
        final int i40 = 29;
        typeMnemonic.add(DLV, "DLV", new Supplier() { // from class: org.xbill.DNS.c0
            @Override // java.util.function.Supplier
            public final Object get() {
                switch (i40) {
                    case 0:
                        return new APLRecord();
                    case 1:
                        return new DSRecord();
                    case 2:
                        return new SSHFPRecord();
                    case 3:
                        return new MFRecord();
                    case 4:
                        return new IPSECKEYRecord();
                    case 5:
                        return new RRSIGRecord();
                    case 6:
                        return new NSECRecord();
                    case 7:
                        return new DNSKEYRecord();
                    case 8:
                        return new DHCIDRecord();
                    case 9:
                        return new NSEC3Record();
                    case 10:
                        return new HINFORecord();
                    case 11:
                        return new NSEC3PARAMRecord();
                    case 12:
                        return new TLSARecord();
                    case 13:
                        return new SMIMEARecord();
                    case 14:
                        return new HIPRecord();
                    case 15:
                        return new CNAMERecord();
                    case 16:
                        return new CDSRecord();
                    case 17:
                        return new CDNSKEYRecord();
                    case 18:
                        return new OPENPGPKEYRecord();
                    case 19:
                        return new ZoneMDRecord();
                    case 20:
                        return new SVCBRecord();
                    case 21:
                        return new MINFORecord();
                    case 22:
                        return new HTTPSRecord();
                    case 23:
                        return new SPFRecord();
                    case 24:
                        return new TKEYRecord();
                    case 25:
                        return new TSIGRecord();
                    case 26:
                        return new URIRecord();
                    case 27:
                        return new SOARecord();
                    case 28:
                        return new CAARecord();
                    default:
                        return new DLVRecord();
                }
            }
        });
    }

    private Type() {
    }

    public static void check(int i2) {
        if (!Utils.isUInt16(i2)) {
            throw new InvalidTypeException(i2);
        }
    }

    public static Supplier<Record> getFactory(int i2) {
        return types.getFactory(i2);
    }

    public static boolean isRR(int i2) {
        if (i2 == 41) {
            return false;
        }
        switch (i2) {
            case TKEY /* 249 */:
            case TSIG /* 250 */:
            case IXFR /* 251 */:
            case 252:
            case 253:
            case 254:
            case 255:
                return false;
            default:
                return true;
        }
    }

    public static void register(int i2, String str, Supplier<Record> supplier) {
        types.replace(i2, str, supplier);
    }

    public static String string(int i2) {
        return types.getText(i2);
    }

    public static int value(String str, boolean z) {
        TypeMnemonic typeMnemonic = types;
        int value = typeMnemonic.getValue(str);
        return (value == -1 && z) ? typeMnemonic.getValue(android.support.v4.media.b.C("TYPE", str)) : value;
    }

    public static int value(String str) {
        return value(str, false);
    }
}
