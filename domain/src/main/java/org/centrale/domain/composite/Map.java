package org.centrale.domain.composite;

import lombok.Getter;
import org.centrale.domain.visitor.Visitor;

@Getter
public class Map implements Component {
    private final String label;

    public Map(String label) {
        this.label = label;
    }

    @Override
    public String render() {
        return "Render Map: " + label;
    }

    public void accept(Visitor visitor) {
        visitor.visitMap(this);
    }
}
