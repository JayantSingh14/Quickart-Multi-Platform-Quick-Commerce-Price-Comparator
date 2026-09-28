package com.chuckerteam.chucker.internal.ui.transaction;

import android.view.Menu;
import com.chuckerteam.chucker.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes3.dex */
public final /* synthetic */ class f implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Menu f16985a;

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        this.f16985a.findItem(R.id.encode_url).setVisible(((Boolean) obj).booleanValue());
        return Unit.f53572a;
    }
}
