package androidx.media3.ui;

import android.view.View;
import androidx.media3.common.Player;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.util.Util;
import androidx.media3.ui.PlayerControlView;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes3.dex */
public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10996a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f10997b;

    public /* synthetic */ c(Object obj, int i2) {
        this.f10996a = i2;
        this.f10997b = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        RecyclerView recyclerView;
        RecyclerView.Adapter adapter;
        int iK;
        Object obj = this.f10997b;
        switch (this.f10996a) {
            case 0:
                PlayerControlView playerControlView = PlayerControlView.this;
                Player player = playerControlView.S0;
                if (player != null && player.D1(29)) {
                    TrackSelectionParameters trackSelectionParametersH0 = playerControlView.S0.H0();
                    Player player2 = playerControlView.S0;
                    int i2 = Util.f5744a;
                    player2.m1(trackSelectionParametersH0.a().d(1).i(1).b());
                    playerControlView.f10869f.f10884e[1] = playerControlView.getResources().getString(R.string.exo_track_selection_auto);
                    playerControlView.f10874k.dismiss();
                    break;
                }
                break;
            case 1:
                int i3 = PlayerControlView.SettingViewHolder.y;
                PlayerControlView.SettingViewHolder settingViewHolder = (PlayerControlView.SettingViewHolder) obj;
                int iC = -1;
                if (settingViewHolder.s != null && (recyclerView = settingViewHolder.r) != null && (adapter = recyclerView.getAdapter()) != null && (iK = settingViewHolder.r.K(settingViewHolder)) != -1) {
                    iC = adapter.c(settingViewHolder.s, iK);
                }
                PlayerControlView playerControlView2 = PlayerControlView.this;
                View view2 = playerControlView2.z;
                if (iC != 0) {
                    if (iC != 1) {
                        playerControlView2.f10874k.dismiss();
                        break;
                    } else {
                        view2.getClass();
                        playerControlView2.e(playerControlView2.f10872i, view2);
                        break;
                    }
                } else {
                    view2.getClass();
                    playerControlView2.e(playerControlView2.f10870g, view2);
                    break;
                }
                break;
            case 2:
                PlayerControlView playerControlView3 = PlayerControlView.this;
                Player player3 = playerControlView3.S0;
                if (player3 != null && player3.D1(29)) {
                    playerControlView3.S0.m1(playerControlView3.S0.H0().a().d(3).g().b());
                    playerControlView3.f10874k.dismiss();
                    break;
                }
                break;
            case 3:
                PlayerControlViewLayoutManager playerControlViewLayoutManager = (PlayerControlViewLayoutManager) obj;
                playerControlViewLayoutManager.g();
                if (view.getId() != R.id.exo_overflow_show) {
                    if (view.getId() == R.id.exo_overflow_hide) {
                        playerControlViewLayoutManager.r.start();
                        break;
                    }
                } else {
                    playerControlViewLayoutManager.q.start();
                    break;
                }
                break;
            default:
                PlayerControlView.a((PlayerControlView) obj);
                break;
        }
    }
}
