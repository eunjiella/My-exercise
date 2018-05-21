package org.ellalee.ex6_1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyView vw = new MyView(this);
        setContentView(vw);
    }
    protected class MyView extends View {
        public MyView(Context context){
            super(context);
        }


        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Paint pnt = new Paint();
            pnt.setColor(Color.BLUE);
        //    canvas.drawColor(Color.RED);
            canvas.drawCircle(500,500,50,pnt);
            canvas.drawRect(560,560,660,660,pnt);

            pnt.setColor(Color.RED);
            pnt.setStrokeWidth(8);

            //채우기
            pnt.setStyle(Paint.Style.FILL);
            canvas.drawCircle(50,50,40,pnt);

            //외곽선 그리기
            pnt.setStyle(Paint.Style.STROKE);
            canvas.drawCircle(150,50,40,pnt);

            //외곽선 및 채우기
            pnt.setStyle(Paint.Style.FILL_AND_STROKE);
            canvas.drawCircle(250,50,40,pnt);

            //파란색으로 채우고 빨간색으로 외곽선
            pnt.setColor(Color.BLUE);
            pnt.setStyle(Paint.Style.FILL);
            canvas.drawCircle(50,150,40,pnt);
            pnt.setColor(Color.RED);
            pnt.setStyle(Paint.Style.STROKE);
            canvas.drawCircle(50,150,40,pnt);

            //빨간색 외곽선 그리고 파란색 채우기
            pnt.setColor(Color.RED);
            pnt.setStyle(Paint.Style.STROKE);
            canvas.drawCircle(150,150,40,pnt);
            pnt.setColor(Color.BLUE);
            pnt.setStyle(Paint.Style.FILL);
            canvas.drawCircle(150,150,40,pnt);

            //캡모양 테스트
            pnt.setColor(Color.BLUE);
            pnt.setStrokeWidth(16);
            canvas.drawLine(50,330,240,330,pnt);
            pnt.setStrokeCap(Paint.Cap.ROUND);
            canvas.drawLine(50,360,240,360,pnt);
            pnt.setStrokeCap(Paint.Cap.SQUARE);
            canvas.drawLine(50,390,240,390,pnt);

            //조인모양테스트
            pnt.setColor(Color.BLACK);
            pnt.setStrokeWidth(20);
            pnt.setStyle(Paint.Style.STROKE);
            pnt.setStrokeJoin(Paint.Join.MITER);
            canvas.drawRect(50,450,90,500,pnt);
            pnt.setStrokeJoin(Paint.Join.BEVEL);
            canvas.drawRect(120,450,160,500,pnt);
            pnt.setStrokeJoin(Paint.Join.ROUND);
            canvas.drawRect(190,450,230,500,pnt);

            Path path = new Path();
            //  canvas.drawColor(Color.WHITE);

            pnt.setStrokeWidth(5);
            pnt.setColor(Color.RED);
            pnt.setStyle(Paint.Style.STROKE);

            //원 사각형을 패스로 정의 후 출력
            path.addRect(100,550,150,640,Path.Direction.CW);
            path.addCircle(50,600,40,Path.Direction.CW);
            canvas.drawPath(path,pnt);

            //패스로 정의 후 출력
            path.reset();
            path.moveTo(10,660);
            path.lineTo(50,700);
            path.lineTo(400,560);
            pnt.setStrokeWidth(3);
            pnt.setColor(Color.BLUE);
            canvas.drawPath(path,pnt);

            //패스 위에 텍스트출력
            pnt.setTextSize(20);
            pnt.setStyle(Paint.Style.FILL);
            canvas.drawTextOnPath("Text on path",path,0,0,pnt);

        }
    }
}
