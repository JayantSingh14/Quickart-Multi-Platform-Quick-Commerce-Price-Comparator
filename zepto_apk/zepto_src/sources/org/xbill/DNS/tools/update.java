package org.xbill.DNS.tools;

import android.support.v4.media.b;
import androidx.fragment.app.e;
import coil3.util.UtilsKt;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.StringUtils;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.xbill.DNS.DClass;
import org.xbill.DNS.Message;
import org.xbill.DNS.Name;
import org.xbill.DNS.Rcode;
import org.xbill.DNS.Record;
import org.xbill.DNS.Resolver;
import org.xbill.DNS.SOARecord;
import org.xbill.DNS.Section;
import org.xbill.DNS.SimpleResolver;
import org.xbill.DNS.TTL;
import org.xbill.DNS.Tokenizer;
import org.xbill.DNS.Type;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes5.dex */
public class update {
    int defaultClass;
    long defaultTTL;
    PrintStream log = null;
    Message query;
    Resolver res;
    Message response;
    String server;
    Name zone;

    /* JADX WARN: Removed duplicated region for block: B:123:0x01fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public update(java.io.InputStream r10) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1162
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.xbill.DNS.tools.update.<init>(java.io.InputStream):void");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static void help(String str) {
        System.out.println();
        if (str == null) {
            System.out.println("The following are supported commands:\nadd      assert   class    clear    date     delete\necho     edns     file     glue     help     key\nlog      port     prohibit query    quit     require\nsend     server   show     sleep    tcp      ttl\nzone     #\n");
        }
        String lowerCase = str.toLowerCase();
        lowerCase.getClass();
        char c2 = 65535;
        switch (lowerCase.hashCode()) {
            case -1408208058:
                if (lowerCase.equals("assert")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1335458389:
                if (lowerCase.equals("delete")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1008619738:
                if (lowerCase.equals("origin")) {
                    c2 = 2;
                    break;
                }
                break;
            case -1000426017:
                if (lowerCase.equals("prohibit")) {
                    c2 = 3;
                    break;
                }
                break;
            case -905826493:
                if (lowerCase.equals("server")) {
                    c2 = 4;
                    break;
                }
                break;
            case 35:
                if (lowerCase.equals("#")) {
                    c2 = 5;
                    break;
                }
                break;
            case WKSRecord.Service.AUTH /* 113 */:
                if (lowerCase.equals("q")) {
                    c2 = 6;
                    break;
                }
                break;
            case 96417:
                if (lowerCase.equals("add")) {
                    c2 = 7;
                    break;
                }
                break;
            case 106079:
                if (lowerCase.equals("key")) {
                    c2 = '\b';
                    break;
                }
                break;
            case 107332:
                if (lowerCase.equals("log")) {
                    c2 = '\t';
                    break;
                }
                break;
            case 114657:
                if (lowerCase.equals("tcp")) {
                    c2 = '\n';
                    break;
                }
                break;
            case 115180:
                if (lowerCase.equals("ttl")) {
                    c2 = 11;
                    break;
                }
                break;
            case 3076014:
                if (lowerCase.equals(CLConstants.SHARED_PREFERENCE_ITEM_DATE)) {
                    c2 = '\f';
                    break;
                }
                break;
            case 3107365:
                if (lowerCase.equals("echo")) {
                    c2 = CharUtils.CR;
                    break;
                }
                break;
            case 3108516:
                if (lowerCase.equals("edns")) {
                    c2 = 14;
                    break;
                }
                break;
            case 3143036:
                if (lowerCase.equals(UtilsKt.SCHEME_FILE)) {
                    c2 = 15;
                    break;
                }
                break;
            case 3175989:
                if (lowerCase.equals("glue")) {
                    c2 = 16;
                    break;
                }
                break;
            case 3198785:
                if (lowerCase.equals("help")) {
                    c2 = 17;
                    break;
                }
                break;
            case 3446913:
                if (lowerCase.equals("port")) {
                    c2 = 18;
                    break;
                }
                break;
            case 3482191:
                if (lowerCase.equals("quit")) {
                    c2 = 19;
                    break;
                }
                break;
            case 3526536:
                if (lowerCase.equals("send")) {
                    c2 = 20;
                    break;
                }
                break;
            case 3529469:
                if (lowerCase.equals("show")) {
                    c2 = 21;
                    break;
                }
                break;
            case 3744684:
                if (lowerCase.equals("zone")) {
                    c2 = 22;
                    break;
                }
                break;
            case 94742904:
                if (lowerCase.equals("class")) {
                    c2 = 23;
                    break;
                }
                break;
            case 94746189:
                if (lowerCase.equals("clear")) {
                    c2 = 24;
                    break;
                }
                break;
            case 107944136:
                if (lowerCase.equals("query")) {
                    c2 = 25;
                    break;
                }
                break;
            case 109522647:
                if (lowerCase.equals("sleep")) {
                    c2 = 26;
                    break;
                }
                break;
            case 1095696741:
                if (lowerCase.equals("require")) {
                    c2 = 27;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                System.out.println("assert <field> <value> [msg]\n\nasserts that the value of the field in the last\nresponse matches the value specified.  If not,\nthe message is printed (if present) and the\nprogram exits.  The field may be any of <rcode>,\n<serial>, <tsig>, <qu>, <an>, <au>, or <ad>.\n");
                break;
            case 1:
                System.out.println("delete <name> [ttl] [class] <type> <data> \ndelete <name> <type> \ndelete <name>\n\nspecify a record or set to be deleted, or that\nall records at a name should be deleted\n");
                break;
            case 2:
            case 22:
                System.out.println("zone <zone>\n\nzone to update (default: .\n");
                break;
            case 3:
                System.out.println("prohibit <name> <type> \nprohibit <name>\n\nrequire that a set or name is not present\n");
                break;
            case 4:
                System.out.println("server <name> [port]\n\nserver that receives send updates/queries\n");
                break;
            case 5:
                System.out.println("# <text>\n\na comment\n");
                break;
            case 6:
            case 19:
                System.out.println("quit\n\nquits the program\n");
                break;
            case 7:
                System.out.println("add <name> [ttl] [class] <type> <data>\n\nspecify a record to be added\n");
                break;
            case '\b':
                System.out.println("key <name> <data>\n\nTSIG key used to sign messages\n");
                break;
            case '\t':
                System.out.println("log <file>\n\nopens the specified file and uses it to log output\n");
                break;
            case '\n':
                System.out.println("tcp\n\nTCP should be used to send all messages\n");
                break;
            case 11:
                System.out.println("ttl <ttl>\n\ndefault ttl of added records (default: 0)\n");
                break;
            case '\f':
                System.out.println("date [-ms]\n\nprints the current date and time in human readable\nformat or as the number of milliseconds since the\nepoch");
                break;
            case '\r':
                System.out.println("echo <text>\n\nprints the text\n");
                break;
            case 14:
                System.out.println("edns <level>\n\nEDNS level specified when sending messages\n");
                break;
            case 15:
                System.out.println("file <file>\n\nopens the specified file as the new input source\n(- represents stdin)\n");
                break;
            case 16:
                System.out.println("glue <name> [ttl] [class] <type> <data>\n\nspecify an additional record\n");
                break;
            case 17:
                System.out.println("help\nhelp [topic]\n\nprints a list of commands or help about a specific\ncommand\n");
                break;
            case 18:
                System.out.println("port <port>\n\nUDP/TCP port messages are sent to (default: 53)\n");
                break;
            case 20:
                System.out.println("send\n\nsends and resets the current update packet\n");
                break;
            case 21:
                System.out.println("show\n\nshows the current update packet\n");
                break;
            case 23:
                System.out.println("class <class>\n\nclass of the zone to be updated (default: IN)\n");
                break;
            case 24:
                System.out.println("clear\n\nclears the current update packet\n");
                break;
            case 25:
                System.out.println("query <name> [type [class]] \n\nissues a query\n");
                break;
            case 26:
                System.out.println("sleep <milliseconds>\n\npause for interval before next command\n");
                break;
            case 27:
                System.out.println("require <name> [ttl] [class] <type> <data> \nrequire <name> <type> \nrequire <name>\n\nrequire that a record, set, or name is present\n");
                break;
            default:
                System.out.println("Topic '" + lowerCase + "' unrecognized\n");
                break;
        }
    }

    public static void main(String[] strArr) {
        InputStream fileInputStream;
        if (strArr.length >= 1) {
            try {
                fileInputStream = new FileInputStream(strArr[0]);
            } catch (FileNotFoundException unused) {
                System.out.println(strArr[0] + " not found.");
                System.exit(1);
                fileInputStream = null;
            }
        } else {
            fileInputStream = System.in;
        }
        new update(fileInputStream);
    }

    public void doAdd(Tokenizer tokenizer) throws IOException {
        Record rr = parseRR(tokenizer, this.defaultClass, this.defaultTTL);
        this.query.addRecord(rr, 2);
        print(rr);
    }

    public boolean doAssert(Tokenizer tokenizer) throws IOException {
        String string = tokenizer.getString();
        String string2 = tokenizer.getString();
        boolean z = true;
        if (this.response == null) {
            print("No response has been received");
            return true;
        }
        String string3 = null;
        if (string.equalsIgnoreCase("rcode")) {
            int rcode = this.response.getHeader().getRcode();
            if (rcode != Rcode.value(string2)) {
                string3 = Rcode.string(rcode);
                z = false;
            }
        } else if (string.equalsIgnoreCase("serial")) {
            List<Record> section = this.response.getSection(1);
            if (section.isEmpty() || !(section.get(0) instanceof SOARecord)) {
                print("Invalid response (no SOA)");
            } else {
                long serial = ((SOARecord) section.get(0)).getSerial();
                if (serial != Long.parseLong(string2)) {
                    string3 = Long.toString(serial);
                    z = false;
                }
            }
        } else if (string.equalsIgnoreCase("tsig")) {
            string3 = this.response.isSigned() ? this.response.isVerified() ? "ok" : "failed" : "unsigned";
            if (!string3.equalsIgnoreCase(string2)) {
                z = false;
            }
        } else {
            int iValue = Section.value(string);
            if (iValue >= 0) {
                int count = this.response.getHeader().getCount(iValue);
                if (count != Integer.parseInt(string2)) {
                    string3 = Integer.toString(count);
                    z = false;
                }
            } else {
                print("Invalid assertion keyword: ".concat(string));
            }
        }
        if (z) {
            return z;
        }
        StringBuilder sbV = e.v("Expected ", string, StringUtils.SPACE, string2, ", received ");
        sbV.append(string3);
        print(sbV.toString());
        while (true) {
            Tokenizer.Token token = tokenizer.get();
            if (!token.isString()) {
                tokenizer.unget();
                return z;
            }
            print(token.value());
        }
    }

    public void doDelete(Tokenizer tokenizer) throws IOException {
        Record recordNewRecord;
        Name name = tokenizer.getName(this.zone);
        Tokenizer.Token token = tokenizer.get();
        if (token.isString()) {
            String strValue = token.value();
            if (DClass.value(strValue) >= 0) {
                strValue = tokenizer.getString();
            }
            int iValue = Type.value(strValue);
            if (iValue < 0) {
                throw new IOException(b.C("Invalid type: ", strValue));
            }
            boolean zIsEOL = tokenizer.get().isEOL();
            tokenizer.unget();
            recordNewRecord = !zIsEOL ? Record.fromString(name, iValue, 254, 0L, tokenizer, this.zone) : Record.newRecord(name, iValue, 255, 0L);
        } else {
            recordNewRecord = Record.newRecord(name, 255, 255, 0L);
        }
        this.query.addRecord(recordNewRecord, 2);
        print(recordNewRecord);
    }

    public void doFile(Tokenizer tokenizer, List<BufferedReader> list, List<InputStream> list2) throws IOException {
        String string = tokenizer.getString();
        try {
            InputStream fileInputStream = string.equals("-") ? System.in : new FileInputStream(string);
            list2.add(0, fileInputStream);
            list.add(0, new BufferedReader(new InputStreamReader(fileInputStream)));
        } catch (FileNotFoundException unused) {
            print(string + " not found");
        }
    }

    public void doGlue(Tokenizer tokenizer) throws IOException {
        Record rr = parseRR(tokenizer, this.defaultClass, this.defaultTTL);
        this.query.addRecord(rr, 3);
        print(rr);
    }

    public void doLog(Tokenizer tokenizer) throws IOException {
        String string = tokenizer.getString();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(string);
            try {
                this.log = new PrintStream(fileOutputStream);
                fileOutputStream.close();
            } finally {
            }
        } catch (Exception unused) {
            print("Error opening " + string);
        }
    }

    public void doProhibit(Tokenizer tokenizer) throws IOException {
        int iValue;
        Name name = tokenizer.getName(this.zone);
        Tokenizer.Token token = tokenizer.get();
        if (token.isString()) {
            iValue = Type.value(token.value());
            if (iValue < 0) {
                throw new IOException("Invalid type: " + token.value());
            }
        } else {
            iValue = 255;
        }
        Record recordNewRecord = Record.newRecord(name, iValue, 254, 0L);
        this.query.addRecord(recordNewRecord, 1);
        print(recordNewRecord);
    }

    public void doQuery(Tokenizer tokenizer) throws IOException {
        int iValue;
        int iValue2 = this.defaultClass;
        Name name = tokenizer.getName(this.zone);
        Tokenizer.Token token = tokenizer.get();
        if (token.isString()) {
            iValue = Type.value(token.value());
            if (iValue < 0) {
                throw new IOException("Invalid type");
            }
            Tokenizer.Token token2 = tokenizer.get();
            if (token2.isString() && (iValue2 = DClass.value(token2.value())) < 0) {
                throw new IOException("Invalid class");
            }
        } else {
            iValue = 1;
        }
        Message messageNewQuery = Message.newQuery(Record.newRecord(name, iValue, iValue2));
        if (this.res == null) {
            this.res = new SimpleResolver(this.server);
        }
        Message messageSend = this.res.send(messageNewQuery);
        this.response = messageSend;
        print(messageSend);
    }

    public void doRequire(Tokenizer tokenizer) throws IOException {
        Record recordNewRecord;
        Name name = tokenizer.getName(this.zone);
        Tokenizer.Token token = tokenizer.get();
        if (token.isString()) {
            int iValue = Type.value(token.value());
            if (iValue < 0) {
                throw new IOException("Invalid type: " + token.value());
            }
            boolean zIsEOL = tokenizer.get().isEOL();
            tokenizer.unget();
            recordNewRecord = !zIsEOL ? Record.fromString(name, iValue, this.defaultClass, 0L, tokenizer, this.zone) : Record.newRecord(name, iValue, 255, 0L);
        } else {
            recordNewRecord = Record.newRecord(name, 255, 255, 0L);
        }
        this.query.addRecord(recordNewRecord, 1);
        print(recordNewRecord);
    }

    public Message newMessage() {
        Message message = new Message();
        message.getHeader().setOpcode(5);
        return message;
    }

    public Record parseRR(Tokenizer tokenizer, int i2, long j2) throws IOException {
        long j3;
        Name name = tokenizer.getName(this.zone);
        String string = tokenizer.getString();
        try {
            long ttl = TTL.parseTTL(string);
            string = tokenizer.getString();
            j3 = ttl;
        } catch (NumberFormatException unused) {
            j3 = j2;
        }
        if (DClass.value(string) >= 0) {
            i2 = DClass.value(string);
            string = tokenizer.getString();
        }
        int i3 = i2;
        int iValue = Type.value(string);
        if (iValue >= 0) {
            return Record.fromString(name, iValue, i3, j3, tokenizer, this.zone);
        }
        throw new IOException(b.C("Invalid type: ", string));
    }

    public void print(Object obj) {
        System.out.println(obj);
        PrintStream printStream = this.log;
        if (printStream != null) {
            printStream.println(obj);
        }
    }

    public void sendUpdate() throws IOException {
        if (this.query.getHeader().getCount(2) == 0) {
            print("Empty update message.  Ignoring.");
            return;
        }
        if (this.query.getHeader().getCount(0) == 0) {
            Name name = this.zone;
            int dClass = this.defaultClass;
            if (name == null) {
                Iterator<Record> it = this.query.getSection(2).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Record next = it.next();
                    if (name == null) {
                        name = new Name(next.getName(), 1);
                    }
                    if (next.getDClass() != 254 && next.getDClass() != 255) {
                        dClass = next.getDClass();
                        break;
                    }
                }
            }
            this.query.addRecord(Record.newRecord(name, 6, dClass), 0);
        }
        if (this.res == null) {
            this.res = new SimpleResolver(this.server);
        }
        Message messageSend = this.res.send(this.query);
        this.response = messageSend;
        print(messageSend);
    }
}
