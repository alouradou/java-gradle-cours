package org.centrale.domain.composite;

public class Button implements Component {
    private final String label;

    public Button(String label) {
        this.label = label;
    }

    @Override
    public String render() {
        return "Render Button: " + label;
    }
}
