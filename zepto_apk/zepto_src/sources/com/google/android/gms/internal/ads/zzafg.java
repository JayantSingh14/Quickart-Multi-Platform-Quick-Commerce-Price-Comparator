package com.google.android.gms.internal.ads;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public final class zzafg {

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f22920c = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");

    /* renamed from: a, reason: collision with root package name */
    public int f22921a = -1;

    /* renamed from: b, reason: collision with root package name */
    public int f22922b = -1;

    public final void a(zzap zzapVar) {
        zzguy zzguyVar = (zzguy) zzapVar.a(zzaia.class, zzaff.f22919a);
        int i2 = zzguyVar.f33234d;
        int i3 = 0;
        int i4 = 0;
        while (i4 < i2) {
            boolean zB = b(((zzaia) zzguyVar.get(i4)).f23174d);
            i4++;
            if (zB) {
                return;
            }
        }
        zzguy zzguyVar2 = (zzguy) zzapVar.a(zzaii.class, zzafe.f22918a);
        int i5 = zzguyVar2.f33234d;
        while (i3 < i5) {
            boolean zB2 = b(((zzaii) zzguyVar2.get(i3)).f23188d);
            i3++;
            if (zB2) {
                return;
            }
        }
    }

    public final boolean b(String str) throws NumberFormatException {
        Matcher matcher = f22920c.matcher(str);
        if (!matcher.find()) {
            return false;
        }
        try {
            String strGroup = matcher.group(1);
            String str2 = zzfj.f31254a;
            int i2 = Integer.parseInt(strGroup, 16);
            int i3 = Integer.parseInt(matcher.group(2), 16);
            if (i2 <= 0 && i3 <= 0) {
                return false;
            }
            this.f22921a = i2;
            this.f22922b = i3;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }
}
