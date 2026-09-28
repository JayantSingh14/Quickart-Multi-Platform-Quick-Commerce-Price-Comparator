package org.xbill.DNS;

/* loaded from: classes5.dex */
public final class Section {
    public static final int ADDITIONAL = 3;
    public static final int ANSWER = 1;
    public static final int AUTHORITY = 2;
    public static final int PREREQ = 1;
    public static final int QUESTION = 0;
    public static final int UPDATE = 2;
    public static final int ZONE = 0;
    private static final String[] longSections;
    private static final Mnemonic sections;
    private static final String[] updateSections;

    static {
        Mnemonic mnemonic = new Mnemonic("Message Section", 3);
        sections = mnemonic;
        longSections = new String[]{"QUESTIONS", "ANSWERS", "AUTHORITY RECORDS", "ADDITIONAL RECORDS"};
        updateSections = new String[]{"ZONE", "PREREQUISITES", "UPDATE RECORDS", "ADDITIONAL RECORDS"};
        mnemonic.setMaximum(3);
        mnemonic.setNumericAllowed(true);
        mnemonic.add(0, "qd");
        mnemonic.add(1, "an");
        mnemonic.add(2, "au");
        mnemonic.add(3, "ad");
    }

    private Section() {
    }

    public static void check(int i2) {
        sections.check(i2);
    }

    public static String longString(int i2) {
        sections.check(i2);
        return longSections[i2];
    }

    public static String string(int i2) {
        return sections.getText(i2);
    }

    public static String updString(int i2) {
        sections.check(i2);
        return updateSections[i2];
    }

    public static int value(String str) {
        return sections.getValue(str);
    }
}
