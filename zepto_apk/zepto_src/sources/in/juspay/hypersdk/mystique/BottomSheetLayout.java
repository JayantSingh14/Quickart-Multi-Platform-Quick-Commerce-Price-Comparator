package in.juspay.hypersdk.mystique;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import in.juspay.hypersdk.core.DuiCallback;

@Keep
/* loaded from: classes4.dex */
public class BottomSheetLayout extends FrameLayout {
    private final BottomSheetBehavior bottomSheetBehavior;
    private final BottomSheetCallback bottomSheetCallback;
    private boolean enableShift;
    private boolean overridePeakHeight;

    public class BottomSheetCallback extends BottomSheetBehavior.BottomSheetCallback {
        float bottomShift;
        private DuiCallback duiCallback;
        private float lastReceivedScroll;
        private String stateChangeCallback;
        private String stateSlideCallback;
        float topShift;
        boolean topShiftOverridden = false;
        boolean bottomShiftOverridden = false;

        public BottomSheetCallback() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onSlide(@NonNull View view, float f2) {
            this.lastReceivedScroll = f2;
            DuiCallback duiCallback = this.duiCallback;
            if (duiCallback == null || this.stateSlideCallback == null) {
                return;
            }
            duiCallback.addJsToWebView("window.callUICallback('" + this.stateSlideCallback + "','" + f2 + "');");
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onStateChanged(@NonNull View view, int i2) throws Resources.NotFoundException {
            if (i2 == 2 && BottomSheetLayout.this.enableShift) {
                if (!this.topShiftOverridden || !this.bottomShiftOverridden) {
                    float f2 = BottomSheetLayout.this.bottomSheetBehavior.F;
                    float fJ = BottomSheetLayout.this.bottomSheetBehavior.J() / view.getHeight();
                    if (!this.topShiftOverridden) {
                        this.topShift = (f2 / 2.0f) + 0.5f;
                    }
                    if (!this.bottomShiftOverridden) {
                        this.bottomShift = (f2 / 2.0f) - (fJ / 2.0f);
                    }
                }
                float f3 = this.bottomShift;
                float f4 = this.lastReceivedScroll;
                if (f3 > f4) {
                    BottomSheetLayout.this.bottomSheetBehavior.f(4);
                } else if (f4 <= f3 || f4 >= this.topShift) {
                    BottomSheetLayout.this.bottomSheetBehavior.f(3);
                } else {
                    BottomSheetLayout.this.bottomSheetBehavior.f(6);
                }
            }
            DuiCallback duiCallback = this.duiCallback;
            if (duiCallback == null || this.stateChangeCallback == null) {
                return;
            }
            duiCallback.addJsToWebView("window.callUICallback('" + this.stateChangeCallback + "','" + i2 + "');");
        }

        public void setBottomShift(float f2) {
            this.bottomShiftOverridden = true;
            this.bottomShift = f2;
        }

        public void setDuiCallback(DuiCallback duiCallback) {
            this.duiCallback = duiCallback;
        }

        public void setSlideCallback(String str) {
            this.stateSlideCallback = str;
        }

        public void setStateChangeCallback(String str) {
            this.stateChangeCallback = str;
        }

        public void setTopShift(float f2) {
            this.topShiftOverridden = true;
            this.topShift = f2;
        }
    }

    public BottomSheetLayout(@NonNull Context context) {
        super(context);
        this.enableShift = true;
        this.overridePeakHeight = true;
        BottomSheetBehavior bottomSheetBehavior = new BottomSheetBehavior();
        this.bottomSheetBehavior = bottomSheetBehavior;
        BottomSheetCallback bottomSheetCallback = new BottomSheetCallback();
        this.bottomSheetCallback = bottomSheetCallback;
        bottomSheetBehavior.y(bottomSheetCallback);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.overridePeakHeight) {
            this.bottomSheetBehavior.S(getMeasuredHeight());
        }
    }

    @Keep
    public void setBottomShift(float f2) {
        this.bottomSheetCallback.setBottomShift(f2);
    }

    @Keep
    public void setEnableShift(boolean z) {
        this.enableShift = z;
    }

    @Keep
    public void setHalfExpandedRatio(float f2) {
        this.bottomSheetBehavior.Q(f2);
    }

    @Keep
    public void setHideable(boolean z) throws Resources.NotFoundException {
        this.bottomSheetBehavior.R(z);
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
            ((CoordinatorLayout.LayoutParams) layoutParams).c(this.bottomSheetBehavior);
        }
        super.setLayoutParams(layoutParams);
    }

    @Keep
    public void setPeakHeight(int i2) {
        this.bottomSheetBehavior.S(i2);
        this.overridePeakHeight = false;
    }

    public void setSlideCallback(DuiCallback duiCallback, String str) {
        this.bottomSheetCallback.setDuiCallback(duiCallback);
        this.bottomSheetCallback.setSlideCallback(str);
    }

    @Keep
    public void setState(int i2) throws Resources.NotFoundException {
        this.bottomSheetBehavior.f(i2);
    }

    public void setStateChangeCallback(DuiCallback duiCallback, String str) {
        this.bottomSheetCallback.setDuiCallback(duiCallback);
        this.bottomSheetCallback.setStateChangeCallback(str);
    }

    @Keep
    public void setTopShift(float f2) {
        this.bottomSheetCallback.setTopShift(f2);
    }
}
