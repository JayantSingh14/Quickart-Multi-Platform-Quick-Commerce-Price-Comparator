package org.xbill.DNS;

import j$.time.Duration;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xbill.DNS.TSIG;

/* loaded from: classes5.dex */
public class ZoneTransferIn {
    private static final int AXFR = 6;
    private static final int END = 7;
    private static final int FIRSTDATA = 1;
    private static final int INITIALSOA = 0;
    private static final int IXFR_ADD = 5;
    private static final int IXFR_ADDSOA = 4;
    private static final int IXFR_DEL = 3;
    private static final int IXFR_DELSOA = 2;

    @Generated
    private static final Logger log = LoggerFactory.b(ZoneTransferIn.class);
    private final SocketAddress address;
    private TCPClient client;
    private long currentSerial;
    private int dclass;
    private long endSerial;
    private ZoneTransferHandler handler;
    private Record initialSoaRecord;
    private final long ixfrSerial;
    private SocketAddress localAddress;
    private int qtype;
    private int rtype;
    private int state;
    private Duration timeout = Duration.ofMinutes(15);
    private final TSIG tsig;
    private TSIG.StreamVerifier verifier;
    private final boolean wantFallback;
    private final Name zname;

    public static class BasicHandler implements ZoneTransferHandler {
        private List<Record> axfr;
        private List<Delta> ixfr;

        private BasicHandler() {
        }

        @Override // org.xbill.DNS.ZoneTransferIn.ZoneTransferHandler
        public void handleRecord(Record record) {
            List<Delta> list = this.ixfr;
            if (list == null) {
                this.axfr.add(record);
                return;
            }
            Delta delta = (Delta) androidx.fragment.app.e.k(1, list);
            if (delta.adds.isEmpty()) {
                delta.deletes.add(record);
            } else {
                delta.adds.add(record);
            }
        }

        @Override // org.xbill.DNS.ZoneTransferIn.ZoneTransferHandler
        public void startAXFR() {
            this.axfr = new ArrayList();
        }

        @Override // org.xbill.DNS.ZoneTransferIn.ZoneTransferHandler
        public void startIXFR() {
            this.ixfr = new ArrayList();
        }

        @Override // org.xbill.DNS.ZoneTransferIn.ZoneTransferHandler
        public void startIXFRAdds(Record record) {
            Delta delta = (Delta) androidx.fragment.app.e.k(1, this.ixfr);
            delta.adds.add(record);
            delta.end = ZoneTransferIn.getSOASerial(record);
        }

        @Override // org.xbill.DNS.ZoneTransferIn.ZoneTransferHandler
        public void startIXFRDeletes(Record record) {
            Delta delta = new Delta();
            delta.deletes.add(record);
            delta.start = ZoneTransferIn.getSOASerial(record);
            this.ixfr.add(delta);
        }
    }

    public static class Delta {
        public List<Record> adds;
        public List<Record> deletes;
        public long end;
        public long start;

        private Delta() {
            this.adds = new ArrayList();
            this.deletes = new ArrayList();
        }
    }

    public interface ZoneTransferHandler {
        void handleRecord(Record record) throws ZoneTransferException;

        void startAXFR() throws ZoneTransferException;

        void startIXFR() throws ZoneTransferException;

        void startIXFRAdds(Record record) throws ZoneTransferException;

        void startIXFRDeletes(Record record) throws ZoneTransferException;
    }

    public ZoneTransferIn(Name name, int i2, long j2, boolean z, SocketAddress socketAddress, TSIG tsig) {
        this.address = socketAddress;
        this.tsig = tsig;
        if (name.isAbsolute()) {
            this.zname = name;
        } else {
            try {
                this.zname = Name.concatenate(name, Name.root);
            } catch (NameTooLongException unused) {
                throw new IllegalArgumentException("ZoneTransferIn: name too long");
            }
        }
        this.qtype = i2;
        this.dclass = 1;
        this.ixfrSerial = j2;
        this.wantFallback = z;
        this.state = 0;
    }

    private void closeConnection() {
        try {
            TCPClient tCPClient = this.client;
            if (tCPClient != null) {
                tCPClient.close();
            }
        } catch (IOException unused) {
        }
    }

    private void doxfr() throws ZoneTransferException, IllegalStateException, NoSuchAlgorithmException, IOException, InvalidKeyException {
        TSIG.StreamVerifier streamVerifier;
        sendQuery();
        while (this.state != 7) {
            byte[] bArrRecv = this.client.recv();
            Message message = parseMessage(bArrRecv);
            List<Record> section = message.getSection(1);
            if (message.getHeader().getRcode() == 0 && (streamVerifier = this.verifier) != null) {
                int iVerify = streamVerifier.verify(message, bArrRecv, ((Record) androidx.fragment.app.e.k(1, section)).getType() == 6);
                if (iVerify != 0) {
                    if (this.verifier.getErrorMessage() != null) {
                        fail("TSIG failure: " + Rcode.TSIGstring(iVerify) + " (" + this.verifier.getErrorMessage() + ")");
                    } else {
                        fail("TSIG failure: " + Rcode.TSIGstring(iVerify));
                    }
                }
            }
            if (this.state == 0) {
                int rcode = message.getRcode();
                if (rcode != 0) {
                    if (this.qtype == 251 && rcode == 4) {
                        fallback();
                        doxfr();
                        return;
                    }
                    fail(Rcode.string(rcode));
                }
                Record question = message.getQuestion();
                if (question != null && question.getType() != this.qtype) {
                    fail("invalid question section");
                }
                if (section.isEmpty() && this.qtype == 251) {
                    fallback();
                    doxfr();
                    return;
                }
            }
            Iterator<Record> it = section.iterator();
            while (it.hasNext()) {
                parseRR(it.next());
            }
        }
    }

    private void fail(String str) throws ZoneTransferException {
        throw new ZoneTransferException(str);
    }

    private void fallback() throws ZoneTransferException {
        if (!this.wantFallback) {
            fail("server doesn't support IXFR");
        }
        logxfr("falling back to AXFR");
        this.qtype = 252;
        this.state = 0;
    }

    private BasicHandler getBasicHandler() throws IllegalArgumentException {
        ZoneTransferHandler zoneTransferHandler = this.handler;
        if (zoneTransferHandler instanceof BasicHandler) {
            return (BasicHandler) zoneTransferHandler;
        }
        throw new IllegalArgumentException("ZoneTransferIn used callback interface");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long getSOASerial(Record record) {
        return ((SOARecord) record).getSerial();
    }

    private void logxfr(String str) {
        log.u("{}: {}", this.zname, str);
    }

    public static ZoneTransferIn newAXFR(Name name, SocketAddress socketAddress, TSIG tsig) {
        return new ZoneTransferIn(name, 252, 0L, false, socketAddress, tsig);
    }

    public static ZoneTransferIn newIXFR(Name name, long j2, boolean z, SocketAddress socketAddress, TSIG tsig) {
        return new ZoneTransferIn(name, Type.IXFR, j2, z, socketAddress, tsig);
    }

    private void openConnection() throws IOException {
        TCPClient tCPClientCreateTcpClient = createTcpClient(this.timeout);
        this.client = tCPClientCreateTcpClient;
        SocketAddress socketAddress = this.localAddress;
        if (socketAddress != null) {
            tCPClientCreateTcpClient.bind(socketAddress);
        }
        this.client.connect(this.address);
    }

    private Message parseMessage(byte[] bArr) throws WireParseException {
        try {
            return new Message(bArr);
        } catch (IOException e2) {
            if (e2 instanceof WireParseException) {
                throw ((WireParseException) e2);
            }
            throw new WireParseException("Error parsing message", e2);
        }
    }

    private void parseRR(Record record) throws ZoneTransferException {
        int type = record.getType();
        switch (this.state) {
            case 0:
                if (type != 6) {
                    fail("missing initial SOA");
                }
                this.initialSoaRecord = record;
                long sOASerial = getSOASerial(record);
                this.endSerial = sOASerial;
                if (this.qtype == 251 && Serial.compare(sOASerial, this.ixfrSerial) <= 0) {
                    logxfr("up to date");
                    this.state = 7;
                    break;
                } else {
                    this.state = 1;
                    break;
                }
                break;
            case 1:
                if (this.qtype == 251 && type == 6 && getSOASerial(record) == this.ixfrSerial) {
                    this.rtype = Type.IXFR;
                    this.handler.startIXFR();
                    logxfr("got incremental response");
                    this.state = 2;
                } else {
                    this.rtype = 252;
                    this.handler.startAXFR();
                    this.handler.handleRecord(this.initialSoaRecord);
                    logxfr("got nonincremental response");
                    this.state = 6;
                }
                parseRR(record);
                break;
            case 2:
                this.handler.startIXFRDeletes(record);
                this.state = 3;
                break;
            case 3:
                if (type != 6) {
                    this.handler.handleRecord(record);
                    break;
                } else {
                    this.currentSerial = getSOASerial(record);
                    this.state = 4;
                    parseRR(record);
                    break;
                }
            case 4:
                this.handler.startIXFRAdds(record);
                this.state = 5;
                break;
            case 5:
                if (type == 6) {
                    long sOASerial2 = getSOASerial(record);
                    if (sOASerial2 != this.endSerial) {
                        if (sOASerial2 == this.currentSerial) {
                            this.state = 2;
                            parseRR(record);
                            break;
                        } else {
                            fail("IXFR out of sync: expected serial " + this.currentSerial + " , got " + sOASerial2);
                        }
                    } else {
                        this.state = 7;
                        break;
                    }
                }
                this.handler.handleRecord(record);
                break;
            case 6:
                if (type != 1 || record.getDClass() == this.dclass) {
                    this.handler.handleRecord(record);
                    if (type == 6) {
                        this.state = 7;
                        break;
                    }
                }
                break;
            case 7:
                fail("extra data");
                break;
            default:
                fail("invalid state");
                break;
        }
    }

    private void sendQuery() throws IOException {
        Record recordNewRecord = Record.newRecord(this.zname, this.qtype, this.dclass);
        Message message = new Message();
        message.getHeader().setOpcode(0);
        message.addRecord(recordNewRecord, 0);
        if (this.qtype == 251) {
            Name name = this.zname;
            int i2 = this.dclass;
            Name name2 = Name.root;
            message.addRecord(new SOARecord(name, i2, 0L, name2, name2, this.ixfrSerial, 0L, 0L, 0L, 0L), 2);
        }
        TSIG tsig = this.tsig;
        if (tsig != null) {
            tsig.apply(message, null);
            this.verifier = new TSIG.StreamVerifier(this.tsig, message.getTSIG());
        }
        this.client.send(message.toWire(Message.MAXLENGTH));
    }

    public TCPClient createTcpClient(Duration duration) throws IOException {
        return new TCPClient(duration);
    }

    public List<Record> getAXFR() {
        return getBasicHandler().axfr;
    }

    public List<Delta> getIXFR() {
        return getBasicHandler().ixfr;
    }

    public Name getName() {
        return this.zname;
    }

    public int getType() {
        return this.qtype;
    }

    public boolean isAXFR() {
        return this.rtype == 252;
    }

    public boolean isCurrent() throws IllegalArgumentException {
        BasicHandler basicHandler = getBasicHandler();
        return basicHandler.axfr == null && basicHandler.ixfr == null;
    }

    public boolean isIXFR() {
        return this.rtype == 251;
    }

    public void run(ZoneTransferHandler zoneTransferHandler) throws ZoneTransferException, IOException {
        this.handler = zoneTransferHandler;
        try {
            openConnection();
            doxfr();
        } finally {
            closeConnection();
        }
    }

    public void setDClass(int i2) {
        DClass.check(i2);
        this.dclass = i2;
    }

    public void setLocalAddress(SocketAddress socketAddress) {
        this.localAddress = socketAddress;
    }

    @Deprecated
    public void setTimeout(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("timeout cannot be negative");
        }
        this.timeout = Duration.ofSeconds(i2);
    }

    public static ZoneTransferIn newAXFR(Name name, String str, int i2, TSIG tsig) {
        if (i2 == 0) {
            i2 = 53;
        }
        return newAXFR(name, new InetSocketAddress(str, i2), tsig);
    }

    public static ZoneTransferIn newIXFR(Name name, long j2, boolean z, String str, int i2, TSIG tsig) {
        if (i2 == 0) {
            i2 = 53;
        }
        return newIXFR(name, j2, z, new InetSocketAddress(str, i2), tsig);
    }

    public static ZoneTransferIn newAXFR(Name name, String str, TSIG tsig) {
        return newAXFR(name, str, 0, tsig);
    }

    public static ZoneTransferIn newIXFR(Name name, long j2, boolean z, String str, TSIG tsig) {
        return newIXFR(name, j2, z, str, 0, tsig);
    }

    public void setTimeout(Duration duration) {
        this.timeout = duration;
    }

    public void run() throws ZoneTransferException, IOException {
        run(new BasicHandler());
    }
}
