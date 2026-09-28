package com.chuckerteam.chucker.internal.ui;

import android.content.Intent;
import androidx.constraintlayout.widget.Group;
import com.chuckerteam.chucker.databinding.ChuckerActivityMainBinding;
import com.chuckerteam.chucker.internal.ui.transaction.TransactionActivity;
import com.chuckerteam.chucker.internal.ui.transaction.TransactionAdapter;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16890a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MainActivity f16891b;

    public /* synthetic */ a(MainActivity mainActivity, int i2) {
        this.f16890a = i2;
        this.f16891b = mainActivity;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        MainActivity context = this.f16891b;
        switch (this.f16890a) {
            case 0:
                long jLongValue = ((Long) obj).longValue();
                int i2 = MainActivity.p;
                Intrinsics.checkNotNullParameter(context, "context");
                Intent intent = new Intent(context, (Class<?>) TransactionActivity.class);
                intent.putExtra("transaction_id", jLongValue);
                context.startActivity(intent);
                return Unit.f53572a;
            default:
                List list = (List) obj;
                TransactionAdapter transactionAdapter = context.f16851l;
                if (transactionAdapter == null) {
                    Intrinsics.h("transactionsAdapter");
                    throw null;
                }
                transactionAdapter.y(list);
                ChuckerActivityMainBinding chuckerActivityMainBinding = context.f16850k;
                if (chuckerActivityMainBinding == null) {
                    Intrinsics.h("mainBinding");
                    throw null;
                }
                Group tutorialGroup = chuckerActivityMainBinding.f16650e;
                Intrinsics.checkNotNullExpressionValue(tutorialGroup, "tutorialGroup");
                tutorialGroup.setVisibility(list.isEmpty() ? 0 : 8);
                return Unit.f53572a;
        }
    }
}
