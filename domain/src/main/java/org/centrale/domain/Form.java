package org.centrale.domain;

import org.centrale.domain.composite.Button;

public class Form extends Button {
    private final Button button;

    public Form(Button button) {
        super("Form");
        this.button = button;
    }

    public String render() {

        return button.render();
    }
}
