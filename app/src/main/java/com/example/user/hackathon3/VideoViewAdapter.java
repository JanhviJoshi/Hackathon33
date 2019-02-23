package com.example.user.hackathon3;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
;
import java.util.List;

public class VideoViewAdapter extends RecyclerView.Adapter<VideoViewAdapter.VideoViewAdapterViewHolder> {

    //creating a reference of he interface Callback
    Callback callback;
    public VideoViewAdapter(Callback callback){
        this.callback= callback;
    }

    private List<String> mVideo;
    @NonNull
    @Override
    public VideoViewAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item,viewGroup,false);
        return new VideoViewAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewAdapterViewHolder videoViewAdapterViewHolder, int i) {
        videoViewAdapterViewHolder.bindData(mVideo.get(i));
        videoViewAdapterViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //when an item in recyclerview is clicked, this function is called.
                //the "callback" holds the reference of the mainactivity that was sent to it earlier. (check constructor)
                //thus, the function in main activity is being called here.
                //itna sab kyu kia? because adapter se we cant use intent becaue adapter and mainactivity ke beech ki interface nai hai
                callback.friendCallback();
            }
        });
    }

    @Override
    public int getItemCount() {
        if(mVideo==null)
        {
            return 0;
        }
        return mVideo.size();
    }

    void setData(List<String> mVideo) {
        this.mVideo = mVideo;
        notifyDataSetChanged();
    }

    public class VideoViewAdapterViewHolder extends RecyclerView.ViewHolder{
        public final TextView LocInfo;

        public VideoViewAdapterViewHolder(View view){
            super(view);
            LocInfo= (TextView)view.findViewById(R.id.textView);
            }

        void bindData(String data) {
            LocInfo.setText(data);
        }    }

    public interface Callback{
        //this function has been defined in mainactivity
        public void friendCallback();
    }
}
