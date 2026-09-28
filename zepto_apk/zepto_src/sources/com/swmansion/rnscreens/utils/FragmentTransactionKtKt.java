package com.swmansion.rnscreens.utils;

import androidx.fragment.app.FragmentTransaction;
import com.swmansion.rnscreens.R;
import com.swmansion.rnscreens.Screen;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
public final class FragmentTransactionKtKt {

    @Metadata
    public /* synthetic */ class WhenMappings {
        static {
            int[] iArr = new int[Screen.StackAnimation.values().length];
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Screen.StackAnimation stackAnimation = Screen.StackAnimation.f46958a;
                iArr[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                Screen.StackAnimation stackAnimation2 = Screen.StackAnimation.f46958a;
                iArr[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                Screen.StackAnimation stackAnimation3 = Screen.StackAnimation.f46958a;
                iArr[4] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                Screen.StackAnimation stackAnimation4 = Screen.StackAnimation.f46958a;
                iArr[5] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                Screen.StackAnimation stackAnimation5 = Screen.StackAnimation.f46958a;
                iArr[3] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                Screen.StackAnimation stackAnimation6 = Screen.StackAnimation.f46958a;
                iArr[6] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                Screen.StackAnimation stackAnimation7 = Screen.StackAnimation.f46958a;
                iArr[7] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                Screen.StackAnimation stackAnimation8 = Screen.StackAnimation.f46958a;
                iArr[8] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public static final void a(FragmentTransaction fragmentTransaction, Screen.StackAnimation stackAnimation, boolean z) {
        Intrinsics.checkNotNullParameter(fragmentTransaction, "<this>");
        Intrinsics.checkNotNullParameter(stackAnimation, "stackAnimation");
        if (z) {
            switch (stackAnimation.ordinal()) {
                case 0:
                    fragmentTransaction.k(R.anim.rns_default_enter_in, R.anim.rns_default_enter_out);
                    return;
                case 1:
                    int i2 = R.anim.rns_no_animation_20;
                    fragmentTransaction.k(i2, i2);
                    return;
                case 2:
                    fragmentTransaction.k(R.anim.rns_fade_in, R.anim.rns_fade_out);
                    return;
                case 3:
                    fragmentTransaction.k(R.anim.rns_slide_in_from_bottom, R.anim.rns_no_animation_medium);
                    return;
                case 4:
                    fragmentTransaction.k(R.anim.rns_slide_in_from_right, R.anim.rns_slide_out_to_left);
                    return;
                case 5:
                    fragmentTransaction.k(R.anim.rns_slide_in_from_left, R.anim.rns_slide_out_to_right);
                    return;
                case 6:
                    fragmentTransaction.k(R.anim.rns_fade_from_bottom, R.anim.rns_no_animation_350);
                    return;
                case 7:
                    fragmentTransaction.k(R.anim.rns_ios_from_right_foreground_open, R.anim.rns_ios_from_right_background_open);
                    return;
                case 8:
                    fragmentTransaction.k(R.anim.rns_ios_from_left_foreground_open, R.anim.rns_ios_from_left_background_open);
                    return;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
        switch (stackAnimation.ordinal()) {
            case 0:
                fragmentTransaction.k(R.anim.rns_default_exit_in, R.anim.rns_default_exit_out);
                return;
            case 1:
                int i3 = R.anim.rns_no_animation_20;
                fragmentTransaction.k(i3, i3);
                return;
            case 2:
                fragmentTransaction.k(R.anim.rns_fade_in, R.anim.rns_fade_out);
                return;
            case 3:
                fragmentTransaction.k(R.anim.rns_no_animation_medium, R.anim.rns_slide_out_to_bottom);
                return;
            case 4:
                fragmentTransaction.k(R.anim.rns_slide_in_from_left, R.anim.rns_slide_out_to_right);
                return;
            case 5:
                fragmentTransaction.k(R.anim.rns_slide_in_from_right, R.anim.rns_slide_out_to_left);
                return;
            case 6:
                fragmentTransaction.k(R.anim.rns_no_animation_250, R.anim.rns_fade_to_bottom);
                return;
            case 7:
                fragmentTransaction.k(R.anim.rns_ios_from_right_background_close, R.anim.rns_ios_from_right_foreground_close);
                return;
            case 8:
                fragmentTransaction.k(R.anim.rns_ios_from_left_background_close, R.anim.rns_ios_from_left_foreground_close);
                return;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
