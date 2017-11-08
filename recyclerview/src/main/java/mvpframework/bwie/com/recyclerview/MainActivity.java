package mvpframework.bwie.com.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.liaoinstan.springview.container.DefaultFooter;
import com.liaoinstan.springview.container.DefaultHeader;
import com.liaoinstan.springview.widget.SpringView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<String> list = new ArrayList<>();
    private SpringView springView;
    private LinearLayoutManager linearLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        list.add("http://f10.baidu.com/it/u=2881303562,336932824&fm=72");
        list.add("http://f11.baidu.com/it/u=681755471,2018070071&fm=72");
        list.add("http://f10.baidu.com/it/u=960650584,863938083&fm=72");
        list.add("http://img0.imgtn.bdimg.com/it/u=783060973,4278100629&fm=27&gp=0.jpg");
        list.add("http://img1.imgtn.bdimg.com/it/u=3743124979,3234956668&fm=27&gp=0.jpg");
        list.add("http://img4.imgtn.bdimg.com/it/u=3468613159,957707785&fm=27&gp=0.jpg");
        list.add("http://img3.imgtn.bdimg.com/it/u=2971205354,485034289&fm=27&gp=0.jpg");


        list.add("http://f10.baidu.com/it/u=2881303562,336932824&fm=72");
        list.add("http://f11.baidu.com/it/u=681755471,2018070071&fm=72");
        list.add("http://f10.baidu.com/it/u=960650584,863938083&fm=72");
        list.add("http://img0.imgtn.bdimg.com/it/u=783060973,4278100629&fm=27&gp=0.jpg");
        list.add("http://img1.imgtn.bdimg.com/it/u=3743124979,3234956668&fm=27&gp=0.jpg");
        list.add("http://img4.imgtn.bdimg.com/it/u=3468613159,957707785&fm=27&gp=0.jpg");
        list.add("http://img3.imgtn.bdimg.com/it/u=2971205354,485034289&fm=27&gp=0.jpg");


        MultiAdapter adapter =  new MultiAdapter(this,list) ;

        linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
//
//        adapter.setIListener(new RecyclerViewAdapter.Listener() {
//            @Override
//            public void onClick(View view, int position) {
//                Toast.makeText(MainActivity.this, ""+position, Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void longClick(View view, int position) {
//
//            }
//        });

        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);


//                linearLayoutManager.findFirstVisibleItemPosition()


            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });

//        recyclerView.setOnI



//        recyclerView.addItemDecoration(new HorizontalDividerItemDecoration.Builder(this)
//        .color(Color.RED).build());


        springView = (SpringView) findViewById(R.id.springview);

        springView.setHeader(new DefaultHeader(this));
        springView.setFooter(new DefaultFooter(this));


        springView.setListener(new SpringView.OnFreshListener() {
            @Override
            public void onRefresh() {
                //下啦

                springView.onFinishFreshAndLoad();
            }

            @Override
            public void onLoadmore() {
// 上啦
                springView.onFinishFreshAndLoad();

            }
        });





//        adapter.notifyDataSetChanged();



    }
}
