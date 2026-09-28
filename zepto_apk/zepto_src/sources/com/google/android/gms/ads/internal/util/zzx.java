package com.google.android.gms.ads.internal.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Rect;
import android.media.AudioManager;
import android.text.TextUtils;
import android.view.DisplayCutout;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import androidx.fragment.app.e;
import com.google.android.gms.internal.ads.zzbgk;
import com.google.android.gms.internal.ads.zzcda;
import java.util.Locale;
import javax.annotation.ParametersAreNonnullByDefault;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@ParametersAreNonnullByDefault
@TargetApi(28)
/* loaded from: classes4.dex */
public class zzx extends zzv {
    @Override // com.google.android.gms.ads.internal.util.zzz
    public final void e(final Activity activity) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.B1)).booleanValue() && com.google.android.gms.ads.internal.zzt.C.f21684h.g().o() == null && !activity.isInMultiWindowMode()) {
            Window window = activity.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (1 != attributes.layoutInDisplayCutoutMode) {
                attributes.layoutInDisplayCutoutMode = 1;
                window.setAttributes(attributes);
            }
            activity.getWindow().getDecorView().setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.google.android.gms.ads.internal.util.zzw
                @Override // android.view.View.OnApplyWindowInsetsListener
                public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    com.google.android.gms.ads.internal.zzt zztVar = com.google.android.gms.ads.internal.zzt.C;
                    if (zztVar.f21684h.g().o() == null) {
                        DisplayCutout displayCutout = windowInsets.getDisplayCutout();
                        zzcda zzcdaVar = zztVar.f21684h;
                        String strConcat = "";
                        if (displayCutout != null) {
                            zzj zzjVarG = zzcdaVar.g();
                            for (Rect rect : displayCutout.getBoundingRects()) {
                                Locale locale = Locale.US;
                                int i2 = rect.left;
                                int i3 = rect.top;
                                int i4 = rect.right;
                                int i5 = rect.bottom;
                                StringBuilder sb = new StringBuilder();
                                sb.append(i2);
                                sb.append(",");
                                sb.append(i3);
                                sb.append(",");
                                sb.append(i4);
                                String strR = e.r(sb, i5, ",");
                                if (!TextUtils.isEmpty(strConcat)) {
                                    strConcat = strConcat.concat(CLConstants.SALT_DELIMETER);
                                }
                                strConcat = strConcat.concat(strR);
                            }
                            zzjVarG.p(strConcat);
                        } else {
                            zzcdaVar.g().p("");
                        }
                    }
                    Window window2 = activity.getWindow();
                    WindowManager.LayoutParams attributes2 = window2.getAttributes();
                    if (2 != attributes2.layoutInDisplayCutoutMode) {
                        attributes2.layoutInDisplayCutoutMode = 2;
                        window2.setAttributes(attributes2);
                    }
                    return view.onApplyWindowInsets(windowInsets);
                }
            });
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzz
    public final int f(AudioManager audioManager) {
        return audioManager.getStreamMinVolume(3);
    }
}
