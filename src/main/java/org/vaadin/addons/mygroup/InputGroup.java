package org.vaadin.addons.mygroup;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexLayout;

@CssImport("./input-group.css")
@CssImport("./input-field.css")
public class InputGroup extends FlexLayout {

	public static final String INPUT_GROUP = "input-group";
	public static final String FLEX_ROW = "flex-row";
	public static final String FLEX_COLUMN = "flex-column";

	public InputGroup(Component... components) {
		addClassName(INPUT_GROUP);
		setFlexDirection(FlexLayout.FlexDirection.ROW);
		add(components);
	}

	@Override
	public void setFlexDirection(FlexLayout.FlexDirection flexDirection) {
		super.setFlexDirection(flexDirection);
		if (flexDirection.equals(FlexLayout.FlexDirection.COLUMN)) {
			setAlignItems(FlexComponent.Alignment.STRETCH);
			removeClassName(FLEX_ROW);
			addClassName(FLEX_COLUMN);
		} else {
			setAlignItems(FlexComponent.Alignment.BASELINE);
			addClassName(FLEX_ROW);
		}
	}
}
