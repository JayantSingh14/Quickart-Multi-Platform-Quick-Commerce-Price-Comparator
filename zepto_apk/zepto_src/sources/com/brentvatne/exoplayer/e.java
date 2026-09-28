package com.brentvatne.exoplayer;

import android.app.Activity;
import android.os.Build;
import androidx.activity.ComponentActivity;
import androidx.core.app.PictureInPictureModeChangedInfo;
import androidx.core.util.Consumer;
import androidx.lifecycle.Lifecycle;
import com.brentvatne.common.api.Source;
import com.brentvatne.common.toolbox.DebugLog;
import com.facebook.react.uimanager.ThemedReactContext;
import java.util.concurrent.Executors;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final /* synthetic */ class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15608a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ReactExoplayerView f15609b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Source f15610c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ReactExoplayerView f15611d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Activity f15612e;

    public /* synthetic */ e(ReactExoplayerView reactExoplayerView, Source source, Activity activity, ReactExoplayerView reactExoplayerView2) {
        this.f15609b = reactExoplayerView;
        this.f15610c = source;
        this.f15612e = activity;
        this.f15611d = reactExoplayerView2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f15608a) {
            case 0:
                ReactExoplayerView reactExoplayerView = this.f15609b;
                boolean z = reactExoplayerView.e1;
                Source source = this.f15610c;
                if (!z || source != reactExoplayerView.E0) {
                    Activity activity = this.f15612e;
                    if (activity != null) {
                        activity.runOnUiThread(new androidx.media3.common.util.e(reactExoplayerView, source, this.f15611d, 12));
                        break;
                    } else {
                        DebugLog.b("ReactExoplayerView", "Failed to initialize Player!, null activity");
                        reactExoplayerView.f15560a.f15444c.invoke("Failed to initialize Player!", new Exception("Current Activity is null!"), "1001");
                        break;
                    }
                }
                break;
            default:
                ReactExoplayerView reactExoplayerView2 = this.f15611d;
                Activity activity2 = this.f15612e;
                final ReactExoplayerView view = this.f15609b;
                ThemedReactContext context = view.W0;
                boolean z2 = view.e1;
                Source source2 = this.f15610c;
                if (!z2 || source2 != view.E0) {
                    try {
                        if (source2.f15392b != null) {
                            if (view.f15570k == null) {
                                view.T(reactExoplayerView2);
                                Intrinsics.checkNotNullParameter(context, "context");
                                Intrinsics.checkNotNullParameter(view, "view");
                                final ComponentActivity componentActivityA = PictureInPictureUtilKt.a(context);
                                Consumer<PictureInPictureModeChangedInfo> consumer = new Consumer() { // from class: com.brentvatne.exoplayer.c
                                    @Override // androidx.core.util.Consumer
                                    public final void accept(Object obj) {
                                        PictureInPictureModeChangedInfo info = (PictureInPictureModeChangedInfo) obj;
                                        Intrinsics.checkNotNullParameter(info, "info");
                                        boolean z3 = info.f2707a;
                                        ReactExoplayerView reactExoplayerView3 = view;
                                        reactExoplayerView3.setIsInPictureInPicture(z3);
                                        if (info.f2707a || componentActivityA.getLifecycle().b() != Lifecycle.State.f4807c || reactExoplayerView3.S0) {
                                            return;
                                        }
                                        reactExoplayerView3.setPausedModifier(true);
                                    }
                                };
                                d dVar = new d(view, 0);
                                componentActivityA.addOnPictureInPictureModeChangedListener(consumer);
                                if (Build.VERSION.SDK_INT < 31) {
                                    componentActivityA.addOnUserLeaveHintListener(dVar);
                                }
                                view.L = new androidx.media3.common.util.e(componentActivityA, consumer, dVar, 11);
                                PictureInPictureUtil.a(context, view.A, view.z);
                            }
                            Source source3 = view.E0;
                            if (source3.f15393c || source3.f15394d || source3.q.f15342a <= 0) {
                                view.M = false;
                            } else {
                                RNVSimpleCache.b(view.E0.q.f15342a, view.getContext());
                                view.M = true;
                            }
                            if (!view.f15572m) {
                                if (source2 == view.E0) {
                                    view.U(source2);
                                    break;
                                }
                            } else {
                                view.f15566g.e();
                                view.f15566g.f15534e.setVideoAspectRatio(0.0f);
                                Executors.newSingleThreadExecutor().execute(new e(view, source2, activity2, reactExoplayerView2));
                                break;
                            }
                        } else {
                            break;
                        }
                    } catch (Exception e2) {
                        reactExoplayerView2.f15572m = true;
                        DebugLog.b("ReactExoplayerView", "Failed to initialize Player! 2");
                        DebugLog.b("ReactExoplayerView", e2.toString());
                        e2.printStackTrace();
                        view.f15560a.f15444c.invoke(e2.toString(), e2, "1001");
                    }
                }
                break;
        }
    }

    public /* synthetic */ e(ReactExoplayerView reactExoplayerView, Source source, ReactExoplayerView reactExoplayerView2, Activity activity) {
        this.f15609b = reactExoplayerView;
        this.f15610c = source;
        this.f15611d = reactExoplayerView2;
        this.f15612e = activity;
    }
}
