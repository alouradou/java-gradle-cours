package org.centrale.domain.composite;

import lombok.Getter;
import org.centrale.domain.visitor.Visitor;

@Getter
public class Button implements Component {
    private final String label;

    public Button(String label) {
        this.label = label;
    }

    @Override
    public String render() {
        return "Render Button: " + label;
    }

    public void accept(Visitor visitor) {
        visitor.visitButton(this);
    }
}
