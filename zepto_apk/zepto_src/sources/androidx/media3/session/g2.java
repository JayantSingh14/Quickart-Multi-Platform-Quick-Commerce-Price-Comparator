package androidx.media3.session;

/* loaded from: classes3.dex */
public final /* synthetic */ class g2 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10376a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f10377b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10378c;

    public /* synthetic */ g2(int i2, int i3, Object obj) {
        this.f10376a = i3;
        this.f10377b = obj;
        this.f10378c = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f10376a) {
            case 0:
                PlayerWrapper playerWrapper = PlayerWrapper.this;
                if (playerWrapper.D1(25) || playerWrapper.D1(33)) {
                    boolean zD1 = playerWrapper.D1(33);
                    int i2 = this.f10378c;
                    if (!zD1) {
                        playerWrapper.u1(i2);
                        break;
                    } else {
                        playerWrapper.Z0(i2, 1);
                        break;
                    }
                }
                break;
            case 1:
                PlayerWrapper playerWrapper2 = PlayerWrapper.this;
                if (playerWrapper2.D1(26) || playerWrapper2.D1(34)) {
                    int i3 = this.f10378c;
                    if (i3 == -100) {
                        if (!playerWrapper2.D1(34)) {
                            playerWrapper2.C0(true);
                            break;
                        } else {
                            playerWrapper2.l0(1, true);
                            break;
                        }
                    } else if (i3 == -1) {
                        if (!playerWrapper2.D1(34)) {
                            playerWrapper2.m0();
                            break;
                        } else {
                            playerWrapper2.x0(1);
                            break;
                        }
                    } else if (i3 == 1) {
                        if (!playerWrapper2.D1(34)) {
                            playerWrapper2.G0();
                            break;
                        } else {
                            playerWrapper2.n0(1);
                            break;
                        }
                    } else if (i3 == 100) {
                        if (!playerWrapper2.D1(34)) {
                            playerWrapper2.C0(false);
                            break;
                        } else {
                            playerWrapper2.l0(1, false);
                            break;
                        }
                    } else if (i3 == 101) {
                        if (!playerWrapper2.D1(34)) {
                            playerWrapper2.C0(!playerWrapper2.s());
                            break;
                        } else {
                            playerWrapper2.l0(1, !playerWrapper2.s());
                            break;
                        }
                    } else {
                        android.support.v4.media.a.r(i3, "onAdjustVolume: Ignoring unknown direction: ", "VolumeProviderCompat");
                        break;
                    }
                }
                break;
            default:
                ((MediaControllerImplBase) this.f10377b).f9980k.remove(Integer.valueOf(this.f10378c));
                break;
        }
    }
}
