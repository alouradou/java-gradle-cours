package org.centrale.domain.visitor;

import org.centrale.domain.composite.Form;
import org.centrale.domain.composite.Button;
import org.centrale.domain.composite.Map;

public class RenderVisitor implements Visitor {
    private final StringBuilder result = new StringBuilder();

    public String getResult() {
        return result.toString();
    }

    @Override
    public void visitButton(Button button) {
        result.append("<div>").append(button.getLabel()).append("</div>");
    }

    @Override
    public void visitMap(Map map) {
        result.append("<div>").append(map.getLabel()).append("</div>");
    }

    @Override
    public void visitForm(Form form) {
        result.append("<div>").append(form.render()).append("</div>");
    }

}
