package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public final class zzfsj {

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f31790b = Pattern.compile("^[a-zA-Z0-9 ]+$");

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f31791a = new ArrayList();

    public final void a(View view, zzfro zzfroVar) {
        zzfsi zzfsiVar;
        if (view == null) {
            throw new IllegalArgumentException("FriendlyObstruction is null");
        }
        if (!f31790b.matcher("Ad overlay").matches()) {
            throw new IllegalArgumentException("FriendlyObstruction has detailed reason that contains characters not in [a-z][A-Z][0-9] or space");
        }
        ArrayList arrayList = this.f31791a;
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                zzfsiVar = null;
                break;
            } else {
                zzfsiVar = (zzfsi) it.next();
                if (zzfsiVar.f31786a.get() == view) {
                    break;
                }
            }
        }
        if (zzfsiVar == null) {
            arrayList.add(new zzfsi(view, zzfroVar));
        }
    }
}
