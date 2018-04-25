package tw.edu.ntut.csie.app03_102590007;

import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity {

    private Button btnAniHeart;
    private ImageView imgHeart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAniHeart = findViewById(R.id.btnAniHeart);
        //imgAndroid = findViewById(R.id.imgAndroid);
        imgHeart = findViewById(R.id.imgHeart);

        btnAniHeart.setOnClickListener(btnAniHeartOnclick);
    }

    // Use static Handler to avoid memory leaks.
    private class StaticHandler extends Handler {
        private final WeakReference<MainActivity> mActivity;

        public StaticHandler(MainActivity activity) {
            mActivity = new WeakReference<MainActivity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            MainActivity activity = mActivity.get();
            //if (activity == null) return;

            int iRand = (int)(Math.random()*5 + 1);
        }
    }

    public final StaticHandler mHandler = new StaticHandler((MainActivity)this);

    private View.OnClickListener btnAniHeartOnclick = new View.OnClickListener() {
        public void onClick(View v) {
            // 從程式資源中取得動畫檔，設定給ImageView物件，然後開始播放。
            Resources res = getResources();
            AnimationDrawable animDraw =
                    (AnimationDrawable) res.getDrawable(R.drawable.ani_heart);
            imgHeart.setImageDrawable(animDraw);
            animDraw.start();
        }
    };

}
