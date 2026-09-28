package com.brentvatne.exoplayer;

import android.app.AlertDialog;
import android.content.DialogInterface;
import com.brentvatne.react.R;
import java.net.CookieManager;

/* loaded from: classes3.dex */
public final /* synthetic */ class i implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15625a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ReactExoplayerView f15626b;

    public /* synthetic */ i(ReactExoplayerView reactExoplayerView, int i2) {
        this.f15625a = i2;
        this.f15626b = reactExoplayerView;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        ReactExoplayerView reactExoplayerView = this.f15626b;
        switch (this.f15625a) {
            case 0:
                CookieManager cookieManager = ReactExoplayerView.j1;
                reactExoplayerView.getClass();
                if (i2 == 0) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(reactExoplayerView.W0);
                    builder.setTitle(R.string.select_playback_speed);
                    builder.setSingleChoiceItems(new String[]{"0.5x", "1.0x", "1.5x", "2.0x"}, reactExoplayerView.f1, new i(reactExoplayerView, 1));
                    builder.show();
                    break;
                }
                break;
            default:
                reactExoplayerView.f1 = i2;
                if (i2 == 0 || i2 != 2) {
                }
                reactExoplayerView.setRateModifier(1.0f);
                break;
        }
    }
}
