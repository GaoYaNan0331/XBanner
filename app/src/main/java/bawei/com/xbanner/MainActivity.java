package bawei.com.xbanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.transformers.Transformer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<String> imagesUrl=new ArrayList<>();
    private XBanner xb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
        initData();
        xb.setData(imagesUrl,null);
        xb.setmAdapter(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, View view, int position) {
                Glide.with(MainActivity.this).load(imagesUrl.get(position)).into((ImageView) view);
            }
        });
        xb.setPageTransformer(Transformer.Default);
        xb.setPageChangeDuration(1000);
    }

    private void initData() {
        imagesUrl.add("http://img.17gexing.com/uploadfile/2017/02/2/20170224090557506.jpg");
        imagesUrl.add("http://img.17gexing.com/uploadfile/2017/02/2/20170224090558477.jpg");
        imagesUrl.add("http://img.17gexing.com/uploadfile/2016/08/2/20160812105538594.jpg");
    }

    private void initview() {
        xb = (XBanner) findViewById(R.id.xbanner);
    }
}
