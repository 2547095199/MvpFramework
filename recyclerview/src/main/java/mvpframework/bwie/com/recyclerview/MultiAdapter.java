package mvpframework.bwie.com.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by CZ on 2017/11/8.
 */
public class MultiAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<String> list;

    public MultiAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == 0) {

            View view = LayoutInflater.from(context).inflate(R.layout.layout_fitem,parent, false);
            return new FViewHolder(view);

        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.layout_sitem, parent, false);

            return new SViewHolder(view);

        }


    }


    @Override
    public int getItemViewType(int position) {
        return position % 2 ;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {




        if(holder instanceof FViewHolder){

            FViewHolder fViewHolder = (FViewHolder)holder ;
            fViewHolder.itemStextview.setText(position+"");
            Glide.with(context).load(list.get(position)).into(fViewHolder.itemSimageview);

//            ImageLoader.getInstance().displayImage(list.get(position),fViewHolder.itemSimageview);


        } else {

            SViewHolder sViewHolder = (SViewHolder)holder ;
            Glide.with(context).load(list.get(position)).into(sViewHolder.itemSimageview);

//            ImageLoader.getInstance().displayImage(list.get(position),sViewHolder.itemSimageview);

        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    static class FViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.item_simageview)
        ImageView itemSimageview;
        @BindView(R.id.item_stextview)
        TextView itemStextview;

        FViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    class SViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.item_simageview)
        ImageView itemSimageview;

        SViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}


