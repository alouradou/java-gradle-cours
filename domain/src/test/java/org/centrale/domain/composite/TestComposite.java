package org.centrale.domain.composite;

import org.centrale.domain.Form;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.ByteArrayOutputStream;

public class TestComposite {

        @Test
        public void testComposite() {
            // Création de composants simples
            Button button1 = new Button("Submit");
            Map map = new Map("<Map />");
            Form form = new Form(button1);

            // Création d'une chaîne de caractères attendue pour le rendu
            String expectedRender = "Render Button: Submit\n" +
                                    "Render Map: <Map />";

            String result = form.render() + "\n" + map.render();

            Assertions.assertEquals(expectedRender, result);
        }
}
