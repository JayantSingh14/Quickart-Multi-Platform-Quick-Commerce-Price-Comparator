package com.swmansion.reanimated.keyboard;

import androidx.core.view.WindowInsetsCompat;
import com.facebook.react.uimanager.PixelUtil;

/* loaded from: classes.dex */
public class Keyboard {
    private static final int CONTENT_TYPE_MASK = 8;
    private static final int SYSTEM_BAR_TYPE_MASK = 519;
    private KeyboardState mState = KeyboardState.UNKNOWN;
    private int mHeight = 0;
    private int mActiveTransitionCounter = 0;

    public int getHeight() {
        return this.mHeight;
    }

    public KeyboardState getState() {
        return this.mState;
    }

    public void onAnimationEnd() {
        int i2 = this.mActiveTransitionCounter - 1;
        this.mActiveTransitionCounter = i2;
        if (i2 == 0) {
            this.mState = this.mHeight <= 0 ? KeyboardState.CLOSED : KeyboardState.OPEN;
        }
    }

    public void onAnimationStart() {
        int i2 = this.mActiveTransitionCounter;
        if (i2 > 0) {
            KeyboardState keyboardState = this.mState;
            KeyboardState keyboardState2 = KeyboardState.OPENING;
            if (keyboardState == keyboardState2) {
                keyboardState2 = KeyboardState.CLOSING;
            }
            this.mState = keyboardState2;
        } else {
            this.mState = this.mHeight <= 0 ? KeyboardState.OPENING : KeyboardState.CLOSING;
        }
        this.mActiveTransitionCounter = i2 + 1;
    }

    public void updateHeight(WindowInsetsCompat windowInsetsCompat, boolean z) {
        int iA = (int) PixelUtil.a(Math.max(0, windowInsetsCompat.d(CONTENT_TYPE_MASK).f2811d - (z ? 0 : windowInsetsCompat.d(SYSTEM_BAR_TYPE_MASK).f2811d)));
        if (iA > 0 || this.mState != KeyboardState.OPEN) {
            this.mHeight = iA;
        }
    }
}
