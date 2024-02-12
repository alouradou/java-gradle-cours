package org.centrale.domain.visitor;

import org.centrale.domain.composite.*;
import org.centrale.domain.composite.Form;

public interface Visitor {
    void visitButton(Button button);
    void visitMap(Map map);
    void visitForm(Form form);
}
