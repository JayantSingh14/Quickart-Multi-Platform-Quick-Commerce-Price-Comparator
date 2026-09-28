package org.xbill.DNS;

/* loaded from: classes5.dex */
public final class ExtendedFlags {
    public static final int DO = 32768;
    private static final Mnemonic extflags;

    static {
        Mnemonic mnemonic = new Mnemonic("EDNS Flag", 3);
        extflags = mnemonic;
        mnemonic.setMaximum(Message.MAXLENGTH);
        mnemonic.setPrefix("FLAG");
        mnemonic.setNumericAllowed(true);
        mnemonic.add(32768, "do");
    }

    private ExtendedFlags() {
    }

    public static String string(int i2) {
        return extflags.getText(i2);
    }

    public static String stringFromBit(int i2) {
        return extflags.getText(1 << (15 - i2));
    }

    public static int value(String str) {
        return extflags.getValue(str);
    }
}
