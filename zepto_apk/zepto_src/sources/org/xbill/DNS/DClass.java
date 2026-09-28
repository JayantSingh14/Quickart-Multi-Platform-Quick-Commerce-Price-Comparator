package org.xbill.DNS;

import com.amazon.identity.auth.device.authorization.RegionUtil;

/* loaded from: classes5.dex */
public final class DClass {
    public static final int ANY = 255;
    public static final int CH = 3;
    public static final int CHAOS = 3;
    public static final int HESIOD = 4;
    public static final int HS = 4;
    public static final int IN = 1;
    public static final int NONE = 254;
    private static final Mnemonic classes;

    public static class DClassMnemonic extends Mnemonic {
        public DClassMnemonic() {
            super("DClass", 2);
            setPrefix("CLASS");
        }

        @Override // org.xbill.DNS.Mnemonic
        public void check(int i2) {
            DClass.check(i2);
        }
    }

    static {
        DClassMnemonic dClassMnemonic = new DClassMnemonic();
        classes = dClassMnemonic;
        dClassMnemonic.add(1, RegionUtil.SubRegionUtil.SUB_REGION_STRING_IN);
        dClassMnemonic.add(3, "CH");
        dClassMnemonic.addAlias(3, "CHAOS");
        dClassMnemonic.add(4, "HS");
        dClassMnemonic.addAlias(4, "HESIOD");
        dClassMnemonic.add(254, "NONE");
        dClassMnemonic.add(255, "ANY");
    }

    private DClass() {
    }

    public static void check(int i2) {
        if (i2 < 0 || i2 > 65535) {
            throw new InvalidDClassException(i2);
        }
    }

    public static String string(int i2) {
        return classes.getText(i2);
    }

    public static int value(String str) {
        return classes.getValue(str);
    }
}
