package com.google.ads.interactivemedia.v3.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.google.ads.interactivemedia.v3.api.CompanionAdSlot;
import com.google.ads.interactivemedia.v3.impl.JavaScriptMessage;
import com.google.ads.interactivemedia.v3.internal.zzeo;
import com.google.ads.interactivemedia.v3.internal.zzfl;
import com.google.ads.interactivemedia.v3.internal.zzpg;
import com.google.ads.interactivemedia.v3.internal.zzqs;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes3.dex */
public final class zzao extends ImageView implements View.OnClickListener {
    private final com.google.ads.interactivemedia.v3.impl.data.zzbk zza;
    private final zzav zzb;
    private final String zzc;
    private final List zzd;
    private final zzfl zze;

    private zzao(Context context, zzav zzavVar, com.google.ads.interactivemedia.v3.impl.data.zzbk zzbkVar, String str, List list, zzfl zzflVar) {
        super(context);
        this.zzb = zzavVar;
        this.zza = zzbkVar;
        this.zzc = str;
        this.zzd = list;
        this.zze = zzflVar;
    }

    public static zzao zza(Context context, zzav zzavVar, com.google.ads.interactivemedia.v3.impl.data.zzbk zzbkVar, Task task, String str, List list, zzfl zzflVar) {
        final zzao zzaoVar = new zzao(context, zzavVar, zzbkVar, str, list, zzflVar);
        zzaoVar.setOnClickListener(zzaoVar);
        task.addOnCompleteListener(new OnCompleteListener() { // from class: com.google.ads.interactivemedia.v3.impl.zzan
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task2) {
                if (task2.p()) {
                    this.zza.setImageBitmap((Bitmap) task2.l());
                } else {
                    zzeo.zzb("Image companion error", task2.k());
                }
            }
        });
        return zzaoVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (!this.zze.zzb(this.zza.clickThroughUrl())) {
            zzeo.zza("The click was ignored because no browser was available.");
            return;
        }
        Iterator it = this.zzd.iterator();
        while (it.hasNext()) {
            ((CompanionAdSlot.ClickListener) it.next()).onCompanionAdClick();
        }
    }

    @Override // android.widget.ImageView
    public final void setImageBitmap(@Nullable Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        String strCompanionId = this.zza.companionId();
        if (zzpg.zzc(strCompanionId)) {
            return;
        }
        String str = this.zzc;
        if (zzpg.zzc(str)) {
            return;
        }
        zzav zzavVar = this.zzb;
        HashMap mapZzb = zzqs.zzb(1);
        mapZzb.put("companionId", strCompanionId);
        zzavVar.zzp(new JavaScriptMessage(JavaScriptMessage.MsgChannel.displayContainer, JavaScriptMessage.MsgType.companionView, str, mapZzb));
    }
}
