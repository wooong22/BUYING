package com.mybuying.buying;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;

public class TabView extends FrameLayout {
    public TabView(Context context) {
        super(context);
        init();
    }

    TextView titleView;
    private void init() {
        inflate(getContext(), R.layout.tab_view, this);
        titleView = (TextView)findViewById(R.id.text_title);
    }

    public void setTitle(String title) {
        titleView.setText(title);
    }


}
