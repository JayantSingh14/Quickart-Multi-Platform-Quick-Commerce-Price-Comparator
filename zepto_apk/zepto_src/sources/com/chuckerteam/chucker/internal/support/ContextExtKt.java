package com.chuckerteam.chucker.internal.support;

import android.content.DialogInterface;
import com.chuckerteam.chucker.internal.data.model.DialogData;
import com.chuckerteam.chucker.internal.ui.MainActivity;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class ContextExtKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.chuckerteam.chucker.internal.support.b] */
    public static final void a(MainActivity mainActivity, DialogData dialogData, final Function0 function0) {
        Intrinsics.checkNotNullParameter(mainActivity, "<this>");
        Intrinsics.checkNotNullParameter(dialogData, "dialogData");
        MaterialAlertDialogBuilder materialAlertDialogBuilderG = new MaterialAlertDialogBuilder(mainActivity).g(dialogData.f16713a);
        materialAlertDialogBuilderG.f282a.f263f = dialogData.f16714b;
        materialAlertDialogBuilderG.f(dialogData.f16715c, new DialogInterface.OnClickListener() { // from class: com.chuckerteam.chucker.internal.support.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                Function0 function02 = function0;
                if (function02 != null) {
                    function02.invoke();
                }
            }
        });
        materialAlertDialogBuilderG.e(dialogData.f16716d, new c());
        materialAlertDialogBuilderG.create().show();
    }
}
