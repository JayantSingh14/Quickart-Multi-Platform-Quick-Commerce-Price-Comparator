package org.xbill.DNS.tools;

import in.juspay.hypernfc.b;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xbill.DNS.CNAMERecord;
import org.xbill.DNS.Cache;
import org.xbill.DNS.DNAMERecord;
import org.xbill.DNS.Header;
import org.xbill.DNS.Message;
import org.xbill.DNS.Name;
import org.xbill.DNS.NameTooLongException;
import org.xbill.DNS.OPTRecord;
import org.xbill.DNS.RRSIGRecord;
import org.xbill.DNS.RRset;
import org.xbill.DNS.Record;
import org.xbill.DNS.SetResponse;
import org.xbill.DNS.TSIG;
import org.xbill.DNS.TSIGRecord;
import org.xbill.DNS.Type;
import org.xbill.DNS.Zone;
import org.xbill.DNS.ZoneTransferException;
import org.xbill.DNS.dnssec.h;

/* loaded from: classes5.dex */
public class jnamed {
    static final int FLAG_DNSSECOK = 1;
    static final int FLAG_SIGONLY = 2;
    Map<Integer, Cache> caches;
    Map<Name, TSIG> tsigs;
    Map<Name, Zone> znames;

    /* JADX WARN: Removed duplicated region for block: B:39:0x00b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public jnamed(java.lang.String r12) throws org.xbill.DNS.ZoneTransferException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 484
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.xbill.DNS.tools.jnamed.<init>(java.lang.String):void");
    }

    private void addAdditional(Message message, int i2) {
        addAdditional2(message, 1, i2);
        addAdditional2(message, 2, i2);
    }

    private void addAdditional2(Message message, int i2, int i3) {
        Iterator<Record> it = message.getSection(i2).iterator();
        while (it.hasNext()) {
            Name additionalName = it.next().getAdditionalName();
            if (additionalName != null) {
                addGlue(message, additionalName, i3);
            }
        }
    }

    private void addCacheNS(Message message, Cache cache, Name name) {
        SetResponse setResponseLookupRecords = cache.lookupRecords(name, 2, 0);
        if (setResponseLookupRecords.isDelegation()) {
            Iterator<Record> it = setResponseLookupRecords.getNS().rrs().iterator();
            while (it.hasNext()) {
                message.addRecord(it.next(), 2);
            }
        }
    }

    private void addGlue(Message message, Name name, int i2) {
        RRset rRsetFindExactMatch = findExactMatch(name, 1, 1, true);
        if (rRsetFindExactMatch == null) {
            return;
        }
        addRRset(name, message, rRsetFindExactMatch, 3, i2);
    }

    private void addNS(Message message, Zone zone, int i2) {
        RRset ns = zone.getNS();
        addRRset(ns.getName(), message, ns, 2, i2);
    }

    private void addSOA(Message message, Zone zone) {
        message.addRecord(zone.getSOA(), 2);
    }

    private static String addrport(InetAddress inetAddress, int i2) {
        return inetAddress.getHostAddress() + "#" + i2;
    }

    public static void main(String[] strArr) {
        if (strArr.length > 1) {
            System.out.println("usage: jnamed [conf]");
            System.exit(0);
        }
        try {
            new jnamed(strArr.length == 1 ? strArr[0] : "jnamed.conf");
        } catch (IOException | ZoneTransferException e2) {
            System.out.println(e2);
        }
    }

    /* renamed from: TCPclient, reason: merged with bridge method [inline-methods] */
    public void lambda$serveTCP$0(Socket socket) throws IOException {
        byte[] bArrFormerrMessage;
        try {
            InputStream inputStream = socket.getInputStream();
            try {
                DataInputStream dataInputStream = new DataInputStream(inputStream);
                byte[] bArr = new byte[dataInputStream.readUnsignedShort()];
                dataInputStream.readFully(bArr);
                try {
                    bArrFormerrMessage = generateReply(new Message(bArr), bArr, socket);
                    if (bArrFormerrMessage == null) {
                        if (inputStream != null) {
                            inputStream.close();
                            return;
                        }
                        return;
                    }
                } catch (IOException unused) {
                    bArrFormerrMessage = formerrMessage(bArr);
                }
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                dataOutputStream.writeShort(bArrFormerrMessage.length);
                dataOutputStream.write(bArrFormerrMessage);
                if (inputStream != null) {
                    inputStream.close();
                }
            } finally {
            }
        } catch (IOException e2) {
            System.out.println("TCPclient(" + addrport(socket.getLocalAddress(), socket.getLocalPort()) + "): " + e2);
        }
    }

    public byte addAnswer(Message message, Name name, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        if (i4 > 6) {
            return (byte) 0;
        }
        if (i2 == 24 || i2 == 46) {
            i6 = i5 | 2;
            i7 = 255;
        } else {
            i6 = i5;
            i7 = i2;
        }
        Zone zoneFindBestZone = findBestZone(name);
        SetResponse setResponseFindRecords = zoneFindBestZone != null ? zoneFindBestZone.findRecords(name, i7) : getCache(i3).lookupRecords(name, i7, 3);
        if (setResponseFindRecords.isUnknown()) {
            addCacheNS(message, getCache(i3), name);
        }
        if (setResponseFindRecords.isNXDOMAIN()) {
            message.getHeader().setRcode(3);
            if (zoneFindBestZone != null) {
                addSOA(message, zoneFindBestZone);
                if (i4 == 0) {
                    message.getHeader().setFlag(5);
                }
            }
            return (byte) 3;
        }
        if (setResponseFindRecords.isNXRRSET()) {
            if (zoneFindBestZone != null) {
                addSOA(message, zoneFindBestZone);
                if (i4 == 0) {
                    message.getHeader().setFlag(5);
                    return (byte) 0;
                }
            }
        } else {
            if (setResponseFindRecords.isDelegation()) {
                RRset ns = setResponseFindRecords.getNS();
                addRRset(ns.getName(), message, ns, 2, i6);
                return (byte) 0;
            }
            if (setResponseFindRecords.isCNAME()) {
                CNAMERecord cname = setResponseFindRecords.getCNAME();
                addRRset(name, message, new RRset(cname), 1, i6);
                if (zoneFindBestZone != null && i4 == 0) {
                    message.getHeader().setFlag(5);
                }
                return addAnswer(message, cname.getTarget(), i7, i3, i4 + 1, i6);
            }
            int i8 = i7;
            if (setResponseFindRecords.isDNAME()) {
                DNAMERecord dname = setResponseFindRecords.getDNAME();
                addRRset(name, message, new RRset(dname), 1, i6);
                int i9 = i6;
                try {
                    Name nameFromDNAME = name.fromDNAME(dname);
                    addRRset(name, message, new RRset(new CNAMERecord(name, i3, 0L, nameFromDNAME)), 1, i9);
                    if (zoneFindBestZone != null && i4 == 0) {
                        message.getHeader().setFlag(5);
                    }
                    return addAnswer(message, nameFromDNAME, i8, i3, i4 + 1, i9);
                } catch (NameTooLongException unused) {
                    return (byte) 6;
                }
            }
            if (setResponseFindRecords.isSuccessful()) {
                Iterator<RRset> it = setResponseFindRecords.answers().iterator();
                while (it.hasNext()) {
                    addRRset(name, message, it.next(), 1, i6);
                }
                if (zoneFindBestZone != null) {
                    addNS(message, zoneFindBestZone, i6);
                    if (i4 == 0) {
                        message.getHeader().setFlag(5);
                        return (byte) 0;
                    }
                } else {
                    addCacheNS(message, getCache(i3), name);
                }
            }
        }
        return (byte) 0;
    }

    public void addPrimaryZone(String str, String str2) throws IOException {
        Zone zone = new Zone(str != null ? Name.fromString(str, Name.root) : null, str2);
        this.znames.put(zone.getOrigin(), zone);
    }

    public void addRRset(Name name, Message message, RRset rRset, int i2, int i3) {
        for (int i4 = 1; i4 <= i2; i4++) {
            if (message.findRRset(name, rRset.getType(), i4)) {
                return;
            }
        }
        if ((i3 & 2) == 0) {
            for (Record recordWithName : rRset.rrs()) {
                if (recordWithName.getName().isWild() && !name.isWild()) {
                    recordWithName = recordWithName.withName(name);
                }
                message.addRecord(recordWithName, i2);
            }
        }
        if ((i3 & 3) != 0) {
            for (RRSIGRecord rRSIGRecordWithName : rRset.sigs()) {
                if (rRSIGRecordWithName.getName().isWild() && !name.isWild()) {
                    rRSIGRecordWithName = rRSIGRecordWithName.withName(name);
                }
                message.addRecord(rRSIGRecordWithName, i2);
            }
        }
    }

    public void addSecondaryZone(String str, String str2) throws ZoneTransferException, IOException {
        Name nameFromString = Name.fromString(str, Name.root);
        this.znames.put(nameFromString, new Zone(nameFromString, 1, str2));
    }

    public void addTCP(InetAddress inetAddress, int i2) {
        new Thread(new a(this, inetAddress, i2, 0)).start();
    }

    public void addTSIG(String str, String str2, String str3) throws IOException {
        this.tsigs.put(Name.fromString(str2, Name.root), new TSIG(str, str2, str3));
    }

    public void addUDP(InetAddress inetAddress, int i2) {
        new Thread(new a(this, inetAddress, i2, 1)).start();
    }

    public byte[] buildErrorMessage(Header header, int i2, Record record) {
        Message message = new Message();
        message.setHeader(header);
        for (int i3 = 0; i3 < 4; i3++) {
            message.removeAllRecords(i3);
        }
        if (i2 == 2) {
            message.addRecord(record, 0);
        }
        header.setRcode(i2);
        return message.toWire();
    }

    public byte[] doAXFR(Name name, Message message, TSIG tsig, TSIGRecord tSIGRecord, Socket socket) throws IOException {
        Zone zone = this.znames.get(name);
        if (zone == null) {
            return errorMessage(message, 5);
        }
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            int id = message.getHeader().getID();
            Iterator<RRset> itAXFR = zone.AXFR();
            boolean z = true;
            TSIGRecord tsig2 = tSIGRecord;
            while (itAXFR.hasNext()) {
                RRset next = itAXFR.next();
                Message message2 = new Message(id);
                Header header = message2.getHeader();
                header.setFlag(0);
                header.setFlag(5);
                addRRset(next.getName(), message2, next, 1, 1);
                if (tsig != null) {
                    tsig.apply(message2, tsig2, z);
                    tsig2 = message2.getTSIG();
                }
                byte[] wire = message2.toWire();
                dataOutputStream.writeShort(wire.length);
                dataOutputStream.write(wire);
                z = false;
            }
        } catch (IOException unused) {
            System.out.println("AXFR failed");
        }
        try {
            socket.close();
            return null;
        } catch (IOException unused2) {
            return null;
        }
    }

    public byte[] errorMessage(Message message, int i2) {
        return buildErrorMessage(message.getHeader(), i2, message.getQuestion());
    }

    public Zone findBestZone(Name name) {
        Zone zone = this.znames.get(name);
        if (zone != null) {
            return zone;
        }
        int iLabels = name.labels();
        for (int i2 = 1; i2 < iLabels; i2++) {
            Zone zone2 = this.znames.get(new Name(name, i2));
            if (zone2 != null) {
                return zone2;
            }
        }
        return null;
    }

    public RRset findExactMatch(Name name, int i2, int i3, boolean z) {
        Zone zoneFindBestZone = findBestZone(name);
        if (zoneFindBestZone != null) {
            return zoneFindBestZone.findExactMatch(name, i2);
        }
        Cache cache = getCache(i3);
        List<RRset> listFindAnyRecords = z ? cache.findAnyRecords(name, i2) : cache.findRecords(name, i2);
        if (listFindAnyRecords == null) {
            return null;
        }
        return listFindAnyRecords.get(0);
    }

    public byte[] formerrMessage(byte[] bArr) {
        try {
            return buildErrorMessage(new Header(bArr), 1, null);
        } catch (IOException unused) {
            return null;
        }
    }

    public byte[] generateReply(Message message, byte[] bArr, Socket socket) {
        int iMax;
        Header header = message.getHeader();
        TSIG tsig = null;
        if (header.getFlag(0)) {
            return null;
        }
        if (header.getRcode() != 0) {
            return errorMessage(message, 1);
        }
        if (header.getOpcode() != 0) {
            return errorMessage(message, 4);
        }
        Record question = message.getQuestion();
        TSIGRecord tsig2 = message.getTSIG();
        if (tsig2 != null) {
            TSIG tsig3 = this.tsigs.get(tsig2.getName());
            if (tsig3 == null || tsig3.verify(message, bArr, null) != 0) {
                return formerrMessage(bArr);
            }
            tsig = tsig3;
        }
        OPTRecord opt = message.getOPT();
        if (socket != null) {
            iMax = Message.MAXLENGTH;
        } else {
            iMax = 512;
            if (opt != null) {
                iMax = Math.max(opt.getPayloadSize(), 512);
            }
        }
        int i2 = iMax;
        int i3 = (opt == null || (opt.getFlags() & 32768) == 0) ? 0 : 1;
        Message message2 = new Message(message.getHeader().getID());
        message2.getHeader().setFlag(0);
        if (message.getHeader().getFlag(7)) {
            message2.getHeader().setFlag(7);
        }
        message2.addRecord(question, 0);
        Name name = question.getName();
        int type = question.getType();
        int dClass = question.getDClass();
        if (type == 252 && socket != null) {
            return doAXFR(name, message, tsig, tsig2, socket);
        }
        TSIG tsig4 = tsig;
        if (!Type.isRR(type) && type != 255) {
            return errorMessage(message, 4);
        }
        int i4 = i3;
        byte bAddAnswer = addAnswer(message2, name, type, dClass, 0, i4);
        if (bAddAnswer != 0 && bAddAnswer != 3) {
            return errorMessage(message, bAddAnswer);
        }
        addAdditional(message2, i4);
        if (opt != null) {
            message2.addRecord(new OPTRecord(4096, bAddAnswer, 0, i4 != 1 ? 0 : 32768), 3);
        }
        message2.setTSIG(tsig4, 0, tsig2);
        return message2.toWire(i2);
    }

    public Cache getCache(int i2) {
        return this.caches.computeIfAbsent(Integer.valueOf(i2), new h(5));
    }

    /* renamed from: serveTCP, reason: merged with bridge method [inline-methods] */
    public void lambda$addTCP$1(InetAddress inetAddress, int i2) {
        try {
            while (true) {
                try {
                    new Thread(new b(28, this, new ServerSocket(i2, 128, inetAddress).accept())).start();
                } finally {
                }
            }
        } catch (IOException e2) {
            System.out.println("serveTCP(" + addrport(inetAddress, i2) + "): " + e2);
        }
    }

    /* renamed from: serveUDP, reason: merged with bridge method [inline-methods] */
    public void lambda$addUDP$2(InetAddress inetAddress, int i2) {
        byte[] bArrFormerrMessage;
        try {
            DatagramSocket datagramSocket = new DatagramSocket(i2, inetAddress);
            try {
                byte[] bArr = new byte[512];
                DatagramPacket datagramPacket = new DatagramPacket(bArr, 512);
                DatagramPacket datagramPacket2 = null;
                while (true) {
                    datagramPacket.setLength(512);
                    try {
                        datagramSocket.receive(datagramPacket);
                        try {
                            bArrFormerrMessage = generateReply(new Message(bArr), bArr, null);
                        } catch (IOException unused) {
                            bArrFormerrMessage = formerrMessage(bArr);
                        }
                    } catch (InterruptedIOException unused2) {
                    }
                    if (bArrFormerrMessage != null) {
                        if (datagramPacket2 == null) {
                            datagramPacket2 = new DatagramPacket(bArrFormerrMessage, bArrFormerrMessage.length, datagramPacket.getAddress(), datagramPacket.getPort());
                        } else {
                            datagramPacket2.setData(bArrFormerrMessage);
                            datagramPacket2.setLength(bArrFormerrMessage.length);
                            datagramPacket2.setAddress(datagramPacket.getAddress());
                            datagramPacket2.setPort(datagramPacket.getPort());
                        }
                        datagramSocket.send(datagramPacket2);
                    }
                }
            } finally {
            }
        } catch (IOException e2) {
            System.out.println("serveUDP(" + addrport(inetAddress, i2) + "): " + e2);
        }
    }
}
