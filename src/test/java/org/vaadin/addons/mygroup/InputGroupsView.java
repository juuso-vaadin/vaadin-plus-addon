package org.vaadin.addons.mygroup;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Input Groups")
@Route(value = "input-groups", layout = MainLayout.class)
public class InputGroupsView extends Main {

	public InputGroupsView() {
		add(new H2("Example: Input with Button"));
		TextField textField = new TextField("Search");
		Button button = new Button("Advanced", VaadinIcon.SEARCH.create());
		add(new InputGroup(textField, button));

		add(new H2("Example: Price"));
		PriceField priceField = new PriceField("Price");
		add(priceField);

		add(new H2("Example: Vertical Group"));
		add(createVerticalGroupExample());

		add(new H2("Example: Credit Card"));
		CreditCardField creditCardField = new CreditCardField("Credit Card");
		add(creditCardField);
	}

	private Component createInputWithButton() {
		TextField textField = new TextField("Search");
		Button button = new Button("Advanced", VaadinIcon.SEARCH.create());

		return new InputGroup(textField, button);
	}

	private Component createVerticalGroupExample() {
		DatePicker startDate = new DatePicker("Start Date");
		startDate.addThemeNames(InputTheme.HIDE_LABEL);

		DatePicker endDate = new DatePicker("End Date");
		endDate.addThemeNames(InputTheme.HIDE_LABEL);

		InputGroup inputGroup = new InputGroup(startDate, endDate);
		inputGroup.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
		return inputGroup;
	}

}
