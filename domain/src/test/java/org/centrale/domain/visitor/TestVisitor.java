package org.centrale.domain.visitor;

import org.centrale.domain.composite.*;
import org.centrale.domain.composite.Form;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TestVisitor {
    @Test
    public void testVisitor() {
        RenderVisitor visitor = new RenderVisitor();
        Button button = new Button("Button");
        Map map = new Map("Map");

        button.accept(visitor);
        map.accept(visitor);

        String expectedRender = "<div>Button</div>" +
                                "<div>Map</div>";

        Assertions.assertEquals(expectedRender, visitor.getResult());
    }

}
