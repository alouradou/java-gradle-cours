package org.centrale.domain.composite;

import java.util.ArrayList;
import java.util.List;

// On va s'inspirer du développement Front-End pour créer un design patern Composite
// https://refactoring.guru/fr/design-patterns/composite
public class Vue implements Component {
    private final List<Component> components = new ArrayList<>();

    public void add(Component component) {
        components.add(component);
    }

    @Override
    public String render() {
        StringBuilder sb = new StringBuilder();
        for (Component component : components) {
            sb.append(component.render());
        }
        return sb.toString();
    }
}
