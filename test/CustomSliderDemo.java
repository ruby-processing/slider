import monkstone.slider.CustomHorizontalSlider;
// import monkstone.slider.VerticalSliderBar;
import processing.core.*;

public class CustomSliderDemo extends PApplet {
    final int SPACING = 15;
    final int LEFT_SPC = SPACING * 3;
    final int RIGHT_SPC = SPACING * 6;
    CustomHorizontalSlider color1;
    CustomHorizontalSlider color2;
    CustomHorizontalSlider color3;
    
//    VerticalSliderBar color1;
//    VerticalSliderBar color2;
//    VerticalSliderBar color3;

    int r, gs, b;

    boolean back = true;


    @Override
    public void setup() {

//        color1 = new VerticalSliderBar(this, 100, 77, 200, 0.0f, 255.0f, "Slider 1");
//        color2 = new VerticalSliderBar(this, 256, 77, 200, 0.0f, 255.0f, "Slider 2");
//        color3 = new VerticalSliderBar(this, 410, 77, 200, 0.0f, 255.0f, "Slider 3");
        
        color1 = new CustomHorizontalSlider(this, LEFT_SPC, height - 5 * SPACING, width - RIGHT_SPC, 0.0f, 255.0f, "Slider 1");
        color2 = new CustomHorizontalSlider(this, LEFT_SPC, height - 3 * SPACING, width - RIGHT_SPC, 0.0f, 255.0f, "Slider 2");
        color3 = new CustomHorizontalSlider(this, LEFT_SPC, height - SPACING, width - RIGHT_SPC, 0.0f, 255.0f, "Slider 3");



     //   color1.barWidth(100);
     //   color1.widgetColors(0xffFF0000, 0xff930303);
        color1.setValue(50);


     //   color2.barWidth(100);
     //   color2.widgetColors(0xff5BCE4D, 0xff1CFF00);
        color2.setValue(180);


     //  color3.barWidth(100);
        color3.widgetColors(0xff4439C9, 0xff9990FF);
        color3.setValue(134);
    }


    @Override
    public void draw() {
        background(b, r, gs);
        fill(r, gs, b);
        ellipse(300, 200, 300, 300);
        r = (int) color1.readValue();
        gs = (int) color2.readValue();
        b = (int) color3.readValue();       
    }

    @Override
    public void settings() {
        size(600, 400);
        smooth();
    }

    static public void main(String[] passedArgs) {
        String[] appletArgs = new String[]{"SliderBarDemo"};
        if (passedArgs != null) {
            PApplet.main(concat(appletArgs, passedArgs));
        } else {
            PApplet.main(appletArgs);
        }
    }
}
