package moh.theamazingappco.bricks;

import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Logger;

/**
 * Created by hp on 21-04-2020.
 */

public class UserTextAdapter extends RecyclerView.Adapter<UserTextAdapter.MyViewHolder> {
    private ArrayList<moh.theamazingappco.bricks.DataModel> dataSet;
    int i = 0;

    String[] mycolors = {"#b2ebf2", "#80deea", "#d1c4e9", "#b39ddb", "#f8bbd0", "#f48fb1", "#ffe082" ,"#ffd54f", "#bcaaa4", "#a1887f", "#ffab91", "#ff8a65","#c8e6c9","#a5d6a7"};

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewInput;
        TextView greenBrick;
        TextView redBrick;
        ImageView rimage,gimage;
        CardView cv,cv1,cv2;
        View myview;


        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewInput = (TextView) itemView.findViewById(R.id.UserText);
            this.greenBrick = (TextView) itemView.findViewById(R.id.GreenBrickCount);
            this.redBrick = (TextView) itemView.findViewById(R.id.RedBrickCount);
            this.rimage = (ImageView) itemView.findViewById(R.id.rimage);
            this.gimage = (ImageView) itemView.findViewById(R.id.gimage);
            this.cv = (CardView) itemView.findViewById(R.id.card_view);
            this.cv1 = (CardView) itemView.findViewById(R.id.card_view2);
            this.cv2 = (CardView) itemView.findViewById(R.id.card_view3);
            //this.myview = (View) itemView.findViewById(R.id.myview);
        }


    }

    public UserTextAdapter(ArrayList<moh.theamazingappco.bricks.DataModel> data) {
        this.dataSet = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cards_layout, parent, false);

        view.setBackgroundColor(Color.parseColor(returnColor()));

//        view.setOnClickListener(MainActivity.myOnClickListener);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        TextView textViewName = holder.textViewInput;
        TextView txtGreen = holder.greenBrick;
        TextView txtRed = holder.redBrick;
        ImageView imageg = holder.gimage;
        ImageView imager = holder.rimage;
        //View lineview = holder.myview;
        CardView mcv = holder.cv;
        CardView mcv1 = holder.cv1;
        CardView mcv2 = holder.cv2;


        String SplitString[];
        String mydata = dataSet.get(listPosition).getInput();


        SplitString = mydata.split(",");

        textViewName.setText(SplitString[0].replace("", " ").trim());
        txtRed.setText(SplitString[1]);
        txtGreen.setText(SplitString[2]);



//            RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT);
//            mcv.setLayoutParams(lp);
            //lineview.setVisibility(View.INVISIBLE);


        //textViewName.setText(dataSet.get(listPosition).getInput());

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public String returnColor(){
        String colorcode;
        Random random = new Random();
        colorcode = mycolors[random.nextInt(11)];

        return colorcode;
    }
}
