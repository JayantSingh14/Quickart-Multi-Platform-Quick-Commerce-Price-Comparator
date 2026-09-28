package com.facebook.soloader;

import android.util.Log;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@DoNotStripAny
/* loaded from: classes3.dex */
public class SoLoaderULErrorFactory {
    public static SoLoaderULError a(String str, UnsatisfiedLinkError unsatisfiedLinkError) {
        SoLoaderULError soLoaderULError;
        if (unsatisfiedLinkError.getMessage() == null || !unsatisfiedLinkError.getMessage().contains("ELF")) {
            Matcher matcher = Pattern.compile("\\P{ASCII}+").matcher(str);
            if (matcher.find()) {
                Log.w("SoLoader", "Library name is corrupted, contains non-ASCII characters " + matcher.group());
                LogUtil.a("Corrupted lib name detected");
                soLoaderULError = new SoLoaderCorruptedLibNameError(str, "corrupted lib name: " + unsatisfiedLinkError.toString());
            } else {
                soLoaderULError = new SoLoaderULError(str, unsatisfiedLinkError.toString());
            }
        } else {
            LogUtil.a("Corrupted lib file detected");
            soLoaderULError = new SoLoaderCorruptedLibFileError(str, unsatisfiedLinkError.toString());
        }
        soLoaderULError.initCause(unsatisfiedLinkError);
        return soLoaderULError;
    }
}
