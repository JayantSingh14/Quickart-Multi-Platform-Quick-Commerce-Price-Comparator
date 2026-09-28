package androidx.media3.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import androidx.media3.ui.PlayerControlView;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
final class PlayerControlViewLayoutManager {
    public boolean A;
    public boolean B;

    /* renamed from: a, reason: collision with root package name */
    public final PlayerControlView f10893a;

    /* renamed from: b, reason: collision with root package name */
    public final View f10894b;

    /* renamed from: c, reason: collision with root package name */
    public final ViewGroup f10895c;

    /* renamed from: d, reason: collision with root package name */
    public final ViewGroup f10896d;

    /* renamed from: e, reason: collision with root package name */
    public final ViewGroup f10897e;

    /* renamed from: f, reason: collision with root package name */
    public final ViewGroup f10898f;

    /* renamed from: g, reason: collision with root package name */
    public final ViewGroup f10899g;

    /* renamed from: h, reason: collision with root package name */
    public final ViewGroup f10900h;

    /* renamed from: i, reason: collision with root package name */
    public final ViewGroup f10901i;

    /* renamed from: j, reason: collision with root package name */
    public final View f10902j;

    /* renamed from: k, reason: collision with root package name */
    public final View f10903k;

    /* renamed from: l, reason: collision with root package name */
    public final AnimatorSet f10904l;

    /* renamed from: m, reason: collision with root package name */
    public final AnimatorSet f10905m;
    public final AnimatorSet n;
    public final AnimatorSet o;
    public final AnimatorSet p;
    public final ValueAnimator q;
    public final ValueAnimator r;
    public final f s = new f(this, 0);
    public final f t = new f(this, 3);
    public final f u = new f(this, 4);
    public final f v = new f(this, 5);
    public final f w = new f(this, 6);
    public final h x = new h(this, 0);
    public boolean C = true;
    public int z = 0;
    public final ArrayList y = new ArrayList();

    public PlayerControlViewLayoutManager(final PlayerControlView playerControlView) throws Resources.NotFoundException {
        this.f10893a = playerControlView;
        this.f10894b = playerControlView.findViewById(R.id.exo_controls_background);
        this.f10895c = (ViewGroup) playerControlView.findViewById(R.id.exo_center_controls);
        this.f10897e = (ViewGroup) playerControlView.findViewById(R.id.exo_minimal_controls);
        ViewGroup viewGroup = (ViewGroup) playerControlView.findViewById(R.id.exo_bottom_bar);
        this.f10896d = viewGroup;
        this.f10901i = (ViewGroup) playerControlView.findViewById(R.id.exo_time);
        View viewFindViewById = playerControlView.findViewById(R.id.exo_progress);
        this.f10902j = viewFindViewById;
        this.f10898f = (ViewGroup) playerControlView.findViewById(R.id.exo_basic_controls);
        this.f10899g = (ViewGroup) playerControlView.findViewById(R.id.exo_extra_controls);
        this.f10900h = (ViewGroup) playerControlView.findViewById(R.id.exo_extra_controls_scroll_view);
        View viewFindViewById2 = playerControlView.findViewById(R.id.exo_overflow_show);
        this.f10903k = viewFindViewById2;
        View viewFindViewById3 = playerControlView.findViewById(R.id.exo_overflow_hide);
        if (viewFindViewById2 != null && viewFindViewById3 != null) {
            viewFindViewById2.setOnClickListener(new c(this, 3));
            viewFindViewById3.setOnClickListener(new c(this, 3));
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new g(this, 3));
        valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: androidx.media3.ui.PlayerControlViewLayoutManager.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                PlayerControlViewLayoutManager playerControlViewLayoutManager = PlayerControlViewLayoutManager.this;
                View view = playerControlViewLayoutManager.f10894b;
                if (view != null) {
                    view.setVisibility(4);
                }
                ViewGroup viewGroup2 = playerControlViewLayoutManager.f10895c;
                if (viewGroup2 != null) {
                    viewGroup2.setVisibility(4);
                }
                ViewGroup viewGroup3 = playerControlViewLayoutManager.f10897e;
                if (viewGroup3 != null) {
                    viewGroup3.setVisibility(4);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                PlayerControlViewLayoutManager playerControlViewLayoutManager = PlayerControlViewLayoutManager.this;
                View view = playerControlViewLayoutManager.f10902j;
                if (!(view instanceof DefaultTimeBar) || playerControlViewLayoutManager.A) {
                    return;
                }
                DefaultTimeBar defaultTimeBar = (DefaultTimeBar) view;
                ValueAnimator valueAnimator = defaultTimeBar.E;
                if (valueAnimator.isStarted()) {
                    valueAnimator.cancel();
                }
                valueAnimator.setFloatValues(defaultTimeBar.F, 0.0f);
                valueAnimator.setDuration(250L);
                valueAnimator.start();
            }
        });
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat2.addUpdateListener(new g(this, 0));
        valueAnimatorOfFloat2.addListener(new AnimatorListenerAdapter() { // from class: androidx.media3.ui.PlayerControlViewLayoutManager.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                PlayerControlViewLayoutManager playerControlViewLayoutManager = PlayerControlViewLayoutManager.this;
                View view = playerControlViewLayoutManager.f10894b;
                if (view != null) {
                    view.setVisibility(0);
                }
                ViewGroup viewGroup2 = playerControlViewLayoutManager.f10895c;
                if (viewGroup2 != null) {
                    viewGroup2.setVisibility(0);
                }
                ViewGroup viewGroup3 = playerControlViewLayoutManager.f10897e;
                if (viewGroup3 != null) {
                    viewGroup3.setVisibility(playerControlViewLayoutManager.A ? 0 : 4);
                }
                View view2 = playerControlViewLayoutManager.f10902j;
                if (!(view2 instanceof DefaultTimeBar) || playerControlViewLayoutManager.A) {
                    return;
                }
                DefaultTimeBar defaultTimeBar = (DefaultTimeBar) view2;
                ValueAnimator valueAnimator = defaultTimeBar.E;
                if (valueAnimator.isStarted()) {
                    valueAnimator.cancel();
                }
                defaultTimeBar.G = false;
                valueAnimator.setFloatValues(defaultTimeBar.F, 1.0f);
                valueAnimator.setDuration(250L);
                valueAnimator.start();
            }
        });
        Resources resources = playerControlView.getResources();
        float dimension = resources.getDimension(R.dimen.exo_styled_bottom_bar_height) - resources.getDimension(R.dimen.exo_styled_progress_bar_height);
        float dimension2 = resources.getDimension(R.dimen.exo_styled_bottom_bar_height);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f10904l = animatorSet;
        animatorSet.setDuration(250L);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: androidx.media3.ui.PlayerControlViewLayoutManager.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                PlayerControlViewLayoutManager playerControlViewLayoutManager = PlayerControlViewLayoutManager.this;
                playerControlViewLayoutManager.i(1);
                if (playerControlViewLayoutManager.B) {
                    playerControlView.post(playerControlViewLayoutManager.s);
                    playerControlViewLayoutManager.B = false;
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                PlayerControlViewLayoutManager.this.i(3);
            }
        });
        animatorSet.play(valueAnimatorOfFloat).with(d(viewFindViewById, 0.0f, dimension)).with(d(viewGroup, 0.0f, dimension));
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.f10905m = animatorSet2;
        animatorSet2.setDuration(250L);
        animatorSet2.addListener(new AnimatorListenerAdapter() { // from class: androidx.media3.ui.PlayerControlViewLayoutManager.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                PlayerControlViewLayoutManager playerControlViewLayoutManager = PlayerControlViewLayoutManager.this;
                playerControlViewLayoutManager.i(2);
                if (playerControlViewLayoutManager.B) {
                    playerControlView.post(playerControlViewLayoutManager.s);
                    playerControlViewLayoutManager.B = false;
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                PlayerControlViewLayoutManager.this.i(3);
            }
        });
        animatorSet2.play(d(viewFindViewById, dimension, dimension2)).with(d(viewGroup, dimension, dimension2));
        AnimatorSet animatorSet3 = new AnimatorSet();
        this.n = animatorSet3;
        animatorSet3.setDuration(250L);
        animatorSet3.addListener(new AnimatorListenerAdapter() { // from class: androidx.media3.ui.PlayerControlViewLayoutManager.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                PlayerControlViewLayoutManager playerControlViewLayoutManager = PlayerControlViewLayoutManager.this;
                playerControlViewLayoutManager.i(2);
                if (playerControlViewLayoutManager.B) {
                    playerControlView.post(playerControlViewLayoutManager.s);
                    playerControlViewLayoutManager.B = false;
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                PlayerControlViewLayoutManager.this.i(3);
            }
        });
        animatorSet3.play(valueAnimatorOfFloat).with(d(viewFindViewById, 0.0f, dimension2)).with(d(viewGroup, 0.0f, dimension2));
        AnimatorSet animatorSet4 = new AnimatorSet();
        this.o = animatorSet4;
        animatorSet4.setDuration(250L);
        animatorSet4.addListener(new AnimatorListenerAdapter() { // from class: androidx.media3.ui.PlayerControlViewLayoutManager.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                PlayerControlViewLayoutManager.this.i(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                PlayerControlViewLayoutManager.this.i(4);
            }
        });
        animatorSet4.play(valueAnimatorOfFloat2).with(d(viewFindViewById, dimension, 0.0f)).with(d(viewGroup, dimension, 0.0f));
        AnimatorSet animatorSet5 = new AnimatorSet();
        this.p = animatorSet5;
        animatorSet5.setDuration(250L);
        animatorSet5.addListener(new AnimatorListenerAdapter() { // from class: androidx.media3.ui.PlayerControlViewLayoutManager.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                PlayerControlViewLayoutManager.this.i(0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                PlayerControlViewLayoutManager.this.i(4);
            }
        });
        animatorSet5.play(valueAnimatorOfFloat2).with(d(viewFindViewById, dimension2, 0.0f)).with(d(viewGroup, dimension2, 0.0f));
        ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.q = valueAnimatorOfFloat3;
        valueAnimatorOfFloat3.setDuration(250L);
        valueAnimatorOfFloat3.addUpdateListener(new g(this, 1));
        valueAnimatorOfFloat3.addListener(new AnimatorListenerAdapter() { // from class: androidx.media3.ui.PlayerControlViewLayoutManager.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                ViewGroup viewGroup2 = PlayerControlViewLayoutManager.this.f10898f;
                if (viewGroup2 != null) {
                    viewGroup2.setVisibility(4);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                PlayerControlViewLayoutManager playerControlViewLayoutManager = PlayerControlViewLayoutManager.this;
                ViewGroup viewGroup2 = playerControlViewLayoutManager.f10900h;
                if (viewGroup2 != null) {
                    viewGroup2.setVisibility(0);
                    playerControlViewLayoutManager.f10900h.setTranslationX(r0.getWidth());
                    ViewGroup viewGroup3 = playerControlViewLayoutManager.f10900h;
                    viewGroup3.scrollTo(viewGroup3.getWidth(), 0);
                }
            }
        });
        ValueAnimator valueAnimatorOfFloat4 = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.r = valueAnimatorOfFloat4;
        valueAnimatorOfFloat4.setDuration(250L);
        valueAnimatorOfFloat4.addUpdateListener(new g(this, 2));
        valueAnimatorOfFloat4.addListener(new AnimatorListenerAdapter() { // from class: androidx.media3.ui.PlayerControlViewLayoutManager.9
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                ViewGroup viewGroup2 = PlayerControlViewLayoutManager.this.f10900h;
                if (viewGroup2 != null) {
                    viewGroup2.setVisibility(4);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                ViewGroup viewGroup2 = PlayerControlViewLayoutManager.this.f10898f;
                if (viewGroup2 != null) {
                    viewGroup2.setVisibility(0);
                }
            }
        });
    }

    public static int c(View view) {
        if (view == null) {
            return 0;
        }
        int width = view.getWidth();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return width;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + width;
    }

    public static ObjectAnimator d(View view, float f2, float f3) {
        return ObjectAnimator.ofFloat(view, "translationY", f2, f3);
    }

    public static boolean j(View view) {
        int id = view.getId();
        return id == R.id.exo_bottom_bar || id == R.id.exo_prev || id == R.id.exo_next || id == R.id.exo_rew || id == R.id.exo_rew_with_amount || id == R.id.exo_ffwd || id == R.id.exo_ffwd_with_amount;
    }

    public final void a(float f2) {
        ViewGroup viewGroup = this.f10900h;
        if (viewGroup != null) {
            viewGroup.setTranslationX((int) ((1.0f - f2) * viewGroup.getWidth()));
        }
        ViewGroup viewGroup2 = this.f10901i;
        if (viewGroup2 != null) {
            viewGroup2.setAlpha(1.0f - f2);
        }
        ViewGroup viewGroup3 = this.f10898f;
        if (viewGroup3 != null) {
            viewGroup3.setAlpha(1.0f - f2);
        }
    }

    public final boolean b(View view) {
        return view != null && this.y.contains(view);
    }

    public final void e(long j2, Runnable runnable) {
        if (j2 >= 0) {
            this.f10893a.postDelayed(runnable, j2);
        }
    }

    public final void f() {
        f fVar = this.w;
        PlayerControlView playerControlView = this.f10893a;
        playerControlView.removeCallbacks(fVar);
        playerControlView.removeCallbacks(this.t);
        playerControlView.removeCallbacks(this.v);
        playerControlView.removeCallbacks(this.u);
    }

    public final void g() {
        if (this.z == 3) {
            return;
        }
        f();
        int showTimeoutMs = this.f10893a.getShowTimeoutMs();
        if (showTimeoutMs > 0) {
            if (!this.C) {
                e(showTimeoutMs, this.w);
            } else if (this.z == 1) {
                e(2000L, this.u);
            } else {
                e(showTimeoutMs, this.v);
            }
        }
    }

    public final void h(View view, boolean z) {
        if (view == null) {
            return;
        }
        ArrayList arrayList = this.y;
        if (!z) {
            view.setVisibility(8);
            arrayList.remove(view);
            return;
        }
        if (this.A && j(view)) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
        }
        arrayList.add(view);
    }

    public final void i(int i2) {
        int i3 = this.z;
        this.z = i2;
        PlayerControlView playerControlView = this.f10893a;
        if (i2 == 2) {
            playerControlView.setVisibility(8);
        } else if (i3 == 2) {
            playerControlView.setVisibility(0);
        }
        if (i3 != i2) {
            Iterator it = playerControlView.f10867d.iterator();
            while (it.hasNext()) {
                ((PlayerControlView.VisibilityListener) it.next()).h(playerControlView.getVisibility());
            }
        }
    }

    public final void k() {
        if (!this.C) {
            i(0);
            g();
            return;
        }
        int i2 = this.z;
        if (i2 == 1) {
            this.o.start();
        } else if (i2 == 2) {
            this.p.start();
        } else if (i2 == 3) {
            this.B = true;
        } else if (i2 == 4) {
            return;
        }
        g();
    }
}
