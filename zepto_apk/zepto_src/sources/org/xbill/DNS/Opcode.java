package org.xbill.DNS;

/* loaded from: classes5.dex */
public final class Opcode {
    public static final int DSO = 6;
    public static final int IQUERY = 1;
    public static final int NOTIFY = 4;
    public static final int QUERY = 0;
    public static final int STATUS = 2;
    public static final int UPDATE = 5;
    private static final Mnemonic opcodes;

    static {
        Mnemonic mnemonic = new Mnemonic("DNS Opcode", 2);
        opcodes = mnemonic;
        mnemonic.setMaximum(15);
        mnemonic.setPrefix("RESERVED");
        mnemonic.setNumericAllowed(true);
        mnemonic.add(0, "QUERY");
        mnemonic.add(1, "IQUERY");
        mnemonic.add(2, "STATUS");
        mnemonic.add(4, "NOTIFY");
        mnemonic.add(5, "UPDATE");
        mnemonic.add(6, "DSO");
    }

    private Opcode() {
    }

    public static String string(int i2) {
        return opcodes.getText(i2);
    }

    public static int value(String str) {
        return opcodes.getValue(str);
    }
}
