package androidx.media3.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

/* loaded from: classes3.dex */
public final /* synthetic */ class h implements View.OnLayoutChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11008a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f11009b;

    public /* synthetic */ h(Object obj, int i2) {
        this.f11008a = i2;
        this.f11009b = obj;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        int height;
        int height2;
        Object obj = this.f11009b;
        switch (this.f11008a) {
            case 0:
                PlayerControlViewLayoutManager playerControlViewLayoutManager = (PlayerControlViewLayoutManager) obj;
                PlayerControlView playerControlView = playerControlViewLayoutManager.f10893a;
                int width = (playerControlView.getWidth() - playerControlView.getPaddingLeft()) - playerControlView.getPaddingRight();
                int height3 = (playerControlView.getHeight() - playerControlView.getPaddingBottom()) - playerControlView.getPaddingTop();
                ViewGroup viewGroup = playerControlViewLayoutManager.f10895c;
                int iC = PlayerControlViewLayoutManager.c(viewGroup) - (viewGroup != null ? viewGroup.getPaddingRight() + viewGroup.getPaddingLeft() : 0);
                if (viewGroup == null) {
                    height = 0;
                } else {
                    height = viewGroup.getHeight();
                    ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        height += marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
                    }
                }
                int paddingBottom = height - (viewGroup != null ? viewGroup.getPaddingBottom() + viewGroup.getPaddingTop() : 0);
                int iMax = Math.max(iC, PlayerControlViewLayoutManager.c(playerControlViewLayoutManager.f10901i) + PlayerControlViewLayoutManager.c(playerControlViewLayoutManager.f10903k));
                ViewGroup viewGroup2 = playerControlViewLayoutManager.f10896d;
                if (viewGroup2 == null) {
                    height2 = 0;
                } else {
                    height2 = viewGroup2.getHeight();
                    ViewGroup.LayoutParams layoutParams2 = viewGroup2.getLayoutParams();
                    if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                        height2 += marginLayoutParams2.topMargin + marginLayoutParams2.bottomMargin;
                    }
                }
                boolean z = width <= iMax || height3 <= (height2 * 2) + paddingBottom;
                if (playerControlViewLayoutManager.A != z) {
                    playerControlViewLayoutManager.A = z;
                    view.post(new f(playerControlViewLayoutManager, 1));
                }
                boolean z2 = i4 - i2 != i8 - i6;
                if (!playerControlViewLayoutManager.A && z2) {
                    view.post(new f(playerControlViewLayoutManager, 2));
                    break;
                }
                break;
            default:
                float[] fArr = PlayerControlView.k1;
                PlayerControlView playerControlView2 = (PlayerControlView) obj;
                playerControlView2.getClass();
                int i10 = i5 - i3;
                int i11 = i9 - i7;
                if (i4 - i2 != i8 - i6 || i10 != i11) {
                    PopupWindow popupWindow = playerControlView2.f10874k;
                    if (popupWindow.isShowing()) {
                        playerControlView2.q();
                        int width2 = playerControlView2.getWidth() - popupWindow.getWidth();
                        int i12 = playerControlView2.f10875l;
                        popupWindow.update(view, width2 - i12, (-popupWindow.getHeight()) - i12, -1, -1);
                        break;
                    }
                }
                break;
        }
    }
}
