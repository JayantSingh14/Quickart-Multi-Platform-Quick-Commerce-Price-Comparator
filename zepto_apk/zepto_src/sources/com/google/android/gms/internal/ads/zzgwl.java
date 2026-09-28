package com.google.android.gms.internal.ads;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public final class zzgwl implements FilenameFilter {

    /* renamed from: a, reason: collision with root package name */
    public final Pattern f33292a;

    public zzgwl(Pattern pattern) {
        pattern.getClass();
        this.f33292a = pattern;
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        return this.f33292a.matcher(str).matches();
    }
}
