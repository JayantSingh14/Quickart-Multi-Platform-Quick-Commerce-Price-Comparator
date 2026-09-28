package org.xbill.DNS;

import com.google.android.gms.common.Scopes;
import in.juspay.hypersdk.core.PaymentConstants;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import org.apache.commons.lang3.StringUtils;
import org.xbill.DNS.Tokenizer;

/* loaded from: classes5.dex */
public class WKSRecord extends Record {
    private byte[] address;
    private int protocol;
    private int[] services;

    public static class Protocol {
        public static final int ARGUS = 13;
        public static final int BBN_RCC_MON = 10;
        public static final int BR_SAT_MON = 76;
        public static final int CFTP = 62;
        public static final int CHAOS = 16;
        public static final int DCN_MEAS = 19;
        public static final int EGP = 8;
        public static final int EMCON = 14;
        public static final int GGP = 3;
        public static final int HMP = 20;
        public static final int ICMP = 1;
        public static final int IGMP = 2;
        public static final int IGP = 9;
        public static final int IPCV = 71;
        public static final int IPPC = 67;
        public static final int IRTP = 28;
        public static final int ISO_TP4 = 29;
        public static final int LEAF_1 = 25;
        public static final int LEAF_2 = 26;
        public static final int MERIT_INP = 32;
        public static final int MFE_NSP = 31;
        public static final int MIT_SUBNET = 65;
        public static final int MUX = 18;
        public static final int NETBLT = 30;
        public static final int NVP_II = 11;
        public static final int PRM = 21;
        public static final int PUP = 12;
        public static final int RDP = 27;
        public static final int RVD = 66;
        public static final int SAT_EXPAK = 64;
        public static final int SAT_MON = 69;
        public static final int SEP = 33;
        public static final int ST = 5;
        public static final int TCP = 6;
        public static final int TRUNK_1 = 23;
        public static final int TRUNK_2 = 24;
        public static final int UCL = 7;
        public static final int UDP = 17;
        public static final int WB_EXPAK = 79;
        public static final int WB_MON = 78;
        public static final int XNET = 15;
        public static final int XNS_IDP = 22;
        private static final Mnemonic protocols;

        static {
            Mnemonic mnemonic = new Mnemonic("IP protocol", 3);
            protocols = mnemonic;
            mnemonic.setMaximum(255);
            mnemonic.setNumericAllowed(true);
            mnemonic.add(1, "icmp");
            mnemonic.add(2, "igmp");
            mnemonic.add(3, "ggp");
            mnemonic.add(5, "st");
            mnemonic.add(6, "tcp");
            mnemonic.add(7, "ucl");
            mnemonic.add(8, "egp");
            mnemonic.add(9, "igp");
            mnemonic.add(10, "bbn-rcc-mon");
            mnemonic.add(11, "nvp-ii");
            mnemonic.add(12, "pup");
            mnemonic.add(13, "argus");
            mnemonic.add(14, "emcon");
            mnemonic.add(15, "xnet");
            mnemonic.add(16, "chaos");
            mnemonic.add(17, "udp");
            mnemonic.add(18, "mux");
            mnemonic.add(19, "dcn-meas");
            mnemonic.add(20, "hmp");
            mnemonic.add(21, "prm");
            mnemonic.add(22, "xns-idp");
            mnemonic.add(23, "trunk-1");
            mnemonic.add(24, "trunk-2");
            mnemonic.add(25, "leaf-1");
            mnemonic.add(26, "leaf-2");
            mnemonic.add(27, "rdp");
            mnemonic.add(28, "irtp");
            mnemonic.add(29, "iso-tp4");
            mnemonic.add(30, "netblt");
            mnemonic.add(31, "mfe-nsp");
            mnemonic.add(32, "merit-inp");
            mnemonic.add(33, "sep");
            mnemonic.add(62, "cftp");
            mnemonic.add(64, "sat-expak");
            mnemonic.add(65, "mit-subnet");
            mnemonic.add(66, "rvd");
            mnemonic.add(67, "ippc");
            mnemonic.add(69, "sat-mon");
            mnemonic.add(71, "ipcv");
            mnemonic.add(76, "br-sat-mon");
            mnemonic.add(78, "wb-mon");
            mnemonic.add(79, "wb-expak");
        }

        private Protocol() {
        }

        public static String string(int i2) {
            return protocols.getText(i2);
        }

        public static int value(String str) {
            return protocols.getValue(str);
        }
    }

    public static class Service {
        public static final int AUTH = 113;
        public static final int BL_IDM = 142;
        public static final int BOOTPC = 68;
        public static final int BOOTPS = 67;
        public static final int CHARGEN = 19;
        public static final int CISCO_FNA = 130;
        public static final int CISCO_SYS = 132;
        public static final int CISCO_TNA = 131;
        public static final int CSNET_NS = 105;
        public static final int DAYTIME = 13;
        public static final int DCP = 93;
        public static final int DISCARD = 9;
        public static final int DOMAIN = 53;
        public static final int DSP = 33;
        public static final int ECHO = 7;
        public static final int EMFIS_CNTL = 141;
        public static final int EMFIS_DATA = 140;
        public static final int ERPC = 121;
        public static final int FINGER = 79;
        public static final int FTP = 21;
        public static final int FTP_DATA = 20;
        public static final int GRAPHICS = 41;
        public static final int HOSTNAME = 101;
        public static final int HOSTS2_NS = 81;
        public static final int INGRES_NET = 134;
        public static final int ISI_GL = 55;
        public static final int ISO_TSAP = 102;
        public static final int LA_MAINT = 51;
        public static final int LINK = 245;
        public static final int LOCUS_CON = 127;
        public static final int LOCUS_MAP = 125;
        public static final int LOC_SRV = 135;
        public static final int LOGIN = 49;
        public static final int METAGRAM = 99;
        public static final int MIT_DOV = 91;
        public static final int MPM = 45;
        public static final int MPM_FLAGS = 44;
        public static final int MPM_SND = 46;
        public static final int MSG_AUTH = 31;
        public static final int MSG_ICP = 29;
        public static final int NAMESERVER = 42;
        public static final int NETBIOS_DGM = 138;
        public static final int NETBIOS_NS = 137;
        public static final int NETBIOS_SSN = 139;
        public static final int NETRJS_1 = 71;
        public static final int NETRJS_2 = 72;
        public static final int NETRJS_3 = 73;
        public static final int NETRJS_4 = 74;
        public static final int NICNAME = 43;
        public static final int NI_FTP = 47;
        public static final int NI_MAIL = 61;
        public static final int NNTP = 119;
        public static final int NSW_FE = 27;
        public static final int NTP = 123;
        public static final int POP_2 = 109;
        public static final int PROFILE = 136;
        public static final int PWDGEN = 129;
        public static final int QUOTE = 17;
        public static final int RJE = 5;
        public static final int RLP = 39;
        public static final int RTELNET = 107;
        public static final int SFTP = 115;
        public static final int SMTP = 25;
        public static final int STATSRV = 133;
        public static final int SUNRPC = 111;
        public static final int SUPDUP = 95;
        public static final int SUR_MEAS = 243;
        public static final int SU_MIT_TG = 89;
        public static final int SWIFT_RVF = 97;
        public static final int TACACS_DS = 65;
        public static final int TACNEWS = 98;
        public static final int TELNET = 23;
        public static final int TFTP = 69;
        public static final int TIME = 37;
        public static final int USERS = 11;
        public static final int UUCP_PATH = 117;
        public static final int VIA_FTP = 63;
        public static final int X400 = 103;
        public static final int X400_SND = 104;
        private static final Mnemonic services;

        static {
            Mnemonic mnemonic = new Mnemonic("TCP/UDP service", 3);
            services = mnemonic;
            mnemonic.setMaximum(Message.MAXLENGTH);
            mnemonic.setNumericAllowed(true);
            mnemonic.add(5, "rje");
            mnemonic.add(7, "echo");
            mnemonic.add(9, "discard");
            mnemonic.add(11, "users");
            mnemonic.add(13, "daytime");
            mnemonic.add(17, "quote");
            mnemonic.add(19, "chargen");
            mnemonic.add(20, "ftp-data");
            mnemonic.add(21, "ftp");
            mnemonic.add(23, "telnet");
            mnemonic.add(25, "smtp");
            mnemonic.add(27, "nsw-fe");
            mnemonic.add(29, "msg-icp");
            mnemonic.add(31, "msg-auth");
            mnemonic.add(33, "dsp");
            mnemonic.add(37, "time");
            mnemonic.add(39, "rlp");
            mnemonic.add(41, "graphics");
            mnemonic.add(42, "nameserver");
            mnemonic.add(43, "nicname");
            mnemonic.add(44, "mpm-flags");
            mnemonic.add(45, "mpm");
            mnemonic.add(46, "mpm-snd");
            mnemonic.add(47, "ni-ftp");
            mnemonic.add(49, "login");
            mnemonic.add(51, "la-maint");
            mnemonic.add(53, "domain");
            mnemonic.add(55, "isi-gl");
            mnemonic.add(61, "ni-mail");
            mnemonic.add(63, "via-ftp");
            mnemonic.add(65, "tacacs-ds");
            mnemonic.add(67, "bootps");
            mnemonic.add(68, "bootpc");
            mnemonic.add(69, "tftp");
            mnemonic.add(71, "netrjs-1");
            mnemonic.add(72, "netrjs-2");
            mnemonic.add(73, "netrjs-3");
            mnemonic.add(74, "netrjs-4");
            mnemonic.add(79, "finger");
            mnemonic.add(81, "hosts2-ns");
            mnemonic.add(89, "su-mit-tg");
            mnemonic.add(91, "mit-dov");
            mnemonic.add(93, "dcp");
            mnemonic.add(95, "supdup");
            mnemonic.add(97, "swift-rvf");
            mnemonic.add(98, "tacnews");
            mnemonic.add(99, "metagram");
            mnemonic.add(101, "hostname");
            mnemonic.add(102, "iso-tsap");
            mnemonic.add(103, "x400");
            mnemonic.add(104, "x400-snd");
            mnemonic.add(105, "csnet-ns");
            mnemonic.add(107, "rtelnet");
            mnemonic.add(109, "pop-2");
            mnemonic.add(SUNRPC, "sunrpc");
            mnemonic.add(AUTH, "auth");
            mnemonic.add(SFTP, "sftp");
            mnemonic.add(UUCP_PATH, "uucp-path");
            mnemonic.add(NNTP, "nntp");
            mnemonic.add(ERPC, "erpc");
            mnemonic.add(NTP, "ntp");
            mnemonic.add(LOCUS_MAP, "locus-map");
            mnemonic.add(LOCUS_CON, "locus-con");
            mnemonic.add(PWDGEN, "pwdgen");
            mnemonic.add(CISCO_FNA, "cisco-fna");
            mnemonic.add(CISCO_TNA, "cisco-tna");
            mnemonic.add(CISCO_SYS, "cisco-sys");
            mnemonic.add(STATSRV, "statsrv");
            mnemonic.add(INGRES_NET, "ingres-net");
            mnemonic.add(LOC_SRV, "loc-srv");
            mnemonic.add(PROFILE, Scopes.PROFILE);
            mnemonic.add(NETBIOS_NS, "netbios-ns");
            mnemonic.add(NETBIOS_DGM, "netbios-dgm");
            mnemonic.add(NETBIOS_SSN, "netbios-ssn");
            mnemonic.add(EMFIS_DATA, "emfis-data");
            mnemonic.add(EMFIS_CNTL, "emfis-cntl");
            mnemonic.add(BL_IDM, "bl-idm");
            mnemonic.add(SUR_MEAS, "sur-meas");
            mnemonic.add(LINK, "link");
        }

        private Service() {
        }

        public static String string(int i2) {
            return services.getText(i2);
        }

        public static int value(String str) {
            return services.getValue(str);
        }
    }

    public WKSRecord() {
    }

    public InetAddress getAddress() {
        try {
            return InetAddress.getByAddress(this.address);
        } catch (UnknownHostException unused) {
            return null;
        }
    }

    public int getProtocol() {
        return this.protocol;
    }

    public int[] getServices() {
        return this.services;
    }

    @Override // org.xbill.DNS.Record
    public void rdataFromString(Tokenizer tokenizer, Name name) throws IOException {
        byte[] byteArray = Address.toByteArray(tokenizer.getString(), 1);
        this.address = byteArray;
        if (byteArray == null) {
            throw tokenizer.exception("invalid address");
        }
        String string = tokenizer.getString();
        int iValue = Protocol.value(string);
        this.protocol = iValue;
        if (iValue < 0) {
            throw tokenizer.exception("Invalid IP protocol: " + string);
        }
        ArrayList arrayList = new ArrayList();
        while (true) {
            Tokenizer.Token token = tokenizer.get();
            if (!token.isString()) {
                tokenizer.unget();
                this.services = new int[arrayList.size()];
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    this.services[i2] = ((Integer) arrayList.get(i2)).intValue();
                }
                return;
            }
            int iValue2 = Service.value(token.value());
            if (iValue2 < 0) {
                throw tokenizer.exception("Invalid TCP/UDP service: " + token.value());
            }
            arrayList.add(Integer.valueOf(iValue2));
        }
    }

    @Override // org.xbill.DNS.Record
    public void rrFromWire(DNSInput dNSInput) throws IOException {
        this.address = dNSInput.readByteArray(4);
        this.protocol = dNSInput.readU8();
        byte[] byteArray = dNSInput.readByteArray();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < byteArray.length; i2++) {
            for (int i3 = 0; i3 < 8; i3++) {
                if ((byteArray[i2] & 255 & (1 << (7 - i3))) != 0) {
                    arrayList.add(Integer.valueOf((i2 * 8) + i3));
                }
            }
        }
        this.services = new int[arrayList.size()];
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            this.services[i4] = ((Integer) arrayList.get(i4)).intValue();
        }
    }

    @Override // org.xbill.DNS.Record
    public String rrToString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Address.toDottedQuad(this.address));
        sb.append(StringUtils.SPACE);
        sb.append(this.protocol);
        for (int i2 : this.services) {
            sb.append(StringUtils.SPACE);
            sb.append(i2);
        }
        return sb.toString();
    }

    @Override // org.xbill.DNS.Record
    public void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        dNSOutput.writeByteArray(this.address);
        dNSOutput.writeU8(this.protocol);
        int[] iArr = this.services;
        byte[] bArr = new byte[(iArr[iArr.length - 1] / 8) + 1];
        for (int i2 : iArr) {
            int i3 = i2 / 8;
            bArr[i3] = (byte) ((1 << (7 - (i2 % 8))) | bArr[i3]);
        }
        dNSOutput.writeByteArray(bArr);
    }

    public WKSRecord(Name name, int i2, long j2, InetAddress inetAddress, int i3, int[] iArr) {
        super(name, 11, i2, j2);
        if (Address.familyOf(inetAddress) != 1) {
            throw new IllegalArgumentException("invalid IPv4 address");
        }
        this.address = inetAddress.getAddress();
        this.protocol = Record.checkU8("protocol", i3);
        for (int i4 : iArr) {
            Record.checkU16(PaymentConstants.SERVICE, i4);
        }
        int[] iArr2 = new int[iArr.length];
        this.services = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        Arrays.sort(this.services);
    }
}
