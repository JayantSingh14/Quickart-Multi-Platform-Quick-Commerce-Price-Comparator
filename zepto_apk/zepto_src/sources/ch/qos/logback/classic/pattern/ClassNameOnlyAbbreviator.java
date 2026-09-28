package ch.qos.logback.classic.pattern;

/* loaded from: classes3.dex */
public class ClassNameOnlyAbbreviator implements Abbreviator {
    @Override // ch.qos.logback.classic.pattern.Abbreviator
    public final String a(String str) {
        int iLastIndexOf = str.lastIndexOf(46);
        return iLastIndexOf != -1 ? str.substring(iLastIndexOf + 1, str.length()) : str;
    }
}
