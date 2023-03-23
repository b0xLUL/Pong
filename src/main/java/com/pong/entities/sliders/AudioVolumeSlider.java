package com.pong.entities.sliders;

import com.github.hanyaeger.api.Coordinate2D;
import com.pong.entities.sliders.parts.SliderBar;
import com.pong.entities.sliders.parts.SliderKnob;

public class AudioVolumeSlider {

    private final SliderBar bar;
    private final SliderKnob knob;

    public AudioVolumeSlider(Coordinate2D initialBarLocation, Coordinate2D initialKnobLocation) {
        bar = new SliderBar(initialBarLocation);
        knob = new SliderKnob(initialKnobLocation);
    }

}
