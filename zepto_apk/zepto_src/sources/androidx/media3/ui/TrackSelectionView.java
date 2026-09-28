package androidx.media3.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.Nullable;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.TrackSelectionOverride;
import androidx.media3.common.Tracks;
import androidx.media3.common.util.UnstableApi;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@UnstableApi
/* loaded from: classes3.dex */
public class TrackSelectionView extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public final int f10969a;

    /* renamed from: b, reason: collision with root package name */
    public final LayoutInflater f10970b;

    /* renamed from: c, reason: collision with root package name */
    public final CheckedTextView f10971c;

    /* renamed from: d, reason: collision with root package name */
    public final CheckedTextView f10972d;

    /* renamed from: e, reason: collision with root package name */
    public final ComponentListener f10973e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f10974f;

    /* renamed from: g, reason: collision with root package name */
    public final HashMap f10975g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f10976h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f10977i;

    /* renamed from: j, reason: collision with root package name */
    public TrackNameProvider f10978j;

    /* renamed from: k, reason: collision with root package name */
    public CheckedTextView[][] f10979k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f10980l;

    public class ComponentListener implements View.OnClickListener {
        public ComponentListener() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            TrackSelectionView trackSelectionView = TrackSelectionView.this;
            HashMap map = trackSelectionView.f10975g;
            boolean z = true;
            if (view == trackSelectionView.f10971c) {
                trackSelectionView.f10980l = true;
                map.clear();
            } else if (view == trackSelectionView.f10972d) {
                trackSelectionView.f10980l = false;
                map.clear();
            } else {
                trackSelectionView.f10980l = false;
                Object tag = view.getTag();
                tag.getClass();
                TrackInfo trackInfo = (TrackInfo) tag;
                Tracks.Group group = trackInfo.f10982a;
                TrackGroup trackGroup = group.f5554b;
                TrackSelectionOverride trackSelectionOverride = (TrackSelectionOverride) map.get(trackGroup);
                int i2 = trackInfo.f10983b;
                if (trackSelectionOverride == null) {
                    if (!trackSelectionView.f10977i && map.size() > 0) {
                        map.clear();
                    }
                    map.put(trackGroup, new TrackSelectionOverride(trackGroup, ImmutableList.t(Integer.valueOf(i2))));
                } else {
                    ArrayList arrayList = new ArrayList(trackSelectionOverride.f5509b);
                    boolean zIsChecked = ((CheckedTextView) view).isChecked();
                    boolean z2 = trackSelectionView.f10976h && group.f5555c;
                    if (!z2 && (!trackSelectionView.f10977i || trackSelectionView.f10974f.size() <= 1)) {
                        z = false;
                    }
                    if (zIsChecked && z) {
                        arrayList.remove(Integer.valueOf(i2));
                        if (arrayList.isEmpty()) {
                            map.remove(trackGroup);
                        } else {
                            map.put(trackGroup, new TrackSelectionOverride(trackGroup, arrayList));
                        }
                    } else if (!zIsChecked) {
                        if (z2) {
                            arrayList.add(Integer.valueOf(i2));
                            map.put(trackGroup, new TrackSelectionOverride(trackGroup, arrayList));
                        } else {
                            map.put(trackGroup, new TrackSelectionOverride(trackGroup, ImmutableList.t(Integer.valueOf(i2))));
                        }
                    }
                }
            }
            trackSelectionView.a();
        }
    }

    public static final class TrackInfo {

        /* renamed from: a, reason: collision with root package name */
        public final Tracks.Group f10982a;

        /* renamed from: b, reason: collision with root package name */
        public final int f10983b;

        public TrackInfo(Tracks.Group group, int i2) {
            this.f10982a = group;
            this.f10983b = i2;
        }
    }

    public interface TrackSelectionListener {
    }

    public TrackSelectionView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void a() {
        this.f10971c.setChecked(this.f10980l);
        boolean z = this.f10980l;
        HashMap map = this.f10975g;
        this.f10972d.setChecked(!z && map.size() == 0);
        for (int i2 = 0; i2 < this.f10979k.length; i2++) {
            TrackSelectionOverride trackSelectionOverride = (TrackSelectionOverride) map.get(((Tracks.Group) this.f10974f.get(i2)).f5554b);
            int i3 = 0;
            while (true) {
                CheckedTextView[] checkedTextViewArr = this.f10979k[i2];
                if (i3 < checkedTextViewArr.length) {
                    if (trackSelectionOverride != null) {
                        Object tag = checkedTextViewArr[i3].getTag();
                        tag.getClass();
                        this.f10979k[i2][i3].setChecked(trackSelectionOverride.f5509b.contains(Integer.valueOf(((TrackInfo) tag).f10983b)));
                    } else {
                        checkedTextViewArr[i3].setChecked(false);
                    }
                    i3++;
                }
            }
        }
    }

    public final void b() {
        for (int childCount = getChildCount() - 1; childCount >= 3; childCount--) {
            removeViewAt(childCount);
        }
        ArrayList arrayList = this.f10974f;
        boolean zIsEmpty = arrayList.isEmpty();
        CheckedTextView checkedTextView = this.f10972d;
        CheckedTextView checkedTextView2 = this.f10971c;
        if (zIsEmpty) {
            checkedTextView2.setEnabled(false);
            checkedTextView.setEnabled(false);
            return;
        }
        checkedTextView2.setEnabled(true);
        checkedTextView.setEnabled(true);
        this.f10979k = new CheckedTextView[arrayList.size()][];
        boolean z = this.f10977i && arrayList.size() > 1;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            Tracks.Group group = (Tracks.Group) arrayList.get(i2);
            boolean z2 = this.f10976h && group.f5555c;
            CheckedTextView[][] checkedTextViewArr = this.f10979k;
            int i3 = group.f5553a;
            checkedTextViewArr[i2] = new CheckedTextView[i3];
            TrackInfo[] trackInfoArr = new TrackInfo[i3];
            for (int i4 = 0; i4 < group.f5553a; i4++) {
                trackInfoArr[i4] = new TrackInfo(group, i4);
            }
            for (int i5 = 0; i5 < i3; i5++) {
                LayoutInflater layoutInflater = this.f10970b;
                if (i5 == 0) {
                    addView(layoutInflater.inflate(R.layout.exo_list_divider, (ViewGroup) this, false));
                }
                CheckedTextView checkedTextView3 = (CheckedTextView) layoutInflater.inflate((z2 || z) ? android.R.layout.simple_list_item_multiple_choice : android.R.layout.simple_list_item_single_choice, (ViewGroup) this, false);
                checkedTextView3.setBackgroundResource(this.f10969a);
                TrackNameProvider trackNameProvider = this.f10978j;
                TrackInfo trackInfo = trackInfoArr[i5];
                checkedTextView3.setText(trackNameProvider.a(trackInfo.f10982a.a(trackInfo.f10983b)));
                checkedTextView3.setTag(trackInfoArr[i5]);
                if (group.b(i5)) {
                    checkedTextView3.setFocusable(true);
                    checkedTextView3.setOnClickListener(this.f10973e);
                } else {
                    checkedTextView3.setFocusable(false);
                    checkedTextView3.setEnabled(false);
                }
                this.f10979k[i2][i5] = checkedTextView3;
                addView(checkedTextView3);
            }
        }
        a();
    }

    public boolean getIsDisabled() {
        return this.f10980l;
    }

    public Map<TrackGroup, TrackSelectionOverride> getOverrides() {
        return this.f10975g;
    }

    public void setAllowAdaptiveSelections(boolean z) {
        if (this.f10976h != z) {
            this.f10976h = z;
            b();
        }
    }

    public void setAllowMultipleOverrides(boolean z) {
        if (this.f10977i != z) {
            this.f10977i = z;
            if (!z) {
                HashMap map = this.f10975g;
                if (map.size() > 1) {
                    ArrayList arrayList = this.f10974f;
                    HashMap map2 = new HashMap();
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        TrackSelectionOverride trackSelectionOverride = (TrackSelectionOverride) map.get(((Tracks.Group) arrayList.get(i2)).f5554b);
                        if (trackSelectionOverride != null && map2.isEmpty()) {
                            map2.put(trackSelectionOverride.f5508a, trackSelectionOverride);
                        }
                    }
                    map.clear();
                    map.putAll(map2);
                }
            }
            b();
        }
    }

    public void setShowDisableOption(boolean z) {
        this.f10971c.setVisibility(z ? 0 : 8);
    }

    public void setTrackNameProvider(TrackNameProvider trackNameProvider) {
        trackNameProvider.getClass();
        this.f10978j = trackNameProvider;
        b();
    }

    public TrackSelectionView(Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2) {
        super(context, attributeSet, i2);
        setOrientation(1);
        setSaveFromParentEnabled(false);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{android.R.attr.selectableItemBackground});
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        this.f10969a = resourceId;
        typedArrayObtainStyledAttributes.recycle();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        this.f10970b = layoutInflaterFrom;
        ComponentListener componentListener = new ComponentListener();
        this.f10973e = componentListener;
        this.f10978j = new DefaultTrackNameProvider(getResources());
        this.f10974f = new ArrayList();
        this.f10975g = new HashMap();
        CheckedTextView checkedTextView = (CheckedTextView) layoutInflaterFrom.inflate(android.R.layout.simple_list_item_single_choice, (ViewGroup) this, false);
        this.f10971c = checkedTextView;
        checkedTextView.setBackgroundResource(resourceId);
        checkedTextView.setText(R.string.exo_track_selection_none);
        checkedTextView.setEnabled(false);
        checkedTextView.setFocusable(true);
        checkedTextView.setOnClickListener(componentListener);
        checkedTextView.setVisibility(8);
        addView(checkedTextView);
        addView(layoutInflaterFrom.inflate(R.layout.exo_list_divider, (ViewGroup) this, false));
        CheckedTextView checkedTextView2 = (CheckedTextView) layoutInflaterFrom.inflate(android.R.layout.simple_list_item_single_choice, (ViewGroup) this, false);
        this.f10972d = checkedTextView2;
        checkedTextView2.setBackgroundResource(resourceId);
        checkedTextView2.setText(R.string.exo_track_selection_auto);
        checkedTextView2.setEnabled(false);
        checkedTextView2.setFocusable(true);
        checkedTextView2.setOnClickListener(componentListener);
        addView(checkedTextView2);
    }
}
