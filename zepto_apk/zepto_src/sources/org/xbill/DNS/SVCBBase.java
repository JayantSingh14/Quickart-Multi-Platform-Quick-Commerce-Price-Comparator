package org.xbill.DNS;

import java.io.IOException;
import java.io.Serializable;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.xbill.DNS.Tokenizer;
import org.xbill.DNS.utils.base64;

/* loaded from: classes5.dex */
public abstract class SVCBBase extends Record {
    public static final int ALPN = 1;
    public static final int ECH = 5;

    @Deprecated
    public static final int ECHCONFIG = 5;
    public static final int IPV4HINT = 4;
    public static final int IPV6HINT = 6;
    public static final int MANDATORY = 0;
    public static final int NO_DEFAULT_ALPN = 2;
    public static final int PORT = 3;
    private static final ParameterMnemonic parameters;
    protected final Map<Integer, ParameterBase> svcParams;
    protected int svcPriority;
    protected Name targetName;

    public static abstract class ParameterBase implements Serializable {
        public static String[] splitStringWithEscapedCommas(String str) {
            return str.split("(?<!\\\\),");
        }

        public abstract void fromString(String str) throws IOException;

        public abstract void fromWire(byte[] bArr) throws IOException;

        public abstract int getKey();

        public abstract String toString();

        public abstract byte[] toWire();
    }

    public static class ParameterEch extends ParameterBase {
        private byte[] data;

        public ParameterEch() {
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public void fromString(String str) throws TextParseException {
            if (str == null || str.isEmpty()) {
                throw new TextParseException("Non-empty base64 value must be specified for ech");
            }
            this.data = base64.fromString(str);
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public void fromWire(byte[] bArr) {
            this.data = bArr;
        }

        public byte[] getData() {
            return this.data;
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public int getKey() {
            return 5;
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public String toString() {
            return base64.toString(this.data);
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public byte[] toWire() {
            return this.data;
        }

        public ParameterEch(byte[] bArr) {
            this.data = bArr;
        }
    }

    @Deprecated
    public static class ParameterEchConfig extends ParameterBase {
        private byte[] data;

        public ParameterEchConfig() {
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public void fromString(String str) throws TextParseException {
            if (str == null || str.isEmpty()) {
                throw new TextParseException("Non-empty base64 value must be specified for echconfig");
            }
            this.data = base64.fromString(str);
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public void fromWire(byte[] bArr) {
            this.data = bArr;
        }

        public byte[] getData() {
            return this.data;
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public int getKey() {
            return 5;
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public String toString() {
            return base64.toString(this.data);
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public byte[] toWire() {
            return this.data;
        }

        public ParameterEchConfig(byte[] bArr) {
            this.data = bArr;
        }
    }

    public static class ParameterMnemonic extends Mnemonic {
        private final HashMap<Integer, Supplier<ParameterBase>> factories;

        public ParameterMnemonic() {
            super("SVCB/HTTPS Parameters", 3);
            setPrefix("key");
            setNumericAllowed(true);
            setMaximum(Message.MAXLENGTH);
            this.factories = new HashMap<>();
        }

        public void add(int i2, String str, Supplier<ParameterBase> supplier) {
            super.add(i2, str);
            this.factories.put(Integer.valueOf(i2), supplier);
        }

        public Supplier<ParameterBase> getFactory(int i2) {
            return this.factories.get(Integer.valueOf(i2));
        }
    }

    public static class ParameterNoDefaultAlpn extends ParameterBase {
        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public void fromString(String str) throws TextParseException {
            if (str != null && !str.isEmpty()) {
                throw new TextParseException("No value can be specified for no-default-alpn");
            }
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public void fromWire(byte[] bArr) throws WireParseException {
            if (bArr.length > 0) {
                throw new WireParseException("No value can be specified for no-default-alpn");
            }
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public int getKey() {
            return 2;
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public String toString() {
            return "";
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public byte[] toWire() {
            return new byte[0];
        }
    }

    public static class ParameterPort extends ParameterBase {
        private int port;

        public ParameterPort() {
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public void fromString(String str) throws TextParseException {
            if (str == null || str.isEmpty()) {
                throw new TextParseException("Integer value must be specified for port");
            }
            this.port = Integer.parseInt(str);
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public void fromWire(byte[] bArr) throws IOException {
            DNSInput dNSInput = new DNSInput(bArr);
            this.port = dNSInput.readU16();
            if (dNSInput.remaining() > 0) {
                throw new WireParseException("Unexpected number of bytes in port parameter");
            }
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public int getKey() {
            return 3;
        }

        public int getPort() {
            return this.port;
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public String toString() {
            return Integer.toString(this.port);
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public byte[] toWire() {
            DNSOutput dNSOutput = new DNSOutput();
            dNSOutput.writeU16(this.port);
            return dNSOutput.toByteArray();
        }

        public ParameterPort(int i2) {
            this.port = i2;
        }
    }

    static {
        ParameterMnemonic parameterMnemonic = new ParameterMnemonic();
        parameters = parameterMnemonic;
        parameterMnemonic.add(0, "mandatory", new y(0));
        parameterMnemonic.add(1, "alpn", new y(1));
        parameterMnemonic.add(2, "no-default-alpn", new y(2));
        parameterMnemonic.add(3, "port", new y(3));
        parameterMnemonic.add(4, "ipv4hint", new y(4));
        parameterMnemonic.add(5, "ech", new y(5));
        parameterMnemonic.add(6, "ipv6hint", new y(6));
        parameterMnemonic.addAlias(5, "echconfig");
    }

    public SVCBBase() {
        this.svcParams = new TreeMap();
    }

    public boolean checkMandatoryParams() {
        ParameterMandatory parameterMandatory = (ParameterMandatory) getSvcParamValue(0);
        if (parameterMandatory == null) {
            return true;
        }
        Iterator it = parameterMandatory.values.iterator();
        while (it.hasNext()) {
            if (getSvcParamValue(((Integer) it.next()).intValue()) == null) {
                return false;
            }
        }
        return true;
    }

    public Set<Integer> getSvcParamKeys() {
        return this.svcParams.keySet();
    }

    public ParameterBase getSvcParamValue(int i2) {
        return this.svcParams.get(Integer.valueOf(i2));
    }

    public int getSvcPriority() {
        return this.svcPriority;
    }

    public Name getTargetName() {
        return this.targetName;
    }

    @Override // org.xbill.DNS.Record
    public void rdataFromString(Tokenizer tokenizer, Name name) throws IOException {
        String strSubstring;
        String strSubstring2;
        this.svcPriority = tokenizer.getUInt16();
        this.targetName = tokenizer.getName(name);
        this.svcParams.clear();
        while (true) {
            Tokenizer.Token token = tokenizer.get();
            if (!token.isString()) {
                tokenizer.unget();
                if (this.svcPriority == 0 && !this.svcParams.isEmpty()) {
                    throw new TextParseException("No parameter values allowed for AliasMode");
                }
                if (!checkMandatoryParams()) {
                    throw new TextParseException("Not all mandatory SvcParams are specified");
                }
                return;
            }
            int iIndexOf = token.value().indexOf(61);
            if (iIndexOf == -1) {
                strSubstring2 = token.value();
                strSubstring = null;
            } else if (iIndexOf == token.value().length() - 1) {
                strSubstring2 = token.value().substring(0, iIndexOf);
                Tokenizer.Token token2 = tokenizer.get();
                if (!token2.isString()) {
                    throw new TextParseException(android.support.v4.media.b.D("Expected value for parameter key '", strSubstring2, "'"));
                }
                strSubstring = token2.value();
            } else {
                if (iIndexOf <= 0) {
                    throw new TextParseException("Expected valid parameter key=value for '" + token.value() + "'");
                }
                String strSubstring3 = token.value().substring(0, iIndexOf);
                strSubstring = token.value().substring(iIndexOf + 1);
                strSubstring2 = strSubstring3;
            }
            ParameterMnemonic parameterMnemonic = parameters;
            int value = parameterMnemonic.getValue(strSubstring2);
            if (value == -1) {
                throw new TextParseException(android.support.v4.media.b.D("Expected a valid parameter key for '", strSubstring2, "'"));
            }
            if (this.svcParams.containsKey(Integer.valueOf(value))) {
                throw new TextParseException(android.support.v4.media.b.D("Duplicate parameter key for '", strSubstring2, "'"));
            }
            Supplier<ParameterBase> factory = parameterMnemonic.getFactory(value);
            ParameterBase parameterUnknown = factory != null ? factory.get() : new ParameterUnknown(value);
            parameterUnknown.fromString(strSubstring);
            this.svcParams.put(Integer.valueOf(value), parameterUnknown);
        }
    }

    @Override // org.xbill.DNS.Record
    public void rrFromWire(DNSInput dNSInput) throws IOException {
        this.svcPriority = dNSInput.readU16();
        this.targetName = new Name(dNSInput);
        this.svcParams.clear();
        while (dNSInput.remaining() >= 4) {
            int u16 = dNSInput.readU16();
            byte[] byteArray = dNSInput.readByteArray(dNSInput.readU16());
            Supplier<ParameterBase> factory = parameters.getFactory(u16);
            ParameterBase parameterUnknown = factory != null ? factory.get() : new ParameterUnknown(u16);
            parameterUnknown.fromWire(byteArray);
            this.svcParams.put(Integer.valueOf(u16), parameterUnknown);
        }
        if (dNSInput.remaining() > 0) {
            throw new WireParseException("Record had unexpected number of bytes");
        }
        if (!checkMandatoryParams()) {
            throw new WireParseException("Not all mandatory SvcParams are specified");
        }
    }

    @Override // org.xbill.DNS.Record
    public String rrToString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.svcPriority);
        sb.append(StringUtils.SPACE);
        sb.append(this.targetName);
        for (Map.Entry<Integer, ParameterBase> entry : this.svcParams.entrySet()) {
            sb.append(StringUtils.SPACE);
            sb.append(parameters.getText(entry.getKey().intValue()));
            String string = entry.getValue().toString();
            if (string != null && !string.isEmpty()) {
                sb.append("=");
                sb.append(string);
            }
        }
        return sb.toString();
    }

    @Override // org.xbill.DNS.Record
    public void rrToWire(DNSOutput dNSOutput, Compression compression, boolean z) {
        dNSOutput.writeU16(this.svcPriority);
        this.targetName.toWire(dNSOutput, null, z);
        for (Map.Entry<Integer, ParameterBase> entry : this.svcParams.entrySet()) {
            dNSOutput.writeU16(entry.getKey().intValue());
            byte[] wire = entry.getValue().toWire();
            dNSOutput.writeU16(wire.length);
            dNSOutput.writeByteArray(wire);
        }
    }

    public static class ParameterAlpn extends ParameterBase {
        private final List<byte[]> values = new ArrayList();

        public ParameterAlpn() {
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public void fromString(String str) throws TextParseException {
            this.values.clear();
            if (str == null || str.isEmpty()) {
                throw new TextParseException("Non-empty list must be specified for alpn");
            }
            for (String str2 : ParameterBase.splitStringWithEscapedCommas(str)) {
                this.values.add(Record.byteArrayFromString(str2));
            }
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public void fromWire(byte[] bArr) throws IOException {
            this.values.clear();
            DNSInput dNSInput = new DNSInput(bArr);
            while (dNSInput.remaining() > 0) {
                this.values.add(dNSInput.readCountedString());
            }
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public int getKey() {
            return 1;
        }

        public List<String> getValues() {
            ArrayList arrayList = new ArrayList();
            Iterator<byte[]> it = this.values.iterator();
            while (it.hasNext()) {
                arrayList.add(Record.byteArrayToString(it.next(), false));
            }
            return arrayList;
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (byte[] bArr : this.values) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(Record.byteArrayToString(bArr, false).replace(",", "\\,"));
            }
            return sb.toString();
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public byte[] toWire() {
            DNSOutput dNSOutput = new DNSOutput();
            Iterator<byte[]> it = this.values.iterator();
            while (it.hasNext()) {
                dNSOutput.writeCountedString(it.next());
            }
            return dNSOutput.toByteArray();
        }

        public ParameterAlpn(List<String> list) throws TextParseException {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                this.values.add(Record.byteArrayFromString(it.next()));
            }
        }
    }

    public static class ParameterIpv4Hint extends ParameterBase {
        private final List<byte[]> addresses;

        public ParameterIpv4Hint() {
            this.addresses = new ArrayList();
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public void fromString(String str) throws IOException {
            this.addresses.clear();
            if (str == null || str.isEmpty()) {
                throw new TextParseException("Non-empty IPv4 list must be specified for ipv4hint");
            }
            for (String str2 : str.split(",")) {
                byte[] byteArray = Address.toByteArray(str2, 1);
                if (byteArray == null) {
                    throw new TextParseException(android.support.v4.media.b.D("Invalid ipv4hint value '", str2, "'"));
                }
                this.addresses.add(byteArray);
            }
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public void fromWire(byte[] bArr) throws IOException {
            this.addresses.clear();
            DNSInput dNSInput = new DNSInput(bArr);
            while (dNSInput.remaining() >= 4) {
                this.addresses.add(dNSInput.readByteArray(4));
            }
            if (dNSInput.remaining() > 0) {
                throw new WireParseException("Unexpected number of bytes in ipv4hint parameter");
            }
        }

        public List<Inet4Address> getAddresses() throws UnknownHostException {
            LinkedList linkedList = new LinkedList();
            Iterator<byte[]> it = this.addresses.iterator();
            while (it.hasNext()) {
                InetAddress byAddress = InetAddress.getByAddress(it.next());
                if (byAddress instanceof Inet4Address) {
                    linkedList.add((Inet4Address) byAddress);
                }
            }
            return linkedList;
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public int getKey() {
            return 4;
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (byte[] bArr : this.addresses) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(Address.toDottedQuad(bArr));
            }
            return sb.toString();
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public byte[] toWire() {
            DNSOutput dNSOutput = new DNSOutput();
            Iterator<byte[]> it = this.addresses.iterator();
            while (it.hasNext()) {
                dNSOutput.writeByteArray(it.next());
            }
            return dNSOutput.toByteArray();
        }

        public ParameterIpv4Hint(List<Inet4Address> list) {
            this.addresses = (List) list.stream().map(new i(7)).collect(Collectors.toList());
        }
    }

    public static class ParameterIpv6Hint extends ParameterBase {
        private final List<byte[]> addresses;

        public ParameterIpv6Hint() {
            this.addresses = new ArrayList();
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public void fromString(String str) throws IOException {
            this.addresses.clear();
            if (str == null || str.isEmpty()) {
                throw new TextParseException("Non-empty IPv6 list must be specified for ipv6hint");
            }
            for (String str2 : str.split(",")) {
                byte[] byteArray = Address.toByteArray(str2, 2);
                if (byteArray == null) {
                    throw new TextParseException(android.support.v4.media.b.D("Invalid ipv6hint value '", str2, "'"));
                }
                this.addresses.add(byteArray);
            }
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public void fromWire(byte[] bArr) throws IOException {
            this.addresses.clear();
            DNSInput dNSInput = new DNSInput(bArr);
            while (dNSInput.remaining() >= 16) {
                this.addresses.add(dNSInput.readByteArray(16));
            }
            if (dNSInput.remaining() > 0) {
                throw new WireParseException("Unexpected number of bytes in ipv6hint parameter");
            }
        }

        public List<Inet6Address> getAddresses() throws UnknownHostException {
            LinkedList linkedList = new LinkedList();
            Iterator<byte[]> it = this.addresses.iterator();
            while (it.hasNext()) {
                InetAddress byAddress = InetAddress.getByAddress(it.next());
                if (byAddress instanceof Inet6Address) {
                    linkedList.add((Inet6Address) byAddress);
                }
            }
            return linkedList;
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public int getKey() {
            return 6;
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (byte[] bArr : this.addresses) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                try {
                    sb.append(InetAddress.getByAddress(null, bArr).getHostAddress());
                } catch (UnknownHostException e2) {
                    return e2.getMessage();
                }
            }
            return sb.toString();
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public byte[] toWire() {
            DNSOutput dNSOutput = new DNSOutput();
            Iterator<byte[]> it = this.addresses.iterator();
            while (it.hasNext()) {
                dNSOutput.writeByteArray(it.next());
            }
            return dNSOutput.toByteArray();
        }

        public ParameterIpv6Hint(List<Inet6Address> list) {
            this.addresses = (List) list.stream().map(new i(8)).collect(Collectors.toList());
        }
    }

    public static class ParameterMandatory extends ParameterBase {
        private final List<Integer> values;

        public ParameterMandatory() {
            this.values = new ArrayList();
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public void fromString(String str) throws TextParseException {
            this.values.clear();
            if (str == null || str.isEmpty()) {
                throw new TextParseException("Non-empty list must be specified for mandatory");
            }
            for (String str2 : ParameterBase.splitStringWithEscapedCommas(str)) {
                int value = SVCBBase.parameters.getValue(str2);
                if (value == 0) {
                    throw new TextParseException("Key mandatory must not appear in its own list");
                }
                if (this.values.contains(Integer.valueOf(value))) {
                    throw new TextParseException(android.support.v4.media.b.D("Duplicate key ", str2, " not allowed in mandatory list"));
                }
                this.values.add(Integer.valueOf(value));
            }
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public void fromWire(byte[] bArr) throws IOException {
            this.values.clear();
            DNSInput dNSInput = new DNSInput(bArr);
            while (dNSInput.remaining() >= 2) {
                this.values.add(Integer.valueOf(dNSInput.readU16()));
            }
            if (dNSInput.remaining() > 0) {
                throw new WireParseException("Unexpected number of bytes in mandatory parameter");
            }
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public int getKey() {
            return 0;
        }

        public List<Integer> getValues() {
            return this.values;
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (Integer num : this.values) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(SVCBBase.parameters.getText(num.intValue()));
            }
            return sb.toString();
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public byte[] toWire() {
            DNSOutput dNSOutput = new DNSOutput();
            Iterator<Integer> it = this.values.iterator();
            while (it.hasNext()) {
                dNSOutput.writeU16(it.next().intValue());
            }
            return dNSOutput.toByteArray();
        }

        public ParameterMandatory(List<Integer> list) {
            this.values = list;
        }
    }

    public static class ParameterUnknown extends ParameterBase {
        private final int key;
        private byte[] value;

        public ParameterUnknown(int i2) {
            this.key = i2;
            this.value = new byte[0];
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public void fromString(String str) throws IOException {
            if (str == null || str.isEmpty()) {
                this.value = new byte[0];
            } else {
                this.value = Record.byteArrayFromString(str);
            }
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public void fromWire(byte[] bArr) {
            this.value = bArr;
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public int getKey() {
            return this.key;
        }

        public byte[] getValue() {
            return this.value;
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public String toString() {
            return Record.byteArrayToString(this.value, false);
        }

        @Override // org.xbill.DNS.SVCBBase.ParameterBase
        public byte[] toWire() {
            return this.value;
        }

        public ParameterUnknown(int i2, byte[] bArr) {
            this.key = i2;
            this.value = bArr;
        }
    }

    public SVCBBase(Name name, int i2, int i3, long j2) {
        super(name, i2, i3, j2);
        this.svcParams = new TreeMap();
    }

    public SVCBBase(Name name, int i2, int i3, long j2, int i4, Name name2, List<ParameterBase> list) {
        super(name, i2, i3, j2);
        this.svcPriority = i4;
        this.targetName = name2;
        this.svcParams = new TreeMap();
        for (ParameterBase parameterBase : list) {
            if (!this.svcParams.containsKey(Integer.valueOf(parameterBase.getKey()))) {
                this.svcParams.put(Integer.valueOf(parameterBase.getKey()), parameterBase);
            } else {
                throw new IllegalArgumentException("Duplicate SvcParam for key " + parameterBase.getKey());
            }
        }
    }
}
