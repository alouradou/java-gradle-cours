package org.centrale.domain.composite;

public class Map implements Component {
    private final String label;

    public Map(String label) {
        this.label = label;
    }

    @Override
    public String render() {
        return "Render Map: " + label;
    }
}
