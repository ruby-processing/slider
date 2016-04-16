
import monkstone.slider.SliderGroup;
import processing.core.*;

public class SimpleSliderDemo extends PApplet {

    SliderGroup sliders;

    int r, gs, b;

    boolean back = true;

    @Override
    public void setup() {
        sliders = new SliderGroup(this);
        sliders.vertical();
        sliders.addSlider(0.0f, 255.0f, 50.0f);
        sliders.addSlider(0.0f, 255.0f, 100.0f);
        sliders.addSlider(0.0f, 255.0f, 100.0f);
    }

    @Override
    public void draw() {
        background(b, r, gs);
        fill(r, gs, b);
        ellipse(300, 200, 300, 300);
        r = (int) sliders.readValue(2);
        gs = (int) sliders.readValue(1);
        b = (int) sliders.readValue(0);
    }

    @Override
    public void settings() {
        size(600, 400);
        smooth();
    }

    static public void main(String[] passedArgs) {
        String[] appletArgs = new String[]{"SimpleSliderDemo"};
        if (passedArgs != null) {
            PApplet.main(concat(appletArgs, passedArgs));
        } else {
            PApplet.main(appletArgs);
        }
    }
}
