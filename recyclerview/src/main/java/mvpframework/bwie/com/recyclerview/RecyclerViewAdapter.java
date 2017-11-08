package mvpframework.bwie.com.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by muhanxi on 17/11/8.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ImageViewHolder> {

    private Context context;
    private List<String> list;
    private int itemWidth ;


    public RecyclerViewAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);

        int width = wm.getDefaultDisplay().getWidth();
        itemWidth = width / 3 ;

    }

    //创建ViewHolder
    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 创建一个View
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item, parent,false);
        return new ImageViewHolder(view);
    }

    // 绑定view 显示数据
    @Override
    public void onBindViewHolder(ImageViewHolder holder, final int position) {



        // 显示图片
//        Glide.with(context).load("https://car3.autoimg.cn/cardfs/product/g18/M12/51/43/1024x0_1_q87_autohomecar__wKgH2VjnqU-AHth4AAiGLIUNYJk190.jpg").into(holder.itemImageview);


        ViewGroup.LayoutParams params =  holder.itemImageview.getLayoutParams() ;

        int itemHeight = 300 ;

        itemHeight = new Random().nextInt(500);
        if(itemHeight < 300){
            itemHeight = 300 ;
        }

        params.width = itemWidth ;
        params.height = itemHeight ;

        holder.itemImageview.setLayoutParams(params);

//        holder.itemImageview.setImageResource(R.mipmap.ic_launcher);

//        ImageLoader.getInstance().displayImage(list.get(position),holder.itemImageview);


        Glide.with(context).load(list.get(position)).into(holder.itemImageview);

        holder.textView.setText(position+"");


        holder.itemImageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listener != null){
                    listener.onClick(view,position);
                }
            }
        });



        holder.itemImageview.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                listener.longClick(view,position);
                return false;
            }
        });

    }

    // 获取条目的个数
    @Override
    public int getItemCount() {
        return list.size();
    }


    static class ImageViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_imageview)
        ImageView itemImageview;

        @BindView(R.id.item_textview)
        TextView textView;
        public ImageViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

//            itemImageview = itemView.findViewById(R.id.item_imageview);

        }

    }


    private Listener listener ;
    public void setIListener(Listener listener){
        this.listener = listener;
    }

    public interface  Listener {
        public void onClick(View view, int position);
        public void longClick(View view, int position);
    }


}
